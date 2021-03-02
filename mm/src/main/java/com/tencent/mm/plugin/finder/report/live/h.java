package com.tencent.mm.plugin.finder.report.live;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.vending.j.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b.\b\b\u0018\u0000 @2\u00020\u0001:\u0002@AB\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0002\u0010\u0017J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\t\u00100\u001a\u00020\u0014HÆ\u0003J\t\u00101\u001a\u00020\u0014HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0007HÆ\u0001J\u0013\u0010<\u001a\u00020\u00142\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0007HÖ\u0001J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010#R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010#R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001d¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "userName", "", "pos", "", "feedId", "feedIdL", "", "liveId", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "onlineNum", "nickName", "liveStatus", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed$LIVE_STATUS;", "isLiveCard", "", "isSingleLiveAvatar", "shareType", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;Ljava/lang/String;ILjava/lang/String;JJLcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed$LIVE_STATUS;ZZI)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "setActionType", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;)V", "getCommentscene", "()Ljava/lang/String;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getFeedId", "getFeedIdL", "()J", "()Z", "getLiveId", "getLiveStatus", "()Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed$LIVE_STATUS;", "getNickName", "getOnlineNum", "()I", "getPos", "getShareType", "getUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "Companion", "LIVE_STATUS", "plugin-finder_release"})
public final class h {
    public static final a vjR = new a((byte) 0);
    final String feedId;
    final long liveId;
    final String nickName;
    final int onlineNum;
    final int pos;
    final bo tIu;
    final String userName;
    final long vjK;
    s.p vjL;
    final String vjM;
    final b vjN;
    final boolean vjO;
    final boolean vjP;
    final int vjQ;

    static {
        AppMethodBeat.i(250937);
        AppMethodBeat.o(250937);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        if (r5.vjQ == r6.vjQ) goto L_0x0082;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.h.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(250939);
        bo boVar = this.tIu;
        int hashCode = (boVar != null ? boVar.hashCode() : 0) * 31;
        String str = this.userName;
        int hashCode2 = ((((str != null ? str.hashCode() : 0) + hashCode) * 31) + this.pos) * 31;
        String str2 = this.feedId;
        int hashCode3 = str2 != null ? str2.hashCode() : 0;
        long j2 = this.vjK;
        long j3 = this.liveId;
        int i4 = (((((hashCode3 + hashCode2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        s.p pVar = this.vjL;
        int hashCode4 = ((pVar != null ? pVar.hashCode() : 0) + i4) * 31;
        String str3 = this.vjM;
        int hashCode5 = ((((str3 != null ? str3.hashCode() : 0) + hashCode4) * 31) + this.onlineNum) * 31;
        String str4 = this.nickName;
        int hashCode6 = ((str4 != null ? str4.hashCode() : 0) + hashCode5) * 31;
        b bVar = this.vjN;
        if (bVar != null) {
            i3 = bVar.hashCode();
        }
        int i5 = (hashCode6 + i3) * 31;
        boolean z = this.vjO;
        if (z) {
            z = true;
        }
        int i6 = z ? 1 : 0;
        int i7 = z ? 1 : 0;
        int i8 = z ? 1 : 0;
        int i9 = (i6 + i5) * 31;
        boolean z2 = this.vjP;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i10 = ((i9 + i2) * 31) + this.vjQ;
        AppMethodBeat.o(250939);
        return i10;
    }

    public final String toString() {
        AppMethodBeat.i(250938);
        String str = "HellLiveFeed(feed=" + this.tIu + ", userName=" + this.userName + ", pos=" + this.pos + ", feedId=" + this.feedId + ", feedIdL=" + this.vjK + ", liveId=" + this.liveId + ", actionType=" + this.vjL + ", commentscene=" + this.vjM + ", onlineNum=" + this.onlineNum + ", nickName=" + this.nickName + ", liveStatus=" + this.vjN + ", isLiveCard=" + this.vjO + ", isSingleLiveAvatar=" + this.vjP + ", shareType=" + this.vjQ + ")";
        AppMethodBeat.o(250938);
        return str;
    }

    public h(bo boVar, String str, int i2, String str2, long j2, long j3, s.p pVar, String str3, int i3, String str4, b bVar, boolean z, boolean z2, int i4) {
        p.h(str2, "feedId");
        p.h(pVar, "actionType");
        p.h(str3, "commentscene");
        p.h(str4, "nickName");
        p.h(bVar, "liveStatus");
        AppMethodBeat.i(250935);
        this.tIu = boVar;
        this.userName = str;
        this.pos = i2;
        this.feedId = str2;
        this.vjK = j2;
        this.liveId = j3;
        this.vjL = pVar;
        this.vjM = str3;
        this.onlineNum = i3;
        this.nickName = str4;
        this.vjN = bVar;
        this.vjO = z;
        this.vjP = z2;
        this.vjQ = i4;
        AppMethodBeat.o(250935);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ h(com.tencent.mm.plugin.finder.model.bo r22, java.lang.String r23, int r24, java.lang.String r25, long r26, long r28, com.tencent.mm.plugin.finder.report.live.s.p r30, java.lang.String r31, int r32, java.lang.String r33, com.tencent.mm.plugin.finder.report.live.h.b r34, boolean r35, boolean r36, int r37, byte r38) {
        /*
            r21 = this;
            r2 = r37 & 2
            if (r2 == 0) goto L_0x0060
            java.lang.String r5 = ""
        L_0x0007:
            r0 = r37
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x005d
            r14 = -1
        L_0x000e:
            r0 = r37
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x005a
            java.lang.String r15 = ""
        L_0x0017:
            r0 = r37
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0057
            com.tencent.mm.plugin.finder.report.live.h$b r16 = com.tencent.mm.plugin.finder.report.live.h.b.UNDEFINE
        L_0x001f:
            r0 = r37
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0054
            r17 = 0
        L_0x0027:
            r0 = r37
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0051
            r18 = 0
        L_0x002f:
            r19 = 0
            r3 = r21
            r4 = r22
            r6 = r24
            r7 = r25
            r8 = r26
            r10 = r28
            r12 = r30
            r13 = r31
            r3.<init>(r4, r5, r6, r7, r8, r10, r12, r13, r14, r15, r16, r17, r18, r19)
            r2 = 250936(0x3d438, float:3.51636E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            r2 = 250936(0x3d438, float:3.51636E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        L_0x0051:
            r18 = r36
            goto L_0x002f
        L_0x0054:
            r17 = r35
            goto L_0x0027
        L_0x0057:
            r16 = r34
            goto L_0x001f
        L_0x005a:
            r15 = r33
            goto L_0x0017
        L_0x005d:
            r14 = r32
            goto L_0x000e
        L_0x0060:
            r5 = r23
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.h.<init>(com.tencent.mm.plugin.finder.model.bo, java.lang.String, int, java.lang.String, long, long, com.tencent.mm.plugin.finder.report.live.s$p, java.lang.String, int, java.lang.String, com.tencent.mm.plugin.finder.report.live.h$b, boolean, boolean, int, byte):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed$LIVE_STATUS;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "UNDEFINE", "ING", "NOT", "plugin-finder_release"})
    public enum b {
        UNDEFINE(-1),
        ING(0),
        NOT(1);
        
        private final int status;

        public static b valueOf(String str) {
            AppMethodBeat.i(250934);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(250934);
            return bVar;
        }

        private b(int i2) {
            this.status = i2;
        }

        static {
            AppMethodBeat.i(250932);
            AppMethodBeat.o(250932);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed$Companion;", "", "()V", "getLiveId", "Lcom/tencent/mm/vending/tuple/Tuple3;", "", "", "", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getNickName", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d<Long, Integer, Boolean> a(bo boVar) {
            boolean z;
            int i2;
            long j2;
            int i3;
            long j3 = 0;
            int i4 = 0;
            AppMethodBeat.i(250930);
            p.h(boVar, "rvFeed");
            if (boVar instanceof BaseFinderFeed) {
                awe liveInfo = ((BaseFinderFeed) boVar).feedObject.getLiveInfo();
                long j4 = liveInfo != null ? liveInfo.liveId : 0;
                awe liveInfo2 = ((BaseFinderFeed) boVar).feedObject.getLiveInfo();
                if (liveInfo2 != null) {
                    i3 = liveInfo2.uBn;
                } else {
                    i3 = 0;
                }
                z = false;
                i2 = i3;
                j2 = j4;
            } else if (boVar instanceof y) {
                awe awe = ((y) boVar).uOo.liveInfo;
                if (awe != null) {
                    j3 = awe.liveId;
                }
                awe awe2 = ((y) boVar).uOo.liveInfo;
                if (awe2 != null) {
                    i4 = awe2.uBn;
                }
                z = true;
                i2 = i4;
                j2 = j3;
            } else {
                z = false;
                i2 = -1;
                j2 = 0;
            }
            d<Long, Integer, Boolean> i5 = com.tencent.mm.vending.j.a.i(Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(z));
            p.g(i5, "Tuple.make(liveId, onlineCnt, isSingleLiveAvatar)");
            AppMethodBeat.o(250930);
            return i5;
        }

        public static String b(bo boVar) {
            AppMethodBeat.i(250931);
            p.h(boVar, "rvFeed");
            String str = "";
            if (boVar instanceof BaseFinderFeed) {
                str = ((BaseFinderFeed) boVar).feedObject.getNickName();
            } else if ((boVar instanceof y) && (str = ((y) boVar).uOo.nickname) == null) {
                str = "";
            }
            AppMethodBeat.o(250931);
            return str;
        }
    }
}
