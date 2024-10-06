package com.geeksforgeeks.library.elib.controller;

import com.geeksforgeeks.library.elib.dto.IssueDataDto;
import com.geeksforgeeks.library.elib.entity.IssueData;
import com.geeksforgeeks.library.elib.service.IssueDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/issue_data")
public class IssueDataController {

    private final IssueDataService issueDataService;

    @Autowired
    public IssueDataController(IssueDataService issueDataService) {
        this.issueDataService = issueDataService;
    }

    @PostMapping
    public ResponseEntity<IssueData> addIssueData(@RequestBody IssueDataDto issueDataDto) {
        IssueData issueData = this.issueDataService.addIssueData ( issueDataDto );
        return new ResponseEntity<> ( issueData, HttpStatus.OK );
    }

    @GetMapping
    public ResponseEntity<List<IssueData>> getIssueDataByMemberId(@RequestParam UUID memberId) {
        List<IssueData> issueDataList = this.issueDataService.getIssueDataByMemberId ( memberId );
        return new ResponseEntity<> ( issueDataList, HttpStatus.OK );
    }
}
