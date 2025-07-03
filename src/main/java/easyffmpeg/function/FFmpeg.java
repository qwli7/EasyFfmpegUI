package easyffmpeg.function;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FFmpeg {


    private static Path ffmpegPath = Path.of("D:\\DevTools\\ffmpeg-master-latest-win64-gpl-shared\\bin\\ffmpeg.exe");
    private static Path ffprobePath = Path.of("D:\\DevTools\\ffmpeg-master-latest-win64-gpl-shared\\bin\\ffprobe.exe");


    private static String videoPath = "D:\\DevCodes\\Github\\EasyFFmpegUI\\src\\main\\resources\\video.mp4";

    public static void main(String[] args) throws IOException {

        System.out.println("hello world");
//        run("");
//        run2(); //原样封装（无损，直接复制音视频流，速度快）
//        run3(); //指定h264编码+3000kbps视频码率， aac 音频+192kpbs码率
//        run4(); //片段截取
        run5(); //利用h265 crf 压缩视频
        String compress = """
                
                //-hide_banner 隐藏ffmpeg banner
                //-strict -2  禁止实验性功能  -strict 2 启用实验性功能
                
                
                ffmpeg -i input.mp4 -g 60 output.mp4 //60帧插入关键帧
                ffmpeg -i input.mp4 -vf "scale=1280:-1" -r 30 output.mp4 //宽度缩至1280px（高度自适应），帧率降到 30fps
                ffmpeg -i input.mp4 -c:a aac -b:a 64k output.mp4 //降低音频码率到64kbps，通常为128kbps
                ffmpeg -i input.mp4 -c:v h264_nvenc -preset fast output.mp4 //硬件加速  英伟达显卡
                
                //提取纯视频
                ffmpeg -i input.mp4 -vcodec copy -an video_only.mp4 //-an 移除音频流，-vcodec copy 视频编码保持不变
                //提取纯音频
                ffmpeg -i input.mp4 -acodec copy -vn audio_only.aac //-vn 忽略视频流 -acodec copy 直接复制音频流                
                
                //音频转mp3
                ffmpeg -i input.mp4 -q:a 0 -map a.output.mp3 // -q:a 0 设置最高音频质量
                
                //视频转h264 编码
                ffmpeg -i input.mp4 -c:v libx264 -an output.h264
                
                //保留封装格式
                ffmpeg -i input.mkv -map 0:v -c copy video.mkv //-map 0:v 选择第一个输入文件的视频流
                
                //精确时间戳提取
                ffmpeg -i input.mp4 -ss 00:01:30 -t 10 -acodec copy clip.mp3 //从1min30s开始提取10s音频
                """;
    }



    public static void run(String cmd) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(ffmpegPath.toString(),  "-i",
                "-strict",
                "-2",
                "-hide_banner",
                "D:\\DevCodes\\Github\\EasyFFmpegUI\\src\\main\\resources\\video.mp4");
        processBuilder.start();
    }

    public static void run2() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(ffmpegPath.toString(),
                "-i",
                videoPath,
                "-c:v",
                "copy",
                "-c:a",
                "copy",
                Path.of(Path.of(videoPath).getParent().toString(), System.currentTimeMillis()+".mp4").toString()
                );
        processBuilder.start();
    }

    public static void run3() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(ffmpegPath.toString(),
                "-i",
                videoPath,
                "-c:v",
                "libx264",
                "-b:v",
                "3000k",
                "-c:a",
                "aac",
                "-b:a",
                "192k",
                Path.of(Path.of(videoPath).getParent().toString(), System.currentTimeMillis()+".mp4").toString()
        );
        processBuilder.start();
    }

    public static void run4() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(ffmpegPath.toString(),
                "-ss",
                "00:01:30",
                "-t",
                "10",
                "-i",
                videoPath,
                "-c",
                "copy",
                Path.of(Path.of(videoPath).getParent().toString(), System.currentTimeMillis()+".mp4").toString()
        );
        processBuilder.start();
    }

    public static void run5() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(ffmpegPath.toString(),
                "-i",
                videoPath,
                "-c:v",
                "libx265",
                "-crf",
                "28",
                Path.of(Path.of(videoPath).getParent().toString(), System.currentTimeMillis()+".mp4").toString()
        );
        processBuilder.start();
    }











}
