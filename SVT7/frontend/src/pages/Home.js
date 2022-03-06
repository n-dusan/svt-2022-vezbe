import React from "react";
import { Col, Container, Row } from "react-bootstrap";

// Načini deklarisanja React komponenti - svi su ekvivalenti
// Funkcionalni načini su moderniji (React >= 16.8), danas češće korišćeni
// Deklarisanje putem klase je i dalje moguće naći, ali je manje elegantno

// Funkcionalan - arrow funkcija
const Home = () => (
  <Container>
    <Row>
      <Col md={{ span: 6, offset: 3 }} style={{ textAlign: "center" }}>
        <h1>Plan carefully!</h1>
      </Col>
    </Row>
  </Container>
);

// Funkcionalan - obična funkcija
// function Home() {
//   return (
//     <Container>
//       <Row>
//         <Col md={{ span: 6, offset: 3 }} style={{ textAlign: "center" }}>
//           <h1>Plan carefully!</h1>
//         </Col>
//       </Row>
//     </Container>
//   );
// }

// U vidu klase
// class Home extends React.Component {
//   render() {
//     return (
//       <Container>
//         <Row>
//           <Col md={{ span: 6, offset: 3 }} style={{ textAlign: "center" }}>
//             <h1>Plan carefully!</h1>
//           </Col>
//         </Row>
//       </Container>
//     );
//   }
// }

export default Home;
