package ds.nfm;

import ds.nfm.mod.Mod;
import ds.nfm.mod.ModSlayer;
import ds.nfm.xm.IBXMod;
import ds.nfm.xm.IBXModSlayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ModuleLoader {
   public static Module loadMod(String var0) throws FileNotFoundException, IOException {
      ZipInputStream var1 = new ZipInputStream(new FileInputStream(new File(var0)));
      return loadMod(var1);
   }

   public static Module loadMod(URL var0) throws IOException {
      ZipInputStream var1 = new ZipInputStream(new DataInputStream(var0.openStream()));
      return loadMod(var1);
   }

   public static Module loadMod(byte[] var0) throws IOException {
      ZipInputStream var1 = new ZipInputStream(new ByteArrayInputStream(var0));
      return loadMod(var1);
   }

   public static Module loadMod(ZipInputStream var0) throws IOException {
      Object var1 = null;
      ZipEntry var2 = var0.getNextEntry();
      String var3 = var2.getName();
      int var4 = (int)var2.getSize();
      byte[] var5;
      if (var4 == -1) {
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();

         int var7;
         while ((var7 = var0.read()) != -1) {
            var6.write(var7);
         }

         var5 = var6.toByteArray();
      } else {
         var5 = new byte[var4];
         int var9 = 0;

         while (var4 > 0) {
            int var10 = var0.read(var5, var9, var4);
            var9 += var10;
            var4 -= var10;
         }
      }

      var0.close();
      if (!var3.toLowerCase().endsWith(".xm") && !var3.toLowerCase().endsWith(".s3m")) {
         var1 = new Mod(var5);
      } else {
         var1 = new IBXMod(var5);
      }

      return (Module)var1;
   }

   public static ModuleSlayer prepareSlayer(Module var0, int var1, int var2, int var3) {
      if (var0 instanceof Mod) {
         return new ModSlayer((Mod)var0, var1, var2, var3);
      } else if (var0 instanceof IBXMod) {
         return new IBXModSlayer((IBXMod)var0, var1, var2, var3);
      } else {
         throw new ModuleException("Unsuported module format: " + var0.getName());
      }
   }
}
