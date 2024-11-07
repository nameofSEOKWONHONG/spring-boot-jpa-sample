package com.example.demo.service;

import com.example.demo.domain.Profile;
import com.example.demo.domain.ProfileId;
import com.example.demo.dto.ProfileDto;
import com.example.demo.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    final ProfileRepository profileRepository;
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile findById(ProfileId id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile update(ProfileId id, String name, int age) {
        var exists = profileRepository.findById(id);
        if(exists.get() != null) {
            exists.get().setName(name);
            exists.get().setAge(age);
            return profileRepository.save(exists.get());
        }

        return null;
    }
}
