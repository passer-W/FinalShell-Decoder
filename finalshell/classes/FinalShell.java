package finalshell.classes;

import finalshell.util.FileUtil;

import java.io.File;
import java.util.ArrayList;

public class FinalShell {

    private static File configPath;
    private static ArrayList<File> configFileList;

    public static void setConfigPath(File file) {
        configPath = file;
        setConfigFileList();
    }

    private static void setConfigFileList() {
        configFileList = FileUtil.getDirFiles(configPath, "_connect_config.json");
    }

    public static ArrayList<File> getConfigFileList() {
        return configFileList;
    }
}
