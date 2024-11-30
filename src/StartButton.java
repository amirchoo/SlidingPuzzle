import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton implements ActionListener {
    private SlidePuzzleBoard board;
    private PuzzleFrame frame;
    private Leaderboard leaderboard;
    private Time time;
    private String name;

    public StartButton(SlidePuzzleBoard b, PuzzleFrame f){
        super("Start");
        board = b;
        frame = f;
        addActionListener(this);
        setFont(new Font("Arial",Font.BOLD,16));

    }

    public void actionPerformed(ActionEvent e){
        board.createPuzzleBoard();
        frame.update();
        this.setText("Restart");

        //--------------TESTING---------------
        name = JOptionPane.showInputDialog("Input your name");
        leaderboard = new Leaderboard(name, time);

    }
}
