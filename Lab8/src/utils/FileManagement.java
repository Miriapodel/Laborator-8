package utils;

import externalizare.PersoanaExternalizable;
import serializare.model.Persoana;
import serializare.model.Nod;
import java.io.*;

public class FileManagement {

    //metoda cu numar variabil de argumente. Vor fi transmise ca un Array
    //dupa tipul obiectului se pun 3 puncte
    public static void scriereObiectInFisier(String outputFile, Object... obj) {
        try(FileOutputStream fos = new FileOutputStream(outputFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for(Object o : obj) {
                oos.writeObject(o);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object citireObiectDinFisier(String fileName) {
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            try {
                while (true){
                    Object o =  ois.readObject();
                    switch (o){
                        case Persoana p ->  System.out.println(p);
                        case PersoanaExternalizable pe ->  System.out.println(pe);
                        case Nod n -> {
                            return n;
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + o);
                    }
                }
            } catch (EOFException e) {
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
