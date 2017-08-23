package com.csy.module.user.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.csy.module.login.controller.LoginAction;
import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.entity.BUserAccountExample;
import com.csy.module.user.service.service.BuserAccountService;
import com.csy.util.ObjectUtils;
import com.csy.util.algorithm.MD5Util;
import com.csy.util.exception.account.EmailNotActivatedException;
import com.csy.util.exception.account.PhoneNotActivatedException;
import com.csy.util.exception.account.UserNotUniqueException;
import com.csy.util.spring.BaseService;

@Service
public class BuserAccountServiceImpl extends BaseService<BUserAccount, BUserAccountExample>
		implements BuserAccountService{

	@Override
	public boolean isAlreayExist(Map<String, Object> map) {
		BUserAccountExample example = new BUserAccountExample();
		Set<String> set = map.keySet();
		for(String key:set){
			if(key != null){
				switch (key.toLowerCase()) {
				case "account":
					example.or().andAccountEqualTo(map.get("account").toString());
					break;
				case "email":
					example.or().andEmailEqualTo(map.get("email").toString());
					break;
				case "phone":
					example.or().andPhoneEqualTo(map.get("phone").toString());
					break;
				default:
					break;
				}
			}
		}
		List<BUserAccount> users = _dao.selectByExample(example);
		return !ObjectUtils.isEmpty(users);
	}

	@Override
	public BUserAccount loginUser(String account,String password) 
			throws UserNotUniqueException, EmailNotActivatedException
			, PhoneNotActivatedException, Exception{
		BUserAccountExample example = new BUserAccountExample();
		example.or().andAccountEqualTo(account);
		example.or().andEmailEqualTo(account);
		example.or().andPhoneEqualTo(account);
		List<BUserAccount> users = _dao.selectByExample(example);
		//帐号不存在
		if(ObjectUtils.isEmpty(users))
			return null;
		//帐号不唯一！（严重问题）
		if(users.size() > 1)
			throw new UserNotUniqueException(account);
		BUserAccount user = users.get(0);
		String md5Password = MD5Util.MD5(user.getPassword() + LoginAction.imageCode);
		//密码不匹配
		if(!md5Password.equals(password)){
			return null;
		}
		//email登录,并且email未激活
		if(account.equals(user.getEmail()) && user.getEmailstatue() != (byte)1){
			throw new EmailNotActivatedException(account);
		}
		//手机登录，并且手机未激活
		if(account.equals(user.getPhone()) && user.getPhonestatue() != (byte)1){
			throw new PhoneNotActivatedException(account);
		}
		return user;
	}
}
