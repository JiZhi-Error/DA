package com.google.a;

import java.util.Iterator;
import java.util.Map;

public final class ah extends ai {
    private final aw bXE;

    public ah(aw awVar, r rVar, g gVar) {
        super(rVar, gVar);
        this.bXE = awVar;
    }

    public final aw GO() {
        return g(this.bXE);
    }

    @Override // com.google.a.ai
    public final int hashCode() {
        return GO().hashCode();
    }

    @Override // com.google.a.ai
    public final boolean equals(Object obj) {
        return GO().equals(obj);
    }

    public final String toString() {
        return GO().toString();
    }

    /* access modifiers changed from: package-private */
    public static class a<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, ah> bXF;

        /* synthetic */ a(Map.Entry entry, byte b2) {
            this(entry);
        }

        private a(Map.Entry<K, ah> entry) {
            this.bXF = entry;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.bXF.getKey();
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            ah value = this.bXF.getValue();
            if (value == null) {
                return null;
            }
            return value.GO();
        }

        public final ah GP() {
            return this.bXF.getValue();
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (obj instanceof aw) {
                return this.bXF.getValue().h((aw) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* access modifiers changed from: package-private */
    public static class b<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> bXG;

        public b(Iterator<Map.Entry<K, Object>> it) {
            this.bXG = it;
        }

        public final boolean hasNext() {
            return this.bXG.hasNext();
        }

        public final void remove() {
            this.bXG.remove();
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            Map.Entry<K, Object> next = this.bXG.next();
            return next.getValue() instanceof ah ? new a(next, (byte) 0) : next;
        }
    }
}
