package com.idfc.onpremautomationbackendservice.controller;

import com.idfc.onpremautomationbackendservice.model.Node;
import com.idfc.onpremautomationbackendservice.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class AutomationController {

    @Autowired
    private AutomationService automationService;

    @GetMapping("/fetch-nodes")
    public List<Node> fetchSourceAndDestinationNodes() {
        return automationService.fetchAllNodes();
    }

    @GetMapping("/fetch-relations")
    public List<Node> fetchNodesWithRelations(@RequestParam String relationType) {
        return automationService.fetchNodesByRelationType(relationType);
    }

    @GetMapping("/fetch-node")
    public List<Node> fetchNodeWithInputIP(@RequestParam String ip) {
        return automationService.fetchNodeWithInputIP(ip);
    }

    @GetMapping("/dummy")
    public Map<String, Object> getGraphData() {

        List<Map<String, Object>> nodes = List.of(
                Map.of("id", 1, "name", "Node 1"),
                Map.of("id", 2, "name", "Node 2"),
                Map.of("id", 3, "name", "Node 3")
        );

        List<Map<String, Object>> links = List.of(
                Map.of("source", 1, "target", 2),
                Map.of("source", 2, "target", 3)
        );

        return Map.of("nodes", nodes, "links", links);
    }
}


