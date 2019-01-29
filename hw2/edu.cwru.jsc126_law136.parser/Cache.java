package edu.cwru.jsc126_law136.parser;

import java.util.Map;
import java.util.function.Function;

final class Cache<T,V>{
    private Map<T,V> cache;

    V get(T key, Function<? super T, ? extends V> constructor){
	if(key == null)
	    throw new NullPointerException("Key is null.");
	if(constructor == null)
	    throw new NullPointerException("Constructor is null.");

	if(cache.containsKey(key)){
	    return cache.get(key);
	}
	else{
	    V obj = constructor(key);
	    cache.put(key, obj);
	    return obj;
	}
    }
}
