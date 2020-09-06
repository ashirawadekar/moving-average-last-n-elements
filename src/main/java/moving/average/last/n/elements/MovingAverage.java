package moving.average.last.n.elements;

/**
 * Operations supported for finding moving average.
 */
public interface MovingAverage {

    /**
     * Add number to a collection.
     * @param number number
     */
    void addNum(double number);

    /**
     * Get average for a collection.
     * @return the average
     */
    double getAverage();
}
