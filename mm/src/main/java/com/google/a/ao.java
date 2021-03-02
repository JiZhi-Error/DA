package com.google.a;

import com.google.a.ae;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class ao<K, V> extends LinkedHashMap<K, V> {
    private static final ao bYg;
    boolean bNd = true;

    ao() {
    }

    ao(Map<K, V> map) {
        super(map);
    }

    static {
        ao aoVar = new ao();
        bYg = aoVar;
        aoVar.bNd = false;
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        GY();
        super.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final V put(K k, V v) {
        GY();
        ae.checkNotNull(k);
        ae.checkNotNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final void putAll(Map<? extends K, ? extends V> map) {
        GY();
        for (Object obj : map.keySet()) {
            ae.checkNotNull(obj);
            ae.checkNotNull(map.get(obj));
        }
        super.putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final V remove(Object obj) {
        GY();
        return (V) super.remove(obj);
    }

    static <K, V> boolean b(Map<K, V> map, Map<K, V> map2) {
        boolean equals;
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
            V value = entry.getValue();
            V v = map2.get(entry.getKey());
            if (!(value instanceof byte[]) || !(v instanceof byte[])) {
                equals = value.equals(v);
                continue;
            } else {
                equals = Arrays.equals((byte[]) value, (byte[]) v);
                continue;
            }
            if (!equals) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Map) && b(this, (Map) obj);
    }

    private static int at(Object obj) {
        if (obj instanceof byte[]) {
            return ae.hashCode((byte[]) obj);
        }
        if (!(obj instanceof ae.a)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    static <K, V> int c(Map<K, V> map) {
        int i2 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            i2 = (at(entry.getValue()) ^ at(entry.getKey())) + i2;
        }
        return i2;
    }

    public final int hashCode() {
        return c(this);
    }

    static <K, V> Map<K, V> d(Map<K, V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                value = (V) Arrays.copyOf(bArr, bArr.length);
            }
            linkedHashMap.put(key, value);
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: package-private */
    public final void GY() {
        if (!this.bNd) {
            throw new UnsupportedOperationException();
        }
    }
}
