package kotlin.g.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000eR\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lkotlin/jvm/internal/ArrayIterator;", "T", "", "array", "", "([Ljava/lang/Object;)V", "getArray", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", FirebaseAnalytics.b.INDEX, "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class a<T> implements Iterator<T>, kotlin.g.b.a.a {
    private final T[] SYh;
    private int index;

    public final void remove() {
        AppMethodBeat.i(129330);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129330);
        throw unsupportedOperationException;
    }

    public a(T[] tArr) {
        p.h(tArr, "array");
        AppMethodBeat.i(129329);
        this.SYh = tArr;
        AppMethodBeat.o(129329);
    }

    public final boolean hasNext() {
        return this.index < this.SYh.length;
    }

    @Override // java.util.Iterator
    public final T next() {
        AppMethodBeat.i(129328);
        try {
            T[] tArr = this.SYh;
            int i2 = this.index;
            this.index = i2 + 1;
            T t = tArr[i2];
            AppMethodBeat.o(129328);
            return t;
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.index--;
            NoSuchElementException noSuchElementException = new NoSuchElementException(e2.getMessage());
            AppMethodBeat.o(129328);
            throw noSuchElementException;
        }
    }
}
