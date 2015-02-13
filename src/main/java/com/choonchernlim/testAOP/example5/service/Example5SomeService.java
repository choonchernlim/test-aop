package com.choonchernlim.testAOP.example5.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Example5SomeService {

    private final Example5DataService dataService;

    @Autowired
    public Example5SomeService(Example5DataService dataService) {
        this.dataService = dataService;
    }

    public String query() {
        return StringUtils.join(dataService.getLotsOfDataByUserId(1L), ", ");
    }
}
