public class ServicioVeterinario{
    protected long idServicio;
    protected Fecha fechaServicio;
    protected int costoServicio;

    public ServicioVeterinario(long idServicio, int costoServicio){
        this.idServicio = idServicio;
        this.costoServicio = costoServicio;
    }

    public void setIdServicio(long idServicio){
        this.idServicio = idServicio;
    }

    public void setFechaServicio(Fecha fechaServicio){
        this.fechaServicio = fechaServicio;
    }

    public void setCostoServicio(int costoServicio){
        this.costoServicio = costoServicio;
    }

    public long getIdServicio(){
        return idServicio;
    }

    public Fecha getFechaServicio(){
        return fechaServicio;
    }

    public int getCostoServicio(){
        return costoServicio;
    }
}  