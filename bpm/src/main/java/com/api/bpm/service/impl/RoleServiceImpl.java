package com.api.bpm.service.impl;

import com.api.bpm.model.entities.BaseVaccineCard;
import com.api.bpm.model.entities.Role;
import com.api.bpm.repository.RoleRepository;
import com.api.bpm.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role getRoleById(long id){
        return roleRepository.getById(id);
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public Role updateRole(long id, Role roleRequest){
        Role role = roleRepository.findById(id).orElseThrow();
        role.setName(roleRequest.getName());
        return roleRepository.save(role);
    }

    public void deleteRole(long id){
        Role role = roleRepository.findById(id).orElseThrow();
        roleRepository.delete(role);
    }
}
