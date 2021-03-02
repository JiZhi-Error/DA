package com.tencent.mm.plugin.finder.live.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/LinkInviteInfo;", "", "linkAnchorUsername", "", "linkObjectId", "", "linkLiveId", "linkAnchorNickname", "linkAnchorAvatarUrl", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "getLinkAnchorAvatarUrl", "()Ljava/lang/String;", "setLinkAnchorAvatarUrl", "(Ljava/lang/String;)V", "getLinkAnchorNickname", "setLinkAnchorNickname", "getLinkAnchorUsername", "setLinkAnchorUsername", "getLinkLiveId", "()J", "setLinkLiveId", "(J)V", "getLinkObjectId", "setLinkObjectId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
public final class h {
    public String hwh;
    public String hwi;
    public String hwj;
    public long uFp;
    public long uFq;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (kotlin.g.b.p.j(r5.hwj, r6.hwj) != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 248010(0x3c8ca, float:3.47536E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x003c
            boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.live.viewmodel.h
            if (r0 == 0) goto L_0x0041
            com.tencent.mm.plugin.finder.live.viewmodel.h r6 = (com.tencent.mm.plugin.finder.live.viewmodel.h) r6
            java.lang.String r0 = r5.hwh
            java.lang.String r1 = r6.hwh
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            long r0 = r5.uFp
            long r2 = r6.uFp
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0041
            long r0 = r5.uFq
            long r2 = r6.uFq
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0041
            java.lang.String r0 = r5.hwi
            java.lang.String r1 = r6.hwi
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r5.hwj
            java.lang.String r1 = r6.hwj
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
        L_0x003c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0040:
            return r0
        L_0x0041:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.h.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(248009);
        String str = this.hwh;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.uFp;
        long j3 = this.uFq;
        int i3 = ((((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str2 = this.hwi;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + i3) * 31;
        String str3 = this.hwj;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i4 = hashCode2 + i2;
        AppMethodBeat.o(248009);
        return i4;
    }

    public final String toString() {
        AppMethodBeat.i(248008);
        String str = "LinkInviteInfo(linkAnchorUsername=" + this.hwh + ", linkObjectId=" + this.uFp + ", linkLiveId=" + this.uFq + ", linkAnchorNickname=" + this.hwi + ", linkAnchorAvatarUrl=" + this.hwj + ")";
        AppMethodBeat.o(248008);
        return str;
    }

    private /* synthetic */ h() {
        this("", 0, 0, "", "");
        AppMethodBeat.i(248007);
        AppMethodBeat.o(248007);
    }

    public h(String str, long j2, long j3, String str2, String str3) {
        this.hwh = str;
        this.uFp = j2;
        this.uFq = j3;
        this.hwi = str2;
        this.hwj = str3;
    }
}
