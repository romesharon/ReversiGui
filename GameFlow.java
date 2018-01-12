public class GameFlow {
    private GameShower screen;
    private CellManger manger;
    private Rule rule;
    private Player[] players;
    private int current;
    private int numOfPieces;

    GameFlow(GameShower s, CellManger c, Rule r, Player[] p)
    {
        screen=s;
        manger=c;
        rule=r;
        players=p;
        current=0;
        numOfPieces=4;
    }

    void play() {
        do {
            screen.show();

            Point[] points = new Point[screen.getSize() * screen.getSize()];

            //going trough all the cells in the array and checking who is valid place to set piece
            int i = 0, j = 0, k = 0;
            for (i = 1; i <= screen.getSize(); i++) {
                for (j = 1; j <= screen.getSize(); j++) {
                    if (rule.check(manger.getArr(), i, j, players[current].getSymbol())) {
                        points[k] = new Point(i, j);
                        k++;
                    }
                }
            }
            if (k == 0) {
                System.out.println("No possible move for:" + players[current].getSymbol());
                current++;
                if (current == 2) { current = 0; }
                continue;
            }
            Point a = players[current].oneMove(points, k);
            if (players[current].getSymbol() == 'x') {
                manger.setBlack(a.getX(), a.getY());
            } else {
                manger.setWhite(a.getX(), a.getY());
            }
            numOfPieces++;
            //applying the rule: flipping the appropriate pieces
            rule.apply(manger.getArr(), a.getX(), a.getY(), players[current].getSymbol());
            current++;

            if (current == 2) {
                current = 0;
            }

            //}while(numOfPieces<10); for debug we will use this somethimes...
        }while(numOfPieces<screen.getSize()*screen.getSize());

        System.out.println("game over");

        if(this.manger.getCount('x')>this.manger.getCount('o')){
            System.out.println("player black-x has won");
        } else{
            System.out.println("player white-o has won");
        }
    }
}
