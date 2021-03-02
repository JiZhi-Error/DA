package com.tencent.mm.plugin.webview.ui.tools.media;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.y;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.bo.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.u;
import com.tencent.xweb.v;
import java.util.Arrays;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0011J\b\u0010_\u001a\u00020]H\u0002J\u0006\u0010`\u001a\u00020]J\b\u0010a\u001a\u00020bH\u0002J\b\u0010c\u001a\u00020]H\u0002J\u0010\u0010d\u001a\u00020b2\u0006\u0010e\u001a\u00020\u000bH\u0002J\b\u0010f\u001a\u00020]H\u0002J\u0010\u0010J\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\"H\u0002J\b\u0010h\u001a\u00020]H\u0002J\u0010\u0010i\u001a\u00020]2\u0006\u0010j\u001a\u00020\"H\u0002J\b\u0010k\u001a\u00020]H\u0002J\b\u0010l\u001a\u00020]H\u0002J\b\u0010m\u001a\u00020]H\u0002J\b\u0010n\u001a\u00020]H\u0002J\b\u0010o\u001a\u00020]H\u0002J\u000e\u0010p\u001a\u00020]2\u0006\u00109\u001a\u00020:J\b\u0010q\u001a\u00020]H\u0002J\b\u0010r\u001a\u00020]H\u0002J\b\u0010s\u001a\u00020]H\u0002J\u0006\u0010t\u001a\u00020]J\u0006\u0010u\u001a\u00020\"J\b\u0010v\u001a\u00020]H\u0002J\u0012\u0010w\u001a\u00020]2\b\u0010x\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010y\u001a\u00020]2\u0006\u0010z\u001a\u00020{H\u0016J\u0006\u0010|\u001a\u00020]J\u0006\u0010}\u001a\u00020]J\u0006\u0010~\u001a\u00020]J\b\u0010\u001a\u00020]H\u0002J\t\u0010\u0001\u001a\u00020]H\u0002J\u0007\u0010\u0001\u001a\u00020]J\t\u0010\u0001\u001a\u00020]H\u0007J\t\u0010\u0001\u001a\u00020]H\u0002J\t\u0010\u0001\u001a\u00020]H\u0002J\u001f\u0010\u0001\u001a\u00020]2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J\t\u0010\u0001\u001a\u00020]H\u0002J\t\u0010\u0001\u001a\u00020]H\u0002J\t\u0010\u0001\u001a\u00020]H\u0002J\t\u0010\u0001\u001a\u00020]H\u0002J\t\u0010\u0001\u001a\u00020]H\u0002J\u0007\u0010\u0001\u001a\u00020\"J\u0012\u0010\u0001\u001a\u00020]2\u0007\u0010\u0001\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010;\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010I\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010N\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u000e\u0010O\u001a\u00020PX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ENTER_HIDE_MIL_SEC", "", "INVALID_ORIENTATION", "", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/view/View;", "centerPlayIv", "closeIv", "currentPlayTime", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "footerLayout", "forbidForward", "", "getForbidForward", "()Z", "setForbidForward", "(Z)V", "forwardUiVisibility", "hasAddVideoView", "hasAdjustOrientation", "hideToolBarTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isLandScapeVideo", "isPlaying", "isRunningExitAnimation", "loadingBar", "Landroid/widget/ProgressBar;", "mCurrentOrientation", "mIsShowOpLayout", "mPreOrientation", "moreIv", "moreLayout", "mpInfoLayout", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "mpShareVideoReport", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "getMpShareVideoReport", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "needDoAnimation", "nicknameTv", "Landroid/widget/TextView;", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "preDeltaX", "preDeltaY", "preScale", "", "shareIv", "subScene", "getSubScene", "()Ljava/lang/Integer;", "setSubScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "toolBarMask", "touchLayout", "videoContainerLayout", "Landroid/view/ViewGroup;", "videoControl", "Lcom/tencent/xweb/VideoControl;", "videoPlayOpLayout", "videoPlayRootLayout", "videoPlayerSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoRootLayout", "addVideoView", "", "view", "adjustOrientation", "exit", "fadeInAnimation", "Landroid/view/animation/Animation;", "fadeInOpLayout", "fadeOutAnimation", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "fadeOutOpLayout", "force", "handleAnimation", "handleFullScreenStatusBar", "fullScreen", "handleHorizontalUI", "handleScreenSize", "handleVerticalUI", "hideLoading", "hideToolBar", "initData", "initReportData", "initSeekBar", "initVideoController", "initView", "isInFullScreen", "loadAvatar", "onClick", "v", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onExit", "onExitMpVideoFullPage", "onResume", "opPlay", "postHandleVerticalUI", "removeVideoView", "resetOrientation", "runDragAnimation", "runEnterAnimation", "runExitAnimation", "bm", "Landroid/graphics/Bitmap;", "callback", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "showLoading", "showToolBar", "starHideToolBar", "startHideToolBarTimer", "stopHideToolBarTimer", "supportFullScreen", "updatePlayBtn", "playing", "plugin-webview_release"})
public final class MPVideoPlayFullScreenView extends RelativeLayout implements View.OnClickListener {
    public float EAC;
    public int EAD;
    public int EAE;
    public boolean FLK;
    private RedesignVideoPlayerSeekBar FLz;
    private com.tencent.mm.bo.a Jii;
    public View JvH;
    private View JvI;
    private ViewGroup JvJ;
    public ViewGroup JvK;
    private View JvL;
    private View JvM;
    private View JvN;
    private View JvO;
    private View JvP;
    private View JvQ;
    public u JvR;
    private View JvS;
    private double JvT;
    private final int JvU = -3;
    private int JvV = this.JvU;
    private boolean JvW;
    private boolean JvX;
    private boolean JvY;
    private final h JvZ;
    private boolean Jwa;
    private Integer Jwb;
    private MTimerHandler Jwc;
    private final long Jwd;
    private boolean Jwe;
    public final String TAG = "MicroMsg.MPVideoPlayFullScreenView";
    private boolean gVd;
    private ImageView gyr;
    private ProgressBar hRO;
    private boolean iAS;
    public y iwi;
    private int mCurrentOrientation = -1;
    private int pHu;
    private TextView pIN;
    private MMNeat7extView pIO;
    private long pLN;
    private int pNM;
    private View pvJ;
    private View pxG;
    public com.tencent.mm.ui.tools.e qaE;
    private View tFX;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MPVideoPlayFullScreenView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(82641);
        this.Jii = new com.tencent.mm.bo.a(context, new j(this, context));
        this.JvZ = new h();
        View.inflate(context, R.layout.bbv, this);
        View findViewById = findViewById(R.id.j5r);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.video_play_root_layout)");
        this.JvH = findViewById;
        View findViewById2 = findViewById(R.id.j5p);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.video_play_op_layout)");
        this.JvI = findViewById2;
        View findViewById3 = findViewById(R.id.j45);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.video_container_layout)");
        this.JvJ = (ViewGroup) findViewById3;
        View findViewById4 = findViewById(R.id.j5v);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.video_player_footer)");
        this.JvL = findViewById4;
        View findViewById5 = findViewById(R.id.flg);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.mp_info_layout)");
        this.JvM = findViewById5;
        View findViewById6 = findViewById(R.id.j6w);
        kotlin.g.b.p.g(findViewById6, "findViewById(R.id.video_touch_layout)");
        this.JvN = findViewById6;
        View findViewById7 = findViewById(R.id.flk);
        kotlin.g.b.p.g(findViewById7, "findViewById(R.id.mp_video_avatar_layout)");
        this.tFX = findViewById7;
        View findViewById8 = findViewById(R.id.flj);
        kotlin.g.b.p.g(findViewById8, "findViewById(R.id.mp_video_avatar_iv)");
        this.gyr = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.flu);
        kotlin.g.b.p.g(findViewById9, "findViewById(R.id.mp_video_nickname_tv)");
        this.pIN = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.flz);
        kotlin.g.b.p.g(findViewById10, "findViewById(R.id.mp_video_title_tv)");
        this.pIO = (MMNeat7extView) findViewById10;
        View findViewById11 = findViewById(R.id.fm0);
        kotlin.g.b.p.g(findViewById11, "findViewById(R.id.mp_video_view_article_layout)");
        this.pxG = findViewById11;
        this.FLz = (RedesignVideoPlayerSeekBar) findViewById(R.id.j5y);
        this.JvS = findViewById(R.id.irz);
        this.hRO = (ProgressBar) findViewById(R.id.j5x);
        RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = this.FLz;
        if (redesignVideoPlayerSeekBar != null) {
            redesignVideoPlayerSeekBar.setOnClickListener(this);
        }
        View view = this.JvL;
        if (view != null) {
            view.setOnClickListener(AnonymousClass1.Jwf);
        }
        View view2 = this.JvM;
        if (view2 != null) {
            view2.setOnClickListener(AnonymousClass2.Jwg);
        }
        this.tFX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.AnonymousClass3 */
            final /* synthetic */ MPVideoPlayFullScreenView Jwh;

            {
                this.Jwh = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:6:0x003a, code lost:
                if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0 != null ? r0.dHc : null) != false) goto L_0x003c;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r10) {
                /*
                // Method dump skipped, instructions count: 169
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.AnonymousClass3.onClick(android.view.View):void");
            }
        });
        com.tencent.mm.ui.tools.o.hp(this.tFX);
        View findViewById12 = findViewById(R.id.j5u);
        kotlin.g.b.p.g(findViewById12, "findViewById(R.id.video_player_close)");
        this.pvJ = findViewById12;
        this.pvJ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.AnonymousClass4 */
            final /* synthetic */ MPVideoPlayFullScreenView Jwh;

            {
                this.Jwh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(82586);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Jwh.exit();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82586);
            }
        });
        View findViewById13 = findViewById(R.id.j5w);
        kotlin.g.b.p.g(findViewById13, "findViewById(R.id.video_player_more_iv)");
        this.JvO = findViewById13;
        this.JvO.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.AnonymousClass5 */
            final /* synthetic */ MPVideoPlayFullScreenView Jwh;

            {
                this.Jwh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(82587);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                y yVar = this.Jwh.iwi;
                if (yVar != null) {
                    g gVar = g.JwF;
                    g.a(context, yVar, 4);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82587);
            }
        });
        View findViewById14 = findViewById(R.id.j5z);
        kotlin.g.b.p.g(findViewById14, "findViewById(R.id.video_player_share_iv)");
        this.JvQ = findViewById14;
        this.JvQ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.AnonymousClass6 */
            final /* synthetic */ MPVideoPlayFullScreenView Jwh;

            {
                this.Jwh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(82588);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Context context = context;
                if (!(context instanceof WebViewUI) || this.Jwh.iwi == null) {
                    Log.w(this.Jwh.TAG, "should not be here");
                } else {
                    if (z.gsM()) {
                        g gVar = g.JwF;
                        y yVar = this.Jwh.iwi;
                        if (yVar == null) {
                            kotlin.g.b.p.hyc();
                        }
                        g.a(context, yVar, 5);
                    } else {
                        ((WebViewUI) context).JjJ.iwi = this.Jwh.iwi;
                        d dVar = d.Jwx;
                        y yVar2 = this.Jwh.iwi;
                        if (yVar2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        String str = yVar2.iAo;
                        y yVar3 = this.Jwh.iwi;
                        if (yVar3 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        String str2 = yVar3.title;
                        y yVar4 = this.Jwh.iwi;
                        if (yVar4 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        d.a(context, str, "", str2, yVar4.KOe, 2);
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18589, 16, 3);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82588);
            }
        });
        View findViewById15 = findViewById(R.id.j71);
        kotlin.g.b.p.g(findViewById15, "findViewById(R.id.video_wait_play_btn)");
        this.JvP = findViewById15;
        this.JvP.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.AnonymousClass7 */
            final /* synthetic */ MPVideoPlayFullScreenView Jwh;

            {
                this.Jwh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(82589);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MPVideoPlayFullScreenView.C(this.Jwh);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82589);
            }
        });
        this.pxG.setVisibility(8);
        RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar2 = this.FLz;
        if (redesignVideoPlayerSeekBar2 != null) {
            redesignVideoPlayerSeekBar2.setPlayBtnOnClickListener(this);
        }
        RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar3 = this.FLz;
        if (redesignVideoPlayerSeekBar3 != null) {
            redesignVideoPlayerSeekBar3.setIplaySeekCallback(new h(this));
        }
        this.EAC = 1.0f;
        this.Jwc = new MTimerHandler(new g(this), true);
        this.Jwd = 4000;
        AppMethodBeat.o(82641);
    }

    public static final /* synthetic */ void B(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
        AppMethodBeat.i(182655);
        mPVideoPlayFullScreenView.ghR();
        AppMethodBeat.o(182655);
    }

    public static final /* synthetic */ void C(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
        AppMethodBeat.i(82650);
        mPVideoPlayFullScreenView.ghJ();
        AppMethodBeat.o(82650);
    }

    public static final /* synthetic */ void c(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
        AppMethodBeat.i(82642);
        mPVideoPlayFullScreenView.ghI();
        AppMethodBeat.o(82642);
    }

    public static final /* synthetic */ void i(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
        AppMethodBeat.i(82645);
        mPVideoPlayFullScreenView.ghM();
        AppMethodBeat.o(82645);
    }

    public final int getEnterId() {
        return this.pHu;
    }

    public final void setEnterId(int i2) {
        this.pHu = i2;
    }

    public final long getEnterTimeInMs() {
        return this.pLN;
    }

    public final void setEnterTimeInMs(long j2) {
        this.pLN = j2;
    }

    public final boolean getForbidForward() {
        return this.iAS;
    }

    public final void setForbidForward(boolean z) {
        this.iAS = z;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
    static final class j implements a.b {
        final /* synthetic */ Context $context;
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        j(MPVideoPlayFullScreenView mPVideoPlayFullScreenView, Context context) {
            this.Jwh = mPVideoPlayFullScreenView;
            this.$context = context;
        }

        @Override // com.tencent.mm.bo.a.b
        public final void a(a.EnumC0280a aVar, a.EnumC0280a aVar2) {
            int i2;
            AppMethodBeat.i(182651);
            if (this.Jwh.JvW) {
                MPVideoPlayFullScreenView mPVideoPlayFullScreenView = this.Jwh;
                if (aVar2 == null) {
                    AppMethodBeat.o(182651);
                    return;
                }
                switch (b.$EnumSwitchMapping$0[aVar2.ordinal()]) {
                    case 1:
                        i2 = 0;
                        break;
                    case 2:
                        i2 = 8;
                        break;
                    default:
                        AppMethodBeat.o(182651);
                        return;
                }
                mPVideoPlayFullScreenView.mCurrentOrientation = i2;
                Context context = this.$context;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(182651);
                    throw tVar;
                }
                ((Activity) context).setRequestedOrientation(this.Jwh.mCurrentOrientation);
                MPVideoPlayFullScreenView.B(this.Jwh);
            }
            AppMethodBeat.o(182651);
        }
    }

    public final h getMpShareVideoReport() {
        return this.JvZ;
    }

    public final synchronized void a(y yVar) {
        String str;
        String str2;
        MultiTaskInfo multiTaskInfo;
        cru erh;
        AppMethodBeat.i(210555);
        kotlin.g.b.p.h(yVar, "mpShareVideoInfo");
        this.iwi = yVar;
        this.iAS = yVar.iAS;
        TextPaint paint = this.pIO.getPaint();
        kotlin.g.b.p.g(paint, "titleTv.paint");
        paint.setFakeBoldText(true);
        TextPaint paint2 = this.pIN.getPaint();
        kotlin.g.b.p.g(paint2, "nicknameTv.paint");
        paint2.setFakeBoldText(true);
        MMNeat7extView mMNeat7extView = this.pIO;
        y yVar2 = this.iwi;
        mMNeat7extView.aw(yVar2 != null ? yVar2.title : null);
        TextView textView = this.pIN;
        Context context = getContext();
        y yVar3 = this.iwi;
        if (yVar3 != null) {
            str = yVar3.iAg;
        } else {
            str = null;
        }
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, str, this.pIN.getTextSize()));
        if (this.iAS) {
            this.JvO.setVisibility(8);
            this.JvQ.setVisibility(8);
        } else {
            this.JvO.setVisibility(0);
            this.JvQ.setVisibility(0);
        }
        Context context2 = getContext();
        if (context2 instanceof WebViewUI) {
            y yVar4 = this.iwi;
            if (!Util.isNullOrNil(yVar4 != null ? yVar4.iAR : null)) {
                y yVar5 = this.iwi;
                str2 = yVar5 != null ? yVar5.iAR : null;
            } else {
                com.tencent.mm.plugin.webview.ui.tools.multitask.a gff = ((WebViewUI) context2).gff();
                str2 = (gff == null || (multiTaskInfo = gff.Abp) == null || (erh = multiTaskInfo.erh()) == null) ? null : erh.MwR;
            }
            com.tencent.mm.av.a.a.bdb().a(str2, this.gyr, new c.a().bdt().ty(R.drawable.bar).bdv());
        }
        if (this.Jwa) {
            ghH();
        }
        Log.d(this.TAG, "initData");
        ghK();
        AppMethodBeat.o(210555);
    }

    private final void ghH() {
        AppMethodBeat.i(82626);
        if (this.qaE == null) {
            this.qaE = new com.tencent.mm.ui.tools.e(getContext());
        }
        if (this.iwi == null) {
            this.Jwa = true;
            AppMethodBeat.o(82626);
            return;
        }
        this.Jwa = false;
        y yVar = this.iwi;
        if (yVar == null) {
            kotlin.g.b.p.hyc();
        }
        int i2 = yVar.iAL;
        y yVar2 = this.iwi;
        if (yVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        int i3 = yVar2.iAM;
        y yVar3 = this.iwi;
        if (yVar3 == null) {
            kotlin.g.b.p.hyc();
        }
        int i4 = yVar3.iAN;
        y yVar4 = this.iwi;
        if (yVar4 == null) {
            kotlin.g.b.p.hyc();
        }
        int i5 = yVar4.iAO;
        com.tencent.mm.ui.tools.e eVar = this.qaE;
        if (eVar != null) {
            eVar.Q(i2, i3, i4, i5);
        }
        com.tencent.mm.ui.tools.e eVar2 = this.qaE;
        if (eVar2 != null) {
            eVar2.gXF();
        }
        com.tencent.mm.ui.tools.e eVar3 = this.qaE;
        if (eVar3 != null) {
            eVar3.lu(0, 0);
        }
        ghI();
        AppMethodBeat.o(82626);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
    public static final class p implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        public final void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            AppMethodBeat.i(82620);
            Log.d(this.Jwh.TAG, "runEnterAnimation");
            ViewGroup viewGroup = this.Jwh.JvK;
            if (!(viewGroup == null || (viewTreeObserver = viewGroup.getViewTreeObserver()) == null)) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            ViewGroup viewGroup2 = this.Jwh.JvK;
            Integer valueOf = viewGroup2 != null ? Integer.valueOf(viewGroup2.getHeight()) : null;
            if (valueOf == null) {
                kotlin.g.b.p.hyc();
            }
            if (valueOf.intValue() <= 0) {
                MPVideoPlayFullScreenView.c(this.Jwh);
                AppMethodBeat.o(82620);
                return;
            }
            MPVideoPlayFullScreenView.d(this.Jwh);
            com.tencent.mm.ui.tools.e eVar = this.Jwh.qaE;
            if (eVar != null) {
                ViewGroup viewGroup3 = this.Jwh.JvK;
                if (viewGroup3 == null) {
                    kotlin.g.b.p.hyc();
                }
                eVar.a(viewGroup3, null, new a(this));
                AppMethodBeat.o(82620);
                return;
            }
            AppMethodBeat.o(82620);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1$onGlobalLayout$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
        public static final class a implements e.c {
            final /* synthetic */ p Jwp;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(p pVar) {
                this.Jwp = pVar;
            }

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationStart() {
            }

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationEnd() {
                AppMethodBeat.i(82619);
                MPVideoPlayFullScreenView.f(this.Jwp.Jwh);
                AppMethodBeat.o(82619);
            }
        }
    }

    private final void ghI() {
        ViewTreeObserver viewTreeObserver;
        AppMethodBeat.i(82627);
        ViewGroup viewGroup = this.JvK;
        if (viewGroup == null || (viewTreeObserver = viewGroup.getViewTreeObserver()) == null) {
            AppMethodBeat.o(82627);
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new p(this));
        AppMethodBeat.o(82627);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onExit"})
    public static final class k implements e.b {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        k(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        @Override // com.tencent.mm.ui.tools.e.b
        public final void onExit() {
            AppMethodBeat.i(82613);
            this.Jwh.exit();
            AppMethodBeat.o(82613);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "longClickOver"})
    public static final class l implements e.d {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        l(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        @Override // com.tencent.mm.ui.tools.e.d
        public final void bmu() {
            y yVar;
            AppMethodBeat.i(82614);
            if (this.Jwh.getForbidForward() || (yVar = this.Jwh.iwi) == null) {
                AppMethodBeat.o(82614);
                return;
            }
            g gVar = g.JwF;
            Context context = this.Jwh.getContext();
            kotlin.g.b.p.g(context, "context");
            g.a(context, yVar, 3);
            AppMethodBeat.o(82614);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    public static final class m implements e.f {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        m(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        @Override // com.tencent.mm.ui.tools.e.f
        public final void onClick() {
            AppMethodBeat.i(82615);
            if (this.Jwh.JvI.getVisibility() == 0) {
                MPVideoPlayFullScreenView.i(this.Jwh);
                AppMethodBeat.o(82615);
                return;
            }
            MPVideoPlayFullScreenView.f(this.Jwh);
            AppMethodBeat.o(82615);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "tx", "", "ty", "onGalleryScale"})
    public static final class n implements e.AbstractC2131e {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        n(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        @Override // com.tencent.mm.ui.tools.e.AbstractC2131e
        public final void S(float f2, float f3) {
            AppMethodBeat.i(82616);
            if (f2 == 0.0f && f3 == 0.0f) {
                MPVideoPlayFullScreenView.f(this.Jwh);
                AppMethodBeat.o(82616);
                return;
            }
            if (Math.abs(f2) > 10.0f || Math.abs(f3) > 10.0f) {
                MPVideoPlayFullScreenView.i(this.Jwh);
            }
            AppMethodBeat.o(82616);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class o implements View.OnClickListener {
        public static final o Jwo = new o();

        static {
            AppMethodBeat.i(82618);
            AppMethodBeat.o(82618);
        }

        o() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(82617);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runDragAnimation$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runDragAnimation$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(82617);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runExitAnimation$2", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
    public static final class q implements e.c {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;
        final /* synthetic */ e.c Jwq = null;
        final /* synthetic */ ViewGroup.LayoutParams Jwr;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.tencent.mm.ui.tools.e$c */
        /* JADX WARN: Multi-variable type inference failed */
        public q(MPVideoPlayFullScreenView mPVideoPlayFullScreenView, e.c cVar) {
            this.Jwh = mPVideoPlayFullScreenView;
            this.Jwr = cVar;
        }

        @Override // com.tencent.mm.ui.tools.e.c
        public final void onAnimationStart() {
            AppMethodBeat.i(82622);
            this.Jwh.FLK = true;
            e.c cVar = this.Jwq;
            if (cVar != null) {
                cVar.onAnimationStart();
                AppMethodBeat.o(82622);
                return;
            }
            AppMethodBeat.o(82622);
        }

        @Override // com.tencent.mm.ui.tools.e.c
        public final void onAnimationEnd() {
            AppMethodBeat.i(82623);
            e.c cVar = this.Jwq;
            if (cVar != null) {
                cVar.onAnimationEnd();
            }
            this.Jwh.JvH.post(new a(this));
            this.Jwh.FLK = false;
            this.Jwh.onExit();
            AppMethodBeat.o(82623);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ q Jws;

            a(q qVar) {
                this.Jws = qVar;
            }

            public final void run() {
                AppMethodBeat.i(82621);
                Context context = this.Jws.Jwh.getContext();
                if ((context instanceof WebViewUI) && ((WebViewUI) context).gfW() != null) {
                    Context context2 = this.Jws.Jwh.getContext();
                    if (context2 == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                        AppMethodBeat.o(82621);
                        throw tVar;
                    }
                    ((WebViewUI) context2).gfW().leaveFullscreen();
                }
                this.Jws.Jwh.JvH.setLayoutParams(this.Jws.Jwr);
                AppMethodBeat.o(82621);
            }
        }
    }

    public final void exit() {
        AppMethodBeat.i(82628);
        Context context = getContext();
        if (!(context instanceof WebViewUI) || ((WebViewUI) context).gfW() == null) {
            Log.w(this.TAG, "should not be here");
        } else if (((WebViewUI) context).gfW() != null) {
            Log.i(this.TAG, "close click");
            ghL();
            ((WebViewUI) context).gfW().leaveFullscreen();
            MMHandlerThread.postToMainThreadDelayed(new a(this), 500);
            AppMethodBeat.o(82628);
            return;
        }
        AppMethodBeat.o(82628);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        a(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        public final void run() {
            AppMethodBeat.i(82590);
            this.Jwh.onExit();
            AppMethodBeat.o(82590);
        }
    }

    public final void onExit() {
        AppMethodBeat.i(82629);
        if (getVisibility() == 8) {
            AppMethodBeat.o(82629);
            return;
        }
        setVisibility(8);
        removeVideoView();
        Log.i(this.TAG, "onExitMpVideoFullPage");
        this.JvX = false;
        this.JvY = false;
        if (this.iwi != null) {
            this.JvZ.pLC = (int) (System.currentTimeMillis() - this.pLN);
            this.JvZ.pLB = (int) (this.JvT * 1000.0d);
            this.JvZ.a(this.iwi, 6, this.pHu);
            this.JvZ.a(this.iwi, 2, this.pHu);
            Context context = getContext();
            if ((context instanceof WebViewUI) && ((WebViewUI) context).IBw != null) {
                com.tencent.mm.plugin.webview.d.h hVar = ((WebViewUI) context).IBw;
                y yVar = this.iwi;
                if (yVar == null) {
                    kotlin.g.b.p.hyc();
                }
                hVar.gh(yVar.KOf, (int) this.JvT);
            }
            this.iwi = null;
        }
        AppMethodBeat.o(82629);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class s implements Runnable {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;
        final /* synthetic */ boolean Jwt;

        s(MPVideoPlayFullScreenView mPVideoPlayFullScreenView, boolean z) {
            this.Jwh = mPVideoPlayFullScreenView;
            this.Jwt = z;
        }

        public final void run() {
            AppMethodBeat.i(82625);
            if (this.Jwt) {
                this.Jwh.JvP.setVisibility(8);
            } else {
                ProgressBar progressBar = this.Jwh.hRO;
                if (progressBar == null || progressBar.getVisibility() != 0) {
                    this.Jwh.JvP.setVisibility(0);
                }
            }
            RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = this.Jwh.FLz;
            if (redesignVideoPlayerSeekBar != null) {
                redesignVideoPlayerSeekBar.hP(this.Jwh.gVd);
                AppMethodBeat.o(82625);
                return;
            }
            AppMethodBeat.o(82625);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initSeekBar$1", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-webview_release"})
    public static final class h implements com.tencent.mm.plugin.sight.decode.ui.b {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        @Override // com.tencent.mm.plugin.sight.decode.ui.b
        public final void aJq() {
        }

        @Override // com.tencent.mm.plugin.sight.decode.ui.b
        public final void rk(int i2) {
            AppMethodBeat.i(82598);
            Log.i(this.Jwh.TAG, "initSeekBar onSeekTo ".concat(String.valueOf(i2)));
            u uVar = this.Jwh.JvR;
            if (uVar != null) {
                uVar.F((double) i2);
                AppMethodBeat.o(82598);
                return;
            }
            AppMethodBeat.o(82598);
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.i(82630);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view != null && view.getId() == R.id.gcc) {
            ghJ();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82630);
    }

    private final void ghJ() {
        AppMethodBeat.i(82631);
        if (this.gVd) {
            u uVar = this.JvR;
            if (uVar != null) {
                uVar.fDd();
                AppMethodBeat.o(82631);
                return;
            }
            AppMethodBeat.o(82631);
            return;
        }
        u uVar2 = this.JvR;
        if (uVar2 != null) {
            uVar2.hsz();
            AppMethodBeat.o(82631);
            return;
        }
        AppMethodBeat.o(82631);
    }

    public final boolean bJb() {
        AppMethodBeat.i(210557);
        if (getVisibility() == 0) {
            AppMethodBeat.o(210557);
            return true;
        }
        AppMethodBeat.o(210557);
        return false;
    }

    private final synchronized void ghK() {
        AppMethodBeat.i(210558);
        Context context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(210558);
            throw tVar;
        }
        Activity activity = (Activity) context;
        if (this.iwi == null) {
            Log.d(this.TAG, "adjustOrientation mpShareVideoInfo is null");
            AppMethodBeat.o(210558);
        } else if (this.JvX || !this.JvY) {
            Log.i(this.TAG, "adjustOrientation hasAdjustOrientation=" + this.JvX + ", hasAddVideoView=" + this.JvY);
            AppMethodBeat.o(210558);
        } else {
            this.JvX = true;
            if (this.JvV == this.JvU) {
                this.JvV = activity.getRequestedOrientation();
            }
            String str = this.TAG;
            StringBuilder sb = new StringBuilder("adjustOrientation width = ");
            y yVar = this.iwi;
            if (yVar == null) {
                kotlin.g.b.p.hyc();
            }
            StringBuilder append = sb.append(yVar.width).append(", height=");
            y yVar2 = this.iwi;
            if (yVar2 == null) {
                kotlin.g.b.p.hyc();
            }
            Log.i(str, append.append(yVar2.height).toString());
            y yVar3 = this.iwi;
            if (yVar3 == null) {
                kotlin.g.b.p.hyc();
            }
            int i2 = yVar3.width;
            y yVar4 = this.iwi;
            if (yVar4 == null) {
                kotlin.g.b.p.hyc();
            }
            if (i2 <= yVar4.height) {
                this.mCurrentOrientation = 1;
                activity.setRequestedOrientation(this.mCurrentOrientation);
                this.JvW = false;
            } else {
                this.JvW = true;
                this.mCurrentOrientation = 0;
                activity.setRequestedOrientation(this.mCurrentOrientation);
                this.Jii.enable();
            }
            ghR();
            AppMethodBeat.o(210558);
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void ghL() {
        AppMethodBeat.i(182652);
        if (this.JvV != this.JvU) {
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(182652);
                throw tVar;
            }
            ((Activity) context).setRequestedOrientation(this.JvV);
            this.JvV = this.JvU;
            this.Jii.disable();
        }
        zq(false);
        AppMethodBeat.o(182652);
    }

    private final void zq(boolean z) {
        AppMethodBeat.i(182653);
        Log.i(this.TAG, "handleFullScreenStatusBar forwardUiVisibility " + this.pNM);
        if (z) {
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(182653);
                throw tVar;
            }
            Activity activity = (Activity) context;
            Window window = activity.getWindow();
            kotlin.g.b.p.g(window, "activity.window");
            View decorView = window.getDecorView();
            if (decorView == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(182653);
                throw tVar2;
            }
            ViewGroup viewGroup = (ViewGroup) decorView;
            this.pNM = viewGroup.getSystemUiVisibility();
            viewGroup.setOnSystemUiVisibilityChangeListener(new c(this, viewGroup));
            viewGroup.setSystemUiVisibility(4102);
            activity.getWindow().addFlags(1024);
            AppMethodBeat.o(182653);
            return;
        }
        Context context2 = getContext();
        if (context2 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(182653);
            throw tVar3;
        }
        Activity activity2 = (Activity) context2;
        Window window2 = activity2.getWindow();
        kotlin.g.b.p.g(window2, "activity.window");
        View decorView2 = window2.getDecorView();
        if (decorView2 == null) {
            t tVar4 = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(182653);
            throw tVar4;
        }
        ((ViewGroup) decorView2).setSystemUiVisibility(this.pNM);
        activity2.getWindow().clearFlags(1024);
        AppMethodBeat.o(182653);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "visibility", "", "onSystemUiVisibilityChange"})
    public static final class c implements View.OnSystemUiVisibilityChangeListener {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;
        final /* synthetic */ ViewGroup Jwi;

        c(MPVideoPlayFullScreenView mPVideoPlayFullScreenView, ViewGroup viewGroup) {
            this.Jwh = mPVideoPlayFullScreenView;
            this.Jwi = viewGroup;
        }

        public final void onSystemUiVisibilityChange(int i2) {
            AppMethodBeat.i(210554);
            if ((i2 & 4) == 0 && this.Jwh.bJb()) {
                this.Jwi.setSystemUiVisibility(5894);
            }
            AppMethodBeat.o(210554);
        }
    }

    private void removeVideoView() {
        AppMethodBeat.i(82632);
        this.JvJ.removeAllViews();
        Context context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            AppMethodBeat.o(82632);
            throw tVar;
        }
        ((WebViewUI) context).setMMOrientation();
        AppMethodBeat.o(82632);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016JR\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020\rH\u0016J\u0018\u0010%\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\"\u0010&\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010'\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006("}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initVideoController$1", "Lcom/tencent/xweb/VideoJsCallback;", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "onSetRequestedOrientation", "", "orientation", "", "onVideoEmptied", "", "onVideoEnded", "onVideoEnterFullscreen", "isVideoTag", "id", "width", "", "height", "paused", "seeking", "currentTime", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "buffered", "", "onVideoError", "error", "msg", "", "onVideoExitFullscreen", "onVideoPause", "onVideoPlay", "onVideoPlaying", "onVideoSeeked", "onVideoSeeking", "onVideoSizeUpdate", "onVideoTimeUpdate", "onVideoWaiting", "plugin-webview_release"})
    public static final class i implements v {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;
        private long lastUpdateTime;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public i(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        @Override // com.tencent.xweb.v
        public final void onVideoEnded() {
            AppMethodBeat.i(82600);
            Log.i(this.Jwh.TAG, "onVideoEnded");
            MPVideoPlayFullScreenView.c(this.Jwh, false);
            MPVideoPlayFullScreenView.p(this.Jwh);
            this.Jwh.getMpShareVideoReport().a(this.Jwh.iwi, 7, this.Jwh.getEnterId());
            this.Jwh.getMpShareVideoReport().jpW = 4;
            AppMethodBeat.o(82600);
        }

        @Override // com.tencent.xweb.v
        public final void onVideoError(int i2, String str) {
            AppMethodBeat.i(82601);
            Log.e(this.Jwh.TAG, "onVideoError " + i2 + ", " + str);
            MPVideoPlayFullScreenView.c(this.Jwh, false);
            MPVideoPlayFullScreenView.p(this.Jwh);
            this.Jwh.getMpShareVideoReport().jpW = 4;
            this.Jwh.getMpShareVideoReport().pLD = str;
            this.Jwh.getMpShareVideoReport().a(this.Jwh.iwi, 11, this.Jwh.getEnterId());
            AppMethodBeat.o(82601);
        }

        @Override // com.tencent.xweb.v
        public final void bLx() {
            AppMethodBeat.i(82602);
            Log.i(this.Jwh.TAG, "onVideoEmptied");
            MPVideoPlayFullScreenView.p(this.Jwh);
            AppMethodBeat.o(82602);
        }

        @Override // com.tencent.xweb.v
        public final void onVideoPlaying() {
            AppMethodBeat.i(82603);
            Log.d(this.Jwh.TAG, "onVideoPlaying");
            if (!this.Jwh.gVd) {
                MPVideoPlayFullScreenView.c(this.Jwh, true);
                MPVideoPlayFullScreenView.p(this.Jwh);
            }
            this.Jwh.getMpShareVideoReport().jpW = 2;
            AppMethodBeat.o(82603);
        }

        @Override // com.tencent.xweb.v
        public final boolean xJ(int i2) {
            return false;
        }

        @Override // com.tencent.xweb.v
        public final void onVideoWaiting() {
            AppMethodBeat.i(82604);
            Log.i(this.Jwh.TAG, "onVideoWaiting");
            MPVideoPlayFullScreenView.q(this.Jwh);
            AppMethodBeat.o(82604);
        }

        @Override // com.tencent.xweb.v
        public final void onVideoSeeking() {
            AppMethodBeat.i(82605);
            Log.i(this.Jwh.TAG, "onVideoSeeking");
            MPVideoPlayFullScreenView.q(this.Jwh);
            AppMethodBeat.o(82605);
        }

        @Override // com.tencent.xweb.v
        public final void onVideoSeeked() {
            AppMethodBeat.i(82606);
            Log.i(this.Jwh.TAG, "onVideoSeeked");
            MPVideoPlayFullScreenView.p(this.Jwh);
            this.Jwh.getMpShareVideoReport().a(this.Jwh.iwi, 13, this.Jwh.getEnterId());
            AppMethodBeat.o(82606);
        }

        @Override // com.tencent.xweb.v
        public final void onVideoPlay() {
            AppMethodBeat.i(82607);
            Log.i(this.Jwh.TAG, "onVideoPlay");
            MPVideoPlayFullScreenView.c(this.Jwh, true);
            MPVideoPlayFullScreenView.p(this.Jwh);
            if (this.Jwh.getMpShareVideoReport().jpW != 2) {
                this.Jwh.getMpShareVideoReport().a(this.Jwh.iwi, this.Jwh.getMpShareVideoReport().getPlayType(), this.Jwh.getEnterId());
            }
            this.Jwh.getMpShareVideoReport().jpW = 2;
            AppMethodBeat.o(82607);
        }

        @Override // com.tencent.xweb.v
        public final void onVideoPause() {
            AppMethodBeat.i(82608);
            Log.i(this.Jwh.TAG, "onVideoPause");
            MPVideoPlayFullScreenView.c(this.Jwh, false);
            MPVideoPlayFullScreenView.p(this.Jwh);
            if (this.Jwh.getMpShareVideoReport().jpW != 3) {
                this.Jwh.getMpShareVideoReport().a(this.Jwh.iwi, 8, this.Jwh.getEnterId());
            }
            this.Jwh.getMpShareVideoReport().jpW = 3;
            AppMethodBeat.o(82608);
        }

        @Override // com.tencent.xweb.v
        public final void onVideoEnterFullscreen(boolean z, long j2, double d2, double d3, boolean z2, boolean z3, double d4, double d5, double[] dArr) {
            AppMethodBeat.i(82609);
            Log.i(this.Jwh.TAG, "onVideoEnterFullscreen isVideoTag:" + z + ", id:" + j2 + ", width:" + d2 + ", height:" + d3 + ", paused:" + z2 + ", seeking:" + z3 + ", currentTime:" + d4 + ", duration:" + d5 + ", buffered:" + Arrays.toString(dArr));
            this.Jwh.gVd = !z2;
            MPVideoPlayFullScreenView.c(this.Jwh, this.Jwh.gVd);
            if (this.Jwh.gVd) {
                this.Jwh.getMpShareVideoReport().jpW = 1;
                this.Jwh.getMpShareVideoReport().a(this.Jwh.iwi, this.Jwh.getMpShareVideoReport().getPlayType(), this.Jwh.getEnterId());
            }
            AppMethodBeat.o(82609);
        }

        @Override // com.tencent.xweb.v
        public final void onVideoExitFullscreen() {
            AppMethodBeat.i(82610);
            Log.i(this.Jwh.TAG, "onVideoExitFullscreen");
            AppMethodBeat.o(82610);
        }

        @Override // com.tencent.xweb.v
        public final void onVideoTimeUpdate(double d2, double d3, double[] dArr) {
            AppMethodBeat.i(82611);
            if (System.currentTimeMillis() - this.lastUpdateTime >= 500) {
                this.lastUpdateTime = System.currentTimeMillis();
                MMHandlerThread.postToMainThread(new a(this, d3, d2, dArr));
            }
            this.Jwh.JvT = d2;
            MPVideoPlayFullScreenView.p(this.Jwh);
            AppMethodBeat.o(82611);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ i Jwk;
            final /* synthetic */ double Jwl;
            final /* synthetic */ double Jwm;
            final /* synthetic */ double[] Jwn;

            a(i iVar, double d2, double d3, double[] dArr) {
                this.Jwk = iVar;
                this.Jwl = d2;
                this.Jwm = d3;
                this.Jwn = dArr;
            }

            public final void run() {
                boolean z;
                RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar;
                boolean z2 = true;
                AppMethodBeat.i(82599);
                RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar2 = this.Jwk.Jwh.FLz;
                if (redesignVideoPlayerSeekBar2 != null) {
                    redesignVideoPlayerSeekBar2.setVideoTotalTime((int) this.Jwl);
                }
                RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar3 = this.Jwk.Jwh.FLz;
                if (redesignVideoPlayerSeekBar3 != null) {
                    redesignVideoPlayerSeekBar3.xv((int) this.Jwm);
                }
                double[] dArr = this.Jwn;
                if (dArr != null) {
                    if (dArr.length == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        z2 = false;
                    }
                    if (!z2 || (redesignVideoPlayerSeekBar = this.Jwk.Jwh.FLz) == null) {
                        AppMethodBeat.o(82599);
                        return;
                    }
                    kotlin.g.b.p.h(dArr, "$this$lastIndex");
                    redesignVideoPlayerSeekBar.aiS((int) dArr[dArr.length - 1]);
                    AppMethodBeat.o(82599);
                    return;
                }
                AppMethodBeat.o(82599);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r0.height == 0) goto L_0x001e;
         */
        @Override // com.tencent.xweb.v
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onVideoSizeUpdate(double r4, double r6) {
            /*
                r3 = this;
                r2 = 82612(0x142b4, float:1.15764E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView r0 = r3.Jwh
                com.tencent.mm.ag.y r0 = com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.g(r0)
                if (r0 == 0) goto L_0x0012
                int r0 = r0.width
                if (r0 == 0) goto L_0x001e
            L_0x0012:
                com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView r0 = r3.Jwh
                com.tencent.mm.ag.y r0 = com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.g(r0)
                if (r0 == 0) goto L_0x0038
                int r0 = r0.height
                if (r0 != 0) goto L_0x003c
            L_0x001e:
                com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView r0 = r3.Jwh
                com.tencent.mm.ag.y r0 = com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.g(r0)
                if (r0 == 0) goto L_0x0029
                int r1 = (int) r4
                r0.width = r1
            L_0x0029:
                com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView r0 = r3.Jwh
                com.tencent.mm.ag.y r0 = com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.g(r0)
                if (r0 == 0) goto L_0x003c
                int r1 = (int) r6
                r0.height = r1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0037:
                return
            L_0x0038:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0037
            L_0x003c:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0037
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.i.onVideoSizeUpdate(double, double):void");
        }
    }

    public final Integer getSubScene() {
        return this.Jwb;
    }

    public final void setSubScene(Integer num) {
        this.Jwb = num;
    }

    private final int getSubScene$1385f2() {
        int i2;
        String str = null;
        AppMethodBeat.i(82633);
        Context context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(82633);
            throw tVar;
        }
        int intExtra = ((Activity) context).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
        if (intExtra == 10000) {
            Context context2 = getContext();
            if (!(context2 instanceof com.tencent.mm.plugin.webview.core.b)) {
                context2 = null;
            }
            com.tencent.mm.plugin.webview.core.b bVar = (com.tencent.mm.plugin.webview.core.b) context2;
            if (bVar != null) {
                str = bVar.coX();
            }
            try {
                i2 = Util.getInt(Uri.parse(str).getQueryParameter("scene"), 10000);
            } catch (Exception e2) {
            }
            AppMethodBeat.o(82633);
            return i2;
        }
        i2 = intExtra;
        AppMethodBeat.o(82633);
        return i2;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class r implements Runnable {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        r(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        public final void run() {
            ProgressBar progressBar;
            AppMethodBeat.i(82624);
            ProgressBar progressBar2 = this.Jwh.hRO;
            if ((progressBar2 == null || progressBar2.getVisibility() != 0) && (progressBar = this.Jwh.hRO) != null) {
                progressBar.setVisibility(0);
                AppMethodBeat.o(82624);
                return;
            }
            AppMethodBeat.o(82624);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        f(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        public final void run() {
            ProgressBar progressBar;
            AppMethodBeat.i(82596);
            ProgressBar progressBar2 = this.Jwh.hRO;
            if (!(progressBar2 == null || progressBar2.getVisibility() != 0 || (progressBar = this.Jwh.hRO) == null)) {
                progressBar.setVisibility(8);
            }
            if (!this.Jwh.gVd) {
                this.Jwh.JvP.setVisibility(0);
            }
            AppMethodBeat.o(82596);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class g implements MTimerHandler.CallBack {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        g(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(82597);
            MPVideoPlayFullScreenView.i(this.Jwh);
            AppMethodBeat.o(82597);
            return false;
        }
    }

    public final void ghM() {
        AppMethodBeat.i(82634);
        if (BuildInfo.IS_FLAVOR_RED) {
            Log.d(this.TAG, "hideOpLayer %s", Util.getStack());
        }
        if (!this.Jwe) {
            AppMethodBeat.o(82634);
            return;
        }
        this.Jwe = false;
        ghN();
        AppMethodBeat.o(82634);
    }

    private final void ghN() {
        boolean z = true;
        AppMethodBeat.i(82635);
        String str = this.TAG;
        Object[] objArr = new Object[1];
        if (this.JvI.getVisibility() != 0) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.d(str, "fadeOutOpLayout: %b", objArr);
        Animation ghO = ghO();
        ghO.setFillAfter(false);
        ghO.setAnimationListener(new b(this));
        this.JvI.clearAnimation();
        this.JvI.startAnimation(ghO);
        AppMethodBeat.o(82635);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$fadeOutOpLayout$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
    public static final class b implements Animation.AnimationListener {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
            this.Jwh = mPVideoPlayFullScreenView;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(82591);
            kotlin.g.b.p.h(animation, "animation");
            AppMethodBeat.o(82591);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(82592);
            kotlin.g.b.p.h(animation, "animation");
            if (!this.Jwh.Jwe) {
                MPVideoPlayFullScreenView.s(this.Jwh);
            }
            AppMethodBeat.o(82592);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.i(82593);
            kotlin.g.b.p.h(animation, "animation");
            AppMethodBeat.o(82593);
        }
    }

    private static Animation ghO() {
        AppMethodBeat.i(82636);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateInterpolator(10.0f));
        AlphaAnimation alphaAnimation2 = alphaAnimation;
        AppMethodBeat.o(82636);
        return alphaAnimation2;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(82637);
        kotlin.g.b.p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            Log.d(this.TAG, "%d image gallery ui is vertical screen", Integer.valueOf(hashCode()));
            ghP();
            AppMethodBeat.o(82637);
        } else if (configuration.orientation == 2) {
            Log.d(this.TAG, "%d image gallery ui is horizontal screen", Integer.valueOf(hashCode()));
            ghQ();
            AppMethodBeat.o(82637);
        } else {
            AppMethodBeat.o(82637);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleVerticalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;
        final /* synthetic */ View Jwj;

        e(MPVideoPlayFullScreenView mPVideoPlayFullScreenView, View view) {
            this.Jwh = mPVideoPlayFullScreenView;
            this.Jwj = view;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(82595);
            this.Jwj.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            MPVideoPlayFullScreenView.t(this.Jwh);
            AppMethodBeat.o(82595);
        }
    }

    private final void ghP() {
        AppMethodBeat.i(82638);
        Context context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(82638);
            throw tVar;
        }
        Window window = ((Activity) context).getWindow();
        kotlin.g.b.p.g(window, "(context as Activity).window");
        View decorView = window.getDecorView();
        kotlin.g.b.p.g(decorView, "(context as Activity).window.decorView");
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new e(this, decorView));
        AppMethodBeat.o(82638);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleHorizontalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ MPVideoPlayFullScreenView Jwh;
        final /* synthetic */ View Jwj;

        d(MPVideoPlayFullScreenView mPVideoPlayFullScreenView, View view) {
            this.Jwh = mPVideoPlayFullScreenView;
            this.Jwj = view;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(82594);
            this.Jwj.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (com.tencent.mm.compatible.util.d.oD(24)) {
                Context context = this.Jwh.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(82594);
                    throw tVar;
                } else if (((Activity) context).isInMultiWindowMode()) {
                    MPVideoPlayFullScreenView.t(this.Jwh);
                    AppMethodBeat.o(82594);
                    return;
                }
            }
            int aD = au.aD(this.Jwh.getContext());
            int aH = com.tencent.mm.cb.a.aH(this.Jwh.getContext(), R.dimen.ct);
            int i2 = aH * 3;
            int i3 = aH * 4;
            int i4 = aH * 7;
            int max = Math.max(aD - (aH * 3), 0);
            this.Jwh.JvL.setPadding(max, aH * 2, max - aH, aH * 2);
            View view = this.Jwh.JvS;
            if (view != null) {
                view.setPadding(0, 0, 0, 0);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(82594);
                    throw tVar2;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.height = com.tencent.mm.cb.a.aG(this.Jwh.getContext(), R.dimen.bz);
                view.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.Jwh.pvJ.getLayoutParams();
            if (layoutParams3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(82594);
                throw tVar3;
            }
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.removeRule(3);
            layoutParams4.setMargins(i3, i2, 0, i2);
            layoutParams4.addRule(15);
            this.Jwh.pvJ.setLayoutParams(layoutParams4);
            ViewGroup.LayoutParams layoutParams5 = this.Jwh.JvO.getLayoutParams();
            if (layoutParams5 == null) {
                t tVar4 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(82594);
                throw tVar4;
            }
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
            layoutParams6.removeRule(3);
            layoutParams6.setMargins(0, i2, i3, i2);
            layoutParams6.addRule(15);
            this.Jwh.JvO.setLayoutParams(layoutParams6);
            ViewGroup.LayoutParams layoutParams7 = this.Jwh.JvQ.getLayoutParams();
            if (layoutParams7 == null) {
                t tVar5 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(82594);
                throw tVar5;
            }
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
            layoutParams8.removeRule(3);
            layoutParams8.setMargins(0, i2, i3, i2);
            layoutParams8.addRule(15);
            this.Jwh.JvQ.setLayoutParams(layoutParams8);
            RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = this.Jwh.FLz;
            if (redesignVideoPlayerSeekBar == null) {
                kotlin.g.b.p.hyc();
            }
            ViewGroup.LayoutParams layoutParams9 = redesignVideoPlayerSeekBar.getLayoutParams();
            if (layoutParams9 == null) {
                t tVar6 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(82594);
                throw tVar6;
            }
            RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
            layoutParams10.addRule(1, R.id.j5u);
            layoutParams10.addRule(0, R.id.j5z);
            layoutParams10.addRule(15);
            layoutParams10.setMargins(i4, i2, i4, i2);
            RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar2 = this.Jwh.FLz;
            if (redesignVideoPlayerSeekBar2 != null) {
                redesignVideoPlayerSeekBar2.setLayoutParams(layoutParams10);
                AppMethodBeat.o(82594);
                return;
            }
            AppMethodBeat.o(82594);
        }
    }

    private final void ghQ() {
        AppMethodBeat.i(82639);
        Context context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(82639);
            throw tVar;
        }
        Window window = ((Activity) context).getWindow();
        kotlin.g.b.p.g(window, "(context as Activity).window");
        View decorView = window.getDecorView();
        kotlin.g.b.p.g(decorView, "(context as Activity).window.decorView");
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, decorView));
        AppMethodBeat.o(82639);
    }

    private final void ghR() {
        AppMethodBeat.i(182654);
        if (this.mCurrentOrientation == 0 || this.mCurrentOrientation == 8) {
            ghQ();
            AppMethodBeat.o(182654);
            return;
        }
        ghP();
        AppMethodBeat.o(182654);
    }

    public final synchronized void gg(View view) {
        AppMethodBeat.i(210556);
        kotlin.g.b.p.h(view, "view");
        if (this.iwi != null) {
            y yVar = this.iwi;
            if (yVar == null) {
                kotlin.g.b.p.hyc();
            }
            yVar.iAP = this.pHu;
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                AppMethodBeat.o(210556);
                throw tVar;
            }
            WebViewUI webViewUI = (WebViewUI) context;
            if (webViewUI.mHh != null) {
                try {
                    h hVar = this.JvZ;
                    com.tencent.mm.plugin.webview.stub.e eVar = webViewUI.mHh;
                    y yVar2 = this.iwi;
                    if (yVar2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    hVar.pLE = eVar.IS(yVar2.dHc);
                    this.JvZ.scene = 141;
                    this.JvZ.pHw = getSubScene$1385f2();
                } catch (Exception e2) {
                }
            }
            this.pLN = System.currentTimeMillis();
            this.pHu = (int) (this.pLN / 1000);
            this.JvZ.a(this.iwi, 1, this.pHu);
            this.JvZ.a(this.iwi, 5, this.pHu);
            this.JvZ.jpW = 0;
        }
        removeVideoView();
        zq(true);
        this.JvH.setAlpha(1.0f);
        this.JvH.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        setVisibility(0);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -2));
        this.JvK = frameLayout;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        this.JvJ.addView(this.JvK, layoutParams);
        ghH();
        this.FLK = false;
        Log.d(this.TAG, "addVideoView");
        this.JvY = true;
        ghK();
        AppMethodBeat.o(210556);
    }

    public static final /* synthetic */ void d(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
        AppMethodBeat.i(82643);
        com.tencent.mm.ui.tools.e eVar = mPVideoPlayFullScreenView.qaE;
        if (eVar != null) {
            View view = mPVideoPlayFullScreenView.JvN;
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            View view2 = mPVideoPlayFullScreenView.JvH;
            ViewGroup viewGroup = mPVideoPlayFullScreenView.JvK;
            if (viewGroup == null) {
                kotlin.g.b.p.hyc();
            }
            eVar.b(view, view2, viewGroup);
        }
        com.tencent.mm.ui.tools.e eVar2 = mPVideoPlayFullScreenView.qaE;
        if (eVar2 != null) {
            eVar2.a(new k(mPVideoPlayFullScreenView));
        }
        com.tencent.mm.ui.tools.e eVar3 = mPVideoPlayFullScreenView.qaE;
        if (eVar3 != null) {
            eVar3.a(new l(mPVideoPlayFullScreenView));
        }
        com.tencent.mm.ui.tools.e eVar4 = mPVideoPlayFullScreenView.qaE;
        if (eVar4 != null) {
            eVar4.a(new m(mPVideoPlayFullScreenView));
        }
        com.tencent.mm.ui.tools.e eVar5 = mPVideoPlayFullScreenView.qaE;
        if (eVar5 != null) {
            eVar5.a(new n(mPVideoPlayFullScreenView));
        }
        View view3 = mPVideoPlayFullScreenView.JvN;
        if (view3 != null) {
            view3.setOnClickListener(o.Jwo);
            AppMethodBeat.o(82643);
            return;
        }
        AppMethodBeat.o(82643);
    }

    public static final /* synthetic */ void f(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
        AppMethodBeat.i(82644);
        if (BuildInfo.IS_FLAVOR_RED) {
            Log.d(mPVideoPlayFullScreenView.TAG, "showToolBar %s", Util.getStack());
        }
        if (!mPVideoPlayFullScreenView.Jwe) {
            mPVideoPlayFullScreenView.Jwe = true;
            String str = mPVideoPlayFullScreenView.TAG;
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(mPVideoPlayFullScreenView.JvI.getVisibility() == 0);
            Log.d(str, "fadeInOpLayout: %b", objArr);
            mPVideoPlayFullScreenView.JvI.clearAnimation();
            View view = mPVideoPlayFullScreenView.JvI;
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(150);
            alphaAnimation.setFillAfter(true);
            view.startAnimation(alphaAnimation);
            Log.d(mPVideoPlayFullScreenView.TAG, "start timer");
            if (!mPVideoPlayFullScreenView.Jwc.stopped()) {
                Log.d(mPVideoPlayFullScreenView.TAG, "stop timer");
                mPVideoPlayFullScreenView.Jwc.stopTimer();
            }
            mPVideoPlayFullScreenView.Jwc.startTimer(mPVideoPlayFullScreenView.Jwd);
            mPVideoPlayFullScreenView.JvM.setVisibility(0);
            View view2 = mPVideoPlayFullScreenView.JvL;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            View view3 = mPVideoPlayFullScreenView.JvI;
            if (view3 != null) {
                view3.setVisibility(0);
                AppMethodBeat.o(82644);
                return;
            }
        }
        AppMethodBeat.o(82644);
    }

    public static final /* synthetic */ void c(MPVideoPlayFullScreenView mPVideoPlayFullScreenView, boolean z) {
        AppMethodBeat.i(82646);
        mPVideoPlayFullScreenView.gVd = z;
        MMHandlerThread.postToMainThread(new s(mPVideoPlayFullScreenView, z));
        AppMethodBeat.o(82646);
    }

    public static final /* synthetic */ void p(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
        AppMethodBeat.i(82647);
        MMHandlerThread.postToMainThread(new f(mPVideoPlayFullScreenView));
        AppMethodBeat.o(82647);
    }

    public static final /* synthetic */ void q(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
        AppMethodBeat.i(82648);
        MMHandlerThread.postToMainThread(new r(mPVideoPlayFullScreenView));
        AppMethodBeat.o(82648);
    }

    public static final /* synthetic */ void s(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
        AppMethodBeat.i(82649);
        mPVideoPlayFullScreenView.JvM.setVisibility(8);
        View view = mPVideoPlayFullScreenView.JvL;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = mPVideoPlayFullScreenView.JvI;
        if (view2 != null) {
            view2.setVisibility(8);
            AppMethodBeat.o(82649);
            return;
        }
        AppMethodBeat.o(82649);
    }

    public static final /* synthetic */ void t(MPVideoPlayFullScreenView mPVideoPlayFullScreenView) {
        AppMethodBeat.i(162323);
        int aD = au.aD(mPVideoPlayFullScreenView.getContext());
        int aH = com.tencent.mm.cb.a.aH(mPVideoPlayFullScreenView.getContext(), R.dimen.ct);
        int i2 = (int) (2.5d * ((double) aH));
        int i3 = (int) (1.5d * ((double) aH));
        int i4 = aH * 3;
        mPVideoPlayFullScreenView.JvL.setPadding(0, aH * 2, 0, (aH * 2) + aD);
        View view = mPVideoPlayFullScreenView.JvS;
        if (view != null) {
            view.setPadding(0, 0, 0, aD);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(162323);
                throw tVar;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.height = com.tencent.mm.cb.a.aG(mPVideoPlayFullScreenView.getContext(), R.dimen.c4);
            view.setLayoutParams(layoutParams2);
        }
        RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = mPVideoPlayFullScreenView.FLz;
        if (redesignVideoPlayerSeekBar == null) {
            kotlin.g.b.p.hyc();
        }
        ViewGroup.LayoutParams layoutParams3 = redesignVideoPlayerSeekBar.getLayoutParams();
        if (layoutParams3 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(162323);
            throw tVar2;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.removeRule(1);
        layoutParams4.removeRule(0);
        layoutParams4.removeRule(15);
        layoutParams4.setMargins(i2, i4, i3, 0);
        RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar2 = mPVideoPlayFullScreenView.FLz;
        if (redesignVideoPlayerSeekBar2 != null) {
            redesignVideoPlayerSeekBar2.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = mPVideoPlayFullScreenView.pvJ.getLayoutParams();
        if (layoutParams5 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(162323);
            throw tVar3;
        }
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
        layoutParams6.addRule(3, R.id.j5y);
        layoutParams6.setMargins(i2, i4, 0, 0);
        layoutParams6.removeRule(15);
        mPVideoPlayFullScreenView.pvJ.setLayoutParams(layoutParams6);
        ViewGroup.LayoutParams layoutParams7 = mPVideoPlayFullScreenView.JvO.getLayoutParams();
        if (layoutParams7 == null) {
            t tVar4 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(162323);
            throw tVar4;
        }
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
        layoutParams8.addRule(3, R.id.j5y);
        layoutParams8.setMargins(0, i4, i3, 0);
        layoutParams8.removeRule(15);
        mPVideoPlayFullScreenView.JvO.setLayoutParams(layoutParams8);
        ViewGroup.LayoutParams layoutParams9 = mPVideoPlayFullScreenView.JvQ.getLayoutParams();
        if (layoutParams9 == null) {
            t tVar5 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(162323);
            throw tVar5;
        }
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
        layoutParams10.addRule(3, R.id.j5y);
        layoutParams10.setMargins(0, i4, i3, 0);
        layoutParams10.removeRule(15);
        mPVideoPlayFullScreenView.JvQ.setLayoutParams(layoutParams10);
        AppMethodBeat.o(162323);
    }
}
