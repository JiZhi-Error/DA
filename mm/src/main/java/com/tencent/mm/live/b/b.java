package com.tencent.mm.live.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "", "liveId", "", "micId", "", "uid", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLiveId", "()J", "getMicId", "()Ljava/lang/String;", "getRoomId", "getSdkUid", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-logic_release"})
public final class b {
    public final String hFF;
    public final String hFG;
    public final String hFz;
    public final long liveId;
    public final String roomId;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (kotlin.g.b.p.j(r5.hFG, r6.hFG) != false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 207555(0x32ac3, float:2.90847E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x003e
            boolean r0 = r6 instanceof com.tencent.mm.live.b.b
            if (r0 == 0) goto L_0x0043
            com.tencent.mm.live.b.b r6 = (com.tencent.mm.live.b.b) r6
            long r0 = r5.liveId
            long r2 = r6.liveId
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0043
            java.lang.String r0 = r5.hFz
            java.lang.String r1 = r6.hFz
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = r5.hFF
            java.lang.String r1 = r6.hFF
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = r5.roomId
            java.lang.String r1 = r6.roomId
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = r5.hFG
            java.lang.String r1 = r6.hFG
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0043
        L_0x003e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0042:
            return r0
        L_0x0043:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(207554);
        long j2 = this.liveId;
        int i3 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        String str = this.hFz;
        int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
        String str2 = this.hFF;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.roomId;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.hFG;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i4 = hashCode3 + i2;
        AppMethodBeat.o(207554);
        return i4;
    }

    public final String toString() {
        AppMethodBeat.i(207553);
        String str = "ApplyLiveMicInfo(liveId=" + this.liveId + ", micId=" + this.hFz + ", uid=" + this.hFF + ", roomId=" + this.roomId + ", sdkUid=" + this.hFG + ")";
        AppMethodBeat.o(207553);
        return str;
    }

    public b(long j2, String str, String str2, String str3, String str4) {
        this.liveId = j2;
        this.hFz = str;
        this.hFF = str2;
        this.roomId = str3;
        this.hFG = str4;
    }
}
