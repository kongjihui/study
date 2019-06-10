package com.example.demo.common;
 
import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * @Title: Result.java 
 * @Package com.aurora.gigabox.util 
 * @Description:   返回结果集
 * @author SSY  
 * @date 2018年7月31日 下午12:06:23 
 * @version V1.0
 */
public class Result<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int STATE_SUCCESS = 200;//成功
	public static final int STATE_ERROR = 500;//服务器错误
	public static final int STATE_FAILED = 403;//用户请求错误
	public static final int STATE_REJECT = 400;  //用户未登录
	/**
	 *  身份证未登记
	 */
	public static final int STATE_FAILED_1=40301;
	/**
	 * 商品库存不足
	 */
	public static final int STATE_FAILED_2=40302;//
	/**
	 * 为空，不存在（如订单,商品,团等等）
	 */
	public static final int STATE_FAILED_3=40303;//
	/**
	 * 用户地址不在配送范围内
	 */
	public static final int STATE_FAILED_4=40304;//
	/**
	 * 返回提示信息;
	 */
	private String msg;
	/**
	 * 响应状态, 
	 */
	private int status = 200; 
	/**
	 * 返回类型;
	 */
	private Integer type; 
	/**
	 * 返回参数
	 */
	private T result;
	/**
	 * 返回参数
	 */
	private List<T> results; 
	/**
	 * 返回参数
	 */
	private Map<String,Object> resultMap; 
	
	/**
	 * 返回参数
	 */
	private Map<String,String> resultStringMap; 
	
	public Map<String, String> getResultStringMap() {
		return resultStringMap;
	}

	public void setResultStringMap(Map<String, String> resultStringMap) {
		this.resultStringMap = resultStringMap;
	}

	public static Result<Object> build(int status,String msg){
		Result<Object> result = new Result<Object>();
		result.setMsg(msg);
		result.setStatus(status);
		return result;
	}
	
	public static Result<Object> buildStringMap(Map<String, String> resultStringMap){
		Result<Object> result = new Result<Object>();
		result.setResultStringMap(resultStringMap);
		return result;
	}
	public static Result<Object> build(Map<String, Object> resultMap){
		Result<Object> result = new Result<Object>();
		result.setResultMap(resultMap);
		return result;
	}
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	/**
	 * 获取: message
	 * @return the message
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 设置: message
	 * @param message the message to set
	 */
	public void setMsg(String message) {
		this.msg = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**获取 type
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/** 设置 type
	 * @param type 
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取: result
	 * @return the result
	 */
	public T getResult() {
		return result;
	}

	/**
	 * 设置: result
	 * @param result the result to set
	 */
	public void setResult(T result) {
		this.result = result;
	}

	/**
	 * 获取: results
	 * @return the results
	 */
	public List<T> getResults() {
		return results;
	}

	/**
	 * 设置: results
	 * @param results the results to set
	 */
	public void setResults(List<T> results) {
		this.results = results;
	}
	
}
