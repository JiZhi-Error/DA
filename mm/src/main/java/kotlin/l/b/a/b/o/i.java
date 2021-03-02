package kotlin.l.b.a.b.o;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.g.b.a.d;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.t;

public final class i<T> extends AbstractSet<T> {
    public static final b TSf = new b((byte) 0);
    private Object data;
    private int size;

    static {
        AppMethodBeat.i(61401);
        AppMethodBeat.o(61401);
    }

    public static final <T> i<T> hLZ() {
        AppMethodBeat.i(61402);
        i<T> hLZ = b.hLZ();
        AppMethodBeat.o(61402);
        return hLZ;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static <T> i<T> hLZ() {
            AppMethodBeat.i(61395);
            i<T> iVar = new i<>((byte) 0);
            AppMethodBeat.o(61395);
            return iVar;
        }
    }

    private i() {
    }

    public /* synthetic */ i(byte b2) {
        this();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<T> iterator() {
        AppMethodBeat.i(61398);
        if (size() == 0) {
            Iterator<T> it = Collections.emptySet().iterator();
            AppMethodBeat.o(61398);
            return it;
        } else if (size() == 1) {
            c cVar = new c(this.data);
            AppMethodBeat.o(61398);
            return cVar;
        } else if (size() < 5) {
            Object obj = this.data;
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(61398);
                throw tVar;
            }
            a aVar = new a((Object[]) obj);
            AppMethodBeat.o(61398);
            return aVar;
        } else {
            Object obj2 = this.data;
            if (obj2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
                AppMethodBeat.o(61398);
                throw tVar2;
            }
            Iterator<T> it2 = af.fb(obj2).iterator();
            AppMethodBeat.o(61398);
            return it2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: java.util.LinkedHashSet */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(T t) {
        i<T> iVar;
        Object[] objArr;
        AppMethodBeat.i(61399);
        if (size() == 0) {
            this.data = t;
        } else if (size() == 1) {
            if (p.j(this.data, t)) {
                AppMethodBeat.o(61399);
                return false;
            }
            this.data = new Object[]{this.data, t};
        } else if (size() < 5) {
            Object obj = this.data;
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(61399);
                throw tVar;
            }
            Object[] objArr2 = (Object[]) obj;
            if (e.contains(objArr2, t)) {
                AppMethodBeat.o(61399);
                return false;
            }
            if (size() == 4) {
                Object[] copyOf = Arrays.copyOf(objArr2, objArr2.length);
                p.h(copyOf, MessengerShareContentUtility.ELEMENTS);
                LinkedHashSet linkedHashSet = (LinkedHashSet) e.b(copyOf, new LinkedHashSet(ae.atJ(copyOf.length)));
                linkedHashSet.add(t);
                iVar = this;
                objArr = linkedHashSet;
            } else {
                Object[] copyOf2 = Arrays.copyOf(objArr2, size() + 1);
                p.g(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
                copyOf2[copyOf2.length - 1] = t;
                iVar = this;
                objArr = copyOf2;
            }
            iVar.data = objArr;
        } else {
            Object obj2 = this.data;
            if (obj2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
                AppMethodBeat.o(61399);
                throw tVar2;
            } else if (!af.fb(obj2).add(t)) {
                AppMethodBeat.o(61399);
                return false;
            }
        }
        this.size = size() + 1;
        AppMethodBeat.o(61399);
        return true;
    }

    public final void clear() {
        this.data = null;
        this.size = 0;
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(61400);
        if (size() == 0) {
            AppMethodBeat.o(61400);
            return false;
        } else if (size() == 1) {
            boolean j2 = p.j(this.data, obj);
            AppMethodBeat.o(61400);
            return j2;
        } else if (size() < 5) {
            Object obj2 = this.data;
            if (obj2 == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(61400);
                throw tVar;
            }
            boolean contains = e.contains((Object[]) obj2, obj);
            AppMethodBeat.o(61400);
            return contains;
        } else {
            Object obj3 = this.data;
            if (obj3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.collections.Set<T>");
                AppMethodBeat.o(61400);
                throw tVar2;
            }
            boolean contains2 = ((Set) obj3).contains(obj);
            AppMethodBeat.o(61400);
            return contains2;
        }
    }

    static final class c<T> implements Iterator<T>, d {
        private final T SYG;
        private boolean SYY = true;

        public c(T t) {
            this.SYG = t;
        }

        @Override // java.util.Iterator
        public final T next() {
            AppMethodBeat.i(61396);
            if (this.SYY) {
                this.SYY = false;
                T t = this.SYG;
                AppMethodBeat.o(61396);
                return t;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            AppMethodBeat.o(61396);
            throw noSuchElementException;
        }

        public final boolean hasNext() {
            return this.SYY;
        }

        public final /* synthetic */ void remove() {
            AppMethodBeat.i(61397);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61397);
            throw unsupportedOperationException;
        }
    }

    static final class a<T> implements Iterator<T>, d {
        private final Iterator<T> TSg;

        public a(T[] tArr) {
            p.h(tArr, "array");
            AppMethodBeat.i(61394);
            this.TSg = kotlin.g.b.b.af(tArr);
            AppMethodBeat.o(61394);
        }

        public final boolean hasNext() {
            AppMethodBeat.i(61391);
            boolean hasNext = this.TSg.hasNext();
            AppMethodBeat.o(61391);
            return hasNext;
        }

        @Override // java.util.Iterator
        public final T next() {
            AppMethodBeat.i(61392);
            T next = this.TSg.next();
            AppMethodBeat.o(61392);
            return next;
        }

        public final /* synthetic */ void remove() {
            AppMethodBeat.i(61393);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(61393);
            throw unsupportedOperationException;
        }
    }

    public final /* bridge */ int size() {
        return this.size;
    }
}
