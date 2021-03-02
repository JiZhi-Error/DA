package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 h2\u00020\u0001:\u0001hB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020L0PH\u0002J\u0010\u0010Q\u001a\u00020N2\u0006\u0010R\u001a\u00020\u0004H\u0002J*\u0010S\u001a\u00020N2\u0006\u0010T\u001a\u00020U2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00010W2\u0006\u0010X\u001a\u00020YJ\b\u0010Z\u001a\u00020NH\u0002J\u0010\u0010[\u001a\u00020L2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u001e\u0010\\\u001a\u00020L2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=J\u001c\u0010]\u001a\u00020N2\u0006\u0010^\u001a\u00020\u00042\f\u0010O\u001a\b\u0012\u0004\u0012\u00020L0PJ\b\u0010_\u001a\u00020LH\u0002J\b\u0010`\u001a\u00020LH\u0002J\u0016\u0010`\u001a\u00020L2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=J\u0014\u0010b\u001a\u00020L2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020L0PJ\u0018\u0010c\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010d\u001a\u00020\u0004H\u0002J\u000e\u0010e\u001a\u00020L2\u0006\u0010f\u001a\u00020gR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001c\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001a\u0010E\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001a\u0010H\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\b¨\u0006i"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "", "()V", "currentMaxVideoHeight", "", "getCurrentMaxVideoHeight", "()I", "setCurrentMaxVideoHeight", "(I)V", "currentVideoHeight", "getCurrentVideoHeight", "setCurrentVideoHeight", "currentVideoWidth", "getCurrentVideoWidth", "setCurrentVideoWidth", "currentX", "getCurrentX", "setCurrentX", "currentY", "getCurrentY", "setCurrentY", "height", "getHeight", "setHeight", "lastVideoBackGround", "getLastVideoBackGround", "setLastVideoBackGround", "maxVideoHeight", "getMaxVideoHeight", "setMaxVideoHeight", "minEdgeGap", "getMinEdgeGap", "setMinEdgeGap", "minVideoHeightWhenPause", "getMinVideoHeightWhenPause", "setMinVideoHeightWhenPause", "minVideoHeightWhenPlay", "getMinVideoHeightWhenPlay", "setMinVideoHeightWhenPlay", "newY", "getNewY", "setNewY", "positionState", "getPositionState", "setPositionState", "reportParams", "", "getReportParams", "()Ljava/lang/String;", "setReportParams", "(Ljava/lang/String;)V", "screenWidth", "getScreenWidth", "setScreenWidth", "va", "Landroid/animation/ValueAnimator;", "getVa", "()Landroid/animation/ValueAnimator;", "setVa", "(Landroid/animation/ValueAnimator;)V", "videoVideo", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoVideo", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "setVideoVideo", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "doVideoZoomAnimation", "", "zoomIn", "", "onUpdateView", "Lkotlin/Function0;", "heightZoomScroll", "absY", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "context", "Landroid/content/Context;", NativeProtocol.WEB_DIALOG_PARAMS, "", Constants.PARAM_DENSITY, "", "isZooming", "normalScroll", "onGetVideoSize", "onWebViewScrollChanged", "scrollY", "resetPositionState", "setVideoBackGroundColor", "color", "switchPlayStatus", "updatePositionByWidth", "currentWidth", "updateVideoPosition", "view", "Landroid/view/View;", "Companion", "plugin-brandservice_release"})
public final class i {
    public static final a pLd = new a((byte) 0);
    public int bEm;
    public int height;
    public int mEX;
    public int pKP;
    public int pKQ;
    public int pKR;
    public int pKS;
    public int pKT;
    public int pKU;
    public int pKV;
    public int pKW;
    public MPVideoView pKX;
    private int pKY = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    public String pKZ;
    public int pLa;
    public ValueAnimator pLb;
    private int pLc = WebView.NIGHT_MODE_COLOR;
    public int width;
    public int x;
    public int y;

    static {
        AppMethodBeat.i(175542);
        AppMethodBeat.o(175542);
    }

    public i() {
        AppMethodBeat.i(175541);
        AppMethodBeat.o(175541);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ i pLe;
        final /* synthetic */ kotlin.g.a.a pLg;

        public f(i iVar, kotlin.g.a.a aVar) {
            this.pLe = iVar;
            this.pLg = aVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(195972);
            i iVar = this.pLe;
            p.g(valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(195972);
                throw tVar;
            }
            iVar.pKR = ((Integer) animatedValue).intValue();
            if (this.pLe.pKR == this.pLe.pKU) {
                this.pLe.pKW = 0;
            }
            this.pLg.invoke();
            AppMethodBeat.o(195972);
        }
    }

    public final void b(boolean z, kotlin.g.a.a<x> aVar) {
        ValueAnimator ofInt;
        AppMethodBeat.i(175535);
        Log.v("MicroMsg.BizVideoPosHelper", "doVideoZoomAnimation zoomIn=".concat(String.valueOf(z)));
        ValueAnimator valueAnimator = this.pLb;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        if (z) {
            ofInt = ValueAnimator.ofInt(this.width, this.mEX);
        } else {
            ofInt = ValueAnimator.ofInt(this.mEX, this.width);
        }
        this.pLb = ofInt;
        this.pKT = this.bEm;
        ValueAnimator valueAnimator2 = this.pLb;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new b(this, z, aVar));
        }
        ValueAnimator valueAnimator3 = this.pLb;
        if (valueAnimator3 != null) {
            valueAnimator3.setDuration(200L);
        }
        ValueAnimator valueAnimator4 = this.pLb;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
            AppMethodBeat.o(175535);
            return;
        }
        AppMethodBeat.o(175535);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ i pLe;
        final /* synthetic */ boolean pLf;
        final /* synthetic */ kotlin.g.a.a pLg;

        b(i iVar, boolean z, kotlin.g.a.a aVar) {
            this.pLe = iVar;
            this.pLf = z;
            this.pLg = aVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(175531);
            i iVar = this.pLe;
            boolean z = this.pLf;
            p.g(valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(175531);
                throw tVar;
            }
            i.a(iVar, z, ((Integer) animatedValue).intValue());
            this.pLg.invoke();
            AppMethodBeat.o(175531);
        }
    }

    public final void DN(int i2) {
        AppMethodBeat.i(175536);
        if (cqY()) {
            AppMethodBeat.o(175536);
            return;
        }
        this.pKP = this.x;
        if (i2 < 0) {
            i2 = 0;
        }
        this.pKQ = i2;
        this.pKR = this.height;
        this.pKS = this.width;
        this.pKW = 0;
        AppMethodBeat.o(175536);
    }

    public final boolean DO(int i2) {
        MPVideoView mPVideoView;
        AppMethodBeat.i(175537);
        int mZ = j.mZ(this.bEm - i2, (this.pKX == null || (mPVideoView = this.pKX) == null || !mPVideoView.isPlaying()) ? this.pKV : this.pKU);
        if (mZ != this.pKR) {
            this.pKQ = 0;
            this.pKR = mZ;
            this.pKT = mZ;
            cqZ();
            if (!cqY()) {
                AppMethodBeat.o(175537);
                return true;
            }
            AppMethodBeat.o(175537);
            return false;
        } else if (this.pKQ != 0) {
            this.pKQ = 0;
            AppMethodBeat.o(175537);
            return true;
        } else {
            AppMethodBeat.o(175537);
            return false;
        }
    }

    public final boolean cqY() {
        return this.pKW == 1 || this.pKW == 2;
    }

    public final void dy(View view) {
        AppMethodBeat.i(175538);
        p.h(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(175538);
            throw tVar;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = this.pKR;
        marginLayoutParams.width = this.pKS;
        marginLayoutParams.leftMargin = j.mZ(this.pKP, 0);
        marginLayoutParams.topMargin = j.mZ(this.pKQ, 0);
        view.setLayoutParams(marginLayoutParams);
        AppMethodBeat.o(175538);
    }

    public final void cqZ() {
        MPVideoView mPVideoView;
        AppMethodBeat.i(175539);
        if (this.pKX == null || ((mPVideoView = this.pKX) != null && mPVideoView.getVideoWidth() == 0)) {
            AppMethodBeat.o(175539);
            return;
        }
        MPVideoView mPVideoView2 = this.pKX;
        if (mPVideoView2 == null || mPVideoView2.getVideoHeight() != 0) {
            z.d dVar = new z.d();
            dVar.SYE = WebView.NIGHT_MODE_COLOR;
            double d2 = ((double) this.pKR) * 1.0d;
            MPVideoView mPVideoView3 = this.pKX;
            if (mPVideoView3 == null) {
                p.hyc();
            }
            double videoHeight = d2 / ((double) mPVideoView3.getVideoHeight());
            MPVideoView mPVideoView4 = this.pKX;
            if (mPVideoView4 == null) {
                p.hyc();
            }
            if (Math.abs((videoHeight * ((double) mPVideoView4.getVideoWidth())) - ((double) this.pKS)) < ((double) this.pKY)) {
                MPVideoView mPVideoView5 = this.pKX;
                if (mPVideoView5 == null) {
                    p.hyc();
                }
                dVar.SYE = com.tencent.mm.cb.a.n(mPVideoView5.getContext(), R.color.afz);
            }
            if (this.pLc != dVar.SYE) {
                Log.d("MicroMsg.BizVideoPosHelper", "setVideoBackGroundColor lastVideoBackGround=" + this.pLc + ", newBackGroundColor=" + dVar.SYE);
                MMHandlerThread.postToMainThread(new e(this, dVar));
            }
            AppMethodBeat.o(175539);
            return;
        }
        AppMethodBeat.o(175539);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ i pLe;
        final /* synthetic */ z.d pLh;

        e(i iVar, z.d dVar) {
            this.pLe = iVar;
            this.pLh = dVar;
        }

        public final void run() {
            AppMethodBeat.i(175534);
            i iVar = this.pLe;
            int i2 = this.pLh.SYE;
            MPVideoView mPVideoView = this.pLe.pKX;
            if (mPVideoView == null) {
                p.hyc();
            }
            iVar.a(i2, mPVideoView);
            AppMethodBeat.o(175534);
        }
    }

    public final void a(int i2, MPVideoView mPVideoView) {
        AppMethodBeat.i(175540);
        p.h(mPVideoView, "videoVideo");
        mPVideoView.setBackgroundColor(i2);
        this.pLc = i2;
        AppMethodBeat.o(175540);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper$Companion;", "", "()V", "TAG", "", "posStateDefault", "", "posStateZoomIn", "posStateZoomOut", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.a pLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(kotlin.g.a.a aVar) {
            super(0);
            this.pLg = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(175532);
            this.pLg.invoke();
            x xVar = x.SXb;
            AppMethodBeat.o(175532);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.a pLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(kotlin.g.a.a aVar) {
            super(0);
            this.pLg = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(175533);
            this.pLg.invoke();
            x xVar = x.SXb;
            AppMethodBeat.o(175533);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(i iVar, boolean z, int i2) {
        AppMethodBeat.i(175543);
        iVar.pKS = i2;
        iVar.pKQ = iVar.pLa >= 0 ? iVar.pLa : 0;
        if (iVar.pKS == iVar.mEX) {
            iVar.pKP = 0;
            iVar.pKR = iVar.pKT;
        } else {
            iVar.pKP = iVar.x - ((iVar.pKS - iVar.width) / 2);
            iVar.pKR = j.na((int) (((((float) iVar.pKS) * 1.0f) / ((float) iVar.width)) * ((float) iVar.height)), iVar.pKT);
        }
        if (!z || iVar.pKS != iVar.mEX) {
            if (!z && iVar.pKS == iVar.width) {
                iVar.pKW = 0;
            }
            AppMethodBeat.o(175543);
            return;
        }
        iVar.pKW = 0;
        AppMethodBeat.o(175543);
    }
}
