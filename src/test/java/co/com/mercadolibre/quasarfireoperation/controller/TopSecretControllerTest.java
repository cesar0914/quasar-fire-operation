package co.com.mercadolibre.quasarfireoperation.controller;

import co.com.mercadolibre.quasarfireoperation.exception.NotFoundException;
import co.com.mercadolibre.quasarfireoperation.mockdata.MockDataGenerator;
import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;
import co.com.mercadolibre.quasarfireoperation.model.dto.request.TopSecretRequest;
import co.com.mercadolibre.quasarfireoperation.model.dto.response.TopSecretResponse;
import co.com.mercadolibre.quasarfireoperation.service.TopSecretService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static co.com.mercadolibre.quasarfireoperation.utils.TopSecretConstant.NOT_FOUND_POSITION_ERROR;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TopSecretController.class)
public class TopSecretControllerTest {

    @MockBean
    private TopSecretService topSecretService;

    @Autowired
    ObjectMapper objectmapper;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getTopSecret_Successful() throws Exception {
        TopSecretRequest topSecretRequest = MockDataGenerator.generateTopSecretRequestMockData();
        TopSecretResponse topSecretResponse = MockDataGenerator.generateTopSecretResponseMockData();

        given(topSecretService.getTopSecret(anyList())).willReturn(topSecretResponse);

        mockMvc.perform(post("/api/v1/quasar/topsecret")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectmapper.writeValueAsString(topSecretRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(topSecretResponse.getMessage()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        verify(topSecretService, times(1)).getTopSecret(anyList());
        verify(topSecretService).getTopSecret(anyList());
    }

    @Test
    void getTopSecret_NotFound() throws Exception {
        TopSecretRequest topSecretRequest = MockDataGenerator.generateTopSecretRequestMockData();

        given(topSecretService.getTopSecret(anyList())).willThrow(new NotFoundException(NOT_FOUND_POSITION_ERROR));

        mockMvc.perform(post("/api/v1/quasar/topsecret")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectmapper.writeValueAsString(topSecretRequest)))
                .andExpect(status().isNotFound())
                .andReturn();

        verify(topSecretService).getTopSecret(anyList());
    }

    @Test
    public void testUpdateSatelliteData() throws Exception {
        SatelliteDto satelliteRequest = MockDataGenerator.generateSatelliteDtoMockData();

        mockMvc.perform(post("/api/v1/quasar/topsecret_split/kenobi")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectmapper.writeValueAsString(satelliteRequest)))
                .andExpect(status().isOk());

        verify(topSecretService, times(1)).updateSatelliteData(eq("kenobi"), any(SatelliteDto.class));
        verifyNoMoreInteractions(topSecretService);
    }

    @Test
    public void testGetTopSecretSplit() throws Exception {
        TopSecretResponse response = MockDataGenerator.generateTopSecretResponseMockData();

        when(topSecretService.getTopSecretSplit()).thenReturn(response);

        mockMvc.perform(get("/api/v1/quasar/topsecret_split"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(response.getMessage()));
        verify(topSecretService, times(1)).getTopSecretSplit();
        verifyNoMoreInteractions(topSecretService);
    }
}