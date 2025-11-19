import java.util.Arrays;

public class Primes {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]); // The maximum number of the checked range.
        Boolean[] isPrime = getPrimesArray(N);
        printsPrimes(isPrime, N);
    }

    /**
     * Returns a boolean array in which only the prime numbers' indexes hold true
     * values. Implementing it by “Sieve of Eratosthenes” algorithm.
     * Creates a boolean array with true default values the size of the given
     * maximum number. Then, changes the composite numbers' indexes to false.
     */
    public static Boolean[] getPrimesArray(int N) {
        // Creates a boolean array with true default values the size of the given
        // maximum number.
        Boolean[] isPrime = new Boolean[N + 1];
        Arrays.fill(isPrime, true);

        // Sets the values of the composite numbers' indexes to false.
        isPrime[0] = false;
        isPrime[1] = false;

        int p = 2;
        while (p <= Math.sqrt(N)) {
            for (int i = 2 * p; i <= N; i += p) {
                isPrime[i] = false;
            }
            p++;
        }
        return isPrime;
    }

    /**
     * Prints the prime numbers. Then, prints a summary of the number of prime
     * numbers from the total range and their precentage.
     */
    public static void printsPrimes(Boolean[] isPrime, int N) {
        int numPrimes = 0;
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                numPrimes++;
            }
        }

        int primePrecentage = (int) ((float) numPrimes / N * 100);
        String message = String.format("There are %s primes between 2 and %s (%s%% are primes)",
                numPrimes, N, primePrecentage);
        System.out.println(message);
    }
}