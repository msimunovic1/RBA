package com.msimunovic.RBA.repository;

import com.msimunovic.RBA.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DocumentRepository extends JpaRepository<Document, BigInteger> {
}
