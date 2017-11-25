import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {
        int time = promptUser();
        boolean firstTurnChoice = pickFirstTurn();
        Game gameThread = new Game(time, 8, firstTurnChoice);
        gameThread.initGame();
    }

    public static int promptUser(){
        System.out.println("** 4 In a Line**");
        Scanner k = new Scanner(System.in);

        System.out.println("Enter the maximum amount of time for each move (30 sec limit): ");
        int seconds = k.nextInt();

        while(seconds > 30){
            System.out.println("Please re-enter a time less than 30 sec: ");
            seconds = k.nextInt();
        }
        return seconds;
    }

    public static boolean pickFirstTurn(){
        Scanner k = new Scanner(System.in);
        System.out.println("Pick who goes first");
        System.out.println("1. Player (X)");
        System.out.println("2. Opponent (O)");
        int choice = k.nextInt();
        while (choice < 1 || choice > 2){
            System.out.println("Invalid choice, pick who goes first");
            choice = k.nextInt();
        }

        if(choice == 1){
            return true;
        }

        return false;
    }
}
