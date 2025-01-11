package com.heimdal;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileMover{
    private Path destination;

    public FileMover(String destinationPath){
        this.destination = Paths.get(destinationPath);
    }

    public void moveFiles(List<Path> imageFiles){
        for(Path file : imageFiles){
            Path destinationFile = destination.resolve(file.getFileName());
            try{
                Files.move(file, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Moved: " + file + " to " + destinationFile);
            } catch (IOException e){
                System.err.println("Failed to move file: " + file);
            }
        }
    }
}