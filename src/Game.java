import java.util.Scanner;
public class Game {
    public static OX ox;
    private static Scanner kb = new Scanner(System.in);
    private static int row,col;

    public static void input(){
        boolean canPut=true;
        do {
            System.out.print(ox.getCurrentPlayer() + " (Col): ");
            col = kb.nextInt();
            System.out.print(ox.getCurrentPlayer() + " (Row): ");
            row = kb.nextInt();
            canPut = ox.put(row, col);
            if (!canPut) {
                System.out.println("Please input number between 0-2");
            }
        }while(!canPut);
    }

    public static void printScore(){
        System.out.print(ox.getTableString());
        System.out.println("X win "+ox.getScoreX());
        System.out.println("O win "+ox.getScoreO());
        System.out.println("Draw "+ox.getScoreDraw());
    }

    public static void main(String[]asdf){
        ox = new OX();
        while(true) {
            System.out.print(ox.getTableString());
            input();
            if(ox.checkWin(row,col)){
                printScore();
                ox.reset();
                continue;
            }
            if(ox.isDraw()){
                printScore();
                ox.reset();
                continue;
            }
            ox.switchPlayer();

        }
    }
}