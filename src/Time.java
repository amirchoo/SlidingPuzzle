import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Time extends JLabel implements ActionListener {

    StartButton startButton;

    int elapsedTime = 0;
    int minutes = 0;
    int seconds = 0;

    String minutes_string = String.format("%02d", minutes);
    String seconds_string = String.format("%02d", seconds);

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime += 1000;  // Increment time by 1000ms (1 second)
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;

            // Update the label with formatted time
            minutes_string = String.format("%02d", minutes);
            seconds_string = String.format("%02d", seconds);
            setText(minutes_string + ":" + seconds_string);
        }
    });

    Time(StartButton startButton, Font font) {
        setText(minutes_string + ":" + seconds_string);
        setFont(font);
        this.startButton = startButton;
        startButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button worked");
        if (e.getSource() == startButton) {
            start();
        }
    }

    public void start(){
        timer.start();
    }

    public String getTime(){
        return String.format("%02d:%02d", minutes, seconds);
    }
}
