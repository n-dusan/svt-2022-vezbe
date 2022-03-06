import React, { useState } from "react";
import { Button, Col, Container, Form, Row } from "react-bootstrap";
import { AuthenticationService } from "../services/AuthenticationService";

const Login = () => {
  // useState je React Hook - funkcija koja dozvoljava definisanje stanja i životnog ciklusa unutar funkcija
  // Moguće ih je koristiti jedino u funkcionalnim komponentama
  // useState definiše dve vrednosti:
  // * Prva je objekat u stanju kome se može pristupati
  // * Druga je funkcija pomoću koje se taj objekat menja - promenu jedino treba raditi putem ove funkcije
  const [credentials, setCredentials] = useState({
    username: "",
    password: "",
  });

  // Funkcija koja prima naziv polja koje će se ažurirati, a potom i događaj koji je doveo do tog ažuriranja
  // Iz događaja je moguće izvući novu vrednost polja
  const handleFormInputChange = (name) => (event) => {
    const val = event.target.value;

    // ... - Destructuring assignment - omogućuje raspakivanje vrednosti objekata ili nizova
    // setCredentails će zameniti stanje novim objektom koji uzima vrednosti iz prethodnog stanja kredencijala
    // ali sa ažuriranom vrednošću [name] polja
    setCredentials({ ...credentials, [name]: val });
  };

  // Asinhrone izvršavanje koda znači da nije potrebno blokirati izvršavanje i čekati da se funkcija završi
  // Koriste se za operacije koje dugo traju - slanje zahteva ka nekom serveru, čitanje sa diska ...
  // Moraju da sadrže await keyword i vraćaju Promise objekat koji nakon što stigne nastavlja sa obradom
  const login = async () => {
    await AuthenticationService.login(credentials);
  };

  // Return vraća JSX (JavaScript XML) - notaciju kroz koju je moguće elemente unutar React-a
  // Ovi elementi ujedno mogu da sadrže deklaraciju UI komponeti i poslovnu logiku
  // JSX je samo notacije te komponente koje se vraćaju ne moraju da budu samo vezane za HTML tagove
  // Koristi se i u drugim projektima poput React Native

  // JSX nije nužno koristi - ovo je samo deklarativan zapis funkcija koje će React izvesti
  // https://reactjs.org/docs/react-without-jsx.html
  return (
    <Container>
      <Row>
        <Col md={{ span: 6, offset: 3 }} style={{ textAlign: "center" }}>
          <Form>
            <Form.Group>
              <Form.Label>Username</Form.Label>
              <Form.Control
                type="text"
                name="username"
                value={credentials.username}
                onChange={handleFormInputChange("username")}
              />
            </Form.Group>
            <Form.Group>
              <Form.Label>Password</Form.Label>
              <Form.Control
                type="password"
                name="password"
                value={credentials.password}
                onChange={handleFormInputChange("password")}
              />
            </Form.Group>
            <Button variant="success" onClick={login}>
              Log in
            </Button>
          </Form>
        </Col>
      </Row>
    </Container>
  );
};

export default Login;
