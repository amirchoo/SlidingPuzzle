public class Main {
    public static void main(String[] args) {
        SlidePuzzleBoard board = new SlidePuzzleBoard();
        new PuzzleFrame(board);
    }
}

/*TODO: 1. Leaderboard: (timer not shown);   problem: this.timer > null     DONE
        2. Button press --> timer go, done --> timer stop && reset timer    DONE
        3. Put leaderboard inside JFrame; JFrame invoked after leaderboard selected
 */