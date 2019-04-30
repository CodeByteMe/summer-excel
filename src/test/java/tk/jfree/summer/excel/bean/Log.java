package tk.jfree.summer.excel.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.jfree.summer.excel.annotation.Column;
import tk.jfree.summer.excel.annotation.Table;
import tk.jfree.summer.excel.type.DateTimeTypeHandler;

/**
 * @author Cheng.Wei
 */
@Getter
@Setter
@ToString
@Table(sheet = "日志信息", start = 1)
public class Log {
    @Column(name = "A", notes = "账号")
    private String username;
    @Column(name = "B", notes = "时间", format = "yyyy-MM-dd hh:mm:ss", typeHandler = DateTimeTypeHandler.class)
    private java.util.Date gmtCreate;
    @Column(name = "C", notes = "操作")
    private String type;

}
