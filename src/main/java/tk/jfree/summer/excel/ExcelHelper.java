package tk.jfree.summer.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.jfree.summer.excel.annotation.Table;
import tk.jfree.summer.excel.exception.ExcelException;
import tk.jfree.summer.excel.reflection.Reflector;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Excel 数据读取
 * @author Cheng.Wei
 */
public class ExcelHelper<T> {

    private static final Logger log = LoggerFactory.getLogger(ExcelHelper.class);

    private Class<T> clazz;

    private ExcelHelper(Class clazz) {
        this.clazz = clazz;
    }

    /**
     *
     * @param clazz
     * @return Excel读取结果
     * @throws Exception
     */
    public static ExcelHelper builder(Class clazz){
        return new ExcelHelper(clazz);
    }

    /**
     * 默认读取第一个 sheet=0  {@link tk.jfree.summer.excel.annotation.Table#sheet}
     * 默认start =1  {@link tk.jfree.summer.excel.annotation.Table#first}
     * @param input InputStream
     * @return Excel读取结果
     */
    public ExcelResult read(InputStream input)throws Exception{
        Table table = Optional.ofNullable(clazz.getAnnotation(Table.class)).orElseThrow(()-> new ExcelException(clazz+"缺少tk.jfree.summer.excel.annotation.Table注解"));
        return read(table.sheet(), table.first(), input);
    }

    /**
     * 设置读取相关参数
     * @param sheetName sheet 名称
     * @param start 数据所在的行
     * @param input InputStream
     * @return Excel读取结果
     */
    public ExcelResult read(String sheetName, int start, InputStream input) throws Exception{
        Workbook book = WorkbookFactory.create(input);
        Sheet sheet = Optional.ofNullable(book.getSheet(sheetName)).orElse(book.getSheetAt(0));
        sheet.setForceFormulaRecalculation(true);
        if (Reflector.of(clazz).isEmpty()){
            log.debug("{}缺少@Column注解", clazz);
            return ExcelResult.builder().sheet(sheet.getSheetName()).firstRow(start).lastRow(sheet.getLastRowNum()).build();
        }
        List tList = new ArrayList<>(sheet.getLastRowNum()-start);
        for (int i = start, length = sheet.getLastRowNum(); i <= length; i++) {
            Row row = sheet.getRow(i);
            T t = clazz.newInstance();
            Reflector.of(clazz).forEach((k, v) -> v.invoke(t, row.getCell(k)));
            tList.add(t);
        }
        return ExcelResult.builder().sheet(sheet.getSheetName()).firstRow(start).lastRow(sheet.getLastRowNum()).data(tList).build();
    }
}
