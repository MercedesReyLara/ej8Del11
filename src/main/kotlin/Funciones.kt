var cit= mutableListOf<Cita>()
fun pedirCita() {
    do {
        println("***BIENVENIDO AL MENÚ DE CITAS***")
        println("OPCIONES: ")
        println("1)Pedir cita")
        println("3)Ver y gestionar calendario de citas")
        print("ESCOJA UNA OPCION: ")
        var tmp1:Int?=readLine()?.toIntOrNull()
        var op:Int=tmp1?:0
        if(op==1) {
            print("ESCOJA DIA DE LA CITA: ")
            var tmp: Int? = readLine()?.toIntOrNull()
            var dia: Int = tmp ?: 1
            if (dia > 31 || dia < 1) {
                println("DIA NO DISPONIBLE.VOLVIENDO AL MENU")
                break
            } else {
                println("***ABRIMOS A LAS 9 Y CERRAMOS A LAS 21***")
                print("ESCOJA HORA DE LA CITA: ")
                var tmp2: Int? = readLine()?.toIntOrNull()
                var hora: Int = tmp2 ?: 1
                if (hora < 9 || hora >= 21) {
                    println("HORA NO DISPONIBLE, NO ESTAMOS ABIERTOS.VOLVIENDO AL MENU")
                    break
                } else {
                    println("Esta es su cita: dia $dia, hora $hora")
                    print("¿Desea confirmar la cita(S/N)?")
                    var a: String? = readLine()
                    var r: String = a.toString()
                    if (a == "S") {
                        for (cits in cit) {
                            if (dia == cits.diaCita && hora == cits.horaCita) {
                                println("Ya hay una cita existente con ese dia y hora")
                                break
                            }
                        }
                            print("CITA ENVIADA A LA OFICINA")
                        var num: Int = (Math.random() * 10000 + 1).toInt()
                            var cita = Cita(num, hora, dia,true,false)
                            println("DATOS DE LA CITA: La cita es el día ${cita.diaCita} a las ${cita.horaCita}")
                            print("¿Hola administrador, desea confirmar esta cita(S/N)?")
                            var r: String? = readLine()
                            var a: String = r.toString()
                            if (a == "S") {
                                cit.add(cita)
                            } else {
                                println("Cita denegada")
                                break
                            }

                        }else{
                            println("VOLVIENDO AL MENÚ")
                    }
                    }
                }
        }else if(op==2){
            if(cit.size==0) {
                println("No hay citas en la lista")
            }else{
                for (cits in cit) {
                    println("CITA NUM:${cits.numCita}")
                    println("Dia de la cita:${cits.diaCita};Hora de la cita:${cits.horaCita}")
                }

            }
        }else if(op==3){
            if(cit.size==0){
                println("No hay citas")
            }else {
                println("ESTE ES EL CALENDARIO")
                for ((cits,cia) in cit.withIndex()) {
                    var i:Int=cits
                    println("CITA NUM:${cia.numCita}")
                    println("Dia de la cita:${cia.diaCita};Hora de la cita:${cia.horaCita}")
                        println("¿Acudió a la cita?")
                        var x: String? = readLine()
                        var a: String = x.toString()
                        if (a == "S") {
                            println("Eliminando de la lista")

                        } else {
                            if (!cia.llamada) {
                            println("Haciendo una llamada para confirmar que va a venir")
                            cia.llamada = true
                            }else{
                                println("No respondió a la llamada, lo eliminaremos de la lista")
                                cia.eliminar()
                            }
                        }
                }
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
