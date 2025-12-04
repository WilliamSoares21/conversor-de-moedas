import { useState, useEffect } from 'react';
import { conversorService } from "../services/api";

function ConversorForm() {
  const [moedas, setMoedas] = useState([]);
  const [origem, setOrigem] = useState('USD');
  const [destino, setDestino] = useState('BRL');
  const [valor, setValor] = useState(100);
  const [resultado, setResultado] = useState(null);
  const [loading, setLoading] = useState(false);
  const [erro, setErro] = useState(null);

  useEffect(() => {
    const carregarMoedas = async () => {
      try {
        const response = await conversorService.listarMoedas();

        setMoedas(response.data.supportedCodes);
      } catch (error) {
        setErro('Erro ao carregar as moedas.');
      }
    };
    carregarMoedas();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setErro(null);

    try {
      const response = await conversorService.converter({
        moedaOrigem: origem,
        moedaDestino: destino,
        valor: parseFloat(valor),
      });

      setResultado({
        valorConvertido: response.data.valorConvertido,
        taxaConversao: response.data.taxaConversao,
        moedaOrigem: origem,
        moedaDestino: destino,
      });
    } catch (error) {
      setErro('Erro ao converter a moeda.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="conversor-form">
      <h2>Conversor de Moedas</h2>

      {erro && <div className="erro">{erro}</div>}

      <form onSubmit={handleSubmit}>
        <div>
          <label>Moeda Origem:</label>
          <select value={origem} onChange={(e) => setOrigem(e.target.value)}>
            {moedas.map(([codigo, nome]) => (
              <option key={codigo} value={codigo}>
                {codigo} - {nome}
              </option>
            ))}
          </select>
        </div>

        <div>
          <label>Moeda Destino:</label>
          <select value={destino} onChange={(e) => setDestino(e.target.value)}>
            {moedas.map(([codigo, nome]) => (
              <option key={codigo} value={codigo}>
                {codigo} - {nome}
              </option>
            ))}
          </select>
        </div>

        <div>
          <label>Valor:</label>
          <input
            type="number"
            value={valor}
            onChange={(e) => setValor(e.target.value)}
            step="0.01"
            min="0"
          />
        </div>

        <button type="submit" disabled={loading}>
          {loading ? 'Convertendo...' : 'Converter'}
        </button>
      </form>

      {resultado && (
        <div className="resultado">
          <h3>Resultado:</h3>
          <p>
            **{valor} {resultado.moedaOrigem}** = **{resultado.valorConvertido.toFixed(2)} {resultado.moedaDestino}**
          </p>
          <p>Taxa: {resultado.taxaConversao}</p>
        </div>
      )}
    </div>
  );
}
export default ConversorForm;
