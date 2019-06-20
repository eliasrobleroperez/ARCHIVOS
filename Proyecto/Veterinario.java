public class Veterinario implements IEspecialistaCanino, IEspecialistaFelino{
    private String nombre;
    private long idVeterinario;
    private long telefono;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setIdVeterinario(long idVeterinario){
        this.idVeterinario = idVeterinario;
    }

    public void setTelefono(long telefono){
        this.telefono = telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public long getIdVeterinario(){
        return idVeterinario;
    }

    public long getTelefono(){
        return telefono;
    }

    public String curarAnimal(){
        return "Cuente conmigo para cuidar de sus animales";
    }
    
    @Override
    public String curarCanino(){
        return "Cuente conmigo para cuidar de su canino";
    }

    @Override
    public String curarFelino(){
        return "Cuente conmigo para cuidar de su felino";
    }
}