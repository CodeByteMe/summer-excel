# summer-excel

## 介绍
summer-excel是一个基于对象关系映射稳定、便捷、可定制的Excel数据读取工具。

## 运行环境
JDK1.8

## 使用示例

### 数据类型

|JavaType|ExcelType|
|:---|:---|
|java.lang.String |CellType.STRING|
|java.lang.Boolean|CellType.BOOLEAN|
|java.lang.Integer|CellType.NUMERIC|
|java.lang.Date   |CellType.NUMERIC|
|java.lang.Enum   |CellType.STRING|
| ...|...|

### 使用 Maven  

在 pom.xml 中添加如下依赖：

```xml 
<dependency>
  <groupId>tk.jfree.summer</groupId>
  <artifactId>summer-excel</artifactId>
  <version>0.1.0</version>
</dependency>
```


### 对象关系映射
``` Java
@Table(sheet = "日志信息", first = 1)
public class Log {
    @Column(name = "A", notes = "账号")
    private String username;
    @Column(name = "B", notes = "时间", format = "yyyy-MM-dd hh:mm:ss", typeHandler = DateTimeTypeHandler.class)
    private java.util.Date gmtCreate;
    @Column(name = "C", notes = "操作")
    private String type;

}
``` 
### Excel读取
``` Java
  ExcelHelper.builder(Log.class).read(new FileInputStream("log.xlsx")).getData().stream().forEach(System.out::println);
``` 

### 自定义数据类型转换
summer-excel支持自定义数据类型转换
#### 方式一 实现tk.jfree.summer.excel.type.TypeHandler
``` Java
public class DateTimeTypeHandler implements TypeHandler<java.util.Date> {
    private final Field field;

    public DateTimeTypeHandler(Field field) {
        this.field = field;
    }

    @Override
    public Date get(Cell cell) throws Exception{
          //TODO
        return null;
    }
}

```
#### （推荐）方式二 继承tk.jfree.summer.excel.type.AbstractTypeHandler
``` Java

public class DateTimeTypeHandler extends AbstractTypeHandler<java.util.Date> {

    public DateTimeTypeHandler(Field field) {
        super(field);
    }

    @Override
    public Date get(Cell cell) throws Exception{
          //TODO
        return null;
    }
}

```