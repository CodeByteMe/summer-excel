package tk.jfree.summer.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

/**
 * Excel 单元格取值
 * @author Cheng.Wei
 */
public class ExcelCellValue {
    /**
     * 取值
     * @param cell
     * @return 根据单元格类型返回 {@link org.apache.poi.ss.usermodel.CellType}
     */
    public static Object get(Cell cell){
        if (cell == null){
            return null;
        }
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();

        } else if (cell.getCellType() == CellType.BOOLEAN) {
            return cell.getBooleanCellValue();

        } else if (cell.getCellType() == CellType.FORMULA) {
            return cell.getCellFormula();

        } else if (cell.getCellType() == CellType.NUMERIC) {
            return  cell.getNumericCellValue();
        }
        return null;
    }
}
