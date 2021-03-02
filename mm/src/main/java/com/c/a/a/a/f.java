package com.c.a.a.a;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

public final class f {
    private static final a cnP = new a(",");

    public static <T> e<T> d(Collection<? extends T> collection) {
        return new a(collection, (byte) 0);
    }

    /* access modifiers changed from: package-private */
    public static class a<T> implements e<T>, Serializable {
        private final Collection<?> cnQ;

        /* synthetic */ a(Collection collection, byte b2) {
            this(collection);
        }

        private a(Collection<?> collection) {
            this.cnQ = (Collection) a.checkNotNull(collection);
        }

        @Override // com.c.a.a.a.e
        public final boolean apply(@Nullable T t) {
            try {
                return this.cnQ.contains(t);
            } catch (ClassCastException | NullPointerException e2) {
                return false;
            }
        }

        public final boolean equals(@Nullable Object obj) {
            if (obj instanceof a) {
                return this.cnQ.equals(((a) obj).cnQ);
            }
            return false;
        }

        public final int hashCode() {
            return this.cnQ.hashCode();
        }

        public final String toString() {
            return "Predicates.in(" + this.cnQ + ")";
        }
    }
}
