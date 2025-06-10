import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseHandler extends MouseAdapter {
   private PopupMenu popupMenu;
   int id;

   public MouseHandler(PopupMenu var1, int var2) {
      this.popupMenu = var1;
      this.id = var2;
   }

   @Override
   public void mousePressed(MouseEvent var1) {
      if (var1.isPopupTrigger()) {
         this.popupMenu.show(var1.getComponent(), var1.getX(), var1.getY());
         Madness.textid = this.id;
         var1.consume();
      }
   }

   @Override
   public void mouseReleased(MouseEvent var1) {
      if (var1.isPopupTrigger()) {
         this.popupMenu.show(var1.getComponent(), var1.getX(), var1.getY());
         Madness.textid = this.id;
         var1.consume();
      }
   }
}
