package GemeloApp.GemeloTriburarioBackend.service;

import GemeloApp.GemeloTriburarioBackend.model.GuiaAprendizaje;
import GemeloApp.GemeloTriburarioBackend.repository.GuiaAprendizajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuiaAprendizajeService {

    private final GuiaAprendizajeRepository repository;

    @Transactional(readOnly = true)
    public List<GuiaAprendizaje> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public GuiaAprendizaje buscarPorId(Long id) {
        return obtenerOFallar(id);
    }

    @Transactional
    public GuiaAprendizaje crear(GuiaAprendizaje datos) {
        datos.setIdGuia(null);
        return repository.save(datos);
    }

    @Transactional
    public GuiaAprendizaje editar(Long id, GuiaAprendizaje datos) {
        GuiaAprendizaje existente = obtenerOFallar(id);
        datos.setIdGuia(existente.getIdGuia());
        return repository.save(datos);
    }

    @Transactional
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("GuiaAprendizaje no encontrado: " + id);
        }
        repository.deleteById(id);
    }

    private GuiaAprendizaje obtenerOFallar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GuiaAprendizaje no encontrado: " + id));
    }
}
