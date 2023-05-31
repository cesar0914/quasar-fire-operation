package co.com.mercadolibre.quasarfireoperation.service.impl;

import co.com.mercadolibre.quasarfireoperation.exception.NotFoundException;
import co.com.mercadolibre.quasarfireoperation.mockdata.MockDataGenerator;
import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;
import co.com.mercadolibre.quasarfireoperation.model.dto.request.TopSecretRequest;
import co.com.mercadolibre.quasarfireoperation.model.dto.response.TopSecretResponse;
import co.com.mercadolibre.quasarfireoperation.model.entity.Satellite;
import co.com.mercadolibre.quasarfireoperation.repository.SatelliteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TopSecretServiceImplTest {

    @Mock
    private SatelliteRepository satelliteRepository;

    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private TopSecretServiceImpl topSecretService;

    @Test
    @DisplayName("NotFoundException distancias incompletas")
    public void testGetLocationThrowsNotFoundException() {
        double[] distances = {100.0, 115.5};
        assertThrows(NotFoundException.class, () -> topSecretService.getLocation(distances));
    }

    @Test
    @DisplayName("Obtiene la posición")
    public void testGetLocation() {
        double[] distances = {100.0, 115.5, 142.7};

        Point location = topSecretService.getLocation(distances);

        assertNotNull(location);
        assertEquals(487.0, location.getX());
        assertEquals(1557.0, location.getY());
    }

    @Test
    @DisplayName("Obtiene el mensaje completo")
    public void testGetMessage() {
        String[][] messages = {
                {"este", "", "", "mensaje", ""},
                {"", "es", "", "", "secreto"},
                {"este", "", "un", "", ""}
        };

        String expectedMessage = "este es un mensaje secreto";

        String result = topSecretService.getMessage(messages);

        assertEquals(expectedMessage, result);
    }

    @Test
    @DisplayName("NotFoundException messages vacíos")
    public void testGetMessageThrowsNotFoundException() {
        String[][] messages = {
                {"este", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""}
        };
        assertThrows(NotFoundException.class, () -> topSecretService.getMessage(messages));
    }

    @Test
    @DisplayName("Obtiene el la psoción y el mensaje del emisor")
    public void testGetTopSecretReturnsTopSecretResponse() {
        TopSecretRequest topSecretRequest = MockDataGenerator.generateTopSecretRequestMockData();

        Point expectedLocation = new Point(487, 1557);
        String expectedMessage = "este es un mensaje secreto";

        TopSecretResponse result = topSecretService.getTopSecret(topSecretRequest.getSatellites());

        assertNotNull(result);
        assertEquals(expectedLocation, result.getPosition());
        assertEquals(expectedMessage, result.getMessage());
    }
    @Test
    @DisplayName("NotFoundException satélites insuficientes")
    public void testGetTopSecretThrowsNotFoundException() {
        SatelliteDto kenobiSatellite = new SatelliteDto();
        kenobiSatellite.setName("kenobi");
        kenobiSatellite.setDistance(100.0);
        kenobiSatellite.setMessage(new String[]{"este", "", "", "mensaje", ""});

        List<SatelliteDto> satellites = Arrays.asList(kenobiSatellite);

        assertThrows(NotFoundException.class, () -> topSecretService.getTopSecret(satellites));
    }
    @Test
    @DisplayName("Actualizar la información de un satélite")
    public void testUpdateSatelliteData() {
        String satelliteName = "kenobi";

        SatelliteDto satelliteDto = new SatelliteDto();
        satelliteDto.setName("kenobi");
        satelliteDto.setDistance(100.0);
        satelliteDto.setMessage(new String[]{"este", "", "", "mensaje", ""});

        when(satelliteRepository.findByName(satelliteName)).thenReturn(null);

        topSecretService.updateSatelliteData(satelliteName, satelliteDto);

        verify(satelliteRepository, times(1)).save(any(Satellite.class));
    }

    @Test
    @DisplayName("Obtiene el la psoción y el mensaje del emisor previamente registrados")
    public void testGetTopSecretSplitReturnsTopSecretResponse() {
        List<Satellite> satelliteList = MockDataGenerator.getSatellitesMockData();
        TopSecretRequest topSecretRequest = MockDataGenerator.generateTopSecretRequestMockData();

        when(satelliteRepository.findAll()).thenReturn(satelliteList);

        List<SatelliteDto> expectedSatelliteDtoList = topSecretRequest.getSatellites();
        when(mapper.map(satelliteList.get(0), SatelliteDto.class)).thenReturn(expectedSatelliteDtoList.get(0));
        when(mapper.map(satelliteList.get(1), SatelliteDto.class)).thenReturn(expectedSatelliteDtoList.get(1));
        when(mapper.map(satelliteList.get(2), SatelliteDto.class)).thenReturn(expectedSatelliteDtoList.get(2));

        Point expectedLocation = new Point(487, 1557);
        String expectedMessage = "este es un mensaje secreto";

        TopSecretResponse result = topSecretService.getTopSecretSplit();

        assertNotNull(result);
        assertEquals(expectedLocation, result.getPosition());
        assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    @DisplayName("NotFoundException no existe información de los satélites registrada")
    public void testGetTopSecretSplitThrowsNotFoundException() {
        List<Satellite> satelliteList = Arrays.asList(new Satellite());
        when(satelliteRepository.findAll()).thenReturn(satelliteList);
        assertThrows(NotFoundException.class, () -> topSecretService.getTopSecretSplit());
    }

}
