package tk.jfree.summer.excel.type;

import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;

/**
 * 普通枚举类转换
 * @author Cheng.Wei
 */
public class EnumTypeHandler extends AbstractTypeHandler<Enum> {

    public EnumTypeHandler(Field field) {
        super(field);
    }

    @Override
    public Enum get(Cell cell) throws Exception {
        String val = cell.getStringCellValue();
        return val == null ? null : Enum.valueOf((Class) super.getField().getType(), val);
    }
}
