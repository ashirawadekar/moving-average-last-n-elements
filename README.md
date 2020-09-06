## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

### Minimum Requirements

1. Provide a separate interface (IE `interface`/`trait`) with documentation for the data structure
2. Provide an implementation for the interface
3. Provide any additional explanation about the interface and implementation in a README file.

#### Moving Average for last n elements:

The moving average is calculated by keeping track of the sum of all numbers being added to the collection.

For implementation example refer test cases:

```
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

```

#### Complexity Analysis:

- Time complexity O(1) + O(1) + O(1) ≃ O(1)
    - Removing a number would take O(1) constant time.
    - Adding a number would take O(1) constant time.
    - Finding average is O(1) constant time.
- Space complexity: O(n) linear space to hold `n` elements, at a time we would hold maximum elements equal to window size.
