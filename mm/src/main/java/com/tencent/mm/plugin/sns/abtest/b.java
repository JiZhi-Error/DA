package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b {
    int DrA = 0;
    int DrB = 0;
    boolean DrC = false;
    AbsoluteLayout DrD = null;
    boolean DrE = false;
    boolean DrF = false;
    NotInterestMenu.c Drl;
    NotInterestMenu Drq;
    ViewGroup Drr;
    NotInterestMenu.b Drs = new NotInterestMenu.b() {
        /* class com.tencent.mm.plugin.sns.abtest.b.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.sns.abtest.NotInterestMenu.b
        public final void eWx() {
            AppMethodBeat.i(94945);
            b.this.eWy();
            AppMethodBeat.o(94945);
        }
    };
    Animation Drt = null;
    Animation Dru = null;
    private Animation Drv = null;
    private Animation Drw = null;
    int Drx = 0;
    int Dry = 0;
    int Drz = 0;
    int mActionBarHeight = 0;
    int mScreenHeight = 0;
    int mStatusBarHeight = 0;

    public b(ViewGroup viewGroup) {
        AppMethodBeat.i(94952);
        this.Drr = viewGroup;
        this.Drt = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.ax);
        this.Drt.setFillAfter(true);
        this.Drt.setDuration(100);
        this.Drt.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.abtest.b.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
                b.this.DrE = true;
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(94946);
                if (b.this.Drq != null) {
                    b.this.Drq.setVisibility(0);
                }
                b.this.DrE = false;
                b.this.DrC = true;
                AppMethodBeat.o(94946);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.Dru = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.b0);
        this.Dru.setFillAfter(true);
        this.Dru.setDuration(100);
        this.Dru.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.abtest.b.AnonymousClass3 */

            public final void onAnimationStart(Animation animation) {
                b.this.DrE = true;
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(94947);
                if (b.this.Drq != null) {
                    b.this.Drq.setVisibility(0);
                }
                b.this.DrE = false;
                b.this.DrC = true;
                AppMethodBeat.o(94947);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.Drv = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.ay);
        this.Drv.setFillAfter(true);
        this.Drv.setDuration(100);
        this.Drv.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.abtest.b.AnonymousClass4 */

            public final void onAnimationStart(Animation animation) {
                b.this.DrE = true;
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(94949);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.abtest.b.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(94948);
                        b.this.eWy();
                        AppMethodBeat.o(94948);
                    }
                });
                b.this.DrE = false;
                AppMethodBeat.o(94949);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.Drw = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.az);
        this.Drw.setFillAfter(true);
        this.Drw.setDuration(100);
        this.Drw.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.abtest.b.AnonymousClass5 */

            public final void onAnimationStart(Animation animation) {
                b.this.DrE = true;
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(94951);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.abtest.b.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(94950);
                        b.this.eWy();
                        AppMethodBeat.o(94950);
                    }
                });
                b.this.DrE = false;
                AppMethodBeat.o(94951);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        AppMethodBeat.o(94952);
    }

    public final void eWy() {
        AppMethodBeat.i(94953);
        if (!(this.DrD == null || this.Drr == null || this.Drq == null)) {
            this.DrD.removeView(this.Drq);
            this.Drr.removeView(this.DrD);
            this.DrD = null;
            this.Drq = null;
            this.DrC = false;
        }
        AppMethodBeat.o(94953);
    }
}
