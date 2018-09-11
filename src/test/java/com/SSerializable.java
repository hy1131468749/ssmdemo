package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.demo.bean.Teacher;
import com.demo.bean.Teacher2;

public class SSerializable {
	public static void main(String[] args) throws Exception{
		
		/*Teacher t = new Teacher();
		t.setSex("男");
		t.setName("李一");
		t.setAge("18");
		
		 ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
	                new File("E:/Teacher.txt")));
	        oo.writeObject(t);
	        System.out.println("Person对象序列化成功！");
		*/
		FileInputStream underlyingStream = new FileInputStream( "E:/Teacher.txt" );
		//用刚才的文件流，创建一个对象序列化输入流
		ObjectInputStream deserializer = new ObjectInputStream(underlyingStream);
		//使用该流的输入函数，将文件中保存的对象读取到内存中，并创建相应对象。
		Teacher2 deserializedObject = (Teacher2)deserializer.readObject();
		System.out.println( deserializedObject.toString());
	}
}
