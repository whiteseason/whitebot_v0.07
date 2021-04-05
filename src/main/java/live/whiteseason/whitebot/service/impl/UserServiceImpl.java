package live.whiteseason.whitebot.service.impl;

import live.whiteseason.whitebot.domain.entity.User;
import live.whiteseason.whitebot.mapper.UserMapper;
import live.whiteseason.whitebot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whiteseason
 * @since 2021-02-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
