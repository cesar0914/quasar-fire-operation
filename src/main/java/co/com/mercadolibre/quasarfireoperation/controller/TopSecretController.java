package co.com.mercadolibre.quasarfireoperation.controller;

import co.com.mercadolibre.quasarfireoperation.model.dto.request.TopSecretRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quasar/")
public class TopSecretController {

    @PostMapping("/topsecret")
    public ResponseEntity<?> getTopSecret(@RequestBody TopSecretRequest request) {
        // Implementa la lógica para determinar la posición y el mensaje
        // utilizando los datos proporcionados en la solicitud

        return ResponseEntity.ok("working");
    }
}
