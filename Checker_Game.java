package Checker_game;

import javax.swing.*;
import java.util.ArrayList;

public class Checker_Game {

Node[][] board = new Node[8][8];

    public Checker_Game() {

    // initialization of board
    for (int i = 0; i < 8; i++)
        for (int j = 0; j < 8; j++)
            board[i][j] = new Node(i,j);

    // Setting the players on the board

    // first player:
    for (int i = 0; i < 3; i++)
        if(i % 2 == 0)
            for (int j = 1; j < 8; j+=2)
                board[i][j].val = 2;
        else
            for (int j = 0; j < 8; j+=2)
                board[i][j].val = 2;

    // Second player:
    for (int i = 5; i < 8; i++)
        if(i % 2 == 0)
            for (int j = 1; j < 8; j += 2)
                board[i][j].val= 1;
        else
            for (int j = 0; j < 8; j+=2)
                board[i][j].val= 1;
}

    public ArrayList<Node> accessibles_P2(Node p) {

        // storing successors of p.
        ArrayList<Node> successors = new ArrayList<>();

        // check if p is a king
        if(p.king) {

            // check for backward successors
            if(p.row-1 != -1 && p.col+1 != 8) {

                // case1: if the diagonal cell is empty.
                // checking if right diagonal is empty.
                if (board[p.row - 1][p.col + 1].val == 0)
                    successors.add(board[p.row - 1][p.col + 1]);

                // case2: if the diagonal cell contains an opponent's checker
                // Check if the right diagonal behind the opponent is valid (in the board)
                // and it is empty
                if (board[p.row - 1][p.col + 1].val == 1 && p.row - 2 != -1 && p.col + 2 != 8 && board[p.row - 2][p.col + 2].val == 0)
                    successors.add(board[p.row - 2][p.col + 2]);
            }
             if(p.col-1 != -1 && p.row-1 != -1) {

                    // checking if left diagonal is empty.
                    if (board[p.row-1][p.col-1].val == 0)
                        successors.add(board[p.row-1][p.col-1]);

                    // check if the left diagonal behind the opponent is valid(in the board)
                    // and it is empty
                    if (board[p.row-1][p.col-1].val == 1 && p.row-2 != -1 && p.col-2 != -1 && board[p.row-2][p.col-2].val == 0)
                        successors.add(board[p.row-2][p.col-2]);
                }

        }

        // Check for forward successors
        if(p.row+1 != 8 && p.col+1 != 8) {

            // case1: if the diagonal cell is empty.
                // checking if right diagonal is empty.
            if (board[p.row+1][p.col+1].val == 0)
                successors.add(board[p.row+1][p.col+1]);

            // case2: if the diagonal cell contains an opponent's checker
            // Check if the right diagonal behind the opponent is valid (in the board)
            // and it is empty
            if (board[p.row+1][p.col+1].val == 1 && p.row+2 != 8 && p.col+2 != 8 && board[p.row+2][p.col+2].val == 0)
                    successors.add(board[p.row+2][p.col+2]);

        }

         if (p.col-1 != -1 && p.row+1 != 8) {

            // checking if left diagonal is empty.
            if (board[p.row+1][p.col-1].val == 0)
                successors.add(board[p.row+1][p.col-1]);


            // check if the left diagonal behind the opponent is valid(in the board)
            // and it is empty
            if (board[p.row+1][p.col-1].val == 1 && p.row+2 != 8 && p.col-2 != -1 && board[p.row+2][p.col-2].val == 0)
                successors.add(board[p.row+2][p.col-2]);
        }

          return successors;
    }

    public ArrayList<Node> accessibles_P1(Node p) {

        // storing successors of p.
        ArrayList<Node> successors = new ArrayList<>();

        // check if p is a king
        if(p.king) {

            // check for backward successors:
            // checking that the moves are valid
            if(p.row+1 != 8 && p.col+1 != 8) {

                // case1: if the diagonal cell is empty.
                // checking if right diagonal is empty.
                if (board[p.row+1][p.col+1].val == 0)
                    successors.add(board[p.row+1][p.col+1]);

                // case2: if the diagonal cell contains an opponent's checker
                // Check if the right diagonal behind the opponent is valid (in the board)
                // and it is empty
                if (board[p.row+1][p.col+1].val == 2 && p.row+2 != 8 && p.col+2 != 8 && board[p.row+2][p.col+2].val == 0)
                    successors.add(board[p.row+2][p.col+2]);
            }

             if (p.col-1 != -1 && p.row+1 != 8) {

                // checking if left diagonal is empty.
                if (board[p.row+1][p.col-1].val == 0)
                    successors.add(board[p.row+1][p.col-1]);


                // check if the left diagonal behind the opponent is valid(in the board)
                // and it is empty
                if (board[p.row+1][p.col-1].val == 2 && p.row+2 != 8 && p.col-2 != -1 && board[p.row+2][p.col-2].val == 0)
                    successors.add(board[p.row+2][p.col-2]);
            }
        }

        // Check for forward successors
        if(p.row-1 != -1 && p.col+1 != 8) {

            // case1: if the diagonal cell is empty.
            // checking if right diagonal is empty.
            if (board[p.row-1][p.col+1].val == 0)
                successors.add(board[p.row-1][p.col+1]);

            // case2: if the diagonal cell contains an opponent's checker
            // Check if the right diagonal behind the opponent is valid (in the board)
            // and it is empty
            if (board[p.row-1][p.col+1].val == 2 && p.row-2 != -1 && p.col+2 != 8 && board[p.row-2][p.col+2].val == 0)
                successors.add(board[p.row-2][p.col+2]);
        }

         if (p.col-1 != -1 && p.row-1 != -1) {

            // checking if left diagonal is empty.
            if (board[p.row-1][p.col-1].val == 0)
                successors.add(board[p.row-1][p.col-1]);

            // check if the left diagonal behind the opponent is valid(in the board)
            // and it is empty
            if (board[p.row-1][p.col-1].val == 2 && p.row-2 != -1 && p.col-2 != -1 && board[p.row-2][p.col-2].val == 0)
                successors.add(board[p.row-2][p.col-2]);
        }

        return successors;
    }

    public void display() {
        System.out.println("  -----------------");
        System.out.println("   0 1 2 3 4 5 6 7");
        System.out.println("  -----------------");
        int count = 0;
        for (Node[] nodes : board) {
            for (int j = 0; j < board.length; j++) {
                if (j == 0) {
                    System.out.print(count + "| ");
                }
                System.out.print(nodes[j].val + " ");

            }
            count++;
            System.out.println();
        }
    }

    public double h() {

        // Index 0: Number of pawns
        // Index 1: Number of kings
        // Index 2: Number that can be taken this turn
        // Index 3: Number that are protected

        int[] p1nums = new int[4];
        int[] p2nums = new int[4];

        for (Node[] nodes : board) {
            for (int j = 0; j < board.length; j++) {

                int row = nodes[j].row;
                int col = nodes[j].col;


                    if (isPlayer(nodes[j]) == 1) {

                        // number of pawns
                        if (!nodes[j].king)
                            p1nums[0]++;

                            // number of kings
                        else p1nums[1]++;

                        // Number that can be taken this turn

                        if (row > 0) {
                            if (col > 0 && col < 7) {
                                if (board[row - 1][row - 1] != null &&
                                        board[col - 1][col - 1].val == 2
                                        && board[row + 1][col + 1] == null) {
                                    p1nums[2]++;
                                }
                                if(row+1 != board.length)
                                if (board[row - 1][col + 1] != null &&
                                        board[row - 1][col + 1].val == 2
                                        && board[row + 1][col - 1] == null) {
                                    p1nums[2]++;
                                }
                            }
                        }

                        // Number that are protected
                        if (row < 7) {
                            if (col == 0 || col == 7) {
                                p1nums[3]++;
                            } else {
                                if ((board[row + 1][col - 1] != null &&
                                        (board[row + 1][col - 1].val == 1 ||
                                                !board[row + 1][col - 1].king)) &&
                                        (board[row + 1][col + 1] != null &&
                                                (board[row + 1][col + 1].val == 1 ||
                                                        !board[row + 1][col + 1].king))) {
                                    p1nums[3]++;
                                }
                            }
                        }

                    }

                    if (isPlayer(nodes[j]) == 2) {
                        // Check for pawns
                        if (!nodes[j].king) {
                            p2nums[0]++;
                        }

                        // Check for king
                        else {
                            p2nums[1]++;
                        }

                        // Check if can be taken this turn
                        if (row < 7) {

                            if (col > 0 && col < 7) {
                                if(row - 1 !=  -1)
                                if (board[row + 1][col - 1] != null &&
                                        board[row + 1][col - 1].val == 1
                                        && board[row - 1][col + 1] == null) {
                                    p2nums[2]++;
                                }
                                if(row -1 != -1)
                                if (board[row + 1][col + 1] != null &&
                                        board[row + 1][col + 1].val == 1
                                        && board[row - 1][col - 1] == null) {
                                    p2nums[2]++;
                                }
                            }
                        }

                        // Check for protected checkers
                        if (row > 0) {
                            if (col == 0 || col == 7) {
                                p2nums[3]++;
                            } else {
                                if ((board[row - 1][col - 1] != null &&
                                        (board[row - 1][col - 1].val == 2 ||
                                                !board[row - 1][col - 1].king)) &&
                                        (board[row - 1][col + 1] != null &&
                                                (board[row - 1][col + 1].val == 2 ||
                                                        !board[row - 1][col + 1].king))) {
                                    p2nums[3]++;
                                }
                            }
                        }
                    }
                }
        }
        
        // Debugging:
        System.out.println("Board in Heuristic:");
        display();

        // the difference between heuristic of player1 & player2
        for (int i = 0; i < p1nums.length; i++)
            p2nums[i] = (p2nums[i] - p1nums[i]);

        double sum = 0.0;

        for (int heuristicNum : p2nums)
            sum += heuristicNum;

        return sum;
    }

    public int isPlayer(Node p){
        return p.val;
    }

    public boolean isKing1(Node p) {
        return p.row == 0;
    }

    public boolean isKing2(Node p) {
        return p.row == 7;
    }

    public boolean opponent(Node oldMove , Node newMove) {

        // checking player1 (forward right move) or king of player2 (backward right move)
        if((oldMove.row-2 == newMove.row && oldMove.col+2 == newMove.col)) {
            if (accessibles_P1(oldMove).contains(newMove) || (oldMove.king && accessibles_P2(oldMove).contains(newMove))) {
                board[oldMove.row - 1][oldMove.col + 1].val = 0;
                return true;
            }
        }

        // checking player1 (forward left move) or king of player2 (backward left move)
        else if (oldMove.row-2 == newMove.row && oldMove.col-2 == newMove.col) {
            if (accessibles_P1(oldMove).contains(newMove) || (oldMove.king && accessibles_P2(oldMove).contains(newMove))) {
                board[oldMove.row - 1][oldMove.col - 1].val = 0;
                return true;
            }
        }

        // checking player2 (forward right move) or king of player1 (backward right move)
       else if((oldMove.row+2 == newMove.row && oldMove.col+2 == newMove.col)) {
            if (accessibles_P2(oldMove).contains(newMove) || (oldMove.king && accessibles_P1(oldMove).contains(newMove))) {
                board[oldMove.row + 1][oldMove.col + 1].val = 0;
                return true;
            }
        }

        // checking player2 (forward left move) or king of player2 (backward left move)
       else if (oldMove.row+2 == newMove.row && oldMove.col-2 == newMove.col ) {
            if (accessibles_P2(oldMove).contains(newMove) || (oldMove.king && accessibles_P1(oldMove).contains(newMove))) {
                board[oldMove.row + 1][oldMove.col - 1].val = 0;
                return true;
            }
        }

        return false;
    }

    public boolean reverse_opponent(Node oldMove , Node newMove) {

        // checking player1 (forward right move) or king of player2 (backward right move)
        if((oldMove.row-2 == newMove.row && oldMove.col+2 == newMove.col)) {
            if (accessibles_P1(oldMove).contains(newMove) || (oldMove.king && accessibles_P2(oldMove).contains(newMove))) {
                if(oldMove.king)
                board[oldMove.row - 1][oldMove.col + 1].val = 1;

                else board[oldMove.row - 1][oldMove.col + 1].val = 2;
                return true;
            }
        }

        // checking player1 (forward left move) or king of player2 (backward left move)
         if (oldMove.row-2 == newMove.row && oldMove.col-2 == newMove.col) {
            if (accessibles_P1(oldMove).contains(newMove) || (oldMove.king && accessibles_P2(oldMove).contains(newMove))) {
                if(oldMove.king)
                    board[oldMove.row - 1][oldMove.col + 1].val = 1;

                else board[oldMove.row - 1][oldMove.col + 1].val = 2;
                return true;
            }
        }

        // checking player2 (forward right move) or king of player1 (backward right move)
         if((oldMove.row+2 == newMove.row && oldMove.col+2 == newMove.col)) {
            if (accessibles_P2(oldMove).contains(newMove) || (oldMove.king && accessibles_P1(oldMove).contains(newMove))) {
                if(oldMove.king)
                    board[oldMove.row - 1][oldMove.col + 1].val = 2;

                else board[oldMove.row - 1][oldMove.col + 1].val = 1;
                return true;
            }
        }

        // checking player2 (forward left move) or king of player2 (backward left move)
         if (oldMove.row+2 == newMove.row && oldMove.col-2 == newMove.col ) {
            if (accessibles_P2(oldMove).contains(newMove) || (oldMove.king && accessibles_P1(oldMove).contains(newMove))) {
                if(oldMove.king)
                    board[oldMove.row - 1][oldMove.col + 1].val = 2;

                else board[oldMove.row - 1][oldMove.col + 1].val = 1;
                return true;
            }
        }

        return false;
    }

    public ArrayList<Node> possible_moves_P1() {

        ArrayList<Node> possible_moves_P1 = new ArrayList<>();

            for (Node[] nodes : board)
                for (int j = 0; j < board.length; j++)
                     if(nodes[j].val == 1 && !accessibles_P1(nodes[j]).isEmpty())
                        possible_moves_P1.add(nodes[j]);

        return possible_moves_P1;
    }

    public ArrayList<Node> possible_moves_P2() {

        ArrayList<Node> possible_moves_P2 = new ArrayList<>();

        for (Node[] nodes : board)
            for (int j = 0; j < board.length; j++)
                if(nodes[j].val == 2 && !accessibles_P2(nodes[j]).isEmpty())
                    possible_moves_P2.add(nodes[j]);

        return possible_moves_P2;
    }

    public double minimax(int depth, Boolean maximizingPlayer, int alpha, int beta) {

        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        // Terminating condition. i.e
        // leaf node is reached

        if (depth == 1)
            return h();

        if (maximizingPlayer) {
            double best = MIN;

            for (int i = 0; i < possible_moves_P2().size(); i++) {

                for (int j = 0; j < accessibles_P2(possible_moves_P2().get(i)).size(); j++) {

                    Node startNode = possible_moves_P2().get(i);
                    Node newMove = accessibles_P2(startNode).get(j);

                    if (isKing2(startNode))
                        startNode.king = true;

                    opponent(startNode,newMove);

                    int temp_val = startNode.val;
                    boolean temp_king = startNode.king;

                    startNode.val = newMove.val;
                    startNode.king = newMove.king;

                    newMove.val = temp_val;
                    newMove.king = temp_king;



                   // Debugging
//                    display();
//                    System.out.println("depth : " + depth);
//                    System.out.println("score : " + h());


                    double val = minimax(depth + 1, false, alpha, beta);

                    if (isKing2(newMove))
                        newMove.king = false;

                    temp_val = newMove.val;
                    temp_king = newMove.king;

                    newMove.val = startNode.val;
                    newMove.king = startNode.king;

                    startNode.val = temp_val;
                    startNode.king = temp_king;

                    // when startNode was already a king
                    if(isKing2(startNode))
                        startNode.king = true;

                    if(startNode.row + 2 == newMove.row && startNode.col + 2 == newMove.col)
                        board[startNode.row+1][startNode.col+1].val = 1;

                    else if(startNode.row + 2 == newMove.row && startNode.col - 2 == newMove.col)
                        board[startNode.row+1][startNode.col-1].val = 1;



//                    System.out.println("checking if we reverse or not");
//                    display();

                //    double temp = best;
                    best = Math.max(best, val);
//                    if(temp != best) {
                        startNode.hure = val;
                        newMove.hure = val;


                    alpha = (int) Math.max(alpha, best);


                    // Alpha Beta Pruning
                    if (beta <= alpha)
                        break;
                }
            }

            return best;

        } else {

            double best = MAX;

            for (int i = 0; i < possible_moves_P1().size(); i++) {

                for (int j = 0; j < accessibles_P1(possible_moves_P1().get(i)).size(); j++) {

                    Node startNode = possible_moves_P1().get(i);
                    Node newMove = accessibles_P1(startNode).get(j);

                    if (isKing1(startNode))
                        startNode.king = true;

                    opponent(startNode,newMove);

                    int temp_val = startNode.val;
                    boolean temp_king = startNode.king;

                    startNode.val = newMove.val;
                    startNode.king = newMove.king;

                    newMove.val = temp_val;
                    newMove.king = temp_king;

                   // Debugging
//                    display();
//                    System.out.println("depth : " + depth);
//                    System.out.println("score : " + h());

                    double val = minimax(depth + 1, true, alpha, beta);

                    if (isKing1(newMove))
                        newMove.king = false;

                    temp_val = newMove.val;
                    temp_king = newMove.king;

                    newMove.val = startNode.val;
                    newMove.king = startNode.king;

                    startNode.val = temp_val;
                    startNode.king = temp_king;

                    // when startNode was already a king
                    if(isKing1(startNode))
                        startNode.king = true;


                    if(startNode.row - 2 == newMove.row && startNode.col + 2 == newMove.col)
                        board[startNode.row-1][startNode.col+1].val = 2;

                    else if(startNode.row - 2 == newMove.row && startNode.col - 2 == newMove.col)
                        board[startNode.row-1][startNode.col-1].val = 2;



//                    System.out.println("checking if we reverse or not");
//                    display();

                    best = Math.min(best, val);
                    beta = (int) Math.min(beta, best);

                    // Alpha Beta Pruning
                    if (beta <= alpha)
                        break;
                }

            }
            return best;
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(500,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

    class Node {
    int row;
    int col;
    int val;
    boolean king;
    double hure;

        public Node(int row , int col) {
        this.row = row;
        this.col = col;
    }

    public String toString(){
        return val + " ";
    }

}
