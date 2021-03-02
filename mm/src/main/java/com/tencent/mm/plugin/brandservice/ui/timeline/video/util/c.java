package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J;\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u00106\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\tHÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\rR\u001a\u0010!\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001a\u0010$\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "", "id", "", "startTime", "", "endTime", "minShowTime", "url", "", "(IDDDLjava/lang/String;)V", "canCreateTime", "getCanCreateTime", "()D", "setCanCreateTime", "(D)V", "end", "", "getEnd", "()Z", "setEnd", "(Z)V", "getEndTime", "hasShow", "getHasShow", "setHasShow", "getId", "()I", "isBeforeCurrentTime", "setBeforeCurrentTime", "isShowControlBar", "setShowControlBar", "getMinShowTime", "needAdjustHeight", "getNeedAdjustHeight", "setNeedAdjustHeight", "needDestroyNotInDotArea", "getNeedDestroyNotInDotArea", "setNeedDestroyNotInDotArea", "posInfo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;", "getPosInfo", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;", "setPosInfo", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;)V", "getStartTime", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-brandservice_release"})
public final class c {
    public boolean dvh;
    public final int id;
    double pKm = (this.pKu - this.pKv);
    public boolean pKn;
    public boolean pKo;
    public boolean pKp;
    public boolean pKq;
    public boolean pKr;
    public d pKs = new d();
    public final double pKt;
    public final double pKu;
    private final double pKv;
    public final String url;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (kotlin.g.b.p.j(r5.url, r6.url) != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 7287(0x1c77, float:1.0211E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x003b
            boolean r0 = r6 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c
            if (r0 == 0) goto L_0x0040
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c r6 = (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c) r6
            int r0 = r5.id
            int r1 = r6.id
            if (r0 != r1) goto L_0x0040
            double r0 = r5.pKt
            double r2 = r6.pKt
            int r0 = java.lang.Double.compare(r0, r2)
            if (r0 != 0) goto L_0x0040
            double r0 = r5.pKu
            double r2 = r6.pKu
            int r0 = java.lang.Double.compare(r0, r2)
            if (r0 != 0) goto L_0x0040
            double r0 = r5.pKv
            double r2 = r6.pKv
            int r0 = java.lang.Double.compare(r0, r2)
            if (r0 != 0) goto L_0x0040
            java.lang.String r0 = r5.url
            java.lang.String r1 = r6.url
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0040
        L_0x003b:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x003f:
            return r0
        L_0x0040:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(7286);
        long doubleToLongBits = Double.doubleToLongBits(this.pKt);
        long doubleToLongBits2 = Double.doubleToLongBits(this.pKu);
        long doubleToLongBits3 = Double.doubleToLongBits(this.pKv);
        int i2 = ((((((this.id * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31;
        String str = this.url;
        int hashCode = (str != null ? str.hashCode() : 0) + i2;
        AppMethodBeat.o(7286);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(7285);
        String str = "BizVideoDotInfo(id=" + this.id + ", startTime=" + this.pKt + ", endTime=" + this.pKu + ", minShowTime=" + this.pKv + ", url=" + this.url + ")";
        AppMethodBeat.o(7285);
        return str;
    }

    public c(int i2, double d2, double d3, double d4, String str) {
        p.h(str, "url");
        AppMethodBeat.i(7284);
        this.id = i2;
        this.pKt = d2;
        this.pKu = d3;
        this.pKv = d4;
        this.url = str;
        AppMethodBeat.o(7284);
    }
}
