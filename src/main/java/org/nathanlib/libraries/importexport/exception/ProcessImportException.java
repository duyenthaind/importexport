package org.nathanlib.libraries.importexport.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author duyenthai
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProcessImportException extends Exception {
    private int lineNumber;

    public ProcessImportException(String message) {
        super(message);
        this.lineNumber = -1;
    }

    public ProcessImportException(int lineNumber, String message) {
        super(message);
        this.lineNumber = lineNumber;
    }

}
