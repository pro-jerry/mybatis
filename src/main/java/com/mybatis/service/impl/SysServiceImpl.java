package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.SysuserMapper;
import com.mybatis.domain.ActiveUser;
import com.mybatis.domain.SysUserExample;
import com.mybatis.exception.CustomException;
import com.mybatis.pojo.Sysuser;
import com.mybatis.service.SysService;
import com.mybatis.utils.MD5;

@Service
public class SysServiceImpl implements SysService{

	@Autowired
	private SysuserMapper sysuserMapper;
	
	@Override
	public ActiveUser authenticat(String usercode, String password)
			throws Exception {
		
		Sysuser sysuser = this.findSysUserByUserCode(usercode);
		if(sysuser==null){
			throw new CustomException("用户账户不存在！");
		}
		//数据库密码 (md5密码 )
		String password_db = sysuser.getPassword();
		String password_input_md5 = new MD5().getMD5ofStr(password);
		if(!password_input_md5.equalsIgnoreCase(password_db)){
			
			throw new CustomException("用户名或密码错误！");
		}
		
		//认证通过，返回用户身份信息
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(sysuser.getId());
		activeUser.setUsercode(usercode);
		activeUser.setUsername(sysuser.getUsername());//用户名称
		
		return activeUser;
	}

	public Sysuser findSysUserByUserCode(String usercode) {
		
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);
		
		List<Sysuser> list = sysuserMapper.selectByExample(sysUserExample);
		
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		
		return null;
	}

}
