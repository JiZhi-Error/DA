package kotlin.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.g.b.a.a;
import kotlin.g.b.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0016\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0011\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020&H\u0016R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006'"}, hxF = {"Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", MessengerShareContentUtility.ELEMENTS, "", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "get", FirebaseAnalytics.b.INDEX, "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "readResolve", "subList", "fromIndex", "toIndex", "toString", "", "kotlin-stdlib"})
public final class v implements Serializable, List, RandomAccess, a {
    public static final v SXr = new v();

    @Override // java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        AppMethodBeat.i(129168);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129168);
        throw unsupportedOperationException;
    }

    @Override // java.util.List, java.util.Collection
    public final /* synthetic */ boolean add(Object obj) {
        AppMethodBeat.i(129167);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129167);
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        AppMethodBeat.i(129161);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129161);
        throw unsupportedOperationException;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        AppMethodBeat.i(129162);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129162);
        throw unsupportedOperationException;
    }

    public final void clear() {
        AppMethodBeat.i(129163);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129163);
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final /* synthetic */ Object remove(int i2) {
        AppMethodBeat.i(129169);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129169);
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final boolean remove(Object obj) {
        AppMethodBeat.i(129164);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129164);
        throw unsupportedOperationException;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        AppMethodBeat.i(129165);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129165);
        throw unsupportedOperationException;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        AppMethodBeat.i(129166);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129166);
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        AppMethodBeat.i(129170);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(129170);
        throw unsupportedOperationException;
    }

    public final Object[] toArray() {
        AppMethodBeat.i(129171);
        Object[] w = i.w(this);
        AppMethodBeat.o(129171);
        return w;
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        AppMethodBeat.i(129172);
        T[] tArr2 = (T[]) i.a(this, tArr);
        AppMethodBeat.o(129172);
        return tArr2;
    }

    static {
        AppMethodBeat.i(129160);
        AppMethodBeat.o(129160);
    }

    private v() {
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(129153);
        if (!(obj instanceof Void)) {
            AppMethodBeat.o(129153);
        } else {
            p.h((Void) obj, "element");
            AppMethodBeat.o(129153);
        }
        return false;
    }

    public final int indexOf(Object obj) {
        AppMethodBeat.i(129156);
        if (!(obj instanceof Void)) {
            AppMethodBeat.o(129156);
        } else {
            p.h((Void) obj, "element");
            AppMethodBeat.o(129156);
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        AppMethodBeat.i(129157);
        if (!(obj instanceof Void)) {
            AppMethodBeat.o(129157);
        } else {
            p.h((Void) obj, "element");
            AppMethodBeat.o(129157);
        }
        return -1;
    }

    public final /* bridge */ int size() {
        return 0;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(129152);
        if (!(obj instanceof List) || !((List) obj).isEmpty()) {
            AppMethodBeat.o(129152);
            return false;
        }
        AppMethodBeat.o(129152);
        return true;
    }

    public final int hashCode() {
        return 1;
    }

    public final String toString() {
        return "[]";
    }

    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        AppMethodBeat.i(129154);
        p.h(collection, MessengerShareContentUtility.ELEMENTS);
        boolean isEmpty = collection.isEmpty();
        AppMethodBeat.o(129154);
        return isEmpty;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return u.SXq;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return u.SXq;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i2) {
        AppMethodBeat.i(129158);
        if (i2 != 0) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Index: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(129158);
            throw indexOutOfBoundsException;
        }
        u uVar = u.SXq;
        AppMethodBeat.o(129158);
        return uVar;
    }

    @Override // java.util.List
    public final List subList(int i2, int i3) {
        AppMethodBeat.i(129159);
        if (i2 == 0 && i3 == 0) {
            v vVar = this;
            AppMethodBeat.o(129159);
            return vVar;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3);
        AppMethodBeat.o(129159);
        throw indexOutOfBoundsException;
    }

    private final Object readResolve() {
        return SXr;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i2) {
        AppMethodBeat.i(129155);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i2 + '.');
        AppMethodBeat.o(129155);
        throw indexOutOfBoundsException;
    }
}
