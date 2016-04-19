import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.DirectoryStream;

public class FuzzDriver {

    public static void fuzzDirectory(String dir) throws IOException {
        DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir));
        for(Path p : stream) {
            System.out.println("\nFuzzing " + p.toString() + "\n");
            Fuzzer fuzzer = new Fuzzer(p.toString(), 200);
            fuzzer.fuzz(100);
        }
    }

    public static void main(String[] args) throws IOException {
        fuzzDirectory("./files/docx/");
        fuzzDirectory("./files/pdf/");
        fuzzDirectory("./files/txt/");
    }
}
