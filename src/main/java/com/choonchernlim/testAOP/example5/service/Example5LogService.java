package com.choonchernlim.testAOP.example5.service;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Example5LogService {
    public void log(final List<String> list, final long userId, final LocalDateTime dateTime) {
        System.out.println("logging data... ");
    }
}
