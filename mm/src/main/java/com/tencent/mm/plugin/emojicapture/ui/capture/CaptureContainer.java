package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hilive.mediasdk.SdkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.p.ac;
import com.tencent.mm.plugin.appbrand.jsapi.p.ah;
import com.tencent.mm.plugin.appbrand.jsapi.p.ao;
import com.tencent.mm.plugin.appbrand.jsapi.p.ap;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.b.a;
import com.tencent.mm.plugin.emojicapture.c.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureGLTextureView;
import com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u000206H\u0016J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020\u0014H\u0016J\b\u0010F\u001a\u00020GH\u0016J\n\u0010H\u001a\u0004\u0018\u00010IH\u0016J\n\u0010J\u001a\u0004\u0018\u00010IH\u0016J\b\u0010K\u001a\u00020\u000bH\u0016J\n\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020\u000bH\u0016J\b\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020<H\u0016J\b\u0010R\u001a\u000206H\u0016J\u0012\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010TH\u0016J\b\u0010V\u001a\u00020<H\u0016J\b\u0010W\u001a\u00020<H\u0016J\b\u0010X\u001a\u00020<H\u0016J\u0010\u0010Y\u001a\u00020<2\u0006\u0010Z\u001a\u000206H\u0002J\u0010\u0010[\u001a\u00020<2\u0006\u0010\\\u001a\u00020\u000bH\u0016J2\u0010]\u001a\u00020<2\b\u0010^\u001a\u0004\u0018\u00010_2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u00105\u001a\u0002062\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u000eJ\b\u0010b\u001a\u00020<H\u0016J-\u0010c\u001a\u0002062#\u0010d\u001a\u001f\u0012\u0013\u0012\u00110A¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020<\u0018\u00010eH\u0016J\b\u0010i\u001a\u000206H\u0016J\u0010\u0010j\u001a\u00020<2\u0006\u0010k\u001a\u000206H\u0016J\u0018\u0010l\u001a\u00020<2\u0006\u0010k\u001a\u0002062\u0006\u0010m\u001a\u00020\u000bH\u0002J\u0010\u0010n\u001a\u00020<2\u0006\u0010k\u001a\u000206H\u0016J\b\u0010o\u001a\u000206H\u0016J\b\u0010p\u001a\u000206H\u0016R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "stickerDesigner", "stickerEnable", "", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "voiceDetectView", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "initCameraConfig", "isMute", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "lensId", "talkerName", JsApiStartRecordVoice.NAME, JsApiStopRecordVoice.NAME, "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"})
public final class CaptureContainer extends RelativeLayout implements com.tencent.mm.media.widget.camerarecordview.d.a, a.b {
    public final String TAG;
    public EmojiCaptureReporter rqJ;
    public boolean rrV;
    private final ViewGroup rsN;
    private EmojiCaptureGLTextureView rsO;
    private final MMSightRecordButton rsP;
    private final View rsQ;
    private final View rsR;
    public final EditorStickerView rsS;
    private final View rsT;
    public final CaptureDecoration rsU;
    private final CameraFrontSightView rsV;
    private final MMSightCaptureTouchView rsW;
    private final TextView rsX;
    private final TextView rsY;
    a.AbstractC0967a rsZ;
    private com.tencent.mm.plugin.emojicapture.ui.b.e rsj;
    private chz rta;
    private final Runnable rtb;
    public com.tencent.mm.media.widget.camerarecordview.a rtc;
    public boolean rtd;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ CaptureContainer rte;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(CaptureContainer captureContainer) {
            super(1);
            this.rte = captureContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX);
            boolean booleanValue = bool.booleanValue();
            CaptureContainer captureContainer = this.rte;
            com.tencent.mm.media.widget.camerarecordview.a unused = this.rte.rtc;
            captureContainer.lJ(com.tencent.mm.media.widget.camerarecordview.a.aQg());
            this.rte.rsS.cJM();
            if (!booleanValue) {
                EmojiCaptureReporter.Gi(9);
                com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.roB;
                com.tencent.mm.plugin.emojicapture.model.e.aNm();
                if (!this.rte.aQw()) {
                    com.tencent.mm.plugin.emojicapture.model.e eVar2 = com.tencent.mm.plugin.emojicapture.model.e.roB;
                    com.tencent.mm.plugin.emojicapture.model.e.cIR();
                } else {
                    com.tencent.mm.plugin.emojicapture.model.e eVar3 = com.tencent.mm.plugin.emojicapture.model.e.roB;
                    com.tencent.mm.plugin.emojicapture.model.e.cIS();
                }
            }
            if (this.rte.aQw()) {
                com.tencent.mm.plugin.emojicapture.model.e eVar4 = com.tencent.mm.plugin.emojicapture.model.e.roB;
                com.tencent.mm.plugin.emojicapture.model.e.cIQ();
            } else {
                com.tencent.mm.plugin.emojicapture.model.e eVar5 = com.tencent.mm.plugin.emojicapture.model.e.roB;
                com.tencent.mm.plugin.emojicapture.model.e.cIP();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(CaptureContainer captureContainer, boolean z, int i2) {
        AppMethodBeat.i(SdkInfo.ErrCode.kErrCodeFormatUnSupport);
        captureContainer.F(z, i2);
        AppMethodBeat.o(SdkInfo.ErrCode.kErrCodeFormatUnSupport);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQy() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CaptureContainer(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(606);
        this.TAG = "MicroMsg.CaptureContainer";
        this.rsj = new com.tencent.mm.plugin.emojicapture.ui.b.e();
        this.rtb = new c(this);
        View.inflate(context, R.layout.a1b, this);
        View findViewById = findViewById(R.id.bz_);
        p.g(findViewById, "findViewById(R.id.emoji_capture_preview_layout)");
        this.rsN = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.byy);
        p.g(findViewById2, "findViewById(R.id.emoji_capture_button)");
        this.rsP = (MMSightRecordButton) findViewById2;
        View findViewById3 = findViewById(R.id.aj8);
        p.g(findViewById3, "findViewById(R.id.capture_close)");
        this.rsQ = findViewById3;
        View findViewById4 = findViewById(R.id.ajc);
        p.g(findViewById4, "findViewById(R.id.capture_flip_camera)");
        this.rsR = findViewById4;
        View findViewById5 = findViewById(R.id.j9q);
        p.g(findViewById5, "findViewById(R.id.voice_detect_hint)");
        this.rsT = findViewById5;
        View findViewById6 = findViewById(R.id.aj_);
        p.g(findViewById6, "findViewById(R.id.capture_decoration)");
        this.rsU = (CaptureDecoration) findViewById6;
        View findViewById7 = findViewById(R.id.ajd);
        p.g(findViewById7, "findViewById(R.id.capture_focus_frame)");
        this.rsV = (CameraFrontSightView) findViewById7;
        View findViewById8 = findViewById(R.id.ajg);
        p.g(findViewById8, "findViewById(R.id.capture_touch_view)");
        this.rsW = (MMSightCaptureTouchView) findViewById8;
        View findViewById9 = findViewById(R.id.bz7);
        p.g(findViewById9, "findViewById(R.id.emoji_capture_hint)");
        this.rsX = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.bzb);
        p.g(findViewById10, "findViewById(R.id.emoji_capture_sticker_designer)");
        this.rsY = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.bzh);
        p.g(findViewById11, "findViewById(R.id.emoji_capture_sticker_panel)");
        this.rsS = (EditorStickerView) findViewById11;
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 120);
        this.rsV.hd(fromDPToPix, fromDPToPix);
        this.rsO = new EmojiCaptureGLTextureView(context);
        this.rtc = new com.tencent.mm.media.widget.camerarecordview.a(this);
        this.rtc.zU(600);
        this.rsN.addView(this.rsO);
        this.rsO.setOpaque(false);
        this.rsP.setHighLightOuter(getResources().getColor(R.color.mq));
        this.rsP.setInnerColor(getResources().getColor(R.color.f3048f));
        this.rsP.setLongPressCallback(new MMSightRecordButton.b(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.AnonymousClass1 */
            final /* synthetic */ CaptureContainer rte;

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$1$b */
            static final class b extends q implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, x> {
                final /* synthetic */ AnonymousClass1 rtf;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                b(AnonymousClass1 r2) {
                    super(1);
                    this.rtf = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
                    AppMethodBeat.i(567);
                    com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = bVar;
                    p.h(bVar2, LocaleUtil.ITALIAN);
                    CaptureContainer.a(this.rtf.rte, bVar2);
                    x xVar = x.SXb;
                    AppMethodBeat.o(567);
                    return xVar;
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.rte = r1;
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b
            public final void cJI() {
                AppMethodBeat.i(568);
                Log.i(this.rte.TAG, "onLongPressFinish");
                CaptureContainer.a(this.rte, this.rte.p(new b(this)));
                AppMethodBeat.o(568);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-emojicapture_release"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$1$a */
            public static final class a implements MMSightCircularProgressBar.a {
                final /* synthetic */ AnonymousClass1 rtf;

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
                /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$1$a$a  reason: collision with other inner class name */
                static final class C0984a extends q implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, x> {
                    final /* synthetic */ a rtg;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    C0984a(a aVar) {
                        super(1);
                        this.rtg = aVar;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
                        AppMethodBeat.i(256439);
                        com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = bVar;
                        p.h(bVar2, LocaleUtil.ITALIAN);
                        CaptureContainer.a(this.rtg.rtf.rte, bVar2);
                        x xVar = x.SXb;
                        AppMethodBeat.o(256439);
                        return xVar;
                    }
                }

                /* JADX WARN: Incorrect args count in method signature: ()V */
                a(AnonymousClass1 r1) {
                    this.rtf = r1;
                }

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a
                public final void Z(ArrayList<Float> arrayList) {
                }

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a
                public final void lK(boolean z) {
                    AppMethodBeat.i(256440);
                    Log.i(this.rtf.rte.TAG, e.a.NAME);
                    CaptureContainer.a(this.rtf.rte, this.rtf.rte.p(new C0984a(this)));
                    AppMethodBeat.o(256440);
                }
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b
            public final void jK() {
                AppMethodBeat.i(569);
                MMSightRecordButton mMSightRecordButton = this.rte.rsP;
                d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
                mMSightRecordButton.a(com.tencent.mm.plugin.emojicapture.model.d.rou * 1000, com.tencent.mm.plugin.emojicapture.ui.c.dH(this.rte), new a(this));
                CaptureContainer captureContainer = this.rte;
                captureContainer.rsS.setShow(false);
                a.AbstractC0967a aVar2 = captureContainer.rsZ;
                if (aVar2 != null) {
                    aVar2.bFT();
                }
                if (!com.tencent.mm.media.widget.camerarecordview.a.a(captureContainer.rtc)) {
                    EmojiCaptureReporter.Gi(33);
                }
                this.rte.rsQ.setEnabled(false);
                this.rte.rsQ.animate().alpha(0.0f).start();
                CaptureContainer.a(this.rte, false, 0);
                this.rte.rsR.setVisibility(8);
                AppMethodBeat.o(569);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b
            public final void cJJ() {
                AppMethodBeat.i(570);
                Log.i(this.rte.TAG, "onPressDown");
                int[] iArr = new int[2];
                this.rte.rsP.getLocationOnScreen(iArr);
                this.rte.rtc.rz(iArr[1]);
                AppMethodBeat.o(570);
            }
        });
        this.rsP.setSimpleTapCallback(new MMSightRecordButton.d(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.AnonymousClass3 */
            final /* synthetic */ CaptureContainer rte;

            {
                this.rte = r1;
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d
            public final void cJK() {
                AppMethodBeat.i(572);
                Log.i(this.rte.TAG, "simpleTapCallback");
                CaptureContainer.a(this.rte, false);
                AppMethodBeat.o(572);
            }
        });
        this.rsP.setLongPressScrollCallback(new MMSightRecordButton.c(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.AnonymousClass4 */
            final /* synthetic */ CaptureContainer rte;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.rte = r1;
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c
            public final void Gt(int i2) {
                AppMethodBeat.i(573);
                this.rte.rtc.i(true, i2);
                AppMethodBeat.o(573);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c
            public final void Gu(int i2) {
                AppMethodBeat.i(574);
                this.rte.rtc.i(false, i2);
                AppMethodBeat.o(574);
            }
        });
        this.rsW.setTouchCallback(new MMSightCaptureTouchView.a(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.AnonymousClass5 */
            final /* synthetic */ CaptureContainer rte;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.rte = r1;
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void I(float f2, float f3) {
                AppMethodBeat.i(575);
                this.rte.rtc.b(f2, f3, this.rte.rsO.getWidth(), this.rte.rsO.getHeight());
                this.rte.rsV.aa(f2, f3);
                AppMethodBeat.o(575);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void cJL() {
                AppMethodBeat.i(576);
                this.rte.rtc.aPq();
                this.rte.aPb();
                AppMethodBeat.o(576);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void bqQ() {
                AppMethodBeat.i(ah.CTRL_INDEX);
                this.rte.rtc.i(true, 1);
                AppMethodBeat.o(ah.CTRL_INDEX);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void bqR() {
                AppMethodBeat.i(578);
                this.rte.rtc.i(false, 1);
                AppMethodBeat.o(578);
            }
        });
        this.rsQ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.AnonymousClass6 */
            final /* synthetic */ CaptureContainer rte;

            {
                this.rte = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(ao.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.AbstractC0967a presenter = this.rte.getPresenter();
                if (presenter != null) {
                    presenter.exit();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(ao.CTRL_INDEX);
            }
        });
        this.rsR.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.AnonymousClass7 */
            final /* synthetic */ CaptureContainer rte;

            {
                this.rte = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(580);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.rte.aPb();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(580);
            }
        });
        this.rsY.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.AnonymousClass8 */
            final /* synthetic */ CaptureContainer rte;

            {
                this.rte = r1;
            }

            public final void onClick(View view) {
                PersonalDesigner personalDesigner;
                AppMethodBeat.i(581);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                chz chz = this.rte.rta;
                if (!(chz == null || (personalDesigner = chz.LVe) == null)) {
                    Class<?> cls = Class.forName("com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI");
                    p.g(cls, "Class.forName(\"com.tence….EmojiStoreV2DesignerUI\")");
                    Intent intent = new Intent(context, cls);
                    intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, personalDesigner.DesignerUin);
                    intent.putExtra("name", personalDesigner.Name);
                    intent.putExtra("headurl", personalDesigner.HeadUrl);
                    Context context = context;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(581);
            }
        });
        this.rsS.setSelectionCallback(new m<com.tencent.mm.sticker.f, chz, x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.AnonymousClass9 */
            final /* synthetic */ CaptureContainer rte;

            {
                this.rte = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(com.tencent.mm.sticker.f fVar, chz chz) {
                PersonalDesigner personalDesigner;
                AppMethodBeat.i(ac.CTRL_INDEX);
                com.tencent.mm.sticker.f fVar2 = fVar;
                chz chz2 = chz;
                a.AbstractC0967a presenter = this.rte.getPresenter();
                if (presenter != null) {
                    presenter.a(fVar2);
                }
                String str = (chz2 == null || (personalDesigner = chz2.LVe) == null) ? null : personalDesigner.Name;
                if (str == null || Util.isNullOrNil(str)) {
                    this.rte.rsY.setText((CharSequence) null);
                } else {
                    String string = context.getString(R.string.brn);
                    p.g(string, "context.getString(R.stri…re_sticker_designer_from)");
                    SpannableString spannableString = new SpannableString(string + str);
                    spannableString.setSpan(new ForegroundColorSpan(this.rte.getResources().getColor(R.color.x0)), string.length(), spannableString.length(), 33);
                    this.rte.rsY.setText(spannableString);
                }
                this.rte.rta = chz2;
                x xVar = x.SXb;
                AppMethodBeat.o(ac.CTRL_INDEX);
                return xVar;
            }
        });
        this.rsS.setVisibility(8);
        this.rsX.setAlpha(0.0f);
        post(new Runnable(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.AnonymousClass10 */
            final /* synthetic */ CaptureContainer rte;

            {
                this.rte = r1;
            }

            public final void run() {
                AppMethodBeat.i(583);
                CaptureContainer.a(this.rte, true, R.string.an3);
                AppMethodBeat.o(583);
            }
        });
        if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED) {
            this.rsQ.setOnLongClickListener(new View.OnLongClickListener(this) {
                /* class com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.AnonymousClass2 */
                final /* synthetic */ CaptureContainer rte;

                {
                    this.rte = r1;
                }

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(571);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    android.support.design.widget.a aVar = new android.support.design.widget.a(context);
                    Window window = aVar.getWindow();
                    if (window != null) {
                        window.clearFlags(2);
                    }
                    XLabEffectSettingView xLabEffectSettingView = new XLabEffectSettingView(context);
                    xLabEffectSettingView.setCameraView(this.rte.rsO);
                    aVar.setContentView(xLabEffectSettingView);
                    aVar.show();
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(571);
                    return true;
                }
            });
        }
        AppMethodBeat.o(606);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CaptureContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(607);
        AppMethodBeat.o(607);
    }

    public final a.AbstractC0967a getPresenter() {
        return this.rsZ;
    }

    public final void setPresenter(a.AbstractC0967a aVar) {
        this.rsZ = aVar;
    }

    public final EmojiCaptureReporter getReporter() {
        return this.rqJ;
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        this.rqJ = emojiCaptureReporter;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ CaptureContainer rte;

        c(CaptureContainer captureContainer) {
            this.rte = captureContainer;
        }

        public final void run() {
            AppMethodBeat.i(587);
            CaptureContainer.a(this.rte, false, 0);
            AppMethodBeat.o(587);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.a.b
    public final void a(com.tencent.mm.sticker.f fVar) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.CTRL_INDEX);
        this.rsU.setStickerInfo(fVar);
        this.rsO.j(new a(this, fVar));
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.CTRL_INDEX);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.a.b
    public final CaptureDecoration getDecoration() {
        return this.rsU;
    }

    public final void lJ(boolean z) {
        AppMethodBeat.i(256442);
        com.tencent.mm.ac.d.h(new h(this, z));
        AppMethodBeat.o(256442);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.a.b
    public final void lD(boolean z) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.fakenative.b.CTRL_INDEX);
        if (z) {
            this.rsT.setVisibility(0);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.fakenative.b.CTRL_INDEX);
            return;
        }
        this.rsT.setVisibility(8);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.fakenative.b.CTRL_INDEX);
    }

    private final void F(boolean z, int i2) {
        AppMethodBeat.i(594);
        if (z) {
            if (((float) this.rsX.getTop()) < getResources().getDimension(R.dimen.a1x) + getResources().getDimension(R.dimen.ag4) + getResources().getDimension(R.dimen.a1y) + getResources().getDimension(R.dimen.a1z) + ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 30))) {
                this.rsX.setBackgroundResource(R.drawable.emoji_capture_hint_bg);
            }
            removeCallbacks(this.rtb);
            this.rsX.animate().cancel();
            this.rsX.animate().alpha(1.0f).start();
            this.rsX.setText(i2);
            postDelayed(this.rtb, 2000);
            AppMethodBeat.o(594);
            return;
        }
        this.rsX.animate().cancel();
        this.rsX.animate().alpha(0.0f).start();
        AppMethodBeat.o(594);
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(595);
        Log.i(this.TAG, "setVisibility:".concat(String.valueOf(i2)));
        super.setVisibility(i2);
        this.rsQ.setVisibility(i2);
        if (i2 == 0) {
            this.rsP.setTouchEnable(true);
            this.rsS.cJM();
        }
        if (i2 == 8) {
            this.rsO.setTextureChangeCallback(null);
            this.rsN.removeView(this.rsO);
            this.rsO = new EmojiCaptureGLTextureView(getContext());
            this.rsN.addView(this.rsO);
            this.rsj = new com.tencent.mm.plugin.emojicapture.ui.b.e();
            this.rsO.a(this.rsj, aQw());
            this.rsO.setOpaque(false);
        }
        this.rsO.setVisibility(i2);
        AppMethodBeat.o(595);
    }

    public final void onResume() {
        AppMethodBeat.i(596);
        Log.i(this.TAG, "resumeCapture");
        lD(false);
        if (this.rrV) {
            this.rsS.setShow(true);
        }
        getDecoration().resume();
        this.rsO.j(new d(this));
        com.tencent.mm.media.widget.camerarecordview.a.a(this.rtc, this.rtd, new e(this), 2);
        AppMethodBeat.o(596);
    }

    public final boolean p(kotlin.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, x> bVar) {
        AppMethodBeat.i(597);
        this.rsO.j(new g(this));
        boolean p = this.rtc.p(bVar);
        AppMethodBeat.o(597);
        return p;
    }

    public final boolean aPb() {
        AppMethodBeat.i(598);
        this.rtd = com.tencent.mm.media.widget.camerarecordview.a.b(this.rtc);
        EmojiCaptureReporter emojiCaptureReporter = this.rqJ;
        long j2 = emojiCaptureReporter != null ? emojiCaptureReporter.hdz : 0;
        EmojiCaptureReporter emojiCaptureReporter2 = this.rqJ;
        EmojiCaptureReporter.a(5, j2, 0, 0, 0, 0, 0, 0, emojiCaptureReporter2 != null ? emojiCaptureReporter2.scene : 0);
        boolean z = this.rtd;
        AppMethodBeat.o(598);
        return z;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQw() {
        AppMethodBeat.i(599);
        boolean z = ((a.C0966a) com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).ilO;
        AppMethodBeat.o(599);
        return z;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public final int getResolutionLimit() {
        AppMethodBeat.i(600);
        int i2 = ((a.C0966a) com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).hzj;
        AppMethodBeat.o(600);
        return i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
    public static final class b implements com.tencent.mm.media.widget.camerarecordview.b.a {
        b() {
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final int aQm() {
            return 2;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final String getFilePath() {
            AppMethodBeat.i(com.tencent.luggage.game.d.a.CTRL_INDEX);
            d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
            String cIK = d.a.cIK();
            AppMethodBeat.o(com.tencent.luggage.game.d.a.CTRL_INDEX);
            return cIK;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final String aQn() {
            AppMethodBeat.i(586);
            d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
            String cIL = d.a.cIL();
            AppMethodBeat.o(586);
            return cIL;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig() {
        AppMethodBeat.i(601);
        b bVar = new b();
        AppMethodBeat.o(601);
        return bVar;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean Zx() {
        return true;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final VideoTransPara getVideoTransPara() {
        AppMethodBeat.i(602);
        VideoTransPara videoTransPara = k.zuy.irT;
        if (videoTransPara != null) {
            AppMethodBeat.o(602);
            return videoTransPara;
        }
        VideoTransPara videoTransPara2 = new VideoTransPara();
        AppMethodBeat.o(602);
        return videoTransPara2;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView() {
        return this.rsO;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.j.a getRecordRenderer() {
        AppMethodBeat.i(603);
        com.tencent.mm.plugin.emojicapture.ui.b.g gVar = new com.tencent.mm.plugin.emojicapture.ui.b.g();
        d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
        int i2 = com.tencent.mm.plugin.emojicapture.model.d.rov;
        d.a aVar2 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        gVar.cZ(i2, com.tencent.mm.plugin.emojicapture.model.d.rov);
        com.tencent.mm.plugin.emojicapture.ui.b.g gVar2 = gVar;
        AppMethodBeat.o(603);
        return gVar2;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.j.a getPreviewRenderer() {
        return this.rsj;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.widget.c.b getRecorder() {
        int i2;
        AppMethodBeat.i(604);
        com.tencent.mm.media.j.a recordRenderer = getRecordRenderer();
        VideoTransPara videoTransPara = getVideoTransPara();
        EGLContext eGLContext = getCameraPreviewView().getEGLContext();
        if (eGLContext == null) {
            p.hyc();
        }
        com.tencent.mm.media.g.d previewTexture = this.rsO.getPreviewTexture();
        if (previewTexture != null) {
            i2 = previewTexture.igv;
        } else {
            i2 = -1;
        }
        com.tencent.mm.media.widget.c.c cVar = new com.tencent.mm.media.widget.c.c(videoTransPara, recordRenderer, eGLContext, i2);
        AppMethodBeat.o(604);
        return cVar;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQx() {
        AppMethodBeat.i(605);
        EmojiCaptureProxy.a aVar = EmojiCaptureProxy.rrF;
        boolean enableAutoRotate = EmojiCaptureProxy.rrE.getEnableAutoRotate();
        AppMethodBeat.o(605);
        return enableAutoRotate;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public final int getRecordScene() {
        return 8;
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        AppMethodBeat.i(256443);
        if (windowInsets != null) {
            findViewById(R.id.bz6).setPadding(0, windowInsets.getSystemWindowInsetTop(), 0, 0);
        }
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        p.g(onApplyWindowInsets, "super.onApplyWindowInsets(insets)");
        AppMethodBeat.o(256443);
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ CaptureContainer rte;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(CaptureContainer captureContainer) {
            super(0);
            this.rte = captureContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256441);
            this.rte.rsj.aEb();
            x xVar = x.SXb;
            AppMethodBeat.o(256441);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ CaptureContainer rte;
        final /* synthetic */ com.tencent.mm.sticker.f rth;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CaptureContainer captureContainer, com.tencent.mm.sticker.f fVar) {
            super(0);
            this.rte = captureContainer;
            this.rth = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(ap.CTRL_INDEX);
            this.rte.rsj.a(this.rth);
            x xVar = x.SXb;
            AppMethodBeat.o(ap.CTRL_INDEX);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ CaptureContainer rte;
        final /* synthetic */ boolean rti;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(CaptureContainer captureContainer, boolean z) {
            super(0);
            this.rte = captureContainer;
            this.rti = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(591);
            if (this.rti) {
                this.rte.rsR.setVisibility(0);
            } else {
                this.rte.rsR.setVisibility(8);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(591);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ CaptureContainer rte;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(CaptureContainer captureContainer) {
            super(0);
            this.rte = captureContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(588);
            this.rte.rsj.aEb();
            x xVar = x.SXb;
            AppMethodBeat.o(588);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ CaptureContainer rte;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(CaptureContainer captureContainer) {
            super(0);
            this.rte = captureContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(af.CTRL_INDEX);
            this.rte.rsj.aEa();
            a.AbstractC0967a presenter = this.rte.getPresenter();
            if (presenter != null) {
                presenter.ZZ();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(af.CTRL_INDEX);
            return xVar;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final VideoTransPara getDaemonVideoTransPara() {
        AppMethodBeat.i(SdkInfo.ErrCode.kErrCodeNotFound);
        VideoTransPara videoTransPara = getVideoTransPara();
        AppMethodBeat.o(SdkInfo.ErrCode.kErrCodeNotFound);
        return videoTransPara;
    }

    public static final /* synthetic */ void a(CaptureContainer captureContainer, boolean z) {
        AppMethodBeat.i(610);
        if (z) {
            Log.i(captureContainer.TAG, "stopRecord true");
            captureContainer.rsP.setTouchEnable(false);
            com.tencent.mm.ac.d.h(new EditorStickerView.b(captureContainer.rsS));
        } else {
            Log.i(captureContainer.TAG, "stopRecord false");
            captureContainer.F(true, R.string.an6);
            captureContainer.rsS.setShow(true);
            captureContainer.rsO.j(new f(captureContainer));
            captureContainer.lJ(com.tencent.mm.media.widget.camerarecordview.a.aQg());
            captureContainer.rsS.cJM();
        }
        captureContainer.rsQ.setEnabled(true);
        captureContainer.rsQ.animate().cancel();
        captureContainer.rsQ.setAlpha(1.0f);
        AppMethodBeat.o(610);
    }

    public static final /* synthetic */ void a(CaptureContainer captureContainer, com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(611);
        Log.i(captureContainer.TAG, "stopRecord: videoRecorder stop");
        EmojiCaptureReporter emojiCaptureReporter = captureContainer.rqJ;
        if (emojiCaptureReporter != null) {
            emojiCaptureReporter.ilM = captureContainer.rtd;
        }
        captureContainer.rtc.stopPreview();
        if (s.YS(bVar.iqd) && !s.YS(bVar.iqe) && !Util.isNullOrNil(bVar.iqe)) {
            Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(bVar.iqd);
            Log.i(captureContainer.TAG, "retry get video thumb:" + PF + ", videoPath:" + bVar.iqd + ", thumbPath:" + bVar.iqe);
            if (PF != null) {
                BitmapUtil.saveBitmapToImage(PF, 80, Bitmap.CompressFormat.JPEG, bVar.iqe, true);
            }
        }
        if (!s.YS(bVar.iqe)) {
            com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.roB;
            com.tencent.mm.plugin.emojicapture.model.e.cIU();
        }
        a.AbstractC0967a aVar = captureContainer.rsZ;
        if (aVar != null) {
            aVar.a(bVar, captureContainer.rtd);
            AppMethodBeat.o(611);
            return;
        }
        AppMethodBeat.o(611);
    }
}
