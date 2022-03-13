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

   JTextArea textArea = new JTextArea();
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
      while (scanner.hasNextLine()) {
         textArea.append(scanner.nextLine() + "\n");
      }
      writer = new FileWriter(file);

      textArea.setBackground(new Color(0, 0, 0, 0));
      textArea.setForeground(new Color(255, 255, 255));
      textArea.setBorder(new RoundedBorder(10, 16, RoundedBorder.BOTTOM));
      textArea.setOpaque(false);
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      textArea.setTabSize(1);
      textArea.setCaretColor(new Color(255, 255, 255));
      textArea.setSelectedTextColor(new Color(70, 3, 124));
      textArea.setSelectionColor(new Color(80, 80, 80));
      textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

      scrollPane = new JScrollPane(textArea);
      scrollPane.setBackground(new Color(0, 0, 0, 0));
      scrollPane.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
      scrollPane.setBorder(new RoundedBorder(0, 16, RoundedBorder.BOTTOM));
      scrollPane.setOpaque(false);
      scrollPane.getViewport().setOpaque(false);

      scrollPane.getVerticalScrollBar().setBackground(new Color(0, 0, 0, 0));
      scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());

      this.add(scrollPane);


   }

   public void setTextAreaPreferredSize(Dimension dimension) {
      scrollPane.setPreferredSize(dimension);
   }

   public void saveText() throws IOException {
      writer.write(textArea.getText());
      writer.close();
   }

}
