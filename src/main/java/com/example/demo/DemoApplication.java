package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//@SpringBootApplication
public class DemoApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}

	public static void main(String[] args) {

		String[] nameArray = {"kalinga","sachithra","kumara", "yapa"};
		String[] nameArray2 = {"kumara", "yapa","samsom", "simba"};

		List<String> list1 = Arrays.asList(nameArray); // return fixed size list
		List<String> list2 = Arrays.asList(nameArray2);
		List<String> mergedList = new ArrayList<>();

		// get common elements to the list
		List<String> list3 = list1.stream().filter(list2::contains).
				collect(Collectors.toList());

		// sort a List
		Collections.sort(list1);

		// merge two list
		mergedList.addAll(list1);
		mergedList.addAll(list2);


		mergedList.forEach(System.out::println);



	}

}
