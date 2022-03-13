import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {

   static File sizeFile = new File("../data/size.txt");
   static File locationFile = new File("../data/location.txt");
   static File lastSizeFile = new File("../data/lastsize.txt");
   static File easySizedFile = new File("../data/easysized.txt");

   static FileWriter writer;
   static Scanner scanner;
   static boolean opening;


   public static void main(String[] args) throws IOException {

      //main frame
      JFrame window = new JFrame("oq");

      //resiser for borders
      ComponentResizer cr = new ComponentResizer();
      //text panel
      TextPanel textPanel = new TextPanel();
      //top bar
      TopBar topBar = new TopBar(window, textPanel);



      //window SETTINGS
      Dimension minimumSize = new Dimension(200, 200);                          //minimum size
      window.setMinimumSize(minimumSize);
      Dimension defaultSize = new Dimension(500, 500);                          //default size

      //set last settings if they are not null
      scanner = new Scanner(sizeFile);
      if (scanner.hasNextInt()) {
         window.setSize(new Dimension(scanner.nextInt(), scanner.nextInt()-topBar.getHeight()));
      } else {
         window.setMinimumSize(minimumSize);
      }
      scanner = new Scanner(locationFile);
      if (scanner.hasNextInt()) {
         window.setLocation(scanner.nextInt(), scanner.nextInt());
      } else {
         window.setLocation(200, 200);                                       //default location, when it opens
      }
      scanner = new Scanner(easySizedFile);
      if (scanner.hasNextInt()) {
         if (scanner.nextInt() == 1) {
            topBar.setEasySized(true);
         } else {
            topBar.setEasySized(false);
         }
      }


      Toolkit toolkit = Toolkit.getDefaultToolkit();
      Image iconImage = toolkit.getImage("../res/oq-icon.png");
      window.setIconImage(iconImage);

      window.setLayout(new BorderLayout());                                     //layout null
      window.setAlwaysOnTop(true);                                              //!!!!!always on top of the screen
      window.setUndecorated(true);                                              //without windows standard UI
      window.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.01f));



      textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - topBar.getHeight()));
      textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - topBar.getHeight()));
      //when window change size, resize the text area
      opening = true;
      window.addComponentListener(new ComponentAdapter() {
         public void componentResized(ComponentEvent ev) {
            textPanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() - topBar.getHeight()));
            textPanel.setTextAreaPreferredSize(new Dimension(window.getWidth(), window.getHeight() - topBar.getHeight()));
            //save not maximized size
            try {
               if (!topBar.isEasySized()) {
                  writer = new FileWriter(lastSizeFile);
                  writer.write(Integer.toString((int) window.getWidth()) + " " + Integer.toString((int) window.getHeight()));
                  writer.close();
                  topBar.setEasySized(false);
               }
            } catch (IOException ex) {
               ex.printStackTrace();
            }
         }
      });



      //resize window
      cr.registerComponent(window);
      cr.setSnapSize(new Dimension(1, 1));
      cr.setMinimumSize(new Dimension(200, 200));

      //adding topbar to the main frame (window)
      window.add(topBar, BorderLayout.NORTH);
      window.add(textPanel);




      //set frame just visible
      window.pack();
      window.setVisible(true);


      window.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            try {
               //save text
               textPanel.saveText();
               //save size and location settings
               writer = new FileWriter(sizeFile);
               writer.write(Integer.toString(window.getWidth()) + " " + Integer.toString(window.getHeight() - topBar.getHeight()));//every time it adds 27
               writer.close();
               writer = new FileWriter(locationFile);
               writer.write(Integer.toString(window.getLocation().x) + " " + Integer.toString(window.getLocation().y));
               writer.close();
               writer = new FileWriter(easySizedFile);
               if (topBar.isEasySized()) {
                  writer.write("1");
                  writer.close();
               } else {
                  writer.write("0");
                  writer.close();
               }
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            System.exit(0);
         }
      });

   }
}
