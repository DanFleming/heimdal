package com.heimdal;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String directoryPath = "C:/Users/Dan/Desktop/AssessedImages";
        String duplicatesLogFilePath = "C:/Users/Dan/Desktop/duplicates.txt";
        String duplicatesFolderPath = "C:/Users/Dan/Desktop/DuplicateImages";
        String originalLocationsFilePath = "C:/Users/Dan/Desktop/originalLocations.csv";

        FileScanner scanner = new FileScanner();
        DuplicateChecker checker = new DuplicateChecker();
        DuplicateHandler duplicateHandler = new DuplicateHandler(duplicatesLogFilePath, duplicatesFolderPath);
        ImageFileHandler imageHandler = new ImageFileHandler();
        FileMover mover = new FileMover("C:/Users/Dan/Desktop/GatheredImages");

        scanner.scanDirectory(directoryPath, imageHandler);
        checker.checkForDuplicates(imageHandler.getImageFiles(), duplicateHandler);
        mover.moveFiles(imageHandler.getImageFiles());

        try {
            imageHandler.saveOriginalLocationsToFile(originalLocationsFilePath);
        } catch(IOException e) {
            e.printStackTrace();
        }

        //Uncomment below to reverse the process
//        try {
//            UndoMove undoMove = new UndoMove(imageHandler, originalLocationsFilePath);
//            undoMove.undoMove();
//        } catch(IOException e){
//            e.printStackTrace();
//        }
    }
}