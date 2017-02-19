package stock;

import java.util.ArrayList;

/**
 * Created by vv on 2017/2/19.
 */
public class Stock {
    public String code;
    public String name;
    public String industry;
    public int industryOrder;
    public TimeSeries<Price> dayPrices;
    public TimeSeries<Report> yearReports;
}
