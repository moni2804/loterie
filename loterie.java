import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class loterie {

    private static BigDecimal calculateCombinations(int n,int k){
        BigDecimal combinations = factorial(n);
        BigDecimal under= factorial(k).multiply(factorial(n-k));
        return combinations.divide(under, 10, BigDecimal.ROUND_HALF_UP);

    }

    private static BigDecimal factorial(int n){
        BigDecimal nr = BigDecimal.ONE;
        for(int i=2;i<=n;i++)
            nr=nr.multiply(BigDecimal.valueOf(i));
        return nr;
    }

    public static long extrageNumere(int n, int k) {
        Random random = new Random();
        long rezultat = 0;
        int numereExtrase = 0;
        while (numereExtrase < k) {
            int numar = random.nextInt(n) + 1; // Numere intre 1 si 49
            if ((rezultat & (1L << numar)) == 0) { // Verifica daca numarul nu a fost deja extras
                rezultat |= (1L << numar); // Seteaza bitul corespunzator numarului extras
                numereExtrase++;
            }
        }
        return rezultat;
    }

    public static void afiseazaNumere(long numere, boolean crescator) {
        if (crescator) {
            for (int i = 1; i <= 49; i++) {
                if ((numere & (1L << i)) != 0) {
                    System.out.print(i + " ");
                }
            }
        } else {
            for (int i = 49; i >= 1; i--) {
                if ((numere & (1L << i)) != 0) {
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int totalNumere = 49;
        int numereExtrase = 6;

        BigDecimal nr=calculateCombinations(totalNumere, numereExtrase);
        System.out.println("sansa de castig la 6 din 49 este 1 din" + nr);

        long numereExtraseSimulate = extrageNumere(totalNumere, numereExtrase);
        System.out.println("Numere extrase:");

        System.out.print("In ordine crescatoare: ");
        afiseazaNumere(numereExtraseSimulate, true);

        System.out.print("In ordine descrescatoare: ");
        afiseazaNumere(numereExtraseSimulate, false);

        //BigDecimal result=BigDecimal.ZERO.divide(combinari,10, RoundingMode.HALF_UP);

    }
}
