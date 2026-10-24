package modelo;


public class Animal {
    private final String nombre;
    private final String especie;
    private final double pesoKg;
    private final double consumoKg;
    private final Cuidador cuidador ;


    public Animal(String nombre, String especie, dobule pesoKg, double consumoKg, Cuidador cuidador){
        this.nombre = nombre;
        this.especie = especie;
        this.pesoKg = pesoKg;
        this.consumoKg = consumoKg;
        this.cuidador = cuidador;
    }

public String getNombre(){
    return nombre;
}

public String getEspecie(){
    return especie;
}

public double getPesoKg(){
    return pesoKg;
}

public double getConsumoKg(){
    return consumoKg;
}

public Cuidador getCuidador(){
    return cuidador;
}

public double costeDiario(double precioKg) {
    return consumoKg * precioKg;
}
}