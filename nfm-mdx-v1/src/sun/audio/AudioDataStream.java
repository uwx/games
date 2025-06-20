package sun.audio;

import java.io.ByteArrayInputStream;

public class AudioDataStream extends ByteArrayInputStream {
   AudioData ad;

   public AudioDataStream(AudioData data) {
      super(data.buffer);
      this.ad = data;
   }

   AudioData getAudioData() {
      return this.ad;
   }
}
