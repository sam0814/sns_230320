package com.sns.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.user.dao.UserRepository;
import com.sns.user.entity.UserEntity;

@Service
public class UserBO {
	@Autowired
	private UserRepository userRepository;
	
	// input: loginId
	// output: UserEntity(null or 채워져 있거나)
	public UserEntity getuserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	
	//input: user 관련 파라미터들
		//output: UserEntity => id pk 추출
		public Integer addUser(String loginId, String password, String name, String email) {
			// save
			UserEntity userEntity = userRepository.save(
						UserEntity.builder()
						.loginId(loginId)
						.password(password)
						.name(name)
						.email(email)
						.build()
					);
			return userEntity == null ? null : userEntity.getId();	// pk만 return
		}
		
		//input: userId, password
		//output: UserEntity
		public UserEntity getUserEntityByIdPassword(String loginId, String password) {
			return userRepository.findByLoginIdAndPassword(loginId, password);
		}
}
