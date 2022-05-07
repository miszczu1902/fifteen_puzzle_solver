package sise.fifteen;

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

    public static void saveToFile(String path, int content,String content2) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(path)));
        try {
            bufferedWriter.write(content);
            bufferedWriter.write(content2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public void close() throws Exception {

    }
}
