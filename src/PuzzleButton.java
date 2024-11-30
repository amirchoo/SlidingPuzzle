import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleButton extends JButton implements ActionListener {
    private SlidePuzzleBoard board;
    private PuzzleFrame frame;
    private int row;
    private int col;

    public PuzzleButton(SlidePuzzleBoard b,PuzzleFrame f,int row,int col) {
        board = b;
        frame = f;
        this.row = row;
        this.col = col;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        //PuzzlePiece piece = board.contents()[row][col];
        PuzzlePiece piece1 = board.getPuzzlePiece(row,col);
        if (piece1 != null) {
            boolean moved = board.move(piece1.faceValue());
            if (moved) {
                frame.update();
            }
        }
        if (board.gameOver()){
            frame.finish();
        }
    }
}
