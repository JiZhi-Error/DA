package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.b.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class h<K extends m, V> {
    private final a<K, V> aIo = new a<>();
    private final Map<K, a<K, V>> aIp = new HashMap();

    h() {
        AppMethodBeat.i(77087);
        AppMethodBeat.o(77087);
    }

    public final void a(K k, V v) {
        AppMethodBeat.i(77088);
        a<K, V> aVar = this.aIp.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.aIp.put(k, aVar);
        } else {
            k.pb();
        }
        aVar.add(v);
        AppMethodBeat.o(77088);
    }

    public final V b(K k) {
        AppMethodBeat.i(77089);
        a<K, V> aVar = this.aIp.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.aIp.put(k, aVar);
        } else {
            k.pb();
        }
        a(aVar);
        V removeLast = aVar.removeLast();
        AppMethodBeat.o(77089);
        return removeLast;
    }

    public final V removeLast() {
        AppMethodBeat.i(77090);
        for (a<K, V> aVar = this.aIo.aIs; !aVar.equals(this.aIo); aVar = aVar.aIs) {
            V removeLast = aVar.removeLast();
            if (removeLast != null) {
                AppMethodBeat.o(77090);
                return removeLast;
            }
            d(aVar);
            this.aIp.remove(aVar.key);
            aVar.key.pb();
        }
        AppMethodBeat.o(77090);
        return null;
    }

    public final String toString() {
        AppMethodBeat.i(77091);
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.aIo.aIr; !aVar.equals(this.aIo); aVar = aVar.aIr) {
            z = true;
            sb.append('{').append((Object) aVar.key).append(':').append(aVar.size()).append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        String sb2 = sb.append(" )").toString();
        AppMethodBeat.o(77091);
        return sb2;
    }

    private void a(a<K, V> aVar) {
        AppMethodBeat.i(77092);
        d(aVar);
        aVar.aIs = this.aIo;
        aVar.aIr = this.aIo.aIr;
        c(aVar);
        AppMethodBeat.o(77092);
    }

    private void b(a<K, V> aVar) {
        AppMethodBeat.i(77093);
        d(aVar);
        aVar.aIs = this.aIo.aIs;
        aVar.aIr = this.aIo;
        c(aVar);
        AppMethodBeat.o(77093);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.aIr.aIs = aVar;
        aVar.aIs.aIr = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.aIs.aIr = aVar.aIr;
        aVar.aIr.aIs = aVar.aIs;
    }

    /* access modifiers changed from: package-private */
    public static class a<K, V> {
        private List<V> aIq;
        a<K, V> aIr;
        a<K, V> aIs;
        final K key;

        a() {
            this(null);
        }

        a(K k) {
            AppMethodBeat.i(77083);
            this.aIs = this;
            this.aIr = this;
            this.key = k;
            AppMethodBeat.o(77083);
        }

        public final V removeLast() {
            AppMethodBeat.i(77084);
            int size = size();
            if (size > 0) {
                V remove = this.aIq.remove(size - 1);
                AppMethodBeat.o(77084);
                return remove;
            }
            AppMethodBeat.o(77084);
            return null;
        }

        public final int size() {
            AppMethodBeat.i(77085);
            if (this.aIq != null) {
                int size = this.aIq.size();
                AppMethodBeat.o(77085);
                return size;
            }
            AppMethodBeat.o(77085);
            return 0;
        }

        public final void add(V v) {
            AppMethodBeat.i(77086);
            if (this.aIq == null) {
                this.aIq = new ArrayList();
            }
            this.aIq.add(v);
            AppMethodBeat.o(77086);
        }
    }
}
