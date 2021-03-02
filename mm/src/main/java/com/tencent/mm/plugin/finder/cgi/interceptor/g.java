package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "T", "", "interceptor", "order", "", "(Ljava/lang/Object;I)V", "getInterceptor", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getOrder", "()I", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "plugin-finder_release"})
public final class g<T> {
    public final int order;
    public final T txH;

    public g(T t, int i2) {
        this.txH = t;
        this.order = i2;
    }

    public final int hashCode() {
        AppMethodBeat.i(242634);
        T t = this.txH;
        if (t != null) {
            int hashCode = t.hashCode();
            AppMethodBeat.o(242634);
            return hashCode;
        }
        AppMethodBeat.o(242634);
        return 0;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(242635);
        boolean j2 = p.j(this.txH, obj);
        AppMethodBeat.o(242635);
        return j2;
    }
}
