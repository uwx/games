import java.applet.Applet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Mod {
   String name;
   int numtracks;
   int track_shift;
   int numpatterns;
   byte[][] patterns;
   ModInstrument[] insts;
   byte[] positions;
   int song_length_patterns;
   int song_repeat_patterns;
   boolean s3m;
   static final int voice_mk = FOURCC("M.K.");
   static final int voice_mk2 = FOURCC("M!K!");
   static final int voice_mk3 = FOURCC("M&K!");
   static final int voice_flt4 = FOURCC("FLT4");
   static final int voice_flt8 = FOURCC("FLT8");
   static final int voice_28ch = FOURCC("28CH");
   static final int voice_8chn = FOURCC("8CHN");
   static final int voice_6chn = FOURCC("6CHN");
   static final int[] voice_31_list = new int[]{voice_mk, voice_mk2, voice_mk3, voice_flt4, voice_flt8, voice_8chn, voice_6chn, voice_28ch};

   public int getNumPatterns() {
      return this.numpatterns;
   }

   public String toString() {
      return this.name + " (" + this.numtracks + " tracks, " + this.numpatterns + " patterns, " + this.insts.length + " samples)";
   }

   Mod(String var1, GameSparker var2) {
      try {
         URL var3 = new URL(var2.getRoot(), var1);
         DataInputStream var4 = new DataInputStream(var3.openStream());
         ZipInputStream var5 = new ZipInputStream(var4);
         ZipEntry var6 = var5.getNextEntry();
         int var7 = (int)var6.getSize();
         byte[] var8 = new byte[var7];
         int var9 = 0;

         while (var7 > 0) {
            int var10 = var5.read(var8, var9, var7);
            var9 += var10;
            var7 -= var10;
         }

         this.LoadMod(new ByteArrayInputStream(var8));
         var4.close();
         var5.close();
      } catch (Exception var11) {
         System.out.println("Mod: " + var1 + " " + var11);
      }
   }

   static final int readu16(DataInputStream var0) throws IOException {
      return var0.readShort() & 65535;
   }

   static final String readText(DataInputStream var0, int var1) throws IOException {
      byte[] var2 = new byte[var1];
      var0.readFully(var2, 0, var1);

      for (int var3 = var1 - 1; var3 >= 0; var3--) {
         if (var2[var3] != 0) {
            return new String(var2, 0, 0, var3 + 1);
         }
      }

      return "";
   }

   void readSequence(DataInputStream var1) throws IOException {
      this.positions = new byte[128];
      this.song_length_patterns = readu8(var1);
      this.song_repeat_patterns = readu8(var1);
      var1.readFully(this.positions, 0, 128);
      if (this.song_repeat_patterns > this.song_length_patterns) {
         this.song_repeat_patterns = this.song_length_patterns;
      }

      this.numpatterns = 0;

      for (int var2 = 0; var2 < this.positions.length; var2++) {
         if (this.positions[var2] > this.numpatterns) {
            this.numpatterns = this.positions[var2];
         }
      }

      this.numpatterns++;
   }

   public void LoadMod(InputStream var1) throws IOException {
      DataInputStream var2 = new DataInputStream(var1);
      byte var3 = 15;
      this.numtracks = 4;
      this.name = readText(var2, 20);
      var2.mark(1068);
      var2.skip(1060L);
      int var4 = var2.readInt();
      var2.reset();

      for (int var5 = 0; var5 < voice_31_list.length; var5++) {
         if (var4 == voice_31_list[var5]) {
            var3 = 31;
            break;
         }
      }

      if (var3 == 31) {
         if (var4 == voice_8chn) {
            this.numtracks = 8;
         } else if (var4 == voice_6chn) {
            this.numtracks = 6;
         } else if (var4 == voice_28ch) {
            this.numtracks = 28;
         }
      }

      this.insts = new ModInstrument[var3];

      for (int var7 = 0; var7 < var3; var7++) {
         this.insts[var7] = readInstrument(var2);
      }

      this.readSequence(var2);
      var2.skipBytes(4);
      this.readPatterns(var2);

      try {
         for (int var8 = 0; var8 < var3; var8++) {
            readSampleData(var2, this.insts[var8]);
         }
      } catch (EOFException var6) {
         System.out.println("Warning: EOF on MOD file");
      }

      var2.close();
   }

   static void readSampleData(DataInputStream var0, ModInstrument var1) throws IOException {
      var0.readFully(var1.samples, 0, var1.sample_length);
      if (var1.repeat_length > 3) {
         System.arraycopy(var1.samples, var1.repeat_point, var1.samples, var1.sample_length, 8);
      }
   }

   static ModInstrument readInstrument(DataInputStream var0) throws IOException {
      ModInstrument var1 = new ModInstrument();
      var1.name = readText(var0, 22);
      var1.sample_length = readu16(var0) << 1;
      var1.samples = new byte[var1.sample_length + 8];
      var1.finetune_value = (byte)(readu8(var0) << 4);
      var1.volume = readu8(var0);
      var1.repeat_point = readu16(var0) << 1;
      var1.repeat_length = readu16(var0) << 1;
      if (var1.repeat_point > var1.sample_length) {
         var1.repeat_point = var1.sample_length;
      }

      if (var1.repeat_point + var1.repeat_length > var1.sample_length) {
         var1.repeat_length = var1.sample_length - var1.repeat_point;
      }

      return var1;
   }

   static final int FOURCC(String var0) {
      return var0.charAt(3) & 0xFF | (var0.charAt(2) & 0xFF) << 8 | (var0.charAt(1) & 0xFF) << 16 | (var0.charAt(0) & 0xFF) << 24;
   }

   public int getNumTracks() {
      return this.numtracks;
   }

   public String getName() {
      return this.name;
   }

   void readPatterns(DataInputStream var1) throws IOException {
      int var2 = this.numtracks * 4 * 64;
      this.patterns = new byte[this.numpatterns][];

      for (int var3 = 0; var3 < this.numpatterns; var3++) {
         this.patterns[var3] = new byte[var2];
         var1.readFully(this.patterns[var3], 0, var2);
      }
   }

   static final int readu8(DataInputStream var0) throws IOException {
      return var0.readByte() & 0xFF;
   }
}
