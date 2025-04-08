package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nathanlib.libraries.importexport.common.ExportResponse;
import org.nathanlib.libraries.importexport.common.ReadResponse;
import org.nathanlib.libraries.importexport.dto.FetchRequest;
import org.nathanlib.libraries.importexport.dto.Page;
import org.nathanlib.libraries.importexport.service.ReadImportFileService;
import org.nathanlib.libraries.importexport.service.WriteExportFileService;
import example.common.Person;
import example.dto.FetchPersonRequest;

import java.io.File;

/**
 * @author duyenthai
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("Hello world!");
        Configuration.getInstance().init();

        String fileImport = System.getProperty("user.dir") + File.separator + "person.xlsx";

        ReadImportFileService<Person> readService = Configuration.getInstance().getReadImportFileService();

        ReadResponse<Person> readResponse = readService.importFile(fileImport);
        Configuration.logger.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(readResponse));

        WriteExportFileService<Person, FetchPersonRequest> writeService = Configuration.getInstance().getWriteExportFileService();
        String folderPath = System.getProperty("user.dir") + File.separator + "output";
        String fileName = "person_export";
        FetchPersonRequest fetchPersonRequest = new FetchPersonRequest();
        FetchRequest<FetchPersonRequest> fetchRequest = new FetchRequest<>(fetchPersonRequest, new Page(0, 10), true);

        ExportResponse exportRes = writeService.exportFile(folderPath, fileName, fetchRequest);
        Configuration.logger.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(exportRes));
    }
}