package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.common.DataType;
import lombok.RequiredArgsConstructor;

/**
 * @author duyenthai
 */
@RequiredArgsConstructor
public class WriteDataServiceStrategy {
    private final WriteDataDefaultService writeDataDefaultService;
    private final WriteDataNumberService writeDataNumberService;
    private final WriteDataDateService writeDataDateService;

    public WriteDataService getParseDataInputService(DataType dataType) {
        return switch (dataType) {
            case NUMBER -> writeDataNumberService;
            case DATE -> writeDataDateService;
            default -> writeDataDefaultService;
        };
    }

}
