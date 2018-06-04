package Views;

import Service.Service;
import ViewModel.TwitterViewModel;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui extends JFrame implements ActionListener {
    //private TwitterViewModel viewModel;
    private JTextArea textArea;
    private JTextArea textArea2;
    private JButton btn;
    private JTextField inputField;
    private JLabel text;
    private String captureText;

    public Gui() throws TwitterException {
        drawInterface();
        connectService();
    }

    public void drawInterface() {
        FlowLayout flow = new FlowLayout();
        textArea = new JTextArea(20, 40);

        textArea2 = new JTextArea();
        this.setTitle("Twitter");
        this.setLayout(flow);
        setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btn = new JButton();
        btn.setText("Click on me");
        textArea.setBounds(0,0, 200, 200);
        textArea.setBackground(Color.LIGHT_GRAY);

        btn.addActionListener(this);
        this.setVisible(true);
        this.add(textArea);
        this.add(textArea2);
        this.add(btn);

    }

    public void connectService() throws TwitterException {
        Service service = new Service();
        //viewModel.getTweetList();

        for (Status s : TwitterViewModel.getTweetList()) {
            textArea.append(s.getText() + "\n");

        }

        for (Status s : TwitterViewModel.getTweetList()){
            JOptionPane.showMessageDialog(null,s.getText());
        }

        captureText = textArea.getText();
        JOptionPane.showMessageDialog(null, captureText.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btn)){

        }
    }
}
