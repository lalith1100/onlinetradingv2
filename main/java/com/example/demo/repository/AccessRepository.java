package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Access;

@Repository
public interface AccessRepository extends JpaRepository<Access, Long> {
	
    @Query("SELECT a FROM Access a WHERE a.assetId = :assetId")
    Access findByAssetId(Long assetId);
}
