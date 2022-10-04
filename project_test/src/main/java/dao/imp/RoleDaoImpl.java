package dao.imp;

import dao.RoleDao;
import domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbc;

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    // 获取角色列表
    public List<Role> getRoleList() {
        List<Role> roleList = jdbc.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public int addRole(Role role) {
        int num = jdbc.update("insert into sys_role values(?,?,?)", null, role.getRoleName(), role.getRoleDesc());
        return num;
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        List<Role> roleList = jdbc.query("select * from sys_user_role ur , sys_role r where ur.roleId = r.id and ur.userId =?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roleList;
    }
}
