package com.school_automation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ManagerDTO {
    private String userName;
    private String password;
    private Long id;

}
