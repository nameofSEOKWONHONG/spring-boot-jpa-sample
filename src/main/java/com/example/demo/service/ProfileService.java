package com.example.demo.service;

import com.example.demo.domain.Notice;
import com.example.demo.domain.Profile;
import com.example.demo.domain.ProfileId;
import com.example.demo.dto.NoticeDto;
import com.example.demo.dto.NoticeSearchCriteria;
import com.example.demo.dto.ProfileDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    List<Profile> findAll();
    Profile findById(ProfileId id);
    Profile save(Profile profile);
    Profile update(ProfileId id, String name, int age);
}
