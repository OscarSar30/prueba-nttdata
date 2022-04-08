package ec.com.servicioentidad.banco.controller.impl;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ec.com.servicioentidad.banco.dto.ClienteDTO;
import ec.com.servicioentidad.banco.repository.IClienteRepository;
import ec.com.servicioentidad.banco.repository.IPersonaRepository;
import ec.com.servicioentidad.banco.repository.entity.ClienteEntity;
import ec.com.servicioentidad.banco.utils.BancoConvert;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerImplTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private IPersonaRepository personaRepository;

	private File clienteJson;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		this.clienteJson = new File("src/test/resources/Cliente.json");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		clienteRepository.deleteAll();
		personaRepository.deleteAll();
		this.clienteJson = null;
		this.mockMvc = null;
	}

	@Test
	void testActualizarCliente() throws JsonProcessingException, Exception {
		ClienteEntity entity = objectMapper.readValue(clienteJson, new TypeReference<List<ClienteEntity>>() {
		}).get(1);
		ClienteDTO dto = BancoConvert.entityToDto(clienteRepository.save(entity));
		dto.setIdentificacion("099999999999");

		this.mockMvc
				.perform(MockMvcRequestBuilders.put("/clientes").content(objectMapper.writeValueAsString(dto))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void testActualizarClienteNotfound() throws Exception {
		ClienteEntity entity = objectMapper.readValue(clienteJson, new TypeReference<List<ClienteEntity>>() {}).get(1);
		ClienteDTO dto = BancoConvert.entityToDto(clienteRepository.save(entity));
		dto.setIdentificacion("099999999999");
		dto.setId(0);
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.put("/clientes")
				.content(objectMapper.writeValueAsString(dto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
	      		.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testConsultarClientePorIdentificacion() throws Exception {
		List<ClienteEntity> entity = objectMapper.readValue(clienteJson, new TypeReference<List<ClienteEntity>>() {
		});
		clienteRepository.saveAll(entity);
		String identificacion = "99999999998";

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/clientes/{identificacion}", identificacion)
						.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void testConsultarClientePorIdentificacionNotFound() throws Exception {
		List<ClienteEntity> entity = objectMapper.readValue(clienteJson, new TypeReference<List<ClienteEntity>>() {
		});
		clienteRepository.saveAll(entity);
		
		String identificacion = "1234";
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.get("/clientes/{identificacion}",identificacion)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testCrearCliente() throws JsonProcessingException, Exception {
		ClienteDTO dto = objectMapper.readValue(clienteJson, new TypeReference<List<ClienteDTO>>() {
		}).get(0);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/clientes").content(objectMapper.writeValueAsString(dto))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void testConsultarClientes() throws JsonProcessingException, Exception {
		List<ClienteEntity> entity = objectMapper.readValue(clienteJson, new TypeReference<List<ClienteEntity>>() {});
		clienteRepository.saveAll(entity);
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.get("/clientes","")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
