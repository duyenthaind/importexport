package org.nathanlib.libraries.importexport.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author duyenthai
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ExportResponse extends BaseResponse {
    private String message;
    private String filePath;
    private String fileName;

}
