package com.example.demo.service;

import com.example.demo.domain.Sample;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {
    private final MongoTemplate primaryMongoTemplate;
    private final MongoTemplate secondaryMongoTemplate;
    public SampleServiceImpl(@Qualifier("primaryMongoTemplate")MongoTemplate primaryMongoTemplate,
                             @Qualifier("secondaryMongoTemplate")MongoTemplate secondaryMongoTemplate) {
        this.primaryMongoTemplate = primaryMongoTemplate;
        this.secondaryMongoTemplate = secondaryMongoTemplate;
    }

    @Override
    public Sample getSample(String id) {
        return this.primaryMongoTemplate.findById(id, Sample.class);
    }

    @Override
    public List<Sample> getSamples(String name) {
        var query = this.primaryMongoTemplate.query(Sample.class)
                .matching(Query.query(Criteria.where("name").is(name)));

        return query.stream().toList();
    }

    @Override
    public Sample saveSample(Sample sample) {
        return this.primaryMongoTemplate.save(sample);
    }

    @Override
    public Sample updateSample(Sample sample) {
        return this.primaryMongoTemplate.save(sample);
    }

    @Override
    public void deleteSample(String id) {
        this.primaryMongoTemplate.remove(new Query(Criteria.where("id").is(id)), Sample.class);
    }
}
