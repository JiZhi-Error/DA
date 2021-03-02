package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0011\u0019\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014J \u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001cH\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "currentShowingView", "Landroid/view/View;", "isAttached", "", "isForeground", "lifecycleObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "tabType", "", "targetAnimMinWidth", "videoFinishListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$videoFinishListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$videoFinishListener$1;", "attach", "", "rv", "getCurrentColor", "fraction", "", "startColor", "endColor", "startAppearAnim", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "startDisappearAnim", "Companion", "plugin-finder_release"})
public final class FinderFeedMegaVideoBtnAnimUIC extends UIComponent {
    public static final a wwf = new a((byte) 0);
    private final ValueAnimator animator;
    private boolean cQp = true;
    private int dLS;
    private RecyclerView hak;
    private boolean iuM;
    private View wwb;
    private int wwc;
    private final d wwd = new d(this);
    private final FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1 wwe = new FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1(this);

    static {
        AppMethodBeat.i(255512);
        AppMethodBeat.o(255512);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFeedMegaVideoBtnAnimUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255510);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        p.g(ofFloat, LocaleUtil.ITALIAN);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new LinearInterpolator());
        this.animator = ofFloat;
        AppMethodBeat.o(255510);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFeedMegaVideoBtnAnimUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255511);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        p.g(ofFloat, LocaleUtil.ITALIAN);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new LinearInterpolator());
        this.animator = ofFloat;
        AppMethodBeat.o(255511);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$videoFinishListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedMegaVideoAnimPlayEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class d extends IListener<hj> {
        final /* synthetic */ FinderFeedMegaVideoBtnAnimUIC wwg;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderFeedMegaVideoBtnAnimUIC finderFeedMegaVideoBtnAnimUIC) {
            this.wwg = finderFeedMegaVideoBtnAnimUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hj hjVar) {
            int ks;
            int ku;
            h hVar;
            ad adVar;
            AppMethodBeat.i(255508);
            hj hjVar2 = hjVar;
            p.h(hjVar2, "event");
            RecyclerView recyclerView = this.wwg.hak;
            if (recyclerView != null) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager != null && (ks = linearLayoutManager.ks()) <= (ku = linearLayoutManager.ku())) {
                    while (true) {
                        RecyclerView.v cg = recyclerView.cg(ks);
                        if (!(cg instanceof h)) {
                            cg = null;
                        }
                        h hVar2 = (h) cg;
                        if (hVar2 != null) {
                            View Mn = hVar2.Mn(R.id.esv);
                            if (Mn != null && Mn.getVisibility() == 0) {
                                hVar = hVar2;
                            } else {
                                hVar = null;
                            }
                            if (hVar != null) {
                                Object hgv = hVar.hgv();
                                if (!(hgv instanceof ad)) {
                                    hgv = null;
                                }
                                adVar = (ad) hgv;
                                if (adVar != null && adVar.feedObject.isPostFinish() && (adVar.feedObject.getExpectId() == hjVar2.dLP.feedId || (hjVar2.dLP.dLQ && adVar.feedObject.getLocalId() == hjVar2.dLP.feedId))) {
                                }
                            }
                        }
                        if (ks == ku) {
                            break;
                        }
                        ks++;
                    }
                    if (hjVar2.dLP.dLD) {
                        Log.i("FinderFeedMegaVideoBtnAnimUIC", "reset mega video anim status, feedId = " + hjVar2.dLP.feedId);
                        if (this.wwg.cQp) {
                            adVar.uOp = false;
                            adVar.uOr = false;
                        }
                        AppMethodBeat.o(255508);
                    } else if (hjVar2.dLP.dLR) {
                        Log.i("FinderFeedMegaVideoBtnAnimUIC", "video is completed, feedId = " + hjVar2.dLP.feedId);
                        adVar.uOr = true;
                    } else {
                        this.wwg.dLS = hjVar2.dLP.dLS;
                        Log.i("FinderFeedMegaVideoBtnAnimUIC", "start finder feed mega video button anim, feedId = " + hjVar2.dLP.feedId);
                        FinderFeedMegaVideoBtnAnimUIC.a(this.wwg, hVar);
                        if (!adVar.uOp) {
                            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.wwg.getActivity()).get(FinderReporterUIC.class)).dIx();
                            af afVar = af.viA;
                            String zs = com.tencent.mm.ac.d.zs(adVar.lT());
                            String str = dIx.sessionId;
                            if (str == null) {
                                str = "";
                            }
                            String str2 = dIx.sGQ;
                            if (str2 == null) {
                                str2 = "";
                            }
                            String str3 = dIx.sGE;
                            if (str3 == null) {
                                str3 = "";
                            }
                            af.p(zs, str, str2, str3);
                            adVar.uOp = true;
                        }
                        AppMethodBeat.o(255508);
                    }
                    return true;
                }
            }
            AppMethodBeat.o(255508);
            return true;
        }
    }

    public final void t(RecyclerView recyclerView) {
        AppMethodBeat.i(255509);
        p.h(recyclerView, "rv");
        this.hak = recyclerView;
        if (!this.iuM) {
            this.wwd.alive();
        }
        this.iuM = true;
        getActivity().getLifecycle().addObserver(this.wwe);
        AppMethodBeat.o(255509);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h qhp;
        final /* synthetic */ FinderFeedMegaVideoBtnAnimUIC wwg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderFeedMegaVideoBtnAnimUIC finderFeedMegaVideoBtnAnimUIC, h hVar) {
            super(0);
            this.wwg = finderFeedMegaVideoBtnAnimUIC;
            this.qhp = hVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$1"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ b wwh;

            a(b bVar) {
                this.wwh = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(255501);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.wwh.qhp.Mn(R.id.esv).performClick();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255501);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$3"})
        /* renamed from: com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC$b$b  reason: collision with other inner class name */
        static final class C1353b implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ View tzy;
            final /* synthetic */ b wwh;
            final /* synthetic */ View wwi;
            final /* synthetic */ int wwj;
            final /* synthetic */ int wwk;

            C1353b(View view, View view2, int i2, int i3, b bVar) {
                this.tzy = view;
                this.wwi = view2;
                this.wwj = i2;
                this.wwk = i3;
                this.wwh = bVar;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(255502);
                p.g(valueAnimator, "anim");
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float width = ((float) this.wwh.wwg.wwc) + (((float) (this.tzy.getWidth() - this.wwh.wwg.wwc)) * animatedFraction);
                View view = this.wwi;
                p.g(view, "bgView");
                view.getLayoutParams().width = (int) width;
                this.wwi.requestLayout();
                this.wwi.setBackgroundColor(FinderFeedMegaVideoBtnAnimUIC.e(animatedFraction, this.wwj, this.wwk));
                if (animatedFraction > 0.5f) {
                    View findViewById = this.tzy.findViewById(R.id.et5);
                    p.g(findViewById, "it.findViewById<TextView>(R.id.long_video_tips)");
                    ((TextView) findViewById).setAlpha((animatedFraction - 0.5f) * 2.0f);
                }
                AppMethodBeat.o(255502);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
        public static final class d extends AnimatorListenerAdapter {
            final /* synthetic */ View wwi;

            d(View view) {
                this.wwi = view;
            }

            public final void onAnimationEnd(Animator animator) {
                StringBuilder sb;
                String str = null;
                AppMethodBeat.i(255504);
                StringBuilder sb2 = new StringBuilder("onAnimationEnd: check bg status, width = ");
                View view = this.wwi;
                p.g(view, "bgView");
                StringBuilder append = sb2.append(view.getWidth()).append(", color = ");
                View view2 = this.wwi;
                p.g(view2, "bgView");
                Drawable background = view2.getBackground();
                if (!(background instanceof ColorDrawable)) {
                    background = null;
                }
                ColorDrawable colorDrawable = (ColorDrawable) background;
                if (colorDrawable != null) {
                    str = Integer.toHexString(colorDrawable.getColor());
                    sb = append;
                } else {
                    sb = append;
                }
                Log.i("FinderFeedMegaVideoBtnAnimUIC", sb.append(str).toString());
                AppMethodBeat.o(255504);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255505);
            View Mn = this.qhp.Mn(R.id.clz);
            if (Mn == null) {
                ViewStub viewStub = (ViewStub) this.qhp.Mn(R.id.est);
                View inflate = viewStub != null ? viewStub.inflate() : null;
                x xVar = x.SXb;
                Mn = inflate;
            }
            if (Mn != null) {
                ValueAnimator valueAnimator = this.wwg.animator;
                p.g(valueAnimator, "animator");
                if (valueAnimator.isRunning() || Mn.getVisibility() == 0) {
                    Log.i("FinderFeedMegaVideoBtnAnimUIC", "startAppearAnim: the guide view is showing");
                } else {
                    this.wwg.wwb = Mn;
                    Mn.setOnClickListener(new a(this));
                    FinderFeedMegaVideoBtnAnimUIC finderFeedMegaVideoBtnAnimUIC = this.wwg;
                    View Mn2 = this.qhp.Mn(R.id.esv);
                    p.g(Mn2, "holder.getView<View>(R.id.long_video_button)");
                    finderFeedMegaVideoBtnAnimUIC.wwc = Mn2.getWidth();
                    TextView textView = (TextView) Mn.findViewById(R.id.et4);
                    if (textView != null) {
                        View Mn3 = this.qhp.Mn(R.id.esy);
                        p.g(Mn3, "holder.getView<TextView>….id.long_video_button_tv)");
                        textView.setText(((TextView) Mn3).getText());
                        Context context = Mn.getContext();
                        p.g(context, "it.context");
                        textView.setTextColor(context.getResources().getColor(R.color.BW_100));
                    }
                    Context context2 = Mn.getContext();
                    p.g(context2, "it.context");
                    ((WeImageView) Mn.findViewById(R.id.et6)).setIconColor(context2.getResources().getColor(R.color.BW_100));
                    View findViewById = Mn.findViewById(R.id.et5);
                    p.g(findViewById, "it.findViewById<TextView>(R.id.long_video_tips)");
                    ((TextView) findViewById).setAlpha(0.0f);
                    View findViewById2 = Mn.findViewById(R.id.mv);
                    p.g(findViewById2, "bgView");
                    findViewById2.getLayoutParams().width = this.wwg.wwc;
                    findViewById2.requestLayout();
                    Mn.setVisibility(0);
                    Context context3 = this.qhp.getContext();
                    p.g(context3, "holder.context");
                    int color = context3.getResources().getColor(y.a(y.vXH, this.wwg.dLS, 0, 2) ? R.color.v0 : R.color.f3044b);
                    Context context4 = this.qhp.getContext();
                    p.g(context4, "holder.context");
                    int color2 = context4.getResources().getColor(y.a(y.vXH, this.wwg.dLS, 0, 2) ? R.color.vd : R.color.Orange_100);
                    this.wwg.animator.removeAllUpdateListeners();
                    this.wwg.animator.removeAllListeners();
                    this.wwg.animator.addUpdateListener(new C1353b(Mn, findViewById2, color, color2, this));
                    this.wwg.animator.addListener(new d(findViewById2));
                    this.wwg.animator.start();
                    com.tencent.mm.ac.d.a(5000, new c(this));
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(255505);
            return xVar2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$5"})
        static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b wwh;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar) {
                super(0);
                this.wwh = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(255503);
                FinderFeedMegaVideoBtnAnimUIC.e(this.wwh.wwg);
                x xVar = x.SXb;
                AppMethodBeat.o(255503);
                return xVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderFeedMegaVideoBtnAnimUIC wwg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFeedMegaVideoBtnAnimUIC finderFeedMegaVideoBtnAnimUIC) {
            super(0);
            this.wwg = finderFeedMegaVideoBtnAnimUIC;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startDisappearAnim$1$2$1"})
        static final class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ View tzy;
            final /* synthetic */ View wwi;
            final /* synthetic */ int wwj;
            final /* synthetic */ int wwk;
            final /* synthetic */ c wwl;

            a(View view, View view2, int i2, int i3, c cVar) {
                this.tzy = view;
                this.wwi = view2;
                this.wwj = i2;
                this.wwk = i3;
                this.wwl = cVar;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(255506);
                p.g(valueAnimator, "anim");
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float width = ((float) this.tzy.getWidth()) - (((float) (this.tzy.getWidth() - this.wwl.wwg.wwc)) * animatedFraction);
                View view = this.wwi;
                p.g(view, "bgView");
                view.getLayoutParams().width = (int) width;
                this.wwi.requestLayout();
                this.wwi.setBackgroundColor(FinderFeedMegaVideoBtnAnimUIC.e(animatedFraction, this.wwj, this.wwk));
                if (animatedFraction >= 1.0f) {
                    this.tzy.setVisibility(8);
                }
                AppMethodBeat.o(255506);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255507);
            View view = this.wwg.wwb;
            if (view != null) {
                if (!(view.getVisibility() == 0)) {
                    view = null;
                }
                if (view != null) {
                    ValueAnimator valueAnimator = this.wwg.animator;
                    p.g(valueAnimator, "animator");
                    if (valueAnimator.isRunning()) {
                        this.wwg.animator.cancel();
                    }
                    View findViewById = view.findViewById(R.id.et5);
                    p.g(findViewById, "it.findViewById<TextView>(R.id.long_video_tips)");
                    ((TextView) findViewById).setAlpha(0.0f);
                    if (!y.a(y.vXH, this.wwg.dLS, 0, 2)) {
                        Context context = view.getContext();
                        p.g(context, "it.context");
                        ((TextView) view.findViewById(R.id.et4)).setTextColor(context.getResources().getColor(R.color.FG_0));
                        Context context2 = view.getContext();
                        p.g(context2, "it.context");
                        ((WeImageView) view.findViewById(R.id.et6)).setIconColor(context2.getResources().getColor(R.color.FG_0));
                    }
                    View findViewById2 = view.findViewById(R.id.mv);
                    Context context3 = view.getContext();
                    p.g(context3, "it.context");
                    int color = context3.getResources().getColor(y.a(y.vXH, this.wwg.dLS, 0, 2) ? R.color.v0 : R.color.f3044b);
                    Context context4 = view.getContext();
                    p.g(context4, "it.context");
                    int color2 = context4.getResources().getColor(y.a(y.vXH, this.wwg.dLS, 0, 2) ? R.color.vd : R.color.Orange_100);
                    this.wwg.animator.removeAllUpdateListeners();
                    this.wwg.animator.removeAllListeners();
                    this.wwg.animator.addUpdateListener(new a(view, findViewById2, color2, color, this));
                    this.wwg.animator.start();
                }
            }
            this.wwg.wwb = null;
            x xVar = x.SXb;
            AppMethodBeat.o(255507);
            return xVar;
        }
    }

    public static final /* synthetic */ int e(float f2, int i2, int i3) {
        AppMethodBeat.i(255513);
        int red = Color.red(i2);
        int blue = Color.blue(i2);
        int green = Color.green(i2);
        int red2 = Color.red(i3);
        int rgb = Color.rgb(red + ((int) (((float) (red2 - red)) * f2)), green + ((int) (((float) (Color.green(i3) - green)) * f2)), blue + ((int) (((float) (Color.blue(i3) - blue)) * f2)));
        AppMethodBeat.o(255513);
        return rgb;
    }

    public static final /* synthetic */ void e(FinderFeedMegaVideoBtnAnimUIC finderFeedMegaVideoBtnAnimUIC) {
        AppMethodBeat.i(255514);
        if (finderFeedMegaVideoBtnAnimUIC.wwb != null) {
            com.tencent.mm.ac.d.h(new c(finderFeedMegaVideoBtnAnimUIC));
        }
        AppMethodBeat.o(255514);
    }

    public static final /* synthetic */ void a(FinderFeedMegaVideoBtnAnimUIC finderFeedMegaVideoBtnAnimUIC, h hVar) {
        AppMethodBeat.i(255515);
        com.tencent.mm.ac.d.h(new b(finderFeedMegaVideoBtnAnimUIC, hVar));
        AppMethodBeat.o(255515);
    }
}
