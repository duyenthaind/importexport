package org.nathanlib.libraries.importexport.service;

import org.apache.poi.ss.usermodel.Cell;

/**
 * @author duyenthai
 */
public interface ParseCellService {
    Object parseCellValue(Cell cell);
}
