package com.geeksforgeeks.library.elib.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class IssueDataDto {

    private UUID bookId;
    private UUID memberId;

}
