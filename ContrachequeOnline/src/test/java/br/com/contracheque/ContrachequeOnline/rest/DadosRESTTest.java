
package br.com.contracheque.ContrachequeOnline.rest;


import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// PARA EXECUÇÃO DESTES TESTES É PRECISO INCIAR O SERVIDOR COM O DEPOLY DA APLICAÇÃO
//

public class DadosRESTTest {

		private static final String BASIC_CREDENTIALS = "Basic " + Base64.encodeBase64String("test:secret".getBytes());
	
		private CloseableHttpClient client;
	
		private ObjectMapper mapper;
	
		private String url;
	
		@Before
		public void before() throws Exception {
			client = HttpClientBuilder.create().build();
			mapper = new ObjectMapper();
	
			Configuration config = new PropertiesConfiguration("test.properties");
			url = config.getString("services.url");
		}
	
		@After
		public void after() throws Exception {
			client.close();
		}
		
		//TODO gerar testes 
		
		@Test
		public void findSuccessful() throws ClientProtocolException, IOException {
				assertTrue(true);
		}
	
		@Test
		public void loadSuccessful() throws Exception {
			 assertTrue(true);
		}
	
		@Test
		public void loadFailed() throws ClientProtocolException, IOException {
			assertTrue(true);			
		}
	
		@Test
		public void deleteSuccessful() throws Exception {
			assertTrue(true);
		}
	
		@Test
		public void deleteFailed() throws Exception {
			assertTrue(true);
		}
	
		@Test
		public void insertSuccessful() throws Exception {
			assertTrue(true);
		}
	
		@Test
		public void insertFailed() throws Exception {
			assertTrue(true);
		}
	
		@Test
		public void updateSuccessful() throws Exception {
			assertTrue(true);
		}
	
		@Test
		public void updateFailed() throws Exception {
			assertTrue(true);
		}
		
}