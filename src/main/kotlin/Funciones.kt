import java.awt.List
import java.lang.Exception

var cit= mutableListOf<Cita>()
fun pedirCita() {
    do {
        println("***BIENVENIDO AL MENÚ DE CITAS***")
        println("Este es el calendario de citas")
        println("ESTE ES EL CALENDARIO")
        if(cit.size==0){
            println("No hay citas")
        }else {
            for (cia in cit ){
                if (!(cia.acudio)) {
                    println("CITA NUM:${cia.numCita}")
                    println("Dia de la cita:${cia.diaCita};Hora de la cita:${cia.horaCita}")
                }
            }
        }
        println("OPCIONES: ")
        println("1)Pedir cita")
        println("2)Actualizar calendario")
        println("3)Salir")
        print("ESCOJA UNA OPCION: ")
        var tmp1: Int? = readLine()?.toIntOrNull()
        var op: Int = tmp1 ?: 0
        if (op == 1) {
            print("ESCOJA DIA DE LA CITA: ")
            var tmp: Int? = readLine()?.toIntOrNull()
            var dia: Int = tmp ?: 1
            println(dia)
            if (dia > 31 || dia < 1) {
                println("DIA NO DISPONIBLE.VOLVIENDO AL MENU")
                break
            } else {
                println("***ABRIMOS A LAS 9 Y CERRAMOS A LAS 21***")
                print("ESCOJA HORA DE LA CITA: ")
                var tmp2: Float? = readLine()?.toFloatOrNull()
                var hora: Float = tmp2 ?: 1F
                if (hora < 9 || hora >= 21) {
                    println("HORA NO DISPONIBLE, NO ESTAMOS ABIERTOS.VOLVIENDO AL MENU")
                    break
                } else {
                    println("Esta es su cita: dia $dia, hora $hora")
                    print("¿Desea confirmar la cita(S/N)?")
                    var a: String? = readLine()
                    var r: String = a.toString()
                    if (r == "S" || r=="s" || r=="si" || r=="SI" || r=="Si"|| r=="1") {
                        for (cits in cit) {
                            if (dia == cits.diaCita && hora == cits.horaCita) {
                                println("Ya hay una cita existente con ese dia y hora")
                                break
                            }
                        }
                        print("CITA ENVIADA A LA OFICINA")
                        var num: Int = (Math.random() * 10000 + 1).toInt()
                        var cita = Cita(num, hora, dia)
                        println("DATOS DE LA CITA: La cita es el día ${cita.diaCita} a las ${cita.horaCita}")
                        print("¿Hola administrador, desea confirmar esta cita(S/N)?")
                        var r: String? = readLine()
                        var a: String = r.toString()
                        if (a == "S"|| a=="s" || a=="si" || a=="SI" || a=="Si"|| a=="1") {
                            cit.add(cita)
                        } else {
                            println("Cita denegada")
                            break
                        }

                    } else {
                        println("VOLVIENDO AL MENÚ")
                    }
                }
            }
        } else if (op == 2) {
            for (c in cit) {
                if (!(c.acudio)) {
                    println("Cita del dia ${c.diaCita}")
                    print("¿Acudio a la cita o se le paso el plazo?")
                    var tmp9: String? = readLine()
                    var oc: String = tmp9.toString()
                    if (oc == "S" || oc == "s" || oc == "si" || oc == "SI" || oc == "Si" || oc == "1") {
                            c.acudio = true
                    }
                }
            }
        } else if(op==3) {
           return
        }else{
            println("OPCIÓN NO DISPONIBLE")
        }
        var salir: Boolean = false
        print("Desea seguir haciendo operaciones(S/N)? ")
        var tmp3: String? = readLine()
        var resp: String = tmp3.toString()
        if (resp == "N") {
            salir = true
        }
    } while (!salir)
}
