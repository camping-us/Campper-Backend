package com.campper.domain.votes;

import com.campper.domain.users.entity.User;
import com.campper.domain.votes.dto.request.PostVoteDto;
import com.campper.domain.votes.dto.response.GetVoteDto;
import com.campper.domain.votes.service.VoteService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/votes")
@Api(tags = "투표")
public class VoteController {
    private final VoteService voteService;

    @PostMapping("/{campId}")
    @Operation(summary = "투표 저장 요청", description = "투표 저장 요청 API 입니다.")
    public void postVote(@PathVariable Long campId, @RequestBody PostVoteDto postVoteDto, @AuthenticationPrincipal User user) {
        voteService.saveVote(campId, postVoteDto, user);
    }

    @GetMapping("/{campId}")
    @Operation(summary = "투표 저장 요청", description = "투표 저장 요청 API 입니다.")
    public Boolean getIsVote(@PathVariable Long campId, @AuthenticationPrincipal User user) {
        return voteService.checkVote(campId, user);
    }

    @GetMapping("")
    @Operation(summary = "투표 내역 호출 요청", description = "투표 내역 호출 요청 API 입니다.")
    public GetVoteDto getVote(@RequestParam Long campId, @AuthenticationPrincipal User user) {
        return voteService.getVote(campId, user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "투표 삭제 요청", description = "투표 삭제 요청 API 입니다.")
    public void delVote(@PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        voteService.delVote(id, user);
    }
}
