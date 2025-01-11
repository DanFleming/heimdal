package com.heimdal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;

public class UndoMove {

    private ImageFileHandler imageFileHandler;

    public UndoMove(ImageFileHandler imageFileHandler){
        this.imageFileHandler = imageFileHandler;
    }

    public void undoMove(){
        for(Map.Entry<Path, Path> entry : imageFileHandler.getOriginalLocations().entrySet()){
            Path originalLocation = entry.getKey();
            Path movedLocation = entry.getValue();

            try{
                Files.move(movedLocation, originalLocation, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Moved file back to: " + originalLocation);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
