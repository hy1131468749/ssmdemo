package com;

import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.bean.Student;
import com.demo.dao.StudentMapper;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/applicationContext-dao.xml" }) // 加载配置文件
public class TestDao {

	@Autowired
	private StudentMapper studentMapper;

	@Test
	public void test1() {

		String name1 = "啊伤筋动骨撒谎的噶啥孤岛惊魂尴尬十多个哈德是看得见啊哈大声道奥斯卡大家好大家好的阿达坚实的阿打算接电话大家安顺达阿达科技收到货阿达科技大号"
				+ "阿萨德开始的大家卡号的爱上大健康收到货撒旦教阿达坚实的哈三等奖熬枯受淡爱神的箭阿可视电话啊大家都会";

		char[] charArray = name1.toCharArray();
		String name2 = "";
		for (int i = 0; i < charArray.length; i++) {
			name2 += charArray[i] + ",";
		}
		// 118
		final String[] names = name2.split(",");
        final String[] sexs = {"男","女"};
		for (int i = 0; i < 10; i++) {

			new Thread() {
				public void run() {
					System.out.println(Thread.currentThread().getName()+":开始");
					Student bean = null;
					Random random = new Random();
					for (int j = 0; j < 100000000; j++) {
						bean = new Student();
						bean.setAge((short)random.nextInt(100));
						bean.setCid(random.nextInt(1000)+""+random.nextInt(1000)+""+random.nextInt(1000)+""+random.nextInt(1000)+""+random.nextInt(1000)+""+random.nextInt(1000));
						bean.setName(names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]); 
						bean.setCreateTime(new Date());
						bean.setModifyTime(new Date());
						bean.setRemark(names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]);
					    bean.setScore(random.nextInt(1000));
					    bean.setNumber(random.nextLong());
					    bean.setSex(sexs[j%2]);
					    bean.setTeacherName(names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]);
					    bean.setcName(names[random.nextInt(118)]+names[random.nextInt(118)]+names[random.nextInt(118)]);  
					    studentMapper.insert(bean);
					}
				};

			}.start();

		}
        while(true);
	}

}
