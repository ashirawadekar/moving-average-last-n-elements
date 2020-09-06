package moving.average.last.n.elements;

import java.util.LinkedList;
import java.util.Queue;

import com.google.common.base.Preconditions;

/**
 * Implementation for {@link MovingAverage} to calculate the moving average for given window size (last n elements).
 */
public class MovingAverageImpl implements MovingAverage {

    private final Queue<Double> queue;
    private final int windowSize;
    private double sum;

    /**
     * Constructor.
     *
     * @param windowSize windowsize for last n elements should be greater than 0.
     */
    public MovingAverageImpl(int windowSize) {
        Preconditions.checkState(windowSize > 0, "{windowSize} should be greater than 0");
        this.queue = new LinkedList<>();
        this.windowSize = windowSize;
        this.sum = 0;
    }

    /**
     * Add number to the queue, if the queue size is equal to window size, remove first element and add new number.
     *
     * @param number number
     */
    @Override
    public void addNum(double number) {
        if (queue.size() >= windowSize) {
            sum -= queue.poll();
        }
        queue.offer(number);
        sum += number;
    }

    /**
     * Calculate the moving average for window size (last n elements).
     *
     * @return the moving average.
     */
    @Override
    public double getAverage() {
        return sum / windowSize;
    }
}
