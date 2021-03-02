package com.tencent.mm.dynamicbackground.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.dynamicbackground.a.c;
import com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative;
import com.tencent.mm.dynamicbackground.view.GameGLSurfaceView;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 11}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0002$%B\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0006\u0010\u0015\u001a\u00020\rJ.\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0012J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\nJ\u0012\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRenderer", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "needPause", "", "showGradientView", "onAttachedToWindow", "", "onDetachedFromWindow", "onResume", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "release", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "surfaceCreated", "holder", "Landroid/view/SurfaceHolder;", "surfaceDestroyed", "Companion", "GLRenderer", "dynamicbg_release"})
public final class DynamicBackgroundGLSurfaceView extends GameGLSurfaceView {
    public static final a gRz = new a((byte) 0);
    public b gRw;
    private boolean gRx;
    private boolean gRy;

    static {
        AppMethodBeat.i(103118);
        AppMethodBeat.o(103118);
    }

    @l(hxD = {1, 1, 11}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$Companion;", "", "()V", "DRAW_LOG", "", "TAG", "", "dynamicbg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(103110);
        super.onDetachedFromWindow();
        c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onDetachedFromWindow", new Object[0]);
        AppMethodBeat.o(103110);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicBackgroundGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(103117);
        setEGLContextClientVersion(2);
        atW();
        setPreserveEGLContextOnPause(true);
        this.gRw = new b(context);
        setRenderer(this.gRw);
        getHolder().setFormat(-3);
        b bVar = this.gRw;
        if (bVar != null) {
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = this;
            p.h(dynamicBackgroundGLSurfaceView, "surfaceView");
            bVar.gRI = dynamicBackgroundGLSurfaceView;
            AppMethodBeat.o(103117);
            return;
        }
        AppMethodBeat.o(103117);
    }

    public /* synthetic */ DynamicBackgroundGLSurfaceView(Context context, AttributeSet attributeSet, int i2) {
        this(context, null);
    }

    public final void setShowGradientView(boolean z) {
        this.gRy = z;
        b bVar = this.gRw;
        if (bVar != null) {
            bVar.gRy = z;
            if (!bVar.gRy) {
                bVar.gRH = false;
            }
        }
    }

    public final void setColor(int i2, int i3, int i4, int i5, int i6) {
        DynamicBackgroundNative dynamicBackgroundNative;
        AppMethodBeat.i(230546);
        b bVar = this.gRw;
        if (bVar != null) {
            bVar.gRL = new b.a(i2, i3, i4, i5, i6);
            if (!bVar.gRM || (dynamicBackgroundNative = bVar.gRA) == null) {
                AppMethodBeat.o(230546);
                return;
            }
            b.a aVar = bVar.gRL;
            if (aVar == null) {
                p.hyc();
            }
            int i7 = aVar.gRQ;
            b.a aVar2 = bVar.gRL;
            if (aVar2 == null) {
                p.hyc();
            }
            int i8 = aVar2.gRR;
            b.a aVar3 = bVar.gRL;
            if (aVar3 == null) {
                p.hyc();
            }
            int i9 = aVar3.gRS;
            b.a aVar4 = bVar.gRL;
            if (aVar4 == null) {
                p.hyc();
            }
            int i10 = aVar4.gRT;
            b.a aVar5 = bVar.gRL;
            if (aVar5 == null) {
                p.hyc();
            }
            dynamicBackgroundNative.setColor(i7, i8, i9, i10, aVar5.gRU);
            AppMethodBeat.o(230546);
            return;
        }
        AppMethodBeat.o(230546);
    }

    @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(103111);
        super.surfaceDestroyed(surfaceHolder);
        c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceDestroyed", new Object[0]);
        b bVar = this.gRw;
        if (bVar != null) {
            bVar.gRG = false;
            AppMethodBeat.o(103111);
            return;
        }
        AppMethodBeat.o(103111);
    }

    @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(103112);
        super.surfaceCreated(surfaceHolder);
        c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceCreated", new Object[0]);
        AppMethodBeat.o(103112);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView
    public final void onAttachedToWindow() {
        AppMethodBeat.i(103113);
        super.onAttachedToWindow();
        c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onAttachedToWindow", new Object[0]);
        AppMethodBeat.o(103113);
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(View view, int i2) {
        AppMethodBeat.i(103114);
        p.h(view, "changedView");
        super.onVisibilityChanged(view, i2);
        c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onVisibilityChanged: %d", Integer.valueOf(i2));
        if (i2 != 0 && this.gRx) {
            c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo needPause", new Object[0]);
            this.gRx = false;
        }
        AppMethodBeat.o(103114);
    }

    @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView
    public final void onResume() {
        AppMethodBeat.i(103115);
        super.onResume();
        this.gRx = false;
        AppMethodBeat.o(103115);
    }

    public final void setGradientBackgroundView(View view) {
        AppMethodBeat.i(103116);
        p.h(view, "gradientColorBackgroundView");
        b bVar = this.gRw;
        if (bVar != null) {
            p.h(view, "gradientColorBackgroundView");
            bVar.gRF = view;
            AppMethodBeat.o(103116);
            return;
        }
        AppMethodBeat.o(103116);
    }

    @l(hxD = {1, 1, 11}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0015\u0018\u0000 B2\u00020\u0001:\u0002ABB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0016J\u001a\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\fH\u0016J\u001c\u0010(\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020!H\u0016J\b\u00100\u001a\u00020!H\u0016J\"\u00101\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0016J\u0006\u00104\u001a\u00020!J\b\u00105\u001a\u00020!H\u0002J.\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\nJ\u000e\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\u0014J\u000e\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\fJ\u000e\u0010@\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, hxF = {"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorInfo", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mDynamicBgService", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "mGradientBgView", "Landroid/view/View;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "nativeRenderInitialized", "needCheckBlack", "showGradientView", "surfaceView", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "viewHeight", "viewWidth", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "initNativeView", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "release", "reset", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "ColorInfo", "Companion", "dynamicbg_release"})
    public static final class b implements GameGLSurfaceView.n {
        private static long gRO = 500;
        public static final C0315b gRP = new C0315b((byte) 0);
        public DynamicBackgroundNative gRA;
        private WeakReference<Context> gRB;
        private long gRC = -1;
        public int gRD;
        public int gRE;
        public View gRF;
        boolean gRG;
        boolean gRH;
        GameGLSurfaceView gRI;
        private int gRJ;
        private boolean gRK = true;
        a gRL;
        public boolean gRM;
        private com.tencent.mm.dynamicbackground.model.c gRN;
        boolean gRy;

        public b(Context context) {
            com.tencent.mm.dynamicbackground.model.c cVar;
            p.h(context, "context");
            AppMethodBeat.i(103108);
            com.tencent.mm.dynamicbackground.model.d dVar = com.tencent.mm.dynamicbackground.model.d.gRj;
            this.gRN = com.tencent.mm.dynamicbackground.model.d.atN();
            com.tencent.mm.dynamicbackground.model.c cVar2 = this.gRN;
            if (cVar2 == null || !cVar2.atB() || (cVar = this.gRN) == null || cVar.atE()) {
                com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground", new Object[0]);
            } else {
                this.gRA = new DynamicBackgroundNative();
            }
            this.gRB = new WeakReference<>(context);
            AppMethodBeat.o(103108);
        }

        private final void init() {
            AppMethodBeat.i(103098);
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init", new Object[0]);
            try {
                DynamicBackgroundNative dynamicBackgroundNative = this.gRA;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.nativeInit();
                }
                this.gRM = true;
                a aVar = this.gRL;
                if (aVar != null) {
                    DynamicBackgroundNative dynamicBackgroundNative2 = this.gRA;
                    if (dynamicBackgroundNative2 != null) {
                        dynamicBackgroundNative2.setColor(aVar.gRQ, aVar.gRR, aVar.gRS, aVar.gRT, aVar.gRU);
                        AppMethodBeat.o(103098);
                        return;
                    }
                    AppMethodBeat.o(103098);
                    return;
                }
                AppMethodBeat.o(103098);
            } catch (Throwable th) {
                com.tencent.mm.dynamicbackground.model.c cVar = this.gRN;
                if (cVar != null) {
                    cVar.atG();
                    AppMethodBeat.o(103098);
                    return;
                }
                AppMethodBeat.o(103098);
            }
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.n
        public final void atP() {
            Point point;
            AppMethodBeat.i(103099);
            try {
                init();
                Context context = this.gRB.get();
                if (context == null) {
                    AppMethodBeat.o(103099);
                    return;
                }
                com.tencent.mm.dynamicbackground.model.c cVar = this.gRN;
                if (cVar == null || (point = cVar.az(context)) == null) {
                    point = new Point(0, 0);
                }
                this.gRD = point.x;
                this.gRE = point.y;
                com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", Integer.valueOf(this.gRD), Integer.valueOf(this.gRE));
                atR();
                com.tencent.mm.dynamicbackground.model.c cVar2 = this.gRN;
                if (cVar2 != null) {
                    if (cVar2.atB()) {
                        com.tencent.mm.dynamicbackground.model.c cVar3 = this.gRN;
                        if (cVar3 == null) {
                            AppMethodBeat.o(103099);
                            return;
                        } else if (!cVar3.atI()) {
                            com.tencent.mm.dynamicbackground.model.c cVar4 = this.gRN;
                            if (cVar4 != null) {
                                cVar4.atH();
                                AppMethodBeat.o(103099);
                                return;
                            }
                            AppMethodBeat.o(103099);
                            return;
                        }
                    }
                    AppMethodBeat.o(103099);
                    return;
                }
                AppMethodBeat.o(103099);
            } catch (Throwable th) {
                com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo onEGLCreated exception", new Object[0]);
                com.tencent.mm.dynamicbackground.model.c cVar5 = this.gRN;
                if (cVar5 != null) {
                    cVar5.atG();
                    AppMethodBeat.o(103099);
                }
            }
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.n
        public final void atQ() {
            AppMethodBeat.i(103100);
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing", new Object[0]);
            this.gRJ = 0;
            AppMethodBeat.o(103100);
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.n
        public final void cx(int i2, int i3) {
            AppMethodBeat.i(103101);
            try {
                com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged width: %d, height: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                if ((this.gRD != i2 && this.gRE == i3) || !(this.gRE == i3 || this.gRD == i2)) {
                    init();
                    this.gRD = i2;
                    this.gRE = i3;
                    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", Integer.valueOf(this.gRD), Integer.valueOf(this.gRE));
                    atR();
                    AppMethodBeat.o(103101);
                    return;
                }
            } catch (Throwable th) {
                com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
                com.tencent.mm.dynamicbackground.model.c cVar = this.gRN;
                if (cVar != null) {
                    cVar.atC();
                    AppMethodBeat.o(103101);
                    return;
                }
            }
            AppMethodBeat.o(103101);
        }

        private final void atR() {
            AppMethodBeat.i(103102);
            DynamicBackgroundNative dynamicBackgroundNative = this.gRA;
            if (dynamicBackgroundNative != null) {
                dynamicBackgroundNative.surfaceCreated(this.gRD, this.gRE);
            }
            Context context = this.gRB.get();
            if (context == null) {
                AppMethodBeat.o(103102);
                return;
            }
            DynamicBackgroundNative dynamicBackgroundNative2 = this.gRA;
            if (dynamicBackgroundNative2 != null) {
                StringBuilder sb = new StringBuilder();
                com.tencent.mm.dynamicbackground.a.b bVar = com.tencent.mm.dynamicbackground.a.b.gRt;
                String sb2 = sb.append(com.tencent.mm.dynamicbackground.a.b.cF(context)).append("scene_shaderv.glsl").toString();
                StringBuilder sb3 = new StringBuilder();
                com.tencent.mm.dynamicbackground.a.b bVar2 = com.tencent.mm.dynamicbackground.a.b.gRt;
                String sb4 = sb3.append(com.tencent.mm.dynamicbackground.a.b.cF(context)).append("scene_shaderf.glsl").toString();
                StringBuilder sb5 = new StringBuilder();
                com.tencent.mm.dynamicbackground.a.b bVar3 = com.tencent.mm.dynamicbackground.a.b.gRt;
                String sb6 = sb5.append(com.tencent.mm.dynamicbackground.a.b.cF(context)).append("vertex_framebuffer_plane.glsl").toString();
                StringBuilder sb7 = new StringBuilder();
                com.tencent.mm.dynamicbackground.a.b bVar4 = com.tencent.mm.dynamicbackground.a.b.gRt;
                String sb8 = sb7.append(com.tencent.mm.dynamicbackground.a.b.cF(context)).append("frag_framebuffer_plane.glsl").toString();
                StringBuilder sb9 = new StringBuilder();
                com.tencent.mm.dynamicbackground.a.b bVar5 = com.tencent.mm.dynamicbackground.a.b.gRt;
                String sb10 = sb9.append(com.tencent.mm.dynamicbackground.a.b.cF(context)).append("texture_vertex_shader.glsl").toString();
                StringBuilder sb11 = new StringBuilder();
                com.tencent.mm.dynamicbackground.a.b bVar6 = com.tencent.mm.dynamicbackground.a.b.gRt;
                String sb12 = sb11.append(com.tencent.mm.dynamicbackground.a.b.cF(context)).append("texture_fragment_shader.glsl").toString();
                StringBuilder sb13 = new StringBuilder();
                com.tencent.mm.dynamicbackground.a.b bVar7 = com.tencent.mm.dynamicbackground.a.b.gRt;
                String sb14 = sb13.append(com.tencent.mm.dynamicbackground.a.b.cF(context)).append("bg_gradient_vertex_shader.glsl").toString();
                StringBuilder sb15 = new StringBuilder();
                com.tencent.mm.dynamicbackground.a.b bVar8 = com.tencent.mm.dynamicbackground.a.b.gRt;
                dynamicBackgroundNative2.setupGlslFiles(sb2, sb4, sb6, sb8, sb10, sb12, sb14, sb15.append(com.tencent.mm.dynamicbackground.a.b.cF(context)).append("bg_gradient_fragment_shader.glsl").toString());
            }
            DynamicBackgroundNative dynamicBackgroundNative3 = this.gRA;
            if (dynamicBackgroundNative3 != null) {
                dynamicBackgroundNative3.initView();
            }
            this.gRJ = 0;
            AppMethodBeat.o(103102);
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.n
        public final void atS() {
            View view;
            View view2;
            com.tencent.mm.dynamicbackground.model.c cVar;
            com.tencent.mm.dynamicbackground.model.c cVar2;
            AppMethodBeat.i(103103);
            try {
                com.tencent.mm.dynamicbackground.model.c cVar3 = this.gRN;
                Thread.sleep(cVar3 != null ? (long) cVar3.atM() : 16);
            } catch (Exception e2) {
            }
            com.tencent.mm.dynamicbackground.model.c cVar4 = this.gRN;
            if (!(cVar4 == null || !cVar4.atJ() || (cVar2 = this.gRN) == null)) {
                cVar2.atK();
            }
            try {
                DynamicBackgroundNative dynamicBackgroundNative = this.gRA;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.draw();
                }
            } catch (Throwable th) {
                com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo onDraw exception", new Object[0]);
                com.tencent.mm.dynamicbackground.model.c cVar5 = this.gRN;
                if (cVar5 != null) {
                    cVar5.atC();
                }
            }
            com.tencent.mm.dynamicbackground.model.c cVar6 = this.gRN;
            if (cVar6 != null && cVar6.atJ()) {
                this.gRJ++;
                if (this.gRJ >= 2 && (cVar = this.gRN) != null) {
                    cVar.atL();
                }
            }
            if (!this.gRy && !this.gRH) {
                this.gRH = true;
                View view3 = this.gRF;
                if (view3 != null) {
                    view3.post(new c(this));
                    AppMethodBeat.o(103103);
                    return;
                }
                AppMethodBeat.o(103103);
            } else if (!this.gRy || (((view = this.gRF) != null && view.getVisibility() == 0) || (view2 = this.gRF) == null)) {
                AppMethodBeat.o(103103);
            } else {
                view2.post(new d(this));
                AppMethodBeat.o(103103);
            }
        }

        @l(hxD = {1, 1, 11}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class c implements Runnable {
            final /* synthetic */ b gRV;

            c(b bVar) {
                this.gRV = bVar;
            }

            public final void run() {
                ViewPropertyAnimator animate;
                ViewPropertyAnimator alpha;
                ViewPropertyAnimator duration;
                ViewPropertyAnimator listener;
                AppMethodBeat.i(103095);
                View view = this.gRV.gRF;
                if (view != null) {
                    if (view.getVisibility() == 0 && !this.gRV.gRG) {
                        GameGLSurfaceView gameGLSurfaceView = this.gRV.gRI;
                        if (gameGLSurfaceView != null) {
                            gameGLSurfaceView.setVisibility(0);
                        }
                        this.gRV.gRG = true;
                        View view2 = this.gRV.gRF;
                        if (view2 != null) {
                            view2.setAlpha(1.0f);
                        }
                        com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation", new Object[0]);
                        View view3 = this.gRV.gRF;
                        if (!(view3 == null || (animate = view3.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(b.gRO)) == null || (listener = duration.setListener(new Animator.AnimatorListener(this) {
                            /* class com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b.c.AnonymousClass1 */
                            final /* synthetic */ c gRW;

                            /* JADX WARN: Incorrect args count in method signature: ()V */
                            {
                                this.gRW = r1;
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }

                            public final void onAnimationEnd(Animator animator) {
                                AppMethodBeat.i(103094);
                                View view = this.gRW.gRV.gRF;
                                if (view != null) {
                                    view.setVisibility(4);
                                }
                                this.gRW.gRV.gRG = false;
                                AppMethodBeat.o(103094);
                            }

                            public final void onAnimationCancel(Animator animator) {
                                this.gRW.gRV.gRG = false;
                            }

                            public final void onAnimationStart(Animator animator) {
                            }
                        })) == null)) {
                            listener.start();
                            AppMethodBeat.o(103095);
                            return;
                        }
                    }
                    AppMethodBeat.o(103095);
                    return;
                }
                AppMethodBeat.o(103095);
            }
        }

        @l(hxD = {1, 1, 11}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class d implements Runnable {
            final /* synthetic */ b gRV;

            d(b bVar) {
                this.gRV = bVar;
            }

            public final void run() {
                AppMethodBeat.i(103097);
                View view = this.gRV.gRF;
                if (view != null) {
                    view.setVisibility(0);
                }
                View view2 = this.gRV.gRF;
                if (view2 != null) {
                    view2.setAlpha(1.0f);
                }
                com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView", new Object[0]);
                GameGLSurfaceView gameGLSurfaceView = this.gRV.gRI;
                if (gameGLSurfaceView != null) {
                    gameGLSurfaceView.postDelayed(new Runnable(this) {
                        /* class com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b.d.AnonymousClass1 */
                        final /* synthetic */ d gRX;

                        {
                            this.gRX = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(103096);
                            GameGLSurfaceView gameGLSurfaceView = this.gRX.gRV.gRI;
                            if (gameGLSurfaceView != null) {
                                gameGLSurfaceView.onPause();
                            }
                            GameGLSurfaceView gameGLSurfaceView2 = this.gRX.gRV.gRI;
                            if (gameGLSurfaceView2 != null) {
                                gameGLSurfaceView2.setVisibility(4);
                                AppMethodBeat.o(103096);
                                return;
                            }
                            AppMethodBeat.o(103096);
                        }
                    }, 50);
                    AppMethodBeat.o(103097);
                    return;
                }
                AppMethodBeat.o(103097);
            }
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.n
        public final void onResume() {
            AppMethodBeat.i(103104);
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onResume", new Object[0]);
            this.gRK = true;
            AppMethodBeat.o(103104);
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.n
        public final void onDestroy() {
            AppMethodBeat.i(103105);
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onDestroy", new Object[0]);
            try {
                DynamicBackgroundNative dynamicBackgroundNative = this.gRA;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.nativeRelease();
                    AppMethodBeat.o(103105);
                    return;
                }
                AppMethodBeat.o(103105);
            } catch (Throwable th) {
                com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo nativeRelease exception", new Object[0]);
                AppMethodBeat.o(103105);
            }
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.n
        public final void onPause() {
            AppMethodBeat.i(103106);
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onPause", new Object[0]);
            AppMethodBeat.o(103106);
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.n
        public final void atT() {
            AppMethodBeat.i(103107);
            com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError", new Object[0]);
            com.tencent.mm.dynamicbackground.model.c cVar = this.gRN;
            if (cVar != null) {
                cVar.atF();
                AppMethodBeat.o(103107);
                return;
            }
            AppMethodBeat.o(103107);
        }

        @l(hxD = {1, 1, 11}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$Companion;", "", "()V", "ALPHA_ANIMATION_DURATION", "", "checkBlackScreen", "", "buf", "Ljava/nio/ByteBuffer;", "width", "", "height", "getAlphaAnimation", "loadShader", "type", "shaderCode", "", "saveRgb2Bitmap", "Landroid/graphics/Bitmap;", "Ljava/nio/Buffer;", "filename", "updateAlphaAnimation", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "dynamicbg_release"})
        /* renamed from: com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView$b$b  reason: collision with other inner class name */
        public static final class C0315b {
            private C0315b() {
            }

            public /* synthetic */ C0315b(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(103109);
            AppMethodBeat.o(103109);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 11}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "dynamicbg_release"})
        public static final class a {
            final int gRQ;
            final int gRR;
            final int gRS;
            final int gRT;
            final int gRU;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (!(obj instanceof a)) {
                        return false;
                    }
                    a aVar = (a) obj;
                    if (!(this.gRQ == aVar.gRQ)) {
                        return false;
                    }
                    if (!(this.gRR == aVar.gRR)) {
                        return false;
                    }
                    if (!(this.gRS == aVar.gRS)) {
                        return false;
                    }
                    if (!(this.gRT == aVar.gRT)) {
                        return false;
                    }
                    if (!(this.gRU == aVar.gRU)) {
                        return false;
                    }
                }
                return true;
            }

            public final int hashCode() {
                return (((((((this.gRQ * 31) + this.gRR) * 31) + this.gRS) * 31) + this.gRT) * 31) + this.gRU;
            }

            public final String toString() {
                AppMethodBeat.i(230545);
                String str = "ColorInfo(particleColor1=" + this.gRQ + ", particleColor2=" + this.gRR + ", particleColor3=" + this.gRS + ", bgColor1=" + this.gRT + ", bgColor2=" + this.gRU + ")";
                AppMethodBeat.o(230545);
                return str;
            }

            public a(int i2, int i3, int i4, int i5, int i6) {
                this.gRQ = i2;
                this.gRR = i3;
                this.gRS = i4;
                this.gRT = i5;
                this.gRU = i6;
            }
        }
    }
}
