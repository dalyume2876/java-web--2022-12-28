package com.kdh.board.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    
    // // 스케쥴 작업이 끝나는 시간 기준으로 실행
    // @Scheduled(fixedDelay = 1000)
    // public void scheduleFixedDelay(){
    //     System.out.println("고정 딜레이 작업 : " + System.currentTimeMillis() / 1000);
    // }

    // // 스케줄 작업이 시작하는 기준으로 실행
    // @Scheduled(fixedRate=1000)
    // public void scheduleFixedRate(){
    //     System.out.println("시작 고정 딜레이 작업 : " + System.currentTimeMillis() / 1000);
    // }

    @Scheduled(cron = "2 * * * * ?")
    public void scheduleCronJob(){
        try {
            crawlling();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crawlling() throws Exception {

        Document document = Jsoup.connect("https://naver.com").get();

        Elements elements = document.selectXpath("#NM_FAVORITE > div.group_nav > ul.list_nav.NM_FAVORITE_LIST > li > a");
        
        for (Element element: elements) {
            System.out.println(element.attr("href"));
        }
    }

}
