import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File{

    public static ArrayList<String> read_file() throws IOException{
            String file = "teste.txt";
            ArrayList<String> linhas = new ArrayList<String>(100);

            try(BufferedReader br = new BufferedReader(new FileReader(file))) 
            {
                String line;
                while ((line = br.readLine()) != null) {
                //System.out.println(line);
                linhas.add(line);
                }
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            return linhas;
        }
}