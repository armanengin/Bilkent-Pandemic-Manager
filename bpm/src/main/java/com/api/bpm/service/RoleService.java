package com.api.bpm.service;

import com.api.bpm.model.entities.Course;
import com.api.bpm.model.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(long id);
    Role createRole(Role role);
    Role updateRole(long id, Role role);
    void deleteRole(long id);
}
