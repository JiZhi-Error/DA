package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class d implements Map<String, Object> {
    private final Map<String, Object> Dxw = new ArrayMap();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(String str, Object obj) {
        AppMethodBeat.i(202085);
        Object put = put(str, obj);
        AppMethodBeat.o(202085);
        return put;
    }

    public d() {
        AppMethodBeat.i(202070);
        AppMethodBeat.o(202070);
    }

    public d(String str, Object obj) {
        AppMethodBeat.i(202071);
        this.Dxw.put(str, obj);
        AppMethodBeat.o(202071);
    }

    public final int size() {
        AppMethodBeat.i(202072);
        int size = this.Dxw.size();
        AppMethodBeat.o(202072);
        return size;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(202073);
        boolean isEmpty = this.Dxw.isEmpty();
        AppMethodBeat.o(202073);
        return isEmpty;
    }

    public final boolean containsKey(Object obj) {
        AppMethodBeat.i(202074);
        if (obj instanceof String) {
            String str = (String) obj;
            if (str != null) {
                boolean containsKey = this.Dxw.containsKey(str);
                AppMethodBeat.o(202074);
                return containsKey;
            }
            AppMethodBeat.o(202074);
            return false;
        }
        AppMethodBeat.o(202074);
        return false;
    }

    public final boolean containsValue(Object obj) {
        AppMethodBeat.i(202075);
        boolean containsValue = this.Dxw.containsValue(obj);
        AppMethodBeat.o(202075);
        return containsValue;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        AppMethodBeat.i(202076);
        if (obj instanceof String) {
            Object obj2 = this.Dxw.get(obj);
            AppMethodBeat.o(202076);
            return obj2;
        }
        AppMethodBeat.o(202076);
        return null;
    }

    public final <T> T z(String str, T t) {
        AppMethodBeat.i(202077);
        try {
            T t2 = (T) this.Dxw.get(str);
            if (t2 != null) {
                AppMethodBeat.o(202077);
                return t2;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202077);
        return t;
    }

    public final Object put(String str, Object obj) {
        AppMethodBeat.i(202078);
        if (str == null || obj == null) {
            AppMethodBeat.o(202078);
            return null;
        }
        Object put = this.Dxw.put(str, obj);
        AppMethodBeat.o(202078);
        return put;
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        AppMethodBeat.i(202079);
        if (obj instanceof String) {
            this.Dxw.remove(obj);
        }
        AppMethodBeat.o(202079);
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Map<? extends java.lang.String, ?>] */
    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends Object> map) {
        AppMethodBeat.i(202080);
        if (c.aI(map)) {
            this.Dxw.putAll(map);
        }
        AppMethodBeat.o(202080);
    }

    public final void clear() {
        AppMethodBeat.i(202081);
        this.Dxw.clear();
        AppMethodBeat.o(202081);
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        AppMethodBeat.i(202082);
        Set<String> keySet = this.Dxw.keySet();
        AppMethodBeat.o(202082);
        return keySet;
    }

    @Override // java.util.Map
    public final Collection<Object> values() {
        AppMethodBeat.i(202083);
        Collection<Object> values = this.Dxw.values();
        AppMethodBeat.o(202083);
        return values;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, Object>> entrySet() {
        AppMethodBeat.i(202084);
        Set<Map.Entry<String, Object>> entrySet = this.Dxw.entrySet();
        AppMethodBeat.o(202084);
        return entrySet;
    }
}
