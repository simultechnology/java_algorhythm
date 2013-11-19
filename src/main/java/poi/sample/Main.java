package poi.sample;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/11/04
 * Time: 0:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Workbook wb = null;
        try(FileInputStream in = new FileInputStream("qustion_ace2.xls")) {
            wb = WorkbookFactory.create(in);
        }
        catch (IOException e){
            System.out.println(e.toString());
        }
        catch (InvalidFormatException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        Sheet sheet = wb.getSheetAt(0);

        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();

        for (int i = 1; i < lastRowNum; i++) {
            Row row = sheet.getRow(i);
            short firstCellNum = row.getFirstCellNum();
            short lastCellNum = row.getLastCellNum();
            Cell cellOfTitle = row.getCell(3);// Titleの取得
            if (cellOfTitle == null) {
                continue;
            }
            Cell cellOfExplanation = row.getCell(10);// Titleの取得
            System.out.println(cellOfExplanation.getStringCellValue());
        }
    }
}
