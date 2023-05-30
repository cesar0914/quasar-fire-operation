package co.com.mercadolibre.quasarfireoperation.mockdata;

import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;
import co.com.mercadolibre.quasarfireoperation.model.dto.request.TopSecretRequest;
import co.com.mercadolibre.quasarfireoperation.model.dto.response.TopSecretResponse;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MockDataGenerator {
    public static TopSecretRequest generateTopSecretRequestMockData() {
        TopSecretRequest request = new TopSecretRequest();
        List<SatelliteDto> satellites = new ArrayList<>();

        SatelliteDto kenobiSatellite = new SatelliteDto();
        kenobiSatellite.setName("kenobi");
        kenobiSatellite.setDistance(100.0);
        kenobiSatellite.setMessage(new String[]{"este", "", "", "mensaje", ""});
        satellites.add(kenobiSatellite);

        SatelliteDto skywalkerSatellite = new SatelliteDto();
        skywalkerSatellite.setName("skywalker");
        skywalkerSatellite.setDistance(115.5);
        skywalkerSatellite.setMessage(new String[]{"", "es", "", "", "secreto"});
        satellites.add(skywalkerSatellite);

        SatelliteDto satoSatellite = new SatelliteDto();
        satoSatellite.setName("sato");
        satoSatellite.setDistance(142.7);
        satoSatellite.setMessage(new String[]{"este", "", "un", "", ""});
        satellites.add(satoSatellite);

        request.setSatellites(satellites);
        return request;
    }
    public static TopSecretResponse generateTopSecretResponseMockData() {
        Point position = new Point(100, 200);
        String message = "Este es un mensaje secreto";

        return TopSecretResponse.builder()
                .position(position)
                .message(message)
                .build();
    }
}