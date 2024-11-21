package com.example.demo.service;

import com.example.demo.domain.Sample;

import java.util.List;

public interface SampleService {
    Sample getSample(String id);
    List<Sample> getSamples(String name);
    Sample saveSample(Sample sample);
    Sample updateSample(Sample sample);
    void deleteSample(String id);
}
