package com.tencent.mm.plugin.finder.live.util;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "", "key", "", "value", "", "times", "(Ljava/lang/String;II)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getTimes", "()I", "setTimes", "(I)V", "getValue", "setValue", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
public final class i {
    int hjI;
    public String key;
    public int value;

    public i() {
        this(null, 0, 7);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r3.hjI == r4.hjI) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 247246(0x3c5ce, float:3.46465E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0024
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.util.i
            if (r0 == 0) goto L_0x0029
            com.tencent.mm.plugin.finder.live.util.i r4 = (com.tencent.mm.plugin.finder.live.util.i) r4
            java.lang.String r0 = r3.key
            java.lang.String r1 = r4.key
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0029
            int r0 = r3.value
            int r1 = r4.value
            if (r0 != r1) goto L_0x0029
            int r0 = r3.hjI
            int r1 = r4.hjI
            if (r0 != r1) goto L_0x0029
        L_0x0024:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0028:
            return r0
        L_0x0029:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.util.i.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(247245);
        String str = this.key;
        int hashCode = ((((str != null ? str.hashCode() : 0) * 31) + this.value) * 31) + this.hjI;
        AppMethodBeat.o(247245);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(247244);
        String str = "CachePair(key=" + this.key + ", value=" + this.value + ", times=" + this.hjI + ")";
        AppMethodBeat.o(247244);
        return str;
    }

    private i(String str, int i2) {
        p.h(str, "key");
        AppMethodBeat.i(247242);
        this.key = str;
        this.value = i2;
        this.hjI = 0;
        AppMethodBeat.o(247242);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, int i2, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i2);
        AppMethodBeat.i(247243);
        AppMethodBeat.o(247243);
    }
}
