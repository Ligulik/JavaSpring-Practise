package dependencies;

import org.apache.commons.lang3.StringUtils;

/**
 * Klasa testowa do nauki wpinania pluginów do pliku pom.xml
 * oraz wykonywania kilku rzeczy razem
 *
 * @author Maciek Rychlinski
 */


public class NameVerifier {
    public static void main(String[] args) {
        String name = "Maciek";
        System.out.println(StringUtils.isAlpha(name));
    }

    /**
     * Metoda dodająca dwie liczby całkowite
     *
     * @param a
     * @param b
     * @return
     */

   public int add(int a,int b){
        return a+b;
   }
}
