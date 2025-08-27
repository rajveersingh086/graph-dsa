import java.util.*;
public class snake {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // {square, moves}

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int square = curr[0], moves = curr[1];

            for (int i = 1; i <= 6; i++) {
                int next = square + i;
                if (next > n * n) continue;

                int[] pos = getCoordinates(next, n);
                int r = pos[0], c = pos[1];

                if (board[r][c] != -1) {
                    next = board[r][c];
                }

                if (next == n * n) return moves + 1;

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, moves + 1});
                }
            }
        }

        return -1;
    }

    private int[] getCoordinates(int s, int n) {
        int quot = (s - 1) / n;
        int rem = (s - 1) % n;
        int row = n - 1 - quot;
        int col = (quot % 2 == 0) ? rem : n - 1 - rem;
        return new int[]{row, col};

    }
}