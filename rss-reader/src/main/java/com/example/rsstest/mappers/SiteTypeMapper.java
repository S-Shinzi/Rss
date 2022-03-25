package com.example.rsstest.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.rsstest.domains.SiteType;

@Mapper
public interface SiteTypeMapper {
	List<SiteType> all();
}
