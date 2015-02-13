package com.choonchernlim.testAOP.example4.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Example4SomeService {

    private final Example4DataService dataService;

    @Autowired
    public Example4SomeService(Example4DataService dataService) {
        this.dataService = dataService;
    }

    public String query() {
        return StringUtils.join(dataService.getLotsOfDataByUserId(1L), ", ");
    }
}
