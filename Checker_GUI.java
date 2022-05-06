package Checker_game;

import javax.swing.*;
import java.awt.*;
public class Checker_GUI extends JFrame {
    private final int ROWS = 8;
    private final int COLS = 8;
    private final int GAP = 2;
    private final int NUM = ROWS * COLS;
    private int x;
    private JPanel pnl = new JPanel(new GridLayout(8,8,2,2));
    private JPanel[] pnl1 = new JPanel[NUM];
    private Color clr = Color.WHITE;
    private Color clr2 = Color.BLACK;
    private Color tColor;
    public Checker_GUI() {
        super("Checker Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pnl);
        for(x = 0; x < NUM; ++x) {
            pnl1[x] = new JPanel();
            pnl.add(pnl1[x]);
            if(x % COLS == 0) {
                tColor = clr;
                clr = clr2;
                clr2 = tColor;
            }
            if(x % 2 == 0)
                pnl1[x].setBackground(clr);
            else
                pnl1[x].setBackground(clr2);
        }

        JButton[] player1 = new JButton[12];
        JButton[] player2 = new JButton[12];

        for (int i = 0; i < 12; i++) {
            player1[i] = new JButton();
            player1[i].setBackground(Color.BLUE);
            player2[i] = new JButton();
            player2[i].setBackground(Color.RED);
        }

        for (int i = 0; i < 3; i++)
            if(i % 2 == 0)
                for (int j = 1; j < 8; j+=2)
                pnl1[i].add(player2[i]);
            else
                for (int j = 0; j < 8; j+=2)
                pnl1[i].add(player2[i]);


        for (int i = 5; i < 8; i++)
            if(i % 2 == 0)
                for (int j = 1; j < 8; j += 2)
                    pnl1[i].add(player1[i]);
            else
                for (int j = 0; j < 8; j+=2)
                    pnl1[i].add(player1[i]);



    }
    public static void main(String[] args) {
        Checker_GUI CheckerBoard = new Checker_GUI();
        final int SIZE = 300;
        CheckerBoard.setSize(SIZE, SIZE);
        CheckerBoard.setVisible(true);
    }
}
