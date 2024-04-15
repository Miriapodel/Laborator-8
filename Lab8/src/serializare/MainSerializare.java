package serializare;

import serializare.model.Nod;
import serializare.model.Persoana;
import utils.FileManagement;

public class MainSerializare {

    private static String fisierPersoane = "listaPersoaneSerializable.txt";
    private static String listaSerie = "listaSerie.txt";

    public static void main(String[] args) {

        serializareDemo();

        //Lista circulara Curs 8
        Nod prim = serializareListaCirculara();
        FileManagement.scriereObiectInFisier(listaSerie, prim);
        Nod prim2 = (Nod) FileManagement.citireObiectDinFisier(listaSerie);
        afisareSerieNodCitita(prim2);
    }

    private static void serializareDemo() {

        Persoana p1 = new Persoana("Pop", "Ioan" , 20);
        Persoana p2 = new Persoana("Preda", "Maria" , 14);

        FileManagement.scriereObiectInFisier(fisierPersoane, p1, p2);
        FileManagement.citireObiectDinFisier(fisierPersoane);
    }

    private static Nod serializareListaCirculara() {
        Nod prim = null, ultim = null;

        for(int i = 1 ; i <= 10 ; i++){
            Nod aux = new Nod(i);
            if(prim == null){
                prim = ultim = aux;
            }else{
                ultim.setNext(aux);
                ultim = aux;
            }
        }
        ultim.setNext(prim);

        System.out.println("Lista care va fi serializata:");
        Nod aux = prim;
        do{
            System.out.println(aux.getData() + " ");
            aux = aux.getNext();
        }while (aux != prim);
        return prim;
    }

    private static void afisareSerieNodCitita(Nod prim) {
        System.out.println("Lista deserializata: ");

        Nod aux = prim;
        do{
            System.out.println(aux.getData() + " ");
            aux = aux.getNext();
        }while (aux != prim);
    }

}