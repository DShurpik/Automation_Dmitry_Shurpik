package Task_10;

import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

    @Test
    public void testApi() {

        List<Integer> data = Arrays.asList(-79, 99, -83, -75, -78, -22, -57, 84, 11, 15);
        for (Integer i : data) {
            System.out.print(" " + i);
        }

        System.out.print("\n");

        List<Integer> data1 = data.stream().map(car -> Math.abs(car)).sorted().collect(Collectors.toList());
        for (Integer i : data1) {
            System.out.print(" " + i);
        }
    }
}