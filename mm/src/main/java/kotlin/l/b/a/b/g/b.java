package kotlin.l.b.a.b.g;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.a.a;
import kotlin.g.b.i;
import kotlin.g.b.p;

public final class b implements Collection<a>, a {
    final Set<a> TDm;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Collection
    public final /* synthetic */ boolean add(a aVar) {
        AppMethodBeat.i(59354);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(59354);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends a> collection) {
        AppMethodBeat.i(59349);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(59349);
        throw unsupportedOperationException;
    }

    public final void clear() {
        AppMethodBeat.i(59350);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(59350);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(59346);
        p.h(collection, MessengerShareContentUtility.ELEMENTS);
        boolean containsAll = this.TDm.containsAll(collection);
        AppMethodBeat.o(59346);
        return containsAll;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(59347);
        boolean isEmpty = this.TDm.isEmpty();
        AppMethodBeat.o(59347);
        return isEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<a> iterator() {
        AppMethodBeat.i(59348);
        Iterator<a> it = this.TDm.iterator();
        AppMethodBeat.o(59348);
        return it;
    }

    public final boolean remove(Object obj) {
        AppMethodBeat.i(59351);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(59351);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(59352);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(59352);
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(59353);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(59353);
        throw unsupportedOperationException;
    }

    public final Object[] toArray() {
        AppMethodBeat.i(59355);
        Object[] w = i.w(this);
        AppMethodBeat.o(59355);
        return w;
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        AppMethodBeat.i(59356);
        T[] tArr2 = (T[]) i.a(this, tArr);
        AppMethodBeat.o(59356);
        return tArr2;
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(59345);
        if (!(obj instanceof a)) {
            AppMethodBeat.o(59345);
            return false;
        }
        a aVar = (a) obj;
        p.h(aVar, "element");
        boolean contains = this.TDm.contains(aVar);
        AppMethodBeat.o(59345);
        return contains;
    }

    public final String toString() {
        AppMethodBeat.i(59341);
        p.h(this, "$this$presentableDescription");
        String a2 = j.a(this.TDm, FilePathGenerator.ANDROID_DIR_SEP, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        AppMethodBeat.o(59341);
        return a2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(59342);
        if (this == obj) {
            AppMethodBeat.o(59342);
            return true;
        } else if (!(obj instanceof b)) {
            AppMethodBeat.o(59342);
            return false;
        } else if (!p.j(this.TDm, ((b) obj).TDm)) {
            AppMethodBeat.o(59342);
            return false;
        } else {
            AppMethodBeat.o(59342);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(59343);
        int hashCode = this.TDm.hashCode();
        AppMethodBeat.o(59343);
        return hashCode;
    }

    public final /* bridge */ int size() {
        AppMethodBeat.i(59344);
        int size = this.TDm.size();
        AppMethodBeat.o(59344);
        return size;
    }
}
