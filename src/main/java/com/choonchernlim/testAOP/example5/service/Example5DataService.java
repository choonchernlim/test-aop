package com.choonchernlim.testAOP.example5.service;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class Example5DataService {

    private final Example5LogService logService;

    @Autowired
    public Example5DataService(Example5LogService logService) {
        this.logService = logService;
    }

    public Collection<String> getLotsOfDataByUserId(final long userId) {

        final List<String> list = Arrays.asList("Data 1", "Data 2", "Data 3");

        logService.log(list, userId, LocalDateTime.now());

        return list;
    }
}
