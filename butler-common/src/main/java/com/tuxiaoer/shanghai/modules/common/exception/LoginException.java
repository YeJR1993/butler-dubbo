package com.tuxiaoer.shanghai.modules.common.exception;


import com.tuxiaoer.shanghai.modules.common.utils.CodeMsg;
import lombok.Data;

/**
 * @author: YeJR
 * @version: 2018年6月1日 下午2:47:25
 * 自定义错误异常
 */
@Data
public class LoginException extends RuntimeException {

	private CodeMsg codeMsg;

	public LoginException(CodeMsg codeMsg) {
		super(codeMsg.toString());
		this.codeMsg = codeMsg;
	}

}
