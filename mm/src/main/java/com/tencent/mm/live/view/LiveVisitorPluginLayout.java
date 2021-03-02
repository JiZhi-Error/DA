package com.tencent.mm.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.d.a;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.ab;
import com.tencent.mm.live.c.ac;
import com.tencent.mm.live.c.ae;
import com.tencent.mm.live.c.ag;
import com.tencent.mm.live.c.ai;
import com.tencent.mm.live.c.ak;
import com.tencent.mm.live.c.am;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.aw;
import com.tencent.mm.live.c.ay;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.bc;
import com.tencent.mm.live.c.be;
import com.tencent.mm.live.c.bg;
import com.tencent.mm.live.c.bk;
import com.tencent.mm.live.c.t;
import com.tencent.mm.live.c.v;
import com.tencent.mm.live.c.z;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.b;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020\f2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020/H\u0002J(\u0010O\u001a\u00020/2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020Q2\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0002J\u0012\u0010T\u001a\u00020/2\b\b\u0002\u0010U\u001a\u00020\nH\u0002J\"\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020XH\u0002J\b\u0010\\\u001a\u00020\fH\u0016J\b\u0010]\u001a\u00020\fH\u0016J\b\u0010^\u001a\u00020\fH\u0002J\b\u0010_\u001a\u00020/H\u0002J\u001a\u0010`\u001a\u00020/2\u0006\u0010a\u001a\u00020\f2\b\u0010b\u001a\u0004\u0018\u00010XH\u0002J\u0018\u0010c\u001a\u00020/2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\nH\u0016J\u0018\u0010g\u001a\u00020/2\u0006\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\fH\u0016J\b\u0010j\u001a\u00020/H\u0016J\b\u0010k\u001a\u00020XH\u0016J\b\u0010l\u001a\u00020\nH\u0016J\u0018\u0010m\u001a\u00020/2\u0006\u0010n\u001a\u00020\f2\u0006\u0010o\u001a\u00020XH\u0016J\u0010\u0010p\u001a\u00020/2\u0006\u0010C\u001a\u00020\nH\u0016J,\u0010q\u001a\u00020/2\u0006\u0010r\u001a\u00020\f2\u0006\u0010a\u001a\u00020\f2\b\u0010b\u001a\u0004\u0018\u00010X2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\b\u0010u\u001a\u00020/H\u0016J\b\u0010v\u001a\u00020/H\u0002J\b\u0010w\u001a\u00020/H\u0016J\b\u0010x\u001a\u00020/H\u0016J\b\u0010y\u001a\u00020/H\u0002J\u001a\u0010z\u001a\u00020/2\u0006\u0010{\u001a\u00020|2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010}\u001a\u00020/H\u0016J\b\u0010~\u001a\u00020/H\u0002J\u0018\u0010\u001a\u00020/2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020QH\u0002J\t\u0010\u0001\u001a\u00020/H\u0016J\t\u0010\u0001\u001a\u00020/H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u0012\u0012\u0004\u0012\u00020F0Ej\b\u0012\u0004\u0012\u00020F`GX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout;", "Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "anchorExceptionInTRTC", "", "audienceMode", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "liveDebugPlugin", "Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveGuestRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "liveInputPlugin", "Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "liveKickedPlugin", "Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVideoMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "liveVisitorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "liveVisitorCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "pluginShow", "rotationEnable", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "callback", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "param", "Landroid/os/Bundle;", "checkAnchorStatus", "checkClickArea", "x", "", "y", "validCallback", "chooseAudienceMode", "byOrientationChange", "enterRoom", "liveName", "", "roomID", "", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "getRenderMode", "handleEnterRoom", "handleJoinLiveErr", "errCode", "errMsg", "initLogic", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "keyboardChange", "show", "height", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "requestLinkMic", "resume", "start", "startTimer", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "stopTimer", "toggleShowPlugins", "unMount", "updatePlugin", "Companion", "plugin-logic_release"})
public final class LiveVisitorPluginLayout extends RoomBaseLivePluginLayout implements com.tencent.mm.ak.i, com.tencent.mm.live.core.core.c {
    public static final a hXe = new a((byte) 0);
    private int curNetworkQuality;
    private t hVH;
    private com.tencent.mm.live.c.c hVJ;
    private as hVL;
    private com.tencent.mm.live.c.m hVM;
    private ay hVO;
    private ai hVP;
    private com.tencent.mm.live.c.o hVT;
    private am hVU;
    private ae hVW;
    private ak hVX;
    private ac hVY;
    private ag hVZ;
    private bk hWV;
    private v hWW;
    private z hWX;
    private bg hWY;
    private com.tencent.mm.live.c.q hWZ;
    private com.tencent.mm.live.c.r hWb;
    private final ArrayList<com.tencent.mm.live.c.a> hWe;
    private boolean hWf = true;
    private boolean hWg;
    private final com.tencent.mm.model.d hWh;
    private bc hXa;
    private ab hXb;
    private be hXc;
    private boolean hXd;
    private int hzl;
    private com.tencent.mm.live.core.core.d.b liveCore;
    private final kotlin.g.a.a<x> liveMessageCallback;
    private aw liveTXLivePlayerPlygin;
    private MTimerHandler timerThread;

    static {
        AppMethodBeat.i(208637);
        AppMethodBeat.o(208637);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            super(4);
            this.hXf = liveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Integer num, String str, com.tencent.mm.live.core.core.b.e eVar, TRTCCloudDef.TRTCParams tRTCParams) {
            AppMethodBeat.i(208595);
            int intValue = num.intValue();
            String str2 = str;
            kotlin.g.b.p.h(str2, "errMsg");
            kotlin.g.b.p.h(eVar, "liveRoomInfo");
            kotlin.g.b.p.h(tRTCParams, "trtcParams");
            LiveVisitorPluginLayout.a(this.hXf, intValue, str2);
            x xVar = x.SXb;
            AppMethodBeat.o(208595);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;
        final /* synthetic */ boolean hXg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(LiveVisitorPluginLayout liveVisitorPluginLayout, boolean z) {
            super(1);
            this.hXf = liveVisitorPluginLayout;
            this.hXg = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(208596);
            if (bool.booleanValue()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_LIVE_START_BY_ORIENTATION_CHANGE", this.hXg);
                this.hXf.statusChange(b.c.hLB, bundle);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(208596);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;
        final /* synthetic */ boolean hXg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(LiveVisitorPluginLayout liveVisitorPluginLayout, boolean z) {
            super(1);
            this.hXf = liveVisitorPluginLayout;
            this.hXg = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(208597);
            if (bool.booleanValue()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_LIVE_START_BY_ORIENTATION_CHANGE", this.hXg);
                this.hXf.statusChange(b.c.hLB, bundle);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(208597);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            super(4);
            this.hXf = liveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Integer num, String str, com.tencent.mm.live.core.core.b.e eVar, TRTCCloudDef.TRTCParams tRTCParams) {
            TRTCCloudDef.TRTCParams tRTCParams2;
            AppMethodBeat.i(208598);
            int intValue = num.intValue();
            String str2 = str;
            com.tencent.mm.live.core.core.b.e eVar2 = eVar;
            TRTCCloudDef.TRTCParams tRTCParams3 = tRTCParams;
            kotlin.g.b.p.h(str2, "errMsg");
            kotlin.g.b.p.h(eVar2, "liveRoomInfo");
            kotlin.g.b.p.h(tRTCParams3, "trtcParams");
            if (intValue == 0) {
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.b(new com.tencent.mm.live.core.core.b.f(tRTCParams3, eVar2, new com.tencent.mm.live.core.core.b.b("com.tencent.mm.live.ui.LiveUIA")));
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.core.core.b.f aGv = com.tencent.mm.live.b.x.aGv();
                if (!(aGv == null || (tRTCParams2 = aGv.hzu) == null)) {
                    tRTCParams2.role = 21;
                }
                this.hXf.hzl = eVar2.hzl;
                com.tencent.mm.live.core.c.b bVar = com.tencent.mm.live.core.c.b.hEJ;
                e.f fVar = e.f.hxS;
                com.tencent.mm.live.core.c.b.d(e.f.aCO(), this.hXf.hzl, eVar2.liveId);
                Log.i("MicroMsg.LiveCoreVisitor", "audienceMode:" + this.hXf.hzl);
                LiveVisitorPluginLayout.a(this.hXf);
            } else {
                LiveVisitorPluginLayout.a(this.hXf, intValue, str2);
            }
            x xVar3 = x.SXb;
            AppMethodBeat.o(208598);
            return xVar3;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "x", "", "y", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.m<Float, Float, x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            super(2);
            this.hXf = liveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Float f2, Float f3) {
            AppMethodBeat.i(208604);
            LiveVisitorPluginLayout.a(this.hXf, f2.floatValue(), f3.floatValue());
            x xVar = x.SXb;
            AppMethodBeat.o(208604);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "x", "", "y", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.m<Float, Float, x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            super(2);
            this.hXf = liveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Float f2, Float f3) {
            AppMethodBeat.i(208605);
            LiveVisitorPluginLayout.a(this.hXf, f2.floatValue(), f3.floatValue());
            x xVar = x.SXb;
            AppMethodBeat.o(208605);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "liveID", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            super(1);
            this.hXf = liveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            AppMethodBeat.i(208607);
            long longValue = l.longValue();
            Log.i("MicroMsg.LiveCoreVisitor", "receive close sys msg:".concat(String.valueOf(longValue)));
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            if (longValue == com.tencent.mm.live.b.x.aGr().hyH) {
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.live.view.LiveVisitorPluginLayout.m.AnonymousClass1 */
                    final /* synthetic */ m hXj;

                    {
                        this.hXj = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(208606);
                        b.C0376b.a(this.hXj.hXf, b.c.hLW);
                        AppMethodBeat.o(208606);
                    }
                });
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(208607);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/live/view/LiveVisitorPluginLayout$statusChange$3$1"})
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            super(1);
            this.hXf = liveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(208612);
            if (bool.booleanValue()) {
                LiveVisitorPluginLayout.c(this.hXf);
            } else {
                Log.w("MicroMsg.LiveCoreVisitor", "enterRoom fail! stop link mic");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(208612);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveVisitorPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(208636);
        e.a aVar = e.a.hxc;
        this.hzl = e.a.aCe();
        this.hWe = new ArrayList<>();
        this.hWh = com.tencent.mm.model.d.aTu();
        e.h hVar = e.h.hya;
        this.curNetworkQuality = e.h.aCT();
        this.liveMessageCallback = new o(this);
        this.timerThread = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack) new q(this), true);
        AppMethodBeat.o(208636);
    }

    public static final /* synthetic */ void c(LiveVisitorPluginLayout liveVisitorPluginLayout) {
        AppMethodBeat.i(208640);
        liveVisitorPluginLayout.aJr();
        AppMethodBeat.o(208640);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class q implements MTimerHandler.CallBack {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        q(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            this.hXf = liveVisitorPluginLayout;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            com.tencent.mm.live.c.o oVar;
            AppMethodBeat.i(208613);
            com.tencent.mm.live.c.o oVar2 = this.hXf.hVT;
            if (!(oVar2 == null || oVar2.hwr.getVisibility() != 0 || (oVar = this.hXf.hVT) == null)) {
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                int i2 = com.tencent.mm.live.b.x.aGr().LIa;
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                oVar.db(i2, com.tencent.mm.live.b.x.aGr().LXG);
            }
            AppMethodBeat.o(208613);
            return true;
        }
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final int getRelativeLayoutId() {
        return R.layout.b20;
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void initLogic(LiveConfig liveConfig, boolean z) {
        com.tencent.mm.live.core.core.d.b bVar;
        int aCf;
        com.tencent.mm.live.core.core.b.e eVar;
        com.tencent.mm.live.core.core.b.g gVar;
        com.tencent.mm.live.core.core.b.g gVar2;
        com.tencent.mm.live.c.c cVar;
        com.tencent.mm.live.core.core.d.b aEf;
        com.tencent.mm.live.core.b.l lVar;
        AppMethodBeat.i(208615);
        kotlin.g.b.p.h(liveConfig, "config");
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        getContext();
        this.liveCore = b.a.aEf();
        com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
        if (bVar2 != null) {
            Context context = getContext();
            kotlin.g.b.p.g(context, "context");
            bVar2.a(new RoomLiveMiniView(context));
        }
        com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
        if (bVar3 != null) {
            bVar3.hAx = this;
        }
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        String aBD = liveConfig.aBD();
        kotlin.g.b.p.g(aBD, "config.hostRoomId");
        com.tencent.mm.live.b.x.GQ(aBD);
        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.a(new civ());
        com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aGr().hyH = liveConfig.getLiveId();
        com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.GR(liveConfig.aBE());
        com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
        String aBG = liveConfig.aBG();
        kotlin.g.b.p.g(aBG, "config.anchorUsername");
        com.tencent.mm.live.b.x.GS(aBG);
        com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aGr().KNv = true;
        View findViewById = findViewById(R.id.elh);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.live_right_panel_ui_root)");
        this.hWW = new v((ViewGroup) findViewById, this);
        View findViewById2 = findViewById(R.id.emn);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.live_title_ui_root)");
        this.hVO = new ay((ViewGroup) findViewById2, this);
        View findViewById3 = findViewById(R.id.ek2);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.live_minimize_ui_root)");
        this.hVU = new am((ViewGroup) findViewById3, this);
        View findViewById4 = findViewById(R.id.enf);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.live_visitor_comment_root)");
        this.hWY = new bg((ViewGroup) findViewById4, this);
        View findViewById5 = findViewById(R.id.ehp);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.live_input_ui_root)");
        this.hWX = new z((ViewGroup) findViewById5, this);
        View findViewById6 = findViewById(R.id.eet);
        kotlin.g.b.p.g(findViewById6, "findViewById(R.id.live_after_ui_root)");
        this.hVJ = new com.tencent.mm.live.c.c((RelativeLayout) findViewById6, this);
        View findViewById7 = findViewById(R.id.ehe);
        kotlin.g.b.p.g(findViewById7, "findViewById(R.id.live_input_debug_view_root)");
        this.hWZ = new com.tencent.mm.live.c.q((ViewGroup) findViewById7, this);
        View findViewById8 = findViewById(R.id.ei6);
        kotlin.g.b.p.g(findViewById8, "findViewById(R.id.live_loading_view_root)");
        this.hVW = new ae((ViewGroup) findViewById8, this);
        View findViewById9 = findViewById(R.id.egg);
        kotlin.g.b.p.g(findViewById9, "findViewById(R.id.live_comment_ui_root)");
        this.hVM = new com.tencent.mm.live.c.m((ViewGroup) findViewById9, this);
        View findViewById10 = findViewById(R.id.eiz);
        kotlin.g.b.p.g(findViewById10, "findViewById(R.id.live_members_list_ui_root)");
        this.hVP = new ai((ViewGroup) findViewById10, this);
        View findViewById11 = findViewById(R.id.ehv);
        kotlin.g.b.p.g(findViewById11, "findViewById(R.id.live_like_confetti_ui_root)");
        this.hVY = new ac((ViewGroup) findViewById11, this);
        View findViewById12 = findViewById(R.id.eju);
        kotlin.g.b.p.g(findViewById12, "findViewById(R.id.live_mic_visitor_header_root)");
        this.hVX = new ak((ViewGroup) findViewById12, this);
        View findViewById13 = findViewById(R.id.ek6);
        kotlin.g.b.p.g(findViewById13, "findViewById(R.id.live_preview_ui_root)");
        this.hWV = new bk((ViewGroup) findViewById13, this);
        View findViewById14 = findViewById(R.id.emp);
        kotlin.g.b.p.g(findViewById14, "findViewById(R.id.live_tx_live_player_ui_root)");
        this.liveTXLivePlayerPlygin = new aw((ViewGroup) findViewById14, this);
        View findViewById15 = findViewById(R.id.elk);
        kotlin.g.b.p.g(findViewById15, "findViewById(R.id.live_shadow_ui_root)");
        this.hVL = new as((ViewGroup) findViewById15, this);
        View findViewById16 = findViewById(R.id.ena);
        kotlin.g.b.p.g(findViewById16, "findViewById(R.id.live_video_mic_ui_root)");
        this.hXa = new bc((ViewGroup) findViewById16, this);
        View findViewById17 = findViewById(R.id.ejc);
        kotlin.g.b.p.g(findViewById17, "findViewById(R.id.live_members_profile_ui_root)");
        this.hVZ = new ag((ViewGroup) findViewById17, this);
        View findViewById18 = findViewById(R.id.eht);
        kotlin.g.b.p.g(findViewById18, "findViewById(R.id.live_kicked_ui_root)");
        this.hXb = new ab((ViewGroup) findViewById18, this);
        View findViewById19 = findViewById(R.id.ene);
        kotlin.g.b.p.g(findViewById19, "findViewById(R.id.live_visitor_close_ui_root)");
        this.hXc = new be((ViewGroup) findViewById19, this);
        View findViewById20 = findViewById(R.id.egr);
        kotlin.g.b.p.g(findViewById20, "findViewById(R.id.live_common_info_ui_root)");
        this.hVT = new com.tencent.mm.live.c.o((ViewGroup) findViewById20, this);
        View findViewById21 = findViewById(R.id.eh2);
        kotlin.g.b.p.g(findViewById21, "findViewById(R.id.live_exception_ui_root)");
        this.hWb = new com.tencent.mm.live.c.r((ViewGroup) findViewById21, this);
        View findViewById22 = findViewById(R.id.eh8);
        kotlin.g.b.p.g(findViewById22, "findViewById(R.id.live_face_verify_ui_root)");
        this.hVH = new t((RelativeLayout) findViewById22, this);
        bk bkVar = this.hWV;
        if (bkVar != null) {
            bc bcVar = this.hXa;
            if (bcVar != null) {
                lVar = bcVar.aHL();
            } else {
                lVar = null;
            }
            bkVar.hTC = lVar;
        }
        com.tencent.mm.live.b.r rVar = com.tencent.mm.live.b.r.hIg;
        com.tencent.mm.live.b.r.a(liveConfig);
        com.tencent.mm.live.c.c cVar2 = this.hVJ;
        if (cVar2 != null) {
            cVar2.a(liveConfig);
        }
        com.tencent.mm.live.c.m mVar = this.hVM;
        if (mVar != null) {
            mVar.a(liveConfig);
        }
        ac acVar = this.hVY;
        if (acVar != null) {
            acVar.a(liveConfig);
        }
        ay ayVar = this.hVO;
        if (ayVar != null) {
            com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
            String str = com.tencent.mm.live.b.x.aGr().LpF;
            String str2 = str != null ? str : "";
            com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
            ayVar.a(str2, com.tencent.mm.live.b.x.aGt());
        }
        ai aiVar = this.hVP;
        if (aiVar != null) {
            aiVar.a(liveConfig);
        }
        ag agVar = this.hVZ;
        if (agVar != null) {
            agVar.a(liveConfig);
        }
        com.tencent.mm.live.c.o oVar = this.hVT;
        if (oVar != null) {
            oVar.aHy();
        }
        aw awVar = this.liveTXLivePlayerPlygin;
        if (awVar != null) {
            awVar.aHy();
        }
        bc bcVar2 = this.hXa;
        if (bcVar2 != null) {
            kotlin.g.b.p.h(liveConfig, "config");
            if (liveConfig.aBC() == LiveConfig.hvT) {
                b.a aVar2 = com.tencent.mm.live.core.core.a.b.hyv;
                bcVar2.hwr.getContext();
                aEf = b.a.aDo();
            } else {
                b.a aVar3 = com.tencent.mm.live.core.core.d.b.hCo;
                bcVar2.hwr.getContext();
                aEf = b.a.aEf();
            }
            bcVar2.hSS = aEf;
        }
        com.tencent.mm.live.c.o oVar2 = this.hVT;
        if (oVar2 != null) {
            oVar2.rg(8);
        }
        be beVar = this.hXc;
        if (beVar != null) {
            beVar.rg(8);
        }
        com.tencent.mm.live.c.c cVar3 = this.hVJ;
        if (cVar3 != null) {
            cVar3.rg(8);
        }
        bg bgVar = this.hWY;
        if (bgVar != null) {
            bgVar.rg(8);
        }
        z zVar = this.hWX;
        if (zVar != null) {
            zVar.rg(8);
        }
        v vVar = this.hWW;
        if (vVar != null) {
            vVar.rg(8);
        }
        ai aiVar2 = this.hVP;
        if (aiVar2 != null) {
            aiVar2.rg(8);
        }
        ae aeVar = this.hVW;
        if (aeVar != null) {
            aeVar.Hc(liveConfig.aBG());
        }
        bk bkVar2 = this.hWV;
        if (bkVar2 != null) {
            bkVar2.rg(0);
        }
        aw awVar2 = this.liveTXLivePlayerPlygin;
        if (awVar2 != null) {
            awVar2.rg(8);
        }
        as asVar = this.hVL;
        if (asVar != null) {
            asVar.rg(8);
        }
        bc bcVar3 = this.hXa;
        if (bcVar3 != null) {
            bcVar3.rg(8);
        }
        ag agVar2 = this.hVZ;
        if (agVar2 != null) {
            agVar2.rg(8);
        }
        ab abVar = this.hXb;
        if (abVar != null) {
            abVar.rg(8);
        }
        com.tencent.mm.live.c.r rVar2 = this.hWb;
        if (rVar2 != null) {
            rVar2.rg(8);
        }
        t tVar = this.hVH;
        if (tVar != null) {
            tVar.rg(8);
        }
        bk bkVar3 = this.hWV;
        if (bkVar3 != null) {
            k kVar = new k(this);
            LivePreviewView livePreviewView = bkVar3.hAs;
            if (livePreviewView != null) {
                livePreviewView.setPreviewTouchListener(kVar);
            }
        }
        aw awVar3 = this.liveTXLivePlayerPlygin;
        if (awVar3 != null) {
            awVar3.hSD.setPreviewTouchListener(new l(this));
        }
        if (liveConfig.getScene() == LiveConfig.hvR && (cVar = this.hVJ) != null) {
            cVar.hOl.setVisibility(8);
            cVar.hOk.setVisibility(0);
        }
        com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aHa().hKO = new m(this);
        com.tencent.mm.live.b.m mVar2 = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.e(name(), new n(this));
        if (LiveConfig.aBO()) {
            View findViewById23 = findViewById(R.id.eh8);
            kotlin.g.b.p.g(findViewById23, "findViewById(R.id.live_face_verify_ui_root)");
            this.hVH = new t((RelativeLayout) findViewById23, this);
            statusChange(b.c.hMz, new Bundle());
            LiveConfig.eu(false);
        } else {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            if (aAh.azQ().getInt(ar.a.USERINFO_LIVE_VISITOR_CUSTOM_ROOM_ID_INT_SYNC, 0) == 1) {
                com.tencent.mm.live.c.q qVar = this.hWZ;
                if (qVar != null) {
                    qVar.rg(0);
                }
            } else {
                com.tencent.mm.live.b.x xVar10 = com.tencent.mm.live.b.x.hJf;
                if (com.tencent.mm.live.b.x.getLastOrientation() != -1) {
                    com.tencent.mm.live.b.x xVar11 = com.tencent.mm.live.b.x.hJf;
                    int lastOrientation = com.tencent.mm.live.b.x.getLastOrientation();
                    Object systemService = getContext().getSystemService("window");
                    if (systemService == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
                        AppMethodBeat.o(208615);
                        throw tVar2;
                    }
                    Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                    kotlin.g.b.p.g(defaultDisplay, "((context.getSystemServi…owManager).defaultDisplay");
                    if (lastOrientation != defaultDisplay.getRotation()) {
                        com.tencent.mm.live.b.x xVar12 = com.tencent.mm.live.b.x.hJf;
                        if (com.tencent.mm.live.b.x.aGD().hJn) {
                            b.C0376b.a(this, b.c.hLV);
                        } else {
                            com.tencent.mm.live.core.core.d.b bVar4 = this.liveCore;
                            if ((bVar4 == null || (gVar2 = bVar4.hAz) == null || !gVar2.aDt()) && ((bVar = this.liveCore) == null || (gVar = bVar.hAz) == null || !gVar.aDu())) {
                                com.tencent.mm.live.b.x xVar13 = com.tencent.mm.live.b.x.hJf;
                                com.tencent.mm.live.core.core.b.f aGv = com.tencent.mm.live.b.x.aGv();
                                if (aGv == null || (eVar = aGv.hwP) == null) {
                                    e.a aVar4 = e.a.hxc;
                                    aCf = e.a.aCf();
                                } else {
                                    aCf = eVar.hzl;
                                }
                                this.hzl = aCf;
                                chooseAudienceMode(true);
                                com.tencent.mm.live.b.x xVar14 = com.tencent.mm.live.b.x.hJf;
                                if (com.tencent.mm.live.b.x.aGE().hJk) {
                                    t tVar3 = this.hVH;
                                    if (tVar3 != null) {
                                        tVar3.rg(0);
                                    }
                                    statusChange(b.c.hLw, new Bundle());
                                    com.tencent.mm.live.b.x xVar15 = com.tencent.mm.live.b.x.hJf;
                                    com.tencent.mm.live.b.x.aGE().hJk = false;
                                }
                            } else {
                                b.C0376b.a(this, b.c.hLB);
                            }
                        }
                    }
                }
                com.tencent.mm.live.b.x xVar16 = com.tencent.mm.live.b.x.hJf;
                String str3 = com.tencent.mm.live.b.x.aGr().LpF;
                if (str3 == null) {
                    str3 = "";
                }
                com.tencent.mm.live.b.x xVar17 = com.tencent.mm.live.b.x.hJf;
                long j2 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar18 = com.tencent.mm.live.b.x.hJf;
                c(str3, j2, com.tencent.mm.live.b.x.aGm());
            }
        }
        com.tencent.mm.live.b.m mVar3 = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.d(name(), this.liveMessageCallback);
        AppMethodBeat.o(208615);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onCallStateChanged(int i2, String str) {
        com.tencent.mm.live.core.core.d.b bVar;
        com.tencent.mm.live.core.core.b.g gVar;
        AppMethodBeat.i(208616);
        kotlin.g.b.p.h(str, "incomingNumber");
        StringBuilder append = new StringBuilder("onCallStateChanged state:").append(i2).append(", isFloatMode:");
        com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
        Log.i("MicroMsg.LiveCoreVisitor", append.append((bVar2 == null || (gVar = bVar2.hAz) == null) ? null : Boolean.valueOf(gVar.isFloatMode())).toString());
        switch (i2) {
            case 1:
                AppMethodBeat.o(208616);
                return;
            case 2:
                com.tencent.mm.live.b.r rVar = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.aFZ();
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGy();
                com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
                if (!(bVar3 == null || !bVar3.hAz.aDt() || (bVar = this.liveCore) == null)) {
                    bVar.aBS();
                }
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHi();
                break;
        }
        AppMethodBeat.o(208616);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onRotationSwitchChange(boolean z) {
        this.hWg = z;
    }

    private final void startTimer() {
        AppMethodBeat.i(208617);
        this.timerThread.stopTimer();
        this.timerThread.startTimer(1000);
        AppMethodBeat.o(208617);
    }

    static /* synthetic */ void a(LiveVisitorPluginLayout liveVisitorPluginLayout) {
        AppMethodBeat.i(208619);
        liveVisitorPluginLayout.chooseAudienceMode(false);
        AppMethodBeat.o(208619);
    }

    private final void chooseAudienceMode(boolean z) {
        TXLivePlayer tXLivePlayer;
        TXCloudVideoView tXCloudVideoView = null;
        AppMethodBeat.i(208618);
        Log.i("MicroMsg.LiveCoreVisitor", "audienceMode:" + this.hzl);
        int i2 = this.hzl;
        e.a aVar = e.a.hxc;
        if (i2 == e.a.aCe()) {
            com.tencent.mm.live.d.f.aIY();
            bk bkVar = this.hWV;
            if (bkVar != null) {
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.core.core.b.f aGv = com.tencent.mm.live.b.x.aGv();
                if (aGv == null) {
                    kotlin.g.b.p.hyc();
                }
                bkVar.a(aGv, new c(this, z));
            }
            bk bkVar2 = this.hWV;
            if (bkVar2 != null) {
                bkVar2.rg(0);
                AppMethodBeat.o(208618);
                return;
            }
            AppMethodBeat.o(208618);
            return;
        }
        e.a aVar2 = e.a.hxc;
        if (i2 == e.a.aCf()) {
            com.tencent.mm.live.d.f.aIX();
            com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
            if (bVar != null) {
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.core.core.b.f aGv2 = com.tencent.mm.live.b.x.aGv();
                if (aGv2 == null) {
                    kotlin.g.b.p.hyc();
                }
                bVar.a(aGv2);
            }
            if (this.liveCore != null) {
                com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.core.core.b.f aGv3 = com.tencent.mm.live.b.x.aGv();
                if (aGv3 == null) {
                    kotlin.g.b.p.hyc();
                }
                com.tencent.mm.live.core.core.d.a(aGv3.hwP);
            }
            aw awVar = this.liveTXLivePlayerPlygin;
            if (awVar != null) {
                aw.a(awVar, 0, null, getRenderMode(), new d(this, z), 3);
            }
            aw awVar2 = this.liveTXLivePlayerPlygin;
            if (awVar2 != null) {
                awVar2.rg(0);
            }
            com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
            if (bVar2 != null) {
                com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                long j2 = com.tencent.mm.live.b.x.aGr().hyH;
                aw awVar3 = this.liveTXLivePlayerPlygin;
                if (awVar3 != null) {
                    tXLivePlayer = awVar3.hwO;
                } else {
                    tXLivePlayer = null;
                }
                aw awVar4 = this.liveTXLivePlayerPlygin;
                if (awVar4 != null) {
                    tXCloudVideoView = awVar4.aHJ();
                }
                bVar2.a(j2, tXLivePlayer, tXCloudVideoView);
                AppMethodBeat.o(208618);
                return;
            }
        }
        AppMethodBeat.o(208618);
    }

    private final int getRenderMode() {
        AppMethodBeat.i(208620);
        if (isLandscape()) {
            AppMethodBeat.o(208620);
            return 1;
        }
        AppMethodBeat.o(208620);
        return 0;
    }

    private final void aJr() {
        AppMethodBeat.i(208621);
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        getContext();
        b.a.aEf().aDY();
        Log.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:0");
        AppMethodBeat.o(208621);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class f implements f.c {
        public static final f hXh = new f();

        static {
            AppMethodBeat.i(208599);
            AppMethodBeat.o(208599);
        }

        f() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class g implements DialogInterface.OnDismissListener {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        g(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            this.hXf = liveVisitorPluginLayout;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(208600);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.aHg();
            b.C0376b.a(this.hXf, b.c.hLD);
            AppMethodBeat.o(208600);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/view/LiveVisitorPluginLayout$handleJoinLiveErr$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
    public static final class j extends com.tencent.mm.plugin.messenger.a.a {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        /* JADX WARN: Incorrect types in method signature: (I)V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            super(1);
            this.hXf = liveVisitorPluginLayout;
        }

        @Override // com.tencent.mm.plugin.messenger.a.a
        public final void onClickImp(View view) {
            AppMethodBeat.i(208603);
            kotlin.g.b.p.h(view, "widget");
            Intent intent = new Intent();
            o.a aVar = com.tencent.mm.live.b.o.hGl;
            intent.putExtra("rawUrl", com.tencent.mm.live.b.o.hGj);
            intent.putExtra("showShare", false);
            com.tencent.mm.br.c.f(this.hXf.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            AppMethodBeat.o(208603);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class h implements f.c {
        public static final h hXi = new h();

        static {
            AppMethodBeat.i(208601);
            AppMethodBeat.o(208601);
        }

        h() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class i implements DialogInterface.OnDismissListener {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        i(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            this.hXf = liveVisitorPluginLayout;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(208602);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.aHg();
            b.C0376b.a(this.hXf, b.c.hLD);
            AppMethodBeat.o(208602);
        }
    }

    private final void c(String str, long j2, String str2) {
        AppMethodBeat.i(208622);
        Log.i("MicroMsg.LiveCoreVisitor", "join, name:" + str + ", roomID:" + j2);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        new com.tencent.mm.live.b.k(com.tencent.mm.live.b.x.aGr().hyH, str2, str, (byte) 0).a(new e(this));
        AppMethodBeat.o(208622);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.c.b
    public final void statusChange(b.c cVar, Bundle bundle) {
        z zVar;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        ViewGroup viewGroup4;
        ViewGroup viewGroup5;
        ViewGroup viewGroup6;
        ViewGroup viewGroup7;
        int i2;
        com.tencent.mm.live.core.core.b.g gVar;
        com.tencent.mm.live.core.core.b.g gVar2;
        com.tencent.mm.live.core.core.b.g gVar3;
        ae aeVar;
        com.tencent.mm.live.core.core.d.b bVar;
        bk bkVar;
        com.tencent.mm.live.core.core.b.d dVar;
        com.tencent.mm.live.core.b.l lVar;
        int i3 = 0;
        AppMethodBeat.i(208623);
        kotlin.g.b.p.h(cVar, "status");
        Log.i("MicroMsg.LiveCoreVisitor", "statusChange:" + cVar.name());
        switch (c.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                com.tencent.mm.live.b.c.c liveTipsBarStorage = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                liveTipsBarStorage.GY(com.tencent.mm.live.b.x.aGm());
                com.tencent.mm.live.d.e eVar = com.tencent.mm.live.d.e.hTP;
                com.tencent.mm.live.d.e.aIK().pe(System.currentTimeMillis());
                com.tencent.mm.live.d.e eVar2 = com.tencent.mm.live.d.e.hTP;
                fp aIK = com.tencent.mm.live.d.e.aIK();
                com.tencent.mm.live.d.e eVar3 = com.tencent.mm.live.d.e.hTP;
                long agB = com.tencent.mm.live.d.e.aIK().agB();
                com.tencent.mm.live.d.e eVar4 = com.tencent.mm.live.d.e.hTP;
                aIK.pc((agB - com.tencent.mm.live.d.e.aIK().agA()) / 1000);
                com.tencent.mm.live.d.e eVar5 = com.tencent.mm.live.d.e.hTP;
                fp aIK2 = com.tencent.mm.live.d.e.aIK();
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                aIK2.pf((long) com.tencent.mm.model.v.Ie(com.tencent.mm.live.b.x.aGm()));
                com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                String aGm = com.tencent.mm.live.b.x.aGm();
                com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                long j2 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
                int aGN = com.tencent.mm.live.b.x.aGN();
                com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
                int aGP = com.tencent.mm.live.b.x.aGP();
                com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
                int i4 = com.tencent.mm.live.b.x.aGr().LIa;
                com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
                int aGQ = com.tencent.mm.live.b.x.aGQ();
                com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
                int aGR = com.tencent.mm.live.b.x.aGR();
                com.tencent.mm.live.b.x xVar10 = com.tencent.mm.live.b.x.hJf;
                int aGS = com.tencent.mm.live.b.x.aGS();
                com.tencent.mm.live.b.x xVar11 = com.tencent.mm.live.b.x.hJf;
                int aGT = com.tencent.mm.live.b.x.aGT();
                com.tencent.mm.live.b.x xVar12 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.d.e.a(aGm, j2, aGN, aGP, i4, aGQ, aGR, aGS, aGT, com.tencent.mm.live.b.x.aGr().MnN);
                com.tencent.mm.live.b.x xVar13 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGy();
                Context context = getContext();
                if (context != null) {
                    ((Activity) context).finishAndRemoveTask();
                    break;
                } else {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(208623);
                    throw tVar;
                }
            case 2:
                com.tencent.mm.live.b.c.c liveTipsBarStorage2 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
                com.tencent.mm.live.b.x xVar14 = com.tencent.mm.live.b.x.hJf;
                liveTipsBarStorage2.GY(com.tencent.mm.live.b.x.aGm());
                com.tencent.mm.live.d.e eVar6 = com.tencent.mm.live.d.e.hTP;
                com.tencent.mm.live.d.e.aIK().pe(System.currentTimeMillis());
                com.tencent.mm.live.d.e eVar7 = com.tencent.mm.live.d.e.hTP;
                fp aIK3 = com.tencent.mm.live.d.e.aIK();
                com.tencent.mm.live.d.e eVar8 = com.tencent.mm.live.d.e.hTP;
                long agB2 = com.tencent.mm.live.d.e.aIK().agB();
                com.tencent.mm.live.d.e eVar9 = com.tencent.mm.live.d.e.hTP;
                aIK3.pc((agB2 - com.tencent.mm.live.d.e.aIK().agA()) / 1000);
                com.tencent.mm.live.d.e eVar10 = com.tencent.mm.live.d.e.hTP;
                fp aIK4 = com.tencent.mm.live.d.e.aIK();
                com.tencent.mm.live.b.x xVar15 = com.tencent.mm.live.b.x.hJf;
                aIK4.pf((long) com.tencent.mm.model.v.Ie(com.tencent.mm.live.b.x.aGm()));
                com.tencent.mm.live.b.x xVar16 = com.tencent.mm.live.b.x.hJf;
                String aGm2 = com.tencent.mm.live.b.x.aGm();
                com.tencent.mm.live.b.x xVar17 = com.tencent.mm.live.b.x.hJf;
                long j3 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar18 = com.tencent.mm.live.b.x.hJf;
                int aGN2 = com.tencent.mm.live.b.x.aGN();
                com.tencent.mm.live.b.x xVar19 = com.tencent.mm.live.b.x.hJf;
                int aGP2 = com.tencent.mm.live.b.x.aGP();
                com.tencent.mm.live.b.x xVar20 = com.tencent.mm.live.b.x.hJf;
                int i5 = com.tencent.mm.live.b.x.aGr().LIa;
                com.tencent.mm.live.b.x xVar21 = com.tencent.mm.live.b.x.hJf;
                int aGQ2 = com.tencent.mm.live.b.x.aGQ();
                com.tencent.mm.live.b.x xVar22 = com.tencent.mm.live.b.x.hJf;
                int aGR2 = com.tencent.mm.live.b.x.aGR();
                com.tencent.mm.live.b.x xVar23 = com.tencent.mm.live.b.x.hJf;
                int aGS2 = com.tencent.mm.live.b.x.aGS();
                com.tencent.mm.live.b.x xVar24 = com.tencent.mm.live.b.x.hJf;
                int aGT2 = com.tencent.mm.live.b.x.aGT();
                com.tencent.mm.live.b.x xVar25 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.d.e.a(aGm2, j3, aGN2, aGP2, i5, aGQ2, aGR2, aGS2, aGT2, com.tencent.mm.live.b.x.aGr().MnN);
                com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
                if (bVar2 != null) {
                    bVar2.aBW();
                    x xVar26 = x.SXb;
                }
                com.tencent.mm.live.b.x xVar27 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGy();
                com.tencent.mm.live.b.x xVar28 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHh();
                com.tencent.mm.live.b.r rVar = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.aGb();
                break;
            case 3:
                com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
                if (bVar3 != null) {
                    bVar3.aBW();
                    x xVar29 = x.SXb;
                }
                com.tencent.mm.live.b.x xVar30 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHh();
                com.tencent.mm.live.b.c.c liveTipsBarStorage3 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
                com.tencent.mm.live.b.x xVar31 = com.tencent.mm.live.b.x.hJf;
                liveTipsBarStorage3.zF(com.tencent.mm.live.b.x.aGr().hyH);
                Context context2 = getContext();
                if (context2 != null) {
                    ((Activity) context2).setRequestedOrientation(1);
                    break;
                } else {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(208623);
                    throw tVar2;
                }
            case 4:
                if (kotlin.g.b.p.j(bundle != null ? Boolean.valueOf(bundle.getBoolean("PARAM_LIVE_START_BY_ORIENTATION_CHANGE", false)) : null, Boolean.FALSE)) {
                    this.hWh.aTv();
                    com.tencent.mm.live.b.r.hIg.aGd();
                    com.tencent.mm.live.b.r rVar2 = com.tencent.mm.live.b.r.hIg;
                    com.tencent.mm.live.b.r.aFY();
                    com.tencent.mm.live.b.r rVar3 = com.tencent.mm.live.b.r.hIg;
                    com.tencent.mm.live.b.r.aGc();
                }
                com.tencent.mm.live.b.x xVar32 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHf();
                com.tencent.mm.live.b.x xVar33 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.eM(false);
                startTimer();
                com.tencent.mm.live.d.e eVar11 = com.tencent.mm.live.d.e.hTP;
                com.tencent.mm.live.d.e.aIK().pd(System.currentTimeMillis());
                break;
            case 5:
                com.tencent.mm.live.b.x xVar34 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJn) {
                    com.tencent.mm.live.b.x xVar35 = com.tencent.mm.live.b.x.hJf;
                    if (!com.tencent.mm.live.b.x.aGD().hJp) {
                        ai aiVar = this.hVP;
                        if (aiVar != null) {
                            aiVar.rg(0);
                            x xVar36 = x.SXb;
                        }
                        ai aiVar2 = this.hVP;
                        if (aiVar2 != null) {
                            aiVar2.aHF();
                            x xVar37 = x.SXb;
                            break;
                        }
                    }
                }
                break;
            case 6:
                com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
                com.tencent.mm.live.b.m.aFh();
                com.tencent.mm.live.b.r.hIg.release();
                Context context3 = getContext();
                if (context3 != null) {
                    ((Activity) context3).finishAndRemoveTask();
                    break;
                } else {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(208623);
                    throw tVar3;
                }
            case 7:
                com.tencent.mm.live.b.x xVar38 = com.tencent.mm.live.b.x.hJf;
                String str = com.tencent.mm.live.b.x.aGr().LpF;
                kotlin.g.b.p.g(str, "RoomLiveService.liveInfo.live_name");
                com.tencent.mm.live.b.x xVar39 = com.tencent.mm.live.b.x.hJf;
                long j4 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar40 = com.tencent.mm.live.b.x.hJf;
                c(str, j4, com.tencent.mm.live.b.x.aGm());
                break;
            case 8:
                bk bkVar2 = this.hWV;
                if (bkVar2 != null) {
                    bc bcVar = this.hXa;
                    if (bcVar != null) {
                        lVar = bcVar.aHL();
                    } else {
                        lVar = null;
                    }
                    bkVar2.hTC = lVar;
                    break;
                }
                break;
            case 9:
                if (this.hWg) {
                    Context context4 = getContext();
                    if (context4 != null) {
                        ((Activity) context4).setRequestedOrientation(4);
                        break;
                    } else {
                        kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(208623);
                        throw tVar4;
                    }
                }
                break;
            case 10:
                Context context5 = getContext();
                if (context5 != null) {
                    ((Activity) context5).setRequestedOrientation(14);
                    break;
                } else {
                    kotlin.t tVar5 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(208623);
                    throw tVar5;
                }
            case 11:
                com.tencent.mm.live.b.x xVar41 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.core.core.b.f aGv = com.tencent.mm.live.b.x.aGv();
                if (!(aGv == null || (dVar = aGv.hzt) == null)) {
                    dVar.hzh = true;
                }
                if (this.hWg) {
                    Context context6 = getContext();
                    if (context6 == null) {
                        kotlin.t tVar6 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(208623);
                        throw tVar6;
                    }
                    ((Activity) context6).setRequestedOrientation(4);
                }
                int i6 = this.hzl;
                e.a aVar = e.a.hxc;
                if (i6 == e.a.aCf()) {
                    bk bkVar3 = this.hWV;
                    if (bkVar3 != null) {
                        bkVar3.exitRoom();
                        x xVar42 = x.SXb;
                    }
                    aw awVar = this.liveTXLivePlayerPlygin;
                    if (awVar != null) {
                        awVar.rg(0);
                        x xVar43 = x.SXb;
                    }
                    aw awVar2 = this.liveTXLivePlayerPlygin;
                    if (awVar2 != null) {
                        TXLivePlayer tXLivePlayer = awVar2.hwO;
                        if (tXLivePlayer != null) {
                            tXLivePlayer.resume();
                        }
                        x xVar44 = x.SXb;
                    }
                }
                ak akVar = this.hVX;
                if (akVar != null) {
                    Boolean.valueOf(this.hWe.remove(akVar));
                    break;
                }
                break;
            case 12:
                ak akVar2 = this.hVX;
                if (akVar2 != null) {
                    Boolean.valueOf(this.hWe.remove(akVar2));
                    break;
                }
                break;
            case 13:
                int i7 = this.hzl;
                e.a aVar2 = e.a.hxc;
                if (i7 != e.a.aCe()) {
                    e.a aVar3 = e.a.hxc;
                    if (i7 == e.a.aCf()) {
                        com.tencent.mm.live.b.x xVar45 = com.tencent.mm.live.b.x.hJf;
                        com.tencent.mm.live.core.core.b.f aGv2 = com.tencent.mm.live.b.x.aGv();
                        if (!(aGv2 == null || (bkVar = this.hWV) == null)) {
                            bkVar.a(aGv2, new p(this));
                            x xVar46 = x.SXb;
                            break;
                        }
                    }
                } else {
                    aJr();
                    break;
                }
                break;
            case 14:
                com.tencent.mm.live.b.x xVar47 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHg();
                com.tencent.mm.live.b.r rVar4 = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.aFZ();
                com.tencent.mm.live.b.m mVar2 = com.tencent.mm.live.b.m.hGg;
                com.tencent.mm.live.b.m.aFh();
                com.tencent.mm.live.b.r.hIg.release();
                ay ayVar = this.hVO;
                if (ayVar != null) {
                    ayVar.rg(8);
                    x xVar48 = x.SXb;
                }
                as asVar = this.hVL;
                if (asVar != null) {
                    asVar.rg(8);
                    x xVar49 = x.SXb;
                }
                com.tencent.mm.live.c.c cVar2 = this.hVJ;
                if (cVar2 != null) {
                    cVar2.rg(8);
                    x xVar50 = x.SXb;
                }
                bg bgVar = this.hWY;
                if (bgVar != null) {
                    bgVar.rg(8);
                    x xVar51 = x.SXb;
                }
                z zVar2 = this.hWX;
                if (zVar2 != null) {
                    zVar2.rg(8);
                    x xVar52 = x.SXb;
                }
                v vVar = this.hWW;
                if (vVar != null) {
                    vVar.rg(8);
                    x xVar53 = x.SXb;
                }
                ai aiVar3 = this.hVP;
                if (aiVar3 != null) {
                    aiVar3.rg(8);
                    x xVar54 = x.SXb;
                }
                ae aeVar2 = this.hVW;
                if (aeVar2 != null) {
                    aeVar2.rg(8);
                    x xVar55 = x.SXb;
                }
                bk bkVar4 = this.hWV;
                if (bkVar4 != null) {
                    bkVar4.rg(8);
                    x xVar56 = x.SXb;
                }
                aw awVar3 = this.liveTXLivePlayerPlygin;
                if (awVar3 != null) {
                    awVar3.rg(8);
                    x xVar57 = x.SXb;
                }
                bc bcVar2 = this.hXa;
                if (bcVar2 != null) {
                    bcVar2.rg(8);
                    x xVar58 = x.SXb;
                }
                ag agVar = this.hVZ;
                if (agVar != null) {
                    agVar.rg(8);
                    x xVar59 = x.SXb;
                }
                ab abVar = this.hXb;
                if (abVar != null) {
                    abVar.rg(0);
                    x xVar60 = x.SXb;
                }
                ab abVar2 = this.hXb;
                if (abVar2 != null) {
                    com.tencent.mm.live.b.x xVar61 = com.tencent.mm.live.b.x.hJf;
                    String aGt = com.tencent.mm.live.b.x.aGt();
                    a.C0373a aVar4 = com.tencent.mm.live.b.d.a.hLg;
                    Context context7 = abVar2.hwr.getContext();
                    kotlin.g.b.p.g(context7, "root.context");
                    a.C0373a.a(aGt, context7.getResources().getColor(R.color.u_), new ab.a(abVar2));
                    x xVar62 = x.SXb;
                }
                com.tencent.mm.live.core.core.d.b bVar4 = this.liveCore;
                if ((bVar4 == null || !bVar4.hAz.aDt()) && ((bVar = this.liveCore) == null || !bVar.hAz.aDu())) {
                    int i8 = this.hzl;
                    e.a aVar5 = e.a.hxc;
                    if (i8 != e.a.aCe()) {
                        aw awVar4 = this.liveTXLivePlayerPlygin;
                        if (awVar4 != null) {
                            awVar4.ev(false);
                            x xVar63 = x.SXb;
                            break;
                        }
                    }
                }
                com.tencent.mm.live.core.core.d.b bVar5 = this.liveCore;
                if (bVar5 != null) {
                    bVar5.aEa();
                    x xVar64 = x.SXb;
                }
                bk bkVar5 = this.hWV;
                if (bkVar5 != null) {
                    bkVar5.exitRoom();
                    x xVar65 = x.SXb;
                    break;
                }
                break;
            case 15:
                com.tencent.mm.live.b.x xVar66 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.qV(2);
                com.tencent.mm.live.b.x xVar67 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJn) {
                    com.tencent.mm.live.b.x xVar68 = com.tencent.mm.live.b.x.hJf;
                    if (!com.tencent.mm.live.b.x.aGD().hJp) {
                        ae aeVar3 = this.hVW;
                        if (aeVar3 != null) {
                            com.tencent.mm.live.b.x xVar69 = com.tencent.mm.live.b.x.hJf;
                            String aGt2 = com.tencent.mm.live.b.x.aGt();
                            Context context8 = getContext();
                            kotlin.g.b.p.g(context8, "context");
                            String string = context8.getResources().getString(R.string.egq);
                            kotlin.g.b.p.g(string, "context.resources.getStr…_local_network_error_tip)");
                            aeVar3.showTipWithBlurBg(aGt2, string);
                            x xVar70 = x.SXb;
                        }
                        com.tencent.mm.live.b.x xVar71 = com.tencent.mm.live.b.x.hJf;
                        com.tencent.mm.live.b.x.aHg();
                        break;
                    }
                }
                break;
            case 16:
                com.tencent.mm.live.b.x xVar72 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.qV(1);
                com.tencent.mm.live.b.x xVar73 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJn) {
                    com.tencent.mm.live.b.x xVar74 = com.tencent.mm.live.b.x.hJf;
                    if (!com.tencent.mm.live.b.x.aGD().hJp && (aeVar = this.hVW) != null) {
                        com.tencent.mm.live.b.x xVar75 = com.tencent.mm.live.b.x.hJf;
                        String aGt3 = com.tencent.mm.live.b.x.aGt();
                        Context context9 = getContext();
                        kotlin.g.b.p.g(context9, "context");
                        String string2 = context9.getResources().getString(R.string.ef7);
                        kotlin.g.b.p.g(string2, "context.resources.getStr…ive_anchor_exception_tip)");
                        aeVar.showTipWithBlurBg(aGt3, string2);
                        x xVar76 = x.SXb;
                        break;
                    }
                }
                break;
            case 17:
                bk bkVar6 = this.hWV;
                if (bkVar6 != null) {
                    bkVar6.rg(0);
                    x xVar77 = x.SXb;
                }
                bk bkVar7 = this.hWV;
                if (bkVar7 != null) {
                    bkVar7.aHQ();
                    x xVar78 = x.SXb;
                }
                aw awVar5 = this.liveTXLivePlayerPlygin;
                if (awVar5 != null) {
                    awVar5.rg(8);
                    x xVar79 = x.SXb;
                }
                aw awVar6 = this.liveTXLivePlayerPlygin;
                if (awVar6 != null) {
                    TXLivePlayer tXLivePlayer2 = awVar6.hwO;
                    if (tXLivePlayer2 != null) {
                        tXLivePlayer2.pause();
                    }
                    x xVar80 = x.SXb;
                    break;
                }
                break;
            case 18:
                ae aeVar4 = this.hVW;
                if (aeVar4 != null) {
                    aeVar4.rg(8);
                    x xVar81 = x.SXb;
                    break;
                }
                break;
            case 19:
                com.tencent.mm.live.core.core.d.b bVar6 = this.liveCore;
                if (!(bVar6 == null || (gVar3 = bVar6.hAz) == null || gVar3.isFloatMode())) {
                    com.tencent.mm.live.core.core.d.b bVar7 = this.liveCore;
                    if (bVar7 != null) {
                        Context context10 = getContext();
                        kotlin.g.b.p.g(context10, "context");
                        Integer.valueOf(b.a.a(bVar7, context10, false, false, 0, 0, 30));
                    }
                    com.tencent.mm.live.b.x xVar82 = com.tencent.mm.live.b.x.hJf;
                    String aGm3 = com.tencent.mm.live.b.x.aGm();
                    com.tencent.mm.live.b.x xVar83 = com.tencent.mm.live.b.x.hJf;
                    long j5 = com.tencent.mm.live.b.x.aGr().hyH;
                    com.tencent.mm.live.b.x xVar84 = com.tencent.mm.live.b.x.hJf;
                    String aGt4 = com.tencent.mm.live.b.x.aGt();
                    com.tencent.mm.live.b.x xVar85 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.d.e.a(aGm3, j5, aGt4, 2, 1, com.tencent.mm.live.b.x.aGr().LIa);
                    com.tencent.mm.live.d.f.aIQ();
                    break;
                }
            case 20:
                com.tencent.mm.live.b.x xVar86 = com.tencent.mm.live.b.x.hJf;
                String aGm4 = com.tencent.mm.live.b.x.aGm();
                com.tencent.mm.live.b.x xVar87 = com.tencent.mm.live.b.x.hJf;
                long j6 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar88 = com.tencent.mm.live.b.x.hJf;
                String aGt5 = com.tencent.mm.live.b.x.aGt();
                com.tencent.mm.live.b.x xVar89 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.d.e.a(aGm4, j6, aGt5, 2, 0, com.tencent.mm.live.b.x.aGr().LIa);
                com.tencent.mm.live.d.f.aIR();
                break;
            case 21:
            case 22:
                com.tencent.mm.live.core.core.d.b bVar8 = this.liveCore;
                if (!(bVar8 == null || (gVar2 = bVar8.hAz) == null)) {
                    gVar2.hzE = g.d.NORMAL_MODE;
                    x xVar90 = x.SXb;
                    break;
                }
            case 23:
                com.tencent.mm.live.core.core.d.b bVar9 = this.liveCore;
                if (!(bVar9 == null || (gVar = bVar9.hAz) == null)) {
                    gVar.hzE = g.d.PERMISSION_MODE;
                    x xVar91 = x.SXb;
                    break;
                }
            case 25:
                bk bkVar8 = this.hWV;
                if (bkVar8 != null) {
                    com.tencent.mm.live.b.x xVar92 = com.tencent.mm.live.b.x.hJf;
                    if (com.tencent.mm.live.b.x.aGG().isLandscape()) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    com.tencent.mm.live.b.x xVar93 = com.tencent.mm.live.b.x.hJf;
                    String str2 = com.tencent.mm.live.b.x.aGG().userId;
                    com.tencent.mm.live.b.x xVar94 = com.tencent.mm.live.b.x.hJf;
                    bkVar8.c(i2, str2, com.tencent.mm.live.b.x.aGG().streamType);
                    x xVar95 = x.SXb;
                    break;
                }
                break;
            case 26:
                com.tencent.mm.live.core.core.d.b bVar10 = this.liveCore;
                if (bVar10 == null || !bVar10.aDx()) {
                    com.tencent.mm.live.b.c.c liveTipsBarStorage4 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
                    com.tencent.mm.live.b.x xVar96 = com.tencent.mm.live.b.x.hJf;
                    liveTipsBarStorage4.GY(com.tencent.mm.live.b.x.aGm());
                    com.tencent.mm.live.b.x xVar97 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aGy();
                    com.tencent.mm.live.b.x xVar98 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aHi();
                    break;
                }
            case 27:
                if (isLandscape()) {
                    if (bundle != null && bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                        com.tencent.mm.live.c.m mVar3 = this.hVM;
                        if (mVar3 != null) {
                            mVar3.rg(4);
                            x xVar99 = x.SXb;
                            break;
                        }
                    } else {
                        com.tencent.mm.live.c.m mVar4 = this.hVM;
                        if (mVar4 != null) {
                            mVar4.rg(0);
                            x xVar100 = x.SXb;
                            break;
                        }
                    }
                } else if (bundle != null && bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                    com.tencent.mm.live.c.m mVar5 = this.hVM;
                    ViewGroup.LayoutParams layoutParams = (mVar5 == null || (viewGroup7 = mVar5.hwr) == null) ? null : viewGroup7.getLayoutParams();
                    if (layoutParams != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                        ((RelativeLayout.LayoutParams) layoutParams).removeRule(2);
                        ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
                        com.tencent.mm.live.c.m mVar6 = this.hVM;
                        if (!(mVar6 == null || (viewGroup6 = mVar6.hwr) == null)) {
                            viewGroup6.requestLayout();
                            x xVar101 = x.SXb;
                            break;
                        }
                    }
                } else {
                    com.tencent.mm.live.c.m mVar7 = this.hVM;
                    ViewGroup.LayoutParams layoutParams2 = (mVar7 == null || (viewGroup5 = mVar7.hwr) == null) ? null : viewGroup5.getLayoutParams();
                    if (layoutParams2 != null && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
                        ((RelativeLayout.LayoutParams) layoutParams2).removeRule(12);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                        bg bgVar2 = this.hWY;
                        if (!(bgVar2 == null || (viewGroup4 = bgVar2.hwr) == null)) {
                            i3 = viewGroup4.getId();
                        }
                        layoutParams3.addRule(2, i3);
                        ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin = at.fromDPToPix(getContext(), 12);
                        com.tencent.mm.live.c.m mVar8 = this.hVM;
                        if (!(mVar8 == null || (viewGroup3 = mVar8.hwr) == null)) {
                            viewGroup3.requestLayout();
                            x xVar102 = x.SXb;
                            break;
                        }
                    }
                }
                break;
            case 28:
                if (!isLandscape() && (zVar = this.hWX) != null && zVar.hwr.getVisibility() == 0) {
                    if (bundle != null) {
                        i3 = bundle.getInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT");
                    }
                    com.tencent.mm.live.c.m mVar9 = this.hVM;
                    ViewGroup.LayoutParams layoutParams4 = (mVar9 == null || (viewGroup2 = mVar9.hwr) == null) ? null : viewGroup2.getLayoutParams();
                    if (layoutParams4 != null && (layoutParams4 instanceof RelativeLayout.LayoutParams)) {
                        ((RelativeLayout.LayoutParams) layoutParams4).bottomMargin = i3;
                        com.tencent.mm.live.c.m mVar10 = this.hVM;
                        if (!(mVar10 == null || (viewGroup = mVar10.hwr) == null)) {
                            viewGroup.requestLayout();
                            x xVar103 = x.SXb;
                            break;
                        }
                    }
                }
                break;
            case 29:
                com.tencent.mm.live.b.x xVar104 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJn) {
                    bk bkVar9 = this.hWV;
                    if (bkVar9 != null) {
                        bkVar9.rg(8);
                        x xVar105 = x.SXb;
                    }
                    t tVar7 = this.hVH;
                    if (tVar7 != null) {
                        tVar7.rg(8);
                        x xVar106 = x.SXb;
                    }
                    ae aeVar5 = this.hVW;
                    if (aeVar5 != null) {
                        aeVar5.rg(8);
                        x xVar107 = x.SXb;
                    }
                    com.tencent.mm.live.c.r rVar5 = this.hWb;
                    if (rVar5 != null) {
                        rVar5.rg(0);
                        x xVar108 = x.SXb;
                    }
                    com.tencent.mm.live.b.x xVar109 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aHg();
                    Context context11 = getContext();
                    if (context11 != null) {
                        ((Activity) context11).setRequestedOrientation(1);
                        break;
                    } else {
                        kotlin.t tVar8 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(208623);
                        throw tVar8;
                    }
                }
                break;
            case 30:
                com.tencent.mm.live.b.x xVar110 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGD().hJq = true;
                break;
            case 31:
                com.tencent.mm.live.b.x xVar111 = com.tencent.mm.live.b.x.hJf;
                String aGm5 = com.tencent.mm.live.b.x.aGm();
                com.tencent.mm.live.b.x xVar112 = com.tencent.mm.live.b.x.hJf;
                long j7 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar113 = com.tencent.mm.live.b.x.hJf;
                String aGt6 = com.tencent.mm.live.b.x.aGt();
                String aTY = com.tencent.mm.model.z.aTY();
                kotlin.g.b.p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                com.tencent.mm.live.b.x xVar114 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.d.e.a(aGm5, j7, aGt6, 8, 1, aTY, com.tencent.mm.live.b.x.aGr().LIa);
                com.tencent.mm.live.d.f.aIO();
                break;
            case 32:
                ay ayVar2 = this.hVO;
                if (ayVar2 != null) {
                    ayVar2.rg(4);
                    x xVar115 = x.SXb;
                    break;
                }
                break;
            case 33:
                com.tencent.mm.live.b.x xVar116 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.qZ(com.tencent.mm.live.b.x.aGR() + 1);
                break;
        }
        super.statusChange(cVar, bundle);
        AppMethodBeat.o(208623);
    }

    @Override // com.tencent.mm.live.view.a
    public final String name() {
        AppMethodBeat.i(208624);
        String simpleName = LiveVisitorPluginLayout.class.getSimpleName();
        kotlin.g.b.p.g(simpleName, "LiveVisitorPluginLayout::class.java.simpleName");
        AppMethodBeat.o(208624);
        return simpleName;
    }

    private final void a(float f2, float f3, kotlin.g.a.a<x> aVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(208625);
        as asVar = this.hVL;
        Rect[] aHH = asVar != null ? asVar.aHH() : null;
        if (aHH != null) {
            int i2 = 0;
            while (true) {
                z = z2;
                if (i2 >= 2) {
                    break;
                }
                if (aHH[i2].contains((int) f2, (int) f3)) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                i2++;
            }
        } else {
            z = false;
        }
        if (!z) {
            aVar.invoke();
        }
        AppMethodBeat.o(208625);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void start() {
        AppMethodBeat.i(208626);
        super.start();
        com.tencent.mm.live.b.r rVar = com.tencent.mm.live.b.r.hIg;
        com.tencent.mm.live.b.r.aGb();
        com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
        if ((bVar == null || !bVar.hAz.aDt()) && this.hWg) {
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            if (!com.tencent.mm.live.b.x.aGD().hJn) {
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJp) {
                    Context context = getContext();
                    if (context == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(208626);
                        throw tVar;
                    }
                    ((Activity) context).setRequestedOrientation(4);
                }
            }
        }
        startTimer();
        AppMethodBeat.o(208626);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void stop() {
        AppMethodBeat.i(208627);
        super.stop();
        this.timerThread.stopTimer();
        AppMethodBeat.o(208627);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void resume() {
        com.tencent.mm.live.core.core.b.g gVar;
        com.tencent.mm.live.core.core.b.g gVar2;
        com.tencent.mm.live.core.core.b.g gVar3;
        bk bkVar;
        com.tencent.mm.live.core.core.d.b bVar;
        int i2;
        com.tencent.mm.live.core.core.b.g gVar4;
        com.tencent.mm.live.core.core.d.b bVar2;
        AppMethodBeat.i(208628);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aGD().hJq = false;
        Object systemService = getContext().getSystemService("window");
        if (systemService == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(208628);
            throw tVar;
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        kotlin.g.b.p.g(defaultDisplay, "((context.getSystemServi…owManager).defaultDisplay");
        int rotation = defaultDisplay.getRotation();
        StringBuilder append = new StringBuilder("curOrientation:").append(rotation).append(", lastOrientation:");
        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
        Log.i("MicroMsg.LiveCoreVisitor", append.append(com.tencent.mm.live.b.x.getLastOrientation()).toString());
        super.resume();
        com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
        if (!(bVar3 == null || (gVar4 = bVar3.hAz) == null || !gVar4.isNormalMode() || (bVar2 = this.liveCore) == null)) {
            bVar2.aEb();
        }
        com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.getLastOrientation() != -1) {
            com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
            if (rotation != com.tencent.mm.live.b.x.getLastOrientation()) {
                com.tencent.mm.live.core.core.d.b bVar4 = this.liveCore;
                if (bVar4 != null) {
                    bVar4.aBU();
                }
                com.tencent.mm.live.core.core.d.b bVar5 = this.liveCore;
                if (bVar5 != null) {
                    bVar5.aDX();
                }
                bk bkVar2 = this.hWV;
                if (bkVar2 != null) {
                    com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
                    if (com.tencent.mm.live.b.x.aGG().isLandscape()) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
                    String str = com.tencent.mm.live.b.x.aGG().userId;
                    com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
                    bkVar2.c(i2, str, com.tencent.mm.live.b.x.aGG().streamType);
                }
                com.tencent.mm.live.core.core.d.b bVar6 = this.liveCore;
                if (!(bVar6 == null || (gVar3 = bVar6.hAz) == null || !gVar3.aDt() || (bkVar = this.hWV) == null || (bVar = bkVar.liveCore) == null)) {
                    LivePreviewView livePreviewView = bkVar.hAs;
                    com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.core.b.a aGk = com.tencent.mm.live.b.x.aGk();
                    com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
                    bVar.a(livePreviewView, aGk, com.tencent.mm.live.b.x.aGl());
                }
                com.tencent.mm.live.b.x xVar10 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.setLastOrientation(rotation);
                AppMethodBeat.o(208628);
            }
        }
        com.tencent.mm.live.core.core.d.b bVar7 = this.liveCore;
        if (bVar7 == null || (gVar2 = bVar7.hAz) == null || gVar2.hzz) {
            com.tencent.mm.live.core.core.d.b bVar8 = this.liveCore;
            if (!(bVar8 == null || (gVar = bVar8.hAz) == null)) {
                gVar.hzz = false;
            }
            com.tencent.mm.live.core.core.d.b bVar62 = this.liveCore;
            LivePreviewView livePreviewView2 = bkVar.hAs;
            com.tencent.mm.live.b.x xVar82 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.core.b.a aGk2 = com.tencent.mm.live.b.x.aGk();
            com.tencent.mm.live.b.x xVar92 = com.tencent.mm.live.b.x.hJf;
            bVar.a(livePreviewView2, aGk2, com.tencent.mm.live.b.x.aGl());
            com.tencent.mm.live.b.x xVar102 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.setLastOrientation(rotation);
            AppMethodBeat.o(208628);
        }
        com.tencent.mm.live.core.core.d.b bVar9 = this.liveCore;
        if (bVar9 != null) {
            bVar9.aBU();
        }
        com.tencent.mm.live.core.core.d.b bVar622 = this.liveCore;
        LivePreviewView livePreviewView22 = bkVar.hAs;
        com.tencent.mm.live.b.x xVar822 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.core.b.a aGk22 = com.tencent.mm.live.b.x.aGk();
        com.tencent.mm.live.b.x xVar922 = com.tencent.mm.live.b.x.hJf;
        bVar.a(livePreviewView22, aGk22, com.tencent.mm.live.b.x.aGl());
        com.tencent.mm.live.b.x xVar1022 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.setLastOrientation(rotation);
        AppMethodBeat.o(208628);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0077  */
    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void pause() {
        /*
        // Method dump skipped, instructions count: 278
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.view.LiveVisitorPluginLayout.pause():void");
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.view.RoomBaseLivePluginLayout
    public final void mount() {
        AppMethodBeat.i(208630);
        super.mount();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3806, this);
        AppMethodBeat.o(208630);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0048  */
    @Override // com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.view.RoomBaseLivePluginLayout
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void unMount() {
        /*
        // Method dump skipped, instructions count: 246
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.view.LiveVisitorPluginLayout.unMount():void");
    }

    @Override // com.tencent.mm.live.c.b
    public final int getLiveRole() {
        return 0;
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(208632);
        boolean onBackPress = super.onBackPress();
        if (!onBackPress) {
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            if (com.tencent.mm.live.b.x.aGD().hJo) {
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGD().hJo = false;
                b.C0376b.a(this, b.c.hLC);
                onBackPress = true;
            }
        }
        AppMethodBeat.o(208632);
        return onBackPress;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        int i4;
        AppMethodBeat.i(208633);
        Log.i("MicroMsg.LiveCoreVisitor", "errType:" + i2 + " errCode:" + i3);
        if ((qVar instanceof com.tencent.mm.live.b.a.b) && i2 == 0 && i3 == 0) {
            bg bgVar = this.hWY;
            if (bgVar != null) {
                bgVar.aHM();
            }
            ay ayVar = this.hVO;
            if (ayVar != null) {
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                String str2 = com.tencent.mm.live.b.x.aGr().LpF;
                String str3 = str2 != null ? str2 : "";
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                ayVar.a(str3, com.tencent.mm.live.b.x.aGt());
            }
            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
            if (!com.tencent.mm.live.b.x.aGr().KNv) {
                i4 = cl.aWB();
            } else {
                i4 = 0;
            }
            com.tencent.mm.live.b.x.qT(i4);
        }
        AppMethodBeat.o(208633);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void keyboardChange(boolean z, int i2) {
        AppMethodBeat.i(208634);
        super.keyboardChange(z, i2);
        AppMethodBeat.o(208634);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008e, code lost:
        if (kotlin.g.b.p.j(r3, com.tencent.mm.live.b.x.aGr().MnM) != false) goto L_0x0090;
     */
    @Override // com.tencent.mm.live.core.core.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void callback(int r11, android.os.Bundle r12) {
        /*
        // Method dump skipped, instructions count: 772
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.view.LiveVisitorPluginLayout.callback(int, android.os.Bundle):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            super(0);
            this.hXf = liveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(208611);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            if (com.tencent.mm.live.b.x.aGP() == -1) {
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                if (com.tencent.mm.live.b.x.aGr().LIa - 1 >= 0) {
                    com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                    i2 = com.tencent.mm.live.b.x.aGr().LIa - 1;
                } else {
                    i2 = 0;
                }
                com.tencent.mm.live.b.x.qX(i2);
            }
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.live.view.LiveVisitorPluginLayout.o.AnonymousClass1 */
                final /* synthetic */ o hXl;

                {
                    this.hXl = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(208610);
                    com.tencent.mm.live.c.m mVar = this.hXl.hXf.hVM;
                    if (mVar != null) {
                        mVar.aHx();
                    }
                    LiveVisitorPluginLayout.k(this.hXl.hXf);
                    x xVar = x.SXb;
                    AppMethodBeat.o(208610);
                    return xVar;
                }
            });
            x xVar5 = x.SXb;
            AppMethodBeat.o(208611);
            return xVar5;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            super(0);
            this.hXf = liveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(208609);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.live.view.LiveVisitorPluginLayout.n.AnonymousClass1 */
                final /* synthetic */ n hXk;

                {
                    this.hXk = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(208608);
                    b.C0376b.a(this.hXk.hXf, b.c.hMl);
                    x xVar = x.SXb;
                    AppMethodBeat.o(208608);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(208609);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ LiveVisitorPluginLayout hXf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(LiveVisitorPluginLayout liveVisitorPluginLayout) {
            super(0);
            this.hXf = liveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(208614);
            if (this.hXf.hWf) {
                for (T t : this.hXf.getPluginList()) {
                    if (t instanceof com.tencent.mm.live.c.a) {
                        if (!kotlin.a.j.listOf((Object[]) new com.tencent.mm.live.c.a[]{this.hXf.hWV, this.hXf.hVW, this.hXf.liveTXLivePlayerPlygin, this.hXf.hVH}).contains(t) && t.hwr.getVisibility() == 0) {
                            t.rg(4);
                            this.hXf.hWe.add(t);
                        }
                    }
                }
            } else {
                for (com.tencent.mm.live.c.a aVar : this.hXf.hWe) {
                    aVar.rg(0);
                }
                this.hXf.hWe.clear();
            }
            LiveVisitorPluginLayout liveVisitorPluginLayout = this.hXf;
            liveVisitorPluginLayout.hWf = !this.hXf.hWf;
            x xVar = x.SXb;
            AppMethodBeat.o(208614);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(LiveVisitorPluginLayout liveVisitorPluginLayout, float f2, float f3) {
        AppMethodBeat.i(208638);
        Log.i("MicroMsg.LiveCoreVisitor", "toggleShowPlugins, pluginShow:" + liveVisitorPluginLayout.hWf);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJn) {
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            if (!com.tencent.mm.live.b.x.aGD().hJp) {
                com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                if (com.tencent.mm.live.b.x.aGD().hJo) {
                    liveVisitorPluginLayout.a(f2, f3, new r(liveVisitorPluginLayout));
                }
            }
        }
        AppMethodBeat.o(208638);
    }

    public static final /* synthetic */ void a(LiveVisitorPluginLayout liveVisitorPluginLayout, int i2, String str) {
        AppMethodBeat.i(208639);
        Log.i("MicroMsg.LiveCoreVisitor", "join live room errCode:" + i2 + " errMsg:" + str);
        switch (i2) {
            case -100069:
                if (Util.isNullOrNil(str)) {
                    Context context = liveVisitorPluginLayout.getContext();
                    kotlin.g.b.p.g(context, "context");
                    str = context.getResources().getString(R.string.ehm);
                }
                new f.a(liveVisitorPluginLayout.getContext()).hbu().bow(str).apa(R.string.w0).b(h.hXi).b(new i(liveVisitorPluginLayout)).show();
                AppMethodBeat.o(208639);
                return;
            case -100068:
            case -100045:
                Bundle bundle = new Bundle();
                Context context2 = liveVisitorPluginLayout.getContext();
                kotlin.g.b.p.g(context2, "context");
                String string = context2.getResources().getString(R.string.efx);
                kotlin.g.b.p.g(string, "context.resources.getStr…eption_desc_forbid_visit)");
                SpannableString spannableString = new SpannableString(string);
                int a2 = kotlin.n.n.a((CharSequence) spannableString, "《", 0, false, 6);
                if (a2 != -1) {
                    spannableString.setSpan(new j(liveVisitorPluginLayout), a2, spannableString.length(), 0);
                }
                Context context3 = liveVisitorPluginLayout.getContext();
                kotlin.g.b.p.g(context3, "context");
                bundle.putString("PARAM_LIVE_EXCEPTION_TITLE", context3.getResources().getString(R.string.efy));
                bundle.putCharSequence("PARAM_LIVE_EXCEPTION_DESC", spannableString);
                bundle.putInt("PARAM_LIVE_EXCEPTION_ICON_RES", R.raw.icons_filled_live_err_red);
                liveVisitorPluginLayout.statusChange(b.c.hMv, bundle);
                AppMethodBeat.o(208639);
                return;
            case -100056:
                b.C0376b.a(liveVisitorPluginLayout, b.c.hMl);
                AppMethodBeat.o(208639);
                return;
            case -100038:
                b.C0376b.a(liveVisitorPluginLayout, b.c.hLV);
                AppMethodBeat.o(208639);
                return;
            case TXLiteAVCode.ERR_SERVER_INFO_ALLOCATE_ACCESS_FAILED:
                f.a hbu = new f.a(liveVisitorPluginLayout.getContext()).hbu();
                Context context4 = liveVisitorPluginLayout.getContext();
                kotlin.g.b.p.g(context4, "context");
                hbu.aC(context4.getResources().getString(R.string.egh)).apa(R.string.w0).b(f.hXh).b(new g(liveVisitorPluginLayout)).show();
                AppMethodBeat.o(208639);
                return;
            default:
                u.makeText(liveVisitorPluginLayout.getContext(), com.tencent.mm.cb.a.aI(liveVisitorPluginLayout.getContext(), R.string.eiq), 0).show();
                b.C0376b.a(liveVisitorPluginLayout, b.c.hMo);
                AppMethodBeat.o(208639);
                return;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0030, code lost:
        if (r0 == true) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void k(com.tencent.mm.live.view.LiveVisitorPluginLayout r6) {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.view.LiveVisitorPluginLayout.k(com.tencent.mm.live.view.LiveVisitorPluginLayout):void");
    }
}
