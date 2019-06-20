public class Antibiotico extends Medicamento{
    private String tipoAplicacion;

    public Antibiotico(String nombreMedicamento, long idMedicamento, int precioMedicamento, String tipoAplicacion){
        super(nombreMedicamento, idMedicamento, precioMedicamento);
        this.tipoAplicacion = tipoAplicacion;
    }

    public void setTipoAplicacion(String tipoAplicacion){
        this.tipoAplicacion = tipoAplicacion;
    }

    public String getTipoAplicacion(){
        return tipoAplicacion;
    }
}