package bigdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by denny on 11-1-2017.
 */

class Task implements Runnable
{
    private String string;

    public Task(String _string)
    {
        string = _string;
    }

    @Override
    public void run() {
        try {
            Runtime.getRuntime().exec(string).waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Main
{
    public static void main(String args[]) {
        final List<String> commands = Arrays.asList("java -jar MovieParser.jar", "java -jar DataParser.jar locations.list locationseries.csv locationmovies.csv",
                "java -jar BusinessParser.jar ratings.list ratingseries.csv ratingmovies.csv \"MOVIE RATINGS REPORT\"", "java -jar BiografieParser.jar",
                "java -jar ActorsParser.jar", "java -jar GenreParser.jar");
        List<Thread> threads = new ArrayList<>();
        for (String s : commands) {
            threads.add(new Thread(new Task(s)));
        }
        for (Thread t: threads) {
            t.start();
        }
        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
