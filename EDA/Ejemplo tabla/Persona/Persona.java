public class Persona {
	
		private String nombre;
		private String apellido;
		private int edad;
		private String origen;
		private int folio;
		
		public Persona(String nombre, String apellido, int edad, String origen,int folio) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.edad = edad;
			this.origen = origen;
			this.folio = folio;
		}
		public String resultado() {
			return nombre+","+apellido+","+edad+", "+origen+", "+folio;
		}
		public String getNombre() {
			return nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public String getOrigen() {
			return origen;
		}
		public void setOrigen(String origen) {
			this.origen = origen;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public void setFolio(int folio){
			this.folio = folio;
		}
		public int getFolio(){
			return folio;
		}
		
		
	}
