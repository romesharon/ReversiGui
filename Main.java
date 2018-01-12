import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice;
        CellManger c = new CellManger(8);
        c.setWhite(4, 4);
        c.setWhite(5, 5);
        c.setBlack(4, 5);
        c.setBlack(5, 4);
        Board b = new Board(8, c.getArr());
        Rule r = new ReverseRule();

        System.out.println("Welcome to Reversi!!!!\n1. 1 vs 1");
        do {
            System.out.println("Enter your choice here:");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
        } while (choice != 1);

        Player p1 = new HumanPlayer('x');
        Player p2 = new HumanPlayer('o');
        Player[] players = new Player[2];
        players[0] = p1;
        players[1] = p2;
        GameFlow g = new GameFlow(b, c, r, players);
        g.play();
        b.show();

    }
}
