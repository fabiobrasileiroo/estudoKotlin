// Importa a função 'pow' para cálculo de potência
import kotlin.math.pow
fun main() {
    val investimentoInicial = 4000.0
    val anos = 3.0

    val taxaSelicAnual = 0.1225
    val adicionalTesouroSelic = 0.0005
    val percentualCDI = 1.02
    val taxaCDIAnual = 0.1225

    val rendimentoTesouroSelic = calcularRendimentoTesouroSelic(investimentoInicial, anos, taxaSelicAnual, adicionalTesouroSelic)
    val rendimentoCDB = calcularRendimentoCDB(investimentoInicial, anos, percentualCDI, taxaCDIAnual)

    println("Após %.0f anos:".format(anos))
    println("Tesouro Selic 2027: R$ %.2f".format(rendimentoTesouroSelic))
    println("CDB Banco Inter 102%% do CDI: R$ %.2f".format(rendimentoCDB))
}

fun calcularRendimentoTesouroSelic(principal: Double, anos: Double, taxaSelicAnual: Double, adicionalAnual: Double): Double {
    val taxaAnual = taxaSelicAnual + adicionalAnual
    val taxaMensal = (1 + taxaAnual).pow(1.0 / 12) - 1
    val meses = (anos * 12).toInt()
    val montanteBruto = principal * (1 + taxaMensal).pow(meses)
    val rendimentoBruto = montanteBruto - principal
    val aliquotaIR = when {
        anos <= 0.5 -> 0.225
        anos <= 1 -> 0.20
        anos <= 2 -> 0.175
        else -> 0.15
    }
    val impostoDeRenda = rendimentoBruto * aliquotaIR
    return montanteBruto - impostoDeRenda
}

fun calcularRendimentoCDB(principal: Double, anos: Double, percentualCDI: Double, taxaCDIAnual: Double): Double {
    val taxaCDBAnual = taxaCDIAnual * percentualCDI
    val taxaCDBMensal = (1 + taxaCDBAnual).pow(1.0 / 12) - 1
    val meses = (anos * 12).toInt()
    val montanteBruto = principal * (1 + taxaCDBMensal).pow(meses)
    val rendimentoBruto = montanteBruto - principal
    val aliquotaIR = when {
        anos <= 0.5 -> 0.225
        anos <= 1 -> 0.20
        anos <= 2 -> 0.175
        else -> 0.15
    }
    val impostoDeRenda = rendimentoBruto * aliquotaIR
    return montanteBruto - impostoDeRenda
}
