package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.helper.ILogger;
import org.nathanlib.libraries.importexport.utils.ReflectionUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * @author duyenthai
 */
public class WriteDataDateService implements WriteDataService {

    private final ILogger logger;

    private final String dateFormat;
    private final SimpleDateFormat sdf;

    public WriteDataDateService(ILogger logger) {
        this.dateFormat = "dd/MM/yyyy";

        this.sdf = new SimpleDateFormat(dateFormat);
        this.logger = logger;
    }

    public WriteDataDateService(String dateFormat, ILogger logger) {
        this.dateFormat = dateFormat;

        this.sdf = new SimpleDateFormat(dateFormat);
        this.logger = logger;
    }

    @Override
    public Object parseInputData(Object input, String fieldName) throws Exception {
        Optional<Object> res = ReflectionUtils.getFieldValue(input, fieldName);
        if (res.isEmpty()) {
            return null;
        }
        Object value = res.get();

        if (value instanceof Date date) {
            return sdf.format(date);
        }

        if (value instanceof Instant instant) {
            return sdf.format(Date.from(instant));
        }

        if (value instanceof Long longValue) {
            return sdf.format(new Date(longValue));
        }

        if (value instanceof Timestamp timestamp) {
            return sdf.format(new Date(timestamp.getTime()));
        }

        if (value instanceof String) {
            Date date = sdf.parse(value.toString());
            return Objects.nonNull(date) ? sdf.format(date) : null;
        }

        return null;
    }

}
