package com.tencent.mm.plugin.finder.report.live;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bW\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B§\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u00120\b\u0002\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bj\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c`\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u0003¢\u0006\u0002\u0010\"J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0007HÆ\u0003J\t\u0010]\u001a\u00020\u000fHÆ\u0003J\t\u0010^\u001a\u00020\u0007HÆ\u0003J\t\u0010_\u001a\u00020\u0007HÆ\u0003J\t\u0010`\u001a\u00020\u0007HÆ\u0003J\t\u0010a\u001a\u00020\u0007HÆ\u0003J\t\u0010b\u001a\u00020\u0007HÆ\u0003J\t\u0010c\u001a\u00020\u0007HÆ\u0003J\t\u0010d\u001a\u00020\u0007HÆ\u0003J\t\u0010e\u001a\u00020\u0007HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0007HÆ\u0003J\t\u0010h\u001a\u00020\u0007HÆ\u0003J1\u0010i\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bj\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c`\u001eHÆ\u0003J\t\u0010j\u001a\u00020\u0007HÆ\u0003J\t\u0010k\u001a\u00020\u0007HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0007HÆ\u0003J\t\u0010o\u001a\u00020\u0007HÆ\u0003J\t\u0010p\u001a\u00020\u0007HÆ\u0003J\t\u0010q\u001a\u00020\u0007HÆ\u0003J\t\u0010r\u001a\u00020\u0007HÆ\u0003J\t\u0010s\u001a\u00020\u0007HÆ\u0003J«\u0002\u0010t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u000720\b\u0002\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bj\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c`\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0003HÆ\u0001J\u0013\u0010u\u001a\u00020v2\b\u0010w\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010x\u001a\u00020\u000fHÖ\u0001J\u0006\u0010y\u001a\u00020zJ\u0010\u0010R\u001a\u00020z2\b\u0010{\u001a\u0004\u0018\u00010|J\t\u0010}\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u001a\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001a\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R\u001a\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&R\u001a\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&R\u001a\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010.\"\u0004\bD\u00100R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010$\"\u0004\bF\u0010&R\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010$\"\u0004\bH\u0010&R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R\u001a\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010$\"\u0004\bL\u0010&R\u001a\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010$\"\u0004\bN\u0010&R9\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bj\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c`\u001e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010$\"\u0004\bR\u0010&R\u001a\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010$\"\u0004\bT\u0010&R\u001a\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010.\"\u0004\bV\u00100R\u001a\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010$\"\u0004\bX\u0010&R\u001a\u0010\u001f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010$\"\u0004\bZ\u0010&¨\u0006~"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveStaticsData_21056;", "", "liveId", "", "feedId", "description", "liveStartTimeMs", "", "liveEndTimeMs", "oriFansCount", "liveDurationSeconds", "audienceCount", "likeCount", "newFansNum", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "floatingCount", "shareSnsCount", "shareSessionCount", "exchangeCameraCount", "complainCount", "allCommentCloseCount", "allCommentOpenCount", "personalCommentCloseCount", "personalCommentOpenCount", "kickOutCount", "promoteGoods", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/report/live/HellPair;", "Lkotlin/collections/HashMap;", "topComment", "tickleTimes", "shopWindowId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJJJIJJJJJJJJJJLjava/util/HashMap;JJLjava/lang/String;)V", "getAllCommentCloseCount", "()J", "setAllCommentCloseCount", "(J)V", "getAllCommentOpenCount", "setAllCommentOpenCount", "getAudienceCount", "setAudienceCount", "getComplainCount", "setComplainCount", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getExchangeCameraCount", "setExchangeCameraCount", "getFeedId", "setFeedId", "getFloatingCount", "setFloatingCount", "getKickOutCount", "setKickOutCount", "getLikeCount", "setLikeCount", "getLiveDurationSeconds", "setLiveDurationSeconds", "getLiveEndTimeMs", "setLiveEndTimeMs", "getLiveId", "setLiveId", "getLiveStartTimeMs", "setLiveStartTimeMs", "getNewFansNum", "setNewFansNum", "getOriFansCount", "setOriFansCount", "getPersonalCommentCloseCount", "setPersonalCommentCloseCount", "getPersonalCommentOpenCount", "setPersonalCommentOpenCount", "getPromoteGoods", "()Ljava/util/HashMap;", "getShareSessionCount", "setShareSessionCount", "getShareSnsCount", "setShareSnsCount", "getShopWindowId", "setShopWindowId", "getTickleTimes", "setTickleTimes", "getTopComment", "setTopComment", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "reset", "", "intent", "Landroid/content/Intent;", "toString", "plugin-finder_release"})
public final class u {
    String description;
    public int errorCode;
    public String feedId;
    public String hJs;
    public final HashMap<Long, LinkedList<o>> vtA;
    public long vtB;
    public long vtC;
    String vtD;
    public long vtj;
    public long vtk;
    public long vtl;
    public long vtm;
    public long vtn;
    public long vto;
    public long vtp;
    public long vtq;
    public long vtr;
    public long vts;
    public long vtt;
    public long vtu;
    public long vtv;
    public long vtw;
    public long vtx;
    public long vty;
    public long vtz;

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dc, code lost:
        if (kotlin.g.b.p.j(r5.vtD, r6.vtD) != false) goto L_0x00de;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 232
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.u.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(251210);
        String str = this.hJs;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.feedId;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.description;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j2 = this.vtj;
        long j3 = this.vtk;
        long j4 = this.vtl;
        long j5 = this.vtm;
        long j6 = this.vtn;
        long j7 = this.vto;
        long j8 = this.vtp;
        long j9 = this.vtq;
        long j10 = this.vtr;
        long j11 = this.vts;
        long j12 = this.vtt;
        long j13 = this.vtu;
        long j14 = this.vtv;
        long j15 = this.vtw;
        long j16 = this.vtx;
        long j17 = this.vty;
        long j18 = this.vtz;
        int i3 = (((((((((((((((((((((((((((((((((((((hashCode3 + hashCode2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + this.errorCode) * 31) + ((int) (j9 ^ (j9 >>> 32)))) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + ((int) (j15 ^ (j15 >>> 32)))) * 31) + ((int) (j16 ^ (j16 >>> 32)))) * 31) + ((int) (j17 ^ (j17 >>> 32)))) * 31) + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        HashMap<Long, LinkedList<o>> hashMap = this.vtA;
        int hashCode4 = hashMap != null ? hashMap.hashCode() : 0;
        long j19 = this.vtB;
        long j20 = this.vtC;
        int i4 = (((((hashCode4 + i3) * 31) + ((int) (j19 ^ (j19 >>> 32)))) * 31) + ((int) (j20 ^ (j20 >>> 32)))) * 31;
        String str4 = this.vtD;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i5 = i4 + i2;
        AppMethodBeat.o(251210);
        return i5;
    }

    public final String toString() {
        AppMethodBeat.i(251209);
        String str = "LiveStaticsData_21056(liveId=" + this.hJs + ", feedId=" + this.feedId + ", description=" + this.description + ", liveStartTimeMs=" + this.vtj + ", liveEndTimeMs=" + this.vtk + ", oriFansCount=" + this.vtl + ", liveDurationSeconds=" + this.vtm + ", audienceCount=" + this.vtn + ", likeCount=" + this.vto + ", newFansNum=" + this.vtp + ", errorCode=" + this.errorCode + ", floatingCount=" + this.vtq + ", shareSnsCount=" + this.vtr + ", shareSessionCount=" + this.vts + ", exchangeCameraCount=" + this.vtt + ", complainCount=" + this.vtu + ", allCommentCloseCount=" + this.vtv + ", allCommentOpenCount=" + this.vtw + ", personalCommentCloseCount=" + this.vtx + ", personalCommentOpenCount=" + this.vty + ", kickOutCount=" + this.vtz + ", promoteGoods=" + this.vtA + ", topComment=" + this.vtB + ", tickleTimes=" + this.vtC + ", shopWindowId=" + this.vtD + ")";
        AppMethodBeat.o(251209);
        return str;
    }

    private u(String str, String str2, String str3, HashMap<Long, LinkedList<o>> hashMap, String str4) {
        p.h(str, "liveId");
        p.h(str2, "feedId");
        p.h(str3, "description");
        p.h(hashMap, "promoteGoods");
        p.h(str4, "shopWindowId");
        AppMethodBeat.i(251207);
        this.hJs = str;
        this.feedId = str2;
        this.description = str3;
        this.vtj = 0;
        this.vtk = 0;
        this.vtl = 0;
        this.vtm = 0;
        this.vtn = 0;
        this.vto = 0;
        this.vtp = 0;
        this.errorCode = 0;
        this.vtq = 0;
        this.vtr = 0;
        this.vts = 0;
        this.vtt = 0;
        this.vtu = 0;
        this.vtv = 0;
        this.vtw = 0;
        this.vtx = 0;
        this.vty = 0;
        this.vtz = 0;
        this.vtA = hashMap;
        this.vtB = 0;
        this.vtC = 0;
        this.vtD = str4;
        AppMethodBeat.o(251207);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ u() {
        /*
            r7 = this;
            r6 = 251208(0x3d548, float:3.52017E-40)
            java.lang.String r1 = ""
            java.lang.String r2 = ""
            java.lang.String r3 = ""
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.tencent.mm.plugin.finder.live.model.o r0 = com.tencent.mm.plugin.finder.live.model.o.ujN
            com.tencent.mm.plugin.finder.live.viewmodel.g r0 = com.tencent.mm.plugin.finder.live.model.o.dfZ()
            if (r0 == 0) goto L_0x0021
            com.tencent.mm.protocal.protobuf.awc r0 = r0.uEl
            if (r0 == 0) goto L_0x0021
            java.lang.String r5 = r0.vtD
            if (r5 != 0) goto L_0x0024
        L_0x0021:
            java.lang.String r5 = ""
        L_0x0024:
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.u.<init>():void");
    }

    public final void setDescription(String str) {
        AppMethodBeat.i(251206);
        p.h(str, "<set-?>");
        this.description = str;
        AppMethodBeat.o(251206);
    }
}
