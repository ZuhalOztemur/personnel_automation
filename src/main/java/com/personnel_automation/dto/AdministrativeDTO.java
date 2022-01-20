package com.personnel_automation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdministrativeDTO {
    private String name;
    private String password;
    private String userName;
    private String branch;
    private Long id;
}
