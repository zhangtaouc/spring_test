package service.impl;

import dao.RoleDao;
import domain.Role;
import org.springframework.stereotype.Component;
import service.RoleService;

import java.util.List;
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = roleDao.getRoleList();
        return roleList;
    }

    @Override
    public int addRole(Role role) {
        int num = roleDao.addRole(role);
        return num;
    }
}
