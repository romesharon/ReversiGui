public class Board implements GameShower {
    int size;
    Cell[][] arr;

    Board(int s, Cell[][] a) {
        size = s;
        arr = a;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void show() {
        for (int i = 0; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (i == 0) {
                    System.out.print(" | " + j);
                    if (j == size) {
                        System.out.print(" |");
                    }
                }
                else {
                    if (j == 1) {
                        System.out.print(i + "| ");
                    }
                    if (arr[i][j].symbol == 'x' || arr[i][j].symbol == 'o') {

                        System.out.print(arr[i][j].symbol + " | ");
                    }
                    else{
                        System.out.print("  | ");

                    }

                }
            }
            System.out.println("");
            System.out.print(" ");

            for (int j = 0; j < size; j++) {
                System.out.print("----");

            }
            System.out.println("");


        }

        System.out.println("");
    }
}
