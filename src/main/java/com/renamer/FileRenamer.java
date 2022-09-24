package com.renamer;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public abstract class FileRenamer {
    public HashMap<Integer, List<File>> getFullFilePath() {
        return fullFilePath;
    }

    public void setFullFilePath(HashMap<Integer, List<File>> fullFilePath) {
        this.fullFilePath = fullFilePath;
    }
    private int fileCounter = 0;
    protected HashMap<Integer, List<File>> fullFilePath;
    public FileRenamer(HashMap<Integer, List<File>> fullFilePath){
        this.fullFilePath = fullFilePath;
    }

    protected void rename(){
        fullFilePath.forEach((directory, files)->{
            fileCounter = 0;
            for(File file : files){
                File renamedFile = createRenamedFile(file, fileCounter);
                file.renameTo(renamedFile);
                fileCounter++;
            }

        });
    }

    abstract File createRenamedFile(File file, int fileCounter);
}