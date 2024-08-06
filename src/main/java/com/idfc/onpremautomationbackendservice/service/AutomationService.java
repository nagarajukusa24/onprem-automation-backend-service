package com.idfc.onpremautomationbackendservice.service;

import com.idfc.onpremautomationbackendservice.model.Node;
import com.idfc.onpremautomationbackendservice.repository.AutomationRepository;
import org.neo4j.driver.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomationService {

    @Autowired
    private AutomationRepository automationRepository;

    public List<Node> fetchAllNodes() {
        return automationRepository.findAll();
    }

    public List<Node> fetchNodesByRelationType(String relationType) {
        return automationRepository.findNodesByRelationType(relationType);
    }
}
