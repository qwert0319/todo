package org.edupoll.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.edupoll.model.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class QuestRepository {
	@Autowired
	SqlSession sqlSession;

	public List<Quest> findAll() {
		return sqlSession.selectList("quests.findAll");
	}

	public int update(Quest quest) {
		return sqlSession.update("quests.update", quest);
	}

	public Quest findById(int id) {
		return sqlSession.selectOne("quests.findById", id);
	}
}
