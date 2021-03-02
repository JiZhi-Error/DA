package com.tencent.mm.plugin.finder.conv;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/conv/FinderConversation;)V", "getConv", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getView", "()Landroid/view/View;", "run", "", "plugin-finder_release"})
public final class b implements Runnable {
    final c tyo;
    final View view;

    public b(View view2, c cVar) {
        p.h(view2, "view");
        p.h(cVar, "conv");
        AppMethodBeat.i(242699);
        this.view = view2;
        this.tyo = cVar;
        AppMethodBeat.o(242699);
    }

    public final void run() {
        AppMethodBeat.i(242698);
        this.view.setSelected(false);
        Drawable drawable = this.view.getContext().getDrawable(R.color.x5);
        if (drawable == null) {
            p.hyc();
        }
        p.g(drawable, "view.context.getDrawable…lor.list_devider_color)!!");
        this.view.setBackground(drawable);
        ValueAnimator ofInt = ValueAnimator.ofInt(240);
        ofInt.addUpdateListener(new a(this, drawable));
        ofInt.setDuration(100L);
        ofInt.addListener(new C1097b(this, drawable));
        ofInt.start();
        AppMethodBeat.o(242698);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim$run$animator$1$1"})
    static final class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ b typ;
        final /* synthetic */ Drawable tyq;

        a(b bVar, Drawable drawable) {
            this.typ = bVar;
            this.tyq = drawable;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(242695);
            Drawable drawable = this.tyq;
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(242695);
                throw tVar;
            }
            drawable.setAlpha(255 - ((Integer) animatedValue).intValue());
            AppMethodBeat.o(242695);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim$run$animator$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.conv.b$b  reason: collision with other inner class name */
    public static final class C1097b implements Animator.AnimatorListener {
        final /* synthetic */ b typ;
        final /* synthetic */ Drawable tyq;

        C1097b(b bVar, Drawable drawable) {
            this.typ = bVar;
            this.tyq = drawable;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            int i2;
            AppMethodBeat.i(242696);
            this.tyq.setAlpha(255);
            View view = this.typ.view;
            if (this.typ.tyo.cZw()) {
                i2 = R.drawable.a_9;
            } else {
                i2 = R.drawable.qa;
            }
            view.setBackgroundResource(i2);
            AppMethodBeat.o(242696);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(242697);
            onAnimationEnd(animator);
            AppMethodBeat.o(242697);
        }

        public final void onAnimationStart(Animator animator) {
        }
    }
}
