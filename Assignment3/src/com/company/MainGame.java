package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGame extends JFrame implements ActionListener {


    private static final int btnSize = 200;
     public JButton[][] buttons;

    public MainGame() {

    }

    public void InitializeGame() {

        // Check if Mennu is Open
        Menu menu = new Menu();
        menu.showMenu();
    }

    public void startGame() {

        drawGui();
    }

    public void drawGui() {
        this.setTitle("Sudoku");
        this.setVisible(true);
        GridLayout grid = new GridLayout(9, 9);
        this.setLayout(grid);
        this.setSize(800, 800);

        // this.setSize(btnSize*9, (btnSize *9)+100);
        this.setLocationRelativeTo(null);

        // Creating a JmenuBar on top of the bar
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu newGame = new JMenu("New Game");

        JMenuItem Easy = new JMenuItem("Easy");
        Easy.addActionListener(new EasyGame());
        JMenuItem deleteGame = new JMenuItem("Delete Game");
        this.setJMenuBar(menuBar);
        menuBar.add(file);
        file.add(newGame);
        file.add(deleteGame);
        newGame.add(Easy);
    }

    public void drawEasyGame() {
        GameLogic GameData = new GameLogic();

        Font font = new Font("Arial", Font.PLAIN, 20);
        Color white = Color.WHITE;
        buttons = GameData.buttons;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //buttons[i][j].setBounds(j*btnSize, i*btnSize, btnSize, btnSize);
                this.add(buttons[i][j]);
                buttons[i][j].setFont(font);
                buttons[i][j].setBackground(white);
            }
        }
        GameData.generateNumbersEasy();
    }

    public void emptyGame(JButton btn[][] ){
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    class EasyGame implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Show page about the creators
            drawEasyGame();
        }
    }

    class EmptyGame implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Show page about the creators

        }
    }
}
