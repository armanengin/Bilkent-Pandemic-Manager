package com.api.bpm.controller;

import com.api.bpm.model.entities.Role;
import com.api.bpm.service.RoleService;
import com.api.bpm.service.impl.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role roleRequest = roleService.createRole(role);
        return new ResponseEntity<Role>(role, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<Role> updateRole(@PathVariable long id, @RequestBody Role role){
        Role roleRequest = roleService.updateRole(id, role);
        return ResponseEntity.ok().body(roleRequest);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<ApiResponse> deleteRole(@PathVariable(name = "id") Long id) {
        roleService.deleteRole(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Role deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<Role> getRoleById(@PathVariable(name ="id")Long id){
        Role role = roleService.getRoleById(id);
        return ResponseEntity.ok().body(role);
    }
}
