package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.common.ImportResponse;

/**
 * @author duyenthai
 */
public interface ProcessImportFileService<T> {
    ImportResponse process(String filePath) throws Exception;
}
