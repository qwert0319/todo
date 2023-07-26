package org.edupoll.service;

import java.util.List;

import org.edupoll.model.Quest;
import org.edupoll.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestService {

	@Autowired
	QuestRepository questRepository;
	
	
	public List<Quest> getThisWeekQuest() {
		List<Quest> quests = questRepository.findAll();
		
		return quests;
	}
	
}
