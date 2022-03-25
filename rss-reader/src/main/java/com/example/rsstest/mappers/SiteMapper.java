package com.example.rsstest.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.rsstest.domains.Site;

@Mapper
public interface SiteMapper {
	List<Site> all();
}
