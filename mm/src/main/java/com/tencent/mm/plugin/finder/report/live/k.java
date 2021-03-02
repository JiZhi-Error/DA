package com.tencent.mm.plugin.finder.report.live;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.g.b.a.cn;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.g.b.a.cq;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.g.b.a.cw;
import com.tencent.mm.g.b.a.cy;
import com.tencent.mm.g.b.a.de;
import com.tencent.mm.g.b.a.eb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.b.b;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.g;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.report.live.f;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0004J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\bH\u0002J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\bH\u0002J\u001a\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020*2\u0006\u0010+\u001a\u00020$H\u0002J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010\bJ\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020-H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020.H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020/H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020\bH\u0002J\u001a\u00103\u001a\u00020\u00132\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107J\u0018\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020$2\b\u0010:\u001a\u0004\u0018\u00010\bJ\u000e\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u001aJ(\u0010=\u001a\u00020\u00132\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u00109\u001a\u00020@2\u0006\u0010%\u001a\u00020\b2\u0006\u0010A\u001a\u00020BJR\u0010=\u001a\u00020\u00132\b\u0010>\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u00109\u001a\u00020@2\u0006\u0010%\u001a\u00020\b2\u0006\u0010A\u001a\u00020B2\u0006\u0010J\u001a\u00020\fJ\u0010\u0010K\u001a\u00020\u00132\b\u0010L\u001a\u0004\u0018\u00010MJ&\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020P2\u0006\u0010#\u001a\u00020$2\u0006\u00109\u001a\u00020@2\u0006\u0010%\u001a\u00020\bJ2\u0010N\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010Q2\b\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020$2\u0006\u00109\u001a\u00020@2\u0006\u0010%\u001a\u00020\bJ@\u0010N\u001a\u00020\u00132\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020$2\u0006\u0010T\u001a\u00020$2\u0006\u00109\u001a\u00020@2\u0006\u0010%\u001a\u00020\bJ\u001e\u0010U\u001a\u00020\u00132\u0006\u0010O\u001a\u00020P2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\bJ\u000e\u0010V\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018JX\u0010W\u001a\u00020\u00132\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020$2\u0006\u0010T\u001a\u00020$2\u0006\u00109\u001a\u00020@2\u0006\u0010%\u001a\u00020\b2\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020[J\u0018\u0010\\\u001a\u00020\u00132\u0006\u0010<\u001a\u00020@2\b\u0010]\u001a\u0004\u0018\u00010^J8\u0010_\u001a\u00020\u00132\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u00109\u001a\u00020@2\u0006\u0010%\u001a\u00020\b2\u0006\u0010A\u001a\u00020B2\u0006\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u0004J\u0018\u0010b\u001a\u00020\u00132\u0006\u00109\u001a\u00020c2\b\u0010d\u001a\u0004\u0018\u00010\bJ\u0018\u0010e\u001a\u00020\u00132\u0006\u0010<\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010\bJ\u0006\u0010h\u001a\u00020\u0013J\u0018\u0010i\u001a\u00020\u00132\u0006\u00109\u001a\u00020j2\b\u0010k\u001a\u0004\u0018\u00010\bJ\u0018\u0010l\u001a\u00020\u00132\u0006\u00109\u001a\u00020m2\b\u0010)\u001a\u0004\u0018\u00010\bJ\u000e\u0010n\u001a\u00020\u00132\u0006\u0010o\u001a\u00020pJ\u0016\u0010q\u001a\u00020\u00132\u0006\u0010o\u001a\u00020r2\u0006\u0010s\u001a\u00020\bJ\u000e\u0010t\u001a\u00020\u00132\u0006\u0010o\u001a\u00020uJ(\u0010v\u001a\u00020\u00132\u0006\u0010w\u001a\u00020x2\b\u0010g\u001a\u0004\u0018\u00010\b2\u0006\u0010y\u001a\u00020\u00042\u0006\u0010z\u001a\u00020\u0004J\u000e\u0010{\u001a\u00020\u00132\u0006\u0010o\u001a\u00020|J\u000e\u0010}\u001a\u00020\u00132\u0006\u0010~\u001a\u00020\u001aJ\u0010\u0010\u001a\u00020\u00132\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u00020\u00132\t\u0010\u0001\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020\u0004J\u0013\u0010\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J\u000f\u0010\u0001\u001a\u00020\u00132\u0006\u0010o\u001a\u00020\u0004J\t\u0010\u0001\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/HellLiveReport;", "", "()V", "INVALIDATE_NEARBY_TAB_TYPE", "", "NEARBY_TAB_TYPE_ARRAY", "", "TAG", "", "fullStatic", "Lcom/tencent/mm/plugin/finder/report/live/FullFeedExploreStatics;", "isClickStartLive", "", "isPullupListHalfPage", "m21053Reporter", "Lcom/tencent/mm/plugin/finder/report/live/Audience21053Report;", "mConfig", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig;", "_doReport21053OnClick", "", "clickData", "Lcom/tencent/mm/plugin/finder/report/live/HellVisitorClickData;", "_doReport21053OnEnter", "enterData", "Lcom/tencent/mm/plugin/finder/report/live/HellVisitorEnterData;", "getCacheExitEvent", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExitType;", "getConfig", "getCoverType", "handleAnchorLinkMicDuration", "handleLinkMicDuration", "linkType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkType;", "initBeauty", "initClickEvent", "pos", "", "commentscene", "initCommField", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderFaceVerifyStreamStruct;", "userName", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveActionStruct;", AppMeasurement.Param.TIMESTAMP, "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveEntranceLogStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveResultStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveStreamStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderNoticeLiveStreamStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderStartLiveResultStruct;", "initEnterEvent", "initFilter", "report", "finderLiveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "report21017", "actionType", "actionJson", "report21024", "type", "report21053", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "event", "Lcom/tencent/mm/plugin/finder/report/live/HELL_SCROLL_EVENT;", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "firstVisibleItem", "visibleItemCount", "headerShow", "report21053FeedOnFull", "centerFeed", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "report21053OnClick", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "feedId", "liveId", "onlineNum", "report21053OnClickOnAvatar", "report21053OnClickOnShare", "report21053OnEnter", "enterStatus", "enterTime", "enterType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "report21053OnFull", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "report21053OnNearby", "fromType", "toType", "report21054", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorActionType;", "json", "report21054OnLottery", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorLotteryType;", "result", "report21056", "report21106", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LiveBookAction;", "value", "report21113", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LiveVerified;", "report21631", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyAction2;", "report21919", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorLiveClose;", "actionResult", "report21919OnVest", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CloseUISeeGiftList;", "reportLinkMic", "linkOp", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkOp;", "micType", "inviteType", "reportVest", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$SEE_GIFT_LIST;", "setCacheExitEvent", "exitType", "setCoverType", "coverType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CoverType2;", "setDesc", "desc", "setErrorCode", "errCode", "setPoiJSONObject", "jsonObject", "Lorg/json/JSONObject;", "setRule", "setTimestampOfEnterLiveAnchorUI", "plugin-finder_release"})
public final class k {
    private static boolean USZ;
    private static boolean hIM;
    private static final s vjZ = new s();
    private static final a vka = new a();
    private static final b vkb = new b();
    private static final List<Integer> vkc = j.listOf((Object[]) new Integer[]{1001, 1002, 1003});
    public static final k vkd = new k();

    static {
        AppMethodBeat.i(250982);
        AppMethodBeat.o(250982);
    }

    private k() {
    }

    public static void a(s.i iVar) {
        AppMethodBeat.i(261327);
        p.h(iVar, NativeProtocol.WEB_DIALOG_ACTION);
        Log.w("HABBYGE-MALI.HellLiveReport", "report21919OnVest, action: " + iVar.name());
        if (iVar == s.i.UNDEFINE) {
            AppMethodBeat.o(261327);
            return;
        }
        a(s.e.SEE_GIFT_LIST, String.valueOf(iVar.action));
        AppMethodBeat.o(261327);
    }

    public static void a(s.e eVar, String str) {
        AppMethodBeat.i(250950);
        p.h(eVar, NativeProtocol.WEB_DIALOG_ACTION);
        p.h(str, "actionResult");
        long currentTimeMillis = System.currentTimeMillis();
        switch (l.$EnumSwitchMapping$0[eVar.ordinal()]) {
            case 1:
                if (p.j(str, String.valueOf(s.i.CLICK_FETCH_INCOME.action))) {
                    c.sEw = String.valueOf(vjZ.vlO);
                    c.sEx = currentTimeMillis;
                    break;
                } else if (p.j(str, String.valueOf(s.i.ENTER_UI.action))) {
                    vjZ.vlP = true;
                    break;
                } else if (p.j(str, String.valueOf(s.i.RETRUN_LIVE_CLOSE_UI.action)) && !vjZ.vlP) {
                    AppMethodBeat.o(250950);
                    return;
                }
            case 2:
                vjZ.vlP = false;
                break;
        }
        ct ctVar = new ct();
        ctVar.hO((long) eVar.type);
        ctVar.nu(str);
        ctVar.hP(currentTimeMillis);
        ctVar.nv(String.valueOf(vjZ.vlO));
        ctVar.bfK();
        Log.i("HABBYGE-MALI.HellLiveReport", "report21919: actionType=" + ctVar.acL() + ", actionResult=" + ctVar.acu() + ", actionTimeMs=" + ctVar.acK() + ", sessionId=" + ctVar.getSessionId());
        AppMethodBeat.o(250950);
    }

    public static void a(s.af afVar) {
        AppMethodBeat.i(250951);
        p.h(afVar, NativeProtocol.WEB_DIALOG_ACTION);
        switch (l.haE[afVar.ordinal()]) {
            case 1:
                hIM = false;
                break;
            case 2:
                hIM = true;
                vjZ.b(s.ao.NEARBY_LIVE);
                break;
            case 3:
                if (hIM) {
                    hIM = false;
                    AppMethodBeat.o(250951);
                    return;
                }
                break;
        }
        cq cqVar = new cq();
        cqVar.hJ(System.currentTimeMillis());
        cqVar.hK((long) afVar.action);
        cqVar.hI((long) vjZ.vmr.type);
        String cMD = ((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        cqVar.nd(cMD);
        d dVar = d.uTq;
        cqVar.nb(d.acj());
        d dVar2 = d.uTq;
        cqVar.nc(d.dlA());
        cqVar.bfK();
        Log.i("HABBYGE-MALI.HellLiveReport", "report21631: actionTS=" + cqVar.acs() + ", pageType=" + cqVar.acw() + ", action=" + cqVar.act() + ", clickid=" + cqVar.aec() + ", session_Id=" + cqVar.aee() + ", contextID=" + cqVar.aed() + ", clickTabContextId=" + cqVar.ack());
        AppMethodBeat.o(250951);
    }

    public static void q(long j2, String str) {
        String str2;
        AppMethodBeat.i(250953);
        if (j2 == s.a.PROFILE_LIVE_BTN_CLICK.hlf) {
            s sVar = vjZ;
            sVar.b(sVar.vlU);
        }
        cy cyVar = new cy();
        a(cyVar);
        if (j2 == s.a.LINKMIC_SWITCH.hlf) {
            if (p.j(str, String.valueOf(s.y.OPEN.action))) {
                vjZ.a(s.y.OPEN);
            } else if (p.j(str, String.valueOf(s.y.CLOSE.action))) {
                vjZ.a(s.y.CLOSE);
            }
        }
        cyVar.iD(j2);
        if (str == null || (str2 = n.j(str, ",", ";", false)) == null) {
            str2 = "";
        }
        cyVar.oe(str2);
        cyVar.iE((long) vjZ.vms.source);
        cyVar.bfK();
        Log.i("HABBYGE-MALI.HellLiveReport", "report21017: finderUsrname=" + cyVar.acG() + ", finderWxAppInfo=" + cyVar.acH() + ", isPrivate=" + cyVar.acI() + ", finderSessionId=" + cyVar.acJ() + ", actionTimeMs=" + cyVar.acK() + ", actionType=" + cyVar.acL() + ", sourceScene=" + cyVar.adn() + ", actionJson=" + cyVar.aeO());
        AppMethodBeat.o(250953);
    }

    public static void a(s.o oVar) {
        String str;
        String str2;
        String str3;
        long j2;
        awc awc;
        String jSONObject;
        AppMethodBeat.i(250954);
        p.h(oVar, "type");
        eb ebVar = new eb();
        ebVar.qq(s.dpt());
        ebVar.qr(vjZ.dpp());
        ebVar.ld(s.dpu());
        ebVar.qs(s.dps());
        ebVar.lo(System.currentTimeMillis());
        ebVar.lv(oVar.dDw);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        ebVar.lp((long) aAh.azQ().getInt(ar.a.USERINFO_FINDER_FANS_COUNT_INT_SYNC, 0));
        a aDC = a.aDC();
        p.g(aDC, "ConfigHelper.getInstance()");
        ebVar.lq((long) (aDC.aDG().hBp == 0 ? 2 : 1));
        ebVar.lr(vjZ.vmc);
        ebVar.ls(System.currentTimeMillis() - ebVar.afn());
        ebVar.lu(vjZ.vmd);
        s sVar = vjZ;
        JSONObject jSONObject2 = sVar.vme;
        if (jSONObject2 == null || (jSONObject = jSONObject2.toString()) == null || (str = n.j(jSONObject, ",", ";", false)) == null) {
            str = "";
        }
        sVar.vme = null;
        ebVar.qt(str);
        s sVar2 = vjZ;
        String str4 = sVar2.desc;
        if (str4 == null || (str2 = n.j(str4, ",", ";", false)) == null) {
            str2 = "";
        }
        sVar2.desc = null;
        ebVar.qu(str2);
        ebVar.lt((long) vjZ.vmf);
        o oVar2 = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ == null || (awc = dfZ.uEl) == null || (str3 = awc.vtD) == null) {
            str3 = "";
        }
        ebVar.qz(str3);
        ebVar.qy("");
        Iterator<Long> it = vjZ.vmp.iterator();
        while (it.hasNext()) {
            ebVar.qy(ebVar.aft() + it.next() + '#');
        }
        String aft = ebVar.aft();
        p.g(aft, "struct.goodsListJson");
        if (n.nm(aft, "#")) {
            String aft2 = ebVar.aft();
            p.g(aft2, "struct.goodsListJson");
            int length = ebVar.aft().length() - 1;
            if (aft2 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(250954);
                throw tVar;
            }
            String substring = aft2.substring(0, length);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            ebVar.qy(substring);
        }
        switch (l.uqL[oVar.ordinal()]) {
            case 1:
                ebVar.qv(vjZ.dpq());
                ebVar.qw(vjZ.dpr());
                ebVar.qx(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                break;
            case 2:
                ebVar.qv(vjZ.dpq());
                ebVar.qw(vjZ.dpr());
                ebVar.qx(String.valueOf(vjZ.errCode));
                break;
            case 3:
                ebVar.qv(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                ebVar.qw(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                ebVar.qx(String.valueOf(vjZ.errCode));
                break;
            case 4:
                ebVar.qv(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                ebVar.qw(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                ebVar.qx(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                vjZ.setTag("");
                vjZ.auS("");
                vjZ.a(s.aq.PUBLIC);
                vjZ.vlX = 0;
                break;
        }
        ebVar.qA(dpf());
        ebVar.qB(dpg());
        ebVar.qE(String.valueOf(vjZ.vlL.action));
        ebVar.lw((long) vjZ.vms.source);
        ebVar.qC(q.encode(vjZ.tag, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        ebVar.qD(q.encode(vjZ.vlT, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        ebVar.lx((long) vjZ.vlW.type);
        if (vjZ.vlW == s.aq.NUMBER_TO_SEE) {
            j2 = vjZ.vlX;
        } else {
            j2 = 0;
        }
        ebVar.ly(j2);
        ebVar.bfK();
        Log.i("HABBYGE-MALI.HellLiveReport", "report21024: finderUsrname=" + ebVar.acG() + ", finderWxAppInfo=" + ebVar.acH() + ", isPrivate=" + ebVar.acI() + ", finderSessionId=" + ebVar.acJ() + ", actionTimeMs=" + ebVar.acK() + ", exitType=" + ebVar.adH() + ", fansCount=" + ebVar.afl() + ", cameraStatus=" + ebVar.afm() + ", enterUITimeMs=" + ebVar.afn() + ", stayTimeMs=" + ebVar.afo() + ", coverType=" + ebVar.afp() + ", ruleType=" + ebVar.afq() + ", poiJson=" + ebVar.afr() + ", description=" + ebVar.getDescription() + ", liveId=" + ebVar.adj() + ", feedId=" + ebVar.adk() + ", errorCode=" + ebVar.afs() + ", goodsListJson=" + ebVar.aft() + ", retouchResult=" + ebVar.afu() + ", filtersResult=" + ebVar.afv() + ", connectSwitch=" + ebVar.afw() + ", sourceScene=" + ebVar.adn() + ", tag=" + ebVar.getTag() + ", subTag=" + ebVar.aeL() + ", visibleRange=" + ebVar.aeN() + ", shopWindowId=" + ebVar.aeH());
        AppMethodBeat.o(250954);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r0 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (r0 == null) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f4, code lost:
        if (r0 == null) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0138, code lost:
        if (r0 == null) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0028, code lost:
        if (r0 == null) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String dpf() {
        /*
        // Method dump skipped, instructions count: 445
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.k.dpf():java.lang.String");
    }

    private static String dpg() {
        String str;
        int i2;
        AppMethodBeat.i(250956);
        s sVar = vjZ;
        o oVar = o.ujN;
        b aGl = o.aGl();
        if (aGl != null) {
            str = aGl.hDj;
        } else {
            str = null;
        }
        sVar.vlH = s.auT(str).type;
        s sVar2 = vjZ;
        o oVar2 = o.ujN;
        b aGl2 = o.aGl();
        if (aGl2 != null) {
            i2 = aGl2.hDk;
        } else {
            i2 = 0;
        }
        sVar2.hDk = i2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", vjZ.vlH);
        jSONObject.put("result", vjZ.hDk);
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "json.toString()");
        String j2 = n.j(jSONObject2, ",", ";", false);
        AppMethodBeat.o(250956);
        return j2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(s.f fVar, String str) {
        String string;
        String str2;
        AppMethodBeat.i(250957);
        p.h(fVar, "type");
        switch (l.vke[fVar.ordinal()]) {
            case 1:
                vjZ.vlB = true;
                str2 = null;
                break;
            case 2:
                vjZ.vlC = true;
                str2 = null;
                break;
            case 3:
                if (TextUtils.isEmpty(str)) {
                    AppMethodBeat.o(250957);
                    return;
                }
                str2 = null;
                break;
            case 4:
                if (str != null) {
                    try {
                        List<String> a2 = n.a(str, new String[]{"@"});
                        if (a2 != null) {
                            int parseInt = Integer.parseInt(a2.get(0));
                            List<String> a3 = n.a(a2.get(1), new String[]{";"});
                            if (parseInt == 1) {
                                if (!TextUtils.isEmpty(a3.get(0))) {
                                    string = a3.get(0);
                                }
                                string = MMApplicationContext.getResources().getString(R.string.cuo);
                            } else {
                                if (parseInt == 2) {
                                    string = MMApplicationContext.getResources().getString(R.string.cvn);
                                }
                                string = MMApplicationContext.getResources().getString(R.string.cuo);
                            }
                            p.g(string, "if (lotteryType == Const…live_lottery_any_comment)");
                            str2 = string + ';' + a3.get(1) + ';' + a3.get(2) + ';' + a3.get(3);
                            vjZ.vlA++;
                            break;
                        }
                    } catch (Exception e2) {
                        Log.e("HABBYGE-MALI.HellLiveReport", "START_LOTTERY_SUCCESS crash: " + e2.getMessage());
                        AppMethodBeat.o(250957);
                        return;
                    }
                }
                AppMethodBeat.o(250957);
                return;
            default:
                str2 = null;
                break;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", fVar.type);
        if (str2 == null) {
            str2 = str;
        }
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put("result", str2);
        a(s.c.LIVE_ANCHOR_LOTTERY, jSONObject.toString());
        AppMethodBeat.o(250957);
    }

    public static void a(s.x xVar, String str, int i2, int i3) {
        AppMethodBeat.i(261328);
        p.h(xVar, "linkOp");
        switch (l.vkf[xVar.ordinal()]) {
            case 1:
                vjZ.vlI++;
                vjZ.vkW.add(com.tencent.mm.vending.j.a.i(s.z.AUDIO, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
                break;
            case 2:
                vjZ.vlI++;
                vjZ.vkW.add(com.tencent.mm.vending.j.a.i(s.z.vpH, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
                break;
            case 3:
                if (vjZ.vlK) {
                    vjZ.vlK = false;
                    a(s.z.AUDIO);
                    break;
                } else {
                    a(s.z.AUDIO);
                    AppMethodBeat.o(261328);
                    return;
                }
            case 4:
                if (!vjZ.vlM) {
                    a(s.z.vpH);
                    break;
                } else {
                    a(s.z.vpH);
                    vjZ.vlM = false;
                    AppMethodBeat.o(261328);
                    return;
                }
            case 5:
                if (str != null) {
                    vjZ.UTd = true;
                    vjZ.UTe.add(com.tencent.mm.vending.j.a.i(str, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
                    break;
                } else {
                    AppMethodBeat.o(261328);
                    return;
                }
            case 6:
                if (vjZ.UTd) {
                    hUF();
                    AppMethodBeat.o(261328);
                    return;
                }
                break;
            case 7:
                hUF();
                AppMethodBeat.o(261328);
                return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", xVar.action);
        if (str == null) {
            str = "";
        }
        jSONObject.put("result", str);
        jSONObject.put("MicType", i2);
        jSONObject.put("InviteType", i3);
        a(s.c.LINKMIC_OP, jSONObject.toString());
        AppMethodBeat.o(261328);
    }

    public static void a(s.ak akVar) {
        s.i iVar;
        AppMethodBeat.i(261329);
        p.h(akVar, NativeProtocol.WEB_DIALOG_ACTION);
        Log.w("HABBYGE-MALI.HellLiveReport", "reportVest, action: " + akVar.name());
        switch (l.vlj[akVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (!USZ && !vjZ.vlP) {
                    AppMethodBeat.o(261329);
                    return;
                }
        }
        if (vjZ.vlP) {
            p.h(akVar, NativeProtocol.WEB_DIALOG_ACTION);
            switch (t.haE[akVar.ordinal()]) {
                case 1:
                    iVar = s.i.CLICK_LIST_ITEM_USER;
                    break;
                case 2:
                    iVar = s.i.EXPOSE_USER_FINDER_HALF_BOARD;
                    break;
                case 3:
                    iVar = s.i.CLICK_PRIVATE_MSG_USER;
                    break;
                case 4:
                    iVar = s.i.CLICK_FOLLOW_USER;
                    break;
                case 5:
                    iVar = s.i.CLICK_ENTER_USER_PROFILE;
                    break;
                default:
                    iVar = s.i.UNDEFINE;
                    break;
            }
            a(iVar);
            AppMethodBeat.o(261329);
            return;
        }
        a(s.c.SEE_GIFT_LIST, String.valueOf(akVar.action));
        AppMethodBeat.o(261329);
    }

    public static void a(s.c cVar, String str) {
        String str2;
        String str3;
        AppMethodBeat.i(250958);
        p.h(cVar, "actionType");
        m mVar = m.vVH;
        if (!m.dBP()) {
            AppMethodBeat.o(250958);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        switch (l.vlk[cVar.ordinal()]) {
            case 1:
                vjZ.vlO = currentTimeMillis;
                vjZ.vmj.vtj = currentTimeMillis;
                break;
            case 2:
                if (p.j(str, String.valueOf(s.u.BY_MORE_OPEN_GIFT.action))) {
                    vjZ.a(s.v.YES);
                    break;
                }
                break;
            case 3:
                if (vjZ.vmi <= 0) {
                    AppMethodBeat.o(250958);
                    return;
                }
                break;
            case 4:
                if (p.j(str, String.valueOf(s.r.LIVE_FLOAT_ACTION_MAXIMIZE.type))) {
                    vjZ.vlB = false;
                    vjZ.vlC = false;
                    break;
                }
                break;
            case 5:
                if (!p.j(str, String.valueOf(s.ak.CLICK_BEANSPROUTS_PULLUP_LIST_HALF_PAGE.action))) {
                    if (p.j(str, String.valueOf(s.ak.RETURN_LIVE_ROOM.action))) {
                        USZ = false;
                        break;
                    }
                } else {
                    USZ = true;
                    break;
                }
                break;
        }
        cn cnVar = new cn();
        a(cnVar, currentTimeMillis);
        cnVar.mA(vjZ.dpq());
        cnVar.mB(vjZ.dpr());
        if (TextUtils.isEmpty(vjZ.vmj.description)) {
            str2 = s.getDescription();
        } else {
            str2 = vjZ.vmj.description;
        }
        cnVar.mC(str2);
        cnVar.gK(vjZ.vmi);
        cnVar.gL(vjZ.vmg);
        cnVar.gM(vjZ.vmh);
        cnVar.gN((long) cVar.action);
        switch (l.vll[cVar.ordinal()]) {
            case 1:
                cnVar.mD(dpf());
                break;
            case 2:
                cnVar.mD(dpg());
                break;
            default:
                if (str == null || (str3 = n.j(str, ",", ";", false)) == null) {
                    str3 = "";
                }
                cnVar.mD(str3);
                break;
        }
        cnVar.gO((long) vjZ.vms.source);
        cnVar.bfK();
        Log.i("HABBYGE-MALI.HellLiveReport", "report21054: finderUsrname=" + cnVar.acG() + ", finderWxAppInfo=" + cnVar.acH() + ", isPrivate=" + cnVar.acI() + ", finderSessionId=" + cnVar.acJ() + ", actionTimeMs=" + cnVar.acK() + ", liveId=" + cnVar.adj() + ", feedId=" + cnVar.adk() + ", description=" + cnVar.getDescription() + ", sourceScene=" + cnVar.adn() + ", liveTime=" + cnVar.aco() + ", likeCount=" + cnVar.adl() + ", onlineCount=" + cnVar.adm() + ", actionType=" + cnVar.acL() + ", actionResult=" + cnVar.acu());
        AppMethodBeat.o(250958);
    }

    private static void a(s.z zVar) {
        AppMethodBeat.i(250959);
        long currentTimeMillis = System.currentTimeMillis();
        for (int size = vjZ.vkW.size() - 1; size >= 0; size--) {
            com.tencent.mm.vending.j.d<s.z, Long, Boolean> dVar = vjZ.vkW.get(size);
            p.g(dVar, "mConfig.gLinkMicTimeList[i]");
            com.tencent.mm.vending.j.d<s.z, Long, Boolean> dVar2 = dVar;
            if (dVar2.hdM() == zVar && dVar2.hdN().longValue() > 0 && p.j(dVar2.hdO(), Boolean.FALSE)) {
                Long hdN = dVar2.hdN();
                p.g(hdN, "tuple.`$2`()");
                long longValue = (currentTimeMillis - hdN.longValue()) / 1000;
                if (longValue >= 0) {
                    vjZ.vkW.set(size, com.tencent.mm.vending.j.a.i(zVar, Long.valueOf(longValue), Boolean.TRUE));
                    AppMethodBeat.o(250959);
                    return;
                }
            }
        }
        AppMethodBeat.o(250959);
    }

    private static void hUF() {
        AppMethodBeat.i(261330);
        long currentTimeMillis = System.currentTimeMillis();
        for (int size = vjZ.UTe.size() - 1; size >= 0; size--) {
            com.tencent.mm.vending.j.d<String, Long, Boolean> dVar = vjZ.UTe.get(size);
            p.g(dVar, "mConfig.gAnchorLinkMicTimeList[i]");
            com.tencent.mm.vending.j.d<String, Long, Boolean> dVar2 = dVar;
            if (dVar2.hdN().longValue() > 0 && p.j(dVar2.hdO(), Boolean.FALSE)) {
                Long hdN = dVar2.hdN();
                p.g(hdN, "tuple.`$2`()");
                long longValue = (currentTimeMillis - hdN.longValue()) / 1000;
                if (longValue >= 0) {
                    vjZ.UTe.set(size, com.tencent.mm.vending.j.a.i(dVar2.hdM(), Long.valueOf(longValue), Boolean.TRUE));
                    AppMethodBeat.o(261330);
                    return;
                }
            }
        }
        AppMethodBeat.o(261330);
    }

    public static void dph() {
        String str;
        String str2;
        String str3;
        awc awc;
        AppMethodBeat.i(250960);
        long j2 = vjZ.vmj.vtj;
        if (j2 <= 0) {
            AppMethodBeat.o(250960);
            return;
        }
        cw cwVar = new cw();
        cwVar.nK(s.dpt());
        cwVar.nL(vjZ.dpp());
        cwVar.ko(s.dpu());
        cwVar.nM(s.dps());
        cwVar.hT(System.currentTimeMillis());
        cwVar.hY(vjZ.vmj.vtn);
        cwVar.hZ(vjZ.vmj.vto);
        cwVar.ia(vjZ.vmj.vtp);
        cwVar.hW(vjZ.vmj.vtm);
        String str4 = vjZ.vmj.hJs;
        if (TextUtils.isEmpty(str4) || p.j(str4, AppEventsConstants.EVENT_PARAM_VALUE_NO) || p.j(str4, "-1")) {
            str4 = vjZ.dpq();
        }
        cwVar.nN(str4);
        String str5 = vjZ.vmj.feedId;
        if (TextUtils.isEmpty(str5) || p.j(str5, AppEventsConstants.EVENT_PARAM_VALUE_NO) || p.j(str5, "-1")) {
            str5 = vjZ.dpr();
        }
        cwVar.nO(str5);
        if (TextUtils.isEmpty(vjZ.vmj.description)) {
            str = s.getDescription();
        } else {
            str = vjZ.vmj.description;
        }
        cwVar.nP(str);
        cwVar.hU(j2);
        cwVar.hV(vjZ.vmj.vtk);
        cwVar.hX(vjZ.vmj.vtl);
        cwVar.kp(vjZ.vmj.errorCode);
        cwVar.ib(vjZ.vmj.vtq);
        cwVar.ic(vjZ.vmj.vtr);
        cwVar.id(vjZ.vmj.vts);
        cwVar.ie(vjZ.vmj.vtt);
        cwVar.m9if(vjZ.vmj.vtu);
        cwVar.ig(vjZ.vmj.vtv);
        cwVar.ih(vjZ.vmj.vtw);
        cwVar.ii(vjZ.vmj.vtx);
        cwVar.ij(vjZ.vmj.vty);
        cwVar.ik(vjZ.vmj.vtz);
        s sVar = vjZ;
        if (sVar.vmj.vtA.isEmpty()) {
            str2 = "";
        } else {
            str2 = "";
            for (Map.Entry<Long, LinkedList<o>> entry : sVar.vmj.vtA.entrySet()) {
                Iterator<o> it = entry.getValue().iterator();
                long j3 = 0;
                while (it.hasNext()) {
                    o next = it.next();
                    if (next.vlm) {
                        j3 += next.time;
                    }
                }
                str2 = str2 + entry.getKey().longValue() + ':' + j3 + '#';
            }
            if (n.nm(str2, "#")) {
                int length = str2.length() - 1;
                if (str2 == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(250960);
                    throw tVar;
                }
                str2 = str2.substring(0, length);
                p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
        }
        cwVar.nQ(str2);
        cwVar.il((long) vjZ.vmj.vtA.size());
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ == null || (awc = dfZ.uEl) == null || (str3 = awc.vtD) == null) {
            str3 = vjZ.vmj.vtD;
        }
        cwVar.nR(str3);
        cwVar.im(vjZ.vmj.vtB);
        cwVar.ip(vjZ.vmj.vtC);
        cwVar.io(vjZ.vlA);
        cwVar.in((long) vjZ.vms.source);
        cwVar.iq((long) vjZ.vlI);
        cwVar.nT(q.encode(vjZ.tag, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        cwVar.nU(q.encode(vjZ.vlT, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        if (vjZ.vkW.isEmpty()) {
            cwVar.nS("");
        } else {
            String str6 = "";
            Iterator<com.tencent.mm.vending.j.d<s.z, Long, Boolean>> it2 = vjZ.vkW.iterator();
            while (it2.hasNext()) {
                com.tencent.mm.vending.j.d<s.z, Long, Boolean> next2 = it2.next();
                Boolean hdO = next2.hdO();
                p.g(hdO, "tuple.`$3`()");
                str6 = hdO.booleanValue() ? str6 + next2.hdM().type + '|' + next2.hdN() + ';' : str6;
            }
            if (!p.j(str6, "")) {
                int length2 = str6.length() - 1;
                if (str6 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(250960);
                    throw tVar2;
                }
                str6 = str6.substring(0, length2);
                p.g(str6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            cwVar.nS(str6);
        }
        if (vjZ.UTe.isEmpty()) {
            cwVar.amE("");
        } else {
            String str7 = "";
            Iterator<com.tencent.mm.vending.j.d<String, Long, Boolean>> it3 = vjZ.UTe.iterator();
            while (it3.hasNext()) {
                com.tencent.mm.vending.j.d<String, Long, Boolean> next3 = it3.next();
                Boolean hdO2 = next3.hdO();
                p.g(hdO2, "tuple.`$3`()");
                str7 = hdO2.booleanValue() ? str7 + next3.hdM() + '|' + next3.hdN() + ';' : str7;
            }
            if (!p.j(str7, "")) {
                int length3 = str7.length() - 1;
                if (str7 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(250960);
                    throw tVar3;
                }
                str7 = str7.substring(0, length3);
                p.g(str7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            cwVar.amE(str7);
        }
        cwVar.ir((long) vjZ.vlN.type);
        cwVar.is((long) vjZ.vlW.type);
        cwVar.iu(vjZ.vlW == s.aq.NUMBER_TO_SEE ? vjZ.vlX : 0);
        c.a aVar = c.sFa;
        cwVar.it((long) c.sEp);
        cwVar.bfK();
        u uVar = vjZ.vmj;
        uVar.hJs = "";
        uVar.feedId = "";
        uVar.description = "";
        uVar.vtj = 0;
        uVar.vtk = 0;
        uVar.vtm = 0;
        uVar.vtl = 0;
        uVar.vtn = 0;
        uVar.vto = 0;
        uVar.vtp = 0;
        uVar.errorCode = 0;
        uVar.vtq = 0;
        uVar.vtr = 0;
        uVar.vts = 0;
        uVar.vtt = 0;
        uVar.vtu = 0;
        uVar.vtv = 0;
        uVar.vtw = 0;
        uVar.vtx = 0;
        uVar.vty = 0;
        uVar.vtz = 0;
        uVar.vtD = "";
        uVar.vtB = 0;
        uVar.vtC = 0;
        uVar.vtA.clear();
        s sVar2 = vjZ;
        sVar2.vmg = 0;
        sVar2.vmh = 0;
        sVar2.vmi = 0;
        sVar2.vmk = false;
        sVar2.vml = false;
        sVar2.vmm = false;
        sVar2.vmn = false;
        sVar2.vmo = false;
        sVar2.vlI = 0;
        sVar2.vkW.clear();
        sVar2.UTd = false;
        sVar2.UTe.clear();
        sVar2.vmp.clear();
        sVar2.vlA = 0;
        sVar2.vlB = false;
        sVar2.vlC = false;
        sVar2.tag = "";
        sVar2.vlT = "";
        sVar2.vlW = s.aq.PUBLIC;
        sVar2.vlX = 0;
        sVar2.vlN = s.v.NO;
        c.a aVar2 = c.sFa;
        c.sEp = 0;
        Log.i("HABBYGE-MALI.HellLiveReport", "report21056: finderUsrname=" + cwVar.acG() + ", finderWxAppInfo=" + cwVar.acH() + ", isPrivate=" + cwVar.acI() + ", finderSessionId=" + cwVar.acJ() + ", actionTimeMs=" + cwVar.acK() + ", audienceCount=" + cwVar.aeu() + ", likeCount=" + cwVar.adl() + ", newFansNum=" + cwVar.aev() + ", liveDurationSeconds=" + cwVar.aes() + ", liveId=" + cwVar.adj() + ", feedId=" + cwVar.adk() + ", description=" + cwVar.getDescription() + ", liveStartTimeMs=" + cwVar.aeq() + ", liveEndTimeMs=" + cwVar.aer() + ", oriFansCount=" + cwVar.aet() + ", errorCode=" + cwVar.getErrorCode() + ", floatingCount=" + cwVar.adx() + ", shareSnsCount=" + cwVar.aew() + ", shareSessionCount=" + cwVar.aex() + ", exchangeCameraCount=" + cwVar.aey() + ", complainCount=" + cwVar.aez() + ", allCommentCloseCount=" + cwVar.aeA() + ", allCommentOpenCount=" + cwVar.aeB() + ", personalCommentCloseCount=" + cwVar.aeC() + ", personalCommentOpenCount=" + cwVar.aeD() + ", kickOutCount=" + cwVar.aeE() + ", promoteGoodsJson=" + cwVar.aeF() + ", promoteGoodsCount=" + cwVar.aeG() + ", shopWindowId=" + cwVar.aeH() + ", nudgeCount=" + cwVar.aeJ() + ", lotteryCount=" + cwVar.adO() + ", connectCount=" + cwVar.aeK() + ", connectDuration=" + cwVar.adR() + ", micWithAnchor=" + cwVar.aDV() + ", sourceScene=" + cwVar.adn() + ", isGift=" + cwVar.aeM() + ", tag=" + cwVar.getTag() + ", subTag=" + cwVar.aeL() + ", visibleRange=" + cwVar.aeN() + ", topComment=" + cwVar.aeI());
        AppMethodBeat.o(250960);
    }

    public static void a(s.ad adVar, String str) {
        String str2;
        AppMethodBeat.i(250961);
        p.h(adVar, "actionType");
        if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoZ(str)) {
            AppMethodBeat.o(250961);
            return;
        }
        bt btVar = new bt();
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        btVar.ke(str2);
        btVar.kf(vjZ.dpp());
        btVar.jX(s.auU(str));
        btVar.kg(s.dps());
        btVar.eF(System.currentTimeMillis());
        btVar.eG(adVar.hlf);
        btVar.bfK();
        Log.i("HABBYGE-MALI.HellLiveReport", "report21113: finderUsrname=" + btVar.acG() + ", finderWxAppInfo=" + btVar.acH() + ", isPrivate=" + btVar.acI() + ", finderSessionId=" + btVar.acJ() + ", actionTimeMs=" + btVar.acK() + ", actionJson=" + btVar.acL());
        AppMethodBeat.o(250961);
    }

    public static void a(s.ab abVar, String str) {
        AppMethodBeat.i(250962);
        p.h(abVar, "actionType");
        if (abVar == s.ab.LIVE_CANCEL_BOOK) {
            g.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.g.sFI;
            g.a.Hg(0);
        }
        de deVar = new de();
        deVar.or(s.dpt());
        deVar.os(vjZ.dpp());
        deVar.kI(s.dpu());
        deVar.ot(s.dps());
        deVar.iY(System.currentTimeMillis());
        deVar.iZ(abVar.hlf);
        if (str == null) {
            str = "";
        }
        deVar.ou(str);
        deVar.ja((long) vjZ.vmt.source);
        deVar.bfK();
        Log.i("HABBYGE-MALI.HellLiveReport", "report21106: finderUsrname=" + deVar.acG() + ", finderWxAppInfo=" + deVar.acH() + ", isPrivate=" + deVar.acI() + ", finderSessionId=" + deVar.acJ() + ", actionTimeMs=" + deVar.acK() + ", actionType=" + deVar.acL() + ", sourceScene=" + deVar.adn() + ", actionJson=" + deVar.aeO());
        AppMethodBeat.o(250962);
    }

    public static void a(AbsListView absListView, BaseAdapter baseAdapter, c.e eVar, int i2, int i3, s.p pVar, String str, c cVar, boolean z) {
        boolean z2;
        com.tencent.mm.vending.j.c<com.tencent.mm.plugin.expt.hellhound.a.a.c, Boolean> _getHellFeed;
        AppMethodBeat.i(250963);
        p.h(eVar, "visibleState");
        p.h(pVar, "actionType");
        p.h(str, "commentscene");
        p.h(cVar, "event");
        a aVar = vka;
        p.h(eVar, "visibleState");
        p.h(pVar, "actionType");
        p.h(str, "commentscene");
        p.h(cVar, "event");
        f fVar = aVar.vja;
        p.h(eVar, "visibleState");
        p.h(cVar, "event");
        p.h(pVar, "actionType");
        p.h(str, "commentscene");
        if (kotlin.a.e.contains(fVar.vjC, str)) {
            switch (g.$EnumSwitchMapping$0[eVar.ordinal()]) {
                case 1:
                    if (!fVar.vjz) {
                        fVar.dpc();
                        fVar.vjz = true;
                        break;
                    }
                    break;
                case 2:
                    if (fVar.vjz) {
                        fVar.dpd();
                        fVar.vjz = false;
                        break;
                    }
                    break;
                case 3:
                    if (z) {
                        fVar.dpc();
                        fVar.vjz = true;
                        break;
                    }
                    break;
                case 4:
                    fVar.dpd();
                    fVar.vjz = false;
                    break;
                case 5:
                    fVar.vjv.clear();
                    break;
            }
            if (p.j(str, "61")) {
                str = "temp_6";
                z2 = true;
            } else {
                z2 = false;
            }
            fVar.vjA = pVar;
            fVar.vjB = str;
            if (z2) {
                if (cVar == c.EVENT_ON_PAUSE) {
                    com.tencent.mm.plugin.expt.hellhound.a.g.d dVar = com.tencent.mm.plugin.expt.hellhound.a.g.d.sJr;
                    f.b bVar = fVar.vjI;
                    com.tencent.mm.plugin.expt.hellhound.a.g.d.mFirstPostion = -1;
                    com.tencent.mm.plugin.expt.hellhound.a.g.d.mVisibleItemCount = -1;
                    com.tencent.mm.plugin.expt.hellhound.a.g.d.sJk.clear();
                    if (bVar != null) {
                        com.tencent.mm.plugin.expt.hellhound.a.g.d.listeners.remove(bVar);
                    }
                    fVar.vjG = true;
                } else if (cVar == c.EVENT_ON_RESUME) {
                    fVar.vjG = false;
                    com.tencent.mm.plugin.expt.hellhound.a.g.d dVar2 = com.tencent.mm.plugin.expt.hellhound.a.g.d.sJr;
                    com.tencent.mm.plugin.expt.hellhound.a.g.d.registerListener(fVar.vjI);
                }
                if (!fVar.vjG) {
                    com.tencent.mm.plugin.expt.hellhound.a.g.d dVar3 = com.tencent.mm.plugin.expt.hellhound.a.g.d.sJr;
                    if (absListView != null) {
                        if (com.tencent.mm.plugin.expt.hellhound.a.g.d.mScreenHeight <= 0) {
                            Context context = absListView.getContext();
                            if (!(context instanceof AppCompatActivity)) {
                                context = null;
                            }
                            AppCompatActivity appCompatActivity = (AppCompatActivity) context;
                            AppCompatActivity appCompatActivity2 = appCompatActivity;
                            if (appCompatActivity2 != null) {
                                Resources resources = appCompatActivity2.getResources();
                                int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
                                com.tencent.mm.plugin.expt.hellhound.a.g.d.mStatusBarHeight = dimensionPixelSize;
                                if (dimensionPixelSize <= 0) {
                                    com.tencent.mm.plugin.expt.hellhound.a.g.d.mStatusBarHeight = resources.getDimensionPixelSize(R.dimen.a3n);
                                }
                            }
                            com.tencent.mm.plugin.expt.hellhound.a.g.d.initActionBarHeight(appCompatActivity);
                            com.tencent.mm.plugin.expt.hellhound.a.g.d.initScreenHeight(appCompatActivity);
                            Log.i("HABBYGE-MALI.SnsFeedMonitor", "init: mScreenRealHeight=" + com.tencent.mm.plugin.expt.hellhound.a.g.d.mScreenRealHeight + ", mScreenHeight=" + com.tencent.mm.plugin.expt.hellhound.a.g.d.mScreenHeight + ", mStatusBarHeight=" + com.tencent.mm.plugin.expt.hellhound.a.g.d.mStatusBarHeight + ", mActionBarHeight=" + com.tencent.mm.plugin.expt.hellhound.a.g.d.mActionBarHeight + ", virtualKeyHeight=" + com.tencent.mm.plugin.expt.hellhound.a.g.d.virtualKeyHeight);
                        }
                        if (i2 >= 0 && i3 > 0) {
                            com.tencent.mm.plugin.expt.hellhound.a.g.d.mFirstPostion = i2;
                            com.tencent.mm.plugin.expt.hellhound.a.g.d.mVisibleItemCount = i3;
                        }
                        for (int i4 = com.tencent.mm.plugin.expt.hellhound.a.g.d.mVisibleItemCount - 1; i4 >= 0; i4--) {
                            View childAt = absListView.getChildAt(i4);
                            if (!(childAt == null || (_getHellFeed = com.tencent.mm.plugin.expt.hellhound.a.g.d._getHellFeed(childAt, i4, absListView, com.tencent.mm.plugin.expt.hellhound.a.g.d.mFirstPostion)) == null)) {
                                com.tencent.mm.plugin.expt.hellhound.a.a.c hdM = _getHellFeed.hdM();
                                Boolean hdN = _getHellFeed.hdN();
                                p.g(hdN, "isShow");
                                if (hdN.booleanValue()) {
                                    if (!com.tencent.mm.plugin.expt.hellhound.a.g.d.sJk.containsKey(hdM.sBK.feedId)) {
                                        String str2 = hdM.sBK.feedId;
                                        p.g(str2, "snsFeed.feed.feedId");
                                        p.g(hdM, "snsFeed");
                                        com.tencent.mm.plugin.expt.hellhound.a.g.d.sJk.put(str2, hdM);
                                        com.tencent.mm.plugin.expt.hellhound.a.g.d.onFeedAppear(baseAdapter, hdM, childAt);
                                    }
                                } else if (com.tencent.mm.plugin.expt.hellhound.a.g.d.sJk.containsKey(hdM.sBK.feedId)) {
                                    com.tencent.mm.plugin.expt.hellhound.a.g.d.sJk.remove(hdM.sBK.feedId);
                                    p.g(hdM, "snsFeed");
                                    com.tencent.mm.plugin.expt.hellhound.a.g.d.cQU();
                                }
                            }
                        }
                    }
                }
                AppMethodBeat.o(250963);
                return;
            }
            if (cVar == c.EVENT_ON_PAUSE) {
                Method method = fVar.vjF;
                if (method == null) {
                    p.btv("unregister_method");
                }
                method.invoke(null, fVar.vjH);
                fVar.vjG = true;
            } else if (cVar == c.EVENT_ON_RESUME) {
                fVar.vjG = false;
                Method method2 = fVar.vjE;
                if (method2 == null) {
                    p.btv("register_method");
                }
                method2.invoke(null, fVar.vjH);
            }
            if (!fVar.vjG) {
                Method method3 = fVar.vjD;
                if (method3 == null) {
                    p.btv("monitor_method");
                }
                method3.invoke(null, absListView, baseAdapter, Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }
        AppMethodBeat.o(250963);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        if (r0.equals("101") != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        r0 = "25";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        if (r0.equals("102") != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        if (r0.equals("999") != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.support.v7.widget.RecyclerView r3, com.tencent.mm.plugin.finder.report.live.s.p r4, java.lang.String r5, com.tencent.mm.plugin.finder.report.live.c r6) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.live.k.b(android.support.v7.widget.RecyclerView, com.tencent.mm.plugin.finder.report.live.s$p, java.lang.String, com.tencent.mm.plugin.finder.report.live.c):void");
    }

    public static void a(s.p pVar, FeedData feedData) {
        AppMethodBeat.i(250965);
        p.h(pVar, "type");
        if (feedData == null) {
            AppMethodBeat.o(250965);
            return;
        }
        vka.a(pVar, vjZ.vlQ, String.valueOf(vjZ.vlR), feedData);
        AppMethodBeat.o(250965);
    }

    public static void a(y.a aVar) {
        AppMethodBeat.i(250966);
        b bVar = vkb;
        a aVar2 = vka;
        s sVar = vjZ;
        p.h(aVar2, "m21053Reporter");
        p.h(sVar, "config");
        if (aVar == null) {
            AppMethodBeat.o(250966);
        } else if (aVar.feed == null) {
            AppMethodBeat.o(250966);
        } else {
            FeedData feedData = aVar.feed;
            long feedId = feedData != null ? feedData.getFeedId() : 0;
            if (bVar.vjc != feedId) {
                bVar.vjc = feedId;
                if (aVar.vXJ != 9) {
                    FeedData feedData2 = aVar.feed;
                    if (feedData2 == null) {
                        AppMethodBeat.o(250966);
                        return;
                    } else if (feedData2.getLiveStatus() != 1) {
                        AppMethodBeat.o(250966);
                        return;
                    } else {
                        aVar2.a(s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, aVar.vXK, String.valueOf(sVar.vlR), aVar.feed);
                    }
                }
            }
            AppMethodBeat.o(250966);
        }
    }

    public static void a(RecyclerView recyclerView, s.p pVar, String str, c cVar, int i2, int i3) {
        AppMethodBeat.i(250967);
        p.h(pVar, "actionType");
        p.h(str, "commentscene");
        p.h(cVar, "event");
        if (cVar == c.EVENT_ON_RESUME) {
            s sVar = vjZ;
            p.h(str, "<set-?>");
            sVar.vlS = str;
        }
        d dVar = d.uTq;
        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(d.acj());
        d dVar2 = d.uTq;
        com.tencent.mm.plugin.expt.hellhound.core.b.aoV(d.dlA());
        if (i2 != -1 || !vkc.contains(Integer.valueOf(i3))) {
            if (i2 != -100 && i3 != -100) {
                c.sEA = i3;
                if (i2 == 1001) {
                    cVar = c.EVENT_ON_PAUSE;
                } else if (i3 == 1001) {
                    cVar = c.EVENT_ON_RESUME;
                } else {
                    AppMethodBeat.o(250967);
                    return;
                }
            } else if ((cVar == c.EVENT_ON_RESUME || cVar == c.EVENT_ON_PAUSE) && c.sEA != 1001) {
                AppMethodBeat.o(250967);
                return;
            }
            vka.a(recyclerView, pVar, str, cVar);
            AppMethodBeat.o(250967);
            return;
        }
        c.sEA = i3;
        AppMethodBeat.o(250967);
    }

    public final void a(com.tencent.mm.plugin.finder.model.y yVar, String str, long j2, s.p pVar, String str2) {
        long j3;
        long j4;
        String str3;
        AppMethodBeat.i(250968);
        p.h(pVar, "actionType");
        p.h(str2, "commentscene");
        if (yVar == null) {
            if (str == null) {
                str3 = "";
            } else {
                str3 = str;
            }
            b(new p(0, 0, str3, j2, -1, pVar, str2));
            AppMethodBeat.o(250968);
            return;
        }
        long j5 = yVar.uOo.id;
        awe awe = yVar.uOo.liveInfo;
        if (awe != null) {
            j3 = awe.liveId;
        } else {
            j3 = 0;
        }
        String str4 = yVar.uOo.username;
        if (str4 == null) {
            str4 = "";
        }
        awe awe2 = yVar.uOo.liveInfo;
        if (awe2 != null) {
            j4 = (long) awe2.uBn;
        } else {
            j4 = -1;
        }
        b(new p(j5, j3, str4, j2, j4, pVar, str2));
        AppMethodBeat.o(250968);
    }

    public final void a(BaseFinderFeed baseFinderFeed, long j2, s.p pVar, String str) {
        long j3;
        long j4;
        AppMethodBeat.i(250969);
        p.h(baseFinderFeed, "feed");
        p.h(pVar, "actionType");
        p.h(str, "commentscene");
        long lT = baseFinderFeed.lT();
        awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
        if (liveInfo != null) {
            j3 = liveInfo.liveId;
        } else {
            j3 = 0;
        }
        String userName = baseFinderFeed.feedObject.getUserName();
        awe liveInfo2 = baseFinderFeed.feedObject.getLiveInfo();
        if (liveInfo2 != null) {
            j4 = (long) liveInfo2.uBn;
        } else {
            j4 = -1;
        }
        b(new p(lT, j3, userName, j2, j4, pVar, str));
        AppMethodBeat.o(250969);
    }

    public final void a(long j2, long j3, String str, long j4, long j5, s.p pVar, String str2) {
        String str3;
        String str4;
        AppMethodBeat.i(250970);
        p.h(pVar, "actionType");
        p.h(str2, "commentscene");
        if (p.j(str2, s.w.PUBLIC_NUMBER.type)) {
            str3 = s.j.COMMENT_SCENE_PUBLIC_NUMBER.scene;
        } else if (p.j(str2, s.w.SEARCH_1_SEARCH.type)) {
            str3 = s.j.COMMENT_SCENE_SEARCH_1_SEARCH.scene;
        } else if (p.j(str2, s.w.SEE_1_SEE.type)) {
            str3 = s.j.COMMENT_SCENE_SEE_1_SEE.scene;
        } else if (p.j(str2, s.w.GAME_CENTER.type) || !p.j(str2, s.w.LITTLE_APP.type)) {
            str3 = str2;
        } else {
            str3 = s.j.COMMENT_SCENE_APPBRAN.scene;
        }
        if (str == null) {
            str4 = "";
        } else {
            str4 = str;
        }
        b(new p(j2, j3, str4, j4, j5, pVar, str3));
        AppMethodBeat.o(250970);
    }

    public final void a(long j2, long j3, String str, long j4, long j5, s.p pVar, String str2, long j6, long j7, s.av avVar) {
        String str3;
        String str4;
        AppMethodBeat.i(250972);
        p.h(pVar, "actionType");
        p.h(str2, "commentscene");
        p.h(avVar, "enterType");
        if (TextUtils.isEmpty(str2)) {
            com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            p.g(cPO, "HellSessionMonitor.getInstance()");
            String cPQ = cPO.cPQ();
            c.a aVar = c.sFa;
            if (c.a.apK(cPQ)) {
                if (str == null) {
                    str4 = "";
                } else {
                    str4 = str;
                }
                String str5 = s.j.COMMENT_SCENE_SHARE_PAGE.scene;
                c.a aVar2 = c.sFa;
                long apJ = (long) c.a.apJ(cPQ);
                String str6 = c.sEq;
                if (str6 == null) {
                    str6 = "";
                }
                String str7 = c.sEr;
                if (str7 == null) {
                    str7 = "";
                }
                c(new q(j2, j3, str4, 0, j5, pVar, str5, j6, apJ, str6, str7, j7, avVar));
            }
            AppMethodBeat.o(250972);
            return;
        }
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        c(new q(j2, j3, str3, j4, j5, pVar, str2, j6, -1, "", "", j7, avVar));
        AppMethodBeat.o(250972);
    }

    private static void c(q qVar) {
        AppMethodBeat.i(250974);
        dpi();
        vka.a(qVar);
        AppMethodBeat.o(250974);
    }

    private static void r(long j2, String str) {
        AppMethodBeat.i(250975);
        com.tencent.mm.plugin.expt.hellhound.a.aox(str);
        vjZ.auQ(str);
        vjZ.vlw = j2;
        AppMethodBeat.o(250975);
    }

    private static void a(cy cyVar) {
        AppMethodBeat.i(250977);
        cyVar.ob(s.dpt());
        cyVar.oc(vjZ.dpp());
        cyVar.kA(s.dpu());
        cyVar.od(s.dps());
        cyVar.iC(System.currentTimeMillis());
        AppMethodBeat.o(250977);
    }

    private static void a(cn cnVar, long j2) {
        AppMethodBeat.i(250978);
        cnVar.mx(s.dpt());
        cnVar.my(vjZ.dpp());
        cnVar.ke(s.dpu());
        cnVar.mz(s.dps());
        cnVar.gJ(j2);
        AppMethodBeat.o(250978);
    }

    public static void a(cp cpVar, String str) {
        String str2;
        AppMethodBeat.i(250979);
        p.h(cpVar, "struct");
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        cpVar.mQ(str2);
        cpVar.hF((long) s.auU(str));
        cpVar.mS(s.dps());
        cpVar.hz(System.currentTimeMillis());
        AppMethodBeat.o(250979);
    }

    public static void b(s.o oVar) {
        AppMethodBeat.i(250980);
        p.h(oVar, "exitType");
        vjZ.c(oVar);
        AppMethodBeat.o(250980);
    }

    public static s.o dpj() {
        return vjZ.vmb;
    }

    public static void KI(int i2) {
        vjZ.vmd = (long) i2;
    }

    public static void aM(JSONObject jSONObject) {
        vjZ.vme = jSONObject;
    }

    public static void setErrorCode(int i2) {
        vjZ.errCode = i2;
    }

    public static void setDesc(String str) {
        if (str != null) {
            vjZ.desc = str;
        }
    }

    public static void a(s.m mVar) {
        AppMethodBeat.i(250981);
        p.h(mVar, "coverType");
        vjZ.vmf = mVar.type;
        AppMethodBeat.o(250981);
    }

    public static int dpk() {
        return vjZ.vmf;
    }

    public static s dpl() {
        return vjZ;
    }

    public static void a(com.tencent.mm.plugin.finder.live.viewmodel.c cVar, FinderLiveConfig finderLiveConfig) {
        awt awt;
        awt awt2;
        AppMethodBeat.i(250952);
        if (vjZ.vml) {
            AppMethodBeat.o(250952);
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        JSONObject jSONObject = new JSONObject();
        if (cVar == null || cVar.uCs.liveInfo.liveId <= 0) {
            if (finderLiveConfig != null) {
                awt = finderLiveConfig.uiv;
            } else {
                awt = null;
            }
            if (awt == null) {
                g.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.g.sFI;
                int cPm = g.a.cPm();
                if (cPm <= 0) {
                    jSONObject.put("type", s.ae.ORDINARY_LAUNCH_UI.type);
                } else if (currentTimeMillis < cPm) {
                    jSONObject.put("type", s.ae.INNER_NOTICE_TIME_LAUNCH_UI.type);
                } else {
                    jSONObject.put("type", s.ae.ORDINARY_LAUNCH_UI.type);
                }
            } else {
                if (currentTimeMillis < ((finderLiveConfig == null || (awt2 = finderLiveConfig.uiv) == null) ? 0 : awt2.dvv)) {
                    jSONObject.put("type", s.ae.INNER_NOTICE_TIME_LAUNCH_UI.type);
                } else {
                    jSONObject.put("type", s.ae.ORDINARY_LAUNCH_UI.type);
                }
            }
        } else {
            jSONObject.put("type", s.ae.RETURN_LIVE_ROOM.type);
            jSONObject.put("liveid", cVar.uCs.liveInfo.liveId);
        }
        q(s.a.LIVE_ENTER_UI.hlf, jSONObject.toString());
        b(s.o.LIVE_EXIT_NOTHING);
        a(s.m.LIVE_COVER_DEFAULT);
        vjZ.vmc = System.currentTimeMillis();
        AppMethodBeat.o(250952);
    }

    public static void b(q qVar) {
        String str;
        AppMethodBeat.i(250971);
        p.h(qVar, "enterData");
        r(qVar.vln, qVar.vjM);
        vjZ.a(qVar.vjL, "");
        a aVar = vka;
        p.h(qVar, "enterData");
        cp cpVar = new cp();
        k kVar = vkd;
        a(cpVar, qVar.userName);
        cpVar.mR(com.tencent.mm.plugin.expt.hellhound.core.b.zs(qVar.feedId));
        cpVar.hy(qVar.liveId);
        cpVar.mY(com.tencent.mm.plugin.expt.hellhound.core.b.zs(qVar.liveId));
        cpVar.hA(qVar.vjL.dDw);
        cpVar.mT(qVar.vjM);
        cpVar.hB(qVar.vln);
        cpVar.hC(qVar.vlt);
        cpVar.hD(qVar.vlp);
        cpVar.mU(qVar.vlq);
        cpVar.mZ(qVar.vlr);
        cpVar.mV(com.tencent.mm.plugin.expt.hellhound.core.b.cND());
        cpVar.hE(qVar.vlo);
        cpVar.mW(com.tencent.mm.plugin.expt.hellhound.core.b.cNB());
        if (!n.J(qVar.vjM, "temp_", false)) {
            long j2 = qVar.feedId;
            String ach = cpVar.ach();
            p.g(ach, "struct.commentScene");
            cpVar.mX(a.aP(j2, Long.parseLong(ach)));
        } else if (p.j(cpVar.ach(), "temp_2")) {
            k kVar2 = vkd;
            cpVar.mX(vjZ.vlV);
        } else {
            cpVar.mX(qVar.vjM);
        }
        cpVar.hG(qVar.enterTime);
        cpVar.hH((long) qVar.vlu.type);
        if (p.j(cpVar.ach(), "61")) {
            if (TextUtils.isEmpty(c.sEy)) {
                com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                p.g(cPO, "HellSessionMonitor.getInstance()");
                str = cPO.cPR();
            } else {
                str = c.sEy;
            }
            cpVar.na(str);
        }
        cpVar.bfK();
        Log.i(aVar.TAG, "report21053OnClickOnShare, struct=\nfeedId=" + cpVar.acf() + '\n' + "liveId=" + cpVar.adY() + '\n' + "userName=" + cpVar.getUserName() + '\n' + "isPrivate=" + cpVar.aci() + '\n' + "sessionID=" + cpVar.acl() + '\n' + "actionTS=" + cpVar.acs() + '\n' + "action=" + cpVar.act() + '\n' + "commentScene=" + cpVar.ach() + '\n' + "index=" + cpVar.adU() + '\n' + "enterStatus=" + cpVar.acr() + '\n' + "contextId=" + cpVar.acj() + '\n' + "onlineNum=" + cpVar.adX() + '\n' + "clickTabContextId=" + cpVar.ack() + '\n' + "sessionBuffer=" + cpVar.getSessionBuffer() + '\n' + "shareType=" + cpVar.adV() + '\n' + "shareUserName=" + cpVar.adW() + '\n' + "enterSessionId=" + cpVar.aea() + '\n' + "enterIconType=" + cpVar.acv() + '\n' + "snsSessionID=" + cpVar.aeb() + '\n' + "snsFeedId=" + cpVar.adZ());
        AppMethodBeat.o(250971);
    }

    public static void b(p pVar) {
        AppMethodBeat.i(250973);
        r(pVar.vln, pVar.vjM);
        vjZ.a(pVar.vjL, pVar.vjM);
        vka.a(pVar);
        AppMethodBeat.o(250973);
    }

    private static void dpi() {
        AppMethodBeat.i(250976);
        vjZ.vlx = false;
        vjZ.auQ("");
        AppMethodBeat.o(250976);
    }
}
