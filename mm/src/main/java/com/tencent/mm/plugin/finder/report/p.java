package com.tencent.mm.plugin.finder.report;

import android.media.AudioManager;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.stats.LoggingConstants;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.h;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.video.reporter.b;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\bR\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 À\u00012\u00020\u0001:\u0002À\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\n\u0010±\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010µ\u0001\u001a\u00020\nHÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003JX\u0010¸\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0007\u0010¹\u0001\u001a\u00020\u0000J\u0015\u0010º\u0001\u001a\u00020\n2\t\u0010»\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010¼\u0001\u001a\u00020\u0017HÖ\u0001J\u0014\u0010½\u0001\u001a\u00030¾\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ\n\u0010¿\u0001\u001a\u00020vHÖ\u0001R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010%\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001a\u0010(\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u001a\u0010+\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001a\u0010.\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001a\u00101\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u001a\u00104\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001a\u00107\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u001a\u0010?\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0019\"\u0004\bA\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0019\"\u0004\bF\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00109R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0019\"\u0004\bL\u0010\u001bR\u001a\u0010M\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR\u001a\u0010O\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0019\"\u0004\bQ\u0010\u001bR\u001a\u0010R\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00109\"\u0004\bT\u0010;R\u001a\u0010U\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0019\"\u0004\bW\u0010\u001bR\u001a\u0010X\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0019\"\u0004\bZ\u0010\u001bR\u001a\u0010[\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0019\"\u0004\b]\u0010\u001bR\u001a\u0010^\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0019\"\u0004\b`\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0019\"\u0004\be\u0010\u001bR\u001a\u0010f\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0019\"\u0004\bh\u0010\u001bR\u001a\u0010i\u001a\u00020jX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020jX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010l\"\u0004\bq\u0010nR\u001a\u0010r\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0019\"\u0004\bt\u0010\u001bR\u001a\u0010u\u001a\u00020vX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001a\u0010{\u001a\u00020vX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010x\"\u0004\b}\u0010zR$\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00170X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u00109\"\u0005\b\u0001\u0010;R\u001d\u0010\u0001\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u00109\"\u0005\b\u0001\u0010;R\u001d\u0010\u0001\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u00109\"\u0005\b\u0001\u0010;R\u001d\u0010\u0001\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u00109\"\u0005\b\u0001\u0010;R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0017X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0019\"\u0005\b\u0001\u0010\u001bR \u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0012\u0010\u0004\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u00109R\u001d\u0010\u0001\u001a\u00020\u0017X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0019\"\u0005\b \u0001\u0010\u001bR\u001d\u0010¡\u0001\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u00109\"\u0005\b£\u0001\u0010;R\u001d\u0010¤\u0001\u001a\u00020\u0017X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u0019\"\u0005\b¦\u0001\u0010\u001bR \u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u001d\u0010«\u0001\u001a\u00020\u0011X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u0013\"\u0005\b­\u0001\u0010\u0015R\u001d\u0010®\u0001\u001a\u00020vX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010x\"\u0005\b°\u0001\u0010z¨\u0006Á\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "isCenterFeed", "", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;ZLcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "changePageTime", "", "getChangePageTime", "()[J", "setChangePageTime", "([J)V", "clickAvatar", "", "getClickAvatar", "()I", "setClickAvatar", "(I)V", "clickComment", "getClickComment", "setClickComment", "clickExpandText", "getClickExpandText", "setClickExpandText", "clickFav", "getClickFav", "setClickFav", "clickFeedMenu", "getClickFeedMenu", "setClickFeedMenu", "clickPoiTimes", "getClickPoiTimes", "setClickPoiTimes", "clickShareMoments", "getClickShareMoments", "setClickShareMoments", "collapseTextTimes", "getCollapseTextTimes", "setCollapseTextTimes", "commentLikeTimes", "getCommentLikeTimes", "setCommentLikeTimes", "complainTimes", "getComplainTimes", "setComplainTimes", "createTimestamp", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "endTime", "getEndTime", "setEndTime", "endVolume", "getEndVolume", "setEndVolume", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "getFeedDataPos", "setFeedDataPos", "getFeedId", "()Z", "setCenterFeed", "(Z)V", "isPause", "setPause", "isSeek", "setSeek", "lastPageIndex", "getLastPageIndex", "setLastPageIndex", "lastPlayTime", "getLastPlayTime", "setLastPlayTime", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "maxReplayCount", "getMaxReplayCount", "setMaxReplayCount", "getMegaVideoFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", DownloadInfo.NETTYPE, "getNetType", "setNetType", "notInterest", "getNotInterest", "setNotInterest", "pageVideoPlayPercent", "", "getPageVideoPlayPercent", "()[I", "setPageVideoPlayPercent", "([I)V", "pageVideoReplayCount", "getPageVideoReplayCount", "setPageVideoReplayCount", "pauseTimes", "getPauseTimes", "setPauseTimes", "playFormat", "", "getPlayFormat", "()Ljava/lang/String;", "setPlayFormat", "(Ljava/lang/String;)V", "playProgressInfo", "getPlayProgressInfo", "setPlayProgressInfo", "playProgressSet", "Ljava/util/Vector;", "getPlayProgressSet", "()Ljava/util/Vector;", "setPlayProgressSet", "(Ljava/util/Vector;)V", "playTime", "getPlayTime", "setPlayTime", "playTimestamp", "getPlayTimestamp", "setPlayTimestamp", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getRvFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setRvFeed", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "shareCount", "getShareCount", "setShareCount", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "startVolume", "getStartVolume", "setStartVolume", "stayTime", "getStayTime", "setStayTime", "videoDuration", "getVideoDuration", "setVideoDuration", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "setVideoPlayReporter", "(Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;)V", "viewPageDuration", "getViewPageDuration", "setViewPageDuration", "voiceInfo", "getVoiceInfo", "setVoiceInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "copyRecord", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "onRelease", "", "toString", "Companion", "plugin-finder_release"})
public final class p {
    private static final String TAG = TAG;
    private static final int vgA = 1;
    private static final int vgB = 2;
    public static final a vgC = new a((byte) 0);
    public long dUy;
    public long endTime;
    public final long feedId;
    public int msj;
    public int netType;
    public final long startTime;
    public final FinderItem tHo;
    public i tIw;
    final bm uJO;
    public long uOV;
    public b vdR;
    public int vfP;
    public long[] vfQ;
    public long[] vfR;
    public int[] vfS;
    public int[] vfT;
    public int vfU;
    public int vfV;
    public int vfW;
    public int vfX;
    public int vfY;
    public int vfZ;
    public int vga;
    public int vgb;
    public int vgc;
    public int vgd;
    public int vge;
    public int vgf;
    public int vgg;
    public int vgh;
    long vgi;
    public int vgj;
    public int vgk;
    public int vgl;
    public long vgm;
    public long vgn;
    public long vgo;
    public long vgp;
    public int vgq;
    public int vgr;
    public String vgs;
    public Vector<Integer> vgt;
    public int vgu;
    public int vgv;
    public String vgw;
    String vgx;
    bo vgy;
    public boolean vgz;
    public int videoDuration;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        if (kotlin.g.b.p.j(r5.uJO, r6.uJO) != false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 250752(0x3d380, float:3.51378E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x004c
            boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.report.p
            if (r0 == 0) goto L_0x0051
            com.tencent.mm.plugin.finder.report.p r6 = (com.tencent.mm.plugin.finder.report.p) r6
            long r0 = r5.feedId
            long r2 = r6.feedId
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0051
            long r0 = r5.startTime
            long r2 = r6.startTime
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0051
            com.tencent.mm.plugin.finder.storage.FinderItem r0 = r5.tHo
            com.tencent.mm.plugin.finder.storage.FinderItem r1 = r6.tHo
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            com.tencent.mm.view.recyclerview.i r0 = r5.tIw
            com.tencent.mm.view.recyclerview.i r1 = r6.tIw
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            boolean r0 = r5.vgz
            boolean r1 = r6.vgz
            if (r0 != r1) goto L_0x0051
            com.tencent.mm.plugin.finder.video.reporter.b r0 = r5.vdR
            com.tencent.mm.plugin.finder.video.reporter.b r1 = r6.vdR
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            com.tencent.mm.plugin.finder.model.bm r0 = r5.uJO
            com.tencent.mm.plugin.finder.model.bm r1 = r6.uJO
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
        L_0x004c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0050:
            return r0
        L_0x0051:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0050
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.p.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(250751);
        long j2 = this.feedId;
        long j3 = this.startTime;
        int i3 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        FinderItem finderItem = this.tHo;
        int hashCode = ((finderItem != null ? finderItem.hashCode() : 0) + i3) * 31;
        i iVar = this.tIw;
        int hashCode2 = ((iVar != null ? iVar.hashCode() : 0) + hashCode) * 31;
        boolean z = this.vgz;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i4 + hashCode2) * 31;
        b bVar = this.vdR;
        int hashCode3 = ((bVar != null ? bVar.hashCode() : 0) + i7) * 31;
        bm bmVar = this.uJO;
        if (bmVar != null) {
            i2 = bmVar.hashCode();
        }
        int i8 = hashCode3 + i2;
        AppMethodBeat.o(250751);
        return i8;
    }

    public final String toString() {
        AppMethodBeat.i(250750);
        String str = "FinderSingleFeedRecord(feedId=" + this.feedId + ", startTime=" + this.startTime + ", feed=" + this.tHo + ", showInfo=" + this.tIw + ", isCenterFeed=" + this.vgz + ", videoPlayReporter=" + this.vdR + ", megaVideoFeed=" + this.uJO + ")";
        AppMethodBeat.o(250750);
        return str;
    }

    public p(long j2, long j3, FinderItem finderItem, i iVar, boolean z, b bVar, bm bmVar) {
        ConcurrentHashMap<Long, b.C1322b> concurrentHashMap;
        b.C1322b bVar2;
        AppMethodBeat.i(250747);
        this.feedId = j2;
        this.startTime = j3;
        this.tHo = finderItem;
        this.tIw = iVar;
        this.vgz = z;
        this.vdR = bVar;
        this.uJO = bmVar;
        this.uOV = cl.aWA();
        long[] jArr = new long[9];
        for (int i2 = 0; i2 < 9; i2++) {
            jArr[i2] = 0;
        }
        this.vfQ = jArr;
        long[] jArr2 = new long[9];
        for (int i3 = 0; i3 < 9; i3++) {
            jArr2[i3] = 0;
        }
        this.vfR = jArr2;
        int[] iArr = new int[9];
        for (int i4 = 0; i4 < 9; i4++) {
            iArr[i4] = 0;
        }
        this.vfS = iArr;
        int[] iArr2 = new int[9];
        for (int i5 = 0; i5 < 9; i5++) {
            iArr2[i5] = 0;
        }
        this.vfT = iArr2;
        this.vfW = 1;
        this.vgs = "";
        this.vgt = new Vector<>();
        this.vgw = "";
        this.vgx = "";
        this.vfQ[0] = this.startTime;
        b bVar3 = this.vdR;
        if (bVar3 == null || (concurrentHashMap = bVar3.whF) == null || (bVar2 = concurrentHashMap.get(Long.valueOf(this.feedId))) == null) {
            AppMethodBeat.o(250747);
            return;
        }
        this.vgp = this.startTime;
        if (bVar2.bfW) {
            this.vgn = this.startTime;
        }
        Object systemService = MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(250747);
            throw tVar;
        }
        this.vgu = ((AudioManager) systemService).getStreamVolume(3);
        AppMethodBeat.o(250747);
    }

    public final long getFeedId() {
        return this.feedId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ p(long r12, long r14, com.tencent.mm.plugin.finder.storage.FinderItem r16, com.tencent.mm.view.recyclerview.i r17, boolean r18, com.tencent.mm.plugin.finder.video.reporter.b r19, com.tencent.mm.plugin.finder.model.bm r20, int r21) {
        /*
            r11 = this;
            r0 = r21 & 8
            if (r0 == 0) goto L_0x004c
            r7 = 0
        L_0x0005:
            r0 = r21 & 16
            if (r0 == 0) goto L_0x0049
            r8 = 0
        L_0x000a:
            r0 = r21 & 32
            if (r0 == 0) goto L_0x0046
            r9 = 0
        L_0x000f:
            r0 = r21 & 64
            if (r0 == 0) goto L_0x0043
            if (r16 == 0) goto L_0x0041
            boolean r0 = r16.isReplaceLongVideoToNormal()
            r1 = 1
            if (r0 != r1) goto L_0x0041
            boolean r0 = r16.isLongVideo()
            if (r0 == 0) goto L_0x0041
            com.tencent.mm.plugin.finder.model.bm r0 = new com.tencent.mm.plugin.finder.model.bm
            com.tencent.mm.protocal.protobuf.FinderObject r1 = r16.getFeedObject()
            r0.<init>(r1)
        L_0x002b:
            r10 = r0
        L_0x002c:
            r1 = r11
            r2 = r12
            r4 = r14
            r6 = r16
            r1.<init>(r2, r4, r6, r7, r8, r9, r10)
            r0 = 250748(0x3d37c, float:3.51373E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r0)
            r0 = 250748(0x3d37c, float:3.51373E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)
            return
        L_0x0041:
            r0 = 0
            goto L_0x002b
        L_0x0043:
            r10 = r20
            goto L_0x002c
        L_0x0046:
            r9 = r19
            goto L_0x000f
        L_0x0049:
            r8 = r18
            goto L_0x000a
        L_0x004c:
            r7 = r17
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.p.<init>(long, long, com.tencent.mm.plugin.finder.storage.FinderItem, com.tencent.mm.view.recyclerview.i, boolean, com.tencent.mm.plugin.finder.video.reporter.b, com.tencent.mm.plugin.finder.model.bm, int):void");
    }

    public final long[] doi() {
        return this.vfQ;
    }

    public final int[] doj() {
        return this.vfS;
    }

    public final int[] dok() {
        return this.vfT;
    }

    public final int dol() {
        return this.vfU;
    }

    public final void Kz(int i2) {
        this.vgg = i2;
    }

    public final int dom() {
        return this.vgg;
    }

    public final void KA(int i2) {
        this.vgj = i2;
    }

    public final int don() {
        return this.vgj;
    }

    public final void KB(int i2) {
        this.vgk = i2;
    }

    public final int doo() {
        return this.vgk;
    }

    public final void Fh(long j2) {
        this.vgn = j2;
    }

    public final long dop() {
        return this.vgn;
    }

    public final long doq() {
        return this.vgp;
    }

    public static /* synthetic */ void c(p pVar) {
        AppMethodBeat.i(250746);
        pVar.a(null);
        AppMethodBeat.o(250746);
    }

    public final void a(b bVar) {
        ConcurrentHashMap<Long, b.C1322b> concurrentHashMap;
        b.C1322b bVar2;
        com.tencent.mm.plugin.sight.base.a aNx;
        cnl cnl;
        LinkedList<cod> linkedList;
        cod cod;
        LinkedList<cjl> mediaList;
        cjl cjl;
        AppMethodBeat.i(250745);
        if (this.endTime == 0) {
            this.endTime = cl.aWA();
        }
        FinderItem finderItem = this.tHo;
        this.videoDuration = (finderItem == null || (mediaList = finderItem.getMediaList()) == null || (cjl = (cjl) j.kt(mediaList)) == null) ? 0 : cjl.videoDuration;
        bm bmVar = this.uJO;
        if (bmVar != null) {
            cng cng = bmVar.tuP;
            this.videoDuration = (cng == null || (cnl = cng.MtG) == null || (linkedList = cnl.media) == null || (cod = (cod) j.kt(linkedList)) == null) ? 0 : cod.Mur;
        }
        if (this.vgz) {
            this.dUy = this.endTime - this.startTime;
        }
        if (bVar == null || (concurrentHashMap = bVar.whF) == null || (bVar2 = concurrentHashMap.get(Long.valueOf(this.feedId))) == null) {
            AppMethodBeat.o(250745);
            return;
        }
        if (this.vgp != 0) {
            this.vgo += this.endTime - this.vgp;
        }
        if (this.vgn != 0) {
            this.vgm += this.endTime - this.vgn;
        }
        Object systemService = MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(250745);
            throw tVar;
        }
        this.vgv = ((AudioManager) systemService).getStreamVolume(3);
        Object systemService2 = MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(250745);
            throw tVar2;
        }
        int streamMaxVolume = ((AudioManager) systemService2).getStreamMaxVolume(3);
        int i2 = 0;
        if (this.vgu != this.vgv) {
            i2 = 1;
        }
        this.vgw = new StringBuilder().append((this.vgu * 100) / streamMaxVolume).append('#').append((this.vgv * 100) / streamMaxVolume).append('#').append(i2).toString();
        k kVar = k.vfA;
        this.netType = k.dod();
        Vector<Integer> vector = this.vgt;
        synchronized (vector) {
            try {
                Iterator<T> it = vector.iterator();
                while (it.hasNext()) {
                    this.vgs += ((Object) it.next()) + '#';
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(250745);
                throw th;
            }
        }
        d dVar = d.vGR;
        String str = d.avH(bVar2.whM).field_fileFormat;
        if (str == null) {
            str = "";
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        s sVar = bVar2.whP;
        if (!(sVar == null || (aNx = e.aNx(sVar.getPath())) == null)) {
            i4 = aNx.videoBitrate;
            i3 = aNx.audioBitrate;
            i5 = aNx.frameRate;
        }
        this.vgx = bVar2.wiz + ';' + i4 + ';' + str + ';' + i3 + ';' + i5 + ';' + bVar2.wiA + ';' + bVar2.wiB + ';';
        AppMethodBeat.o(250745);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0013J%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\nJ\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord$Companion;", "", "()V", "FinderStatsReportFeedTypeRelated", "", "getFinderStatsReportFeedTypeRelated", "()I", "FinderStatsReportFeedTypeStream", "getFinderStatsReportFeedTypeStream", "TAG", "", "getTAG", "()Ljava/lang/String;", "expandNotZeroValue", "", "sb", "Ljava/lang/StringBuffer;", "key", "value", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Long;)V", "printStats", LoggingConstants.LOG_FILE_PREFIX, "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "trans2Stats", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ecq a(p pVar, bbn bbn) {
            long j2;
            String str;
            long j3;
            String str2;
            String str3;
            String str4;
            cxr cxr;
            FinderItem finderItem;
            int i2;
            FinderContact finderContact;
            cng cng;
            int i3 = 1;
            AppMethodBeat.i(250741);
            kotlin.g.b.p.h(pVar, "record");
            kotlin.g.b.p.h(bbn, "contextObj");
            ecq ecq = new ecq();
            BitSet bitSet = new BitSet(64);
            bm bmVar = pVar.uJO;
            if (bmVar != null) {
                j2 = bmVar.dkW();
            } else {
                j2 = pVar.feedId;
            }
            ecq.hFK = j2;
            bm bmVar2 = pVar.uJO;
            if (bmVar2 == null || (str = bmVar2.dkX()) == null) {
                FinderItem finderItem2 = pVar.tHo;
                str = finderItem2 != null ? finderItem2.getObjectNonceId() : null;
            }
            if (str == null) {
                str = "";
            }
            ecq.objectNonceId = str;
            bm bmVar3 = pVar.uJO;
            if (bmVar3 != null) {
                j3 = bmVar3.lT();
            } else {
                j3 = 0;
            }
            ecq.NcU = j3;
            bm bmVar4 = pVar.uJO;
            if (bmVar4 == null || (cng = bmVar4.tuP) == null || (str2 = cng.LOd) == null) {
                str2 = "";
            }
            ecq.NcV = str2;
            ecq.NcM = new mp();
            ecq.NcN = new epf();
            ecq.NcO = new cxr();
            bm bmVar5 = pVar.uJO;
            if (bmVar5 == null || (finderContact = bmVar5.contact) == null || (str3 = finderContact.username) == null) {
                FinderItem finderItem3 = pVar.tHo;
                str3 = finderItem3 != null ? finderItem3.field_username : null;
            }
            if (str3 == null) {
                str3 = "";
            }
            ecq.finderUsername = str3;
            ecq.NcP = pVar.uOV;
            if (bbn.tCE == 20) {
                h hVar = h.vGk;
                FinderItem FH = h.FH(pVar.feedId);
                if (FH == null || !FH.isRelatedItem()) {
                    i2 = p.vgA;
                } else {
                    i2 = p.vgB;
                }
                ecq.NcQ = i2;
            }
            if (pVar.uJO == null || ((finderItem = pVar.tHo) != null && finderItem.isReplaceLongVideoToNormal())) {
                k kVar = k.vfA;
                str4 = k.G(pVar.feedId, bbn.tCE);
            } else {
                k kVar2 = k.vfA;
                str4 = k.H(pVar.feedId, bbn.tCE);
            }
            ecq.sessionBuffer = str4;
            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            ecq.NcS = e.a.ak(bbn.tCE, pVar.feedId);
            ecq.NcW = pVar.startTime;
            int i4 = pVar.vfW;
            for (int i5 = 0; i5 < i4; i5++) {
                bitSet.set(i5, true);
            }
            if (pVar.vfY < 5) {
                bitSet.set(9, true);
            } else if (pVar.vfY < 10) {
                bitSet.set(10, true);
            } else if (pVar.vfY < 20) {
                bitSet.set(11, true);
            } else if (pVar.vfY < 30) {
                bitSet.set(12, true);
            } else if (pVar.vfY < 40) {
                bitSet.set(13, true);
            } else if (pVar.vfY < 50) {
                bitSet.set(14, true);
            } else if (pVar.vfY < 60) {
                bitSet.set(15, true);
            } else if (pVar.vfY < 70) {
                bitSet.set(16, true);
            } else if (pVar.vfY < 80) {
                bitSet.set(17, true);
            } else if (pVar.vfY < 90) {
                bitSet.set(18, true);
            } else if (pVar.vfY < 100) {
                bitSet.set(19, true);
            } else {
                bitSet.set(20, true);
            }
            float f2 = ((float) pVar.dUy) / 1000.0f;
            if (f2 < 0.5f) {
                bitSet.set(21, true);
            } else if (f2 < 1.0f) {
                bitSet.set(22, true);
            } else if (f2 < 2.0f) {
                bitSet.set(23, true);
            } else if (f2 < 3.0f) {
                bitSet.set(24, true);
            } else if (f2 < 5.0f) {
                bitSet.set(25, true);
            } else if (f2 < 10.0f) {
                bitSet.set(26, true);
            } else if (f2 < 20.0f) {
                bitSet.set(27, true);
            } else if (f2 < 30.0f) {
                bitSet.set(28, true);
            } else if (f2 < 40.0f) {
                bitSet.set(29, true);
            } else if (f2 < 50.0f) {
                bitSet.set(30, true);
            } else {
                bitSet.set(31, true);
            }
            int[] iArr = pVar.vfT;
            int length = iArr.length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                int i8 = iArr[i6];
                if (i8 <= i7) {
                    i8 = i7;
                }
                i6++;
                i7 = i8;
            }
            if (i7 == 0) {
                bitSet.set(32, true);
            } else if (i7 == 1) {
                bitSet.set(33, true);
            } else if (i7 == 2) {
                bitSet.set(34, true);
            } else if (i7 == 3) {
                bitSet.set(35, true);
            } else if (i7 == 4) {
                bitSet.set(36, true);
            } else if (i7 == 5) {
                bitSet.set(37, true);
            } else {
                bitSet.set(38, true);
            }
            long j4 = bitSet.toLongArray()[0];
            mp mpVar = ecq.NcM;
            if (mpVar != null) {
                mpVar.KQT = j4;
            }
            epf epf = ecq.NcN;
            if (epf != null) {
                epf.ElR = (int) f2;
            }
            epf epf2 = ecq.NcN;
            if (epf2 != null) {
                epf2.Nnc = pVar.videoDuration;
            }
            epf epf3 = ecq.NcN;
            if (epf3 != null) {
                epf3.sGB = pVar.dUy;
            }
            epf epf4 = ecq.NcN;
            if (epf4 != null) {
                epf4.Nnd = pVar.vgo;
            }
            epf epf5 = ecq.NcN;
            if (epf5 != null) {
                epf5.Nne = pVar.vgm;
            }
            epf epf6 = ecq.NcN;
            if (epf6 != null) {
                epf6.Nnf = pVar.dUy;
                epf6.iJF = pVar.startTime;
                epf6.Nng = pVar.endTime;
                epf6.vgi = pVar.vgi;
                epf6.Nnh = (long) pVar.vgh;
                epf6.Nni = 1;
            }
            cxr cxr2 = ecq.NcO;
            if (cxr2 != null) {
                cxr2.MCg = (int) f2;
            }
            cxr cxr3 = ecq.NcO;
            if (cxr3 != null) {
                cxr3.MCh = i7;
            }
            cxr cxr4 = ecq.NcO;
            if (cxr4 != null) {
                cxr4.MCf = pVar.vfY;
            }
            long[] jArr = pVar.vfQ;
            int length2 = jArr.length;
            int i9 = 0;
            int i10 = 0;
            while (i9 < length2) {
                int i11 = i10 + 1;
                if (jArr[i9] > 0 && (cxr = ecq.NcO) != null) {
                    cxr.MCe = i10;
                }
                i9++;
                i10 = i11;
            }
            cxr cxr5 = ecq.NcO;
            if (cxr5 != null) {
                cxr5.MCi = pVar.msj;
            }
            cxr cxr6 = ecq.NcO;
            if (cxr6 != null) {
                cxr6.MCk = pVar.msj > 0 ? 1 : 0;
            }
            cxr cxr7 = ecq.NcO;
            if (cxr7 != null) {
                cxr7.vfZ = pVar.vfZ;
            }
            cxr cxr8 = ecq.NcO;
            if (cxr8 != null) {
                cxr8.MCj = pVar.vga;
            }
            cxr cxr9 = ecq.NcO;
            if (cxr9 != null) {
                cxr9.MCr = pVar.vgl;
            }
            cxr cxr10 = ecq.NcO;
            if (cxr10 != null) {
                cxr10.MCp = pVar.vfP;
            }
            cxr cxr11 = ecq.NcO;
            if (cxr11 != null) {
                cxr11.MCs = pVar.vge;
            }
            cxr cxr12 = ecq.NcO;
            if (cxr12 != null) {
                cxr12.MCt = pVar.vgc;
            }
            cxr cxr13 = ecq.NcO;
            if (cxr13 != null) {
                cxr13.MCu = pVar.vgd;
            }
            cxr cxr14 = ecq.NcO;
            if (cxr14 != null) {
                cxr14.vge = pVar.vge;
            }
            cxr cxr15 = ecq.NcO;
            if (cxr15 != null) {
                cxr15.vgf = pVar.vgf;
            }
            cxr cxr16 = ecq.NcO;
            if (cxr16 != null) {
                cxr16.vgg = pVar.vgg;
            }
            cxr cxr17 = ecq.NcO;
            if (cxr17 != null) {
                cxr17.vgj = pVar.vgj;
            }
            cxr cxr18 = ecq.NcO;
            if (cxr18 != null) {
                cxr18.vgk = pVar.vgk;
            }
            cxr cxr19 = ecq.NcO;
            if (cxr19 != null) {
                cxr19.MCw = pVar.vgr;
            }
            FinderItem finderItem4 = pVar.tHo;
            if (finderItem4 != null) {
                cxr cxr20 = ecq.NcO;
                if (cxr20 != null) {
                    cxr20.MCl = finderItem4.getLikeFlag() != 0 ? 1 : 0;
                }
                cxr cxr21 = ecq.NcO;
                if (cxr21 != null) {
                    c.a aVar2 = c.tsp;
                    cxr21.vPj = c.a.asJ(finderItem4.getUserName()) ? 1 : 0;
                }
                cxr cxr22 = ecq.NcO;
                if (cxr22 != null) {
                    cxr22.MCn = finderItem4.getFavFlag() == 1 ? 1 : 0;
                }
            }
            cxr cxr23 = ecq.NcO;
            if (cxr23 != null) {
                cxr23.MCq = pVar.vfX;
            }
            bm bmVar6 = pVar.uJO;
            if (bmVar6 != null) {
                cxr cxr24 = ecq.NcO;
                if (cxr24 != null) {
                    cxr24.MCl = bmVar6.getFeedObject().likeFlag != 0 ? 1 : 0;
                }
                cxr cxr25 = ecq.NcO;
                if (cxr25 != null) {
                    c.a aVar3 = c.tsp;
                    FinderContact finderContact2 = bmVar6.contact;
                    cxr25.vPj = c.a.asJ(finderContact2 != null ? finderContact2.username : null) ? 1 : 0;
                }
                cxr cxr26 = ecq.NcO;
                if (cxr26 != null) {
                    if (bmVar6.getFeedObject().favFlag != 1) {
                        i3 = 0;
                    }
                    cxr26.MCn = i3;
                }
            }
            AppMethodBeat.o(250741);
            return ecq;
        }

        public static void a(ecq ecq, String str) {
            Integer num;
            Long l;
            Long l2;
            Long l3;
            Integer num2;
            Integer num3;
            Integer num4;
            Integer num5;
            Integer num6;
            Integer num7;
            Integer num8;
            Integer num9;
            Integer num10;
            Integer num11;
            Integer num12;
            Integer num13;
            Integer num14;
            Integer num15;
            Integer num16;
            Integer num17;
            Integer num18;
            Integer num19;
            Integer num20;
            Integer num21;
            Integer num22;
            Integer num23;
            Integer num24;
            Integer num25 = null;
            AppMethodBeat.i(250742);
            kotlin.g.b.p.h(ecq, LoggingConstants.LOG_FILE_PREFIX);
            kotlin.g.b.p.h(str, "tag");
            StringBuffer stringBuffer = new StringBuffer("[Stats]\n");
            a aVar = p.vgC;
            a(stringBuffer, "feedId", Long.valueOf(ecq.hFK));
            if (BuildInfo.DEBUG) {
                stringBuffer.append("strfeedId=" + com.tencent.mm.ac.d.zs(ecq.hFK) + '\n');
                e.a aVar2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                FinderItem Fy = e.a.Fy(ecq.hFK);
                if (Fy != null) {
                    stringBuffer.append("nick=" + Fy.getNickName() + ", desc=" + Fy.getDebugDescription() + '\n');
                }
            }
            a aVar3 = p.vgC;
            epf epf = ecq.NcN;
            a(stringBuffer, "vidPlayLen", epf != null ? Integer.valueOf(epf.Nnc) : null);
            a aVar4 = p.vgC;
            epf epf2 = ecq.NcN;
            if (epf2 != null) {
                num = Integer.valueOf(epf2.ElR);
            } else {
                num = null;
            }
            a(stringBuffer, "stayTime", num);
            a aVar5 = p.vgC;
            epf epf3 = ecq.NcN;
            if (epf3 != null) {
                l = Long.valueOf(epf3.sGB);
            } else {
                l = null;
            }
            a(stringBuffer, "stayTimeMs", l);
            a aVar6 = p.vgC;
            epf epf4 = ecq.NcN;
            if (epf4 != null) {
                l2 = Long.valueOf(epf4.Nnd);
            } else {
                l2 = null;
            }
            a(stringBuffer, "vidPlayTimeMs", l2);
            a aVar7 = p.vgC;
            epf epf5 = ecq.NcN;
            if (epf5 != null) {
                l3 = Long.valueOf(epf5.Nne);
            } else {
                l3 = null;
            }
            a(stringBuffer, "vidPlayingTimeMs", l3);
            a aVar8 = p.vgC;
            cxr cxr = ecq.NcO;
            if (cxr != null) {
                num2 = Integer.valueOf(cxr.MCk);
            } else {
                num2 = null;
            }
            a(stringBuffer, "share", num2);
            a aVar9 = p.vgC;
            cxr cxr2 = ecq.NcO;
            if (cxr2 != null) {
                num3 = Integer.valueOf(cxr2.MCi);
            } else {
                num3 = null;
            }
            a(stringBuffer, "forward_times", num3);
            a aVar10 = p.vgC;
            cxr cxr3 = ecq.NcO;
            if (cxr3 != null) {
                num4 = Integer.valueOf(cxr3.MCg);
            } else {
                num4 = null;
            }
            a(stringBuffer, "feed_stay_time", num4);
            a aVar11 = p.vgC;
            cxr cxr4 = ecq.NcO;
            if (cxr4 != null) {
                num5 = Integer.valueOf(cxr4.MCh);
            } else {
                num5 = null;
            }
            a(stringBuffer, "vid_replay_times", num5);
            a aVar12 = p.vgC;
            cxr cxr5 = ecq.NcO;
            if (cxr5 != null) {
                num6 = Integer.valueOf(cxr5.MCf);
            } else {
                num6 = null;
            }
            a(stringBuffer, "max_vid_play_progress", num6);
            a aVar13 = p.vgC;
            cxr cxr6 = ecq.NcO;
            if (cxr6 != null) {
                num7 = Integer.valueOf(cxr6.MCe);
            } else {
                num7 = null;
            }
            a(stringBuffer, "pageTurn", num7);
            a aVar14 = p.vgC;
            cxr cxr7 = ecq.NcO;
            if (cxr7 != null) {
                num8 = Integer.valueOf(cxr7.vfZ);
            } else {
                num8 = null;
            }
            a(stringBuffer, "clickComment", num8);
            a aVar15 = p.vgC;
            cxr cxr8 = ecq.NcO;
            if (cxr8 != null) {
                num9 = Integer.valueOf(cxr8.MCj);
            } else {
                num9 = null;
            }
            a(stringBuffer, "clickHead", num9);
            a aVar16 = p.vgC;
            cxr cxr9 = ecq.NcO;
            if (cxr9 != null) {
                num10 = Integer.valueOf(cxr9.MCl);
            } else {
                num10 = null;
            }
            a(stringBuffer, "likeStatus", num10);
            a aVar17 = p.vgC;
            cxr cxr10 = ecq.NcO;
            if (cxr10 != null) {
                num11 = Integer.valueOf(cxr10.vPj);
            } else {
                num11 = null;
            }
            a(stringBuffer, "followStatus", num11);
            a aVar18 = p.vgC;
            cxr cxr11 = ecq.NcO;
            if (cxr11 != null) {
                num12 = Integer.valueOf(cxr11.MCn);
            } else {
                num12 = null;
            }
            a(stringBuffer, "favStatus", num12);
            a aVar19 = p.vgC;
            cxr cxr12 = ecq.NcO;
            if (cxr12 != null) {
                num13 = Integer.valueOf(cxr12.MCr);
            } else {
                num13 = null;
            }
            a(stringBuffer, "notInterestAction", num13);
            a aVar20 = p.vgC;
            cxr cxr13 = ecq.NcO;
            if (cxr13 != null) {
                num14 = Integer.valueOf(cxr13.MCo);
            } else {
                num14 = null;
            }
            a(stringBuffer, "fastSlip", num14);
            a aVar21 = p.vgC;
            cxr cxr14 = ecq.NcO;
            if (cxr14 != null) {
                num15 = Integer.valueOf(cxr14.MCp);
            } else {
                num15 = null;
            }
            a(stringBuffer, "sortId", num15);
            a aVar22 = p.vgC;
            cxr cxr15 = ecq.NcO;
            if (cxr15 != null) {
                num16 = Integer.valueOf(cxr15.MCq);
            } else {
                num16 = null;
            }
            a(stringBuffer, "maxVidPlayLen", num16);
            a aVar23 = p.vgC;
            cxr cxr16 = ecq.NcO;
            if (cxr16 != null) {
                num17 = Integer.valueOf(cxr16.MCs);
            } else {
                num17 = null;
            }
            a(stringBuffer, "clickTopicTimes", num17);
            a aVar24 = p.vgC;
            cxr cxr17 = ecq.NcO;
            if (cxr17 != null) {
                num18 = Integer.valueOf(cxr17.MCt);
            } else {
                num18 = null;
            }
            a(stringBuffer, "expandTextTimes", num18);
            a aVar25 = p.vgC;
            cxr cxr18 = ecq.NcO;
            if (cxr18 != null) {
                num19 = Integer.valueOf(cxr18.MCu);
            } else {
                num19 = null;
            }
            a(stringBuffer, "shareMomentTimes", num19);
            a aVar26 = p.vgC;
            cxr cxr19 = ecq.NcO;
            if (cxr19 != null) {
                num20 = Integer.valueOf(cxr19.vge);
            } else {
                num20 = null;
            }
            a(stringBuffer, "clickPoiTimes", num20);
            a aVar27 = p.vgC;
            cxr cxr20 = ecq.NcO;
            if (cxr20 != null) {
                num21 = Integer.valueOf(cxr20.vgf);
            } else {
                num21 = null;
            }
            a(stringBuffer, "collapseTextTimes", num21);
            a aVar28 = p.vgC;
            cxr cxr21 = ecq.NcO;
            if (cxr21 != null) {
                num22 = Integer.valueOf(cxr21.vgg);
            } else {
                num22 = null;
            }
            a(stringBuffer, "commentLikeTimes", num22);
            a aVar29 = p.vgC;
            cxr cxr22 = ecq.NcO;
            if (cxr22 != null) {
                num23 = Integer.valueOf(cxr22.vgj);
            } else {
                num23 = null;
            }
            a(stringBuffer, "clickFeedMenu", num23);
            a aVar30 = p.vgC;
            cxr cxr23 = ecq.NcO;
            if (cxr23 != null) {
                num24 = Integer.valueOf(cxr23.vgk);
            } else {
                num24 = null;
            }
            a(stringBuffer, "complainTimes", num24);
            a aVar31 = p.vgC;
            a(stringBuffer, "actionTimeMs", Long.valueOf(ecq.NcP));
            a aVar32 = p.vgC;
            a(stringBuffer, "feedScene", Integer.valueOf(ecq.NcQ));
            a aVar33 = p.vgC;
            String str2 = ecq.sessionBuffer;
            if (str2 != null) {
                num25 = Integer.valueOf(str2.length());
            }
            a(stringBuffer, "sessionBuffer", num25);
            Log.i(str, stringBuffer.toString());
            AppMethodBeat.o(250742);
        }

        private static void a(StringBuffer stringBuffer, String str, Long l) {
            AppMethodBeat.i(250743);
            kotlin.g.b.p.h(stringBuffer, "sb");
            kotlin.g.b.p.h(str, "key");
            if (l == null || l.longValue() != 0) {
                stringBuffer.append(str + '=' + l + '\n');
            }
            AppMethodBeat.o(250743);
        }

        private static void a(StringBuffer stringBuffer, String str, Integer num) {
            AppMethodBeat.i(250744);
            kotlin.g.b.p.h(stringBuffer, "sb");
            kotlin.g.b.p.h(str, "key");
            if (num == null || num.intValue() != 0) {
                stringBuffer.append(str + '=' + num + '\n');
            }
            AppMethodBeat.o(250744);
        }
    }

    static {
        AppMethodBeat.i(250749);
        AppMethodBeat.o(250749);
    }
}
