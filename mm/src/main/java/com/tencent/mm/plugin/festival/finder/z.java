package com.tencent.mm.plugin.festival.finder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.util.f;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001VB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u000200H\u0002J\b\u00105\u001a\u00020&H\u0016J\u0018\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0002J\u0018\u0010:\u001a\u0002072\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0002J\u001e\u0010;\u001a\u0002072\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010<\u001a\u00020&J\b\u0010=\u001a\u000207H\u0002J\u0018\u0010>\u001a\u0002002\u0006\u0010?\u001a\u0002002\u0006\u0010@\u001a\u000200H\u0002J\b\u0010A\u001a\u000207H\u0002J \u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\u00142\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0002J \u0010D\u001a\u0002072\u0006\u0010E\u001a\u00020\u00142\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0002J\u0010\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\nH\u0002J\u0006\u0010'\u001a\u000207J\u000e\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020JJ\u001a\u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u000207H\u0002J\u0014\u0010Q\u001a\u0002072\f\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SJ\b\u0010U\u001a\u000207H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \u001d*\u0004\u0018\u00010\"0\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u001e\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0016j\b\u0012\u0004\u0012\u00020\u0014`\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveLikeConfettiPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "CONFETTI_INTERVAL", "", "HL_CHEER_MAX_COUNT", "", "HL_LIKE_ANIMATION_DURATION", "HL_LIKE_DESTINATION_Y", "HL_LIKE_END_OFFSET_X", "HL_LIKE_SIZE", "HL_OFFSET_X_MAX", "LIKE_FROM_OTHER", "LIKE_INTERNAL", "LIKE_MANNUAL", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "count", "hadler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "highLightLikeRoot", "Landroid/widget/RelativeLayout;", "likeXyArray", "", "liking", "", "postLikeWork", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timeHandler$delegate", "Lkotlin/Lazy;", "waitingHlCheerList", "calculateNormalPoint", "Landroid/graphics/PointF;", "t", "", "start", "end", "canClearScreen", "checkEmitHighLightCheer", "", "x", "y", "emitHightLightLike", "emitLikeConfetti", "needHalfAlpha", "emitLikeConfettiMsg", "genHighLightLikeControlPoint", "startPoint", "endPoint", "initLikeXyArray", "loadOthersAvatar", "headUrl", "loadSelfAvatar", ch.COL_USERNAME, "nextInt", "next", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopLikeTimer", "tryEmitHightLightLikeByOthers", "hlCheerList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "unMount", "LineInterpolator", "plugin-festival_release"})
public final class z extends p {
    final String TAG = "Finder.FestivalFinderLiveLikeConfettiPlugin";
    long count;
    private final com.tencent.mm.live.c.b hOp;
    private final FrameLayout hRf;
    private com.tencent.mm.particles.c hRg;
    final ArrayList<Bitmap> hRh;
    final RelativeLayout ura;
    final int urb;
    final int urc;
    private final int urd;
    volatile boolean ure;
    volatile boolean urf;
    final long urg;
    final int urh;
    private final int urj;
    private final int urk;
    private final int urm;
    final long urn;
    private final int uro;
    final ArrayList<String> urp;
    final int[] urq;
    private final kotlin.f urr;
    private MMHandler urs;

    /* access modifiers changed from: package-private */
    public final MTimerHandler dhr() {
        AppMethodBeat.i(262388);
        MTimerHandler mTimerHandler = (MTimerHandler) this.urr.getValue();
        AppMethodBeat.o(262388);
        return mTimerHandler;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class d<T, R> implements com.tencent.mm.loader.f.e<o, Bitmap> {
        final /* synthetic */ z UsV;
        final /* synthetic */ int tHa;
        final /* synthetic */ PointF urA;
        final /* synthetic */ PointF urB;
        final /* synthetic */ PointF urC;
        final /* synthetic */ String urD;
        final /* synthetic */ int urx;
        final /* synthetic */ PointF ury;
        final /* synthetic */ PointF urz;

        d(z zVar, int i2, int i3, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, String str) {
            this.UsV = zVar;
            this.tHa = i2;
            this.urx = i3;
            this.ury = pointF;
            this.urz = pointF2;
            this.urA = pointF3;
            this.urB = pointF4;
            this.urC = pointF5;
            this.urD = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(262380);
            final Bitmap bitmap2 = bitmap;
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.festival.finder.z.d.AnonymousClass1 */
                final /* synthetic */ d UsW;

                {
                    this.UsW = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(262379);
                    if (bitmap2 != null) {
                        final ImageView imageView = new ImageView(this.UsW.UsV.hwr.getContext());
                        imageView.setImageBitmap(bitmap2);
                        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.UsW.UsV.urh, this.UsW.UsV.urh);
                        marginLayoutParams.setMarginStart(this.UsW.tHa);
                        marginLayoutParams.topMargin = this.UsW.urx;
                        imageView.setLayoutParams(marginLayoutParams);
                        this.UsW.UsV.ura.addView(imageView);
                        imageView.setAlpha(0.0f);
                        imageView.post(new Runnable(this) {
                            /* class com.tencent.mm.plugin.festival.finder.z.d.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 UsX;

                            {
                                this.UsX = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(262378);
                                imageView.animate().setDuration(this.UsX.UsW.UsV.urn).setInterpolator(new a(new PointF(0.18f, 0.3f))).setUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                                    /* class com.tencent.mm.plugin.festival.finder.z.d.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass1 UsY;

                                    {
                                        this.UsY = r1;
                                    }

                                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        PointF c2;
                                        AppMethodBeat.i(262375);
                                        p.g(valueAnimator, LocaleUtil.ITALIAN);
                                        if (valueAnimator.getAnimatedValue() instanceof Float) {
                                            Object animatedValue = valueAnimator.getAnimatedValue();
                                            if (animatedValue == null) {
                                                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                                                AppMethodBeat.o(262375);
                                                throw tVar;
                                            }
                                            float floatValue = ((Float) animatedValue).floatValue();
                                            if (floatValue <= 0.3f) {
                                                imageView.setAlpha(3.3333333f * floatValue);
                                                imageView.setScaleX(3.3333333f * floatValue);
                                                imageView.setScaleY(3.3333333f * floatValue);
                                            } else if (floatValue > 0.7f) {
                                                imageView.setAlpha((1.0f - floatValue) * 3.3333333f);
                                                imageView.setScaleX(j.aJ(1.0f - ((0.3f - (1.0f - floatValue)) * 0.6666666f), 1.0f));
                                                imageView.setScaleY(j.aJ(1.0f - ((0.3f - (1.0f - floatValue)) * 0.6666666f), 1.0f));
                                            } else {
                                                imageView.setAlpha(1.0f);
                                                imageView.setScaleX(1.0f);
                                                imageView.setScaleY(1.0f);
                                            }
                                            if (floatValue < 0.3f) {
                                                c2 = z.b(floatValue, this.UsY.UsX.UsW.ury, this.UsY.UsX.UsW.urz);
                                            } else {
                                                f.a aVar = com.tencent.mm.plugin.finder.live.util.f.uwb;
                                                c2 = f.a.c((floatValue - 0.3f) / 0.7f, this.UsY.UsX.UsW.urA, this.UsY.UsX.UsW.urB, this.UsY.UsX.UsW.urC);
                                            }
                                            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                                            if (layoutParams == null) {
                                                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                                AppMethodBeat.o(262375);
                                                throw tVar2;
                                            }
                                            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart((int) c2.x);
                                            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                                            if (layoutParams2 == null) {
                                                t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                                AppMethodBeat.o(262375);
                                                throw tVar3;
                                            }
                                            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) c2.y;
                                            imageView.requestLayout();
                                        }
                                        AppMethodBeat.o(262375);
                                    }
                                }).setListener(new AnimatorListenerAdapter(this) {
                                    /* class com.tencent.mm.plugin.festival.finder.z.d.AnonymousClass1.AnonymousClass1.AnonymousClass2 */
                                    final /* synthetic */ AnonymousClass1 UsY;

                                    /* JADX WARN: Incorrect args count in method signature: ()V */
                                    {
                                        this.UsY = r1;
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        AppMethodBeat.i(262376);
                                        this.UsY.UsX.UsW.UsV.ura.removeView(imageView);
                                        AppMethodBeat.o(262376);
                                    }

                                    public final void onAnimationCancel(Animator animator) {
                                        AppMethodBeat.i(262377);
                                        this.UsY.UsX.UsW.UsV.ura.removeView(imageView);
                                        AppMethodBeat.o(262377);
                                    }
                                }).start();
                                AppMethodBeat.o(262378);
                            }
                        });
                    } else {
                        Log.w(this.UsW.UsV.TAG, "loadOthersAvatar fail: " + this.UsW.urD);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(262379);
                    return xVar;
                }
            });
            AppMethodBeat.o(262380);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262395);
        this.hOp = bVar;
        this.hRf = (FrameLayout) viewGroup.findViewById(R.id.ehu);
        this.ura = (RelativeLayout) viewGroup.findViewById(R.id.ehw);
        this.hRh = new ArrayList<>();
        this.urb = 1;
        this.urc = 2;
        this.urd = 3;
        this.urg = 200;
        this.urh = at.fromDPToPix(viewGroup.getContext(), 48);
        this.urj = at.fromDPToPix(viewGroup.getContext(), 48);
        this.urk = (au.az(viewGroup.getContext()).y / 2) - at.fromDPToPix(viewGroup.getContext(), 24);
        this.urm = at.fromDPToPix(viewGroup.getContext(), 60);
        this.urn = 2500;
        this.uro = 3;
        this.urp = new ArrayList<>();
        this.urq = new int[]{0, 0};
        this.urr = kotlin.g.ah(new f(this));
        viewGroup.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.festival.finder.z.AnonymousClass1 */
            final /* synthetic */ z UsV;

            {
                this.UsV = r1;
            }

            public final void run() {
                AppMethodBeat.i(262370);
                z.a(this.UsV);
                AppMethodBeat.o(262370);
            }
        });
        this.urs = new MMHandler(Looper.getMainLooper(), new c(this));
        AppMethodBeat.o(262395);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
    static final class f extends q implements kotlin.g.a.a<MTimerHandler> {
        final /* synthetic */ z UsV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(z zVar) {
            super(0);
            this.UsV = zVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
        static final class a implements MTimerHandler.CallBack {
            final /* synthetic */ f Uta;

            a(f fVar) {
                this.Uta = fVar;
            }

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(262385);
                if (!(this.Uta.UsV.count <= 0 || this.Uta.UsV.urq[0] == 0 || this.Uta.UsV.urq[1] == 0)) {
                    z zVar = this.Uta.UsV;
                    zVar.count--;
                    this.Uta.UsV.v(this.Uta.UsV.urq[0], this.Uta.UsV.urq[1], true);
                    this.Uta.UsV.ga(this.Uta.UsV.urq[0], this.Uta.UsV.urq[1]);
                }
                AppMethodBeat.o(262385);
                return true;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MTimerHandler invoke() {
            AppMethodBeat.i(262386);
            MTimerHandler mTimerHandler = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new a(this), true);
            mTimerHandler.setLogging(false);
            AppMethodBeat.o(262386);
            return mTimerHandler;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class c implements MMHandler.Callback {
        final /* synthetic */ z UsV;

        c(z zVar) {
            this.UsV = zVar;
        }

        public final boolean handleMessage(Message message) {
            long longValue;
            AppMethodBeat.i(262374);
            int i2 = message.what;
            if (i2 == this.UsV.urb) {
                this.UsV.ure = false;
            } else if (i2 == this.UsV.urc) {
                z zVar = this.UsV;
                if (!zVar.urf) {
                    zVar.urf = true;
                    zVar.dhr().stopTimer();
                    zVar.dhr().startTimer(zVar.urg);
                }
                if (this.UsV.urq[0] <= 0 || this.UsV.urq[1] <= 0) {
                    z.a(this.UsV);
                }
                if (message.obj instanceof Integer) {
                    Object obj = message.obj;
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(262374);
                        throw tVar;
                    }
                    longValue = (long) ((Integer) obj).intValue();
                } else {
                    Object obj2 = message.obj;
                    if (obj2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type kotlin.Long");
                        AppMethodBeat.o(262374);
                        throw tVar2;
                    }
                    longValue = ((Long) obj2).longValue();
                }
                z zVar2 = this.UsV;
                zVar2.count = longValue + zVar2.count;
            }
            AppMethodBeat.o(262374);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void ga(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(262389);
        Log.v(this.TAG, "checkEmitHighLightCheer waitingHlCheerList.size:" + this.urp.size());
        if (!this.urp.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String remove = this.urp.remove(0);
            p.g(remove, "waitingHlCheerList.removeAt(0)");
            String str = remove;
            if (str.length() > 0) {
                if (Util.isEqual(str, com.tencent.mm.model.z.aTY())) {
                    PointF pointF = new PointF((float) i2, (float) i3);
                    PointF pointF2 = new PointF((float) i2, (float) this.urk);
                    ImageView imageView = new ImageView(this.hwr.getContext());
                    a.b.d(imageView, str);
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.urh, this.urh);
                    marginLayoutParams.setMarginStart(i2);
                    marginLayoutParams.topMargin = i3;
                    imageView.setLayoutParams(marginLayoutParams);
                    this.ura.addView(imageView);
                    imageView.setAlpha(0.0f);
                    imageView.post(new e(this, imageView, pointF, pointF2));
                    AppMethodBeat.o(262389);
                    return;
                }
                PointF pointF3 = new PointF((float) i2, (float) i3);
                PointF pointF4 = new PointF((float) i2, (float) this.urk);
                PointF pointF5 = new PointF((float) i2, ((float) i3) - ((((float) i3) - ((float) this.urk)) * 0.3f));
                PointF pointF6 = new PointF((float) (i2 - nextInt(this.urj)), (float) this.urk);
                PointF pointF7 = new PointF(j.aJ(pointF5.x, (float) (au.az(this.hwr.getContext()).x - this.urh)), ((float) nextInt((int) (j.aI(pointF5.y - pointF6.y, 1.0f) / 2.0f))) + pointF6.y + ((pointF5.y - pointF6.y) * 0.25f));
                m mVar = m.uJa;
                com.tencent.mm.loader.d<o> dka = m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str);
                m mVar2 = m.uJa;
                dka.a(aVar, m.a(m.a.AVATAR)).a(new d(this, i2, i3, pointF3, pointF4, pointF5, pointF7, pointF6, str)).vC();
            }
        }
        AppMethodBeat.o(262389);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    public final void v(int i2, int i3, boolean z) {
        AppMethodBeat.i(262390);
        Log.d(this.TAG, "emitLikeConfetti containerMiddleX=" + i2 + " containerMiddleY=" + i3);
        com.tencent.mm.particles.d dVar = new com.tencent.mm.particles.d(i2, i3);
        Bitmap bitmap = this.hRh.get(nextInt(this.hRh.size()));
        p.g(bitmap, "confettiBitmaps[nextInt(confettiBitmaps.size)]");
        this.hRg = new com.tencent.mm.particles.c(this.hwr.getContext(), new b(bitmap, z), dVar, this.hRf).ax(1.0f).bkF().H(-360.0f, 50.0f).AQ(1000).bkD().bkJ();
        AppMethodBeat.o(262390);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ z UsV;
        final /* synthetic */ ImageView urG;
        final /* synthetic */ PointF ury;
        final /* synthetic */ PointF urz;

        e(z zVar, ImageView imageView, PointF pointF, PointF pointF2) {
            this.UsV = zVar;
            this.urG = imageView;
            this.ury = pointF;
            this.urz = pointF2;
        }

        public final void run() {
            AppMethodBeat.i(262384);
            this.urG.animate().setDuration(this.UsV.urn).setInterpolator(new a(new PointF(0.18f, 0.3f))).setUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                /* class com.tencent.mm.plugin.festival.finder.z.e.AnonymousClass1 */
                final /* synthetic */ e UsZ;

                {
                    this.UsZ = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(262381);
                    p.g(valueAnimator, LocaleUtil.ITALIAN);
                    if (valueAnimator.getAnimatedValue() instanceof Float) {
                        Object animatedValue = valueAnimator.getAnimatedValue();
                        if (animatedValue == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                            AppMethodBeat.o(262381);
                            throw tVar;
                        }
                        float floatValue = ((Float) animatedValue).floatValue();
                        if (floatValue <= 0.3f) {
                            this.UsZ.urG.setAlpha(3.3333333f * floatValue);
                            this.UsZ.urG.setScaleX(3.3333333f * floatValue);
                            this.UsZ.urG.setScaleY(3.3333333f * floatValue);
                        } else if (floatValue > 0.7f) {
                            this.UsZ.urG.setAlpha((1.0f - floatValue) * 3.3333333f);
                            this.UsZ.urG.setScaleX(j.aJ(1.0f - ((0.3f - (1.0f - floatValue)) * 0.6666666f), 1.0f));
                            this.UsZ.urG.setScaleY(j.aJ(1.0f - ((0.3f - (1.0f - floatValue)) * 0.6666666f), 1.0f));
                        } else {
                            this.UsZ.urG.setAlpha(1.0f);
                            this.UsZ.urG.setScaleX(1.0f);
                            this.UsZ.urG.setScaleY(1.0f);
                        }
                        PointF b2 = z.b(floatValue, this.UsZ.ury, this.UsZ.urz);
                        ViewGroup.LayoutParams layoutParams = this.UsZ.urG.getLayoutParams();
                        if (layoutParams == null) {
                            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            AppMethodBeat.o(262381);
                            throw tVar2;
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart((int) b2.x);
                        ViewGroup.LayoutParams layoutParams2 = this.UsZ.urG.getLayoutParams();
                        if (layoutParams2 == null) {
                            t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            AppMethodBeat.o(262381);
                            throw tVar3;
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) b2.y;
                        this.UsZ.urG.requestLayout();
                    }
                    AppMethodBeat.o(262381);
                }
            }).setListener(new AnimatorListenerAdapter(this) {
                /* class com.tencent.mm.plugin.festival.finder.z.e.AnonymousClass2 */
                final /* synthetic */ e UsZ;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.UsZ = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(262382);
                    this.UsZ.UsV.ura.removeView(this.UsZ.urG);
                    AppMethodBeat.o(262382);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(262383);
                    this.UsZ.UsV.ura.removeView(this.UsZ.urG);
                    AppMethodBeat.o(262383);
                }
            }).start();
            AppMethodBeat.o(262384);
        }
    }

    private final int nextInt(int i2) {
        AppMethodBeat.i(262391);
        if (i2 <= 0) {
            Log.i(this.TAG, "[nextInt] param:" + i2 + " is not positive,stack:");
            Log.printInfoStack(this.TAG, "nextInt", new Object[0]);
            AppMethodBeat.o(262391);
            return 0;
        }
        int nextInt = kotlin.j.c.SYP.nextInt(0, i2);
        AppMethodBeat.o(262391);
        return nextInt;
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262392);
        super.unMount();
        dhs();
        Log.i(this.TAG, "unMount " + this + " ,postLikeWork:" + this.urf);
        this.urs.removeMessages(this.urc);
        this.urs.removeMessages(this.urb);
        AppMethodBeat.o(262392);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        String str;
        int i2;
        int i3 = 100;
        AppMethodBeat.i(262393);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (aa.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                int i4 = bundle != null ? bundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X") : 100;
                if (bundle != null) {
                    i3 = bundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
                }
                v(i4, i3, false);
                this.ure = true;
                com.tencent.mm.plugin.finder.report.live.m.vli.hUG();
                this.urs.removeMessages(this.urb);
                this.urs.sendEmptyMessageDelayed(this.urb, 1000);
                AppMethodBeat.o(262393);
                return;
            case 2:
                long j2 = getLiveData().UPS;
                if (j2 <= 0 || this.ure) {
                    AppMethodBeat.o(262393);
                    return;
                }
                this.urs.sendMessageDelayed(this.urs.obtainMessage(this.urc, Long.valueOf(j2)), 300);
                AppMethodBeat.o(262393);
                return;
            case 3:
                this.urs.removeMessages(this.urc);
                this.urs.removeMessages(this.urb);
                dhs();
                Log.i(this.TAG, "CLOSE_LIVE " + this + " ,postLikeWork:" + this.urf);
                AppMethodBeat.o(262393);
                return;
            case 4:
                if (bundle == null || (str = bundle.getString("PARAM_FINDER_LIVE_HEAD_URL")) == null) {
                    str = "";
                }
                p.g(str, "param?.getString(ILiveSt…NDER_LIVE_HEAD_URL) ?: \"\"");
                if (bundle != null) {
                    i2 = bundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");
                } else {
                    i2 = 100;
                }
                if (bundle != null) {
                    i3 = bundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
                }
                this.urp.add(0, str);
                ga(i2, i3);
                break;
        }
        AppMethodBeat.o(262393);
    }

    private final void dhs() {
        AppMethodBeat.i(262394);
        dhr().stopTimer();
        this.count = 0;
        this.urf = false;
        AppMethodBeat.o(262394);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveLikeConfettiPlugin$LineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "divideInput", "", "divideOutput", "getInterpolation", "input", "plugin-festival_release"})
    public static final class a implements Interpolator {
        private final float uru;
        private final float urv;

        public a(PointF pointF) {
            p.h(pointF, "divide");
            AppMethodBeat.i(262371);
            this.uru = pointF.x;
            this.urv = pointF.y;
            AppMethodBeat.o(262371);
        }

        public final float getInterpolation(float f2) {
            if (f2 < this.uru) {
                return (f2 / this.uru) * this.urv;
            }
            return this.urv + (((f2 - this.uru) / (1.0f - this.uru)) * (1.0f - this.urv));
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", LocaleUtil.ITALIAN, "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
    public static final class b implements com.tencent.mm.particles.b {
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ boolean urw;

        b(Bitmap bitmap, boolean z) {
            this.cKG = bitmap;
            this.urw = z;
        }

        @Override // com.tencent.mm.particles.b
        public final /* synthetic */ com.tencent.mm.particles.a.b a(Random random) {
            AppMethodBeat.i(262373);
            com.tencent.mm.live.view.b.a aVar = new com.tencent.mm.live.view.b.a(this.cKG, this.urw);
            AppMethodBeat.o(262373);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ z UsV;
        final /* synthetic */ List urK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(z zVar, List list) {
            super(0);
            this.UsV = zVar;
            this.urK = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            FinderContact finderContact;
            String str;
            AppMethodBeat.i(262387);
            if (this.UsV.urq[0] <= 0 || this.UsV.urq[1] <= 0) {
                z.a(this.UsV);
            }
            List<aut> list = this.urK;
            synchronized (list) {
                try {
                    for (aut aut : list) {
                        avn avn = aut.LFE;
                        if (!(avn == null || (finderContact = avn.contact) == null || (str = finderContact.headUrl) == null)) {
                            this.UsV.urp.add(str);
                        }
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(262387);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(262387);
            return xVar2;
        }
    }

    public static final /* synthetic */ void a(z zVar) {
        int i2;
        AppMethodBeat.i(262396);
        try {
            int[] iArr = {0, 0};
            ViewParent parent = zVar.hwr.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(262396);
                throw tVar;
            }
            View findViewById = ((View) parent).findViewById(R.id.cs4);
            if (findViewById == null) {
                ViewParent parent2 = zVar.hwr.getParent();
                if (parent2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(262396);
                    throw tVar2;
                }
                findViewById = ((View) parent2).findViewById(R.id.cn0);
            }
            if (findViewById != null) {
                findViewById.getLocationOnScreen(iArr);
                int scaleX = ((int) ((findViewById.getScaleX() * ((float) findViewById.getWidth())) / 2.0f)) + iArr[0];
                o.b bVar = o.b.hGo;
                int aFl = scaleX - (o.b.aFl() / 2);
                int fromDPToPix = iArr[1] - at.fromDPToPix(zVar.hwr.getContext(), 16);
                int[] iArr2 = zVar.urq;
                if (zVar.isLandscape()) {
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    Context context = zVar.hwr.getContext();
                    p.g(context, "root.context");
                    com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                    i2 = com.tencent.mm.plugin.finder.utils.m.B(context, com.tencent.mm.plugin.finder.utils.m.i(zVar.getLiveData()));
                } else {
                    i2 = 0;
                }
                iArr2[0] = aFl - i2;
                zVar.urq[1] = fromDPToPix;
                AppMethodBeat.o(262396);
                return;
            }
            AppMethodBeat.o(262396);
        } catch (Exception e2) {
            Log.printErrStackTrace(zVar.TAG, e2, "FinderLiveLikeConfettiPlugin LIKE_FROM_OTHER", new Object[0]);
            br brVar = new br();
            brVar.jX("2");
            brVar.ew(10004);
            brVar.bfK();
            AppMethodBeat.o(262396);
        }
    }

    public static final /* synthetic */ PointF b(float f2, PointF pointF, PointF pointF2) {
        AppMethodBeat.i(262397);
        PointF pointF3 = new PointF();
        pointF3.x = pointF.x;
        pointF3.y = pointF.y - ((pointF.y - pointF2.y) * f2);
        AppMethodBeat.o(262397);
        return pointF3;
    }
}
