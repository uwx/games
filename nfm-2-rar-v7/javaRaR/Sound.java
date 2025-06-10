
import java.io.ByteArrayInputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.*;

class Sound {

 Game G;
 Clip clp = null;
 AudioInputStream snd;
 Clip ecoC1 = null;
 AudioInputStream ecoS1;
 Clip ecoC2 = null;
 AudioInputStream ecoS2;
 Clip ecoC3 = null;
 AudioInputStream ecoS3;
 double gn2;

 Sound(byte[] b, Game g) {
  ByteArrayInputStream bs;
  try {
   bs = new ByteArrayInputStream(b);
   snd = AudioSystem.getAudioInputStream(bs);
   snd.mark(b.length);
   DataLine.Info i = new DataLine.Info(Clip.class, snd.getFormat());
   clp = ((Clip) AudioSystem.getLine(i));
  } catch (Exception e) {
   System.out.println("Clip loading error: " + e);
  }
  try {
   bs = new ByteArrayInputStream(b);
   ecoS1 = AudioSystem.getAudioInputStream(bs);
   ecoS1.mark(b.length);
   DataLine.Info i = new DataLine.Info(Clip.class, ecoS1.getFormat());
   ecoC1 = ((Clip) AudioSystem.getLine(i));
  } catch (Exception e) {
   System.out.println("Echo 1 loading error: " + e);
  }
  try {
   bs = new ByteArrayInputStream(b);
   ecoS2 = AudioSystem.getAudioInputStream(bs);
   ecoS2.mark(b.length);
   DataLine.Info i = new DataLine.Info(Clip.class, ecoS2.getFormat());
   ecoC2 = ((Clip) AudioSystem.getLine(i));
  } catch (Exception e) {
   System.out.println("Echo 2 loading error: " + e);
  }
  try {
   bs = new ByteArrayInputStream(b);
   ecoS3 = AudioSystem.getAudioInputStream(bs);
   ecoS3.mark(b.length);
   DataLine.Info i = new DataLine.Info(Clip.class, ecoS3.getFormat());
   ecoC3 = ((Clip) AudioSystem.getLine(i));
  } catch (Exception e) {
   System.out.println("Echo 3 loading error: " + e);
  }
  G = g;
 }

 public void ply(double d) {
  clp.stop();
  try {
   clp.open(snd);
  } catch (Exception e) {
  }
  FloatControl gn = (FloatControl) clp.getControl(FloatControl.Type.MASTER_GAIN);
  if (Math.abs(gn2 - gn.getValue()) > 1) {
   clp.flush();
   gn2 = gn.getValue();
  }
  gn.setValue(Math.max((float) -d, -80));
  clp.setFramePosition(0);
  clp.loop(0);
  if (G.eco[G.stg] > 0) {
   plyE1();
  }
 }

 void plyE1() {
  new Timer().schedule(new TimerTask() {
   public void run() {
    ecoC1.stop();
    try {
     ecoC1.open(ecoS1);
    } catch (Exception e) {
    }
    FloatControl gn = (FloatControl) ecoC1.getControl(FloatControl.Type.MASTER_GAIN);
    gn.setValue(-G.eco[G.stg] * .05f);
    FloatControl pn = (FloatControl) ecoC1.getControl(FloatControl.Type.PAN);
    pn.setValue((float) Math.random() - (float) Math.random());
    ecoC1.setFramePosition(0);
    ecoC1.loop(0);
    plyE2();
    cancel();
   }
  }, G.eco[G.stg]);
 }

 void plyE2() {
  new Timer().schedule(new TimerTask() {
   public void run() {
    ecoC2.stop();
    try {
     ecoC2.open(ecoS2);
    } catch (Exception e) {
    }
    FloatControl gn = (FloatControl) ecoC2.getControl(FloatControl.Type.MASTER_GAIN);
    gn.setValue(-G.eco[G.stg] * .1f);
    FloatControl pn = (FloatControl) ecoC2.getControl(FloatControl.Type.PAN);
    pn.setValue((float) Math.random() - (float) Math.random());
    ecoC2.setFramePosition(0);
    ecoC2.loop(0);
    plyE3();
    cancel();
   }
  }, G.eco[G.stg]);
 }

 void plyE3() {
  new Timer().schedule(new TimerTask() {
   public void run() {
    ecoC3.stop();
    try {
     ecoC3.open(ecoS3);
    } catch (Exception e) {
    }
    FloatControl gn = (FloatControl) ecoC3.getControl(FloatControl.Type.MASTER_GAIN);
    gn.setValue(-G.eco[G.stg] * .15f);
    FloatControl pn = (FloatControl) ecoC3.getControl(FloatControl.Type.PAN);
    pn.setValue((float) Math.random() - (float) Math.random());
    ecoC3.setFramePosition(0);
    ecoC3.loop(0);
    cancel();
   }
  }, G.eco[G.stg]);
 }

 void lop(double d) {
  if (!clp.isOpen()) {
   try {
    clp.open(snd);
   } catch (Exception e) {
   }
  }
  FloatControl gn = (FloatControl) clp.getControl(FloatControl.Type.MASTER_GAIN);
  if (Math.abs(gn2 - gn.getValue()) > 1) {
   clp.flush();
   gn2 = gn.getValue();
  }
  gn.setValue(Math.max((float) -d, -80));
  if (!clp.isRunning()) {
   clp.loop(-1);
   if (G.eco[G.stg] > 0) {
    lopE1();
   }
  }
 }

 void lopE1() {
  new Timer().schedule(new TimerTask() {
   public void run() {
    if (!ecoC1.isOpen()) {
     try {
      ecoC1.open(ecoS1);
     } catch (Exception e) {
     }
    }
    FloatControl gn = (FloatControl) ecoC1.getControl(FloatControl.Type.MASTER_GAIN);
    gn.setValue(-G.eco[G.stg] * .05f);
    FloatControl pn = (FloatControl) ecoC1.getControl(FloatControl.Type.PAN);
    pn.setValue((float) Math.random() - (float) Math.random());
    if (!ecoC1.isRunning()) {
     ecoC1.loop(-1);
     lopE2();
    }
    cancel();
   }
  }, G.eco[G.stg]);
 }

 void lopE2() {
  new Timer().schedule(new TimerTask() {
   public void run() {
    if (!ecoC2.isOpen()) {
     try {
      ecoC2.open(ecoS2);
     } catch (Exception e) {
     }
    }
    FloatControl gn = (FloatControl) ecoC2.getControl(FloatControl.Type.MASTER_GAIN);
    gn.setValue(-G.eco[G.stg] * .1f);
    FloatControl pn = (FloatControl) ecoC2.getControl(FloatControl.Type.PAN);
    pn.setValue((float) Math.random() - (float) Math.random());
    if (!ecoC2.isRunning()) {
     ecoC2.loop(-1);
     lopE3();
    }
    cancel();
   }
  }, G.eco[G.stg]);
 }

 void lopE3() {
  new Timer().schedule(new TimerTask() {
   public void run() {
    if (!ecoC3.isOpen()) {
     try {
      ecoC3.open(ecoS3);
     } catch (Exception e) {
     }
    }
    FloatControl gn = (FloatControl) ecoC3.getControl(FloatControl.Type.MASTER_GAIN);
    gn.setValue(-G.eco[G.stg] * .15f);
    FloatControl pn = (FloatControl) ecoC3.getControl(FloatControl.Type.PAN);
    pn.setValue((float) Math.random() - (float) Math.random());
    if (!ecoC3.isRunning()) {
     ecoC3.loop(-1);
    }
    cancel();
   }
  }, G.eco[G.stg]);
 }

 void stp() {
  if (clp.isRunning()) {
   clp.stop();
   if (G.eco[G.stg] > 0) {
    stpE1();
   }
  }
 }

 void stpE1() {
  new Timer().schedule(new TimerTask() {
   public void run() {
    ecoC1.stop();
    stpE2();
    cancel();
   }
  }, G.eco[G.stg]);
 }

 void stpE2() {
  new Timer().schedule(new TimerTask() {
   public void run() {
    ecoC2.stop();
    stpE3();
    cancel();
   }
  }, G.eco[G.stg]);
 }

 void stpE3() {
  new Timer().schedule(new TimerTask() {
   public void run() {
    ecoC3.stop();
    cancel();
   }
  }, G.eco[G.stg]);
 }
}
