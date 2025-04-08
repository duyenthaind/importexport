package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.common.ExportResponse;
import org.nathanlib.libraries.importexport.dto.FetchRequest;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author duyenthai
 */
public interface WriteExportFileService<T, R> {

    Workbook create(String folderPath, String fileName) throws Exception;

    ExportResponse process(Workbook workbook, String filePath, FetchRequest<R> fetchRequest) throws Exception;

    ExportResponse exportFile(String folderPath, String fileName, FetchRequest<R> fetchRequest) throws Exception;

}
