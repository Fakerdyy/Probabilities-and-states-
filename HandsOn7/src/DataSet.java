import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class DataSet {
    protected List<Double> data;

    public DataSet(List<Double> data) {
        this.data = data;
    }

    public List<Double> getData() {
        return data;
    }

    public abstract double calculateMean();
    public abstract double calculateMedian();
    public abstract double calculateMode();
}

class UngroupedDataSet extends DataSet {

    public UngroupedDataSet(List<Double> data) {
        super(data);
    }

    @Override
    public double calculateMean() {
        return Statistics.calculateMean(data);
    }

    @Override
    public double calculateMedian() {
        return Statistics.calculateMedian(data);
    }

    @Override
    public double calculateMode() {
        return Statistics.calculateMode(data);
    }
}

class GroupedDataSet extends DataSet {
    private Map<Double, Integer> groupedData; // Key: Midpoint or class, Value: Frequency

    public GroupedDataSet(Map<Double, Integer> groupedData) {
        super(null);
        this.groupedData = groupedData;
    }

    public Map<Double, Integer> getGroupedData() {
        return groupedData;
    }

    @Override
    public double calculateMean() {
        return Statistics.calculateGroupedMean(groupedData);
    }

    @Override
    public double calculateMedian() {
        return Statistics.calculateGroupedMedian(groupedData);
    }

    @Override
    public double calculateMode() {
        return Statistics.calculateGroupedMode(groupedData);
    }
}