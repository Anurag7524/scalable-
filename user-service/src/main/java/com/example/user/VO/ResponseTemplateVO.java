package com.example.user.VO;

import com.example.user.entity.Userd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Userd user;
    private Department department;
}
