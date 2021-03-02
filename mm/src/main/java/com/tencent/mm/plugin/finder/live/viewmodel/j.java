package com.tencent.mm.plugin.finder.live.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/ApplyPkAnchorInfo;", "", "sessionId", "", "anchorUsername", "anchorNickname", "anchorHeadUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorHeadUrl", "()Ljava/lang/String;", "getAnchorNickname", "getAnchorUsername", "getSessionId", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
public final class j {
    private final String UPK;
    private final String hwd;
    private final String sessionId;
    private final String uud;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (kotlin.g.b.p.j(r3.UPK, r4.UPK) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 261039(0x3fbaf, float:3.65794E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0036
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.viewmodel.j
            if (r0 == 0) goto L_0x003b
            com.tencent.mm.plugin.finder.live.viewmodel.j r4 = (com.tencent.mm.plugin.finder.live.viewmodel.j) r4
            java.lang.String r0 = r3.sessionId
            java.lang.String r1 = r4.sessionId
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r3.hwd
            java.lang.String r1 = r4.hwd
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r3.uud
            java.lang.String r1 = r4.uud
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r3.UPK
            java.lang.String r1 = r4.UPK
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
        L_0x0036:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x003a:
            return r0
        L_0x003b:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.j.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(261038);
        String str = this.sessionId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.hwd;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.uud;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.UPK;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode3 + i2;
        AppMethodBeat.o(261038);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(261037);
        String str = "ApplyPkAnchorInfo(sessionId=" + this.sessionId + ", anchorUsername=" + this.hwd + ", anchorNickname=" + this.uud + ", anchorHeadUrl=" + this.UPK + ")";
        AppMethodBeat.o(261037);
        return str;
    }

    public j(String str, String str2, String str3, String str4) {
        this.sessionId = str;
        this.hwd = str2;
        this.uud = str3;
        this.UPK = str4;
    }
}
