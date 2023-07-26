package org.edupoll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.edupoll.model.Quest;

@Mapper
public interface QuestMapper {
	@Select("SELECT * FROM QUESTS")
	public List<Quest> findAll();
}
