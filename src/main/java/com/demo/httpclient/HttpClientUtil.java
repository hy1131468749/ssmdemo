package com.demo.httpclient;

import java.util.Map;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientUtil {
	private static PoolingHttpClientConnectionManager cm = null;
	private static CloseableHttpClient httpClient = null;
	static {
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
				// .register("https", sslsf)
				.register("http", PlainConnectionSocketFactory.INSTANCE).build();
		cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		cm.setMaxTotal(200);
		cm.setDefaultMaxPerRoute(20);
		cm.setValidateAfterInactivity(1000);
		RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000)
				.setConnectionRequestTimeout(20000).build();
		httpClient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(defaultRequestConfig)
				.build();
	}


	public static CloseableHttpClient getHttpClient() {
		// httpClient不能被关闭 ，如果关闭 连接池也会被关闭，就会抛出连接池关闭异常
		// httpClient只有生成一个实例对接就可以了，因为他执行请求方法时，会去从连接池去连接
		// 源码：final ConnectionRequest connRequest =
		// connManager.requestConnection(route, null);
		return httpClient;


	}
	
	
}
