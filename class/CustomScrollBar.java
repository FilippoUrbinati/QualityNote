import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class CustomScrollBar extends BasicScrollBarUI {

   int sbHeight;

   @Override
   protected void paintTrack(Graphics g, JComponent jc, Rectangle r) {
      Graphics2D g2 = (Graphics2D) g;
      int x, y, width, height;
      x = r.x;
      y = r.y;
      width = r.width;
      height = r.height;
      this.sbHeight =  r.height;
      g2.setColor(new Color(0, 0, 0, 0));
      g2.fillRect(x, y, width, height);
   }

   @Override
   protected void paintThumb(Graphics g, JComponent jc, Rectangle r) {
      Graphics2D g2 = (Graphics2D) g;
      int x, y, width, height;
      int arcWidth = 8;
      int arcHeight = 8;
      x = r.width/4;
      y = r.y;
      width = r.width/2;
      height = r.height;
      //stop the thumb before the window bottom border
      if (y > sbHeight-height-5) {
         y -= 12;
      }
      g2.setColor(new Color(70, 3, 124));
      g2.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
   }

   @Override
   protected JButton createDecreaseButton(int o) {
      JButton button = new JButton();
      button.setBorder(BorderFactory.createEmptyBorder());
      return button;
   }

   @Override
   protected JButton createIncreaseButton(int o) {
      JButton button = new JButton();
      button.setBorder(BorderFactory.createEmptyBorder());
      return button;
   }
}
