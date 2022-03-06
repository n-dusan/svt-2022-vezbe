package rs.ac.uns.ftn.svtvezbe03.primer02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

@SpringBootApplication
public class Primer02 implements CommandLineRunner {

    private static String driver;
    private static String connectionUrl;
    private static String username;
    private static String password;

    public static void main(String[] args) {
        SpringApplication.run(Primer02.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Inializacija parametara za konektovanje ka bazi
        initializeDatabaseProperties();

        // Ucitavanje H2 drajvera
        Class.forName(driver);

        // Povezivanje na bazu podataka
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        // Dodavanje novih nastavnika
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO nastavnici (nastavnikId, ime, prezime, zvanje) VALUES (?, ?, ?, ?)");
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Sima");
        preparedStatement.setString(3, "Simic");
        preparedStatement.setString(4, "docent");
        preparedStatement.executeUpdate();

        preparedStatement.setInt(1, 3);
        preparedStatement.setString(2, "Vasa");
        preparedStatement.setString(3, "Vasic");
        preparedStatement.setString(4, "vanprof");

        // Izvrsavanja pripremljene naredbe
        preparedStatement.executeUpdate();
        preparedStatement.close();

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
        ClassLoader classLoader = Primer02.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        return properties;
    }

}
