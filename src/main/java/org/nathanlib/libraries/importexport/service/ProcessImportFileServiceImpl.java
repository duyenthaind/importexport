package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.common.BatchResponse;
import org.nathanlib.libraries.importexport.common.ImportResponse;
import org.nathanlib.libraries.importexport.common.ReadResponse;
import lombok.RequiredArgsConstructor;

/**
 * @author duyenthai
 */
@RequiredArgsConstructor
public class ProcessImportFileServiceImpl<T> implements ProcessImportFileService<T> {
    private final ReadImportFileService<T> readImportFileService;
    private final ProcessDataService<T> processDataService;

    @Override
    public ImportResponse process(String filePath) throws Exception {
        ImportResponse response = new ImportResponse();
        response.setFailed();

        ReadResponse<T> readResponse = readImportFileService.importFile(filePath);
        if (readResponse == null) {
            return response;
        }
        response = ImportResponse.importResponseBuilder()
                .readCount(readResponse.getReadCount())
                .readFailed(readResponse.getFailedCount())
                .rowErrors(readResponse.getRowErrors())
                .build();
        if (readResponse.getRc() != 0 || readResponse.getReadCount() <= 0) {
            return response;
        }

        BatchResponse batchResponse = processDataService.processBatch(readResponse.getData());
        if (batchResponse != null) {
            response.setTotalRecord(batchResponse.getTotalRecord());
            response.setSuccessRecord(batchResponse.getSuccessRecord());
            response.setFailedRecord(batchResponse.getFailedRecord());
            response.setDbResponses(batchResponse.getDbResponses());
        }
        return response;
    }
}
