import java.util.HashMap;
/**
 * one to one mapping for keys and values, implements DualMap interface
 * @author Carla Ramirez
 *
 * @param <K> unique keys
 * @param <V> unique values
 */
public class DualHashMap<K, V> implements DualMap<K, V> {
	
	/** HashMap designed to track individual keys.*/
	private HashMap<K, V> keys = null;
	
	/** HashMap designed to track individual values.*/
	private HashMap<V, K> values = null;

	/** Instantiate a basic DualHashMap. This HashMap is designed to keep
	 * individual keys and individual values unique.
	 * */
	public DualHashMap() {
		this.keys = new HashMap<K, V>();
		this.values = new HashMap<V, K>();
	}

	/** Adds a key and value to the DualHashMap. If the key is 
	 * associated with an existing value, that key will be removed 
	 * and vice versa. 
	 * @param key The key to be added. 
	 * @param value The value to be added and associated with a key.
	 * */
	@Override
	public void put(K key, V value) {
		K tempKey = this.values.get(value);
		V tempValue = this.keys.get(key);
		if(tempValue != null){
			this.values.remove(tempValue);
		}
		if(tempKey != null){
			this.keys.remove(tempKey);
		}
		this.values.put(value, key);
		this.keys.put(key, value);
	}

	/**
     * Removes the mapping from the key to the value from this dual map if it is
     * present. After dualmap.put(key, value) and dualmap.remove(key, value),
     * then dualmap.get(key) should return null and dualmap.reverseGet(value)
     * should return null.
     * 
     * @param key
     *            key whose mapping to value is to be removed
     * @param value
     *            value whose mapping from key is to be removed
     */
	@Override
	public void remove(K key, V value) {
		this.keys.remove(key);
		this.values.remove(value);
	}

    /**
     * Returns the value that maps from the specified key, or null if this dual
     * map contains no mapping for the key.
     * 
     * @param key
     *            the key that maps to the value that should be returned
     * @return the value that maps from the specified key, or null if this dual
     *         map contains no mapping for the key
     */
	@Override
	public V get(K key) {
		return this.keys.get(key);
	}

    /**
     * Returns the key that maps to the specified value, or null if this dual
     * map contains no mapping for the value.
     * 
     * @param value
     *            the value that maps from the key that should be returned
     * @return the key that maps to the specified value, or null if this dual
     *         map contains no mapping for the value
     */
	@Override
	public K reverseGet(V value) {
		return this.values.get(value);
	}

}