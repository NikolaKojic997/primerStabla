package main;

import java.util.LinkedList;

import labis.cvorovi.CvorStabla;
import labis.exception.LabisException;
import labis.stabla.ABinarnoStablo;

public class BinarnoStablo extends ABinarnoStablo {

	@Override
	public CvorStabla vratiNajveciNaPutanji(CvorStabla k, CvorStabla neki) throws LabisException {
		
		LinkedList<CvorStabla> lista = new LinkedList<CvorStabla>();
		
		if (k == null)
			return null;
		
		if (k == neki)
			return neki;
		
		lista.add(k);
		
		while(k != neki) {
				if (postoji(k.levo, neki)) {
					lista.add(k.levo);
					k = k.levo;
			}
				else {
					lista.add(k.desno);
					k = k.desno;
				}
				
		}
		
		return max(lista);
		
	}

	private CvorStabla max(LinkedList<CvorStabla> lista) {
		
		if (lista.isEmpty())
			return null;
		CvorStabla max = lista.get(0);
		
			for (int i = 1; i<lista.size(); i++){
				if (lista.get(i).podatak > max.podatak)
					max = lista.get(i);
			}
		return max;
	}

	private boolean postoji(CvorStabla koren, CvorStabla neki) {
		
		if (koren == null || neki == null)
			return false;
		
		if (koren == neki)
			return true;
		
		return postoji(koren.levo, neki) || postoji(koren.desno, neki);
	}
}
