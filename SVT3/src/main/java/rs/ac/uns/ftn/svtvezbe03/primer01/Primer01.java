package rs.ac.uns.ftn.svtvezbe03.primer01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

@SpringBootApplication
public class Primer01 implements CommandLineRunner {

    private static String driver;
    private static String connectionUrl;
    private static String username;
    private static String password;

    public static void main(String[] args) {
        SpringApplication.run(Primer01.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Inializacija parametara za konektovanje ka bazi
        initializeDatabaseProperties();

        // Ucitavanje H2 drajvera
        Class.forName(driver);

        // Povezivanje na bazu podataka
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        // Izvrsavanje upita
        String query = "SELECT ime, prezime FROM nastavnici";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        // Prikazivanje rezultata upita
        while (resultSet.next()) {
            System.out.printf("%s %s%n", resultSet.getString(1), resultSet.getString(2));
        }

        // Zatvaranje veze
        resultSet.close();
        statement.close();
        connection.close();
    }

    private void initializeDatabaseProperties() throws IOException {
        Properties databaseProperties = loadDatabasePropertiesFromFile();

        driver = databaseProperties.getProperty("db.driver");
        connectionUrl = databaseProperties.getProperty("db.connectionUrl");
        username = databaseProperties.getProperty("db.username");
        password = databaseProperties.getProperty("db.password");
    }

    private Properties loadDatabasePropertiesFromFile() throws IOException {
        ClassLoader classLoader = Primer01.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        return properties;
    }
}
