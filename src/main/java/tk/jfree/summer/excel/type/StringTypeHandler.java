package tk.jfree.summer.excel.type;

import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;

/**
 * 字符串类型java.lang.String
 * @author Cheng.Wei
 *
 */
public class StringTypeHandler extends AbstractTypeHandler<java.lang.String>{
    public StringTypeHandler(Field field) {
        super(field);
    }

    @Override
    public String get(Cell cell) throws Exception {
        return cell.getStringCellValue();
    }
}
