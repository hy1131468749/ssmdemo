package com;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

public class TestChar {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		
		List<NameValuePair> paramsList = new ArrayList<NameValuePair>();

		HttpPost httpPost = new HttpPost("http://222.190.109.84:21514/zhcg.kzxt.api.open/Event/ReportUmEvent");
//		HttpPost httpPost = new HttpPost("http://www.zhcgdsj.suzhou.gov.cn/szAPIGateway/DataResourceCms/registerEvent.do");
		httpPost.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("appid", "2018072300007148"));				//appid	String	是	32	分配应用id	2018072300007148
		params.add(new BasicNameValuePair("C_REG_TIME", ""));				//C_REG_TIME		TIMESTAMP(6)	11	是	立案时间
	    params.add(new BasicNameValuePair("C_END_TIME", ""));				//C_END_TIME		TIMESTAMP(6)	11	是	结案时间
	    params.add(new BasicNameValuePair("C_CODE", ""));						//C_CODE			VARCHAR2		32	是	案件编号
	    params.add(new BasicNameValuePair("C_EVT_SRC", ""));		
		  UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params,"utf-8");
		  httpPost.setEntity(urlEncodedFormEntity);

		
	}
}
