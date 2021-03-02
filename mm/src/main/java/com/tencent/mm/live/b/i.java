package com.tencent.mm.live.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/live/model/FinderLiveCloseLiveMicInfo;", "", "liveId", "", "objectId", "liveMicId", "", "seq", "businessType", "", "(JJLjava/lang/String;Ljava/lang/String;I)V", "getBusinessType", "()I", "getLiveId", "()J", "getLiveMicId", "()Ljava/lang/String;", "getObjectId", "getSeq", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-logic_release"})
public final class i {
    private final int businessType;
    private final long hFK;
    public final String hFO;
    private final long liveId;
    private final String seq;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r5.businessType == r6.businessType) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 207572(0x32ad4, float:2.9087E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0038
            boolean r0 = r6 instanceof com.tencent.mm.live.b.i
            if (r0 == 0) goto L_0x003d
            com.tencent.mm.live.b.i r6 = (com.tencent.mm.live.b.i) r6
            long r0 = r5.liveId
            long r2 = r6.liveId
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003d
            long r0 = r5.hFK
            long r2 = r6.hFK
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003d
            java.lang.String r0 = r5.hFO
            java.lang.String r1 = r6.hFO
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = r5.seq
            java.lang.String r1 = r6.seq
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
            int r0 = r5.businessType
            int r1 = r6.businessType
            if (r0 != r1) goto L_0x003d
        L_0x0038:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x003c:
            return r0
        L_0x003d:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.i.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(207571);
        long j2 = this.liveId;
        long j3 = this.hFK;
        int i3 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.hFO;
        int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
        String str2 = this.seq;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i4 = ((hashCode + i2) * 31) + this.businessType;
        AppMethodBeat.o(207571);
        return i4;
    }

    public final String toString() {
        AppMethodBeat.i(207570);
        String str = "FinderLiveCloseLiveMicInfo(liveId=" + this.liveId + ", objectId=" + this.hFK + ", liveMicId=" + this.hFO + ", seq=" + this.seq + ", businessType=" + this.businessType + ")";
        AppMethodBeat.o(207570);
        return str;
    }

    public i(long j2, long j3, String str, String str2, int i2) {
        this.liveId = j2;
        this.hFK = j3;
        this.hFO = str;
        this.seq = str2;
        this.businessType = i2;
    }
}
