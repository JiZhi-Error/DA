package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.b;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.s;
import com.tencent.mm.plugin.finder.live.component.j;
import com.tencent.mm.plugin.finder.live.model.cgi.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ac;
import com.tencent.mm.plugin.finder.live.model.cgi.ae;
import com.tencent.mm.plugin.finder.live.model.cgi.af;
import com.tencent.mm.plugin.finder.live.model.cgi.d;
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
import com.tencent.mm.plugin.finder.live.plugin.bl;
import com.tencent.mm.plugin.finder.live.plugin.cb;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.live.plugin.j;
import com.tencent.mm.plugin.finder.live.plugin.t;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.fft;
import com.tencent.mm.protocal.protobuf.ffx;
import com.tencent.mm.protocal.protobuf.ffz;
import com.tencent.mm.protocal.protobuf.fgx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.u;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\"\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0011H\u0002J\u0012\u0010$\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020\u0011H\u0002J\b\u0010(\u001a\u00020\u0011H\u0002J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J*\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u00010\t2\u0006\u00101\u001a\u000202H\u0002J2\u00103\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u00010\t2\u0006\u00101\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J@\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u00100\u001a\u00020\t2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u00101\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020\u0011H\u0002J\b\u0010@\u001a\u00020\u0011H\u0002J\b\u0010A\u001a\u00020\u0011H\u0002J\b\u0010B\u001a\u00020\u0011H\u0002J\b\u0010C\u001a\u00020\u0011H\u0016J\b\u0010D\u001a\u00020\tH\u0016J\u0010\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020\u0011H\u0016J\u0012\u0010I\u001a\u00020\u00112\b\u0010J\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u00020\u0011H\u0016J\b\u0010P\u001a\u00020\u0015H\u0016J\u0018\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020\tH\u0016J\u0010\u0010T\u001a\u00020\u00112\u0006\u0010F\u001a\u00020UH\u0016J\u001a\u0010V\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\u00192\b\u0010X\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010Y\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\u0015H\u0016J,\u0010[\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u00010\t2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010^\u001a\u00020\u0011H\u0016J\u0012\u0010_\u001a\u00020\u00112\b\u0010`\u001a\u0004\u0018\u00010aH\u0002J\b\u0010b\u001a\u00020\u0011H\u0002J\b\u0010c\u001a\u00020\u0011H\u0016J\b\u0010d\u001a\u00020\u0011H\u0002J\b\u0010e\u001a\u00020\u0011H\u0002J\b\u0010f\u001a\u00020\u0011H\u0002J\b\u0010g\u001a\u00020\u0011H\u0016J\u0010\u0010h\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0004H\u0002J\b\u0010j\u001a\u00020\u0011H\u0016J\b\u0010k\u001a\u00020\u0011H\u0002J\u001a\u0010l\u001a\u00020\u00112\u0006\u0010m\u001a\u00020n2\b\u0010X\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010o\u001a\u00020\u0011H\u0016J\b\u0010p\u001a\u00020\u0011H\u0002R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveBaseAnchorPluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "alertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "activate", "", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "isFinished", "", "isFromFloat", "restart", "curIndex", "", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "bindData", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "isInitPos", "checkFinderObject", "checkLinkMicStateWhenJoin", "micInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMicInfo;", "checkMiniWindow", "directStartLive", "genLiveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveRole", "getRelativeLayoutId", "handleAcceptMicPkResp", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderAcceptLiveMicResponse;", "handleApplyMicPkResp", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "applyContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "handleEnterLive", "handleJoinResp", "success", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "hideBottomAraePlugin", "initPlugins", "joinLive", "miniWindow", "mount", "name", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAcceptMicPkTimeout", "onAcceptMicTimeout", "micId", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onApplyMicPkTimeout", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onLiveEventCallback", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "param", "onRotationSwitchChange", "rotationEnable", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "postCloseLinkMsg", "linkMicUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "postCloseLinkPkMsg", "release", "report", "reportLaunchLiveSuccess", "restoreLinkMicUI", "resume", "showAlertDialog", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "start", "startLiveVideo", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "stopLiveVideo", "plugin-finder_release"})
public final class a extends e implements com.tencent.mm.ak.i {
    private String TAG = "Finder.LiveAnchorPluginLayout";
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.plugin.finder.live.view.e
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(247381);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(247381);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.plugin.finder.live.view.e
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(247380);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(247380);
        return view;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ a uxE;

        e(a aVar) {
            this.uxE = aVar;
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.a.e.call(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\n¢\u0006\u0002\b\u000f"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "invoke"})
    public static final class i extends kotlin.g.b.q implements u<Boolean, Integer, Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, auf, x> {
        final /* synthetic */ a uxE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar) {
            super(7);
            this.uxE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.u
        public final /* synthetic */ x invoke(Boolean bool, Integer num, Integer num2, String str, com.tencent.mm.live.core.core.b.e eVar, TRTCCloudDef.TRTCParams tRTCParams, auf auf) {
            AppMethodBeat.i(247337);
            boolean booleanValue = bool.booleanValue();
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            String str2 = str;
            com.tencent.mm.live.core.core.b.e eVar2 = eVar;
            TRTCCloudDef.TRTCParams tRTCParams2 = tRTCParams;
            auf auf2 = auf;
            kotlin.g.b.p.h(str2, "errMsg");
            kotlin.g.b.p.h(eVar2, "liveRoomInfo");
            kotlin.g.b.p.h(tRTCParams2, "trtcParams");
            kotlin.g.b.p.h(auf2, "resp");
            Log.i(this.uxE.getTAG(), "joinLive success:" + booleanValue + ", errCode:" + intValue + " isDestroyed:" + this.uxE.isDestroyed() + " cliBuff:" + auf2.ViJ);
            if (!this.uxE.isDestroyed()) {
                a.a(this.uxE, booleanValue, intValue, intValue2, str2, eVar2, tRTCParams2, auf2);
                this.uxE.getLiveMessageCallback().invoke();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247337);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.s<Boolean, Integer, Integer, String, ape, x> {
        final /* synthetic */ a uxE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(a aVar) {
            super(5);
            this.uxE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.s
        public final /* synthetic */ x a(Boolean bool, Integer num, Integer num2, String str, ape ape) {
            AppMethodBeat.i(260773);
            boolean booleanValue = bool.booleanValue();
            num.intValue();
            num2.intValue();
            kotlin.g.b.p.h(str, "errMsg");
            Log.i(this.uxE.getTAG(), "close live result:".concat(String.valueOf(booleanValue)));
            x xVar = x.SXb;
            AppMethodBeat.o(260773);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ com.tencent.mm.live.b.f UNo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(com.tencent.mm.live.b.f fVar) {
            super(1);
            this.UNo = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            AppMethodBeat.i(260774);
            Boolean valueOf = Boolean.valueOf(Util.isEqual(eVar.sessionId, this.UNo.hFz));
            AppMethodBeat.o(260774);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "toUsers", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke", "com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout$statusChange$4$1"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.b<ArrayList<String>, x> {
        final /* synthetic */ a uxE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(a aVar) {
            super(1);
            this.uxE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ArrayList<String> arrayList) {
            AppMethodBeat.i(247344);
            ArrayList<String> arrayList2 = arrayList;
            if (arrayList2 != null) {
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.uxE.getLiveData();
                String str = (String) kotlin.a.j.kt(arrayList2);
                if (str == null) {
                    str = "";
                }
                liveData.uDJ = str;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247344);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "info", "Lcom/tencent/mm/plugin/finder/live/viewmodel/AnchorFinishInfo;", "invoke"})
    public static final class o extends kotlin.g.b.q implements kotlin.g.a.s<Boolean, Integer, Integer, String, com.tencent.mm.plugin.finder.live.viewmodel.a, x> {
        final /* synthetic */ a uxE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(a aVar) {
            super(5);
            this.uxE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.s
        public final /* synthetic */ x a(Boolean bool, Integer num, Integer num2, String str, com.tencent.mm.plugin.finder.live.viewmodel.a aVar) {
            AppMethodBeat.i(247347);
            final boolean booleanValue = bool.booleanValue();
            final int intValue = num.intValue();
            num2.intValue();
            final com.tencent.mm.plugin.finder.live.viewmodel.a aVar2 = aVar;
            kotlin.g.b.p.h(str, "errMsg");
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.view.a.o.AnonymousClass1 */
                final /* synthetic */ o uxM;

                {
                    this.uxM = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(247346);
                    if (booleanValue && aVar2 != null) {
                        com.tencent.mm.plugin.finder.live.plugin.e finderLiveAfterPlugin = this.uxM.uxE.getFinderLiveAfterPlugin();
                        if (finderLiveAfterPlugin != null) {
                            com.tencent.mm.plugin.finder.live.viewmodel.a aVar = aVar2;
                            kotlin.g.b.p.h(aVar, "info");
                            finderLiveAfterPlugin.umm.setVisibility(0);
                            TextView textView = finderLiveAfterPlugin.hOg;
                            StringBuilder sb = new StringBuilder();
                            Context context = finderLiveAfterPlugin.hwr.getContext();
                            kotlin.g.b.p.g(context, "root.context");
                            StringBuilder append = sb.append(context.getResources().getString(R.string.cs2)).append(' ');
                            u.a aVar2 = com.tencent.mm.live.b.u.hIn;
                            textView.setText(append.append(u.a.a(aVar.duration, ":", false, false, false, 28)).toString());
                            TextView textView2 = finderLiveAfterPlugin.hOd;
                            y yVar = y.vXH;
                            textView2.setText(y.LT(aVar.uCk));
                            TextView textView3 = finderLiveAfterPlugin.hOf;
                            y yVar2 = y.vXH;
                            textView3.setText(y.LT(aVar.likeCount));
                            TextView textView4 = finderLiveAfterPlugin.umf;
                            y yVar3 = y.vXH;
                            textView4.setText(y.LT(aVar.uCl));
                            TextView textView5 = finderLiveAfterPlugin.umk;
                            y yVar4 = y.vXH;
                            textView5.setText(y.LT((int) aVar.uCm));
                            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                            if (com.tencent.mm.plugin.finder.storage.c.hVh().value().intValue() == 1) {
                                if (aVar.uCm == 0) {
                                    finderLiveAfterPlugin.umi.setOnClickListener(null);
                                    finderLiveAfterPlugin.ULh.setVisibility(8);
                                } else {
                                    finderLiveAfterPlugin.ULh.setVisibility(0);
                                }
                            }
                            if (aVar.uCl > 0) {
                                finderLiveAfterPlugin.umh.setVisibility(0);
                            } else {
                                finderLiveAfterPlugin.umh.setVisibility(8);
                            }
                        }
                        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtn = (long) aVar2.uCk;
                        com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vto = (long) aVar2.likeCount;
                        com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtp = (long) aVar2.uCl;
                        com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtm = (long) aVar2.duration;
                    }
                    com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().dpv();
                    com.tencent.mm.plugin.finder.report.live.k kVar6 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.errorCode = intValue;
                    com.tencent.mm.plugin.finder.report.live.k kVar7 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtk = System.currentTimeMillis();
                    com.tencent.mm.plugin.finder.report.live.k kVar8 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_OUT, String.valueOf(intValue));
                    com.tencent.mm.plugin.finder.report.live.k kVar9 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dph();
                    x xVar = x.SXb;
                    AppMethodBeat.o(247346);
                    return xVar;
                }
            });
            Log.i(this.uxE.getTAG(), "finish live result:" + booleanValue + ',' + aVar2);
            x xVar = x.SXb;
            AppMethodBeat.o(247347);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(MMActivity mMActivity) {
        super(mMActivity);
        kotlin.g.b.p.h(mMActivity, "context");
        AppMethodBeat.i(247375);
        AppMethodBeat.o(247375);
    }

    public static final /* synthetic */ void diq() {
        AppMethodBeat.i(247378);
        report();
        AppMethodBeat.o(247378);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.e
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.e
    public final void setTAG(String str) {
        AppMethodBeat.i(247350);
        kotlin.g.b.p.h(str, "<set-?>");
        this.TAG = str;
        AppMethodBeat.o(247350);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.e
    public final com.tencent.mm.live.core.core.trtc.a dip() {
        AppMethodBeat.i(247351);
        b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
        getContext();
        com.tencent.mm.live.core.core.a.b aDo = b.a.aDo();
        AppMethodBeat.o(247351);
        return aDo;
    }

    private final void joinLive() {
        Long l2;
        long j2 = 0;
        AppMethodBeat.i(247352);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
        getLiveData().EO(asG != null ? asG.field_liveSwitchFlag : 0);
        com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
        if (asG != null) {
            j2 = asG.field_liveAnchorStatusFlag;
        }
        liveData.uDA = (int) j2;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            s.a.a(finderLiveAssistant, getLiveData().liveInfo.liveId, getLiveData().hFK, getLiveData().uDA);
        }
        com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
        com.tencent.mm.plugin.finder.live.model.e.dfy();
        j.a aVar2 = com.tencent.mm.plugin.finder.live.component.j.UJU;
        j.a.RI(getLiveData().liveInfo.liveId);
        String tag = getTAG();
        StringBuilder append = new StringBuilder("joinLive anchorStatusFlag:").append(getLiveData().uDA).append(" switchFlag:");
        if (asG != null) {
            l2 = Long.valueOf(asG.field_liveSwitchFlag);
        } else {
            l2 = null;
        }
        Log.i(tag, append.append(l2).append(" giftFuncEnabel:").append(getLiveData().uEJ).append(" linkMicFuncEnabel:").append(getLiveData().uEG).toString());
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant2 = getFinderLiveAssistant();
        if (finderLiveAssistant2 != null) {
            finderLiveAssistant2.a(1, new i(this));
            AppMethodBeat.o(247352);
            return;
        }
        AppMethodBeat.o(247352);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout$handleJoinResp$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
    public static final class g implements com.tencent.mm.live.core.core.c {
        final /* synthetic */ auf UNn;
        final /* synthetic */ a uxE;

        g(a aVar, auf auf) {
            this.uxE = aVar;
            this.UNn = auf;
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(247335);
            Log.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish");
            if (i2 > 0) {
                a.a(this.uxE, this.UNn.LES);
                ae aeVar = ae.vZW;
                ae.Gn(cl.aWy());
                ac acVar = ac.vYp;
                ad.a aVar = ad.vZu;
                ac.a(acVar, ad.vZc.name, null, false, false, 14);
                long j2 = this.uxE.getLiveData().liveInfo.liveId;
                long j3 = this.uxE.getLiveData().hFK;
                int i3 = this.uxE.getLiveData().uDA;
                String aUg = z.aUg();
                kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                new com.tencent.mm.plugin.finder.cgi.s(j2, j3, i3, aUg, 1, new s.a(this) {
                    /* class com.tencent.mm.plugin.finder.live.view.a.g.AnonymousClass1 */
                    final /* synthetic */ g uxH;

                    {
                        this.uxH = r1;
                    }

                    @Override // com.tencent.mm.plugin.finder.cgi.s.a
                    public final void onSuccess(int i2) {
                        AppMethodBeat.i(247332);
                        Log.i(this.uxH.uxE.getTAG(), "share live success!");
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.live.view.a.g.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 uxI;

                            {
                                this.uxI = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(247329);
                                com.tencent.mm.plugin.finder.live.model.i iVar = com.tencent.mm.plugin.finder.live.model.i.uja;
                                com.tencent.mm.plugin.finder.live.model.i.b(this.uxI.uxH.uxE.getLiveData());
                                com.tencent.mm.plugin.finder.live.model.i iVar2 = com.tencent.mm.plugin.finder.live.model.i.uja;
                                com.tencent.mm.plugin.finder.live.model.i.c(this.uxI.uxH.uxE.getLiveData());
                                com.tencent.mm.plugin.finder.live.model.i iVar3 = com.tencent.mm.plugin.finder.live.model.i.uja;
                                com.tencent.mm.plugin.finder.live.model.i.k(this.uxI.uxH.uxE.getLiveData());
                                int i2 = this.uxI.uxH.uxE.getLiveCore().hAB;
                                com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                                kotlin.g.b.p.g(aDC, "ConfigHelper.getInstance()");
                                com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
                                kotlin.g.b.p.g(aDD, "ConfigHelper.getInstance().videoConfig");
                                if (i2 != aDD.aDR()) {
                                    com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                                    if (com.tencent.mm.plugin.finder.live.model.o.dgm()) {
                                        String tag = this.uxI.uxH.uxE.getTAG();
                                        StringBuilder append = new StringBuilder("fps Change, oldFps:").append(this.uxI.uxH.uxE.getLiveCore().hAB).append(" newFps:");
                                        com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                                        kotlin.g.b.p.g(aDC2, "ConfigHelper.getInstance()");
                                        com.tencent.mm.live.core.core.trtc.a.a.d aDD2 = aDC2.aDD();
                                        kotlin.g.b.p.g(aDD2, "ConfigHelper.getInstance().videoConfig");
                                        Log.i(tag, append.append(aDD2.aDR()).toString());
                                        com.tencent.mm.plugin.finder.live.plugin.r previewPlugin = this.uxI.uxH.uxE.getPreviewPlugin();
                                        if (previewPlugin != null) {
                                            previewPlugin.startPreview();
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = this.uxI.uxH.uxE.getFinderLiveAssistant();
                                if (finderLiveAssistant != null) {
                                    this.uxI.uxH.uxE.getLiveData();
                                    this.uxI.uxH.uxE.getLiveData();
                                    this.uxI.uxH.uxE.getLiveData();
                                    finderLiveAssistant.f(null);
                                }
                                this.uxI.uxH.uxE.getLiveData().sessionId = SystemClock.elapsedRealtimeNanos();
                                b.C0376b.a(this.uxI.uxH.uxE, b.c.hLB);
                                b.C0376b.a(this.uxI.uxH.uxE, b.c.hMs);
                                EventCenter.instance.publish(new hi());
                                ac acVar = ac.vYp;
                                ad.a aVar = ad.vZu;
                                ac.a(acVar, ad.vZf.name, null, false, true, 6);
                                ae aeVar = ae.vZW;
                                ae.Gl(cl.aWy());
                                x xVar = x.SXb;
                                AppMethodBeat.o(247329);
                                return xVar;
                            }
                        });
                        AppMethodBeat.o(247332);
                    }

                    @Override // com.tencent.mm.plugin.finder.cgi.s.a
                    public final void b(final int i2, final int i3, final String str, int i4) {
                        AppMethodBeat.i(247333);
                        Log.i(this.uxH.uxE.getTAG(), "share live fail!");
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.live.view.a.g.AnonymousClass1.AnonymousClass2 */
                            final /* synthetic */ AnonymousClass1 uxI;

                            {
                                this.uxI = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                String string;
                                AppMethodBeat.i(247331);
                                Context context = this.uxI.uxH.uxE.getContext();
                                String str = str;
                                if (str != null) {
                                    string = str;
                                } else {
                                    Context context2 = this.uxI.uxH.uxE.getContext();
                                    kotlin.g.b.p.g(context2, "context");
                                    string = context2.getResources().getString(R.string.chw);
                                }
                                com.tencent.mm.ui.base.u.makeText(context, string, 0).show();
                                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = this.uxI.uxH.uxE.getFinderLiveAssistant();
                                if (finderLiveAssistant != null) {
                                    s.a.a(finderLiveAssistant, new kotlin.g.a.s<Boolean, Integer, Integer, String, ape, x>(this) {
                                        /* class com.tencent.mm.plugin.finder.live.view.a.g.AnonymousClass1.AnonymousClass2.AnonymousClass1 */
                                        final /* synthetic */ AnonymousClass2 uxJ;

                                        {
                                            this.uxJ = r2;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                                        @Override // kotlin.g.a.s
                                        public final /* synthetic */ x a(Boolean bool, Integer num, Integer num2, String str, ape ape) {
                                            AppMethodBeat.i(247330);
                                            boolean booleanValue = bool.booleanValue();
                                            num.intValue();
                                            num2.intValue();
                                            kotlin.g.b.p.h(str, "errMsg");
                                            Log.i(this.uxJ.uxI.uxH.uxE.getTAG(), "close live result:".concat(String.valueOf(booleanValue)));
                                            x xVar = x.SXb;
                                            AppMethodBeat.o(247330);
                                            return xVar;
                                        }
                                    });
                                }
                                b.C0376b.a(this.uxI.uxH.uxE, b.c.hLy);
                                ac acVar = ac.vYp;
                                ad.a aVar = ad.vZu;
                                ac.a(acVar, ad.vZd.name, null, false, true, 6);
                                ae aeVar = ae.vZW;
                                String dEf = ae.dEf();
                                int i2 = i3;
                                int i3 = i2;
                                String str2 = str;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                ae.a(dEf, i2, i3, str2, this.uxI.uxH.uxE.getLiveData());
                                x xVar = x.SXb;
                                AppMethodBeat.o(247331);
                                return xVar;
                            }
                        });
                        AppMethodBeat.o(247333);
                    }
                }).aYI();
                AppMethodBeat.o(247335);
                return;
            }
            ac acVar2 = ac.vYp;
            ad.a aVar2 = ad.vZu;
            ac.a(acVar2, ad.vZb.name, null, false, true, 6);
            Log.w("MicroMsg.LiveCoreAnchor", "enter room fail");
            com.tencent.mm.ui.base.u.makeText(this.uxE.getContext(), "enter room fail", 0).show();
            b.C0376b.a(this.uxE, b.c.hLy);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("live_user_exit_reason", i2);
            this.uxE.statusChange(b.c.hMr, bundle2);
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = this.uxE.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                s.a.a(finderLiveAssistant, new kotlin.g.a.s<Boolean, Integer, Integer, String, ape, x>(this) {
                    /* class com.tencent.mm.plugin.finder.live.view.a.g.AnonymousClass2 */
                    final /* synthetic */ g uxH;

                    {
                        this.uxH = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                    @Override // kotlin.g.a.s
                    public final /* synthetic */ x a(Boolean bool, Integer num, Integer num2, String str, ape ape) {
                        AppMethodBeat.i(247334);
                        boolean booleanValue = bool.booleanValue();
                        num.intValue();
                        num2.intValue();
                        kotlin.g.b.p.h(str, "errMsg");
                        Log.i(this.uxH.uxE.getTAG(), "close live result:".concat(String.valueOf(booleanValue)));
                        x xVar = x.SXb;
                        AppMethodBeat.o(247334);
                        return xVar;
                    }
                });
            }
            ae aeVar2 = ae.vZW;
            ae.a(ae.dEe(), i2, 0, String.valueOf(bundle), this.uxE.getLiveData());
            AppMethodBeat.o(247335);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ a uxE;

        f(a aVar) {
            this.uxE = aVar;
        }

        public final void run() {
            AppMethodBeat.i(247328);
            a.a(this.uxE);
            AppMethodBeat.o(247328);
        }
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final int getRelativeLayoutId() {
        return R.layout.ad3;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void bindData(com.tencent.mm.plugin.finder.live.viewmodel.c cVar, com.tencent.mm.plugin.finder.live.viewmodel.g gVar, boolean z) {
        AppMethodBeat.i(247353);
        kotlin.g.b.p.h(cVar, "data");
        kotlin.g.b.p.h(gVar, "liveData");
        super.bindData(cVar, gVar, z);
        if (gVar.hIy == null) {
            gVar.hIy = new com.tencent.mm.live.core.core.b.f(new TRTCCloudDef.TRTCParams(), new com.tencent.mm.live.core.core.b.e(null, 0, 0, null, 0, 0, 0, null, null, 0, 8191), new com.tencent.mm.live.core.core.b.b("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
        }
        AppMethodBeat.o(247353);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void activate(com.tencent.mm.plugin.finder.live.viewmodel.c cVar, boolean z, boolean z2, boolean z3, int i2) {
        TRTCVideoLayoutManager renderLayout;
        AppMethodBeat.i(260783);
        kotlin.g.b.p.h(cVar, "data");
        super.activate(cVar, z, z2, z3, i2);
        com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
        String aUg = z.aUg();
        kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        liveData.atT(aUg);
        Log.i(getTAG(), "liveFinish:" + getLiveData().uDN + ",isFromFloat:" + z2 + ", restart:" + z3 + ",liveId:" + getLiveData().liveInfo.liveId + ",objectId:" + getLiveData().hFK + ",nonceId:" + getLiveData().hwg + ",username:" + getLiveData().hwd);
        fillBlurBg(getLiveData().hwd);
        View findViewById = findViewById(R.id.ek6);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.live_preview_ui_root)");
        setPreviewPlugin(new com.tencent.mm.plugin.finder.live.plugin.r((ViewGroup) findViewById, this));
        View findViewById2 = findViewById(R.id.cwn);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.finder_live_post_layout)");
        setFinderLiveBeforePlugin(new t((ViewGroup) findViewById2, this));
        View findViewById3 = findViewById(R.id.elk);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.live_shadow_ui_root)");
        setShadowPlugin(new as((ViewGroup) findViewById3, this));
        View findViewById4 = findViewById(R.id.cu8);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.finder_live_lottery_bubble_root)");
        setLotteryBubblePlugin(new al((ViewGroup) findViewById4, this));
        View findViewById5 = findViewById(R.id.emn);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.live_title_ui_root)");
        setTitleInfoPlugin(new bh((ViewGroup) findViewById5, this));
        View findViewById6 = findViewById(R.id.egr);
        kotlin.g.b.p.g(findViewById6, "findViewById(R.id.live_common_info_ui_root)");
        setCommonInfoPlugin(new com.tencent.mm.plugin.finder.live.plugin.y((ViewGroup) findViewById6, this));
        View findViewById7 = findViewById(R.id.cx9);
        kotlin.g.b.p.g(findViewById7, "findViewById(R.id.finder_live_ready_ui_root)");
        setReadyPlugin(new ay((ViewGroup) findViewById7, this));
        View findViewById8 = findViewById(R.id.cps);
        kotlin.g.b.p.g(findViewById8, "findViewById(R.id.finder_live_comment_ui_root)");
        setCommentPlugin(new v((ViewGroup) findViewById8, this));
        View findViewById9 = findViewById(R.id.ef1);
        kotlin.g.b.p.g(findViewById9, "findViewById(R.id.live_anchor_close_ui_root)");
        setClosePlugin(new com.tencent.mm.plugin.finder.live.plugin.l((ViewGroup) findViewById9, this));
        View findViewById10 = findViewById(R.id.cms);
        kotlin.g.b.p.g(findViewById10, "findViewById(R.id.finder…ive_anchor_after_ui_root)");
        setFinderLiveAfterPlugin(new com.tencent.mm.plugin.finder.live.plugin.e((ViewGroup) findViewById10, this));
        View findViewById11 = findViewById(R.id.eiz);
        kotlin.g.b.p.g(findViewById11, "findViewById(R.id.live_members_list_ui_root)");
        setMemberListPlugin(new ap((ViewGroup) findViewById11, this));
        View findViewById12 = findViewById(R.id.cva);
        kotlin.g.b.p.g(findViewById12, "findViewById(R.id.finder…_members_profile_ui_root)");
        setProfilePlugin(new cc((ViewGroup) findViewById12, this, getContextObj()));
        View findViewById13 = findViewById(R.id.ehv);
        kotlin.g.b.p.g(findViewById13, "findViewById(R.id.live_like_confetti_ui_root)");
        setConfettiPlugin(new aj((ViewGroup) findViewById13, this));
        View findViewById14 = findViewById(R.id.cvz);
        kotlin.g.b.p.g(findViewById14, "findViewById(R.id.finder_live_more_action_ui_root)");
        ViewGroup viewGroup = (ViewGroup) findViewById14;
        a aVar = this;
        Context context = getContext();
        if (context == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(260783);
            throw tVar;
        }
        setMoreActionPlugin(new at(viewGroup, aVar, (MMActivity) context));
        View findViewById15 = findViewById(R.id.cpz);
        kotlin.g.b.p.g(findViewById15, "findViewById(R.id.finder_live_exception)");
        setExceptionPlugin(new com.tencent.mm.plugin.finder.live.plugin.n((ViewGroup) findViewById15, this));
        View findViewById16 = findViewById(R.id.cqt);
        kotlin.g.b.p.g(findViewById16, "findViewById(R.id.finder_live_gift_play_ui_root)");
        setGiftPlayPlugin(new com.tencent.mm.plugin.finder.live.plugin.ac((ViewGroup) findViewById16, this));
        View findViewById17 = findViewById(R.id.cr1);
        kotlin.g.b.p.g(findViewById17, "findViewById(R.id.finder_live_gift_queue_ui_root)");
        View findViewById18 = findViewById(R.id.jx4);
        kotlin.g.b.p.g(findViewById18, "findViewById(R.id.finder…e_gift_queue_outer_space)");
        setGiftQueuePlugin(new com.tencent.mm.plugin.finder.live.plugin.ae((ViewGroup) findViewById17, this, getLiveData().uDw, (ViewGroup) findViewById18));
        View findViewById19 = findViewById(R.id.cyi);
        kotlin.g.b.p.g(findViewById19, "findViewById(R.id.finder_live_top_comment_ui_root)");
        setTopCommentPlugin(new bj((ViewGroup) findViewById19, this));
        View findViewById20 = findViewById(R.id.cmw);
        kotlin.g.b.p.g(findViewById20, "findViewById(R.id.finder…nchor_camera_opt_ui_root)");
        setCameraOptPlugin(new com.tencent.mm.plugin.finder.live.plugin.k((ViewGroup) findViewById20, this));
        View findViewById21 = findViewById(R.id.cpp);
        kotlin.g.b.p.g(findViewById21, "findViewById(R.id.finder…camera_opt_panel_ui_root)");
        setCameraOptPanelPlugin(new com.tencent.mm.plugin.finder.live.plugin.j((ViewGroup) findViewById21, this));
        View findViewById22 = findViewById(R.id.cu9);
        kotlin.g.b.p.g(findViewById22, "findViewById(R.id.finder_live_lottery_card_root)");
        setLotteryCardPlugin(new com.tencent.mm.plugin.finder.live.plugin.q((ViewGroup) findViewById22, this));
        View findViewById23 = findViewById(R.id.ctw);
        kotlin.g.b.p.g(findViewById23, "findViewById(R.id.finder_live_link_state_ui_root)");
        setLinkStatePlugin(new com.tencent.mm.plugin.finder.live.plugin.p((ViewGroup) findViewById23, this));
        View findViewById24 = findViewById(R.id.cnl);
        kotlin.g.b.p.g(findViewById24, "findViewById(R.id.finder…anchor_link_list_ui_root)");
        setLinkApplyListPlugin(new com.tencent.mm.plugin.finder.live.plugin.o((ViewGroup) findViewById24, this));
        View findViewById25 = findViewById(R.id.jy5);
        kotlin.g.b.p.g(findViewById25, "findViewById(R.id.finder…ive_mic_decorate_ui_root)");
        setMicDecoratePlugin(new cb((ViewGroup) findViewById25, this));
        View findViewById26 = findViewById(R.id.cmu);
        kotlin.g.b.p.g(findViewById26, "findViewById(R.id.finder…or_bottom_option_ui_root)");
        setBottomOptionPlugin(new com.tencent.mm.plugin.finder.live.plugin.h((ViewGroup) findViewById26, this));
        View findViewById27 = findViewById(R.id.jy2);
        kotlin.g.b.p.g(findViewById27, "findViewById(R.id.finder_live_lucky_money_ui_root)");
        setLuckyMoneyPlugin(new com.tencent.mm.plugin.finder.live.plugin.as((ViewGroup) findViewById27, this));
        View findViewById28 = findViewById(R.id.jy3);
        kotlin.g.b.p.g(findViewById28, "findViewById(R.id.finder…ic_audio_preview_ui_root)");
        setMicAudioPreviewPlugin(new bl((ViewGroup) findViewById28, this, (byte) 0));
        hTJ();
        hideLoadingLayer();
        com.tencent.mm.plugin.finder.live.plugin.r previewPlugin = getPreviewPlugin();
        if (previewPlugin != null) {
            previewPlugin.rg(0);
        }
        t finderLiveBeforePlugin = getFinderLiveBeforePlugin();
        if (finderLiveBeforePlugin != null) {
            finderLiveBeforePlugin.rg(8);
        }
        as shadowPlugin = getShadowPlugin();
        if (shadowPlugin != null) {
            shadowPlugin.rg(8);
        }
        bh titleInfoPlugin = getTitleInfoPlugin();
        if (titleInfoPlugin != null) {
            titleInfoPlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.y commonInfoPlugin = getCommonInfoPlugin();
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
        com.tencent.mm.plugin.finder.live.plugin.l closePlugin = getClosePlugin();
        if (closePlugin != null) {
            closePlugin.rg(8);
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
        com.tencent.mm.plugin.finder.live.plugin.k cameraOptPlugin = getCameraOptPlugin();
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
        com.tencent.mm.plugin.finder.live.plugin.n exceptionPlugin = getExceptionPlugin();
        if (exceptionPlugin != null) {
            exceptionPlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.ac giftPlayPlugin = getGiftPlayPlugin();
        if (giftPlayPlugin != null) {
            giftPlayPlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.ae giftQueuePlugin = getGiftQueuePlugin();
        if (giftQueuePlugin != null) {
            giftQueuePlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.j cameraOptPanelPlugin = getCameraOptPanelPlugin();
        if (cameraOptPanelPlugin != null) {
            cameraOptPanelPlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin = getLinkStatePlugin();
        if (linkStatePlugin != null) {
            linkStatePlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.o linkApplyListPlugin = getLinkApplyListPlugin();
        if (linkApplyListPlugin != null) {
            linkApplyListPlugin.rg(8);
        }
        cb micDecoratePlugin = getMicDecoratePlugin();
        if (micDecoratePlugin != null) {
            micDecoratePlugin.rg(8);
        }
        bl micAudioPreviewPlugin = getMicAudioPreviewPlugin();
        if (micAudioPreviewPlugin != null) {
            micAudioPreviewPlugin.rg(8);
        }
        al lotteryBubblePlugin = getLotteryBubblePlugin();
        if (lotteryBubblePlugin != null) {
            lotteryBubblePlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.q lotteryCardPlugin = getLotteryCardPlugin();
        if (lotteryCardPlugin != null) {
            lotteryCardPlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin = getBottomOptionPlugin();
        if (bottomOptionPlugin != null) {
            bottomOptionPlugin.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.as luckyMoneyPlugin = getLuckyMoneyPlugin();
        if (luckyMoneyPlugin != null) {
            luckyMoneyPlugin.rg(8);
        }
        aj confettiPlugin2 = getConfettiPlugin();
        if (confettiPlugin2 != null) {
            confettiPlugin2.a(getData().uCr);
        }
        com.tencent.mm.plugin.finder.live.plugin.y commonInfoPlugin2 = getCommonInfoPlugin();
        if (commonInfoPlugin2 != null) {
            getData();
            commonInfoPlugin2.aHy();
        }
        t finderLiveBeforePlugin2 = getFinderLiveBeforePlugin();
        if (finderLiveBeforePlugin2 != null) {
            com.tencent.mm.plugin.finder.live.viewmodel.c data = getData();
            kotlin.g.b.p.h(data, "data");
            FinderLivePostUIC finderLivePostUIC = finderLiveBeforePlugin2.unX;
            awt awt = data.ufj;
            if (awt != null) {
                String str = awt.dDJ;
                if (!(str == null || str.length() == 0) && (awt.LHx & 1) == 1) {
                    View view = finderLivePostUIC.uCM;
                    if (view == null) {
                        kotlin.g.b.p.btv("noticeLayout");
                    }
                    view.setVisibility(0);
                    Date date = new Date(((long) awt.dvv) * 1000);
                    Calendar instance = Calendar.getInstance();
                    kotlin.g.b.p.g(instance, FFmpegMetadataRetriever.METADATA_KEY_DATE);
                    instance.setTime(date);
                    int i3 = instance.get(2) + 1;
                    int i4 = instance.get(5);
                    y yVar = y.vXH;
                    String LX = y.LX(instance.get(11));
                    y yVar2 = y.vXH;
                    String LX2 = y.LX(instance.get(12));
                    TextView textView = finderLivePostUIC.uCO;
                    if (textView == null) {
                        kotlin.g.b.p.btv("noticeTimeTxt");
                    }
                    Context context2 = finderLivePostUIC.getRootView().getContext();
                    kotlin.g.b.p.g(context2, "rootView.context");
                    textView.setText(context2.getResources().getString(R.string.cy3, Integer.valueOf(i3), Integer.valueOf(i4), LX, LX2));
                }
            }
        }
        showProgressWithBlurBg(getLiveData().hwd);
        if (getLiveData().liveInfo.liveId == 0) {
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vmk = false;
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vml = false;
            b.C0376b.a(this, b.c.hLy);
        } else if (!z2) {
            getLiveData().uDz = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().Fy(getLiveData().hFK).getFinderObject();
            getLiveData().uEj = true;
            joinLive();
        } else if (getLiveData().uDN) {
            b.C0376b.a(this, b.c.hLV);
        } else {
            hideLoadingLayer();
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", true);
            statusChange(b.c.hLB, bundle);
            b.C0376b.a(this, b.c.hMs);
            com.tencent.mm.plugin.finder.live.plugin.r previewPlugin2 = getPreviewPlugin();
            if (!(previewPlugin2 == null || (renderLayout = previewPlugin2.hAs.getRenderLayout()) == null)) {
                renderLayout.post(new f(this));
            }
            com.tencent.mm.ac.d.a(200, new C1193a(this));
        }
        com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
        com.tencent.mm.plugin.finder.live.model.q.j(name(), new b(this));
        AppMethodBeat.o(260783);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onCallStateChanged(int i2, String str) {
        AppMethodBeat.i(247355);
        kotlin.g.b.p.h(str, "incomingNumber");
        AppMethodBeat.o(247355);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onRotationSwitchChange(boolean z) {
    }

    @Override // com.tencent.mm.live.view.a
    public final String name() {
        AppMethodBeat.i(247356);
        String simpleName = a.class.getSimpleName();
        kotlin.g.b.p.g(simpleName, "FinderLiveAnchorPluginLa…ut::class.java.simpleName");
        AppMethodBeat.o(247356);
        return simpleName;
    }

    @Override // com.tencent.mm.live.c.b
    public final int getLiveRole() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void resume() {
        AppMethodBeat.i(247357);
        super.resume();
        AppMethodBeat.o(247357);
    }

    private final void stopLiveVideo() {
        AppMethodBeat.i(247358);
        Log.i(getTAG(), "stopLiveVideo,float mode:" + getLiveCore().hAz.isFloatMode() + ", normal mode:" + getLiveCore().hAz.isNormalMode() + ",manual closed:" + isManualClosed() + ", needMiniWindow:" + getLiveData().uDS + ", start:" + isLiveStarted() + ",finish:" + isLiveFinished());
        if (isManualClosed() || !isLiveStarted() || isLiveFinished()) {
            if (getLiveCore().hAz.isNormalMode()) {
                getLiveCore().aBS();
                getLiveCore().aBX();
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
                RequestFloatWindowPermissionDialog.a(getContext(), getContext().getString(R.string.ej9), new j(this), false, com.tencent.mm.bq.a.apJ());
                AppMethodBeat.o(247358);
                return;
            }
            setMiniWinPermission(false);
            statusChange(b.c.hLQ, bundle);
            report();
            AppMethodBeat.o(247358);
            return;
        }
        AppMethodBeat.o(247358);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder_release"})
    public static final class j implements RequestFloatWindowPermissionDialog.a {
        final /* synthetic */ a uxE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(a aVar) {
            this.uxE = aVar;
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            int i2 = 1;
            AppMethodBeat.i(247338);
            kotlin.g.b.p.h(requestFloatWindowPermissionDialog, "dialog");
            requestFloatWindowPermissionDialog.finish();
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true);
            if (!this.uxE.isSwipeBack()) {
                i2 = 3;
            }
            bundle.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", i2);
            bundle.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
            this.uxE.statusChange(b.c.hLQ, bundle);
            this.uxE.setMiniWinPermission(false);
            a.diq();
            AppMethodBeat.o(247338);
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(247339);
            kotlin.g.b.p.h(requestFloatWindowPermissionDialog, "dialog");
            this.uxE.setMiniWinPermission(false);
            requestFloatWindowPermissionDialog.finish();
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_LIVE_MINI_WINDOW_AUTO", true);
            this.uxE.statusChange(b.c.hLT, bundle);
            AppMethodBeat.o(247339);
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(247340);
            kotlin.g.b.p.h(requestFloatWindowPermissionDialog, "dialog");
            this.uxE.setMiniWinPermission(false);
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_LIVE_MINI_WINDOW_AUTO", true);
            this.uxE.statusChange(b.c.hLU, bundle);
            AppMethodBeat.o(247340);
        }
    }

    private static void report() {
        String valueOf;
        AppMethodBeat.i(247359);
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmo) {
            valueOf = String.valueOf(s.r.LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP.type);
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vmo = false;
        } else {
            com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            if (!com.tencent.mm.plugin.finder.report.live.k.dpl().vlB) {
                com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                if (!com.tencent.mm.plugin.finder.report.live.k.dpl().vlC) {
                    if (com.tencent.mm.plugin.expt.hellhound.a.syQ) {
                        valueOf = String.valueOf(s.r.LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG.type);
                    } else {
                        valueOf = String.valueOf(s.r.LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE.type);
                    }
                }
            }
            valueOf = String.valueOf(s.d.CLICK_ENTER_LOTTERY_RECORD.action);
        }
        com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_MINIMIZE, valueOf);
        AppMethodBeat.o(247359);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void pause() {
        AppMethodBeat.i(247360);
        super.pause();
        AppMethodBeat.o(247360);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void stop() {
        AppMethodBeat.i(247361);
        super.stop();
        checkMiniWindow();
        AppMethodBeat.o(247361);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void start() {
        AppMethodBeat.i(247362);
        super.start();
        Log.i(getTAG(), "startLiveVideo,float mode:" + getLiveCore().hAz.isFloatMode() + ", normal mode:" + getLiveCore().hAz.isNormalMode());
        if (getLiveCore().hAz.isFloatMode()) {
            getLiveCore().aBU();
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_MINIMIZE, String.valueOf(s.r.LIVE_FLOAT_ACTION_MAXIMIZE.type));
        }
        if (getLiveCore().hAz.isNormalMode()) {
            com.tencent.mm.plugin.finder.live.plugin.r previewPlugin = getPreviewPlugin();
            if (previewPlugin != null) {
                previewPlugin.startPreview();
            }
            com.tencent.mm.plugin.finder.live.plugin.r previewPlugin2 = getPreviewPlugin();
            if (previewPlugin2 != null) {
                previewPlugin2.hAs.hER.aFa();
            }
            if (getLiveCore().hAz.b(Long.valueOf(getLiveData().liveInfo.liveId))) {
                getLiveCore().aBY();
            }
        }
        startTimer();
        AppMethodBeat.o(247362);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void mount() {
        AppMethodBeat.i(247363);
        super.mount();
        ae aeVar = ae.vZW;
        com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
        if (liveCore == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
            AppMethodBeat.o(247363);
            throw tVar;
        }
        ae.e((com.tencent.mm.live.core.core.a.b) liveCore);
        com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.d(name(), getLiveMessageCallback());
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3582, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg2, "MMKernel.network()");
        aAg2.azz().a(3917, this);
        com.tencent.mm.kernel.b aAg3 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg3, "MMKernel.network()");
        aAg3.azz().a(3861, this);
        com.tencent.mm.kernel.b aAg4 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg4, "MMKernel.network()");
        aAg4.azz().a(3603, this);
        AppMethodBeat.o(247363);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(247364);
        boolean onBackPress = super.onBackPress();
        if (!onBackPress) {
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_OUT.hlf, "");
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(com.tencent.mm.plugin.finder.report.live.k.dpj());
        }
        AppMethodBeat.o(247364);
        return onBackPress;
    }

    private final void checkMiniWindow() {
        AppMethodBeat.i(247365);
        Log.i(getTAG(), "checkMiniWindow:" + getCheckMiniWin());
        if (!getCheckMiniWin()) {
            stopLiveVideo();
            this.timerThread.stopTimer();
            setCheckMiniWin(true);
        }
        AppMethodBeat.o(247365);
    }

    private final void c(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
        AppMethodBeat.i(260784);
        Log.i(getTAG(), "postCloseLinkMsg linkMicUser:".concat(String.valueOf(eVar)));
        if (eVar != null) {
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                o.m mVar = o.m.hHB;
                finderLiveAssistant.a(o.m.aFV(), eVar.uCo, eVar.sessionId, new p(eVar, this, eVar));
                AppMethodBeat.o(260784);
                return;
            }
            AppMethodBeat.o(260784);
            return;
        }
        AppMethodBeat.o(260784);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout$postCloseLinkMsg$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder_release"})
    public static final class p implements d.a {
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.e UNp;
        final /* synthetic */ a uxE;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.e uxL;

        p(com.tencent.mm.plugin.finder.live.viewmodel.e eVar, a aVar, com.tencent.mm.plugin.finder.live.viewmodel.e eVar2) {
            this.uxL = eVar;
            this.uxE = aVar;
            this.UNp = eVar2;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.d.a
        public final void onCgiBack(final int i2, final int i3, final String str, avm avm) {
            AppMethodBeat.i(260776);
            kotlin.g.b.p.h(avm, "resp");
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.view.a.p.AnonymousClass1 */
                final /* synthetic */ p UNq;

                {
                    this.UNq = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(260775);
                    Log.i(this.UNq.uxE.getTAG(), "postCloseLinkMsg errCode:" + i3 + ", errType:" + i2 + ", errMsg:" + str);
                    if (i3 == 0 && i2 == 0) {
                        ac acVar = ac.vYp;
                        ac.dDo();
                        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = this.UNq.uxE.getLiveData().uEB;
                        if (eVar == null || eVar.uCx != 1) {
                            com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = this.UNq.uxE.getLiveData().uEB;
                            if (eVar2 != null && eVar2.uCx == 2) {
                                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                com.tencent.mm.plugin.finder.report.live.k.a(s.x.DISCONNECT_VIDEO_TO_LINKMIC, "", -1, -1);
                            }
                        } else {
                            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            com.tencent.mm.plugin.finder.report.live.k.a(s.x.DISCONNECT_VOICE_TO_LINKMIC, "", -1, -1);
                        }
                        this.UNq.uxE.getLiveData().UPX.remove(this.UNq.UNp);
                        this.UNq.uxE.getLiveData().UPZ.remove(this.UNq.UNp);
                        this.UNq.uxE.notifyAudienceMicUserChange();
                    } else {
                        ac acVar2 = ac.vYp;
                        ac.dDp();
                    }
                    this.UNq.uxL.UPO = 0;
                    com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin = this.UNq.uxE.getBottomOptionPlugin();
                    if (bottomOptionPlugin != null) {
                        bottomOptionPlugin.dgP();
                    }
                    com.tencent.mm.plugin.finder.live.plugin.o linkApplyListPlugin = this.UNq.uxE.getLinkApplyListPlugin();
                    if (linkApplyListPlugin != null) {
                        linkApplyListPlugin.aQG();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(260775);
                    return xVar;
                }
            });
            AppMethodBeat.o(260776);
        }
    }

    private final void hTG() {
        String str;
        String str2;
        String str3;
        String str4 = null;
        AppMethodBeat.i(260785);
        Log.i(getTAG(), "postCloseLinkPkMsg curLinkUser:" + getLiveData().uEB);
        avn avn = new avn();
        FinderContact finderContact = new FinderContact();
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = getLiveData().uEB;
        if (eVar != null) {
            str = eVar.username;
        } else {
            str = null;
        }
        finderContact.username = str;
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = getLiveData().uEB;
        if (eVar2 != null) {
            str2 = eVar2.nickname;
        } else {
            str2 = null;
        }
        finderContact.nickname = str2;
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar3 = getLiveData().uEB;
        if (eVar3 != null) {
            str4 = eVar3.headUrl;
        }
        finderContact.headUrl = str4;
        avn.contact = finderContact;
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar4 = getLiveData().uEB;
        if (eVar4 == null || (str3 = eVar4.sessionId) == null) {
            str3 = getLiveData().uEy;
        }
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            o.m mVar = o.m.hHB;
            finderLiveAssistant.a(o.m.aFV(), getLiveData().djq(), str3, avn, new q(this));
            AppMethodBeat.o(260785);
            return;
        }
        AppMethodBeat.o(260785);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout$postCloseLinkPkMsg$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveMicResponse;", "plugin-finder_release"})
    public static final class q implements af.a {
        final /* synthetic */ a uxE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        q(a aVar) {
            this.uxE = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.af.a
        public final void a(int i2, int i3, String str, ffz ffz) {
            AppMethodBeat.i(260778);
            kotlin.g.b.p.h(ffz, "resp");
            com.tencent.mm.ac.d.h(new C1194a(this, i3, i2, str));
            AppMethodBeat.o(260778);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.live.view.a$q$a  reason: collision with other inner class name */
        static final class C1194a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $errType;
            final /* synthetic */ q UNr;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1194a(q qVar, int i2, int i3, String str) {
                super(0);
                this.UNr = qVar;
                this.$errCode = i2;
                this.$errType = i3;
                this.$errMsg = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin;
                AppMethodBeat.i(260777);
                Log.i(this.UNr.uxE.getTAG(), "postCloseLinkPkMsg errCode:" + this.$errCode + ", errType:" + this.$errType + ", errMsg:" + this.$errMsg);
                if (this.$errCode == 0 && this.$errType == 0) {
                    if (this.UNr.uxE.getLiveData().djr() && (linkStatePlugin = this.UNr.uxE.getLinkStatePlugin()) != null) {
                        linkStatePlugin.dgX();
                    }
                    ac acVar = ac.vYp;
                    ac.dDo();
                    this.UNr.uxE.getLiveData().uEC = 0;
                    this.UNr.uxE.getLiveData().uEB = null;
                    this.UNr.uxE.notifyPKMicUserChange();
                    com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin = this.UNr.uxE.getBottomOptionPlugin();
                    if (bottomOptionPlugin != null) {
                        bottomOptionPlugin.dgP();
                    }
                    com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.model.o.hTf();
                    if (this.UNr.uxE.getLiveCore() instanceof com.tencent.mm.live.core.core.a.b) {
                        com.tencent.mm.live.core.core.trtc.a liveCore = this.UNr.uxE.getLiveCore();
                        if (liveCore == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                            AppMethodBeat.o(260777);
                            throw tVar;
                        }
                        ((com.tencent.mm.live.core.core.a.b) liveCore).aFT();
                    }
                    this.UNr.uxE.notifyPKMicUserChange();
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.x.STOP_LINKMIC_WHEN_WAITING_CONNECT, "", -1, -1);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(260777);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void applyState(int i2, int i3, Bundle bundle) {
        ViewGroup viewGroup;
        AppMethodBeat.i(247368);
        if (getLiveData().djl()) {
            hideLoadingLayer();
            t finderLiveBeforePlugin = getFinderLiveBeforePlugin();
            if (finderLiveBeforePlugin != null) {
                finderLiveBeforePlugin.rg(8);
            }
            as shadowPlugin = getShadowPlugin();
            if (shadowPlugin != null) {
                shadowPlugin.rg(8);
            }
            bh titleInfoPlugin = getTitleInfoPlugin();
            if (titleInfoPlugin != null) {
                titleInfoPlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.y commonInfoPlugin = getCommonInfoPlugin();
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
            com.tencent.mm.plugin.finder.live.plugin.k cameraOptPlugin = getCameraOptPlugin();
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
            com.tencent.mm.plugin.finder.live.plugin.n exceptionPlugin = getExceptionPlugin();
            if (exceptionPlugin != null) {
                exceptionPlugin.rg(8);
            }
            cc profilePlugin = getProfilePlugin();
            if (profilePlugin != null) {
                profilePlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.ac giftPlayPlugin = getGiftPlayPlugin();
            if (giftPlayPlugin != null) {
                giftPlayPlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.ae giftQueuePlugin = getGiftQueuePlugin();
            if (giftQueuePlugin != null) {
                giftQueuePlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.e finderLiveAfterPlugin = getFinderLiveAfterPlugin();
            if (finderLiveAfterPlugin != null) {
                c cVar = new c(this);
                if (finderLiveAfterPlugin.umn) {
                    finderLiveAfterPlugin.hwr.setAlpha(0.0f);
                    finderLiveAfterPlugin.rg(0);
                    finderLiveAfterPlugin.hNZ.setVisibility(8);
                    finderLiveAfterPlugin.hPX.setVisibility(0);
                    finderLiveAfterPlugin.hwr.animate().alpha(1.0f).setDuration(300).withEndAction(new com.tencent.mm.plugin.finder.live.plugin.g(cVar)).start();
                } else {
                    finderLiveAfterPlugin.rg(0);
                    finderLiveAfterPlugin.hNZ.setVisibility(0);
                    finderLiveAfterPlugin.hPX.setVisibility(8);
                    cVar.invoke();
                }
                if (!finderLiveAfterPlugin.getLiveData().uEJ || finderLiveAfterPlugin.getLiveData().djm()) {
                    finderLiveAfterPlugin.umi.setVisibility(8);
                    finderLiveAfterPlugin.uml.setVisibility(8);
                    finderLiveAfterPlugin.umm.setWeightSum(3.0f);
                } else {
                    finderLiveAfterPlugin.umi.setVisibility(0);
                    finderLiveAfterPlugin.uml.setVisibility(0);
                    finderLiveAfterPlugin.umm.setWeightSum(4.0f);
                }
                if (finderLiveAfterPlugin.hOy.getLiveRole() == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.e.ENTER_LIVE_CLOSE_UI, "");
                }
            }
            bj topCommentPlugin = getTopCommentPlugin();
            if (topCommentPlugin != null) {
                topCommentPlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.j cameraOptPanelPlugin = getCameraOptPanelPlugin();
            if (cameraOptPanelPlugin != null) {
                cameraOptPanelPlugin.rg(8);
            }
            al lotteryBubblePlugin = getLotteryBubblePlugin();
            if (lotteryBubblePlugin != null) {
                lotteryBubblePlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.q lotteryCardPlugin = getLotteryCardPlugin();
            if (lotteryCardPlugin != null) {
                lotteryCardPlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin = getLinkStatePlugin();
            if (linkStatePlugin != null) {
                linkStatePlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.o linkApplyListPlugin = getLinkApplyListPlugin();
            if (linkApplyListPlugin != null) {
                linkApplyListPlugin.rg(8);
            }
            cb micDecoratePlugin = getMicDecoratePlugin();
            if (micDecoratePlugin != null) {
                micDecoratePlugin.rg(8);
            }
            bl micAudioPreviewPlugin = getMicAudioPreviewPlugin();
            if (micAudioPreviewPlugin != null) {
                micAudioPreviewPlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin = getBottomOptionPlugin();
            if (bottomOptionPlugin != null) {
                bottomOptionPlugin.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.as luckyMoneyPlugin = getLuckyMoneyPlugin();
            if (luckyMoneyPlugin != null) {
                luckyMoneyPlugin.rg(8);
                AppMethodBeat.o(247368);
                return;
            }
            AppMethodBeat.o(247368);
        } else if (getLiveData().isLiveStarted()) {
            if (!getLiveData().hTY()) {
                hideLoadingLayer();
            }
            bh titleInfoPlugin2 = getTitleInfoPlugin();
            if (titleInfoPlugin2 != null) {
                bh.a(titleInfoPlugin2);
            }
            com.tencent.mm.plugin.finder.live.plugin.r previewPlugin = getPreviewPlugin();
            if (previewPlugin != null) {
                previewPlugin.rg(0);
            }
            t finderLiveBeforePlugin2 = getFinderLiveBeforePlugin();
            if (finderLiveBeforePlugin2 != null) {
                finderLiveBeforePlugin2.rg(8);
            }
            as shadowPlugin2 = getShadowPlugin();
            if (shadowPlugin2 != null) {
                shadowPlugin2.rg(0);
            }
            bh titleInfoPlugin3 = getTitleInfoPlugin();
            if (titleInfoPlugin3 != null) {
                titleInfoPlugin3.rg(0);
            }
            com.tencent.mm.plugin.finder.live.plugin.y commonInfoPlugin2 = getCommonInfoPlugin();
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
            com.tencent.mm.plugin.finder.live.plugin.k cameraOptPlugin2 = getCameraOptPlugin();
            if (cameraOptPlugin2 != null) {
                cameraOptPlugin2.rg(0);
            }
            com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin2 = getLinkStatePlugin();
            if (linkStatePlugin2 != null) {
                linkStatePlugin2.rg(0);
            }
            ay readyPlugin2 = getReadyPlugin();
            if (readyPlugin2 != null) {
                readyPlugin2.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.j cameraOptPanelPlugin2 = getCameraOptPanelPlugin();
            if (cameraOptPanelPlugin2 != null) {
                cameraOptPanelPlugin2.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.e finderLiveAfterPlugin2 = getFinderLiveAfterPlugin();
            if (finderLiveAfterPlugin2 != null) {
                finderLiveAfterPlugin2.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.n exceptionPlugin2 = getExceptionPlugin();
            if (exceptionPlugin2 != null) {
                exceptionPlugin2.rg(8);
            }
            aj confettiPlugin2 = getConfettiPlugin();
            if (confettiPlugin2 != null) {
                confettiPlugin2.rg(0);
            }
            com.tencent.mm.plugin.finder.live.plugin.l closePlugin = getClosePlugin();
            if (closePlugin != null) {
                closePlugin.rg(0);
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
            com.tencent.mm.plugin.finder.live.plugin.y commonInfoPlugin3 = getCommonInfoPlugin();
            if (!(commonInfoPlugin3 == null || (viewGroup = commonInfoPlugin3.hwr) == null)) {
                viewGroup.post(new d(this));
            }
            com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin2 = getBottomOptionPlugin();
            if (bottomOptionPlugin2 != null) {
                bottomOptionPlugin2.dgN();
            }
            if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 32)) {
                String str = getLiveData().hwd;
                Context context = getContext();
                kotlin.g.b.p.g(context, "context");
                String string = context.getResources().getString(R.string.cuk);
                kotlin.g.b.p.g(string, "context.resources.getStr…ng_exception_tip_network)");
                showTipWithBlurBg(str, string);
                com.tencent.mm.plugin.finder.live.plugin.k cameraOptPlugin3 = getCameraOptPlugin();
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
                com.tencent.mm.plugin.finder.live.plugin.j cameraOptPanelPlugin3 = getCameraOptPanelPlugin();
                if (cameraOptPanelPlugin3 != null) {
                    cameraOptPanelPlugin3.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.q lotteryCardPlugin2 = getLotteryCardPlugin();
                if (lotteryCardPlugin2 != null) {
                    lotteryCardPlugin2.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin3 = getBottomOptionPlugin();
                if (bottomOptionPlugin3 != null) {
                    bottomOptionPlugin3.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin3 = getLinkStatePlugin();
                if (linkStatePlugin3 != null) {
                    linkStatePlugin3.rg(8);
                    AppMethodBeat.o(247368);
                    return;
                }
                AppMethodBeat.o(247368);
            } else if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 2)) {
                at moreActionPlugin3 = getMoreActionPlugin();
                if (moreActionPlugin3 != null) {
                    moreActionPlugin3.dhD();
                    AppMethodBeat.o(247368);
                    return;
                }
                AppMethodBeat.o(247368);
            } else if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 4)) {
                bf shoppingListPlugin3 = getShoppingListPlugin();
                if (shoppingListPlugin3 != null) {
                    bf.a(shoppingListPlugin3, bundle);
                    AppMethodBeat.o(247368);
                    return;
                }
                AppMethodBeat.o(247368);
            } else if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 8192)) {
                getLiveData().uDR = true;
                onScreenClear(getLiveData().uDR);
                com.tencent.mm.plugin.finder.live.plugin.j cameraOptPanelPlugin4 = getCameraOptPanelPlugin();
                if (cameraOptPanelPlugin4 != null) {
                    com.tencent.mm.ac.d.h(new j.d(cameraOptPanelPlugin4));
                }
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.c.CLICK_FAIRY_STICK, "");
                AppMethodBeat.o(247368);
            } else {
                super.applyState(i2, i3, bundle);
                AppMethodBeat.o(247368);
            }
        } else {
            if (getLiveData().djk()) {
                hideLoadingLayer();
                com.tencent.mm.plugin.finder.live.plugin.r previewPlugin2 = getPreviewPlugin();
                if (previewPlugin2 != null) {
                    previewPlugin2.rg(0);
                }
                t finderLiveBeforePlugin3 = getFinderLiveBeforePlugin();
                if (finderLiveBeforePlugin3 != null) {
                    finderLiveBeforePlugin3.rg(0);
                }
                as shadowPlugin3 = getShadowPlugin();
                if (shadowPlugin3 != null) {
                    shadowPlugin3.rg(8);
                }
                bh titleInfoPlugin4 = getTitleInfoPlugin();
                if (titleInfoPlugin4 != null) {
                    titleInfoPlugin4.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.y commonInfoPlugin4 = getCommonInfoPlugin();
                if (commonInfoPlugin4 != null) {
                    commonInfoPlugin4.rg(8);
                }
                v commentPlugin4 = getCommentPlugin();
                if (commentPlugin4 != null) {
                    commentPlugin4.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.l closePlugin2 = getClosePlugin();
                if (closePlugin2 != null) {
                    closePlugin2.rg(8);
                }
                ay readyPlugin3 = getReadyPlugin();
                if (readyPlugin3 != null) {
                    readyPlugin3.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.e finderLiveAfterPlugin3 = getFinderLiveAfterPlugin();
                if (finderLiveAfterPlugin3 != null) {
                    finderLiveAfterPlugin3.rg(8);
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
                com.tencent.mm.plugin.finder.live.plugin.n exceptionPlugin3 = getExceptionPlugin();
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
                com.tencent.mm.plugin.finder.live.plugin.k cameraOptPlugin4 = getCameraOptPlugin();
                if (cameraOptPlugin4 != null) {
                    cameraOptPlugin4.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.ac giftPlayPlugin2 = getGiftPlayPlugin();
                if (giftPlayPlugin2 != null) {
                    giftPlayPlugin2.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.ae giftQueuePlugin2 = getGiftQueuePlugin();
                if (giftQueuePlugin2 != null) {
                    giftQueuePlugin2.rg(8);
                }
                bj topCommentPlugin2 = getTopCommentPlugin();
                if (topCommentPlugin2 != null) {
                    topCommentPlugin2.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.j cameraOptPanelPlugin5 = getCameraOptPanelPlugin();
                if (cameraOptPanelPlugin5 != null) {
                    cameraOptPanelPlugin5.rg(8);
                }
                al lotteryBubblePlugin2 = getLotteryBubblePlugin();
                if (lotteryBubblePlugin2 != null) {
                    lotteryBubblePlugin2.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.q lotteryCardPlugin3 = getLotteryCardPlugin();
                if (lotteryCardPlugin3 != null) {
                    lotteryCardPlugin3.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin4 = getLinkStatePlugin();
                if (linkStatePlugin4 != null) {
                    linkStatePlugin4.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.o linkApplyListPlugin2 = getLinkApplyListPlugin();
                if (linkApplyListPlugin2 != null) {
                    linkApplyListPlugin2.rg(8);
                }
                cb micDecoratePlugin2 = getMicDecoratePlugin();
                if (micDecoratePlugin2 != null) {
                    micDecoratePlugin2.rg(8);
                }
                bl micAudioPreviewPlugin2 = getMicAudioPreviewPlugin();
                if (micAudioPreviewPlugin2 != null) {
                    micAudioPreviewPlugin2.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin4 = getBottomOptionPlugin();
                if (bottomOptionPlugin4 != null) {
                    bottomOptionPlugin4.rg(8);
                }
                com.tencent.mm.plugin.finder.live.plugin.as luckyMoneyPlugin2 = getLuckyMoneyPlugin();
                if (luckyMoneyPlugin2 != null) {
                    luckyMoneyPlugin2.rg(8);
                }
                if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 4)) {
                    bf shoppingListPlugin5 = getShoppingListPlugin();
                    if (shoppingListPlugin5 != null) {
                        bf.a(shoppingListPlugin5, bundle);
                        AppMethodBeat.o(247368);
                        return;
                    }
                    AppMethodBeat.o(247368);
                    return;
                }
                super.applyState(i2, i3, bundle);
            }
            AppMethodBeat.o(247368);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ a uxE;

        d(a aVar) {
            this.uxE = aVar;
        }

        public final void run() {
            ViewGroup viewGroup;
            AppMethodBeat.i(247326);
            com.tencent.mm.plugin.finder.live.plugin.y commonInfoPlugin = this.uxE.getCommonInfoPlugin();
            if (commonInfoPlugin == null || (viewGroup = commonInfoPlugin.hwr) == null) {
                AppMethodBeat.o(247326);
                return;
            }
            bj topCommentPlugin = this.uxE.getTopCommentPlugin();
            if (topCommentPlugin != null) {
                topCommentPlugin.dY(viewGroup);
                AppMethodBeat.o(247326);
                return;
            }
            AppMethodBeat.o(247326);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.plugin.finder.live.view.e, com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.c.b
    public final void statusChange(b.c cVar, Bundle bundle) {
        ArrayList arrayList;
        avn avn;
        int i2;
        TRTCCloudDef.TRTCParams tRTCParams;
        FinderContact finderContact;
        String str;
        T t;
        T t2;
        String string;
        byte[] byteArray;
        String str2;
        String str3;
        String str4;
        String str5;
        String string2;
        String string3;
        Long l2;
        String str6;
        String str7;
        String str8;
        FinderObject finderObject;
        AppMethodBeat.i(247369);
        kotlin.g.b.p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (b.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                t finderLiveBeforePlugin = getFinderLiveBeforePlugin();
                if (finderLiveBeforePlugin != null) {
                    finderLiveBeforePlugin.rg(8);
                    x xVar = x.SXb;
                    AppMethodBeat.o(247369);
                    return;
                }
                AppMethodBeat.o(247369);
                return;
            case 2:
                Boolean valueOf = bundle != null ? Boolean.valueOf(bundle.getBoolean("PARAM_FINDER_LIVE_POST_AFTER_FACE_VERIFY", false)) : null;
                Log.i(getTAG(), "createLive afterFaceVerify:".concat(String.valueOf(valueOf)));
                if (kotlin.g.b.p.j(valueOf, Boolean.TRUE)) {
                    dis();
                    AppMethodBeat.o(247369);
                    return;
                }
                byte[] byteArray2 = bundle != null ? bundle.getByteArray("PARAM_KEY_POST_OBJECT_DESC") : null;
                if (byteArray2 != null) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
                    FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
                    finderObjectDesc.parseFrom(byteArray2);
                    x xVar2 = x.SXb;
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
                    x xVar3 = x.SXb;
                    AppMethodBeat.o(247369);
                    return;
                }
                AppMethodBeat.o(247369);
                return;
            case 3:
                joinLive();
                AppMethodBeat.o(247369);
                return;
            case 4:
                Log.i(getTAG(), "start live failed");
                if (!getLiveData().djl()) {
                    ay readyPlugin = getReadyPlugin();
                    if (readyPlugin != null) {
                        readyPlugin.rg(8);
                        x xVar4 = x.SXb;
                    }
                    com.tencent.mm.plugin.finder.live.plugin.r previewPlugin = getPreviewPlugin();
                    if (previewPlugin != null) {
                        previewPlugin.rg(8);
                        x xVar5 = x.SXb;
                    }
                    t finderLiveBeforePlugin2 = getFinderLiveBeforePlugin();
                    if (finderLiveBeforePlugin2 != null) {
                        finderLiveBeforePlugin2.rg(8);
                        x xVar6 = x.SXb;
                    }
                    String str9 = getLiveData().hwd;
                    Context context = getContext();
                    kotlin.g.b.p.g(context, "context");
                    String string4 = context.getResources().getString(R.string.egq);
                    kotlin.g.b.p.g(string4, "context.resources.getStr…_local_network_error_tip)");
                    showTipWithBlurBg(str9, string4);
                }
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_BTN_CLICK.hlf, String.valueOf(s.ap.LIVE_START_NETWORK_ERROR.type));
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.setErrorCode(bundle != null ? bundle.getInt("live_user_exit_reason", 0) : 0);
                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.b(s.o.LIVE_EXIT_ERROR);
                AppMethodBeat.o(247369);
                return;
            case 5:
                Log.i(getTAG(), "start live success");
                com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                if (!com.tencent.mm.plugin.finder.report.live.k.dpl().vml) {
                    com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_BEGIN, "");
                    AppMethodBeat.o(247369);
                    return;
                }
                break;
            case 6:
                boolean z = bundle != null ? bundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW") : false;
                String tag = getTAG();
                StringBuilder sb = new StringBuilder("checkFinderObject id:");
                FinderObject finderObject2 = getLiveData().uDz;
                if (finderObject2 != null) {
                    l2 = Long.valueOf(finderObject2.id);
                } else {
                    l2 = null;
                }
                Log.i(tag, sb.append(l2).append(", nonceId:").append(getLiveData().hwg).toString());
                if ((getLiveData().uDz == null || ((finderObject = getLiveData().uDz) != null && finderObject.id == 0)) && !Util.isNullOrNil(getLiveData().hwg)) {
                    new com.tencent.mm.plugin.finder.cgi.af(getLiveData().hFK, getLiveData().hwg, 0, 2, "", true, null, null, 0, null, false, false, null, null, 0, 24512).aYI().b(new e(this));
                }
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.o.EK(getLiveData().liveInfo.liveId);
                getLiveCore().aBY();
                al lotteryBubblePlugin = getLotteryBubblePlugin();
                if (lotteryBubblePlugin != null) {
                    lotteryBubblePlugin.dhu();
                    x xVar7 = x.SXb;
                }
                com.tencent.mm.plugin.finder.live.plugin.as luckyMoneyPlugin = getLuckyMoneyPlugin();
                if (luckyMoneyPlugin != null) {
                    luckyMoneyPlugin.hTC();
                    x xVar8 = x.SXb;
                }
                startTimer();
                prepareShopping();
                if (getLiveData().uDO != null) {
                    Bundle bundle2 = new Bundle();
                    com.tencent.mm.plugin.finder.live.viewmodel.h hVar = getLiveData().uDO;
                    if (hVar == null || (str6 = hVar.hwj) == null) {
                        str6 = "";
                    }
                    bundle2.putString("PARAM_FINDER_LIVE_LINK_AVATAR", str6);
                    com.tencent.mm.plugin.finder.live.viewmodel.h hVar2 = getLiveData().uDO;
                    if (hVar2 == null || (str7 = hVar2.hwi) == null) {
                        str7 = "";
                    }
                    bundle2.putString("PARAM_FINDER_LIVE_LINK_NICKNAME", str7);
                    com.tencent.mm.plugin.finder.live.viewmodel.h hVar3 = getLiveData().uDO;
                    if (hVar3 == null || (str8 = hVar3.hwh) == null) {
                        str8 = "";
                    }
                    bundle2.putString("PARAM_FINDER_LIVE_LINK_USERNAME", str8);
                    x xVar9 = x.SXb;
                    statusChange(b.c.hMQ, bundle2);
                    statusChange(b.c.hMX, bundle2);
                }
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.VQ().putInt("live_status_flag", 1);
                Log.i(getTAG(), "START_LIVE byMiniWin:".concat(String.valueOf(z)));
                AppMethodBeat.o(247369);
                return;
            case 7:
                com.tencent.mm.plugin.finder.live.plugin.e finderLiveAfterPlugin = getFinderLiveAfterPlugin();
                if (finderLiveAfterPlugin != null) {
                    finderLiveAfterPlugin.dgL();
                    x xVar10 = x.SXb;
                }
                boolean z2 = bundle != null ? bundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL") : false;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    finderLiveAssistant.a(z2, new o(this));
                    x xVar11 = x.SXb;
                }
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant2 = getFinderLiveAssistant();
                if (finderLiveAssistant2 != null) {
                    finderLiveAssistant2.dfk();
                    x xVar12 = x.SXb;
                }
                com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.VQ().putInt("live_status_flag", 0);
                com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.o.aHh();
                aJm();
                Log.i(getTAG(), "finish live is manual finish:".concat(String.valueOf(z2)));
                AppMethodBeat.o(247369);
                return;
            case 8:
                getLiveCore().aBW();
                finish();
                AppMethodBeat.o(247369);
                return;
            case 9:
                Boolean valueOf2 = bundle != null ? Boolean.valueOf(bundle.getBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true)) : null;
                int i3 = bundle != null ? bundle.getInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0) : 0;
                if (bundle != null) {
                    bundle.getInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 0);
                }
                if (!getLiveCore().hAz.isFloatMode()) {
                    com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
                    Context context2 = getContext();
                    kotlin.g.b.p.g(context2, "context");
                    b.a.a(liveCore, context2, valueOf2 != null ? valueOf2.booleanValue() : true, false, i3, 0, 16);
                }
                com.tencent.mm.plugin.finder.report.live.k kVar6 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtq++;
                AppMethodBeat.o(247369);
                return;
            case 10:
                AppMethodBeat.o(247369);
                return;
            case 11:
                if (bundle == null || (string3 = bundle.getString("PARAM_FINDER_LIVE_LINK_USERNAME", "")) == null) {
                    str3 = "";
                } else {
                    str3 = string3;
                }
                if (bundle == null || (string2 = bundle.getString("PARAM_FINDER_LIVE_LINK_NICKNAME", "")) == null) {
                    str4 = "";
                } else {
                    str4 = string2;
                }
                if (bundle == null || (str5 = bundle.getString("PARAM_FINDER_LIVE_LINK_AVATAR", "")) == null) {
                    str5 = "";
                }
                getLiveData().uDK = (int) (System.currentTimeMillis() / 1000);
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData2 = getLiveData();
                com.tencent.mm.plugin.finder.live.viewmodel.b bVar = new com.tencent.mm.plugin.finder.live.viewmodel.b(0, 0, null, null, null, null, 0, 0, null, null, null, 2047);
                bVar.finderUsername = str3;
                bVar.uCq = str4;
                bVar.kog = str5;
                x xVar13 = x.SXb;
                liveData2.uDE = bVar;
                getLiveCore().hAz.hzC = g.f.PK_WAITING;
                AppMethodBeat.o(247369);
                return;
            case 12:
                if (bundle == null || (str2 = bundle.getString("PARAM_FINDER_LIVE_LINK_USERNAME", "")) == null) {
                    str2 = "";
                }
                getLiveData().uDE = getLiveData().atW(str2);
                if (getLiveData().uDE == null) {
                    Log.w(getTAG(), "FINDER_LIVE_LINK_MIC_ACCEPT finderLinkUser is null");
                    AppMethodBeat.o(247369);
                    return;
                }
                break;
            case 13:
                getLiveData().uDK = 0;
                AppMethodBeat.o(247369);
                return;
            case 14:
                getLiveData().uDG.clear();
                AppMethodBeat.o(247369);
                return;
            case 15:
                FinderObject finderObject3 = getLiveData().uDz;
                if (finderObject3 != null) {
                    s.a aVar3 = com.tencent.mm.plugin.finder.utils.s.vWt;
                    Context context3 = getContext();
                    if (context3 == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(247369);
                        throw tVar;
                    }
                    FinderItem.a aVar4 = FinderItem.Companion;
                    s.a.a(aVar3, (MMActivity) context3, FinderItem.a.a(finderObject3, 16384), new m(this));
                    x xVar14 = x.SXb;
                    AppMethodBeat.o(247369);
                    return;
                }
                AppMethodBeat.o(247369);
                return;
            case 16:
                com.tencent.mm.plugin.finder.live.model.o oVar3 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.o.P(0, getLiveData().liveInfo.liveId);
                AppMethodBeat.o(247369);
                return;
            case 17:
                if (bundle == null || (byteArray = bundle.getByteArray("PARAM_FINDER_LIVE_TOP_COMMENT")) == null) {
                    AppMethodBeat.o(247369);
                    return;
                }
                awq awq = new awq();
                awq.parseFrom(byteArray);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(awq);
                bj topCommentPlugin = getTopCommentPlugin();
                if (topCommentPlugin != null) {
                    topCommentPlugin.ea(arrayList2);
                    x xVar15 = x.SXb;
                }
                com.tencent.mm.plugin.finder.report.live.k kVar7 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtB++;
                x xVar16 = x.SXb;
                AppMethodBeat.o(247369);
                return;
            case 18:
            case 19:
                if (bundle != null ? bundle.getBoolean("PARAM_LIVE_MINI_WINDOW_AUTO") : false) {
                    com.tencent.mm.plugin.finder.live.model.o oVar4 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.model.o.a(false, false, null, 7);
                    getLiveCore().aBW();
                    aJm();
                    getLiveData().reset();
                    AppMethodBeat.o(247369);
                    return;
                }
                break;
            case 20:
                com.tencent.mm.live.core.core.trtc.a liveCore2 = getLiveCore();
                if (liveCore2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                    AppMethodBeat.o(247369);
                    throw tVar2;
                }
                com.tencent.mm.plugin.finder.live.model.o oVar5 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                ((com.tencent.mm.live.core.core.a.b) liveCore2).ew(com.tencent.mm.plugin.finder.live.model.o.dgl());
                AppMethodBeat.o(247369);
                return;
            case 21:
                onScreenClear(bundle != null ? bundle.getBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR") : false);
                AppMethodBeat.o(247369);
                return;
            case 22:
                if (bundle == null || (string = bundle.getString("PARAM_FINDER_LIVE_MIC_ID")) == null) {
                    str = "";
                } else {
                    str = string;
                }
                kotlin.g.b.p.g(str, "param?.getString(ILiveSt…FINDER_LIVE_MIC_ID) ?: \"\"");
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = getLiveData().UPZ;
                if (list != null) {
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = list;
                    synchronized (list2) {
                        try {
                            Iterator<T> it = list2.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    T next = it.next();
                                    if (Util.isEqual(next.sessionId, str)) {
                                        t2 = next;
                                    }
                                } else {
                                    t2 = null;
                                }
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(247369);
                            throw th;
                        }
                    }
                    t = t2;
                } else {
                    t = null;
                }
                if (t != null) {
                    avn avn2 = new avn();
                    FinderContact finderContact2 = new FinderContact();
                    finderContact2.username = t.username;
                    finderContact2.nickname = t.nickname;
                    finderContact2.headUrl = t.headUrl;
                    x xVar17 = x.SXb;
                    avn2.contact = finderContact2;
                    x xVar18 = x.SXb;
                    com.tencent.mm.plugin.finder.live.model.a.b bVar2 = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                    com.tencent.mm.plugin.finder.live.model.a.b.bxE(t.sessionId);
                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant3 = getFinderLiveAssistant();
                    if (finderLiveAssistant3 != null) {
                        long j2 = getLiveData().liveInfo.liveId;
                        long j3 = getLiveData().hFK;
                        String str10 = getLiveData().hwg;
                        byte[] bArr = getLiveData().hIt;
                        o.m mVar3 = o.m.hHB;
                        int aFV = o.m.aFV();
                        int i4 = t.uCx;
                        String str11 = t.uCo;
                        String str12 = t.sessionId;
                        if (str12 == null) {
                            str12 = "";
                        }
                        finderLiveAssistant3.a(j2, j3, str10, bArr, aFV, avn2, i4, str11, str12, new n(t, avn2, this, str));
                        x xVar19 = x.SXb;
                        AppMethodBeat.o(247369);
                        return;
                    }
                    AppMethodBeat.o(247369);
                    return;
                }
                AppMethodBeat.o(247369);
                return;
            case 23:
                Log.i(getTAG(), "closeLinkMic curLinkUser:" + getLiveData().uEB + " liveData.audienceLinkMicUserList:" + getLiveData().UPZ);
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar = getLiveData().uEB;
                if (eVar == null || !eVar.UPN) {
                    String string5 = bundle != null ? bundle.getString("PARAM_FINDER_LIVE_MIC_ID") : null;
                    com.tencent.mm.plugin.finder.live.viewmodel.e bxQ = getLiveData().bxQ(string5);
                    Log.i(getTAG(), "micId:" + string5 + " micUser:" + bxQ);
                    if (bxQ != null) {
                        c(bxQ);
                        x xVar20 = x.SXb;
                        AppMethodBeat.o(247369);
                        return;
                    }
                    AppMethodBeat.o(247369);
                    return;
                }
                com.tencent.mm.plugin.finder.live.model.a.b bVar3 = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                com.tencent.mm.plugin.finder.live.model.a.b.hTq();
                hTG();
                AppMethodBeat.o(247369);
                return;
            case 24:
                cb micDecoratePlugin = getMicDecoratePlugin();
                if (micDecoratePlugin != null) {
                    micDecoratePlugin.hTD();
                    x xVar21 = x.SXb;
                }
                bl micAudioPreviewPlugin = getMicAudioPreviewPlugin();
                if (micAudioPreviewPlugin != null) {
                    micAudioPreviewPlugin.hTD();
                    x xVar22 = x.SXb;
                    AppMethodBeat.o(247369);
                    return;
                }
                AppMethodBeat.o(247369);
                return;
            case 25:
                cb micDecoratePlugin2 = getMicDecoratePlugin();
                if (micDecoratePlugin2 != null) {
                    micDecoratePlugin2.hTE();
                    x xVar23 = x.SXb;
                }
                bl micAudioPreviewPlugin2 = getMicAudioPreviewPlugin();
                if (micAudioPreviewPlugin2 != null) {
                    micAudioPreviewPlugin2.hTE();
                    x xVar24 = x.SXb;
                    AppMethodBeat.o(247369);
                    return;
                }
                AppMethodBeat.o(247369);
                return;
            case 26:
                com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin = getBottomOptionPlugin();
                if (bottomOptionPlugin != null) {
                    bottomOptionPlugin.dgO();
                    x xVar25 = x.SXb;
                    AppMethodBeat.o(247369);
                    return;
                }
                AppMethodBeat.o(247369);
                return;
            case 27:
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant4 = getFinderLiveAssistant();
                if (finderLiveAssistant4 != null) {
                    s.a.a(finderLiveAssistant4, getLiveData().liveInfo.liveId, getLiveData().hFK, getLiveData().uDA);
                    x xVar26 = x.SXb;
                }
                if (!(bundle != null ? bundle.getBoolean("PARAM_FINDER_LIVE_LINK_MIC_ENABLE") : true) && getLiveData().uEB != null) {
                    com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = getLiveData().uEB;
                    if (eVar2 == null || !eVar2.UPN) {
                        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list3 = getLiveData().UPZ;
                        kotlin.g.b.p.g(list3, "liveData.audienceLinkMicUserList");
                        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list4 = list3;
                        synchronized (list4) {
                            try {
                                Iterator<T> it2 = list4.iterator();
                                while (it2.hasNext()) {
                                    c(it2.next());
                                }
                                x xVar27 = x.SXb;
                            } catch (Throwable th2) {
                                AppMethodBeat.o(247369);
                                throw th2;
                            }
                        }
                        getLiveData().UPZ.clear();
                        AppMethodBeat.o(247369);
                        return;
                    }
                    com.tencent.mm.plugin.finder.live.model.a.b bVar4 = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                    com.tencent.mm.plugin.finder.live.model.a.b.hTq();
                    hTG();
                    AppMethodBeat.o(247369);
                    return;
                }
                break;
            case 28:
                com.tencent.mm.plugin.finder.live.plugin.ae giftQueuePlugin = getGiftQueuePlugin();
                if (giftQueuePlugin != null) {
                    giftQueuePlugin.dho();
                    x xVar28 = x.SXb;
                    AppMethodBeat.o(247369);
                    return;
                }
                AppMethodBeat.o(247369);
                return;
            case 29:
                byte[] byteArray3 = bundle != null ? bundle.getByteArray("PARAM_FINDER_LIVE_BYTES_DATA") : null;
                avn avn3 = new avn();
                try {
                    avn3.parseFrom(byteArray3);
                    avn = avn3;
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                    avn = null;
                }
                avn avn4 = avn;
                Log.i(getTAG(), "[LinkMicPk] apply anchor link mic pk. toContact:[" + ((avn4 == null || (finderContact = avn4.contact) == null) ? null : finderContact.nickname) + ']');
                if (avn4 != null) {
                    getLiveData().uEC = 2;
                    com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin = getLinkStatePlugin();
                    if (linkStatePlugin != null) {
                        linkStatePlugin.dgW();
                        x xVar29 = x.SXb;
                    }
                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant5 = getFinderLiveAssistant();
                    if (finderLiveAssistant5 != null) {
                        long j4 = getLiveData().liveInfo.liveId;
                        long j5 = getLiveData().hFK;
                        String str13 = getLiveData().hwg;
                        byte[] bArr2 = getLiveData().hIt;
                        o.m mVar4 = o.m.hHB;
                        int aFV2 = o.m.aFV();
                        String djq = getLiveData().djq();
                        com.tencent.mm.live.core.core.b.f fVar = getLiveData().hIy;
                        if (fVar == null || (tRTCParams = fVar.hzu) == null) {
                            i2 = 0;
                        } else {
                            i2 = tRTCParams.roomId;
                        }
                        finderLiveAssistant5.a(j4, j5, str13, bArr2, aFV2, avn4, djq, i2, new r(this, avn4));
                        x xVar30 = x.SXb;
                        AppMethodBeat.o(247369);
                        return;
                    }
                    AppMethodBeat.o(247369);
                    return;
                }
                AppMethodBeat.o(247369);
                return;
            case 30:
                Log.i(getTAG(), "[LinkMicPk] accept anchor link mic pk. curPkUser:" + getLiveData().uEB);
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar3 = getLiveData().uEB;
                if (eVar3 != null) {
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list5 = getLiveData().UPX;
                    kotlin.g.b.p.g(list5, "liveData.linkMicUserList");
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list6 = list5;
                    synchronized (list6) {
                        try {
                            ArrayList arrayList3 = new ArrayList();
                            for (T t3 : list6) {
                                if (Util.isEqual(t3.username, eVar3.username)) {
                                    arrayList3.add(t3);
                                }
                            }
                            arrayList = arrayList3;
                        } catch (Throwable th3) {
                            AppMethodBeat.o(247369);
                            throw th3;
                        }
                    }
                    if (arrayList.isEmpty()) {
                        Log.i(getTAG(), "[LinkMicPk] accept anchor link mic pk, but apply user has cancel. skip accept");
                        getLiveData().uEB = null;
                    } else {
                        avn avn5 = new avn();
                        FinderContact finderContact3 = new FinderContact();
                        finderContact3.username = eVar3.username;
                        finderContact3.nickname = eVar3.nickname;
                        finderContact3.headUrl = eVar3.headUrl;
                        x xVar31 = x.SXb;
                        avn5.contact = finderContact3;
                        x xVar32 = x.SXb;
                        getLiveData().uEC = 2;
                        com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin2 = getLinkStatePlugin();
                        if (linkStatePlugin2 != null) {
                            linkStatePlugin2.dgW();
                            x xVar33 = x.SXb;
                        }
                        com.tencent.mm.plugin.finder.live.model.a.b bVar5 = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                        com.tencent.mm.plugin.finder.live.model.a.b.hTo();
                        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant6 = getFinderLiveAssistant();
                        if (finderLiveAssistant6 != null) {
                            long j6 = getLiveData().liveInfo.liveId;
                            long j7 = getLiveData().hFK;
                            String str14 = getLiveData().hwg;
                            byte[] bArr3 = getLiveData().hIt;
                            o.m mVar5 = o.m.hHB;
                            finderLiveAssistant6.a(j6, j7, str14, bArr3, o.m.aFV(), avn5, eVar3.uCo, eVar3.hFB, eVar3.sessionId, new s(this));
                            x xVar34 = x.SXb;
                        }
                    }
                    x xVar35 = x.SXb;
                    AppMethodBeat.o(247369);
                    return;
                }
                AppMethodBeat.o(247369);
                return;
            case 31:
                hTJ();
                break;
        }
        AppMethodBeat.o(247369);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout$statusChange$6$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceResponse;", "plugin-finder_release"})
    public static final class n implements a.AbstractC1184a {
        final /* synthetic */ avn UNs;
        final /* synthetic */ String UNt;
        final /* synthetic */ a uxE;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.e uxL;

        n(com.tencent.mm.plugin.finder.live.viewmodel.e eVar, avn avn, a aVar, String str) {
            this.uxL = eVar;
            this.UNs = avn;
            this.uxE = aVar;
            this.UNt = str;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.a.AbstractC1184a
        public final void a(int i2, int i3, String str, aur aur) {
            AppMethodBeat.i(247345);
            kotlin.g.b.p.h(aur, "resp");
            Log.i(this.uxE.getTAG(), "acceptLinkMic " + this.uxL.nickname + ' ' + this.uxL.uCo + " errCode:" + i3 + " errType:" + i2 + " errMsg:" + str);
            if (i3 == 0 && i2 == 0) {
                ac acVar = ac.vYp;
                ac.dDl();
                if (this.uxL.uCx == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.x.CONNECT_VOICE_TO_LINKMIC, "", -1, -1);
                } else {
                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.x.CONNECT_VIDEO_TO_LINKMIC, "", -1, -1);
                }
                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                s.x xVar = s.x.LINKMIC_CONNECT_SUCCESS;
                FinderContact finderContact = this.UNs.contact;
                com.tencent.mm.plugin.finder.report.live.k.a(xVar, finderContact != null ? finderContact.username : null, s.bf.ANCHOR_VISITOR.type, s.be.PASSIVE.type);
                this.uxL.hTR();
                com.tencent.mm.plugin.finder.live.plugin.r previewPlugin = this.uxE.getPreviewPlugin();
                if (previewPlugin != null) {
                    previewPlugin.bxG(this.uxL.uCo);
                }
                this.uxE.notifyAudienceMicUserChange();
                this.uxE.getLiveData().UPY.clear();
                com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin = this.uxE.getBottomOptionPlugin();
                if (bottomOptionPlugin != null) {
                    bottomOptionPlugin.dgP();
                }
            } else {
                ac acVar2 = ac.vYp;
                ac.dDn();
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = this.uxE.getLiveData().UPZ;
                kotlin.g.b.p.g(list, "liveData.audienceLinkMicUserList");
                com.tencent.mm.ac.d.a(list, new kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean>(this) {
                    /* class com.tencent.mm.plugin.finder.live.view.a.n.AnonymousClass1 */
                    final /* synthetic */ n UNu;

                    {
                        this.UNu = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
                        AppMethodBeat.i(260779);
                        Boolean valueOf = Boolean.valueOf(Util.isEqual(eVar.sessionId, this.UNu.UNt));
                        AppMethodBeat.o(260779);
                        return valueOf;
                    }
                });
            }
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.view.a.n.AnonymousClass2 */
                final /* synthetic */ n UNu;

                {
                    this.UNu = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(260780);
                    com.tencent.mm.plugin.finder.live.plugin.o linkApplyListPlugin = this.UNu.uxE.getLinkApplyListPlugin();
                    if (linkApplyListPlugin != null) {
                        linkApplyListPlugin.aQG();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(260780);
                    return xVar;
                }
            });
            AppMethodBeat.o(247345);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout$statusChange$9$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "plugin-finder_release"})
    public static final class r implements ae.a {
        final /* synthetic */ avn UNv;
        final /* synthetic */ a uxE;

        r(a aVar, avn avn) {
            this.uxE = aVar;
            this.UNv = avn;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.ae.a
        public final void a(int i2, int i3, String str, ffx ffx) {
            AppMethodBeat.i(260781);
            kotlin.g.b.p.h(ffx, "resp");
            a.a(this.uxE, i2, i3, str, ffx, this.UNv);
            AppMethodBeat.o(260781);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout$statusChange$10$2", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderAcceptLiveMicResponse;", "plugin-finder_release"})
    public static final class s implements ac.a {
        final /* synthetic */ a uxE;

        s(a aVar) {
            this.uxE = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.ac.a
        public final void a(int i2, int i3, String str, fft fft) {
            AppMethodBeat.i(260782);
            kotlin.g.b.p.h(fft, "resp");
            a.a(this.uxE, i2, i3, str);
            AppMethodBeat.o(260782);
        }
    }

    @Override // com.tencent.mm.live.b.j, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onCloseLiveMic(com.tencent.mm.live.b.f fVar) {
        com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin;
        AppMethodBeat.i(247370);
        kotlin.g.b.p.h(fVar, "info");
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = getLiveData().uEB;
        if (eVar == null || !Util.isEqual(eVar.sessionId, fVar.hFz)) {
            Log.i(getTAG(), "close mic. info:" + fVar + " linkState:" + getLiveData().uEC + " liveData.audienceLinkMicUserList:" + getLiveData().UPZ);
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = getLiveData().UPZ;
            kotlin.g.b.p.g(list, "liveData.audienceLinkMicUserList");
            com.tencent.mm.ac.d.a(list, new l(fVar));
            notifyAudienceMicUserChange();
            com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin = getBottomOptionPlugin();
            if (bottomOptionPlugin != null) {
                bottomOptionPlugin.dgP();
            }
        } else {
            Log.i(getTAG(), "close mic pk. curLinkUser:" + eVar + " linkState:" + getLiveData().uEC);
            if (eVar.UPN) {
                if (getLiveCore() == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                    AppMethodBeat.o(247370);
                    throw tVar;
                }
                com.tencent.mm.live.core.core.a.b.aFU();
                if (getLiveCore() instanceof com.tencent.mm.live.core.core.a.b) {
                    com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
                    if (liveCore == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                        AppMethodBeat.o(247370);
                        throw tVar2;
                    }
                    ((com.tencent.mm.live.core.core.a.b) liveCore).aFT();
                }
                if (getLiveData().djr() && (linkStatePlugin = getLinkStatePlugin()) != null) {
                    linkStatePlugin.dgX();
                }
                getLiveData().uEC = 0;
                getLiveData().uEB = null;
                notifyPKMicUserChange();
                com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin2 = getBottomOptionPlugin();
                if (bottomOptionPlugin2 != null) {
                    bottomOptionPlugin2.dgP();
                }
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.x.STOP_LINKMIC_WHEN_SHOW_CONNECTING, "", -1, -1);
            }
        }
        Log.i(getTAG(), "onCloseLiveMic liveData.curLinkMicUser:" + eVar + " info:" + fVar);
        AppMethodBeat.o(247370);
    }

    @Override // com.tencent.mm.live.b.j, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onAcceptLiveMic(com.tencent.mm.live.b.a aVar) {
        AppMethodBeat.i(260786);
        kotlin.g.b.p.h(aVar, "info");
        getLiveData();
        if (aVar.vae && (getLiveCore() instanceof com.tencent.mm.live.core.core.a.b)) {
            com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
            if (liveCore == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                AppMethodBeat.o(260786);
                throw tVar;
            }
            com.tencent.mm.live.core.core.a.b bVar = (com.tencent.mm.live.core.core.a.b) liveCore;
            String valueOf = String.valueOf(aVar.hFB);
            String str = aVar.userId;
            if (str == null) {
                str = "";
            }
            String str2 = aVar.uCp;
            if (str2 == null) {
                str2 = "";
            }
            bVar.bE(valueOf, str, str2);
        }
        AppMethodBeat.o(260786);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.a.a, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onAcceptMicTimeout(String str) {
        AppMethodBeat.i(260787);
        Log.i(getTAG(), "accept mic timeout, will auto cancel. curLinkUser:" + getLiveData().uEB + " micId:" + str);
        if (getLiveData().bxP(str)) {
            c(getLiveData().bxQ(str));
        }
        AppMethodBeat.o(260787);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.a.a, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onApplyMicPkTimeout() {
        AppMethodBeat.i(260788);
        Log.i(getTAG(), "apply pk mic timeout, will auto cancel. curLinkUser:" + getLiveData().uEB + ", curLinkState:" + getLiveData().uEC);
        if (getLiveData().uEC == 2) {
            com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin = getLinkStatePlugin();
            if (linkStatePlugin != null) {
                linkStatePlugin.dgX();
            }
            hTG();
        }
        AppMethodBeat.o(260788);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.a.a, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onAcceptMicPkTimeout() {
        AppMethodBeat.i(260789);
        Log.i(getTAG(), "accept pk mic timeout, will auto cancel. curLinkUser:" + getLiveData().uEB + ", curLinkState:" + getLiveData().uEC);
        if (getLiveData().uEC == 2) {
            com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin = getLinkStatePlugin();
            if (linkStatePlugin != null) {
                linkStatePlugin.dgX();
            }
            hTG();
        }
        AppMethodBeat.o(260789);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(247371);
        Log.i(getTAG(), "onSceneEnd errType:" + i2 + ", errCode:" + i3 + ", scene:" + qVar);
        AppMethodBeat.o(247371);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onLiveEventCallback(int i2, Bundle bundle) {
        String str;
        String string;
        String str2;
        String string2;
        String str3;
        String string3;
        String str4;
        String string4;
        String str5 = null;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(247372);
        Log.i(getTAG(), "sdk callback errorCode:".concat(String.valueOf(i2)));
        com.tencent.mm.plugin.finder.utils.ae aeVar = com.tencent.mm.plugin.finder.utils.ae.vZW;
        com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
        String netTypeString = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        kotlin.g.b.p.g(netTypeString, "NetStatusUtil.getNetType…tionContext.getContext())");
        com.tencent.mm.plugin.finder.utils.ae.a(i2, liveData, netTypeString);
        e.d dVar = e.d.hxF;
        if (i2 == e.d.aCo()) {
            if (bundle == null || (string4 = bundle.getString("live_user_id")) == null) {
                str4 = "";
            } else {
                str4 = string4;
            }
            kotlin.g.b.p.g(str4, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
            com.tencent.mm.plugin.finder.live.viewmodel.e eVar = getLiveData().uEB;
            if (eVar != null && eVar.UPN) {
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = getLiveData().uEB;
                if (Util.isEqual(eVar2 != null ? eVar2.uCo : null, str4)) {
                    getLiveData().uEC = 4;
                    com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin = getLinkStatePlugin();
                    if (linkStatePlugin != null) {
                        linkStatePlugin.dgX();
                    }
                    notifyPKMicUserChange();
                    com.tencent.mm.plugin.finder.live.model.a.b bVar = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                    com.tencent.mm.plugin.finder.live.model.a.b.hTr();
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    s.x xVar = s.x.LINKMIC_CONNECT_SUCCESS;
                    com.tencent.mm.plugin.finder.live.viewmodel.e eVar3 = getLiveData().uEB;
                    if (eVar3 != null) {
                        str5 = eVar3.username;
                    }
                    com.tencent.mm.plugin.finder.report.live.k.a(xVar, str5, s.bf.ANCHOR_ANCHOR.type, s.be.INITIATIVE.type);
                }
            }
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = getLiveData().UPZ;
            kotlin.g.b.p.g(list, "liveData.audienceLinkMicUserList");
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = list;
            synchronized (list2) {
                try {
                    for (T t : list2) {
                        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                        if (com.tencent.mm.plugin.finder.utils.m.h(t) && Util.isEqual(t.uCo, str4)) {
                            t.hTR();
                            com.tencent.mm.plugin.finder.live.model.a.b bVar2 = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                            com.tencent.mm.plugin.finder.live.model.a.b.bxF(t.sessionId);
                        }
                    }
                    x xVar2 = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(247372);
                    throw th;
                }
            }
            notifyAudienceMicUserChange();
            Log.i(getTAG(), "USER_VIDEO_AVAILABLE curLinkState:" + getLiveData().uEC + ", curLinkUser:" + getLiveData().uEB + ", userId:" + str4 + ", selfId:" + getLiveData().djq() + " audienceMicList:" + getLiveData().UPZ);
            AppMethodBeat.o(247372);
            return;
        }
        e.d dVar2 = e.d.hxF;
        if (i2 == e.d.aCt()) {
            if (bundle == null || (string3 = bundle.getString("live_user_id")) == null) {
                str3 = "";
            } else {
                str3 = string3;
            }
            kotlin.g.b.p.g(str3, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
            com.tencent.mm.plugin.finder.live.viewmodel.e eVar4 = getLiveData().uEB;
            if (eVar4 != null && eVar4.UPN) {
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vlM = true;
                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.x.DISCONNECT_VIDEO_TO_LINKMIC, "", -1, -1);
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar5 = getLiveData().uEB;
                if (eVar5 != null) {
                    str5 = eVar5.uCo;
                }
                if (Util.isEqual(str5, str3)) {
                    hTG();
                }
            }
            ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> arrayList = new ArrayList();
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list3 = getLiveData().UPZ;
            kotlin.g.b.p.g(list3, "liveData.audienceLinkMicUserList");
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list4 = list3;
            synchronized (list4) {
                try {
                    for (T t2 : list4) {
                        if (Util.isEqual(t2.uCo, str3)) {
                            arrayList.add(t2);
                        }
                    }
                    x xVar3 = x.SXb;
                } catch (Throwable th2) {
                    AppMethodBeat.o(247372);
                    throw th2;
                }
            }
            if (arrayList.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                for (com.tencent.mm.plugin.finder.live.viewmodel.e eVar6 : arrayList) {
                    c(eVar6);
                }
            }
            Log.i(getTAG(), "USER_VIDEO_DISABLE curLinkState:" + getLiveData().uEC + ", curLinkUser:" + getLiveData().uEB + ", userId:" + str3 + ", selfId:" + getLiveData().djq() + " audienceMicList:" + getLiveData().UPZ);
            AppMethodBeat.o(247372);
            return;
        }
        e.d dVar3 = e.d.hxF;
        if (i2 == e.d.aCp()) {
            if (bundle == null || (string2 = bundle.getString("live_user_id")) == null) {
                str2 = "";
            } else {
                str2 = string2;
            }
            kotlin.g.b.p.g(str2, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
            com.tencent.mm.plugin.finder.live.viewmodel.e eVar7 = getLiveData().uEB;
            if (eVar7 != null && eVar7.UPN) {
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar8 = getLiveData().uEB;
                if (eVar8 != null) {
                    str5 = eVar8.uCo;
                }
                if (Util.isEqual(str5, str2)) {
                    com.tencent.mm.plugin.finder.live.model.a.b bVar3 = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                    com.tencent.mm.plugin.finder.live.model.a.b.hTq();
                    hTG();
                }
            }
            ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> arrayList2 = new ArrayList();
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list5 = getLiveData().UPZ;
            kotlin.g.b.p.g(list5, "liveData.audienceLinkMicUserList");
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list6 = list5;
            synchronized (list6) {
                try {
                    for (T t3 : list6) {
                        if (Util.isEqual(t3.uCo, str2)) {
                            arrayList2.add(t3);
                        }
                    }
                    x xVar4 = x.SXb;
                } catch (Throwable th3) {
                    AppMethodBeat.o(247372);
                    throw th3;
                }
            }
            if (arrayList2.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                for (com.tencent.mm.plugin.finder.live.viewmodel.e eVar9 : arrayList2) {
                    c(eVar9);
                }
            }
            Log.i(getTAG(), "EVENT_ROOM_USER_EXIT userId:" + str2 + " linkState:" + getLiveData().uEC + " curLinkMic:" + getLiveData().uEB + " audienceMicList:" + getLiveData().UPZ);
            AppMethodBeat.o(247372);
            return;
        }
        e.d dVar4 = e.d.hxF;
        if (i2 == e.d.aCq()) {
            if (bundle == null || (string = bundle.getString("live_user_id")) == null) {
                str = "";
            } else {
                str = string;
            }
            kotlin.g.b.p.g(str, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
            boolean z3 = bundle != null ? bundle.getBoolean("live_media_enable") : false;
            com.tencent.mm.plugin.finder.live.viewmodel.e eVar10 = getLiveData().uEB;
            if (eVar10 != null && eVar10.UPN) {
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar11 = getLiveData().uEB;
                if (eVar11 != null) {
                    str5 = eVar11.uCo;
                }
                if (Util.isEqual(str5, str) && !z3) {
                    com.tencent.mm.plugin.finder.live.model.a.b bVar4 = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                    com.tencent.mm.plugin.finder.live.model.a.b.hTq();
                    hTG();
                }
            }
            if (z3) {
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list7 = getLiveData().UPZ;
                kotlin.g.b.p.g(list7, "liveData.audienceLinkMicUserList");
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list8 = list7;
                synchronized (list8) {
                    try {
                        for (T t4 : list8) {
                            com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                            if (com.tencent.mm.plugin.finder.utils.m.i((com.tencent.mm.plugin.finder.live.viewmodel.e) t4) && Util.isEqual(t4.uCo, str)) {
                                t4.hTR();
                                com.tencent.mm.plugin.finder.live.model.a.b bVar5 = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                                com.tencent.mm.plugin.finder.live.model.a.b.bxF(t4.sessionId);
                                com.tencent.mm.plugin.finder.utils.ac acVar = com.tencent.mm.plugin.finder.utils.ac.vYp;
                                com.tencent.mm.plugin.finder.utils.ac.dDm();
                            }
                        }
                        x xVar5 = x.SXb;
                    } catch (Throwable th4) {
                        AppMethodBeat.o(247372);
                        throw th4;
                    }
                }
                notifyAudienceMicUserChange();
            } else {
                ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> arrayList3 = new ArrayList();
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list9 = getLiveData().UPZ;
                kotlin.g.b.p.g(list9, "liveData.audienceLinkMicUserList");
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list10 = list9;
                synchronized (list10) {
                    try {
                        for (T t5 : list10) {
                            if (Util.isEqual(t5.uCo, str)) {
                                arrayList3.add(t5);
                            }
                        }
                        x xVar6 = x.SXb;
                    } catch (Throwable th5) {
                        AppMethodBeat.o(247372);
                        throw th5;
                    }
                }
                if (!arrayList3.isEmpty()) {
                    z = true;
                }
                if (z) {
                    for (com.tencent.mm.plugin.finder.live.viewmodel.e eVar12 : arrayList3) {
                        c(eVar12);
                    }
                }
            }
            Log.i(getTAG(), "EVENT_ROOM_USER_AUDIO_STATE linkState:" + getLiveData().uEC + " curLinkMic:" + getLiveData().uEB + " audienceMicList:" + getLiveData().UPZ + " userId:" + str + " enable:" + z3);
            AppMethodBeat.o(247372);
            return;
        }
        e.d dVar5 = e.d.hxF;
        if (i2 == e.d.aCu()) {
            joinLive();
            AppMethodBeat.o(247372);
            return;
        }
        e.d dVar6 = e.d.hxF;
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
                        kotlin.g.b.p.g(context2, "context");
                        com.tencent.mm.ui.base.u.makeText(context, context2.getResources().getString(R.string.cul), 0).show();
                        AppMethodBeat.o(247372);
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
            kotlin.g.b.p.g(context22, "context");
            com.tencent.mm.ui.base.u.makeText(context3, context22.getResources().getString(R.string.cul), 0).show();
            AppMethodBeat.o(247372);
            return;
        }
        e.d dVar7 = e.d.hxF;
        if (i2 == e.d.aCz()) {
            statusChange(b.c.hNp, bundle);
        }
        AppMethodBeat.o(247372);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ a uxE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(a aVar) {
            super(0);
            this.uxE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260772);
            a aVar = this.uxE;
            Context context = this.uxE.getContext();
            if (context == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(260772);
                throw tVar;
            }
            aVar.goGetLuckMoney((MMActivity) context, this.uxE.getData().uCr.aFR());
            x xVar = x.SXb;
            AppMethodBeat.o(260772);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.live.view.a$a  reason: collision with other inner class name */
    static final class C1193a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ a uxE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1193a(a aVar) {
            super(0);
            this.uxE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260771);
            a aVar = this.uxE;
            Context context = this.uxE.getContext();
            if (context == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(260771);
                throw tVar;
            }
            aVar.goGetLuckMoney((MMActivity) context, this.uxE.getData().uCr.aFR());
            x xVar = x.SXb;
            AppMethodBeat.o(260771);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ a uxE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.uxE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247324);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.view.a.b.AnonymousClass1 */
                final /* synthetic */ b uxG;

                {
                    this.uxG = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(247323);
                    if (!this.uxG.uxE.getLiveData().djl()) {
                        b.C0376b.a(this.uxG.uxE, b.c.hLV);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(247323);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(247324);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void release() {
        AppMethodBeat.i(247373);
        Log.i(getTAG(), "release");
        checkMiniWindow();
        com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.aFh();
        com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
        com.tencent.mm.plugin.finder.live.model.q.dgC();
        this.timerThread.stopTimer();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3582, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(3917, this);
        com.tencent.mm.kernel.b aAg3 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg3, "MMKernel.network()");
        aAg3.azz().b(3861, this);
        com.tencent.mm.kernel.b aAg4 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg4, "MMKernel.network()");
        aAg4.azz().b(3603, this);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.o.a(false, getMiniWinPermission(), null, 5);
        if (!getLiveCore().hAz.isFloatMode() && !getMiniWinPermission()) {
            com.tencent.mm.live.b.s sVar = com.tencent.mm.live.b.s.hIl;
            com.tencent.mm.live.b.s.release();
            getLiveCore().aBW();
            aJm();
            getLiveData().reset();
        }
        AppMethodBeat.o(247373);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(247374);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1005:
                if (i3 == -1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.u uVar = com.tencent.mm.plugin.finder.report.live.k.dpl().vmj;
                    if (intent == null) {
                        uVar.vts++;
                        AppMethodBeat.o(247374);
                        return;
                    }
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
                    if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                        uVar.vts++;
                        AppMethodBeat.o(247374);
                        return;
                    }
                    uVar.vts += (long) stringArrayListExtra.size();
                    AppMethodBeat.o(247374);
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
        AppMethodBeat.o(247374);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ a uxE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(0);
            this.uxE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247325);
            com.tencent.mm.plugin.finder.live.plugin.r previewPlugin = this.uxE.getPreviewPlugin();
            if (previewPlugin != null) {
                previewPlugin.rg(8);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247325);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(a aVar, boolean z, int i2, int i3, String str, com.tencent.mm.live.core.core.b.e eVar, TRTCCloudDef.TRTCParams tRTCParams, auf auf) {
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant;
        Long valueOf;
        com.tencent.mm.live.core.core.b.e eVar2;
        long j2;
        long j3;
        com.tencent.mm.live.core.core.b.e eVar3;
        awe awe;
        AppMethodBeat.i(260790);
        if (z) {
            aVar.a(auf);
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            com.tencent.mm.plugin.finder.utils.m.a(auf, aVar.getConfettiPlugin(), aVar.getLiveData());
            aVar.getLiveData().UQm.Mpi.clear();
            aVar.getLiveData().UQm.Mpi.addAll(auf.Viw);
            aVar.getLiveData().UQm.UQM = auf.ViJ;
            com.tencent.mm.plugin.finder.live.plugin.r previewPlugin = aVar.getPreviewPlugin();
            if (previewPlugin != null) {
                String str2 = tRTCParams.userId;
                if (str2 == null) {
                    str2 = "";
                }
                kotlin.g.b.p.h(str2, "userId");
                previewPlugin.hAs.setSelfUserId(str2);
            }
            if (aVar.getLiveData().hIy == null) {
                aVar.getLiveData().hIy = new com.tencent.mm.live.core.core.b.f(tRTCParams, eVar, new com.tencent.mm.live.core.core.b.b("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI"));
            } else {
                com.tencent.mm.live.core.core.b.f fVar = aVar.getLiveData().hIy;
                if (fVar != null) {
                    kotlin.g.b.p.h(tRTCParams, "<set-?>");
                    fVar.hzu = tRTCParams;
                }
                com.tencent.mm.live.core.core.b.f fVar2 = aVar.getLiveData().hIy;
                if (fVar2 != null) {
                    kotlin.g.b.p.h(eVar, "<set-?>");
                    fVar2.hwP = eVar;
                }
                com.tencent.mm.live.core.core.b.f fVar3 = aVar.getLiveData().hIy;
                if (fVar3 != null) {
                    com.tencent.mm.live.core.core.b.b bVar = new com.tencent.mm.live.core.core.b.b("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
                    kotlin.g.b.p.h(bVar, "<set-?>");
                    fVar3.hzv = bVar;
                }
            }
            com.tencent.mm.live.core.core.b.f fVar4 = aVar.getLiveData().hIy;
            if (fVar4 != null) {
                aVar.getLiveCore().a(fVar4);
                com.tencent.mm.plugin.finder.utils.ac acVar = com.tencent.mm.plugin.finder.utils.ac.vYp;
                ad.a aVar2 = ad.vZu;
                com.tencent.mm.plugin.finder.utils.ac.a(acVar, ad.vZa.name, null, false, false, 14);
                aVar.getLiveCore().a(new g(aVar, auf));
            }
            b.C0376b.a(aVar, b.c.hNb);
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if (dfZ == null || (awe = dfZ.liveInfo) == null) {
                com.tencent.mm.live.core.core.b.f fVar5 = aVar.getLiveCore().hAy;
                valueOf = (fVar5 == null || (eVar2 = fVar5.hwP) == null) ? null : Long.valueOf(eVar2.liveId);
            } else {
                valueOf = Long.valueOf(awe.liveId);
            }
            long longValue = valueOf != null ? valueOf.longValue() : -1;
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.u uVar = com.tencent.mm.plugin.finder.report.live.k.dpl().vmj;
            String zs = com.tencent.mm.plugin.expt.hellhound.core.b.zs(longValue);
            kotlin.g.b.p.g(zs, "HellhoundUtil.long2UnsignedString(liveId)");
            kotlin.g.b.p.h(zs, "<set-?>");
            uVar.hJs = zs;
            com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if (dfZ2 != null) {
                j2 = dfZ2.hFK;
            } else {
                j2 = aVar.getLiveData().hFK;
            }
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.u uVar2 = com.tencent.mm.plugin.finder.report.live.k.dpl().vmj;
            String zs2 = com.tencent.mm.plugin.expt.hellhound.core.b.zs(j2);
            kotlin.g.b.p.g(zs2, "HellhoundUtil.long2UnsignedString(feedId)");
            kotlin.g.b.p.h(zs2, "<set-?>");
            uVar2.feedId = zs2;
            com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtj = System.currentTimeMillis();
            com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.u uVar3 = com.tencent.mm.plugin.finder.report.live.k.dpl().vmj;
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            uVar3.vtl = (long) aAh.azQ().getInt(ar.a.USERINFO_FINDER_FANS_COUNT_INT_SYNC, 0);
            JSONObject jSONObject = new JSONObject();
            com.tencent.mm.live.core.core.b.f fVar6 = aVar.getLiveCore().hAy;
            if (fVar6 == null || (eVar3 = fVar6.hwP) == null) {
                j3 = -1;
            } else {
                j3 = eVar3.liveId;
            }
            jSONObject.put("liveid", j3);
            jSONObject.put("feedid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(aVar.getLiveData().hFK));
            com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_SUCCESS.hlf, jSONObject.toString());
            com.tencent.mm.plugin.finder.report.live.k kVar6 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(s.o.LIVE_EXIT_OK);
            com.tencent.mm.plugin.finder.utils.ae aeVar = com.tencent.mm.plugin.finder.utils.ae.vZW;
            com.tencent.mm.plugin.finder.utils.ae.Gm(cl.aWy());
            com.tencent.mm.ac.d.a(200, new h(aVar));
            AppMethodBeat.o(260790);
            return;
        }
        com.tencent.mm.plugin.finder.utils.ac acVar2 = com.tencent.mm.plugin.finder.utils.ac.vYp;
        ad.a aVar3 = ad.vZu;
        String str3 = ad.vYZ.name;
        y yVar = y.vXH;
        cit cit = new cit();
        cit.errCode = i2;
        cit.errMsg = str;
        com.tencent.mm.plugin.finder.utils.ac.a(acVar2, str3, y.j(cit), false, true, 4);
        if (!(i2 == -100038 || (finderLiveAssistant = aVar.getFinderLiveAssistant()) == null)) {
            s.a.a(finderLiveAssistant, new k(aVar));
        }
        e.a(aVar, i3, i2, str);
        com.tencent.mm.plugin.finder.utils.ae aeVar2 = com.tencent.mm.plugin.finder.utils.ae.vZW;
        String dEd = com.tencent.mm.plugin.finder.utils.ae.dEd();
        if (str == null) {
            str = "";
        }
        com.tencent.mm.plugin.finder.utils.ae.a(dEd, i2, i3, str, aVar.getLiveData());
        AppMethodBeat.o(260790);
    }

    public static final /* synthetic */ void a(a aVar, awn awn) {
        LinkedList<awm> linkedList;
        com.tencent.mm.live.core.core.b.e eVar;
        com.tencent.mm.live.core.core.b.e eVar2;
        com.tencent.mm.live.core.core.b.e eVar3;
        String str;
        String str2;
        String str3;
        FinderContact finderContact;
        FinderContact finderContact2;
        FinderContact finderContact3;
        int i2;
        int i3;
        FinderContact finderContact4;
        FinderContact finderContact5;
        FinderContact finderContact6;
        avn avn;
        FinderContact finderContact7;
        avn avn2;
        FinderContact finderContact8;
        AppMethodBeat.i(260791);
        if (awn == null || (linkedList = awn.LHo) == null) {
            linkedList = new LinkedList<>();
        }
        fgx fgx = awn != null ? awn.Vjl : null;
        for (awm awm : linkedList) {
            Log.i(aVar.getTAG(), "checkLinkMicStateWhenJoin micUserList.size:" + linkedList.size() + " micInfo:[sessionId:" + (awm != null ? awm.KDS : null) + ", micSeq:" + (awm != null ? Long.valueOf(awm.LHk) : null) + ", micNickname:" + ((awm == null || (avn2 = awm.LFI) == null || (finderContact8 = avn2.contact) == null) ? null : finderContact8.nickname) + ']' + ", micPkInfo:[sessionId:" + (fgx != null ? fgx.KDS : null) + ", micPkseq:" + (fgx != null ? Long.valueOf(fgx.LHk) : null) + ", micPkNickname:" + ((fgx == null || (avn = fgx.LFI) == null || (finderContact7 = avn.contact) == null) ? null : finderContact7.nickname) + ']');
            if (awm != null) {
                String str4 = awm.KDS;
                if (!(str4 == null || str4.length() == 0)) {
                    String str5 = awm.Lmn;
                    avn avn3 = awm.LFI;
                    String str6 = (avn3 == null || (finderContact6 = avn3.contact) == null) ? null : finderContact6.headUrl;
                    avn avn4 = awm.LFI;
                    String str7 = (avn4 == null || (finderContact5 = avn4.contact) == null) ? null : finderContact5.username;
                    avn avn5 = awm.LFI;
                    String str8 = (avn5 == null || (finderContact4 = avn5.contact) == null) ? null : finderContact4.nickname;
                    int i4 = awm.LFG;
                    String str9 = awm.KDS;
                    if (awm.LFG == 2) {
                        i2 = 4;
                    } else {
                        i2 = 3;
                    }
                    avn avn6 = awm.LFI;
                    if (avn6 != null) {
                        i3 = avn6.LGj;
                    } else {
                        i3 = 0;
                    }
                    com.tencent.mm.plugin.finder.live.viewmodel.e eVar4 = new com.tencent.mm.plugin.finder.live.viewmodel.e(str5, str6, str7, str8, i4, str9, null, false, 0, null, null, i2, i3, Exif.PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN);
                    aVar.getLiveData().f(eVar4);
                    Log.i(aVar.getTAG(), "checkLinkMicStateWhenJoin has unfinished mic, will close. curLinkUser:".concat(String.valueOf(eVar4)));
                    aVar.c(eVar4);
                }
            }
        }
        if (fgx != null) {
            String str10 = fgx.KDS;
            if (!(str10 == null || str10.length() == 0)) {
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = aVar.getLiveData();
                String str11 = fgx.Lmn;
                avn avn7 = fgx.LFI;
                if (avn7 == null || (finderContact3 = avn7.contact) == null) {
                    str = null;
                } else {
                    str = finderContact3.headUrl;
                }
                avn avn8 = fgx.LFI;
                if (avn8 == null || (finderContact2 = avn8.contact) == null) {
                    str2 = null;
                } else {
                    str2 = finderContact2.username;
                }
                avn avn9 = fgx.LFI;
                if (avn9 == null || (finderContact = avn9.contact) == null) {
                    str3 = null;
                } else {
                    str3 = finderContact.nickname;
                }
                liveData.uEB = new com.tencent.mm.plugin.finder.live.viewmodel.e(str11, str, str2, str3, 2, fgx.KDS, null, true, 0, null, null, 0, 0, 7936);
                aVar.getLiveData().uEC = 4;
                Log.i(aVar.getTAG(), "checkLinkMicStateWhenJoin has unfinished mic pk, will close. curPkUser:" + aVar.getLiveData().uEB);
                com.tencent.mm.plugin.finder.live.model.a.b bVar = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                com.tencent.mm.plugin.finder.live.model.a.b.hTq();
                aVar.hTG();
            }
        }
        com.tencent.mm.live.core.core.trtc.a liveCore = aVar.getLiveCore();
        if (liveCore != null) {
            List<com.tencent.mm.live.core.core.trtc.a.b.a> bxn = com.tencent.mm.live.core.core.trtc.a.b.b.bxh().bxn();
            if (bxn != null) {
                bxn.clear();
            }
            liveCore.hAm.bxo();
            com.tencent.mm.live.core.core.b.f fVar = liveCore.hAy;
            if (!(fVar == null || (eVar3 = fVar.hwP) == null)) {
                int i5 = eVar3.hzo;
                e.f fVar2 = e.f.hxS;
                if (i5 == e.f.aCO()) {
                    liveCore.hAm.aDU();
                    AppMethodBeat.o(260791);
                    return;
                }
            }
            com.tencent.mm.live.core.core.b.f fVar3 = liveCore.hAy;
            if (!(fVar3 == null || (eVar2 = fVar3.hwP) == null)) {
                int i6 = eVar2.hzo;
                e.f fVar4 = e.f.hxS;
                if (i6 == e.f.aCP()) {
                    liveCore.hAm.jh(true);
                    AppMethodBeat.o(260791);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("resetMixtureParams invalid live scene: ");
            com.tencent.mm.live.core.core.b.f fVar5 = liveCore.hAy;
            Log.w("MicroMsg.LiveCore", sb.append((fVar5 == null || (eVar = fVar5.hwP) == null) ? null : Integer.valueOf(eVar.hzo)).toString());
            AppMethodBeat.o(260791);
            return;
        }
        AppMethodBeat.o(260791);
    }

    public static final /* synthetic */ void a(a aVar) {
        String str;
        AppMethodBeat.i(247377);
        Log.i(aVar.getTAG(), "restoreLinkMicUI curLinkMicUser:" + aVar.getLiveData().uEB + " curLinkState:" + aVar.getLiveData().uEC + " liveData.audienceLinkMicUserList:" + aVar.getLiveData().UPZ);
        if (aVar.getLiveData().djr()) {
            com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin = aVar.getLinkStatePlugin();
            if (linkStatePlugin != null) {
                linkStatePlugin.dgW();
                AppMethodBeat.o(247377);
                return;
            }
            AppMethodBeat.o(247377);
            return;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = aVar.getLiveData().uEB;
        if (eVar == null || !eVar.UPN) {
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = aVar.getLiveData().UPZ;
            kotlin.g.b.p.g(list, "liveData.audienceLinkMicUserList");
            if (!list.isEmpty()) {
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = aVar.getLiveData().UPZ;
                kotlin.g.b.p.g(list2, "liveData.audienceLinkMicUserList");
                for (T t : list2) {
                    com.tencent.mm.plugin.finder.live.plugin.r previewPlugin = aVar.getPreviewPlugin();
                    if (previewPlugin != null) {
                        previewPlugin.bxG(t.uCo);
                    }
                    if (t.uCx == 2) {
                        aVar.getLiveCore().Gp(t.uCo);
                    }
                }
                aVar.notifyAudienceMicUserChange();
            }
            AppMethodBeat.o(247377);
            return;
        }
        com.tencent.mm.live.core.core.trtc.a liveCore = aVar.getLiveCore();
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = aVar.getLiveData().uEB;
        if (eVar2 != null) {
            str = eVar2.uCo;
        } else {
            str = null;
        }
        liveCore.Gp(str);
        aVar.notifyPKMicUserChange();
        AppMethodBeat.o(247377);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(a aVar, int i2, int i3, String str, ffx ffx, avn avn) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        AppMethodBeat.i(260792);
        if (i2 == 0 && i3 == 0) {
            String tag = aVar.getTAG();
            StringBuilder sb = new StringBuilder("[LinkMicPk] apply anchor link mic pk success. toContact:[");
            FinderContact finderContact = avn.contact;
            Log.i(tag, sb.append(finderContact != null ? finderContact.nickname : null).append(']').toString());
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData = aVar.getLiveData();
            String str2 = ffx.session_id;
            if (str2 == null) {
                str2 = "";
            }
            liveData.bxO(str2);
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData2 = aVar.getLiveData();
            FinderContact finderContact2 = avn.contact;
            String str3 = finderContact2 != null ? finderContact2.headUrl : null;
            FinderContact finderContact3 = avn.contact;
            String str4 = finderContact3 != null ? finderContact3.username : null;
            FinderContact finderContact4 = avn.contact;
            liveData2.uEB = new com.tencent.mm.plugin.finder.live.viewmodel.e("", str3, str4, finderContact4 != null ? finderContact4.nickname : null, 2, ffx.session_id, null, true, 0, null, null, 0, 0, 7168);
            com.tencent.mm.plugin.finder.live.model.a.b bVar = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
            com.tencent.mm.plugin.finder.live.model.a.b.hTn();
            AppMethodBeat.o(260792);
            return;
        }
        String tag2 = aVar.getTAG();
        StringBuilder sb2 = new StringBuilder("[LinkMicPk] apply anchor link mic pk fail. toContact:[");
        FinderContact finderContact5 = avn.contact;
        Log.i(tag2, sb2.append(finderContact5 != null ? finderContact5.nickname : null).append(']').toString());
        com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin = aVar.getLinkStatePlugin();
        if (linkStatePlugin != null) {
            linkStatePlugin.dgX();
        }
        aVar.getLiveData().uEC = 0;
        String str5 = str;
        String str6 = str5 == null || str5.length() == 0 ? null : str;
        switch (i3) {
            case -200075:
                Context context = aVar.getContext();
                if (str6 != null) {
                    string = str6;
                } else {
                    Context context2 = aVar.getContext();
                    kotlin.g.b.p.g(context2, "context");
                    string = context2.getResources().getString(R.string.j_x);
                }
                com.tencent.mm.ui.base.u.makeText(context, string, 0).show();
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                s.x xVar = s.x.LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW;
                Context context3 = aVar.getContext();
                kotlin.g.b.p.g(context3, "context");
                com.tencent.mm.plugin.finder.report.live.k.a(xVar, context3.getResources().getString(R.string.j_x), -1, -1);
                break;
            case -200073:
                Context context4 = aVar.getContext();
                if (str6 != null) {
                    string2 = str6;
                } else {
                    Context context5 = aVar.getContext();
                    kotlin.g.b.p.g(context5, "context");
                    string2 = context5.getResources().getString(R.string.j_w);
                }
                com.tencent.mm.ui.base.u.makeText(context4, string2, 0).show();
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                s.x xVar2 = s.x.LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW;
                Context context6 = aVar.getContext();
                kotlin.g.b.p.g(context6, "context");
                com.tencent.mm.plugin.finder.report.live.k.a(xVar2, context6.getResources().getString(R.string.j_w), -1, -1);
                AppMethodBeat.o(260792);
                return;
            case -200072:
                Context context7 = aVar.getContext();
                if (str6 != null) {
                    string3 = str6;
                } else {
                    Context context8 = aVar.getContext();
                    kotlin.g.b.p.g(context8, "context");
                    string3 = context8.getResources().getString(R.string.j_y);
                }
                com.tencent.mm.ui.base.u.makeText(context7, string3, 0).show();
                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                s.x xVar3 = s.x.LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW;
                Context context9 = aVar.getContext();
                kotlin.g.b.p.g(context9, "context");
                com.tencent.mm.plugin.finder.report.live.k.a(xVar3, context9.getResources().getString(R.string.j_y), -1, -1);
                AppMethodBeat.o(260792);
                return;
            case -200071:
                Context context10 = aVar.getContext();
                if (str6 != null) {
                    string4 = str6;
                } else {
                    Context context11 = aVar.getContext();
                    kotlin.g.b.p.g(context11, "context");
                    string4 = context11.getResources().getString(R.string.ja0);
                }
                com.tencent.mm.ui.base.u.makeText(context10, string4, 0).show();
                com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                s.x xVar4 = s.x.LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW;
                Context context12 = aVar.getContext();
                kotlin.g.b.p.g(context12, "context");
                com.tencent.mm.plugin.finder.report.live.k.a(xVar4, context12.getResources().getString(R.string.ja0), -1, -1);
                AppMethodBeat.o(260792);
                return;
            case -200070:
                Context context13 = aVar.getContext();
                if (str6 != null) {
                    string5 = str6;
                } else {
                    Context context14 = aVar.getContext();
                    kotlin.g.b.p.g(context14, "context");
                    string5 = context14.getResources().getString(R.string.j_z);
                }
                com.tencent.mm.ui.base.u.makeText(context13, string5, 0).show();
                com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                s.x xVar5 = s.x.LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW;
                Context context15 = aVar.getContext();
                kotlin.g.b.p.g(context15, "context");
                com.tencent.mm.plugin.finder.report.live.k.a(xVar5, context15.getResources().getString(R.string.j_z), -1, -1);
                AppMethodBeat.o(260792);
                return;
        }
        AppMethodBeat.o(260792);
    }

    public static final /* synthetic */ void a(a aVar, int i2, int i3, String str) {
        String string;
        String str2;
        AppMethodBeat.i(260793);
        com.tencent.mm.plugin.finder.live.plugin.p linkStatePlugin = aVar.getLinkStatePlugin();
        if (linkStatePlugin != null) {
            linkStatePlugin.dgX();
        }
        if (i2 == 0 && i3 == 0) {
            Log.i(aVar.getTAG(), "[LinkMicPk] accept anchor link mic pk success");
            com.tencent.mm.plugin.finder.live.viewmodel.e eVar = aVar.getLiveData().uEB;
            if (eVar != null) {
                if (aVar.getLiveCore() == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                    AppMethodBeat.o(260793);
                    throw tVar;
                }
                com.tencent.mm.live.core.core.a.b.bF(String.valueOf(eVar.hFB), eVar.uCo, "");
            }
            aVar.getLiveData().UPY.clear();
            com.tencent.mm.plugin.finder.live.plugin.h bottomOptionPlugin = aVar.getBottomOptionPlugin();
            if (bottomOptionPlugin != null) {
                bottomOptionPlugin.dgP();
            }
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.o.hTe();
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            s.x xVar = s.x.LINKMIC_CONNECT_SUCCESS;
            com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = aVar.getLiveData().uEB;
            if (eVar2 != null) {
                str2 = eVar2.username;
            } else {
                str2 = null;
            }
            com.tencent.mm.plugin.finder.report.live.k.a(xVar, str2, s.bf.ANCHOR_ANCHOR.type, s.be.PASSIVE.type);
            AppMethodBeat.o(260793);
            return;
        }
        com.tencent.mm.plugin.finder.live.model.a.b bVar = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
        com.tencent.mm.plugin.finder.live.model.a.b.hTr();
        Log.i(aVar.getTAG(), "[LinkMicPk] accept anchor link mic pk fail");
        aVar.getLiveData().uEB = null;
        aVar.getLiveData().uEC = 0;
        String str3 = str;
        String str4 = str3 == null || str3.length() == 0 ? null : str;
        switch (i3) {
            case -200074:
                Context context = aVar.getContext();
                if (str4 != null) {
                    string = str4;
                } else {
                    Context context2 = aVar.getContext();
                    kotlin.g.b.p.g(context2, "context");
                    string = context2.getResources().getString(R.string.j_u);
                }
                com.tencent.mm.ui.base.u.makeText(context, string, 0).show();
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                s.x xVar2 = s.x.LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW;
                Context context3 = aVar.getContext();
                kotlin.g.b.p.g(context3, "context");
                com.tencent.mm.plugin.finder.report.live.k.a(xVar2, context3.getResources().getString(R.string.j_u), -1, -1);
                break;
        }
        AppMethodBeat.o(260793);
    }
}
