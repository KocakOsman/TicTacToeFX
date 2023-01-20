package Model;

import java.util.HashMap;

public class Board {
    private String[][] board;

    public Board() {
        this.board = new String[3][3];
    }

    public String[][] getBoard() {
        return board;
    }


    //Sets the move on the board
    public void setMove(int val, String p){
        int i = val / 3;
        int j = val % 3;
        board[i][j] = p;
    }


    public boolean isWinner(String currentPlayer){
        try {
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board.length; j++){
                    if (board[i][j] != null  && board[i][j].equals(currentPlayer)){
                        if (checkRightHorizontal(i,j,currentPlayer) == 3 ||
                                checkLeftHorizontal(i,j, currentPlayer) == 3 ||
                                checkDownVertical(i,j,currentPlayer) == 3 ||
                                checkUpVertical(i,j,currentPlayer) == 3 ||
                                checkDownRight(i,j,currentPlayer) == 3 ||
                                checkDownLeft(i,j,currentPlayer) == 3 ||
                                checkUpperLeft(i,j,currentPlayer) == 3 ||
                                checkUpperRight(i,j,currentPlayer) == 3 ){
                            return true;
                        }else return false;
                    }
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }

    private int checkRightHorizontal(int i, int j, String player){
        try {
            if (board[i][j].equals(player)){
                return 1 + checkRightHorizontal(i,j+1,player);
            }else return 0;
        }catch (Exception e){
            return 0;
        }
    }

    private int checkLeftHorizontal(int i, int j, String player){
        try {
            if (board[i][j].equals(player)){
                return 1 + checkLeftHorizontal(i,j-1,player);
            }else return 0;
        }catch (Exception e){
            return 0;
        }
    }

    private int checkDownVertical(int i, int j, String player){
        try {
            if (board[i][j].equals(player)){
                return 1 + checkDownVertical(i+1,j,player);
            }else return 0;
        }catch (Exception e){
            return 0;
        }
    }

    private int checkUpVertical(int i, int j, String player){
        try {
            if (board[i][j].equals(player)){
                return 1 + checkUpVertical(i-1,j,player);
            }else return 0;
        }catch (Exception e){
            return 0;
        }
    }

    private int checkDownRight(int i, int j, String player){
        try {
            if (board[i][j].equals(player)){
                return 1 + checkDownRight(i+1,j+1,player);
            }else return 0;
        }catch (Exception e){
            return 0;
        }
    }

    private int checkDownLeft(int i, int j, String player){
        try {
            if (board[i][j].equals(player)){
                return 1 + checkDownLeft(i+1,j-1,player);
            }else return 0;
        }catch (Exception e){
            return 0;
        }
    }

    private int checkUpperLeft(int i, int j, String player){
        try {
            if (board[i][j].equals(player)){
                return 1 + checkUpperLeft(i-1,j-1,player);
            }else return 0;
        }catch (Exception e){
            return 0;
        }
    }

    private int checkUpperRight(int i, int j, String player){
        try {
            if (board[i][j].equals(player)){
                return 1 + checkUpperRight(i-1,j+1,player);
            }else return 0;
        }catch (Exception e){
            return 0;
        }
    }





    public HashMap<String, Integer> getValue(){
        HashMap<String,Integer> values = new HashMap<>();
        values.put("zero",0);
        values.put("one",1);
        values.put("two",2);
        values.put("three",3);
        values.put("four",4);
        values.put("five",5);
        values.put("six",6);
        values.put("seven",7);
        values.put("eight",8);
        return values;
    }

}
