package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGame extends JFrame implements ActionListener {


    public MainGame(){

        InitializeGame();
    }

    public void InitializeGame(){

        // Check if Mennu is Open
        Menu menu = new Menu();
        menu.showMenu();
    }

    public void startGame(){

        drawGui();
    }

    public void drawGui(){
        this.setTitle("Sudoku");
        GridLayout gridLayout = new GridLayout(9,9);
        this.setVisible(true);
        this.setLayout(gridLayout);
        this.setSize(1500, 1000);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
