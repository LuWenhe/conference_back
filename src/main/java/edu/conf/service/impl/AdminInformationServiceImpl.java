package edu.conf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.conf.dto.AdminInformationDTO;
import edu.conf.dto.AdminInformationSaveDTO;
import edu.conf.dto.AdminInformationUpdateDTO;
import edu.conf.entity.AdminInformation;
import edu.conf.enums.AdminRole;
import edu.conf.exception.HintException;
import edu.conf.mapper.AdminInformationMapper;
import edu.conf.service.AdminInformationService;
import edu.conf.utils.EncryptUtil;
import edu.conf.utils.HashUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminInformationServiceImpl extends ServiceImpl<AdminInformationMapper, AdminInformation>
        implements AdminInformationService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean checkPassword(String username, String password) {
        // 对密码进行加密后与数据库中的密码进行比对
        int count = count(new QueryWrapper<AdminInformation>().eq(USERNAME, username).eq(PASSWORD, EncryptUtil.getEnpPassword(password)));
        return count >= 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveAdminInformation(AdminInformationSaveDTO dto) {
        int count = count(new QueryWrapper<AdminInformation>().eq(USERNAME, dto.getUsername()));

        if (count > 0) {
            throw new HintException("用户名已经存在");
        }

        dto.setPassword(HashUtils.encrypt(dto.getUsername(), dto.getPassword()));
        return save(modelMapper.map(dto, AdminInformation.class));
    }

    @Override
    public boolean removeAdminInformationById(Integer id) {
        int count = count(new QueryWrapper<AdminInformation>().eq(ID, id));
        if (count < 1) {
            throw new HintException("管理员不存在");
        }
        return removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateAdminInformation(AdminInformationUpdateDTO dto) {
        int count = count(new QueryWrapper<AdminInformation>().eq(USERNAME, dto.getUsername()));
        if (count < 1) {
            throw new HintException("此用户名不存在");
        }
        String password = HashUtils.encrypt(dto.getUsername(), dto.getPassword());
        return update(new UpdateWrapper<AdminInformation>().set(PASSWORD, password).eq(USERNAME, dto.getUsername()));
    }

    @Override
    public AdminInformationDTO getAdminInformationByUsername(String username) {
        AdminInformation adminInformation = getOne(new QueryWrapper<AdminInformation>()
                .select(ID, USERNAME, ROLE).eq(USERNAME, username));

        if (adminInformation != null) {
            return modelMapper.map(adminInformation, AdminInformationDTO.class);
        }

        return null;
    }

    @Override
    public List<AdminInformationDTO> getAdminInformationList() {
        List<AdminInformation> list = list(new QueryWrapper<AdminInformation>().select(ID, USERNAME).eq(ROLE, AdminRole.GENERAL_ADMIN));
        return modelMapper.map(list, new TypeToken<List<AdminInformationDTO>>(){}.getType());
    }
}
