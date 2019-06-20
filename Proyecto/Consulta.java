public class Consulta extends ServicioVeterinario{
    private String motivoConsulta;
    private Medicamento medicamento;

    public Consulta(long idServicio, int costoServicio, String motivoConsulta){
        super(idServicio, costoServicio);
        this.motivoConsulta = motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta){
        this.motivoConsulta = motivoConsulta;
    }

    public String getMotivoConsulta(){
        return motivoConsulta;
    }

    public void setMedicamento(Medicamento medicamento){
        this.medicamento = medicamento;
    }

    public Medicamento getMedicamento(){
        return medicamento;
    }
}