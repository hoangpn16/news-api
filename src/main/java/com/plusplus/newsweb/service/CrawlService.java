package com.plusplus.newsweb.service;

import com.plusplus.newsweb.entity.JobModel;
import com.plusplus.newsweb.entity.repository.JobRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrawlService {
    Logger logger = LogManager.getLogger(CrawlService.class);

    @Autowired
    JobRepository jobRepository;

    public void parserAllJob(String type) {
        jobRepository.deleteAll();
        String url = "https://itviec.com/it-jobs/" + type;
        List<String> listLink = parserListLink(url);
        for (String link : listLink) {
            logger.info("Crawling link =" + link);
            JobModel jobModel = parserDetailJob(link, type.toLowerCase());
            jobRepository.save(jobModel);
        }
    }

    public List<String> parserListLink(String url) {
        List<String> listLink = new ArrayList<>();
        Document html = getHtmlContent(url);
        Elements elements = html.select("h3.title");
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            String link = element.select("a").first().attr("href");
            listLink.add("https://itviec.com/" + link);
        }
        return listLink;
    }

    public JobModel parserDetailJob(String url, String type) {
        JobModel jobModel = jobRepository.findByLinkJob(url);
        if (jobModel == null) {
            jobModel = new JobModel();
        }

        Document html = getHtmlContent(url);

        String jobTitle = html.select("div.job-details__header").select("h1").text();
        String companyLogo = html.select("div.employer-long-overview__logo").select("picture").first().select("img").attr("data-src");
        String companyAddress = html.getElementsByClass("svg-icon__text").select("span").text();
        String companyName = html.select("div.employer-long-overview__top-left").select("a").text();

        if (jobTitle != null)
            jobModel.setJobTitle(jobTitle);
        if (companyLogo != null)
            jobModel.setCompanyLogo(companyLogo);
        if (companyAddress != null)
            jobModel.setCompanyAddress(companyAddress);
        if (companyName != null)
            jobModel.setCompanyName(companyName);
        if (url != null)
            jobModel.setLinkJob(url);
        if (type != null)
            jobModel.setType(type);

        return jobModel;
    }

    private Document getHtmlContent(String url) {
        Document pageHtml;
        try {
            Connection.Response response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .followRedirects(true)
                    .timeout(30000)
                    .execute();
            pageHtml = response.parse();
            return pageHtml;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
