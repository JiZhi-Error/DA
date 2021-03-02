package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bm;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.plugin.appbrand.jsapi.bu;
import com.tencent.mm.plugin.emojicapture.b.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.ui.b.n;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.f;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.au;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001\u0013\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000208H\u0016J\n\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\nH\u0016J\b\u0010<\u001a\u00020\nH\u0016J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u000202H\u0016J\u0006\u0010@\u001a\u000202J\u0006\u0010A\u001a\u000202J\u0006\u0010B\u001a\u000202J(\u0010C\u001a\u0002022\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\nH\u0014J\u000e\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020\rJ\b\u0010J\u001a\u000200H\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "bottomLine", "Landroid/support/constraint/Guideline;", "callback", "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreview", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiPreviewSize", "emojiPreviewTopMargin", "mode", "previewLayout", "Landroid/view/ViewGroup;", "previewRect", "Landroid/graphics/Rect;", "render", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "stickerUrl", "switchCamera", "Landroid/view/View;", "switchCameraIcon", "Landroid/widget/ImageView;", "switchMode", "switchModeIcon", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "useBackgroundCamera", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordScene", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "initCameraConfig", "onDestroy", "onPause", "onResume", "onSizeChanged", "w", "h", "oldw", "oldh", "setStickerUrl", "url", "useCpuCrop", "Companion", "plugin-emojicapture_release"})
public final class StickerPreviewView extends ConstraintLayout implements com.tencent.mm.media.widget.camerarecordview.d.a {
    public static final a rxh = new a((byte) 0);
    private final String TAG;
    private final int gJc;
    private int mode;
    private final Rect previewRect;
    private final CameraFrontSightView rsV;
    private final MMSightCaptureTouchView rsW;
    private String rsz;
    public final com.tencent.mm.media.widget.camerarecordview.a rtc;
    private boolean rtd;
    private final FontAnimTextView rtk;
    private final CaptureStickerHint rtl;
    private final ViewGroup rwX;
    private final CameraPreviewGLTextureView rwY;
    private final View rwZ;
    private final View rxa;
    private final ImageView rxb;
    private final ImageView rxc;
    private final Guideline rxd;
    private n rxe;
    private final int rxf;
    public final b rxg;

    static {
        AppMethodBeat.i(926);
        AppMethodBeat.o(926);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean Zx() {
        return false;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQx() {
        return false;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQy() {
        return false;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.j.a getRecordRenderer() {
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.widget.c.b getRecorder() {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StickerPreviewView(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(924);
        this.TAG = "MicroMsg.StickerPreviewView";
        this.rxe = new n((byte) 0);
        this.mode = 2;
        this.previewRect = new Rect();
        this.rsz = "";
        this.rxg = new b(this);
        View.inflate(context, R.layout.byv, this);
        this.gJc = getResources().getDimensionPixelSize(R.dimen.a1x);
        this.rxf = getResources().getDimensionPixelSize(R.dimen.c6);
        View findViewById = findViewById(R.id.i64);
        p.g(findViewById, "findViewById(R.id.sticker_preview_capture_layout)");
        this.rwX = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.i6b);
        p.g(findViewById2, "findViewById(R.id.sticker_preview_capture_view)");
        this.rwY = (CameraPreviewGLTextureView) findViewById2;
        View findViewById3 = findViewById(R.id.i63);
        p.g(findViewById3, "findViewById(R.id.sticke…view_capture_focus_frame)");
        this.rsV = (CameraFrontSightView) findViewById3;
        View findViewById4 = findViewById(R.id.i6a);
        p.g(findViewById4, "findViewById(R.id.sticke…eview_capture_touch_view)");
        this.rsW = (MMSightCaptureTouchView) findViewById4;
        View findViewById5 = findViewById(R.id.i68);
        p.g(findViewById5, "findViewById(R.id.sticke…view_capture_switch_mode)");
        this.rwZ = findViewById5;
        View findViewById6 = findViewById(R.id.i65);
        p.g(findViewById6, "findViewById(R.id.sticke…ew_capture_switch_camera)");
        this.rxa = findViewById6;
        View findViewById7 = findViewById(R.id.i69);
        p.g(findViewById7, "findViewById(R.id.sticke…capture_switch_mode_icon)");
        this.rxb = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.i66);
        p.g(findViewById8, "findViewById(R.id.sticke…pture_switch_camera_icon)");
        this.rxc = (ImageView) findViewById8;
        com.tencent.mm.plugin.emojicapture.ui.c.a(this.rxc, R.raw.icons_filled_camera_switch, -1);
        View findViewById9 = findViewById(R.id.i6l);
        p.g(findViewById9, "findViewById(R.id.sticker_preview_switch_bottom)");
        this.rxd = (Guideline) findViewById9;
        this.rxd.setGuidelineEnd(au.aD(context) + getResources().getDimensionPixelOffset(R.dimen.ci));
        View findViewById10 = findViewById(R.id.i6d);
        p.g(findViewById10, "findViewById(R.id.sticker_preview_hint)");
        this.rtl = (CaptureStickerHint) findViewById10;
        View findViewById11 = findViewById(R.id.i6j);
        p.g(findViewById11, "findViewById(R.id.sticker_preview_subtitle)");
        this.rtk = (FontAnimTextView) findViewById11;
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 120);
        this.rsV.hd(fromDPToPix, fromDPToPix);
        this.rwY.setOpaque(false);
        this.rtc = new com.tencent.mm.media.widget.camerarecordview.a(this);
        this.rsW.setTouchCallback(new MMSightCaptureTouchView.a(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView.AnonymousClass1 */
            final /* synthetic */ StickerPreviewView rxi;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.rxi = r1;
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void I(float f2, float f3) {
                AppMethodBeat.i(902);
                this.rxi.rtc.b(f2, f3, this.rxi.rwX.getWidth(), this.rxi.rwX.getHeight());
                this.rxi.rsV.aa(f2, f3);
                AppMethodBeat.o(902);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void cJL() {
                AppMethodBeat.i(903);
                this.rxi.rtc.aPq();
                this.rxi.rtd = com.tencent.mm.media.widget.camerarecordview.a.b(this.rxi.rtc);
                AppMethodBeat.o(903);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void bqQ() {
                AppMethodBeat.i(904);
                this.rxi.rtc.i(true, 1);
                AppMethodBeat.o(904);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void bqR() {
                AppMethodBeat.i(bu.CTRL_INDEX);
                this.rxi.rtc.i(false, 1);
                AppMethodBeat.o(bu.CTRL_INDEX);
            }
        });
        this.rwZ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView.AnonymousClass2 */
            final /* synthetic */ StickerPreviewView rxi;

            {
                this.rxi = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(909);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final android.support.design.widget.a aVar = new android.support.design.widget.a(context);
                StickerPreviewChangeMode stickerPreviewChangeMode = new StickerPreviewChangeMode(context);
                stickerPreviewChangeMode.setBackgroundResource(R.drawable.emoji_capture_sticker_panel_bg);
                stickerPreviewChangeMode.setOnModeSelected(new kotlin.g.a.b<Integer, x>(this) {
                    /* class com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView.AnonymousClass2.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass2 rxj;

                    {
                        this.rxj = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(Integer num) {
                        AppMethodBeat.i(908);
                        final int intValue = num.intValue();
                        ViewGroup.LayoutParams layoutParams = this.rxj.rxi.rwX.getLayoutParams();
                        if (layoutParams == null) {
                            t tVar = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                            AppMethodBeat.o(908);
                            throw tVar;
                        }
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        ViewGroup.LayoutParams layoutParams3 = this.rxj.rxi.rtk.getLayoutParams();
                        if (layoutParams3 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                            AppMethodBeat.o(908);
                            throw tVar2;
                        }
                        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                        switch (intValue) {
                            case 0:
                                layoutParams2.width = this.rxj.rxi.gJc;
                                layoutParams2.height = this.rxj.rxi.gJc;
                                layoutParams2.topMargin = this.rxj.rxi.rxf;
                                int width = (this.rxj.rxi.getWidth() - this.rxj.rxi.gJc) / 2;
                                int i2 = this.rxj.rxi.rxf;
                                this.rxj.rxi.previewRect.set(width, i2, this.rxj.rxi.gJc + width, this.rxj.rxi.gJc + i2);
                                layoutParams4.bottomToBottom = 0;
                                layoutParams4.topToBottom = -1;
                                break;
                            case 1:
                                layoutParams2.width = -1;
                                layoutParams2.height = -1;
                                if (this.rxj.rxi.getWidth() * 16 > this.rxj.rxi.getHeight() * 9) {
                                    int width2 = (this.rxj.rxi.getWidth() - ((this.rxj.rxi.getHeight() * 9) / 16)) / 2;
                                    this.rxj.rxi.previewRect.set(width2, 0, this.rxj.rxi.getWidth() - width2, this.rxj.rxi.getHeight());
                                } else {
                                    int height = (this.rxj.rxi.getHeight() - ((this.rxj.rxi.getWidth() * 16) / 9)) / 2;
                                    this.rxj.rxi.previewRect.set(0, height, this.rxj.rxi.getWidth(), this.rxj.rxi.getHeight() - height);
                                }
                                layoutParams4.bottomToBottom = -1;
                                layoutParams4.topToBottom = R.id.i6k;
                                break;
                            case 2:
                                layoutParams2.width = -1;
                                layoutParams2.height = -1;
                                layoutParams2.topMargin = 0;
                                this.rxj.rxi.previewRect.set(0, 0, this.rxj.rxi.getWidth(), this.rxj.rxi.getHeight());
                                layoutParams4.bottomToBottom = -1;
                                layoutParams4.topToBottom = R.id.i6k;
                                break;
                        }
                        this.rxj.rxi.rwY.j(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView.AnonymousClass2.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 rxl;

                            {
                                this.rxl = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(907);
                                this.rxl.rxj.rxi.rxe.b(intValue, this.rxl.rxj.rxi.previewRect);
                                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                                    /* class com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView.AnonymousClass2.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass1 rxn;

                                    {
                                        this.rxn = r2;
                                    }

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.g.a.a
                                    public final /* synthetic */ x invoke() {
                                        AppMethodBeat.i(bb.CTRL_INDEX);
                                        this.rxn.rxl.rxj.rxi.rwX.requestLayout();
                                        x xVar = x.SXb;
                                        AppMethodBeat.o(bb.CTRL_INDEX);
                                        return xVar;
                                    }
                                });
                                x xVar = x.SXb;
                                AppMethodBeat.o(907);
                                return xVar;
                            }
                        });
                        aVar.dismiss();
                        x xVar = x.SXb;
                        AppMethodBeat.o(908);
                        return xVar;
                    }
                });
                aVar.setContentView(stickerPreviewChangeMode);
                aVar.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(909);
            }
        });
        this.rxa.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView.AnonymousClass3 */
            final /* synthetic */ StickerPreviewView rxi;

            {
                this.rxi = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.f.b.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.media.widget.camerarecordview.a.b(this.rxi.rtc);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.f.b.CTRL_INDEX);
            }
        });
        com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
        com.tencent.mm.sticker.loader.e.a(this.rxg);
        f fVar = new f();
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.sticker.loader.e eVar2 = com.tencent.mm.sticker.loader.e.NNN;
        fVar.bip(sb.append(com.tencent.mm.sticker.loader.e.gyY()).append("preview/").toString());
        StringBuilder sb2 = new StringBuilder();
        com.tencent.mm.sticker.loader.e eVar3 = com.tencent.mm.sticker.loader.e.NNN;
        fVar.bir(sb2.append(com.tencent.mm.sticker.loader.e.gyY()).append("preview/").toString());
        a(fVar);
        AppMethodBeat.o(924);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StickerPreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(br.CTRL_INDEX);
        AppMethodBeat.o(br.CTRL_INDEX);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
    public static final class b implements com.tencent.mm.loader.g.f<g> {
        final /* synthetic */ StickerPreviewView rxi;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(StickerPreviewView stickerPreviewView) {
            this.rxi = stickerPreviewView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(g gVar, j jVar) {
            AppMethodBeat.i(911);
            g gVar2 = gVar;
            p.h(gVar2, "task");
            p.h(jVar, "status");
            if (p.j(gVar2.NNU.url, this.rxi.rsz)) {
                Log.i(this.rxi.TAG, "onLoaderFin: ".concat(String.valueOf(jVar)));
                if (jVar == j.OK) {
                    f fVar = new f();
                    StringBuilder sb = new StringBuilder();
                    com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
                    fVar.bip(sb.append(com.tencent.mm.sticker.loader.e.gyY()).append("preview/").toString());
                    StringBuilder sb2 = new StringBuilder();
                    com.tencent.mm.sticker.loader.e eVar2 = com.tencent.mm.sticker.loader.e.NNN;
                    fVar.bir(sb2.append(com.tencent.mm.sticker.loader.e.gyY()).append("preview/").toString());
                    this.rxi.a(fVar);
                    AppMethodBeat.o(911);
                    return;
                }
                this.rxi.a((f) null);
            }
            AppMethodBeat.o(911);
        }
    }

    public final void setStickerUrl(String str) {
        AppMethodBeat.i(bm.CTRL_INDEX);
        p.h(str, "url");
        this.rsz = str;
        com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
        com.tencent.mm.sticker.loader.e.biv(str);
        AppMethodBeat.o(bm.CTRL_INDEX);
    }

    public final void a(f fVar) {
        AppMethodBeat.i(917);
        com.tencent.mm.ac.d.h(new c(this, fVar));
        this.rwY.j(new d(this, fVar));
        AppMethodBeat.o(917);
    }

    public final void onResume() {
        AppMethodBeat.i(918);
        com.tencent.mm.media.widget.camerarecordview.a.a(this.rtc, this.rtd, null, 6);
        AppMethodBeat.o(918);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(919);
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 && i2 > 0) {
            int width = (getWidth() - this.gJc) / 2;
            int i6 = this.rxf;
            this.previewRect.set(width, i6, this.gJc + width, this.gJc + i6);
            n nVar = this.rxe;
            Rect rect = this.previewRect;
            p.h(rect, "previewRect");
            nVar.previewRect.set(rect);
        }
        AppMethodBeat.o(919);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQw() {
        AppMethodBeat.i(920);
        boolean z = ((a.C0966a) com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).ilO;
        AppMethodBeat.o(920);
        return z;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public final int getRecordScene() {
        return 10;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public final int getResolutionLimit() {
        AppMethodBeat.i(921);
        int i2 = ((a.C0966a) com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).hzj;
        AppMethodBeat.o(921);
        return i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
    public static final class e implements com.tencent.mm.media.widget.camerarecordview.b.a {
        e() {
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final int aQm() {
            return 2;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final String getFilePath() {
            AppMethodBeat.i(914);
            d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
            String cIK = d.a.cIK();
            AppMethodBeat.o(914);
            return cIK;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final String aQn() {
            AppMethodBeat.i(915);
            d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
            String cIL = d.a.cIL();
            AppMethodBeat.o(915);
            return cIL;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig() {
        AppMethodBeat.i(922);
        e eVar = new e();
        AppMethodBeat.o(922);
        return eVar;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final VideoTransPara getVideoTransPara() {
        AppMethodBeat.i(923);
        VideoTransPara videoTransPara = k.zuy.irT;
        if (videoTransPara != null) {
            AppMethodBeat.o(923);
            return videoTransPara;
        }
        VideoTransPara videoTransPara2 = new VideoTransPara();
        AppMethodBeat.o(923);
        return videoTransPara2;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView() {
        return this.rwY;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.j.a getPreviewRenderer() {
        return this.rxe;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$Companion;", "", "()V", "MODE_CAPTURE_EMOJI", "", "MODE_FULLSCREEN", "MODE_RATIO_16_9", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f rth;
        final /* synthetic */ StickerPreviewView rxi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(StickerPreviewView stickerPreviewView, f fVar) {
            super(0);
            this.rxi = stickerPreviewView;
            this.rth = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            String str2;
            String str3;
            boolean z;
            int i2;
            boolean z2;
            int Gp;
            String str4;
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.a.a.CTRL_INDEX);
            f fVar = this.rth;
            if (fVar != null) {
                str = fVar.title;
            } else {
                str = null;
            }
            String str5 = str;
            if (str5 == null || str5.length() == 0) {
                this.rxi.rtk.e(null, WebView.NIGHT_MODE_COLOR, com.tencent.mm.plugin.emojicapture.ui.c.Gp(WebView.NIGHT_MODE_COLOR));
            } else {
                f fVar2 = this.rth;
                if (fVar2 != null) {
                    str2 = fVar2.iyd;
                } else {
                    str2 = null;
                }
                f fVar3 = this.rth;
                if (fVar3 != null) {
                    str3 = fVar3.NNr;
                } else {
                    str3 = null;
                }
                String str6 = str2;
                if (str6 == null || kotlin.n.n.aL(str6)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
                    i2 = d.a.anl(str2);
                } else {
                    i2 = -1;
                }
                String str7 = str3;
                if (str7 == null || kotlin.n.n.aL(str7)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    d.a aVar2 = com.tencent.mm.plugin.emojicapture.model.d.roA;
                    Gp = d.a.anl(str3);
                } else {
                    Gp = com.tencent.mm.plugin.emojicapture.ui.c.Gp(i2);
                }
                FontAnimTextView fontAnimTextView = this.rxi.rtk;
                f fVar4 = this.rth;
                if (fVar4 != null) {
                    str4 = fVar4.title;
                } else {
                    str4 = null;
                }
                fontAnimTextView.e(str4, i2, Gp);
            }
            this.rxi.rtl.setStickerPack(this.rth);
            x xVar = x.SXb;
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.a.a.CTRL_INDEX);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f rth;
        final /* synthetic */ StickerPreviewView rxi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(StickerPreviewView stickerPreviewView, f fVar) {
            super(0);
            this.rxi = stickerPreviewView;
            this.rth = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(913);
            n nVar = this.rxi.rxe;
            f fVar = this.rth;
            com.tencent.mm.plugin.xlabeffect.b bVar = nVar.hiH;
            if (bVar != null) {
                bVar.a(fVar);
            }
            nVar.rwO = fVar;
            x xVar = x.SXb;
            AppMethodBeat.o(913);
            return xVar;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final VideoTransPara getDaemonVideoTransPara() {
        AppMethodBeat.i(bf.CTRL_INDEX);
        VideoTransPara videoTransPara = getVideoTransPara();
        AppMethodBeat.o(bf.CTRL_INDEX);
        return videoTransPara;
    }
}
