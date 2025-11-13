package com.conversor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabelaMoedas {

  // --- 1. MAPEAMENTO DE REGIÕES ---
  // O mapa que associa o Código da Moeda à sua Região para permitir o filtro.
  private static final Map<String, String> REGIOES_MAP;

  static {
    REGIOES_MAP = new HashMap<>();
    // América do Norte
    REGIOES_MAP.put("USD", "AMERICA_NORTE");
    REGIOES_MAP.put("CAD", "AMERICA_NORTE");
    REGIOES_MAP.put("MXN", "AMERICA_NORTE");
    REGIOES_MAP.put("CUP", "AMERICA_NORTE");
    REGIOES_MAP.put("CRC", "AMERICA_NORTE");
    REGIOES_MAP.put("DOP", "AMERICA_NORTE");
    REGIOES_MAP.put("HTG", "AMERICA_NORTE");
    REGIOES_MAP.put("HNL", "AMERICA_NORTE");
    REGIOES_MAP.put("NIO", "AMERICA_NORTE");
    REGIOES_MAP.put("PAB", "AMERICA_NORTE");
    REGIOES_MAP.put("TTD", "AMERICA_NORTE");
    REGIOES_MAP.put("XCD", "AMERICA_NORTE");
    REGIOES_MAP.put("BSD", "AMERICA_NORTE");
    REGIOES_MAP.put("BBD", "AMERICA_NORTE");
    REGIOES_MAP.put("KYD", "AMERICA_NORTE");
    REGIOES_MAP.put("JMD", "AMERICA_NORTE");
    REGIOES_MAP.put("ANG", "AMERICA_NORTE");
    REGIOES_MAP.put("AWG", "AMERICA_NORTE");
    REGIOES_MAP.put("BZD", "AMERICA_NORTE");

    // América do Sul
    REGIOES_MAP.put("BRL", "AMERICA_SUL");
    REGIOES_MAP.put("ARS", "AMERICA_SUL");
    REGIOES_MAP.put("COP", "AMERICA_SUL");
    REGIOES_MAP.put("CLP", "AMERICA_SUL");
    REGIOES_MAP.put("PEN", "AMERICA_SUL");
    REGIOES_MAP.put("UYU", "AMERICA_SUL");
    REGIOES_MAP.put("VES", "AMERICA_SUL");
    REGIOES_MAP.put("BOB", "AMERICA_SUL");
    REGIOES_MAP.put("PYG", "AMERICA_SUL");
    REGIOES_MAP.put("SRD", "AMERICA_SUL");
    REGIOES_MAP.put("GYD", "AMERICA_SUL");
    REGIOES_MAP.put("FKP", "AMERICA_SUL");

    // Europa
    REGIOES_MAP.put("EUR", "EUROPA");
    REGIOES_MAP.put("GBP", "EUROPA");
    REGIOES_MAP.put("CHF", "EUROPA");
    REGIOES_MAP.put("DKK", "EUROPA");
    REGIOES_MAP.put("SEK", "EUROPA");
    REGIOES_MAP.put("NOK", "EUROPA");
    REGIOES_MAP.put("PLN", "EUROPA");
    REGIOES_MAP.put("RUB", "EUROPA");
    REGIOES_MAP.put("CZK", "EUROPA");
    REGIOES_MAP.put("HUF", "EUROPA");
    REGIOES_MAP.put("BGN", "EUROPA");
    REGIOES_MAP.put("RON", "EUROPA");
    REGIOES_MAP.put("HRK", "EUROPA"); // OBS: Croácia usa EUR agora, mas mantido para lista histórica.
    REGIOES_MAP.put("AMD", "EUROPA");
    REGIOES_MAP.put("GEL", "EUROPA");
    REGIOES_MAP.put("AZN", "EUROPA");
    REGIOES_MAP.put("BYN", "EUROPA");
    REGIOES_MAP.put("UAH", "EUROPA");
    REGIOES_MAP.put("RSD", "EUROPA");
    REGIOES_MAP.put("BAM", "EUROPA");
    REGIOES_MAP.put("MKD", "EUROPA");
    REGIOES_MAP.put("ISK", "EUROPA");
    REGIOES_MAP.put("ALL", "EUROPA");
    REGIOES_MAP.put("MDL", "EUROPA");

    // Ásia/Oriente Médio
    REGIOES_MAP.put("JPY", "ASIA");
    REGIOES_MAP.put("CNY", "ASIA");
    REGIOES_MAP.put("KRW", "ASIA");
    REGIOES_MAP.put("INR", "ASIA");
    REGIOES_MAP.put("AED", "ASIA");
    REGIOES_MAP.put("SAR", "ASIA");
    REGIOES_MAP.put("HKD", "ASIA");
    REGIOES_MAP.put("SGD", "ASIA");
    REGIOES_MAP.put("THB", "ASIA");
    REGIOES_MAP.put("IDR", "ASIA");
    REGIOES_MAP.put("MYR", "ASIA");
    REGIOES_MAP.put("VND", "ASIA");
    REGIOES_MAP.put("PHP", "ASIA");
    REGIOES_MAP.put("PKR", "ASIA");
    REGIOES_MAP.put("BDT", "ASIA");
    REGIOES_MAP.put("LKR", "ASIA");
    REGIOES_MAP.put("ILS", "ASIA");
    REGIOES_MAP.put("IQD", "ASIA");
    REGIOES_MAP.put("IRR", "ASIA");
    REGIOES_MAP.put("KWD", "ASIA");
    REGIOES_MAP.put("OMR", "ASIA");
    REGIOES_MAP.put("QAR", "ASIA");
    REGIOES_MAP.put("JOD", "ASIA");
    REGIOES_MAP.put("BHD", "ASIA");
    REGIOES_MAP.put("KZT", "ASIA");
    REGIOES_MAP.put("UZS", "ASIA");
    REGIOES_MAP.put("TJS", "ASIA");
    REGIOES_MAP.put("TMT", "ASIA");
    REGIOES_MAP.put("AFN", "ASIA");
    REGIOES_MAP.put("MNT", "ASIA");
    REGIOES_MAP.put("LAK", "ASIA");
    REGIOES_MAP.put("MMK", "ASIA");
    REGIOES_MAP.put("KHR", "ASIA");
    REGIOES_MAP.put("NPR", "ASIA");
    REGIOES_MAP.put("BTN", "ASIA");
    REGIOES_MAP.put("MOP", "ASIA");
    REGIOES_MAP.put("TWD", "ASIA");
    REGIOES_MAP.put("SYP", "ASIA");
    REGIOES_MAP.put("YER", "ASIA");
    REGIOES_MAP.put("LBP", "ASIA");

    // África
    REGIOES_MAP.put("ZAR", "AFRICA");
    REGIOES_MAP.put("NGN", "AFRICA");
    REGIOES_MAP.put("EGP", "AFRICA");
    REGIOES_MAP.put("DZD", "AFRICA");
    REGIOES_MAP.put("MAD", "AFRICA");
    REGIOES_MAP.put("TND", "AFRICA");
    REGIOES_MAP.put("GHS", "AFRICA");
    REGIOES_MAP.put("KES", "AFRICA");
    REGIOES_MAP.put("XOF", "AFRICA");
    REGIOES_MAP.put("XAF", "AFRICA");
    REGIOES_MAP.put("AOA", "AFRICA");
    REGIOES_MAP.put("MWK", "AFRICA");
    REGIOES_MAP.put("ZMW", "AFRICA");
    REGIOES_MAP.put("BWP", "AFRICA");
    REGIOES_MAP.put("ETB", "AFRICA");
    REGIOES_MAP.put("RWF", "AFRICA");
    REGIOES_MAP.put("TZS", "AFRICA");
    REGIOES_MAP.put("UGX", "AFRICA");
    REGIOES_MAP.put("LYD", "AFRICA");
    REGIOES_MAP.put("SDG", "AFRICA");
    REGIOES_MAP.put("SOS", "AFRICA");
    REGIOES_MAP.put("MUR", "AFRICA");
    REGIOES_MAP.put("SCR", "AFRICA");
    REGIOES_MAP.put("MGA", "AFRICA");
    REGIOES_MAP.put("MRU", "AFRICA");
    REGIOES_MAP.put("CDF", "AFRICA");
    REGIOES_MAP.put("BIF", "AFRICA");
    REGIOES_MAP.put("CVE", "AFRICA");
    REGIOES_MAP.put("DJF", "AFRICA");
    REGIOES_MAP.put("ERN", "AFRICA");
    REGIOES_MAP.put("GMD", "AFRICA");
    REGIOES_MAP.put("GNF", "AFRICA");
    REGIOES_MAP.put("LSL", "AFRICA");
    REGIOES_MAP.put("LRD", "AFRICA");
    REGIOES_MAP.put("MZN", "AFRICA");
    REGIOES_MAP.put("NAD", "AFRICA");
    REGIOES_MAP.put("SLL", "AFRICA");
    REGIOES_MAP.put("SSP", "AFRICA");
    REGIOES_MAP.put("STN", "AFRICA");
    REGIOES_MAP.put("SZL", "AFRICA");
    REGIOES_MAP.put("ZWL", "AFRICA");
  }

  // --- 2. DADOS BRUTOS (COMPLETOS) ---
  private static final String DADOS_MOEDAS = "AED;UAE Dirham;United Arab Emirates\n" +
      "AFN;Afghan Afghani;Afghanistan\n" +
      "ALL;Albanian Lek;Albania\n" +
      "AMD;Armenian Dram;Armenia\n" +
      "ANG;Netherlands Antillian Guilder;Netherlands Antilles\n" +
      "AOA;Angolan Kwanza;Angola\n" +
      "ARS;Argentine Peso;Argentina\n" +
      "AUD;Australian Dollar;Australia\n" +
      "AWG;Aruban Florin;Aruba\n" +
      "AZN;Azerbaijani Manat;Azerbaijan\n" +
      "BAM;Bosnia and Herzegovina Mark;Bosnia and Herzegovina\n" +
      "BBD;Barbados Dollar;Barbados\n" +
      "BDT;Bangladeshi Taka;Bangladesh\n" +
      "BGN;Bulgarian Lev;Bulgaria\n" +
      "BHD;Bahraini Dinar;Bahrain\n" +
      "BIF;Burundian Franc;Burundi\n" +
      "BMD;Bermudian Dollar;Bermuda\n" +
      "BND;Brunei Dollar;Brunei\n" +
      "BOB;Bolivian Boliviano;Bolivia\n" +
      "BRL;Brazilian Real;Brazil\n" +
      "BSD;Bahamian Dollar;Bahamas\n" +
      "BTN;Bhutanese Ngultrum;Bhutan\n" +
      "BWP;Botswana Pula;Botswana\n" +
      "BYN;Belarusian Ruble;Belarus\n" +
      "BZD;Belize Dollar;Belize\n" +
      "CAD;Canadian Dollar;Canada\n" +
      "CDF;Congolese Franc;Democratic Republic of the Congo\n" +
      "CHF;Swiss Franc;Switzerland\n" +
      "CLP;Chilean Peso;Chile\n" +
      "CNY;Chinese Renminbi;China\n" +
      "COP;Colombian Peso;Colombia\n" +
      "CRC;Costa Rican Colon;Costa Rica\n" +
      "CUP;Cuban Peso;Cuba\n" +
      "CVE;Cape Verdean Escudo;Cape Verde\n" +
      "CZK;Czech Koruna;Czech Republic\n" +
      "DJF;Djiboutian Franc;Djibouti\n" +
      "DKK;Danish Krone;Denmark\n" +
      "DOP;Dominican Peso;Dominican Republic\n" +
      "DZD;Algerian Dinar;Algeria\n" +
      "EGP;Egyptian Pound;Egypt\n" +
      "ERN;Eritrean Nakfa;Eritrea\n" +
      "ETB;Ethiopian Birr;Ethiopia\n" +
      "EUR;Euro;European Union\n" +
      "FJD;Fiji Dollar;Fiji\n" +
      "FKP;Falkland Islands Pound;Falkland Islands\n" +
      "FOK;Faroese Króna;Faroe Islands\n" +
      "GBP;Pound Sterling;United Kingdom\n" +
      "GEL;Georgian Lari;Georgia\n" +
      "GGP;Guernsey Pound;Guernsey\n" +
      "GHS;Ghanaian Cedi;Ghana\n" +
      "GIP;Gibraltar Pound;Gibraltar\n" +
      "GMD;Gambian Dalasi;The Gambia\n" +
      "GNF;Guinean Franc;Guinea\n" +
      "GTQ;Guatemalan Quetzal;Guatemala\n" +
      "GYD;Guyanese Dollar;Guyana\n" +
      "HKD;Hong Kong Dollar;Hong Kong\n" +
      "HNL;Honduran Lempira;Honduras\n" +
      "HRK;Croatian Kuna;Croatia\n" +
      "HTG;Haitian Gourde;Haiti\n" +
      "HUF;Hungarian Forint;Hungary\n" +
      "IDR;Indonesian Rupiah;Indonesia\n" +
      "ILS;Israeli New Shekel;Israel\n" +
      "IMP;Manx Pound;Isle of Man\n" +
      "INR;Indian Rupee;India\n" +
      "IQD;Iraqi Dinar;Iraq\n" +
      "IRR;Iranian Rial;Iran\n" +
      "ISK;Icelandic Króna;Iceland\n" +
      "JEP;Jersey Pound;Jersey\n" +
      "JMD;Jamaican Dollar;Jamaica\n" +
      "JOD;Jordanian Dinar;Jordan\n" +
      "JPY;Japanese Yen;Japan\n" +
      "KES;Kenyan Shilling;Kenya\n" +
      "KGS;Kyrgyzstani Som;Kyrgyzstan\n" +
      "KHR;Cambodian Riel;Cambodia\n" +
      "KID;Kiribati Dollar;Kiribati\n" +
      "KMF;Comorian Franc;Comoros\n" +
      "KRW;South Korean Won;South Korea\n" +
      "KWD;Kuwaiti Dinar;Kuwait\n" +
      "KYD;Cayman Islands Dollar;Cayman Islands\n" +
      "KZT;Kazakhstani Tenge;Kazakhstan\n" +
      "LAK;Lao Kip;Laos\n" +
      "LBP;Lebanese Pound;Lebanon\n" +
      "LKR;Sri Lanka Rupee;Sri Lanka\n" +
      "LRD;Liberian Dollar;Liberia\n" +
      "LSL;Lesotho Loti;Lesotho\n" +
      "LYD;Libyan Dinar;Libya\n" +
      "MAD;Moroccan Dirham;Morocco\n" +
      "MDL;Moldovan Leu;Moldova\n" +
      "MGA;Malagasy Ariary;Madagascar\n" +
      "MKD;Macedonian Denar;North Macedonia\n" +
      "MMK;Burmese Kyat;Myanmar\n" +
      "MNT;Mongolian Tögrög;Mongolia\n" +
      "MOP;Macanese Pataca;Macau\n" +
      "MRU;Mauritanian Ouguiya;Mauritania\n" +
      "MUR;Mauritian Rupee;Mauritius\n" +
      "MVR;Maldivian Rufiyaa;Maldives\n" +
      "MWK;Malawian Kwacha;Malawi\n" +
      "MXN;Mexican Peso;Mexico\n" +
      "MYR;Malaysian Ringgit;Malaysia\n" +
      "MZN;Mozambican Metical;Mozambique\n" +
      "NAD;Namibian Dollar;Namibia\n" +
      "NGN;Nigerian Naira;Nigeria\n" +
      "NIO;Nicaraguan Córdoba;Nicaragua\n" +
      "NOK;Norwegian Krone;Norway\n" +
      "NPR;Nepalese Rupee;Nepal\n" +
      "NZD;New Zealand Dollar;New Zealand\n" +
      "OMR;Omani Rial;Oman\n" +
      "PAB;Panamanian Balboa;Panama\n" +
      "PEN;Peruvian Sol;Peru\n" +
      "PGK;Papua New Guinean Kina;Papua New Guinea\n" +
      "PHP;Philippine Peso;Philippines\n" +
      "PKR;Pakistani Rupee;Pakistan\n" +
      "PLN;Polish Złoty;Poland\n" +
      "PYG;Paraguayan Guaraní;Paraguay\n" +
      "QAR;Qatari Riyal;Qatar\n" +
      "RON;Romanian Leu;Romania\n" +
      "RSD;Serbian Dinar;Serbia\n" +
      "RUB;Russian Ruble;Russia\n" +
      "RWF;Rwandan Franc;Rwanda\n" +
      "SAR;Saudi Riyal;Saudi Arabia\n" +
      "SBD;Solomon Islands Dollar;Solomon Islands\n" +
      "SCR;Seychellois Rupee;Seychelles\n" +
      "SDG;Sudanese Pound;Sudan\n" +
      "SEK;Swedish Krona;Sweden\n" +
      "SGD;Singapore Dollar;Singapore\n" +
      "SHP;Saint Helena Pound;Saint Helena\n" +
      "SLE;Sierra Leonean Leone;Sierra Leone\n" +
      "SOS;Somali Shilling;Somalia\n" +
      "SRD;Surinamese Dollar;Suriname\n" +
      "SSP;South Sudanese Pound;South Sudan\n" +
      "STN;São Tomé and Príncipe Dobra;São Tomé and Príncipe\n" +
      "SYP;Syrian Pound;Syria\n" +
      "SZL;Eswatini Lilangeni;Eswatini\n" +
      "THB;Thai Baht;Thailand\n" +
      "TJ;Tajikistani Somoni;Tajikistan\n" +
      "TMT;Turkmenistan Manat;Turkmenistan\n" +
      "TND;Tunisian Dinar;Tunisia\n" +
      "TOP;Tongan Paʻanga;Tonga\n" +
      "TRY;Turkish Lira;Turkey\n" +
      "TTD;Trinidad and Tobago Dollar;Trinidad and Tobago\n" +
      "TVD;Tuvaluan Dollar;Tuvalu\n" +
      "TWD;New Taiwan Dollar;Taiwan\n" +
      "TZS;Tanzanian Shilling;Tanzania\n" +
      "UAH;Ukrainian Hryvnia;Ukraine\n" +
      "UGX;Ugandan Shilling;Uganda\n" +
      "USD;United States Dollar;United States\n" +
      "UYU;Uruguayan Peso;Uruguay\n" +
      "UZS;Uzbekistani So'm;Uzbekistan\n" +
      "VES;Venezuelan Bolívar Soberano;Venezuela\n" +
      "VND;Vietnamese Đồng;Vietnam\n" +
      "VUV;Vanuatu Vatu;Vanuatu\n" +
      "WST;Samoan Tālā;Samoa\n" +
      "XAF;Central African CFA Franc;CEMAC\n" +
      "XCD;East Caribbean Dollar;Organisation of Eastern Caribbean States\n" +
      "XDR;Special Drawing Rights;International Monetary Fund\n" +
      "XOF;West African CFA franc;CFA\n" +
      "XPF;CFP Franc;Collectivités d'Outre-Mer\n" +
      "YER;Yemeni Rial;Yemen\n" +
      "ZAR;South African Rand;South Africa\n" +
      "ZMW;Zambian Kwacha;Zambia\n" +
      "ZWL;Zimbabwean Dollar;Zimbabwe";

  /**
   * Exibe a tabela de moedas, opcionalmente filtrada por região.
   * 
   * @param dados        A string completa de dados da moeda.
   * @param filtroRegiao O código da região (ex: "AMERICA_SUL"). Use "TODAS" para
   *                     não filtrar.
   */
  public static void exibirMoedas(String dados, String filtroRegiao) {
    String formatoLinha = "| %-4s | %-35s | %-40s |%n";
    String separador = "+------+-------------------------------------+------------------------------------------+%n";

    String titulo = filtroRegiao.equalsIgnoreCase("TODAS") ? "TODAS AS MOEDAS" : filtroRegiao.replace('_', ' ');

    System.out.println("\n--- Códigos de Moeda disponíveis (" + titulo + ") ---");
    System.out.printf(separador);
    System.out.printf(formatoLinha, "Code", "Nome da Moeda", "País/Organização");
    System.out.printf(separador);

    // Processamento da String
    String[] linhas = dados.split("\n");

    for (String linha : linhas) {
      linha = linha.trim();
      if (linha.isEmpty())
        continue;

      String[] partes = linha.split(";", 3);

      if (partes.length < 3)
        continue;

      String codigo = partes[0].trim();
      String nomeMoeda = partes[1].trim();
      String pais = partes[2].trim();

      // Lógica de FILTRO
      // Pega a região do mapa, ou "OUTRAS" se não estiver mapeada
      String regiaoDaMoeda = REGIOES_MAP.getOrDefault(codigo, "OUTRAS");

      boolean deveExibir = filtroRegiao.equalsIgnoreCase("TODAS") ||
          filtroRegiao.equalsIgnoreCase(regiaoDaMoeda);

      if (deveExibir) {
        System.out.printf(formatoLinha, codigo, nomeMoeda, pais);
      }
    }
    System.out.printf(separador);
  }

  /**
   * Versão simplificada que exibe todas as moedas
   */
  public static void exibirMoedas(String dados) {
    exibirMoedas(dados, "TODAS");
  }

  /**
   * Retorna a string completa de dados para o processamento.
   */
  public static String getDadosMoedas() {
    return DADOS_MOEDAS;
  }

  /**
   * Retorna as opções de filtro para o menu no App.java.
   */
  public static String[] getOpcoesRegiao() {
    return new String[] {
        "TODAS",
        "AMERICA_NORTE",
        "AMERICA_SUL",
        "EUROPA",
        "ASIA",
        "AFRICA",
        "OUTRAS" // Moedas não mapeadas em nenhuma das regiões acima
    };
  }

  public static MoedasSuportadas getMoedasOffline() {
    List<List<String>> listaMoedas = new ArrayList<>();

    String[] linhas = DADOS_MOEDAS.split("\n");

    for (String linha : linhas) {
      linha = linha.trim();
      if (!linha.isEmpty())
        continue;

      String[] partes = linha.split(";", 3);
      if (partes.length < 3)
        continue;

      String codigo = partes[0].trim();
      String nomeMoeda = partes[1].trim();

      // Cria uma lista [código, nome] como a API retorna
      List<String> par = new ArrayList<>();
      par.add(codigo);
      par.add(nomeMoeda);

      listaMoedas.add(par);
    }

    // Retorna um objeto MoedasSuportadas simulando a resposta da API
    return new MoedasSuportadas("success", listaMoedas);
  }
}
