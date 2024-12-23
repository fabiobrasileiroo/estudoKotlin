fun main() {

  idadePessoa()
  doideira()
  verificacaoDeIdade(nome ="fabio",idade = 22, isAdmin = false)
}

fun doideira() = println("Isso é doido mesmo")

fun idadePessoa() {

  val idade = 32

  if(idade < 18)  println("Menor de idade")

  else 
    println("É maior de idade")
}

fun verificacaoDeIdade(idade: Int, nome:String,isAdmin: Boolean) {
  val admin = if(isAdmin == true) "sou Admin dono da porra toda" else "sou zé ninguem"
  println("minha idade é $idade, meu nome é $nome e $admin")
  if(idade > 16) {
    println("Pode dirigir")
  } else {
    println("nao pode dirigir")
  }
}

 