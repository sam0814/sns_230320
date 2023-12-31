package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sns.common.FileManagerService;
import com.sns.post.dao.PostMapper;
import com.sns.post.dao.PostRepository;
import com.sns.post.domain.Post;
import com.sns.post.entity.PostEntity;

@Service
public class PostBO {
	
	@Autowired
	private FileManagerService  fileManager;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private PostMapper postMapper; // mybatis 지금 안씀
	
	public List<Post> getPostListByUserId(int userId) {
		return postMapper.selectPostListByUserId(userId);
	}
	
	public List<PostEntity> getPostList() {
		return postRepository.findAllByOrderByIdDesc();
	}
	
	public PostEntity addPost(int userId, String userLoginId, String content, MultipartFile file) {
		  String imagePath = null;
		  
		  // 이미지가 있으면 업로드 후 imagePath 받아오기
		  if (file != null) {
			  imagePath = fileManager.saveFile(userLoginId, file);
		  }
		   
			return postRepository.save(
					PostEntity.builder()
					.userId(userId)
					.content(content)
					.imagePath(imagePath)
					.build());
	}
	
	

}
