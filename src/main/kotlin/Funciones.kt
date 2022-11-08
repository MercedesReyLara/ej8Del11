var cit= mutableListOf<Cita>()
fun pedirCita() {
    do {
        println("***BIENVENIDO AL MENÚ DE CITAS***")
        println("OPCIONES: ")
        println("1)Pedir cita")
        println("2)Ver calendario")
        print("ESCOJA UNA OPCION: ")
        var tmp1:Int?=readLine()?.toIntOrNull()
        var op:Int=tmp1?:0
        if(op==1) {
            print("ESCOJA DIA DE LA CITA: ")
            var tmp: Int? = readLine()?.toIntOrNull()
            var dia: Int = tmp ?: 1
            if (dia > 31 || dia < 1) {
                println("DIA NO DISPONIBLE.VOLVIENDO AL MENU")
            } else {
                println("***ABRIMOS A LAS 9 Y CERRAMOS A LAS 21***")
                    print("ESCOJA HORA DE LA CITA: ")
                    var tmp2: Int? = readLine()?.toIntOrNull()
                    var hora: Int = tmp2 ?: 1
                if (hora < 9 || hora >= 21) {
                    println("HORA NO DISPONIBLE, NO ESTAMOS ABIERTOS.VOLVIENDO AL MENU")
                } else
                            print("Esta es su cita: dia $dia, hora $hora")
                            print("¿Desea confirmar la cita(S/N)?")
                            var a:String?=readLine()
                            var r:String=a.toString()
                            if(a=="S"){
                                var num: Int = (Math.random()*10000+1).toInt()
                                for(cits in cit){
                                    if(dia==cits.diaCita && hora==cits.horaCita){
                                        println("Ya hay una cita existente con ese dia y hora")
                                        /*print("¿Desea cambiar la hora(S/N)? ")
                                        var c:String?=readLine()
                                        var ca:String=c.toString()
                                        if(ca=="S"){
                                            println("***ABRIMOS A LAS 9 Y CERRAMOS A LAS 21***")
                                            print("ESCOJA HORA DE LA CITA: ")
                                            var tmp2: Int? = readLine()?.toIntOrNull()
                                            var hora: Int = tmp2 ?: 1
                                            if (hora < 9 || hora >= 21) {
                                                println("HORA NO DISPONIBLE, NO ESTAMOS ABIERTOS.VOLVIENDO AL MENU")
                                        }
                                    }*/
                                    }else{
                                        var cita = Cita(num, dia, hora)
                                        cit.add(cita)
                                        break
                                }

                            }

                    }
                }
        }else if(op==2){
                    for (cits in cit) {
                        println("CITA NUM:${cits.numCita}")
                        println("Dia de la cita:${cits.diaCita};Hora de la cita:${cits.horaCita}")
                    }
        }else{
            println("OPCIÓN NO DISPONIBLE")
        }
        var salir:Boolean=false
        print("Desea seguir haciendo operaciones(S/N)? ")
        var tmp3:String?=readLine()
        var resp:String=tmp3.toString()
        if(resp=="N"){
            salir=true
        }
    }while(!salir)
}