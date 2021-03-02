package com.tencent.mm.view.recyclerview;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006$"}, hxF = {"Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "associatedObject", "(Lcom/tencent/mm/view/recyclerview/ConvertData;)V", "adapterPosition", "", "getAdapterPosition", "()I", "setAdapterPosition", "(I)V", "getAssociatedObject", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "exposeTime", "getExposeTime", "setExposeTime", "startTime", "getStartTime", "setStartTime", "component1", "copy", "(Lcom/tencent/mm/view/recyclerview/ConvertData;)Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "libmmui_release"})
public final class b<T extends a> {
    public int Qgj = -1;
    public final T RqA;
    public long endTime = -1;
    public long startTime = -1;
    public long wVY = -1;

    public b(T t) {
        p.h(t, "associatedObject");
        AppMethodBeat.i(205033);
        this.RqA = t;
        AppMethodBeat.o(205033);
    }

    public final int hashCode() {
        AppMethodBeat.i(205030);
        int lT = (int) this.RqA.lT();
        AppMethodBeat.o(205030);
        return lT;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(205031);
        if (!(obj instanceof b) || !(this == obj || this.RqA.lT() == ((b) obj).RqA.lT())) {
            AppMethodBeat.o(205031);
            return false;
        }
        AppMethodBeat.o(205031);
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(205032);
        String str = "\n" + ("adapterPosition = " + this.Qgj) + "\n" + ("exposeTime = " + this.wVY) + "\n" + ("startTime = " + this.startTime) + "\n" + ("endTime = " + this.endTime) + "\n";
        p.g(str, "StringBuilder().append(\"…)\n            .toString()");
        AppMethodBeat.o(205032);
        return str;
    }
}
