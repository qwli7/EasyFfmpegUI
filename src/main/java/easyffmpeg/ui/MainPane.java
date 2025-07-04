package easyffmpeg.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;


public class MainPane implements Initializable {

    @FXML
    public Label selectedFilePathLabel;
    @FXML
    public MediaView mediaView;
    @FXML
    public ProgressBar progressBar;
    @FXML
    public Button playButton;
    @FXML
    public Button pauseButton;
    @FXML
    public Slider volumeSlider;
    @FXML
    public ComboBox<String> speedCombo;
    @FXML
    private Button selectedFileButton;

    private Media media;
    private MediaPlayer mediaPlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        media = new Media("file:/D:/DevDocs/music/GpULzuPo_3212732760_shd.mp4");
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaView.setMediaPlayer(mediaPlayer);

//        volumeSlider.valueProperty().bindBidirectional(mediaPlayer.volumeProperty());
    }


    public void selectedFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("选择文件");
            fileChooser.setInitialDirectory(new File(".")); //初始路径

            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("图片", "*.jpg", "*.png"),
                    new FileChooser.ExtensionFilter("视频", "*.mp4"),
                    new FileChooser.ExtensionFilter("所有文件", "*.*")
            );

            File file = fileChooser.showOpenDialog(selectedFileButton.getScene().getWindow());
        URI uri = file.toURI();


        media = new Media(uri.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        volumeSlider.valueProperty().bindBidirectional(mediaPlayer.volumeProperty());
//
    }

    public void handlePlay(ActionEvent actionEvent) {
        mediaView.getMediaPlayer().play();
    }

    public void handlePause(ActionEvent actionEvent) {
        mediaView.getMediaPlayer().pause();
    }

    public void handleStop(ActionEvent actionEvent) {
        mediaView.getMediaPlayer().stop();
    }
}
