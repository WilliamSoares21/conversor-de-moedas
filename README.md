# 💱 Conversor de Moedas

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java" alt="Java 21">
  <img src="https://img.shields.io/badge/Maven-3.8+-blue?style=for-the-badge&logo=apache-maven" alt="Maven">
  <img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge" alt="License">
</p>

## 📋 Sobre o Projeto

Conversor de Moedas é uma aplicação Java de linha de comando que permite realizar conversões entre diferentes moedas em tempo real. O projeto consome a API [ExchangeRate-API](https://www.exchangerate-api.com/) para obter cotações atualizadas e oferece uma interface interativa via console.

Este projeto foi desenvolvido como parte do desafio da formação **Java Back-End** da [Alura](https://www.alura.com.br/), com o objetivo de consolidar conhecimentos em:

- Programação Orientada a Objetos
- Consumo de APIs REST
- Manipulação de JSON com Gson
- Tratamento de exceções
- Boas práticas de desenvolvimento

## ✨ Funcionalidades

- ✅ **Conversão em tempo real** entre diversas moedas
- ✅ **Mais de 160 moedas suportadas** (EUR, USD, GBP, ARS, JPY, KRW, BRL e muitas outras)
- ✅ **Consulta de moedas disponíveis** com filtros por região
- ✅ **Validação de códigos de moedas** antes da requisição
- ✅ **Modo offline** como fallback caso a API esteja indisponível
- ✅ **Interface interativa** via console
- ✅ **Tratamento robusto de erros**

## 🚀 Demonstração

```
#-- Seja bem vindo ao conversor de Moedas! --#

Carregando lista de moedas disponíveis...

Tudo OK, 162 moedas foram carregadas da API!

Nossas moedas disponíveis são: EUR, USD, GBP, ARS, JPY, KRW e muitas outras!

O que deseja fazer ?
1 - Converter moedas
2 - Consultar moedas disponíveis
0 - Sair
> 1

--- CONVERSÃO DE MOEDAS ---
Insira a moeda de origem (ex: USD, EUR):
> USD
Insira a moeda de destino (ex: USD, EUR):
> BRL
Resultado da requisição: Moeda[Result=success, BaseCode=USD, TargetCode=BRL, ConversionRate=4.8665, ...]
```

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| **Java 21** | Linguagem de programação principal |
| **Maven** | Gerenciamento de dependências e build |
| **Gson 2.13.2** | Serialização/deserialização de JSON |
| **HttpClient** | Cliente HTTP nativo do Java para requisições à API |
| **Dotenv Java 2.3.0** | Gerenciamento de variáveis de ambiente |
| **ExchangeRate-API** | API para obtenção de cotações em tempo real |

## 📦 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/) ou superior
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- Uma chave de API da [ExchangeRate-API](https://www.exchangerate-api.com/) (gratuita)

## ⚙️ Instalação e Configuração

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/conversor-de-moedas.git
cd conversor-de-moedas
```

### 2. Obtenha sua API Key

1. Acesse [ExchangeRate-API](https://www.exchangerate-api.com/)
2. Insira seu e-mail para receber a chave gratuitamente
3. Copie a chave recebida por e-mail

### 3. Configure as variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto:

```bash
touch .env
```

Adicione sua API Key no arquivo `.env`:

```env
API_KEY=sua_chave_api_aqui
```

### 4. Instale as dependências

```bash
mvn clean install
```

## 🎮 Como Usar

### Executar a aplicação

```bash
mvn exec:java
```

Ou, se preferir compilar e executar o JAR:

```bash
mvn clean package
java -jar target/conversor-1.0-SNAPSHOT.jar
```

### Menu Principal

Ao iniciar, você verá o menu com três opções:

1. **Converter moedas**: Converte um valor entre duas moedas
2. **Consultar moedas disponíveis**: Lista moedas por região (África, Américas, Ásia, Europa, Oceania)
3. **Sair**: Encerra o programa

### Exemplo de Conversão

```
Insira a moeda de origem (ex: USD, EUR):
> USD
Insira a moeda de destino (ex: USD, EUR):
> BRL
```

## 📁 Estrutura do Projeto

```
conversor-de-moedas/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── conversor/
│   │               ├── App.java                           # Classe principal
│   │               ├── ConversorService.java              # Lógica de requisições
│   │               ├── Moeda.java                         # Record para moeda
│   │               ├── MoedasSuportadas.java              # Record para lista de moedas
│   │               ├── TabelaMoedas.java                  # Dados de moedas offline
│   │               └── MoedaNaoEncontradaException.java   # Exceção customizada
│   └── test/
│       └── java/
│           └── com/
│               └── conversor/
│                   └── AppTest.java
├── pom.xml
├── .env
├── .gitignore
└── README.md
```

## 🔧 Dependências do Projeto

As principais dependências estão configuradas no `pom.xml`:

```xml
<!-- Gson para manipulação de JSON -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.13.2</version>
</dependency>

<!-- Dotenv para variáveis de ambiente -->
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>2.3.0</version>
</dependency>
```

## 🎯 Funcionalidades Detalhadas

### Validações Implementadas

- ✅ Verifica se os códigos de moeda têm exatamente 3 caracteres
- ✅ Valida se contém apenas letras maiúsculas (A-Z)
- ✅ Impede conversão entre moedas iguais
- ✅ Verifica se a moeda existe na API
- ✅ Tratamento de erros de conexão

### Modo Offline

Caso a API esteja indisponível, o sistema automaticamente carrega uma lista offline de moedas, permitindo consultas mesmo sem internet.

## 🤝 Contribuindo

Contribuições são sempre bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 📝 Melhorias Futuras

- [ ] Histórico de conversões com data e hora
- [ ] Salvar conversões em arquivo
- [ ] Interface gráfica (GUI)
- [ ] Suporte a múltiplas APIs de câmbio
- [ ] Gráficos de variação cambial
- [ ] Cache de cotações
- [ ] Testes unitários completos

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/WilliamSoares21">
        <img src="https://github.com/WilliamSoares21.png" width="100px;" alt="Foto de William Soares"/><br>
        <sub>
          <b>William Soares</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

Desenvolvido como parte do desafio da formação Java Back-End da Alura.

[![GitHub](https://img.shields.io/badge/GitHub-WilliamSoares21-181717?style=flat&logo=github)](https://github.com/WilliamSoares21)

---

<p align="center">
  Feito com ☕ e Java
</p>
