import exceptii.SumaException;
import serializare.model.Pers;

import java.io.*;
import java.util.Scanner;

public class MainEx2ScriereOcteti {

    public static void scriereObiectInFisier(String outputFile, Object... obj) {
        try(FileOutputStream fos = new FileOutputStream(outputFile, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nume = "";
        String prenume = "";
        Integer varsta = 0;
        Integer suma = 0;
        String valuta = "";

            for(int j = 0;j< 2;j++) {
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
                Pers persoana = new Pers(nume, prenume, varsta, suma, valuta);
                scriereObiectInFisier("persoaneOcteti.txt", persoana);
            }
    }
}
