package modelo;

public class Refugio{

private Animal[] animales;
private double precioKg;
private int registrados;
private boolean creado;


public Refugio(){
    this.precioKg = 3.0;
    this.creado = false;
}

public void crearRegistro(int capacidad){

    this.animales = new Animal[capacidad];
    this.registrados = 0;
    this.creado = true;
}
 public boolean estaCreado(){
    return creado;    
 }

 public boolean estaLLeno(){

     if(!creado){
        return false;
     }
    
    if(registrados == animales.length){
        return true;
    }

    return false;
    
    
    }
    
    public boolean estaVacio(){
        if(!creado){
            return true;
        }
        
        if(registrados == 0){
            return true;
        }
        return false;

    }



    public int getRegistrados (){
        return registrados;
    }


    public int getCapacidad (){
        if(!creado){
            return 0;
        }
        return animales.length;
    }

    public double getPrecioKg(){
        return precioKg;
    }

    public boolean isPrecioConfigurado(){
        if(precioKg >0){
            return true;
        }
        return false;
    }

    public void setPrecioKg(double precioKg){
        this.precioKg = precioKg;
    }

    public boolean agregarAnimal(Animal animal){

        if(animal == null || !estaCreado() || estaLLeno()){
            return false;
        }

        for(int i = 0; i< animales.length; i++){

            if(animales[i] == null){
                animales[i] = animal;
                registrados++;
                return true;
            }
        }
        return false;


        }

        public Animal getAnimal(int posicion){
            if(!estaCreado() || posicion < 0 || posicion >= animales.length){
                return null;
            }
            return animales[posicion];
    }


        public double costeTotalDiario(){
            double total = 0;
            if(!estaCreado()){
                return 0;
            }


            for (int i = 0 ; i<animales.length; i++){
                if(animales[i] != null){
                    total += animales[i].costeDiario(precioKg);
                }
            }
            return total;
        }

        public double pesoMedio(){
            if(!estaCreado()){
                return 0;
            }

        double suma = 0;
        int contador = 0;
        double medio = 0;
        for(int i = 0; i < animales.length; i++){

            if(animales[i] != null){
                suma += animales[i].getPesoKg();
                contador ++;
            }

        }
        if(contador > 0){
        medio = suma / contador;
        return medio;
        }

        return medio;

        }

}