package kotlin.a;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.i;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H¦\u0002J\u0015\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0015¢\u0006\u0002\u0010\u0014J'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0012\"\u0004\b\u0001\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0012H\u0014¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, hxF = {"Lkotlin/collections/AbstractCollection;", QLog.TAG_REPORTLEVEL_USER, "", "()V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", MessengerShareContentUtility.ELEMENTS, "isEmpty", "iterator", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "kotlin-stdlib"})
public abstract class a<E> implements Collection<E>, kotlin.g.b.a.a {
    @Override // java.util.Collection
    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int getSize();

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected a() {
    }

    public final int size() {
        return getSize();
    }

    public boolean contains(Object obj) {
        if (!isEmpty()) {
            for (E e2 : this) {
                if (p.j(e2, obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        p.h(collection, MessengerShareContentUtility.ELEMENTS);
        Collection<? extends Object> collection2 = collection;
        if (!collection2.isEmpty()) {
            Iterator<T> it = collection2.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        return j.a(this, ", ", "[", "]", 0, (CharSequence) null, new C2257a(this), 24);
    }

    public Object[] toArray() {
        return i.w(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        p.h(tArr, "array");
        T[] tArr2 = (T[]) i.a(this, tArr);
        if (tArr2 != null) {
            return tArr2;
        }
        throw new t("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", QLog.TAG_REPORTLEVEL_USER, LocaleUtil.ITALIAN, "invoke", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"})
    /* renamed from: kotlin.a.a$a  reason: collision with other inner class name */
    static final class C2257a extends q implements b<E, CharSequence> {
        final /* synthetic */ a SXe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2257a(a aVar) {
            super(1);
            this.SXe = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* synthetic */ CharSequence invoke(Object obj) {
            AppMethodBeat.i(129007);
            if (obj == this.SXe) {
                AppMethodBeat.o(129007);
                return r0;
            }
            String valueOf = String.valueOf(obj);
            AppMethodBeat.o(129007);
            return valueOf;
        }
    }
}