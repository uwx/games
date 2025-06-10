package sun.audio;

import com.sun.media.sound.DataPusher;
import com.sun.media.sound.Toolkit;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Vector;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiFileFormat;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFormat.Encoding;

public class AudioDevice {
   private boolean DEBUG = false;
   private Hashtable clipStreams;
   private Vector infos;
   private boolean playing = false;
   private Mixer mixer = null;
   public static final AudioDevice device = new AudioDevice();

   private AudioDevice() {
      this.clipStreams = new Hashtable();
      this.infos = new Vector();
   }

   private synchronized void startSampled(AudioInputStream as, InputStream in) throws UnsupportedAudioFileException, LineUnavailableException {
      AudioDevice.Info info = null;
      DataPusher datapusher = null;
      DataLine.Info lineinfo = null;
      SourceDataLine sourcedataline = null;
      as = Toolkit.getPCMConvertedAudioInputStream(as);
      if (as != null) {
         lineinfo = new DataLine.Info(SourceDataLine.class, as.getFormat());
         if (AudioSystem.isLineSupported(lineinfo)) {
            sourcedataline = (SourceDataLine)AudioSystem.getLine(lineinfo);
            datapusher = new DataPusher(sourcedataline, as);
            info = new AudioDevice.Info(null, in, datapusher);
            this.infos.addElement(info);
            datapusher.start();
         }
      }
   }

   private synchronized void startMidi(InputStream bis, InputStream in) throws InvalidMidiDataException, MidiUnavailableException {
      Sequencer sequencer = null;
      AudioDevice.Info info = null;
      sequencer = MidiSystem.getSequencer();
      sequencer.open();

      try {
         sequencer.setSequence(bis);
      } catch (IOException var6) {
         throw new InvalidMidiDataException(var6.getMessage());
      }

      info = new AudioDevice.Info(sequencer, in, null);
      this.infos.addElement(info);
      sequencer.addMetaEventListener(info);
      sequencer.start();
   }

   public synchronized void openChannel(InputStream in) {
      if (this.DEBUG) {
         System.out.println("AudioDevice: openChannel");
         System.out.println("input stream =" + in);
      }

      AudioDevice.Info info = null;

      for (int i = 0; i < this.infos.size(); i++) {
         info = (AudioDevice.Info)this.infos.elementAt(i);
         if (info.in == in) {
            return;
         }
      }

      AudioInputStream as = null;
      if (in instanceof AudioStream) {
         if (((AudioStream)in).midiformat != null) {
            try {
               this.startMidi(((AudioStream)in).stream, in);
            } catch (Exception var20) {
               return;
            }
         } else if (((AudioStream)in).ais != null) {
            try {
               this.startSampled(((AudioStream)in).ais, in);
            } catch (Exception var19) {
               return;
            }
         }
      } else if (in instanceof AudioDataStream) {
         if (in instanceof ContinuousAudioDataStream) {
            try {
               AudioInputStream ais = new AudioInputStream(in, ((AudioDataStream)in).getAudioData().format, -1L);
               this.startSampled(ais, in);
            } catch (Exception var18) {
               return;
            }
         } else {
            try {
               AudioInputStream ais = new AudioInputStream(in, ((AudioDataStream)in).getAudioData().format, ((AudioDataStream)in).getAudioData().buffer.length);
               this.startSampled(ais, in);
            } catch (Exception var17) {
               return;
            }
         }
      } else {
         BufferedInputStream bis = new BufferedInputStream(in, 1024);

         try {
            try {
               as = AudioSystem.getAudioInputStream(bis);
            } catch (IOException var14) {
               return;
            }

            this.startSampled(as, in);
         } catch (UnsupportedAudioFileException var15) {
            try {
               try {
                  MidiFileFormat e2 = MidiSystem.getMidiFileFormat(bis);
               } catch (IOException var11) {
                  return;
               }

               this.startMidi(bis, in);
            } catch (InvalidMidiDataException var12) {
               AudioFormat defformat = new AudioFormat(Encoding.ULAW, 8000.0F, 8, 1, 1, 8000.0F, true);

               try {
                  AudioInputStream defaif = new AudioInputStream(bis, defformat, -1L);
                  this.startSampled(defaif, in);
               } catch (UnsupportedAudioFileException var9) {
                  return;
               } catch (LineUnavailableException var10) {
                  return;
               }
            } catch (MidiUnavailableException var13) {
               return;
            }
         } catch (LineUnavailableException var16) {
            return;
         }
      }

      this.notify();
   }

   public synchronized void closeChannel(InputStream in) {
      if (this.DEBUG) {
         System.out.println("AudioDevice.closeChannel");
      }

      if (in != null) {
         for (int i = 0; i < this.infos.size(); i++) {
            AudioDevice.Info info = (AudioDevice.Info)this.infos.elementAt(i);
            if (info.in == in) {
               if (info.sequencer != null) {
                  info.sequencer.stop();
                  this.infos.removeElement(info);
               } else if (info.datapusher != null) {
                  info.datapusher.stop();
                  this.infos.removeElement(info);
               }
            }
         }

         this.notify();
      }
   }

   public synchronized void open() {
   }

   public synchronized void close() {
   }

   public void play() {
      if (this.DEBUG) {
         System.out.println("exiting play()");
      }
   }

   public synchronized void closeStreams() {
      for (int i = 0; i < this.infos.size(); i++) {
         AudioDevice.Info info = (AudioDevice.Info)this.infos.elementAt(i);
         if (info.sequencer != null) {
            info.sequencer.stop();
            info.sequencer.close();
            this.infos.removeElement(info);
         } else if (info.datapusher != null) {
            info.datapusher.stop();
            this.infos.removeElement(info);
         }
      }

      if (this.DEBUG) {
         System.err.println("Audio Device: Streams all closed.");
      }

      this.clipStreams = new Hashtable();
      this.infos = new Vector();
   }

   public int openChannels() {
      return this.infos.size();
   }

   void setVerbose(boolean v) {
      this.DEBUG = v;
   }

   class Info implements MetaEventListener {
      Sequencer sequencer;
      InputStream in;
      DataPusher datapusher;

      Info(Sequencer sequencer, InputStream in, DataPusher datapusher) {
         this.sequencer = sequencer;
         this.in = in;
         this.datapusher = datapusher;
      }

      @Override
      public void meta(MetaMessage event) {
         if (event.getType() == 47 && this.sequencer != null) {
            this.sequencer.close();
         }
      }
   }
}
