package GemeloApp.GemeloTriburarioBackend.repository;

import GemeloApp.GemeloTriburarioBackend.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
