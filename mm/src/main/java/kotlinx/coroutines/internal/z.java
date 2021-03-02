package kotlinx.coroutines.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Comparable;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.an;
import kotlinx.coroutines.internal.aa;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\u0018\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000602j\u0002`3B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\tJ.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\f0\u000bH\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0005J\u0011\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b \u0010\u0012J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0010¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0010¢\u0006\u0004\b$\u0010#J\u001f\u0010&\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'R \u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0013\u0010*\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u00100\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00198F@BX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u0010#¨\u00061"}, hxF = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", FirebaseAnalytics.b.INDEX, "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"})
public class z<T extends aa & Comparable<? super T>> {
    public T[] TWs;
    public volatile int _size = 0;

    public final T hNU() {
        T[] tArr = this.TWs;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final T avW(int i2) {
        boolean z;
        AppMethodBeat.i(118067);
        if (an.hMK()) {
            if (!(this._size > 0)) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(118067);
                throw assertionError;
            }
        }
        T[] tArr = this.TWs;
        if (tArr == null) {
            p.hyc();
        }
        this._size--;
        if (i2 < this._size) {
            nd(i2, this._size);
            int i3 = (i2 - 1) / 2;
            if (i2 > 0) {
                T t = tArr[i2];
                if (t == null) {
                    p.hyc();
                }
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i3];
                if (t2 == null) {
                    p.hyc();
                }
                if (comparable.compareTo(t2) < 0) {
                    nd(i2, i3);
                    avX(i3);
                }
            }
            avY(i2);
        }
        T t3 = tArr[this._size];
        if (t3 == null) {
            p.hyc();
        }
        if (an.hMK()) {
            if (t3.hNf() == this) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                AssertionError assertionError2 = new AssertionError();
                AppMethodBeat.o(118067);
                throw assertionError2;
            }
        }
        t3.a(null);
        t3.setIndex(-1);
        tArr[this._size] = null;
        AppMethodBeat.o(118067);
        return t3;
    }

    public final void avX(int i2) {
        AppMethodBeat.i(118068);
        while (i2 > 0) {
            T[] tArr = this.TWs;
            if (tArr == null) {
                p.hyc();
            }
            int i3 = (i2 - 1) / 2;
            T t = tArr[i3];
            if (t == null) {
                p.hyc();
            }
            Comparable comparable = (Comparable) t;
            T t2 = tArr[i2];
            if (t2 == null) {
                p.hyc();
            }
            if (comparable.compareTo(t2) <= 0) {
                AppMethodBeat.o(118068);
                return;
            } else {
                nd(i2, i3);
                i2 = i3;
            }
        }
        AppMethodBeat.o(118068);
    }

    private final void avY(int i2) {
        AppMethodBeat.i(118069);
        while (true) {
            int i3 = (i2 * 2) + 1;
            if (i3 >= this._size) {
                AppMethodBeat.o(118069);
                return;
            }
            T[] tArr = this.TWs;
            if (tArr == null) {
                p.hyc();
            }
            if (i3 + 1 < this._size) {
                T t = tArr[i3 + 1];
                if (t == null) {
                    p.hyc();
                }
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i3];
                if (t2 == null) {
                    p.hyc();
                }
                if (comparable.compareTo(t2) < 0) {
                    i3++;
                }
            }
            T t3 = tArr[i2];
            if (t3 == null) {
                p.hyc();
            }
            Comparable comparable2 = (Comparable) t3;
            T t4 = tArr[i3];
            if (t4 == null) {
                p.hyc();
            }
            if (comparable2.compareTo(t4) <= 0) {
                AppMethodBeat.o(118069);
                return;
            } else {
                nd(i2, i3);
                i2 = i3;
            }
        }
    }

    private final void nd(int i2, int i3) {
        AppMethodBeat.i(118070);
        T[] tArr = this.TWs;
        if (tArr == null) {
            p.hyc();
        }
        T t = tArr[i3];
        if (t == null) {
            p.hyc();
        }
        T t2 = tArr[i2];
        if (t2 == null) {
            p.hyc();
        }
        tArr[i2] = t;
        tArr[i3] = t2;
        t.setIndex(i2);
        t2.setIndex(i3);
        AppMethodBeat.o(118070);
    }

    public final T hNS() {
        T hNU;
        AppMethodBeat.i(118065);
        synchronized (this) {
            try {
                hNU = hNU();
            } finally {
                AppMethodBeat.o(118065);
            }
        }
        return hNU;
    }

    public final T hNT() {
        T t;
        AppMethodBeat.i(192449);
        synchronized (this) {
            try {
                if (this._size > 0) {
                    t = avW(0);
                } else {
                    t = null;
                }
            } finally {
                AppMethodBeat.o(192449);
            }
        }
        return t;
    }

    public final boolean a(T t) {
        boolean z = false;
        AppMethodBeat.i(118066);
        synchronized (this) {
            try {
                if (t.hNf() != null) {
                    int index = t.getIndex();
                    if (an.hMK()) {
                        if (index >= 0) {
                            z = true;
                        }
                        if (!z) {
                            AssertionError assertionError = new AssertionError();
                            AppMethodBeat.o(118066);
                            throw assertionError;
                        }
                    }
                    avW(index);
                    z = true;
                }
            } finally {
                AppMethodBeat.o(118066);
            }
        }
        return z;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }
}
