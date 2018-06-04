package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame  {

    public Menu(){

        // CONSTRUCTOR
    }

    public void showAboutPage(){


    }

    public void showMenu(){


        // Defining the Layout
        GridLayout gridLayout = new GridLayout(3,3);
        this.setTitle("Sudoku Game");
        boolean check = this.isVisible();
        this.setVisible(true);

        if(check){
            System.out.println("Det window is visible");
        }



        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(gridLayout);

        Color darkBlue = Color.decode("#000080");
        Color darkRed = Color.decode("#800000");
        Color darkMagenta = Color.decode("#8B008B");
        JButton startGame = new JButton();
        startGame.setText("Start game");
        startGame.addActionListener(new NewGame());
        this.add(startGame);

        startGame.setBackground(darkBlue);
        startGame.setForeground(Color.WHITE);
        JButton aboutCreators = new JButton();
        aboutCreators.setText("About Creators");
        aboutCreators.setBackground(darkRed);
        aboutCreators.setForeground(Color.WHITE);
        aboutCreators.addActionListener(new AboutCreators());
        this.add(aboutCreators);

        JButton toggleMusic = new JButton();
        toggleMusic.setText("Toggle music");
        toggleMusic.setBackground(darkMagenta);
        toggleMusic.setForeground(Color.WHITE);
        toggleMusic.addActionListener(new ToggleMusic());
        this.add(toggleMusic);

    }

    // ActionListeners
    class NewGame implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Starting new game");
            MainGame game = new MainGame();
            game.startGame();
            // calling the Sudoku Board and hide the menu
        }
    }
    class AboutCreators implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Show page about the creators
            showAboutPage();

        }
    }
    class ToggleMusic implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Show page about the creators
            System.out.println("Toggling music");
        }
    }
}


