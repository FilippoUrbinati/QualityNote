import java.awt.*;
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.border.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;


public class SizingDialog extends JDialog {

   JDialog dialog;
   //screen size (height is without Windows taskbar)
   int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
   int screenHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;

   Dimension sizingDialogSize;
   Color transparent = new Color(0, 0, 0, 0);
   Color buttonColorDefault = new Color(78, 78, 78);
   Color buttonColorOver = new Color(98, 4, 174);
   Color buttonColorClick = new Color(92, 7, 160);
   JPanel panel = new JPanel(new GridLayout(2, 3, 12, 12));
   JPanel box1 = new JPanel(new GridLayout(1, 2, 4, 0));
   JPanel box2 = new JPanel(new GridBagLayout());
   JPanel box3 = new JPanel(new GridLayout(1, 3, 4, 0));
   JPanel box4 = new JPanel(new GridLayout(1, 2, 4, 0));
      JPanel box4_right = new JPanel(new GridLayout(2, 1, 0, 4));
   JPanel box5 = new JPanel(new GridLayout(2, 2, 4, 4));
   JPanel box6 = new JPanel(new GridBagLayout());

   JButton box1_btn1 = new JButton();
   JButton box1_btn2 = new JButton();

   JButton box2_btn1 = new JButton();
   JButton box2_btn2 = new JButton();

   JButton box3_btn1 = new JButton();
   JButton box3_btn2 = new JButton();
   JButton box3_btn3 = new JButton();

   JButton box4_btn1 = new JButton();
   JButton box4_btn2 = new JButton();
   JButton box4_btn3 = new JButton();

   JButton box5_btn1 = new JButton();
   JButton box5_btn2 = new JButton();
   JButton box5_btn3 = new JButton();
   JButton box5_btn4 = new JButton();

   JButton box6_btn1 = new JButton();
   JButton box6_btn2 = new JButton();
   JButton box6_btn3 = new JButton();


   static boolean isEasySized;                                                  //used to check if window is sized with macros or not

   public SizingDialog(JFrame window, TextPanel textPanel) {
      dialog = this;

      panel = new JPanel(new GridLayout(2, 3, 12, 12));
      sizingDialogSize = new Dimension(342, 164);
      this.setSize(sizingDialogSize);
      this.setAlwaysOnTop(true);
      this.setUndecorated(true);
      //fix little not transparent corners
      this.setBackground(transparent);
      panel.setOpaque(false);
      //background to give color context (for fillRoundRect in RoundedBorder class)
      panel.setBackground(new Color(44, 44, 44));
      panel.setDoubleBuffered(true);
      panel.setBorder(new RoundedBorder(12, 15, RoundedBorder.ALL));



      //BOX1 TOP LEFT
      box1.setBackground(transparent);
      box1_btn1.setOpaque(false);
      box1_btn1.setFocusable(false);
      box1_btn1.setBackground(buttonColorDefault);
      box1_btn1.setContentAreaFilled(false);
      box1_btn1.setBorder(new RoundedBorder(12, 10, RoundedBorder.LEFT));
      box1_btn1.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(0, 0);
               window.setSize(screenWidth/2, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box1_btn1.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box1_btn1.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box1_btn1.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box1_btn1.setBackground(buttonColorOver);
            } else {
               box1_btn1.setBackground(buttonColorDefault);
            }
         }
      });

      box1_btn2.setOpaque(false);
      box1_btn2.setFocusable(false);
      box1_btn2.setBackground(buttonColorDefault);
      box1_btn2.setContentAreaFilled(false);
      box1_btn2.setBorder(new RoundedBorder(12, 10, RoundedBorder.RIGHT));
      box1_btn2.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(screenWidth/2, 0);
               window.setSize(screenWidth/2, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box1_btn2.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box1_btn2.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box1_btn2.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box1_btn2.setBackground(buttonColorOver);
            } else {
               box1_btn2.setBackground(buttonColorDefault);
            }
         }
      });

      box1.add(box1_btn1);
      box1.add(box1_btn2);



      //BOX2 TOP CENTER
      box2.setBackground(transparent);
      box2_btn1.setPreferredSize(new Dimension(63, 64));
      box2_btn1.setOpaque(false);
      box2_btn1.setFocusable(false);
      box2_btn1.setBackground(buttonColorDefault);
      box2_btn1.setContentAreaFilled(false);
      box2_btn1.setBorder(new RoundedBorder(12, 10, RoundedBorder.LEFT));
      box2_btn1.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(0, 0);
               window.setSize(screenWidth/3*2, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box2_btn1.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box2_btn1.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box2_btn1.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box2_btn1.setBackground(buttonColorOver);
            } else {
               box2_btn1.setBackground(buttonColorDefault);
            }
         }
      });

      box2_btn2.setPreferredSize(new Dimension(31, 64));
      box2_btn2.setOpaque(false);
      box2_btn2.setFocusable(false);
      box2_btn2.setBackground(new Color(78, 78, 78));
      box2_btn2.setContentAreaFilled(false);
      box2_btn2.setBorder(new RoundedBorder(12, 10, RoundedBorder.RIGHT));
      box2_btn2.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(screenWidth/3*2, 0);
               window.setSize(screenWidth/3, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box2_btn2.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box2_btn2.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box2_btn2.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box2_btn2.setBackground(buttonColorOver);
            } else {
               box2_btn2.setBackground(buttonColorDefault);
            }
         }
      });

      box2.add(box2_btn1);
      box2.add(Box.createRigidArea(new Dimension(4, 0)));
      box2.add(box2_btn2);



      //BOX3 TOP CENTER
      box3.setBackground(transparent);
      box3_btn1.setPreferredSize(new Dimension(30, 64));
      box3_btn1.setOpaque(false);
      box3_btn1.setFocusable(false);
      box3_btn1.setBackground(buttonColorDefault);
      box3_btn1.setContentAreaFilled(false);
      box3_btn1.setBorder(new RoundedBorder(12, 10, RoundedBorder.LEFT));
      box3_btn1.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(0, 0);
               window.setSize(screenWidth/3, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box3_btn1.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box3_btn1.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box3_btn1.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box3_btn1.setBackground(buttonColorOver);
            } else {
               box3_btn1.setBackground(buttonColorDefault);
            }
         }
      });

      box3_btn2.setPreferredSize(new Dimension(30, 64));
      box3_btn2.setOpaque(false);
      box3_btn2.setFocusable(false);
      box3_btn2.setBackground(buttonColorDefault);
      box3_btn2.setContentAreaFilled(false);
      box3_btn2.setBorder(new RoundedBorder(12, 10, RoundedBorder.NO_ROUNDED));
      box3_btn2.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(screenWidth/3, 0);
               window.setSize(screenWidth/3, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box3_btn2.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box3_btn2.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box3_btn2.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box3_btn2.setBackground(buttonColorOver);
            } else {
               box3_btn2.setBackground(buttonColorDefault);
            }
         }
      });

      box3_btn3.setPreferredSize(new Dimension(30, 64));
      box3_btn3.setOpaque(false);
      box3_btn3.setFocusable(false);
      box3_btn3.setBackground(buttonColorDefault);
      box3_btn3.setContentAreaFilled(false);
      box3_btn3.setBorder(new RoundedBorder(12, 10, RoundedBorder.RIGHT));
      box3_btn3.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(screenWidth/3*2, 0);
               window.setSize(screenWidth/3, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box3_btn3.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box3_btn3.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box3_btn3.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box3_btn3.setBackground(buttonColorOver);
            } else {
               box3_btn3.setBackground(buttonColorDefault);
            }
         }
      });

      box3.add(box3_btn1);
      box3.add(box3_btn2);
      box3.add(box3_btn3);



      //BOX4 TOP CENTER
      box4.setBackground(transparent);
      box4_right.setBackground(transparent);
      box4_btn1.setOpaque(false);
      box4_btn1.setFocusable(false);
      box4_btn1.setBackground(buttonColorDefault);
      box4_btn1.setContentAreaFilled(false);
      box4_btn1.setBorder(new RoundedBorder(12, 10, RoundedBorder.LEFT));
      box4_btn1.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(0, 0);
               window.setSize(screenWidth/3, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box4_btn1.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box4_btn1.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box4_btn1.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box4_btn1.setBackground(buttonColorOver);
            } else {
               box4_btn1.setBackground(buttonColorDefault);
            }
         }
      });

      box4_btn2.setOpaque(false);
      box4_btn2.setFocusable(false);
      box4_btn2.setBackground(buttonColorDefault);
      box4_btn2.setContentAreaFilled(false);
      box4_btn2.setBorder(new RoundedBorder(12, 10, RoundedBorder.TOP_RIGHT));
      box4_btn2.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(screenWidth/2, 0);
               window.setSize(screenWidth/2, screenHeight/2);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box4_btn2.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box4_btn2.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box4_btn2.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box4_btn2.setBackground(buttonColorOver);
            } else {
               box4_btn2.setBackground(buttonColorDefault);
            }
         }
      });

      box4_btn3.setOpaque(false);
      box4_btn3.setFocusable(false);
      box4_btn3.setBackground(buttonColorDefault);
      box4_btn3.setContentAreaFilled(false);
      box4_btn3.setBorder(new RoundedBorder(12, 10, RoundedBorder.BOTTOM_RIGHT));
      box4_btn3.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(screenWidth/2, screenHeight/2);
               window.setSize(screenWidth/2, screenHeight/2);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box4_btn3.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box4_btn3.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box4_btn3.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box4_btn3.setBackground(buttonColorOver);
            } else {
               box4_btn3.setBackground(buttonColorDefault);
            }
         }
      });

      box4.add(box4_btn1);
      box4.add(box4_right);
      box4_right.add(box4_btn2);
      box4_right.add(box4_btn3);



      //BOX5 TOP LEFT
      box5.setBackground(transparent);
      box5_btn1.setOpaque(false);
      box5_btn1.setFocusable(false);
      box5_btn1.setBackground(buttonColorDefault);
      box5_btn1.setContentAreaFilled(false);
      box5_btn1.setBorder(new RoundedBorder(12, 10, RoundedBorder.TOP_LEFT));
      box5_btn1.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(0, 0);
               window.setSize(screenWidth/2, screenHeight/2);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box5_btn1.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box5_btn1.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box5_btn1.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box5_btn1.setBackground(buttonColorOver);
            } else {
               box5_btn1.setBackground(buttonColorDefault);
            }
         }
      });

      box5_btn2.setOpaque(false);
      box5_btn2.setFocusable(false);
      box5_btn2.setBackground(buttonColorDefault);
      box5_btn2.setContentAreaFilled(false);
      box5_btn2.setBorder(new RoundedBorder(12, 10, RoundedBorder.TOP_RIGHT));
      box5_btn2.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(screenWidth/2, 0);
               window.setSize(screenWidth/2, screenHeight/2);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box5_btn2.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box5_btn2.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box5_btn2.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box5_btn2.setBackground(buttonColorOver);
            } else {
               box5_btn2.setBackground(buttonColorDefault);
            }
         }
      });

      box5_btn3.setOpaque(false);
      box5_btn3.setFocusable(false);
      box5_btn3.setBackground(buttonColorDefault);
      box5_btn3.setContentAreaFilled(false);
      box5_btn3.setBorder(new RoundedBorder(12, 10, RoundedBorder.BOTTOM_LEFT));
      box5_btn3.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(0, screenHeight/2);
               window.setSize(screenWidth/2, screenHeight/2);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box5_btn3.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box5_btn3.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box5_btn3.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box5_btn3.setBackground(buttonColorOver);
            } else {
               box5_btn3.setBackground(buttonColorDefault);
            }
         }
      });

      box5_btn4.setOpaque(false);
      box5_btn4.setFocusable(false);
      box5_btn4.setBackground(buttonColorDefault);
      box5_btn4.setContentAreaFilled(false);
      box5_btn4.setBorder(new RoundedBorder(12, 10, RoundedBorder.BOTTOM_RIGHT));
      box5_btn4.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(screenWidth/2, screenHeight/2);
               window.setSize(screenWidth/2, screenHeight/2);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box5_btn4.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box5_btn4.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box5_btn4.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box5_btn4.setBackground(buttonColorOver);
            } else {
               box5_btn4.setBackground(buttonColorDefault);
            }
         }
      });

      box5.add(box5_btn1);
      box5.add(box5_btn2);
      box5.add(box5_btn3);
      box5.add(box5_btn4);



      //BOX3 TOP CENTER
      box6.setBackground(transparent);
      box6_btn1.setPreferredSize(new Dimension(23, 64));
      box6_btn1.setOpaque(false);
      box6_btn1.setFocusable(false);
      box6_btn1.setBackground(buttonColorDefault);
      box6_btn1.setContentAreaFilled(false);
      box6_btn1.setBorder(new RoundedBorder(12, 10, RoundedBorder.LEFT));
      box6_btn1.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(0, 0);
               window.setSize(screenWidth/4, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box6_btn1.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box6_btn1.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box6_btn1.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box6_btn1.setBackground(buttonColorOver);
            } else {
               box6_btn1.setBackground(buttonColorDefault);
            }
         }
      });

      box6_btn2.setPreferredSize(new Dimension(44, 64));
      box6_btn2.setOpaque(false);
      box6_btn2.setFocusable(false);
      box6_btn2.setBackground(buttonColorDefault);
      box6_btn2.setContentAreaFilled(false);
      box6_btn2.setBorder(new RoundedBorder(12, 10, RoundedBorder.NO_ROUNDED));
      box6_btn2.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(screenWidth/4, 0);
               window.setSize(screenWidth/2, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box6_btn2.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box6_btn2.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box6_btn2.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box6_btn2.setBackground(buttonColorOver);
            } else {
               box6_btn2.setBackground(buttonColorDefault);
            }
         }
      });

      box6_btn3.setPreferredSize(new Dimension(23, 64));
      box6_btn3.setOpaque(false);
      box6_btn3.setFocusable(false);
      box6_btn3.setBackground(buttonColorDefault);
      box6_btn3.setContentAreaFilled(false);
      box6_btn3.setBorder(new RoundedBorder(12, 10, RoundedBorder.RIGHT));
      box6_btn3.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setLocation(screenWidth/4*3, 0);
               window.setSize(screenWidth/4, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               isEasySized = true;
            }
            dialog.setVisible(false);
         }
         boolean over;
         public void mouseExited(MouseEvent e) {
            box6_btn3.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            box6_btn3.setBackground(buttonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            box6_btn3.setBackground(buttonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               box6_btn3.setBackground(buttonColorOver);
            } else {
               box6_btn3.setBackground(buttonColorDefault);
            }
         }
      });

      box6.add(box6_btn1);
      box6.add(Box.createRigidArea(new Dimension(4, 0)));
      box6.add(box6_btn2);
      box6.add(Box.createRigidArea(new Dimension(4, 0)));
      box6.add(box6_btn3);



      //adding boxes to panel
      panel.add(box1);
      panel.add(box2);
      panel.add(box3);
      panel.add(box4);
      panel.add(box5);
      panel.add(box6);



      this.addWindowFocusListener(new WindowFocusListener() {
         public void windowGainedFocus(WindowEvent e) {

         }
         public void windowLostFocus(WindowEvent e) {
            setVisible(false);
         }
      });


      this.add(panel);
      //this.setVisible(true);
   }

   public boolean isEasySized() {
      return isEasySized;
   }
   public void setEasySized(boolean b) {
      isEasySized = b;
   }


}
