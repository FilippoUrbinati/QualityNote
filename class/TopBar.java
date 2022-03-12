import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.FontFormatException;


public class TopBar extends JPanel {

   JButton exit = new JButton();
   JButton scaleUp = new JButton();
   JButton minimize = new JButton();
   JButton textSettingButton = new JButton();//bella pe te ci vediamo la prossima volta che non so quando sarà

   SizingDialog sizingDialog;
   Dimension lastSize = new Dimension();                                        //to return the window to the last size
   Point lastLocation = new Point();                                            //to return the window to the last location
   static Point compCoords;

   static File lastSizeFile = new File("../data/lastsize.txt");
   static Scanner scanner;
   static boolean isEasySized;                                                  //used to check if window is sized with macros or not

   int screenWidth = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
   int screenHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;

   Font font;

   public TopBar(JFrame window, TextPanel textPanel) throws IOException {

      this.setLayout(new BorderLayout());

      //panel SETTINGS
      Color panelColor = new Color(70, 3, 124);
      Color panelColorNotFocused = new Color(43, 43, 43);
      this.setPreferredSize(new Dimension(window.getWidth(), 27));              //set size
      this.setBackground(panelColor);                                           //set color
      this.setOpaque(false);
      this.setDoubleBuffered(true);
      this.setBorder(new RoundedBorder(0, 16, RoundedBorder.TOP));             //set rounded border
      this.setVisible(true);                                                    //show

      sizingDialog = new SizingDialog(window, textPanel);

      //EXIT BUTTON SETTINGS
      //colors
      Color buttonColorDefault = this.getBackground();
      Color exitButtonColorOver = new Color(255, 0, 0);
      Color exitButtonColorClick = new Color(200, 0, 0);
      Color panelButtonsColorBorder = new Color(110, 110, 110, 110);
      //settings
      exit.setPreferredSize(new Dimension(23, 23));
      exit.setBackground(buttonColorDefault);                               //defaul color
      exit.setBorderPainted(true);                                              //left border
      exit.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, panelButtonsColorBorder));
      exit.setContentAreaFilled(false);
      exit.setOpaque(true);
      exit.setFocusable(false);
      //button funcion & color
      exit.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               //close window, windowListener is triggered in main class
               Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
            }
         }
         //color settings
         boolean over;
         public void mouseExited(MouseEvent e) {
            exit.setBackground(buttonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            exit.setBackground(exitButtonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            exit.setBackground(exitButtonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               exit.setBackground(exitButtonColorOver);
            } else {
               exit.setBackground(buttonColorDefault);
            }
         }
      });



      //SCALE UP BUTTON SETTINGS
      //colors
      Color topbarButtonColorDefault = this.getBackground();
      Color topbarUpButtonColorOver = new Color(50, 50, 50);
      Color topbarUpButtonColorClick = new Color(65, 65, 65);
      //settings
      scaleUp.setPreferredSize(new Dimension(23, 23));
      scaleUp.setBackground(buttonColorDefault);                            //defaul color
      scaleUp.setBorderPainted(true);                                           //left border
      scaleUp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, panelButtonsColorBorder));
      scaleUp.setContentAreaFilled(false);
      scaleUp.setOpaque(true);
      scaleUp.setFocusable(false);
      //button funcion & color
      scaleUp.addMouseListener(new MouseAdapter() {

         //button function
         public void mouseClicked(MouseEvent e) {

            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               if (window.getSize() != new Dimension(screenWidth, screenHeight)) {
                  isEasySized = true;
                  window.setLocation(0, 0);
                  window.setSize(screenWidth, screenHeight);
                  lastLocation.setLocation(window.getLocation());
                  textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
                  textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               } else {
                  try {scanner=new Scanner(lastSizeFile);}catch(IOException ex){ex.printStackTrace();}
                  window.setSize(scanner.nextInt(), scanner.nextInt());         //set last size
                  if (lastLocation.y < 0) {                                     //when window is dragged on top, it could go to y < 0
                     lastLocation.y = 0;                                        //so relocate it at y = 0
                  }
                  window.setLocation(lastLocation);                          //set last location
                  //resize textArea
                  textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
                  textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               }
            }
         }
         //color settings
         boolean over;
         public void mouseExited(MouseEvent e) {
            scaleUp.setBackground(topbarButtonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            scaleUp.setBackground(topbarUpButtonColorOver);
            over = true;

            int sizingDialogX = scaleUp.getLocationOnScreen().x + (scaleUp.getWidth()/2) - (sizingDialog.getWidth()/2);
            int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            //if there's no space, set max location on right
            if (sizingDialogX + sizingDialog.getWidth() > screenWidth) {
               sizingDialogX = screenWidth - sizingDialog.getWidth() - 1;
            }
            int sizingDialogY = scaleUp.getLocationOnScreen().y + scaleUp.getHeight() + 3;
            sizingDialog.setLocation(sizingDialogX, sizingDialogY);

            //after 750ms if the mouse is still over the button it shows the dialog
            new java.util.Timer().schedule(new java.util.TimerTask() {
               @Override
               public void run() {
                  if(over) {
                     sizingDialog.setVisible(true);
                  }
               }
            }, 750);
         }
         public void mousePressed(MouseEvent e) {
            scaleUp.setBackground(topbarUpButtonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               scaleUp.setBackground(topbarUpButtonColorOver);
            } else {
               scaleUp.setBackground(topbarButtonColorDefault);
            }
         }
      });



      //MINIMIZE BUTTON SETTINGS
      //settings
      minimize.setPreferredSize(new Dimension(23, 23));
      minimize.setBackground(buttonColorDefault);                            //defaul color
      minimize.setBorderPainted(true);                                           //left border
      minimize.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, panelButtonsColorBorder));
      minimize.setContentAreaFilled(false);
      minimize.setOpaque(true);
      minimize.setFocusable(false);
      //button funcion & color
      minimize.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               window.setState(Frame.ICONIFIED);
            }
         }
         //color settings
         boolean over;
         public void mouseExited(MouseEvent e) {
            minimize.setBackground(topbarButtonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            minimize.setBackground(topbarUpButtonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            minimize.setBackground(topbarUpButtonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               minimize.setBackground(topbarUpButtonColorOver);
            } else {
               minimize.setBackground(topbarButtonColorDefault);
            }
         }
      });






      //TEXT SETTINGS BUTTON SETTINGS
      //settings
      textSettingButton.setPreferredSize(new Dimension(18, 18));
      textSettingButton.setBackground(buttonColorDefault);                            //defaul color
      textSettingButton.setBorderPainted(true);                                           //left border
      textSettingButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, panelButtonsColorBorder));
      textSettingButton.setContentAreaFilled(false);
      textSettingButton.setOpaque(true);
      textSettingButton.setFocusable(false);
      //button funcion & color
      textSettingButton.addMouseListener(new MouseAdapter() {
         //button function
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {

            }
         }
         //color settings
         boolean over;
         public void mouseExited(MouseEvent e) {
            textSettingButton.setBackground(topbarButtonColorDefault);
            over = false;
         }
         public void mouseEntered(MouseEvent e) {
            textSettingButton.setBackground(topbarUpButtonColorOver);
            over = true;
         }
         public void mousePressed(MouseEvent e) {
            textSettingButton.setBackground(topbarUpButtonColorClick);
         }
         public void mouseReleased(MouseEvent e) {
            if (over) {
               textSettingButton.setBackground(topbarUpButtonColorOver);
            } else {
               textSettingButton.setBackground(topbarButtonColorDefault);
            }
         }
      });



      //adding the left container to the panel
      JPanel leftContainer = new JPanel();
      leftContainer.setBackground(new Color(0, 0, 0, 0));
      leftContainer.setAlignmentY(Component.CENTER_ALIGNMENT);
      //IMPORTANT, the last is on the right
      leftContainer.add(textSettingButton);
      this.add(leftContainer, BorderLayout.WEST);

      JPanel rightContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 1, 2));
      rightContainer.setBackground(new Color(0, 0, 0, 0));
      //IMPORTANT, the last is on the right
      rightContainer.add(minimize);
      rightContainer.add(scaleUp);
      rightContainer.add(exit);
      rightContainer.add(Box.createRigidArea(new Dimension(3, 0)));
      //adding the right container to the panel
      this.add(rightContainer, BorderLayout.EAST);

      //adding some space at the end
      this.add(Box.createRigidArea(new Dimension(3, 0)));



      //move the window from the titlebar
      compCoords = null;
      this.addMouseListener(new MouseListener() {
         public void mouseReleased(MouseEvent e) {
            compCoords = null;
            lastLocation.setLocation(window.getLocation());                     //store last location
            if (e.getLocationOnScreen().y == 0) {
               isEasySized = true;
               window.setLocation(0, 0);
               window.setSize(screenWidth, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
            } else if (e.getLocationOnScreen().x == 0) {
               isEasySized = true;
               window.setLocation(0, 0);
               window.setSize(screenWidth/2, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
            } else if (e.getLocationOnScreen().x == screenWidth-1) {
               isEasySized = true;
               window.setLocation(screenWidth/2, 0);
               window.setSize(screenWidth/2, screenHeight);
               //resize textArea
               textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
               textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
            } else {
               isEasySized = false;
               sizingDialog.setEasySized(false);
            }

         }
         public void mousePressed(MouseEvent e) {
            compCoords = e.getPoint();
         }
         public void mouseExited(MouseEvent e) {
         }
         public void mouseEntered(MouseEvent e) {
         }
         public void mouseClicked(MouseEvent e) {
         }
      });
      this.addMouseMotionListener(new MouseMotionListener() {
         public void mouseMoved(MouseEvent e) {
         }
         public void mouseDragged(MouseEvent e) {
            Point currCoords;
            //if it is maximized --> change size and bring it to the mouse location
            currCoords = e.getLocationOnScreen();
            if (isEasySized || sizingDialog.isEasySized()) {
               try {scanner=new Scanner(lastSizeFile);}catch(IOException ex){ex.printStackTrace();}
               window.setSize(scanner.nextInt(), scanner.nextInt());            //set last size
               window.setLocation(currCoords.x - getWidth()/2, currCoords.y - getHeight()/2);
            } else {
               window.setLocation(currCoords.x - compCoords.x, currCoords.y - compCoords.y);
            }
            //resize textArea
            textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));
            textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - 27));

         }
      });



      //change topbar (panel) color when it is not focused
      window.addWindowFocusListener(new WindowFocusListener() {
         public void windowGainedFocus(WindowEvent e) {
            setBackground(panelColor);
            getRootPane().setBorder(new RoundedBorder(1, 16, RoundedBorder.ALL_NO_FILLED));
         }
         public void windowLostFocus(WindowEvent e) {
            setBackground(panelColorNotFocused);
            getRootPane().setBorder(new RoundedBorder(1, 16, RoundedBorder.ALL_NO_FILLED));
         }
      });



   }

   public boolean isEasySized() {
      if (isEasySized || sizingDialog.isEasySized()) {
         return true;
      } else {
         return false;
      }
   }
   public void setEasySized(boolean b) {
      isEasySized = b;
      sizingDialog.setEasySized(b);
   }

}
