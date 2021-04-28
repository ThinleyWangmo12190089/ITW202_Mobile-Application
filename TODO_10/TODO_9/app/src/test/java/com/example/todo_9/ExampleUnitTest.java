package com.example.todo_9;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private Calculator mCalculator;

    @Before
    public void setup() {
        mCalculator = new Calculator();
    }

    @Test
    public void addTwoNumbers() {
        double result = mCalculator.add(1d,2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void subTwoNumbers() {
        double result = mCalculator.sub(4d, 2d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public void subWorksWithNegativeResults() {
        double result = mCalculator.sub(-2d,2d);
        assertThat(result, is(equalTo(-4d)));
    }
    @Test
    public void mulTwoNumbers() {
        double result = mCalculator.mul(2d, 2d);
        assertThat(result, is(4d));
    }
    @Test
    public void mulTwoNumbersZero() {
        double result = mCalculator.mul(0d, 5d);
        assertThat(result, is(0d));
    }
    @Test
    public void divTwoNumbers() {
        double result = mCalculator.div(8d, 4d);
        assertThat(result, is(2d));
    }
    @Test
    public void divTwoNumbersZero() {
        double result = mCalculator.div(4d, 0d);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }
    @Test
    public void addTwoNumbersFloats() {
        double result = mCalculator.add(1.111f, 1.111d);
        assertThat(result, is(closeTo(2.222, 0.01)));
    }
}