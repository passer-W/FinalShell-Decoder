# FinalShell-Decoder

> FinallShell 密码解密GUI工具

**使用 Maven 进行了重构，jdk11以上版本可自行打包，使用时记得添加环境变量 `java--module-path "%JDK_INSTALL_PATH%\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml finalshell-tool-1.0-SNAPSHOT.jar  `**

解密部分参考https://github.com/jas502n/FinalShellDecodePass ，做了图形化显示：

<img src="images/image-20220406151439766.png" alt="image-20220406151439766" style="zoom:50%;" />	

可在文本框中直接输入路径或点击选择按钮选择FinalShell配置文件根路径，一般在 `%FINALSHELL_INSTALL_PATH%/conn` 目录下：

![](images/image-20220406151612339.png)

也可将远程主机文件下载到本地解密，输入合法路径后自动生成所有主机配置信息：

<img src="images/image-20220406151733676.png" alt="image-20220406151733676" style="zoom:50%;" />	

双击单元格可复制所选信息。