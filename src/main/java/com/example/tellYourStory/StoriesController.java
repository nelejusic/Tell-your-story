package com.example.tellYourStory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/stories")

public class StoriesController {
    private final StoriesRepository storiesRepository;

    @Autowired
    public StoriesController( StoriesRepository storiesRepository) { this.storiesRepository = storiesRepository; }

    @PostMapping
    public void saveStory(@RequestBody Stories stories){

        storiesRepository.save(stories); }

    @GetMapping
        public List<Stories>getStories(){ return storiesRepository.findAll();}



    @DeleteMapping("/{id}")
    public void deleteStory(@PathVariable("id") Long id){ storiesRepository.deleteById(id); }

    @PostMapping ("/publish/{id}")
    public void publishedStory(@PathVariable("id") String id){
        Long idLong = Long.valueOf(id);
        Stories stories = storiesRepository.getOne(idLong);

        if (stories==null){
            throw new RuntimeException("Nepostojeća priča");
        }
        stories.setPublished(true);
        storiesRepository.save(stories);

    }  @PostMapping ("/aprove/{id}")
    public void likedStory(@PathVariable("id") String id){
        Long idLong = Long.valueOf(id);
        Stories stories = storiesRepository.getOne(idLong);

        if (stories==null){
            throw new RuntimeException("Nepostojeća priča");
        }
        stories.setApproved(stories.getApproved()+1);
        storiesRepository.save(stories);

    }



    @PostMapping ("/disapprove/{id}")
    public void disLikedStory(@PathVariable("id") String id){
        Long idLong = Long.valueOf(id);
        Stories stories = storiesRepository.getOne(idLong);

        if (stories==null){
            throw new RuntimeException("Nepostojeća priča");
        }
        stories.setDisapproved(stories.getDisapproved()+1);
        storiesRepository.save(stories);

    }


}
