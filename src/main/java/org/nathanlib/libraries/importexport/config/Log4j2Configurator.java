package org.nathanlib.libraries.importexport.config;

import org.apache.logging.log4j.core.config.Configurator;

/**
 * @author duyenthai
 */
public class Log4j2Configurator {
    private static final String LOG4J2_CONFIG_FILE = "log4j2.xml";

    private Log4j2Configurator() {
    }

    public void configure() {
        Configurator.initialize("ImportService", this.getClass().getClassLoader(), LOG4J2_CONFIG_FILE);
    }

    public static Log4j2Configurator getInstance() {
        return Singleton.INSTANCE;
    }

    private static class Singleton {
        public static final Log4j2Configurator INSTANCE = new Log4j2Configurator();
    }
}
