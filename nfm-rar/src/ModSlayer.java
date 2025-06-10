import java.io.IOException;

public class ModSlayer {
   static final String VERSION = "1.0";
   static final String COPYRIGHT = "";
   static final int EFF_VOL_SLIDE = 1;
   static final int EFF_PORT_DOWN = 2;
   static final int EFF_PORT_UP = 4;
   static final int EFF_VIBRATO = 8;
   static final int EFF_ARPEGGIO = 16;
   static final int EFF_PORT_TO = 32;
   static final int EFF_TREMOLO = 64;
   static final int EFF_RETRIG = 128;
   static final int MIX_BUF_SIZE = 2048;
   static final int DEF_TEMPO_NTSC = 6;
   static final int DEF_TEMPO_PAL = 6;
   static final int DEF_BPM_NTSC = 125;
   static final int DEF_BPM_PAL = 145;
   static final int MIDCRATE = 8448;
   static final int MAX_SAMPLES = 100;
   static final int MAX_TRACKS = 32;
   static final int S3M_MAGIC1 = 4122;
   static final int S3M_MAGIC2 = Mod.FOURCC("SCRM");
   static final int S3M_INSTR2 = Mod.FOURCC("SCRS");
   static final int[] normal_vol_adj = new int[]{
      0,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      11,
      12,
      13,
      14,
      15,
      16,
      17,
      18,
      19,
      20,
      21,
      22,
      23,
      24,
      25,
      26,
      27,
      28,
      29,
      30,
      31,
      32,
      33,
      34,
      35,
      36,
      37,
      38,
      39,
      40,
      41,
      42,
      43,
      44,
      45,
      46,
      47,
      48,
      49,
      50,
      51,
      52,
      53,
      54,
      55,
      56,
      57,
      58,
      59,
      60,
      61,
      62,
      63,
      63
   };
   static final int[] loud_vol_adj = new int[]{
      0,
      0,
      1,
      2,
      2,
      3,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      12,
      14,
      16,
      18,
      20,
      22,
      24,
      26,
      28,
      30,
      32,
      34,
      36,
      38,
      40,
      42,
      44,
      46,
      47,
      48,
      49,
      50,
      51,
      52,
      53,
      53,
      54,
      55,
      55,
      56,
      56,
      57,
      57,
      58,
      58,
      59,
      59,
      60,
      60,
      61,
      61,
      61,
      62,
      62,
      62,
      63,
      63,
      63,
      63,
      63,
      63
   };
   static final int[] sintable = new int[]{
      0, 25, 50, 74, 98, 120, 142, 162, 180, 197, 212, 225, 236, 244, 250, 254, 255, 254, 250, 244, 236, 225, 212, 197, 180, 162, 142, 120, 98, 74, 50, 25
   };
   static final int[] period_set = new int[]{
      1712,
      1616,
      1525,
      1440,
      1359,
      1283,
      1211,
      1143,
      1078,
      1018,
      961,
      907,
      856,
      808,
      763,
      720,
      679,
      641,
      605,
      571,
      539,
      509,
      480,
      453,
      428,
      404,
      381,
      360,
      340,
      321,
      303,
      286,
      270,
      254,
      240,
      227,
      214,
      202,
      191,
      180,
      170,
      160,
      151,
      143,
      135,
      127,
      120,
      113,
      107,
      101,
      95,
      90,
      85,
      80,
      76,
      71,
      67,
      64,
      60,
      57,
      53,
      50,
      48,
      45,
      42,
      40,
      38,
      36,
      34,
      32,
      30,
      28,
      27,
      25,
      24,
      22,
      21,
      20,
      19,
      18,
      17,
      16,
      15,
      14
   };
   static final int[] period_set_step = new int[]{
      1664,
      1570,
      1482,
      1399,
      1321,
      1247,
      1177,
      1110,
      1048,
      989,
      934,
      881,
      832,
      785,
      741,
      699,
      660,
      623,
      588,
      555,
      524,
      494,
      466,
      440,
      416,
      392,
      370,
      350,
      330,
      312,
      294,
      278,
      262,
      247,
      233,
      220,
      208,
      196,
      185,
      175,
      165,
      155,
      147,
      139,
      131,
      123,
      116,
      110,
      104,
      98,
      92,
      87,
      82,
      78,
      73,
      69,
      65,
      62,
      58,
      55,
      51,
      49,
      46,
      43,
      41,
      39,
      37,
      35,
      33,
      31,
      29,
      27,
      26,
      24,
      23,
      21,
      20,
      19,
      18,
      17,
      16,
      15,
      14,
      14
   };
   int def_tempo;
   int def_bpm;
   byte[] vol_table;
   int[] vol_adj;
   int vol_shift;
   Mod mod;
   int order_pos;
   int tempo;
   int tempo_wait;
   int bpm;
   int row;
   int break_row;
   int bpm_samples;
   int pattofs;
   byte[] patt;
   int numtracks;
   ModTrackInfo[] tracks;
   int mixspeed;
   boolean mod_done = false;
   public boolean bit16;
   public int samplingrate;
   public int oversample;
   public int gain;
   public int nloops = 1;
   public boolean loud = false;
   static final byte[] sunfmt = new byte[]{46, 115, 110, 100, 0, 0, 0, 24, 127, 127, 127, 127, 0, 0, 0, 1, 0, 0, 31, 76, 0, 0, 0, 1, 0, 0, 0, 0};
   private static final int ERROR_SHIFT = 12;
   private static final int ERROR_MASK = 4095;
   private static final long ratediv = 22748294283264L;

   final void beattrack(ModTrackInfo var1) {
      if (var1.period_low_limit == 0) {
         var1.period_low_limit = 1;
      }

      if ((var1.effect & 1) != 0) {
         var1.volume = var1.volume + var1.vol_slide;
         if (var1.volume < 0) {
            var1.volume = 0;
         }

         if (var1.volume > 64) {
            var1.volume = 64;
         }
      }

      if ((var1.effect & 2) != 0) {
         if ((var1.period = var1.period + var1.port_down) > var1.period_high_limit) {
            var1.period = var1.period_high_limit;
         }

         var1.pitch = var1.finetune_rate / var1.period;
      }

      if ((var1.effect & 4) != 0) {
         if ((var1.period = var1.period - var1.port_up) < var1.period_low_limit) {
            if (this.mod.s3m) {
               var1.period = var1.period_high_limit;
            } else {
               var1.period = var1.period_low_limit;
            }
         }

         var1.pitch = var1.finetune_rate / var1.period;
      }

      if ((var1.effect & 32) != 0) {
         if (var1.portto < var1.period) {
            if ((var1.period = var1.period + var1.port_inc) > var1.portto) {
               var1.period = var1.portto;
            }
         } else if (var1.portto > var1.period && (var1.period = var1.period - var1.port_inc) < var1.portto) {
            var1.period = var1.portto;
         }

         var1.pitch = var1.finetune_rate / var1.period;
      }

      if ((var1.effect & 8) != 0) {
         var1.vibpos = var1.vibpos + (var1.vib_rate << 2);
         int var2 = sintable[var1.vibpos >> 2 & 31] * var1.vib_depth >> 7;
         if ((var1.vibpos & 128) != 0) {
            var2 = -var2;
         }

         var2 += var1.period;
         if (var2 < var1.period_low_limit) {
            var2 = var1.period_low_limit;
         }

         if (var2 > var1.period_high_limit) {
            var2 = var1.period_high_limit;
         }

         var1.pitch = var1.finetune_rate / var2;
      }

      if ((var1.effect & 16) != 0) {
         var1.pitch = var1.finetune_rate / var1.arp[var1.arpindex];
         var1.arpindex++;
         if (var1.arpindex >= 3) {
            var1.arpindex = 0;
         }
      }
   }

   final void mixtrack_16_mono(ModTrackInfo var1, int[] var2, int var3, int var4) {
      byte[] var5 = var1.samples;
      int var6 = var1.position;
      int var7 = this.vol_adj[var1.volume] * this.gain >> this.vol_shift + 8;
      int var8 = var1.error;
      int var9 = var1.pitch & 4095;
      int var10 = var1.pitch >> 12;
      if (var1.replen < 3) {
         int var11 = var1.length;
         if (var6 >= var11) {
            return;
         }

         int var12 = var3 + var4;
         if (var1.pitch < 4096) {
            while (var6 < var11 && var3 < var12) {
               var2[var3++] += (var5[var6] * (4096 - var8) + var5[var6 + 1] * var8) * var7 >> 12;
               int var14;
               var6 += var10 + ((var14 = var8 + var9) >> 12);
               var8 = var14 & 4095;
            }
         } else {
            while (var6 < var11 && var3 < var12) {
               var2[var3++] += var5[var6] * var7;
               int var13;
               var6 += var10 + ((var13 = var8 + var9) >> 12);
               var8 = var13 & 4095;
            }
         }

         var1.error = var8;
         var1.position = var6;
      } else {
         int var17 = var1.replen + var1.repeat;
         if (var1.pitch < 4096) {
            while (var4 > 0) {
               if (var6 >= var17) {
                  var6 -= var1.replen;
               }

               var2[var3++] += (var5[var6] * (4096 - var8) + var5[var6 + 1] * var8) * var7 >> 12;
               int var16;
               var6 += var10 + ((var16 = var8 + var9) >> 12);
               var8 = var16 & 4095;
               var4--;
            }
         } else {
            while (var4 > 0) {
               if (var6 >= var17) {
                  var6 -= var1.replen;
               }

               var2[var3++] += var5[var6] * var7;
               int var15;
               var6 += var10 + ((var15 = var8 + var9) >> 12);
               var8 = var15 & 4095;
               var4--;
            }
         }

         var1.error = var8;
         var1.position = var6;
      }
   }

   ModSlayer(Mod var1, int var2, int var3, int var4) {
      this.samplingrate = var2;
      this.gain = var3;
      this.oversample = 1;
      this.mod = var1;
      this.def_tempo = 6;
      this.def_bpm = var4;
   }

   final void make_vol_table8() {
      this.vol_table = new byte[16640];
      int var1 = 0;

      do {
         this.vol_table[var1] = (byte)(this.vol_adj[var1 >> 8] * (byte)var1 >> 8 + this.vol_shift);
      } while (++var1 < 16640);
   }

   final void updatetracks() {
      this.tempo_wait = this.tempo;
      if (this.row >= 64) {
         if (this.order_pos >= this.mod.song_length_patterns) {
            this.order_pos = 0;
            this.nloops += -1;
            if (this.nloops == 0) {
               this.mod_done = true;
            }
         }

         this.row = this.break_row;
         this.break_row = 0;
         if (this.mod.positions[this.order_pos] == 255) {
            this.order_pos = 0;
            this.row = 0;
         }

         this.patt = this.mod.patterns[this.mod.positions[this.order_pos]];
         this.pattofs = this.row * 4 * this.numtracks;
         this.order_pos++;
      }

      this.row++;

      for (int var1 = 0; var1 < this.numtracks; var1++) {
         this.pattofs = this.get_track(this.tracks[var1], this.patt, this.pattofs);
      }
   }

   public byte[] turnbytes() throws IOException {
      this.bit16 = true;
      this.startplaying(this.loud);
      int[] var3 = new int[this.mixspeed];
      int[] var4 = new int[this.mixspeed];
      int[] var5 = new int[3500000];
      int var6 = 0;

      while (!this.mod_done) {
         if ((this.tempo_wait += -1) > 0) {
            for (int var2 = 0; var2 < this.numtracks; var2++) {
               this.beattrack(this.tracks[var2]);
            }
         } else {
            this.updatetracks();
         }

         System.arraycopy(var4, 0, var3, 0, this.bpm_samples);

         for (int var1 = 0; var1 < this.numtracks; var1++) {
            this.mixtrack_16_mono(this.tracks[var1], var3, 0, this.bpm_samples);
         }

         int var7 = this.bpm_samples;
         if (this.oversample > 1) {
            int var8 = 0;
            var7 = this.bpm_samples / this.oversample;
            if (this.oversample == 2) {
               for (int var12 = 0; var12 < var7; var12++) {
                  var3[var12] = var3[var8] + var3[var8 + 1] >> 1;
                  var8 += 2;
               }
            } else {
               for (int var11 = 0; var11 < var7; var11++) {
                  int var9 = var3[var8++];

                  for (int var10 = 1; var10 < this.oversample; var10++) {
                     var9 += var3[var8++];
                  }

                  var3[var11] = var9 / this.oversample;
               }
            }
         }

         for (int var13 = 0; var13 < var7; var13++) {
            if (var6 < 3500000) {
               var5[var6] = var3[var13];
               var6++;
            }
         }
      }

      for (int var14 = 2; var14 < var6; var14++) {
         var5[var14] = (var5[var14] + var5[var14 - 2]) / 2;
      }

      for (int var15 = 57; var15 < var6; var15++) {
         var5[var15] = (var5[var15] + var5[var15] + var5[var15 - 50]) / 3;
      }

      byte[] var16 = new byte[var6];

      for (int var17 = 0; var17 < var6; var17++) {
         var16[var17] = UlawUtils.linear2ulawclip(var5[var17]);
      }

      return var16;
   }

   final int get_track(ModTrackInfo var1, byte[] var2, int var3) {
      int var4 = var2[var3] & 240;
      int var5 = (var2[var3++] & 15) << 8;
      var5 |= var2[var3++] & 255;
      int var6 = var2[var3] & 15;
      var4 |= (var2[var3++] & 240) >> 4;
      int var7 = var2[var3++];
      var1.effect = 0;
      if (var4 != 0) {
         ModInstrument var8 = this.mod.insts[--var4];
         var1.volume = var8.volume;
         var1.length = var8.sample_length;
         var1.repeat = var8.repeat_point;
         var1.replen = var8.repeat_length;
         var1.finetune_rate = var8.finetune_rate;
         var1.samples = var8.samples;
         var1.period_low_limit = var8.period_low_limit;
         var1.period_high_limit = var8.period_high_limit;
      }

      if (var5 != 0) {
         var1.portto = var5;
         if (var6 != 3 && var6 != 5) {
            var1.start_period = var1.period = var5;
            var1.pitch = var1.finetune_rate / var5;
            var1.position = 0;
         }
      }

      if (var6 != 0 || var7 != 0) {
         switch (var6) {
            case 0:
               int var19 = 12;

               while (var1.period < period_set[var19]) {
                  if (++var19 >= 48) {
                     break;
                  }
               }

               var1.arp[0] = period_set[var19];
               var1.arp[1] = period_set[var19 + (var7 & 15)];
               var1.arp[2] = period_set[var19 + ((var7 & 240) >> 4)];
               var1.arpindex = 0;
               var1.effect |= 16;
               break;
            case 1:
               var1.effect |= 4;
               if (var7 != 0) {
                  var1.port_up = var7;
               }
               break;
            case 2:
               var1.effect |= 2;
               if (var7 != 0) {
                  var1.port_down = var7;
               }
               break;
            case 3:
               if (var7 != 0) {
                  var1.port_inc = var7 & 0xFF;
               }

               var1.effect |= 32;
               break;
            case 4:
               if ((var7 & 15) != 0) {
                  var1.vib_depth = var7 & 15;
               }

               if ((var7 & 240) != 0) {
                  var1.vib_rate = (var7 & 240) >> 4;
               }

               if (var5 != 0) {
                  var1.vibpos = 0;
               }

               var1.effect |= 8;
               break;
            case 5:
               var1.effect |= 32;
            case 6:
               if (var6 == 6) {
                  var1.effect |= 8;
               }
            case 10:
               var1.vol_slide = ((var7 & 240) >> 4) - (var7 & 15);
               var1.effect |= 1;
            case 7:
            case 8:
            case 11:
            default:
               break;
            case 9:
               if (var7 == 0) {
                  var7 = var1.oldsampofs;
               }

               var1.oldsampofs = var7;
               var1.position = (var7 & 0xFF) << 8;
               break;
            case 12:
               if (var7 <= 64 && var7 >= 0) {
                  var1.volume = var7;
               } else {
                  var1.volume = 64;
               }
               break;
            case 13:
               this.break_row = ((var7 & 240) >> 4) * 10 + (var7 & 15);
               this.row = 64;
               break;
            case 14:
               int var9 = var7 & 240;
               var7 &= 15;
               switch (var9) {
                  case 1:
                     var1.period += var7;
                     if (var1.period > var1.period_high_limit) {
                        var1.period = var1.period_high_limit;
                     }

                     var1.pitch = var1.finetune_rate / var1.period;
                     return var3;
                  case 2:
                     var1.period -= var7;
                     if (var1.period < var1.period_low_limit) {
                        var1.period = var1.period_low_limit;
                     }

                     var1.pitch = var1.finetune_rate / var1.period;
                     return var3;
                  default:
                     return var3;
               }
            case 15:
               if (var7 != 0) {
                  var7 &= 255;
                  if (var7 <= 32) {
                     this.tempo = var7;
                     this.tempo_wait = var7;
                  } else {
                     this.bpm = var7;
                     this.bpm_samples = this.samplingrate / (103 * var7 >> 8) * this.oversample;
                  }
               }
         }
      }

      return var3;
   }

   final void startplaying(boolean var1) {
      this.vol_adj = var1 ? loud_vol_adj : normal_vol_adj;
      this.mixspeed = this.samplingrate * this.oversample;
      this.order_pos = 0;
      this.tempo_wait = this.tempo = this.def_tempo;
      this.bpm = this.def_bpm;
      this.row = 64;
      this.break_row = 0;
      this.bpm_samples = this.samplingrate / (24 * this.bpm / 60) * this.oversample;
      this.numtracks = this.mod.numtracks;
      this.tracks = new ModTrackInfo[this.numtracks];

      for (int var2 = 0; var2 < this.tracks.length; var2++) {
         this.tracks[var2] = new ModTrackInfo();
      }

      if (this.mod.s3m) {
         for (int var4 = 0; var4 < this.mod.insts.length; var4++) {
            ModInstrument var3 = this.mod.insts[var4];
            var3.finetune_rate = (int)(428L * var3.finetune_value << 8) / this.mixspeed;
            var3.period_low_limit = 14;
            var3.period_high_limit = 1712;
         }
      } else {
         for (int var5 = 0; var5 < this.mod.insts.length; var5++) {
            ModInstrument var6 = this.mod.insts[var5];
            var6.finetune_rate = (int)(22748294283264L / (this.mixspeed * (1536 - var6.finetune_value)));
            var6.period_low_limit = 113;
            var6.period_high_limit = 856;
         }
      }

      if (this.numtracks > 8) {
         this.vol_shift = 2;
      } else if (this.numtracks > 4) {
         this.vol_shift = 1;
      } else {
         this.vol_shift = 0;
      }

      if (!this.bit16) {
         this.make_vol_table8();
      }
   }
}
