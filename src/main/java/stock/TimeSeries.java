package stock;

import java.util.ArrayList;
import java.util.List;

public class TimeSeries<T> extends ArrayList<T>{
    public T last(){
        return get(0);
    }

    public List<T> lastN(int n){
        int lastIndex = n < size() ? n - 1 : size() - 1;
        return subList(0, lastIndex);
    }
}
