package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.login.widget.ToolTipPopup;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.plugin.festival.finder.bd;
import com.tencent.mm.plugin.festival.finder.bh;
import com.tencent.mm.plugin.festival.finder.k;
import com.tencent.mm.plugin.festival.finder.v;
import com.tencent.mm.plugin.festival.finder.w;
import com.tencent.mm.plugin.festival.finder.z;
import com.tencent.mm.plugin.festival.model.h;
import com.tencent.mm.plugin.festival.model.n;
import com.tencent.mm.plugin.festival.model.r;
import com.tencent.mm.plugin.festival.model.t;
import com.tencent.mm.plugin.festival.model.z;
import com.tencent.mm.plugin.festival.ui.bak.FestivalSecondBakUI;
import com.tencent.mm.plugin.festival.ui.view.FestivalRealNamePanel;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.trtc.TRTCCloudDef;
import java.util.HashMap;
import java.util.List;
import kotlin.g.a.u;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001+\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u000202H\u0016J\"\u0010T\u001a\u00020)2\u0006\u0010U\u001a\u0002022\u0006\u0010V\u001a\u0002022\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J \u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020O2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u001fH\u0016J\u001c\u0010^\u001a\u0004\u0018\u00010_2\b\b\u0002\u0010`\u001a\u00020a2\b\b\u0002\u0010b\u001a\u00020aJ\u001c\u0010c\u001a\u0004\u0018\u00010_2\b\b\u0002\u0010`\u001a\u00020a2\b\b\u0002\u0010b\u001a\u00020aJ\b\u0010d\u001a\u00020)H\u0002J\b\u0010e\u001a\u00020)H\u0002J\b\u0010f\u001a\u00020)H\u0002J\b\u0010g\u001a\u00020)H\u0002J\b\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u000202H\u0016J\b\u0010k\u001a\u000202H\u0016J\u0018\u0010l\u001a\u00020)2\u0006\u0010m\u001a\u0002022\u0006\u0010n\u001a\u00020iH\u0002J\b\u0010o\u001a\u00020)H\u0002J\b\u0010p\u001a\u00020)H\u0002J\b\u0010q\u001a\u00020)H\u0002J\b\u0010r\u001a\u00020)H\u0002J\b\u0010s\u001a\u00020)H\u0016J\b\u0010t\u001a\u00020iH\u0016J\b\u0010u\u001a\u00020)H\u0002J\u0018\u0010v\u001a\u00020)2\u0006\u0010w\u001a\u0002022\u0006\u0010x\u001a\u00020iH\u0016J\u001a\u0010y\u001a\u00020)2\u0006\u0010z\u001a\u0002022\b\u0010{\u001a\u0004\u0018\u00010XH\u0016J\u0010\u0010|\u001a\u00020)2\u0006\u0010}\u001a\u00020\u001fH\u0016J.\u0010~\u001a\u00020)2\u0006\u0010\u001a\u0002022\u0006\u0010m\u001a\u0002022\b\u0010n\u001a\u0004\u0018\u00010i2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020)H\u0016J\u0007\u0010\u0001\u001a\u00020)J\t\u0010\u0001\u001a\u00020)H\u0016J\u0014\u0010\u0001\u001a\u00020)2\t\b\u0002\u0010\u0001\u001a\u00020\u001fH\u0002J\t\u0010\u0001\u001a\u00020)H\u0002J\u0012\u0010\u0001\u001a\u00020)2\u0007\u0010\u0001\u001a\u00020iH\u0002J\t\u0010\u0001\u001a\u00020)H\u0002J\t\u0010\u0001\u001a\u00020)H\u0016J\t\u0010\u0001\u001a\u00020)H\u0002J\u001d\u0010\u0001\u001a\u00020)2\b\u0010\u0001\u001a\u00030\u00012\b\u0010{\u001a\u0004\u0018\u00010XH\u0016J\t\u0010\u0001\u001a\u00020)H\u0016J\t\u0010\u0001\u001a\u00020)H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorPluginLayout;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "blurHelper", "Lcom/tencent/mm/plugin/festival/util/FestivalBlurHelper;", "canvasDanmakuPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin;", "canvasHandDrawSharePlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveCanvasHandDrawSharePlugin;", "canvasLayout", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasLayout;", "canvasPopupPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasPopupContainerPlugin;", "closePlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorClosePlugin;", "commentPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin;", "confettiPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveLikeConfettiPlugin;", "donationPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalDonationPlugin;", "educationPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalEducationPlugin;", "fuBagPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFuBagPlugin;", "hadTotalRelease", "", "inputPluigin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveInputPlugin;", "isFromFloatBall", "isRestart", "isWishLiveStarted", "likePlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveLikePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveStatusErrorListener", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorPluginLayout$liveStatusErrorListener$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorPluginLayout$liveStatusErrorListener$1;", "moreActionPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderMoreActionPlugin;", "myNewWishPopupPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveMyNewWishPopupPlugin;", "originCommentBottomMargin", "", "postPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveNewVisitorPostPlugin;", "postWishPanelPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderPostWishPanelPlugin;", "prepareWishPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin;", "presenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;)V", "screenClearPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveScreenClearPlugin;", "setStatusPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin;", "shareInfoPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderShareInfoPlugin;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "titleInfoPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveTitlePlugin;", "wishBtnPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderWishBtnPlugin;", "wishDetailsCardContainerPlugin", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin;", "activate", "config", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "isFinished", "isFromFloat", "restart", "curIndex", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "bindData", "data", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "isCurLive", "captureCanvasBlurSnapshot", "Landroid/graphics/Bitmap;", "blurRadius", "", "downscaleFactor", "captureRootBlurSnapshot", "checkFinderObject", "checkRelease", "chooseAudienceMode", "directStartLive", "getKeyStatusStr", "", "getLiveRole", "getRelativeLayoutId", "handleJoinErr", "errCode", "errMsg", "hideLiveRoomRelatedPlugins", "hideWishRelatedPlugins", "initPlugins", "joinLive", "mount", "name", "notifyLiveFinish", "onCallStateChanged", "state", "incomingNumber", "onLiveEventCallback", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "param", "onRotationSwitchChange", "rotationEnable", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "restartLiveRoomRelated", "resume", "setDefaultGradientBackground", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "showLiveRoomRelatedPlugins", "showRealNameBottomSheet", "realNameUrl", "showWishRelatedPlugins", "start", "startPollInfoTimer", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "stopPollInfoTimer", "Companion", "plugin-festival_release"})
public final class FestivalFinderLiveVisitorPluginLayout extends FestivalFinderBaseLivePluginLayout implements com.tencent.mm.ak.i {
    @Deprecated
    public static final a Uvk = new a((byte) 0);
    t UsO;
    private w.a UtL;
    private boolean UuF;
    af UuJ;
    x UuK;
    private av UuL;
    private bh UuM;
    ab UuN;
    private bi UuO;
    private bs UuP;
    private bf UuQ;
    private ay UuR;
    private bd UuS;
    private ar UuT;
    private e UuU;
    private q UuV;
    private h UuW;
    private c UuX;
    private ad UuY;
    private ah UuZ;
    private bb Uva;
    private m Uvb;
    private o Uvc;
    z Uvd;
    private bk Uve;
    private boolean Uvf;
    private boolean Uvg;
    private boolean Uvh;
    private final f Uvi;
    private final com.tencent.mm.plugin.festival.c.a Uvj;
    private HashMap _$_findViewCache;
    private kotlin.g.a.a<x> liveMessageCallback = new e(this);
    private int originCommentBottomMargin;
    private MTimerHandler timerThread;

    static {
        AppMethodBeat.i(262635);
        AppMethodBeat.o(262635);
    }

    @Override // com.tencent.mm.plugin.festival.finder.FestivalFinderBaseLivePluginLayout, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(262643);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(262643);
    }

    @Override // com.tencent.mm.plugin.festival.finder.FestivalFinderBaseLivePluginLayout, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(262642);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(262642);
        return view;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ FestivalFinderLiveVisitorPluginLayout Uvl;

        c(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
            this.Uvl = festivalFinderLiveVisitorPluginLayout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
            if (com.tencent.mm.plugin.finder.utils.y.gp(r8.errType, r8.errCode) != false) goto L_0x001d;
         */
        @Override // com.tencent.mm.vending.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object call(java.lang.Object r8) {
            /*
            // Method dump skipped, instructions count: 155
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.finder.FestivalFinderLiveVisitorPluginLayout.c.call(java.lang.Object):java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\n¢\u0006\u0002\b\u000f"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "invoke"})
    static final class d extends q implements u<Boolean, Integer, Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, auf, x> {
        final /* synthetic */ FestivalFinderLiveVisitorPluginLayout Uvl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
            super(7);
            this.Uvl = festivalFinderLiveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.u
        public final /* synthetic */ x invoke(Boolean bool, Integer num, Integer num2, String str, com.tencent.mm.live.core.core.b.e eVar, TRTCCloudDef.TRTCParams tRTCParams, auf auf) {
            int aCe;
            String str2;
            long ahy;
            com.tencent.mm.live.core.core.b.e eVar2;
            TRTCCloudDef.TRTCParams tRTCParams2;
            AppMethodBeat.i(262603);
            boolean booleanValue = bool.booleanValue();
            int intValue = num.intValue();
            num2.intValue();
            String str3 = str;
            com.tencent.mm.live.core.core.b.e eVar3 = eVar;
            TRTCCloudDef.TRTCParams tRTCParams3 = tRTCParams;
            auf auf2 = auf;
            p.h(str3, "errMsg");
            p.h(eVar3, "liveRoomInfo");
            p.h(tRTCParams3, "trtcParams");
            p.h(auf2, "resp");
            a unused = FestivalFinderLiveVisitorPluginLayout.Uvk;
            Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "join live room success:" + booleanValue + " errCode:" + intValue + " errMsg:" + str3 + " isDestroyed:" + this.Uvl.isDestroyed());
            com.tencent.mm.plugin.festival.model.i iVar = com.tencent.mm.plugin.festival.model.i.Uyl;
            com.tencent.mm.plugin.festival.model.i.log("join live success:" + booleanValue + " errCode:" + intValue + " errMsg:" + str3 + ' ' + FestivalFinderLiveVisitorPluginLayout.e(this.Uvl));
            if (!this.Uvl.isDestroyed()) {
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.Uvl.getLiveData();
                avn avn = auf2.LDQ;
                liveData.RK((long) (avn != null ? avn.LGj : 0));
                this.Uvl.liveMessageCallback.invoke();
                if (booleanValue) {
                    this.Uvl.getLiveData().hIy = new com.tencent.mm.live.core.core.b.f(tRTCParams3, eVar3, new com.tencent.mm.live.core.core.b.b("com.tencent.mm.plugin.festival.finder.FestivalFinderLiveEndUI"));
                    com.tencent.mm.plugin.finder.live.model.i iVar2 = com.tencent.mm.plugin.finder.live.model.i.uja;
                    com.tencent.mm.plugin.finder.live.model.i.b(this.Uvl.getLiveData());
                    com.tencent.mm.plugin.finder.live.model.i iVar3 = com.tencent.mm.plugin.finder.live.model.i.uja;
                    com.tencent.mm.plugin.finder.live.model.i.c(this.Uvl.getLiveData());
                    com.tencent.mm.live.core.core.b.f fVar = this.Uvl.getLiveData().hIy;
                    if (!(fVar == null || (tRTCParams2 = fVar.hzu) == null)) {
                        tRTCParams2.role = 21;
                    }
                    this.Uvl.getLiveData().sessionId = SystemClock.elapsedRealtimeNanos();
                    com.tencent.mm.live.core.c.b bVar = com.tencent.mm.live.core.c.b.hEJ;
                    e.f fVar2 = e.f.hxS;
                    int aCP = e.f.aCP();
                    com.tencent.mm.live.core.core.b.f fVar3 = this.Uvl.getLiveData().hIy;
                    if (fVar3 == null || (eVar2 = fVar3.hwP) == null) {
                        e.a aVar = e.a.hxc;
                        aCe = e.a.aCe();
                    } else {
                        aCe = eVar2.hzl;
                    }
                    com.tencent.mm.live.core.c.b.d(aCP, aCe, eVar3.liveId);
                    this.Uvl.getLiveData().uEt = 0;
                    FestivalFinderLiveVisitorPluginLayout.g(this.Uvl);
                    af afVar = af.waa;
                    StringBuilder sb = new StringBuilder();
                    af afVar2 = af.waa;
                    String sb2 = sb.append(af.dEm()).append(this.Uvl.getData().uCr.getLiveId()).toString();
                    ad.a aVar2 = ad.vZu;
                    af.a(afVar, sb2, ad.vYP.name, null, false, false, 28);
                    m mVar = m.vli;
                    m.a(s.n.LIVE_LIVING);
                    m mVar2 = m.vli;
                    com.tencent.mm.plugin.finder.live.viewmodel.c data = this.Uvl.getData();
                    Context context = this.Uvl.getContext();
                    p.g(context, "context");
                    Resources resources = context.getResources();
                    p.g(resources, "context.resources");
                    mVar2.a(data, resources.getConfiguration().orientation);
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    long j2 = this.Uvl.getLiveData().hFK;
                    long j3 = eVar3.liveId;
                    if (TextUtils.isEmpty(this.Uvl.getData().uCs.hwd)) {
                        str2 = this.Uvl.getLiveData().hwd;
                    } else {
                        str2 = this.Uvl.getData().uCs.hwd;
                    }
                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    long j4 = com.tencent.mm.plugin.finder.report.live.k.dpl().vlw;
                    long size = (long) this.Uvl.getLiveData().uDn.size();
                    s.p pVar = s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL;
                    com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    String str4 = com.tencent.mm.plugin.finder.report.live.k.dpl().vlv;
                    long j5 = s.n.LIVE_LIVING.jii;
                    m mVar3 = m.vli;
                    if (m.ahy() <= 0) {
                        ahy = System.currentTimeMillis();
                    } else {
                        m mVar4 = m.vli;
                        ahy = m.ahy();
                    }
                    com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    kVar.a(j2, j3, str2, j4, size, pVar, str4, j5, ahy, com.tencent.mm.plugin.finder.report.live.k.dpl().vma);
                } else {
                    af afVar3 = af.waa;
                    StringBuilder sb3 = new StringBuilder();
                    af afVar4 = af.waa;
                    String sb4 = sb3.append(af.dEm()).append(this.Uvl.getData().uCr.getLiveId()).toString();
                    ad.a aVar3 = ad.vZu;
                    String str5 = ad.vYR.name;
                    y yVar = y.vXH;
                    cit cit = new cit();
                    cit.errCode = intValue;
                    cit.errMsg = str3;
                    af.a(afVar3, sb4, str5, y.j(cit), false, true, 8);
                    this.Uvl.disableRatation();
                    FestivalFinderLiveVisitorPluginLayout.a(this.Uvl, intValue, str3);
                }
                if (this.Uvl.Uvf) {
                    a unused2 = FestivalFinderLiveVisitorPluginLayout.Uvk;
                    Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "join live restart hide loading layer");
                    this.Uvl.hideLoadingLayer();
                    FestivalFinderLiveVisitorPluginLayout.i(this.Uvl);
                    FestivalFinderLiveVisitorPluginLayout.j(this.Uvl);
                    c cVar = this.Uvl.UuX;
                    if (cVar != null) {
                        cVar.gFc();
                    }
                    h hVar = this.Uvl.UuW;
                    if (hVar != null) {
                        hVar.gFc();
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(262603);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    static final class h extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ FestivalFinderLiveVisitorPluginLayout Uvl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
            super(1);
            this.Uvl = festivalFinderLiveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0050, code lost:
            if (new com.tencent.mm.plugin.finder.cgi.x(com.tencent.mm.plugin.finder.cgi.x.a.a(r1, r0.uqR), r0.getLiveData(), null).aYI() == null) goto L_0x0052;
         */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke(java.lang.Boolean r7) {
            /*
            // Method dump skipped, instructions count: 111
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.finder.FestivalFinderLiveVisitorPluginLayout.h.invoke(java.lang.Object):java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "addFloatBallSuc", "", "invoke"})
    static final class k extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ FestivalFinderLiveVisitorPluginLayout Uvl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
            super(1);
            this.Uvl = festivalFinderLiveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(262611);
            boolean booleanValue = bool.booleanValue();
            com.tencent.mm.plugin.festival.model.i iVar = com.tencent.mm.plugin.festival.model.i.Uyl;
            com.tencent.mm.plugin.festival.model.i.log("addFloatBall " + booleanValue + ' ' + FestivalFinderLiveVisitorPluginLayout.e(this.Uvl));
            if (booleanValue) {
                com.tencent.mm.plugin.festival.model.g gVar = com.tencent.mm.plugin.festival.model.g.UxZ;
                com.tencent.mm.plugin.festival.model.g.Fl(true);
                this.Uvl.statusChange(b.c.wMy, null);
            } else {
                a unused = FestivalFinderLiveVisitorPluginLayout.Uvk;
                Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "stop add float ball failed");
                FestivalFinderLiveVisitorPluginLayout.m(this.Uvl);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(262611);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalFinderLiveVisitorPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(262634);
        this.Uvi = new f(this, context);
        this.Uvj = new com.tencent.mm.plugin.festival.c.a();
        AppMethodBeat.o(262634);
    }

    public static final /* synthetic */ String e(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
        AppMethodBeat.i(262636);
        String keyStatusStr = festivalFinderLiveVisitorPluginLayout.getKeyStatusStr();
        AppMethodBeat.o(262636);
        return keyStatusStr;
    }

    public static final /* synthetic */ void g(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
        AppMethodBeat.i(262637);
        festivalFinderLiveVisitorPluginLayout.ghD();
        AppMethodBeat.o(262637);
    }

    public static final /* synthetic */ void i(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
        AppMethodBeat.i(262639);
        festivalFinderLiveVisitorPluginLayout.gEz();
        AppMethodBeat.o(262639);
    }

    public static final /* synthetic */ void j(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
        AppMethodBeat.i(262640);
        festivalFinderLiveVisitorPluginLayout.gtj();
        AppMethodBeat.o(262640);
    }

    public static final /* synthetic */ void m(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
        AppMethodBeat.i(262641);
        festivalFinderLiveVisitorPluginLayout.ghE();
        AppMethodBeat.o(262641);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final w.a getPresenter() {
        return this.UtL;
    }

    public final void setPresenter(w.a aVar) {
        this.UtL = aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorPluginLayout$liveStatusErrorListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/festival/model/FestivalLiveHeartbeatErrorResp;", "callback", "", "event", "plugin-festival_release"})
    public static final class f extends IListener<n> {
        final /* synthetic */ Context $context;
        final /* synthetic */ FestivalFinderLiveVisitorPluginLayout Uvl;

        f(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout, Context context) {
            this.Uvl = festivalFinderLiveVisitorPluginLayout;
            this.$context = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(n nVar) {
            AppMethodBeat.i(262606);
            n nVar2 = nVar;
            p.h(nVar2, "event");
            if (nVar2.errCode == -100002 || nVar2.errCode == -100001) {
                com.tencent.mm.plugin.festival.model.i iVar = com.tencent.mm.plugin.festival.model.i.Uyl;
                com.tencent.mm.plugin.festival.model.i.log("wish live error status:" + nVar2.errCode + "  " + FestivalFinderLiveVisitorPluginLayout.e(this.Uvl));
                Context context = this.$context;
                Intent intent = new Intent();
                int i2 = nVar2.errCode == -100001 ? 2 : 1;
                intent.setClass(this.$context, FestivalSecondBakUI.class);
                intent.putExtra("IntentKeyAnchorUsrName", this.Uvl.getLiveData().hwd);
                intent.putExtra("IntentKeyStatusErrorType", i2);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorPluginLayout$liveStatusErrorListener$1", "callback", "(Lcom/tencent/mm/plugin/festival/model/FestivalLiveHeartbeatErrorResp;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorPluginLayout$liveStatusErrorListener$1", "callback", "(Lcom/tencent/mm/plugin/festival/model/FestivalLiveHeartbeatErrorResp;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.Uvl.statusChange(b.c.hLC, null);
            }
            AppMethodBeat.o(262606);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    public static final class i implements MTimerHandler.CallBack {
        final /* synthetic */ FestivalFinderLiveVisitorPluginLayout Uvl;

        i(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
            this.Uvl = festivalFinderLiveVisitorPluginLayout;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(262609);
            bh bhVar = this.Uvl.UuM;
            if (bhVar != null) {
                com.tencent.mm.ac.d.h(new bh.c(bhVar));
            }
            ab abVar = this.Uvl.UuN;
            if (abVar != null) {
                abVar.RE(this.Uvl.getLiveData().UPT);
            }
            AppMethodBeat.o(262609);
            return true;
        }
    }

    private final void ghD() {
        AppMethodBeat.i(262612);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", this.UuF);
        statusChange(b.c.hLB, bundle);
        b.C0376b.a(this, b.c.hMy);
        AppMethodBeat.o(262612);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final int getRelativeLayoutId() {
        return R.layout.cdp;
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onCallStateChanged(int i2, String str) {
        AppMethodBeat.i(262613);
        p.h(str, "incomingNumber");
        AppMethodBeat.o(262613);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onRotationSwitchChange(boolean z) {
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void bindData(com.tencent.mm.plugin.finder.live.viewmodel.c cVar, com.tencent.mm.plugin.finder.live.viewmodel.g gVar, boolean z) {
        AppMethodBeat.i(262614);
        p.h(cVar, "data");
        p.h(gVar, "liveData");
        super.bindData(cVar, gVar, z);
        this.Uvi.alive();
        setDefaultGradientBackground(false);
        if (this.UuQ == null) {
            View findViewById = findViewById(R.id.jv6);
            p.g(findViewById, "findViewById(R.id.festiv…inder_post_wish_panel_ui)");
            this.UuQ = new bf((ViewGroup) findViewById, this);
        }
        if (this.Uvb == null) {
            View findViewById2 = findViewById(R.id.juz);
            p.g(findViewById2, "findViewById(R.id.festival_finder_donation_panel)");
            this.Uvb = new m((ViewGroup) findViewById2, this);
        }
        if (this.Uvc == null) {
            View findViewById3 = findViewById(R.id.jv0);
            p.g(findViewById3, "findViewById(R.id.festival_finder_education_panel)");
            this.Uvc = new o((ViewGroup) findViewById3, this);
        }
        if (this.UuL == null) {
            View findViewById4 = findViewById(R.id.emn);
            p.g(findViewById4, "findViewById(R.id.live_title_ui_root)");
            this.UuL = new av((ViewGroup) findViewById4, this, (byte) 0);
        }
        if (this.UuM == null) {
            View findViewById5 = findViewById(R.id.k2f);
            p.g(findViewById5, "findViewById(R.id.share_info_ui_root)");
            this.UuM = new bh((ViewGroup) findViewById5, this);
        }
        if (this.UsO == null) {
            View findViewById6 = findViewById(R.id.cps);
            p.g(findViewById6, "findViewById(R.id.finder_live_comment_ui_root)");
            this.UsO = new t((ViewGroup) findViewById6, this);
            t tVar = t.UyR;
            t.a(this.UsO);
        }
        if (this.UuJ == null) {
            View findViewById7 = findViewById(R.id.cz7);
            p.g(findViewById7, "findViewById(R.id.finder…ive_visitor_post_ui_root)");
            this.UuJ = new af((ViewGroup) findViewById7, this);
            t tVar2 = t.UyR;
            t.a(this.UuJ);
        }
        if (this.UuK == null) {
            View findViewById8 = findViewById(R.id.ehp);
            p.g(findViewById8, "findViewById(R.id.live_input_ui_root)");
            this.UuK = new x((ViewGroup) findViewById8, this);
            t tVar3 = t.UyR;
            t.a(this.UuK);
        }
        if (this.UuN == null) {
            View findViewById9 = findViewById(R.id.cs9);
            p.g(findViewById9, "findViewById(R.id.finder_live_like_ui_root)");
            this.UuN = new ab((ViewGroup) findViewById9, this);
        }
        if (this.UuR == null) {
            View findViewById10 = findViewById(R.id.ene);
            p.g(findViewById10, "findViewById(R.id.live_visitor_close_ui_root)");
            this.UuR = new ay((ViewGroup) findViewById10, this);
        }
        if (this.UuT == null) {
            View findViewById11 = findViewById(R.id.cxb);
            p.g(findViewById11, "findViewById(R.id.finder_live_screen_clear_view)");
            ViewGroup viewGroup = (ViewGroup) findViewById11;
            w.a aVar = this.UtL;
            if (aVar == null) {
                p.hyc();
            }
            this.UuT = new ar(viewGroup, aVar, this);
        }
        if (this.UuU == null) {
            View findViewById12 = findViewById(R.id.jvh);
            p.g(findViewById12, "findViewById<FrameLayout…d.festival_map_layout_ui)");
            this.UuU = new e((ViewGroup) findViewById12, this);
            View findViewById13 = findViewById(R.id.jva);
            p.g(findViewById13, "findViewById(R.id.festiv…_draw_share_container_ui)");
            ViewGroup viewGroup2 = (ViewGroup) findViewById13;
            e eVar = this.UuU;
            if (eVar == null) {
                p.hyc();
            }
            k.a aVar2 = eVar.Uqv;
            w.a aVar3 = this.UtL;
            if (aVar3 == null) {
                p.hyc();
            }
            this.UuV = new q(viewGroup2, aVar2, aVar3, this);
            View findViewById14 = findViewById(R.id.jv_);
            p.g(findViewById14, "findViewById(R.id.festiv…vas_danmaku_container_ui)");
            FrameLayout frameLayout = (FrameLayout) findViewById14;
            e eVar2 = this.UuU;
            if (eVar2 == null) {
                p.hyc();
            }
            this.UuX = new c(frameLayout, eVar2.Uqv, this);
            View findViewById15 = findViewById(R.id.jvb);
            p.g(findViewById15, "findViewById(R.id.festiv…anvas_popup_container_ui)");
            FestivalPopupContainerFrameLayout festivalPopupContainerFrameLayout = (FestivalPopupContainerFrameLayout) findViewById15;
            e eVar3 = this.UuU;
            if (eVar3 == null) {
                p.hyc();
            }
            k.a aVar4 = eVar3.Uqv;
            c cVar2 = this.UuX;
            if (cVar2 == null) {
                p.hyc();
            }
            this.UuW = new h(festivalPopupContainerFrameLayout, aVar4, cVar2.Uqg, this);
            View findViewById16 = findViewById(R.id.jvd);
            p.g(findViewById16, "findViewById(R.id.festiv…_wish_popup_container_ui)");
            ViewGroup viewGroup3 = (ViewGroup) findViewById16;
            e eVar4 = this.UuU;
            if (eVar4 == null) {
                p.hyc();
            }
            this.UuY = new ad(viewGroup3, eVar4.Uqv, this);
            t tVar4 = t.UyR;
            t.a(this.UuX);
            t tVar5 = t.UyR;
            t.a(this.UuW);
        }
        ah ahVar = this.UuZ;
        if (ahVar == null) {
            View findViewById17 = findViewById(R.id.jve);
            p.g(findViewById17, "findViewById(R.id.festiv…repare_wish_container_ui)");
            ViewGroup viewGroup4 = (ViewGroup) findViewById17;
            FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout = this;
            w.a aVar5 = this.UtL;
            if (aVar5 == null) {
                p.hyc();
            }
            e eVar5 = this.UuU;
            if (eVar5 == null) {
                p.hyc();
            }
            ahVar = new ah(viewGroup4, festivalFinderLiveVisitorPluginLayout, aVar5, eVar5.Uqv);
        }
        this.UuZ = ahVar;
        bb bbVar = this.Uva;
        if (bbVar == null) {
            View findViewById18 = findViewById(R.id.jv2);
            p.g(findViewById18, "findViewById(R.id.festiv…s_card_container_ui_root)");
            ViewGroup viewGroup5 = (ViewGroup) findViewById18;
            FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout2 = this;
            w.a aVar6 = this.UtL;
            if (aVar6 == null) {
                p.hyc();
            }
            bbVar = new bb(viewGroup5, festivalFinderLiveVisitorPluginLayout2, aVar6);
        }
        this.Uva = bbVar;
        if (this.UuO == null) {
            View findViewById19 = findViewById(R.id.jv8);
            p.g(findViewById19, "findViewById(R.id.festiv…er_wish_btn_container_ui)");
            this.UuO = new bi((ViewGroup) findViewById19, this);
        }
        if (this.UuS == null) {
            View findViewById20 = findViewById(R.id.cvz);
            p.g(findViewById20, "findViewById(R.id.finder_live_more_action_ui_root)");
            ViewGroup viewGroup6 = (ViewGroup) findViewById20;
            FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout3 = this;
            Context context = getContext();
            if (context == null) {
                kotlin.t tVar6 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(262614);
                throw tVar6;
            }
            this.UuS = new bd(viewGroup6, festivalFinderLiveVisitorPluginLayout3, (MMActivity) context);
        }
        if (this.Uvd == null) {
            View findViewById21 = findViewById(R.id.ehv);
            p.g(findViewById21, "findViewById(R.id.live_like_confetti_ui_root)");
            this.Uvd = new z((ViewGroup) findViewById21, this);
        }
        if (this.UuP == null) {
            View findViewById22 = findViewById(R.id.jv7);
            p.g(findViewById22, "findViewById(R.id.festiv…_finder_set_status_panel)");
            this.UuP = new bs((ViewGroup) findViewById22, this);
        }
        if (this.Uve == null) {
            View findViewById23 = findViewById(R.id.jv1);
            p.g(findViewById23, "findViewById(R.id.festiv…nder_fu_bag_container_ui)");
            this.Uve = new bk((ViewGroup) findViewById23, this);
            t tVar7 = t.UyR;
            t.a(this.Uve);
        }
        showProgressWithBlurBg(getLiveData().hwd);
        z zVar = this.Uvd;
        if (zVar != null) {
            p.h(getData().uCr, "config");
            Context context2 = zVar.hwr.getContext();
            p.g(context2, "root.context");
            Bitmap decodeResource = BitmapFactory.decodeResource(context2.getResources(), R.drawable.bsu);
            o.b bVar = o.b.hGo;
            int aFl = o.b.aFl();
            o.b bVar2 = o.b.hGo;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, aFl, o.b.aFl(), true);
            Context context3 = zVar.hwr.getContext();
            p.g(context3, "root.context");
            Bitmap decodeResource2 = BitmapFactory.decodeResource(context3.getResources(), R.drawable.bsv);
            o.b bVar3 = o.b.hGo;
            int aFl2 = o.b.aFl();
            o.b bVar4 = o.b.hGo;
            Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(decodeResource2, aFl2, o.b.aFl(), true);
            Context context4 = zVar.hwr.getContext();
            p.g(context4, "root.context");
            Bitmap decodeResource3 = BitmapFactory.decodeResource(context4.getResources(), R.drawable.bsw);
            o.b bVar5 = o.b.hGo;
            int aFl3 = o.b.aFl();
            o.b bVar6 = o.b.hGo;
            Bitmap createScaledBitmap3 = Bitmap.createScaledBitmap(decodeResource3, aFl3, o.b.aFl(), true);
            Context context5 = zVar.hwr.getContext();
            p.g(context5, "root.context");
            Bitmap decodeResource4 = BitmapFactory.decodeResource(context5.getResources(), R.drawable.bsx);
            o.b bVar7 = o.b.hGo;
            int aFl4 = o.b.aFl();
            o.b bVar8 = o.b.hGo;
            Bitmap createScaledBitmap4 = Bitmap.createScaledBitmap(decodeResource4, aFl4, o.b.aFl(), true);
            Context context6 = zVar.hwr.getContext();
            p.g(context6, "root.context");
            Bitmap decodeResource5 = BitmapFactory.decodeResource(context6.getResources(), R.drawable.bsy);
            o.b bVar9 = o.b.hGo;
            int aFl5 = o.b.aFl();
            o.b bVar10 = o.b.hGo;
            Bitmap createScaledBitmap5 = Bitmap.createScaledBitmap(decodeResource5, aFl5, o.b.aFl(), true);
            Context context7 = zVar.hwr.getContext();
            p.g(context7, "root.context");
            Bitmap decodeResource6 = BitmapFactory.decodeResource(context7.getResources(), R.drawable.bsz);
            o.b bVar11 = o.b.hGo;
            int aFl6 = o.b.aFl();
            o.b bVar12 = o.b.hGo;
            Bitmap createScaledBitmap6 = Bitmap.createScaledBitmap(decodeResource6, aFl6, o.b.aFl(), true);
            zVar.hRh.add(createScaledBitmap);
            zVar.hRh.add(createScaledBitmap2);
            zVar.hRh.add(createScaledBitmap3);
            zVar.hRh.add(createScaledBitmap4);
            zVar.hRh.add(createScaledBitmap5);
            zVar.hRh.add(createScaledBitmap6);
        }
        av avVar = this.UuL;
        if (avVar != null) {
            avVar.rg(8);
        }
        bh bhVar = this.UuM;
        if (bhVar != null) {
            bhVar.rg(8);
        }
        e eVar6 = this.UuU;
        if (eVar6 != null) {
            eVar6.rg(8);
        }
        bi biVar = this.UuO;
        if (biVar != null) {
            biVar.rg(8);
        }
        bk bkVar = this.Uve;
        if (bkVar != null) {
            bkVar.rg(8);
        }
        bf bfVar = this.UuQ;
        if (bfVar != null) {
            bfVar.rg(8);
        }
        m mVar = this.Uvb;
        if (mVar != null) {
            mVar.rg(8);
        }
        o oVar = this.Uvc;
        if (oVar != null) {
            oVar.rg(8);
        }
        ay ayVar = this.UuR;
        if (ayVar != null) {
            ayVar.rg(8);
        }
        bd bdVar = this.UuS;
        if (bdVar != null) {
            bdVar.rg(8);
        }
        ar arVar = this.UuT;
        if (arVar != null) {
            arVar.rg(8);
        }
        bs bsVar = this.UuP;
        if (bsVar != null) {
            bsVar.rg(8);
        }
        ah ahVar2 = this.UuZ;
        if (ahVar2 != null) {
            ahVar2.rg(8);
        }
        c cVar3 = this.UuX;
        if (cVar3 != null) {
            cVar3.rg(8);
        }
        h hVar = this.UuW;
        if (hVar != null) {
            hVar.rg(8);
        }
        q qVar = this.UuV;
        if (qVar != null) {
            qVar.rg(8);
        }
        gEA();
        AppMethodBeat.o(262614);
    }

    private final void setDefaultGradientBackground(boolean z) {
        AppMethodBeat.i(262615);
        if (z) {
            setBackground(null);
            AppMethodBeat.o(262615);
            return;
        }
        com.tencent.mm.plugin.festival.ui.b bVar = com.tencent.mm.plugin.festival.ui.b.UBn;
        Context context = getContext();
        p.g(context, "context");
        setBackground(com.tencent.mm.plugin.festival.ui.b.mj(context));
        AppMethodBeat.o(262615);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void activate(com.tencent.mm.plugin.finder.live.viewmodel.c cVar, boolean z, boolean z2, boolean z3, int i2) {
        AppMethodBeat.i(262616);
        p.h(cVar, "config");
        super.activate(cVar, z, z2, z3, i2);
        this.UuF = z2;
        this.Uvf = z3;
        if (this.Uvf) {
            setDefaultGradientBackground(false);
            c cVar2 = this.UuX;
            if (cVar2 != null) {
                cVar2.gFb();
            }
            h hVar = this.UuW;
            if (hVar != null) {
                hVar.gFb();
            }
        }
        if (this.UuF) {
            this.Uvg = true;
        }
        com.tencent.mm.plugin.festival.model.i iVar = com.tencent.mm.plugin.festival.model.i.Uyl;
        com.tencent.mm.plugin.festival.model.i.log("activate plugin layout " + getKeyStatusStr());
        if (!z2 || !getLiveData().hUa()) {
            Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "activate joinLive");
            com.tencent.mm.plugin.festival.model.i iVar2 = com.tencent.mm.plugin.festival.model.i.Uyl;
            com.tencent.mm.plugin.festival.model.i.log("joinLive liveId:" + getData().uCr.getLiveId() + ' ' + getKeyStatusStr());
            af afVar = af.waa;
            StringBuilder sb = new StringBuilder();
            af afVar2 = af.waa;
            String sb2 = sb.append(af.dEm()).append(getData().uCr.getLiveId()).toString();
            ad.a aVar = ad.vZu;
            af.a(afVar, sb2, ad.vYM.name, null, false, false, 28);
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.a(2, new d(this));
            }
        } else {
            Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "activate directStartLive");
            com.tencent.mm.plugin.festival.model.i iVar3 = com.tencent.mm.plugin.festival.model.i.Uyl;
            com.tencent.mm.plugin.festival.model.i.log("directStartLive isRestart:" + this.Uvf);
            hideLoadingLayer();
            af afVar3 = this.UuJ;
            if (afVar3 != null) {
                afVar3.dhK();
            }
            ghD();
            t tVar = this.UsO;
            if (tVar != null) {
                List<com.tencent.mm.plugin.finder.live.model.t> list = getLiveData().uDs;
                p.g(list, "liveData.msgList");
                tVar.ea(list);
            }
            ab abVar = this.UuN;
            if (abVar != null) {
                abVar.RE(getLiveData().UPT);
            }
            gtj();
            gEz();
        }
        com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
        com.tencent.mm.plugin.finder.live.model.q.j(name(), new b(this));
        StringBuilder append = new StringBuilder("liveId:").append(getData().uCr.getLiveId()).append(" objectId:").append(getData().uCr.aBH()).append(",nonceId:").append(getData().uCr.aBI()).append(",username:").append(getData().uCr.aBG()).append(",show name:");
        y yVar = y.vXH;
        Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", append.append(y.hf(getData().uCr.aBG(), "")).toString());
        AppMethodBeat.o(262616);
    }

    @Override // com.tencent.mm.live.view.a
    public final String name() {
        AppMethodBeat.i(262617);
        String simpleName = FestivalFinderLiveVisitorPluginLayout.class.getSimpleName();
        p.g(simpleName, "FestivalFinderLiveVisito…ut::class.java.simpleName");
        AppMethodBeat.o(262617);
        return simpleName;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void mount() {
        AppMethodBeat.i(262618);
        super.mount();
        Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "mount " + getLiveData());
        com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.d(name(), this.liveMessageCallback);
        getRootView().post(new g(this));
        AppMethodBeat.o(262618);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ FestivalFinderLiveVisitorPluginLayout Uvl;

        g(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
            this.Uvl = festivalFinderLiveVisitorPluginLayout;
        }

        public final void run() {
            AppMethodBeat.i(262607);
            this.Uvl.onScreenClear(this.Uvl.getLiveData().uDR);
            AppMethodBeat.o(262607);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void stop() {
        AppMethodBeat.i(262619);
        super.stop();
        com.tencent.mm.plugin.festival.model.i iVar = com.tencent.mm.plugin.festival.model.i.Uyl;
        com.tencent.mm.plugin.festival.model.i.log("plugin layout stop " + getKeyStatusStr());
        if (!this.Uvg || isManualClosed()) {
            r rVar = r.UyJ;
            r.stop();
            AppMethodBeat.o(262619);
            return;
        }
        com.tencent.mm.plugin.festival.model.h hVar = com.tencent.mm.plugin.festival.model.h.Uye;
        Context context = getContext();
        p.g(context, "context");
        k kVar = new k(this);
        p.h(context, "context");
        p.h(kVar, "callback");
        Log.i("FestivalFloatBallHelper", "addFloatBall");
        com.tencent.mm.plugin.festival.model.h.d(context, new h.b(context, kVar));
        AppMethodBeat.o(262619);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void start() {
        AppMethodBeat.i(262620);
        super.start();
        com.tencent.mm.plugin.festival.model.i iVar = com.tencent.mm.plugin.festival.model.i.Uyl;
        com.tencent.mm.plugin.festival.model.i.log("plugin layout start " + getKeyStatusStr());
        r rVar = r.UyJ;
        Log.i("FestivalMusicManager", "start");
        if (!com.tencent.mm.ai.c.LT(r.dtX)) {
            r.heb();
        }
        r.UyC = false;
        getLiveData().uDS = true;
        AppMethodBeat.o(262620);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void resume() {
        AppMethodBeat.i(262621);
        super.resume();
        getLiveData().uDS = true;
        AppMethodBeat.o(262621);
    }

    private final void ghE() {
        AppMethodBeat.i(262622);
        if (this.Uvh) {
            Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "checkRelease already had");
            AppMethodBeat.o(262622);
            return;
        }
        at atVar = at.Uuv;
        at.a(false, (Boolean) null, (Boolean) null, 15);
        this.Uvh = true;
        AppMethodBeat.o(262622);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void release() {
        boolean z = false;
        int i2 = 1;
        AppMethodBeat.i(262623);
        boolean z2 = isManualClosed() || !this.Uvg || !getLiveData().uDS;
        com.tencent.mm.plugin.festival.model.i iVar = com.tencent.mm.plugin.festival.model.i.Uyl;
        com.tencent.mm.plugin.festival.model.i.log("plugin layout release needTotalRelease:" + z2 + ' ' + getKeyStatusStr());
        com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.aFh();
        Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "stopPollInfoTimer");
        MTimerHandler mTimerHandler = this.timerThread;
        if (mTimerHandler != null) {
            mTimerHandler.stopTimer();
        }
        com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
        com.tencent.mm.plugin.finder.live.model.q.dgC();
        this.Uvj.destroy();
        this.Uvi.dead();
        if (z2) {
            Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "release manual close");
            ghE();
        }
        com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
        if (!z2) {
            z = true;
        }
        if (!z) {
            i2 = 2;
        }
        com.tencent.mm.plugin.festival.model.a.b.gmJ = i2;
        com.tencent.mm.plugin.festival.model.a.b.awH(2);
        AppMethodBeat.o(262623);
    }

    @Override // com.tencent.mm.live.c.b
    public final int getLiveRole() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void applyState(int i2, int i3, Bundle bundle) {
        String str;
        String string;
        boolean z;
        int i4;
        AppMethodBeat.i(262624);
        Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "applyState liveState:" + i2 + ",uiState:" + i3);
        if (getLiveData().hTZ()) {
            t tVar = this.UsO;
            if (tVar != null) {
                tVar.reset();
                AppMethodBeat.o(262624);
                return;
            }
            AppMethodBeat.o(262624);
        } else if (getLiveData().djl()) {
            m.vli.a(s.at.CloseTypeLiveOver);
            gEA();
            AppMethodBeat.o(262624);
        } else {
            if (getLiveData().isLiveStarted()) {
                if (this.Uvg) {
                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        finderLiveAssistant.dfl();
                    }
                    gEz();
                }
                if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 2)) {
                    bd bdVar = this.UuS;
                    if (bdVar != null) {
                        if (bdVar.hOv == null) {
                            bdVar.hOv = new com.tencent.mm.ui.widget.a.e(bdVar.hwr.getContext(), 0, true);
                            com.tencent.mm.ui.widget.a.e eVar = bdVar.hOv;
                            if (eVar != null) {
                                eVar.hbs();
                            }
                        }
                        com.tencent.mm.ui.widget.a.e eVar2 = bdVar.hOv;
                        if (eVar2 != null) {
                            View inflate = View.inflate(bdVar.hwr.getContext(), R.layout.ce5, null);
                            String str2 = z.Uzb.hRC().UAI;
                            TextView textView = (TextView) inflate.findViewById(R.id.k0w);
                            p.g(textView, "menuHeaderDescTv");
                            textView.setText(Html.fromHtml(str2));
                            TextView textView2 = (TextView) inflate.findViewById(R.id.k0w);
                            p.g(textView2, "menuHeaderDescTv");
                            textView2.setMovementMethod(LinkMovementMethod.getInstance());
                            TextView textView3 = (TextView) inflate.findViewById(R.id.k0w);
                            p.g(textView3, "menuHeaderDescTv");
                            bdVar.H(textView3);
                            TextView textView4 = (TextView) inflate.findViewById(R.id.k0w);
                            p.g(textView4, "menuHeaderDescTv");
                            String str3 = str2;
                            if (str3 == null || str3.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                i4 = 8;
                            } else {
                                i4 = 0;
                            }
                            textView4.setVisibility(i4);
                            p.g(inflate, "View.inflate(root.contex…se View.VISIBLE\n        }");
                            eVar2.V(inflate, true);
                        }
                        com.tencent.mm.ui.widget.a.e eVar3 = bdVar.hOv;
                        if (eVar3 != null) {
                            eVar3.hbr();
                        }
                        com.tencent.mm.ui.widget.a.e eVar4 = bdVar.hOv;
                        if (eVar4 != null) {
                            eVar4.Dp(false);
                        }
                        com.tencent.mm.ui.widget.a.e eVar5 = bdVar.hOv;
                        if (eVar5 != null) {
                            eVar5.a(new bd.c(bdVar));
                        }
                        com.tencent.mm.ui.widget.a.e eVar6 = bdVar.hOv;
                        if (eVar6 != null) {
                            eVar6.b(new bd.d(bdVar));
                        }
                        com.tencent.mm.ui.widget.a.e eVar7 = bdVar.hOv;
                        if (eVar7 != null) {
                            eVar7.a(bdVar.uhx);
                        }
                        com.tencent.mm.ui.widget.a.e eVar8 = bdVar.hOv;
                        if (eVar8 != null) {
                            eVar8.b(bdVar.uhx);
                        }
                        com.tencent.mm.ui.widget.a.e eVar9 = bdVar.hOv;
                        if (eVar9 != null) {
                            eVar9.b(new bd.e(bdVar));
                        }
                        com.tencent.mm.ui.widget.a.e eVar10 = bdVar.hOv;
                        if (eVar10 != null) {
                            eVar10.dGm();
                            AppMethodBeat.o(262624);
                            return;
                        }
                        AppMethodBeat.o(262624);
                        return;
                    }
                    AppMethodBeat.o(262624);
                    return;
                } else if (com.tencent.mm.ac.d.cW(getLiveData().uEf, 4096)) {
                    if (bundle == null || (string = bundle.getString("PARAM_FINDER_LIVE_URL")) == null) {
                        str = "";
                    } else {
                        str = string;
                    }
                    p.g(str, "extraMsg?.getString(ILiv…AM_FINDER_LIVE_URL) ?: \"\"");
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(262624);
                        return;
                    }
                    Context context = getContext();
                    p.g(context, "context");
                    v vVar = new v(new FestivalRealNamePanel(context), this);
                    h hVar = new h(this);
                    p.h(str, "realNameUrl");
                    p.h(hVar, "callback");
                    vVar.UsL.setDialogHeight(((double) ((float) au.az(MMApplicationContext.getContext()).y)) * 0.55d);
                    vVar.UsL.setWebviewForwardCallback(v.a.UsM);
                    FestivalRealNamePanel festivalRealNamePanel = vVar.UsL;
                    v.b bVar = new v.b(hVar);
                    p.h(str, "verifyUrl");
                    p.h(bVar, "callback");
                    festivalRealNamePanel.hJl = str;
                    festivalRealNamePanel.uym = bVar;
                    com.tencent.mm.ui.widget.a.g gVar = festivalRealNamePanel.uyo;
                    if (gVar == null) {
                        p.btv("bottomDialog");
                    }
                    gVar.dGm();
                    m.vli.a(s.as.AuthExposure);
                    AppMethodBeat.o(262624);
                    return;
                } else {
                    super.applyState(i2, i3, bundle);
                }
            }
            AppMethodBeat.o(262624);
        }
    }

    private final void gtj() {
        AppMethodBeat.i(262625);
        av avVar = this.UuL;
        if (avVar != null) {
            avVar.rg(0);
        }
        bh bhVar = this.UuM;
        if (bhVar != null) {
            bhVar.rg(0);
        }
        e eVar = this.UuU;
        if (eVar != null) {
            eVar.rg(0);
        }
        bi biVar = this.UuO;
        if (biVar != null) {
            biVar.rg(0);
        }
        ay ayVar = this.UuR;
        if (ayVar != null) {
            ayVar.rg(0);
        }
        bd bdVar = this.UuS;
        if (bdVar != null) {
            bdVar.rg(0);
        }
        ar arVar = this.UuT;
        if (arVar != null) {
            arVar.rg(0);
        }
        e eVar2 = this.UuU;
        if (eVar2 != null) {
            eVar2.rg(0);
        }
        h hVar = this.UuW;
        if (hVar != null) {
            hVar.rg(0);
        }
        c cVar = this.UuX;
        if (cVar != null) {
            cVar.rg(0);
        }
        ah ahVar = this.UuZ;
        if (ahVar != null) {
            ahVar.rg(0);
        }
        bb bbVar = this.Uva;
        if (bbVar != null) {
            bbVar.rg(0);
        }
        o oVar = this.Uvc;
        if (oVar != null) {
            oVar.fvk();
        }
        bk bkVar = this.Uve;
        if (bkVar != null) {
            bkVar.fvk();
            AppMethodBeat.o(262625);
            return;
        }
        AppMethodBeat.o(262625);
    }

    private final void gEz() {
        AppMethodBeat.i(262626);
        t tVar = this.UsO;
        if (tVar != null) {
            tVar.rg(0);
        }
        af afVar = this.UuJ;
        if (afVar != null) {
            afVar.rg(0);
        }
        ab abVar = this.UuN;
        if (abVar != null) {
            abVar.rg(0);
        }
        z zVar = this.Uvd;
        if (zVar != null) {
            zVar.rg(0);
            AppMethodBeat.o(262626);
            return;
        }
        AppMethodBeat.o(262626);
    }

    private final void gEA() {
        AppMethodBeat.i(262627);
        t tVar = this.UsO;
        if (tVar != null) {
            tVar.rg(8);
        }
        af afVar = this.UuJ;
        if (afVar != null) {
            afVar.rg(8);
        }
        x xVar = this.UuK;
        if (xVar != null) {
            xVar.rg(8);
        }
        ab abVar = this.UuN;
        if (abVar != null) {
            abVar.rg(8);
        }
        z zVar = this.Uvd;
        if (zVar != null) {
            zVar.rg(8);
            AppMethodBeat.o(262627);
            return;
        }
        AppMethodBeat.o(262627);
    }

    @Override // com.tencent.mm.plugin.festival.finder.FestivalFinderBaseLivePluginLayout, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.c.b
    public final void statusChange(b.c cVar, Bundle bundle) {
        PointF pointF;
        FinderObject finderObject;
        AppMethodBeat.i(262628);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (ba.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "wish live start");
                this.Uvg = true;
                com.tencent.mm.plugin.festival.model.i iVar = com.tencent.mm.plugin.festival.model.i.Uyl;
                com.tencent.mm.plugin.festival.model.i.log("canvas ready wish live start. " + getKeyStatusStr());
                setDefaultGradientBackground(true);
                hideLoadingLayer();
                gtj();
                if (getLiveData().hUa()) {
                    gEz();
                }
                Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "startPollInfoTimer");
                if (this.timerThread == null) {
                    this.timerThread = new MTimerHandler("FestivalFinderShareInfoPlugin::Timer", (MTimerHandler.CallBack) new i(this), true);
                }
                MTimerHandler mTimerHandler = this.timerThread;
                if (mTimerHandler != null) {
                    mTimerHandler.stopTimer();
                }
                MTimerHandler mTimerHandler2 = this.timerThread;
                if (mTimerHandler2 != null) {
                    mTimerHandler2.startTimer(1, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                }
                if (!this.UuF) {
                    r rVar = r.UyJ;
                    Log.i("FestivalMusicManager", "startPlayMusic");
                    com.tencent.mm.ai.c.iS("festival2021", r.dtX);
                    EventCenter.instance.add(r.UyG);
                    z zVar = z.Uzb;
                    z.a(rVar);
                    r.hea();
                    AppMethodBeat.o(262628);
                    return;
                }
                break;
            case 2:
                com.tencent.mm.plugin.festival.model.i iVar2 = com.tencent.mm.plugin.festival.model.i.Uyl;
                com.tencent.mm.plugin.festival.model.i.log("live room start status. " + getKeyStatusStr());
                if (getLiveData().uDz == null || ((finderObject = getLiveData().uDz) != null && finderObject.id == 0)) {
                    com.tencent.mm.plugin.festival.model.i iVar3 = com.tencent.mm.plugin.festival.model.i.Uyl;
                    com.tencent.mm.plugin.festival.model.i.log("plugin layout checkFinderObject");
                    new com.tencent.mm.plugin.finder.cgi.af(getLiveData().hFK, getData().uCr.aBI(), 0, 2, "", true, null, null, 0, null, false, false, null, null, 0, 24512).aYI().b(new c(this));
                }
                at atVar = at.Uuv;
                long j2 = getLiveData().liveInfo.liveId;
                at.hWh.aTv();
                at.P(0, j2);
                Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "statusChange START_LIVE");
                AppMethodBeat.o(262628);
                return;
            case 3:
                com.tencent.mm.plugin.festival.model.i iVar4 = com.tencent.mm.plugin.festival.model.i.Uyl;
                com.tencent.mm.plugin.festival.model.i.log("live room has finished status. " + getKeyStatusStr());
                com.tencent.mm.plugin.festival.model.i iVar5 = com.tencent.mm.plugin.festival.model.i.Uyl;
                com.tencent.mm.plugin.festival.model.i.log("plugin layout notifyLiveFinish " + getKeyStatusStr());
                if (getLiveData().djl()) {
                    hn hnVar = new hn();
                    hnVar.dLW.id = getLiveData().liveInfo.liveId;
                    hnVar.dLW.username = getLiveData().hwd;
                    hnVar.dLW.liveStatus = 2;
                    hnVar.dLW.dLY = 1;
                    hnVar.dLW.type = 8;
                    EventCenter.instance.publish(hnVar);
                }
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    finderLiveAssistant.dfk();
                }
                at atVar2 = at.Uuv;
                at.aHh();
                Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "statusChange LIVE_HAS_FINISHED");
                AppMethodBeat.o(262628);
                return;
            case 4:
            case 5:
                setManualClosed(true);
                com.tencent.mm.plugin.festival.model.i iVar6 = com.tencent.mm.plugin.festival.model.i.Uyl;
                com.tencent.mm.plugin.festival.model.i.log("live room close live status. " + getKeyStatusStr());
                com.tencent.mm.plugin.festival.model.h.Uye.cir();
                finish();
                AppMethodBeat.o(262628);
                return;
            case 6:
                if (getLiveData().uDQ) {
                    b.C0376b.a(this, b.c.hLV);
                    AppMethodBeat.o(262628);
                    return;
                }
                break;
            case 7:
                onScreenClear(bundle != null ? bundle.getBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR") : false);
                AppMethodBeat.o(262628);
                return;
            case 8:
                List<com.tencent.mm.plugin.finder.live.model.t> list = getLiveData().uDs;
                p.g(list, "liveData.msgList");
                if (!list.isEmpty()) {
                    m mVar = m.vli;
                    List<com.tencent.mm.plugin.finder.live.model.t> list2 = getLiveData().uDs;
                    p.g(list2, "liveData.msgList");
                    mVar.gP(((com.tencent.mm.plugin.finder.live.model.t) kotlin.a.j.ku(list2)).getContent(), "");
                    AppMethodBeat.o(262628);
                    return;
                }
                break;
            case 9:
                AppMethodBeat.o(262628);
                return;
            case 10:
                if (!isLandscape()) {
                    t tVar = this.UsO;
                    if (tVar != null) {
                        ViewGroup viewGroup = tVar.hwr;
                        (viewGroup != null ? Boolean.valueOf(viewGroup.post(new j(tVar, this, bundle))) : null).booleanValue();
                        AppMethodBeat.o(262628);
                        return;
                    }
                    AppMethodBeat.o(262628);
                    return;
                }
                break;
            case 11:
                ar arVar = this.UuT;
                if (arVar != null) {
                    arVar.n(Boolean.TRUE);
                    AppMethodBeat.o(262628);
                    return;
                }
                AppMethodBeat.o(262628);
                return;
            case 12:
                w.a aVar = this.UtL;
                if (aVar != null) {
                    aVar.Fh(false);
                }
                ar arVar2 = this.UuT;
                if (arVar2 != null) {
                    arVar2.n(Boolean.FALSE);
                    AppMethodBeat.o(262628);
                    return;
                }
                AppMethodBeat.o(262628);
                return;
            case 13:
                if (bundle != null) {
                    pointF = (PointF) bundle.getParcelable("PARAM_FESTIVAL_FINDER_LIVE_CANVAS_CLICK_POINT");
                } else {
                    pointF = null;
                }
                if (pointF != null && !Float.isNaN(pointF.x) && !Float.isNaN(pointF.y)) {
                    bn[] bnVarArr = new bn[4];
                    c cVar2 = this.UuX;
                    if (cVar2 == null) {
                        p.hyc();
                    }
                    bnVarArr[0] = cVar2;
                    h hVar = this.UuW;
                    if (hVar == null) {
                        p.hyc();
                    }
                    bnVarArr[1] = hVar;
                    q qVar = this.UuV;
                    if (qVar == null) {
                        p.hyc();
                    }
                    bnVarArr[2] = qVar;
                    ar arVar3 = this.UuT;
                    if (arVar3 == null) {
                        p.hyc();
                    }
                    bnVarArr[3] = arVar3;
                    int i2 = 0;
                    while (i2 < 4 && !bnVarArr[i2].d(pointF)) {
                        i2++;
                    }
                }
                break;
        }
        AppMethodBeat.o(262628);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorPluginLayout$statusChange$1$1"})
    public static final class j implements Runnable {
        final /* synthetic */ Bundle $param$inlined;
        final /* synthetic */ FestivalFinderLiveVisitorPluginLayout Uvl;
        final /* synthetic */ t Uvo;

        j(t tVar, FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout, Bundle bundle) {
            this.Uvo = tVar;
            this.Uvl = festivalFinderLiveVisitorPluginLayout;
            this.$param$inlined = bundle;
        }

        public final void run() {
            AppMethodBeat.i(262610);
            Bundle bundle = this.$param$inlined;
            if (bundle == null || !bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                x xVar = this.Uvl.UuK;
                if (xVar != null) {
                    xVar.UsO = null;
                }
                ViewGroup.LayoutParams layoutParams = this.Uvo.hwr.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(262610);
                    throw tVar;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.removeRule(12);
                layoutParams2.addRule(2, R.id.cz7);
                ViewGroup.LayoutParams layoutParams3 = this.Uvo.hwr.getLayoutParams();
                if (layoutParams3 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(262610);
                    throw tVar2;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = this.Uvl.originCommentBottomMargin;
                AppMethodBeat.o(262610);
                return;
            }
            FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout = this.Uvl;
            ViewGroup.LayoutParams layoutParams4 = this.Uvo.hwr.getLayoutParams();
            if (layoutParams4 == null) {
                kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(262610);
                throw tVar3;
            }
            festivalFinderLiveVisitorPluginLayout.originCommentBottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin;
            x xVar2 = this.Uvl.UuK;
            if (xVar2 != null) {
                xVar2.UsO = this.Uvl.UsO;
            }
            ViewGroup.LayoutParams layoutParams5 = this.Uvo.hwr.getLayoutParams();
            if (layoutParams5 == null) {
                kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(262610);
                throw tVar4;
            }
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
            layoutParams6.addRule(12);
            layoutParams6.removeRule(2);
            AppMethodBeat.o(262610);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(262629);
        Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "onSceneEnd errType:" + i2 + ", errCode:" + i3 + ", scene:" + qVar);
        AppMethodBeat.o(262629);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onLiveEventCallback(int i2, Bundle bundle) {
        AppMethodBeat.i(262630);
        Log.e("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "unexpected reach errCode:%d", Integer.valueOf(i2));
        AppMethodBeat.o(262630);
    }

    /* access modifiers changed from: package-private */
    public final String getKeyStatusStr() {
        AppMethodBeat.i(262631);
        String str = "   isWishLiveStarted:" + this.Uvg + " isFromFloatBall:" + this.UuF + " isRestart:" + this.Uvf + " hasJoinLive:" + getLiveData().hUa() + " hadTotalRelease:" + this.Uvh;
        AppMethodBeat.o(262631);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FestivalFinderLiveVisitorPluginLayout Uvl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
            super(0);
            this.Uvl = festivalFinderLiveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262605);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.festival.finder.FestivalFinderLiveVisitorPluginLayout.e.AnonymousClass1 */
                final /* synthetic */ e Uvn;

                {
                    this.Uvn = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(262604);
                    t tVar = this.Uvn.Uvl.UsO;
                    if (tVar != null) {
                        List<com.tencent.mm.plugin.finder.live.model.t> list = this.Uvn.Uvl.getLiveData().uDs;
                        p.g(list, "liveData.msgList");
                        tVar.ea(list);
                    }
                    z zVar = this.Uvn.Uvl.Uvd;
                    if (zVar != null) {
                        List<aut> list2 = this.Uvn.Uvl.getLiveData().uDv;
                        p.g(list2, "liveData.highLightCheerList");
                        p.h(list2, "hlCheerList");
                        com.tencent.mm.ac.d.h(new z.g(zVar, list2));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(262604);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(262605);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FestivalFinderLiveVisitorPluginLayout Uvl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
            super(0);
            this.Uvl = festivalFinderLiveVisitorPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262601);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.festival.finder.FestivalFinderLiveVisitorPluginLayout.b.AnonymousClass1 */
                final /* synthetic */ b Uvm;

                {
                    this.Uvm = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(262600);
                    b.C0376b.a(this.Uvm.Uvl, b.c.hLV);
                    x xVar = x.SXb;
                    AppMethodBeat.o(262600);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(262601);
            return xVar;
        }
    }

    public static /* synthetic */ Bitmap a(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
        AppMethodBeat.i(262632);
        Bitmap gD = festivalFinderLiveVisitorPluginLayout.Uvj.gD(festivalFinderLiveVisitorPluginLayout.getParent());
        AppMethodBeat.o(262632);
        return gD;
    }

    public static /* synthetic */ Bitmap b(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout) {
        ViewGroup viewGroup;
        AppMethodBeat.i(262633);
        com.tencent.mm.plugin.festival.c.a aVar = festivalFinderLiveVisitorPluginLayout.Uvj;
        e eVar = festivalFinderLiveVisitorPluginLayout.UuU;
        if (eVar != null) {
            viewGroup = eVar.hwr;
        } else {
            viewGroup = null;
        }
        Bitmap gD = aVar.gD(viewGroup);
        AppMethodBeat.o(262633);
        return gD;
    }

    public static final /* synthetic */ void a(FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout, int i2, String str) {
        s.n nVar;
        String str2;
        long ahy;
        AppMethodBeat.i(262638);
        Log.i("MicroMsg.FestivalFinderLiveVisitorPluginLayout", "join live room errCode:" + i2 + " errMsg:" + str);
        switch (i2) {
            case -200030:
                nVar = s.n.LIVE_NO_ACCESS_PERMISSION;
                break;
            case -200001:
                nVar = s.n.LIVE_IN_BLACK_LIST;
                break;
            case -100038:
                nVar = s.n.LIVE_STOPPED;
                break;
            default:
                nVar = s.n.LIVE_STOPPED;
                break;
        }
        m mVar = m.vli;
        m.a(nVar);
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        long j2 = festivalFinderLiveVisitorPluginLayout.getLiveData().hFK;
        long j3 = festivalFinderLiveVisitorPluginLayout.getLiveData().liveInfo.liveId;
        if (TextUtils.isEmpty(festivalFinderLiveVisitorPluginLayout.getData().uCs.hwd)) {
            str2 = festivalFinderLiveVisitorPluginLayout.getLiveData().hwd;
        } else {
            str2 = festivalFinderLiveVisitorPluginLayout.getData().uCs.hwd;
        }
        com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        long j4 = com.tencent.mm.plugin.finder.report.live.k.dpl().vlw;
        long size = (long) festivalFinderLiveVisitorPluginLayout.getLiveData().uDn.size();
        s.p pVar = s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL;
        com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        String str3 = com.tencent.mm.plugin.finder.report.live.k.dpl().vlv;
        long j5 = nVar.jii;
        m mVar2 = m.vli;
        if (m.ahy() <= 0) {
            ahy = System.currentTimeMillis();
        } else {
            m mVar3 = m.vli;
            ahy = m.ahy();
        }
        com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        kVar.a(j2, j3, str2, j4, size, pVar, str3, j5, ahy, com.tencent.mm.plugin.finder.report.live.k.dpl().vma);
        AppMethodBeat.o(262638);
    }
}
