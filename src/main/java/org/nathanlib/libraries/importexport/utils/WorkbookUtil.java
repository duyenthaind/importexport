package org.nathanlib.libraries.importexport.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Objects;

/**
 * @author duyenthai
 */
public class WorkbookUtil {

    public static Workbook create(String filePath, boolean isOverride) {
        File file = new File(filePath);
        if (file.exists() && !isOverride) {
            return null;
        }
        return new XSSFWorkbook();
    }

    public static void write(Workbook workbook, String filePath, boolean isOverride, boolean closeWorkbook) throws Exception {
        OutputStream outputStream = null;
        try {
            File file = new File(filePath);
            if (file.exists() && !isOverride) {
                return;
            }
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
        } finally {
            if (closeWorkbook) {
                workbook.close();
            }
            if (Objects.nonNull(outputStream)) {
                outputStream.close();
            }
        }
    }
}
