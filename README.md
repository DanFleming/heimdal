# Heimdal: Duplicate Image Scanner and Organizer

## Overview
Heimdal is a Java-based program designed to efficiently manage image files by identifying duplicate files, organizing them into designated directories, and allowing users to reverse any file movements. The program ensures that duplicate files are logged, moved to a specified location, and original file locations can be tracked and restored when needed.

## Features
- Scans a specified directory for image files (`.jpg`, `.png`).
- Detects duplicate image files using SHA-256 hashing.
- Moves duplicates to a specified folder and logs their locations.
- Moves all unique images to a target folder.
- Saves and restores the original locations of files.
- Provides an undo functionality to reverse file movements.

---

## Prerequisites
- **Java Version**: Ensure you have Java 11 or later installed.
- **Dependencies**: None beyond standard Java libraries.

---

## Project Structure
```
com.heimdal
├── Main.java                # Entry point of the program
├── FileScanner.java         # Scans a directory for image files
├── FileUtils.java           # Utility class for file operations
├── DuplicateHandler.java    # Handles duplicate detection, logging, and moving
├── ImageFileHandler.java    # Manages image files and their original locations
├── UndoMove.java            # Reverses file movements
├── FileMover.java           # Moves files to the target directory
├── DuplicateChecker.java    # Detects duplicates using file hashing
```

---

## How to Use

1. **Setup Directory Paths**:
   Update the file paths in `Main.java` with your desired directories:
    - `directoryPath`: Path to the directory containing the images to scan.
    - `duplicatesLogFilePath`: File where duplicate logs will be stored.
    - `duplicatesFolderPath`: Folder where duplicate images will be moved.
    - `originalLocationsFilePath`: File where original file locations will be saved.
    - `destinationPath`: Target folder where all unique images will be moved.

2. **Run the Program**:
   Compile and run the `Main.java` file:
   ```
   javac com/heimdal/*.java
   java com.heimdal.Main
   ```

3. **Undo File Movements (Optional)**:
   Uncomment the `UndoMove` section in `Main.java` and re-run the program to reverse file movements.

---

## Example Workflow

1. Specify a directory of images (`C:/Users/Dan/Desktop/AssessedImages`).
2. Run the program to:
    - Identify duplicates.
    - Move duplicates to a folder (`C:/Users/Dan/Desktop/DuplicateImages`).
    - Log duplicates in a file (`C:/Users/Dan/Desktop/duplicates.txt`).
    - Move all unique images to a target folder (`C:/Users/Dan/Desktop/GatheredImages`).
    - Save the original file locations to a CSV file (`C:/Users/Dan/Desktop/originalLocations.csv`).
3. Reverse the process (if needed) using the undo functionality.

---

## Key Classes and Responsibilities

### `Main.java`
- Coordinates the overall workflow of scanning, detecting duplicates, moving files, and undoing moves.

### `FileScanner.java`
- Traverses a directory and identifies image files (`.jpg`, `.png`).

### `FileUtils.java`
- Utility methods for checking file existence.

### `DuplicateHandler.java`
- Manages the detection of duplicates, moving them to a separate folder, and logging their paths.

### `ImageFileHandler.java`
- Tracks image files and their original locations.
- Provides methods to save and load original locations from a CSV file.

### `UndoMove.java`
- Reverses the movements of files based on the saved original locations.

### `FileMover.java`
- Moves all unique image files to the target directory.

### `DuplicateChecker.java`
- Uses SHA-256 hashing to identify duplicate files.

---

## Notes
- Duplicate detection is based on file content, not filename, ensuring robust identification of duplicates.
- Ensure sufficient disk space is available in the destination and duplicates folders.
- Logging and file paths are hardcoded in the current implementation. Update paths as needed before running the program.

---

## Limitations
- Only supports `.jpg` and `.png` file formats.
- Does not handle symbolic links or deeply nested directory structures gracefully.
- Error handling is minimal in certain cases (e.g., corrupted files).

---

## Possible Future Enhancements
- Addition of support for more file formats (e.g., `.gif`, `.bmp`).
- Implement a graphical user interface (GUI).
- Improve error handling and logging.
- Allow configuration of paths via external files or command-line arguments.

---

## License
This program is distributed under the MIT License. Feel free to modify and distribute it as needed.

---

## Author
- **Dan Fleming**

For questions or feedback, feel free to reach out!

