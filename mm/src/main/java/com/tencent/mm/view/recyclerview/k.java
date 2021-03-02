package com.tencent.mm.view.recyclerview;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, hxF = {"Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "", "convertData", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "exposeTimestamp", "", "(Lcom/tencent/mm/view/recyclerview/ConvertData;J)V", "getConvertData", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "dataPos", "", "getDataPos", "()I", "setDataPos", "(I)V", "getExposeTimestamp", "()J", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "libmmui_release"})
public final class k {
    public final a Rrp;
    public final long Rrq;
    public int tIv;
    i tIw;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r5.Rrq == r6.Rrq) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 205055(0x320ff, float:2.87343E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0020
            boolean r0 = r6 instanceof com.tencent.mm.view.recyclerview.k
            if (r0 == 0) goto L_0x0025
            com.tencent.mm.view.recyclerview.k r6 = (com.tencent.mm.view.recyclerview.k) r6
            com.tencent.mm.view.recyclerview.a r0 = r5.Rrp
            com.tencent.mm.view.recyclerview.a r1 = r6.Rrp
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0025
            long r0 = r5.Rrq
            long r2 = r6.Rrq
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0025
        L_0x0020:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0024:
            return r0
        L_0x0025:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.view.recyclerview.k.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(205054);
        a aVar = this.Rrp;
        int hashCode = aVar != null ? aVar.hashCode() : 0;
        long j2 = this.Rrq;
        int i2 = (hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)));
        AppMethodBeat.o(205054);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(205053);
        String str = "WxRVDataItem(convertData=" + this.Rrp + ", exposeTimestamp=" + this.Rrq + ")";
        AppMethodBeat.o(205053);
        return str;
    }

    public /* synthetic */ k(a aVar) {
        this(aVar, cl.aWA());
        AppMethodBeat.i(205052);
        AppMethodBeat.o(205052);
    }

    private k(a aVar, long j2) {
        p.h(aVar, "convertData");
        AppMethodBeat.i(205051);
        this.Rrp = aVar;
        this.Rrq = j2;
        AppMethodBeat.o(205051);
    }
}
