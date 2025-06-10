package ibxm;

import java.io.IOException;
import java.io.InputStream;

public class Module {
   public String songName = "Blank";
   public int numChannels = 4;
   public int numInstruments = 1;
   public int numPatterns = 1;
   public int sequenceLength = 1;
   public int restartPos = 0;
   public int defaultGVol = 64;
   public int defaultSpeed = 6;
   public int defaultTempo = 125;
   public int c2Rate = 8287;
   public int gain = 64;
   public boolean linearPeriods = false;
   public boolean fastVolSlides = false;
   public int[] defaultPanning = new int[]{51, 204, 204, 51};
   public int[] sequence = new int[]{0};
   public Pattern[] patterns = new Pattern[]{new Pattern(4, 64)};
   public Instrument[] instruments = new Instrument[]{new Instrument(), new Instrument()};

   public Module() {
   }

   public Module(InputStream inputStream) throws IOException {
      this(new Data(inputStream));
   }

   public Module(Data moduleData) throws IOException {
      if (moduleData.strLatin1(0, 17).equals("Extended Module: ")) {
         this.loadXM(moduleData);
      } else if (moduleData.strLatin1(44, 4).equals("SCRM")) {
         this.loadS3M(moduleData);
      } else {
         this.loadMod(moduleData);
      }
   }

   public Module(byte[] moduleData) throws IOException {
      this(new Data(moduleData));
   }

   private void loadMod(Data moduleData) throws IOException {
      this.songName = moduleData.strLatin1(0, 20);
      this.sequenceLength = moduleData.uByte(950) & 127;
      this.restartPos = moduleData.uByte(951) & 127;
      if (this.restartPos >= this.sequenceLength) {
         this.restartPos = 0;
      }

      this.sequence = new int[128];

      for (int seqIdx = 0; seqIdx < 128; seqIdx++) {
         int patIdx = moduleData.uByte(952 + seqIdx) & 127;
         this.sequence[seqIdx] = patIdx;
         if (patIdx >= this.numPatterns) {
            this.numPatterns = patIdx + 1;
         }
      }

      switch (moduleData.ubeShort(1082)) {
         case 17224:
            this.numChannels = (moduleData.uByte(1080) - 48) * 10;
            this.numChannels = this.numChannels + (moduleData.uByte(1081) - 48);
            this.c2Rate = 8363;
            this.gain = 32;
            break;
         case 18510:
            this.numChannels = moduleData.uByte(1080) - 48;
            this.c2Rate = 8363;
            this.gain = 32;
            break;
         case 19233:
         case 19246:
         case 21556:
            this.numChannels = 4;
            this.c2Rate = 8287;
            this.gain = 64;
            break;
         default:
            throw new IllegalArgumentException("MOD Format not recognised!");
      }

      this.defaultGVol = 64;
      this.defaultSpeed = 6;
      this.defaultTempo = 125;
      this.defaultPanning = new int[this.numChannels];

      for (int idx = 0; idx < this.numChannels; idx++) {
         this.defaultPanning[idx] = 51;
         if ((idx & 3) == 1 || (idx & 3) == 2) {
            this.defaultPanning[idx] = 204;
         }
      }

      int moduleDataIdx = 1084;
      this.patterns = new Pattern[this.numPatterns];

      for (int patIdx = 0; patIdx < this.numPatterns; patIdx++) {
         Pattern pattern = this.patterns[patIdx] = new Pattern(this.numChannels, 64);

         for (int patDataIdx = 0; patDataIdx < pattern.data.length; patDataIdx += 5) {
            int period = (moduleData.uByte(moduleDataIdx) & 15) << 8;
            period = (period | moduleData.uByte(moduleDataIdx + 1)) * 4;
            if (period > 112) {
               pattern.data[patDataIdx] = (byte)Channel.periodToKey(period);
            }

            int ins = (moduleData.uByte(moduleDataIdx + 2) & 240) >> 4;
            ins |= moduleData.uByte(moduleDataIdx) & 16;
            pattern.data[patDataIdx + 1] = (byte)ins;
            int effect = moduleData.uByte(moduleDataIdx + 2) & 15;
            int param = moduleData.uByte(moduleDataIdx + 3);
            if (param == 0 && (effect < 3 || effect == 10)) {
               effect = 0;
            }

            if (param == 0 && (effect == 5 || effect == 6)) {
               effect -= 2;
            }

            if (effect == 8 && this.numChannels == 4) {
               param = 0;
               effect = 0;
            }

            pattern.data[patDataIdx + 3] = (byte)effect;
            pattern.data[patDataIdx + 4] = (byte)param;
            moduleDataIdx += 4;
         }
      }

      this.numInstruments = 31;
      this.instruments = new Instrument[this.numInstruments + 1];
      this.instruments[0] = new Instrument();

      for (int instIdx = 1; instIdx <= this.numInstruments; instIdx++) {
         Instrument instrument = this.instruments[instIdx] = new Instrument();
         Sample sample = instrument.samples[0];
         instrument.name = moduleData.strLatin1(instIdx * 30 - 10, 22);
         int sampleLength = moduleData.ubeShort(instIdx * 30 + 12) * 2;
         int fineTune = (moduleData.uByte(instIdx * 30 + 14) & 15) << 4;
         sample.fineTune = fineTune < 128 ? fineTune : fineTune - 256;
         int volume = moduleData.uByte(instIdx * 30 + 15) & 127;
         sample.volume = volume <= 64 ? volume : 64;
         sample.panning = -1;
         sample.c2Rate = this.c2Rate;
         int loopStart = moduleData.ubeShort(instIdx * 30 + 16) * 2;
         int loopLength = moduleData.ubeShort(instIdx * 30 + 18) * 2;
         if (loopStart + loopLength > sampleLength) {
            loopLength = sampleLength - loopStart;
         }

         if (loopLength < 4) {
            loopStart = sampleLength;
            loopLength = 0;
         }

         sample.setSampleData(moduleData.samS8(moduleDataIdx, sampleLength), loopStart, loopLength, false);
         moduleDataIdx += sampleLength;
      }
   }

   private void loadS3M(Data moduleData) throws IOException {
      this.songName = moduleData.strCp850(0, 28);
      this.sequenceLength = moduleData.uleShort(32);
      this.numInstruments = moduleData.uleShort(34);
      this.numPatterns = moduleData.uleShort(36);
      int flags = moduleData.uleShort(38);
      int version = moduleData.uleShort(40);
      this.fastVolSlides = (flags & 64) == 64 || version == 4864;
      boolean signedSamples = moduleData.uleShort(42) == 1;
      if (moduleData.uleInt(44) != 1297236819) {
         throw new IllegalArgumentException("Not an S3M file!");
      } else {
         this.defaultGVol = moduleData.uByte(48);
         this.defaultSpeed = moduleData.uByte(49);
         this.defaultTempo = moduleData.uByte(50);
         this.c2Rate = 8363;
         this.gain = moduleData.uByte(51) & 127;
         boolean stereoMode = (moduleData.uByte(51) & 128) == 128;
         boolean defaultPan = moduleData.uByte(53) == 252;
         int[] channelMap = new int[32];

         for (int chanIdx = 0; chanIdx < 32; chanIdx++) {
            channelMap[chanIdx] = -1;
            if (moduleData.uByte(64 + chanIdx) < 16) {
               channelMap[chanIdx] = this.numChannels++;
            }
         }

         this.sequence = new int[this.sequenceLength];

         for (int seqIdx = 0; seqIdx < this.sequenceLength; seqIdx++) {
            this.sequence[seqIdx] = moduleData.uByte(96 + seqIdx);
         }

         int moduleDataIdx = 96 + this.sequenceLength;
         this.instruments = new Instrument[this.numInstruments + 1];
         this.instruments[0] = new Instrument();

         for (int instIdx = 1; instIdx <= this.numInstruments; instIdx++) {
            Instrument instrument = this.instruments[instIdx] = new Instrument();
            Sample sample = instrument.samples[0];
            int instOffset = moduleData.uleShort(moduleDataIdx) << 4;
            moduleDataIdx += 2;
            instrument.name = moduleData.strCp850(instOffset + 48, 28);
            if (moduleData.uByte(instOffset) == 1 && moduleData.uleShort(instOffset + 76) == 17235) {
               int sampleOffset = moduleData.uByte(instOffset + 13) << 20;
               sampleOffset += moduleData.uleShort(instOffset + 14) << 4;
               int sampleLength = moduleData.uleInt(instOffset + 16);
               int loopStart = moduleData.uleInt(instOffset + 20);
               int loopLength = moduleData.uleInt(instOffset + 24) - loopStart;
               sample.volume = moduleData.uByte(instOffset + 28);
               sample.panning = -1;
               boolean packed = moduleData.uByte(instOffset + 30) != 0;
               boolean loopOn = (moduleData.uByte(instOffset + 31) & 1) == 1;
               if (loopStart + loopLength > sampleLength) {
                  loopLength = sampleLength - loopStart;
               }

               if (loopLength < 1 || !loopOn) {
                  loopStart = sampleLength;
                  loopLength = 0;
               }

               boolean stereo = (moduleData.uByte(instOffset + 31) & 2) == 2;
               boolean sixteenBit = (moduleData.uByte(instOffset + 31) & 4) == 4;
               if (packed) {
                  throw new IllegalArgumentException("Packed samples not supported!");
               }

               sample.c2Rate = moduleData.uleInt(instOffset + 32);
               if (sixteenBit) {
                  if (signedSamples) {
                     sample.setSampleData(moduleData.samS16(sampleOffset, sampleLength), loopStart, loopLength, false);
                  } else {
                     sample.setSampleData(moduleData.samU16(sampleOffset, sampleLength), loopStart, loopLength, false);
                  }
               } else if (signedSamples) {
                  sample.setSampleData(moduleData.samS8(sampleOffset, sampleLength), loopStart, loopLength, false);
               } else {
                  sample.setSampleData(moduleData.samU8(sampleOffset, sampleLength), loopStart, loopLength, false);
               }
            }
         }

         this.patterns = new Pattern[this.numPatterns];

         for (int patIdx = 0; patIdx < this.numPatterns; patIdx++) {
            Pattern pattern = this.patterns[patIdx] = new Pattern(this.numChannels, 64);
            int inOffset = (moduleData.uleShort(moduleDataIdx) << 4) + 2;
            int rowIdx = 0;

            while (rowIdx < 64) {
               int token = moduleData.uByte(inOffset++);
               if (token == 0) {
                  rowIdx++;
               } else {
                  int noteKey = 0;
                  int noteIns = 0;
                  if ((token & 32) == 32) {
                     noteKey = moduleData.uByte(inOffset++);
                     noteIns = moduleData.uByte(inOffset++);
                     if (noteKey < 254) {
                        noteKey = (noteKey >> 4) * 12 + (noteKey & 15) + 1;
                     }

                     if (noteKey == 255) {
                        noteKey = 0;
                     }
                  }

                  int noteVol = 0;
                  if ((token & 64) == 64) {
                     noteVol = (moduleData.uByte(inOffset++) & 127) + 16;
                     if (noteVol > 80) {
                        noteVol = 0;
                     }
                  }

                  int noteEffect = 0;
                  int noteParam = 0;
                  if ((token & 128) == 128) {
                     noteEffect = moduleData.uByte(inOffset++);
                     noteParam = moduleData.uByte(inOffset++);
                     if (noteEffect < 1 || noteEffect >= 64) {
                        noteParam = 0;
                        noteEffect = 0;
                     }

                     if (noteEffect > 0) {
                        noteEffect += 128;
                     }
                  }

                  int chanIdxx = channelMap[token & 31];
                  if (chanIdxx >= 0) {
                     int noteOffset = (rowIdx * this.numChannels + chanIdxx) * 5;
                     pattern.data[noteOffset] = (byte)noteKey;
                     pattern.data[noteOffset + 1] = (byte)noteIns;
                     pattern.data[noteOffset + 2] = (byte)noteVol;
                     pattern.data[noteOffset + 3] = (byte)noteEffect;
                     pattern.data[noteOffset + 4] = (byte)noteParam;
                  }
               }
            }

            moduleDataIdx += 2;
         }

         this.defaultPanning = new int[this.numChannels];

         for (int chanIdxx = 0; chanIdxx < 32; chanIdxx++) {
            if (channelMap[chanIdxx] >= 0) {
               int panning = 7;
               if (stereoMode) {
                  panning = 12;
                  if (moduleData.uByte(64 + chanIdxx) < 8) {
                     panning = 3;
                  }
               }

               if (defaultPan) {
                  int panFlags = moduleData.uByte(moduleDataIdx + chanIdxx);
                  if ((panFlags & 32) == 32) {
                     panning = panFlags & 15;
                  }
               }

               this.defaultPanning[channelMap[chanIdxx]] = panning * 17;
            }
         }
      }
   }

   private void loadXM(Data moduleData) throws IOException {
      if (moduleData.uleShort(58) != 260) {
         throw new IllegalArgumentException("XM format version must be 0x0104!");
      } else {
         this.songName = moduleData.strCp850(17, 20);
         boolean deltaEnv = moduleData.strLatin1(38, 20).startsWith("DigiBooster Pro");
         int dataOffset = 60 + moduleData.uleInt(60);
         this.sequenceLength = moduleData.uleShort(64);
         this.restartPos = moduleData.uleShort(66);
         this.numChannels = moduleData.uleShort(68);
         this.numPatterns = moduleData.uleShort(70);
         this.numInstruments = moduleData.uleShort(72);
         this.linearPeriods = (moduleData.uleShort(74) & 1) > 0;
         this.defaultGVol = 64;
         this.defaultSpeed = moduleData.uleShort(76);
         this.defaultTempo = moduleData.uleShort(78);
         this.c2Rate = 8363;
         this.gain = 64;
         this.defaultPanning = new int[this.numChannels];

         for (int idx = 0; idx < this.numChannels; idx++) {
            this.defaultPanning[idx] = 128;
         }

         this.sequence = new int[this.sequenceLength];

         for (int seqIdx = 0; seqIdx < this.sequenceLength; seqIdx++) {
            int entry = moduleData.uByte(80 + seqIdx);
            this.sequence[seqIdx] = entry < this.numPatterns ? entry : 0;
         }

         this.patterns = new Pattern[this.numPatterns];

         for (int patIdx = 0; patIdx < this.numPatterns; patIdx++) {
            if (moduleData.uByte(dataOffset + 4) != 0) {
               throw new IllegalArgumentException("Unknown pattern packing type!");
            }

            int numRows = moduleData.uleShort(dataOffset + 5);
            int numNotes = numRows * this.numChannels;
            Pattern pattern = this.patterns[patIdx] = new Pattern(this.numChannels, numRows);
            int patternDataLength = moduleData.uleShort(dataOffset + 7);
            dataOffset += moduleData.uleInt(dataOffset);
            int nextOffset = dataOffset + patternDataLength;
            if (patternDataLength > 0) {
               int patternDataOffset = 0;

               for (int note = 0; note < numNotes; note++) {
                  int flags = moduleData.uByte(dataOffset);
                  if ((flags & 128) == 0) {
                     flags = 31;
                  } else {
                     dataOffset++;
                  }

                  byte key = (flags & 1) > 0 ? moduleData.sByte(dataOffset++) : 0;
                  pattern.data[patternDataOffset++] = key;
                  byte ins = (flags & 2) > 0 ? moduleData.sByte(dataOffset++) : 0;
                  pattern.data[patternDataOffset++] = ins;
                  byte vol = (flags & 4) > 0 ? moduleData.sByte(dataOffset++) : 0;
                  pattern.data[patternDataOffset++] = vol;
                  byte fxc = (flags & 8) > 0 ? moduleData.sByte(dataOffset++) : 0;
                  byte fxp = (flags & 16) > 0 ? moduleData.sByte(dataOffset++) : 0;
                  if (fxc >= 64) {
                     fxp = 0;
                     fxc = 0;
                  }

                  pattern.data[patternDataOffset++] = fxc;
                  pattern.data[patternDataOffset++] = fxp;
               }
            }

            dataOffset = nextOffset;
         }

         this.instruments = new Instrument[this.numInstruments + 1];
         this.instruments[0] = new Instrument();

         for (int insIdx = 1; insIdx <= this.numInstruments; insIdx++) {
            Instrument instrument = this.instruments[insIdx] = new Instrument();
            instrument.name = moduleData.strCp850(dataOffset + 4, 22);
            int numSamples = instrument.numSamples = moduleData.uleShort(dataOffset + 27);
            if (numSamples > 0) {
               instrument.samples = new Sample[numSamples];

               for (int keyIdx = 0; keyIdx < 96; keyIdx++) {
                  instrument.keyToSample[keyIdx + 1] = moduleData.uByte(dataOffset + 33 + keyIdx);
               }

               Envelope volEnv = instrument.volumeEnvelope = new Envelope();
               volEnv.pointsTick = new int[12];
               volEnv.pointsAmpl = new int[12];
               int pointTick = 0;

               for (int point = 0; point < 12; point++) {
                  int pointOffset = dataOffset + 129 + point * 4;
                  pointTick = (deltaEnv ? pointTick : 0) + moduleData.uleShort(pointOffset);
                  volEnv.pointsTick[point] = pointTick;
                  volEnv.pointsAmpl[point] = moduleData.uleShort(pointOffset + 2);
               }

               Envelope panEnv = instrument.panningEnvelope = new Envelope();
               panEnv.pointsTick = new int[12];
               panEnv.pointsAmpl = new int[12];
               pointTick = 0;

               for (int point = 0; point < 12; point++) {
                  int pointOffset = dataOffset + 177 + point * 4;
                  pointTick = (deltaEnv ? pointTick : 0) + moduleData.uleShort(pointOffset);
                  panEnv.pointsTick[point] = pointTick;
                  panEnv.pointsAmpl[point] = moduleData.uleShort(pointOffset + 2);
               }

               volEnv.numPoints = moduleData.uByte(dataOffset + 225);
               if (volEnv.numPoints > 12) {
                  volEnv.numPoints = 0;
               }

               panEnv.numPoints = moduleData.uByte(dataOffset + 226);
               if (panEnv.numPoints > 12) {
                  panEnv.numPoints = 0;
               }

               volEnv.sustainTick = volEnv.pointsTick[moduleData.uByte(dataOffset + 227)];
               volEnv.loopStartTick = volEnv.pointsTick[moduleData.uByte(dataOffset + 228)];
               volEnv.loopEndTick = volEnv.pointsTick[moduleData.uByte(dataOffset + 229)];
               panEnv.sustainTick = panEnv.pointsTick[moduleData.uByte(dataOffset + 230)];
               panEnv.loopStartTick = panEnv.pointsTick[moduleData.uByte(dataOffset + 231)];
               panEnv.loopEndTick = panEnv.pointsTick[moduleData.uByte(dataOffset + 232)];
               volEnv.enabled = volEnv.numPoints > 0 && (moduleData.uByte(dataOffset + 233) & 1) > 0;
               volEnv.sustain = (moduleData.uByte(dataOffset + 233) & 2) > 0;
               volEnv.looped = (moduleData.uByte(dataOffset + 233) & 4) > 0;
               panEnv.enabled = panEnv.numPoints > 0 && (moduleData.uByte(dataOffset + 234) & 1) > 0;
               panEnv.sustain = (moduleData.uByte(dataOffset + 234) & 2) > 0;
               panEnv.looped = (moduleData.uByte(dataOffset + 234) & 4) > 0;
               instrument.vibratoType = moduleData.uByte(dataOffset + 235);
               instrument.vibratoSweep = moduleData.uByte(dataOffset + 236);
               instrument.vibratoDepth = moduleData.uByte(dataOffset + 237);
               instrument.vibratoRate = moduleData.uByte(dataOffset + 238);
               instrument.volumeFadeOut = moduleData.uleShort(dataOffset + 239);
            }

            dataOffset += moduleData.uleInt(dataOffset);
            int sampleHeaderOffset = dataOffset;
            dataOffset += numSamples * 40;

            for (int samIdx = 0; samIdx < numSamples; samIdx++) {
               Sample sample = instrument.samples[samIdx] = new Sample();
               int sampleDataBytes = moduleData.uleInt(sampleHeaderOffset);
               int sampleLoopStart = moduleData.uleInt(sampleHeaderOffset + 4);
               int sampleLoopLength = moduleData.uleInt(sampleHeaderOffset + 8);
               sample.volume = moduleData.sByte(sampleHeaderOffset + 12);
               sample.fineTune = moduleData.sByte(sampleHeaderOffset + 13);
               sample.c2Rate = 8363;
               boolean looped = (moduleData.uByte(sampleHeaderOffset + 14) & 3) > 0;
               boolean pingPong = (moduleData.uByte(sampleHeaderOffset + 14) & 2) > 0;
               boolean sixteenBit = (moduleData.uByte(sampleHeaderOffset + 14) & 16) > 0;
               sample.panning = moduleData.uByte(sampleHeaderOffset + 15);
               sample.relNote = moduleData.sByte(sampleHeaderOffset + 16);
               sample.name = moduleData.strCp850(sampleHeaderOffset + 18, 22);
               sampleHeaderOffset += 40;
               if (!looped || sampleLoopStart + sampleLoopLength > sampleDataBytes) {
                  sampleLoopStart = sampleDataBytes;
                  sampleLoopLength = 0;
               }

               if (sixteenBit) {
                  sample.setSampleData(moduleData.samS16D(dataOffset, sampleDataBytes >> 1), sampleLoopStart >> 1, sampleLoopLength >> 1, pingPong);
               } else {
                  sample.setSampleData(moduleData.samS8D(dataOffset, sampleDataBytes), sampleLoopStart, sampleLoopLength, pingPong);
               }

               dataOffset += sampleDataBytes;
            }
         }
      }
   }

   public void toStringBuffer(StringBuffer out) {
      out.append(
         "Song Name: "
            + this.songName
            + '\n'
            + "Num Channels: "
            + this.numChannels
            + '\n'
            + "Num Instruments: "
            + this.numInstruments
            + '\n'
            + "Num Patterns: "
            + this.numPatterns
            + '\n'
            + "Sequence Length: "
            + this.sequenceLength
            + '\n'
            + "Restart Pos: "
            + this.restartPos
            + '\n'
            + "Default Speed: "
            + this.defaultSpeed
            + '\n'
            + "Default Tempo: "
            + this.defaultTempo
            + '\n'
            + "Linear Periods: "
            + this.linearPeriods
            + '\n'
      );
      out.append("Sequence: ");

      for (int seqIdx = 0; seqIdx < this.sequence.length; seqIdx++) {
         out.append(this.sequence[seqIdx] + ", ");
      }

      out.append('\n');

      for (int patIdx = 0; patIdx < this.patterns.length; patIdx++) {
         out.append("Pattern " + patIdx + ":\n");
         this.patterns[patIdx].toStringBuffer(out);
      }

      for (int insIdx = 1; insIdx < this.instruments.length; insIdx++) {
         out.append("Instrument " + insIdx + ":\n");
         this.instruments[insIdx].toStringBuffer(out);
      }
   }
}
