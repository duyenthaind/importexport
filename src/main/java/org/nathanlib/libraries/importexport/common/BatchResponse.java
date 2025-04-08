package org.nathanlib.libraries.importexport.common;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author duyenthai
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class BatchResponse extends BaseResponse {
    private int totalRecord;
    private int successRecord;
    private int failedRecord;
    private List<String> dbResponses;

    @Builder(builderMethodName = "batchResponseBuilder")
    public BatchResponse(int totalRecord, int successRecord, int failedRecord, List<String> dbResponses, int rc, String rd) {
        super(rc, rd);
        this.totalRecord = totalRecord;
        this.successRecord = successRecord;
        this.failedRecord = failedRecord;
        this.dbResponses = dbResponses;
    }
}
