package co.com.mercadolibre.quasarfireoperation.controller;

import co.com.mercadolibre.quasarfireoperation.exception.ApiException;
import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;
import co.com.mercadolibre.quasarfireoperation.model.dto.request.TopSecretRequest;
import co.com.mercadolibre.quasarfireoperation.model.dto.response.TopSecretResponse;
import co.com.mercadolibre.quasarfireoperation.service.TopSecretService;
import co.com.mercadolibre.quasarfireoperation.utils.DocumentationConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quasar/")
public class TopSecretController {

    private final TopSecretService topSecretService;

    @PostMapping("/topsecret")
    @Operation(summary = "Obtener la posición y el mensaje secreto.", description = "Servicio encargado de obtener la posición de la nave y el mensaje" +
            "secreto que esta emite.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "* Success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TopSecretResponse.class),
                            examples = {@ExampleObject(name = "Successful operation", summary = "Successful operation",
                                    value = DocumentationConstant.GET_TOP_SECRET_OK_EXAMPLE)})),
            @ApiResponse(responseCode = "400", description = "* Bad Request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class),
                            examples = {@ExampleObject(name = "* Bad Request", summary = "Bad Request",
                            value = DocumentationConstant.GET_TOP_SECRET_BAD_REQUEST_EXAMPLE)})),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class))),
            @ApiResponse(responseCode = "500", description = "* Internal Server Error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    public ResponseEntity<TopSecretResponse> getTopSecret(@Valid @RequestBody TopSecretRequest request) {
        TopSecretResponse response = topSecretService.getTopSecret(request.getSatellites());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/topsecret_split/{satelliteName}")
    public ResponseEntity<String> updateSatelliteData(@PathVariable String satelliteName, @Valid @RequestBody SatelliteDto satellite) {
        topSecretService.updateSatelliteData(satelliteName, satellite);
        return ResponseEntity.ok("Operation exitosa");
    }

    @GetMapping("/topsecret_split")
    public ResponseEntity<TopSecretResponse> getTopSecretSplit() {
        TopSecretResponse response = topSecretService.getTopSecretSplit();
        return ResponseEntity.ok(response);
    }
}
