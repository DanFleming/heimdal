package com.heimdal;

public class Main {
    public static void main(String[] args){
        String directoryPath = "C:/Users/Dan/Desktop";

        FileScanner scanner = new FileScanner();
        DuplicateChecker checker = new DuplicateChecker();
        ImageFileHandler imageHandler = new ImageFileHandler();
        FileMover mover = new FileMover("C:/Users/Dan/Desktop/Gathered Images");

        scanner.scanDirectory(directoryPath, imageHandler);
        checker.checkForDuplicates(imageHandler.getImageFiles());
        mover.moveFiles(imageHandler.getImageFiles());
    }
}