package com.heimdal;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class FileUtils {

    public static boolean fileExists(Path file){
        return Files.exists(file);
    }
}