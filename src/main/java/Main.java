import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Main run = new Main();
        run.loadData("https://www.youtube.com/playlist?list=PLWBrqglnjNl1LwsWW_CTzA_dSgyE3x5TQ");
    }

    private Connection loadUrl(String url) throws IOException{
        Connection connection = null;

        connection = Jsoup.connect(url);

        return connection;
    }


    private void loadData(String url) throws IOException{
        Document document = this.loadUrl(url).get();
        Element playList = document.getElementById("pl-video-list");
        Elements video = playList.select("tr.pl-video");
        for (Element element : video){
            String videoId = element.attr("data-video-id");
            System.out.println("video url : https://www.youtube.com/watch?v="+videoId);
            System.out.println("video thumbnail : https://i.ytimg.com/vi/"+videoId+"/hqdefault.jpg");
            System.out.println("video title : "+element.select("a.pl-video-title-link").text());
            System.out.println("Video Owner : "+element.select("div.pl-video-owner").text());
            System.out.println("Video duration : "+element.select("div.timestamp").text());
            System.out.println("-----------------------------------------------");
        }
    }

}
