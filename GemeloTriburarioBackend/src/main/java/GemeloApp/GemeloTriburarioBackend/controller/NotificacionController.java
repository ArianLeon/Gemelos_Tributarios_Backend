package GemeloApp.GemeloTriburarioBackend.controller;

import GemeloApp.GemeloTriburarioBackend.model.Notificacion;
import GemeloApp.GemeloTriburarioBackend.service.NotificacionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
@Tag(name = "Notificaciones")
public class NotificacionController {

    private final NotificacionService service;

    @GetMapping
    public ResponseEntity<List<Notificacion>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Notificacion> crear(@Valid @RequestBody Notificacion datos) {
        return ResponseEntity.status(201).body(service.crear(datos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacion> editar(@PathVariable Long id, @Valid @RequestBody Notificacion datos) {
        return ResponseEntity.ok(service.editar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
