package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation;", "Lcom/tencent/mm/plugin/finder/view/animation/DefaultItemAnimator;", "()V", "animateAdd", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "animateAddImpl", "", "animateRemove", "animateRemoveImpl", "getAddDelay", "", "getAddDuration", "getRemoveDelay", "getRemoveDuration", "Companion", "plugin-finder_release"})
public final class d extends a {
    public static final a wrL = new a((byte) 0);

    static {
        AppMethodBeat.i(255188);
        AppMethodBeat.o(255188);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.view.animation.a, android.support.v7.widget.as
    public final boolean b(RecyclerView.v vVar) {
        AppMethodBeat.i(255184);
        p.h(vVar, "holder");
        e(vVar);
        this.aml.add(vVar);
        AppMethodBeat.o(255184);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.finder.view.animation.a
    public final void aa(RecyclerView.v vVar) {
        AppMethodBeat.i(255185);
        if (vVar == null) {
            p.hyc();
        }
        View view = vVar.aus;
        p.g(view, "holder!!.itemView");
        view.setAlpha(0.3f);
        ViewPropertyAnimator animate = view.animate();
        this.amu.add(vVar);
        ViewPropertyAnimator alpha = animate.setDuration(200).alpha(0.0f);
        View view2 = vVar.aus;
        p.g(view2, "holder.itemView");
        Context context = view2.getContext();
        p.g(context, "holder.itemView.context");
        alpha.translationY(context.getResources().getDimension(R.dimen.cn)).setStartDelay(0).setListener(new c(this, vVar, view, animate)).start();
        AppMethodBeat.o(255185);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "animator", "onAnimationStart", "plugin-finder_release"})
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ View hCI;
        final /* synthetic */ d wrM;
        final /* synthetic */ RecyclerView.v wrN;
        final /* synthetic */ ViewPropertyAnimator wrO;

        c(d dVar, RecyclerView.v vVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.wrM = dVar;
            this.wrN = vVar;
            this.hCI = view;
            this.wrO = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(255181);
            p.h(animator, "animator");
            this.wrM.A(this.wrN);
            AppMethodBeat.o(255181);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(255182);
            p.h(animator, "animation");
            onAnimationEnd(animator);
            AppMethodBeat.o(255182);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(255183);
            p.h(animator, "animator");
            f.ej(this.hCI);
            this.wrO.setListener(null);
            this.wrM.w(this.wrN);
            this.wrM.amu.remove(this.wrN);
            this.wrM.jE();
            AppMethodBeat.o(255183);
        }
    }

    @Override // com.tencent.mm.plugin.finder.view.animation.a, android.support.v7.widget.as
    public final boolean c(RecyclerView.v vVar) {
        AppMethodBeat.i(255186);
        p.h(vVar, "holder");
        e(vVar);
        if (vVar.lU() != -3) {
            View view = vVar.aus;
            p.g(view, "holder.itemView");
            view.setAlpha(0.0f);
            this.amm.add(vVar);
        }
        AppMethodBeat.o(255186);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.finder.view.animation.a
    public final void ab(RecyclerView.v vVar) {
        AppMethodBeat.i(255187);
        if (vVar == null) {
            p.hyc();
        }
        View view = vVar.aus;
        p.g(view, "holder!!.itemView");
        ViewPropertyAnimator animate = view.animate();
        this.ams.add(vVar);
        animate.alpha(1.0f).setStartDelay(0).setDuration(260).setListener(new b(this, vVar, view, animate)).start();
        AppMethodBeat.o(255187);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "plugin-finder_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ View hCI;
        final /* synthetic */ d wrM;
        final /* synthetic */ RecyclerView.v wrN;
        final /* synthetic */ ViewPropertyAnimator wrO;

        b(d dVar, RecyclerView.v vVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.wrM = dVar;
            this.wrN = vVar;
            this.hCI = view;
            this.wrO = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(255178);
            p.h(animator, "animator");
            AppMethodBeat.o(255178);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(255179);
            p.h(animator, "animator");
            onAnimationEnd(animator);
            AppMethodBeat.o(255179);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(255180);
            p.h(animator, "animator");
            f.ej(this.hCI);
            this.wrO.setListener(null);
            this.wrM.y(this.wrN);
            this.wrM.ams.remove(this.wrN);
            this.wrM.jE();
            AppMethodBeat.o(255180);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.finder.view.animation.a
    public final long dHo() {
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final long lx() {
        return 260;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final long ly() {
        return 200;
    }
}
