public class CuidadoAnimal extends ServicioVeterinario{
    private String cambioDeseado;

    public CuidadoAnimal(long idServicio, int costoServicio, String cambioDeseado){
        super(idServicio, costoServicio);
        this.cambioDeseado = cambioDeseado;
    }

    public void setCambioDeseado(String cambioDeseado){
        this.cambioDeseado = cambioDeseado;
    }

    public String getCambioDeseado(){
        return cambioDeseado;
    }
}