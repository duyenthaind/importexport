package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.utils.ReflectionUtils;

import java.util.Optional;

/**
 * @author duyenthai
 */
public class WriteDataNumberService implements WriteDataService {
    @Override
    public Object parseInputData(Object input, String fieldName) throws Exception {
        Optional<Object> res = ReflectionUtils.getFieldValue(input, fieldName);
        if (res.isEmpty()) {
            return null;
        }
        Object value = res.get();
        if (value instanceof Number) {
            return value;
        }
        return Double.parseDouble(value.toString());
    }

}
