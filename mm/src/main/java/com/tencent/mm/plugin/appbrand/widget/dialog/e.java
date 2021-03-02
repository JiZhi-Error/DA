package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Looper;
import android.support.v4.e.b;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import com.tencent.luggage.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e extends RelativeLayout implements m {
    private final j GdC = new j(this);
    private final LinkedList<k> GdH = new LinkedList<>();
    private final Runnable GdI = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.dialog.e.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(131478);
            e.this.setBackgroundColor(0);
            e.this.removeAllViews();
            e.this.setVisibility(4);
            AppMethodBeat.o(131478);
        }
    };
    private k GdJ;
    private k GdV;
    private Set<l> GeA = new b();
    private final Set<Object> GeR = new b();
    private final Set<Object> GeS = new b();
    private boolean GeW = false;
    private boolean GfG = true;
    private boolean ddZ = false;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.appbrand.widget.dialog.e.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(131477);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view == e.this) {
                e.a(e.this);
            }
            a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131477);
        }
    };
    private final MMHandler mQp = new MMHandler(Looper.getMainLooper());
    private int mRotation = 0;

    public e(Context context) {
        super(context);
        AppMethodBeat.i(131483);
        setVisibility(4);
        setBackgroundColor(0);
        setOnClickListener(this.mOnClickListener);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null) {
            this.mRotation = windowManager.getDefaultDisplay().getRotation();
        }
        AppMethodBeat.o(131483);
    }

    public final void setShouldBringSelfToFrontWhenDialogShown(boolean z) {
        this.GfG = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.m
    public final void b(final k kVar) {
        RelativeLayout.LayoutParams layoutParams;
        AppMethodBeat.i(131484);
        if (kVar == null) {
            AppMethodBeat.o(131484);
            return;
        }
        Log.i("MicroMsg.AppBrandDialogContainerLayout", "showDialog dialog[%s] tid[%d]", kVar.getClass().getName(), Long.valueOf(Thread.currentThread().getId()));
        if (Looper.getMainLooper() != Looper.myLooper()) {
            this.mQp.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.dialog.e.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(131479);
                    e.this.b(kVar);
                    AppMethodBeat.o(131479);
                }
            });
            AppMethodBeat.o(131484);
            return;
        }
        g.aM(getContext());
        if (this.GdC.isRunning()) {
            this.GdC.cancel();
        }
        View contentView = kVar.getContentView();
        if (contentView == null) {
            Log.w("MicroMsg.AppBrandDialogContainerLayout", "showDialog NULL dialogView from dialog[%s], stack=%s", kVar, android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(131484);
            return;
        }
        if (contentView.getParent() != this) {
            cS(contentView);
            if (kVar.getPosition() == 2) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(14);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
            }
            addView(contentView, layoutParams);
            if (this.GdV != kVar) {
                contentView.clearAnimation();
                if (kVar.getPosition() == 2) {
                    contentView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.c8));
                } else {
                    contentView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.a_));
                }
            }
            this.GdV = kVar;
        }
        contentView.setOnClickListener(this.mOnClickListener);
        this.GdH.add(kVar);
        kVar.a(this);
        setVisibility(0);
        if (this.GfG) {
            bringToFront();
        }
        this.GdC.c(Color.argb((int) TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, 0, 0, 0), null);
        if (!this.GeA.isEmpty() && !this.ddZ) {
            for (l lVar : this.GeA) {
                lVar.h(Boolean.TRUE);
            }
        }
        this.ddZ = true;
        AppMethodBeat.o(131484);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.m
    public final void c(final k kVar) {
        AppMethodBeat.i(131485);
        if (kVar == null || kVar.getContentView() == null) {
            AppMethodBeat.o(131485);
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            this.mQp.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.dialog.e.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(204428);
                    e.this.c(kVar);
                    AppMethodBeat.o(204428);
                }
            });
            AppMethodBeat.o(131485);
        } else if (kVar.getContentView().getParent() != this) {
            AppMethodBeat.o(131485);
        } else if (this.GdJ == kVar) {
            AppMethodBeat.o(131485);
        } else {
            this.GdJ = kVar;
            if (this.GdV == kVar) {
                this.GdV = null;
            }
            final View contentView = kVar.getContentView();
            contentView.animate().cancel();
            contentView.clearAnimation();
            Animator P = P(contentView, kVar.getPosition());
            P.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.appbrand.widget.dialog.e.AnonymousClass5 */

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(204430);
                    onAnimationEnd(animator);
                    AppMethodBeat.o(204430);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(204431);
                    contentView.setVisibility(8);
                    e.this.GdH.remove(kVar);
                    e.this.GdJ = null;
                    e.this.post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.widget.dialog.e.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(204429);
                            e.this.removeView(contentView);
                            e.this.GeW = true;
                            Iterator it = e.this.GeR.iterator();
                            while (it.hasNext()) {
                                it.next();
                            }
                            e.this.GeW = false;
                            if (!e.this.GeS.isEmpty()) {
                                e.this.GeR.removeAll(e.this.GeS);
                                e.this.GeS.clear();
                            }
                            AppMethodBeat.o(204429);
                        }
                    });
                    AppMethodBeat.o(204431);
                }
            });
            P.start();
            if (this.GdH.size() <= 1) {
                this.GdC.c(0, this.GdI);
            }
            if (!this.GeA.isEmpty() && this.ddZ) {
                for (l lVar : this.GeA) {
                    lVar.h(Boolean.FALSE);
                }
            }
            this.ddZ = false;
            AppMethodBeat.o(131485);
        }
    }

    public final void onViewRemoved(View view) {
        AppMethodBeat.i(204433);
        super.onViewRemoved(view);
        if (this.GdH.size() == 0) {
            this.GdC.c(0, this.GdI);
        }
        AppMethodBeat.o(204433);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.m
    public final void a(l lVar) {
        AppMethodBeat.i(176008);
        this.GeA.add(lVar);
        AppMethodBeat.o(176008);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.m
    public final void b(l lVar) {
        AppMethodBeat.i(176009);
        this.GeA.remove(lVar);
        AppMethodBeat.o(176009);
    }

    public final void cbm() {
        AppMethodBeat.i(183778);
        if (this.GdC.isRunning()) {
            this.GdC.cancel();
        }
        if (!this.GdH.isEmpty()) {
            AnonymousClass6 r0 = new android.arch.a.c.a<k, Void>() {
                /* class com.tencent.mm.plugin.appbrand.widget.dialog.e.AnonymousClass6 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.arch.a.c.a
                public final /* synthetic */ Void apply(k kVar) {
                    AppMethodBeat.i(204432);
                    k kVar2 = kVar;
                    if (!(kVar2 == null || kVar2.getContentView() == null)) {
                        View contentView = kVar2.getContentView();
                        contentView.animate().cancel();
                        contentView.clearAnimation();
                    }
                    AppMethodBeat.o(204432);
                    return null;
                }
            };
            while (!this.GdH.isEmpty()) {
                r0.apply(this.GdH.pollFirst());
            }
        }
        this.GdJ = null;
        this.GdV = null;
        this.GeW = false;
        this.GeR.clear();
        this.GeS.clear();
        removeAllViewsInLayout();
        this.mQp.removeCallbacksAndMessages(null);
        this.GdI.run();
        AppMethodBeat.o(183778);
    }

    public final k getCurrentDialog() {
        AppMethodBeat.i(131486);
        k peekLast = this.GdH.peekLast();
        AppMethodBeat.o(131486);
        return peekLast;
    }

    private static void cS(View view) {
        AppMethodBeat.i(131487);
        if (view == null || view.getParent() == null) {
            AppMethodBeat.o(131487);
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
        AppMethodBeat.o(131487);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(131488);
        if (getChildCount() == 0) {
            AppMethodBeat.o(131488);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(131488);
        return dispatchTouchEvent;
    }

    public final boolean onBackPressed() {
        AppMethodBeat.i(131489);
        k peekLast = this.GdH.peekLast();
        if (peekLast == null) {
            setVisibility(8);
            AppMethodBeat.o(131489);
            return false;
        }
        if (!peekLast.bjb() && peekLast.isCancelable()) {
            peekLast.onCancel();
            c(peekLast);
        }
        AppMethodBeat.o(131489);
        return true;
    }

    private static Animator P(View view, int i2) {
        AppMethodBeat.i(131490);
        if (i2 == 2) {
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", 0.0f, (float) view.getHeight()).setDuration(200L);
            duration.setInterpolator(accelerateInterpolator);
            animatorSet.playTogether(duration);
            AppMethodBeat.o(131490);
            return animatorSet;
        }
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(view.getContext(), R.anim.aq);
        Interpolator loadInterpolator2 = AnimationUtils.loadInterpolator(view.getContext(), R.anim.ap);
        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.9f).setDuration(220L);
        duration2.setInterpolator(loadInterpolator);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.9f).setDuration(220L);
        duration3.setInterpolator(loadInterpolator);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(150L);
        duration4.setInterpolator(loadInterpolator2);
        animatorSet2.playTogether(duration2, duration3, duration4);
        AppMethodBeat.o(131490);
        return animatorSet2;
    }

    /* access modifiers changed from: protected */
    public final void onConfigurationChanged(Configuration configuration) {
        int rotation;
        AppMethodBeat.i(131491);
        super.onConfigurationChanged(configuration);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (!(windowManager == null || this.mRotation == (rotation = windowManager.getDefaultDisplay().getRotation()))) {
            this.mRotation = rotation;
            Iterator<k> it = this.GdH.iterator();
            while (it.hasNext()) {
                it.next().ut(this.mRotation);
            }
        }
        AppMethodBeat.o(131491);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(131492);
        k peekLast = eVar.GdH.peekLast();
        if (peekLast == null) {
            eVar.setVisibility(8);
            AppMethodBeat.o(131492);
            return;
        }
        if (peekLast.bjc()) {
            peekLast.onCancel();
            eVar.c(peekLast);
        }
        AppMethodBeat.o(131492);
    }
}
