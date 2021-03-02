package com.tencent.mm.plugin.finder.live.component;

import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.component.i;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0002&'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0016\u0010\u001e\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "container", "Landroid/view/ViewGroup;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "refPoint", "Landroid/graphics/PointF;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;Landroid/graphics/PointF;)V", "animListener", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$AnimListener;", "cntTv", "Landroid/widget/TextView;", "currentCnt", "", "isLotteryShowing", "", "isPagEnable", "pagView", "Lorg/libpag/PAGView;", "rootView", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "initView", "", "release", "reset", "resumeLuckyMoneyBubble", "callback", "Lkotlin/Function0;", "updateLotteryStatus", "showing", "updateLuckyMoneyCount", "count", "updateRefPoint", "AnimListener", "Companion", "plugin-finder_release"})
public final class k implements i.c {
    private static final float UKf = (-MMApplicationContext.getResources().getDimension(R.dimen.bt));
    private static final float UKg = (-MMApplicationContext.getResources().getDimension(R.dimen.bt));
    private static final float UKh = MMApplicationContext.getResources().getDimension(R.dimen.cp);
    public static final b UKi = new b((byte) 0);
    private TextView UJZ;
    private a UKa;
    private int UKb;
    private boolean UKc;
    final i.b UKd;
    private final PointF UKe;
    private final MMActivity activity;
    private final ViewGroup jLy;
    private final boolean ugz;
    private final ViewGroup ulG;
    private PAGView uqi;

    public k(ViewGroup viewGroup, MMActivity mMActivity, i.b bVar, PointF pointF) {
        p.h(viewGroup, "container");
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(pointF, "refPoint");
        AppMethodBeat.i(260426);
        this.ulG = viewGroup;
        this.activity = mMActivity;
        this.UKd = bVar;
        this.UKe = pointF;
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        this.ugz = ((PluginFinder) ah).isPagEnable();
        Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", "init: refPoint:" + this.UKe);
        y yVar = y.vXH;
        y.awu("FinderLiveLuckyMoneyBubbleViewCallback");
        View inflate = LayoutInflater.from(this.ulG.getContext()).inflate(R.layout.cf3, this.ulG, false);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(260426);
            throw tVar;
        }
        this.jLy = (ViewGroup) inflate;
        this.ulG.addView(this.jLy);
        this.jLy.setTranslationX(this.UKe.x + UKg);
        this.jLy.setTranslationY(this.UKe.y + UKf);
        AppMethodBeat.o(260426);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$Companion;", "", "()V", "ANIMATION_FILE_REPEATED_1", "", "ANIMATION_FILE_REPEATED_2", "ANIMATION_FILE_SECTION_1", "ANIMATION_FILE_SECTION_2", "ANIMATION_FILE_SECTION_COMPLETE", "ON_LOTTERY_BUBBLE_SHOWN_TRANSLATION_Y", "", "RELATIVE_TRANSLATION_X", "RELATIVE_TRANSLATION_Y", "TAG", "TRANSLATION_DURATION", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260427);
        AppMethodBeat.o(260427);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.i.c
    public final void f(PointF pointF) {
        AppMethodBeat.i(260421);
        p.h(pointF, "refPoint");
        Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", "updateRefPoint refPoint:".concat(String.valueOf(pointF)));
        this.UKe.set(pointF);
        this.jLy.setTranslationX(this.UKe.x + UKg);
        this.jLy.setTranslationY(this.UKe.y + UKf);
        AppMethodBeat.o(260421);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.i.c
    public final void initView() {
        AppMethodBeat.i(260422);
        this.UJZ = (TextView) this.jLy.findViewById(R.id.jtu);
        TextView textView = this.UJZ;
        if (textView != null) {
            textView.setTextSize(1, 22.0f);
        }
        TextView textView2 = this.UJZ;
        if (textView2 != null) {
            m mVar = m.vVH;
            m.p(textView2);
        }
        this.uqi = (PAGView) this.jLy.findViewById(R.id.k0n);
        this.UKa = new a(this);
        PAGView pAGView = this.uqi;
        if (pAGView != null) {
            pAGView.addListener(this.UKa);
        }
        PAGView pAGView2 = this.uqi;
        if (pAGView2 != null) {
            pAGView2.setOnClickListener(new c(this));
            AppMethodBeat.o(260422);
            return;
        }
        AppMethodBeat.o(260422);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ k UKj;

        c(k kVar) {
            this.UKj = kVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260419);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            i.b bVar2 = this.UKj.UKd;
            if (bVar2 != null) {
                bVar2.deZ();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260419);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.component.i.c
    public final void release() {
        AppMethodBeat.i(260423);
        com.tencent.mm.ac.d.h(new d(this));
        AppMethodBeat.o(260423);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.i.c
    public final void awL(int i2) {
        PAGFile Load;
        int i3;
        PAGView pAGView;
        AppMethodBeat.i(260424);
        Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", "updateLuckyMoneyCount: count:" + i2 + ", currentCnt=" + this.UKb + ", pagView:" + this.uqi + ", isPagEnable:" + this.ugz + ", refPoint:" + this.UKe);
        PAGView pAGView2 = this.uqi;
        if (!(pAGView2 == null || !pAGView2.isPlaying() || (pAGView = this.uqi) == null)) {
            pAGView.stop();
        }
        PAGView pAGView3 = this.uqi;
        if (pAGView3 != null) {
            pAGView3.removeListener(this.UKa);
        }
        if (i2 <= 0) {
            i.b bVar = this.UKd;
            if (bVar != null) {
                bVar.Fu(false);
            }
            this.jLy.setVisibility(8);
            AppMethodBeat.o(260424);
            return;
        }
        if (i2 == 1) {
            PAGView pAGView4 = this.uqi;
            if (pAGView4 != null) {
                pAGView4.setFile(PAGFile.Load(this.activity.getAssets(), "finder_live_lucky_money_section_1.pag"));
            }
        } else {
            PAGView pAGView5 = this.uqi;
            if (pAGView5 != null) {
                if (this.UKb <= 0) {
                    Load = PAGFile.Load(this.activity.getAssets(), "finder_live_lucky_money_complete.pag");
                } else {
                    Load = PAGFile.Load(this.activity.getAssets(), "finder_live_lucky_money_section_2.pag");
                }
                pAGView5.setFile(Load);
            }
        }
        this.UKb = i2;
        PAGView pAGView6 = this.uqi;
        if (pAGView6 != null) {
            pAGView6.setRepeatCount(1);
        }
        PAGView pAGView7 = this.uqi;
        if (pAGView7 != null) {
            pAGView7.play();
        }
        PAGView pAGView8 = this.uqi;
        if (pAGView8 != null) {
            pAGView8.addListener(this.UKa);
        }
        if (this.jLy.getVisibility() != 0 && this.UKc) {
            this.jLy.setTranslationY(this.UKe.y + UKf + UKh);
        }
        this.jLy.setVisibility(0);
        i.b bVar2 = this.UKd;
        if (bVar2 != null) {
            bVar2.Fu(true);
        }
        TextView textView = this.UJZ;
        if (textView != null) {
            textView.setText("x" + String.valueOf(i2));
        }
        TextView textView2 = this.UJZ;
        if (textView2 != null) {
            if (i2 == 1) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView2.setVisibility(i3);
            AppMethodBeat.o(260424);
            return;
        }
        AppMethodBeat.o(260424);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.i.c
    public final void Fv(boolean z) {
        AppMethodBeat.i(260425);
        this.UKc = z;
        if (this.jLy.getVisibility() == 0 && !this.UKc) {
            ObjectAnimator.ofFloat(this.jLy, "translationY", this.jLy.getTranslationY(), this.UKe.y + UKf).setDuration(500L).start();
        }
        AppMethodBeat.o(260425);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final MMFragmentActivity dcl() {
        return this.activity;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback$AnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleViewCallback;)V", "rViewCallback", "Ljava/lang/ref/WeakReference;", "getRViewCallback", "()Ljava/lang/ref/WeakReference;", "setRViewCallback", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class a implements PAGView.PAGViewListener {
        private WeakReference<k> uhG;

        public a(k kVar) {
            p.h(kVar, "viewCallback");
            AppMethodBeat.i(260418);
            this.uhG = new WeakReference<>(kVar);
            AppMethodBeat.o(260418);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public final void onAnimationRepeat(PAGView pAGView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public final void onAnimationEnd(PAGView pAGView) {
            PAGFile Load;
            AppMethodBeat.i(260417);
            k kVar = this.uhG.get();
            Log.i("Finder.FinderLiveLuckyMoneyBubbleViewCallback", "onAnimationEnd emptyViewCallback:".concat(String.valueOf(kVar == null)));
            if (kVar != null) {
                PAGView pAGView2 = kVar.uqi;
                if (pAGView2 != null) {
                    if (kVar.UKb == 1) {
                        Load = PAGFile.Load(kVar.activity.getAssets(), "finder_live_lucky_money_repeated_1.pag");
                    } else {
                        Load = PAGFile.Load(kVar.activity.getAssets(), "finder_live_lucky_money_repeated_2.pag");
                    }
                    pAGView2.setFile(Load);
                }
                PAGView pAGView3 = kVar.uqi;
                if (pAGView3 != null) {
                    pAGView3.removeListener(this);
                }
                PAGView pAGView4 = kVar.uqi;
                if (pAGView4 != null) {
                    pAGView4.setRepeatCount(0);
                }
                PAGView pAGView5 = kVar.uqi;
                if (pAGView5 != null) {
                    pAGView5.play();
                    AppMethodBeat.o(260417);
                    return;
                }
                AppMethodBeat.o(260417);
                return;
            }
            AppMethodBeat.o(260417);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public final void onAnimationCancel(PAGView pAGView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public final void onAnimationStart(PAGView pAGView) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ k UKj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(k kVar) {
            super(0);
            this.UKj = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260420);
            this.UKj.ulG.removeView(this.UKj.jLy);
            x xVar = x.SXb;
            AppMethodBeat.o(260420);
            return xVar;
        }
    }
}
