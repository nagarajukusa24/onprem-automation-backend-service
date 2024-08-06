package com.idfc.onpremautomationbackendservice.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;

@org.springframework.data.neo4j.core.schema.Node

@Data
public class Node {

    @Id
    private String ip;
    private String name;
}
