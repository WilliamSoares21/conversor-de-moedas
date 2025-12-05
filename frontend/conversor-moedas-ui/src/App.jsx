import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import ConversorForm from './components/ConversorForm';
import ListaMoedas from './components/ListaMoedas';
import './styles/App.css';

function App() {
  return (
    <Router>
      <div className="app">
        <header className="header">
          <h1>💱 Conversor de Moedas</h1>
          <nav className="nav">
            <Link to="/" className="nav-link">Converter</Link>
            <Link to="/moedas" className="nav-link">Lista de Moedas</Link>
          </nav>
        </header>

        <main className="main-content">
          <Routes>
            <Route path="/" element={<ConversorForm />} />
            <Route path="/moedas" element={<ListaMoedas />} />
          </Routes>
        </main>

        <footer className="footer">
          <p>Conversor de Moedas © 2025 - Desenvolvido com React + Spring Boot</p>
        </footer>
      </div>
    </Router>
  );
}

export default App;
