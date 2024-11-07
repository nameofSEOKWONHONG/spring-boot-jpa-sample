package com.example.demo.controller;

import com.example.demo.domain.Profile;
import com.example.demo.domain.ProfileId;
import com.example.demo.dto.ProfileDto;
import com.example.demo.service.NoticeServiceImpl;
import com.example.demo.service.ProfileService;
import com.example.demo.service.ProfileServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private final ProfileServiceImpl profileService;
    public ProfileController(ProfileServiceImpl profileService) {
        this.profileService = profileService;
    }

    @GetMapping()
    public ResponseEntity<List<Profile>> getAll() {
        var result = this.profileService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{accountId}/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable("accountId") String accountId, @PathVariable String id) {
        var profileId = new ProfileId(id, accountId);
        var result = this.profileService.findById(profileId);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Profile> createProfile(@RequestBody ProfileDto profileDto) {
        var profileId = new ProfileId(UUID.randomUUID().toString(), profileDto.getAccountId());
        var profile = new Profile(profileId, profileDto.getName(), profileDto.getAge());

        var result = this.profileService.save(profile);
        return ResponseEntity.ok(result);
    }
}
