package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.widget.e;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020'H\u0002J\b\u0010,\u001a\u00020'H\u0002J\b\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020'H\u0002J\u0006\u00103\u001a\u00020'R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \u0011*\u0004\u0018\u00010\u001f0\u001fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \u0011*\u0004\u0018\u00010!0!X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n \u0011*\u0004\u0018\u00010#0#X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "STATE_HIDE", "", "STATE_SHOW_BEAUTY", "STATE_SHOW_FILTER", "STATE_SHOW_MENU", "TAG", "", "beautyPanel", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "beautyWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;", "filterPanel", "filterWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "menuBeauty", "menuFilter", "menuMirror", "menuMirrorIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "menuMirrorTv", "Landroid/widget/TextView;", "menuPanel", "Landroid/widget/LinearLayout;", "menuSwitchCamera", "state", "checkCamera", "", "clickBeauty", "clickFilter", "clickMirror", "clickSwitch", "hideCameraOptPanel", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "resetState", "showCameraOptPanel", "plugin-finder_release"})
public final class j extends d implements View.OnClickListener {
    private final String TAG = "Finder.FinderLiveAnchorCameraOptPanelPlugin";
    private final com.tencent.mm.live.c.b hOp;
    private int state;
    private final LinearLayout umA;
    private final RelativeLayout umB;
    private final RelativeLayout umC;
    private final TextView umD;
    private final WeImageView umE;
    private final RelativeLayout umF;
    private final RelativeLayout umG;
    private final RelativeLayout umH;
    private final RelativeLayout umI;
    private final e umJ;
    private final com.tencent.mm.plugin.finder.live.widget.d umK;
    private final int umw;
    private final int umx = 1;
    private final int umy = 2;
    private final int umz = 3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246433);
        this.hOp = bVar;
        this.umA = (LinearLayout) viewGroup.findViewById(R.id.cpc);
        this.umB = (RelativeLayout) viewGroup.findViewById(R.id.cpm);
        this.umC = (RelativeLayout) viewGroup.findViewById(R.id.cpj);
        this.umD = (TextView) viewGroup.findViewById(R.id.cpl);
        this.umE = (WeImageView) viewGroup.findViewById(R.id.cpk);
        this.umF = (RelativeLayout) viewGroup.findViewById(R.id.cpg);
        this.umG = (RelativeLayout) viewGroup.findViewById(R.id.cpd);
        this.umH = (RelativeLayout) viewGroup.findViewById(R.id.cp5);
        this.umI = (RelativeLayout) viewGroup.findViewById(R.id.cow);
        this.state = this.umw;
        if (!isLandscape()) {
            LinearLayout linearLayout = this.umA;
            p.g(linearLayout, "menuPanel");
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(246433);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
            RelativeLayout relativeLayout = this.umH;
            RelativeLayout relativeLayout2 = this.umH;
            p.g(relativeLayout2, "filterPanel");
            int paddingLeft = relativeLayout2.getPaddingLeft();
            RelativeLayout relativeLayout3 = this.umH;
            p.g(relativeLayout3, "filterPanel");
            int paddingTop = relativeLayout3.getPaddingTop();
            RelativeLayout relativeLayout4 = this.umH;
            p.g(relativeLayout4, "filterPanel");
            int paddingRight = relativeLayout4.getPaddingRight();
            RelativeLayout relativeLayout5 = this.umH;
            p.g(relativeLayout5, "filterPanel");
            relativeLayout.setPadding(paddingLeft, paddingTop, paddingRight, relativeLayout5.getPaddingBottom() + au.aD(viewGroup.getContext()));
            RelativeLayout relativeLayout6 = this.umI;
            RelativeLayout relativeLayout7 = this.umI;
            p.g(relativeLayout7, "beautyPanel");
            int paddingLeft2 = relativeLayout7.getPaddingLeft();
            RelativeLayout relativeLayout8 = this.umI;
            p.g(relativeLayout8, "beautyPanel");
            int paddingTop2 = relativeLayout8.getPaddingTop();
            RelativeLayout relativeLayout9 = this.umI;
            p.g(relativeLayout9, "beautyPanel");
            int paddingRight2 = relativeLayout9.getPaddingRight();
            RelativeLayout relativeLayout10 = this.umI;
            p.g(relativeLayout10, "beautyPanel");
            relativeLayout6.setPadding(paddingLeft2, paddingTop2, paddingRight2, relativeLayout10.getPaddingBottom() + au.aD(viewGroup.getContext()));
        }
        viewGroup.setTranslationY((float) au.az(viewGroup.getContext()).y);
        RelativeLayout relativeLayout11 = this.umH;
        p.g(relativeLayout11, "filterPanel");
        this.umJ = new e(relativeLayout11, getLiveCore());
        RelativeLayout relativeLayout12 = this.umI;
        p.g(relativeLayout12, "beautyPanel");
        this.umK = new com.tencent.mm.plugin.finder.live.widget.d(relativeLayout12, getLiveCore());
        this.umB.setOnClickListener(this);
        this.umC.setOnClickListener(this);
        this.umF.setOnClickListener(this);
        this.umG.setOnClickListener(this);
        viewGroup.setOnClickListener(this);
        this.umJ.uFO = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.j.AnonymousClass1 */
            final /* synthetic */ j umL;

            {
                this.umL = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(246422);
                j.h(this.umL);
                k kVar = k.vkd;
                k.a(s.c.FILTER, "");
                x xVar = x.SXb;
                AppMethodBeat.o(246422);
                return xVar;
            }
        };
        this.umK.uFO = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.j.AnonymousClass2 */
            final /* synthetic */ j umL;

            {
                this.umL = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(246423);
                j.h(this.umL);
                k kVar = k.vkd;
                k.a(s.c.BEAUTY, "");
                x xVar = x.SXb;
                AppMethodBeat.o(246423);
                return xVar;
            }
        };
        if (!getLiveData().uEW) {
            RelativeLayout relativeLayout13 = this.umF;
            p.g(relativeLayout13, "menuFilter");
            relativeLayout13.setVisibility(8);
        }
        if (!getLiveData().uEV) {
            RelativeLayout relativeLayout14 = this.umG;
            p.g(relativeLayout14, "menuBeauty");
            relativeLayout14.setVisibility(8);
        }
        AppMethodBeat.o(246433);
    }

    public static final /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(246434);
        jVar.dgR();
        AppMethodBeat.o(246434);
    }

    public static final /* synthetic */ void h(j jVar) {
        AppMethodBeat.i(246436);
        jVar.dgQ();
        AppMethodBeat.o(246436);
    }

    private static com.tencent.mm.live.core.core.trtc.a getLiveCore() {
        AppMethodBeat.i(260549);
        o oVar = o.ujN;
        com.tencent.mm.live.core.core.a.b hTh = o.hTh();
        AppMethodBeat.o(260549);
        return hTh;
    }

    private final void dgQ() {
        AppMethodBeat.i(246429);
        com.tencent.mm.ac.d.h(new c(this));
        AppMethodBeat.o(246429);
    }

    private final void dgR() {
        com.tencent.mm.live.core.core.b.d dVar;
        AppMethodBeat.i(246430);
        f fVar = getLiveData().hIy;
        if (fVar == null || (dVar = fVar.hzt) == null || !dVar.hzh) {
            WeImageView weImageView = this.umE;
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            weImageView.setIconColor(context.getResources().getColor(R.color.BW_100_Alpha_0_3));
            TextView textView = this.umD;
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            textView.setTextColor(context2.getResources().getColor(R.color.BW_100_Alpha_0_3));
            AppMethodBeat.o(246430);
            return;
        }
        WeImageView weImageView2 = this.umE;
        Context context3 = this.hwr.getContext();
        p.g(context3, "root.context");
        weImageView2.setIconColor(context3.getResources().getColor(R.color.ag2));
        TextView textView2 = this.umD;
        Context context4 = this.hwr.getContext();
        p.g(context4, "root.context");
        textView2.setTextColor(context4.getResources().getColor(R.color.ag2));
        AppMethodBeat.o(246430);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin$clickBeauty$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ j umL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(j jVar) {
            this.umL = jVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(246424);
            this.umL.umK.djz();
            AppMethodBeat.o(246424);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin$clickFilter$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ j umL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(j jVar) {
            this.umL = jVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(246425);
            this.umL.umJ.djB();
            AppMethodBeat.o(246425);
        }
    }

    public final void onClick(View view) {
        com.tencent.mm.live.core.core.b.d dVar;
        boolean z;
        boolean z2;
        com.tencent.mm.live.core.core.b.d dVar2;
        com.tencent.mm.live.core.core.b.d dVar3;
        com.tencent.mm.live.core.core.b.d dVar4;
        boolean z3;
        com.tencent.mm.live.core.core.b.d dVar5;
        com.tencent.mm.live.core.core.b.d dVar6;
        int i2 = 1;
        boolean z4 = true;
        AppMethodBeat.i(246431);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.cpm) {
            f fVar = getLiveData().hIy;
            if (!(fVar == null || (dVar = fVar.hzt) == null)) {
                f fVar2 = getLiveData().hIy;
                if (fVar2 == null || (dVar2 = fVar2.hzt) == null) {
                    z = true;
                } else {
                    z = dVar2.hzh;
                }
                if (!z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                dVar.hzh = z2;
            }
            this.hOp.statusChange(b.c.hLE, new Bundle());
            dgR();
            if (this.hOp.getLiveRole() == 1) {
                k kVar = k.vkd;
                k.dpl().vmj.vtt++;
                com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(aDC, "ConfigHelper.getInstance()");
                if (aDC.aDG().hBp == 0) {
                    i2 = 2;
                }
                k kVar2 = k.vkd;
                k.a(s.c.LIVE_ANCHOR_ACTION_EXCHANGE_CAMERA, String.valueOf(i2));
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.cpj) {
            f fVar3 = getLiveData().hIy;
            if (fVar3 == null || (dVar3 = fVar3.hzt) == null || !dVar3.hzh) {
                Log.i(this.TAG, "clickMirror while using front camera, skip!");
                Context context = this.hwr.getContext();
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                u.makeText(context, context2.getResources().getString(R.string.cwq), 0).show();
            } else {
                f fVar4 = getLiveData().hIy;
                if (fVar4 == null || (dVar6 = fVar4.hzt) == null || !dVar6.hzk) {
                    this.umE.animate().rotationY(0.0f).setDuration(200).start();
                } else {
                    this.umE.animate().rotationY(180.0f).setDuration(200).start();
                }
                f fVar5 = getLiveData().hIy;
                if (!(fVar5 == null || (dVar4 = fVar5.hzt) == null)) {
                    f fVar6 = getLiveData().hIy;
                    if (fVar6 == null || (dVar5 = fVar6.hzt) == null) {
                        z3 = true;
                    } else {
                        z3 = dVar5.hzk;
                    }
                    if (z3) {
                        z4 = false;
                    }
                    dVar4.hzk = z4;
                }
                this.hOp.statusChange(b.c.hMF, new Bundle());
                k kVar3 = k.vkd;
                k.a(s.c.CLICK_MIRROR, "");
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.cpg) {
            this.state = this.umy;
            this.umA.animate().translationY((float) au.az(this.hwr.getContext()).y).setDuration(100).setListener(new b(this)).start();
        } else if (valueOf != null && valueOf.intValue() == R.id.cpd) {
            this.state = this.umz;
            this.umA.animate().translationY((float) au.az(this.hwr.getContext()).y).setDuration(100).setListener(new a(this)).start();
        } else if (valueOf != null && valueOf.intValue() == R.id.cpp) {
            if (this.state == this.umz) {
                k kVar4 = k.vkd;
                k.a(s.c.BEAUTY, "");
            } else if (this.state == this.umy) {
                k kVar5 = k.vkd;
                k.a(s.c.FILTER, "");
            }
            dgQ();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246431);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(246432);
        int i2 = this.state;
        if (i2 != this.umw) {
            if (i2 == this.umx) {
                dgQ();
                AppMethodBeat.o(246432);
                return true;
            } else if (i2 == this.umy) {
                dgQ();
                AppMethodBeat.o(246432);
                return true;
            } else if (i2 == this.umz) {
                dgQ();
                AppMethodBeat.o(246432);
                return true;
            }
        }
        AppMethodBeat.o(246432);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ j umL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(j jVar) {
            super(0);
            this.umL = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246428);
            j.a(this.umL);
            this.umL.state = this.umL.umx;
            this.umL.hwr.setVisibility(0);
            this.umL.hwr.animate().translationY(0.0f).setDuration(200).setListener(null).start();
            x xVar = x.SXb;
            AppMethodBeat.o(246428);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ j umL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j jVar) {
            super(0);
            this.umL = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246427);
            this.umL.state = this.umL.umw;
            this.umL.hwr.animate().translationY((float) au.az(this.umL.hwr.getContext()).y).setDuration(200).setListener(new AnimatorListenerAdapter(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.j.c.AnonymousClass1 */
                final /* synthetic */ c umM;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.umM = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(246426);
                    this.umM.umL.hwr.setVisibility(8);
                    com.tencent.mm.plugin.finder.live.widget.d dVar = this.umM.umL.umK;
                    dVar.uFP.setTranslationY((float) au.az(dVar.uFP.getContext()).y);
                    e eVar = this.umM.umL.umJ;
                    eVar.uGb.setTranslationY((float) au.az(eVar.uGb.getContext()).y);
                    j.f(this.umM.umL);
                    b.C0376b.a(this.umM.umL.hOp, b.c.hNy);
                    this.umM.umL.getLiveData().uDR = false;
                    com.tencent.mm.live.c.b bVar = this.umM.umL.hOp;
                    b.c cVar = b.c.hNl;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", this.umM.umL.getLiveData().uDR);
                    bVar.statusChange(cVar, bundle);
                    AppMethodBeat.o(246426);
                }
            }).start();
            x xVar = x.SXb;
            AppMethodBeat.o(246427);
            return xVar;
        }
    }

    public static final /* synthetic */ void f(j jVar) {
        AppMethodBeat.i(246435);
        LinearLayout linearLayout = jVar.umA;
        p.g(linearLayout, "menuPanel");
        linearLayout.setTranslationY(0.0f);
        AppMethodBeat.o(246435);
    }
}
