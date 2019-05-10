package universo;


import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Umore {

    private static List<Integer> range = IntStream.rangeClosed(0, 100).boxed().collect(Collectors.toList());
    private static final List<Integer> backup = IntStream.rangeClosed(0, 100).boxed().collect(Collectors.toList());

    public static List<Integer> Gen(int seed){
        range = backup;

        Collections.shuffle(range, new Random(seed));

        return range;

    }

    public static int Gen(int seed,int i){
        range = backup;

        Collections.shuffle(range, new Random(seed));

        return range.get(i);

    }





}
