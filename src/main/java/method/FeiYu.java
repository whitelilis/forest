package method;

import stock.Price;
import stock.Report;
import stock.Stock;

import java.util.List;

/**
 * Created by vv on 2017/2/19.
 */
public class FeiYu {
    public float buyValue(Stock stock){
        return safeValue(stock) * growthValue(stock);
    }

    public float priceEarningRatio(Stock stock){
        Price lastPrice = stock.dayPrices.last();
        Report lastReport = stock.yearReports.last();
        return lastPrice.closePrice / lastReport.earningPerStock;
    }

    public float lastThreeAvageGrowthRate(Stock stock){
        List<Report> reportList = stock.yearReports.lastN(3);
        float sum =  0.0F;
        for(Report report : reportList){
            sum += report.netProfitGrowthRate;
        }
        return sum / reportList.size();
    }
     public float lastThreeDividentRate(Stock stock){
        List<Report> reportList = stock.yearReports.lastN(3);
        float sum =  0.0F;
        for(Report report : reportList){
            sum += report.dividentRate;
        }
        return sum / reportList.size();
    }

    public float growthValue(Stock stock){
        return 100.0F * (lastThreeAvageGrowthRate(stock) + lastThreeDividentRate(stock)) / priceEarningRatio(stock);
    }

    //
    public boolean black(Stock stock){
        return inBlackList(stock) ||
                financeDoubt(stock) ||
                moreThan2RationedShareLast5year(stock) ||
                nameDoubt(stock);
    }

    public float safeValue(Stock stock) {
        if (black(stock)) {
            return 0.0F;
        } else {
            float result = 0;
            boolean[] checks = new boolean[3];
            checks[2] = marketShareTop(stock);
            checks[1] = buyBackPriceHigherThanCurrentPrice(stock);
            checks[0] = dividentMoreThanRaiseMoney(stock);
            for (boolean b : checks) {
                if (b) {
                    result += 1F;
                }
            }
            return result;
        }
    }

    public float otherPlus(Stock stock){
        // 13 14 15
        return 0.0F;
    }
}






}
