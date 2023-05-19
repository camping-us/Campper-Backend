package com.campper.domain.votes;

import com.campper.domain.users.entity.User;
import com.campper.domain.votes.dto.request.PostVoteDto;
import com.campper.domain.votes.dto.response.GetVoteDto;
import com.campper.domain.votes.service.VoteService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/vote")
@Api(tags = "투표")
public class VoteController {
    private final VoteService voteService;

    @PostMapping("/")
    public void postVote(@RequestParam Long campId, @RequestBody PostVoteDto postVoteDto, @AuthenticationPrincipal User user) {
        voteService.saveVote(campId, postVoteDto, user);
    }

    @GetMapping("/")
    public GetVoteDto getVote(@RequestParam Long campId, @AuthenticationPrincipal User user) {
        return voteService.getVote(campId, user);
    }

    @DeleteMapping("/{id}")
    public void delVote(@PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        voteService.delVote(id, user);
    }
}
