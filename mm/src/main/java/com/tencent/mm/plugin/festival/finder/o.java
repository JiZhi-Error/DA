package com.tencent.mm.plugin.festival.finder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.model.ab;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalEducationPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "enterAnimator", "Landroid/animation/Animator;", "exitAnimator", "checkShow", "", "getFuIconDrawable", "Landroid/graphics/drawable/Drawable;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "onBackPress", "", "renderBgBlur", "setDescFuImageSpan", "showAnimation", "unMount", "Companion", "plugin-festival_release"})
public final class o extends p {
    @Deprecated
    public static final a UrU = new a((byte) 0);
    private Animator UrM;
    private Animator UrN;
    private final com.tencent.mm.live.c.b hOp;

    static {
        AppMethodBeat.i(262172);
        AppMethodBeat.o(262172);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262171);
        this.hOp = bVar;
        ((Button) viewGroup.findViewById(R.id.jud)).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.o.AnonymousClass1 */
            final /* synthetic */ o UrV;

            {
                this.UrV = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(262158);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalEducationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                o.g(this.UrV);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalEducationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262158);
            }
        });
        viewGroup.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.o.AnonymousClass2 */
            final /* synthetic */ o UrV;

            {
                this.UrV = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(262159);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalEducationPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                o.g(this.UrV);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalEducationPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262159);
            }
        });
        AppMethodBeat.o(262171);
    }

    public static final /* synthetic */ void g(o oVar) {
        AppMethodBeat.i(262176);
        oVar.hide();
        AppMethodBeat.o(262176);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalEducationPlugin$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void fvk() {
        boolean z = false;
        AppMethodBeat.i(262167);
        ab abVar = ab.UzG;
        Log.i("MicroMsg.FestivalWishLogic", "needShowEducation " + abVar.hRG());
        if (abVar.hRG()) {
            abVar.Fm(false);
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(262167);
            return;
        }
        com.tencent.mm.ac.d.a(200, new b(this));
        AppMethodBeat.o(262167);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/finder/FestivalEducationPlugin$showAnimation$1$1"})
    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ o UrV;

        f(o oVar) {
            this.UrV = oVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(262165);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(262165);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            RelativeLayout relativeLayout = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout, "root.educationLayoutContent");
            relativeLayout.setAlpha(floatValue);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout2, "root.educationLayoutContent");
            relativeLayout2.setScaleX(floatValue);
            RelativeLayout relativeLayout3 = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout3, "root.educationLayoutContent");
            relativeLayout3.setScaleY(floatValue);
            AppMethodBeat.o(262165);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalEducationPlugin$showAnimation$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
    public static final class g extends AnimatorListenerAdapter {
        final /* synthetic */ o UrV;

        g(o oVar) {
            this.UrV = oVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(262166);
            this.UrV.hwr.setVisibility(0);
            RelativeLayout relativeLayout = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout, "root.educationLayoutContent");
            relativeLayout.setAlpha(1.0f);
            this.UrV.UrM = null;
            AppMethodBeat.o(262166);
        }
    }

    private final void hide() {
        AppMethodBeat.i(262168);
        Animator animator = this.UrM;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.UrN;
        if (animator2 != null) {
            animator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(450L);
        ofFloat.addUpdateListener(new c(this));
        ofFloat.addListener(new d(this));
        ofFloat.start();
        this.UrN = ofFloat;
        AppMethodBeat.o(262168);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/finder/FestivalEducationPlugin$hide$1$1"})
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ o UrV;

        c(o oVar) {
            this.UrV = oVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(262162);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(262162);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            RelativeLayout relativeLayout = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout, "root.educationLayoutContent");
            relativeLayout.setAlpha(floatValue);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout2, "root.educationLayoutContent");
            relativeLayout2.setScaleX(floatValue);
            RelativeLayout relativeLayout3 = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout3, "root.educationLayoutContent");
            relativeLayout3.setScaleY(floatValue);
            AppMethodBeat.o(262162);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalEducationPlugin$hide$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ o UrV;

        d(o oVar) {
            this.UrV = oVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(262163);
            this.UrV.hwr.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout, "root.educationLayoutContent");
            relativeLayout.setBackground(null);
            this.UrV.UrN = null;
            this.UrV.hOp.statusChange(b.c.wLY, null);
            AppMethodBeat.o(262163);
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262170);
        super.unMount();
        Animator animator = this.UrM;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.UrN;
        if (animator2 != null) {
            animator2.cancel();
            AppMethodBeat.o(262170);
            return;
        }
        AppMethodBeat.o(262170);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ o UrV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(o oVar) {
            super(0);
            this.UrV = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262161);
            RelativeLayout relativeLayout = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout, "root.educationLayoutContent");
            relativeLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this) {
                /* class com.tencent.mm.plugin.festival.finder.o.b.AnonymousClass1 */
                final /* synthetic */ b UrW;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.UrW = r1;
                }

                public final boolean onPreDraw() {
                    AppMethodBeat.i(262160);
                    RelativeLayout relativeLayout = (RelativeLayout) this.UrW.UrV.hwr.findViewById(R.id.jue);
                    p.g(relativeLayout, "root.educationLayoutContent");
                    relativeLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                    o.a(this.UrW.UrV);
                    o.b(this.UrW.UrV);
                    AppMethodBeat.o(262160);
                    return true;
                }
            });
            RelativeLayout relativeLayout2 = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout2, "root.educationLayoutContent");
            relativeLayout2.setAlpha(0.0f);
            o.c(this.UrV);
            this.UrV.hwr.bringToFront();
            this.UrV.rg(0);
            x xVar = x.SXb;
            AppMethodBeat.o(262161);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ o UrV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(o oVar) {
            super(0);
            this.UrV = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262164);
            RelativeLayout relativeLayout = (RelativeLayout) this.UrV.hwr.findViewById(R.id.jue);
            p.g(relativeLayout, "root.educationLayoutContent");
            Drawable[] drawableArr = new Drawable[2];
            com.tencent.mm.plugin.festival.ui.b bVar = com.tencent.mm.plugin.festival.ui.b.UBn;
            Context context = this.UrV.hwr.getContext();
            p.g(context, "root.context");
            Drawable mj = com.tencent.mm.plugin.festival.ui.b.mj(context);
            if (mj == null) {
                p.hyc();
            }
            drawableArr[0] = mj;
            Drawable l = android.support.v4.content.b.l(this.UrV.hwr.getContext(), R.drawable.ctr);
            if (l == null) {
                p.hyc();
            }
            p.g(l, "ContextCompat.getDrawabl…al_education_layout_bg)!!");
            drawableArr[1] = l;
            relativeLayout.setBackground(new LayerDrawable(drawableArr));
            x xVar = x.SXb;
            AppMethodBeat.o(262164);
            return xVar;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(262169);
        if (this.hwr.getVisibility() == 0) {
            Log.i("FestivalDonationPlugin", "onBackPress eat and hide");
            hide();
            AppMethodBeat.o(262169);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(262169);
        return onBackPress;
    }

    public static final /* synthetic */ void a(o oVar) {
        AppMethodBeat.i(262173);
        Log.i("FestivalDonationPlugin", "renderBgBlur");
        e eVar = new e(oVar);
        com.tencent.mm.live.c.b bVar = oVar.hOp;
        if (!(bVar instanceof FestivalFinderLiveVisitorPluginLayout)) {
            bVar = null;
        }
        FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout = (FestivalFinderLiveVisitorPluginLayout) bVar;
        if (festivalFinderLiveVisitorPluginLayout != null) {
            Bitmap a2 = FestivalFinderLiveVisitorPluginLayout.a(festivalFinderLiveVisitorPluginLayout);
            if (a2 == null || a2.isRecycled()) {
                eVar.invoke();
                AppMethodBeat.o(262173);
                return;
            }
            RelativeLayout relativeLayout = (RelativeLayout) oVar.hwr.findViewById(R.id.jue);
            p.g(relativeLayout, "root.educationLayoutContent");
            int x = (int) relativeLayout.getX();
            RelativeLayout relativeLayout2 = (RelativeLayout) oVar.hwr.findViewById(R.id.jue);
            p.g(relativeLayout2, "root.educationLayoutContent");
            int y = (int) relativeLayout2.getY();
            RelativeLayout relativeLayout3 = (RelativeLayout) oVar.hwr.findViewById(R.id.jue);
            p.g(relativeLayout3, "root.educationLayoutContent");
            float x2 = relativeLayout3.getX();
            RelativeLayout relativeLayout4 = (RelativeLayout) oVar.hwr.findViewById(R.id.jue);
            p.g(relativeLayout4, "root.educationLayoutContent");
            int width = (int) (((float) relativeLayout4.getWidth()) + x2);
            RelativeLayout relativeLayout5 = (RelativeLayout) oVar.hwr.findViewById(R.id.jue);
            p.g(relativeLayout5, "root.educationLayoutContent");
            float y2 = relativeLayout5.getY();
            RelativeLayout relativeLayout6 = (RelativeLayout) oVar.hwr.findViewById(R.id.jue);
            p.g(relativeLayout6, "root.educationLayoutContent");
            Rect rect = new Rect(x, y, width, (int) (((float) relativeLayout6.getHeight()) + y2));
            Log.d("FestivalDonationPlugin", "renderBgBlur rect : ".concat(String.valueOf(rect)));
            try {
                Bitmap bitmapFromRectFixed = BitmapUtil.getBitmapFromRectFixed(a2, rect, false);
                Context context = oVar.hwr.getContext();
                p.g(context, "root.context");
                Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmapFromRectFixed, true, (float) context.getResources().getDimensionPixelSize(R.dimen.c5), true);
                RelativeLayout relativeLayout7 = (RelativeLayout) oVar.hwr.findViewById(R.id.jue);
                p.g(relativeLayout7, "root.educationLayoutContent");
                Drawable[] drawableArr = new Drawable[2];
                Context context2 = oVar.hwr.getContext();
                p.g(context2, "root.context");
                drawableArr[0] = new BitmapDrawable(context2.getResources(), roundedCornerBitmap);
                Drawable l = android.support.v4.content.b.l(oVar.hwr.getContext(), R.drawable.ctr);
                if (l == null) {
                    p.hyc();
                }
                p.g(l, "ContextCompat.getDrawabl…al_education_layout_bg)!!");
                drawableArr[1] = l;
                relativeLayout7.setBackground(new LayerDrawable(drawableArr));
                AppMethodBeat.o(262173);
            } catch (Exception e2) {
                Log.e("FestivalDonationPlugin", "renderBgBlur exp:".concat(String.valueOf(e2)));
                eVar.invoke();
                AppMethodBeat.o(262173);
            }
        } else {
            AppMethodBeat.o(262173);
        }
    }

    public static final /* synthetic */ void b(o oVar) {
        AppMethodBeat.i(262174);
        Animator animator = oVar.UrM;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = oVar.UrN;
        if (animator2 != null) {
            animator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        oVar.hwr.setClickable(true);
        RelativeLayout relativeLayout = (RelativeLayout) oVar.hwr.findViewById(R.id.jue);
        p.g(relativeLayout, "root.educationLayoutContent");
        relativeLayout.setScaleX(0.0f);
        RelativeLayout relativeLayout2 = (RelativeLayout) oVar.hwr.findViewById(R.id.jue);
        p.g(relativeLayout2, "root.educationLayoutContent");
        relativeLayout2.setScaleY(0.0f);
        ofFloat.setDuration(450L);
        ofFloat.setInterpolator(new com.tencent.mm.msgsubscription.ui.a.a());
        ofFloat.addUpdateListener(new f(oVar));
        ofFloat.addListener(new g(oVar));
        ofFloat.start();
        oVar.UrM = ofFloat;
        AppMethodBeat.o(262174);
    }

    public static final /* synthetic */ void c(o oVar) {
        Drawable drawable;
        AppMethodBeat.i(262175);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) oVar.hwr.getContext().getString(R.string.j8h));
        ab abVar = ab.UzG;
        Drawable hRQ = ab.hRQ();
        if (hRQ == null) {
            drawable = oVar.hwr.getContext().getDrawable(R.drawable.cvt);
        } else {
            drawable = hRQ;
        }
        if (drawable != null) {
            TextView textView = (TextView) oVar.hwr.findViewById(R.id.jug);
            p.g(textView, "root.educationLayoutTitleTv");
            int lineHeight = textView.getLineHeight();
            TextView textView2 = (TextView) oVar.hwr.findViewById(R.id.jug);
            p.g(textView2, "root.educationLayoutTitleTv");
            drawable.setBounds(0, 0, lineHeight, textView2.getLineHeight());
            spannableStringBuilder.setSpan(new ImageSpan(drawable), spannableStringBuilder.length() - 12, spannableStringBuilder.length() - 11, 34);
        }
        TextView textView3 = (TextView) oVar.hwr.findViewById(R.id.jug);
        p.g(textView3, "root.educationLayoutTitleTv");
        textView3.setText(spannableStringBuilder);
        AppMethodBeat.o(262175);
    }
}
