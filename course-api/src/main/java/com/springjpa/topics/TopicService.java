package com.springjpa.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

@Autowired	
private TopicRepositary topicRepositary;
	
	/*
	 * List<Topics> topics=new ArrayList<>(Arrays.asList( new
	 * Topics("1","Rohit","HR"), new Topics("2","Shekhar","HR"), new
	 * Topics("3","Ramesh","HR") ));
	 */

public List<Topics> getAllTopics()
{
//return topics;	
	List<Topics> topics=new ArrayList<>();
	topicRepositary.findAll().forEach(topics::add);
	return topics;
}

public Topics getTopic(String id)
{
//	return topics.stream().filter(t -> t.getEmpid().equals(id)).findFirst().get();
	return topicRepositary.findById(id).orElse(null);
}

public void addTopic(Topics topic) {
	topicRepositary.save(topic);
	
}

public void updateTopic(String id, Topics topic) {

	topicRepositary.save(topic);	
}

public void deleteTopic(String id) {
	
	topicRepositary.deleteById(id);
}


}
