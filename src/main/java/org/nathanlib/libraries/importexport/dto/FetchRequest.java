package org.nathanlib.libraries.importexport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author duyenthai
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchRequest<R> {
    private R request;
    private Page pageable;
    private Boolean fetchAll;
}
