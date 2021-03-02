package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class V8Map<V> implements Releasable, Map<V8Value, V> {
    private Map<V8Value, V> map = new HashMap();
    private Map<V8Value, V8Value> twinMap = new HashMap();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(V8Value v8Value, Object obj) {
        AppMethodBeat.i(61728);
        V put = put(v8Value, obj);
        AppMethodBeat.o(61728);
        return put;
    }

    public V8Map() {
        AppMethodBeat.i(61714);
        AppMethodBeat.o(61714);
    }

    @Override // com.eclipsesource.v8.Releasable
    public void release() {
        AppMethodBeat.i(61715);
        clear();
        AppMethodBeat.o(61715);
    }

    public int size() {
        AppMethodBeat.i(61716);
        int size = this.map.size();
        AppMethodBeat.o(61716);
        return size;
    }

    public boolean isEmpty() {
        AppMethodBeat.i(61717);
        boolean isEmpty = this.map.isEmpty();
        AppMethodBeat.o(61717);
        return isEmpty;
    }

    public boolean containsKey(Object obj) {
        AppMethodBeat.i(61718);
        boolean containsKey = this.map.containsKey(obj);
        AppMethodBeat.o(61718);
        return containsKey;
    }

    public boolean containsValue(Object obj) {
        AppMethodBeat.i(61719);
        boolean containsValue = this.map.containsValue(obj);
        AppMethodBeat.o(61719);
        return containsValue;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        AppMethodBeat.i(61720);
        V v = this.map.get(obj);
        AppMethodBeat.o(61720);
        return v;
    }

    public V put(V8Value v8Value, V v) {
        AppMethodBeat.i(61721);
        remove(v8Value);
        V8Value twin = v8Value.twin();
        this.twinMap.put(twin, twin);
        V put = this.map.put(twin, v);
        AppMethodBeat.o(61721);
        return put;
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        AppMethodBeat.i(61722);
        V remove = this.map.remove(obj);
        V8Value remove2 = this.twinMap.remove(obj);
        if (remove2 != null) {
            remove2.release();
        }
        AppMethodBeat.o(61722);
        return remove;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.eclipsesource.v8.utils.V8Map<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends V8Value, ? extends V> map2) {
        AppMethodBeat.i(61723);
        for (Map.Entry<? extends V8Value, ? extends V> entry : map2.entrySet()) {
            put((V8Value) entry.getKey(), entry.getValue());
        }
        AppMethodBeat.o(61723);
    }

    public void clear() {
        AppMethodBeat.i(61724);
        this.map.clear();
        for (V8Value v8Value : this.twinMap.keySet()) {
            v8Value.release();
        }
        this.twinMap.clear();
        AppMethodBeat.o(61724);
    }

    @Override // java.util.Map
    public Set<V8Value> keySet() {
        AppMethodBeat.i(61725);
        Set<V8Value> keySet = this.map.keySet();
        AppMethodBeat.o(61725);
        return keySet;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        AppMethodBeat.i(61726);
        Collection<V> values = this.map.values();
        AppMethodBeat.o(61726);
        return values;
    }

    @Override // java.util.Map
    public Set<Map.Entry<V8Value, V>> entrySet() {
        AppMethodBeat.i(61727);
        Set<Map.Entry<V8Value, V>> entrySet = this.map.entrySet();
        AppMethodBeat.o(61727);
        return entrySet;
    }
}
