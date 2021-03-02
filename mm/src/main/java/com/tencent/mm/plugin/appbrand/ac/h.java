package com.tencent.mm.plugin.appbrand.ac;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class h<K, V> {
    private final Map<K, Set<V>> ogz = new a();

    public h() {
        AppMethodBeat.i(140836);
        AppMethodBeat.o(140836);
    }

    public final boolean r(K k, V v) {
        boolean add;
        AppMethodBeat.i(140837);
        if (k == null || v == null) {
            AppMethodBeat.o(140837);
            return false;
        }
        Set<V> d2 = d(k, true);
        synchronized (d2) {
            try {
                add = d2.add(v);
            } finally {
                AppMethodBeat.o(140837);
            }
        }
        return add;
    }

    public final boolean b(K k, Collection<V> collection) {
        boolean z = false;
        AppMethodBeat.i(221347);
        if (k == null || collection == null) {
            AppMethodBeat.o(221347);
        } else if (collection.isEmpty()) {
            AppMethodBeat.o(221347);
        } else {
            Set<V> d2 = d(k, true);
            synchronized (d2) {
                try {
                    z = d2.addAll(collection);
                } finally {
                    AppMethodBeat.o(221347);
                }
            }
        }
        return z;
    }

    private Set<V> d(K k, boolean z) {
        Set<V> set;
        AppMethodBeat.i(140838);
        synchronized (this.ogz) {
            try {
                set = this.ogz.get(k);
                if (set == null && z) {
                    set = new HashSet<>();
                    this.ogz.put(k, set);
                }
            } finally {
                AppMethodBeat.o(140838);
            }
        }
        return set;
    }

    public final boolean J(K k, V v) {
        boolean z = false;
        AppMethodBeat.i(140839);
        if (v == null) {
            AppMethodBeat.o(140839);
        } else {
            Set<V> d2 = d(k, false);
            if (d2 != null) {
                synchronized (d2) {
                    try {
                        z = d2.remove(v);
                    } finally {
                        AppMethodBeat.o(140839);
                    }
                }
            } else {
                AppMethodBeat.o(140839);
            }
        }
        return z;
    }

    public final Set<V> cM(K k) {
        HashSet hashSet;
        AppMethodBeat.i(140840);
        if (k == null) {
            AppMethodBeat.o(140840);
            return null;
        }
        Set<V> d2 = d(k, false);
        if (d2 == null) {
            Set<V> emptySet = Collections.emptySet();
            AppMethodBeat.o(140840);
            return emptySet;
        }
        synchronized (d2) {
            try {
                hashSet = new HashSet(d2);
            } finally {
                AppMethodBeat.o(140840);
            }
        }
        return hashSet;
    }

    public final Set<V> cN(K k) {
        Set<V> remove;
        AppMethodBeat.i(140841);
        if (k == null) {
            AppMethodBeat.o(140841);
            return null;
        }
        synchronized (this.ogz) {
            try {
                remove = this.ogz.remove(k);
            } finally {
                AppMethodBeat.o(140841);
            }
        }
        return remove;
    }

    public final Map<K, Set<V>> bZl() {
        HashMap hashMap;
        AppMethodBeat.i(140842);
        synchronized (this.ogz) {
            try {
                hashMap = new HashMap(this.ogz);
            } finally {
                AppMethodBeat.o(140842);
            }
        }
        return hashMap;
    }
}
