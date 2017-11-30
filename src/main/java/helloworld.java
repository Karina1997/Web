import java.io.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class helloworld {
    public static void main(String args[]) throws IOException {

        FileReader reader = new FileReader("./src/logging.properties");
        System.out.println(reader.read());

        try {
            LogManager.getLogManager().readConfiguration(
                    helloworld.class.getResourceAsStream("./src/logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger log = Logger.getLogger(helloworld.class.getName());
        log.info("Wow");
    }
}
