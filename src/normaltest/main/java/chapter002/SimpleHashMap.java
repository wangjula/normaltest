package normaltest.main.java.chapter002;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Set;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

	private static final int SIZE = 997;
	
	private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return null;
	}

}
