package sise.fifteen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOFileOperations implements AutoCloseable {
    public static List<Integer> readFromFile(String argument) throws IOException {
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
        }
        return integers;
    }

    public static void saveSolutionToFile(Path path) {

    }

    @Override
    public void close() throws Exception {

    }
}
