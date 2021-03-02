package com.tencent.luggage.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class h {
    protected l ctf = new l();
    public j ctg;
    protected a cth;
    public Context mContext;

    /* access modifiers changed from: protected */
    public abstract View Lf();

    /* access modifiers changed from: protected */
    public abstract void destroy();

    public abstract void g(String str, Bundle bundle);

    public abstract View getContentView();

    public h(j jVar) {
        this.mContext = jVar.getContext();
        this.ctg = jVar;
    }

    public void a(a aVar) {
        this.cth = aVar;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final j Lg() {
        return this.ctg;
    }

    public final void Li() {
        onForeground();
        this.ctf.Q(l.d.class);
    }

    /* access modifiers changed from: protected */
    public void onForeground() {
    }

    public final void Lj() {
        onBackground();
        this.ctf.Q(l.b.class);
    }

    /* access modifiers changed from: protected */
    public void onBackground() {
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void Ll() {
        onDestroy();
        this.ctf.Q(l.c.class);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: package-private */
    public final void a(Animator animator, final Runnable runnable) {
        animator.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.luggage.d.h.AnonymousClass1 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(140373);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(140373);
            }
        });
        animator.start();
    }

    public static class a {
        protected a ctj;

        public a() {
        }

        protected a(a aVar) {
            this.ctj = aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final void Lh() {
        this.ctf.Q(l.e.class);
    }

    public final boolean Lk() {
        return this.ctf.Q(l.a.class) || onBackPressed();
    }

    /* access modifiers changed from: package-private */
    public final void g(Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getContentView(), "translationX", -(((float) getContentView().getWidth()) * 0.25f), 0.0f);
        ofFloat.setDuration(250L);
        a(ofFloat, runnable);
    }

    /* access modifiers changed from: package-private */
    public final void h(Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getContentView(), "translationX", 0.0f, (float) getContentView().getWidth());
        ofFloat.setDuration(250L);
        a(ofFloat, runnable);
    }
}
