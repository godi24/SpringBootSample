package com.godi24.springbootsample.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.godi24.springbootsample.model.TopicModel;

@Service
public class TopicService {
	private List<TopicModel> topicList = new ArrayList<>(Arrays.asList(
			new TopicModel("spring", "Spring", "Spring Description"),
			new TopicModel("java", "Java", "Java Description"),
			new TopicModel("javascript", "JavaScript", "JavaScript Description")
			));
	
	public List<TopicModel> getAllTopics(){
		return topicList;
	}
	
	public TopicModel getTopic(String id) {
		return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(TopicModel topicModel) {
		topicList.add(topicModel);
	}

	public void updateTopic(String id, TopicModel topicModel) {
		for(int i = 0; i < topicList.size(); i++) {
			TopicModel t = topicList.get(i);
			if(t.getId().equals(id)) {
				topicList.set(i, topicModel);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topicList.removeIf(t -> t.getId().equals(id));
	}
}
