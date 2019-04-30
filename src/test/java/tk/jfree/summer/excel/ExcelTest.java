package tk.jfree.summer.excel;

import tk.jfree.summer.excel.bean.Employee;
import tk.jfree.summer.excel.bean.Log;

import java.io.FileInputStream;

/**
 * @author Cheng.Wei
 */
public class ExcelTest {
    public static void main(String[] args) {
        try{
            ExcelHelper.builder(Employee.class).read(new FileInputStream(FileUtilTest.getWebRootPath("employee.xlsx"))).getData().stream().forEach(System.out::println);
            System.out.println("==============================");
            ExcelHelper.builder(Log.class).read( new FileInputStream(FileUtilTest.getWebRootPath("employee.xlsx"))).getData().stream().forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
