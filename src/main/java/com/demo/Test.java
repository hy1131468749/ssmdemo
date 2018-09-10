package com.demo;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hamcrest.core.IsInstanceOf;

import com.demo.util.JsonUtil;

public class Test {
	public static void main(String[] args) {
		
		String json =  "{\"notifyType\":\"deviceDataChanged\",\"deviceId\":\"96406b41-b392-4884-bfbe-281a333f3527\",\"gatewayId\":\"96406b41-b392-4884-bfbe-281a333f3527\",\"requestId\":\"deviceDataChanged\",\"service\":{\"serviceId\":\"GCData\",\"serviceType\":\"RawData\",\"data\":{\"rawData\":{\"CMD\":\"UBD\",\"SN\":\"111000\",\"FLOW\":\"a2c62cd5-0963-4750-896f-5fefbfa5d5e4\",\"TIME\":\"0\",\"STATUS\":1,\"DATAS\":{\"data0\":10.60,\"data1\":13.74,\"data2\":21.15,\"data3\":34.23,\"data4\":100.00,\"data5\":13.00,\"data6\":12.00,\"data7\":15.00,\"data8\":20.00,\"data9\":3.00,\"data10\":12.00,\"data11\":13.00,\"data12\":14.00,\"data13\":14.00,\"data14\":13.00,\"data15\":15.00}}},\"eventTime\":\"20170413T113500Z\"}}"; 
		 
		 Map<String,Object> map = JsonUtil.jsonString2SimpleObj(json, Map.class);
		 Map<String,Object> service = (Map<String, Object>) map.get("service");
		 service.put("data", value)
		 System.out.println(map);
		
	}
}
