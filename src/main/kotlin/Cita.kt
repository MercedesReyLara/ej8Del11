class Cita(var numCita:Int, var horaCita:Int, var diaCita:Int,var acudio:Boolean,var llamada:Boolean) {
    fun eliminar(){
        if(llamada){
            cit.remove(this)
        }
    }
}