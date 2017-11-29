package com.firsttry;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class helloworld {
    public static void main(String args[])
    {
        try {
            LogManager.getLogManager().readConfiguration(
                    helloworld.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger log = Logger.getLogger(helloworld.class.getName());
        log.info("Wow");
    }
}
