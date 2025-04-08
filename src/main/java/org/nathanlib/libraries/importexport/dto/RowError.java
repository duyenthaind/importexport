package org.nathanlib.libraries.importexport.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author duyenthai
 */
@Data
@Builder
public class RowError {
    private int row;
    private List<CellError> fields;
}
