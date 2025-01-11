package com.heimdal;

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
}