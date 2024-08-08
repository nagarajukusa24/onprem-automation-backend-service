package com.idfc.onpremautomationbackendservice.repository;

import com.idfc.onpremautomationbackendservice.model.Node;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomationRepository extends Neo4jRepository<Node, String> {

    @Query("MATCH (n)-[r]->(m) WHERE type(r) = $relationType RETURN DISTINCT n")
    List<Node> findNodesByRelationType(@Param("relationType") String relationType);

    @Query("MATCH (ip:Node{ip: $ip}) RETURN ip")
    List<Node> fetchNodeByInputIP(String ip);
}
