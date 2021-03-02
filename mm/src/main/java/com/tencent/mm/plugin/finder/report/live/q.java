package com.tencent.mm.plugin.finder.report.live;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.live.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0012HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/HellVisitorEnterData;", "", "feedId", "", "liveId", "userName", "", FirebaseAnalytics.b.INDEX, "onlineNum", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "enterStatus", "shareType", "shareUserName", "snsFeedid", "enterTime", "enterType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "(JJLjava/lang/String;JJLcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JLcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "getCommentscene", "()Ljava/lang/String;", "getEnterStatus", "()J", "getEnterTime", "getEnterType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "getFeedId", "getIndex", "getLiveId", "getOnlineNum", "getShareType", "getShareUserName", "getSnsFeedid", "getUserName", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
public final class q {
    final long enterTime;
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
    final long vlt;
    final s.av vlu;

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        if (kotlin.g.b.p.j(r5.vlu, r6.vlu) != false) goto L_0x0082;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.q.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(251014);
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
        long j6 = this.vlt;
        long j7 = this.vlp;
        int i5 = (((((hashCode3 + hashCode2) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        String str3 = this.vlq;
        int hashCode4 = ((str3 != null ? str3.hashCode() : 0) + i5) * 31;
        String str4 = this.vlr;
        int hashCode5 = str4 != null ? str4.hashCode() : 0;
        long j8 = this.enterTime;
        int i6 = (((hashCode5 + hashCode4) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31;
        s.av avVar = this.vlu;
        if (avVar != null) {
            i2 = avVar.hashCode();
        }
        int i7 = i6 + i2;
        AppMethodBeat.o(251014);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(251013);
        String str = "HellVisitorEnterData(feedId=" + this.feedId + ", liveId=" + this.liveId + ", userName=" + this.userName + ", index=" + this.vln + ", onlineNum=" + this.vlo + ", actionType=" + this.vjL + ", commentscene=" + this.vjM + ", enterStatus=" + this.vlt + ", shareType=" + this.vlp + ", shareUserName=" + this.vlq + ", snsFeedid=" + this.vlr + ", enterTime=" + this.enterTime + ", enterType=" + this.vlu + ")";
        AppMethodBeat.o(251013);
        return str;
    }

    public q(long j2, long j3, String str, long j4, long j5, s.p pVar, String str2, long j6, long j7, String str3, String str4, long j8, s.av avVar) {
        p.h(str, "userName");
        p.h(pVar, "actionType");
        p.h(str2, "commentscene");
        p.h(str3, "shareUserName");
        p.h(str4, "snsFeedid");
        p.h(avVar, "enterType");
        AppMethodBeat.i(251012);
        this.feedId = j2;
        this.liveId = j3;
        this.userName = str;
        this.vln = j4;
        this.vlo = j5;
        this.vjL = pVar;
        this.vjM = str2;
        this.vlt = j6;
        this.vlp = j7;
        this.vlq = str3;
        this.vlr = str4;
        this.enterTime = j8;
        this.vlu = avVar;
        AppMethodBeat.o(251012);
    }
}
