import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Medicamento[] listaMedicamentos = new Medicamento[500];
        Veterinario[] listaVeterinarios = new Veterinario[50];
        ServicioVeterinario[] listadoServicios = new ServicioVeterinario[50];
        ServicioVeterinario servicioVeterinario;
        IEspecialistaCanino especialistaCanino;
        IEspecialistaFelino especialistaFelino;
        ControlServicio controlServicio = new ControlServicio();
        int cantidadVeterinarios = 0;   
        int cantidadMedicamentos = 0;
        int cantidadPacientes = 0;
        Paciente[] listaPacientes = new Paciente[100];
        Medicamento medicamento;
        Veterinario veterinario;
        Paciente paciente;
        Almacen almacen = new Almacen();   
        int reintentar;

        System.out.println("============================================'SOFTVETER'======================================================");
        System.out.print("Ingrese el nombre de 'Administrador': ");
        String nombreAdministrador = entrada.nextLine();
        System.out.print("Capital en efectivo inicial en caja que desea ingresar: $");
        controlServicio.setDineroCaja(entrada.nextLong());
        do{
            System.out.println("\t1.-Administracion de veterinarios\n\t2.-Gestion de inventario\n\t3.-Servicios\n\t4.-Reportes");
            System.out.print(" Opcion: "); 
            byte opcion = entrada.nextByte();
            switch(opcion){
                case 1:
                    System.out.println("1.-Agregar veterinario\n2.-Modificar Veteterinario");
                    System.out.print(" Opcion: ");
                    opcion = entrada.nextByte();
                    switch(opcion){ 
                        case 1: 
                            do{             
                                veterinario = new Veterinario();
                                entrada.nextLine();
                                System.out.print("Nombre del veterinario: ");
                                veterinario.setNombre(entrada.nextLine());
                                System.out.print("ID del veterinario: ");
                                veterinario.setIdVeterinario(entrada.nextLong());  
                                System.out.print("Num. de telefono del veterinario: ");
                                veterinario.setTelefono(entrada.nextLong());    
                                listaVeterinarios[cantidadVeterinarios] = veterinario;
                                cantidadVeterinarios++; 
                                System.out.println("Se ha agregado el veterinario");
                                System.out.println("Desea ver la lista de veterinarios?\n1.-Si\n2.-No");
                                System.out.print(" Opcion: ");    
                                int respuesta = entrada.nextInt();
                                if(respuesta == 1){
                                    System.out.println("_____________________LISTA DE VETERINARIOS____________________________");
                                    for(int x=0; x<cantidadVeterinarios; x++){
                                        System.out.println("VETERINARIO "+(x+1));
                                        System.out.println("Nombre: "+listaVeterinarios[x].getNombre()+"\nID: "+listaVeterinarios[x].getIdVeterinario()+ "\nNum. telefono: "+listaVeterinarios[x].getTelefono());
                                        System.out.print("\n");
                                    }
                                } 
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("Ingrese un numero diferente de 0 si desea agregar otro veterinario");  
                            reintentar = entrada.nextByte();
                            }while(reintentar!=0);                                     
                        break;
                        case 2:
                            if(cantidadVeterinarios>=1){
                                do{
                                    System.out.println("__________________LISTA DE VETERINARIOS_____________________");
                                    for(int x=0; x<cantidadVeterinarios; x++){
                                        System.out.println("VETERINARIO "+(x+1));
                                        System.out.println("Nombre: "+listaVeterinarios[x].getNombre()+"\nID: "+listaVeterinarios[x].getIdVeterinario()+"\nTelefono: "+listaVeterinarios[x].getTelefono());
                                        System.out.print("\n");
                                    }
                                    System.out.println("_____________________________________________________________");
                                    System.out.print("Ingresa el ID  del veterinario a modificar: ");
                                    long buscarID = entrada.nextLong();
                                    int x=0;
                                    while( x<cantidadVeterinarios && buscarID!=listaVeterinarios[x].getIdVeterinario()){
                                        x++;
                                    }
                                    if(x!=cantidadVeterinarios){                                                                             
                                        System.out.println("Modificacion que desea llevar a cabo: \n1.-Nombre\n2.-ID\n3.-Num. telefono");
                                        System.out.print("Opcion: ");
                                        opcion = entrada.nextByte();
                                        switch(opcion){
                                            case 1: 
                                                entrada.nextLine();
                                                System.out.print("Ingrese el nuevo nombre: ");
                                                String nuevoNombre = entrada.nextLine(); 
                                                listaVeterinarios[x].setNombre(nuevoNombre);
                                                
                                            break;
                                            case 2:
                                                System.out.print("Ingrese el nuevo ID: ");
                                                long nuevoID = entrada.nextLong(); 
                                                listaVeterinarios[x].setIdVeterinario(nuevoID);                                               
                                            break;
                                            case 3:
                                                System.out.print("Ingrese el nuevo num. de telefono: ");
                                                long nuevoTelefono = entrada.nextLong(); 
                                                listaVeterinarios[x].setTelefono(nuevoTelefono);                                               
                                            break;
                                            default: System.out.println("Opcion no disponible");
                                        }
                                        System.out.println("---------------------------------------------------------");
                                        System.out.println("Datos del veterinario modificado... ");
                                        System.out.println("Nombre: "+listaVeterinarios[x].getNombre()+"       ID: "+listaVeterinarios[x].getIdVeterinario()+"       Telefono: "+listaVeterinarios[x].getTelefono());
                                        System.out.println("---------------------------------------------------------");
                                        
                                    }   
                                    else
                                        System.out.println("El ID ingresado no se ha encontrado");
                                    System.out.println(".........................................................................");
                                    System.out.println("Ingrese un numero diferente de 0 si desea llevar a cabo otra modificacion");                            
                                    reintentar = entrada.nextInt();
                                }while(reintentar!=0);   
                            }
                            else{
                                System.out.println("Aun no ha agregado veterinarios");
                            }
                        break;
                    }
                break;
                case 2: 
                    System.out.println("1.-Comprar medicamentos\n2.-Modificar medicamentos\n3.-Stock");
                    System.out.print(" Opcion: ");
                    opcion = entrada.nextByte();
                    switch(opcion){
                        case 1:
                            do{
                            System.out.println("Tipo de medicamento que se desea adquirir: \n1.-Antibiotico\n2.-Vacuna\n3.-Otro medicamento");
                            System.out.print(" Opcion: ");
                            byte tipoMedicamento = entrada.nextByte();
                            entrada.nextLine();
                            System.out.print("Nombre del medicamento: ");
                            String nombreMedicamento = entrada.nextLine();
                            System.out.print("ID del medicameto: ");
                            long idMedicamento = entrada.nextLong();
                            System.out.print("Cantidad que desea adquirir: ");
                            int cantidadAdquisicion = entrada.nextInt();
                            System.out.print("Precio del medicamento: ");
                            int precioMedicamento = entrada.nextInt();                      
                            int precioTotal = precioMedicamento * cantidadAdquisicion;
                            if(controlServicio.getDineroCaja()<precioTotal){
                                System.out.println("\nLamentablemente no puede llevar a cabo la compra, no cuenta con suficiente capital en caja");
                                System.out.println("Desea ingresar dinero en caja?\n1.-Si\n2.-No");
                                System.out.print(" Opcion: ");
                                int respuesta = entrada.nextInt();
                                if(respuesta ==1){
                                    System.out.print("Cantidad que desea agregar: $");
                                    controlServicio.aumentarCapital(entrada.nextLong());
                                }
                            }
                            else{
                                switch(tipoMedicamento){
                                    case 1:
                                    entrada.nextLine();
                                        System.out.print("Tipo de aplicacion(ej.Oral, etc.): ");
                                        String tipoAplicacion = entrada.nextLine();
                                        for(int x=0; x<cantidadAdquisicion; x++){
                                            almacen.addMedicamento(medicamento = new Antibiotico(nombreMedicamento, idMedicamento, precioMedicamento, tipoAplicacion)); 
                                            cantidadMedicamentos++;
                                        }
                                        controlServicio.restarCapital(precioTotal);
                                    break;
                                    case 2: 
                                        System.out.print("Contraindicaciones: ");
                                        String contraindicaciones = entrada.nextLine();
                                        for(int x=0; x<cantidadAdquisicion; x++){
                                            almacen.addMedicamento(medicamento = new Vacuna(nombreMedicamento, idMedicamento, precioMedicamento, contraindicaciones));
                                            cantidadMedicamentos++;      
                                        } 
                                        controlServicio.restarCapital(precioTotal);                           
                                    break; 
                                    case 3:
                                        for(int x=0; x<cantidadAdquisicion; x++){
                                            almacen.addMedicamento(medicamento = new Medicamento(nombreMedicamento, idMedicamento, precioMedicamento));  
                                            cantidadMedicamentos++;
                                        } 
                                        controlServicio.restarCapital(precioTotal);         
                                    break;  
                                    default: 
                                        System.out.println("Error, el tipo de medicamento que ha seleccionado no existe");   
                                }
                                System.out.println("------------------------------------------------------------------------");
                                System.out.println("El medicamento ha sido a\u00F1adido al almacen.");
                                System.out.println("El saldo restante en caja es: $"+controlServicio.getDineroCaja());
                                System.out.println("------------------------------------------------------------------------");
                                System.out.println("Desea ver los medicamentos ahora disponibles en el almacen? \n1.-Si\n2.-No");   
                                System.out.print(" Opcion: ");
                                int respuesta = entrada.nextByte();
                                if(respuesta ==1){
                                    System.out.println("____________________LISTA DE MEDICAMENTOS_____________________");
                                    listaMedicamentos = almacen.getListaMedicamentos();
                                    for(int y=0; y<almacen.getCantidadMedicamentos(); y++){
                                        System.out.println("MEDICAMENTO "+(y+1));
                                        System.out.println("Nombre: "+listaMedicamentos[y].getNombreMedicamento()+"\nID: "+listaMedicamentos[y].getIdMedicamento()+"\nPrecio: "+listaMedicamentos[y].getPrecioMedicamento());
                                        System.out.print("\n");
                                    }
                                }
                            }
                            if(controlServicio.getDineroCaja()<precioMedicamento){
                                reintentar = 0;
                            }
                            else{
                                System.out.println("--------------------------------------------------------------------");
                                System.out.println("Ingrese un numero diferente de 0 si desea adquirir mas medicamentos");  
                                reintentar = entrada.nextByte();
                            }
                            }while(reintentar!=0);
                        break;
                        case 2: 
                            if(almacen.getCantidadMedicamentos()>=1){
                                do{
                                    System.out.println("__________________LISTA DE MEDICAMENTOS_____________________");
                                    listaMedicamentos = almacen.getListaMedicamentos();
                                    for(int y=0; y<almacen.getCantidadMedicamentos(); y++){
                                        System.out.println("MEDICAMENTO "+(y+1));
                                        System.out.println("Nombre: "+listaMedicamentos[y].getNombreMedicamento()+"\nID: "+listaMedicamentos[y].getIdMedicamento()+"\nPrecio: "+listaMedicamentos[y].getPrecioMedicamento());
                                        System.out.print("\n");
                                    }
                                    System.out.print("Ingresa el ID  del medicamento a modificar: ");
                                    long buscarID = entrada.nextLong();
                                    int x=0;
                                    while( x<almacen.getCantidadMedicamentos() && buscarID!=listaMedicamentos[x].getIdMedicamento()){
                                        x++;
                                    }
                                    if(x!=almacen.getCantidadMedicamentos()){                                                                      
                                        System.out.println("Modificacion que desea llevar a cabo: \n1.-Nombre\n2.-ID\n3.-Precio");
                                        System.out.print("Opcion: ");
                                        opcion = entrada.nextByte();
                                        switch(opcion){
                                            case 1: 
                                                entrada.nextLine();
                                                String nombreOriginal = listaMedicamentos[x].getNombreMedicamento();
                                                System.out.print("Ingrese el nuevo nombre: ");
                                                String nuevoNombre = entrada.nextLine(); 
                                                listaMedicamentos[x].setNombreMedicamento(nuevoNombre);
                                                for(int j=0;j<almacen.getCantidadMedicamentos();j++){       
                                                    if(listaMedicamentos[j].getNombreMedicamento()==nombreOriginal){
                                                        listaMedicamentos[j].setNombreMedicamento(nuevoNombre);
                                                    }
                                                }
                                                System.out.println("---------------------------------------------------------");
                                                System.out.println("Datos de medicamento(s) modificado(s)... ");
                                                for(int j=0; j<almacen.getCantidadMedicamentos(); j++){
                                                    if(listaMedicamentos[j].getNombreMedicamento()==listaMedicamentos[x].getNombreMedicamento()){
                                                        System.out.println("Nombre: "+listaMedicamentos[j].getNombreMedicamento()+"       ID: "+listaMedicamentos[j].getIdMedicamento()+"       Precio: $"+listaMedicamentos[j].getPrecioMedicamento());
                                                    }
                                                }
                                                System.out.println("---------------------------------------------------------");
                                            break;
                                            case 2:
                                                long IdOriginal = listaMedicamentos[x].getIdMedicamento();
                                                System.out.print("Ingrese el nuevo ID: ");
                                                long nuevoID = entrada.nextLong(); 
                                                listaMedicamentos[x].setIdMedicamento(nuevoID);
                                                for(int j=0;j<almacen.getCantidadMedicamentos();j++){       
                                                    if(listaMedicamentos[j].getIdMedicamento()==IdOriginal){
                                                        listaMedicamentos[j].setIdMedicamento(nuevoID);
                                                    }
                                                }
                                                System.out.println("---------------------------------------------------------");
                                                System.out.println("Datos de medicamento(s) modificado(s)... ");
                                                for(int j=0; j<almacen.getCantidadMedicamentos(); j++){
                                                    if(listaMedicamentos[j].getIdMedicamento()==listaMedicamentos[x].getIdMedicamento()){
                                                        System.out.println("Nombre: "+listaMedicamentos[j].getNombreMedicamento()+"       ID: "+listaMedicamentos[j].getIdMedicamento()+"       Precio: $"+listaMedicamentos[j].getPrecioMedicamento());
                                                    }
                                                }
                                                System.out.println("---------------------------------------------------------");
                                            break;
                                            case 3:                         
                                                int precioOriginal = listaMedicamentos[x].getPrecioMedicamento();                     
                                                System.out.print("Ingrese el nuevo precio: $");
                                                int nuevoPrecio = entrada.nextInt();                                                
                                                listaMedicamentos[x].setPrecioMedicamento(nuevoPrecio);                                                
                                                for(int j=0;j<almacen.getCantidadMedicamentos();j++){       
                                                    if(listaMedicamentos[j].getPrecioMedicamento()==precioOriginal){
                                                        listaMedicamentos[j].setPrecioMedicamento(nuevoPrecio);
                                                    }
                                                }
                                                System.out.println("---------------------------------------------------------");
                                                System.out.println("Datos de medicamento(s) modificado(s)... ");
                                                for(int j=0; j<almacen.getCantidadMedicamentos(); j++){
                                                    if(listaMedicamentos[j].getPrecioMedicamento()==listaMedicamentos[x].getPrecioMedicamento()){
                                                        System.out.println("Nombre: "+listaMedicamentos[j].getNombreMedicamento()+"       ID: "+listaMedicamentos[j].getIdMedicamento()+"       Precio: $"+listaMedicamentos[j].getPrecioMedicamento());
                                                    }
                                                }
                                                System.out.println("---------------------------------------------------------");
                                            break;
                                            default: System.out.println("Opcion no disponible");
                                        }
                                        System.out.println("--------------------------------------------------------------------");
                                        System.out.println("Ingrese un numero diferente de 0 si desea llevar a cabo otra modificacion");
                                    }   
                                    else
                                        System.out.println("El ID ingresado no se ha encontrado");
                                reintentar = entrada.nextInt();
                                }while(reintentar!=0);   
                            }
                            else{
                                System.out.println("Aun no ha agregado medicamentos");
                            }
                        break;
                        case 3:                            
                            if(almacen.getCantidadMedicamentos()==0){
                                System.out.println("No hay productos");
                            }
                            else{
                                System.out.println("Productos en existencia en el almacen...");
                                listaMedicamentos = almacen.getListaMedicamentos();
                                for(int y=0; y<almacen.getCantidadMedicamentos(); y++)
                                    System.out.println("Nombre: "+listaMedicamentos[y].getNombreMedicamento()+"    ID: "+listaMedicamentos[y].getIdMedicamento()+"    Precio: "+listaMedicamentos[y].getPrecioMedicamento());
                            }                            
                        break;
                        default: System.out.println(" ");
                    }
                break;
                case 3: 
                    veterinario = new Veterinario();
                    do{
                        System.out.println("1.-Consulta\n2.-Cuidado animal");
                        System.out.print(" Opcion: ");
                        opcion=entrada.nextByte();
                        switch(opcion){
                            case 1: 
                                System.out.print("ID servicio: ");
                                long idServicio = entrada.nextLong();
                                entrada.nextLine();
                                System.out.print("\nMotivo de la consulta:");  
                                String motivo = entrada.nextLine();
                                System.out.println("\nFamilia a la que pertenece el paciente \n1.-Canina\n2.-Felina\n3.-Otra familia");
                                System.out.print(" Opcion: ");
                                int familia = entrada.nextInt();                                
                                System.out.print("\nCosto de la consulta: $");
                                int costoConsulta = entrada.nextInt();
                                controlServicio.aumentarCapital(costoConsulta);
                                controlServicio.addServicio(servicioVeterinario = new Consulta(idServicio, costoConsulta, motivo));
                                System.out.println("\nDesea recetar medicamentos?\n1.-Si\n2.-No");
                                System.out.print(" Opcion: ");
                                int respuesta = entrada.nextInt();
                                if(respuesta == 1 ){
                                    if(cantidadMedicamentos>=1){
                                        do{
                                            System.out.println("\nTipo de medicamento a recetar: \n1.-Antibiotico\n2.-Vacuna\n3.-Otro tipo de medicamento");
                                            byte tipoMedicamento = entrada.nextByte();
                                            switch(tipoMedicamento){
                                                case 1:                                                    
                                                    System.out.println("Medicamentos disponibles para el tipo 'Antibiotico':");
                                                    listaMedicamentos = almacen.getListaMedicamentos();
                                                    for(int y=0; y<almacen.getCantidadMedicamentos(); y++){
                                                        if(listaMedicamentos[y] instanceof Antibiotico)
                                                            System.out.println("Nombre: "+listaMedicamentos[y].getNombreMedicamento()+"    ID: "+listaMedicamentos[y].getIdMedicamento()+"    Precio: "+listaMedicamentos[y].getPrecioMedicamento()+"  Tipo aplicacion: "+((Antibiotico)listaMedicamentos[y]).getTipoAplicacion());
                                                    }
                                                    System.out.println("Ingrese el ID del medicamento a recetar: ");
                                                    long idReceta = entrada.nextLong();
                                                    int x=0;
                                                    while(x<almacen.getCantidadMedicamentos() && idReceta!=listaMedicamentos[x].getIdMedicamento()){
                                                        x++;
                                                    }
                                                    if(x!=almacen.getCantidadMedicamentos()){
                                                        System.out.println("El medicamento es...");
                                                        System.out.println("Nombre: "+listaMedicamentos[x].getNombreMedicamento()+"    ID: "+listaMedicamentos[x].getIdMedicamento()+"    Precio: "+listaMedicamentos[x].getPrecioMedicamento()+"  Tipo aplicacion: "+((Antibiotico)listaMedicamentos[x]).getTipoAplicacion());
                                                        controlServicio.aumentarCapital(listaMedicamentos[x].getPrecioMedicamento());
                                                        ((Consulta)servicioVeterinario).setMedicamento(listaMedicamentos[x]);
                                                    }
                                                    else
                                                        System.out.println("No se ha encontrado el medicamento");                                                    
                                                break;
                                                case 2: 
                                                    System.out.println("Medicamentos disponibles para el tipo 'Vacuna':");
                                                    listaMedicamentos = almacen.getListaMedicamentos();
                                                    for(int y=0; y<almacen.getCantidadMedicamentos(); y++){
                                                        if(listaMedicamentos[y] instanceof Vacuna)
                                                            System.out.println("Nombre: "+listaMedicamentos[y].getNombreMedicamento()+"    ID: "+listaMedicamentos[y].getIdMedicamento()+"    Precio: "+listaMedicamentos[y].getPrecioMedicamento()+" Contraindicaciones: "+((Vacuna)listaMedicamentos[y]).getContraindicaciones());
                                                    }
                                                    System.out.println("Ingrese el ID del medicamento a recetar: ");
                                                    idReceta = entrada.nextLong();
                                                    x=0;
                                                    while(x<almacen.getCantidadMedicamentos() && idReceta!=listaMedicamentos[x].getIdMedicamento()){
                                                        x++;
                                                    }
                                                    if(x!=almacen.getCantidadMedicamentos()){
                                                        System.out.println("El medicamento es...");
                                                        System.out.println("Nombre: "+listaMedicamentos[x].getNombreMedicamento()+"    ID: "+listaMedicamentos[x].getIdMedicamento()+"    Precio: "+listaMedicamentos[x].getPrecioMedicamento()+" Contraindicaciones: "+((Vacuna)listaMedicamentos[x]).getContraindicaciones());
                                                        controlServicio.aumentarCapital(listaMedicamentos[x].getPrecioMedicamento());
                                                        controlServicio.addServicio(servicioVeterinario = new Consulta(idServicio, costoConsulta, motivo));
                                                    }
                                                    else
                                                        System.out.println("No se ha encontrado el medicamento");
                                                    break;
                                                case 3:
                                                    System.out.println("Medicamentos disponibles para 'Cualquier tipo de medicamento':");
                                                    listaMedicamentos = almacen.getListaMedicamentos();
                                                    for(int y=0; y<almacen.getCantidadMedicamentos(); y++)                                                
                                                            System.out.println("Nombre: "+listaMedicamentos[y].getNombreMedicamento()+"    ID: "+listaMedicamentos[y].getIdMedicamento()+"    Precio: "+listaMedicamentos[y].getPrecioMedicamento());
                                                    System.out.println("Ingrese el ID del medicamento a recetar: ");
                                                    idReceta = entrada.nextLong();
                                                    x=0;
                                                    while(x<almacen.getCantidadMedicamentos() && idReceta!=listaMedicamentos[x].getIdMedicamento()){
                                                        x++;
                                                    }
                                                    if(x!=almacen.getCantidadMedicamentos()){
                                                        System.out.println("El medicamento es...");
                                                        System.out.println("Nombre: "+listaMedicamentos[x].getNombreMedicamento()+"    ID: "+listaMedicamentos[x].getIdMedicamento()+"    Precio: "+listaMedicamentos[x].getPrecioMedicamento());
                                                        controlServicio.aumentarCapital(listaMedicamentos[x].getPrecioMedicamento());
                                                        controlServicio.addServicio(servicioVeterinario = new Consulta(idServicio, costoConsulta, motivo));
                                                    }
                                                    else
                                                        System.out.println("No se ha encontrado el medicamento");
                                                    break;
                                                default: 
                                                    System.out.println(" ");
                                                break;
                                                
                                            }
                                            System.out.println("----------------------------------------------------------------------");
                                            System.out.println("Ingrese un numero diferente de cero si desea recetar otro medicamento");
                                            reintentar = entrada.nextInt();
                                        }while(reintentar!=0);
                                    }
                                    else
                                        System.out.println("No tiene medicamentos.");
                                }
                                switch(familia){
                                    case 1:                                        
                                        System.out.println("Su veterinario le agradece la confianza y le dice... "+veterinario.curarCanino());
                                    break;
                                    case 2:                                        
                                        System.out.println("Su veterinario le agradece la confianza y le dice... "+veterinario.curarFelino());                                        
                                    break;
                                    case 3:                                       
                                        System.out.println("Su veterinario le agradece la confianza y le dice... "+veterinario.curarAnimal());                                       
                                    break;
                                    default: System.out.println(" ");                                        
                                }
                                System.out.println("______________________REPORTE DE LA CONSULTA_______________________");
                                System.out.println("ID Servicio: "+idServicio+"\nMotivo de la consulta: "+motivo+"\nCosto de la consulta: $"+costoConsulta);
                                System.out.println("___________________________________________________________________");
                            break;
                            case 2:
                                System.out.print("ID servicio: ");
                                idServicio = entrada.nextLong();
                                entrada.nextLine();
                                System.out.print("Tipo de cuidado (Lavado, corte de pelo, etc): ");  
                                motivo = entrada.nextLine();                                                        
                                System.out.print("Costo del 'Cuidado Animal': $");
                                costoConsulta = entrada.nextInt(); 
                                controlServicio.aumentarCapital(costoConsulta);      
                                controlServicio.addServicio(servicioVeterinario = new CuidadoAnimal(idServicio, costoConsulta, motivo));  
                                System.out.println("____________________REPORTE DEL CUIDADO ANIMAL______________________");   
                                System.out.println("ID:Servicio: "+idServicio +"\nTipo de cuidado: "+motivo+"\nCosto del servicio: "+costoConsulta);    
                                System.out.println("____________________________________________________________________");                                                
                            break;
                            default: System.out.println(" ");
                        } 
                        System.out.println("Desea agregar el paciente a su lista de pacientes?\n1.-Si\n2.-No");
                        System.out.print(" Opcion: ");
                        int respuesta = entrada.nextInt();
                        if(respuesta == 1){
                            System.out.print("Ingrese el ID del paciente: ");
                            long idPaciente = entrada.nextLong();
                            entrada.nextLine();
                            System.out.print("Tipo de animal: ");
                            String especie = entrada.nextLine();
                            paciente = new Paciente(idPaciente, especie);
                            listaPacientes[cantidadPacientes] = paciente;
                            cantidadPacientes++;                            
                            System.out.println("\nSe ha agregado el paciente a su lista de pacientes");
                            System.out.println("Desea visualizar la lista de pacientes agregados?\n1.-Si\n2.-No");
                            System.out.print(" Opcion: ");
                            respuesta = entrada.nextInt();
                            if(respuesta == 1){
                                System.out.println("_____________________LISTA DE PACIENTES_____________________");
                                for(int x =0; x<cantidadPacientes; x++){
                                    System.out.println("PACIENTE: "+(x+1));
                                    System.out.println("ID: "+listaPacientes[x].getIdPaciente());
                                    System.out.println("Tipo de animal: "+listaPacientes[x].getEspecie()+"\n");                                    
                                }
                            }
                        }
                        System.out.println("---------------------------------------------------------------------------------");
                        System.out.println("Ingrese un numero diferente de cero si desea hacer otra consulta o cuidado animal");
                        reintentar = entrada.nextInt();
                    }while(reintentar!=0);     
                break;
                case 4: 
                    System.out.println("1.-Reporte de servicios llevados a cabo\n2.-Listado de pacientes\n3.-Ingresos por servicios llevados a cabo y caja total");
                    opcion = entrada.nextByte();
                    switch(opcion){
                        case 1:
                            if(controlServicio.getCantidadServicios()>=1){
                                System.out.println("___________________LISTADO DE SERVICIOS__________________");
                                listadoServicios = controlServicio.getServcios();
                                for(int x=0; x<controlServicio.getCantidadServicios();x++){  
                                    System.out.println("SERVICIO "+(x+1));                            
                                    System.out.println("ID servicio: "+listadoServicios[x].getIdServicio()+"\nCosto servicio: "+listadoServicios[x].getCostoServicio());
                                  
                                    System.out.print("\n");  
                                }                              
                            }
                            else
                                System.out.println("No existen servicios registrados");                            
                        break;
                        case 2: 
                            if(cantidadPacientes>=1){
                                System.out.println("__________________LISTADO DE PACIENTES_____________________");
                                for(int x=0; x<cantidadPacientes; x++){
                                    System.out.println("PACIENTE "+(x+1));
                                    System.out.println("ID paciente: "+listaPacientes[x].getIdPaciente()+"\nEspecie: "+listaPacientes[x].getEspecie());
                                    System.out.print("\n");
                                }                               
                            } 
                            else
                               System.out.println("No se han registrado pacientes");
                        break;
                        case 3:
                            if(controlServicio.getCantidadServicios()>=1){
                                int ingresosPorServicios = 0;
                                listadoServicios = controlServicio.getServcios();
                                for(int x=0; x<controlServicio.getCantidadServicios(); x++)
                                    ingresosPorServicios = ingresosPorServicios + listadoServicios[x].getCostoServicio();                                
                                System.out.println("Ingreso total por servicios: $"+ingresosPorServicios);
                                System.out.println("Servicios mas capital en caja: $"+ingresosPorServicios+controlServicio.getDineroCaja()); 
                            }
                            else
                                System.out.println("No existen servicios registrados");
                        break;
                        default: System.out.println(" ");                           
                    }
                break;
                default: 
                    System.out.println("Opcion no valida");
            }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Ingrese 1 si desea llevar a cabo otra operacion");  
        reintentar = entrada.nextByte();
        }while(reintentar==1);
    }       
}