package kotlin.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b'\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0002J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, hxF = {"Lkotlin/collections/AbstractList;", QLog.TAG_REPORTLEVEL_USER, "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "get", FirebaseAnalytics.b.INDEX, "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"})
public abstract class b<E> extends a<E> implements List<E>, kotlin.g.b.a.a {
    public static final a SXf = new a((byte) 0);

    @Override // java.util.List
    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public abstract E get(int i2);

    @Override // java.util.List
    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected b() {
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new C2258b();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i2) {
        return new c(i2);
    }

    @Override // java.util.List
    public List<E> subList(int i2, int i3) {
        return new d(this, i2, i3);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, hxF = {"Lkotlin/collections/AbstractList$SubList;", QLog.TAG_REPORTLEVEL_USER, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", FirebaseAnalytics.b.INDEX, "(I)Ljava/lang/Object;", "kotlin-stdlib"})
    static final class d<E> extends b<E> implements RandomAccess {
        private final b<E> SXh;
        private final int SXi;
        private int _size;

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.a.b<? extends E> */
        /* JADX WARN: Multi-variable type inference failed */
        public d(b<? extends E> bVar, int i2, int i3) {
            p.h(bVar, "list");
            AppMethodBeat.i(129224);
            this.SXh = bVar;
            this.SXi = i2;
            int i4 = this.SXi;
            int size = this.SXh.size();
            if (i4 < 0 || i3 > size) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("fromIndex: " + i4 + ", toIndex: " + i3 + ", size: " + size);
                AppMethodBeat.o(129224);
                throw indexOutOfBoundsException;
            } else if (i4 > i3) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("fromIndex: " + i4 + " > toIndex: " + i3);
                AppMethodBeat.o(129224);
                throw illegalArgumentException;
            } else {
                this._size = i3 - this.SXi;
                AppMethodBeat.o(129224);
            }
        }

        @Override // kotlin.a.b, java.util.List
        public final E get(int i2) {
            AppMethodBeat.i(129223);
            int i3 = this._size;
            if (i2 < 0 || i2 >= i3) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
                AppMethodBeat.o(129223);
                throw indexOutOfBoundsException;
            }
            E e2 = this.SXh.get(this.SXi + i2);
            AppMethodBeat.o(129223);
            return e2;
        }

        @Override // kotlin.a.a
        public final int getSize() {
            return this._size;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        b<E> bVar = this;
        Collection collection = (Collection) obj;
        p.h(bVar, "c");
        p.h(collection, FacebookRequestErrorClassification.KEY_OTHER);
        if (bVar.size() != collection.size()) {
            return false;
        }
        Iterator<E> it = collection.iterator();
        for (E e2 : bVar) {
            if (!p.j(e2, it.next())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        b<E> bVar = this;
        p.h(bVar, "c");
        int i2 = 1;
        Iterator<E> it = bVar.iterator();
        while (it.hasNext()) {
            E next = it.next();
            i2 = (next != null ? next.hashCode() : 0) + (i2 * 31);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, hxF = {"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", FirebaseAnalytics.b.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    /* renamed from: kotlin.a.b$b  reason: collision with other inner class name */
    public class C2258b implements Iterator<E>, kotlin.g.b.a.a {
        int index;

        public void remove() {
            AppMethodBeat.i(129037);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(129037);
            throw unsupportedOperationException;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C2258b() {
        }

        public boolean hasNext() {
            AppMethodBeat.i(129035);
            if (this.index < b.this.size()) {
                AppMethodBeat.o(129035);
                return true;
            }
            AppMethodBeat.o(129035);
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            AppMethodBeat.i(129036);
            if (!hasNext()) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(129036);
                throw noSuchElementException;
            }
            b bVar = b.this;
            int i2 = this.index;
            this.index = i2 + 1;
            E e2 = (E) bVar.get(i2);
            AppMethodBeat.o(129036);
            return e2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\r\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, hxF = {"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", FirebaseAnalytics.b.INDEX, "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"})
    class c extends b<E>.C2258b implements ListIterator<E>, kotlin.g.b.a.a {
        @Override // java.util.ListIterator
        public final void add(E e2) {
            AppMethodBeat.i(129033);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(129033);
            throw unsupportedOperationException;
        }

        @Override // java.util.ListIterator
        public final void set(E e2) {
            AppMethodBeat.i(129034);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(129034);
            throw unsupportedOperationException;
        }

        public c(int i2) {
            super();
            AppMethodBeat.i(129032);
            a aVar = b.SXf;
            int size = b.this.size();
            if (i2 < 0 || i2 > size) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("index: " + i2 + ", size: " + size);
                AppMethodBeat.o(129032);
                throw indexOutOfBoundsException;
            }
            this.index = i2;
            AppMethodBeat.o(129032);
        }

        @Override // java.util.ListIterator
        public final E previous() {
            AppMethodBeat.i(129031);
            if (!hasPrevious()) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(129031);
                throw noSuchElementException;
            }
            this.index--;
            E e2 = (E) b.this.get(this.index);
            AppMethodBeat.o(129031);
            return e2;
        }

        public final boolean hasPrevious() {
            return this.index > 0;
        }

        public final int nextIndex() {
            return this.index;
        }

        public final int previousIndex() {
            return this.index - 1;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\tJ\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000eJ%\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0012J%\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0000¢\u0006\u0002\b\u0018J\u0019\u0010\u0019\u001a\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0000¢\u0006\u0002\b\u001a¨\u0006\u001b"}, hxF = {"Lkotlin/collections/AbstractList$Companion;", "", "()V", "checkBoundsIndexes", "", "startIndex", "", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", FirebaseAnalytics.b.INDEX, "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "orderedEquals", "", "c", "", FacebookRequestErrorClassification.KEY_OTHER, "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public int indexOf(Object obj) {
        int i2 = 0;
        for (E e2 : this) {
            if (p.j(e2, obj)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (p.j(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
