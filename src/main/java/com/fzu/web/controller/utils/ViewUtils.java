package com.fzu.web.controller.utils;

import com.fzu.pojo.Collect;
import com.fzu.pojo.User;
import com.fzu.pojo.Exclusive;
import com.fzu.repository.CollectRepository;
import com.fzu.repository.ExclusiveRepository;
import com.fzu.repository.UserRepository;
import com.fzu.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ViewUtils {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ExclusiveRepository exclusiveRepository;
	@Autowired
	private CollectRepository collectRepository;

	public User getCurrentUser() {
		return userRepository.findByEmail(SecurityUtils.getCurrentUserEmail());
	}

	public Exclusive getUserExclusive(){
		User user = getCurrentUser();
		List<Exclusive> exclusives = exclusiveRepository.findByOwnUserId(user.getId());
		if(null != exclusives){
			return exclusives.get(0);
		}
		return null;
	}

    public List<Exclusive> getUserExclusives(){
        User user = getCurrentUser();
        List<Exclusive> exclusives = exclusiveRepository.findByOwnUserId(user.getId());
        if(null != exclusives){
            return exclusives;
        }
        return null;
    }

    public boolean isCollect(Long articleId){
		Collect collect = collectRepository.findByUserIdAndArticleId(getCurrentUser().getId(), articleId);
		return null != collect;
    }

}
