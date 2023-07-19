package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.post.dao.PostMapper;
import com.sns.post.domain.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostMapper postMapper;
	
	public List<Post> getPostListByUserId(int userId) {
		return postMapper.selectPostListByUserId(userId);
	}

}
