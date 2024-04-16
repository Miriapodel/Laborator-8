import exceptii.SumaException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainEx1ScriereChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nume = "";
        String prenume = "";
        Integer varsta = 0;
        Integer suma = 0;
        String valuta = "";

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("persoaneChar.txt", true))) {
            for(int j = 0;j< 2;j++){
                for (int i = 0; i < 5; i++) {
                    switch (i) {
                        case 0:
                            System.out.println("Introduceti numele: ");
                            nume = scanner.nextLine();
                            break;
                        case 1:
                            System.out.println("Introduceti prenumele: ");
                            prenume = scanner.nextLine();
                            break;
                        case 2:
                            System.out.println("Introduceti varsta: ");
                            varsta = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        case 3:
                            try {
                                System.out.println("Introduceti suma: ");
                                suma = scanner.nextInt();
                                scanner.nextLine();

                                if (suma > 2000) {
                                    throw new SumaException();
                                }
                            } catch (SumaException e) {
                                i = -1;
                            }
                            break;
                        case 4:
                            System.out.println("Introduceti valuta: ");
                            valuta = scanner.nextLine();
                            break;
                    }
                }
            }

            bufferedWriter.write(nume);
            bufferedWriter.write("; ");
            bufferedWriter.write(prenume);
            bufferedWriter.write("; ");
            bufferedWriter.write(varsta.toString());
            bufferedWriter.write("; ");
            bufferedWriter.write(suma.toString());
            bufferedWriter.write("; ");
            bufferedWriter.write(valuta);
            bufferedWriter.write("\n");

        } catch(IOException e){
            throw new RuntimeException(e);
        }

    }
}
