package com.demo.common;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

public class ResultStatus {

	// {
	// "statusCode":"200",
	// "message":"操作成功",
	// "navTabId":"",
	// "rel":"",
	// "callbackType":"closeCurrent",
	// "forwardUrl":""
	// }

	private String statucCode = "";
	private String message = "";
	private String navTabId = "";
	private String rel = "";
	private String callbackType = "";
	private String forwardUrl = "";

	public static String output(String statucCode, String message, String navTabId, String rel, String callbackType, String forwardUr) {
		StringBuffer buff = new StringBuffer();
		buff.append("{");
		buff.append("statusCode:").append(statucCode);
		buff.append("message:").append(message);
		buff.append("navTabId:").append(navTabId);
		buff.append("rel:").append(rel);
		buff.append("callbackType:").append(callbackType);
		buff.append("forwardUrl:").append(forwardUr);
		buff.append("}");
		return buff.toString();
	}

	public static String output(String statucCode, String message, String callbackType) {
		StringBuffer buff = new StringBuffer();
		buff.append("{");
		buff.append("statusCode:").append(statucCode);
		buff.append("message:").append(message);
		buff.append("navTabId:").append("");
		buff.append("rel:").append("");
		buff.append("callbackType:").append(callbackType);
		buff.append("forwardUrl:").append("");
		buff.append("}");
		return buff.toString();
	}

	public static String output(String statucCode, String message, String callbackType, String forwardUr) {
		StringBuffer buff = new StringBuffer();
		buff.append("{");
		buff.append("statusCode:").append(statucCode);
		buff.append("message:").append(message);
		buff.append("navTabId:").append("");
		buff.append("rel:").append("");
		buff.append("callbackType:").append(callbackType);
		buff.append("forwardUrl:").append(forwardUr);
		buff.append("}");
		return buff.toString();
	}

}
