package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameLogic implements ActionListener {

    public JButton [][] buttons = new JButton[9][9];
    public GameLogic(){


        for (int i = 0; i < 9; i ++){
            for (int j = 0; j < 9; j ++ ){
                buttons[i][j] = new JButton("");
                buttons[i][j].putClientProperty("verdi", 0);
                buttons[i][j].putClientProperty("rad", i);
                buttons[i][j].putClientProperty("kolonne", j);
                buttons[i][j].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        Object rad =  btn.getClientProperty("rad");
        Object kolonne =  btn.getClientProperty("kolonne");


        for (int i = 0; i < 9; i ++){
            for (int j = 0; j < 9; j ++ ){

                if (rad == buttons[i][j].getClientProperty("rad") &&
                        kolonne == buttons[i][j].getClientProperty("kolonne")){
                    Object selectedrad = buttons[i][j].getClientProperty("rad");
                    Object selectedkolonne = buttons[i][j].getClientProperty("kolonne");
                    JFrame frame = new JFrame("InputDiaglog Example 1");
                    frame.setSize(300, 300);
                    Integer userNumber = Integer.parseInt(JOptionPane.showInputDialog(frame, "Type in a number"));
                    enterNumber(userNumber, e);

                }
            }
        }
    }
    public void generateNumbersEasy(){
        for (int i = 0; i < 9; i ++){
            for (int j = 0; j < 9; j ++ ){
                Random rg = new Random();
                int tall = rg.nextInt(10);
                String tallet = Integer.toString(tall);
                buttons[i][j].setText(tallet);
                buttons[i][j].putClientProperty("verdi", tall);
            }
        }
        Random rg = new Random();
        int rrange = rg.nextInt(9);
        for (int i = 0; i < rrange; i ++){
            for (int j = 4; j < rrange; j ++ ){
                buttons[i][j].setText("");
                buttons[i][j].putClientProperty("verdi", 0);
            }
        }

    }
    public void enterNumber(Integer num, ActionEvent e ){

        JButton btn = (JButton) e.getSource();
        Object rad =  btn.getClientProperty("rad");
        Object kolonne =  btn.getClientProperty("kolonne");

        for (int i = 0; i < 9; i ++){
            for (int j = 0; j < 9; j ++ ){
                if (rad == buttons[i][j].getClientProperty("rad") &&
                        kolonne == buttons[i][j].getClientProperty("kolonne")){
                    Object selectedrad = buttons[i][j].getClientProperty("rad");
                    Object selectedkolonne = buttons[i][j].getClientProperty("kolonne");
                    buttons[i][j].putClientProperty("value", num);
                    buttons[i][j].setText(Integer.toString(num));
                }
            }
        }
    }
}


