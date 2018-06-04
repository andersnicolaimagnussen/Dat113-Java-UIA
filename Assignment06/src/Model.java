import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Model {
    public ArrayList<String> RiktigeOrd= new ArrayList<>();

    public JFileChooser fileChooser;



    public Model(){
        fileChooser= new JFileChooser();
        try {
            BufferedReader br= new BufferedReader(new FileReader("ordliste.txt"));
            while(br.readLine()!=null){
                RiktigeOrd.add(br.readLine());
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public JTextPane loadfile() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        JTextPane jtp = new JTextPane();

        try {
            BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile()));
            String string;
            while ((string = br.readLine()) != null) {
                jtp.setText(jtp.getText() + string + "");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jtp;
    }

    public void savefile(JTextPane tp) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);

        try {
            FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(tp.getText());
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public JTextPane appendToPane(JTextPane tp) {

        String text = tp.getText();
        String[] words = text.split("[ !?.,]");
        tp.setText("");

        StyledDocument doc = tp.getStyledDocument();
        Style style = tp.addStyle("style", null);

        for (int i = 0; i < words.length; i++) {
            if (!RiktigeOrd.contains(words[i])) {
                StyleConstants.setForeground(style, Color.RED);

                try {
                    doc.insertString(doc.getLength(), words[i]+" ",style);
                }catch(BadLocationException e ){}
            } else {
                StyleConstants.setForeground(style, Color.BLACK);

                try {
                    doc.insertString(doc.getLength(), words[i]+" ",style);
                }catch(BadLocationException e ){}
            }
        }


        return tp; }
}



