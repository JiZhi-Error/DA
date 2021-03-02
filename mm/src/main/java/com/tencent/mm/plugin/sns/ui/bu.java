package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.d.c;

public final class bu {
    int CHZ = -1;
    c DQs;
    FrameLayout DQt;
    AbsoluteLayout DQu = null;
    protected Animation DQv;
    protected Animation DQw;
    boolean DQx = false;
    private b Eni;
    Context mContext;
    boolean onr = false;

    public bu(Context context, c cVar, FrameLayout frameLayout) {
        AppMethodBeat.i(99761);
        this.mContext = context;
        this.DQs = cVar;
        this.DQt = frameLayout;
        this.DQv = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.DQv = AnimationUtils.loadAnimation(context, R.anim.ax);
        this.DQw = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.DQw = AnimationUtils.loadAnimation(context, R.anim.ay);
        AppMethodBeat.o(99761);
    }

    class a {
        View Atk = null;

        public a(View view) {
            this.Atk = view;
        }
    }

    /* access modifiers changed from: package-private */
    public final void fw(final View view) {
        AppMethodBeat.i(99762);
        this.DQx = true;
        view.startAnimation(this.DQw);
        this.DQw.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.ui.bu.AnonymousClass4 */

            public final void onAnimationStart(Animation animation) {
                bu.this.DQx = true;
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(99760);
                if (view != null) {
                    view.clearAnimation();
                    view.setVisibility(8);
                    bu.this.fka();
                }
                bu.this.DQx = false;
                AppMethodBeat.o(99760);
            }
        });
        AppMethodBeat.o(99762);
    }

    public final boolean fka() {
        AppMethodBeat.i(99763);
        if (this.Eni != null && aj.faG().fco()) {
            this.Eni.fcl();
        }
        if (this.DQu != null) {
            this.DQt.removeView(this.DQu);
            this.DQu = null;
            AppMethodBeat.o(99763);
            return true;
        }
        this.DQx = false;
        AppMethodBeat.o(99763);
        return false;
    }

    static /* synthetic */ void a(bu buVar, View view) {
        AppMethodBeat.i(99764);
        view.setVisibility(0);
        buVar.DQx = true;
        buVar.DQv.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.ui.bu.AnonymousClass3 */

            public final void onAnimationStart(Animation animation) {
                bu.this.DQx = true;
            }

            public final void onAnimationEnd(Animation animation) {
                bu.this.DQx = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(buVar.DQv);
        AppMethodBeat.o(99764);
    }
}
