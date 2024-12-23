// Importa a função 'pow' para cálculo de potência
import kotlin.math.pow

// Função principal do programa
fun main() {
    // Valor inicial do investimento
    val investimentoInicial = 4000.0
    // Período de investimento em anos
    val anos = 3

    // Taxas de rendimento anuais
    val taxaSelicAnual = 0.1225 // 12,25% ao ano
    val taxaCDBAnual = 0.13     // Exemplo: 13% ao ano
    val percentualCDI = 1.0     // 100% do CDI (considerando CDI igual à Selic)

    // Cálculo dos rendimentos
    val rendimentoPoupanca = calcularRendimentoPoupanca(investimentoInicial, anos)
    val rendimentoCDB = calcularRendimentoCDB(investimentoInicial, anos, taxaCDBAnual)
    val rendimentoTesouroDireto = calcularRendimentoTesouroDireto(investimentoInicial, anos, taxaSelicAnual)

    // Exibe os resultados
    println("Após $anos anos:")
    println("Poupança: R$ %.2f".format(rendimentoPoupanca))
    println("CDB: R$ %.2f".format(rendimentoCDB))
    println("Tesouro Direto: R$ %.2f".format(rendimentoTesouroDireto))
}

// Função para calcular o rendimento da Poupança
fun calcularRendimentoPoupanca(principal: Double, anos: Int): Double {
    // Taxa mensal da poupança (0,5% ao mês)
    val taxaMensal = 0.005
    // Número total de meses
    val meses = anos * 12
    // Fórmula de juros compostos: M = P * (1 + r)^n
    return principal * (1 + taxaMensal).pow(meses)
}

// Função para calcular o rendimento do CDB
fun calcularRendimentoCDB(principal: Double, anos: Int, taxaAnual: Double): Double {
    // Fórmula de juros compostos: M = P * (1 + r)^n
    val montanteBruto = principal * (1 + taxaAnual).pow(anos)
    // Imposto de Renda: 15% para investimentos acima de 2 anos
    val imposto = 0.15
    // Rendimento líquido após imposto
    return principal + (montanteBruto - principal) * (1 - imposto)
}

// Função para calcular o rendimento do Tesouro Direto (Tesouro Selic)
fun calcularRendimentoTesouroDireto(principal: Double, anos: Int, taxaAnual: Double): Double {
    // Taxa de custódia da B3: 0,20% ao ano
    val taxaCustodia = 0.002
    // Taxa líquida anual após descontar a taxa de custódia
    val taxaLiquidaAnual = taxaAnual - taxaCustodia
    // Fórmula de juros compostos: M = P * (1 + r)^n
    val montanteBruto = principal * (1 + taxaLiquidaAnual).pow(anos)
    // Imposto de Renda: 15% para investimentos acima de 2 anos
    val imposto = 0.15
    // Rendimento líquido após imposto
    return principal + (montanteBruto - principal) * (1 - imposto)
}
