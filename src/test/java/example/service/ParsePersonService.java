package example.service;

import org.nathanlib.libraries.importexport.dto.CellData;
import org.nathanlib.libraries.importexport.dto.RowData;
import example.common.Person;
import org.nathanlib.libraries.importexport.exception.ParseDataException;
import org.nathanlib.libraries.importexport.service.ParseDataService;

/**
 * @author duyenthai
 */
public class ParsePersonService implements ParseDataService<Person> {

    @Override
    public Person parseEntity(RowData rowData) throws ParseDataException {
        Person person = new Person();
        for (CellData cellData : rowData.getCells()) {
            switch (cellData.getName()) {
                case "Name":
                    person.setName(cellData.getCellValue() + "");
                    break;
                case "Age":
                    person.setAge(((Double) cellData.getCellValue()).intValue());
                    break;
                case "Address":
                    person.setAddress(cellData.getCellValue() + "");
                    break;
                default:
                    break;
            }
        }
        return person;
    }
}
