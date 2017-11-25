import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private final int TIMELIMIT;
    private final int BOARDSIZE;
    private boolean playerTurn;

    private final Map<Character, Integer> coordinatesTable;
    private BoardNode currentGame;


    public Game(int timeLimit, int boardsize, boolean firstTurnChoice){
        this.TIMELIMIT = timeLimit;
        this.BOARDSIZE = boardsize;
        this.playerTurn = firstTurnChoice;
        coordinatesTable = new HashMap<>();
        mapCoordinates();
    }

    public void initGame(){
        this.currentGame = new BoardNode(BOARDSIZE);
//        System.out.println();
//        System.out.println("Initial Board");
//        currentGame.print();

        Scanner k = new Scanner(System.in);

        // testing
        for (int i = 0; i < 4; i++) { //testing for 4 iterations
            if (playerTurn) {
                System.out.println("Enter Position: ");
                String input = k.nextLine().toUpperCase();
                while (!handlePosition(input)) {
                    System.out.println("Invalid move, re-enter: ");
                    input = k.nextLine();
                }
            }else{
                System.out.println();
                System.out.println("Computers turn !!!");
                System.out.println();
            }

            playerTurn = determineTurn(playerTurn);
        }
    }

    public boolean determineTurn(boolean playerTurn){
        if (playerTurn){
           return false;
        }else {
            return true;
        }
    }

    public void mapCoordinates(){
        coordinatesTable.put('A', 0);
        coordinatesTable.put('B', 1);
        coordinatesTable.put('C', 2);
        coordinatesTable.put('D', 3);
        coordinatesTable.put('E', 4);
        coordinatesTable.put('F', 5);
        coordinatesTable.put('G', 6);
        coordinatesTable.put('H', 7);
    }

    public boolean handlePosition(String position){
        char letter = position.charAt(0);
        int row = coordinatesTable.get(letter);
        char numChar = position.charAt(1);
        int column = Character.getNumericValue(numChar);

        if(currentGame.checkMove(row, column)){
            currentGame.playerMove(row, column);
            return true;
        }
        return false;
    }

}
