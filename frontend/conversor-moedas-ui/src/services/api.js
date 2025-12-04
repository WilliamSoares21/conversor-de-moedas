import axios from 'axios';

const api = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

api.interceptors.request.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 500) {
      console.error('Erro interno do servidor:', error.response.data);
    }
    return Promise.reject(error);
  }
);

export const conversorService = {
  listarMoedas: () => api.get('/conversor/moedas'),

  buscarTaxa: (origem, destino) =>
    api.get(`/conversor/taxa?origem=${origem}&destino=${destino}`),

  converter: (dados) => api.post('/conversor/converter', dados),
};

export default api;
