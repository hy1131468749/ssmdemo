package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestSendData {
	
	public static void main(String[] args) {
		 List<String> list = Arrays.asList("java", "scala", "python", "shell", "ruby");
		 Stream<String> parallelStream = list.parallelStream();
		 parallelStream.count();
	}

}
