package tk.jfree.summer.excel.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.jfree.summer.excel.annotation.Column;
import tk.jfree.summer.excel.annotation.Table;
import tk.jfree.summer.excel.type.DateTimeTypeHandler;
import tk.jfree.summer.excel.type.IntegerTypeHandler;

/**
 * @author Cheng.Wei
 */
@Getter
@Setter
@ToString
@Table(sheet = "人员信息", start = 1)
public class Employee {
    @Column(name = "A", notes = "姓名")
    private String name;
    @Column(name = "B", notes = "年龄", typeHandler = IntegerTypeHandler.class)
    private Integer age;
    @Column(name = "C", notes = "录入时间", format = "yyyy-MM-dd hh:mm:ss", typeHandler = DateTimeTypeHandler.class)
    private java.util.Date gmtCreate;
}
