package org.nathanlib.libraries.importexport.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author duyenthai
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ParseDataException extends RuntimeException {

    private List<String> fieldNames;
    private Integer lineNumber;

    public ParseDataException(List<String> fieldNames, Integer lineNumber, String message) {
        super(message);
        this.fieldNames = fieldNames;
        this.lineNumber = lineNumber;
    }
}
