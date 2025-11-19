import java.util.Arrays;

// Finds and prints the prime numbers in the range of the given maximum number.
// Implementing it by “Sieve of Eratosthenes” algorithm - Creates a boolean array with
//  true default values. Then, changes the composite numbers' indexes to false.
//  Only values of prime numbers' indexes are true.
public class Primes {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // The maximum number of the checked range.
        // Creates a boolean array with true default values the size of the given maximum number.
        Boolean[] isPrime = new Boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // Sets the values of the composite numbers' indexes to false.
        int p = 2;
        while (p <= Math.sqrt(N)) {
            for (int i = 2 * p; i <= N; i += p) {
                isPrime[i] = false;
            }
            p++;
        }

        // Prints the prime numbers.
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}