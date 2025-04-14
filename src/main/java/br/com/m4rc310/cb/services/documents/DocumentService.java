package br.com.m4rc310.cb.services.documents;

import org.springframework.stereotype.Service;

import br.com.m4rc310.cb.db.models.documents.Document;
import br.com.m4rc310.cb.db.models.documents.DocumentId;
import br.com.m4rc310.cb.db.models.documents.DocumentItem;
import br.com.m4rc310.cb.db.models.documents.EDocumentKind;
import br.com.m4rc310.cb.db.models.person.EPersonKind;
import br.com.m4rc310.cb.db.models.person.Person;
import br.com.m4rc310.cb.services.MService;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@GraphQLApi
public class DocumentService extends MService{
	
	@GraphQLMutation
	public Person storeCompany(Person company) {
		return personRepository.saveAndFlush(company);
	}
	
	@GraphQLMutation
	public Document storeDocument() {
		
		Person company = new Person();
		company.setCpfcnpj("03057532900");
		company.setKind(EPersonKind.PF);
		
		company = personRepository.save(company);
		
		DocumentId id = new DocumentId();
		id.setCompany(company);
		id.setKind(EDocumentKind.FISCAL_RECEIPT);
		id.setNumber(1L);
		id.setSerie("A1");
		
		Document doc = new Document();
		doc.setId(id);
		doc = documentRepository.save(doc);
		
		
		DocumentItem item = new DocumentItem();
		item.setDocument(doc);
		item = documentItemRepository.save(item);
		
		item = new DocumentItem();
		item.setDocument(doc);
		item = documentItemRepository.save(item);
		
		
		
		return doc;
	}
	
//	@PrePersist
//	public void prePersist(DocumentItem entity) {
//		log.info("> {}", documentItemRepository);
//	}
	
	
}
