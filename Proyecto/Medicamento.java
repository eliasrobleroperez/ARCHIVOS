public class Medicamento{
    protected String nombreMedicamento;
    protected long idMedicamento;
    protected int precioMedicamento;

    public Medicamento(String nombreMedicamento, long idMedicamento, int precioMedicamento){
        this.nombreMedicamento = nombreMedicamento;
        this.idMedicamento = idMedicamento;
        this.precioMedicamento = precioMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento){
        this.nombreMedicamento = nombreMedicamento;
    }

    public void setIdMedicamento(long idMedicamento){
        this.idMedicamento = idMedicamento;
    }

    public void setPrecioMedicamento(int precioMedicamento){
        this.precioMedicamento = precioMedicamento;
    }

    public String getNombreMedicamento(){
        return nombreMedicamento;
    }

    public long getIdMedicamento(){
        return idMedicamento;
    }

    public int getPrecioMedicamento(){
        return precioMedicamento;
    }
}