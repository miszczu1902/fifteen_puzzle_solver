package sise.fifteen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOFileOperations implements AutoCloseable {
    public static List<Integer> readFromFile(String argument) {
        Path filePath = Paths.get(argument);
        List<Integer> integers = new ArrayList<>();

        try (Scanner scanner = new Scanner(filePath)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    integers.add(scanner.nextInt());
                } else {
                    scanner.next();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return integers;
    }

    public static void saveToFile(String path, String numberOfMoves,String Moves) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(path)));

        bufferedWriter.write(numberOfMoves);
        if(!numberOfMoves.equals("-1"))
        {
            bufferedWriter.write('\n');
            bufferedWriter.write(Moves);

        }

        bufferedWriter.close();
    }


    public static void saveToFileInformations(String path, String numberOfMoves,String VisitedStates,String ProcessedMoves,String depth,String Time) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(path)));
        bufferedWriter.write(numberOfMoves);
            bufferedWriter.write('\n');
            bufferedWriter.write(VisitedStates);
            bufferedWriter.write('\n');
            bufferedWriter.write(ProcessedMoves);
            bufferedWriter.write('\n');
            bufferedWriter.write(depth);
            bufferedWriter.write('\n');
            bufferedWriter.write(Time);



        bufferedWriter.close();

    }



    @Override
    public void close() throws Exception {

    }
}
