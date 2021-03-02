package com.tencent.mm.plugin.finder.live.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.thumbplayer.api.TPOptionalID;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003JQ\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\b\u0010,\u001a\u00020-H\u0016R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "", "localStatus", "", "localRemainTime", "haveLottering", "", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "lastDoneLottery", "cardShowing", "bubbleFinsh", "(IIZLcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;ZZZ)V", "getBubbleFinsh", "()Z", "setBubbleFinsh", "(Z)V", "getCardShowing", "setCardShowing", "getHaveLottering", "setHaveLottering", "getLastDoneLottery", "setLastDoneLottery", "getLocalRemainTime", "()I", "setLocalRemainTime", "(I)V", "getLocalStatus", "setLocalStatus", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "setLotteryInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
public final class i {
    public awi tWe;
    public int uFr;
    public boolean uFs;
    public boolean uFt;
    public boolean uFu;
    public boolean uFv;
    public int uhD;

    public i() {
        this(0, 0, null, false, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        if (r3.uFv == r4.uFv) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 248014(0x3c8ce, float:3.47542E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x003c
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.viewmodel.i
            if (r0 == 0) goto L_0x0041
            com.tencent.mm.plugin.finder.live.viewmodel.i r4 = (com.tencent.mm.plugin.finder.live.viewmodel.i) r4
            int r0 = r3.uhD
            int r1 = r4.uhD
            if (r0 != r1) goto L_0x0041
            int r0 = r3.uFr
            int r1 = r4.uFr
            if (r0 != r1) goto L_0x0041
            boolean r0 = r3.uFs
            boolean r1 = r4.uFs
            if (r0 != r1) goto L_0x0041
            com.tencent.mm.protocal.protobuf.awi r0 = r3.tWe
            com.tencent.mm.protocal.protobuf.awi r1 = r4.tWe
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            boolean r0 = r3.uFt
            boolean r1 = r4.uFt
            if (r0 != r1) goto L_0x0041
            boolean r0 = r3.uFu
            boolean r1 = r4.uFu
            if (r0 != r1) goto L_0x0041
            boolean r0 = r3.uFv
            boolean r1 = r4.uFv
            if (r0 != r1) goto L_0x0041
        L_0x003c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0040:
            return r0
        L_0x0041:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.i.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 1;
        AppMethodBeat.i(248013);
        int i3 = ((this.uhD * 31) + this.uFr) * 31;
        boolean z = this.uFs;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i4 + i3) * 31;
        awi awi = this.tWe;
        int hashCode = ((awi != null ? awi.hashCode() : 0) + i7) * 31;
        boolean z2 = this.uFt;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i8 + hashCode) * 31;
        boolean z3 = this.uFu;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (i12 + i11) * 31;
        boolean z4 = this.uFv;
        if (!z4) {
            i2 = z4 ? 1 : 0;
        }
        int i16 = i15 + i2;
        AppMethodBeat.o(248013);
        return i16;
    }

    private i(int i2, int i3, awi awi, boolean z) {
        this.uhD = i2;
        this.uFr = i3;
        this.uFs = false;
        this.tWe = awi;
        this.uFt = z;
        this.uFu = false;
        this.uFv = false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(int i2, int i3, awi awi, boolean z, int i4) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? -1 : i3, (i4 & 8) != 0 ? null : awi, (i4 & 16) != 0 ? false : z);
        AppMethodBeat.i(248012);
        AppMethodBeat.o(248012);
    }

    public final String toString() {
        AppMethodBeat.i(248011);
        StringBuilder append = new StringBuilder("localStatus:").append(this.uhD).append(",localRemainTime:").append(this.uFr).append(",haveLottering:").append(this.uFs).append(", lotteryInfo:");
        Object obj = this.tWe;
        if (obj == null) {
            obj = "";
        }
        String sb = append.append(g.bN(obj)).append(",lastDoneLottery:").append(this.uFt).append(",cardShowing:").append(this.uFu).append(",bubbleFinsh:").append(this.uFv).toString();
        AppMethodBeat.o(248011);
        return sb;
    }
}
