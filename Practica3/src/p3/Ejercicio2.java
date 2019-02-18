package p3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio2 {
	
	public static Long combi(Integer n, Integer k) {
		Map<List<Integer>, Long> m = new HashMap<>();
		ini_map(m, n, k);
		return combi(m, n, k);
	}
	
	private static Long combi(Map<List<Integer>, Long> m, Integer n, Integer k) {
		Long res = null;
		List<Integer> key = List.of(n,k);
		if(m.containsKey(key)) {
			res = m.get(key);
		} else {
			res = combi(m, n-1, k-1) + combi(m, n-1, k);
			m.put(key,res);
		}
		return res;
	}
	
	private static void ini_map(Map<List<Integer>, Long> m, Integer n, Integer k) {
		for(int i=0; i<=n; i++) {//i recorre la n
			for(int j=0; j<=k; j++) {//j recorre la k
				if(j==0 || j==i) {
					m.put(List.of(i,j), 1L);
				} else if(j==1 || j==i-1) {
					m.put(List.of(i,j), i+0L);
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("(10,4)="+combi(10,4));
		
		
		
	}

}
