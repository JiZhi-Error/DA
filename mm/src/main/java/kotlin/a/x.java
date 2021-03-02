package kotlin.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.a.a;
import kotlin.g.b.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0016\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, hxF = {"Lkotlin/collections/EmptySet;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", MessengerShareContentUtility.ELEMENTS, "", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "isEmpty", "iterator", "", "readResolve", "toString", "", "kotlin-stdlib"})
public final class x implements Serializable, Set, a {
    public static final x SXt = new x();

    @Override // java.util.Collection, java.util.Set
    public final /* synthetic */ boolean add(Object obj) {
        AppMethodBeat.i(129058);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129058);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        AppMethodBeat.i(129053);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129053);
        throw unsupportedOperationException;
    }

    public final void clear() {
        AppMethodBeat.i(129054);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129054);
        throw unsupportedOperationException;
    }

    public final boolean remove(Object obj) {
        AppMethodBeat.i(129055);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129055);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        AppMethodBeat.i(129056);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129056);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        AppMethodBeat.i(129057);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129057);
        throw unsupportedOperationException;
    }

    public final Object[] toArray() {
        AppMethodBeat.i(129059);
        Object[] w = i.w(this);
        AppMethodBeat.o(129059);
        return w;
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        AppMethodBeat.i(129060);
        T[] tArr2 = (T[]) i.a(this, tArr);
        AppMethodBeat.o(129060);
        return tArr2;
    }

    static {
        AppMethodBeat.i(129052);
        AppMethodBeat.o(129052);
    }

    private x() {
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(129050);
        if (!(obj instanceof Void)) {
            AppMethodBeat.o(129050);
        } else {
            p.h((Void) obj, "element");
            AppMethodBeat.o(129050);
        }
        return false;
    }

    public final /* bridge */ int size() {
        return 0;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(129049);
        if (!(obj instanceof Set) || !((Set) obj).isEmpty()) {
            AppMethodBeat.o(129049);
            return false;
        }
        AppMethodBeat.o(129049);
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "[]";
    }

    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        AppMethodBeat.i(129051);
        p.h(collection, MessengerShareContentUtility.ELEMENTS);
        boolean isEmpty = collection.isEmpty();
        AppMethodBeat.o(129051);
        return isEmpty;
    }

    @Override // java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator iterator() {
        return u.SXq;
    }

    private final Object readResolve() {
        return SXt;
    }
}
