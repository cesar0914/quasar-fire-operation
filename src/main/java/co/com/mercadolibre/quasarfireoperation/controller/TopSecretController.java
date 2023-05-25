package co.com.mercadolibre.quasarfireoperation.controller;

import co.com.mercadolibre.quasarfireoperation.model.dto.request.TopSecretRequest;
import co.com.mercadolibre.quasarfireoperation.model.dto.response.TopSecretResponse;
import co.com.mercadolibre.quasarfireoperation.utils.DocumentationConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quasar/")
public class TopSecretController {

    @PostMapping("/topsecret")
    @Operation(summary = "Obtener la posición y el mensaje secreto.", description = "Servicio encargado de obtener la posición de la nave y el mensaje" +
            "secreto que esta emite.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "* Success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TopSecretResponse.class),
                            examples = {@ExampleObject(name = "Successful operation", summary = "Successful operation",
                                    value = DocumentationConstant.GET_TOP_SECRET_OK_EXAMPLE)})),
            @ApiResponse(responseCode = "400", description = "* Bad Request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class))),
            @ApiResponse(responseCode = "500", description = "* Internal Server Error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class)))
    })
    public ResponseEntity<?> getTopSecret(@RequestBody TopSecretRequest request) {
        // Implementa la lógica para determinar la posición y el mensaje
        // utilizando los datos proporcionados en la solicitud

        return ResponseEntity.ok("working");
    }
}
