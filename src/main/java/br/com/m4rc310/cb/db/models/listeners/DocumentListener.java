package br.com.m4rc310.cb.db.models.listeners;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import br.com.m4rc310.cb.db.models.documents.Document;
import br.com.m4rc310.cb.db.models.documents.IDocumentRepository;
import jakarta.persistence.PrePersist;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocumentListener {

	@Autowired
	private ApplicationContext context;

	@PrePersist
	public void prePersist(Document entity) {
		IDocumentRepository repo = getBean(IDocumentRepository.class);
		Optional<Document> optional = repo.findTopByOrderByNumberControlDesc();
		Long numberControl = optional.isEmpty()? 1L : optional.get().getNumberControl() + 1;
		entity.setNumberControl(numberControl);
	}

	public <T> T getBean(Class<T> beanClass) {
		return context.getBean(beanClass);
	}
	
	
}
