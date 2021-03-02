package com.tencent.mm.b;

import java.util.Map;
import java.util.Set;

public interface f<K, O> {

    public interface a<K, O> {
    }

    public interface b<K, O> {
        void c(K k, O o, O o2);
    }

    public interface c<K, O> {
        int y(K k, O o);
    }

    void a(a<K, O> aVar);

    O aT(K k);

    boolean check(K k);

    boolean checkAndUpTime(K k);

    void clear();

    int createCount();

    int evictionCount();

    O get(K k);

    int hitCount();

    Set<K> keySet();

    int maxSize();

    int missCount();

    O put(K k, O o);

    int putCount();

    O remove(K k);

    int size();

    int sizeOf(K k, O o);

    Map<K, O> snapshot();

    void trimToSize(int i2);

    void x(K k, O o);
}
