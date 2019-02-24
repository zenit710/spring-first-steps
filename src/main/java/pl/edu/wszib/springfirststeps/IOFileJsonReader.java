package pl.edu.wszib.springfirststeps;

import java.io.*;

public class IOFileJsonReader implements FileJsonReader {

    @Override
    public String readJson(String path) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = fileReader.readLine();
            while (line != null) {
                sb.append(line);
                line = fileReader.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
