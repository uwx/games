package sun.audio;

import java.io.IOException;
import java.io.InputStream;

public class AudioTranslatorStream extends NativeAudioStream {
   private int length = 0;

   public AudioTranslatorStream(InputStream in) throws IOException {
      super(in);
      throw new InvalidAudioFormatException();
   }

   @Override
   public int getLength() {
      return this.length;
   }
}
