package br.com.m4rc310.cb.services.general;

import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import br.com.m4rc310.cb.services.MService;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class GeneralService extends MService{
	
	@GraphQLQuery(name=NUMBER$version, description=DESC$number_version)
	public String getVersion() {
		try {
			Resource resource = new ClassPathResource("META-INF/MANIFEST.MF");
			InputStream inputStream = resource.getInputStream();
			Manifest manifest = new Manifest(inputStream);
			Attributes attributes = manifest.getMainAttributes();
			return attributes.getValue("Implementation-Version");
		} catch (Exception e) {
			return "unknown";
		}
	}
}
