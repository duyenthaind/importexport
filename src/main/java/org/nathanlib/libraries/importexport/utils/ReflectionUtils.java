package org.nathanlib.libraries.importexport.utils;

import java.lang.reflect.Field;
import java.util.Optional;

/**
 * @author duyenthai
 */
public class ReflectionUtils {
    public static Optional<Object> getFieldValue(Object object, String fieldName) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return Optional.ofNullable(field.get(object));
    }
}
