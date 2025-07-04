package easyffmpeg.function;

import javafx.animation.AnimationTimer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * javafx mediaplayer 单帧播放
 */
public class FrameByFramePlayer {

    private MediaPlayer mediaPlayer;
    private Double frameDurationMs = 33.3; //默认30fps
    private AnimationTimer frameTimer; //提供高精度计时循环


    public void initPlayer(String mediaPath) {
        Media media = new Media(mediaPath);
        mediaPlayer = new MediaPlayer(media);


        //mediaPlayer.getCurrentTime() //获取当前播放时间戳

        frameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Duration next = mediaPlayer.getCurrentTime()
                        .add(Duration.millis(frameDurationMs));
                mediaPlayer.seek(next);
            }
        };
    }

    public void setFrameRate(double fps) {
        this.frameDurationMs = 1000/fps;
    }

    public void startFrameByFrame() {
        frameTimer.start();
    }

    public void stop() {
        frameTimer.stop();
    }
}
