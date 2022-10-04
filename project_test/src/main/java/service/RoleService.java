package service;

import domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getRoleList();

    int addRole(Role role);
}
