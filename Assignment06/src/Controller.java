
import javax.swing.*;
import java.awt.event.*;

public class Controller implements ActionListener, WindowListener {
    Model m = new Model();
    View view = new View();

    public Controller() {

        view.Save.addActionListener(this);
        view.Open.addActionListener(this);
        view.Check_Spelling.addActionListener(this);
        view.Exit.addActionListener(this);
        view.Add_word.addActionListener(this);
        view.Layout.addWindowListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.Exit) {
            int result = JOptionPane.showConfirmDialog(null, "Do you want do save before closing?", "Close", JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                m.savefile(view.text());
            } else System.exit(0);

        }
        if (e.getSource() == view.Save) {
            m.savefile(view.text());
        }
        if (e.getSource() == view.Open) {
            JTextPane otherjtp = m.loadfile();
            view.text1.setText(otherjtp.getText());
            view.repaint();
            view.revalidate();
        }
        if (e.getSource() == view.Check_Spelling) {
            JTextPane fixed = m.appendToPane(view.text());
            view.getContentPane().add(fixed);
            view.revalidate();
            view.repaint();
        }
        if (e.getSource() == view.Add_word) {
            String text = JOptionPane.showInputDialog(null, "Write a word: ");
            m.RiktigeOrd.add(text);
        }
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        int result = JOptionPane.showConfirmDialog(null, "Do you want do save before closing?", "Close", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            m.savefile(view.text());
        } else System.exit(0);

    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}

