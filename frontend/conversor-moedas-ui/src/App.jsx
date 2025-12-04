import { useState } from 'react'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="min-h-screen flex items-center justify-center p-4">
      <div className="card max-w-md w-full">
        <h1 className="text-4xl font-bold text-gray-800 mb-2">
          💱 Conversor de Moedas
        </h1>
        <p className="text-gray-600 mb-8">
          Converta valores entre moedas em tempo real
        </p>
        
        <button 
          onClick={() => setCount((count) => count + 1)}
          className="btn-primary w-full"
        >
          Teste Tailwind: {count} cliques
        </button>

        <p className="text-sm text-gray-500 mt-4 text-center">
          ✅ Tailwind CSS configurado com sucesso!
        </p>
      </div>
    </div>
  )
}

export default App
