import kotlin.math.*

fun main() {

    val larguraGrafico = 80
    val alturaGrafico = 25
    val grafico = Chart(larguraGrafico, alturaGrafico)

    do{
        println("Introduza a altura inicial(0-5m)")
        var alturaInicial = readLine()!!.toDouble()

        if(alturaInicial<=0.0 || alturaInicial>5.0){
            println("Introduza a altura inicial (0-5m)")
            alturaInicial = readLine()!!.toDouble()
        }

        println("Introduza a velocidade inicial")
        val velocidade = readLine()!!.toDouble()

        println("Introduza o angulo inicial (0-90)")
        var anguloGraus = readLine()!!.toDouble()

        if(anguloGraus<0.0 || anguloGraus>90.0){
            println("Introduza o angulo inicial (0-90)")
            anguloGraus = readLine()!!.toDouble()
        }

        val anguloRadianos = anguloGraus * PI / 180
        val tetta = anguloRadianos

        val v0 = velocidade
        val y0 = alturaInicial
        val g = 9.80
        var x=0.0
        var passouARede: Boolean = false
        var rede=0.00
        var y=y0

        while (  y >= 0.0  ){

            grafico.ponto(x,y)
            x+= 0.25
            y=y0+(tan(tetta)*x)-((g/2)*x.pow(2))/((v0* cos(tetta))).pow(2)

            while (x==5.0 && rede <= 2.25){
                rede+=0.250
                grafico.ponto(5.0,rede)
            }

            if (x == 5.0){
                passouARede = y > 2.5
            }
        }
        grafico.draw()

        if (passouARede){
            if( x>5.0 && x <= 10.0 ){
                println("Marcou ponto, pois X está entre 5 e 10.")
            }
            else{
                println("A bola saiu do campo, pois X>10")
            }
        }
        else{
            println("A bola caiu no campo da própria equipa, pois X está entre 0 e 5")
        }

        println("Pretende outro gráfico (S/N) ")
        val continuar = readLine()

    }while (continuar != "N" && continuar != "n")

}