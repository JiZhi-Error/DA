package com.tencent.mm.live.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "", "LiveId", "", "enableComment", "", "wording", "", "(JILjava/lang/String;)V", "getLiveId", "()J", "getEnableComment", "()I", "getWording", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-logic_release"})
public final class c {
    public final String dQx;
    public final long hFH;
    public final int hFI;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (kotlin.g.b.p.j(r5.dQx, r6.dQx) != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 207558(0x32ac6, float:2.90851E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0026
            boolean r0 = r6 instanceof com.tencent.mm.live.b.c
            if (r0 == 0) goto L_0x002b
            com.tencent.mm.live.b.c r6 = (com.tencent.mm.live.b.c) r6
            long r0 = r5.hFH
            long r2 = r6.hFH
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002b
            int r0 = r5.hFI
            int r1 = r6.hFI
            if (r0 != r1) goto L_0x002b
            java.lang.String r0 = r5.dQx
            java.lang.String r1 = r6.dQx
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002b
        L_0x0026:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x002a:
            return r0
        L_0x002b:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(207557);
        long j2 = this.hFH;
        int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + this.hFI) * 31;
        String str = this.dQx;
        int hashCode = (str != null ? str.hashCode() : 0) + i2;
        AppMethodBeat.o(207557);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(207556);
        String str = "BanLiveCommentInfo(LiveId=" + this.hFH + ", enableComment=" + this.hFI + ", wording=" + this.dQx + ")";
        AppMethodBeat.o(207556);
        return str;
    }

    public c(long j2, int i2, String str) {
        this.hFH = j2;
        this.hFI = i2;
        this.dQx = str;
    }
}
