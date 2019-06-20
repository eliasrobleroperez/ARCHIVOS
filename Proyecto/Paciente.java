public class Paciente{
    private long idPaciente;
    private String especie;

    public Paciente(long idPaciente, String especie){
        this.idPaciente = idPaciente;
        this.especie = especie;
    }

    public void setIdPaciente(long setIdPaciente){
        this.idPaciente = idPaciente;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public long getIdPaciente(){
        return idPaciente;
    }

    public String getEspecie(){
        return especie;
    }
}