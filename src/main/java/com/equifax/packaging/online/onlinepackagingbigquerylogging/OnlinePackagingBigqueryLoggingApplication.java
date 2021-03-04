package com.equifax.packaging.online.onlinepackagingbigquerylogging;

import com.equifax.packaging.online.logging.filter.LoggingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlinePackagingBigqueryLoggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinePackagingBigqueryLoggingApplication.class, args);
    }

    @Bean
    public LoggingFilter getFilter(){
        return new LoggingFilter();
    }

}
