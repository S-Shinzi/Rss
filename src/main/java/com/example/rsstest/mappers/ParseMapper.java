package com.example.rsstest.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.rsstest.domains.Parse;

@Mapper
public interface ParseMapper {
	List<Parse> all();
	void add(Parse parse);
	void remove(Parse parse);
	void update(Parse parse);
	List<Parse> getParses(int id);
}
