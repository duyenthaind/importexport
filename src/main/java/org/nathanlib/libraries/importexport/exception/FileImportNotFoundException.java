package org.nathanlib.libraries.importexport.exception;

import java.io.FileNotFoundException;

/**
 * @author duyenthai
 */
public class FileImportNotFoundException extends FileNotFoundException {
    public FileImportNotFoundException(String message) {
        super(message);
    }
}
