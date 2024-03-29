public class BoardNode {
    private final int SIZE;
    private final int[][] board;
    private final String[] letters;

    public BoardNode(int SIZE){
        this.SIZE = SIZE;
        this.board = new int[SIZE][SIZE];
        this.letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        populateBoard();
    }

    /**
     * check for 4 in a line for columns and rows
     * excluding diagonal wins
     */
    public int checkWin(){
//        print();
//        System.out.println();
        if(checkRow(1) || checkCol(1)){
            // player wins
            System.out.println("Player wins !");
            return 1;
        }else if (checkRow(-1) || checkCol(-1)){
            System.out.println("AI wins !");
            return -1;
        }else{
            return 0;
        }
    }

    public boolean checkRow(int type){
        int count = 0;
        for(int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (board[i][j] == type){
                    count++;
                }else {
                    count = 0;
                }
                if (count >= 4){
                    System.out.println("Found the winning row !!! @ " + "coordinates (row, col) -> (" + letters[i] + " , " + (j+1) +")");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCol(int type){
        int count = 0;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if (board[j][i] == type){
                    count++;
                }else {
                    count = 0;
                }
                if (count >= 4){
                    System.out.println("Found the winning column !!! @ " + "coordinates (row, col) -> (" + letters[j] + " , " + (i+1) +")");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check for legal move
     * out of bounds, already taken pos.
     * @return valid or invalid move
     */
    public boolean checkMove(int rowPos, int colPos){
        colPos = colPos-1;
        if((rowPos < 0 || rowPos >= SIZE) || (colPos < 0 || colPos >= SIZE)){
            // out of bounds
            return false;
        }

        if(board[rowPos][colPos] != 0){
            // position is occupied by either player or opponent
            return false;
        }
        return true;
    }

    /**
     * player move execution
     * maps to proper coordinates on the board (post-valid check)
     * @param rowPos
     * @param colPos
     */
    public void playerMove(int rowPos, int colPos){
        board[rowPos][colPos-1] = 1;
        print();
    }

    /**
     * populate board with default dashes and coordinates
     * 1 = (X)
     * -1 = (O)
     */
    public void populateBoard(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                board[i][j] = 0;
            }
        }
    }

    public void print() {
        // prints numbers on top of board
        for (int x = 1; x < SIZE+1; x++){
            if (x==1){
                System.out.print("  " + x);
            }else {
                System.out.print(x);
            }
        }
        System.out.println();
        for(int i = 0; i < SIZE; i++){
            System.out.print(letters[i] + " ");
            for(int j = 0; j < SIZE; j++){
                if(board[i][j] == 0){
                    System.out.print(".");
                }else if (board[i][j] == 1){
                    System.out.print("X");
                }else{
                    System.out.print("O");
                }
            }
            System.out.println();
        }


    }
}
