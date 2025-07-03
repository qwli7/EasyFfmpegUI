module EasyFFmpegUI {
    requires java.base;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    exports easyffmpeg to javafx.base,javafx.fxml,javafx.graphics,javafx.controls;
}