package br.com.m4rc310.cb.db.models.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentRepository extends JpaRepository<Document, DocumentId> {
	
}
