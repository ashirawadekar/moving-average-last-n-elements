package moving.average.last.n.elements;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

/**
 * Test cases for {@link MovingAverageImpl}.
 */
public class MovingAverageImplTest {

    /**
     * Test case to verify moving average is calculated.
     */
    @Test
    public void whenWindowSizeIsDefined_shouldReturnCorrectMovingAverage() {
        MovingAverage movingAverage = new MovingAverageImpl(4);
        double numbers[] = new double[]{1, 2, 3, 4.5, 5.6, 6.7, 7.8, 8, 9, 10};
        double answers[] = new double[]{0.25, 0.75, 1.5, 2.625, 3.775, 4.95, 6.15, 7.025, 7.875, 8.7};

        for (int i = 0; i < numbers.length; i++) {
            movingAverage.addNum(numbers[i]);
            assertThat(movingAverage.getAverage()).isEqualTo(answers[i]);
        }
    }

    /**
     * Test case to verify exception is thrown when window size is 0.
     */
    @Test
    public void whenWindowSizeIsLessThanEqualToZero_shouldFail() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new MovingAverageImpl(0));
    }
}
