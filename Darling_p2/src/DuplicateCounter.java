import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {
    private HashMap<String, Integer> wordCounter = new HashMap<>();
    public void count(String dataFile) throws IOException {
        Integer count;
        String w;
        Scanner fileScnr = new Scanner(new File(dataFile));
        while (fileScnr.hasNext()){
            w = fileScnr.next();
            count = wordCounter.get(w);
            if(count == null) count = 1;
            else count += 1;
            wordCounter.put(w, count);
        }

        fileScnr.close();
    }

    public void write(String outputFile) throws IOException{
        File output = new File(outputFile);
        FileWriter fileWriter = new FileWriter(outputFile);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        if(!(output.exists())){
            output.createNewFile();
        }

        for (String word: wordCounter.keySet()){
            printWriter.println(word + ": " + wordCounter.get(word));
        }

        fileWriter.close();
        printWriter.close();
    }
}
