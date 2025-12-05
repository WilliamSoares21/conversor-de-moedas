import { useState, useEffect } from 'react';
import { conversorService } from '../services/api';

function ListaMoedas() {
  const [moedas, setMoedas] = useState([]);
  const [loading, setLoading] = useState(true);
  const [erro, setErro] = useState(null);
  const [busca, setBusca] = useState('');

  useEffect(() => {
    const carregarMoedas = async () => {
      try {
        const response = await conversorService.listarMoedas();
        setMoedas(response.data.supportedCodes || []);
      } catch (error) {
        setErro('Erro ao carregar a lista de moedas.');
        console.error(error);
      } finally {
        setLoading(false);
      }
    };
    carregarMoedas();
  }, []);

  const moedasFiltradas = moedas.filter(([codigo, nome]) =>
    codigo.toLowerCase().includes(busca.toLowerCase()) ||
    nome.toLowerCase().includes(busca.toLowerCase())
  );

  if (loading) {
    return <div className="loading">⏳ Carregando moedas...</div>;
  }

  if (erro) {
    return <div className="erro">{erro}</div>;
  }

  return (
    <div className="lista-moedas">
      <h2>📋 Lista de Moedas Disponíveis</h2>
      
      <div className="busca-container">
        <input
          type="text"
          placeholder="🔍 Buscar moeda (código ou nome)..."
          value={busca}
          onChange={(e) => setBusca(e.target.value)}
          className="input-busca"
        />
      </div>

      <p className="total-moedas">
        Total: <strong>{moedasFiltradas.length}</strong> moedas encontradas
      </p>

      <div className="moedas-grid">
        {moedasFiltradas.map(([codigo, nome]) => (
          <div key={codigo} className="moeda-card">
            <span className="moeda-codigo">{codigo}</span>
            <span className="moeda-nome">{nome}</span>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ListaMoedas;
