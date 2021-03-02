package com.tencent.mm.plugin.finder.report.live;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.bbz;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/HellLiveMixSearchItem;", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "pos", "", "feedId", "", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "liveStatus", "", "nickName", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;ILjava/lang/String;Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;Ljava/lang/String;ZLjava/lang/String;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "getCommentscene", "()Ljava/lang/String;", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getFeedId", "getLiveStatus", "()Z", "getNickName", "getPos", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
public final class j {
    final String feedId;
    final String nickName;
    final int pos;
    final s.p vjL;
    final String vjM;
    final boolean vjX;
    final bbz vjY;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        if (kotlin.g.b.p.j(r3.nickName, r4.nickName) != false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 250948(0x3d444, float:3.51653E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x004c
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.report.live.j
            if (r0 == 0) goto L_0x0051
            com.tencent.mm.plugin.finder.report.live.j r4 = (com.tencent.mm.plugin.finder.report.live.j) r4
            com.tencent.mm.protocal.protobuf.bbz r0 = r3.vjY
            com.tencent.mm.protocal.protobuf.bbz r1 = r4.vjY
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            int r0 = r3.pos
            int r1 = r4.pos
            if (r0 != r1) goto L_0x0051
            java.lang.String r0 = r3.feedId
            java.lang.String r1 = r4.feedId
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            com.tencent.mm.plugin.finder.report.live.s$p r0 = r3.vjL
            com.tencent.mm.plugin.finder.report.live.s$p r1 = r4.vjL
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = r3.vjM
            java.lang.String r1 = r4.vjM
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            boolean r0 = r3.vjX
            boolean r1 = r4.vjX
            if (r0 != r1) goto L_0x0051
            java.lang.String r0 = r3.nickName
            java.lang.String r1 = r4.nickName
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
        L_0x004c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0050:
            return r0
        L_0x0051:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0050
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.j.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(250947);
        bbz bbz = this.vjY;
        int hashCode = (((bbz != null ? bbz.hashCode() : 0) * 31) + this.pos) * 31;
        String str = this.feedId;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        s.p pVar = this.vjL;
        int hashCode3 = ((pVar != null ? pVar.hashCode() : 0) + hashCode2) * 31;
        String str2 = this.vjM;
        int hashCode4 = ((str2 != null ? str2.hashCode() : 0) + hashCode3) * 31;
        boolean z = this.vjX;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (i3 + hashCode4) * 31;
        String str3 = this.nickName;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i7 = i6 + i2;
        AppMethodBeat.o(250947);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(250946);
        String str = "HellLiveMixSearchItem(contact=" + this.vjY + ", pos=" + this.pos + ", feedId=" + this.feedId + ", actionType=" + this.vjL + ", commentscene=" + this.vjM + ", liveStatus=" + this.vjX + ", nickName=" + this.nickName + ")";
        AppMethodBeat.o(250946);
        return str;
    }

    public j(bbz bbz, int i2, String str, s.p pVar, String str2, boolean z, String str3) {
        p.h(bbz, "contact");
        p.h(str, "feedId");
        p.h(pVar, "actionType");
        p.h(str2, "commentscene");
        p.h(str3, "nickName");
        AppMethodBeat.i(250945);
        this.vjY = bbz;
        this.pos = i2;
        this.feedId = str;
        this.vjL = pVar;
        this.vjM = str2;
        this.vjX = z;
        this.nickName = str3;
        AppMethodBeat.o(250945);
    }
}
