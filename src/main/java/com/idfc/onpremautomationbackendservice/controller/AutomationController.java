package com.idfc.onpremautomationbackendservice.controller;

import com.idfc.onpremautomationbackendservice.model.Node;
import com.idfc.onpremautomationbackendservice.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
