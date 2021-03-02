package com.tencent.mm.live.view.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "", ch.COL_USERNAME, "", "memberCount", "", "(Ljava/lang/String;I)V", "getMemberCount", "()I", "setMemberCount", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-logic_release"})
public final class h {
    int dRN;
    String username;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r3.dRN == r4.dRN) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 208689(0x32f31, float:2.92436E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof com.tencent.mm.live.view.a.h
            if (r0 == 0) goto L_0x0023
            com.tencent.mm.live.view.a.h r4 = (com.tencent.mm.live.view.a.h) r4
            java.lang.String r0 = r3.username
            java.lang.String r1 = r4.username
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0023
            int r0 = r3.dRN
            int r1 = r4.dRN
            if (r0 != r1) goto L_0x0023
        L_0x001e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0022:
            return r0
        L_0x0023:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.view.a.h.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(208688);
        String str = this.username;
        int hashCode = ((str != null ? str.hashCode() : 0) * 31) + this.dRN;
        AppMethodBeat.o(208688);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(208687);
        String str = "ShareRoomItem(username=" + this.username + ", memberCount=" + this.dRN + ")";
        AppMethodBeat.o(208687);
        return str;
    }

    public h(String str, int i2) {
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(208686);
        this.username = str;
        this.dRN = i2;
        AppMethodBeat.o(208686);
    }
}
