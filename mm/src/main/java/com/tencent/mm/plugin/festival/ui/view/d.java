package com.tencent.mm.plugin.festival.ui.view;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fJ\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasPopupAnimation;", "", "()V", "ENTER_ANIMATION_DURATION", "", "EXIT_ANIMATION_DURATION", "startEnterAnimation", "", "view", "Landroid/view/View;", "showDelay", "onEnd", "Lkotlin/Function0;", "startExitAnimation", "plugin-festival_release"})
public final class d {
    public static final d UFJ = new d();

    static {
        AppMethodBeat.i(263438);
        AppMethodBeat.o(263438);
    }

    private d() {
    }

    public static void a(View view, long j2, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(263436);
        p.h(view, "view");
        p.h(aVar, "onEnd");
        ViewPropertyAnimator animate = view.animate();
        if (animate != null) {
            animate.cancel();
        }
        view.setPivotX(((float) view.getWidth()) / 2.0f);
        view.setPivotY(((float) view.getHeight()) / 2.0f);
        view.setScaleX(0.1f);
        view.setScaleY(0.1f);
        view.setAlpha(0.0f);
        ViewPropertyAnimator animate2 = view.animate();
        animate2.setDuration(300);
        animate2.setStartDelay(j2);
        animate2.scaleX(1.0f);
        animate2.scaleY(1.0f);
        animate2.alpha(1.0f);
        animate2.setListener(new a(j2, aVar, view));
        animate2.start();
        AppMethodBeat.o(263436);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/ui/view/FestivalCanvasPopupAnimation$startEnterAnimation$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-festival_release"})
    public static final class a implements Animator.AnimatorListener {
        final /* synthetic */ long UFh;
        final /* synthetic */ kotlin.g.a.a Usj;
        final /* synthetic */ View tBN;

        a(long j2, kotlin.g.a.a aVar, View view) {
            this.UFh = j2;
            this.Usj = aVar;
            this.tBN = view;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(263433);
            this.Usj.invoke();
            AppMethodBeat.o(263433);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(263434);
            this.tBN.setScaleX(1.0f);
            this.tBN.setScaleY(1.0f);
            this.tBN.setAlpha(1.0f);
            AppMethodBeat.o(263434);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    public static void b(View view, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(263437);
        p.h(view, "view");
        p.h(aVar, "onEnd");
        ViewPropertyAnimator animate = view.animate();
        if (animate != null) {
            animate.cancel();
        }
        ViewPropertyAnimator animate2 = view.animate();
        animate2.alpha(0.0f);
        animate2.scaleX(0.1f);
        animate2.scaleY(0.1f);
        animate2.setStartDelay(0);
        animate2.setDuration(500);
        animate2.setListener(new b(aVar));
        animate2.start();
        AppMethodBeat.o(263437);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/ui/view/FestivalCanvasPopupAnimation$startExitAnimation$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-festival_release"})
    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ kotlin.g.a.a Usj;

        b(kotlin.g.a.a aVar) {
            this.Usj = aVar;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(263435);
            this.Usj.invoke();
            AppMethodBeat.o(263435);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }
}
