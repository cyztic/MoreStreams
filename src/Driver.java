import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;


public class Driver {

    public static void main(String[] args) {
        //double the even numbers and total:
        //List
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //old way:
        /*int result = 0;

        for(int e : numbers)
        {
            if(e % 2 == 0)
            {
                result += e *2;
            }
        }
        System.out.println(result);
        */

        //using stream to find even numbers and multiply by 2 and total numbers
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)    // get even numbers
                        .mapToInt(e -> e * 2)       //double them
                        .sum());                    //sum all numbers together


        int result = numbers.stream()
                .filter(number -> number > 5)
                .filter(number -> number % 2 == 0)
                .filter(number -> number < 9)
                .filter(number -> number * 2 > 15)
                .findFirst()
                .get();

        System.out.println(result);

        //what are filters:
        //filters 0 <= n <= number of inputs
        //input: stream<T> filter takes predicate<T>

        //what are maps:
        //map is a transforming function
        //number of output == number of input (does it to all objects passed through)
        // no guarantee of output with respect to input

        //reduce:
        //takes two parameters:
        //1: type T
        //second: is of type bifuction<R,T,R> to produce a result of R

        System.out.println(
        numbers.stream()
                .reduce(0, (carry, e) -> carry + 2));

        //List to List using stream
        List<Integer> doubleOfEven =
                numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(toList());

        System.out.println(doubleOfEven);

        


    }
}