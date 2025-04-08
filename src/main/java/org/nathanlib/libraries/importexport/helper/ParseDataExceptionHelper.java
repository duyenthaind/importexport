package org.nathanlib.libraries.importexport.helper;

import org.nathanlib.libraries.importexport.dto.CellError;
import org.nathanlib.libraries.importexport.dto.RowError;
import org.nathanlib.libraries.importexport.exception.ParseDataException;

import java.util.List;

/**
 * @author duyenthai
 */
public class ParseDataExceptionHelper {

    private ParseDataExceptionHelper() {
    }

    public static ParseDataExceptionHelper getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public RowError parseException(ParseDataException pEx) {
        List<String> fields = pEx.getFieldNames();
        if (fields == null || fields.isEmpty()) {
            return RowError.builder().row(pEx.getLineNumber()).build();
        }
        return RowError.builder().row(pEx.getLineNumber())
                .fields(parseFields(fields, pEx.getMessage()))
                .build();
    }

    private List<CellError> parseFields(List<String> fields, String error) {
        return fields.stream().map(field -> CellError.builder()
                .name(field)
                .error(error)
                .build()).toList();
    }

    private static class SingletonHelper {
        private static final ParseDataExceptionHelper INSTANCE = new ParseDataExceptionHelper();
    }
}
