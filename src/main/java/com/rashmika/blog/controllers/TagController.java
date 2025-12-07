package com.rashmika.blog.controllers;

import com.rashmika.blog.domain.dtos.CreateTagsRequest;
import com.rashmika.blog.domain.dtos.TagResponse;
import com.rashmika.blog.domain.entities.Tag;
import com.rashmika.blog.mapper.TagMapper;
import com.rashmika.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags(){
        List<Tag> tags = tagService.getTags();
        List<TagResponse> tagResponses = tags.stream().map(tagMapper::toTagResponse).toList();

        return ResponseEntity.ok(tagResponses);
    }

    @PostMapping
    public ResponseEntity<List<TagResponse>> createTags(@RequestBody CreateTagsRequest createtagsRequest){
        List<Tag> savedTags = tagService.createTags(createtagsRequest.getNames());
        List<TagResponse> createdTagResponses = savedTags.stream().map(tagMapper::toTagResponse).toList();

        return new ResponseEntity<>(
           createdTagResponses,
                HttpStatus.CREATED
        );
    }
}
