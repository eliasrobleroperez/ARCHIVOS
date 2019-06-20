public class Almacen{
    private Medicamento[] listaMedicamentos;
    private int cantidadMedicamentos;

    public Almacen(){
        listaMedicamentos = new Medicamento[5000];
        cantidadMedicamentos = 0;
    }

    public void addMedicamento(Medicamento medicamento){
        listaMedicamentos[cantidadMedicamentos] = medicamento;
        cantidadMedicamentos++;
    }

    public int getCantidadMedicamentos(){
        return cantidadMedicamentos;
    }

    public Medicamento[] getListaMedicamentos(){
        return listaMedicamentos;
    }
}