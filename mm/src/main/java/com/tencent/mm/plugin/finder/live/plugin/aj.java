package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.util.f;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.ffr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001_B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002052\u0006\u00109\u001a\u000205H\u0002J\b\u0010:\u001a\u00020*H\u0016J\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\nH\u0002J\u0018\u0010?\u001a\u00020<2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\nH\u0002J\u001e\u0010@\u001a\u00020<2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010A\u001a\u00020*J\b\u0010B\u001a\u00020<H\u0002J\u0018\u0010C\u001a\u0002052\u0006\u0010D\u001a\u0002052\u0006\u0010E\u001a\u000205H\u0002J\b\u0010F\u001a\u00020<H\u0002J \u0010G\u001a\u00020<2\u0006\u0010H\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\nH\u0002J \u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\nH\u0002J\u0010\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\nH\u0002J\u0006\u0010,\u001a\u00020<J\b\u0010M\u001a\u00020\u0018H\u0002J\u000e\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020PJ\u0014\u0010N\u001a\u00020<2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RJ\u001a\u0010T\u001a\u00020<2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u00020<H\u0002J\u0014\u0010Z\u001a\u00020<2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\J\b\u0010^\u001a\u00020<H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0017j\b\u0012\u0004\u0012\u00020\n`\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n \u001e*\u0004\u0018\u00010&0&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b/\u00100R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0017j\b\u0012\u0004\u0012\u00020\u0015`\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "CONFETTI_INTERVAL", "", "HEAD_HEAD_LIKE_INTERVAL", "", "HL_CHEER_MAX_COUNT", "HL_LIKE_ANIMATION_DURATION", "HL_LIKE_DESTINATION_Y", "HL_LIKE_END_OFFSET_X", "HL_LIKE_SIZE", "HL_OFFSET_X_MAX", "LIKE_FROM_OTHER", "LIKE_INTERNAL", "LIKE_MANNUAL", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "count", "customConfettiBitmaps", "customConfettiRate", "customTotalRate", "hadler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "highLightLikeRoot", "Landroid/widget/RelativeLayout;", "likeXyArray", "", "liking", "", "normalLikeShowCount", "postLikeWork", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timeHandler$delegate", "Lkotlin/Lazy;", "waitingHlCheerList", "calculateNormalPoint", "Landroid/graphics/PointF;", "t", "", "start", "end", "canClearScreen", "checkEmitHighLightCheer", "", "x", "y", "emitHightLightLike", "emitLikeConfetti", "needHalfAlpha", "emitLikeConfettiMsg", "genHighLightLikeControlPoint", "startPoint", "endPoint", "initLikeXyArray", "loadOthersAvatar", "headUrl", "loadSelfAvatar", ch.COL_USERNAME, "nextInt", "next", "rollNextBitmap", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "cheerIconInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheerIconInfo;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopLikeTimer", "tryEmitHightLightLikeByOthers", "hlCheerList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "unMount", "LineInterpolator", "plugin-finder_release"})
public final class aj extends d {
    final String TAG = "Finder.FinderLiveLikeConfettiPlugin";
    ArrayList<Bitmap> UMv;
    ArrayList<Integer> UMw;
    private int UMx;
    final int UMy;
    int UMz;
    long count;
    private final com.tencent.mm.live.c.b hOp;
    private final FrameLayout hRf;
    private com.tencent.mm.particles.c hRg;
    private final ArrayList<Bitmap> hRh;
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
        AppMethodBeat.i(246820);
        MTimerHandler mTimerHandler = (MTimerHandler) this.urr.getValue();
        AppMethodBeat.o(246820);
        return mTimerHandler;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class d<T, R> implements com.tencent.mm.loader.f.e<o, Bitmap> {
        final /* synthetic */ int tHa;
        final /* synthetic */ PointF urA;
        final /* synthetic */ PointF urB;
        final /* synthetic */ PointF urC;
        final /* synthetic */ String urD;
        final /* synthetic */ aj urt;
        final /* synthetic */ int urx;
        final /* synthetic */ PointF ury;
        final /* synthetic */ PointF urz;

        d(aj ajVar, int i2, int i3, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, String str) {
            this.urt = ajVar;
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
            AppMethodBeat.i(246812);
            final Bitmap bitmap2 = bitmap;
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.aj.d.AnonymousClass1 */
                final /* synthetic */ d urE;

                {
                    this.urE = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(246811);
                    if (bitmap2 != null) {
                        final ImageView imageView = new ImageView(this.urE.urt.hwr.getContext());
                        imageView.setImageBitmap(bitmap2);
                        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.urE.urt.urh, this.urE.urt.urh);
                        marginLayoutParams.setMarginStart(this.urE.tHa);
                        marginLayoutParams.topMargin = this.urE.urx;
                        imageView.setLayoutParams(marginLayoutParams);
                        this.urE.urt.ura.addView(imageView);
                        imageView.setAlpha(0.0f);
                        imageView.post(new Runnable(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.aj.d.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 urF;

                            {
                                this.urF = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(246810);
                                imageView.animate().setDuration(this.urF.urE.urt.urn).setInterpolator(new a(new PointF(0.18f, 0.3f))).setUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                                    /* class com.tencent.mm.plugin.finder.live.plugin.aj.d.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass1 urH;

                                    {
                                        this.urH = r1;
                                    }

                                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        PointF c2;
                                        AppMethodBeat.i(246807);
                                        p.g(valueAnimator, LocaleUtil.ITALIAN);
                                        if (valueAnimator.getAnimatedValue() instanceof Float) {
                                            Object animatedValue = valueAnimator.getAnimatedValue();
                                            if (animatedValue == null) {
                                                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                                                AppMethodBeat.o(246807);
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
                                                c2 = aj.a(floatValue, this.urH.urF.urE.ury, this.urH.urF.urE.urz);
                                            } else {
                                                f.a aVar = com.tencent.mm.plugin.finder.live.util.f.uwb;
                                                c2 = f.a.c((floatValue - 0.3f) / 0.7f, this.urH.urF.urE.urA, this.urH.urF.urE.urB, this.urH.urF.urE.urC);
                                            }
                                            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                                            if (layoutParams == null) {
                                                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                                AppMethodBeat.o(246807);
                                                throw tVar2;
                                            }
                                            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart((int) c2.x);
                                            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                                            if (layoutParams2 == null) {
                                                t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                                AppMethodBeat.o(246807);
                                                throw tVar3;
                                            }
                                            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) c2.y;
                                            imageView.requestLayout();
                                        }
                                        AppMethodBeat.o(246807);
                                    }
                                }).setListener(new AnimatorListenerAdapter(this) {
                                    /* class com.tencent.mm.plugin.finder.live.plugin.aj.d.AnonymousClass1.AnonymousClass1.AnonymousClass2 */
                                    final /* synthetic */ AnonymousClass1 urH;

                                    /* JADX WARN: Incorrect args count in method signature: ()V */
                                    {
                                        this.urH = r1;
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        AppMethodBeat.i(246808);
                                        this.urH.urF.urE.urt.ura.removeView(imageView);
                                        AppMethodBeat.o(246808);
                                    }

                                    public final void onAnimationCancel(Animator animator) {
                                        AppMethodBeat.i(246809);
                                        this.urH.urF.urE.urt.ura.removeView(imageView);
                                        AppMethodBeat.o(246809);
                                    }
                                }).start();
                                AppMethodBeat.o(246810);
                            }
                        });
                    } else {
                        Log.w(this.urE.urt.TAG, "loadOthersAvatar fail: " + this.urE.urD);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(246811);
                    return xVar;
                }
            });
            AppMethodBeat.o(246812);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n¨\u0006\u000b"}, hxF = {"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin$setupConfig$1$1"})
    public static final class h<T, R> implements com.tencent.mm.loader.f.e<o, Bitmap> {
        final /* synthetic */ int UMA;
        final /* synthetic */ aj urt;

        h(int i2, aj ajVar) {
            this.UMA = i2;
            this.urt = ajVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(260654);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                synchronized (this.urt.UMv) {
                    try {
                        o.b bVar = o.b.hGo;
                        int aFl = o.b.aFl();
                        o.b bVar2 = o.b.hGo;
                        this.urt.UMv.add(Bitmap.createScaledBitmap(bitmap2, aFl, o.b.aFl(), true));
                        this.urt.UMw.add(Integer.valueOf(this.UMA));
                    } finally {
                        AppMethodBeat.o(260654);
                    }
                }
                return;
            }
            AppMethodBeat.o(260654);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aj(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246829);
        this.hOp = bVar;
        this.hRf = (FrameLayout) viewGroup.findViewById(R.id.ehu);
        this.ura = (RelativeLayout) viewGroup.findViewById(R.id.ehw);
        this.hRh = new ArrayList<>();
        this.UMv = new ArrayList<>();
        this.UMw = new ArrayList<>();
        this.UMx = 100;
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
        this.UMy = 8;
        this.urr = kotlin.g.ah(new f(this));
        viewGroup.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.aj.AnonymousClass1 */
            final /* synthetic */ aj urt;

            {
                this.urt = r1;
            }

            public final void run() {
                AppMethodBeat.i(246802);
                aj.a(this.urt);
                AppMethodBeat.o(246802);
            }
        });
        this.urs = new MMHandler(Looper.getMainLooper(), new c(this));
        AppMethodBeat.o(246829);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
    static final class f extends q implements kotlin.g.a.a<MTimerHandler> {
        final /* synthetic */ aj urt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(aj ajVar) {
            super(0);
            this.urt = ajVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
        static final class a implements MTimerHandler.CallBack {
            final /* synthetic */ f urJ;

            a(f fVar) {
                this.urJ = fVar;
            }

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(246817);
                if (!(this.urJ.urt.count <= 0 || this.urJ.urt.urq[0] == 0 || this.urJ.urt.urq[1] == 0)) {
                    aj ajVar = this.urJ.urt;
                    ajVar.count--;
                    this.urJ.urt.v(this.urJ.urt.urq[0], this.urJ.urt.urq[1], true);
                    this.urJ.urt.UMz++;
                    if (this.urJ.urt.UMz % this.urJ.urt.UMy == 0) {
                        this.urJ.urt.ga(this.urJ.urt.urq[0], this.urJ.urt.urq[1]);
                        this.urJ.urt.UMz = 0;
                        this.urJ.urt.urp.clear();
                    }
                }
                AppMethodBeat.o(246817);
                return true;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MTimerHandler invoke() {
            AppMethodBeat.i(246818);
            MTimerHandler mTimerHandler = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new a(this), true);
            mTimerHandler.setLogging(false);
            AppMethodBeat.o(246818);
            return mTimerHandler;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class c implements MMHandler.Callback {
        final /* synthetic */ aj urt;

        c(aj ajVar) {
            this.urt = ajVar;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(246806);
            int i2 = message.what;
            if (i2 == this.urt.urb) {
                this.urt.ure = false;
            } else if (i2 == this.urt.urc) {
                aj ajVar = this.urt;
                if (!ajVar.urf) {
                    ajVar.urf = true;
                    ajVar.dhr().stopTimer();
                    ajVar.dhr().startTimer(ajVar.urg);
                }
                if (this.urt.urq[0] <= 0 || this.urt.urq[1] <= 0) {
                    aj.a(this.urt);
                }
                Object obj = message.obj;
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                    AppMethodBeat.o(246806);
                    throw tVar;
                }
                long longValue = ((Long) obj).longValue();
                aj ajVar2 = this.urt;
                ajVar2.count = longValue + ajVar2.count;
            }
            AppMethodBeat.o(246806);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void ga(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(246821);
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
                if (Util.isEqual(str, z.aTY())) {
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
                    AppMethodBeat.o(246821);
                    return;
                }
                PointF pointF3 = new PointF((float) i2, (float) i3);
                PointF pointF4 = new PointF((float) i2, (float) this.urk);
                PointF pointF5 = new PointF((float) i2, ((float) i3) - ((((float) i3) - ((float) this.urk)) * 0.3f));
                PointF pointF6 = new PointF((float) (i2 - nextInt(this.urj)), (float) this.urk);
                PointF pointF7 = new PointF(j.aJ(pointF5.x, (float) (au.az(this.hwr.getContext()).x - this.urh)), ((float) nextInt((int) (j.aI(pointF5.y - pointF6.y, 1.0f) / 2.0f))) + pointF6.y + ((pointF5.y - pointF6.y) * 0.25f));
                m mVar = m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str);
                m mVar2 = m.uJa;
                dka.a(aVar, m.a(m.a.AVATAR)).a(new d(this, i2, i3, pointF3, pointF4, pointF5, pointF7, pointF6, str)).vC();
            }
        }
        AppMethodBeat.o(246821);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    public final void bS(LinkedList<ffr> linkedList) {
        AppMethodBeat.i(260655);
        p.h(linkedList, "cheerIconInfos");
        this.UMv = new ArrayList<>();
        this.UMw = new ArrayList<>();
        this.UMx = 0;
        for (T t : linkedList) {
            this.UMx += t.Vip;
            String str = t.qGB;
            int i2 = t.Vip;
            cjl cjl = new cjl();
            cjl.mediaId = MD5Util.getMD5String(str);
            cjl.url = str;
            cjl.thumbUrl = str;
            k kVar = new k(cjl, com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE, null, null, 12);
            m mVar = m.uJa;
            com.tencent.mm.loader.a.b<com.tencent.mm.plugin.finder.loader.o, Bitmap> bQ = m.djY().bQ(kVar);
            m mVar2 = m.uJa;
            bQ.a(m.a(m.a.TIMELINE)).a(new h(i2, this)).aJw();
        }
        AppMethodBeat.o(260655);
    }

    private final Bitmap hTB() {
        AppMethodBeat.i(260656);
        Bitmap bitmap = this.hRh.get(nextInt(this.hRh.size()));
        p.g(bitmap, "confettiBitmaps[nextInt(confettiBitmaps.size)]");
        Bitmap bitmap2 = bitmap;
        if (this.UMv.size() > 0 && this.UMx > 0) {
            synchronized (this.UMv) {
                try {
                    Iterator<T> it = this.UMw.iterator();
                    if (!it.hasNext()) {
                        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Empty collection can't be reduced.");
                        AppMethodBeat.o(260656);
                        throw unsupportedOperationException;
                    }
                    Number next = it.next();
                    while (it.hasNext()) {
                        next = Integer.valueOf(next.intValue() + it.next().intValue());
                    }
                    int intValue = next.intValue();
                    int i2 = intValue < 100 ? 100 : intValue;
                    z.d dVar = new z.d();
                    dVar.SYE = nextInt(i2);
                    if (dVar.SYE <= intValue) {
                        int i3 = 0;
                        for (T t : this.UMw) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.a.j.hxH();
                            }
                            int intValue2 = t.intValue();
                            if (dVar.SYE <= intValue2) {
                                Bitmap bitmap3 = (Bitmap) kotlin.a.j.L(this.UMv, i3);
                                if (bitmap3 != null) {
                                    bitmap2 = bitmap3;
                                }
                                AppMethodBeat.o(260656);
                            } else {
                                dVar.SYE -= intValue2;
                                i3 = i4;
                            }
                        }
                        x xVar = x.SXb;
                    }
                } finally {
                    AppMethodBeat.o(260656);
                }
            }
            return bitmap2;
        }
        AppMethodBeat.o(260656);
        return bitmap2;
    }

    public final void v(int i2, int i3, boolean z) {
        AppMethodBeat.i(246823);
        Log.d(this.TAG, "emitLikeConfetti containerMiddleX=" + i2 + " containerMiddleY=" + i3);
        com.tencent.mm.particles.d dVar = new com.tencent.mm.particles.d(i2, i3);
        this.hRg = new com.tencent.mm.particles.c(this.hwr.getContext(), new b(hTB(), z), dVar, this.hRf).ax(1.0f).bkF().H(-360.0f, 50.0f).AQ(1000).bkD().bkJ();
        AppMethodBeat.o(246823);
    }

    public final void ed(List<aut> list) {
        AppMethodBeat.i(246824);
        p.h(list, "hlCheerList");
        com.tencent.mm.ac.d.h(new g(this, list));
        AppMethodBeat.o(246824);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ ImageView urG;
        final /* synthetic */ aj urt;
        final /* synthetic */ PointF ury;
        final /* synthetic */ PointF urz;

        e(aj ajVar, ImageView imageView, PointF pointF, PointF pointF2) {
            this.urt = ajVar;
            this.urG = imageView;
            this.ury = pointF;
            this.urz = pointF2;
        }

        public final void run() {
            AppMethodBeat.i(246816);
            this.urG.animate().setDuration(this.urt.urn).setInterpolator(new a(new PointF(0.18f, 0.3f))).setUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.aj.e.AnonymousClass1 */
                final /* synthetic */ e urI;

                {
                    this.urI = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(246813);
                    p.g(valueAnimator, LocaleUtil.ITALIAN);
                    if (valueAnimator.getAnimatedValue() instanceof Float) {
                        Object animatedValue = valueAnimator.getAnimatedValue();
                        if (animatedValue == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                            AppMethodBeat.o(246813);
                            throw tVar;
                        }
                        float floatValue = ((Float) animatedValue).floatValue();
                        if (floatValue <= 0.3f) {
                            this.urI.urG.setAlpha(3.3333333f * floatValue);
                            this.urI.urG.setScaleX(3.3333333f * floatValue);
                            this.urI.urG.setScaleY(3.3333333f * floatValue);
                        } else if (floatValue > 0.7f) {
                            this.urI.urG.setAlpha((1.0f - floatValue) * 3.3333333f);
                            this.urI.urG.setScaleX(j.aJ(1.0f - ((0.3f - (1.0f - floatValue)) * 0.6666666f), 1.0f));
                            this.urI.urG.setScaleY(j.aJ(1.0f - ((0.3f - (1.0f - floatValue)) * 0.6666666f), 1.0f));
                        } else {
                            this.urI.urG.setAlpha(1.0f);
                            this.urI.urG.setScaleX(1.0f);
                            this.urI.urG.setScaleY(1.0f);
                        }
                        PointF a2 = aj.a(floatValue, this.urI.ury, this.urI.urz);
                        ViewGroup.LayoutParams layoutParams = this.urI.urG.getLayoutParams();
                        if (layoutParams == null) {
                            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            AppMethodBeat.o(246813);
                            throw tVar2;
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart((int) a2.x);
                        ViewGroup.LayoutParams layoutParams2 = this.urI.urG.getLayoutParams();
                        if (layoutParams2 == null) {
                            t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            AppMethodBeat.o(246813);
                            throw tVar3;
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) a2.y;
                        this.urI.urG.requestLayout();
                    }
                    AppMethodBeat.o(246813);
                }
            }).setListener(new AnimatorListenerAdapter(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.aj.e.AnonymousClass2 */
                final /* synthetic */ e urI;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.urI = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(246814);
                    this.urI.urt.ura.removeView(this.urI.urG);
                    AppMethodBeat.o(246814);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(246815);
                    this.urI.urt.ura.removeView(this.urI.urG);
                    AppMethodBeat.o(246815);
                }
            }).start();
            AppMethodBeat.o(246816);
        }
    }

    private final int nextInt(int i2) {
        AppMethodBeat.i(246825);
        if (i2 <= 0) {
            Log.i(this.TAG, "[nextInt] param:" + i2 + " is not positive,stack:");
            Log.printInfoStack(this.TAG, "nextInt", new Object[0]);
            AppMethodBeat.o(246825);
            return 0;
        }
        int nextInt = kotlin.j.c.SYP.nextInt(0, i2);
        AppMethodBeat.o(246825);
        return nextInt;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246826);
        super.unMount();
        dhs();
        Log.i(this.TAG, "unMount " + this + " ,postLikeWork:" + this.urf);
        this.urs.removeMessages(this.urc);
        this.urs.removeMessages(this.urb);
        AppMethodBeat.o(246826);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        String str;
        int i2;
        int i3 = 100;
        AppMethodBeat.i(246827);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (ak.$EnumSwitchMapping$0[cVar.ordinal()]) {
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
                AppMethodBeat.o(246827);
                return;
            case 2:
                long j2 = getLiveData().UPS;
                if (j2 <= 0 || this.ure) {
                    AppMethodBeat.o(246827);
                    return;
                }
                this.urs.sendMessageDelayed(this.urs.obtainMessage(this.urc, Long.valueOf(j2)), 300);
                AppMethodBeat.o(246827);
                return;
            case 3:
                this.urs.removeMessages(this.urc);
                this.urs.removeMessages(this.urb);
                dhs();
                Log.i(this.TAG, "CLOSE_LIVE " + this + " ,postLikeWork:" + this.urf);
                AppMethodBeat.o(246827);
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
        AppMethodBeat.o(246827);
    }

    private final void dhs() {
        AppMethodBeat.i(246828);
        dhr().stopTimer();
        this.count = 0;
        this.urf = false;
        AppMethodBeat.o(246828);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin$LineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "divideInput", "", "divideOutput", "getInterpolation", "input", "plugin-finder_release"})
    public static final class a implements Interpolator {
        private final float uru;
        private final float urv;

        public a(PointF pointF) {
            p.h(pointF, "divide");
            AppMethodBeat.i(246803);
            this.uru = pointF.x;
            this.urv = pointF.y;
            AppMethodBeat.o(246803);
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
            AppMethodBeat.i(246805);
            com.tencent.mm.live.view.b.a aVar = new com.tencent.mm.live.view.b.a(this.cKG, this.urw);
            AppMethodBeat.o(246805);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ List urK;
        final /* synthetic */ aj urt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(aj ajVar, List list) {
            super(0);
            this.urt = ajVar;
            this.urK = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            FinderContact finderContact;
            String str;
            AppMethodBeat.i(246819);
            if (this.urt.urq[0] <= 0 || this.urt.urq[1] <= 0) {
                aj.a(this.urt);
            }
            List<aut> list = this.urK;
            synchronized (list) {
                try {
                    for (aut aut : list) {
                        avn avn = aut.LFE;
                        if (!(avn == null || (finderContact = avn.contact) == null || (str = finderContact.headUrl) == null)) {
                            this.urt.urp.add(str);
                        }
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(246819);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(246819);
            return xVar2;
        }
    }

    public final void a(LiveConfig liveConfig) {
        AppMethodBeat.i(246822);
        p.h(liveConfig, "config");
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.bsu);
        o.b bVar = o.b.hGo;
        int aFl = o.b.aFl();
        o.b bVar2 = o.b.hGo;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, aFl, o.b.aFl(), true);
        Context context2 = this.hwr.getContext();
        p.g(context2, "root.context");
        Bitmap decodeResource2 = BitmapFactory.decodeResource(context2.getResources(), R.drawable.bsv);
        o.b bVar3 = o.b.hGo;
        int aFl2 = o.b.aFl();
        o.b bVar4 = o.b.hGo;
        Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(decodeResource2, aFl2, o.b.aFl(), true);
        Context context3 = this.hwr.getContext();
        p.g(context3, "root.context");
        Bitmap decodeResource3 = BitmapFactory.decodeResource(context3.getResources(), R.drawable.bsw);
        o.b bVar5 = o.b.hGo;
        int aFl3 = o.b.aFl();
        o.b bVar6 = o.b.hGo;
        Bitmap createScaledBitmap3 = Bitmap.createScaledBitmap(decodeResource3, aFl3, o.b.aFl(), true);
        Context context4 = this.hwr.getContext();
        p.g(context4, "root.context");
        Bitmap decodeResource4 = BitmapFactory.decodeResource(context4.getResources(), R.drawable.bsx);
        o.b bVar7 = o.b.hGo;
        int aFl4 = o.b.aFl();
        o.b bVar8 = o.b.hGo;
        Bitmap createScaledBitmap4 = Bitmap.createScaledBitmap(decodeResource4, aFl4, o.b.aFl(), true);
        Context context5 = this.hwr.getContext();
        p.g(context5, "root.context");
        Bitmap decodeResource5 = BitmapFactory.decodeResource(context5.getResources(), R.drawable.bsy);
        o.b bVar9 = o.b.hGo;
        int aFl5 = o.b.aFl();
        o.b bVar10 = o.b.hGo;
        Bitmap createScaledBitmap5 = Bitmap.createScaledBitmap(decodeResource5, aFl5, o.b.aFl(), true);
        Context context6 = this.hwr.getContext();
        p.g(context6, "root.context");
        Bitmap decodeResource6 = BitmapFactory.decodeResource(context6.getResources(), R.drawable.bsz);
        o.b bVar11 = o.b.hGo;
        int aFl6 = o.b.aFl();
        o.b bVar12 = o.b.hGo;
        Bitmap createScaledBitmap6 = Bitmap.createScaledBitmap(decodeResource6, aFl6, o.b.aFl(), true);
        this.hRh.add(createScaledBitmap);
        this.hRh.add(createScaledBitmap2);
        this.hRh.add(createScaledBitmap3);
        this.hRh.add(createScaledBitmap4);
        this.hRh.add(createScaledBitmap5);
        this.hRh.add(createScaledBitmap6);
        AppMethodBeat.o(246822);
    }

    public static final /* synthetic */ void a(aj ajVar) {
        int i2;
        AppMethodBeat.i(246830);
        try {
            int[] iArr = {0, 0};
            ViewParent parent = ajVar.hwr.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(246830);
                throw tVar;
            }
            View findViewById = ((View) parent).findViewById(R.id.cs4);
            if (findViewById == null) {
                ViewParent parent2 = ajVar.hwr.getParent();
                if (parent2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(246830);
                    throw tVar2;
                }
                findViewById = ((View) parent2).findViewById(R.id.cn0);
            }
            if (findViewById != null) {
                findViewById.getLocationOnScreen(iArr);
                int scaleX = ((int) ((findViewById.getScaleX() * ((float) findViewById.getWidth())) / 2.0f)) + iArr[0];
                o.b bVar = o.b.hGo;
                int aFl = scaleX - (o.b.aFl() / 2);
                int fromDPToPix = iArr[1] - at.fromDPToPix(ajVar.hwr.getContext(), 16);
                int[] iArr2 = ajVar.urq;
                if (ajVar.isLandscape()) {
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    Context context = ajVar.hwr.getContext();
                    p.g(context, "root.context");
                    com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                    i2 = com.tencent.mm.plugin.finder.utils.m.B(context, com.tencent.mm.plugin.finder.utils.m.i(ajVar.getLiveData()));
                } else {
                    i2 = 0;
                }
                iArr2[0] = aFl - i2;
                ajVar.urq[1] = fromDPToPix;
                AppMethodBeat.o(246830);
                return;
            }
            AppMethodBeat.o(246830);
        } catch (Exception e2) {
            Log.printErrStackTrace(ajVar.TAG, e2, "FinderLiveLikeConfettiPlugin LIKE_FROM_OTHER", new Object[0]);
            br brVar = new br();
            brVar.jX("2");
            brVar.ew(10004);
            brVar.bfK();
            AppMethodBeat.o(246830);
        }
    }

    public static final /* synthetic */ PointF a(float f2, PointF pointF, PointF pointF2) {
        AppMethodBeat.i(246831);
        PointF pointF3 = new PointF();
        pointF3.x = pointF.x;
        pointF3.y = pointF.y - ((pointF.y - pointF2.y) * f2);
        AppMethodBeat.o(246831);
        return pointF3;
    }
}
