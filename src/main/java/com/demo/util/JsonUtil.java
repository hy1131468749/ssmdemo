package com.demo.util;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtil {

    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapper;

    private static ObjectMapper objectNoNullMapper;
    
    static {
    	objectMapper = new ObjectMapper();
		objectNoNullMapper = new ObjectMapper();

		// 设置FAIL_ON_EMPTY_BEANS属性，当序列化空对象不要抛异常
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		// 设置FAIL_ON_UNKNOWN_PROPERTIES属性，当JSON字符串中存在Java对象没有的属性，忽略
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		// 设置FAIL_ON_IGNORED_PROPERTIES属性，当JSON字符串中存在 @JsonIgnore注解时，忽略
		objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		
		// 设置FAIL_ON_EMPTY_BEANS属性，当序列化空对象不要抛异常
		objectNoNullMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		// 设置FAIL_ON_UNKNOWN_PROPERTIES属性，当JSON字符串中存在Java对象没有的属性，忽略
		objectNoNullMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		// 属性为  NULL 不序列化
		objectNoNullMapper.setSerializationInclusion(Include.NON_NULL);
    }

    /**
     * Convert Object to JsonString
     * 
     * @param jsonObj
     * @return
     */
    public static String jsonObj2Sting(Object jsonObj) {
        String jsonString = null;

        try {
            jsonString = objectMapper.writeValueAsString(jsonObj);
        } catch (IOException e) {
            log.error("pasre json Object[{}] to string failed.", jsonObj);
        }

        return jsonString;
    }

    /**
     * Convert JsonString to Simple Object
     * 
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> T jsonString2SimpleObj(String jsonString, Class<T> cls) {
        T jsonObj = null;

        try {
            jsonObj = objectMapper.readValue(jsonString, cls);
        } catch (IOException e) {
            log.error("pasre json string[{}] to Object failed.", jsonString);
        }

        return jsonObj;
    }
    
    public static ObjectNode simpleObj2jsonObj(Object obj) throws JsonParseException, IOException
	{
		String jsonStr = objectMapper.writeValueAsString(obj);
		
		return jsonString2SimpleObj(jsonStr,ObjectNode.class);
	}
    
    
    
    
    /**
	 * Convert Object to JsonString
	 * 
	 * @param obj
	 * @return
	 */
	public static String obj2Sting(Object obj)
	{
		String jsonString = null;

		try
		{
			jsonString = objectMapper.writeValueAsString(obj);
		} catch (IOException e)
		{
			log.error("pasre json Object[{}] to string failed.", obj);
		}

		return jsonString;
	}
	
	public static String obj2StingNoNull(Object obj) throws JsonProcessingException
	{
		String jsonString = null;

		jsonString = objectNoNullMapper.writeValueAsString(obj);

		return jsonString;
	}

	/**
	 * Convert JsonString to Simple Object
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T string2Obj(String jsonString, Class<T> cls)
	{
		T jsonObj = null;

		try
		{
			jsonObj = objectMapper.readValue(jsonString, cls);
		} catch (IOException e)
		{
			log.error("pasre json string[{}] to Object failed.", jsonString);
		}

		return jsonObj;
	}

	/**
	 * Convert Json Object to Simple Object
	 * 
	 * @param jsonObj
	 * @param cls
	 * @return
	 */
	public static <T> T jsonObj2SimpleObj(Object jsonObj, Class<T> cls)
	{
		T simpleObj = objectMapper.convertValue(jsonObj, cls);

		return simpleObj;
	}

	
	public static ObjectNode string2JsonObj(String jsonString) throws JsonParseException, IOException
	{
		JsonFactory factory = objectMapper.getFactory(); // since 2.1 use mapper.getFactory() instead
		JsonParser jp = factory.createParser(jsonString);
		JsonNode jsonObj = objectMapper.readTree(jp);
		
		return (ObjectNode) jsonObj;
	}
	
	public static ObjectMapper getObjectMapper()
	{
		return objectMapper;
	}

	public static void setObjectMapper(ObjectMapper objectMapper)
	{
		JsonUtil.objectMapper = objectMapper;
	}
   
}
