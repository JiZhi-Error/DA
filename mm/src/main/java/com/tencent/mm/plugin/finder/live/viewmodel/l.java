package com.tencent.mm.plugin.finder.live.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avi;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUserDesc;", "", "descType", "", "badgeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;)V", "getBadgeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "setBadgeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;)V", "getDescType", "()I", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
public final class l {
    public final int jGX;
    public avi uDx;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (kotlin.g.b.p.j(r3.uDx, r4.uDx) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 261046(0x3fbb6, float:3.65803E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.viewmodel.l
            if (r0 == 0) goto L_0x0023
            com.tencent.mm.plugin.finder.live.viewmodel.l r4 = (com.tencent.mm.plugin.finder.live.viewmodel.l) r4
            int r0 = r3.jGX
            int r1 = r4.jGX
            if (r0 != r1) goto L_0x0023
            com.tencent.mm.protocal.protobuf.avi r0 = r3.uDx
            com.tencent.mm.protocal.protobuf.avi r1 = r4.uDx
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0023
        L_0x001e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0022:
            return r0
        L_0x0023:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.l.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(261045);
        int i2 = this.jGX * 31;
        avi avi = this.uDx;
        int hashCode = (avi != null ? avi.hashCode() : 0) + i2;
        AppMethodBeat.o(261045);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(261044);
        String str = "FinderLiveLinkMicUserDesc(descType=" + this.jGX + ", badgeInfo=" + this.uDx + ")";
        AppMethodBeat.o(261044);
        return str;
    }

    private /* synthetic */ l() {
        this(0, null);
    }

    public l(int i2, avi avi) {
        this.jGX = i2;
        this.uDx = avi;
    }
}
