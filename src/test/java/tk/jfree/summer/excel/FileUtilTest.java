package tk.jfree.summer.excel;

import java.net.URISyntaxException;

/**
 * @author Cheng.Wei
 */
public class FileUtilTest {
    public static String getWebRootPath(String filePath) {
        try {
            String path = FileUtilTest.class.getClassLoader().getResource("").toURI().getPath();
            return path + filePath;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
