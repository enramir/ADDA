package ejercicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.bt.EstadoBT;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;

public class Estado_Caballo implements EstadoBT<SolucionCaballoBT, Integer, Estado_Caballo> {

	private Integer[] movx;
	private Integer[] movy;
	private Integer tam;
	private Integer posx;
	private Integer posy;
	private Integer casillasProcesadas;
	private Map<Tuple2<Integer,Integer>, Integer> tablero;

	public static Estado_Caballo create() {
		return new Estado_Caballo();
	}

	private Estado_Caballo() {
		tam = ProblemaCaballo.getLado();
		casillasProcesadas = 1;
		posx = ProblemaCaballo.getIposx();
		posy = ProblemaCaballo.getIposy();
		movx = ProblemaCaballo.getMovx();
		movy = ProblemaCaballo.getMovy();
		tablero = new HashMap<>();
		tablero.put(Tuple.create(posx, posy), casillasProcesadas);

	}

	public Tipo getTipo() {
		return Tipo.AlgunasSoluciones;
	}

	@Override
	public Estado_Caballo getEstadoInicial() {
		return Estado_Caballo.create();
	}

	@Override
	public Estado_Caballo avanza(Integer movimiento) {
		posx += movx[movimiento];
		posy += movy[movimiento];
		casillasProcesadas++;
		tablero.put(Tuple.create(posx, posy), casillasProcesadas);
		return this;
	}

	@Override
	public Estado_Caballo retrocede(Integer movimiento) {
		tablero.remove(Tuple.create(posx,posy));
		posx -= movx[movimiento];
		posy -= movy[movimiento];
		casillasProcesadas--;
		return this;
	}

	public int size() {
		return (tam * tam) - casillasProcesadas;
	}


	public boolean esCasoBase() {
		return casillasProcesadas==tam*tam;
	}


	public List<Integer> getAlternativas() {
		//Con for
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<movx.length; i++) {
			if(dentroTablero(i) && !estaVisitada(i)) {
				res.add(i);
			}
		}
		return res;
	}

	//Con Stream
	/*List<Integer> movAlt = IntStream.rangeClosed(0, 7)
			.boxed()
			.filter(v -> 0 <= (posx + movx[v]) && (posx + movx[v]) < tam)
			.filter(v -> 0 <= (posy + movy[v]) && (posy + movy[v]) < tam)
			.filter(v -> tablero.get(Tuple.create(posx + movx[v], posy + movy[v])))
			.collect(Collectors.toList());
			return movAlt;*/


	private Boolean estaVisitada(int i) {
		Tuple2<Integer, Integer> mov = Tuple.create(posx+movx[i], posy+movy[i]);
		return tablero.get(mov)!=null;
	}

	private Boolean dentroTablero(int i) {
		return posx+movx[i]>=0 && posx+movx[i]<tam &&
				posy+movy[i]>=0 && posy+movy[i]<tam;
	}

	public SolucionCaballoBT getSolucion() {
		if(!esCasoBase()) {
			throw new RuntimeException("Sin solución para ese estado");
		}
		return SolucionCaballoBT.create(tablero);
	}


}
