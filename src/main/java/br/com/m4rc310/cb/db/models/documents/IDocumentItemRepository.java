package br.com.m4rc310.cb.db.models.documents;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDocumentItemRepository extends JpaRepository<DocumentItem, DocumentItemId> {
	Optional<DocumentItem> findTopByDocumentIdOrderByItemDesc(DocumentId id);
}
