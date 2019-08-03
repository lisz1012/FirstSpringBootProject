package com.lisz.springboot.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lisz.springboot.domain.City;

@Repository
public class CityDao {
	
	/**
	 * 在内存里虚拟出一份数据 List 或者 Map
	 * 还需要保证线程安全,
	 * 下面也可以用ConcurrentHashMap
	 */
	private static Map<Integer, City> dataMap = Collections.synchronizedMap(new HashMap<>());

	public List<City> findAll() {
		return new ArrayList<>(dataMap.values());
	}

	public void add(City city) {
		if (dataMap.containsKey(city.getId())) {
			throw new IllegalArgumentException("City key already exists");
		} else {
			dataMap.put(city.getId(), city);
			System.out.println("City added: " + city);
		}
	}

}
