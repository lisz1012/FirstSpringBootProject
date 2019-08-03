package com.lisz.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisz.springboot.dao.CityDao;
import com.lisz.springboot.domain.City;

@Service
public class CityService {

	@Autowired
	private CityDao cityDao;
	
	public List<City> findAll() {
		List<City> list = cityDao.findAll();
		return list;
	}

	public String add(City city) {
		try {
			cityDao.add(city);
			return "保存成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "保存失败";
		}
	}

	public String add(Integer id, String name) {
		City city = new City(id, name);
		try {
			cityDao.add(city);
			return "保存成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "保存失败";
		}
	}

	public String update(Integer id, String name) {
		City city = new City(id, name);
		try {
			cityDao.update(city);
			return "更新成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "更新失败";
		}
	}

	public String deleteById(Integer id) {
		try {
			cityDao.deleteById(id);
			return "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "删除失败";
		}
	}
}
