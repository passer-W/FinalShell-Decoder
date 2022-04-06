package finalshell.controller;

import finalshell.Main;
import finalshell.classes.Config;
import finalshell.classes.FinalShell;
import finalshell.util.ConfigUtil;
import finalshell.util.FileUtil;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.Callback;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    protected Button choseBtn;

    @FXML
    protected TextField configPath;

    @FXML
    protected TableView<Config> resultTableView;
    @FXML
    protected TableColumn index;
    @FXML
    protected TableColumn host;
    @FXML
    protected TableColumn name;
    @FXML
    protected TableColumn user;
    @FXML
    protected TableColumn password;
    @FXML
    protected Label status;

    // 返回tablecell绑定的回调函数
    protected Callback getCenterCallBack(){
        return new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                TableCell tc = new TableCell<Config, Object>(){
                    @Override
                    protected void updateItem(Object item, boolean empty) {
                        if(item != null) {
                            setText(item.toString());
                        } else {
                            setText(null);
                        }
                    }
                };
                tc.setAlignment(Pos.CENTER);
                tc.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if(event.getClickCount() == 2){
                            Clipboard clipboard = Clipboard.getSystemClipboard();
                            ClipboardContent content = new ClipboardContent();
                            content.putString(tc.getText().toString());
                            clipboard.setContent(content);
                            setStatus("复制成功: "+content.getString());
                        }
                    }
                });
                return tc;
            }
        };
    }

    // 设置状态
    private void setStatus(String message){
        status.setText(message);
    }


    protected void setResultTableView(){
        index.setCellValueFactory(new PropertyValueFactory<Config, Integer>("index"));
        index.setCellFactory(getCenterCallBack());
        host.setCellValueFactory(new PropertyValueFactory<Config, TableCell>("host"));
        host.setCellFactory(getCenterCallBack());
        name.setCellValueFactory(new PropertyValueFactory<Config, TableCell>("name"));
        name.setCellFactory(getCenterCallBack());
        user.setCellValueFactory(new PropertyValueFactory<Config, TableCell>("user"));
        user.setCellFactory(getCenterCallBack());
        password.setCellValueFactory(new PropertyValueFactory<Config, TableCell>("password"));
        password.setCellFactory(getCenterCallBack());
        resultTableView.getItems().addAll(ConfigUtil.getConfigList());
        setStatus("解密配置文件成功");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choseBtn.setOnAction(event -> {
            File file;
            if(configPath.getText().equals("")) {
                DirectoryChooser dirChooser = new DirectoryChooser();
                dirChooser.setTitle("选择配置文件路径");
                file = dirChooser.showDialog(Main.getStage());
            } else {
                file = new File(configPath.getText());
            }
            if (file != null && file.exists()) {
                configPath.setText(file.getAbsolutePath());
                FinalShell.setConfigPath(file);
                setResultTableView();
            } else{
                setStatus("路径不存在");
            }
        });
    }
}
