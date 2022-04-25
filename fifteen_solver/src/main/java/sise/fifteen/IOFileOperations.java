package sise.fifteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOFileOperations implements AutoCloseable {
    public static String readFromFile(String argument) {
        StringBuilder stringBuilder = new StringBuilder();
        String path = Paths.get(argument).toString();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String row;

            while ((row = bufferedReader.readLine()) != null) {
                stringBuilder.append(row);
                int index = 0;

                for (int i = 0; i < stringBuilder.length(); i++) {
                    if (!Character.isWhitespace(stringBuilder.charAt(i))) {
                        stringBuilder.setCharAt(index++, stringBuilder.charAt(i));
                    }
                }
                stringBuilder.delete(index, stringBuilder.length());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();

    }

    public static void saveSolutionToFile(Path path) {

    }

    @Override
    public void close() throws Exception {

    }
}
