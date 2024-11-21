package com.example.demo.controller;

import com.example.demo.domain.Sample;
import com.example.demo.dto.Results;
import com.example.demo.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sample")
public class SampleController {
    private final SampleService sampleService;
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Results<Sample>> getById(@PathVariable("id") String id) {
        var item = sampleService.getSample(id);
        return ResponseEntity.ok(new Results<>(item, "success", true));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Results<List<Sample>>> getByName(@PathVariable("name") String name) {
        var item = sampleService.getSamples(name);
        return ResponseEntity.ok(new Results<>(item, "success", true));
    }

    @PostMapping()
    public ResponseEntity<Results<Sample>> save(@RequestBody Sample sample) {
        var item = sampleService.saveSample(sample);
        return ResponseEntity.ok(new Results<>(item, "success", true));
    }

    @PutMapping()
    public ResponseEntity<Results<Sample>> update(@RequestBody Sample sample) {
        var item = sampleService.updateSample(sample);
        return ResponseEntity.ok(new Results<>(item, "success", true));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Results> delete(@PathVariable("id") String id) {
        sampleService.deleteSample(id);
        return ResponseEntity.ok(new Results<>(null, "success", true));
    }
}
