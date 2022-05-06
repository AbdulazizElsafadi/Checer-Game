package Checker_game;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int pawns1 = 12;
        int pawns2 = 12;

        boolean player1 = true;
        Checker_Game board = new Checker_Game();

        System.out.println("Choose Option \n press 1 for 1 player \n press 2 for 2v2");
        int option = input.nextInt();
        
        while (pawns1 != 0 | pawns2 != 0) {


                if (player1) {
                    System.out.println("Player1 Turn: ");
                    System.out.println("Choose the pawn: ");

                    Node startNode = board.board[input.nextInt()][input.nextInt()];

                    if (startNode.val != 1) {
                        System.out.println("Choose one of your pawns!!");
                        continue;
                    }

                    while (true) {
                        System.out.println("play a move: ");
                        Node newMove;
                        int row1;
                        int col1;
                        try {
                            row1 = input.nextInt();
                            col1 = input.nextInt();
                            newMove = board.board[row1][col1];
                        } catch (RuntimeException e) {
                            newMove = board.board[input.nextInt()][input.nextInt()];
                        }

                        if (board.isKing1(startNode))
                            startNode.king = true;
                        // row1 == 2 && col1 == 5 && row == 4 && col == 3

                        if (board.accessibles_P1(startNode).contains(newMove)) {

                            if (board.opponent(startNode, newMove))
                                pawns2--;

                            int temp_val = startNode.val;
                            boolean temp_king = startNode.king;

                            startNode.val = newMove.val;
                            startNode.king = newMove.king;

                            newMove.val = temp_val;
                            newMove.king = temp_king;

                            board.display();
                            System.out.println("pawns1: " + pawns1);
                            System.out.println("pawns2: " + pawns2);
                            System.out.println("############");

                            player1 = false;
                            break;

                        } else {
                            newMove.king = false;
                            System.out.println("invalid move , try again..");
                        }
                    }
                }

                // player2 turn:

                if (pawns2 == 0)
                    break;


            if (option == 1) {

                double h = board.minimax(0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);

                Node startNode;
                Node newMove;

                outer:
                for (int i = 0; i < board.possible_moves_P2().size(); i++) {
                    startNode = board.possible_moves_P2().get(i);

                    if (h == startNode.hure) {
                        for (int j = 0; j < board.accessibles_P2(startNode).size(); j++) {
                            newMove = board.accessibles_P2(startNode).get(j);
                            if (h == newMove.hure) {

                                if (board.isKing2(startNode))
                                    startNode.king = true;

                                if (board.opponent(startNode, newMove))
                                    pawns1--;

                                int temp_val = startNode.val;
                                boolean temp_king = startNode.king;

                                startNode.val = newMove.val;
                                startNode.king = newMove.king;

                                newMove.val = temp_val;
                                newMove.king = temp_king;

                                board.display();
                                System.out.println("pawns1: " + pawns1);
                                System.out.println("pawns2: " + pawns2);
                                System.out.println("Player 2");
                                System.out.println("############");

                                player1 = true;
                                break outer;
                            }

                        }
                    }
                }

            } else if (option == 2) {

                System.out.println("Player2 Turn: ");
                System.out.println("Choose the pawn: ");
                int row = input.nextInt();
                int col = input.nextInt();
                Node startNode = board.board[row][col];


                if(startNode.val != 2) {
                System.out.println("Choose one of your pawns!!");
                continue;
                }

                while (true) {
                System.out.println("play a move: ");
                int row1 = input.nextInt();
                int col1 = input.nextInt();
                Node newMove = board.board[row1][col1];

                if (board.isKing2(startNode))
                startNode.king = true;

                if(board.accessibles_P2(startNode).contains(newMove)) {

                if(board.opponent(startNode , newMove))
                pawns1--;


                int temp_val = startNode.val;
                boolean temp_king = startNode.king;

                startNode.val = newMove.val;
                startNode.king = newMove.king;

                newMove.val = temp_val;
                newMove.king = temp_king;

                board.display();
                System.out.println(pawns1);
                System.out.println(pawns2);

                player1 = true;
                break;

                } else {
                newMove.king = false;
                System.out.println("invalid move , try again..");
                }
                }

                    }


        }

        if (pawns1 == 0)
            System.out.println("Player2 wins");
        if (pawns2 == 0)
            System.out.println("Player1 wins");
    }

   }




