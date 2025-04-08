package org.nathanlib.libraries.importexport.processor;

import org.nathanlib.libraries.importexport.dto.CellMetaData;
import org.nathanlib.libraries.importexport.helper.ILogger;
import org.nathanlib.libraries.importexport.service.WriteDataService;
import org.nathanlib.libraries.importexport.service.WriteDataServiceStrategy;
import org.nathanlib.libraries.importexport.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author duyenthai
 */
@RequiredArgsConstructor
public class WriteRowProcessor {
    private final WriteDataServiceStrategy writeDataServiceStrategy;
    private final List<CellMetaData> columnMetaData;
    private final ILogger iLogger;

    public Map<Integer, CellMetaData> readMetaData() {
        columnMetaData.forEach(value -> {
            String fieldName = value.getFieldName();
            String camelCaseFieldName = StringUtils.snakeToCamel(fieldName, false);
            value.setFieldName(camelCaseFieldName);
        });

        final AtomicInteger columnAtomic = new AtomicInteger(0);
        return columnMetaData.stream()
                .map(entry -> Map.entry(columnAtomic.getAndIncrement(), entry))
                .collect(
                        HashMap::new,
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                        HashMap::putAll
                );
    }

    public Map<Integer, WriteCellProcessor> initWriteProcessors(Map<Integer, CellMetaData> metadata) {
        Map<Integer, WriteCellProcessor> writeCellProcessors = new HashMap<>();
        metadata.forEach((key, value) -> {
            WriteDataService writeDataService = writeDataServiceStrategy.getParseDataInputService(value.getDataType());
            writeCellProcessors.put(key, new WriteCellProcessor(value, writeDataService));
        });
        return writeCellProcessors;
    }

    public void write(Row row, Object data, final Map<Integer, CellMetaData> columMetadata, final Map<Integer, WriteCellProcessor> processors) {
        CellStyle cellStyle = getDefaultCellStyle(row.getSheet());

        columMetadata.forEach((key, value) -> {
            // write cell
            Cell cell = row.createCell(key);
            cell.setCellStyle(cellStyle);

            WriteCellProcessor processor = processors.get(key);
            if (Objects.isNull(processor)) {
                cell.setCellValue(StringUtils.EMPTY);
                return;
            }
            try {
                processor.write(cell, data);
            } catch (Exception ex) {
                // log error
                iLogger.error("Error writing cell: " + value.getFieldName(), ex);
            }
        });
    }

    protected CellStyle getDefaultCellStyle(Sheet sheet) {
        CellStyle res = sheet.getWorkbook().createCellStyle();
        res.setBorderTop(BorderStyle.THIN);
        res.setBorderBottom(BorderStyle.THIN);
        res.setBorderLeft(BorderStyle.THIN);
        res.setBorderRight(BorderStyle.THIN);
        res.setAlignment(HorizontalAlignment.CENTER);
        return res;
    }
}
