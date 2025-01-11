package com.heimdal;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ImageFileHandler{

    private List<Path> imageFiles = new ArrayList<>();

    public void addImageFile(Path file){
        imageFiles.add(file);
    }

    public List<Path> getImageFiles(){
        return imageFiles;
    }
}