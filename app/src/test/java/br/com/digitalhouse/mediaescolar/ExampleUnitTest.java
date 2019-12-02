package br.com.digitalhouse.mediaescolar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        MainActivity mainActivity = new MainActivity();
        assertEquals((Float) 9F, mainActivity.calcularMedia(9F, 10F, 7F, 10F));
    }
}