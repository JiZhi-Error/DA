package com.tencent.mm.plugin.festival.finder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.b.e;
import com.tencent.mm.plugin.festival.model.z;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020$J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\tH\u0016J\u001a\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\b\u00102\u001a\u00020\u001dH\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \r*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \r*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveLikePlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/festival/model/FestivalWishConfigProvider$OnConfigUpdatedListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MAX_LIKE_ONE_TIME", "", "TAG", "", "likeClickArea", "kotlin.jvm.PlatformType", "likeCntWording", "likeContainer", "likeCount", "likeIcon", "Landroid/widget/ImageView;", "likeTv", "Landroid/widget/TextView;", "liking", "", "postLikeTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "vibrator", "", "canClearScreen", "mount", "", "onConfigUpdated", "config", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;", "postHightLightLike", "postLike", "refreshLikeCount", "", "scaleAnimate", "target", "Landroid/view/View;", "targetValue", "", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "uploadLike", "plugin-festival_release"})
@SuppressLint({"ClickableViewAccessibility"})
public final class ab extends p implements z.a {
    final String TAG = "Finder.FestivalFinderLiveLikePlugin";
    private final ViewGroup Utb;
    private final ViewGroup Utc;
    String Utd;
    final com.tencent.mm.live.c.b hOp;
    final TextView hPG;
    final Object hQn;
    final MTimerHandler hQp;
    int likeCount;
    final ImageView rNa;
    final int uHG = 9;
    volatile boolean ure;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ab(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262412);
        this.hOp = bVar;
        this.Utb = (ViewGroup) viewGroup.findViewById(R.id.cs5);
        this.Utc = (ViewGroup) viewGroup.findViewById(R.id.cs4);
        this.rNa = (ImageView) viewGroup.findViewById(R.id.cs6);
        ViewParent parent = viewGroup.getParent();
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(262412);
            throw tVar;
        }
        this.hPG = (TextView) ((ViewGroup) parent).findViewById(R.id.cs8);
        this.hQn = viewGroup.getContext().getSystemService("vibrator");
        this.hQp = new MTimerHandler("FinderLiveLikePlugin::Timer", (MTimerHandler.CallBack) new c(this), true);
        ImageView imageView = this.rNa;
        Context context = viewGroup.getContext();
        p.g(context, "root.context");
        imageView.setImageDrawable(ar.e(context.getResources().getDrawable(R.raw.icons_filled_call_good), -1));
        this.Utc.setOnTouchListener(new View.OnTouchListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.ab.AnonymousClass1 */
            final /* synthetic */ ab Ute;

            {
                this.Ute = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(262398);
                p.g(motionEvent, "event");
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        this.Ute.ure = true;
                        TextView textView = this.Ute.hPG;
                        p.g(textView, "likeTv");
                        textView.setVisibility(8);
                        ab.E(viewGroup, 1.7f);
                        this.Ute.hQp.startTimer(0, 200);
                        ImageView imageView = this.Ute.rNa;
                        p.g(imageView, "likeIcon");
                        imageView.setAlpha(0.3f);
                        break;
                    case 1:
                    case 3:
                        this.Ute.ure = false;
                        this.Ute.hQp.stopTimer();
                        TextView textView2 = this.Ute.hPG;
                        p.g(textView2, "likeTv");
                        textView2.setVisibility(0);
                        ab.E(viewGroup, 1.0f);
                        ab.a(this.Ute);
                        ImageView imageView2 = this.Ute.rNa;
                        p.g(imageView2, "likeIcon");
                        imageView2.setAlpha(1.0f);
                        break;
                }
                AppMethodBeat.o(262398);
                return true;
            }
        });
        viewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            /* class com.tencent.mm.plugin.festival.finder.ab.AnonymousClass2 */

            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                AppMethodBeat.i(262399);
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams != null) {
                    p.g(windowInsets, "insets");
                    marginLayoutParams.bottomMargin = windowInsets.getSystemWindowInsetBottom();
                }
                viewGroup.requestLayout();
                AppMethodBeat.o(262399);
                return windowInsets;
            }
        });
        this.Utd = z.Uzb.hRC().UAM;
        AppMethodBeat.o(262412);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ ab Ute;
        final /* synthetic */ long Utg;

        d(ab abVar, long j2) {
            this.Ute = abVar;
            this.Utg = j2;
        }

        public final void run() {
            TextView textView;
            int i2 = 0;
            AppMethodBeat.i(262405);
            String str = this.Ute.Utd;
            if (!(str == null || str.length() == 0)) {
                TextView textView2 = this.Ute.hPG;
                p.g(textView2, "likeTv");
                textView2.setText(this.Ute.Utd);
                textView = this.Ute.hPG;
                p.g(textView, "likeTv");
            } else {
                TextView textView3 = this.Ute.hPG;
                p.g(textView3, "likeTv");
                y yVar = y.vXH;
                textView3.setText(y.RN(this.Utg));
                textView = this.Ute.hPG;
                p.g(textView, "likeTv");
                if (this.Utg == 0) {
                    i2 = 8;
                }
            }
            textView.setVisibility(i2);
            AppMethodBeat.o(262405);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class c implements MTimerHandler.CallBack {
        final /* synthetic */ ab Ute;

        c(ab abVar) {
            this.Ute = abVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(262404);
            if (this.Ute.likeCount < this.Ute.uHG - 1) {
                ab abVar = this.Ute;
                if (abVar.hQn instanceof Vibrator) {
                    ((Vibrator) abVar.hQn).vibrate(10);
                }
                com.tencent.mm.ac.d.h(new b(abVar));
                AppMethodBeat.o(262404);
                return true;
            }
            if (this.Ute.likeCount == this.Ute.uHG - 1) {
                ab abVar2 = this.Ute;
                if (abVar2.hQn instanceof Vibrator) {
                    ((Vibrator) abVar2.hQn).vibrate(10);
                }
                com.tencent.mm.ac.d.h(new a(abVar2));
            }
            AppMethodBeat.o(262404);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(262407);
        z zVar = z.Uzb;
        z.a(this);
        AppMethodBeat.o(262407);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262408);
        z zVar = z.Uzb;
        z.b(this);
        AppMethodBeat.o(262408);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(262409);
        super.rg(i2);
        ViewGroup viewGroup = this.Utb;
        p.g(viewGroup, "likeContainer");
        viewGroup.setVisibility(this.hwr.getVisibility());
        TextView textView = this.hPG;
        p.g(textView, "likeTv");
        textView.setVisibility(this.likeCount == 0 ? 8 : this.hwr.getVisibility());
        AppMethodBeat.o(262409);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(262410);
        p.h(cVar, "status");
        switch (ac.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                m mVar = m.vVH;
                m.a((com.tencent.mm.plugin.finder.live.plugin.d) this, false);
                break;
        }
        AppMethodBeat.o(262410);
    }

    @Override // com.tencent.mm.plugin.festival.model.z.a
    public final void a(e eVar) {
        AppMethodBeat.i(262411);
        p.h(eVar, "config");
        this.Utd = eVar.UAM;
        AppMethodBeat.o(262411);
    }

    public final void RE(long j2) {
        AppMethodBeat.i(262406);
        this.hwr.post(new d(this, j2));
        AppMethodBeat.o(262406);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ab Ute;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ab abVar) {
            super(0);
            this.Ute = abVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262402);
            Bundle bundle = new Bundle();
            int[] iArr = {0, 0};
            this.Ute.hwr.getLocationOnScreen(iArr);
            int width = iArr[0] + ((int) ((((float) this.Ute.hwr.getWidth()) * this.Ute.hwr.getScaleX()) / 2.0f));
            o.b bVar = o.b.hGo;
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_X", width - (o.b.aFm() / 2));
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", iArr[1]);
            String str = this.Ute.getLiveData().UQh.qFV;
            if (str == null) {
                str = com.tencent.mm.model.z.aTY();
            }
            bundle.putString("PARAM_FINDER_LIVE_HEAD_URL", str);
            this.Ute.hOp.statusChange(b.c.hNK, bundle);
            at atVar = at.Uuv;
            s finderLiveAssistant = at.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.c(new r<Integer, Integer, String, ban, x>(this) {
                    /* class com.tencent.mm.plugin.festival.finder.ab.a.AnonymousClass1 */
                    final /* synthetic */ a Utf;

                    {
                        this.Utf = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                    @Override // kotlin.g.a.r
                    public final /* synthetic */ x invoke(Integer num, Integer num2, String str, ban ban) {
                        AppMethodBeat.i(262401);
                        int intValue = num.intValue();
                        int intValue2 = num2.intValue();
                        p.h(ban, "resp");
                        Log.i(this.Utf.Ute.TAG, "doHighLightLikeLive errType:" + intValue + " errCode:" + intValue2 + " errMsg:" + str);
                        x xVar = x.SXb;
                        AppMethodBeat.o(262401);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(262402);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ab Ute;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ab abVar) {
            super(0);
            this.Ute = abVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262403);
            this.Ute.likeCount++;
            ab.a(this.Ute);
            Bundle bundle = new Bundle();
            int[] iArr = {0, 0};
            this.Ute.hwr.getLocationOnScreen(iArr);
            int width = iArr[0] + ((int) ((((float) this.Ute.hwr.getWidth()) * this.Ute.hwr.getScaleX()) / 2.0f));
            o.b bVar = o.b.hGo;
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_X", width - (o.b.aFl() / 2));
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", iArr[1] - at.fromDPToPix(this.Ute.hwr.getContext(), 16));
            this.Ute.hOp.statusChange(b.c.hMa, bundle);
            x xVar = x.SXb;
            AppMethodBeat.o(262403);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(ab abVar) {
        AppMethodBeat.i(262413);
        if (!abVar.ure) {
            com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
            com.tencent.mm.plugin.festival.model.a.b.awG(abVar.likeCount);
            at atVar = at.Uuv;
            s finderLiveAssistant = at.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.Jf(abVar.likeCount);
            }
            abVar.RE(abVar.getLiveData().UPT);
            abVar.likeCount = 0;
        }
        AppMethodBeat.o(262413);
    }

    public static final /* synthetic */ void E(View view, float f2) {
        AppMethodBeat.i(262414);
        view.animate().setDuration(200).scaleX(f2).scaleY(f2).start();
        AppMethodBeat.o(262414);
    }
}
