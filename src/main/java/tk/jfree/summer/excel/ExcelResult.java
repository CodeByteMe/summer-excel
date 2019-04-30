package tk.jfree.summer.excel;

import lombok.*;

import java.util.List;

/**
 * 数据读取结果
 * @author Cheng.Wei
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExcelResult<T> {
    /**sheet name*/
    private String sheet;
    /**首行（不含表头）*/
    private Integer firstRow;
    /**最后一行*/
    private Integer lastRow;
    /**读取的数据*/
    private List<T> data;
}
