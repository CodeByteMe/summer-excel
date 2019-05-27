package tk.jfree.summer.excel.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.jfree.summer.excel.annotation.Column;
import tk.jfree.summer.excel.annotation.Table;
import tk.jfree.summer.excel.type.EnumTypeHandler;

import java.io.Serializable;

/**
 * @author Cheng.Wei
 */
@Getter
@Setter
@ToString
@Table(sheet = "api", first = 1)
public class Api implements Serializable {
    private static final long serialVersionUID = 5157310469743826822L;
    @Column(name = "B")
    private String name;
    @Column(name = "C")
    private String uri;
    @Column(name = "D", typeHandler = EnumTypeHandler.class)
    private HttpMethod method;
}
