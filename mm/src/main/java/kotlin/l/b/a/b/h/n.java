package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class n extends AbstractList<String> implements RandomAccess, o {
    public static final o TDQ = new n().hJM();
    private final List<Object> list;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList
    public final /* bridge */ /* synthetic */ void add(int i2, String str) {
        AppMethodBeat.i(59513);
        this.list.add(i2, str);
        this.modCount++;
        AppMethodBeat.o(59513);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String set(int i2, String str) {
        AppMethodBeat.i(59514);
        String as = as(this.list.set(i2, str));
        AppMethodBeat.o(59514);
        return as;
    }

    static {
        AppMethodBeat.i(59516);
        AppMethodBeat.o(59516);
    }

    public n() {
        AppMethodBeat.i(59501);
        this.list = new ArrayList();
        AppMethodBeat.o(59501);
    }

    public n(o oVar) {
        AppMethodBeat.i(59502);
        this.list = new ArrayList(oVar.size());
        addAll(oVar);
        AppMethodBeat.o(59502);
    }

    public final int size() {
        AppMethodBeat.i(59503);
        int size = this.list.size();
        AppMethodBeat.o(59503);
        return size;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends String> collection) {
        AppMethodBeat.i(59504);
        boolean addAll = addAll(size(), collection);
        AppMethodBeat.o(59504);
        return addAll;
    }

    @Override // java.util.List, java.util.AbstractList
    public final boolean addAll(int i2, Collection<? extends String> collection) {
        AppMethodBeat.i(59505);
        if (collection instanceof o) {
            collection = ((o) collection).GQ();
        }
        boolean addAll = this.list.addAll(i2, collection);
        this.modCount++;
        AppMethodBeat.o(59505);
        return addAll;
    }

    public final void clear() {
        AppMethodBeat.i(59506);
        this.list.clear();
        this.modCount++;
        AppMethodBeat.o(59506);
    }

    @Override // kotlin.l.b.a.b.h.o
    public final void f(d dVar) {
        AppMethodBeat.i(59507);
        this.list.add(dVar);
        this.modCount++;
        AppMethodBeat.o(59507);
    }

    @Override // kotlin.l.b.a.b.h.o
    public final d avC(int i2) {
        d di;
        AppMethodBeat.i(59508);
        Object obj = this.list.get(i2);
        if (obj instanceof d) {
            di = (d) obj;
        } else if (obj instanceof String) {
            di = d.bud((String) obj);
        } else {
            di = d.di((byte[]) obj);
        }
        if (di != obj) {
            this.list.set(i2, di);
        }
        AppMethodBeat.o(59508);
        return di;
    }

    private static String as(Object obj) {
        AppMethodBeat.i(59509);
        if (obj instanceof String) {
            String str = (String) obj;
            AppMethodBeat.o(59509);
            return str;
        } else if (obj instanceof d) {
            String yO = ((d) obj).yO();
            AppMethodBeat.o(59509);
            return yO;
        } else {
            String G = j.G((byte[]) obj);
            AppMethodBeat.o(59509);
            return G;
        }
    }

    @Override // kotlin.l.b.a.b.h.o
    public final List<?> GQ() {
        AppMethodBeat.i(59510);
        List<?> unmodifiableList = Collections.unmodifiableList(this.list);
        AppMethodBeat.o(59510);
        return unmodifiableList;
    }

    @Override // kotlin.l.b.a.b.h.o
    public final o hJM() {
        AppMethodBeat.i(59511);
        x xVar = new x(this);
        AppMethodBeat.o(59511);
        return xVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String remove(int i2) {
        AppMethodBeat.i(59512);
        Object remove = this.list.remove(i2);
        this.modCount++;
        String as = as(remove);
        AppMethodBeat.o(59512);
        return as;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i2) {
        AppMethodBeat.i(59515);
        Object obj = this.list.get(i2);
        if (obj instanceof String) {
            String str = (String) obj;
            AppMethodBeat.o(59515);
            return str;
        } else if (obj instanceof d) {
            d dVar = (d) obj;
            String yO = dVar.yO();
            if (dVar.yP()) {
                this.list.set(i2, yO);
            }
            AppMethodBeat.o(59515);
            return yO;
        } else {
            byte[] bArr = (byte[]) obj;
            String G = j.G(bArr);
            if (j.F(bArr)) {
                this.list.set(i2, G);
            }
            AppMethodBeat.o(59515);
            return G;
        }
    }
}
