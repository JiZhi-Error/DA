package com.tencent.mm.live.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "", "liveId", "", "audience", "", "micId", "sdkUserId", "micType", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAudience", "()Ljava/lang/String;", "getLiveId", "()J", "getMicId", "getMicType", "()I", "getSdkUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-logic_release"})
public final class f {
    public final String hFJ;
    public final String hFz;
    public final long liveId;
    public final String uCo;
    public final int uCx;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (r5.uCx == r6.uCx) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 207563(0x32acb, float:2.90858E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x003a
            boolean r0 = r6 instanceof com.tencent.mm.live.b.f
            if (r0 == 0) goto L_0x003f
            com.tencent.mm.live.b.f r6 = (com.tencent.mm.live.b.f) r6
            long r0 = r5.liveId
            long r2 = r6.liveId
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003f
            java.lang.String r0 = r5.hFJ
            java.lang.String r1 = r6.hFJ
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003f
            java.lang.String r0 = r5.hFz
            java.lang.String r1 = r6.hFz
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003f
            java.lang.String r0 = r5.uCo
            java.lang.String r1 = r6.uCo
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003f
            int r0 = r5.uCx
            int r1 = r6.uCx
            if (r0 != r1) goto L_0x003f
        L_0x003a:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x003e:
            return r0
        L_0x003f:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(207562);
        long j2 = this.liveId;
        int i3 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        String str = this.hFJ;
        int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
        String str2 = this.hFz;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.uCo;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i4 = ((hashCode2 + i2) * 31) + this.uCx;
        AppMethodBeat.o(207562);
        return i4;
    }

    public final String toString() {
        AppMethodBeat.i(207561);
        String str = "CloseLiveMicInfo(liveId=" + this.liveId + ", audience=" + this.hFJ + ", micId=" + this.hFz + ", sdkUserId=" + this.uCo + ", micType=" + this.uCx + ")";
        AppMethodBeat.o(207561);
        return str;
    }

    public /* synthetic */ f(long j2, String str, String str2) {
        this(j2, str, str2, null, 0);
    }

    public f(long j2, String str, String str2, String str3, int i2) {
        this.liveId = j2;
        this.hFJ = str;
        this.hFz = str2;
        this.uCo = str3;
        this.uCx = i2;
    }
}
