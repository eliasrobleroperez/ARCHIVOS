public class Vacuna extends Medicamento{
    private String contraindicaciones;

    public Vacuna(String nombreMedicamento, long idMedicamento, int precioMedicamento, String contraindicaciones){
        super(nombreMedicamento, idMedicamento, precioMedicamento);
        this.contraindicaciones = contraindicaciones;
    }

    public void setContraindicaciones(String contraindicaciones){
        this.contraindicaciones = contraindicaciones;
    }

    public String getContraindicaciones(){
        return contraindicaciones;
    }
}