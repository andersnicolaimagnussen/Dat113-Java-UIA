import javax.swing.*;
import java.awt.*;




public class View extends JFrame  {
    public JMenu File; //Hovedmeny
    public JMenuItem Save, Open, Check_Spelling, Add_word, Exit;//undermeny
    public JTextPane text1= new JTextPane();
    public JFrame Layout= new JFrame("Text Editor");

    public JTextPane text(){
        return this.text1;
    }


    public View(){
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setSize(600, 600);
        JMenuBar menybar= new JMenuBar();
        File= new JMenu("File");
        Save= new JMenuItem("Save");
        Open= new JMenuItem("Open");
        Check_Spelling= new JMenuItem("Check spelling");
        Add_word= new JMenuItem("Add word");
        Exit= new JMenuItem("Exit");

        File.add(Save);

        File.add(Open);

        File.add(Check_Spelling);

        File.add(Add_word);

        File.add(Exit);
        menybar.add(File);

        this.setJMenuBar(menybar);

        this.setVisible(true);
        //this.setDefaultCloseOperation();
        this.add(text1);


    }
}
