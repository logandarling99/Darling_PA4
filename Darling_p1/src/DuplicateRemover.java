import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    private Set<String> uniqueWords = new HashSet<>();
    public void remove(String dataFile) throws IOException {
        Scanner fileScnr = new Scanner(new File(dataFile));
        while (fileScnr.hasNext()){
            uniqueWords.add(fileScnr.next());
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
        Iterator iterator = uniqueWords.iterator();
        while (iterator.hasNext()){
            printWriter.println(iterator.next());
        }
        printWriter.flush();
        printWriter.close();
        fileWriter.close();
    }

}
