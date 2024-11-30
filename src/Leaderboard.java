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

            int data, count = 1;
            while ((data = reader.read()) != -1) {
                if (data == '\n') {
                    count++;
                }
            }

            reader.close();

            if (this.time == null){
                writer.write(count + ". " + name +"\n");
                System.out.println("this.time is null");
            }else {
                writer.write(count + ". " + name + "\t\t" + time.getTime() +"\n");
                System.out.println("this.time not null");
            }
            writer.close();

            // --------------DEBUGGING--------------
            FileReader reader2 = new FileReader(file);
            int read;
            while( (read = reader2.read()) != -1){
                System.out.print((char)read);
            }
            System.out.println("ok");
            reader2.close();
            //--------------------------------------

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------END----------------");
    }
}
