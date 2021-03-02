package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "T", "", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "newObj", "pool", "Ljava/util/LinkedList;", "get", "()Ljava/lang/Object;", "put", "", "view", "(Ljava/lang/Object;)Z", "plugin-brandservice_release"})
public final class i<T> {
    private final LinkedList<T> puj = new LinkedList<>();
    private a<? extends T> puk;

    public i(a<? extends T> aVar) {
        p.h(aVar, "callback");
        AppMethodBeat.i(195284);
        this.puk = aVar;
        AppMethodBeat.o(195284);
    }

    public final boolean da(T t) {
        AppMethodBeat.i(195282);
        boolean add = this.puj.add(t);
        AppMethodBeat.o(195282);
        return add;
    }

    public final T get() {
        AppMethodBeat.i(195283);
        T remove = this.puj.size() > 0 ? this.puj.remove(0) : (T) this.puk.invoke();
        AppMethodBeat.o(195283);
        return remove;
    }
}
