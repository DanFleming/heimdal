package com.heimdal;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DuplicateHandler{

    private String duplicatesLogFilePath;
    private Path duplicatesDirectory;
    private Set<String> processedFiles;

    public DuplicateHandler(String duplicatesLogFilePath, String duplicatesFolderPath){
        this.duplicatesLogFilePath = duplicatesLogFilePath;
        this.duplicatesDirectory = Path.of(duplicatesFolderPath);
        this.processedFiles = new HashSet<>();

        // Create the duplicates directory if it doesn't exist
        if (!Files.exists(duplicatesDirectory)) {
            try {
                Files.createDirectories(duplicatesDirectory);
            } catch (IOException e) {
                System.err.println("Error creating duplicates directory: " + e.getMessage());
            }
        }
    }

    public void handleDuplicate(Path file){
        try {
            if(processedFiles.contains(file.toString())){
                moveDuplicateToFolder(file);
                logDuplicate(file);
            } else {
                processedFiles.add(file.toString());
            }
        } catch (IOException e){
            System.err.println("Error while processing file: " + e.getMessage());
        }
    }

    private void moveDuplicateToFolder(Path file) throws IOException {
        Path destination = duplicatesDirectory.resolve(file.getFileName());
        Files.move(file, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Moved duplicate to: " + destination);
    }

    private void logDuplicate(Path file) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(duplicatesLogFilePath, true))) {
            writer.write(file.toString());
            writer.newLine();
        }
    }
}