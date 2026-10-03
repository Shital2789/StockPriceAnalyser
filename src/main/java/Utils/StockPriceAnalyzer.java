package Utils;


	import java.time.LocalDate;
	import java.util.Map;
	import java.util.TreeMap;




	public class StockPriceAnalyzer {

	    public static double findHighestPrice(TreeMap<LocalDate, Double> prices) {

	        double highestPrice = Double.NEGATIVE_INFINITY;

	        for (double price : prices.values()) {

	            if (price > highestPrice) {
	                highestPrice = price;
	            }
	        }

	        return highestPrice;
	    }

	    public static double findLowestPrice(TreeMap<LocalDate, Double> prices) {

	        double lowestPrice = Double.POSITIVE_INFINITY;

	        for (double price : prices.values()) {

	            if (price < lowestPrice) {
	                lowestPrice = price;
	            }
	        }

	        return lowestPrice;
	    }

	    public static double calculateAveragePrice(TreeMap<LocalDate, Double> prices) {

	        double total = 0;

	        for (double price : prices.values()) {
	            total = total + price;
	        }

	        return total / prices.size();
	    }

	    public static LocalDate findHighestPriceDate(TreeMap<LocalDate, Double> prices) {

	        double highestPrice = findHighestPrice(prices);

	        for (Map.Entry<LocalDate, Double> entry : prices.entrySet()) {

	            if (entry.getValue() == highestPrice) {
	                return entry.getKey();
	            }
	        }

	        return null;
	    }

	    public static LocalDate findLowestPriceDate(TreeMap<LocalDate, Double> prices) {

	        double lowestPrice = findLowestPrice(prices);

	        for (Map.Entry<LocalDate, Double> entry : prices.entrySet()) {

	            if (entry.getValue() == lowestPrice) {
	                return entry.getKey();
	            }
	        }

	        return null;
	    }
	}
