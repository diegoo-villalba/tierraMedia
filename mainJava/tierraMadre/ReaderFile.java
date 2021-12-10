/*package tierraMadre;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
                String nombre = datos[0];
                double presupuesto = Double.parseDouble(datos[1]);
                double tiempodisp = Double.parseDouble(datos[2]);
                TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(datos[3]);
                // agrego esa persona a la lista, siempre y cuando no est� repetida
                Usuario p = new Usuario(nombre, presupuesto, tiempodisp, tipoAtraccion);
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
	
	
	public static LinkedList<Promocion> getPromociones(String archivo, List<Atraccion> atracciones) {
        // para leer el archivo de promociones y armar una lista con ellas
        LinkedList<Promocion> promociones = new LinkedList<Promocion>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(archivo));
            while (sc.hasNext()) {
                // leo cada linea del archivo
                String linea = sc.nextLine();
                String datos[] = linea.split(",");
                // creo una Promocion a partir de los datos le�dos de la l�nea.
                // las promos son de dos o tres atracciones
                double montoPromo = Double.parseDouble(datos[0]);
                TipoPromo tipoPromo = TipoPromo.valueOf(datos[1]);
                String nombre = datos[2];
                String atraccion1 = datos[3];
                String atraccion2 = datos[4];
                String atraccion3 = datos[5];
                List<Atraccion> atraccionesPromo = Promocion.filtroAtraccion(atraccion1, atraccion2, atraccion3, atracciones);
                // agrego esa persona a la lista, siempre y cuando no est� repetida
                Promocion p = PromoFactory.buildPromocion(nombre, atraccionesPromo, tipoPromo, montoPromo);
                if (!promociones.contains(p))
                    promociones.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // cierro el archivo
        sc.close();
        return promociones;
    }
	

}*/
