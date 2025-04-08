package org.nathanlib.libraries.importexport.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

/**
 * @author duyenthai
 */
public class ParseCellDefaultService implements ParseCellService {

    protected final DataFormatter dataFormatter = new DataFormatter();

    @Override
    public Object parseCellValue(Cell cell) {
        return dataFormatter.formatCellValue(cell);
    }

}
