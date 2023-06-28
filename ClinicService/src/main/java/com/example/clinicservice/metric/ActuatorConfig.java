package com.example.clinicservice.metric;

import com.example.clinicservice.service.CatService;
import com.example.clinicservice.service.DogService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Configuration
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ActuatorConfig implements InfoContributor {

    CatService catService;
    DogService dogService;
    LocalDateTime startTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    Environment env;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("Start time", startTime)
                .withDetail("Service version", getProperty("spring.application.version"))
                .withDetail("Total cat client amount", catService.count())
                .withDetail("Total dog client amount", dogService.count())
                .build();
    }


    private String getProperty(String key) {
        return env.getProperty(key);
    }


}
