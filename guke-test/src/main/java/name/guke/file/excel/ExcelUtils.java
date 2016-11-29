package name.guke.file.excel;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by GUKE on 2016/11/2.
 */
public class ExcelUtils {

    public static String encodingFileName(String fileName) {
        String returnFileName = "";
        try {
            returnFileName = URLEncoder.encode(fileName, "UTF-8");
            returnFileName = StringUtils.replace(returnFileName, "+", "%20");
            if (returnFileName.length() > 150) {
                returnFileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
                returnFileName = StringUtils.replace(returnFileName, " ", "%20");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return returnFileName;
    }
}
