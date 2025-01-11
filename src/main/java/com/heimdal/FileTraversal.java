package com.heimdal;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

public class FileTraversal {
    public void traverseDirectory(String directoryPath){
        Path startPath = Paths.get(directoryPath);

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
                    System.out.println("File " + file.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    System.err.println("Failed to access file: " + file.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs){
                    System.out.println(("Directory: " + dir.toString()));
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e){
            System.err.println("Error traversing files: " + e.getMessage());
        }
    }
}
