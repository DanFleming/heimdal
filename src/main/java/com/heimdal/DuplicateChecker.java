package com.heimdal;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DuplicateChecker {

    private Set<String> fileHashes = new HashSet<>();

    public void checkForDuplicates(List<Path> imageFiles){
        for (Path file : imageFiles){
            try{
                String fileHash = generateFileHash(file);
                if(fileHashes.contains(fileHash)) {
                    System.out.println("Duplicate found: " + file);
                } else {
                    fileHashes.add(fileHash);
                    System.out.println("Unique file: " + file);
                }
            } catch (IOException | NoSuchAlgorithmException e){
                e.printStackTrace();
            }
        }
    }

    private String generateFileHash(Path file) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] fileBytes = Files.readAllBytes(file);
        byte[] hashBytes = digest.digest(fileBytes);
        StringBuilder hexString =  new StringBuilder();
        for(byte b : hashBytes){
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
