package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.dto.FetchRequest;

import java.util.List;

/**
 * @author duyenthai
 */
public interface FetchDataService<T, R> {
    List<T> fetch(FetchRequest<R> request);
}
