package name.guke.file.excel;

import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by GUKE on 2016/11/2.
 */
public abstract class JxlUtils implements Serializable {
    private static final long serialVersionUID = 2246395367043276044L;

    public static void exportExcel(String[] headers, List<String[]> datas) {

    }

    public static void importExcel() {

    }

    public static WritableWorkbook create(final OutputStream os) throws IOException {
        return Workbook.createWorkbook(os);
    }

    public static WritableWorkbook create(final File file) throws IOException {
        return Workbook.createWorkbook(file);
    }

    public static Workbook read(final File file) throws IOException, BiffException {
        return Workbook.getWorkbook(file);
    }

    public static Workbook read(final InputStream is) throws IOException, BiffException {
        return Workbook.getWorkbook(is);
    }

    public static WritableSheet[] getSheets(final WritableWorkbook workbook) {
        if (workbook == null) {
            return new WritableSheet[]{};
        }
        return workbook.getSheets();
    }

    public static String[] getSheetNames(final WritableWorkbook workbook) {
        if (workbook == null) {
            return new String[]{};
        }
        return workbook.getSheetNames();
    }

    public static int getSheetCount(final WritableWorkbook workbook) {
        if (workbook == null) {
            return 0;
        }
        return workbook.getNumberOfSheets();
    }

    public static boolean hasSheets(final Workbook workbook) {
        return workbook != null && workbook.getNumberOfSheets() > 0;
    }

    public static boolean isEmpty(final Cell cell) {
        return cell == null || cell.getContents() == null || cell.getContents().length() == 0;
    }

    public static boolean isEmpty(final Cell[] cells) {
        if (cells == null || cells.length == 0) {
            return true;
        }
        for (final Cell cell : cells) {
            if (!isEmpty(cell)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> getContentLists(final Cell[] cells) {
        return Arrays.asList(getContents(cells));
    }

    public static String[] getContents(final Cell[] cells) {
        if (isEmpty(cells)) {
            return new String[]{};
        }
        final String[] values = new String[cells.length];
        for (final Cell cell : cells) {
            values[cell.getColumn()] = isEmpty(cell) ? null : cell.getContents();
        }
        return values;
    }

}
