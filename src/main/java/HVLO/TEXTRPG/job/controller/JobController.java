package HVLO.TEXTRPG.job.controller;

import HVLO.TEXTRPG.job.dto.JobDTO;
import HVLO.TEXTRPG.job.dto.PassiveSkillDTO;
import HVLO.TEXTRPG.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping
    public ResponseEntity<JobDTO> getJob() {
        return ResponseEntity.ok(jobService.getJobDTOById(1L));
    }



}
