package co.edu.konradlorenz.model;
import java.util.ArrayList;
public class Lista {
	  private ArrayList <Persona> listaPersona = new ArrayList<Persona>();
	     
		public Lista() {
			
			// TODO Auto-generated constructor stub
		}

		public Lista(ArrayList<Persona> listaPersona) {
			
			this.listaPersona = listaPersona;
		}

		public Persona getListaJugadores(int indice) {
			return listaPersona.get(indice);
		}

		public void setListaPersona(Persona persona) {
			this.listaPersona.add(persona);
		}
		public ArrayList<Persona> getLista() {
	        return listaPersona;
	    }


		@Override
		public String toString() {
			return "Lista [listaPersona=" + listaPersona + "]";
		}
	     
}
