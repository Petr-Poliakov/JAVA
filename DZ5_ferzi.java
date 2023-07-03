public class Ferzi {
    private int SIZE;
    private int board[][];

    public Ferzi(int N) {
        SIZE = N;
        board = new int[N][N];

    }

    public boolean tryQueen(int a, int b) {
        for (int i = 0; i < a; ++i)
            if (board[i][b] == 1)
                return false;

        for (int i = 1; i <= a && b - i >= 0; ++i)
            if (board[a - i][b - i] == 1)
                return false;

        for (int i = 1; i <= a && b + i < SIZE; i++)
            if (board[a - i][b + i] == 1)
                return false;

        return true;
    }

    public boolean setQueen(int a) {
        if (a >= SIZE) {
            return true;
        }
        for (int i = 0; i < SIZE; i++) {
            if (tryQueen(a, i)) {
                board[a][i] = 1;
                if (setQueen(a + 1) == true) {
                    return true;
                }
                board[a][i] = 0;
            }
        }
        return false;
    }

    public void showBoard() {
        for (int a = 0; a < SIZE; ++a) {
            for (int b = 0; b < SIZE; ++b) {
                System.out.print((board[a][b] == 1) ? " Q" : " .");
            }
            System.out.print('\n');
        }
    }

    public class Programm {
        public static void main(String args[]) throws InterruptedException {
            Ferzi fer = new Ferzi(8);
            fer.setQueen(0);
            fer.showBoard();
        }
    }
}