package com.heimdal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;

public class UndoMove {

    private ImageFileHandler imageFileHandler;

    public UndoMove(ImageFileHandler imageFileHandler, String originalLocationsFilePath) throws IOException {
        this.imageFileHandler = imageFileHandler;
        imageFileHandler.loadOriginalLocationsFromFile(originalLocationsFilePath);
    }

    public void undoMove(){
        Map<Path, Path> originalLocations = imageFileHandler.getOriginalLocations();

        for(Map.Entry<Path, Path> entry : originalLocations.entrySet()){
            Path movedLocation = entry.getKey();
            Path originalLocation = entry.getValue();

            try {
                Files.move(movedLocation, originalLocation, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File moved back to " + originalLocation);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
