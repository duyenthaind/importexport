package org.nathanlib.libraries.importexport.dto;

import org.nathanlib.libraries.importexport.common.DataType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author duyenthai
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CellMetaData {
    private String name;
    private DataType dataType;
    private boolean checkNull;
    private boolean checkEmpty;
    private String fieldName;
}
