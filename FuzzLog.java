import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardCopyOption;

import java.time.Instant;

public class FuzzLog {
    public Path path;

    public int it;
    public int err;
    public int f_size;

    public String statsLog = "./logs/stats.txt";
    public String errorsLog = "./logs/errors.txt";

    public void printStatistics() {
        System.out.println("STATS\n------");
        System.out.println("Path: " + path);
        System.out.println("File Size: " + f_size + " bytes");
        System.out.println("Iterations: " + it);
        System.out.println("Errors: " + err);
    }

    public FuzzLog() {
        this.it = 0;
        err = 0;
    }

    public void addError() {
        err++;
    }

    public int getErrors() {
        return err;
    }

    public void writeError(String filename, InputStream error, String time) throws IOException {
        String data = "\n\nFilename: " + filename + "\nTime: " + time + "\n";
        Files.write(Paths.get(errorsLog), data.getBytes(), StandardOpenOption.APPEND);

        byte[] errorBytes = new byte[error.available()];
        error.read(errorBytes);

        Files.write(Paths.get(errorsLog), errorBytes, StandardOpenOption.APPEND);
    }

    public void printErrorFound(String filename) {
        System.out.println("Error found in " + filename + ". Please check error logs.");
    }

    public void createErrorFile(String filename, byte[] fileBytes) throws IOException {
        Path errorPath = Paths.get("./errors/" + filename);
        Files.write(errorPath, fileBytes);
    }

    public void setIterations(int it) {
        this.it = it;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void setFileSize(int f_size) {
        this.f_size = f_size;
    }
}
