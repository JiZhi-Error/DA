package com.tencent.mm.live.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, hxF = {"Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "", "liveId", "", "audience", "", "headImg", "nickName", "sdkUid", "micId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "getHeadImg", "getLiveId", "()J", "getMicId", "getNickName", "getSdkUid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-logic_release"})
public final class q {
    public final String hFG;
    public final String hFJ;
    public final String hFz;
    public final String hIc;
    public final long liveId;
    public final String nickName;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (kotlin.g.b.p.j(r5.hFz, r6.hFz) != false) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 207655(0x32b27, float:2.90987E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0048
            boolean r0 = r6 instanceof com.tencent.mm.live.b.q
            if (r0 == 0) goto L_0x004d
            com.tencent.mm.live.b.q r6 = (com.tencent.mm.live.b.q) r6
            long r0 = r5.liveId
            long r2 = r6.liveId
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x004d
            java.lang.String r0 = r5.hFJ
            java.lang.String r1 = r6.hFJ
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = r5.hIc
            java.lang.String r1 = r6.hIc
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = r5.nickName
            java.lang.String r1 = r6.nickName
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = r5.hFG
            java.lang.String r1 = r6.hFG
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = r5.hFz
            java.lang.String r1 = r6.hFz
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x004d
        L_0x0048:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x004c:
            return r0
        L_0x004d:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.q.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(207654);
        long j2 = this.liveId;
        int i3 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        String str = this.hFJ;
        int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
        String str2 = this.hIc;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.nickName;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.hFG;
        int hashCode4 = ((str4 != null ? str4.hashCode() : 0) + hashCode3) * 31;
        String str5 = this.hFz;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i4 = hashCode4 + i2;
        AppMethodBeat.o(207654);
        return i4;
    }

    public final String toString() {
        AppMethodBeat.i(207653);
        String str = "LiveMicSuccessInfo(liveId=" + this.liveId + ", audience=" + this.hFJ + ", headImg=" + this.hIc + ", nickName=" + this.nickName + ", sdkUid=" + this.hFG + ", micId=" + this.hFz + ")";
        AppMethodBeat.o(207653);
        return str;
    }

    public q(long j2, String str, String str2, String str3, String str4, String str5) {
        this.liveId = j2;
        this.hFJ = str;
        this.hIc = str2;
        this.nickName = str3;
        this.hFG = str4;
        this.hFz = str5;
    }
}
