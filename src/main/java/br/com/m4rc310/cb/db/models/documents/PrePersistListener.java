package br.com.m4rc310.cb.db.models.documents;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import jakarta.persistence.PrePersist;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrePersistListener {

	@Autowired
	private ApplicationContext context;


	@PrePersist
	public void prePersist(DocumentItem entity) {
		if (entity.getItem() == null) {
			
			IDocumentItemRepository repo = getBean(IDocumentItemRepository.class);
			
			DocumentId docId = entity.getDocument().getId();
			Optional<DocumentItem> opDocItem = repo.findTopByDocumentIdOrderByItemDesc(docId);
			Integer item = opDocItem.isEmpty() ? 1 : opDocItem.get().getItem() + 1;
			entity.setItem(item);
		}
	}

	public <T> T getBean(Class<T> beanClass) {
		return context.getBean(beanClass);
	}
}
