package client;

import compute.Task;
import java.io.Serializable;
import java.math.BigDecimal;

public class Pi implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;

    /** constantes utilisées dans le calcul pi  */
    private static final BigDecimal FOUR =
        BigDecimal.valueOf(4);

    /** mode d'arrondi à utiliser lors du calcul de pi */
    private static final int roundingMode = 
        BigDecimal.ROUND_HALF_EVEN;

    /** chiffres de précision après la virgule */
    private final int digits;

    /**
     * Construire une tâche pour calculer pi au spécifié
     * précision.
     */
    public Pi(int digits) {
        this.digits = digits;
    }

    /**
     * Calculate pi.
     */
    public BigDecimal execute() {
        return computePi(digits);
    }

    /**
     * Calculer la valeur de pi au nombre spécifié de
     * chiffres après la virgule. La valeur est
     * calculé à l'aide de la formule de Machin :
     *
     *          pi/4 = 4*arctan(1/5) - arctan(1/239)
     *
     * et un développement en séries entières d'arctan(x) en
     * précision suffisante.
     */
    public static BigDecimal computePi(int digits) {
        int scale = digits + 5;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR).subtract(arctan1_239).multiply(FOUR);
        return pi.setScale(digits, BigDecimal.ROUND_HALF_UP);
    }
    /**
     * Calculer la valeur, en radians, de l'arc tangente de
     * l'inverse de l'entier fourni au spécifié
     * nombre de chiffres après la virgule. La valeur
     * est calculé en utilisant le développement en séries de puissance pour le
     * arc tangente :
     *
     * arctan(x) = x - (x^3)/3 + (x^5)/5 - (x^7)/7 +
     * (x^9)/9 ...
     */
    public static BigDecimal arctan(int inverseX, int scale)
    {
        BigDecimal result, numer, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX);
        BigDecimal invX2 = 
            BigDecimal.valueOf(inverseX * inverseX);

        numer = BigDecimal.ONE.divide(invX,
                                      scale, roundingMode);

        result = numer;
        int i = 1;
        do {
            numer = 
                numer.divide(invX2, scale, roundingMode);
            int denom = 2 * i + 1;
            term = 
                numer.divide(BigDecimal.valueOf(denom),
                             scale, roundingMode);
            if ((i % 2) != 0) {
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
            i++;
        } while (term.compareTo(BigDecimal.ZERO) != 0);
        return result;
    }
}