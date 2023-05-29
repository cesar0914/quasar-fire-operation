package co.com.mercadolibre.quasarfireoperation.controller;

import co.com.mercadolibre.quasarfireoperation.model.dto.request.TopSecretRequest;
import co.com.mercadolibre.quasarfireoperation.service.TopSecretService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.awt.*;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TopSecretController.class)
public class TopSecretControllerTest {

    @MockBean
    private TopSecretService topSecretService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetTopSecret() throws Exception {
        // Datos de prueba
        TopSecretRequest request = new TopSecretRequest();
        request.setSatellites(Collections.emptyList());

        String message = "This is a secret message";
        Point position = new Point(1, 2);

        // Configuración del mock del servicio
        when(topSecretService.getMessage(anyList())).thenReturn(message);
        when(topSecretService.GetLocation(anyList())).thenReturn(position);

        // Construir la solicitud
        RequestBuilder requestBuilder = post("/api/v1/quasar/topsecret")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"satellites\":[{\"name\":\"kenobi\",\"distance\":100,\"message\":[\"este\",\"\",\"\"," +
                        "\"mensaje\",\"\"]},{\"name\":\"skywalker\",\"distance\":115.5,\"message\":[\"\",\"es\",\"\",\"\"," +
                        "\"secreto\"]},{\"name\":\"sato\",\"distance\":142.7,\"message\":[\"este\",\"\",\"un\",\"\",\"\"]}]}");

        // Realizar la solicitud y verificar la respuesta
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message))
                .andExpect(jsonPath("$.position.x").value(position.getX()))
                .andExpect(jsonPath("$.position.y").value(position.getY()));
    }
}