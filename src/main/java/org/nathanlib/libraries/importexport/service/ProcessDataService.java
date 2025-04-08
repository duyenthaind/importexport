package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.common.BaseResponse;
import org.nathanlib.libraries.importexport.common.BatchResponse;

import java.util.List;

/**
 * @author duyenthai
 */
public interface ProcessDataService<T> {
    BatchResponse processBatch(List<T> batch);

    BaseResponse process(T data);
}
