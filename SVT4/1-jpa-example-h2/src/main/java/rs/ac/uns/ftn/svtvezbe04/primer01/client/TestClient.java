package rs.ac.uns.ftn.svtvezbe04.primer01.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rs.ac.uns.ftn.svtvezbe04.primer01.entity.Gorivo;
import rs.ac.uns.ftn.svtvezbe04.primer01.entity.Menjac;
import rs.ac.uns.ftn.svtvezbe04.primer01.entity.Vozilo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class TestClient implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestClient.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Logger.getLogger("").setLevel(Level.OFF);
        // Creates an Entity Manager Factory (it is thread safe)
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Vezbe04");

        // Creates an Entity Manager (it is not thread safe)
        EntityManager manager = factory.createEntityManager();

        try {
            // Creates object model
            Gorivo dizel = new Gorivo();
            dizel.setTipGoriva("dizel");

            Gorivo benzin = new Gorivo();
            benzin.setTipGoriva("benzin");

            Menjac automatski = new Menjac();
            automatski.setTipMenjaca("automatski");

            Menjac rucni = new Menjac();
            rucni.setTipMenjaca("rucni");

            // Starts a transaction
            EntityTransaction tx = manager.getTransaction();
            tx.begin();

            manager.persist(automatski);
            manager.persist(rucni);

            Vozilo fiatPunto = new Vozilo(5, 5, 3, 4500, new Date(), 1999, benzin, 1000, rucni, "Fiat Punto", 90000l, 60, 1200, false);
            Vozilo zastavaYugo = new Vozilo(5, 4, 3, 1200, new Date(), 1989, benzin, 900, rucni, "Zastava Yugo", 97000l, 45, 726, false);

            manager.persist(dizel);
            manager.persist(benzin);

            // Commits the transaction
            tx.commit();

            System.out.println("Entities persisted:\n" + fiatPunto + "\n" + zastavaYugo);

            // Finds an entity (ID = 1)
            tx.begin();
            Vozilo vozilo = manager.find(Vozilo.class, 1);
            System.out.println("Found:\n" + vozilo);

            // Updates the entity
            vozilo.setNazivVozila("Fiat");
            manager.merge(vozilo);
            System.out.println("Updated:\n" + vozilo);

            // Removes the entity
            vozilo = manager.find(Vozilo.class, 2);
            manager.remove(vozilo);
            tx.commit();
            System.out.println("Removed:\n" + vozilo);

            // Executes a query
            tx.begin();
            Query query = manager.createQuery("SELECT v FROM Vozilo v WHERE v.id > ?1");
            query.setParameter(1, 0);
            @SuppressWarnings("unchecked")
            List<Vozilo> vozila = (List<Vozilo>) query.getResultList();
            tx.commit();

            System.out.println("Entities retrieved:");
            for (Vozilo v : vozila)
                System.out.println(v);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
            factory.close();
        }
    }
}

