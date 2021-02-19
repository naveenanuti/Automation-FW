package TestData;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Readnwrite {


    static public  String  readdata(String sheetname, int row, int column) throws IOException {

        FileInputStream fis = new FileInputStream("./src/main/resources/data/data.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet s = wb.getSheet( sheetname);
        Row r = s.getRow(row);
        Cell c = r.getCell(column);
        return c.toString();





    }




}
