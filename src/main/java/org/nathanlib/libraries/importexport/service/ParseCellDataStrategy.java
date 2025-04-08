package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.common.DataType;
import lombok.RequiredArgsConstructor;

/**
 * @author duyenthai
 */
@RequiredArgsConstructor
public class ParseCellDataStrategy {
    private final ParseCellDefaultService parseCellDefaultService;
    private final ParseCellDateService parseCellDateService;
    private final ParseCellNumberService parseCellNumberService;

    public ParseCellService getParseCellService(DataType dataType) {
        return switch (dataType) {
            case NUMBER -> parseCellNumberService;
            case DATE -> parseCellDateService;
            default -> parseCellDefaultService;
        };
    }
}
