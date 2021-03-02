package kotlin.a;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.g.b.b;
import kotlin.g.b.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0002J\u0015\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0004¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, hxF = {"Lkotlin/collections/ArrayAsCollection;", "T", "", "values", "", "isVarargs", "", "([Ljava/lang/Object;Z)V", "()Z", "size", "", "getSize", "()I", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", MessengerShareContentUtility.ELEMENTS, "isEmpty", "iterator", "", "toArray", "", "kotlin-stdlib"})
final class d<T> implements Collection<T>, a {
    private final boolean SXj;
    private final T[] apH;

    @Override // java.util.Collection
    public final boolean add(T t) {
        AppMethodBeat.i(129068);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129068);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        AppMethodBeat.i(129069);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129069);
        throw unsupportedOperationException;
    }

    public final void clear() {
        AppMethodBeat.i(129070);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129070);
        throw unsupportedOperationException;
    }

    public final boolean remove(Object obj) {
        AppMethodBeat.i(129071);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129071);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(129072);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129072);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(129073);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129073);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        AppMethodBeat.i(129074);
        T[] tArr2 = (T[]) i.a(this, tArr);
        AppMethodBeat.o(129074);
        return tArr2;
    }

    public d(T[] tArr, boolean z) {
        p.h(tArr, "values");
        AppMethodBeat.i(129067);
        this.apH = tArr;
        this.SXj = z;
        AppMethodBeat.o(129067);
    }

    public final boolean isEmpty() {
        return this.apH.length == 0;
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(129063);
        boolean contains = e.contains(this.apH, obj);
        AppMethodBeat.o(129063);
        return contains;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(129064);
        p.h(collection, MessengerShareContentUtility.ELEMENTS);
        Collection<? extends Object> collection2 = collection;
        if (!collection2.isEmpty()) {
            Iterator<T> it = collection2.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    AppMethodBeat.o(129064);
                    return false;
                }
            }
        }
        AppMethodBeat.o(129064);
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        AppMethodBeat.i(129065);
        Iterator<T> af = b.af(this.apH);
        AppMethodBeat.o(129065);
        return af;
    }

    public final Object[] toArray() {
        AppMethodBeat.i(129066);
        T[] tArr = this.apH;
        boolean z = this.SXj;
        p.h(tArr, "$this$copyToArrayOfAny");
        if (!z || !p.j(tArr.getClass(), Object[].class)) {
            Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
            p.g(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
            AppMethodBeat.o(129066);
            return copyOf;
        }
        AppMethodBeat.o(129066);
        return tArr;
    }

    public final /* bridge */ int size() {
        return this.apH.length;
    }
}
