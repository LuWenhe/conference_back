package edu.conf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.conf.dto.AdminInformationDTO;
import edu.conf.dto.AdminInformationSaveDTO;
import edu.conf.dto.AdminInformationUpdateDTO;
import edu.conf.entity.AdminInformation;

import java.util.List;

public interface AdminInformationService extends IService<AdminInformation> {

    String ID = "id";

    String USERNAME = "username";

    String PASSWORD = "password";

    String ROLE = "role";

    String CREATE_TIME = "create_time";

    String UPDATE_TIME = "update_time";

    /**
     * 检验密码是否正确
     */
    boolean checkPassword(String username, String password);

    /**
     * 添加普通管理员信息
     */
    boolean saveAdminInformation(AdminInformationSaveDTO dto);

    /**
     * 删除管理员信息根据id
     */
    boolean removeAdminInformationById(Integer id);

    /**
     * 修改普通管理员密码
     */
    boolean updateAdminInformation(AdminInformationUpdateDTO dto);

    /**
     * 根据用户名查询管理员信息
     */
    AdminInformationDTO getAdminInformationByUsername(String username);

    /**
     * 查找普通管理员列表
     */
    List<AdminInformationDTO> getAdminInformationList();

}
