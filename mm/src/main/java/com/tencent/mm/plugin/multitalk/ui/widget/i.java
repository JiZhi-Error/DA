package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 T2\u00020\u0001:\u0001TB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u001c2\b\u0010?\u001a\u0004\u0018\u00010,2\u0006\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020.H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001cH\u0002J\u000e\u0010E\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u001cJ \u0010F\u001a\u00020C2\b\u0010?\u001a\u0004\u0018\u00010,2\u0006\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020.J\b\u0010G\u001a\u00020CH\u0002J(\u0010H\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u001c2\b\u0010I\u001a\u0004\u0018\u00010,2\u0006\u0010A\u001a\u00020.2\u0006\u0010@\u001a\u00020.J\b\u0010J\u001a\u0004\u0018\u000103J\u0006\u0010K\u001a\u00020CJ\u000e\u0010L\u001a\u00020C2\u0006\u00107\u001a\u00020.J\u0006\u0010M\u001a\u00020CJ\u0006\u0010N\u001a\u00020CJ\u000e\u0010O\u001a\u00020C2\u0006\u0010P\u001a\u00020\u0013J\u0006\u0010Q\u001a\u00020CJ\u000e\u0010R\u001a\u00020C2\u0006\u0010S\u001a\u00020.R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010'\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u000e\u0010*\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u0010\u0004R,\u00107\u001a\u0004\u0018\u00010.2\b\u0010\u001b\u001a\u0004\u0018\u00010.8F@FX\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006U"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVideoView;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "animationView", "Landroid/widget/ImageView;", "contentView", "context", "Landroid/content/Context;", "detailShadow", "detailTv", "Landroid/widget/TextView;", "drawPaint", "Landroid/graphics/Paint;", "fullIconLayout", "fullLayout", "fullTextTv", "isDoingAnimationChange", "", "lastRenderSwitchTick", "", "getLastRenderSwitchTick", "()Ljava/lang/Long;", "setLastRenderSwitchTick", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "value", "", "mCurrentRenderUser", "getMCurrentRenderUser", "()Ljava/lang/String;", "setMCurrentRenderUser", "(Ljava/lang/String;)V", "mCurrentRenderVideo", "getMCurrentRenderVideo", "()Z", "setMCurrentRenderVideo", "(Z)V", "mCurrentShowUser", "getMCurrentShowUser", "setMCurrentShowUser", "mLastVideoData", "mPrevBitmap", "Landroid/graphics/Bitmap;", "mPrevBitmapAngle", "", "mPrevBitmapMirror", "radius", "", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "getRootView", "()Landroid/view/View;", "setRootView", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "changeRenderAnimation", "userName", "bitmap", "angle", "mirror", "changeRenderUser", "", "name", "drawAvatar", "drawBitmap", "drawPrevBitmap", "drawVideo", "img", "getRenderSurface", "hideOther", "hideView", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "release", "setVoicePlayDevice", "device", "Companion", "plugin-multitalk_release"})
public final class i {
    public static final a zTo = new a((byte) 0);
    View contentView = this.lJI.findViewById(R.id.fod);
    Context context;
    View lJI;
    private Paint qvj;
    private final float radius = ((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12));
    TextView zSY;
    private VoIPRenderTextureView zSZ;
    ImageView zTa;
    private View zTb;
    View zTc;
    ImageView zTd;
    TextView zTe;
    boolean zTf;
    String zTg;
    String zTh;
    Long zTi;
    private Bitmap zTj;
    private int zTk;
    private int zTl;
    private long zTm;
    private boolean zTn;

    static {
        AppMethodBeat.i(239800);
        AppMethodBeat.o(239800);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVideoView$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public i(View view) {
        p.h(view, "rootView");
        AppMethodBeat.i(239799);
        this.lJI = view;
        View view2 = this.contentView;
        if (view2 != null) {
            view2.setClipToOutline(true);
        }
        View view3 = this.contentView;
        if (view3 != null) {
            view3.setOutlineProvider(new e(this.radius));
        }
        this.zSY = (TextView) this.lJI.findViewById(R.id.fpd);
        this.zTb = this.lJI.findViewById(R.id.xb);
        this.context = this.lJI.getContext();
        this.zSZ = (VoIPRenderTextureView) this.lJI.findViewById(R.id.fp7);
        VoIPRenderTextureView voIPRenderTextureView = this.zSZ;
        if (voIPRenderTextureView != null) {
            voIPRenderTextureView.setClipToOutline(true);
        }
        VoIPRenderTextureView voIPRenderTextureView2 = this.zSZ;
        if (voIPRenderTextureView2 != null) {
            voIPRenderTextureView2.setOutlineProvider(new e(this.radius));
        }
        this.zTa = (ImageView) this.lJI.findViewById(R.id.fp6);
        ImageView imageView = this.zTa;
        if (imageView != null) {
            imageView.setClipToOutline(true);
        }
        ImageView imageView2 = this.zTa;
        if (imageView2 != null) {
            imageView2.setOutlineProvider(new e(this.radius));
        }
        this.qvj = new Paint();
        Paint paint = this.qvj;
        if (paint != null) {
            paint.setColor(WebView.NIGHT_MODE_COLOR);
        }
        Paint paint2 = this.qvj;
        if (paint2 != null) {
            paint2.setFilterBitmap(false);
        }
        Paint paint3 = this.qvj;
        if (paint3 != null) {
            paint3.setTextSize(40.0f);
        }
        this.zTc = this.lJI.findViewById(R.id.jbb);
        View view4 = this.zTc;
        if (view4 != null) {
            view4.setClipToOutline(true);
        }
        View view5 = this.zTc;
        if (view5 != null) {
            view5.setOutlineProvider(new e(this.radius));
        }
        this.zTd = (ImageView) this.lJI.findViewById(R.id.fon);
        this.zTe = (TextView) this.lJI.findViewById(R.id.foo);
        this.zTm = -1;
        AppMethodBeat.o(239799);
    }

    public final void aGs(String str) {
        Long l = null;
        AppMethodBeat.i(239791);
        if (str == null) {
            this.zTj = null;
            this.zTl = -1;
            this.zTk = -1;
        } else {
            l = Long.valueOf(Util.currentTicks());
        }
        this.zTi = l;
        this.zTg = str;
        AppMethodBeat.o(239791);
    }

    public final void aGt(String str) {
        AppMethodBeat.i(239792);
        aGs(str);
        this.zTh = str;
        AppMethodBeat.o(239792);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ String naX;
        final /* synthetic */ i zTp;

        c(i iVar, String str) {
            this.zTp = iVar;
            this.naX = str;
        }

        public final void run() {
            AppMethodBeat.i(239790);
            View view = this.zTp.zTb;
            if (view != null) {
                view.setVisibility(0);
            }
            TextView textView = this.zTp.zSY;
            if (textView != null) {
                textView.setTextSize(1, 10.0f);
            }
            TextView textView2 = this.zTp.zSY;
            if (textView2 != null) {
                com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(this.naX);
                p.g(Kn, "MMKernel.service(IMessen…ss.java).contactStg[name]");
                textView2.setText(Kn.getNickname());
            }
            View view2 = this.zTp.lJI;
            StringBuilder sb = new StringBuilder();
            Context context = this.zTp.context;
            StringBuilder append = sb.append(String.valueOf(context != null ? context.getString(R.string.b3_) : null)).append(",");
            com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().Kn(this.naX);
            p.g(Kn2, "MMKernel.service(IMessen…ss.java).contactStg[name]");
            view2.setContentDescription(append.append(Kn2.getNickname()).toString());
            if (!p.j(this.zTp.zTh, this.naX)) {
                this.zTp.aGt(this.naX);
                this.zTp.zTi = Long.valueOf(Util.currentTicks());
            }
            AppMethodBeat.o(239790);
        }
    }

    private final void aGu(String str) {
        AppMethodBeat.i(239793);
        h.RTc.aV(new c(this, str));
        AppMethodBeat.o(239793);
    }

    public final synchronized void f(Bitmap bitmap, int i2, int i3) {
        Canvas canvas = null;
        synchronized (this) {
            AppMethodBeat.i(239794);
            if (bitmap == null || bitmap.isRecycled()) {
                Log.e("MicroMsg.MultiTalkMiniVideoView", "DrawBitmap, bitmap is null or recycled");
                com.tencent.mm.plugin.multitalk.model.p.emX();
                AppMethodBeat.o(239794);
            } else {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (this.zSZ == null) {
                    AppMethodBeat.o(239794);
                } else {
                    VoIPRenderTextureView voIPRenderTextureView = this.zSZ;
                    if (voIPRenderTextureView != null) {
                        canvas = voIPRenderTextureView.lockCanvas(null);
                    }
                    if (canvas == null) {
                        Log.e("MicroMsg.MultiTalkMiniVideoView", "getCanvasError");
                        AppMethodBeat.o(239794);
                    } else {
                        Matrix matrix = new Matrix();
                        if (i2 == OpenGlRender.FLAG_Angle270) {
                            matrix.setRotate(270.0f, ((float) width) / 2.0f, ((float) height) / 2.0f);
                        } else if (i2 == OpenGlRender.FLAG_Angle90) {
                            matrix.setRotate(90.0f, ((float) width) / 2.0f, ((float) height) / 2.0f);
                        }
                        if (i3 == OpenGlRender.FLAG_Mirror) {
                            matrix.postScale(-1.0f, 1.0f);
                            matrix.postTranslate((float) width, 0.0f);
                        }
                        matrix.postScale(((float) canvas.getWidth()) / ((float) height), ((float) canvas.getHeight()) / ((float) width));
                        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        if (!bitmap.isRecycled()) {
                            try {
                                canvas.drawBitmap(bitmap, matrix, this.qvj);
                                this.zTk = i2;
                                this.zTl = i3;
                                this.zTj = bitmap;
                            } catch (Exception e2) {
                                Log.e("MicroMsg.MultiTalkMiniVideoView", "draw bitmap error");
                            }
                        }
                        try {
                            VoIPRenderTextureView voIPRenderTextureView2 = this.zSZ;
                            if (voIPRenderTextureView2 != null) {
                                voIPRenderTextureView2.unlockCanvasAndPost(canvas);
                                AppMethodBeat.o(239794);
                            } else {
                                AppMethodBeat.o(239794);
                            }
                        } catch (Exception e3) {
                            Log.printErrStackTrace("MicroMsg.MultiTalkMiniVideoView", e3, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                            AppMethodBeat.o(239794);
                        }
                    }
                }
            }
        }
    }

    public final synchronized boolean b(String str, Bitmap bitmap, int i2, int i3) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(239795);
            p.h(str, "userName");
            if (this.zSZ == null) {
                Log.e("MicroMsg.MultiTalkMiniVideoView", "drawVideo view is null");
                AppMethodBeat.o(239795);
            } else if (bitmap == null) {
                Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img is null");
                AppMethodBeat.o(239795);
            } else if (this.zTn) {
                Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img false cause isDoingAnimationChange");
                AppMethodBeat.o(239795);
            } else if (!c(str, bitmap, i3, i2)) {
                f(bitmap, i3, i2);
                this.zTm = Util.currentTicks();
                aGu(str);
                this.zTf = true;
                AppMethodBeat.o(239795);
                z = true;
            } else {
                AppMethodBeat.o(239795);
                z = true;
            }
        }
        return z;
    }

    private final boolean c(String str, Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(239796);
        if (!(!p.j(this.zTh, str)) || this.zTj == null || this.zSZ == null) {
            AppMethodBeat.o(239796);
            return false;
        }
        h.RTc.aV(new b(this, bitmap, i2, i3, str));
        AppMethodBeat.o(239796);
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ String jDi;
        final /* synthetic */ i zTp;
        final /* synthetic */ int zTq;
        final /* synthetic */ int zTr;

        b(i iVar, Bitmap bitmap, int i2, int i3, String str) {
            this.zTp = iVar;
            this.cKG = bitmap;
            this.zTq = i2;
            this.zTr = i3;
            this.jDi = str;
        }

        public final void run() {
            ViewPropertyAnimator animate;
            ViewPropertyAnimator duration;
            ViewPropertyAnimator alpha;
            AppMethodBeat.i(239789);
            ImageView imageView = this.zTp.zTa;
            if (imageView != null) {
                imageView.setAlpha(1.0f);
            }
            i.e(this.zTp);
            ImageView imageView2 = this.zTp.zTa;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.zTp.zTa;
            if (imageView3 != null) {
                imageView3.clearAnimation();
            }
            ImageView imageView4 = this.zTp.zTa;
            if (imageView4 == null || (animate = imageView4.animate()) == null || (duration = animate.setDuration(300)) == null || (alpha = duration.alpha(0.0f)) == null) {
                AppMethodBeat.o(239789);
                return;
            }
            alpha.setListener(new Animator.AnimatorListener(this) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.i.b.AnonymousClass1 */
                final /* synthetic */ b zTs;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.zTs = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(239787);
                    ImageView imageView = this.zTs.zTp.zTa;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    TextView textView = this.zTs.zTp.zSY;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    this.zTs.zTp.zTn = false;
                    AppMethodBeat.o(239787);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(239788);
                    this.zTs.zTp.f(this.zTs.cKG, this.zTs.zTq, this.zTs.zTr);
                    TextView textView = this.zTs.zTp.zSY;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    TextView textView2 = this.zTs.zTp.zSY;
                    if (textView2 != null) {
                        textView2.setTextSize(1, 10.0f);
                    }
                    TextView textView3 = this.zTs.zTp.zSY;
                    if (textView3 != null) {
                        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(this.zTs.jDi);
                        p.g(Kn, "MMKernel.service(IMessen…ava).contactStg[userName]");
                        textView3.setText(Kn.getNickname());
                    }
                    View view = this.zTs.zTp.lJI;
                    StringBuilder sb = new StringBuilder();
                    Context context = this.zTs.zTp.context;
                    StringBuilder append = sb.append(String.valueOf(context != null ? context.getString(R.string.b3_) : null)).append(",");
                    com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
                    as Kn2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().Kn(this.zTs.jDi);
                    p.g(Kn2, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    view.setContentDescription(append.append(Kn2.getNickname()).toString());
                    this.zTs.zTp.aGt(this.zTs.jDi);
                    this.zTs.zTp.zTn = true;
                    AppMethodBeat.o(239788);
                }
            });
            AppMethodBeat.o(239789);
        }
    }

    public final synchronized boolean aGv(String str) {
        int i2 = 0;
        r0 = false;
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(239797);
            p.h(str, "userName");
            if (this.zSZ == null) {
                Log.e("MicroMsg.MultiTalkMiniVideoView", "drawAvatar view is null");
                AppMethodBeat.o(239797);
            } else if (this.zTn) {
                Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img false cause isDoingAnimationChange");
                AppMethodBeat.o(239797);
            } else {
                j.a gov = a.b.gov();
                VoIPRenderTextureView voIPRenderTextureView = this.zSZ;
                int measuredWidth = voIPRenderTextureView != null ? voIPRenderTextureView.getMeasuredWidth() : 0;
                VoIPRenderTextureView voIPRenderTextureView2 = this.zSZ;
                if (voIPRenderTextureView2 != null) {
                    i2 = voIPRenderTextureView2.getMeasuredHeight();
                }
                Bitmap a2 = gov.a(str, measuredWidth, i2, 1);
                if (a2 != null && a2.getHeight() < a2.getWidth()) {
                    a2 = Bitmap.createBitmap(a2, 0, 0, a2.getHeight(), a2.getHeight());
                }
                if (a2 != null) {
                    if (!c(str, a2, 0, 0)) {
                        f(a2, 0, 0);
                        aGu(str);
                        this.zTf = false;
                    }
                    AppMethodBeat.o(239797);
                    z = true;
                } else {
                    Context context2 = MMApplicationContext.getContext();
                    p.g(context2, "MMApplicationContext.getContext()");
                    Bitmap decodeResource = com.tencent.mm.compatible.f.a.decodeResource(context2.getResources(), R.raw.default_avatar);
                    if (!c(str, a2, 0, 0)) {
                        f(decodeResource, 0, 0);
                        aGu(str);
                        this.zTf = false;
                    }
                    AppMethodBeat.o(239797);
                    z = true;
                }
            }
        }
        return z;
    }

    public final void H(int i2) {
        AppMethodBeat.i(239798);
        View view = this.zTb;
        if (view != null) {
            view.setVisibility(i2);
            AppMethodBeat.o(239798);
            return;
        }
        AppMethodBeat.o(239798);
    }

    public static final /* synthetic */ void e(i iVar) {
        AppMethodBeat.i(239801);
        if (iVar.zTj != null) {
            Bitmap bitmap = iVar.zTj;
            if (bitmap == null) {
                p.hyc();
            }
            int width = bitmap.getWidth();
            Bitmap bitmap2 = iVar.zTj;
            if (bitmap2 == null) {
                p.hyc();
            }
            int height = bitmap2.getHeight();
            VoIPRenderTextureView voIPRenderTextureView = iVar.zSZ;
            if (voIPRenderTextureView == null) {
                p.hyc();
            }
            int measuredWidth = voIPRenderTextureView.getMeasuredWidth();
            VoIPRenderTextureView voIPRenderTextureView2 = iVar.zSZ;
            if (voIPRenderTextureView2 == null) {
                p.hyc();
            }
            Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, voIPRenderTextureView2.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            if (createBitmap == null) {
                p.hyc();
            }
            Canvas canvas = new Canvas(createBitmap);
            Matrix matrix = new Matrix();
            if (iVar.zTk == OpenGlRender.FLAG_Angle270) {
                matrix.setRotate(270.0f, ((float) width) / 2.0f, ((float) height) / 2.0f);
            } else if (iVar.zTk == OpenGlRender.FLAG_Angle90) {
                matrix.setRotate(90.0f, ((float) width) / 2.0f, ((float) height) / 2.0f);
            }
            if (iVar.zTl == OpenGlRender.FLAG_Mirror) {
                matrix.postScale(-1.0f, 1.0f);
                matrix.postTranslate((float) width, 0.0f);
            }
            matrix.postScale(((float) canvas.getWidth()) / ((float) height), ((float) canvas.getHeight()) / ((float) width));
            Bitmap bitmap3 = iVar.zTj;
            if (bitmap3 == null) {
                p.hyc();
            }
            canvas.drawBitmap(bitmap3, matrix, iVar.qvj);
            ImageView imageView = iVar.zTa;
            if (imageView != null) {
                imageView.setImageBitmap(createBitmap);
                AppMethodBeat.o(239801);
                return;
            }
        }
        AppMethodBeat.o(239801);
    }
}
