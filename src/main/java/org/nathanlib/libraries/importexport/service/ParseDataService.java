package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.dto.RowData;
import org.nathanlib.libraries.importexport.exception.ParseDataException;

/**
 * @author duyenthai
 */
public interface ParseDataService<T> {
    T parseEntity(RowData rowData) throws ParseDataException;
}
