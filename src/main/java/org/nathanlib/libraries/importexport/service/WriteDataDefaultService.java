package org.nathanlib.libraries.importexport.service;

import org.nathanlib.libraries.importexport.utils.ReflectionUtils;

import java.util.Optional;

/**
 * @author duyenthai
 */
public class WriteDataDefaultService implements WriteDataService {
    @Override
    public Object parseInputData(Object input, String fieldName) throws Exception {
        Optional<Object> res = ReflectionUtils.getFieldValue(input, fieldName);
        return res.<Object>map(Object::toString).orElse(null);
    }

}
