package org.nathanlib.libraries.importexport.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author duyenthai
 */
@Data
@Builder
public class RowData {
    private int lineNumber;
    private List<CellData> cells;

}
