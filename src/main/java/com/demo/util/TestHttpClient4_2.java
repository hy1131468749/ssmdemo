
package com.demo.util;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class TestHttpClient4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testHttpClient();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void testHttpClient() throws UnsupportedEncodingException {
		HttpClient httpClient = HttpConnectionManager.getHttpClient();//连接池获取连接
		HttpPost httpPost = new HttpPost("http://222.190.109.84:21514/zhcg.kzxt.api.open/Event/ReportUmEvent");
//		HttpPost httpPost = new HttpPost("http://www.zhcgdsj.suzhou.gov.cn/szAPIGateway/DataResourceCms/registerEvent.do");
		httpPost.setHeader(new BasicHeader("Content-Type", "application/json; charset=utf-8"));
//		httpPost.setHeader("key", "c5c217acb402429d8f759f6a4ba7456a");
//		httpPost.setHeader("secret", "d21849adfaf346798b85f552c2364a8d");
//		
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		//params.add(new BasicNameValuePair("appid", "2018072300007148"));				//appid	String	是	32	分配应用id	2018072300007148
		params.add(new BasicNameValuePair("C_REG_TIME", ""));				//C_REG_TIME		TIMESTAMP(6)	11	是	立案时间
	    params.add(new BasicNameValuePair("C_END_TIME", ""));				//C_END_TIME		TIMESTAMP(6)	11	是	结案时间
	    params.add(new BasicNameValuePair("C_CODE", ""));						//C_CODE			VARCHAR2		32	是	案件编号
	    params.add(new BasicNameValuePair("C_EVT_SRC", ""));		
		httpPost.setEntity(new UrlEncodedFormEntity(params,"utf-8"));
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("appid", "2018072300007148");
//		jsonObject.put("C_REG_TIME", "");
//		jsonObject.put("C_END_TIME", "");
//		jsonObject.put("C_CODE", "");
	//	httpPost.setEntity(new StringEntity(jsonObject.toJSONString(),"utf-8"));
		HttpResponse response = null;
		Header contentType = httpPost.getEntity().getContentType();
		
		HttpEntity entity = null;
		try {
			response = httpClient.execute(httpPost);
			entity = response.getEntity();
			//在这里可以用Jsoup之类的工具对返回结果进行分析，以判断登录是否成功
			String res = EntityUtils.toString(entity);//返回的值
			System.out.println(res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
