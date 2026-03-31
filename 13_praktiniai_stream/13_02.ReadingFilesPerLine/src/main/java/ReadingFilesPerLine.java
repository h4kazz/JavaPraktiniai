import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadingFilesPerLine {

    public static List<String> read(String file) throws IOException {
        return Files.readAllLines(Paths.get(file));
    }

    public static void main(String[] args) throws IOException {
        List<String> books = read("books.txt");
        System.out.println(books);
    }
}