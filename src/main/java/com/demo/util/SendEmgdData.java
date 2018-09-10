package com.demo.util;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.demo.httpclient.HttpHandler;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SendEmgdData {

	public static void main(String[] args) throws Exception, IOException {
			
		
			String [] sns = new String[] {"115001", "115002", "115003", "115004", "115006", "115007"};
			for(int i=0;i<6;i++) {
				SendThread st = new SendThread(sns[i]);
				st.start();
			}
				
	
			
			
		}

	public static Map<String, Object> getdata(String SN) {

		DecimalFormat fnum = new DecimalFormat("##0.00");
		float fdata0 = 20 + (new Random().nextInt(10) - 5) * new Random().nextFloat();
		String data0 = fnum.format(fdata0);
		float fdata1 = 65 + (new Random().nextInt(10) - 5) * new Random().nextFloat();
		float fdata2 = 20 + (new Random().nextInt(10) - 5) * new Random().nextFloat();
		float fdata3 = 30 + (new Random().nextInt(10) - 5) * new Random().nextFloat();
		String data1 = fnum.format(fdata1);
		String data2 = fnum.format(fdata2);
		String data3 = fnum.format(fdata3);

		float fdata4 = 40 + (new Random().nextInt(10) - 5) * new Random().nextFloat();
		float fdata5 = 45 + (new Random().nextInt(10) - 5) * new Random().nextFloat();
		float fdata6 = 55 + (new Random().nextInt(10) - 5) * new Random().nextFloat();
		String data4 = fnum.format(fdata1);
		String data5 = fnum.format(fdata2);
		String data6 = fnum.format(fdata3);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CMD", "UBD");
		map.put("SN", SN);
		map.put("TIME", System.currentTimeMillis());
		map.put("FLOW", System.currentTimeMillis());
		map.put("STATUS", 1);

		Map<String, String> DATAS = new HashMap<String, String>();
		DATAS.put("data0", data0);
		DATAS.put("data1", data1);
		DATAS.put("data2", data2);
		DATAS.put("data3", data3);

		DATAS.put("data4", data4);
		DATAS.put("data5", data5);
		DATAS.put("data6", data6);
		DATAS.put("data7", "0.00");
		DATAS.put("data8", "0.00");
		DATAS.put("data9", "0.00");
		DATAS.put("data10", "0.00");
		DATAS.put("data11", "0.00");
		DATAS.put("data12", "0.00");
		DATAS.put("data13", "0.00");
		DATAS.put("data14", "0.00");
		DATAS.put("data15", "0.00");

		map.put("DATAS", DATAS);
		return map;
	}

}

class SendThread extends Thread {

	public SendThread(String sN) {
		super();
		SN = sN;
	}

	private String SN;

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 1000000; i++) {
				
				TimeUnit.MILLISECONDS.sleep(500);
				
				HttpHandler h = new HttpHandler();
                
				h.doPostJsonForString("http://localhost:8380/EMGD/devNotify/updateDeviceData", null,
						JsonUtil.jsonObj2Sting(SendEmgdData.getdata(SN)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
