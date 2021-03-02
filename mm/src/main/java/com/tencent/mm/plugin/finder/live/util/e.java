package com.tencent.mm.plugin.finder.live.util;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "", "key", "", "valueCount", "", "times", "", "averageValue", "(Ljava/lang/String;JIJ)V", "getAverageValue", "()J", "setAverageValue", "(J)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getTimes", "()I", "setTimes", "(I)V", "getValueCount", "setValueCount", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
public final class e {
    int hjI;
    private String key;
    long uvZ;
    public long uwa;

    public e() {
        this(null, 15);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r5.uwa == r6.uwa) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 247233(0x3c5c1, float:3.46447E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x002e
            boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.live.util.e
            if (r0 == 0) goto L_0x0033
            com.tencent.mm.plugin.finder.live.util.e r6 = (com.tencent.mm.plugin.finder.live.util.e) r6
            java.lang.String r0 = r5.key
            java.lang.String r1 = r6.key
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0033
            long r0 = r5.uvZ
            long r2 = r6.uvZ
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0033
            int r0 = r5.hjI
            int r1 = r6.hjI
            if (r0 != r1) goto L_0x0033
            long r0 = r5.uwa
            long r2 = r6.uwa
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0033
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.util.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(247232);
        String str = this.key;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.uvZ;
        long j3 = this.uwa;
        int i2 = (((((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.hjI) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        AppMethodBeat.o(247232);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(247231);
        String str = "AverageCachePair(key=" + this.key + ", valueCount=" + this.uvZ + ", times=" + this.hjI + ", averageValue=" + this.uwa + ")";
        AppMethodBeat.o(247231);
        return str;
    }

    private e(String str) {
        p.h(str, "key");
        AppMethodBeat.i(247229);
        this.key = str;
        this.uvZ = 0;
        this.hjI = 0;
        this.uwa = 0;
        AppMethodBeat.o(247229);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(String str, int i2) {
        this((i2 & 1) != 0 ? "" : str);
        AppMethodBeat.i(247230);
        AppMethodBeat.o(247230);
    }
}
