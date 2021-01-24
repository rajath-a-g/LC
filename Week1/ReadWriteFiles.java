package Week1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

//Used the following links for reading:
//        https://stackabuse.com/reading-and-writing-files-in-java/
public class ReadWriteFiles {
    static String directory = System.getProperty("user.home");
    static String fileName = "test.txt";
    static String absPath = directory + File.separator + fileName;


    public static void readerAndWriter() {
        try(FileWriter fileWriter = new FileWriter(absPath)) {
            String content = "This is sample text 1";
            fileWriter.write(content);
            System.out.println("Wrote using file writer successfully.");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Could not write to the file because:");
            e.printStackTrace();
        }

        try(FileReader fileReader = new FileReader(absPath)) {
            int ch = fileReader.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (ch != -1) {
                stringBuilder.append((char)ch);
                ch = fileReader.read();
            }
            if (!stringBuilder.toString().equals("This is sample text 1"))
                System.out.println("String not equal in file reader");
            System.out.println("Read using file reader successfully.");
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Could not read the file because:");
            e.printStackTrace();
        }
    }

    public static void bufreaderAndWriter() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absPath))) {
            String content = "This is sample text 2";
            bufferedWriter.write(content);

        } catch (IOException e) {
            System.out.println("Could not write to the file because:");
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absPath))) {
            int ch = bufferedReader.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (ch != -1) {
                stringBuilder.append((char)ch);
                ch = bufferedReader.read();
            }
            if (!stringBuilder.toString().equals("This is sample text 2"))
                System.out.println("String not equal in buffered reader");
            System.out.println("Read using buffered reader successfully.");
        } catch (IOException e) {
            System.out.println("Could not read the file because:");
            e.printStackTrace();
        }
    }

    public static void streamReaderWriter() {
        try(FileOutputStream fileOutputStream = new FileOutputStream(absPath)) {
            String content = "This is sample text 1";
            fileOutputStream.write(content.getBytes());
            System.out.println("Wrote using file input stream successfully.");
        } catch (IOException e) {
            System.out.println("Could not write to the file because:");
            e.printStackTrace();
        }

        try(FileInputStream fileInputStream = new FileInputStream(absPath)) {
            int ch = fileInputStream.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (ch != -1) {
                stringBuilder.append((char)ch);
                ch = fileInputStream.read();
            }
            if (!stringBuilder.toString().equals("This is sample text 1"))
                System.out.println("String not equal in file reader");
            System.out.println("Read using file input stream reader successfully.");
        } catch (IOException e) {
            System.out.println("Could not read the file because:");
            e.printStackTrace();
        }
    }

    public static void bufferStreamReaderWriter() {
        try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(absPath))) {
            String content = "This is sample text 1";
            bufferedOutputStream.write(content.getBytes());
            System.out.println("Wrote using buffered input stream successfully.");
        } catch (IOException e) {
            System.out.println("Could not write to the file because:");
            e.printStackTrace();
        }

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(absPath))) {
            int ch = bufferedInputStream.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (ch != -1) {
                stringBuilder.append((char)ch);
                ch = bufferedInputStream.read();
            }
            if (!stringBuilder.toString().equals("This is sample text 1"))
                System.out.println("String not equal in file reader");
            System.out.println("Read using buffered input stream reader successfully.");
        } catch (IOException e) {
            System.out.println("Could not read the file because:");
            e.printStackTrace();
        }
    }

    public static void nioReadWrite() {
        String content = "This is nio sample.";
        Path path = Paths.get(directory, fileName);
        try {
            Files.write(path, content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Could not read the file because:");
            e.printStackTrace();
        }
        try {
            List<String> list = Files.readAllLines(path);
            list.forEach(System.out::println);
            if (!list.get(0).equals("This is nio sample. 1"))   //figure out why 1 is coming here????
                System.out.println("String not equal in nio reader");
            System.out.println("Read using buffered input stream reader successfully.");
        } catch (IOException e) {
            System.out.println("Could not read the file because:");
            e.printStackTrace();
        }
    }

    public  static void main(String[] args) {
        readerAndWriter();
        bufreaderAndWriter();
        streamReaderWriter();
        bufferStreamReaderWriter();
        nioReadWrite();
    }
}
