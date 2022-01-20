package com.personnel_automation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeveloperDTO {
    private String name;
    private String userName;
    private String password;
    private int pay;
    private Long id;

}
