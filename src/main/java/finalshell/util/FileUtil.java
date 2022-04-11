package finalshell.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class FileUtil {

    public static void writeFile(File file, String content) throws IOException {
        FileOutputStream outputStream = new FileOutputStream((file));
        outputStream.write(content.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    public static String readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        char[] buffers = new char[1024];
        int size;
        while ((size = bufferedReader.read(buffers)) != -1){
            content.append(String.valueOf(buffers, 0, size));
        }
        return content.toString();
    }


    public static ArrayList<File> getDirFiles(File file, String ext){
        if(!file.isDirectory() || !file.exists()){
            return null;
        } else{
            ArrayList<File> fileList = new ArrayList<>();
            for(File f : file.listFiles()){
                if(!f.isDirectory()){
                    if(f.getName().endsWith(ext)) {
                        fileList.add(f);
                    }
                } else {
                    fileList.addAll(getDirFiles(f, ext));
                }
            }
            return fileList;
        }
    }
}
