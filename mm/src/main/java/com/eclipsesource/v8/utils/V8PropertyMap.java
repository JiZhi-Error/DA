package com.eclipsesource.v8.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

class V8PropertyMap<V> implements Map<String, V> {
    private Hashtable<String, V> map = new Hashtable<>();
    private Set<String> nulls = new HashSet();

    V8PropertyMap() {
        AppMethodBeat.i(61769);
        AppMethodBeat.o(61769);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String str, Object obj) {
        AppMethodBeat.i(61782);
        V put = put(str, obj);
        AppMethodBeat.o(61782);
        return put;
    }

    public int size() {
        AppMethodBeat.i(61770);
        int size = this.map.size() + this.nulls.size();
        AppMethodBeat.o(61770);
        return size;
    }

    public boolean isEmpty() {
        AppMethodBeat.i(61771);
        if (!this.map.isEmpty() || !this.nulls.isEmpty()) {
            AppMethodBeat.o(61771);
            return false;
        }
        AppMethodBeat.o(61771);
        return true;
    }

    public boolean containsKey(Object obj) {
        AppMethodBeat.i(61772);
        if (this.map.containsKey(obj) || this.nulls.contains(obj)) {
            AppMethodBeat.o(61772);
            return true;
        }
        AppMethodBeat.o(61772);
        return false;
    }

    public boolean containsValue(Object obj) {
        AppMethodBeat.i(61773);
        if (obj == null && !this.nulls.isEmpty()) {
            AppMethodBeat.o(61773);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(61773);
            return false;
        } else {
            boolean containsValue = this.map.containsValue(obj);
            AppMethodBeat.o(61773);
            return containsValue;
        }
    }

    @Override // java.util.Map
    public V get(Object obj) {
        AppMethodBeat.i(61774);
        if (this.nulls.contains(obj)) {
            AppMethodBeat.o(61774);
            return null;
        }
        V v = this.map.get(obj);
        AppMethodBeat.o(61774);
        return v;
    }

    public V put(String str, V v) {
        AppMethodBeat.i(61775);
        if (v == null) {
            if (this.map.containsKey(str)) {
                this.map.remove(str);
            }
            this.nulls.add(str);
            AppMethodBeat.o(61775);
            return null;
        }
        if (this.nulls.contains(str)) {
            this.nulls.remove(str);
        }
        V put = this.map.put(str, v);
        AppMethodBeat.o(61775);
        return put;
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        AppMethodBeat.i(61776);
        if (this.nulls.contains(obj)) {
            this.nulls.remove(obj);
            AppMethodBeat.o(61776);
            return null;
        }
        V remove = this.map.remove(obj);
        AppMethodBeat.o(61776);
        return remove;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.eclipsesource.v8.utils.V8PropertyMap<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends V> map2) {
        AppMethodBeat.i(61777);
        for (Map.Entry<? extends String, ? extends V> entry : map2.entrySet()) {
            put((String) entry.getKey(), entry.getValue());
        }
        AppMethodBeat.o(61777);
    }

    public void clear() {
        AppMethodBeat.i(61778);
        this.map.clear();
        this.nulls.clear();
        AppMethodBeat.o(61778);
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        AppMethodBeat.i(61779);
        HashSet hashSet = new HashSet(this.map.keySet());
        hashSet.addAll(this.nulls);
        AppMethodBeat.o(61779);
        return hashSet;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        AppMethodBeat.i(61780);
        ArrayList arrayList = new ArrayList(this.map.values());
        for (int i2 = 0; i2 < this.nulls.size(); i2++) {
            arrayList.add(null);
        }
        AppMethodBeat.o(61780);
        return arrayList;
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, V>> entrySet() {
        AppMethodBeat.i(61781);
        HashSet hashSet = new HashSet(this.map.entrySet());
        for (String str : this.nulls) {
            hashSet.add(new AbstractMap.SimpleEntry(str, null));
        }
        AppMethodBeat.o(61781);
        return hashSet;
    }
}
