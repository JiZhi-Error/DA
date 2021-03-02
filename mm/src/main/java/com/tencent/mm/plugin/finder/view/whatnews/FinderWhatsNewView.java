package com.tencent.mm.plugin.finder.view.whatnews;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\rH\u0014J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0014J\b\u0010\u001c\u001a\u00020\rH\u0002R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "detachFinish", "Lkotlin/Function0;", "", "getDetachFinish", "()Lkotlin/jvm/functions/Function0;", "setDetachFinish", "(Lkotlin/jvm/functions/Function0;)V", "withEnterAnim", "", "getWithEnterAnim", "()Z", "setWithEnterAnim", "(Z)V", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnimation", "Companion", "plugin-finder_release"})
public final class FinderWhatsNewView extends FrameLayout {
    public static final a wtK = new a((byte) 0);
    private kotlin.g.a.a<x> wtI;
    private boolean wtJ;

    static {
        AppMethodBeat.i(168565);
        AppMethodBeat.o(168565);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        public static final b wtL = new b();

        static {
            AppMethodBeat.i(168555);
            AppMethodBeat.o(168555);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderWhatsNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (context == null) {
            p.hyc();
        }
        AppMethodBeat.i(168563);
        setId(R.id.d46);
        a aVar = a.wtG;
        a aVar2 = a.wtG;
        LayoutInflater.from(getContext()).inflate(R.layout.al8, (ViewGroup) this, true);
        this.wtI = b.wtL;
        AppMethodBeat.o(168563);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderWhatsNewView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (context == null) {
            p.hyc();
        }
        AppMethodBeat.i(168564);
        setId(R.id.d46);
        a aVar = a.wtG;
        a aVar2 = a.wtG;
        LayoutInflater.from(getContext()).inflate(R.layout.al8, (ViewGroup) this, true);
        this.wtI = b.wtL;
        AppMethodBeat.o(168564);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$Companion;", "", "()V", "attachToWindow", "Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "window", "Landroid/view/Window;", "withEnterAnim", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(168560);
        super.onMeasure(i2, i3);
        requestLayout();
        AppMethodBeat.o(168560);
    }

    public final kotlin.g.a.a<x> getDetachFinish() {
        return this.wtI;
    }

    public final void setDetachFinish(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(168561);
        p.h(aVar, "<set-?>");
        this.wtI = aVar;
        AppMethodBeat.o(168561);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(168562);
        super.onAttachedToWindow();
        Button button = (Button) findViewById(R.id.c40);
        a aVar = a.wtG;
        a aVar2 = a.wtG;
        p.g(button, LocaleUtil.ITALIAN);
        Context context = getContext();
        p.g(context, "context");
        button.setText(context.getResources().getString(R.string.dbg));
        button.setOnClickListener(new c(this));
        post(new d(this));
        AppMethodBeat.o(168562);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$1$1"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ FinderWhatsNewView wtM;

        c(FinderWhatsNewView finderWhatsNewView) {
            this.wtM = finderWhatsNewView;
        }

        public final void onClick(final View view) {
            AppMethodBeat.i(168557);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wtM.animate().alpha(0.0f).setDuration(300).setListener(new Animator.AnimatorListener(this) {
                /* class com.tencent.mm.plugin.finder.view.whatnews.FinderWhatsNewView.c.AnonymousClass1 */
                final /* synthetic */ c wtN;

                {
                    this.wtN = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(255313);
                    ViewParent parent = this.wtN.wtM.getParent();
                    if (parent == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(255313);
                        throw tVar;
                    }
                    ((ViewGroup) parent).removeView(view);
                    this.wtN.wtM.getDetachFinish().invoke();
                    AppMethodBeat.o(255313);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                }
            }).start();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168557);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ FinderWhatsNewView wtM;

        d(FinderWhatsNewView finderWhatsNewView) {
            this.wtM = finderWhatsNewView;
        }

        public final void run() {
            AppMethodBeat.i(168558);
            a aVar = a.wtG;
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_WHATS_NEW_SHOWN_BOOLEAN_SYNC, Boolean.TRUE);
            h.INSTANCE.n(1305, 0, 1);
            FinderWhatsNewView.a(this.wtM);
            AppMethodBeat.o(168558);
        }
    }

    public final boolean getWithEnterAnim() {
        return this.wtJ;
    }

    public final void setWithEnterAnim(boolean z) {
        this.wtJ = z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$startAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class e implements Animator.AnimatorListener {
        final /* synthetic */ FinderWhatsNewView wtM;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderWhatsNewView finderWhatsNewView) {
            this.wtM = finderWhatsNewView;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(255314);
            this.wtM.setTranslationX(0.0f);
            AppMethodBeat.o(255314);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public static final /* synthetic */ void a(FinderWhatsNewView finderWhatsNewView) {
        AppMethodBeat.i(168566);
        if (finderWhatsNewView.wtJ) {
            finderWhatsNewView.setTranslationX((float) finderWhatsNewView.getHeight());
            finderWhatsNewView.animate().translationY(0.0f).setDuration(200).setListener(new e(finderWhatsNewView)).start();
        }
        AppMethodBeat.o(168566);
    }
}
