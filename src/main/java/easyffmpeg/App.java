package easyffmpeg;

import easyffmpeg.ui.MainPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class App extends Application {

    private static final int initWindow = 800;
    private static final int initHeight = 600;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("EasyFfmpegUI");
//        Button button = new Button("浏览");
//
//        button.setOnAction(event -> {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("选择文件");
//            fileChooser.setInitialDirectory(new File(".")); //初始路径
//
//            fileChooser.getExtensionFilters().addAll(
//                    new FileChooser.ExtensionFilter("图片", "*.jpg", "*.png"),
//                    new FileChooser.ExtensionFilter("视频", "*.mp4"),
//                    new FileChooser.ExtensionFilter("所有文件", "*.*")
//            );
//
//            File file = fileChooser.showOpenDialog(stage);
//            System.out.println(file.toString());
//        });

        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(this.getClass().getResourceAsStream("/fxml/MainPane.fxml"));
        Object controller = fxmlLoader.getController(); //获取到对应的控制器

//        MainPane mainPane = new MainPane(stage);
        Scene scene = new Scene(root, initWindow, initHeight);
        stage.setScene(scene);
        stage.show();
    }
}
