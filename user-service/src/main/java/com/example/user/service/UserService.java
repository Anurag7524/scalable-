package com.example.user.service;

import com.example.user.VO.Department;
import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.Userd;
import com.example.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Userd saveUser(Userd user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) throws RestClientException {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Userd user = userRepository.findByUserId(userId);

            Department department =
                    restTemplate.getForObject("http://localhost:9005/departments/" + user.getDepartmentId()
                            , Department.class);

            vo.setUser(user);
            vo.setDepartment(department);

            return vo;

    }
}
