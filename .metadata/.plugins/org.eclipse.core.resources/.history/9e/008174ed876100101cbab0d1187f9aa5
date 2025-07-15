package com.lucasleao.clienteservice.controller;

import com.lucasleao.clienteservice.model.Cliente;
import com.lucasleao.clienteservice.repository.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    @DisplayName("GET /clientes - Deve retornar lista de clientes")
    public void testGetAllClientes() throws Exception {
        Cliente c1 = new Cliente(1L, "Lucas", "lucas@email.com");
        Cliente c2 = new Cliente(2L, "Ana", "ana@email.com");

        Mockito.when(clienteRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nome", is("Lucas")))
                .andExpect(jsonPath("$[1].email", is("ana@email.com")));
    }

    @Test
    @DisplayName("GET /clientes/{id} - Deve retornar cliente por id")
    public void testGetClienteById() throws Exception {
        Cliente cliente = new Cliente(1L, "Lucas", "lucas@email.com");

        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        mockMvc.perform(get("/clientes/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("Lucas")))
                .andExpect(jsonPath("$.email", is("lucas@email.com")));
    }

    @Test
    @DisplayName("GET /clientes/{id} - Quando cliente não existe, retorna 404")
    public void testGetClienteById_NotFound() throws Exception {
        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/clientes/{id}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /clientes - Cria um novo cliente")
    public void testCreateCliente() throws Exception {
        Cliente cliente = new Cliente(null, "Lucas", "lucas@email.com");
        Cliente clienteSalvo = new Cliente(1L, "Lucas", "lucas@email.com");

        Mockito.when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteSalvo);

        String json = """
            {
                "nome": "Lucas",
                "email": "lucas@email.com"
            }
            """;

        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Lucas")))
                .andExpect(jsonPath("$.email", is("lucas@email.com")));
    }

    @Test
    @DisplayName("PUT /clientes/{id} - Atualiza cliente existente")
    public void testUpdateCliente() throws Exception {
        Cliente clienteExistente = new Cliente(1L, "Lucas", "lucas@email.com");
        Cliente clienteAtualizado = new Cliente(1L, "Lucas Silva", "lucas.silva@email.com");

        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteExistente));
        Mockito.when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteAtualizado);

        String json = """
            {
                "nome": "Lucas Silva",
                "email": "lucas.silva@email.com"
            }
            """;

        mockMvc.perform(put("/clientes/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("Lucas Silva")))
                .andExpect(jsonPath("$.email", is("lucas.silva@email.com")));
    }

    @Test
    @DisplayName("PUT /clientes/{id} - Quando cliente não existe, retorna 404")
    public void testUpdateCliente_NotFound() throws Exception {
        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        String json = """
            {
                "nome": "Lucas Silva",
                "email": "lucas.silva@email.com"
            }
            """;

        mockMvc.perform(put("/clientes/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /clientes/{id} - Deleta cliente existente")
    public void testDeleteCliente() throws Exception {
        Mockito.when(clienteRepository.existsById(1L)).thenReturn(true);

        mockMvc.perform(delete("/clientes/{id}", 1L))
                .andExpect(status().isNoContent());

        Mockito.verify(clienteRepository).deleteById(1L);
    }

    @Test
    @DisplayName("DELETE /clientes/{id} - Quando cliente não existe, retorna 404")
    public void testDeleteCliente_NotFound() throws Exception {
        Mockito.when(clienteRepository.existsById(1L)).thenReturn(false);

        mockMvc.perform(delete("/clientes/{id}", 1L))
                .andExpect(status().isNotFound());
    }
}
