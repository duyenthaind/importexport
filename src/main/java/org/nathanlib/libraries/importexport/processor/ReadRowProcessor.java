package org.nathanlib.libraries.importexport.processor;

import org.nathanlib.libraries.importexport.dto.CellDataBuilder;
import org.nathanlib.libraries.importexport.dto.CellMetaData;
import org.nathanlib.libraries.importexport.dto.RowDataBuilder;
import org.nathanlib.libraries.importexport.service.ParseCellDataStrategy;
import org.nathanlib.libraries.importexport.service.ParseCellService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.*;

/**
 * @author duyenthai
 */
@RequiredArgsConstructor
public class ReadRowProcessor {
    private final ParseCellDataStrategy parseCellDataStrategy;
    private final Map<String, CellMetaData> columnMetaData;

    public Map<Integer, CellMetaData> readMetaData(Sheet sheet) {
        Map<Integer, CellMetaData> metadata = new HashMap<>();
        Iterator<Cell> iterator = sheet.getRow(0).cellIterator();
        while (iterator.hasNext()) {
            Cell cell = iterator.next();
            String cellName = cell.getStringCellValue().trim();
            CellMetaData cellMetaData = columnMetaData.get(cellName);
            if (cellMetaData != null) {
                metadata.put(cell.getColumnIndex(), cellMetaData);
            }
        }
        return metadata;
    }

    public Map<Integer, ReadCellProcessor> initReadProcessors(Map<Integer, CellMetaData> metadata) {
        Map<Integer, ReadCellProcessor> readCellProcessors = new HashMap<>();
        metadata.forEach((key, value) -> {
            ParseCellService parseCellService = parseCellDataStrategy.getParseCellService(value.getDataType());
            readCellProcessors.put(key, new ReadCellProcessor(value, parseCellService));
        });
        return readCellProcessors;
    }

    public RowDataBuilder read(int lineNumber, Row row, final Map<Integer, CellMetaData> columnMetadata, final Map<Integer, ReadCellProcessor> processors) {
        Iterator<Cell> cellIterator = row.cellIterator();
        List<CellDataBuilder> cellDataBuilders = new ArrayList<>();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            ReadCellProcessor readCellProcessor = processors.get(cell.getColumnIndex());
            if (readCellProcessor != null) {
                CellDataBuilder cellDataBuilder = readCellProcessor.read(lineNumber, cell);
                cellDataBuilders.add(cellDataBuilder);
            }
        }
        return RowDataBuilder.builder()
                .row(row)
                .columnMetaData(columnMetadata)
                .lineNumber(lineNumber)
                .cellDataBuilders(cellDataBuilders)
                .build();
    }
}
