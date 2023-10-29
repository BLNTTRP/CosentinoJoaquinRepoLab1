import java.util.Scanner;

public class MutantDetector {

    public static void main(String[] args) {
        
        String[] dna = new String[6];
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese las 6 filas de la secuencia de ADN:");
        for (int i = 0; i < 6; i++) {
            dna[i] = scanner.nextLine().toUpperCase();
        }
        
        if (isMutant(dna)) {
            System.out.println("El ADN es de un mutante.");
        } else {
            System.out.println("El ADN no es de un mutante.");
        }
        
    }

    public static boolean isMutant(String[] dna) {
        
        int rows = dna.length;
        int cols = dna[0].length();
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char currentChar = dna[i].charAt(j);

                // Horizontal
                if (j + 3 < cols && currentChar == dna[i].charAt(j + 1) && currentChar == dna[i].charAt(j + 2) && currentChar == dna[i].charAt(j + 3)) {
                    count++;
                    if (count >= 2) {
                        return true;
                    }
                }

                // Vertical
                if (i + 3 < rows && currentChar == dna[i + 1].charAt(j) && currentChar == dna[i + 2].charAt(j) && currentChar == dna[i + 3].charAt(j)) {
                    count++;
                    if (count >= 2) {
                        return true;
                    }
                }

                // Diagonal derecha
                if (i + 3 < rows && j + 3 < cols && currentChar == dna[i + 1].charAt(j + 1) && currentChar == dna[i + 2].charAt(j + 2) && currentChar == dna[i + 3].charAt(j + 3)) {
                    count++;
                    if (count >= 2) {
                        return true;
                    }
                }

                // Diagonal izquierda
                if (i + 3 < rows && j - 3 >= 0 && currentChar == dna[i + 1].charAt(j - 1) && currentChar == dna[i + 2].charAt(j - 2) && currentChar == dna[i + 3].charAt(j - 3)) {
                    count++;
                    if (count >= 2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
