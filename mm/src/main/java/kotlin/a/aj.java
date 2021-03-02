package kotlin.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0013\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, hxF = {"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", FirebaseAnalytics.b.INDEX, "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class aj<T> extends c<T> {
    private final List<T> SXv;

    public aj(List<T> list) {
        p.h(list, "delegate");
        AppMethodBeat.i(129150);
        this.SXv = list;
        AppMethodBeat.o(129150);
    }

    @Override // kotlin.a.c
    public final int getSize() {
        AppMethodBeat.i(129144);
        int size = this.SXv.size();
        AppMethodBeat.o(129144);
        return size;
    }

    @Override // java.util.List, java.util.AbstractList
    public final T get(int i2) {
        AppMethodBeat.i(129145);
        T t = this.SXv.get(r.K(this, i2));
        AppMethodBeat.o(129145);
        return t;
    }

    public final void clear() {
        AppMethodBeat.i(129146);
        this.SXv.clear();
        AppMethodBeat.o(129146);
    }

    @Override // kotlin.a.c
    public final T removeAt(int i2) {
        AppMethodBeat.i(129147);
        T remove = this.SXv.remove(r.K(this, i2));
        AppMethodBeat.o(129147);
        return remove;
    }

    @Override // java.util.List, java.util.AbstractList
    public final T set(int i2, T t) {
        AppMethodBeat.i(129148);
        T t2 = this.SXv.set(r.K(this, i2), t);
        AppMethodBeat.o(129148);
        return t2;
    }

    @Override // java.util.List, java.util.AbstractList
    public final void add(int i2, T t) {
        AppMethodBeat.i(129149);
        List<T> list = this.SXv;
        int size = size();
        if (i2 >= 0 && size >= i2) {
            list.add(size() - i2, t);
            AppMethodBeat.o(129149);
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new f(0, size()) + "].");
        AppMethodBeat.o(129149);
        throw indexOutOfBoundsException;
    }
}
