
import serializare.model.Pers;
import utils.FileManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainEx2CitireOcteti {

    public static Object[] citireObiectDinFisier(String fileName) {
        Object[] o;
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            o = (Object[]) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    public static void main(String[] args) {
        ArrayList<String> nume = new ArrayList<>();
        ArrayList<String> prenume = new ArrayList<>();

       Object[] o =  citireObiectDinFisier("persoaneOcteti.txt");
        for(int i = 0; i < o.length; i++){
            Pers p = (Pers) o[i];
            nume.add(p.getNume());
            prenume.add(p.getPrenume());

            System.out.println(p.getNume());
            System.out.println(p.getPrenume());
        }

        for (int i = 0; i < nume.size(); i++) {
            for (int j = i + 1; j < nume.size(); j++) {
                if (nume.get(i).equals(nume.get(j)) && prenume.get(i).equals(prenume.get(j))) {
                    System.out.println("Numele: " + nume.get(i) + ", Prenume: " + prenume.get(i));
                }
            }
        }
    }
}
