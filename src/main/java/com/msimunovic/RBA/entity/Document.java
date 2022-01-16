package com.msimunovic.RBA.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import java.math.BigInteger;

@Data
@Entity
public class Document {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documentSeq")
  @SequenceGenerator(name = "documentSeq", sequenceName = "document_seq", allocationSize = 1)
  private BigInteger id;

  private String name;

  @Lob
  private byte[] content;
}
