import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { Container } from "react-bootstrap";
import Home from "./pages/Home";
import NotFound from "./pages/NotFound";
import NavBar from "./components/NavBar";
import Login from "./pages/Login";
import Tasks from "./pages/tasks/Tasks";
import EditTask from "./pages/tasks/EditTask";
import { PrivateRoute } from "./components/PrivateRoute";

export default function App() {
  return (
    // Ruter obezbeđuje iluziju odlaska na druge stranice
    // Stranica se nikad ne refrešuje ali React Router i dalje ažurira URL
    // Ovo znači da je moguće ići kroz istoriju, kao i koristi bookmark-ove
    <Router>
      <NavBar />
      <Container style={{ marginTop: 25 }}>
        <Switch>
          <Route exact path="/" component={Home} />
          <Route exact path="/tasks" component={Tasks} />
          <PrivateRoute
            exact
            path="/tasks/edit/:id"
            component={EditTask}
            roles={["ROLE_ADMIN"]}
          />
          <Route exact path="/login" component={Login} />
          {/* Svaka putanja koja se ne može vodi do prikaza NotFound komponente */}
          <Route component={NotFound} />
        </Switch>
      </Container>
    </Router>
  );
}
