package com.tuxiaoer.shanghai.modules.common.exception;


import com.tuxiaoer.shanghai.modules.common.utils.CodeMsg;
import lombok.Data;

/**
 * @author YeJR
 * @version: 2018年5月28日 上午10:07:51
 * 自定义全局异常
 *
 */
@Data
public class GlobalException extends RuntimeException{

	private CodeMsg codeMsg;
	
	public GlobalException(CodeMsg codeMsg) {
		super(codeMsg.toString());
		this.codeMsg = codeMsg;
	}

}
