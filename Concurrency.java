import java.util.Scanner;
import java.util.stream.IntStream;

public class Concurrency {
    
    public static void main(String... args) {
        
        // Ask input user to enter the number of threads they would like to run.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of threads: ");
        int numThreads = sc.nextInt();

        IntStream.range(0, numThreads).mapToObj(i -> {
            Thread t = Thread.ofVirtual().start(() -> {
                System.out.println(i);
            });

            return t;
        }).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
