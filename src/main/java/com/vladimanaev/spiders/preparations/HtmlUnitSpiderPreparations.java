package com.vladimanaev.spiders.preparations;

import com.gargoylesoftware.htmlunit.*;
import org.apache.http.annotation.ThreadSafe;
import org.apache.log4j.Logger;

/**
 * Created by Vladi
 * Date: 9/17/2016
 * Time: 4:37 PM
 * Copyright VMSR
 */
@ThreadSafe
public class HtmlUnitSpiderPreparations implements SpiderPreparations<String, WebClient> {

    private static final Logger LOGGER = Logger.getLogger(HtmlUnitSpiderPreparations.class);

    @Override
    public WebClient execute(String url) {
        LOGGER.debug("Executing preparation for [" + url + "]");

        final WebClient webClient = new WebClient();
        WebClientOptions options = webClient.getOptions();

        options.setRedirectEnabled(true);
        options.setJavaScriptEnabled(true);
        options.setCssEnabled(true);

        options.setThrowExceptionOnScriptError(false);
        options.setThrowExceptionOnFailingStatusCode(false);
        options.setPopupBlockerEnabled(false);
        options.setPrintContentOnFailingStatusCode(false);

        return webClient;
    }
}