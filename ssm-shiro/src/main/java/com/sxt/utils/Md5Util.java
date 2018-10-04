package com.sxt.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Util {

	/**
	 * 获取Md5加密密码
	 * @param source 原密码
	 * @param salt 盐
	 * @param hashIterations 散列次数
	 * @return
	 */
	public static String getEncryptedPassword(Object source, Object salt, int hashIterations) {
		return new Md5Hash(source, salt, hashIterations).toString();
	}
}
