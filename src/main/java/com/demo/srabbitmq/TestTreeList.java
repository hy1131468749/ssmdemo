package com.demo.srabbitmq;

import java.util.SortedSet;
import java.util.TreeSet;

public class TestTreeList {
	public static void main(String[] args) {
		
		SortedSet<Long> list = new TreeSet<>();
		list.add(1L);
		list.add(2L);
		list.add(3L);
		list.add(4L);
		list.add(5L);
		list.add(6L);
		list.headSet(3L).clear();;
	
		System.out.println(list);
		
	}
}
