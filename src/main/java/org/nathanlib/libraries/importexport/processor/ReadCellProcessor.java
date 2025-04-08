package org.nathanlib.libraries.importexport.processor;

import org.nathanlib.libraries.importexport.dto.CellDataBuilder;
import org.nathanlib.libraries.importexport.dto.CellMetaData;
import org.nathanlib.libraries.importexport.service.ParseCellService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;

/**
 * @author duyenthai
 */
@RequiredArgsConstructor
public class ReadCellProcessor {
    private final CellMetaData cellMetaData;
    private final ParseCellService parseCellService;

    public CellDataBuilder read(int rowNumber, Cell cell) {
        Object cellData = parseCellService.parseCellValue(cell);
        return CellDataBuilder.builder()
                .cell(cell)
                .name(cellMetaData.getName())
                .cellType(cellMetaData.getDataType())
                .cellData(cellData)
                .rowNumber(rowNumber)
                .columnNumber(cell.getColumnIndex())
                .build();
    }
}
