package org.nathanlib.libraries.importexport.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author duyenthai
 */
@Data
@Builder
public class CellData {
    private String name;
    private Object cellValue;
    private String cellType;
    private Integer rowNumber;
    private Integer columnNumber;

}
