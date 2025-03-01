package sv.edu.udb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.model.Alumno;
import sv.edu.udb.model.Materia;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlumnoRepositoryTest {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Test
    @Transactional
    @Commit
    void insertarAlumnoTest() {
        Materia materia = new Materia();
        materia.setNombre("Biología");
        materiaRepository.save(materia);

        Alumno alumno = new Alumno();
        alumno.setNombre("Pedro");
        alumno.setApellido("Ramírez");
        alumno.setMateria(materia);
        alumnoRepository.save(alumno);

        assertNotNull(alumno.getId());
        assertEquals("Pedro", alumno.getNombre());
    }
}
