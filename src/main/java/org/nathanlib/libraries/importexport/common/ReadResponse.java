package org.nathanlib.libraries.importexport.common;

import org.nathanlib.libraries.importexport.dto.RowError;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author duyenthai
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReadResponse<T> extends BaseResponse {
    private int readCount;
    private int failedCount;
    private List<T> data;
    private List<RowError> rowErrors;
}
