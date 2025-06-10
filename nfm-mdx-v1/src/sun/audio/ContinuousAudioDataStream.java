package sun.audio;

public class ContinuousAudioDataStream extends AudioDataStream {
   public ContinuousAudioDataStream(AudioData data) {
      super(data);
   }

   @Override
   public int read() {
      int i = super.read();
      if (i == -1) {
         this.reset();
         i = super.read();
      }

      return i;
   }

   @Override
   public int read(byte[] ab, int i1, int j) {
      int k = 0;

      while (k < j) {
         int i2 = super.read(ab, i1 + k, j - k);
         if (i2 >= 0) {
            k += i2;
         } else {
            this.reset();
         }
      }

      return k;
   }
}
