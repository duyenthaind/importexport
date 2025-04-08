package org.nathanlib.libraries.importexport.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author duyenthai
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BaseResponse {
    private int rc;
    private String rd;

    public void setSuccess() {
        this.rc = 0;
        this.rd = "Success";
    }

    public void setFailed() {
        this.rc = 1;
        this.rd = "Failed";
    }

    public void setFailed(String msg) {
        this.rc = 1;
        this.rd = msg;
    }
}
