package ru.sfedu.FirstTryServer;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.jmx.Server;
import ru.sfedu.FirstTryServer.api.ServerAnswer;

import static ru.sfedu.FirstTryServer.Constants.ENV_PROPERTIES;
import static ru.sfedu.FirstTryServer.Constants.LOG4J2_PROPERTIES;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException{
        try {
            log.debug(System.getProperty(ENV_PROPERTIES));
            log.debug(System.getProperty(LOG4J2_PROPERTIES));
            new ServerAnswer();


        } catch (Exception exception) {
            log.error(exception);
        }

    }
}
