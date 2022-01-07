package utils;

import java.util.Comparator;

import model.Atraccion;

public class CostoComparacion implements Comparator<Atraccion> {
	
	@Override
	public int compare(Atraccion a1, Atraccion a2) {
		return Integer.compare(a2.getCosto(),a1.getCosto());
	}
}
