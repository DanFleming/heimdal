package com.heimdal;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageFileHandler{

    private List<Path> imageFiles = new ArrayList<>();
    private Map<Path, Path> originalLocations = new HashMap<>();

    public void addImageFile(Path file){
        imageFiles.add(file);
        originalLocations.put(file, file);
    }

    public List<Path> getImageFiles(){
        return imageFiles;
    }

    public Map<Path, Path> getOriginalLocations(){
        return originalLocations;
    }

    public void saveOriginalLocationsToFile(String filePath) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(Map.Entry<Path, Path> entry : originalLocations.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        }
    }

    public void loadOriginalLocationsFromFile(String filePath) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 2) {
                    originalLocations.put(Path.of(parts[0]), Path.of(parts[1]));
                }
            }
        }
    }
}