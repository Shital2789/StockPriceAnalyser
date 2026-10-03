package Tests;

import java.time.LocalDate;
import java.util.TreeMap;

import org.testng.annotations.Test;

import Utils.ExcelReader;
import org.testng.Assert;
import Utils.StockPriceAnalyzer;

public class StockPriceTest {

	
    @Test
    public void readStockPrices() throws Exception {

        TreeMap<LocalDate, Double> prices = ExcelReader.loadPrices();

        System.out.println("Stock Prices:");

        for (LocalDate date : prices.keySet()) {
            System.out.println(date + " : " + prices.get(date));
        }
    }
        
    

    @Test
    public void findHighestAndLowestPrice() throws Exception {

        TreeMap<LocalDate, Double> prices = ExcelReader.loadPrices();

        double highestPrice = Double.MIN_VALUE;
        double lowestPrice = Double.MAX_VALUE;

        LocalDate highestPriceDate = null;
        LocalDate lowestPriceDate = null;

        for (LocalDate date : prices.keySet()) {

            double price = prices.get(date);

            if (price > highestPrice) {
                highestPrice = price;
                highestPriceDate = date;
            }

            if (price < lowestPrice) {
                lowestPrice = price;
                lowestPriceDate = date;
            }
        }

        System.out.println("Highest Price: " + highestPrice);
        System.out.println("Highest Price Date: " + highestPriceDate);

        System.out.println("Lowest Price: " + lowestPrice);
        System.out.println("Lowest Price Date: " + lowestPriceDate);
    }

@Test
public void calculateAveragePrice() throws Exception {

    TreeMap<LocalDate, Double> prices = ExcelReader.loadPrices();

    double total = 0;

    for (double price : prices.values()) {
        total = total + price;
    }

    double averagePrice = total / prices.size();

    System.out.println("Total Price: " + total);
    System.out.println("Number of Records: " + prices.size());
    System.out.println("Average Stock Price: " + averagePrice);
}


@Test
public void validateHighestAndLowestPrice() throws Exception {

    TreeMap<LocalDate, Double> prices = ExcelReader.loadPrices();

    double highestPrice = StockPriceAnalyzer.findHighestPrice(prices);
    double lowestPrice = StockPriceAnalyzer.findLowestPrice(prices);

    Assert.assertEquals(highestPrice, 215.69);
    Assert.assertEquals(lowestPrice, 188.73);

    System.out.println("Highest Price: " + highestPrice);
    System.out.println("Lowest Price: " + lowestPrice);

    System.out.println("Highest and lowest price validation passed");
}
    
   

@Test
public void validateAveragePrice() throws Exception {

    TreeMap<LocalDate, Double> prices = ExcelReader.loadPrices();

    double total = 0;

    for (double price : prices.values()) {
        total = total + price;
    }

    double averagePrice = total / prices.size();

    Assert.assertEquals(averagePrice, 200.9972727272727, 0.001);

    System.out.println("Average price validation passed");
}

@Test
public void validateNumberOfRecords() throws Exception {

    TreeMap<LocalDate, Double> prices = ExcelReader.loadPrices();

    Assert.assertEquals(prices.size(), 22);

    System.out.println("Number of records validation passed");
}

@Test
public void validateHighestAndLowestPriceDates() throws Exception {

    TreeMap<LocalDate, Double> prices = ExcelReader.loadPrices();

    LocalDate highestPriceDate =
            StockPriceAnalyzer.findHighestPriceDate(prices);

    LocalDate lowestPriceDate =
            StockPriceAnalyzer.findLowestPriceDate(prices);

    Assert.assertEquals(highestPriceDate, LocalDate.of(2026, 6, 1));
    Assert.assertEquals(lowestPriceDate, LocalDate.of(2026, 6, 29));

    System.out.println("Highest Price Date: " + highestPriceDate);
    System.out.println("Lowest Price Date: " + lowestPriceDate);

    System.out.println("Highest and lowest price date validation passed");
}

}