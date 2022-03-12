import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class RoundedBorder implements Border {

   //corner radius
   private int radius;
   //border size
   private int size;

   public static final String ALL = "ALL";
   public static final String ALL_NO_FILLED = "ALL_NO_FILLED";
   public static final String TOP = "TOP";
   public static final String BOTTOM = "BOTTOM";
   public static final String BOTTOM_JUST_BORDER = "BOTTOM_JUST_BORDER";
   public static final String LEFT = "LEFT";
   public static final String RIGHT = "RIGHT";
   public static final String TOP_LEFT = "TOP_LEFT";
   public static final String TOP_RIGHT = "TOP_RIGHT";
   public static final String BOTTOM_LEFT = "BOTTOM_LEFT";
   public static final String BOTTOM_RIGHT = "BOTTOM_RIGHT";
   public static final String NO_ROUNDED = "NO_ROUNDED";

   private String constant;

   public RoundedBorder (int size, int radius, String string) {
      this.radius = radius;
      this.size = size;
      this.constant = string;
   }

   @Override
   public Insets getBorderInsets(Component c) {
      return new Insets(this.size, this.size, this.size, this.size);
   }

   @Override
   public boolean isBorderOpaque() {
      return true;
   }

   @Override
   public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

      Graphics2D graphics2D = (Graphics2D) g;
      //Set  anti-alias for SMOOTH corners;
      graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      graphics2D.setColor(c.getBackground());

      if (constant == ALL) {
         graphics2D.fillRoundRect(x,y,width,height,this.radius,this.radius);
      } else if (constant == ALL_NO_FILLED) {
         graphics2D.drawRoundRect(x,y,width,height,this.radius,this.radius);
      } else if (constant == TOP) {
         graphics2D.fillRoundRect(x,y,width,height+this.radius,this.radius,this.radius);
      } else if (constant == BOTTOM) {
         graphics2D.fillRoundRect(x,y-this.radius,width,height+this.radius,this.radius,this.radius);
      } else if (constant == BOTTOM_JUST_BORDER) {
         graphics2D.drawRoundRect(x,y-this.radius,width,height+this.radius,this.radius,this.radius);
      } else if (constant == LEFT) {
         graphics2D.fillRoundRect(x,y,width+this.radius,height,this.radius,this.radius);
      } else if (constant == RIGHT) {
         graphics2D.fillRoundRect(x-this.radius,y,width+this.radius,height,this.radius,this.radius);
      } else if (constant == TOP_LEFT) {
         graphics2D.fillRoundRect(x,y,width+this.radius,height+this.radius,this.radius,this.radius);
      } else if (constant == TOP_RIGHT) {
         graphics2D.fillRoundRect(x-this.radius,y,width+this.radius,height+this.radius,this.radius,this.radius);
      } else if (constant == BOTTOM_LEFT) {
         graphics2D.fillRoundRect(x,y-this.radius,width+this.radius,height+this.radius,this.radius,this.radius);
      } else if (constant == BOTTOM_RIGHT) {
         graphics2D.fillRoundRect(x-this.radius,y-this.radius,width+this.radius,height+this.radius,this.radius,this.radius);
      } else if (constant == NO_ROUNDED) {
         graphics2D.fillRect(x-this.radius,y-this.radius,width+this.radius,height+this.radius);
      } else {
         graphics2D.fillRoundRect(x,y,width,height,this.radius,this.radius);
      }

   }
}
