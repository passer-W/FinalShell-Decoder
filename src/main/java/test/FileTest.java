package test;

import finalshell.classes.Config;
import finalshell.util.FileUtil;
import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTest {
    @Test
    public void readTest() throws Exception{
        // [user_name, password, host, name]
        String configPattern = "\"user_name\":\"(.*?)\".*?\"password\":\"(.*?)\".*?\"host\":\"(.*?)\".*?\"name\":\"(.*?)\"";
        String content = (FileUtil.readFile(new File("D:\\Tool\\finalshell\\conn\\6514z8orao20nk4a_connect_config.json")));
        System.out.println(content);
        Pattern compile = Pattern.compile(configPattern);
        Matcher matcher = compile.matcher(content);
        int count = 1;
        while (matcher.find()){
            Config config = new Config(count++, matcher.group(3), matcher.group(4), matcher.group(1), matcher.group(2));
        }
    }

    @Test
    public void getTest(){
        for(File i : FileUtil.getDirFiles(new File("D:\\Tool\\finalshell\\conn"), "_connect_config.json")){
            System.out.println(i.getAbsolutePath());
        }
    }
}
