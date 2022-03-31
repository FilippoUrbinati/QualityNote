import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



public class TextPanel extends JPanel {

   JTextPane textPane = new JTextPane();
   JScrollPane scrollPane;

   File file = new File("../data/text.txt");
   FileWriter writer;


   public TextPanel() throws IOException {

      this.setBackground(new Color(51, 51, 51));
      this.setOpaque(false);
      this.setDoubleBuffered(true);
      this.setBorder(new RoundedBorder(0, 16, RoundedBorder.BOTTOM));
      this.setVisible(true);

      Scanner scanner = new Scanner(file);
      /*while (scanner.hasNextLine()) {
         textPane.append(scanner.nextLine() + "\n");
      }*/
      writer = new FileWriter(file);

      textPane.setBackground(new Color(0, 0, 0, 0));
      textPane.setForeground(new Color(255, 255, 255));
      textPane.setBorder(new RoundedBorder(10, 16, RoundedBorder.BOTTOM));
      textPane.setOpaque(false);
      textPane.setCaretColor(new Color(255, 255, 255));
      textPane.setSelectedTextColor(new Color(70, 3, 124));
      textPane.setSelectionColor(new Color(80, 80, 80));
      textPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

      scrollPane = new JScrollPane(textPane);
      scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setBackground(new Color(0, 0, 0, 0));
      scrollPane.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
      scrollPane.setBorder(new RoundedBorder(0, 16, RoundedBorder.BOTTOM));
      scrollPane.setOpaque(false);
      scrollPane.getViewport().setOpaque(false);
      //scroll bar
      scrollPane.getVerticalScrollBar().setBackground(new Color(0, 0, 0, 0));
      scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());

      this.add(scrollPane);


   }

   public void setTextPanePreferredSize(Dimension dimension) {
      textPane.setPreferredSize(dimension);
      scrollPane.setPreferredSize(dimension);
   }

   public void saveText() throws IOException {
      writer.write(textPane.getText());
      writer.flush();
      writer.close();
   }

   public void setSelectedText(int fontStyle) {
      //textPane.getSelectedText().setFont("Comic Sans MS", fontStyle, 18);
   }

}
