package com.equifax.packaging.online.onlinepackagingbigquerylogging.controller;

import com.equifax.packaging.online.logging.logger.CustomLogger;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/intl-ca-online-packaging/logging/api/v2/")
public class LoggingRestController {

    private static final Logger LOGGER = CustomLogger.getConsoleJsonLogger();

    @GetMapping("/log")
    public String sampleLog() {
        LOGGER.info("Called smaplelog 0...");
        MDC.put("key", "Value");
        LOGGER.info("Called smaplelog 1...");
        return "This is smaple log";
    }
}
