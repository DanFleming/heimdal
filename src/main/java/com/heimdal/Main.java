package com.heimdal;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args){
        String directoryPath = "C:/Users/Dan/Desktop/AssessedImages";
        String duplicatesLogFilePath = "C:/Users/Dan/Desktop/duplicates.txt";
        String duplicatesFolderPath = "C:/Users/Dan/Desktop/DuplicateImages";

        FileScanner scanner = new FileScanner();
        DuplicateChecker checker = new DuplicateChecker();
        DuplicateHandler duplicateHandler = new DuplicateHandler(duplicatesLogFilePath, duplicatesFolderPath);
        ImageFileHandler imageHandler = new ImageFileHandler();
        FileMover mover = new FileMover("C:/Users/Dan/Desktop/GatheredImages");

        scanner.scanDirectory(directoryPath, imageHandler);
        checker.checkForDuplicates(imageHandler.getImageFiles(), duplicateHandler);
        mover.moveFiles(imageHandler.getImageFiles());

        //Uncomment below to reverse the process
        //UndoMove undoMove = new UndoMove(imageHandler);
        //undoMove.undoMove();
    }
}