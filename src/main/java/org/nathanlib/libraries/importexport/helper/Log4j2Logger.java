package org.nathanlib.libraries.importexport.helper;

import lombok.extern.log4j.Log4j2;

/**
 * @author duyenthai
 */
@Log4j2(topic = "ImportService")
public class Log4j2Logger implements ILogger {

    @Override
    public void info(String info) {
        log.info(info);
    }

    @Override
    public void error(String error) {
        log.error(error);
    }

    @Override
    public void error(String error, Throwable ex) {
        log.error(error, ex);
    }

    @Override
    public void debug(String debug) {
        log.debug(debug);
    }
}
