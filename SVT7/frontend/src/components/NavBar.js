import React from "react";
import { Button, Nav, Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";
import { TokenService } from "../services/TokenService";
import { AuthenticationService } from "../services/AuthenticationService";

const NavBar = () => {
  const role = AuthenticationService.getRole();
  return (
    <Navbar
      bg={role === "ROLE_ADMIN" ? "dark" : "light"}
      variant={role === "ROLE_ADMIN" ? "dark" : "light"}
      expand
    >
      <Navbar.Brand as={Link} to="/">
        Sprints UI
      </Navbar.Brand>
      {/* className="mr-auto" podesi ovu grupu Nav Link-ova da se "rašire" sto je više moguće,
              i zbog toga je dugme Log in/Log out skroz sa leve strane */}
      <Nav className="mr-auto">
        <Nav.Link as={Link} to="/tasks">
          Tasks
        </Nav.Link>
      </Nav>

      {TokenService.getToken() ? (
        <Button onClick={() => AuthenticationService.logout()}>Log out</Button>
      ) : (
        <Nav.Link as={Link} to="/login">
          Log in
        </Nav.Link>
      )}
    </Navbar>
  );
};

export default NavBar;
