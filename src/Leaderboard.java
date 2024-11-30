import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Leaderboard {
    private String name;
    private Time time;

    Leaderboard(String n, Time t){
        name = n;
        time = t;

        File file = new File("ranking.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(file, true);
            FileReader reader = new FileReader(file);

            System.out.println("file exist at " + file.getAbsolutePath());

            int data, count = 1;
            while ((data = reader.read()) != -1) {
                if (data == '\n') {
                    count++;
                }
            }

            writer.write(count + ". " + name + "\t" + time.getTime() + "\n");

            // --------------DEBUGGING--------------
            FileReader reader2 = new FileReader(file);
            int read;
            while( (read = reader2.read()) != -1){
                System.out.print((char)read);
            }

            System.out.println("ok");

            writer.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
