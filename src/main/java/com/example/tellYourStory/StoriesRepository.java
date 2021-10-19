package com.example.tellYourStory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StoriesRepository extends JpaRepository<Stories, Long> {
     List<Stories> findAllByPublished(boolean published);


}
