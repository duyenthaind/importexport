package org.nathanlib.libraries.importexport.processor;

import org.nathanlib.libraries.importexport.dto.CellMetaData;
import org.nathanlib.libraries.importexport.service.WriteDataService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;

import java.util.Objects;

/**
 * @author duyenthai
 */
@RequiredArgsConstructor
public class WriteCellProcessor {
    private final CellMetaData cellMetaData;
    private final WriteDataService writeDataService;

    public void write(Cell cell, Object input) throws Exception {
        Object cellData = writeDataService.parseInputData(input, cellMetaData.getFieldName());
        if (Objects.isNull(cellData)) {
            return;
        }
        switch (cellMetaData.getDataType()) {
            case STRING, DATE:
                cell.setCellValue((String) cellData);
                break;
            case NUMBER:
                cell.setCellValue(((Number) cellData).doubleValue());
                break;
            default:
                break;
        }
    }
}
