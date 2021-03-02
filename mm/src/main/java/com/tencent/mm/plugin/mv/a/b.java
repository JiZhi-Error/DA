package com.tencent.mm.plugin.mv.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ars;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCache;", "", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", AppMeasurement.Param.TIMESTAMP, "", "(Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;J)V", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-mv_release"})
public final class b {
    final ars Apk;
    final long timestamp;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r5.timestamp == r6.timestamp) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 256750(0x3eaee, float:3.59783E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0020
            boolean r0 = r6 instanceof com.tencent.mm.plugin.mv.a.b
            if (r0 == 0) goto L_0x0025
            com.tencent.mm.plugin.mv.a.b r6 = (com.tencent.mm.plugin.mv.a.b) r6
            com.tencent.mm.protocal.protobuf.ars r0 = r5.Apk
            com.tencent.mm.protocal.protobuf.ars r1 = r6.Apk
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0025
            long r0 = r5.timestamp
            long r2 = r6.timestamp
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.a.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(256749);
        ars ars = this.Apk;
        int hashCode = ars != null ? ars.hashCode() : 0;
        long j2 = this.timestamp;
        int i2 = (hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)));
        AppMethodBeat.o(256749);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(256748);
        String str = "FinderFeedDetailCache(response=" + this.Apk + ", timestamp=" + this.timestamp + ")";
        AppMethodBeat.o(256748);
        return str;
    }

    public b(ars ars, long j2) {
        p.h(ars, "response");
        AppMethodBeat.i(256747);
        this.Apk = ars;
        this.timestamp = j2;
        AppMethodBeat.o(256747);
    }
}
