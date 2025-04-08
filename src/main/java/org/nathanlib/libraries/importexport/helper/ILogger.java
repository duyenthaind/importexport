package org.nathanlib.libraries.importexport.helper;

/**
 * @author duyenthai
 */
public interface ILogger {
    void info(String info);

    void error(String error);

    void error(String error, Throwable ex);

    void debug(String debug);
}
