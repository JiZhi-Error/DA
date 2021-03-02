package com.tencent.mm.plugin.vlog.ui.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class aj implements t {
    public static final a GJP = new a((byte) 0);
    final v GDT;
    private RectF GJE = new RectF();
    private boolean GJF;
    private RectF GJG = new RectF();
    private RelativeLayout GJH;
    private final int GJI;
    private final WeImageView GJJ;
    private final ProgressBar GJK;
    private final TextView GJL;
    private boolean GJM;
    public com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a GJN;
    private boolean GJO;
    private final int GyC;
    private ValueAnimator animator;
    private boolean ded;
    private ViewGroup parent;
    private final int vXu;
    private com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;

    static {
        AppMethodBeat.i(191595);
        AppMethodBeat.o(191595);
    }

    public aj(ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar, v vVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        p.h(vVar, "multiMedia");
        AppMethodBeat.i(191594);
        this.parent = viewGroup;
        this.wgr = dVar;
        this.GDT = vVar;
        View findViewById = this.parent.findViewById(R.id.ggi);
        p.g(findViewById, "parent.findViewById(R.id…view_decorator_container)");
        this.GJH = (RelativeLayout) findViewById;
        Context context = this.parent.getContext();
        p.g(context, "parent.context");
        this.GyC = context.getResources().getDimensionPixelSize(R.dimen.cj);
        Context context2 = this.parent.getContext();
        p.g(context2, "parent.context");
        this.vXu = context2.getResources().getDimensionPixelSize(R.dimen.c5);
        Context context3 = this.parent.getContext();
        p.g(context3, "parent.context");
        this.GJI = context3.getResources().getDimensionPixelSize(R.dimen.bz);
        this.GJN = new com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a();
        this.ded = true;
        aa.jQ(this.parent.getContext()).inflate(R.layout.a19, (ViewGroup) this.GJH, true);
        View findViewById2 = this.GJH.findViewById(R.id.a2n);
        p.g(findViewById2, "container.findViewById(R.id.beauty_effect)");
        this.GJJ = (WeImageView) findViewById2;
        View findViewById3 = this.GJH.findViewById(R.id.epq);
        p.g(findViewById3, "container.findViewById(R.id.loading_progress)");
        this.GJK = (ProgressBar) findViewById3;
        View findViewById4 = this.GJH.findViewById(R.id.epu);
        p.g(findViewById4, "container.findViewById(R.id.loading_tips)");
        this.GJL = (TextView) findViewById4;
        this.GJJ.setIconColor(-1);
        this.GJJ.setVisibility(8);
        if (a.isEnable()) {
            this.GJH.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.vlog.ui.plugin.aj.AnonymousClass1 */
                final /* synthetic */ aj GJQ;

                {
                    this.GJQ = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(191577);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (this.GJQ.GJJ.isShown()) {
                        this.GJQ.GJM = !this.GJQ.GJM;
                        aj.a(this.GJQ, this.GJQ.GJM);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(191577);
                }
            });
        }
        if (!a.isEnable()) {
            this.GJH.setVisibility(8);
        }
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF.cMT();
        AppMethodBeat.o(191594);
    }

    public static final /* synthetic */ void b(aj ajVar, boolean z) {
        AppMethodBeat.i(191597);
        ajVar.wK(z);
        AppMethodBeat.o(191597);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191596);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191596);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x003e, code lost:
            if (com.tencent.mm.vfs.s.YS(r0.append(com.tencent.mm.plugin.xlabeffect.e.glv()).toString()) != false) goto L_0x0040;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean isEnable() {
            /*
                r2 = 191578(0x2ec5a, float:2.68458E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                com.tencent.mm.plugin.vlog.model.local.a r0 = com.tencent.mm.plugin.vlog.model.local.a.GAD
                boolean r0 = com.tencent.mm.plugin.vlog.model.local.a.fBW()
                if (r0 == 0) goto L_0x0045
                com.tencent.mm.plugin.recordvideo.res.g r0 = com.tencent.mm.plugin.recordvideo.res.g.BYp
                boolean r0 = r0.eLz()
                if (r0 != 0) goto L_0x0040
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.tencent.mm.plugin.xlabeffect.e r1 = com.tencent.mm.plugin.xlabeffect.e.JRF
                java.lang.String r1 = com.tencent.mm.plugin.xlabeffect.e.glu()
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r1 = "/"
                java.lang.StringBuilder r0 = r0.append(r1)
                com.tencent.mm.plugin.xlabeffect.e r1 = com.tencent.mm.plugin.xlabeffect.e.JRF
                java.lang.String r1 = com.tencent.mm.plugin.xlabeffect.e.glv()
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                boolean r0 = com.tencent.mm.vfs.s.YS(r0)
                if (r0 == 0) goto L_0x0045
            L_0x0040:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0044:
                return r0
            L_0x0045:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0044
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.plugin.aj.a.isEnable():boolean");
        }
    }

    public static /* synthetic */ void a(aj ajVar, boolean z) {
        AppMethodBeat.i(191585);
        ajVar.aB(z, false);
        AppMethodBeat.o(191585);
    }

    public final void aB(boolean z, boolean z2) {
        AppMethodBeat.i(191584);
        if (!a.isEnable()) {
            Log.i("MicroMsg.VideoPreviewDecorationPlugin", "not enable video enhancement, ignore this request");
            AppMethodBeat.o(191584);
            return;
        }
        Log.i("MicroMsg.VideoPreviewDecorationPlugin", "switchVideoEnhancement:".concat(String.valueOf(z)));
        if (z) {
            com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            if (com.tencent.mm.plugin.vlog.model.local.a.fBS().isEmpty()) {
                c(true, (kotlin.g.a.a<x>) new d(this, z2, z));
                AppMethodBeat.o(191584);
                return;
            }
        }
        wK(z);
        AppMethodBeat.o(191584);
    }

    private final void wK(boolean z) {
        AppMethodBeat.i(191586);
        wL(z);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_1_BOOLEAN", z);
        this.wgr.a(d.c.BWU, bundle);
        this.GJM = z;
        if (z) {
            com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            com.tencent.mm.plugin.vlog.model.local.a.fBY();
        }
        AppMethodBeat.o(191586);
    }

    static /* synthetic */ void a(aj ajVar) {
        AppMethodBeat.i(191588);
        ajVar.c(false, (kotlin.g.a.a<x>) null);
        AppMethodBeat.o(191588);
    }

    private final void c(boolean z, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(191587);
        Log.i("MicroMsg.VideoPreviewDecorationPlugin", "start loadingNormalStateSwitch, toLoading:".concat(String.valueOf(z)));
        this.GJJ.setVisibility(8);
        this.GJL.setVisibility(8);
        this.GJK.setVisibility(8);
        this.GJO = z;
        int i2 = z ? this.GyC : this.GJI;
        int i3 = z ? this.GJI : this.GyC;
        int width = (int) (((this.GJE.width() + this.GJE.left) - ((float) i2)) - ((float) this.vXu));
        int width2 = (int) (((this.GJE.width() + this.GJE.left) - ((float) i3)) - ((float) this.vXu));
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = ValueAnimator.ofFloat((float) width, (float) width2);
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new b(this));
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new c(this, z, aVar));
        }
        ValueAnimator valueAnimator4 = this.animator;
        if (valueAnimator4 != null) {
            valueAnimator4.setDuration(300L);
        }
        ValueAnimator valueAnimator5 = this.animator;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
            AppMethodBeat.o(191587);
            return;
        }
        AppMethodBeat.o(191587);
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ aj GJQ;

        b(aj ajVar) {
            this.GJQ = ajVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(191579);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(191579);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            ViewGroup.LayoutParams layoutParams = this.GJQ.GJH.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(191579);
                throw tVar2;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = (int) floatValue;
            marginLayoutParams.width = (int) (((this.GJQ.GJE.width() + this.GJQ.GJE.left) - ((float) this.GJQ.vXu)) - floatValue);
            this.GJQ.GJH.setLayoutParams(marginLayoutParams);
            AppMethodBeat.o(191579);
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ aj GJQ;
        final /* synthetic */ boolean GJR;
        final /* synthetic */ kotlin.g.a.a ihE;

        c(aj ajVar, boolean z, kotlin.g.a.a aVar) {
            this.GJQ = ajVar;
            this.GJR = z;
            this.ihE = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(191580);
            this.GJQ.GJJ.setVisibility(this.GJR ? 8 : 0);
            TextView textView = this.GJQ.GJL;
            if (this.GJR) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            ProgressBar progressBar = this.GJQ.GJK;
            if (!this.GJR) {
                i3 = 8;
            }
            progressBar.setVisibility(i3);
            Log.i("MicroMsg.VideoPreviewDecorationPlugin", "end loadingNormalStateSwitch, toLoading:" + this.GJR);
            kotlin.g.a.a aVar = this.ihE;
            if (aVar != null) {
                aVar.invoke();
            }
            if (this.GJQ.GJF) {
                this.GJQ.h(this.GJQ.GJG);
            }
            AppMethodBeat.o(191580);
        }
    }

    public final void h(RectF rectF) {
        int i2;
        ValueAnimator valueAnimator;
        AppMethodBeat.i(191589);
        p.h(rectF, "rect");
        StringBuilder append = new StringBuilder("setVisibleRect:").append(rectF).append(", animator:");
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            i2 = valueAnimator2.hashCode();
        } else {
            i2 = 0;
        }
        StringBuilder append2 = append.append(i2).append(", isRunning:");
        ValueAnimator valueAnimator3 = this.animator;
        Log.i("MicroMsg.VideoPreviewDecorationPlugin", append2.append(valueAnimator3 != null ? Boolean.valueOf(valueAnimator3.isRunning()) : null).toString());
        if ((this.animator == null || ((valueAnimator = this.animator) != null && !valueAnimator.isRunning())) && (!p.j(this.GJE, rectF))) {
            this.GJF = false;
            this.GJE.set(rectF);
            ViewGroup.LayoutParams layoutParams = this.GJH.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(191589);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = (int) (((((float) ((int) this.GJE.top)) + this.GJE.height()) - ((float) this.GyC)) - ((float) this.vXu));
            if (this.GJO) {
                marginLayoutParams.leftMargin = (int) (((this.GJE.width() + this.GJE.left) - ((float) this.GJI)) - ((float) this.vXu));
            } else {
                marginLayoutParams.leftMargin = (int) (((this.GJE.width() + this.GJE.left) - ((float) this.GyC)) - ((float) this.vXu));
            }
            this.GJH.setLayoutParams(marginLayoutParams);
            AppMethodBeat.o(191589);
            return;
        }
        this.GJF = true;
        this.GJG.set(rectF);
        AppMethodBeat.o(191589);
    }

    private void wL(boolean z) {
        AppMethodBeat.i(191590);
        this.GJJ.setVisibility(0);
        if (z) {
            this.GJJ.setImageDrawable(this.parent.getContext().getDrawable(R.raw.icons_filled_cutie_check));
        } else {
            this.GJJ.setImageDrawable(this.parent.getContext().getDrawable(R.raw.icons_filled_cutie));
        }
        this.GJJ.setIconColor(-1);
        AppMethodBeat.o(191590);
    }

    public final boolean fDS() {
        AppMethodBeat.i(191591);
        if (!this.GJM || !a.isEnable()) {
            AppMethodBeat.o(191591);
            return false;
        }
        AppMethodBeat.o(191591);
        return true;
    }

    public final void setEnable(boolean z) {
        AppMethodBeat.i(191592);
        this.ded = z;
        if (a.isEnable()) {
            this.GJH.setVisibility(0);
            AppMethodBeat.o(191592);
            return;
        }
        this.GJH.setVisibility(8);
        AppMethodBeat.o(191592);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191593);
        if (a.isEnable()) {
            this.GJH.setVisibility(i2);
        }
        AppMethodBeat.o(191593);
    }

    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ aj GJQ;
        final /* synthetic */ boolean GJS;
        final /* synthetic */ boolean hLa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(aj ajVar, boolean z, boolean z2) {
            super(0);
            this.GJQ = ajVar;
            this.GJS = z;
            this.hLa = z2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(191583);
            com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a aVar = this.GJQ.GJN;
            v vVar = this.GJQ.GDT;
            p.h(vVar, "multiMedia");
            h.RTc.aX(new a.c(aVar, this.GJS, vVar, new kotlin.g.a.b<HashMap<String, Pair<Integer, Long>>, x>(this) {
                /* class com.tencent.mm.plugin.vlog.ui.plugin.aj.d.AnonymousClass1 */
                final /* synthetic */ d GJT;

                {
                    this.GJT = r2;
                }

                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(HashMap<String, Pair<Integer, Long>> hashMap) {
                    AppMethodBeat.i(191582);
                    HashMap<String, Pair<Integer, Long>> hashMap2 = hashMap;
                    p.h(hashMap2, LocaleUtil.ITALIAN);
                    Log.i("MicroMsg.VideoPreviewDecorationPlugin", "get video label finish:".concat(String.valueOf(hashMap2)));
                    com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                    com.tencent.mm.plugin.vlog.model.local.a.p(hashMap2);
                    if (this.GJT.GJS) {
                        com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                        com.tencent.mm.plugin.vlog.model.local.a.hP(this.GJT.GJQ.GDT.Gyv);
                    }
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.vlog.ui.plugin.aj.d.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 GJU;

                        {
                            this.GJU = r2;
                        }

                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(191581);
                            aj.a(this.GJU.GJT.GJQ);
                            aj.b(this.GJU.GJT.GJQ, this.GJU.GJT.hLa);
                            x xVar = x.SXb;
                            AppMethodBeat.o(191581);
                            return xVar;
                        }
                    });
                    x xVar = x.SXb;
                    AppMethodBeat.o(191582);
                    return xVar;
                }
            }));
            x xVar = x.SXb;
            AppMethodBeat.o(191583);
            return xVar;
        }
    }
}
