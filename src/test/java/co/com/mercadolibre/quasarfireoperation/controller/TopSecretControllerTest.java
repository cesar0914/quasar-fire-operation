package co.com.mercadolibre.quasarfireoperation.controller;

import co.com.mercadolibre.quasarfireoperation.service.TopSecretService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TopSecretController.class)
public class TopSecretControllerTest {

    @MockBean
    private TopSecretService topSecretService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetTopSecret() throws Exception {

    }
}