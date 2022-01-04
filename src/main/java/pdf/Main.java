package pdf;

import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by ishi on 2014/05/23.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("start!!");

        File file = new File("data/sample.xls");
        String path = file.getAbsolutePath();
        System.out.println(path);

        InputStream excel = new FileInputStream(path);
        // ワークブックを開く
        Workbook workbook = new HSSFWorkbook(excel);
        // 最初のシートを開く
        Sheet sheet = workbook.getSheetAt(0);

        // セル内に埋め込まれている置換文字を置換
        for (Iterator<Row> sheetIte = sheet.iterator(); sheetIte.hasNext(); ) {
            // 行を取得
            Row row = sheetIte.next();

            for (Iterator<Cell> cellIte = row.iterator(); cellIte.hasNext();) {
                // セルを取得
                Cell cell = cellIte.next();

                // 文字列タイプのセルのみを対象
//                if (cell.getCellType() != Cell.CELL_TYPE_STRING) {
//                    continue;
//                }

                if (cell.getStringCellValue().equals("#TITLE#")) {
                    // 「#NAME#」を置換
                    cell.setCellValue("山田 太郎");
                } else if (cell.getStringCellValue().equals("#BANK_NAME#")) {
                    // 「#BANK_NAME#」を置換
                    cell.setCellValue("渋谷銀行");
                } else if (cell.getStringCellValue().equals("#BRANCH_NAME#")) {
                    // 「#BRANCH__NAME#」を置換
                    cell.setCellValue("恵比寿支店");
                } else if (cell.getStringCellValue().equals("#ACCOUNT_NAME#")) {
                    // 「#ACCOUNT_NAME#」を置換
                    cell.setCellValue("恵比寿 花子");
                } else if (cell.getStringCellValue().equals("#ACCOUNT_NO#")) {
                    // 「#ACCOUNT_NO#」を置換
                    cell.setCellValue("0123456789");
                } else if (cell.getStringCellValue().equals("#CREATE_DATE#")) {
                    // 「#CREATE_DATE#」を置換
                    cell.setCellValue(Calendar.getInstance().getTime());
                } else if (cell.getStringCellValue().equals("#NO#")) {
                    //「#NO#」を置換
                    cell.setCellValue("10020-039");
                } else if (cell.getStringCellValue().equals("#CONTACT_NAME#")) {
                    //「#CONTACT_NAME#」を置換
                    cell.setCellValue("STSD綿田");
                } else if (cell.getStringCellValue().equals("#TEL_NO#")) {
                    // 「#TEL_NO#」を置換
                    cell.setCellValue("03-1111-2222");
                } else if (cell.getStringCellValue().equals("#FAX_NO#")) {
                    // 「#FAX_NO#」を置換
                    cell.setCellValue("03-3333-4444");
                }
            }
        }

        // バッファ内にExcelの内容を書き出す
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        workbook.write(buff);

        // PDF変換時に渡すInputStreamを用意
        ByteArrayInputStream in = new ByteArrayInputStream(buff.toByteArray());
        buff.close();
        excel.close();

        // PDFの出力先を開く
        FileOutputStream out = new FileOutputStream("data/test.pdf");

        // OpenOfficeに接続(localhostの8100番ポート)
        SocketOpenOfficeConnection con = new SocketOpenOfficeConnection(8100);
        con.connect();

        try {
            // ExcelからPDFへ変換
            DocumentConverter converter = new OpenOfficeDocumentConverter(con);
            converter.convert(
                    in, new DefaultDocumentFormatRegistry().getFormatByFileExtension("xls"),
                    out, new DefaultDocumentFormatRegistry().getFormatByFileExtension("pdf")
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // OpenOfficeから切断
            // ここで確実に切断しないとスレッドが終了しません
            con.disconnect();
        }

        out.flush();
        out.close();
        in.close();

    }

}
