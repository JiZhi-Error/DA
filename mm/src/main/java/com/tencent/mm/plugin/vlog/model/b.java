package com.tencent.mm.plugin.vlog.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/ABAVideoInfo;", "", "path", "", "videoStart", "", "videoEnd", "(Ljava/lang/String;JJ)V", "getPath", "()Ljava/lang/String;", "getVideoEnd", "()J", "getVideoStart", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-vlog_release"})
public final class b {
    final long GwX;
    final long GwY;
    final String path;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r5.GwY == r6.GwY) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 190479(0x2e80f, float:2.66918E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0028
            boolean r0 = r6 instanceof com.tencent.mm.plugin.vlog.model.b
            if (r0 == 0) goto L_0x002d
            com.tencent.mm.plugin.vlog.model.b r6 = (com.tencent.mm.plugin.vlog.model.b) r6
            java.lang.String r0 = r5.path
            java.lang.String r1 = r6.path
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
            long r0 = r5.GwX
            long r2 = r6.GwX
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
            long r0 = r5.GwY
            long r2 = r6.GwY
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
        L_0x0028:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x002c:
            return r0
        L_0x002d:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(190478);
        String str = this.path;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.GwX;
        long j3 = this.GwY;
        int i2 = (((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        AppMethodBeat.o(190478);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(190477);
        String str = "ABAVideoInfo(path=" + this.path + ", videoStart=" + this.GwX + ", videoEnd=" + this.GwY + ")";
        AppMethodBeat.o(190477);
        return str;
    }

    public b(String str, long j2, long j3) {
        p.h(str, "path");
        AppMethodBeat.i(190476);
        this.path = str;
        this.GwX = j2;
        this.GwY = j3;
        AppMethodBeat.o(190476);
    }
}
