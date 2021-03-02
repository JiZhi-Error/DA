package com.tencent.mm.plugin.finder.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.cmm;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000H\u0002J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "", "feedId", "", "isRead", "", AppMeasurement.Param.TIMESTAMP, "stat", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "(JZJLcom/tencent/mm/protocal/protobuf/MarkReadStat;)V", "getFeedId", "()J", "()Z", "setRead", "(Z)V", "getStat", "()Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "setStat", "(Lcom/tencent/mm/protocal/protobuf/MarkReadStat;)V", "getTimestamp", "compareTo", "", FacebookRequestErrorClassification.KEY_OTHER, "component1", "component2", "component3", "component4", "copy", "equals", "", "hashCode", "toString", "", "plugin-finder_release"})
public final class bq implements Comparable<bq> {
    final long feedId;
    private final long timestamp;
    boolean uPa;
    cmm uPb;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (kotlin.g.b.p.j(r5.uPb, r6.uPb) != false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 248875(0x3cc2b, float:3.48748E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x002e
            boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.model.bq
            if (r0 == 0) goto L_0x0033
            com.tencent.mm.plugin.finder.model.bq r6 = (com.tencent.mm.plugin.finder.model.bq) r6
            long r0 = r5.feedId
            long r2 = r6.feedId
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0033
            boolean r0 = r5.uPa
            boolean r1 = r6.uPa
            if (r0 != r1) goto L_0x0033
            long r0 = r5.timestamp
            long r2 = r6.timestamp
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0033
            com.tencent.mm.protocal.protobuf.cmm r0 = r5.uPb
            com.tencent.mm.protocal.protobuf.cmm r1 = r6.uPb
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0033
        L_0x002e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0032:
            return r0
        L_0x0033:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.model.bq.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(248874);
        long j2 = this.feedId;
        int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        boolean z = this.uPa;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        long j3 = this.timestamp;
        int i6 = (((i3 + i2) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        cmm cmm = this.uPb;
        int hashCode = (cmm != null ? cmm.hashCode() : 0) + i6;
        AppMethodBeat.o(248874);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(248873);
        String str = "StreamMarkReadStat(feedId=" + this.feedId + ", isRead=" + this.uPa + ", timestamp=" + this.timestamp + ", stat=" + this.uPb + ")";
        AppMethodBeat.o(248873);
        return str;
    }

    public /* synthetic */ bq(long j2) {
        this(j2, cl.aWA());
        AppMethodBeat.i(248872);
        AppMethodBeat.o(248872);
    }

    private bq(long j2, long j3) {
        this.feedId = j2;
        this.uPa = false;
        this.timestamp = j3;
        this.uPb = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(bq bqVar) {
        AppMethodBeat.i(248871);
        bq bqVar2 = bqVar;
        p.h(bqVar2, FacebookRequestErrorClassification.KEY_OTHER);
        int i2 = (int) (bqVar2.timestamp - this.timestamp);
        AppMethodBeat.o(248871);
        return i2;
    }
}
