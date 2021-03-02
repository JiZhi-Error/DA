package com.tencent.mm.plugin.mv.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCacheKey;", "", "feedId", "", "nonceId", "", "(JLjava/lang/String;)V", "getFeedId", "()J", "getNonceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-mv_release"})
public final class c {
    private final long feedId;
    private final String hwg;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (kotlin.g.b.p.j(r5.hwg, r6.hwg) != false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 256754(0x3eaf2, float:3.59789E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0020
            boolean r0 = r6 instanceof com.tencent.mm.plugin.mv.a.c
            if (r0 == 0) goto L_0x0025
            com.tencent.mm.plugin.mv.a.c r6 = (com.tencent.mm.plugin.mv.a.c) r6
            long r0 = r5.feedId
            long r2 = r6.feedId
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = r5.hwg
            java.lang.String r1 = r6.hwg
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0025
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.a.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(256753);
        long j2 = this.feedId;
        int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        String str = this.hwg;
        int hashCode = (str != null ? str.hashCode() : 0) + i2;
        AppMethodBeat.o(256753);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(256752);
        String str = "FinderFeedDetailCacheKey(feedId=" + this.feedId + ", nonceId=" + this.hwg + ")";
        AppMethodBeat.o(256752);
        return str;
    }

    public c(long j2, String str) {
        p.h(str, "nonceId");
        AppMethodBeat.i(256751);
        this.feedId = j2;
        this.hwg = str;
        AppMethodBeat.o(256751);
    }
}
