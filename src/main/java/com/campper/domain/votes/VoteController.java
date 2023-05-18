package com.campper.domain.votes;

import com.campper.domain.votes.service.VoteService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/vote")
@Api(tags = "투표")
public class VoteController {
    private final VoteService voteService;
}
