package com.shablobank.app.controller;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Role;
import com.shablobank.app.repository.IRoleRepository;
import com.shablobank.app.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/rest/role")
@CrossOrigin("*")
public class RoleController {

    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private RoleService roleService;
    private final Logger LOGGER = LoggerFactory.getLogger(com.shablobank.app.controller.AnalyseController.class);

    @GetMapping()
    public List<Role> fetchRole() {
        return roleService.fetchRoleList();
    }

    @GetMapping("{id}")
    public Role fetchRoleById(@PathVariable("id") Long idRole) throws EntityException {

        LOGGER.info("Inside fetchRole RoleController ");
        return roleService.fetchRole(idRole);
    }

    @DeleteMapping("{id}")
    public String deleteAnalyse(@PathVariable("id") Long idRole) throws EntityException{
        LOGGER.info("Inside deleteRole RoleController ");
        roleService.deleteRole(idRole);
        return "Delete successfull";
    }

    @PostMapping()
    public Role saveRole(@Validated @RequestBody Role role) {
        LOGGER.info("Inside SaveAnalyse AnalyseController ");
        return roleService.saveRole(role);
    }

    @PutMapping("{id}")
    public Role updateRole(@PathVariable("id") Long idRole, @Valid @RequestBody Role role) throws EntityException{
        LOGGER.info("Inside updateAnalyse AnalyseController ");
        return  roleService.updateRole(idRole, role);
    }
}
