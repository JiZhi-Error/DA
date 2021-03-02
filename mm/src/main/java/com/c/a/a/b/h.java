package com.c.a.a.b;

import com.c.a.a.a.a;
import com.c.a.a.a.b;
import com.c.a.a.a.e;
import com.c.a.a.a.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class h {
    private static r<Object> coo = new r<Object>() {
        /* class com.c.a.a.b.h.AnonymousClass1 */

        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public final Object next() {
            throw new NoSuchElementException();
        }

        public final boolean hasPrevious() {
            return false;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            throw new NoSuchElementException();
        }

        public final int nextIndex() {
            return 0;
        }

        public final int previousIndex() {
            return -1;
        }
    };
    private static final Iterator<Object> cop = new Iterator<Object>() {
        /* class com.c.a.a.b.h.AnonymousClass2 */

        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw new NoSuchElementException();
        }

        public final void remove() {
            a.bN(false);
        }
    };

    static <T> Iterator<T> JW() {
        return (Iterator<T>) cop;
    }

    public static boolean a(Iterator<?> it, Collection<?> collection) {
        e d2 = f.d(collection);
        a.checkNotNull(d2);
        boolean z = false;
        while (it.hasNext()) {
            if (d2.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <F, T> Iterator<T> a(Iterator<F> it, final b<? super F, ? extends T> bVar) {
        a.checkNotNull(bVar);
        return new p<F, T>(it) {
            /* class com.c.a.a.b.h.AnonymousClass3 */

            /* access modifiers changed from: package-private */
            @Override // com.c.a.a.b.p
            public final T aA(F f2) {
                return (T) bVar.apply(f2);
            }
        };
    }

    static void a(Iterator<?> it) {
        a.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
}
