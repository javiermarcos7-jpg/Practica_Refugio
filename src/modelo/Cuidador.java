package modelo;

public class Cuidador{

private final String nombre;
private final String apellidos;
private final boolean formacion;

public Cuidador(String nombre, String apellidos, boolean formacion){

this.nombre = nombre;
this.apellidos = apellidos;
this.formacion = formacion;

}

public String getNombre(){
    return nombre;
}
public String getApellidos(){
    return apellidos;
}

public String getNombreCompleto (){
    return nombre + " " + apellidos;
}

public boolean Formacion() {
    return formacion;
}








}