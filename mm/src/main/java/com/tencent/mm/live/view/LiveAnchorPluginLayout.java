package com.tencent.mm.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.b.a;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.c.ac;
import com.tencent.mm.live.c.ae;
import com.tencent.mm.live.c.ag;
import com.tencent.mm.live.c.ai;
import com.tencent.mm.live.c.ak;
import com.tencent.mm.live.c.am;
import com.tencent.mm.live.c.ao;
import com.tencent.mm.live.c.aq;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.au;
import com.tencent.mm.live.c.ay;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.ba;
import com.tencent.mm.live.c.x;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.b;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001a\u0010S\u001a\u0002042\u0006\u0010T\u001a\u00020\u00102\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J(\u0010W\u001a\u0002042\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103H\u0002J\u0010\u0010\\\u001a\u0002042\u0006\u0010]\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u0002042\u0006\u0010]\u001a\u00020^H\u0002J\u0018\u0010`\u001a\u0002042\u0006\u0010a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000bH\u0002J\b\u0010c\u001a\u00020\u0010H\u0016J\b\u0010d\u001a\u00020\u0010H\u0016J\b\u0010e\u001a\u000204H\u0002J\u001a\u0010f\u001a\u0002042\u0006\u0010g\u001a\u00020\u00102\b\u0010h\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010i\u001a\u0002042\u0006\u0010]\u001a\u00020^2\u0006\u0010j\u001a\u00020\u0014H\u0017J\b\u0010k\u001a\u000204H\u0002J\b\u0010l\u001a\u000204H\u0002J\b\u0010m\u001a\u000204H\u0016J\b\u0010n\u001a\u00020\u000bH\u0016J\b\u0010o\u001a\u00020\u0014H\u0016J\u0018\u0010p\u001a\u0002042\u0006\u0010q\u001a\u00020\u00102\u0006\u0010r\u001a\u00020\u000bH\u0016J\u0010\u0010s\u001a\u0002042\u0006\u0010t\u001a\u00020\u0010H\u0016J\u0010\u0010u\u001a\u0002042\u0006\u0010K\u001a\u00020\u0014H\u0016J,\u0010v\u001a\u0002042\u0006\u0010w\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\u00102\b\u0010h\u001a\u0004\u0018\u00010\u000b2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J\b\u0010z\u001a\u00020\u0014H\u0002J\b\u0010{\u001a\u000204H\u0016J\b\u0010|\u001a\u000204H\u0002J\b\u0010}\u001a\u000204H\u0016J\b\u0010~\u001a\u000204H\u0016J$\u0010\u001a\u0002042\u0006\u0010a\u001a\u00020\u000b2\n\b\u0002\u0010\u0001\u001a\u00030\u00012\u0006\u0010b\u001a\u00020\u000bH\u0002J\t\u0010\u0001\u001a\u000204H\u0002J\u001c\u0010\u0001\u001a\u0002042\u0007\u0010\u0001\u001a\u00020\u00122\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\t\u0010\u0001\u001a\u000204H\u0016J\t\u0010\u0001\u001a\u000204H\u0002J\t\u0010\u0001\u001a\u000204H\u0002J\u0019\u0010\u0001\u001a\u0002042\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020YH\u0002J#\u0010\u0001\u001a\u0002042\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000bH\u0002J\t\u0010\u0001\u001a\u000204H\u0016J\t\u0010\u0001\u001a\u000204H\u0002R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010M\u001a\u0012\u0012\u0004\u0012\u00020O0Nj\b\u0012\u0004\u0012\u00020O`PX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/live/view/LiveAnchorPluginLayout;", "Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "", "curStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "fromForcelockOrientation", "", "lastRotationFromSensor", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveAnchorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "liveAnchorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorMicPlugin;", "liveBanCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "liveBeforePlugin", "Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "liveReadyPlugin", "Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "liveRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveShareRoomsPlugin", "Lcom/tencent/mm/live/plugin/LiveShareRoomsPlugin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "nextStatus", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "pluginShow", "rotationEnable", "shareLiveRetryCount", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "callback", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "param", "Landroid/os/Bundle;", "checkClickArea", "x", "", "y", "validCallback", "checkInitStatus", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "checkVerify", "createNewLive", "liveName", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleErrForeigner", "handleJoinLiveFail", "errCode", "errMsg", "initLogic", "isFinished", "joinLive", "lockOrientation", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onOrientationChange", "orientation", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "orientationChanged", "pause", "refreshCamera", "resume", "start", "startLive", "liveId", "", "startTimer", "statusChange", "status", "stop", "stopLive", "stopTimer", "toggleShowPlugins", "tryResumeLive", "unMount", "updatePlugin", "plugin-logic_release"})
public final class LiveAnchorPluginLayout extends RoomBaseLivePluginLayout implements com.tencent.mm.ak.i, com.tencent.mm.live.core.core.c, d.a {
    private final String TAG = "MicroMsg.LiveAnchorPluginLayout";
    private int curNetworkQuality;
    private com.tencent.mm.live.core.core.a.a hSm;
    private ba hVG;
    private com.tencent.mm.live.c.t hVH;
    private com.tencent.mm.live.c.k hVI;
    private com.tencent.mm.live.c.c hVJ;
    private ao hVK;
    private as hVL;
    private com.tencent.mm.live.c.m hVM;
    private aq hVN;
    private ay hVO;
    private ai hVP;
    private x hVQ;
    private com.tencent.mm.live.c.g hVR;
    private com.tencent.mm.live.c.i hVS;
    private com.tencent.mm.live.c.o hVT;
    private am hVU;
    private au hVV;
    private ae hVW;
    private ak hVX;
    private ac hVY;
    private ag hVZ;
    private com.tencent.mm.live.c.e hWa;
    private com.tencent.mm.live.c.r hWb;
    private b.c hWc = b.c.hLy;
    private b.c hWd = b.c.hLy;
    private final ArrayList<com.tencent.mm.live.c.a> hWe;
    private boolean hWf;
    private boolean hWg;
    private final com.tencent.mm.model.d hWh;
    private boolean hWi;
    private int hWj;
    private int lastRotationFromSensor;
    private kotlin.g.a.a<kotlin.x> liveMessageCallback;
    private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
    private MTimerHandler timerThread;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, kotlin.x> {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            super(4);
            this.hWk = liveAnchorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ kotlin.x invoke(Integer num, String str, com.tencent.mm.live.core.core.b.e eVar, TRTCCloudDef.TRTCParams tRTCParams) {
            AppMethodBeat.i(208493);
            int intValue = num.intValue();
            String str2 = str;
            kotlin.g.b.p.h(str2, "errMsg");
            kotlin.g.b.p.h(eVar, "liveRoomInfo");
            kotlin.g.b.p.h(tRTCParams, "trtcParams");
            LiveAnchorPluginLayout.a(this.hWk, intValue, str2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(208493);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "success", "", "needFaceVerify", "verifyUrl", "", "errCode", "", "errMsg", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.s<Boolean, Boolean, String, Integer, String, kotlin.x> {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            super(5);
            this.hWk = liveAnchorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.s
        public final /* synthetic */ kotlin.x a(Boolean bool, Boolean bool2, String str, Integer num, String str2) {
            AppMethodBeat.i(208499);
            boolean booleanValue = bool.booleanValue();
            boolean booleanValue2 = bool2.booleanValue();
            String str3 = str;
            int intValue = num.intValue();
            String str4 = str2;
            kotlin.g.b.p.h(str3, "verifyUrl");
            kotlin.g.b.p.h(str4, "errMsg");
            if (booleanValue) {
                b.C0376b.a(this.hWk, b.c.hLz);
            } else if (booleanValue2) {
                ba baVar = this.hWk.hVG;
                if (baVar != null) {
                    baVar.rg(8);
                }
                com.tencent.mm.live.c.t tVar = this.hWk.hVH;
                if (tVar != null) {
                    tVar.rg(0);
                }
                com.tencent.mm.live.c.c cVar = this.hWk.hVJ;
                if (cVar != null) {
                    cVar.rg(4);
                }
                com.tencent.mm.live.c.m mVar = this.hWk.hVM;
                if (mVar != null) {
                    mVar.rg(8);
                }
                x xVar = this.hWk.hVQ;
                if (xVar != null) {
                    xVar.rg(8);
                }
                ay ayVar = this.hWk.hVO;
                if (ayVar != null) {
                    ayVar.rg(8);
                }
                as asVar = this.hWk.hVL;
                if (asVar != null) {
                    asVar.rg(8);
                }
                com.tencent.mm.live.c.i iVar = this.hWk.hVS;
                if (iVar != null) {
                    iVar.rg(8);
                }
                ae aeVar = this.hWk.hVW;
                if (aeVar != null) {
                    aeVar.rg(8);
                }
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGE().GW(str3);
                com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGE().hJm = true;
                this.hWk.statusChange(b.c.hLw, new Bundle());
            } else if (intValue == -100064) {
                Bundle bundle = new Bundle();
                bundle.putInt("PARAM_FACE_VERIFY_ERROR", R.string.eg9);
                this.hWk.statusChange(b.c.hLy, bundle);
            } else if (intValue == -100066) {
                Bundle bundle2 = new Bundle();
                Context context = this.hWk.getContext();
                kotlin.g.b.p.g(context, "context");
                String string = context.getResources().getString(R.string.efx);
                kotlin.g.b.p.g(string, "context.resources.getStr…eption_desc_forbid_visit)");
                SpannableString spannableString = new SpannableString(string);
                int a2 = kotlin.n.n.a((CharSequence) spannableString, "《", 0, false, 6);
                if (a2 != -1) {
                    Context context2 = this.hWk.getContext();
                    kotlin.g.b.p.g(context2, "context");
                    spannableString.setSpan(new ForegroundColorSpan(context2.getResources().getColor(R.color.Link)), a2, spannableString.length(), 0);
                    spannableString.setSpan(new a(this), a2, spannableString.length(), 0);
                }
                Context context3 = this.hWk.getContext();
                kotlin.g.b.p.g(context3, "context");
                bundle2.putString("PARAM_LIVE_EXCEPTION_TITLE", context3.getResources().getString(R.string.efy));
                bundle2.putCharSequence("PARAM_LIVE_EXCEPTION_DESC", spannableString);
                bundle2.putInt("PARAM_LIVE_EXCEPTION_ICON_RES", R.raw.icons_filled_live_err_red);
                this.hWk.statusChange(b.c.hMv, bundle2);
            } else if (intValue == -100065) {
                LiveAnchorPluginLayout.o(this.hWk);
            } else if (intValue == -100002) {
                f.a hbu = new f.a(this.hWk.getContext()).hbu();
                Context context4 = this.hWk.getContext();
                kotlin.g.b.p.g(context4, "context");
                hbu.aC(context4.getResources().getString(R.string.efl)).apa(R.string.w0).b(AnonymousClass1.hWl).b(new DialogInterface.OnDismissListener(this) {
                    /* class com.tencent.mm.live.view.LiveAnchorPluginLayout.b.AnonymousClass2 */
                    final /* synthetic */ b hWm;

                    {
                        this.hWm = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(208495);
                        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                        com.tencent.mm.live.b.x.aHg();
                        b.C0376b.a(this.hWm.hWk, b.c.hLD);
                        AppMethodBeat.o(208495);
                    }
                }).show();
            } else if (intValue == -100069) {
                if (Util.isNullOrNil(str4)) {
                    Context context5 = this.hWk.getContext();
                    kotlin.g.b.p.g(context5, "context");
                    str4 = context5.getResources().getString(R.string.ehm);
                }
                kotlin.g.b.p.g(str4, "if (Util.isNullOrNil(err… errMsg\n                }");
                new f.a(this.hWk.getContext()).hbu().bow(str4).apa(R.string.w0).b(AnonymousClass3.hWn).b(new DialogInterface.OnDismissListener(this) {
                    /* class com.tencent.mm.live.view.LiveAnchorPluginLayout.b.AnonymousClass4 */
                    final /* synthetic */ b hWm;

                    {
                        this.hWm = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(208497);
                        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                        com.tencent.mm.live.b.x.aHg();
                        b.C0376b.a(this.hWm.hWk, b.c.hLD);
                        AppMethodBeat.o(208497);
                    }
                }).show();
            } else {
                com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
                com.tencent.mm.live.core.debug.a.GB("create live fail, errCode:".concat(String.valueOf(intValue)));
                com.tencent.mm.ui.base.u.makeText(this.hWk.getContext(), com.tencent.mm.cb.a.aI(this.hWk.getContext(), R.string.eip), 0).show();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("live_user_exit_reason", intValue);
                this.hWk.statusChange(b.c.hMr, bundle3);
            }
            kotlin.x xVar4 = kotlin.x.SXb;
            AppMethodBeat.o(208499);
            return xVar4;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/view/LiveAnchorPluginLayout$createNewLive$1$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
        public static final class a extends com.tencent.mm.plugin.messenger.a.a {
            final /* synthetic */ b hWm;

            /* JADX WARN: Incorrect types in method signature: (I)V */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(1);
                this.hWm = bVar;
            }

            @Override // com.tencent.mm.plugin.messenger.a.a
            public final void onClickImp(View view) {
                AppMethodBeat.i(208498);
                kotlin.g.b.p.h(view, "widget");
                Intent intent = new Intent();
                o.a aVar = com.tencent.mm.live.b.o.hGl;
                intent.putExtra("rawUrl", com.tencent.mm.live.b.o.hGj);
                intent.putExtra("showShare", false);
                com.tencent.mm.br.c.f(this.hWm.hWk.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                AppMethodBeat.o(208498);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "xOffset", "", "yOffset", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.m<Float, Float, kotlin.x> {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            super(2);
            this.hWk = liveAnchorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Float f2, Float f3) {
            AppMethodBeat.i(208507);
            float floatValue = f2.floatValue();
            float floatValue2 = f3.floatValue();
            com.tencent.mm.live.core.core.a.a aVar = this.hWk.hSm;
            if (aVar != null) {
                aVar.A(floatValue, floatValue2);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(208507);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "x", "", "y", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.m<Float, Float, kotlin.x> {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            super(2);
            this.hWk = liveAnchorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Float f2, Float f3) {
            AppMethodBeat.i(208508);
            LiveAnchorPluginLayout.a(this.hWk, f2.floatValue(), f3.floatValue());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(208508);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "liveID", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.b<Long, kotlin.x> {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            super(1);
            this.hWk = liveAnchorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Long l) {
            com.tencent.mm.live.c.c cVar;
            AppMethodBeat.i(208510);
            long longValue = l.longValue();
            Log.i(this.hWk.TAG, "receive close sys msg:".concat(String.valueOf(longValue)));
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            if (longValue == com.tencent.mm.live.b.x.aGr().hyH && ((cVar = this.hWk.hVJ) == null || cVar.hwr.getVisibility() != 0)) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.live.view.LiveAnchorPluginLayout.l.AnonymousClass1 */
                    final /* synthetic */ l hWr;

                    {
                        this.hWr = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(208509);
                        b.C0376b.a(this.hWr.hWk, b.c.hLW);
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(208509);
                        return xVar;
                    }
                });
            }
            kotlin.x xVar2 = kotlin.x.SXb;
            AppMethodBeat.o(208510);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\n¢\u0006\u0002\b\f"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.s<Boolean, Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, kotlin.x> {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            super(5);
            this.hWk = liveAnchorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.s
        public final /* synthetic */ kotlin.x a(Boolean bool, Integer num, String str, com.tencent.mm.live.core.core.b.e eVar, TRTCCloudDef.TRTCParams tRTCParams) {
            AppMethodBeat.i(208512);
            boolean booleanValue = bool.booleanValue();
            int intValue = num.intValue();
            String str2 = str;
            com.tencent.mm.live.core.core.b.e eVar2 = eVar;
            TRTCCloudDef.TRTCParams tRTCParams2 = tRTCParams;
            kotlin.g.b.p.h(str2, "errMsg");
            kotlin.g.b.p.h(eVar2, "liveRoomInfo");
            kotlin.g.b.p.h(tRTCParams2, "trtcParams");
            if (booleanValue) {
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.b(new com.tencent.mm.live.core.core.b.f(tRTCParams2, eVar2, new com.tencent.mm.live.core.core.b.b("com.tencent.mm.live.ui.LiveUIA")));
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.core.core.b.f aGv = com.tencent.mm.live.b.x.aGv();
                if (aGv != null) {
                    com.tencent.mm.live.core.core.a.a aVar = this.hWk.hSm;
                    if (aVar != null) {
                        aVar.a(aGv);
                    }
                    com.tencent.mm.live.core.core.a.a aVar2 = this.hWk.hSm;
                    if (aVar2 != null) {
                        aVar2.a(new a(this));
                    }
                }
            } else {
                com.tencent.mm.live.core.debug.a aVar3 = com.tencent.mm.live.core.debug.a.hCA;
                com.tencent.mm.live.core.debug.a.GB("join live fail, errCode:".concat(String.valueOf(intValue)));
                LiveAnchorPluginLayout.a(this.hWk, intValue, str2);
            }
            kotlin.x xVar3 = kotlin.x.SXb;
            AppMethodBeat.o(208512);
            return xVar3;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/live/view/LiveAnchorPluginLayout$joinLive$1$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
        public static final class a implements com.tencent.mm.live.core.core.c {
            final /* synthetic */ m hWs;

            a(m mVar) {
                this.hWs = mVar;
            }

            @Override // com.tencent.mm.live.core.core.c
            public final void callback(int i2, Bundle bundle) {
                AppMethodBeat.i(208511);
                Log.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish");
                if (i2 >= 0) {
                    b.C0376b.a(this.hWs.hWk, b.c.hLB);
                    com.tencent.mm.live.b.r rVar = com.tencent.mm.live.b.r.hIg;
                    com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.r.GO(com.tencent.mm.live.b.x.aGm());
                    b.C0376b.a(this.hWs.hWk, b.c.hMs);
                    AppMethodBeat.o(208511);
                    return;
                }
                Log.w("MicroMsg.LiveCoreAnchor", "enter room fail");
                com.tencent.mm.ui.base.u.makeText(this.hWs.hWk.getContext(), "enter room fail", 0).show();
                b.C0376b.a(this.hWs.hWk, b.c.hLy);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("live_user_exit_reason", i2);
                this.hWs.hWk.statusChange(b.c.hMr, bundle2);
                AppMethodBeat.o(208511);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "ret", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
    public static final class u extends kotlin.g.b.q implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, kotlin.x> {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            super(4);
            this.hWk = liveAnchorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ kotlin.x invoke(Integer num, String str, com.tencent.mm.live.core.core.b.e eVar, TRTCCloudDef.TRTCParams tRTCParams) {
            AppMethodBeat.i(208523);
            int intValue = num.intValue();
            String str2 = str;
            com.tencent.mm.live.core.core.b.e eVar2 = eVar;
            TRTCCloudDef.TRTCParams tRTCParams2 = tRTCParams;
            kotlin.g.b.p.h(str2, "errMsg");
            kotlin.g.b.p.h(eVar2, "liveRoomInfo");
            kotlin.g.b.p.h(tRTCParams2, "trtcParams");
            Log.i("MicroMsg.LiveCoreAnchor", "join live room ret:".concat(String.valueOf(intValue)));
            if (intValue == 0) {
                com.tencent.mm.live.core.core.b.f fVar = new com.tencent.mm.live.core.core.b.f(tRTCParams2, eVar2, new com.tencent.mm.live.core.core.b.b("com.tencent.mm.live.ui.LiveUIA"));
                fVar.hzu.role = 20;
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.b(fVar);
                com.tencent.mm.live.core.core.a.a aVar = this.hWk.hSm;
                if (aVar != null) {
                    aVar.a(fVar);
                }
                com.tencent.mm.live.core.core.a.a aVar2 = this.hWk.hSm;
                if (aVar2 != null) {
                    aVar2.a(new com.tencent.mm.live.core.core.c(this) {
                        /* class com.tencent.mm.live.view.LiveAnchorPluginLayout.u.AnonymousClass1 */
                        final /* synthetic */ u hWv;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.hWv = r1;
                        }

                        @Override // com.tencent.mm.live.core.core.c
                        public final void callback(int i2, Bundle bundle) {
                            AppMethodBeat.i(208522);
                            Log.i("MicroMsg.LiveCoreAnchor", "try resume live on enterRoom finish");
                            if (i2 >= 0) {
                                b.C0376b.a(this.hWv.hWk, b.c.hLB);
                                AppMethodBeat.o(208522);
                                return;
                            }
                            Log.w("MicroMsg.LiveCoreAnchor", "try resume live senter room fail");
                            com.tencent.mm.ui.base.u.makeText(this.hWv.hWk.getContext(), "enter room fail", 0).show();
                            b.C0376b.a(this.hWv.hWk, b.c.hLy);
                            AppMethodBeat.o(208522);
                        }
                    });
                }
            } else {
                LiveAnchorPluginLayout.a(this.hWk, intValue, str2);
            }
            kotlin.x xVar2 = kotlin.x.SXb;
            AppMethodBeat.o(208523);
            return xVar2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveAnchorPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(208544);
        e.h hVar = e.h.hya;
        this.curNetworkQuality = e.h.aCT();
        this.hWe = new ArrayList<>();
        this.hWf = true;
        this.hWh = com.tencent.mm.model.d.aTu();
        this.lastRotationFromSensor = -1;
        this.liveMessageCallback = new n(this);
        this.timerThread = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack) new s(this), true);
        AppMethodBeat.o(208544);
    }

    public static final /* synthetic */ void o(LiveAnchorPluginLayout liveAnchorPluginLayout) {
        AppMethodBeat.i(208546);
        liveAnchorPluginLayout.aJn();
        AppMethodBeat.o(208546);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class s implements MTimerHandler.CallBack {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        s(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            this.hWk = liveAnchorPluginLayout;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            int i2;
            AppMethodBeat.i(208520);
            com.tencent.mm.live.c.o oVar = this.hWk.hVT;
            if (oVar != null && oVar.hwr.getVisibility() == 0) {
                com.tencent.mm.live.c.o oVar2 = this.hWk.hVT;
                if (oVar2 != null) {
                    com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                    int i3 = com.tencent.mm.live.b.x.aGr().Gaz;
                    if (com.tencent.mm.kernel.g.aAf().azp()) {
                        int aWB = cl.aWB();
                        u.a aVar = com.tencent.mm.live.b.u.hIn;
                        oVar2.hPQ = u.a.a(aWB - i3, ":", false, false, false, 28);
                    }
                }
                com.tencent.mm.live.c.o oVar3 = this.hWk.hVT;
                if (oVar3 != null) {
                    if (oVar3.dMz) {
                        b.a aVar2 = com.tencent.mm.live.core.core.a.b.hyv;
                        oVar3.hwr.getContext();
                        i2 = b.a.aDo().hAz.hzL;
                    } else {
                        b.a aVar3 = com.tencent.mm.live.core.core.d.b.hCo;
                        oVar3.hwr.getContext();
                        i2 = b.a.aEf().hAz.hzL;
                    }
                    oVar3.hPP = i2;
                }
                com.tencent.mm.live.c.o oVar4 = this.hWk.hVT;
                if (oVar4 != null) {
                    com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                    int i4 = com.tencent.mm.live.b.x.aGr().LIa;
                    com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                    oVar4.db(i4, com.tencent.mm.live.b.x.aGr().LXG);
                }
            }
            AppMethodBeat.o(208520);
            return true;
        }
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.c.b
    public final void statusChange(b.c cVar, Bundle bundle) {
        int i2;
        com.tencent.mm.live.core.core.b.g aBV;
        com.tencent.mm.live.core.core.b.g aBV2;
        com.tencent.mm.live.core.core.b.g aBV3;
        com.tencent.mm.live.core.core.b.g aBV4;
        com.tencent.mm.live.core.core.b.g aBV5;
        com.tencent.mm.live.core.core.b.g aBV6;
        com.tencent.mm.live.core.core.a.a aVar;
        com.tencent.mm.live.core.core.b.g aBV7;
        int i3;
        String str;
        boolean z;
        String str2;
        AppMethodBeat.i(208525);
        kotlin.g.b.p.h(cVar, "status");
        Log.i(this.TAG, "statusChange:" + cVar.name());
        this.hWc = cVar;
        switch (b.haE[cVar.ordinal()]) {
            case 1:
                if (this.hWg) {
                    Context context = getContext();
                    if (context == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(208525);
                        throw tVar;
                    }
                    ((Activity) context).setRequestedOrientation(4);
                }
                switch (b.$EnumSwitchMapping$0[this.hWd.ordinal()]) {
                    case 1:
                        com.tencent.mm.live.b.r rVar = com.tencent.mm.live.b.r.hIg;
                        com.tencent.mm.live.b.r.qS(0);
                        ao aoVar = this.hVK;
                        if (aoVar != null) {
                            aoVar.rg(0);
                        }
                        ba baVar = this.hVG;
                        if (baVar != null) {
                            baVar.rg(8);
                        }
                        com.tencent.mm.live.c.t tVar2 = this.hVH;
                        if (tVar2 != null) {
                            tVar2.rg(8);
                        }
                        com.tencent.mm.live.c.k kVar = this.hVI;
                        if (kVar != null) {
                            kVar.rg(8);
                        }
                        com.tencent.mm.live.c.c cVar2 = this.hVJ;
                        if (cVar2 != null) {
                            cVar2.rg(8);
                        }
                        com.tencent.mm.live.c.m mVar = this.hVM;
                        if (mVar != null) {
                            mVar.rg(8);
                        }
                        x xVar = this.hVQ;
                        if (xVar != null) {
                            xVar.rg(8);
                        }
                        ay ayVar = this.hVO;
                        if (ayVar != null) {
                            ayVar.rg(8);
                        }
                        as asVar = this.hVL;
                        if (asVar != null) {
                            asVar.rg(8);
                        }
                        com.tencent.mm.live.c.i iVar = this.hVS;
                        if (iVar != null) {
                            iVar.rg(8);
                        }
                        ay ayVar2 = this.hVO;
                        if (ayVar2 != null) {
                            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                            String str3 = com.tencent.mm.live.b.x.aGr().LpF;
                            String str4 = str3 != null ? str3 : "";
                            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                            ayVar2.a(str4, com.tencent.mm.live.b.x.aGt());
                        }
                        statusChange(b.c.hMx, new Bundle());
                        break;
                    case 2:
                        statusChange(b.c.hLy, new Bundle());
                        break;
                }
            case 2:
                com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
                if (dVar != null) {
                    dVar.disable();
                }
                com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
                if (dVar2 != null) {
                    dVar2.a(null);
                }
                this.orientationEventListener = null;
                com.tencent.mm.live.b.c.a aVar2 = com.tencent.mm.live.b.c.a.hLc;
                cip aHm = com.tencent.mm.live.b.c.a.aHm();
                Log.i(this.TAG, "lockOrientation liveRotation:" + aHm.rotation + ", curRotation:" + getCurrentOrientation());
                if (aHm.rotation != -1 && aHm.rotation != getCurrentOrientation()) {
                    switch (aHm.rotation) {
                        case 0:
                        case 2:
                            this.hWi = true;
                            Context context2 = getContext();
                            if (context2 != null) {
                                ((Activity) context2).setRequestedOrientation(1);
                                break;
                            } else {
                                kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                                AppMethodBeat.o(208525);
                                throw tVar3;
                            }
                        case 1:
                        case 3:
                            this.hWi = true;
                            Context context3 = getContext();
                            if (context3 != null) {
                                ((Activity) context3).setRequestedOrientation(0);
                                break;
                            } else {
                                kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                                AppMethodBeat.o(208525);
                                throw tVar4;
                            }
                    }
                } else {
                    Context context4 = getContext();
                    if (context4 == null) {
                        kotlin.t tVar5 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(208525);
                        throw tVar5;
                    }
                    ((Activity) context4).setRequestedOrientation(14);
                }
                com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
                kotlin.g.b.p.g(aDD, "ConfigHelper.getInstance().videoConfig");
                Context context5 = getContext();
                kotlin.g.b.p.g(context5, "context");
                Resources resources = context5.getResources();
                kotlin.g.b.p.g(resources, "context.resources");
                aDD.eA(resources.getConfiguration().orientation == 1);
                String str5 = this.TAG;
                StringBuilder sb = new StringBuilder("create live, isVideoVertical:");
                com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC2, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD2 = aDC2.aDD();
                kotlin.g.b.p.g(aDD2, "ConfigHelper.getInstance().videoConfig");
                Log.i(str5, sb.append(aDD2.aDS()).toString());
                com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                civ aGr = com.tencent.mm.live.b.x.aGr();
                if (bundle == null || (str2 = bundle.getString("PARAM_START_LIVE_TITLE")) == null) {
                    str2 = "";
                }
                aGr.LpF = str2;
                com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
                String str6 = com.tencent.mm.live.b.x.aGr().LpF;
                kotlin.g.b.p.g(str6, "RoomLiveService.liveInfo.live_name");
                com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
                long j2 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
                String aGm = com.tencent.mm.live.b.x.aGm();
                Log.i(this.TAG, "startLive, name:" + str6 + ", roomId:" + j2);
                if (j2 == 0 || Util.isNullOrNil(aGm)) {
                    Log.i("MicroMsg.LiveCoreAnchor", "createNewLive, liveName:" + str6 + ", wechatRoomId:" + aGm);
                    Context context6 = getContext();
                    kotlin.g.b.p.g(context6, "context");
                    com.tencent.mm.live.b.l lVar = new com.tencent.mm.live.b.l(str6, aGm, context6);
                    com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
                    kotlin.g.b.p.g(aAg, "MMKernel.network()");
                    aAg.azz().a(3501, lVar);
                    com.tencent.mm.live.b.a.l lVar2 = new com.tencent.mm.live.b.a.l(lVar.name, lVar.roomId);
                    com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
                    kotlin.g.b.p.g(aAg2, "MMKernel.network()");
                    aAg2.azz().b(lVar2);
                    lVar.hFY = new b(this);
                } else {
                    Log.i(this.TAG, "try resume live, liveId:" + j2 + ", liveName:" + str6 + ", roomId:" + aGm);
                    com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.core.core.b.f aGv = com.tencent.mm.live.b.x.aGv();
                    if (aGv == null) {
                        new com.tencent.mm.live.b.k(j2, aGm, str6, (byte) 0).a(new u(this));
                    } else {
                        com.tencent.mm.live.core.core.a.a aVar3 = this.hSm;
                        if (aVar3 != null) {
                            aVar3.a(aGv);
                        }
                        com.tencent.mm.live.core.core.a.a aVar4 = this.hSm;
                        if (aVar4 != null) {
                            aVar4.a(new v(this));
                        }
                    }
                }
                com.tencent.mm.live.core.core.a.a aVar5 = this.hSm;
                if (aVar5 != null) {
                    aVar5.aBY();
                    break;
                }
                break;
            case 3:
                com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
                String str7 = com.tencent.mm.live.b.x.aGr().LpF;
                kotlin.g.b.p.g(str7, "RoomLiveService.liveInfo.live_name");
                com.tencent.mm.live.b.x xVar10 = com.tencent.mm.live.b.x.hJf;
                String aGm2 = com.tencent.mm.live.b.x.aGm();
                Context context7 = getContext();
                kotlin.g.b.p.g(context7, "context");
                com.tencent.mm.live.b.l lVar3 = new com.tencent.mm.live.b.l(str7, aGm2, context7);
                com.tencent.mm.kernel.b aAg3 = com.tencent.mm.kernel.g.aAg();
                kotlin.g.b.p.g(aAg3, "MMKernel.network()");
                aAg3.azz().a(3797, lVar3);
                com.tencent.mm.live.b.x xVar11 = com.tencent.mm.live.b.x.hJf;
                long j3 = com.tencent.mm.live.b.x.aGr().hyH;
                String str8 = lVar3.roomId;
                com.tencent.mm.live.b.x xVar12 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.a.o oVar = new com.tencent.mm.live.b.a.o(j3, str8, com.tencent.mm.live.b.x.aGq());
                com.tencent.mm.kernel.b aAg4 = com.tencent.mm.kernel.g.aAg();
                kotlin.g.b.p.g(aAg4, "MMKernel.network()");
                aAg4.azz().b(oVar);
                lVar3.hFZ = new m(this);
                break;
            case 4:
                this.hWh.aTv();
                ae aeVar = this.hVW;
                if (aeVar != null) {
                    aeVar.rg(8);
                }
                ae.a aVar6 = ae.hRk;
                postDelayed(new q(this), ae.aHE() + 50);
                com.tencent.mm.live.b.r.hIg.aGd();
                com.tencent.mm.live.b.r rVar2 = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.aFY();
                com.tencent.mm.live.b.x xVar13 = com.tencent.mm.live.b.x.hJf;
                if (com.tencent.mm.live.b.x.aGr().Gaz == 0) {
                    com.tencent.mm.live.b.x xVar14 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aGr().Gaz = cl.aWB();
                }
                com.tencent.mm.live.b.c.a aVar7 = com.tencent.mm.live.b.c.a.hLc;
                if (com.tencent.mm.live.b.c.a.aHm().hyH != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    com.tencent.mm.live.b.c.a aVar8 = com.tencent.mm.live.b.c.a.hLc;
                    com.tencent.mm.live.b.x xVar15 = com.tencent.mm.live.b.x.hJf;
                    long j4 = com.tencent.mm.live.b.x.aGr().hyH;
                    com.tencent.mm.live.b.x xVar16 = com.tencent.mm.live.b.x.hJf;
                    String aGm3 = com.tencent.mm.live.b.x.aGm();
                    int currentOrientation = getCurrentOrientation();
                    com.tencent.mm.live.b.x xVar17 = com.tencent.mm.live.b.x.hJf;
                    String aHe = com.tencent.mm.live.b.x.aHe();
                    com.tencent.mm.live.b.x xVar18 = com.tencent.mm.live.b.x.hJf;
                    int i4 = com.tencent.mm.live.b.x.aGr().Gaz;
                    com.tencent.mm.live.b.x xVar19 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.c.a.a(j4, aGm3, currentOrientation, aHe, i4, com.tencent.mm.live.b.x.aGt());
                }
                com.tencent.mm.live.b.x xVar20 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHf();
                com.tencent.mm.live.b.r rVar3 = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.qS(0);
                startTimer();
                break;
            case 5:
                com.tencent.mm.live.b.x xVar21 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGy();
                Context context8 = getContext();
                if (context8 != null) {
                    ((Activity) context8).finishAndRemoveTask();
                    break;
                } else {
                    kotlin.t tVar6 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(208525);
                    throw tVar6;
                }
            case 6:
                com.tencent.mm.live.c.g gVar = this.hVR;
                if (gVar != null && gVar.hON.isShowing()) {
                    gVar.hON.dismiss();
                }
                ae aeVar2 = this.hVW;
                if (aeVar2 != null) {
                    aeVar2.rg(8);
                }
                com.tencent.mm.live.core.core.a.a aVar9 = this.hSm;
                if (aVar9 != null) {
                    aVar9.aBW();
                }
                aJm();
                com.tencent.mm.live.b.x xVar22 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHh();
                com.tencent.mm.live.b.r rVar4 = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.aGa();
                com.tencent.mm.live.b.r rVar5 = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.aGb();
                com.tencent.mm.live.b.r.hIg.release();
                com.tencent.mm.live.b.m mVar2 = com.tencent.mm.live.b.m.hGg;
                com.tencent.mm.live.b.m.aFh();
                com.tencent.mm.live.b.c.a aVar10 = com.tencent.mm.live.b.c.a.hLc;
                com.tencent.mm.live.b.x xVar23 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.c.a.zE(com.tencent.mm.live.b.x.aGr().hyH);
                break;
            case 7:
                com.tencent.mm.live.b.x xVar24 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJn) {
                    aq aqVar = this.hVN;
                    if (aqVar != null) {
                        aqVar.rg(8);
                    }
                    ao aoVar2 = this.hVK;
                    if (aoVar2 != null) {
                        aoVar2.rg(8);
                    }
                    ba baVar2 = this.hVG;
                    if (baVar2 != null) {
                        baVar2.rg(8);
                    }
                    com.tencent.mm.live.c.t tVar7 = this.hVH;
                    if (tVar7 != null) {
                        tVar7.rg(8);
                    }
                    com.tencent.mm.live.c.k kVar2 = this.hVI;
                    if (kVar2 != null) {
                        kVar2.rg(8);
                    }
                    ae aeVar3 = this.hVW;
                    if (aeVar3 != null) {
                        com.tencent.mm.live.b.x xVar25 = com.tencent.mm.live.b.x.hJf;
                        String aGt = com.tencent.mm.live.b.x.aGt();
                        Context context9 = getContext();
                        kotlin.g.b.p.g(context9, "context");
                        String string = context9.getResources().getString(R.string.egq);
                        kotlin.g.b.p.g(string, "context.resources.getStr…_local_network_error_tip)");
                        aeVar3.showTipWithBlurBg(aGt, string);
                    }
                    com.tencent.mm.live.b.x xVar26 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aHg();
                    break;
                }
                break;
            case 8:
                com.tencent.mm.live.b.x xVar27 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJn) {
                    ao aoVar3 = this.hVK;
                    if (aoVar3 != null) {
                        aoVar3.rg(0);
                    }
                    com.tencent.mm.live.b.x xVar28 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aGD().hJp = false;
                    break;
                }
                break;
            case 9:
                if (this.hWg) {
                    Context context10 = getContext();
                    if (context10 != null) {
                        ((Activity) context10).setRequestedOrientation(4);
                        break;
                    } else {
                        kotlin.t tVar8 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(208525);
                        throw tVar8;
                    }
                }
                break;
            case 10:
                if (bundle == null || (str = bundle.getString("PARAM_LIVE_KICK_USERNAME")) == null) {
                    str = "";
                }
                kotlin.g.b.p.g(str, "param?.getString(ILiveSt…LIVE_KICK_USERNAME) ?: \"\"");
                com.tencent.mm.live.b.r rVar6 = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.GP(str);
                break;
            case 11:
                com.tencent.mm.live.b.x xVar29 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGD().hJq = true;
                break;
            case 12:
                ae aeVar4 = this.hVW;
                if (aeVar4 != null) {
                    aeVar4.rg(8);
                }
                com.tencent.mm.plugin.mmsight.model.d dVar3 = this.orientationEventListener;
                if (dVar3 != null) {
                    dVar3.a(this);
                }
                com.tencent.mm.plugin.mmsight.model.d dVar4 = this.orientationEventListener;
                if (dVar4 != null) {
                    dVar4.enable();
                }
                com.tencent.mm.live.b.x xVar30 = com.tencent.mm.live.b.x.hJf;
                if (com.tencent.mm.live.b.x.aGE().hJk) {
                    com.tencent.mm.live.c.t tVar9 = this.hVH;
                    if (tVar9 != null) {
                        tVar9.rg(0);
                    }
                    statusChange(b.c.hLw, new Bundle());
                    com.tencent.mm.live.b.x xVar31 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aGE().hJk = false;
                    break;
                }
                break;
            case 13:
                com.tencent.mm.live.b.x xVar32 = com.tencent.mm.live.b.x.hJf;
                if (com.tencent.mm.live.b.x.aGL()) {
                    i3 = 4;
                } else {
                    i3 = 5;
                }
                com.tencent.mm.live.b.x xVar33 = com.tencent.mm.live.b.x.hJf;
                String aGm4 = com.tencent.mm.live.b.x.aGm();
                com.tencent.mm.live.b.x xVar34 = com.tencent.mm.live.b.x.hJf;
                boolean aGI = com.tencent.mm.live.b.x.aGI();
                com.tencent.mm.live.b.x xVar35 = com.tencent.mm.live.b.x.hJf;
                boolean aGJ = com.tencent.mm.live.b.x.aGJ();
                com.tencent.mm.live.b.x xVar36 = com.tencent.mm.live.b.x.hJf;
                String str9 = com.tencent.mm.live.b.x.aGr().LpF;
                com.tencent.mm.live.b.x xVar37 = com.tencent.mm.live.b.x.hJf;
                boolean aGH = com.tencent.mm.live.b.x.aGH();
                Context context11 = getContext();
                kotlin.g.b.p.g(context11, "context");
                Resources resources2 = context11.getResources();
                kotlin.g.b.p.g(resources2, "context.resources");
                com.tencent.mm.live.d.e.a(aGm4, aGI, aGJ, str9, aGH, resources2.getConfiguration().orientation, i3);
                Context context12 = getContext();
                kotlin.g.b.p.g(context12, "context");
                Resources resources3 = context12.getResources();
                kotlin.g.b.p.g(resources3, "context.resources");
                if (resources3.getConfiguration().orientation != 2) {
                    com.tencent.mm.live.d.a.aIg();
                    break;
                } else {
                    com.tencent.mm.live.d.a.aIf();
                    break;
                }
            case 14:
                com.tencent.mm.live.b.x xVar38 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJn) {
                    aq aqVar2 = this.hVN;
                    if (aqVar2 != null) {
                        aqVar2.rg(8);
                    }
                    ao aoVar4 = this.hVK;
                    if (aoVar4 != null) {
                        aoVar4.rg(8);
                    }
                    ba baVar3 = this.hVG;
                    if (baVar3 != null) {
                        baVar3.rg(8);
                    }
                    com.tencent.mm.live.c.t tVar10 = this.hVH;
                    if (tVar10 != null) {
                        tVar10.rg(8);
                    }
                    com.tencent.mm.live.c.k kVar3 = this.hVI;
                    if (kVar3 != null) {
                        kVar3.rg(8);
                    }
                    ae aeVar5 = this.hVW;
                    if (aeVar5 != null) {
                        com.tencent.mm.live.b.x xVar39 = com.tencent.mm.live.b.x.hJf;
                        String aGt2 = com.tencent.mm.live.b.x.aGt();
                        Context context13 = getContext();
                        kotlin.g.b.p.g(context13, "context");
                        String string2 = context13.getResources().getString(R.string.egq);
                        kotlin.g.b.p.g(string2, "context.resources.getStr…_local_network_error_tip)");
                        aeVar5.showTipWithBlurBg(aGt2, string2);
                    }
                    com.tencent.mm.live.b.x xVar40 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aHg();
                }
                com.tencent.mm.live.b.x xVar41 = com.tencent.mm.live.b.x.hJf;
                String aGm5 = com.tencent.mm.live.b.x.aGm();
                com.tencent.mm.live.b.x xVar42 = com.tencent.mm.live.b.x.hJf;
                boolean aGI2 = com.tencent.mm.live.b.x.aGI();
                com.tencent.mm.live.b.x xVar43 = com.tencent.mm.live.b.x.hJf;
                boolean aGJ2 = com.tencent.mm.live.b.x.aGJ();
                com.tencent.mm.live.b.x xVar44 = com.tencent.mm.live.b.x.hJf;
                String str10 = com.tencent.mm.live.b.x.aGr().LpF;
                com.tencent.mm.live.b.x xVar45 = com.tencent.mm.live.b.x.hJf;
                boolean aGH2 = com.tencent.mm.live.b.x.aGH();
                Context context14 = getContext();
                kotlin.g.b.p.g(context14, "context");
                Resources resources4 = context14.getResources();
                kotlin.g.b.p.g(resources4, "context.resources");
                com.tencent.mm.live.d.e.a(aGm5, aGI2, aGJ2, str10, aGH2, resources4.getConfiguration().orientation, 6, bundle != null ? bundle.getInt("live_user_exit_reason") : 0);
                break;
            case 15:
                ao aoVar5 = this.hVK;
                if (aoVar5 != null) {
                    aoVar5.hAs.hER.aEZ();
                }
                com.tencent.mm.live.core.core.a.a aVar11 = this.hSm;
                if (!(aVar11 == null || (aBV6 = aVar11.aBV()) == null || !aBV6.aDu() || (aVar = this.hSm) == null || (aBV7 = aVar.aBV()) == null)) {
                    aBV7.hzB = g.b.VIDEO_LINK_MIC;
                    break;
                }
            case 16:
            case 17:
                com.tencent.mm.live.core.core.a.a aVar12 = this.hSm;
                if (!(aVar12 == null || (aBV5 = aVar12.aBV()) == null)) {
                    aBV5.hzE = g.d.NORMAL_MODE;
                    break;
                }
            case 18:
                com.tencent.mm.live.core.core.a.a aVar13 = this.hSm;
                if (!(aVar13 == null || (aBV4 = aVar13.aBV()) == null)) {
                    aBV4.hzE = g.d.PERMISSION_MODE;
                    break;
                }
            case 19:
                com.tencent.mm.live.core.core.a.a aVar14 = this.hSm;
                if (!(aVar14 == null || (aBV3 = aVar14.aBV()) == null || aBV3.isFloatMode())) {
                    int i5 = bundle != null ? bundle.getInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0) : 0;
                    com.tencent.mm.live.core.core.a.a aVar15 = this.hSm;
                    if (aVar15 != null) {
                        Context context15 = getContext();
                        kotlin.g.b.p.g(context15, "context");
                        b.a.a(aVar15, context15, false, false, i5, 0, 22);
                    }
                    com.tencent.mm.live.b.x xVar46 = com.tencent.mm.live.b.x.hJf;
                    String aGm6 = com.tencent.mm.live.b.x.aGm();
                    com.tencent.mm.live.b.x xVar47 = com.tencent.mm.live.b.x.hJf;
                    long j5 = com.tencent.mm.live.b.x.aGr().hyH;
                    com.tencent.mm.live.b.x xVar48 = com.tencent.mm.live.b.x.hJf;
                    String aGt3 = com.tencent.mm.live.b.x.aGt();
                    com.tencent.mm.live.b.x xVar49 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.d.e.a(aGm6, j5, aGt3, 2, 1, com.tencent.mm.live.b.x.aGr().LIa);
                    com.tencent.mm.live.d.a.aId();
                    break;
                }
            case 20:
                com.tencent.mm.live.b.x xVar50 = com.tencent.mm.live.b.x.hJf;
                String aGm7 = com.tencent.mm.live.b.x.aGm();
                com.tencent.mm.live.b.x xVar51 = com.tencent.mm.live.b.x.hJf;
                long j6 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar52 = com.tencent.mm.live.b.x.hJf;
                String aGt4 = com.tencent.mm.live.b.x.aGt();
                com.tencent.mm.live.b.x xVar53 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.d.e.a(aGm7, j6, aGt4, 2, 0, com.tencent.mm.live.b.x.aGr().LIa);
                com.tencent.mm.live.d.a.aIe();
                break;
            case 21:
                com.tencent.mm.live.core.core.a.a aVar16 = this.hSm;
                if (!(aVar16 == null || (aBV2 = aVar16.aBV()) == null)) {
                    aBV2.hzB = g.b.AUDIO_LINK_MIC;
                    break;
                }
            case 22:
                com.tencent.mm.live.core.core.a.a aVar17 = this.hSm;
                if (!(aVar17 == null || (aBV = aVar17.aBV()) == null)) {
                    aBV.hzB = g.b.NO_LINK_MIC;
                }
                ak akVar = this.hVX;
                if (akVar != null) {
                    this.hWe.remove(akVar);
                    break;
                }
                break;
            case 23:
                com.tencent.mm.live.core.core.trtc.a.a aDC3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC3, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD3 = aDC3.aDD();
                kotlin.g.b.p.g(aDD3, "ConfigHelper.getInstance().videoConfig");
                com.tencent.mm.live.b.x xVar54 = com.tencent.mm.live.b.x.hJf;
                aDD3.eB(!com.tencent.mm.live.b.x.aGG().isLandscape());
                com.tencent.mm.live.core.core.a.a aVar18 = this.hSm;
                if (aVar18 != null) {
                    aVar18.A(0.0f, 0.0f);
                }
                ao aoVar6 = this.hVK;
                if (aoVar6 != null) {
                    com.tencent.mm.live.b.x xVar55 = com.tencent.mm.live.b.x.hJf;
                    if (com.tencent.mm.live.b.x.aGG().isLandscape()) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    com.tencent.mm.live.b.x xVar56 = com.tencent.mm.live.b.x.hJf;
                    String str11 = com.tencent.mm.live.b.x.aGG().userId;
                    com.tencent.mm.live.b.x xVar57 = com.tencent.mm.live.b.x.hJf;
                    int i6 = com.tencent.mm.live.b.x.aGG().streamType;
                    kotlin.g.b.p.h(str11, "userId");
                    aoVar6.hAs.c(i2, str11, i6);
                    break;
                }
                break;
            case 24:
                com.tencent.mm.live.b.x xVar58 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJn) {
                    aq aqVar3 = this.hVN;
                    if (aqVar3 != null) {
                        aqVar3.rg(8);
                    }
                    ao aoVar7 = this.hVK;
                    if (aoVar7 != null) {
                        aoVar7.rg(8);
                    }
                    ba baVar4 = this.hVG;
                    if (baVar4 != null) {
                        baVar4.rg(8);
                    }
                    com.tencent.mm.live.c.t tVar11 = this.hVH;
                    if (tVar11 != null) {
                        tVar11.rg(8);
                    }
                    com.tencent.mm.live.c.k kVar4 = this.hVI;
                    if (kVar4 != null) {
                        kVar4.rg(8);
                    }
                    ae aeVar6 = this.hVW;
                    if (aeVar6 != null) {
                        aeVar6.rg(8);
                    }
                    com.tencent.mm.live.c.r rVar7 = this.hWb;
                    if (rVar7 != null) {
                        rVar7.rg(0);
                    }
                    com.tencent.mm.live.b.x xVar59 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aHg();
                    Context context16 = getContext();
                    if (context16 != null) {
                        ((Activity) context16).setRequestedOrientation(1);
                        break;
                    } else {
                        kotlin.t tVar12 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(208525);
                        throw tVar12;
                    }
                }
                break;
            case 25:
                ay ayVar3 = this.hVO;
                if (ayVar3 != null) {
                    com.tencent.mm.live.b.x xVar60 = com.tencent.mm.live.b.x.hJf;
                    String str12 = com.tencent.mm.live.b.x.aGr().LpF;
                    kotlin.g.b.p.g(str12, "RoomLiveService.liveInfo.live_name");
                    com.tencent.mm.live.b.x xVar61 = com.tencent.mm.live.b.x.hJf;
                    ayVar3.a(str12, com.tencent.mm.live.b.x.aGt());
                    break;
                }
                break;
        }
        super.statusChange(cVar, bundle);
        AppMethodBeat.o(208525);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class q implements Runnable {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        q(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            this.hWk = liveAnchorPluginLayout;
        }

        public final void run() {
            AppMethodBeat.i(208518);
            ae aeVar = this.hWk.hVW;
            if (aeVar != null) {
                aeVar.hwr.setVisibility(8);
                AppMethodBeat.o(208518);
                return;
            }
            AppMethodBeat.o(208518);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x0530  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0537  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x053e  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0546  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x054d  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0554  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x055b  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0562  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0569  */
    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    @android.annotation.SuppressLint({"SourceLockedOrientationActivity"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initLogic(com.tencent.mm.live.api.LiveConfig r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 1400
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.view.LiveAnchorPluginLayout.initLogic(com.tencent.mm.live.api.LiveConfig, boolean):void");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onCallStateChanged(int i2, String str) {
        com.tencent.mm.live.core.core.b.g aBV;
        com.tencent.mm.live.core.core.b.g aBV2;
        com.tencent.mm.live.core.core.b.g aBV3;
        AppMethodBeat.i(208527);
        kotlin.g.b.p.h(str, "incomingNumber");
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("onCallStateChanged state:").append(i2).append(", isFloatMode:");
        com.tencent.mm.live.core.core.a.a aVar = this.hSm;
        Log.i(str2, append.append((aVar == null || (aBV3 = aVar.aBV()) == null) ? null : Boolean.valueOf(aBV3.isFloatMode())).toString());
        switch (i2) {
            case 0:
                com.tencent.mm.live.b.r rVar = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.qS(0);
                com.tencent.mm.live.core.core.a.a aVar2 = this.hSm;
                if (aVar2 == null || (aBV = aVar2.aBV()) == null) {
                    AppMethodBeat.o(208527);
                    return;
                }
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                if (aBV.b(Long.valueOf(com.tencent.mm.live.b.x.aGr().hyH))) {
                    ao aoVar = this.hVK;
                    if (aoVar != null) {
                        aoVar.startPreview();
                    }
                    com.tencent.mm.live.core.core.a.a aVar3 = this.hSm;
                    if (aVar3 != null) {
                        aVar3.aBY();
                        AppMethodBeat.o(208527);
                        return;
                    }
                }
                break;
            case 1:
                AppMethodBeat.o(208527);
                return;
            case 2:
                com.tencent.mm.live.b.r rVar2 = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.qS(2);
                com.tencent.mm.live.core.core.a.a aVar4 = this.hSm;
                if (aVar4 == null || (aBV2 = aVar4.aBV()) == null || !aBV2.isFloatMode()) {
                    com.tencent.mm.live.core.core.a.a aVar5 = this.hSm;
                    if (aVar5 != null) {
                        aVar5.aBS();
                    }
                    com.tencent.mm.live.core.core.a.a aVar6 = this.hSm;
                    if (aVar6 != null) {
                        aVar6.aBX();
                        AppMethodBeat.o(208527);
                        return;
                    }
                    AppMethodBeat.o(208527);
                    return;
                }
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGy();
                com.tencent.mm.live.core.core.a.a aVar7 = this.hSm;
                if (aVar7 != null) {
                    aVar7.aBS();
                }
                com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHi();
                AppMethodBeat.o(208527);
                return;
        }
        AppMethodBeat.o(208527);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onRotationSwitchChange(boolean z) {
        this.hWg = z;
    }

    private final void a(float f2, float f3, kotlin.g.a.a<kotlin.x> aVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(208528);
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
        AppMethodBeat.o(208528);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final int getRelativeLayoutId() {
        return R.layout.b0h;
    }

    @Override // com.tencent.mm.live.c.b
    public final int getLiveRole() {
        return 1;
    }

    @Override // com.tencent.mm.live.view.a
    public final String name() {
        AppMethodBeat.i(208529);
        String simpleName = getClass().getSimpleName();
        kotlin.g.b.p.g(simpleName, "this.javaClass.simpleName");
        AppMethodBeat.o(208529);
        return simpleName;
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.view.RoomBaseLivePluginLayout
    public final void mount() {
        AppMethodBeat.i(208530);
        super.mount();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3806, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg2, "MMKernel.network()");
        aAg2.azz().a(3559, this);
        com.tencent.mm.kernel.b aAg3 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg3, "MMKernel.network()");
        aAg3.azz().a(3557, this);
        AppMethodBeat.o(208530);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.view.RoomBaseLivePluginLayout
    public final void unMount() {
        com.tencent.mm.live.c.g gVar;
        a.C0371a selectUser;
        com.tencent.mm.live.core.core.a.a aVar;
        com.tencent.mm.live.core.core.b.g aBV;
        com.tencent.mm.live.core.core.b.g aBV2;
        AppMethodBeat.i(208531);
        super.unMount();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3806, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(3559, this);
        com.tencent.mm.kernel.b aAg3 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(aAg3, "MMKernel.network()");
        aAg3.azz().b(3557, this);
        if (!aJo() && !this.hWi) {
            com.tencent.mm.live.core.core.a.a aVar2 = this.hSm;
            if (!(((aVar2 == null || (aBV2 = aVar2.aBV()) == null || !aBV2.aDu()) && ((aVar = this.hSm) == null || (aBV = aVar.aBV()) == null || !aBV.aDt())) || (gVar = this.hVR) == null || (selectUser = gVar.hOM.getSelectUser()) == null)) {
                com.tencent.mm.live.b.r rVar = com.tencent.mm.live.b.r.hIg;
                com.tencent.mm.live.b.r.aw(selectUser.hFz, selectUser.hFG);
            }
            com.tencent.mm.live.b.r rVar2 = com.tencent.mm.live.b.r.hIg;
            com.tencent.mm.live.b.r.qS(1);
            aJm();
            com.tencent.mm.live.b.r.hIg.release();
            com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
            com.tencent.mm.live.b.m.aFh();
            com.tencent.mm.live.core.core.a.a aVar3 = this.hSm;
            if (aVar3 != null) {
                aVar3.aBW();
            }
            b.a aVar4 = com.tencent.mm.live.core.core.a.b.hyv;
            b.a.releaseInstance();
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.and();
            this.hWh.apm();
        }
        this.timerThread.stopTimer();
        AppMethodBeat.o(208531);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void start() {
        AppMethodBeat.i(208532);
        super.start();
        com.tencent.mm.live.b.r rVar = com.tencent.mm.live.b.r.hIg;
        com.tencent.mm.live.b.r.aGb();
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGr().hyH == 0 && this.hWg) {
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            if (!com.tencent.mm.live.b.x.aGD().hJn) {
                com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJq) {
                    com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                    if (!com.tencent.mm.live.b.x.aGD().hJp) {
                        Context context = getContext();
                        if (context == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                            AppMethodBeat.o(208532);
                            throw tVar;
                        }
                        ((Activity) context).setRequestedOrientation(4);
                    }
                }
            }
        }
        startTimer();
        AppMethodBeat.o(208532);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void stop() {
        AppMethodBeat.i(208533);
        super.stop();
        this.timerThread.stopTimer();
        AppMethodBeat.o(208533);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(208534);
        boolean onBackPress = super.onBackPress();
        if (!onBackPress) {
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            if (!com.tencent.mm.live.b.x.aGD().hJp) {
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                if (com.tencent.mm.live.b.x.aGD().hJo) {
                    b.C0376b.a(this, b.c.hLC);
                    onBackPress = true;
                }
            }
        }
        AppMethodBeat.o(208534);
        return onBackPress;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        int i4 = 0;
        AppMethodBeat.i(208535);
        Log.i(this.TAG, "errType:" + i2 + " errCode:" + i3);
        if (qVar instanceof com.tencent.mm.live.b.a.b) {
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJn) {
                    com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                    if (!com.tencent.mm.live.b.x.aGD().hJp) {
                        com.tencent.mm.live.c.i iVar = this.hVS;
                        if (iVar != null) {
                            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                            iVar.hOV = com.tencent.mm.live.b.x.aGr().KNv;
                        }
                        com.tencent.mm.live.c.i iVar2 = this.hVS;
                        if (iVar2 != null) {
                            iVar2.aHu();
                        }
                        com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                        com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
                        if (!com.tencent.mm.live.b.x.aGr().KNv) {
                            i4 = cl.aWB();
                        }
                        com.tencent.mm.live.b.x.qT(i4);
                        com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
                        if (com.tencent.mm.live.b.x.aGr().pSb > 0) {
                            b.C0376b.a(this, b.c.hLV);
                        }
                        AppMethodBeat.o(208535);
                        return;
                    }
                }
                AppMethodBeat.o(208535);
                return;
            }
        } else if (qVar instanceof com.tencent.mm.live.b.a.p) {
            ai aiVar = this.hVP;
            if (aiVar != null) {
                if (i2 == 0 && i3 == 0) {
                    i4 = 1;
                }
                com.tencent.mm.ui.base.q qVar2 = aiVar.hRS;
                if (qVar2 != null) {
                    qVar2.dismiss();
                }
                if (i4 != 0) {
                    Context context = aiVar.hwr.getContext();
                    Context context2 = aiVar.hwr.getContext();
                    kotlin.g.b.p.g(context2, "root.context");
                    com.tencent.mm.ui.base.u.cG(context, context2.getResources().getString(R.string.egx));
                    AppMethodBeat.o(208535);
                    return;
                }
                Context context3 = aiVar.hwr.getContext();
                Context context4 = aiVar.hwr.getContext();
                kotlin.g.b.p.g(context4, "root.context");
                com.tencent.mm.ui.base.u.cH(context3, context4.getResources().getString(R.string.egw));
                AppMethodBeat.o(208535);
                return;
            }
            AppMethodBeat.o(208535);
            return;
        } else if ((qVar instanceof com.tencent.mm.live.b.a.u) && !(i2 == 0 && i3 == 0)) {
            int i5 = this.hWj;
            o.a aVar = com.tencent.mm.live.b.o.hGl;
            if (i5 < com.tencent.mm.live.b.o.hGk) {
                this.hWj++;
                Log.i(this.TAG, "will retry share live, delay:" + (((long) this.hWj) * 1000));
                postDelayed(o.hWu, ((long) this.hWj) * 1000);
            }
        }
        AppMethodBeat.o(208535);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class o implements Runnable {
        public static final o hWu = new o();

        static {
            AppMethodBeat.i(208516);
            AppMethodBeat.o(208516);
        }

        o() {
        }

        public final void run() {
            AppMethodBeat.i(208515);
            com.tencent.mm.live.b.r rVar = com.tencent.mm.live.b.r.hIg;
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.r.GO(com.tencent.mm.live.b.x.aGm());
            AppMethodBeat.o(208515);
        }
    }

    private final void startTimer() {
        AppMethodBeat.i(208536);
        this.timerThread.stopTimer();
        this.timerThread.startTimer(1000);
        AppMethodBeat.o(208536);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class e implements f.c {
        public static final e hWp = new e();

        static {
            AppMethodBeat.i(208502);
            AppMethodBeat.o(208502);
        }

        e() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class f implements DialogInterface.OnDismissListener {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        f(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            this.hWk = liveAnchorPluginLayout;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(208503);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.aHg();
            b.C0376b.a(this.hWk, b.c.hLD);
            AppMethodBeat.o(208503);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/view/LiveAnchorPluginLayout$handleJoinLiveFail$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
    public static final class i extends com.tencent.mm.plugin.messenger.a.a {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX WARN: Incorrect types in method signature: (I)V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            super(1);
            this.hWk = liveAnchorPluginLayout;
        }

        @Override // com.tencent.mm.plugin.messenger.a.a
        public final void onClickImp(View view) {
            AppMethodBeat.i(208506);
            kotlin.g.b.p.h(view, "widget");
            Intent intent = new Intent();
            o.a aVar = com.tencent.mm.live.b.o.hGl;
            intent.putExtra("rawUrl", com.tencent.mm.live.b.o.hGj);
            intent.putExtra("showShare", false);
            com.tencent.mm.br.c.f(this.hWk.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            AppMethodBeat.o(208506);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class g implements f.c {
        public static final g hWq = new g();

        static {
            AppMethodBeat.i(208504);
            AppMethodBeat.o(208504);
        }

        g() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class h implements DialogInterface.OnDismissListener {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        h(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            this.hWk = liveAnchorPluginLayout;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(208505);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.aHg();
            b.C0376b.a(this.hWk, b.c.hLD);
            AppMethodBeat.o(208505);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/live/view/LiveAnchorPluginLayout$tryResumeLive$2", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class v implements com.tencent.mm.live.core.core.c {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        v(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            this.hWk = liveAnchorPluginLayout;
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(208524);
            Log.i("MicroMsg.LiveCoreAnchor", "try resume live on enterRoom finish");
            if (i2 >= 0) {
                b.C0376b.a(this.hWk, b.c.hLB);
                AppMethodBeat.o(208524);
                return;
            }
            Log.w("MicroMsg.LiveCoreAnchor", "try resume live senter room fail");
            com.tencent.mm.ui.base.u.makeText(this.hWk.getContext(), "enter room fail", 0).show();
            b.C0376b.a(this.hWk, b.c.hLy);
            AppMethodBeat.o(208524);
        }
    }

    private final void aJm() {
        AppMethodBeat.i(208537);
        Log.i("MicroMsg.LiveCoreAnchor", "stopLive");
        com.tencent.mm.live.core.core.a.a aVar = this.hSm;
        if (aVar != null) {
            aVar.b(new r());
            AppMethodBeat.o(208537);
            return;
        }
        AppMethodBeat.o(208537);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/live/view/LiveAnchorPluginLayout$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class r implements com.tencent.mm.live.core.core.c {
        r() {
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(208519);
            Log.i("MicroMsg.LiveCoreAnchor", "on exitRoom finish");
            AppMethodBeat.o(208519);
        }
    }

    private final void aJn() {
        AppMethodBeat.i(208538);
        f.a hbu = new f.a(getContext()).hbu();
        Context context = getContext();
        kotlin.g.b.p.g(context, "context");
        hbu.aC(context.getResources().getString(R.string.efn)).apa(R.string.w0).b(c.hWo).b(new d(this)).show();
        AppMethodBeat.o(208538);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class c implements f.c {
        public static final c hWo = new c();

        static {
            AppMethodBeat.i(208500);
            AppMethodBeat.o(208500);
        }

        c() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class d implements DialogInterface.OnDismissListener {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        d(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            this.hWk = liveAnchorPluginLayout;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(208501);
            b.C0376b.a(this.hWk, b.c.hLD);
            AppMethodBeat.o(208501);
        }
    }

    private final boolean aJo() {
        AppMethodBeat.i(208539);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGD().hJo) {
            com.tencent.mm.live.b.c.a aVar = com.tencent.mm.live.b.c.a.hLc;
            cip aHm = com.tencent.mm.live.b.c.a.aHm();
            if (aHm.rotation == -1 || aHm.rotation == getCurrentOrientation()) {
                AppMethodBeat.o(208539);
                return false;
            }
            AppMethodBeat.o(208539);
            return true;
        }
        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.getLastOrientation() != -1) {
            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
            if (com.tencent.mm.live.b.x.getLastOrientation() != getCurrentOrientation()) {
                AppMethodBeat.o(208539);
                return true;
            }
        }
        AppMethodBeat.o(208539);
        return false;
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void resume() {
        com.tencent.mm.live.core.core.b.g aBV;
        com.tencent.mm.live.core.core.a.a aVar;
        com.tencent.mm.live.core.core.b.g aBV2;
        com.tencent.mm.live.core.core.a.a aVar2;
        com.tencent.mm.live.core.core.a.a aVar3;
        com.tencent.mm.live.core.core.b.g aBV3;
        com.tencent.mm.live.core.core.b.g aBV4;
        AppMethodBeat.i(208540);
        super.resume();
        Log.d(this.TAG, "resume curRotation:" + getCurrentOrientation());
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aGD().hJq = false;
        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGr().hyH != 0) {
            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
            if (!com.tencent.mm.live.b.x.aGD().hJn) {
                com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
                kotlin.g.b.p.g(azz, "MMKernel.getNetSceneQueue()");
                if (azz.azD() != null) {
                    com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                    long j2 = com.tencent.mm.live.b.x.aGr().hyH;
                    com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.a.b bVar = new com.tencent.mm.live.b.a.b(j2, com.tencent.mm.live.b.x.aGm(), true);
                    com.tencent.mm.ak.t azz2 = com.tencent.mm.kernel.g.azz();
                    kotlin.g.b.p.g(azz2, "MMKernel.getNetSceneQueue()");
                    bVar.doScene(azz2.azD(), new p(this));
                }
                aVar3 = this.hSm;
                if (aVar3 != null || (aBV4 = aVar3.aBV()) == null || aBV4.hzz) {
                    com.tencent.mm.live.core.core.a.a aVar4 = this.hSm;
                    if (!(aVar4 == null || (aBV3 = aVar4.aBV()) == null)) {
                        aBV3.hzz = false;
                    }
                } else {
                    com.tencent.mm.live.core.core.a.a aVar5 = this.hSm;
                    if (aVar5 != null) {
                        aVar5.aBU();
                    }
                }
                com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.setLastOrientation(getCurrentOrientation());
                AppMethodBeat.o(208540);
            }
        }
        ao aoVar = this.hVK;
        if (aoVar != null) {
            aoVar.startPreview();
        }
        com.tencent.mm.live.core.core.a.a aVar6 = this.hSm;
        if (!(aVar6 == null || (aBV = aVar6.aBV()) == null || !aBV.isNormalMode() || (aVar = this.hSm) == null || (aBV2 = aVar.aBV()) == null)) {
            com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
            if (aBV2.b(Long.valueOf(com.tencent.mm.live.b.x.aGr().hyH)) && (aVar2 = this.hSm) != null) {
                aVar2.aBY();
            }
        }
        aVar3 = this.hSm;
        if (aVar3 != null) {
        }
        com.tencent.mm.live.core.core.a.a aVar42 = this.hSm;
        aBV3.hzz = false;
        com.tencent.mm.live.b.x xVar62 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.setLastOrientation(getCurrentOrientation());
        AppMethodBeat.o(208540);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
    static final class p implements com.tencent.mm.ak.i {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        p(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            this.hWk = liveAnchorPluginLayout;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            com.tencent.mm.live.core.core.b.g aBV;
            com.tencent.mm.live.core.core.b.g aBV2;
            com.tencent.mm.live.core.core.a.a aVar;
            AppMethodBeat.i(208517);
            qVar.setHasCallbackToQueue(true);
            if (i2 == 0 && i3 == 0) {
                if (qVar == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
                    AppMethodBeat.o(208517);
                    throw tVar;
                }
                civ aGr = ((com.tencent.mm.live.b.a.b) qVar).aGr();
                if (aGr == null) {
                    AppMethodBeat.o(208517);
                    return;
                } else if (aGr.pSb == 0) {
                    com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                    if (!com.tencent.mm.live.b.x.aGD().hJn) {
                        ao aoVar = this.hWk.hVK;
                        if (aoVar != null) {
                            aoVar.startPreview();
                        }
                        com.tencent.mm.live.core.core.a.a aVar2 = this.hWk.hSm;
                        if (aVar2 == null || (aBV = aVar2.aBV()) == null) {
                            AppMethodBeat.o(208517);
                            return;
                        } else if (aBV.isNormalMode()) {
                            com.tencent.mm.live.core.core.a.a aVar3 = this.hWk.hSm;
                            if (aVar3 == null || (aBV2 = aVar3.aBV()) == null) {
                                AppMethodBeat.o(208517);
                                return;
                            }
                            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                            if (aBV2.b(Long.valueOf(com.tencent.mm.live.b.x.aGr().hyH)) && (aVar = this.hWk.hSm) != null) {
                                aVar.aBY();
                                AppMethodBeat.o(208517);
                                return;
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(208517);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008e  */
    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void pause() {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.view.LiveAnchorPluginLayout.pause():void");
    }

    @Override // com.tencent.mm.plugin.mmsight.model.d.a
    public final void onOrientationChange(int i2) {
        AppMethodBeat.i(208542);
        if (this.lastRotationFromSensor == -1 || this.lastRotationFromSensor != i2) {
            Log.i(this.TAG, "onOrientationChange orientation:".concat(String.valueOf(i2)));
            this.lastRotationFromSensor = i2;
            Log.i(this.TAG, "refreshCamera");
            com.tencent.mm.live.core.core.a.a aVar = this.hSm;
            if (aVar != null) {
                aVar.aBT();
                AppMethodBeat.o(208542);
                return;
            }
        }
        AppMethodBeat.o(208542);
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a3  */
    @Override // com.tencent.mm.live.core.core.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void callback(int r11, android.os.Bundle r12) {
        /*
        // Method dump skipped, instructions count: 764
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.view.LiveAnchorPluginLayout.callback(int, android.os.Bundle):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            super(0);
            this.hWk = liveAnchorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(208514);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.live.view.LiveAnchorPluginLayout.n.AnonymousClass1 */
                final /* synthetic */ n hWt;

                {
                    this.hWt = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(208513);
                    com.tencent.mm.live.c.m mVar = this.hWt.hWk.hVM;
                    if (mVar != null) {
                        mVar.aHx();
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(208513);
                    return xVar;
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(208514);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ LiveAnchorPluginLayout hWk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(LiveAnchorPluginLayout liveAnchorPluginLayout) {
            super(0);
            this.hWk = liveAnchorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(208521);
            if (this.hWk.hWf) {
                for (T t : this.hWk.getPluginList()) {
                    if (t instanceof com.tencent.mm.live.c.a) {
                        if (!kotlin.a.j.listOf((Object[]) new com.tencent.mm.live.c.a[]{this.hWk.hVK, this.hWk.hVW}).contains(t) && t.hwr.getVisibility() == 0) {
                            t.rg(4);
                            this.hWk.hWe.add(t);
                        }
                    }
                }
            } else {
                for (com.tencent.mm.live.c.a aVar : this.hWk.hWe) {
                    aVar.rg(0);
                }
                this.hWk.hWe.clear();
            }
            LiveAnchorPluginLayout liveAnchorPluginLayout = this.hWk;
            liveAnchorPluginLayout.hWf = !this.hWk.hWf;
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(208521);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(LiveAnchorPluginLayout liveAnchorPluginLayout, float f2, float f3) {
        AppMethodBeat.i(208545);
        Log.i(liveAnchorPluginLayout.TAG, "toggleShowPlugins, pluginShow:" + liveAnchorPluginLayout.hWf);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJn) {
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            if (!com.tencent.mm.live.b.x.aGD().hJp) {
                com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                if (com.tencent.mm.live.b.x.aGD().hJo) {
                    liveAnchorPluginLayout.a(f2, f3, new t(liveAnchorPluginLayout));
                }
            }
        }
        AppMethodBeat.o(208545);
    }

    public static final /* synthetic */ void a(LiveAnchorPluginLayout liveAnchorPluginLayout, int i2, String str) {
        AppMethodBeat.i(208547);
        Log.i(liveAnchorPluginLayout.TAG, "join live room errCode:" + i2 + " errMsg:" + str);
        switch (i2) {
            case -100069:
                if (Util.isNullOrNil(str)) {
                    Context context = liveAnchorPluginLayout.getContext();
                    kotlin.g.b.p.g(context, "context");
                    str = context.getResources().getString(R.string.ehm);
                }
                new f.a(liveAnchorPluginLayout.getContext()).hbu().bow(str).apa(R.string.w0).b(g.hWq).b(new h(liveAnchorPluginLayout)).show();
                AppMethodBeat.o(208547);
                return;
            case -100068:
            case -100045:
                Bundle bundle = new Bundle();
                Context context2 = liveAnchorPluginLayout.getContext();
                kotlin.g.b.p.g(context2, "context");
                String string = context2.getResources().getString(R.string.efx);
                kotlin.g.b.p.g(string, "context.resources.getStr…eption_desc_forbid_visit)");
                SpannableString spannableString = new SpannableString(string);
                int a2 = kotlin.n.n.a((CharSequence) spannableString, "《", 0, false, 6);
                if (a2 != -1) {
                    Context context3 = liveAnchorPluginLayout.getContext();
                    kotlin.g.b.p.g(context3, "context");
                    spannableString.setSpan(new ForegroundColorSpan(context3.getResources().getColor(R.color.Link)), a2, spannableString.length(), 0);
                    spannableString.setSpan(new i(liveAnchorPluginLayout), a2, spannableString.length(), 0);
                }
                Context context4 = liveAnchorPluginLayout.getContext();
                kotlin.g.b.p.g(context4, "context");
                bundle.putString("PARAM_LIVE_EXCEPTION_TITLE", context4.getResources().getString(R.string.efy));
                bundle.putCharSequence("PARAM_LIVE_EXCEPTION_DESC", spannableString);
                bundle.putInt("PARAM_LIVE_EXCEPTION_ICON_RES", R.raw.icons_filled_live_err_red);
                liveAnchorPluginLayout.statusChange(b.c.hMv, bundle);
                AppMethodBeat.o(208547);
                return;
            case -100065:
                liveAnchorPluginLayout.aJn();
                AppMethodBeat.o(208547);
                return;
            case -100038:
                b.C0376b.a(liveAnchorPluginLayout, b.c.hLV);
                AppMethodBeat.o(208547);
                return;
            case TXLiteAVCode.ERR_SERVER_INFO_ALLOCATE_ACCESS_FAILED:
                f.a hbu = new f.a(liveAnchorPluginLayout.getContext()).hbu();
                Context context5 = liveAnchorPluginLayout.getContext();
                kotlin.g.b.p.g(context5, "context");
                hbu.bow(context5.getResources().getString(R.string.egh)).apa(R.string.w0).b(e.hWp).b(new f(liveAnchorPluginLayout)).show();
                AppMethodBeat.o(208547);
                return;
            default:
                b.C0376b.a(liveAnchorPluginLayout, b.c.hMo);
                AppMethodBeat.o(208547);
                return;
        }
    }
}
