package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import model.Atraccion;
import model.Promocion;
import model.Usuario;
import model.enums.TipoDeAtraccion;
import model.enums.TipoPromo;

@Deprecated
public class ReaderFile {
	
	
    public static LinkedList<Usuario> getUsuarios(String archivo) {
        LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(archivo));
            while (sc.hasNext()) {
                // leo cada linea del archivo
                String linea = sc.nextLine();
                String datos[] = linea.split(" ");
                // creo una Persona a partir de los datos leídos de la linea.
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                Double presupuesto = Double.parseDouble(datos[2]);
                Double tiempodisp = Double.parseDouble(datos[3]);
                String tipoAtraccion = datos[4];
                String username = datos[5];
                String password = datos[6];
                Boolean isAdmin = Boolean.parseBoolean(datos[7]);
                
                // agrego esa persona a la lista, siempre y cuando no est� repetida
                
                Usuario p = new Usuario(id, nombre, presupuesto, tiempodisp, tipoAtraccion, username, password, isAdmin);
                if (!usuarios.contains(p))
                    usuarios.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // cierro el archivo
        sc.close();
        return usuarios;
    }
	
	
	public static LinkedList<Atraccion> getAtracciones(String archivo) {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));
			while (sc.hasNext()) {
				// leo cada linea del archivo
				String linea = sc.nextLine();
				String datos[] = linea.split(",");
				// creo una Persona a partir de los datos le�dos de la l�nea.
				String nombre = datos[0];
				int costo = Integer.parseInt(datos[1]);
				double tiempoPromedio = Double.parseDouble(datos[2]);
				int cupo = Integer.parseInt(datos[3]);
				TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(datos[4]);
				// agrego esa persona a la lista, siempre y cuando no est� repetida
				Atraccion p = new Atraccion(nombre, costo, tiempoPromedio, cupo, tipoAtraccion);

				if (!atracciones.contains(p))
					atracciones.add(p);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// cierro el archivo
		sc.close();

		return atracciones;
	}
	
	
	public LinkedList<Promocion> getPromociones(String archivo) {
		LinkedList<Promocion> promociones = new LinkedList<Promocion>();
		Scanner sc = null;
		try { //
			sc = new Scanner(new File(archivo));
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(", ");

				TipoPromo tipoDePromocion = TipoPromo.valueOf(datos[1]);

				Promocion promocion = Promocion.generarPromo(datos, tipoDePromocion);

				int id1 = Integer.parseInt(datos[3]);
				int id2 = Integer.parseInt(datos[4]);

				Atraccion atraccion1 = Atraccion.encontrarPorId(id1);
				Atraccion atraccion2 = Atraccion.encontrarPorId(id2);

				promocion.getAtracciones().add(atraccion1);
				promocion.getAtracciones().add(atraccion2);

				if (TipoPromo.AXB.equals(TipoPromo.valueOf(datos[1]))) {
					Atraccion atraccion3 = Atraccion.encontrarPorId(Integer.parseInt(datos[5]));
					promocion.getAtracciones().add(atraccion3);
				}

				promociones.add(promocion);

			}

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			try {
				if (sc != null) {
					sc.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		sc.close();
		return promociones;
	}
	

}
