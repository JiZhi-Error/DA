package com.tencent.mm.plugin.finder.report.live;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.live.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0010HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003Jy\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0010HÖ\u0001J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/HellVisitorClickData;", "", "feedId", "", "liveId", "userName", "", FirebaseAnalytics.b.INDEX, "onlineNum", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "shareType", "shareUserName", "snsFeedid", "enterIconType", "", "(JJLjava/lang/String;JJLcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "getCommentscene", "()Ljava/lang/String;", "getEnterIconType", "()I", "getFeedId", "()J", "getIndex", "getLiveId", "getOnlineNum", "getShareType", "getShareUserName", "getSnsFeedid", "getUserName", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
public final class p {
    final long feedId;
    final long liveId;
    final String userName;
    final s.p vjL;
    final String vjM;
    final long vln;
    final long vlo;
    final long vlp;
    final String vlq;
    final String vlr;
    private final int vls;

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        if (r5.vls == r6.vls) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.p.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(251010);
        long j2 = this.feedId;
        long j3 = this.liveId;
        int i3 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.userName;
        int hashCode = str != null ? str.hashCode() : 0;
        long j4 = this.vln;
        long j5 = this.vlo;
        int i4 = (((((hashCode + i3) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        s.p pVar = this.vjL;
        int hashCode2 = ((pVar != null ? pVar.hashCode() : 0) + i4) * 31;
        String str2 = this.vjM;
        int hashCode3 = str2 != null ? str2.hashCode() : 0;
        long j6 = this.vlp;
        int i5 = (((hashCode3 + hashCode2) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        String str3 = this.vlq;
        int hashCode4 = ((str3 != null ? str3.hashCode() : 0) + i5) * 31;
        String str4 = this.vlr;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i6 = ((hashCode4 + i2) * 31) + this.vls;
        AppMethodBeat.o(251010);
        return i6;
    }

    public final String toString() {
        AppMethodBeat.i(251009);
        String str = "HellVisitorClickData(feedId=" + this.feedId + ", liveId=" + this.liveId + ", userName=" + this.userName + ", index=" + this.vln + ", onlineNum=" + this.vlo + ", actionType=" + this.vjL + ", commentscene=" + this.vjM + ", shareType=" + this.vlp + ", shareUserName=" + this.vlq + ", snsFeedid=" + this.vlr + ", enterIconType=" + this.vls + ")";
        AppMethodBeat.o(251009);
        return str;
    }

    private p(long j2, long j3, String str, long j4, long j5, s.p pVar, String str2, String str3, String str4) {
        kotlin.g.b.p.h(str, "userName");
        kotlin.g.b.p.h(pVar, "actionType");
        kotlin.g.b.p.h(str2, "commentscene");
        kotlin.g.b.p.h(str3, "shareUserName");
        AppMethodBeat.i(251007);
        this.feedId = j2;
        this.liveId = j3;
        this.userName = str;
        this.vln = j4;
        this.vlo = j5;
        this.vjL = pVar;
        this.vjM = str2;
        this.vlp = 0;
        this.vlq = str3;
        this.vlr = str4;
        this.vls = 0;
        AppMethodBeat.o(251007);
    }

    public /* synthetic */ p(long j2, long j3, String str, long j4, long j5, s.p pVar, String str2) {
        this(j2, j3, str, j4, j5, pVar, str2, "", "");
        AppMethodBeat.i(251008);
        AppMethodBeat.o(251008);
    }
}
