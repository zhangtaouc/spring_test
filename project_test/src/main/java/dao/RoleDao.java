package dao;

import domain.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getRoleList();

    int addRole(Role role);

    List<Role> findRoleByUserId(Long id);
}
