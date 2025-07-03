package easyffmpeg.ui;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainPane extends Parent {

    private HBox hBox;


    public MainPane(Stage primaryStage) {
        hBox = new HBox(20);
        Button button = new Button("浏览");

        button.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("选择文件");
            fileChooser.setInitialDirectory(new File(".")); //初始路径

            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("图片", "*.jpg", "*.png"),
                    new FileChooser.ExtensionFilter("视频", "*.mp4"),
                    new FileChooser.ExtensionFilter("所有文件", "*.*")
            );

            File file = fileChooser.showOpenDialog(primaryStage);
            System.out.println(file.toString());
        });

        hBox.getChildren().add(button);

    }
}
