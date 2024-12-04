package logico;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler implements FileOperations{
	 @Override
	    public String readFile(String filePath) throws IOException {
	        String content = new String(Files.readAllBytes(Paths.get(filePath)));
	        System.out.println("Contenido leído: " + content);
	        return content;
	    }

	    @Override
	    public void writeFile(String filePath, String content) throws IOException {
	        File file = new File(filePath);
	        if (!file.exists()) {
	            file.createNewFile();
	        }

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            writer.write(content);
	            writer.flush();
	        } catch (IOException e) {
	            System.err.println("Error al escribir en el archivo: " + e.getMessage());
	            throw e;
	        }
	    }

	    @Override
	    public void delateFile(String filePath) throws IOException {
	        Files.delete(Paths.get(filePath));
	    }

	    @Override
	    public void appendToFile(String filePath, String content) throws IOException {
	        // Verificar si el archivo existe, si no, crearlo
	        File file = new File(filePath);
	        if (!file.exists()) {
	            file.createNewFile();
	        }

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
	            writer.write(content);
	            writer.newLine();
	            writer.flush();
	        } catch (IOException e) {
	            System.err.println("Error al escribir en el archivo: " + e.getMessage());
	            throw e;
	        }
	    }

	    void createFileIfNotExists(String filePath) throws IOException {
	        File file = new File(filePath);
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	    }
}
