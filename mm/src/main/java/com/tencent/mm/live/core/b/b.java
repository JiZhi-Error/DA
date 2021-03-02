package com.tencent.mm.live.core.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/live/core/render/FilterConfig;", "", "filterKey", "", "filterPath", "", "filterValue", "(ILjava/lang/String;I)V", "getFilterKey", "()I", "setFilterKey", "(I)V", "getFilterPath", "()Ljava/lang/String;", "setFilterPath", "(Ljava/lang/String;)V", "getFilterValue", "setFilterValue", "component1", "component2", "component3", "copy", "enableFilter", "", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-core_release"})
public final class b {
    public int hDi;
    public String hDj;
    public int hDk;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r3.hDk == r4.hDk) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 196615(0x30007, float:2.75516E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0024
            boolean r0 = r4 instanceof com.tencent.mm.live.core.b.b
            if (r0 == 0) goto L_0x0029
            com.tencent.mm.live.core.b.b r4 = (com.tencent.mm.live.core.b.b) r4
            int r0 = r3.hDi
            int r1 = r4.hDi
            if (r0 != r1) goto L_0x0029
            java.lang.String r0 = r3.hDj
            java.lang.String r1 = r4.hDj
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0029
            int r0 = r3.hDk
            int r1 = r4.hDk
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.core.b.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(196614);
        int i2 = this.hDi * 31;
        String str = this.hDj;
        int hashCode = (((str != null ? str.hashCode() : 0) + i2) * 31) + this.hDk;
        AppMethodBeat.o(196614);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(196613);
        String str = "FilterConfig(filterKey=" + this.hDi + ", filterPath=" + this.hDj + ", filterValue=" + this.hDk + ")";
        AppMethodBeat.o(196613);
        return str;
    }

    public b(int i2, String str, int i3) {
        this.hDi = i2;
        this.hDj = str;
        this.hDk = i3;
    }

    public final boolean aEv() {
        AppMethodBeat.i(196612);
        if (this.hDk < 0 || !s.YS(this.hDj)) {
            AppMethodBeat.o(196612);
            return false;
        }
        AppMethodBeat.o(196612);
        return true;
    }
}
