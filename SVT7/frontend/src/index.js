import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import "bootstrap/dist/css/bootstrap.min.css";

ReactDOM.render(
  // React koristi virtuelni DOM kao način deklarisanja UI komponenti
  // Ovo omogućava smeštanja svih UI komponenti u memoriju i veoma brzu izmenu
  // Performanse garantuje "Reconciliation" algoritam
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  // React se ne mora koristiti samo kao Single Page Application (SPA)
  // Može se dodati u bilo koji element unutar nekog validnog HTML tag-a, proizvoljno mnogo puta
  // Ovo znači da je React moguće kombinovati i naknadno dodavati na već postojeće web stranice
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
