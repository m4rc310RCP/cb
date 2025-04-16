package br.com.m4rc310.cb.services.documents;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.m4rc310.cb.db.models.documents.Document;
import br.com.m4rc310.cb.db.models.documents.DocumentId;
import br.com.m4rc310.cb.db.models.documents.DocumentItem;
import br.com.m4rc310.cb.db.models.documents.EDocumentKind;
import br.com.m4rc310.cb.db.models.person.EPersonKind;
import br.com.m4rc310.cb.db.models.person.Person;
import br.com.m4rc310.cb.services.MService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@GraphQLApi
@EnableScheduling
public class DocumentService extends MService{
	
	@Autowired
    private JdbcTemplate jdbc;
	
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
		
		
		Optional<Document> optDocument = documentRepository.findById(id);
		
		
		Document doc = optDocument.orElse(new Document());
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
	
    @Scheduled(cron = "*/59 * * * * *")
	public void onHeartBeat() {
    	jdbc.execute("SELECT 1");
	}
	
	
	@GraphQLMutation(name=MUTATION$register_nfe, description=DESC$mutation_register_nfe)
	public Document sendKeyNfe(
			@GraphQLArgument(name=NUMBER$key_nfe, description=DESC$number_key_nfe)
			String keyNfe) {
		return null;
	}
	
	
	@GraphQLQuery(name=NUMBER$document, description=DESC$number_document)
	public Long getDocumentNumber(@GraphQLContext Document doc) {
		try {
			return doc.getId().getNumber();			
		} catch (Exception e) {
			return null;
		}
	}
	
	@GraphQLQuery(name=KIND$document, description=DESC$kind_document)
	public EDocumentKind getDocumentKind(@GraphQLContext Document doc) {
		try {
			return doc.getId().getKind();			
		} catch (Exception e) {
			return null;
		}
	}

	@GraphQLQuery(name=NUMBER$serie, description=DESC$number_serie)
	public String getDocumentSerie(@GraphQLContext Document doc) {
		try {
			return doc.getId().getSerie();			
		} catch (Exception e) {
			return null;
		}
	}
//	Document
//	curl -X GET "https://nfe.api.nfe.io/v2/productinvoices/41250476260017000573650100002605841844951750" -H  "accept: application/json" -H  "Authorization: PwvyqUgVNiky2P8JWcUM3BX3j0XOmQ2LMJrzyFtWOtjBVv6aym7CTTFG4ZYk4Cmp2X4"
//	curl -X GET "https://nfe.api.nfe.io/v1/consumerinvoices/coupon/41250476260017000573650100002605841844951750" -H  "accept: application/json"  -H  "Authorization: PwvyqUgVNiky2P8JWcUM3BX3j0XOmQ2LMJrzyFtWOtjBVv6aym7CTTFG4ZYk4Cmp2X4"
	
}
