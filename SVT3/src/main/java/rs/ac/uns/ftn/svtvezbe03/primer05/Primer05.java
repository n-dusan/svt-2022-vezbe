package rs.ac.uns.ftn.svtvezbe03.primer05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Primer05 implements CommandLineRunner {

    @Autowired
    private TeacherRepository teacherRepository;

    public static void main(String[] args) {
        SpringApplication.run(Primer05.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Teacher zika = new Teacher(10, "Zika", "Zikic", "docent");
        Teacher pera = new Teacher(11, "Pera", "Peric", "vanredni profesor");
        Teacher laza = new Teacher(12, "Laza", "Lazic", "redovni profesor");

        teacherRepository.insert(zika);
        teacherRepository.insert(pera);
        teacherRepository.insert(laza);

        pera = teacherRepository.load(11);
        pera.setPosition("asistent");

        teacherRepository.update(pera);

        List<Teacher> teachers = teacherRepository.findAll();
        for (Teacher teacher: teachers) {
            System.out.println(teacher);
        }
    }
}
