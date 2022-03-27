import java.awt.*;
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.font.*;
import java.util.*;


public class TextSettingDialog extends JDialog {

   Dimension dialogSize = new Dimension(198, 27);
   JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 2));
   JButton bold = new JButton();
   JButton italic = new JButton();
   JButton underlined = new JButton();
   JButton barred = new JButton();
   JButton list = new JButton();

   Color transparent = new Color(0, 0, 0, 0);
   Color borderButtonColor = new Color(110, 110, 110, 110);

   Font font;
   Map<TextAttribute, Object> attributes;


   public TextSettingDialog(TextPanel textPanel) {

      this.setSize(dialogSize);
      this.setAlwaysOnTop(true);
      this.setUndecorated(true);
      //fix little not transparent corners
      this.setBackground(new Color(0, 0, 0, 0));
      panel.setOpaque(false);
      //background to give color context (for fillRoundRect in RoundedBorder class)
      panel.setBackground(new Color(43, 43, 43));
      panel.setDoubleBuffered(true);
      panel.setBorder(new RoundedBorder(0, 16, RoundedBorder.BOTTOM_RIGHT));

      Color buttonColorDefault = panel.getBackground();
      Color buttonColorOver = new Color(70, 3, 124);
      Color buttonColorClick = new Color(50, 50, 50);



      //button general settings
      bold.setPreferredSize(new Dimension(23, 23));
      bold.setBackground(transparent);
      bold.setBorderPainted(true);                                              //left border
      bold.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, borderButtonColor));
      bold.setContentAreaFilled(false);
      bold.setOpaque(true);
      bold.setFocusable(false);
      //text button settings
      bold.setText("B");
      bold.setVerticalAlignment(SwingConstants.CENTER);
      bold.setHorizontalAlignment(SwingConstants.CENTER);
      bold.setForeground(new Color(255, 255, 255));
      bold.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
      bold.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {


               setVisible(false);
            }
         }
         //color settings
         boolean over;
         public void mouseExited(MouseEvent e) {
            bold.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            bold.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            bold.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               bold.setBackground(buttonColorOver);
            } else {
               bold.setBackground(buttonColorDefault);
            }
         }
      });



      italic.setPreferredSize(new Dimension(23, 23));
      italic.setBackground(transparent);
      italic.setBorderPainted(true);                                              //left border
      italic.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, borderButtonColor));
      italic.setContentAreaFilled(false);
      italic.setOpaque(true);
      italic.setFocusable(false);
      //text button settings
      italic.setText("I");
      italic.setVerticalAlignment(SwingConstants.CENTER);
      italic.setHorizontalAlignment(SwingConstants.CENTER);
      italic.setForeground(new Color(255, 255, 255));
      italic.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
      italic.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {


               setVisible(false);
            }
         }
         //color settings
         boolean over;
         public void mouseExited(MouseEvent e) {
            italic.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            italic.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            italic.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               italic.setBackground(buttonColorOver);
            } else {
               italic.setBackground(buttonColorDefault);
            }
         }
      });



      underlined.setPreferredSize(new Dimension(23, 23));
      underlined.setBackground(transparent);
      underlined.setBorderPainted(true);                                              //left border
      underlined.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, borderButtonColor));
      underlined.setContentAreaFilled(false);
      underlined.setOpaque(true);
      underlined.setFocusable(false);
      //text button settings
      underlined.setText("U");
      underlined.setVerticalAlignment(SwingConstants.CENTER);
      underlined.setHorizontalAlignment(SwingConstants.CENTER);
      underlined.setForeground(new Color(255, 255, 255));
      underlined.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
      font = underlined.getFont();
      attributes = new HashMap<>(font.getAttributes());
      attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
      underlined.setFont(font.deriveFont(attributes));
      underlined.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               textPanel.setSelectedText(Font.BOLD);


               setVisible(false);
            }
         }
         //color settings
         boolean over;
         public void mouseExited(MouseEvent e) {
            underlined.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            underlined.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            underlined.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               underlined.setBackground(buttonColorOver);
            } else {
               underlined.setBackground(buttonColorDefault);
            }
         }
      });



      barred.setPreferredSize(new Dimension(23, 23));
      barred.setBackground(transparent);
      barred.setBorderPainted(true);                                              //left border
      barred.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, borderButtonColor));
      barred.setContentAreaFilled(false);
      barred.setOpaque(true);
      barred.setFocusable(false);
      //text button settings
      barred.setText("ab");
      barred.setVerticalAlignment(SwingConstants.CENTER);
      barred.setHorizontalAlignment(SwingConstants.CENTER);
      barred.setForeground(new Color(255, 255, 255));
      barred.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
      font = barred.getFont();
      attributes = new HashMap<>(font.getAttributes());
      attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
      barred.setFont(font.deriveFont(attributes));
      barred.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {




               setVisible(false);
            }
         }
         //color settings
         boolean over;
         public void mouseExited(MouseEvent e) {
            barred.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            barred.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            barred.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               barred.setBackground(buttonColorOver);
            } else {
               barred.setBackground(buttonColorDefault);
            }
         }
      });



      list.setPreferredSize(new Dimension(23, 23));
      list.setBackground(transparent);
      list.setBorderPainted(true);                                              //left border
      list.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, borderButtonColor));
      list.setContentAreaFilled(false);
      list.setOpaque(true);
      list.setFocusable(false);
      list.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {


               setVisible(false);
            }
         }
         //color settings
         boolean over;
         public void mouseExited(MouseEvent e) {
            list.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            list.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            list.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               list.setBackground(buttonColorOver);
            } else {
               list.setBackground(buttonColorDefault);
            }
         }
      });







      panel.add(bold);
      panel.add(italic);
      panel.add(underlined);
      panel.add(barred);
      panel.add(list);




      this.addWindowFocusListener(new WindowFocusListener() {
         public void windowGainedFocus(WindowEvent e) {
         }
         public void windowLostFocus(WindowEvent e) {
            setVisible(false);
         }
      });


      this.add(panel);
   }








}
