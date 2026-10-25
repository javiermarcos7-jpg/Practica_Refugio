
import java.util.Scanner;
import modelo.Animal;
import modelo.Cuidador;
import modelo.Refugio;

public class App {
   
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Refugio refugio = new Refugio();
        
        int opcion = 0;

        do {
            // Imprimir el menú de la práctica[cite: 1]
            System.out.println("\nGESTIÓN DEL REFUGIO");
            System.out.println("1) Crear un nuevo registro de animales");
            System.out.println("2) Configurar el precio del alimento por kg");
            System.out.println("3) Añadir un nuevo animal al refugio");
            System.out.println("4) Mostrar información de los animales");
            System.out.println("5) Salir (se borrará toda la información)");
            System.out.print("Seleccione una opción (1-5): ");

            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {

                            case 1:
                                            
                                if (refugio.estaCreado()) {
                                    System.out.println("¡Atención! Ya existe un registro. Si creas uno nuevo se perderá la información anterior.");
                                    int confirmacion = 0;
                                
                                    while (confirmacion != 1 && confirmacion != 2) {
                                    System.out.print("¿Deseas continuar? (1: Sí / 2: No): ");
                                    if (scanner.hasNextInt()) {
                                        confirmacion = scanner.nextInt();
                                        scanner.nextLine();
                                        if (confirmacion != 1 && confirmacion != 2) {
                                            System.out.println("Por favor, introduce 1 o 2.");
                                        }
                                    } else {
                                        System.out.println("Error: Debes introducir un número (1 o 2).");
                                        scanner.nextLine(); 
                                    }
                                }
                                
                                        if (confirmacion == 2) {
                                        System.out.println("Operación cancelada.");
                                    break;
                                    }
                            }   

                            
                                int capacidad = 0;
                                    while (capacidad <= 0) {
                                        System.out.print("Introduce la capacidad del refugio (mayor que 0): ");
                                        if (scanner.hasNextInt()) {
                                        capacidad = scanner.nextInt();
                                        scanner.nextLine();
                                            if (capacidad <= 0) {
                                            System.out.println("La capacidad debe ser mayor que cero.");
                                        }
                                        } else {
                                            System.out.println("Error: Debes introducir un número entero válido.");
                                        scanner.nextLine();
                                    }
                                }

                                    refugio.crearRegistro(capacidad);
                                    System.out.println("Registro creado con éxito para " + capacidad + " animales.");
                                    break;
                            
                            case 2:
                                    double nuevoPrecio = 0;
                                    while (nuevoPrecio <= 0) {
                                        System.out.print("Introduce el nuevo precio del alimento por kg (mayor que 0): ");
                                                if (scanner.hasNextDouble()) {
                                                    nuevoPrecio = scanner.nextDouble();
                                                        if (nuevoPrecio <= 0) {
                                                            System.out.println("El precio debe ser un número mayor que cero.");
                                                    }
                                                } else {
                                                    System.out.println("Error: Debes introducir un número válido.");
                                            }
                                            scanner.nextLine(); 
                            }

                                refugio.setPrecioKg(nuevoPrecio);
                                System.out.println("Precio del alimento configurado correctamente a " + nuevoPrecio + " €/kg.");
                                break;
        
                        
                


                            case 3:

                                    if (!refugio.estaCreado()) {
                                        System.out.println("Error: Primero debes crear el registro del refugio (Opción 1).");
                                        break;
                                    }

                                    
                                    if (refugio.estaLLeno()) {
                                        System.out.println("Error: El refugio está lleno. No se pueden registrar más animales.");
                                        break;
                                    }

                                    
                                    System.out.println("\n--- DATOS DEL CUIDADOR ---");
                                    System.out.print("Nombre del cuidador: ");
                                    String nombreCuidador = scanner.nextLine();

                                    System.out.print("Apellidos del cuidador: ");
                                    String apellidosCuidador = scanner.nextLine();

                                    int opcionFormacion = 0;
                                    while (opcionFormacion != 1 && opcionFormacion != 2) {
                                        System.out.print("¿Tiene formación en cuidado animal? (1: Sí / 2: No): ");
                                        if (scanner.hasNextInt()) {
                                            opcionFormacion = scanner.nextInt();
                                            if (opcionFormacion != 1 && opcionFormacion != 2) {
                                                System.out.println("Opción no válida. Debes introducir 1 (Sí) o 2 (No).");
                                            }
                                        } else {
                                            System.out.println("Error: Debes introducir un número (1 o 2).");
                                        }
                                        scanner.nextLine(); // Limpiar el buffer
                                    }
                                    boolean formacion;

                                        if (opcionFormacion == 1) {
                                            formacion = true;
                                        } else {
                                            formacion = false;
                                        };

                                    
                                    System.out.println("\n--- DATOS DEL ANIMAL ---");
                                    System.out.print("Nombre del animal: ");
                                    String nombreAnimal = scanner.nextLine();

                                    System.out.print("Especie del animal: ");
                                    String especieAnimal = scanner.nextLine();

                                    double peso = 0;
                                    while (peso <= 0) {
                                        System.out.print("Peso del animal en kg (mayor que 0): ");
                                        if (scanner.hasNextDouble()) {
                                            peso = scanner.nextDouble();
                                            if (peso <= 0) {
                                                System.out.println("El peso debe ser un número mayor que cero.");
                                            }
                                        } else {
                                            System.out.println("Error: Debes introducir un número válido.");
                                        }
                                        scanner.nextLine();
                                    }

                                    double consumo = 0;
                                    while (consumo <= 0) {
                                        System.out.print("Consumo diario de alimento en kg (mayor que 0): ");
                                        if (scanner.hasNextDouble()) {
                                            consumo = scanner.nextDouble();
                                            if (consumo <= 0) {
                                                System.out.println("El consumo debe ser un número mayor que cero.");
                                            }
                                        } else {
                                            System.out.println("Error: Debes introducir un número válido.");
                                        }
                                        scanner.nextLine();
                                    }

                                    
                                    Cuidador nuevoCuidador = new Cuidador(nombreCuidador, apellidosCuidador, formacion);
                                    Animal nuevoAnimal = new Animal(nombreAnimal, especieAnimal, peso, consumo, nuevoCuidador);

                                    refugio.agregarAnimal(nuevoAnimal);
                                    System.out.println("¡Animal '" + nombreAnimal + "' añadido con éxito al refugio!");
                                    break;

                            case 4:
                                // 1. Comprobar que el registro exista
                                if (!refugio.estaCreado()) {
                                    System.out.println("Error: Primero debes crear el registro del refugio (Opción 1).");
                                    break;
                                }

                                // 2. Comprobar si el registro está vacío
                                if (refugio.estaVacio()) {
                                    System.out.println("El registro está vacío. No hay animales para mostrar ni se puede calcular el peso medio.");
                                    break;
                                }

                                // 3. Imprimir la cabecera de la tabla
                                System.out.println("\n-----------------------------------------------------------------------------------------");
                                System.out.println("                                 ANIMALES DEL REFUGIO                                    ");
                                System.out.println("-----------------------------------------------------------------------------------------");
                                System.out.printf("%-12s | %-10s | %-20s | %-9s | %-9s | %-10s | %-9s%n",
                                        "Nombre", "Especie", "Cuidador", "Formación", "Peso (kg)", "Consumo kg", "Coste EUR");
                                System.out.println("-----------------------------------------------------------------------------------------");

                                // 4. Recorrer el array de animales
                                for (int i = 0; i < refugio.getCapacidad(); i++) {
                                    Animal a = refugio.getAnimal(i);
                                    
                                    // Solo mostramos las posiciones que contengan un animal (distintas de null)
                                    if (a != null) {
                                        String formacionTexto = "No";
                                        if (a.getCuidador().Formacion()) {
                                            formacionTexto = "Si";
                                        }

                                        double costeIndividual = a.costeDiario(refugio.getPrecioKg());

                                        System.out.printf("%-12s | %-10s | %-20s | %-9s | %-9.2f | %-10.2f | %-9.2f%n",
                                                a.getNombre(),
                                                a.getEspecie(),
                                                a.getCuidador().getNombreCompleto(),
                                                formacionTexto,
                                                a.getPesoKg(),
                                                a.getConsumoKg(),
                                                costeIndividual);
                                    }
                                }

                                System.out.println("-----------------------------------------------------------------------------------------");

                                // 5. Imprimir los totales globales
                                System.out.printf("Coste diario total de alimentación: %.2f EUR%n", refugio.costeTotalDiario());
                                System.out.printf("Peso medio de los animales: %.2f kg%n", refugio.pesoMedio());
                                System.out.println("-----------------------------------------------------------------------------------------");
                                break;
                    case 5:
                        System.out.println("Saliendo del programa... Se ha borrado la información.");
                        break;
                    default:
                        System.out.println("Opción fuera de rango. Seleccione un número entre 1 y 5.");
                }

            } else {
                
                System.out.println("Error: Debe introducir un número entero válido.");
                scanner.nextLine();
            }

        } while (opcion != 5);

        scanner.close();
    }

    }


