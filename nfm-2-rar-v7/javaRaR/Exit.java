
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Exit extends WindowAdapter {

 public void windowClosing(WindowEvent w) {
  Game.exit();
 }
}
