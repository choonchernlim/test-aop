package com.choonchernlim.testAOP.example4.service;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class Example4DataService {

    private final Example4LogService logService;

    @Autowired
    public Example4DataService(Example4LogService logService) {
        this.logService = logService;
    }

    public Collection<String> getLotsOfDataByUserId(final long userId) {

        final List<String> list = Arrays.asList("Data 1", "Data 2", "Data 3");

        logService.log(list, userId, LocalDateTime.now());

        return list;
    }
}
