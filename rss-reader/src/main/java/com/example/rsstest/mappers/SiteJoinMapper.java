package com.example.rsstest.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.rsstest.domains.SiteJoin;

@Mapper
public interface SiteJoinMapper {
	List<SiteJoin> all();
}
