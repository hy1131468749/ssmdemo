
package com.demo.util;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;


/**
 *   
 * @author 
 * httpClient4.2.X连接池
 */
public class HttpConnectionManager {
	
	
	private static SchemeRegistry schemeRegistry = null;
	private static PoolingClientConnectionManager cm = null;	
    private static DefaultHttpClient httpClient = null;
    private static final int RETRY_TIME = 3;//重试次数
	private static final int REQUEST_TIMEOUT = 30 * 1000;//设置请求超时10秒钟   
	private static final int SO_TIMEOUT = 50 * 1000;//设置等待数据超时时间10秒钟   
	private static final int CONN_MANAGER_TIMEOUT = 10 * 1000;//该值就是连接不够用的时候等待超时时间，一定要设置，而且不能太大 
	private static final int MAX_TOTAL = 50;//连接池最大连接数
	private static final int DEFAULT_MAX_PER_ROUTE = 5;//没个路由的默认最大连接数
	
	static {
		//连接池相关配置
		//设置访问协议
		schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
		
		cm = new PoolingClientConnectionManager(schemeRegistry);
		cm.setMaxTotal(MAX_TOTAL); // 连接池里的最大连接数
		cm.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE); // 每个路由的默认最大连接数
//		HttpHost localhost = new HttpHost("locahost", 80); // 可以针对某特定网站指定最大连接数
//		cm.setMaxPerRoute(new HttpRoute(localhost), 30);
		
		// 其它设置
		HttpParams params = new BasicHttpParams(); 
		//设置连接超时时间   
	    params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, REQUEST_TIMEOUT);//设置请求超时10秒钟    
	    params.setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);//设置等待数据超时时间10秒钟    
	    params.setParameter(ClientPNames.CONN_MANAGER_TIMEOUT, 100L);//该值就是连接不够用的时候等待超时时间，一定要设置，而且不能太大 ()
	    params.setParameter(CoreConnectionPNames.TCP_NODELAY, false);//是否启动noDelay策略
	    params.setParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, 1024 * 1024);//socket缓冲区大小，单位KB,默认8kb
	    params.setBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true);//在提交请求之前 测试连接是否可用
	    //另外设置http client的重试次数，默认是3次；
//	    httpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(RETRY_TIME, true));
	    //设置组件参数, HTTP协议的版本,1.1/1.0/0.9   
	    HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);   
	    HttpProtocolParams.setUserAgent(params, "HttpComponents/1.1");   
	    HttpProtocolParams.setUseExpectContinue(params, true);      
		
		httpClient = new DefaultHttpClient(cm, params);
	}
	
	
	public static HttpClient getHttpClient() {
	
		return httpClient;
	}
	
}

/**
 * 相关参数说明
 * 
 * params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, REQUEST_TIMEOUT);    
 * params.setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);  
 * 		socket等待时间是指从站点下载页面和数据时，两个数据包之间的最大时间间隔，超过这个时间间隔，httpClient就认为连接出了故障。
 * 		连接最大等待时间则是指和站点建立连接时的最大等待时间，超过这个时间站点不给回应，则认为站点无法连接。
 * 
 * params.setParameter(ClientPNames.CONN_MANAGER_TIMEOUT, CONN_MANAGER_TIMEOUT);
 * 		该值就是连接不够用的时候等待超时时间，一定要设置，而且不能太大 ()
 * 
 * params.setParameter(CoreConnectionPNames.TCP_NODELAY, false);
 * 		如果启用了NoDelay策略，httpClient和站点之间传输数据时将会尽可能及时地将发送缓冲区中的数据发送出去、而不考虑网络带宽的利用率，
 * 		这个策略适合对实时性要求高的场景。而禁用了这个策略之后，数据传输会采用Nagle's algorithm发送数据，该算法会充分顾及带宽的利用率，
 * 		而不是数据传输的实时性。
 * 
 * params.setParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, 1024 * 1024);
 * 		设置socket缓冲区的大小（单位为字节），默认是8KB。
 * 
 * params.setBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true);
 * 		在提交请求之前 测试连接是否可用
 */
