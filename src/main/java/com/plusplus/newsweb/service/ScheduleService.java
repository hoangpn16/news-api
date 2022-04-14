package com.plusplus.newsweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import sun.plugin.javascript.navig.Link;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@EnableScheduling
public class ScheduleService {

    @Scheduled(cron = "0 15 10 ? * SUN")
    public void scheduleFixedRateTask() throws InterruptedException, IOException {
//        String url = "http://localhost:8081/itviec/crawldata?type=java,python,ai,frontend";
        URL url = new URL("http://localhost:8090/itviec/crawldata?type=java,python,ai,frontend");
        InputStream is = url.openConnection().getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}

