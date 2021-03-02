package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

final class a<K, V> extends ConcurrentHashMap<K, V> {
    a() {
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.concurrent.ConcurrentHashMap
    public final V get(Object obj) {
        AppMethodBeat.i(146085);
        if (obj == null) {
            AppMethodBeat.o(146085);
            return null;
        }
        V v = (V) super.get(obj);
        AppMethodBeat.o(146085);
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.concurrent.ConcurrentHashMap
    public final V put(K k, V v) {
        AppMethodBeat.i(146086);
        if (k == null) {
            AppMethodBeat.o(146086);
            return null;
        } else if (v == null) {
            V v2 = (V) super.remove(k);
            AppMethodBeat.o(146086);
            return v2;
        } else {
            V v3 = (V) super.put(k, v);
            AppMethodBeat.o(146086);
            return v3;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.concurrent.ConcurrentHashMap
    public final V remove(Object obj) {
        AppMethodBeat.i(146087);
        if (obj == null) {
            AppMethodBeat.o(146087);
            return null;
        }
        V v = (V) super.remove(obj);
        AppMethodBeat.o(146087);
        return v;
    }

    public final boolean containsValue(Object obj) {
        AppMethodBeat.i(146088);
        if (obj == null) {
            AppMethodBeat.o(146088);
            return false;
        }
        boolean containsValue = super.containsValue(obj);
        AppMethodBeat.o(146088);
        return containsValue;
    }
}
