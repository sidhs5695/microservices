package com.citi.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citi.user.VO.Department;
import com.citi.user.VO.ResponseTemplateVO;
import com.citi.user.entity.User;
import com.citi.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

   

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department =restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class); 
 
        vo.setUser(user);
        vo.setDepartment(department);
        return  vo;
    }

	public User saveUser(User user) {
        return userRepository.save(user);

	}
}
