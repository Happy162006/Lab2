package sv.edu.udb.spring_api_rest.repository;

import sv.edu.udb.spring_api_rest.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Long> {



}