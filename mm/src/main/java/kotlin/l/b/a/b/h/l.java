package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;

public final class l extends m {
    private final q TDL;

    public final q hJL() {
        AppMethodBeat.i(59495);
        q d2 = d(this.TDL);
        AppMethodBeat.o(59495);
        return d2;
    }

    public final int hashCode() {
        AppMethodBeat.i(59496);
        int hashCode = hJL().hashCode();
        AppMethodBeat.o(59496);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(59497);
        boolean equals = hJL().equals(obj);
        AppMethodBeat.o(59497);
        return equals;
    }

    public final String toString() {
        AppMethodBeat.i(59498);
        String obj = hJL().toString();
        AppMethodBeat.o(59498);
        return obj;
    }

    static class a<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, l> bXF;

        /* synthetic */ a(Map.Entry entry, byte b2) {
            this(entry);
        }

        private a(Map.Entry<K, l> entry) {
            this.bXF = entry;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            AppMethodBeat.i(59489);
            K key = this.bXF.getKey();
            AppMethodBeat.o(59489);
            return key;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            AppMethodBeat.i(59490);
            l value = this.bXF.getValue();
            if (value == null) {
                AppMethodBeat.o(59490);
                return null;
            }
            q hJL = value.hJL();
            AppMethodBeat.o(59490);
            return hJL;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            AppMethodBeat.i(59491);
            if (!(obj instanceof q)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
                AppMethodBeat.o(59491);
                throw illegalArgumentException;
            }
            q e2 = this.bXF.getValue().e((q) obj);
            AppMethodBeat.o(59491);
            return e2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> bXG;

        public b(Iterator<Map.Entry<K, Object>> it) {
            this.bXG = it;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(59492);
            boolean hasNext = this.bXG.hasNext();
            AppMethodBeat.o(59492);
            return hasNext;
        }

        public final void remove() {
            AppMethodBeat.i(59493);
            this.bXG.remove();
            AppMethodBeat.o(59493);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            AppMethodBeat.i(59494);
            Map.Entry<K, Object> next = this.bXG.next();
            if (next.getValue() instanceof l) {
                a aVar = new a(next, (byte) 0);
                AppMethodBeat.o(59494);
                return aVar;
            }
            AppMethodBeat.o(59494);
            return next;
        }
    }
}
