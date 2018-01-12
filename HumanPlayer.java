import java.util.Scanner;

public class HumanPlayer implements Player {
    private char symbol;
    public HumanPlayer(char x) {
        symbol = x;
    }

    @Override
    public Point oneMove(Point[] pointsArr, int a) {
        System.out.println(symbol + ":its your Move!");
        System.out.println("your possible moves are: ");

        for(int i=0;i<a;i++){
            System.out.println("(" + pointsArr[i].getX() + "," + pointsArr[i].getY() + ")");
        }

        System.out.println("\nchoose a move by pressing a number a space and than the other number\n\n");
        boolean flag= true;
        int x, y;
        //loops until the user chooses valid option
        do {
            Scanner in = new Scanner(System.in);
            x = in.nextInt();
            y = in.nextInt();
            for(int i=0;i<a;i++){
                if(x==pointsArr[i].getX() && y==pointsArr[i].getY())
                flag=false;
            }
            if(flag){
                System.out.println("not an option try again");
            }
        }while(flag);
        System.out.println("you chose " +x + "," + y);

        Point p=new Point(x,y);

        return p;    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
