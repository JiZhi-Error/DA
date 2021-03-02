package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.aw;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.b;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.live.component.j;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.aj;
import com.tencent.mm.plugin.finder.live.plugin.al;
import com.tencent.mm.plugin.finder.live.plugin.ap;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.ay;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.plugin.bh;
import com.tencent.mm.plugin.finder.live.plugin.bj;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.live.plugin.h;
import com.tencent.mm.plugin.finder.live.plugin.k;
import com.tencent.mm.plugin.finder.live.plugin.n;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.plugin.finder.live.plugin.y;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.u;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\"\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002J\u0012\u0010#\u001a\u00020\u00112\b\b\u0002\u0010$\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J@\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020\u0011H\u0002J\b\u00107\u001a\u00020\u0011H\u0002J\b\u00108\u001a\u00020\u0011H\u0002J\b\u00109\u001a\u00020\u0011H\u0002J\b\u0010:\u001a\u00020\u0011H\u0016J\b\u0010;\u001a\u00020\tH\u0016J\"\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020\u0015H\u0016J\u0018\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\tH\u0016J\u001a\u0010D\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u00192\b\u0010F\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u0015H\u0016J,\u0010I\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\b\u0010/\u001a\u0004\u0018\u00010\t2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u00020\u0011H\u0016J\b\u0010M\u001a\u00020\u0011H\u0016J\b\u0010N\u001a\u00020\u0011H\u0002J\b\u0010O\u001a\u00020\u0011H\u0016J\b\u0010P\u001a\u00020\u0011H\u0016J\u001a\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020S2\b\u0010F\u001a\u0004\u0018\u00010 H\u0016J\b\u0010T\u001a\u00020\u0011H\u0016J\b\u0010U\u001a\u00020\u0011H\u0002R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveAnchorSecondaryPluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveBaseAnchorPluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "activate", "", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "isFinished", "", "isFromFloat", "restart", "curIndex", "", "adjustLayout", "adjustLayoutCDN", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "checkFinderObject", "checkMiniWindow", "chooseAudienceMode", "fromMiniWin", "directStartLive", "genLiveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveRole", "getRelativeLayoutId", "handleEnterLive", "handleJoinResp", "success", "errCode", "errType", "errMsg", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "hideBottomAraePlugin", "initPlugins", "joinLive", "miniWindow", "mount", "name", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onLiveEventCallback", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "param", "onRotationSwitchChange", "rotationEnable", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "release", "report", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "stopLiveVideo", "plugin-finder_release"})
public final class c extends e implements i {
    private String TAG = "FinderLiveAnchorSecondaryPluginLayout";
    private HashMap _$_findViewCache;
    private aw liveTXLivePlayerPlygin;

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.plugin.finder.live.view.e
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(247426);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(247426);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.plugin.finder.live.view.e
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(247425);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(247425);
        return view;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.finder.live.view.c$c  reason: collision with other inner class name */
    public static final class C1200c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c uxP;

        C1200c(c cVar) {
            this.uxP = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
            if (r0.liveId == 0) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
            if (com.tencent.mm.plugin.finder.utils.y.gp(r6.errType, r6.errCode) != false) goto L_0x001d;
         */
        @Override // com.tencent.mm.vending.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object call(java.lang.Object r6) {
            /*
            // Method dump skipped, instructions count: 157
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.c.C1200c.call(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorSecondaryPluginLayout$chooseAudienceMode$1$1"})
    public static final class d extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ boolean $fromMiniWin$inlined;
        final /* synthetic */ c uxP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar, boolean z) {
            super(1);
            this.uxP = cVar;
            this.$fromMiniWin$inlined = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(247387);
            if (bool.booleanValue()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", this.$fromMiniWin$inlined);
                this.uxP.statusChange(b.c.hLB, bundle);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247387);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\n¢\u0006\u0002\b\u000f"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "invoke"})
    public static final class f extends q implements u<Boolean, Integer, Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, auf, x> {
        final /* synthetic */ c uxP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(c cVar) {
            super(7);
            this.uxP = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.u
        public final /* synthetic */ x invoke(Boolean bool, Integer num, Integer num2, String str, com.tencent.mm.live.core.core.b.e eVar, TRTCCloudDef.TRTCParams tRTCParams, auf auf) {
            AppMethodBeat.i(247390);
            boolean booleanValue = bool.booleanValue();
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            String str2 = str;
            com.tencent.mm.live.core.core.b.e eVar2 = eVar;
            TRTCCloudDef.TRTCParams tRTCParams2 = tRTCParams;
            auf auf2 = auf;
            p.h(str2, "errMsg");
            p.h(eVar2, "liveRoomInfo");
            p.h(tRTCParams2, "trtcParams");
            p.h(auf2, "resp");
            Log.i(this.uxP.getTAG(), "joinLive success:" + booleanValue + ", errCode:" + intValue + " isDestroyed:" + this.uxP.isDestroyed());
            if (!this.uxP.isDestroyed()) {
                c.a(this.uxP, booleanValue, intValue, intValue2, str2, eVar2, tRTCParams2, auf2);
                this.uxP.getLiveMessageCallback().invoke();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247390);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(MMActivity mMActivity) {
        super(mMActivity);
        p.h(mMActivity, "context");
        AppMethodBeat.i(247422);
        AppMethodBeat.o(247422);
    }

    public static final /* synthetic */ void dir() {
        AppMethodBeat.i(247424);
        report();
        AppMethodBeat.o(247424);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.e
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.e
    public final void setTAG(String str) {
        AppMethodBeat.i(247397);
        p.h(str, "<set-?>");
        this.TAG = str;
        AppMethodBeat.o(247397);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.e
    public final com.tencent.mm.live.core.core.trtc.a dip() {
        AppMethodBeat.i(247398);
        a.C0381a aVar = com.tencent.mm.live.core.core.c.a.hAj;
        getContext();
        com.tencent.mm.live.core.core.c.a aDw = a.C0381a.aDw();
        AppMethodBeat.o(247398);
        return aDw;
    }

    private final void joinLive() {
        Long l;
        long j2 = 0;
        AppMethodBeat.i(247399);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
        getLiveData().EO(asG != null ? asG.field_liveSwitchFlag : 0);
        com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
        if (asG != null) {
            j2 = asG.field_liveAnchorStatusFlag;
        }
        liveData.uDA = (int) j2;
        com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
        com.tencent.mm.plugin.finder.live.model.e.dfy();
        j.a aVar2 = j.UJU;
        j.a.RI(getLiveData().liveInfo.liveId);
        String tag = getTAG();
        StringBuilder append = new StringBuilder("joinLive anchorStatusFlag:").append(getLiveData().uDA).append(" switchFlag:");
        if (asG != null) {
            l = Long.valueOf(asG.field_liveSwitchFlag);
        } else {
            l = null;
        }
        Log.i(tag, append.append(l).append(" giftFuncEnabel:").append(getLiveData().uEJ).append(" linkMicFuncEnabel:").append(getLiveData().uEG).toString());
        s finderLiveAssistant = getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.a(1, new f(this));
            AppMethodBeat.o(247399);
            return;
        }
        AppMethodBeat.o(247399);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorSecondaryPluginLayout$handleJoinResp$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
    public static final class e implements com.tencent.mm.live.core.core.c {
        final /* synthetic */ c uxP;

        e(c cVar) {
            this.uxP = cVar;
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(247389);
            Log.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish");
            if (i2 > 0) {
                ae aeVar = ae.vZW;
                ae.Gn(cl.aWy());
                ac acVar = ac.vYp;
                ad.a aVar = ad.vZu;
                ac.a(acVar, ad.vZc.name, null, false, false, 14);
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.live.view.c.e.AnonymousClass1 */
                    final /* synthetic */ e uxR;

                    {
                        this.uxR = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(247388);
                        com.tencent.mm.plugin.finder.live.model.i iVar = com.tencent.mm.plugin.finder.live.model.i.uja;
                        com.tencent.mm.plugin.finder.live.model.i.b(this.uxR.uxP.getLiveData());
                        com.tencent.mm.plugin.finder.live.model.i iVar2 = com.tencent.mm.plugin.finder.live.model.i.uja;
                        com.tencent.mm.plugin.finder.live.model.i.c(this.uxR.uxP.getLiveData());
                        com.tencent.mm.plugin.finder.live.model.i iVar3 = com.tencent.mm.plugin.finder.live.model.i.uja;
                        com.tencent.mm.plugin.finder.live.model.i.k(this.uxR.uxP.getLiveData());
                        c.a(this.uxR.uxP);
                        this.uxR.uxP.getLiveData().sessionId = SystemClock.elapsedRealtimeNanos();
                        b.C0376b.a(this.uxR.uxP, b.c.hLB);
                        b.C0376b.a(this.uxR.uxP, b.c.hMs);
                        EventCenter.instance.publish(new hi());
                        ac acVar = ac.vYp;
                        ad.a aVar = ad.vZu;
                        ac.a(acVar, ad.vZf.name, null, false, true, 6);
                        ae aeVar = ae.vZW;
                        ae.Gl(cl.aWy());
                        s finderLiveAssistant = this.uxR.uxP.getFinderLiveAssistant();
                        if (finderLiveAssistant != null) {
                            this.uxR.uxP.getLiveData();
                            this.uxR.uxP.getLiveData();
                            this.uxR.uxP.getLiveData();
                            finderLiveAssistant.f(null);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(247388);
                        return xVar;
                    }
                });
                AppMethodBeat.o(247389);
                return;
            }
            ac acVar2 = ac.vYp;
            ad.a aVar2 = ad.vZu;
            ac.a(acVar2, ad.vZb.name, null, false, true, 6);
            Log.w("MicroMsg.LiveCoreAnchor", "enter room fail");
            com.tencent.mm.ui.base.u.makeText(this.uxP.getContext(), "enter room fail", 0).show();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("live_user_exit_reason", i2);
            this.uxP.statusChange(b.c.hMr, bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_IF_CLOSE_LIVE", false);
            this.uxP.statusChange(b.c.hLV, bundle3);
            ae aeVar2 = ae.vZW;
            ae.a(ae.dEe(), i2, 0, String.valueOf(bundle), this.uxP.getLiveData());
            AppMethodBeat.o(247389);
        }
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(247401);
        cVar.chooseAudienceMode(false);
        AppMethodBeat.o(247401);
    }

    private final void chooseAudienceMode(boolean z) {
        TXLivePlayer tXLivePlayer;
        TXCloudVideoView tXCloudVideoView = null;
        AppMethodBeat.i(247400);
        if (!z) {
            View rootView = getRootView();
            p.g(rootView, "rootView");
            Context context = rootView.getContext();
            Context context2 = getContext();
            p.g(context2, "context");
            com.tencent.mm.ui.base.u.makeText(context, context2.getResources().getString(R.string.cz0), 0).show();
        }
        int djc = getLiveData().djc();
        e.a aVar = e.a.hxc;
        if (djc == e.a.aCf()) {
            Log.i(getTAG(), "chooseAudienceMode CDN fromMiniWin:" + z + ", liveRoomModel:" + getLiveData().hIy);
            com.tencent.mm.live.core.core.b.f fVar = getLiveData().hIy;
            if (fVar != null) {
                com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
                if (liveCore != null) {
                    liveCore.a(fVar);
                }
                com.tencent.mm.live.core.core.d dVar = com.tencent.mm.live.core.core.d.hwY;
                com.tencent.mm.live.core.core.d.a(fVar.hwP);
                aw awVar = this.liveTXLivePlayerPlygin;
                if (awVar != null) {
                    awVar.ev(false);
                }
                af afVar = af.waa;
                StringBuilder sb = new StringBuilder();
                af afVar2 = af.waa;
                String sb2 = sb.append(af.dEm()).append(getData().uCr.getLiveId()).toString();
                ad.a aVar2 = ad.vZu;
                af.a(afVar, sb2, ad.vYQ.name, null, false, false, 28);
                aw awVar2 = this.liveTXLivePlayerPlygin;
                if (awVar2 != null) {
                    m mVar = m.vVH;
                    TXLivePlayConfig dBO = m.dBO();
                    m mVar2 = m.vVH;
                    aw.a(awVar2, 0, dBO, m.a(getLiveData(), isLandscape()), new d(this, z), 1);
                }
                aw awVar3 = this.liveTXLivePlayerPlygin;
                if (awVar3 != null) {
                    awVar3.rg(0);
                }
                com.tencent.mm.live.core.core.trtc.a liveCore2 = getLiveCore();
                if (!(liveCore2 instanceof com.tencent.mm.live.core.core.c.a)) {
                    liveCore2 = null;
                }
                com.tencent.mm.live.core.core.c.a aVar3 = (com.tencent.mm.live.core.core.c.a) liveCore2;
                if (aVar3 != null) {
                    long j2 = getLiveData().liveInfo.liveId;
                    aw awVar4 = this.liveTXLivePlayerPlygin;
                    if (awVar4 != null) {
                        tXLivePlayer = awVar4.hwO;
                    } else {
                        tXLivePlayer = null;
                    }
                    aw awVar5 = this.liveTXLivePlayerPlygin;
                    if (awVar5 != null) {
                        tXCloudVideoView = awVar5.aHJ();
                    }
                    aVar3.a(j2, tXLivePlayer, tXCloudVideoView);
                    AppMethodBeat.o(247400);
                    return;
                }
                AppMethodBeat.o(247400);
                return;
            }
        }
        AppMethodBeat.o(247400);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final int getRelativeLayoutId() {
        return R.layout.ad1;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void activate(com.tencent.mm.plugin.finder.live.viewmodel.c cVar, boolean z, boolean z2, boolean z3, int i2) {
        FinderObject finderObject;
        AppMethodBeat.i(260794);
        p.h(cVar, "data");
        super.activate(cVar, z, z2, z3, i2);
        com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        liveData.atT(aUg);
        Log.i(getTAG(), "liveFinish:" + getLiveData().uDN + ",isFromFloat:" + z2 + ", restart:" + z3 + ",liveId:" + getLiveData().liveInfo.liveId + ",objectId:" + getLiveData().hFK + ",nonceId:" + getLiveData().hwg + ",username:" + getLiveData().hwd);
        fillBlurBg(getLiveData().hwd);
        View findViewById = findViewById(R.id.emp);
        p.g(findViewById, "findViewById(R.id.live_tx_live_player_ui_root)");
        this.liveTXLivePlayerPlygin = new aw((ViewGroup) findViewById, this);
        aw awVar = this.liveTXLivePlayerPlygin;
        if (awVar != null) {
            com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
            if (liveCore == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.secdevice.LiveSecondaryDeviceTRTCCore");
                AppMethodBeat.o(260794);
                throw tVar;
            }
            com.tencent.mm.live.core.core.c.a aVar = (com.tencent.mm.live.core.core.c.a) liveCore;
            p.h(aVar, "core");
            awVar.liveCore = aVar;
        }
        View findViewById2 = findViewById(R.id.elk);
        p.g(findViewById2, "findViewById(R.id.live_shadow_ui_root)");
        setShadowPlugin(new as((ViewGroup) findViewById2, this));
        View findViewById3 = findViewById(R.id.cu8);
        p.g(findViewById3, "findViewById(R.id.finder_live_lottery_bubble_root)");
        setLotteryBubblePlugin(new al((ViewGroup) findViewById3, this));
        View findViewById4 = findViewById(R.id.emn);
        p.g(findViewById4, "findViewById(R.id.live_title_ui_root)");
        setTitleInfoPlugin(new bh((ViewGroup) findViewById4, this));
        View findViewById5 = findViewById(R.id.egr);
        p.g(findViewById5, "findViewById(R.id.live_common_info_ui_root)");
        setCommonInfoPlugin(new y((ViewGroup) findViewById5, this));
        View findViewById6 = findViewById(R.id.cx9);
        p.g(findViewById6, "findViewById(R.id.finder_live_ready_ui_root)");
        setReadyPlugin(new ay((ViewGroup) findViewById6, this));
        View findViewById7 = findViewById(R.id.cps);
        p.g(findViewById7, "findViewById(R.id.finder_live_comment_ui_root)");
        setCommentPlugin(new v((ViewGroup) findViewById7, this));
        View findViewById8 = findViewById(R.id.ef1);
        p.g(findViewById8, "findViewById(R.id.live_anchor_close_ui_root)");
        setClosePlugin(new com.tencent.mm.plugin.finder.live.plugin.l((ViewGroup) findViewById8, this));
        com.tencent.mm.plugin.finder.live.plugin.l closePlugin = getClosePlugin();
        if (closePlugin != null) {
            m mVar = m.vVH;
            closePlugin.umP = m.i(getLiveData());
        }
        View findViewById9 = findViewById(R.id.cms);
        p.g(findViewById9, "findViewById(R.id.finder…ive_anchor_after_ui_root)");
        setFinderLiveAfterPlugin(new com.tencent.mm.plugin.finder.live.plugin.e((ViewGroup) findViewById9, this));
        View findViewById10 = findViewById(R.id.eiz);
        p.g(findViewById10, "findViewById(R.id.live_members_list_ui_root)");
        setMemberListPlugin(new ap((ViewGroup) findViewById10, this));
        View findViewById11 = findViewById(R.id.cva);
        p.g(findViewById11, "findViewById(R.id.finder…_members_profile_ui_root)");
        setProfilePlugin(new cc((ViewGroup) findViewById11, this, getContextObj()));
        View findViewById12 = findViewById(R.id.ehv);
        p.g(findViewById12, "findViewById(R.id.live_like_confetti_ui_root)");
        setConfettiPlugin(new aj((ViewGroup) findViewById12, this));
        View findViewById13 = findViewById(R.id.cvz);
        p.g(findViewById13, "findViewById(R.id.finder_live_more_action_ui_root)");
        ViewGroup viewGroup = (ViewGroup) findViewById13;
        c cVar2 = this;
        Context context = getContext();
        if (context == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(260794);
            throw tVar2;
        }
        setMoreActionPlugin(new at(viewGroup, cVar2, (MMActivity) context));
        View findViewById14 = findViewById(R.id.cmw);
        p.g(findViewById14, "findViewById(R.id.finder…nchor_camera_opt_ui_root)");
        setCameraOptPlugin(new k((ViewGroup) findViewById14, this));
        View findViewById15 = findViewById(R.id.cpz);
        p.g(findViewById15, "findViewById(R.id.finder_live_exception)");
        setExceptionPlugin(new n((ViewGroup) findViewById15, this));
        View findViewById16 = findViewById(R.id.cyi);
        p.g(findViewById16, "findViewById(R.id.finder_live_top_comment_ui_root)");
        setTopCommentPlugin(new bj((ViewGroup) findViewById16, this));
        View findViewById17 = findViewById(R.id.cu8);
        p.g(findViewById17, "findViewById(R.id.finder_live_lottery_bubble_root)");
        setLotteryBubblePlugin(new al((ViewGroup) findViewById17, this));
        View findViewById18 = findViewById(R.id.cu9);
        p.g(findViewById18, "findViewById(R.id.finder_live_lottery_card_root)");
        setLotteryCardPlugin(new com.tencent.mm.plugin.finder.live.plugin.q((ViewGroup) findViewById18, this));
        View findViewById19 = findViewById(R.id.cqt);
        p.g(findViewById19, "findViewById(R.id.finder_live_gift_play_ui_root)");
        setGiftPlayPlugin(new com.tencent.mm.plugin.finder.live.plugin.ac((ViewGroup) findViewById19, this));
        View findViewById20 = findViewById(R.id.cr1);
        p.g(findViewById20, "findViewById(R.id.finder_live_gift_queue_ui_root)");
        View findViewById21 = findViewById(R.id.jx4);
        p.g(findViewById21, "findViewById(R.id.finder…e_gift_queue_outer_space)");
        setGiftQueuePlugin(new com.tencent.mm.plugin.finder.live.plugin.ae((ViewGroup) findViewById20, this, getLiveData().uDw, (ViewGroup) findViewById21));
        View findViewById22 = findViewById(R.id.cmu);
        p.g(findViewById22, "findViewById(R.id.finder…or_bottom_option_ui_root)");
        setBottomOptionPlugin(new h((ViewGroup) findViewById22, this));
        hTJ();
        hideLoadingLayer();
        as shadowPlugin = getShadowPlugin();
        if (shadowPlugin != null) {
            shadowPlugin.rg(8);
        }
        bh titleInfoPlugin = getTitleInfoPlugin();
        if (titleInfoPlugin != null) {
            titleInfoPlugin.rg(8);
        }
        y commonInfoPlugin = getCommonInfoPlugin();
        if (commonInfoPlugin != null) {
            commonInfoPlugin.rg(8);
        }
        ay readyPlugin = getReadyPlugin();
        if (readyPlugin != null) {
            readyPlugin.rg(8);
        }
        v commentPlugin = getCommentPlugin();
        if (commentPlugin != null) {
            commentPlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.l closePlugin2 = getClosePlugin();
        if (closePlugin2 != null) {
            closePlugin2.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.e finderLiveAfterPlugin = getFinderLiveAfterPlugin();
        if (finderLiveAfterPlugin != null) {
            finderLiveAfterPlugin.rg(8);
        }
        ap memberListPlugin = getMemberListPlugin();
        if (memberListPlugin != null) {
            memberListPlugin.rg(8);
        }
        cc profilePlugin = getProfilePlugin();
        if (profilePlugin != null) {
            profilePlugin.rg(8);
        }
        aj confettiPlugin = getConfettiPlugin();
        if (confettiPlugin != null) {
            confettiPlugin.rg(8);
        }
        at moreActionPlugin = getMoreActionPlugin();
        if (moreActionPlugin != null) {
            moreActionPlugin.rg(8);
        }
        k cameraOptPlugin = getCameraOptPlugin();
        if (cameraOptPlugin != null) {
            cameraOptPlugin.rg(8);
        }
        bd shoppingBubblePlugin = getShoppingBubblePlugin();
        if (shoppingBubblePlugin != null) {
            shoppingBubblePlugin.rg(8);
        }
        bf shoppingListPlugin = getShoppingListPlugin();
        if (shoppingListPlugin != null) {
            shoppingListPlugin.rg(8);
        }
        n exceptionPlugin = getExceptionPlugin();
        if (exceptionPlugin != null) {
            exceptionPlugin.rg(8);
        }
        al lotteryBubblePlugin = getLotteryBubblePlugin();
        if (lotteryBubblePlugin != null) {
            lotteryBubblePlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.q lotteryCardPlugin = getLotteryCardPlugin();
        if (lotteryCardPlugin != null) {
            lotteryCardPlugin.rg(8);
        }
        h bottomOptionPlugin = getBottomOptionPlugin();
        if (bottomOptionPlugin != null) {
            bottomOptionPlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.ac giftPlayPlugin = getGiftPlayPlugin();
        if (giftPlayPlugin != null) {
            giftPlayPlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.ae giftQueuePlugin = getGiftQueuePlugin();
        if (giftQueuePlugin != null) {
            giftQueuePlugin.rg(8);
        }
        aj confettiPlugin2 = getConfettiPlugin();
        if (confettiPlugin2 != null) {
            confettiPlugin2.a(getData().uCr);
        }
        y commonInfoPlugin2 = getCommonInfoPlugin();
        if (commonInfoPlugin2 != null) {
            getData();
            commonInfoPlugin2.aHy();
        }
        showProgressWithBlurBg(getLiveData().hwd);
        if (getLiveData().liveInfo.liveId == 0) {
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vmk = false;
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vml = false;
            b.C0376b.a(this, b.c.hLy);
        } else if (!z2) {
            if (getLiveData().uDz == null || ((finderObject = getLiveData().uDz) != null && finderObject.id == 0)) {
                getLiveData().uDz = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().Fy(getLiveData().hFK).getFinderObject();
            }
            getLiveData().uEj = true;
            joinLive();
        } else if (getLiveData().uDN) {
            b.C0376b.a(this, b.c.hLV);
        } else {
            hideLoadingLayer();
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", true);
            statusChange(b.c.hLB, bundle);
            chooseAudienceMode(true);
            b.C0376b.a(this, b.c.hMs);
        }
        com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
        com.tencent.mm.plugin.finder.live.model.q.j(name(), new a(this));
        AppMethodBeat.o(260794);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onCallStateChanged(int i2, String str) {
        com.tencent.mm.live.core.core.b.g gVar;
        AppMethodBeat.i(247403);
        p.h(str, "incomingNumber");
        String tag = getTAG();
        StringBuilder append = new StringBuilder("onCallStateChanged state:").append(i2).append(", isFloatMode:");
        com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
        Log.i(tag, append.append(((liveCore == null || (gVar = liveCore.hAz) == null) ? null : Boolean.valueOf(gVar.isFloatMode())).booleanValue()).toString());
        switch (i2) {
            case 1:
                AppMethodBeat.o(247403);
                return;
            case 2:
                setManualClosed(true);
                b.C0376b.a(this, b.c.hLC);
                break;
        }
        AppMethodBeat.o(247403);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onRotationSwitchChange(boolean z) {
    }

    @Override // com.tencent.mm.live.view.a
    public final String name() {
        AppMethodBeat.i(247404);
        String simpleName = a.class.getSimpleName();
        p.g(simpleName, "FinderLiveAnchorPluginLa…ut::class.java.simpleName");
        AppMethodBeat.o(247404);
        return simpleName;
    }

    @Override // com.tencent.mm.live.c.b
    public final int getLiveRole() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void resume() {
        AppMethodBeat.i(247405);
        super.resume();
        if (!getLiveCore().hAz.hzz) {
            getLiveCore().aBU();
            AppMethodBeat.o(247405);
            return;
        }
        getLiveCore().hAz.hzz = false;
        AppMethodBeat.o(247405);
    }

    private final void stopLiveVideo() {
        AppMethodBeat.i(247406);
        Log.i(getTAG(), "stopLiveVideo,float mode:" + getLiveCore().hAz.isFloatMode() + ", normal mode:" + getLiveCore().hAz.isNormalMode() + ",manual closed:" + isManualClosed() + ", needMiniWindow:" + getLiveData().uDS + ", start:" + isLiveStarted() + ",finish:" + isLiveFinished());
        if (isManualClosed() || !isLiveStarted() || isLiveFinished()) {
            if (getLiveCore().hAz.isNormalMode()) {
                com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
                if (!(liveCore instanceof com.tencent.mm.live.core.core.c.a)) {
                    liveCore = null;
                }
                com.tencent.mm.live.core.core.c.a aVar = (com.tencent.mm.live.core.core.c.a) liveCore;
                if (aVar != null) {
                    aVar.aEa();
                    AppMethodBeat.o(247406);
                    return;
                }
            }
        } else if (getLiveCore().hAz.isNormalMode() && needMiniWindow() && !com.tencent.mm.ac.d.cW(getLiveData().uEf, 2048)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", needRemoveActivity());
            bundle.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", isSwipeBack() ? 1 : 3);
            bundle.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
            if (!com.tencent.mm.compatible.e.b.cx(getContext())) {
                Log.e(getTAG(), "showVideoTalking, permission denied");
                setMiniWinPermission(true);
                b.C0376b.a(this, b.c.hLS);
                RequestFloatWindowPermissionDialog.a(getContext(), getContext().getString(R.string.ej9), new g(this), false, com.tencent.mm.bq.a.apJ());
                AppMethodBeat.o(247406);
                return;
            }
            setMiniWinPermission(false);
            statusChange(b.c.hLQ, bundle);
            report();
            AppMethodBeat.o(247406);
            return;
        }
        AppMethodBeat.o(247406);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorSecondaryPluginLayout$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder_release"})
    public static final class g implements RequestFloatWindowPermissionDialog.a {
        final /* synthetic */ c uxP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(c cVar) {
            this.uxP = cVar;
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            int i2 = 1;
            AppMethodBeat.i(247391);
            p.h(requestFloatWindowPermissionDialog, "dialog");
            this.uxP.setMiniWinPermission(false);
            requestFloatWindowPermissionDialog.finish();
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true);
            if (!this.uxP.isSwipeBack()) {
                i2 = 3;
            }
            bundle.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", i2);
            bundle.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
            this.uxP.statusChange(b.c.hLQ, bundle);
            c.dir();
            AppMethodBeat.o(247391);
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(247392);
            p.h(requestFloatWindowPermissionDialog, "dialog");
            this.uxP.setMiniWinPermission(false);
            requestFloatWindowPermissionDialog.finish();
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_LIVE_MINI_WINDOW_AUTO", true);
            this.uxP.statusChange(b.c.hLT, bundle);
            AppMethodBeat.o(247392);
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(247393);
            p.h(requestFloatWindowPermissionDialog, "dialog");
            this.uxP.setMiniWinPermission(false);
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_LIVE_MINI_WINDOW_AUTO", true);
            this.uxP.statusChange(b.c.hLU, bundle);
            AppMethodBeat.o(247393);
        }
    }

    private static void report() {
        String valueOf;
        AppMethodBeat.i(247407);
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmo) {
            valueOf = String.valueOf(s.r.LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP.type);
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vmo = false;
        } else if (com.tencent.mm.plugin.expt.hellhound.a.syQ) {
            valueOf = String.valueOf(s.r.LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG.type);
        } else {
            valueOf = String.valueOf(s.r.LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE.type);
        }
        com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_MINIMIZE, valueOf);
        AppMethodBeat.o(247407);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void pause() {
        AppMethodBeat.i(247408);
        super.pause();
        AppMethodBeat.o(247408);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void stop() {
        AppMethodBeat.i(247409);
        super.stop();
        checkMiniWindow();
        AppMethodBeat.o(247409);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void start() {
        AppMethodBeat.i(247410);
        super.start();
        startTimer();
        AppMethodBeat.o(247410);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void mount() {
        AppMethodBeat.i(247411);
        super.mount();
        com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.d(name(), getLiveMessageCallback());
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3582, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().a(3917, this);
        com.tencent.mm.kernel.b aAg3 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg3, "MMKernel.network()");
        aAg3.azz().a(3861, this);
        com.tencent.mm.kernel.b aAg4 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg4, "MMKernel.network()");
        aAg4.azz().a(3603, this);
        AppMethodBeat.o(247411);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(247412);
        boolean onBackPress = super.onBackPress();
        if (!onBackPress) {
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_OUT.hlf, "");
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(com.tencent.mm.plugin.finder.report.live.k.dpj());
        }
        AppMethodBeat.o(247412);
        return onBackPress;
    }

    private final void checkMiniWindow() {
        AppMethodBeat.i(247413);
        Log.i(getTAG(), "checkMiniWindow:" + getCheckMiniWin());
        if (!getCheckMiniWin()) {
            stopLiveVideo();
            this.timerThread.stopTimer();
            setCheckMiniWin(true);
        }
        AppMethodBeat.o(247413);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void applyState(int i2, int i3, Bundle bundle) {
        ViewGroup viewGroup;
        AppMethodBeat.i(247414);
        if (getLiveData().djl()) {
            hideLoadingLayer();
            as shadowPlugin = getShadowPlugin();
            if (shadowPlugin != null) {
                shadowPlugin.rg(8);
            }
            bh titleInfoPlugin = getTitleInfoPlugin();
            if (titleInfoPlugin != null) {
                titleInfoPlugin.rg(8);
            }
            y commonInfoPlugin = getCommonInfoPlugin();
            if (commonInfoPlugin != null) {
                commonInfoPlugin.rg(8);
            }
            v commentPlugin = getCommentPlugin();
            if (commentPlugin != null) {
                commentPlugin.rg(8);
            }
            ay readyPlugin = getReadyPlugin();
            if (readyPlugin != null) {
                readyPlugin.rg(8);
            }
            aj confettiPlugin = getConfettiPlugin();
            if (confettiPlugin != null) {
                confettiPlugin.rg(8);
            }
            at moreActionPlugin = getMoreActionPlugin();
            if (moreActionPlugin != null) {
                moreActionPlugin.rg(8);
            }
            k cameraOptPlugin = getCameraOptPlugin();
            if (cameraOptPlugin != null) {
                cameraOptPlugin.rg(8);
            }
            bd shoppingBubblePlugin = getShoppingBubblePlugin();
            if (shoppingBubblePlugin != null) {
                shoppingBubblePlugin.rg(8);
            }
            bf shoppingListPlugin = getShoppingListPlugin();
            if (shoppingListPlugin != null) {
                shoppingListPlugin.rg(8);
            }
            n exceptionPlugin = getExceptionPlugin();
            if (exceptionPlugin != null) {
                exceptionPlugin.rg(8);
            }
            cc profilePlugin = getProfilePlugin();
            if (profilePlugin != null) {
                profilePlugin.rg(8);
            }
            bj topCommentPlugin = getTopCommentPlugin();
            if (topCommentPlugin != null) {
                topCommentPlugin.rg(8);
            }
            al lotteryBubblePlugin = getLotteryBubblePlugin();
            if (lotteryBubblePlugin != null) {
                lotteryBubblePlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.q lotteryCardPlugin = getLotteryCardPlugin();
            if (lotteryCardPlugin != null) {
                lotteryCardPlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.ac giftPlayPlugin = getGiftPlayPlugin();
            if (giftPlayPlugin != null) {
                giftPlayPlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.ae giftQueuePlugin = getGiftQueuePlugin();
            if (giftQueuePlugin != null) {
                giftQueuePlugin.rg(8);
            }
            h bottomOptionPlugin = getBottomOptionPlugin();
            if (bottomOptionPlugin != null) {
                bottomOptionPlugin.rg(8);
                AppMethodBeat.o(247414);
                return;
            }
            AppMethodBeat.o(247414);
        } else if (getLiveData().isLiveStarted()) {
            bh titleInfoPlugin2 = getTitleInfoPlugin();
            if (titleInfoPlugin2 != null) {
                bh.a(titleInfoPlugin2);
            }
            if (!getLiveData().hTY()) {
                hideLoadingLayer();
            }
            as shadowPlugin2 = getShadowPlugin();
            if (shadowPlugin2 != null) {
                shadowPlugin2.rg(0);
            }
            bh titleInfoPlugin3 = getTitleInfoPlugin();
            if (titleInfoPlugin3 != null) {
                titleInfoPlugin3.rg(0);
            }
            y commonInfoPlugin2 = getCommonInfoPlugin();
            if (commonInfoPlugin2 != null) {
                commonInfoPlugin2.rg(0);
            }
            v commentPlugin2 = getCommentPlugin();
            if (commentPlugin2 != null) {
                commentPlugin2.rg(0);
            }
            at moreActionPlugin2 = getMoreActionPlugin();
            if (moreActionPlugin2 != null) {
                moreActionPlugin2.rg(0);
            }
            k cameraOptPlugin2 = getCameraOptPlugin();
            if (cameraOptPlugin2 != null) {
                cameraOptPlugin2.rg(0);
            }
            ay readyPlugin2 = getReadyPlugin();
            if (readyPlugin2 != null) {
                readyPlugin2.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.e finderLiveAfterPlugin = getFinderLiveAfterPlugin();
            if (finderLiveAfterPlugin != null) {
                finderLiveAfterPlugin.rg(8);
            }
            n exceptionPlugin2 = getExceptionPlugin();
            if (exceptionPlugin2 != null) {
                exceptionPlugin2.rg(8);
            }
            aj confettiPlugin2 = getConfettiPlugin();
            if (confettiPlugin2 != null) {
                confettiPlugin2.rg(0);
            }
            if (getLiveData().uit) {
                bd shoppingBubblePlugin2 = getShoppingBubblePlugin();
                if (shoppingBubblePlugin2 != null) {
                    shoppingBubblePlugin2.rg(0);
                }
            } else {
                bd shoppingBubblePlugin3 = getShoppingBubblePlugin();
                if (shoppingBubblePlugin3 != null) {
                    shoppingBubblePlugin3.rg(8);
                }
            }
            y commonInfoPlugin3 = getCommonInfoPlugin();
            if (!(commonInfoPlugin3 == null || (viewGroup = commonInfoPlugin3.hwr) == null)) {
                viewGroup.post(new b(this));
            }
            h bottomOptionPlugin2 = getBottomOptionPlugin();
            if (bottomOptionPlugin2 != null) {
                bottomOptionPlugin2.dgN();
            }
            if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 32)) {
                String str = getLiveData().hwd;
                Context context = getContext();
                p.g(context, "context");
                String string = context.getResources().getString(R.string.cuk);
                p.g(string, "context.resources.getStr…ng_exception_tip_network)");
                showTipWithBlurBg(str, string);
                k cameraOptPlugin3 = getCameraOptPlugin();
                if (cameraOptPlugin3 != null) {
                    cameraOptPlugin3.rg(8);
                }
                bf shoppingListPlugin2 = getShoppingListPlugin();
                if (shoppingListPlugin2 != null) {
                    shoppingListPlugin2.rg(8);
                }
                bd shoppingBubblePlugin4 = getShoppingBubblePlugin();
                if (shoppingBubblePlugin4 != null) {
                    shoppingBubblePlugin4.rg(8);
                }
                aj confettiPlugin3 = getConfettiPlugin();
                if (confettiPlugin3 != null) {
                    confettiPlugin3.rg(8);
                }
                v commentPlugin3 = getCommentPlugin();
                if (commentPlugin3 != null) {
                    commentPlugin3.rg(8);
                }
                cc profilePlugin2 = getProfilePlugin();
                if (profilePlugin2 != null) {
                    profilePlugin2.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.q lotteryCardPlugin2 = getLotteryCardPlugin();
                if (lotteryCardPlugin2 != null) {
                    lotteryCardPlugin2.rg(8);
                }
                h bottomOptionPlugin3 = getBottomOptionPlugin();
                if (bottomOptionPlugin3 != null) {
                    bottomOptionPlugin3.rg(8);
                    AppMethodBeat.o(247414);
                    return;
                }
                AppMethodBeat.o(247414);
            } else if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 2)) {
                at moreActionPlugin3 = getMoreActionPlugin();
                if (moreActionPlugin3 != null) {
                    moreActionPlugin3.dhD();
                    AppMethodBeat.o(247414);
                    return;
                }
                AppMethodBeat.o(247414);
            } else if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 4)) {
                bf shoppingListPlugin3 = getShoppingListPlugin();
                if (shoppingListPlugin3 != null) {
                    bf.a(shoppingListPlugin3, bundle);
                    AppMethodBeat.o(247414);
                    return;
                }
                AppMethodBeat.o(247414);
            } else {
                super.applyState(i2, i3, bundle);
                AppMethodBeat.o(247414);
            }
        } else {
            if (getLiveData().djk()) {
                hideLoadingLayer();
                as shadowPlugin3 = getShadowPlugin();
                if (shadowPlugin3 != null) {
                    shadowPlugin3.rg(8);
                }
                bh titleInfoPlugin4 = getTitleInfoPlugin();
                if (titleInfoPlugin4 != null) {
                    titleInfoPlugin4.rg(8);
                }
                y commonInfoPlugin4 = getCommonInfoPlugin();
                if (commonInfoPlugin4 != null) {
                    commonInfoPlugin4.rg(8);
                }
                v commentPlugin4 = getCommentPlugin();
                if (commentPlugin4 != null) {
                    commentPlugin4.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.l closePlugin = getClosePlugin();
                if (closePlugin != null) {
                    closePlugin.rg(8);
                }
                ay readyPlugin3 = getReadyPlugin();
                if (readyPlugin3 != null) {
                    readyPlugin3.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.e finderLiveAfterPlugin2 = getFinderLiveAfterPlugin();
                if (finderLiveAfterPlugin2 != null) {
                    finderLiveAfterPlugin2.rg(8);
                }
                ap memberListPlugin = getMemberListPlugin();
                if (memberListPlugin != null) {
                    memberListPlugin.rg(8);
                }
                cc profilePlugin3 = getProfilePlugin();
                if (profilePlugin3 != null) {
                    profilePlugin3.rg(8);
                }
                bd shoppingBubblePlugin5 = getShoppingBubblePlugin();
                if (shoppingBubblePlugin5 != null) {
                    shoppingBubblePlugin5.rg(8);
                }
                bf shoppingListPlugin4 = getShoppingListPlugin();
                if (shoppingListPlugin4 != null) {
                    shoppingListPlugin4.rg(8);
                }
                n exceptionPlugin3 = getExceptionPlugin();
                if (exceptionPlugin3 != null) {
                    exceptionPlugin3.rg(8);
                }
                aj confettiPlugin4 = getConfettiPlugin();
                if (confettiPlugin4 != null) {
                    confettiPlugin4.rg(8);
                }
                at moreActionPlugin4 = getMoreActionPlugin();
                if (moreActionPlugin4 != null) {
                    moreActionPlugin4.rg(8);
                }
                k cameraOptPlugin4 = getCameraOptPlugin();
                if (cameraOptPlugin4 != null) {
                    cameraOptPlugin4.rg(8);
                }
                bj topCommentPlugin2 = getTopCommentPlugin();
                if (topCommentPlugin2 != null) {
                    topCommentPlugin2.rg(8);
                }
                al lotteryBubblePlugin2 = getLotteryBubblePlugin();
                if (lotteryBubblePlugin2 != null) {
                    lotteryBubblePlugin2.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.q lotteryCardPlugin3 = getLotteryCardPlugin();
                if (lotteryCardPlugin3 != null) {
                    lotteryCardPlugin3.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.ac giftPlayPlugin2 = getGiftPlayPlugin();
                if (giftPlayPlugin2 != null) {
                    giftPlayPlugin2.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.ae giftQueuePlugin2 = getGiftQueuePlugin();
                if (giftQueuePlugin2 != null) {
                    giftQueuePlugin2.rg(8);
                }
                h bottomOptionPlugin4 = getBottomOptionPlugin();
                if (bottomOptionPlugin4 != null) {
                    bottomOptionPlugin4.rg(8);
                }
                if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 4)) {
                    bf shoppingListPlugin5 = getShoppingListPlugin();
                    if (shoppingListPlugin5 != null) {
                        bf.a(shoppingListPlugin5, bundle);
                        AppMethodBeat.o(247414);
                        return;
                    }
                    AppMethodBeat.o(247414);
                    return;
                }
                super.applyState(i2, i3, bundle);
            }
            AppMethodBeat.o(247414);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ c uxP;

        b(c cVar) {
            this.uxP = cVar;
        }

        public final void run() {
            ViewGroup viewGroup;
            AppMethodBeat.i(247385);
            y commonInfoPlugin = this.uxP.getCommonInfoPlugin();
            if (commonInfoPlugin == null || (viewGroup = commonInfoPlugin.hwr) == null) {
                AppMethodBeat.o(247385);
                return;
            }
            bj topCommentPlugin = this.uxP.getTopCommentPlugin();
            if (topCommentPlugin != null) {
                topCommentPlugin.dY(viewGroup);
                AppMethodBeat.o(247385);
                return;
            }
            AppMethodBeat.o(247385);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.plugin.finder.live.view.e, com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.c.b
    public final void statusChange(b.c cVar, Bundle bundle) {
        int i2;
        int i3;
        TXLivePlayer tXLivePlayer;
        byte[] byteArray;
        com.tencent.mm.live.core.core.b.g gVar;
        Long l;
        FinderObject finderObject;
        AppMethodBeat.i(247415);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (d.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                AppMethodBeat.o(247415);
                return;
            case 2:
                Boolean valueOf = bundle != null ? Boolean.valueOf(bundle.getBoolean("PARAM_FINDER_LIVE_POST_AFTER_FACE_VERIFY", false)) : null;
                Log.i(getTAG(), "createLive afterFaceVerify:".concat(String.valueOf(valueOf)));
                if (p.j(valueOf, Boolean.TRUE)) {
                    dis();
                    AppMethodBeat.o(247415);
                    return;
                }
                byte[] byteArray2 = bundle != null ? bundle.getByteArray("PARAM_KEY_POST_OBJECT_DESC") : null;
                if (byteArray2 != null) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
                    FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
                    finderObjectDesc.parseFrom(byteArray2);
                    liveData.uDm = finderObjectDesc;
                    ac acVar = ac.vYp;
                    ad.a aVar = ad.vZu;
                    ac.a(acVar, ad.vYU.name, null, true, false, 10);
                    ac acVar2 = ac.vYp;
                    ad.a aVar2 = ad.vZu;
                    ac.a(acVar2, ad.vYV.name, null, false, false, 14);
                    ae aeVar = ae.vZW;
                    ae.Gk(cl.aWy());
                    dis();
                    AppMethodBeat.o(247415);
                    return;
                }
                AppMethodBeat.o(247415);
                return;
            case 3:
                joinLive();
                AppMethodBeat.o(247415);
                return;
            case 4:
                Log.i(getTAG(), "start live failed");
                if (!getLiveData().djl()) {
                    ay readyPlugin = getReadyPlugin();
                    if (readyPlugin != null) {
                        readyPlugin.rg(8);
                    }
                    String str = getLiveData().hwd;
                    Context context = getContext();
                    p.g(context, "context");
                    String string = context.getResources().getString(R.string.egq);
                    p.g(string, "context.resources.getStr…_local_network_error_tip)");
                    showTipWithBlurBg(str, string);
                }
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_BTN_CLICK.hlf, String.valueOf(s.ap.LIVE_START_NETWORK_ERROR.type));
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.setErrorCode(bundle != null ? bundle.getInt("live_user_exit_reason", 0) : 0);
                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.b(s.o.LIVE_EXIT_ERROR);
                AppMethodBeat.o(247415);
                return;
            case 5:
                Log.i(getTAG(), "start live success");
                com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                if (!com.tencent.mm.plugin.finder.report.live.k.dpl().vml) {
                    com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_BTN_CLICK.hlf, String.valueOf(s.ap.LIVE_START_OK.type));
                    com.tencent.mm.plugin.finder.report.live.k kVar6 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_BEGIN, "");
                    AppMethodBeat.o(247415);
                    return;
                }
                break;
            case 6:
                boolean z = bundle != null ? bundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW") : false;
                String tag = getTAG();
                StringBuilder sb = new StringBuilder("checkFinderObject id:");
                FinderObject finderObject2 = getLiveData().uDz;
                if (finderObject2 != null) {
                    l = Long.valueOf(finderObject2.id);
                } else {
                    l = null;
                }
                Log.i(tag, sb.append(l).append(", nonceId:").append(getLiveData().hwg).toString());
                if ((getLiveData().uDz == null || ((finderObject = getLiveData().uDz) != null && finderObject.id == 0)) && !Util.isNullOrNil(getLiveData().hwg)) {
                    new com.tencent.mm.plugin.finder.cgi.af(getLiveData().hFK, getLiveData().hwg, 0, 2, "", true, null, null, 0, null, false, false, null, null, 0, 24512).aYI().b(new C1200c(this));
                }
                o oVar = o.ujN;
                o.EK(getLiveData().liveInfo.liveId);
                getLiveCore().aBY();
                startTimer();
                al lotteryBubblePlugin = getLotteryBubblePlugin();
                if (lotteryBubblePlugin != null) {
                    lotteryBubblePlugin.dhu();
                }
                prepareShopping();
                Log.i(getTAG(), "START_LIVE byMiniWin:".concat(String.valueOf(z)));
                AppMethodBeat.o(247415);
                return;
            case 7:
                com.tencent.mm.plugin.finder.live.plugin.e finderLiveAfterPlugin = getFinderLiveAfterPlugin();
                if (finderLiveAfterPlugin != null) {
                    finderLiveAfterPlugin.dgL();
                }
                boolean z2 = bundle != null ? bundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL") : false;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    finderLiveAssistant.dfk();
                }
                o oVar2 = o.ujN;
                o.aHh();
                b.C0376b.a(this, b.c.hLD);
                Log.i(getTAG(), "quit but not close");
                Log.i(getTAG(), "finish live is manual finish:".concat(String.valueOf(z2)));
                AppMethodBeat.o(247415);
                return;
            case 8:
                getLiveCore().aBW();
                finish();
                AppMethodBeat.o(247415);
                return;
            case 9:
                Boolean valueOf2 = bundle != null ? Boolean.valueOf(bundle.getBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true)) : null;
                int i4 = bundle != null ? bundle.getInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0) : 0;
                if (bundle != null) {
                    bundle.getInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 0);
                }
                if (!getLiveCore().hAz.isFloatMode()) {
                    com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
                    Context context2 = getContext();
                    p.g(context2, "context");
                    b.a.a(liveCore, context2, valueOf2 != null ? valueOf2.booleanValue() : true, false, i4, 0, 16);
                }
                com.tencent.mm.plugin.finder.report.live.k kVar7 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtq++;
                AppMethodBeat.o(247415);
                return;
            case 10:
            case 11:
                com.tencent.mm.live.core.core.trtc.a liveCore2 = getLiveCore();
                if (liveCore2 == null || (gVar = liveCore2.hAz) == null) {
                    AppMethodBeat.o(247415);
                    return;
                }
                gVar.hzE = g.d.NORMAL_MODE;
                AppMethodBeat.o(247415);
                return;
            case 12:
                if (bundle == null || (byteArray = bundle.getByteArray("PARAM_FINDER_LIVE_TOP_COMMENT")) == null) {
                    AppMethodBeat.o(247415);
                    return;
                }
                awq awq = new awq();
                awq.parseFrom(byteArray);
                ArrayList arrayList = new ArrayList();
                arrayList.add(awq);
                bj topCommentPlugin = getTopCommentPlugin();
                if (topCommentPlugin != null) {
                    topCommentPlugin.ea(arrayList);
                }
                com.tencent.mm.plugin.finder.report.live.k kVar8 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtB++;
                AppMethodBeat.o(247415);
                return;
            case 13:
                Log.i(getTAG(), "param:".concat(String.valueOf(bundle)));
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData2 = getLiveData();
                if (bundle != null) {
                    i2 = bundle.getInt("EVT_PARAM1");
                } else {
                    i2 = 0;
                }
                liveData2.videoWidth = i2;
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData3 = getLiveData();
                if (bundle != null) {
                    i3 = bundle.getInt("EVT_PARAM2");
                } else {
                    i3 = 0;
                }
                liveData3.videoHeight = i3;
                Log.i(getTAG(), "videoWidth:" + getLiveData().videoWidth + ",videoHeight:" + getLiveData().videoHeight);
                aw awVar = this.liveTXLivePlayerPlygin;
                if (!(awVar == null || (tXLivePlayer = awVar.hwO) == null)) {
                    m mVar = m.vVH;
                    tXLivePlayer.setRenderMode(m.a(getLiveData(), isLandscape()));
                }
                adjustLayout();
                AppMethodBeat.o(247415);
                return;
            case 14:
                com.tencent.mm.plugin.finder.live.plugin.ae giftQueuePlugin = getGiftQueuePlugin();
                if (giftQueuePlugin != null) {
                    giftQueuePlugin.dho();
                    AppMethodBeat.o(247415);
                    return;
                }
                break;
        }
        AppMethodBeat.o(247415);
    }

    private final void adjustLayout() {
        AppMethodBeat.i(247416);
        int djc = getLiveData().djc();
        e.a aVar = e.a.hxc;
        if (djc != e.a.aCe()) {
            int djc2 = getLiveData().djc();
            e.a aVar2 = e.a.hxc;
            if (djc2 == e.a.aCf()) {
                adjustLayoutCDN();
                AppMethodBeat.o(247416);
                return;
            }
            Log.i(getTAG(), "invalid audience mode:" + getLiveData().djc());
        }
        AppMethodBeat.o(247416);
    }

    private final void adjustLayoutCDN() {
        float f2;
        float f3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(247417);
        aw awVar = this.liveTXLivePlayerPlygin;
        TXCloudVideoView aHJ = awVar != null ? awVar.aHJ() : null;
        ViewGroup.LayoutParams layoutParams = aHJ != null ? aHJ.getLayoutParams() : null;
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        ViewParent parent = aHJ != null ? aHJ.getParent() : null;
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        ViewGroup.LayoutParams layoutParams3 = viewGroup != null ? viewGroup.getLayoutParams() : null;
        if (!(layoutParams3 instanceof RelativeLayout.LayoutParams)) {
            layoutParams3 = null;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        int i7 = 0;
        int i8 = -1;
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        int i9 = resources.getConfiguration().orientation;
        boolean djn = getLiveData().djn();
        boolean djp = getLiveData().djp();
        if (!djn || 1 != i9 || !djp) {
            f2 = 0.0f;
            f3 = 0.0f;
            i2 = 0;
            i3 = -1;
        } else {
            int i10 = (int) (((float) au.az(MMApplicationContext.getContext()).x) * (((float) getLiveData().videoHeight) / ((float) getLiveData().videoWidth)));
            f3 = ((float) au.az(MMApplicationContext.getContext()).y) * 0.68799996f;
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            f2 = context2.getResources().getDimension(R.dimen.a4u);
            if (((float) i10) <= f3) {
                i4 = ((int) (0.156f * ((float) au.az(MMApplicationContext.getContext()).y))) + au.getStatusBarHeight(getContext());
                if (((float) i10) < f2) {
                    i5 = (int) f2;
                    if (layoutParams2 != null) {
                        layoutParams2.addRule(16);
                        i6 = i10;
                    } else {
                        i6 = i10;
                    }
                } else {
                    i6 = i10;
                    i5 = i10;
                }
            } else {
                i4 = 0;
                i5 = -1;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(16);
                    i6 = i10;
                } else {
                    i6 = i10;
                }
            }
            getLiveData().uDR = false;
            onScreenClear(getLiveData().uDR);
            i2 = i10;
            i3 = i6;
            i8 = i5;
            i7 = i4;
        }
        if (layoutParams4 != null) {
            layoutParams4.topMargin = i7;
        }
        if (layoutParams4 != null) {
            layoutParams4.height = i8;
        }
        if (layoutParams2 != null) {
            layoutParams2.height = i3;
        }
        if (viewGroup != null) {
            viewGroup.setLayoutParams(layoutParams4);
        }
        if (aHJ != null) {
            aHJ.setLayoutParams(layoutParams2);
        }
        Log.i(getTAG(), "adjustLayoutCDN fitLandscapeVideo:" + djn + ",curOrientation:" + i9 + ",videoSizeValid:" + djp + ",uiState:" + getLiveData().uEf + ",videoScaleHeight:" + i2 + ",limitHeight:" + f3 + ",landscapePlayerMiniHeight:" + f2 + ',' + "parentLp height:" + (layoutParams4 != null ? Integer.valueOf(layoutParams4.height) : null) + ",top:" + (layoutParams4 != null ? Integer.valueOf(layoutParams4.topMargin) : null) + ", height:" + (layoutParams2 != null ? Integer.valueOf(layoutParams2.height) : null) + ",top:" + (layoutParams2 != null ? Integer.valueOf(layoutParams2.topMargin) : null));
        AppMethodBeat.o(247417);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(247418);
        Log.i(getTAG(), "onSceneEnd errType:" + i2 + ", errCode:" + i3 + ", scene:" + qVar);
        AppMethodBeat.o(247418);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onLiveEventCallback(int i2, Bundle bundle) {
        int i3;
        int i4 = 0;
        AppMethodBeat.i(247419);
        Log.i(getTAG(), "sdk callback errorCode:".concat(String.valueOf(i2)));
        ae aeVar = ae.vZW;
        com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
        String netTypeString = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        p.g(netTypeString, "NetStatusUtil.getNetType…tionContext.getContext())");
        ae.a(i2, liveData, netTypeString);
        e.d dVar = e.d.hxF;
        if (i2 == e.d.aCu()) {
            joinLive();
            AppMethodBeat.o(247419);
            return;
        }
        e.d dVar2 = e.d.hxF;
        if (i2 == e.d.aCr()) {
            int curNetworkQuality = getCurNetworkQuality();
            setCurNetworkQuality(getLiveCore().hAz.hzL);
            e.h hVar = e.h.hya;
            if (curNetworkQuality != e.h.aCV()) {
                int curNetworkQuality2 = getCurNetworkQuality();
                e.h hVar2 = e.h.hya;
                if (curNetworkQuality2 == e.h.aCV()) {
                    b.C0376b.a(this, b.c.hMo);
                    int curNetworkType = getCurNetworkType();
                    setCurNetworkType(getLiveCore().hAz.networkType);
                    if (!(curNetworkType != 0 || getCurNetworkType() == 0 || getCurNetworkType() == -1)) {
                        Context context = getContext();
                        Context context2 = getContext();
                        p.g(context2, "context");
                        com.tencent.mm.ui.base.u.makeText(context, context2.getResources().getString(R.string.cul), 0).show();
                        AppMethodBeat.o(247419);
                        return;
                    }
                }
            }
            e.h hVar3 = e.h.hya;
            if (curNetworkQuality == e.h.aCV()) {
                int curNetworkQuality3 = getCurNetworkQuality();
                e.h hVar4 = e.h.hya;
                if (curNetworkQuality3 != e.h.aCV()) {
                    b.C0376b.a(this, b.c.hMp);
                }
            }
            int curNetworkType2 = getCurNetworkType();
            setCurNetworkType(getLiveCore().hAz.networkType);
            Context context3 = getContext();
            Context context22 = getContext();
            p.g(context22, "context");
            com.tencent.mm.ui.base.u.makeText(context3, context22.getResources().getString(R.string.cul), 0).show();
            AppMethodBeat.o(247419);
            return;
        }
        e.d dVar3 = e.d.hxF;
        if (i2 == e.d.aCD()) {
            Log.i(getTAG(), "param:".concat(String.valueOf(bundle)));
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData2 = getLiveData();
            if (bundle != null) {
                i3 = bundle.getInt("EVT_PARAM1");
            } else {
                i3 = 0;
            }
            liveData2.videoWidth = i3;
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData3 = getLiveData();
            if (bundle != null) {
                i4 = bundle.getInt("EVT_PARAM2");
            }
            liveData3.videoHeight = i4;
            Log.i(getTAG(), "videoWidth:" + getLiveData().videoWidth + ",videoHeight:" + getLiveData().videoHeight);
            adjustLayout();
        }
        AppMethodBeat.o(247419);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void release() {
        com.tencent.mm.live.core.core.b.g gVar;
        AppMethodBeat.i(247420);
        Log.i(getTAG(), "release");
        checkMiniWindow();
        com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.aFh();
        com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
        com.tencent.mm.plugin.finder.live.model.q.dgC();
        this.timerThread.stopTimer();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3582, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(3917, this);
        com.tencent.mm.kernel.b aAg3 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg3, "MMKernel.network()");
        aAg3.azz().b(3861, this);
        com.tencent.mm.kernel.b aAg4 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg4, "MMKernel.network()");
        aAg4.azz().b(3603, this);
        com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
        if (!((liveCore == null || (gVar = liveCore.hAz) == null) ? null : Boolean.valueOf(gVar.isFloatMode())).booleanValue() && !getMiniWinPermission()) {
            if (!getLiveData().uEv) {
                o oVar = o.ujN;
                o.a(false, getMiniWinPermission(), Boolean.FALSE, 1);
                getLiveData().reset();
            }
            com.tencent.mm.live.core.core.trtc.a liveCore2 = getLiveCore();
            if (liveCore2 != null) {
                liveCore2.aBW();
                AppMethodBeat.o(247420);
                return;
            }
        }
        AppMethodBeat.o(247420);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(247421);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1005:
                if (i3 == -1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vts++;
                    AppMethodBeat.o(247421);
                    return;
                }
                break;
            case 1006:
                if (i3 == -1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtr++;
                    break;
                }
                break;
        }
        AppMethodBeat.o(247421);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c uxP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar) {
            super(0);
            this.uxP = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247384);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.view.c.a.AnonymousClass1 */
                final /* synthetic */ a uxQ;

                {
                    this.uxQ = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(247383);
                    if (!this.uxQ.uxP.getLiveData().djl()) {
                        b.C0376b.a(this.uxQ.uxP, b.c.hLV);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(247383);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(247384);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(c cVar, boolean z, int i2, int i3, String str, com.tencent.mm.live.core.core.b.e eVar, TRTCCloudDef.TRTCParams tRTCParams, auf auf) {
        AppMethodBeat.i(260795);
        if (z) {
            cVar.a(auf);
            m mVar = m.vVH;
            m.a(auf, cVar.getConfettiPlugin(), cVar.getLiveData());
            cVar.getLiveData().UQm.Mpi.clear();
            cVar.getLiveData().UQm.Mpi.addAll(auf.Viw);
            cVar.getLiveData().UQm.UQM = auf.ViJ;
            cVar.getLiveData().hIy = new com.tencent.mm.live.core.core.b.f(tRTCParams, eVar, new com.tencent.mm.live.core.core.b.b("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
            com.tencent.mm.live.core.core.b.f fVar = cVar.getLiveData().hIy;
            if (fVar != null) {
                cVar.getLiveCore().a(fVar);
                ac acVar = ac.vYp;
                ad.a aVar = ad.vZu;
                ac.a(acVar, ad.vZa.name, null, false, false, 14);
                cVar.getLiveCore().a(new e(cVar));
            }
            b.C0376b.a(cVar, b.c.hNb);
            ae aeVar = ae.vZW;
            ae.Gm(cl.aWy());
            AppMethodBeat.o(260795);
            return;
        }
        ac acVar2 = ac.vYp;
        ad.a aVar2 = ad.vZu;
        String str2 = ad.vYZ.name;
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        cit cit = new cit();
        cit.errCode = i2;
        cit.errMsg = str;
        ac.a(acVar2, str2, com.tencent.mm.plugin.finder.utils.y.j(cit), false, true, 4);
        e.a(cVar, i3, i2, str);
        ae aeVar2 = ae.vZW;
        String dEd = ae.dEd();
        if (str == null) {
            str = "";
        }
        ae.a(dEd, i2, i3, str, cVar.getLiveData());
        AppMethodBeat.o(260795);
    }
}
