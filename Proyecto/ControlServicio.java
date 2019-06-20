public class ControlServicio{
    ServicioVeterinario servicios[];
    private int cantidadServicios;
    private long dineroCaja;

    public ControlServicio(){
        servicios = new ServicioVeterinario[1000];
        cantidadServicios = 0;
    }

    public void setDineroCaja(long dineroCaja){
        this.dineroCaja = dineroCaja;
    }

    public long getDineroCaja(){
        return dineroCaja;
    }

    public void addServicio(ServicioVeterinario servicioVeterinario){
        servicios[cantidadServicios] = servicioVeterinario;
        cantidadServicios++;
    }

    public int getCantidadServicios(){
        return cantidadServicios;
    }

    public ServicioVeterinario[] getServcios(){
        return servicios;
    }
    
    public void aumentoCaja(ServicioVeterinario servicioVeterinario){
        dineroCaja = dineroCaja + servicioVeterinario.getCostoServicio();
    }

    public void aumentarCapital(long cantidad){
        dineroCaja = dineroCaja + cantidad;
    }

    public  void restarCapital(long cantidad){
        dineroCaja = dineroCaja - cantidad;
    }
}