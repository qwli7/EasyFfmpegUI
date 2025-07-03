package easyffmpeg.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class FFprobe {


    private static Path ffprobePath = Path.of("D:\\DevTools\\ffmpeg-master-latest-win64-gpl-shared\\bin\\ffprobe.exe");



    public static void main(String[] args) throws IOException {
        run(null);
    }


    public static void run(String cmd) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(
                ffprobePath.toString(),
                "-hide_banner",
                "-v",
                "quiet",
                "-print_format",
                "json",
                "-show_format",
                "-show_streams",
                "D:\\DevCodes\\Github\\EasyFFmpegUI\\src\\main\\resources\\video.mp4"
        );

        Process process = processBuilder.start();

        StringBuilder result = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
        )) {
            String line;
            while((line = reader.readLine()) != null) {
                result.append(line);
            }
        }
        System.out.println(result);
    }

}
