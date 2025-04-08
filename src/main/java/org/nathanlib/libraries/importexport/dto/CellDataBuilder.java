package org.nathanlib.libraries.importexport.dto;

import org.nathanlib.libraries.importexport.common.DataType;
import lombok.Builder;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;

/**
 * @author duyenthai
 */
@Data
@Builder
public class CellDataBuilder {
    private Cell cell;
    private String name;
    private DataType cellType;
    private Object cellData;
    private Integer rowNumber;
    private Integer columnNumber;

    public CellData build() {
        return CellData.builder()
                .name(name)
                .cellValue(cellData)
                .cellType(cellType.toString())
                .rowNumber(rowNumber)
                .columnNumber(columnNumber)
                .build();
    }
}
