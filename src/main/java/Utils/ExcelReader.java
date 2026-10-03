package Utils;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static TreeMap<LocalDate, Double> loadPrices() throws Exception {

        TreeMap<LocalDate, Double> prices = new TreeMap<>();

        String filePath = "src/test/resources/StockPrices.xlsx";

        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            Cell dateCell = row.getCell(0);
            Cell priceCell = row.getCell(1);

            LocalDate date;

            if (DateUtil.isCellDateFormatted(dateCell)) {
                date = dateCell.getLocalDateTimeCellValue().toLocalDate();
            } else {
                date = LocalDate.parse(dateCell.getStringCellValue());
            }

            double price = priceCell.getNumericCellValue();

            prices.put(date, price);
        }

        workbook.close();
        fis.close();

        return prices;
    }
}