package net.asifhossain.algorithms.sieve;

import net.asifhossain.codeforces.utils.ArrayUtils;

/**
 * @author asif.hossain
 * @since 12/18/16.
 */
public class PrimeGenerator {
    public int[] sieve(int n) {
        int[] primes = new int[n + 1];
        primes[0] = -1;
        primes[1] = -1;
        for (int p = 2; p * p <= n; p++) {
            if (primes[p] == 0) {
                for (int i = p * 2 ; i <= n; i += p) {
                    primes[i] = -1;
                }
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        PrimeGenerator p =new PrimeGenerator();

        ArrayUtils.printArray(p.sieve(10));
    }
}
