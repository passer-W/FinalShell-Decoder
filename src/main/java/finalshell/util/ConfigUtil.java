package finalshell.util;

import finalshell.classes.Config;
import finalshell.classes.FinalShell;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigUtil {

    private static Config getConfig(int count, File file){
        // username, password, host, name
        String configPattern = "\"user_name\":\"(.*?)\".*?\"password\":\"(.*?)\".*?\"host\":\"(.*?)\".*?\"name\":\"(.*?)\"";
        try {
            String content = FileUtil.readFile(file);
            Pattern compile = Pattern.compile(configPattern);
            Matcher matcher = compile.matcher(content);
            if (matcher.find()){
                return new Config(count, matcher.group(3), matcher.group(4), matcher.group(1), DecodeUtil.decodePass(matcher.group(2)));
            } else {
                return null;
            }
        } catch (Exception e){
            return null;
        }

    }

    /**
     * 从FinalShell全局变量获取所有配置文件，并解密返回
     * @return
     */
    public static ArrayList<Config> getConfigList(){
        ArrayList<File> configFileList = FinalShell.getConfigFileList();
        ArrayList<Config> configs = new ArrayList<>();
        int count = 1;
        for(File f : configFileList){
            Config config = getConfig(count++, f);
            configs.add(config);
        }
        return configs;
    }
}
