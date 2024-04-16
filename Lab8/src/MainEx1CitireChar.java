import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MainEx1CitireChar {
    public static void main(String[] args) {

        ArrayList<String> nume = new ArrayList<>();
        ArrayList<String> prenume = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("persoaneChar.txt"))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                var date = line.split("[; ]+");

                nume.add(date[0]);
                prenume.add(date[1]);

                line = bufferedReader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < nume.size() - 1; i++) {
            for(int j = i + 1; j < nume.size(); j++){
                if (nume.get(i).compareTo(nume.get(j)) == 0 && prenume.get(i).compareTo(prenume.get(j)) == 0) {
                    System.out.println("Numele: " + nume.get(i) + ", Prenume:  " + prenume.get(i));
                    System.out.println("Numele: " + nume.get(i) + ", Prenume: " + prenume.get(i));
                }
            }

        }
    }
}
