package org.nathanlib.libraries.importexport.dto;

import org.nathanlib.libraries.importexport.exception.ParseDataException;
import lombok.Builder;
import lombok.Data;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author duyenthai
 */
@Data
@Builder
public class RowDataBuilder {
    private Row row;
    private Map<Integer, CellMetaData> columnMetaData;
    private int lineNumber;
    private List<CellDataBuilder> cellDataBuilders;

    public RowData build() {
        List<String> fieldErrors = new ArrayList<>();
        for (CellDataBuilder cellDataBuilder : cellDataBuilders) {
            CellMetaData cellMetaData = columnMetaData.get(cellDataBuilder.getColumnNumber());
            if (cellMetaData == null) {
                throw new ParseDataException(List.of(cellDataBuilder.getName()), lineNumber, "Field not found");
            }
            if (cellMetaData.isCheckNull() && cellDataBuilder.getCellData() == null) {
                fieldErrors.add(cellDataBuilder.getName());
            }
            if (cellMetaData.isCheckEmpty() && cellDataBuilder.getCellData() != null && cellDataBuilder.getCellData().toString().isEmpty()) {
                fieldErrors.add(cellDataBuilder.getName());
            }
        }
        if (!fieldErrors.isEmpty()) {
            throw new ParseDataException(fieldErrors, lineNumber, "Field data null or empty");
        }
        return RowData.builder()
                .lineNumber(lineNumber)
                .cells(cellDataBuilders.stream().map(CellDataBuilder::build).toList())
                .build();
    }
}
