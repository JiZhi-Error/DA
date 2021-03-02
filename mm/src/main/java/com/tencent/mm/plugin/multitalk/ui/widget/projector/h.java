package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u0000 b2\u00020\u0001:\u0001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020,J\u0010\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u001cH\u0002J2\u0010Q\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u001c2\b\u0010R\u001a\u0004\u0018\u00010&2\u0006\u0010S\u001a\u00020,2\u0006\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020,H\u0002J\u0010\u0010V\u001a\u00020M2\u0006\u0010W\u001a\u00020\u001cH\u0002J\u0006\u0010X\u001a\u00020MJ\u0006\u0010Y\u001a\u00020MJ\u000e\u0010Z\u001a\u00020M2\u0006\u0010[\u001a\u00020\u0012J\u000e\u0010\\\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u001cJ(\u0010]\u001a\u00020M2\b\u0010R\u001a\u0004\u0018\u00010&2\u0006\u0010S\u001a\u00020,2\u0006\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020,J\u0006\u0010^\u001a\u00020MJ(\u0010_\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u001c2\b\u0010`\u001a\u0004\u0018\u00010&2\u0006\u0010T\u001a\u00020,2\u0006\u0010S\u001a\u00020,J\u0006\u0010a\u001a\u00020MR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER,\u0010F\u001a\u0004\u0018\u00010,2\b\u0010\u001b\u001a\u0004\u0018\u00010,8F@FX\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006c"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "", "rootView", "Landroid/widget/RelativeLayout;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "context", "Landroid/content/Context;", "drawPaint", "Landroid/graphics/Paint;", "isDoingAnimationChange", "", "lastRenderSwitchTick", "", "getLastRenderSwitchTick", "()Ljava/lang/Long;", "setLastRenderSwitchTick", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mContentView", "value", "", "mCurrentRenderUser", "getMCurrentRenderUser", "()Ljava/lang/String;", "setMCurrentRenderUser", "(Ljava/lang/String;)V", "mCurrentShowUser", "getMCurrentShowUser", "setMCurrentShowUser", "mPrevBitmap", "Landroid/graphics/Bitmap;", "getMPrevBitmap", "()Landroid/graphics/Bitmap;", "setMPrevBitmap", "(Landroid/graphics/Bitmap;)V", "mPrevBitmapAngle", "", "mPrevBitmapMirror", "mPrevTarget", "getMPrevTarget", "()I", "setMPrevTarget", "(I)V", "mVoiceIv", "mVoiceRoot", "Landroid/view/View;", "radius", "", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "getRenderView", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "setRenderView", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;)V", "getRootView", "()Landroid/widget/RelativeLayout;", "setRootView", "(Landroid/widget/RelativeLayout;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "applyOrientation", "", "orientation", "changeRenderToAvatarAnimation", "userName", "changeRenderToVideoAnimation", "bitmap", "angle", "mirror", "target", "changeRenderUser", "name", "doAnimationHide", "doAnimationShow", "doShowOrHideSpeakerVoice", "show", "drawAvatar", "drawBitmap", "drawPrevBitmap", "drawVideo", "img", "resetLayoutCauseDoodle", "Companion", "plugin-multitalk_release"})
public final class h {
    public static final a zWv = new a((byte) 0);
    private Context context = this.zWu.getContext();
    ImageView jWS;
    private Paint qvj;
    private final float radius = ((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2));
    private a zQD;
    VoIPRenderTextureView zSZ;
    String zTg;
    String zTh;
    Long zTi;
    private Bitmap zTj;
    private int zTk;
    private int zTl;
    private boolean zTn;
    private int zWq;
    private ImageView zWr;
    private View zWs;
    private RelativeLayout zWt;
    RelativeLayout zWu;

    static {
        AppMethodBeat.i(239989);
        AppMethodBeat.o(239989);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public h(RelativeLayout relativeLayout, a aVar) {
        ImageView imageView;
        ImageView imageView2;
        View view = null;
        p.h(relativeLayout, "rootView");
        p.h(aVar, "statusManager");
        AppMethodBeat.i(239988);
        this.zWu = relativeLayout;
        this.zQD = aVar;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.bcz, this.zWu);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(239988);
            throw tVar;
        }
        this.zWt = (RelativeLayout) inflate;
        RelativeLayout relativeLayout2 = this.zWt;
        if (relativeLayout2 != null) {
            relativeLayout2.setClipToOutline(true);
        }
        RelativeLayout relativeLayout3 = this.zWt;
        if (relativeLayout3 != null) {
            relativeLayout3.setOutlineProvider(new com.tencent.mm.plugin.voip.ui.e(this.radius));
        }
        RelativeLayout relativeLayout4 = this.zWt;
        this.zSZ = relativeLayout4 != null ? (VoIPRenderTextureView) relativeLayout4.findViewById(R.id.fp7) : null;
        VoIPRenderTextureView voIPRenderTextureView = this.zSZ;
        if (voIPRenderTextureView != null) {
            voIPRenderTextureView.setClipToOutline(true);
        }
        VoIPRenderTextureView voIPRenderTextureView2 = this.zSZ;
        if (voIPRenderTextureView2 != null) {
            voIPRenderTextureView2.setOutlineProvider(new com.tencent.mm.plugin.voip.ui.e(this.radius));
        }
        this.qvj = new Paint();
        Paint paint = this.qvj;
        if (paint != null) {
            paint.setColor(WebView.NIGHT_MODE_COLOR);
        }
        Paint paint2 = this.qvj;
        if (paint2 != null) {
            paint2.setFilterBitmap(true);
        }
        Paint paint3 = this.qvj;
        if (paint3 != null) {
            paint3.setTextSize(40.0f);
        }
        RelativeLayout relativeLayout5 = this.zWt;
        if (relativeLayout5 != null) {
            imageView = (ImageView) relativeLayout5.findViewById(R.id.wx);
        } else {
            imageView = null;
        }
        this.jWS = imageView;
        RelativeLayout relativeLayout6 = this.zWt;
        if (relativeLayout6 != null) {
            imageView2 = (ImageView) relativeLayout6.findViewById(R.id.j9s);
        } else {
            imageView2 = null;
        }
        this.zWr = imageView2;
        RelativeLayout relativeLayout7 = this.zWt;
        this.zWs = relativeLayout7 != null ? relativeLayout7.findViewById(R.id.j9t) : view;
        AppMethodBeat.o(239988);
    }

    public final Integer eoH() {
        AppMethodBeat.i(239976);
        Integer valueOf = Integer.valueOf(this.zWu.getVisibility());
        AppMethodBeat.o(239976);
        return valueOf;
    }

    public final void aGs(String str) {
        Long l = null;
        AppMethodBeat.i(239977);
        if (str == null) {
            this.zTj = null;
            this.zTl = -1;
            this.zTk = -1;
        } else {
            l = Long.valueOf(Util.currentTicks());
        }
        this.zTi = l;
        this.zTg = str;
        AppMethodBeat.o(239977);
    }

    public final void aGt(String str) {
        AppMethodBeat.i(239978);
        aGs(str);
        this.zTh = str;
        AppMethodBeat.o(239978);
    }

    public final synchronized void g(Bitmap bitmap, int i2, int i3) {
        Canvas canvas = null;
        synchronized (this) {
            AppMethodBeat.i(239979);
            if (bitmap == null || bitmap.isRecycled()) {
                Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "DrawBitmap, bitmap is null or recycled");
                com.tencent.mm.plugin.multitalk.model.p.emX();
                AppMethodBeat.o(239979);
            } else {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (this.zSZ == null) {
                    AppMethodBeat.o(239979);
                } else {
                    VoIPRenderTextureView voIPRenderTextureView = this.zSZ;
                    if (voIPRenderTextureView != null) {
                        canvas = voIPRenderTextureView.lockCanvas(null);
                    }
                    if (canvas == null) {
                        Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "getCanvasError");
                        AppMethodBeat.o(239979);
                    } else {
                        Matrix matrix = new Matrix();
                        int epf = this.zQD.epf();
                        if (epf == 90 || epf == 270) {
                            if (i2 == OpenGlRender.FLAG_Angle270) {
                                matrix.setRotate(-90.0f, ((float) width) / 2.0f, ((float) height) / 2.0f);
                            } else if (i2 == OpenGlRender.FLAG_Angle90) {
                                matrix.setRotate(-270.0f, ((float) width) / 2.0f, ((float) height) / 2.0f);
                            }
                        } else if (i2 == OpenGlRender.FLAG_Angle270) {
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
                                this.zWq = 1;
                            } catch (Exception e2) {
                                Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "draw bitmap error");
                            }
                        }
                        try {
                            VoIPRenderTextureView voIPRenderTextureView2 = this.zSZ;
                            if (voIPRenderTextureView2 != null) {
                                voIPRenderTextureView2.unlockCanvasAndPost(canvas);
                                AppMethodBeat.o(239979);
                            } else {
                                AppMethodBeat.o(239979);
                            }
                        } catch (Exception e3) {
                            Log.printErrStackTrace("MicroMsg.ScreenProjectAvatarCellLayout", e3, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                            AppMethodBeat.o(239979);
                        }
                    }
                }
            }
        }
    }

    public final synchronized boolean b(String str, Bitmap bitmap, int i2, int i3) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(239980);
            p.h(str, "userName");
            if (this.zSZ == null) {
                Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "drawVideo view is null");
                AppMethodBeat.o(239980);
            } else if (bitmap == null) {
                Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img is null");
                AppMethodBeat.o(239980);
            } else if (this.zTn) {
                Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img false cause isDoingAnimationChange");
                AppMethodBeat.o(239980);
            } else {
                Log.i("MicroMsg.ScreenProjectAvatarCellLayout", "changeRenderAnimation %s and target is %s", str, 1);
                if (!(!(!p.j(this.zTh, str)) || this.zSZ == null || this.zWq == 1)) {
                    aGt(str);
                    this.zTn = true;
                    com.tencent.f.h.RTc.aV(new c(this, str, bitmap, i3, i2));
                    z = true;
                }
                if (!z) {
                    ImageView imageView = this.jWS;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    VoIPRenderTextureView voIPRenderTextureView = this.zSZ;
                    if (voIPRenderTextureView != null) {
                        voIPRenderTextureView.setVisibility(0);
                    }
                    g(bitmap, i3, i2);
                    aGu(str);
                    AppMethodBeat.o(239980);
                    z = true;
                } else {
                    AppMethodBeat.o(239980);
                    z = true;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ String jDi;
        final /* synthetic */ int zTq;
        final /* synthetic */ int zTr;
        final /* synthetic */ h zWw;

        c(h hVar, String str, Bitmap bitmap, int i2, int i3) {
            this.zWw = hVar;
            this.jDi = str;
            this.cKG = bitmap;
            this.zTq = i2;
            this.zTr = i3;
        }

        public final void run() {
            ViewPropertyAnimator animate;
            ViewPropertyAnimator alpha;
            ViewPropertyAnimator duration;
            ViewPropertyAnimator listener;
            ViewPropertyAnimator withStartAction;
            AppMethodBeat.i(239972);
            ImageView imageView = this.zWw.jWS;
            if (!(imageView == null || (animate = imageView.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(300)) == null || (listener = duration.setListener(new Animator.AnimatorListener(this) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.projector.h.c.AnonymousClass1 */
                final /* synthetic */ c zWy;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.zWy = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(239969);
                    ImageView imageView = this.zWy.zWw.jWS;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    this.zWy.zWw.zTn = false;
                    VoIPRenderTextureView voIPRenderTextureView = this.zWy.zWw.zSZ;
                    if (voIPRenderTextureView != null) {
                        voIPRenderTextureView.setAlpha(1.0f);
                    }
                    VoIPRenderTextureView voIPRenderTextureView2 = this.zWy.zWw.zSZ;
                    if (voIPRenderTextureView2 != null) {
                        voIPRenderTextureView2.setVisibility(0);
                        AppMethodBeat.o(239969);
                        return;
                    }
                    AppMethodBeat.o(239969);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(239970);
                    RelativeLayout relativeLayout = this.zWy.zWw.zWu;
                    StringBuilder sb = new StringBuilder();
                    Context context = this.zWy.zWw.context;
                    StringBuilder append = sb.append(String.valueOf(context != null ? context.getString(R.string.b3_) : null)).append(",");
                    com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                    as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(this.zWy.jDi);
                    p.g(Kn, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    relativeLayout.setContentDescription(append.append(Kn.getNickname()).toString());
                    AppMethodBeat.o(239970);
                }
            })) == null || (withStartAction = listener.withStartAction(new Runnable(this) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.projector.h.c.AnonymousClass2 */
                final /* synthetic */ c zWy;

                {
                    this.zWy = r1;
                }

                public final void run() {
                    ViewPropertyAnimator animate;
                    ViewPropertyAnimator alpha;
                    ViewPropertyAnimator duration;
                    AppMethodBeat.i(239971);
                    VoIPRenderTextureView voIPRenderTextureView = this.zWy.zWw.zSZ;
                    if (voIPRenderTextureView != null) {
                        voIPRenderTextureView.setAlpha(0.0f);
                    }
                    VoIPRenderTextureView voIPRenderTextureView2 = this.zWy.zWw.zSZ;
                    if (voIPRenderTextureView2 == null || (animate = voIPRenderTextureView2.animate()) == null || (alpha = animate.alpha(1.0f)) == null || (duration = alpha.setDuration(300)) == null) {
                        AppMethodBeat.o(239971);
                        return;
                    }
                    duration.start();
                    AppMethodBeat.o(239971);
                }
            })) == null)) {
                withStartAction.start();
            }
            this.zWw.g(this.cKG, this.zTq, this.zTr);
            AppMethodBeat.o(239972);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ String jDi;
        final /* synthetic */ h zWw;

        b(h hVar, String str) {
            this.zWw = hVar;
            this.jDi = str;
        }

        public final void run() {
            ViewPropertyAnimator animate;
            ViewPropertyAnimator alpha;
            ViewPropertyAnimator duration;
            ViewPropertyAnimator listener;
            AppMethodBeat.i(239968);
            VoIPRenderTextureView voIPRenderTextureView = this.zWw.zSZ;
            if (voIPRenderTextureView == null || (animate = voIPRenderTextureView.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(300)) == null || (listener = duration.setListener(new Animator.AnimatorListener(this) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.projector.h.b.AnonymousClass1 */
                final /* synthetic */ b zWx;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.zWx = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(239965);
                    VoIPRenderTextureView voIPRenderTextureView = this.zWx.zWw.zSZ;
                    if (voIPRenderTextureView != null) {
                        voIPRenderTextureView.setVisibility(8);
                    }
                    this.zWx.zWw.zTn = false;
                    ImageView imageView = this.zWx.zWw.jWS;
                    if (imageView != null) {
                        imageView.setAlpha(1.0f);
                    }
                    ImageView imageView2 = this.zWx.zWw.jWS;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                        AppMethodBeat.o(239965);
                        return;
                    }
                    AppMethodBeat.o(239965);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(239966);
                    RelativeLayout relativeLayout = this.zWx.zWw.zWu;
                    StringBuilder sb = new StringBuilder();
                    Context context = this.zWx.zWw.context;
                    StringBuilder append = sb.append(String.valueOf(context != null ? context.getString(R.string.b3_) : null)).append(",");
                    com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                    as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(this.zWx.jDi);
                    p.g(Kn, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    relativeLayout.setContentDescription(append.append(Kn.getNickname()).toString());
                    AppMethodBeat.o(239966);
                }
            })) == null) {
                AppMethodBeat.o(239968);
                return;
            }
            listener.withStartAction(new Runnable(this) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.projector.h.b.AnonymousClass2 */
                final /* synthetic */ b zWx;

                {
                    this.zWx = r1;
                }

                public final void run() {
                    ViewPropertyAnimator animate;
                    ViewPropertyAnimator alpha;
                    AppMethodBeat.i(239967);
                    ImageView imageView = this.zWx.zWw.jWS;
                    if (imageView != null) {
                        imageView.setAlpha(0.0f);
                    }
                    ImageView imageView2 = this.zWx.zWw.jWS;
                    if (imageView2 == null || (animate = imageView2.animate()) == null || (alpha = animate.alpha(1.0f)) == null) {
                        AppMethodBeat.o(239967);
                        return;
                    }
                    alpha.setDuration(300);
                    AppMethodBeat.o(239967);
                }
            });
            AppMethodBeat.o(239968);
        }
    }

    public final synchronized boolean aGv(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(239981);
            p.h(str, "userName");
            if (this.zSZ == null) {
                Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "drawAvatar view is null");
                AppMethodBeat.o(239981);
            } else if (this.zTn) {
                Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img false cause isDoingAnimationChange");
                AppMethodBeat.o(239981);
            } else {
                a.b.y(this.jWS, str);
                Log.i("MicroMsg.ScreenProjectAvatarCellLayout", "changeRenderAnimation %s ", str);
                if (!(!(!p.j(this.zTh, str)) || this.zSZ == null || this.zWq == 0)) {
                    aGt(str);
                    this.zTn = true;
                    com.tencent.f.h.RTc.aV(new b(this, str));
                    this.zWq = 0;
                    z = true;
                }
                if (!z) {
                    ImageView imageView = this.jWS;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    VoIPRenderTextureView voIPRenderTextureView = this.zSZ;
                    if (voIPRenderTextureView != null) {
                        voIPRenderTextureView.setVisibility(8);
                    }
                    aGu(str);
                }
                AppMethodBeat.o(239981);
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ String naX;
        final /* synthetic */ h zWw;

        d(h hVar, String str) {
            this.zWw = hVar;
            this.naX = str;
        }

        public final void run() {
            AppMethodBeat.i(239973);
            RelativeLayout relativeLayout = this.zWw.zWu;
            StringBuilder sb = new StringBuilder();
            Context context = this.zWw.context;
            StringBuilder append = sb.append(String.valueOf(context != null ? context.getString(R.string.b3_) : null)).append(",");
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(this.naX);
            p.g(Kn, "MMKernel.service(IMessen…ss.java).contactStg[name]");
            relativeLayout.setContentDescription(append.append(Kn.getNickname()).toString());
            if (!p.j(this.zWw.zTh, this.naX)) {
                this.zWw.aGt(this.naX);
                this.zWw.zTi = Long.valueOf(Util.currentTicks());
            }
            AppMethodBeat.o(239973);
        }
    }

    private final void aGu(String str) {
        AppMethodBeat.i(239982);
        com.tencent.f.h.RTc.aV(new d(this, str));
        AppMethodBeat.o(239982);
    }

    public final void epx() {
        AppMethodBeat.i(239983);
        epz();
        RA(this.zQD.epf());
        this.zWu.setAlpha(0.0f);
        this.zWu.setVisibility(0);
        this.zWu.clearAnimation();
        this.zWu.animate().alpha(1.0f).setDuration(300).setListener(new f(this)).start();
        AppMethodBeat.o(239983);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$doAnimationShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
    public static final class f implements Animator.AnimatorListener {
        final /* synthetic */ h zWw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(h hVar) {
            this.zWw = hVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(239975);
            this.zWw.zWu.setAlpha(1.0f);
            AppMethodBeat.o(239975);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public final void epy() {
        AppMethodBeat.i(239984);
        this.zWu.setAlpha(1.0f);
        this.zWu.setVisibility(0);
        this.zWu.clearAnimation();
        this.zWu.animate().alpha(0.0f).setDuration(300).setListener(new e(this)).start();
        AppMethodBeat.o(239984);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$doAnimationHide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
    public static final class e implements Animator.AnimatorListener {
        final /* synthetic */ h zWw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(h hVar) {
            this.zWw = hVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(239974);
            this.zWw.zWu.setVisibility(4);
            AppMethodBeat.o(239974);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public final void epz() {
        AppMethodBeat.i(239985);
        if (this.zQD.epf() == 90 || this.zQD.epf() == 270) {
            RelativeLayout relativeLayout = this.zWu;
            int i2 = com.tencent.mm.plugin.multitalk.ui.widget.f.zSw;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
            if (this.zQD.epg()) {
                layoutParams.setMarginEnd(com.tencent.mm.plugin.multitalk.ui.widget.f.zSt);
            } else {
                layoutParams.setMarginEnd(com.tencent.mm.plugin.multitalk.ui.widget.f.zSk);
            }
            layoutParams.addRule(21);
            relativeLayout.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(239985);
    }

    public final void se(boolean z) {
        AppMethodBeat.i(239986);
        RA(this.zQD.epf());
        View view = this.zWs;
        if (view != null) {
            view.setVisibility(z ? 0 : 4);
            AppMethodBeat.o(239986);
            return;
        }
        AppMethodBeat.o(239986);
    }

    public final void RA(int i2) {
        RelativeLayout relativeLayout;
        String str;
        AppMethodBeat.i(239987);
        if (this.zQD.epi() != 0 || (relativeLayout = this.zWt) == null) {
            AppMethodBeat.o(239987);
            return;
        }
        if (i2 != 180) {
            switch (i2) {
                case 0:
                    ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                    if (layoutParams != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        if (layoutParams2 != null) {
                            layoutParams2.removeRule(21);
                        }
                        if (layoutParams2 != null) {
                            layoutParams2.removeRule(20);
                        }
                        if (layoutParams2 != null) {
                            layoutParams2.removeRule(10);
                        }
                        if (layoutParams2 != null) {
                            layoutParams2.removeRule(12);
                        }
                        layoutParams2.addRule(10, -1);
                        if (layoutParams2 != null) {
                            layoutParams2.addRule(21, -1);
                        }
                        relativeLayout.setLayoutParams(layoutParams2);
                        relativeLayout.requestLayout();
                        View view = this.zWs;
                        if (view != null) {
                            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                            if (layoutParams3 != null) {
                                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                                if (layoutParams4 != null) {
                                    layoutParams4.removeRule(21);
                                }
                                if (layoutParams4 != null) {
                                    layoutParams4.removeRule(20);
                                }
                                if (layoutParams4 != null) {
                                    layoutParams4.removeRule(10);
                                }
                                if (layoutParams4 != null) {
                                    layoutParams4.removeRule(12);
                                }
                                if (layoutParams4 != null) {
                                    layoutParams4.addRule(12, -1);
                                }
                                if (layoutParams4 != null) {
                                    layoutParams4.addRule(21, -1);
                                }
                                layoutParams4.setMarginEnd(com.tencent.mm.plugin.multitalk.ui.widget.f.zSe / 2);
                                view.setLayoutParams(layoutParams4);
                                view.requestLayout();
                                break;
                            } else {
                                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                                AppMethodBeat.o(239987);
                                throw tVar;
                            }
                        }
                    } else {
                        t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(239987);
                        throw tVar2;
                    }
                    break;
                case 90:
                    ViewGroup.LayoutParams layoutParams5 = relativeLayout.getLayoutParams();
                    if (layoutParams5 != null) {
                        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
                        if (layoutParams6 != null) {
                            layoutParams6.removeRule(21);
                        }
                        if (layoutParams6 != null) {
                            layoutParams6.removeRule(20);
                        }
                        if (layoutParams6 != null) {
                            layoutParams6.removeRule(10);
                        }
                        if (layoutParams6 != null) {
                            layoutParams6.removeRule(12);
                        }
                        if (layoutParams6 != null) {
                            layoutParams6.addRule(20, -1);
                        }
                        if (layoutParams6 != null) {
                            layoutParams6.addRule(10, -1);
                        }
                        relativeLayout.setLayoutParams(layoutParams6);
                        relativeLayout.requestLayout();
                        View view2 = this.zWs;
                        if (view2 != null) {
                            ViewGroup.LayoutParams layoutParams7 = view2.getLayoutParams();
                            if (layoutParams7 != null) {
                                RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
                                if (layoutParams8 != null) {
                                    layoutParams8.removeRule(21);
                                }
                                if (layoutParams8 != null) {
                                    layoutParams8.removeRule(20);
                                }
                                if (layoutParams8 != null) {
                                    layoutParams8.removeRule(10);
                                }
                                if (layoutParams8 != null) {
                                    layoutParams8.removeRule(12);
                                }
                                if (layoutParams8 != null) {
                                    layoutParams8.addRule(10, -1);
                                }
                                if (layoutParams8 != null) {
                                    layoutParams8.addRule(21, -1);
                                }
                                layoutParams8.setMarginEnd(com.tencent.mm.plugin.multitalk.ui.widget.f.zSe / 2);
                                view2.setLayoutParams(layoutParams8);
                                view2.requestLayout();
                                break;
                            } else {
                                t tVar3 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                                AppMethodBeat.o(239987);
                                throw tVar3;
                            }
                        }
                    } else {
                        t tVar4 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(239987);
                        throw tVar4;
                    }
                    break;
                case 270:
                    ViewGroup.LayoutParams layoutParams9 = relativeLayout.getLayoutParams();
                    if (layoutParams9 != null) {
                        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
                        if (layoutParams10 != null) {
                            layoutParams10.removeRule(21);
                        }
                        if (layoutParams10 != null) {
                            layoutParams10.removeRule(20);
                        }
                        if (layoutParams10 != null) {
                            layoutParams10.removeRule(10);
                        }
                        if (layoutParams10 != null) {
                            layoutParams10.removeRule(12);
                        }
                        if (layoutParams10 != null) {
                            layoutParams10.addRule(21, -1);
                        }
                        if (layoutParams10 != null) {
                            layoutParams10.addRule(12, -1);
                        }
                        relativeLayout.setLayoutParams(layoutParams10);
                        relativeLayout.requestLayout();
                        View view3 = this.zWs;
                        if (view3 != null) {
                            ViewGroup.LayoutParams layoutParams11 = view3.getLayoutParams();
                            if (layoutParams11 != null) {
                                RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) layoutParams11;
                                if (layoutParams12 != null) {
                                    layoutParams12.removeRule(21);
                                }
                                if (layoutParams12 != null) {
                                    layoutParams12.removeRule(20);
                                }
                                if (layoutParams12 != null) {
                                    layoutParams12.removeRule(10);
                                }
                                if (layoutParams12 != null) {
                                    layoutParams12.removeRule(12);
                                }
                                if (layoutParams12 != null) {
                                    layoutParams12.addRule(12, -1);
                                }
                                if (layoutParams12 != null) {
                                    layoutParams12.addRule(20, -1);
                                }
                                layoutParams12.setMarginStart(com.tencent.mm.plugin.multitalk.ui.widget.f.zSe / 2);
                                view3.setLayoutParams(layoutParams12);
                                view3.requestLayout();
                                break;
                            } else {
                                t tVar5 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                                AppMethodBeat.o(239987);
                                throw tVar5;
                            }
                        }
                    } else {
                        t tVar6 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(239987);
                        throw tVar6;
                    }
                    break;
            }
        }
        if (!(this.zWq == 1 || (str = this.zTg) == null)) {
            aGv(str);
        }
        ImageView imageView = this.zWr;
        if (imageView != null) {
            imageView.setRotation(360.0f - ((float) i2));
            AppMethodBeat.o(239987);
            return;
        }
        AppMethodBeat.o(239987);
    }
}
