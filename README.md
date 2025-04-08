A library for importing and exporting entities to Excel file
Can be used for Java core and Spring boot

# 1. How to use:
Include this dependency to your project or you and build it yourself :D
- Setup dependency to jitpack:
```
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
- Add dependency:
```
	        implementation 'com.github.duyenthaind:importexport:1.0.0'
```
# 2. Example:
### Import
```
# Create an import service
public ReadImportFileService<Person> getReadImportFileService() {
        return new ReadImportFileServiceImpl<>(
                new ParsePersonService(),
                new ReadRowProcessor(
                        new ParseCellDataStrategy(
                                new ParseCellDefaultService(),
                                new ParseCellDateService("dd/MM/yyyy", new Log4j2Logger()),
                                new ParseCellNumberService()
                        ),
                        PersonColumnMetaData.getMetaDataMap()
                ),
                logger
        );
    }

# Call it
ReadImportFileService<Person> readService = Configuration.getInstance().getReadImportFileService();

        ReadResponse<Person> readResponse = readService.importFile(fileImport);
        Configuration.logger.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(readResponse));
```
### Export
```
# Create an export service
 public WriteExportFileService<Person, FetchPersonRequest> getWriteExportFileService() {
        return new WriteExportFileServiceImpl<>(
                new FetchPersonService(),
                new WriteRowProcessor(
                        new WriteDataServiceStrategy(
                                new WriteDataDefaultService(),
                                new WriteDataNumberService(),
                                new WriteDataDateService("dd/MM/yyyy", logger)
                        ),
                        PersonColumnMetaData.getMetaDataList(),
                        logger
                ),
                logger
        );
    }

# Call it
 WriteExportFileService<Person, FetchPersonRequest> writeService = Configuration.getInstance().getWriteExportFileService();
        String folderPath = System.getProperty("user.dir") + File.separator + "output";
        String fileName = "person_export";
        FetchPersonRequest fetchPersonRequest = new FetchPersonRequest();
        FetchRequest<FetchPersonRequest> fetchRequest = new FetchRequest<>(fetchPersonRequest, new Page(0, 10), true);

        ExportResponse exportRes = writeService.exportFile(folderPath, fileName, fetchRequest);
```

All full example can be seen in the test package of this repository
