package com.example.demo.repository;

import com.example.demo.domain.Profile;
import com.example.demo.domain.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, ProfileId>, JpaSpecificationExecutor<Profile> {
}
