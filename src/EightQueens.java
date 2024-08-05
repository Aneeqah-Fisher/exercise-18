public class EightQueens {

    private static final int N = 8;
    private static int[] board = new int[N]; // Array to store the position of queens

    public static void main(String[] args) {
        if (solve(0)) {
            printBoard();
        } else {
            System.out.println("No solution found.");
        }
    }

    // Solve the Eight Queens puzzle
    private static boolean solve(int row) {
        if (row == N) return true;

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row] = col; // Place queen
                if (solve(row + 1)) return true;
            }
        }
        return false;
    }

    // Check if placing a queen is safe
    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    // Print the chessboard with queens
    private static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}