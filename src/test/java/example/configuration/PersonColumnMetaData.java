package example.configuration;

import org.nathanlib.libraries.importexport.common.DataType;
import org.nathanlib.libraries.importexport.dto.CellMetaData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author duyenthai
 */
public class PersonColumnMetaData {
    public static final List<CellMetaData> META_DATA_LIST = new ArrayList<>();

    static {
        META_DATA_LIST.add(CellMetaData.builder()
                .name("Name")
                .dataType(DataType.STRING)
                .fieldName("name")
                .build());
        META_DATA_LIST.add(CellMetaData.builder()
                .name("Age")
                .dataType(DataType.NUMBER)
                .fieldName("age")
                .build());
        META_DATA_LIST.add(CellMetaData.builder()
                .name("Address")
                .dataType(DataType.STRING)
                .fieldName("address")
                .build());
    }

    public static List<CellMetaData> getMetaDataList() {
        return META_DATA_LIST;
    }

    public static Map<String, CellMetaData> getMetaDataMap() {
        return META_DATA_LIST.stream().collect(Collectors.toMap(CellMetaData::getName, Function.identity()));
    }


}
