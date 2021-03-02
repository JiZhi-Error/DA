package com.tencent.mm.ui.widget.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.snackbar.a;
import java.util.LinkedList;
import java.util.Queue;

public class SnackContainer extends FrameLayout {
    private AnimationSet PpM;
    Queue<a> QVC = new LinkedList();
    private AnimationSet QVD;
    private final Runnable mHideRunnable = new Runnable() {
        /* class com.tencent.mm.ui.widget.snackbar.SnackContainer.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(159719);
            if (SnackContainer.this.getVisibility() == 0) {
                SnackContainer.this.startAnimation(SnackContainer.this.QVD);
            }
            AppMethodBeat.o(159719);
        }
    };

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(159735);
        b(aVar);
        AppMethodBeat.o(159735);
    }

    public SnackContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159724);
        init();
        AppMethodBeat.o(159724);
    }

    SnackContainer(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        AppMethodBeat.i(159725);
        viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        setVisibility(8);
        setId(R.id.hts);
        init();
        AppMethodBeat.o(159725);
    }

    private void init() {
        AppMethodBeat.i(159726);
        this.PpM = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.PpM.setInterpolator(new DecelerateInterpolator(1.5f));
        this.PpM.addAnimation(translateAnimation);
        this.PpM.addAnimation(alphaAnimation);
        this.QVD = new AnimationSet(false);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, 1.0f);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.QVD.addAnimation(translateAnimation2);
        this.QVD.addAnimation(alphaAnimation2);
        this.QVD.setDuration(300);
        this.QVD.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.ui.widget.snackbar.SnackContainer.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(159720);
                if (!(SnackContainer.this.isEmpty() || SnackContainer.this.QVC.peek() == null || ((a) SnackContainer.this.QVC.peek()).QVJ == null)) {
                    b.Dt(false);
                    ((a) SnackContainer.this.QVC.peek()).QVJ.bDY();
                }
                AppMethodBeat.o(159720);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(159721);
                SnackContainer.this.removeAllViews();
                if (!SnackContainer.this.QVC.isEmpty()) {
                    SnackContainer.d((a) SnackContainer.this.QVC.poll());
                }
                if (!SnackContainer.this.isEmpty()) {
                    SnackContainer.a(SnackContainer.this, (a) SnackContainer.this.QVC.peek());
                    AppMethodBeat.o(159721);
                    return;
                }
                SnackContainer.this.setVisibility(8);
                AppMethodBeat.o(159721);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        AppMethodBeat.o(159726);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(159727);
        super.onDetachedFromWindow();
        this.PpM.cancel();
        this.QVD.cancel();
        removeCallbacks(this.mHideRunnable);
        this.QVC.clear();
        AppMethodBeat.o(159727);
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(159728);
        boolean isEmpty = this.QVC.isEmpty();
        AppMethodBeat.o(159728);
        return isEmpty;
    }

    public final boolean isShowing() {
        AppMethodBeat.i(159729);
        if (!this.QVC.isEmpty()) {
            AppMethodBeat.o(159729);
            return true;
        }
        AppMethodBeat.o(159729);
        return false;
    }

    public final void hide() {
        AppMethodBeat.i(159730);
        removeCallbacks(this.mHideRunnable);
        this.mHideRunnable.run();
        AppMethodBeat.o(159730);
    }

    /* access modifiers changed from: package-private */
    public final void a(final a aVar) {
        AppMethodBeat.i(159731);
        setVisibility(0);
        c(aVar);
        addView(aVar.QVG);
        aVar.tF.setText(aVar.QVI.mMessage);
        if (aVar.QVI.QVo != null) {
            aVar.QVH.setVisibility(0);
            aVar.QVH.setText(aVar.QVI.QVo);
        } else {
            aVar.QVH.setVisibility(8);
        }
        this.PpM.setDuration(500);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.br);
        loadAnimation.setDuration(500);
        startAnimation(this.PpM);
        loadAnimation.setStartOffset(200);
        aVar.QVH.startAnimation(loadAnimation);
        aVar.tF.startAnimation(loadAnimation);
        if (aVar.QVI.QVr > 0) {
            postDelayed(this.mHideRunnable, (long) aVar.QVI.QVr);
        }
        aVar.QVG.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.widget.snackbar.SnackContainer.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(159722);
                switch (motionEvent.getAction()) {
                    case 4:
                        SnackContainer.this.removeCallbacks(SnackContainer.this.mHideRunnable);
                        SnackContainer.d(aVar);
                        SnackContainer.this.startAnimation(SnackContainer.this.QVD);
                        if (!SnackContainer.this.QVC.isEmpty()) {
                            SnackContainer.this.QVC.clear();
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(159722);
                return true;
            }
        });
        AppMethodBeat.o(159731);
    }

    private static void b(a aVar) {
        AppMethodBeat.i(159732);
        if (aVar.QVJ != null) {
            b.Dt(false);
            aVar.QVJ.onHide();
        }
        AppMethodBeat.o(159732);
    }

    private static void c(a aVar) {
        AppMethodBeat.i(159733);
        if (aVar.QVJ != null) {
            b.Dt(true);
            aVar.QVJ.onShow();
        }
        AppMethodBeat.o(159733);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        AppMethodBeat.i(159734);
        super.onVisibilityChanged(view, i2);
        if (8 == i2) {
            removeAllViews();
            if (!this.QVC.isEmpty()) {
                b(this.QVC.poll());
            }
            if (!isEmpty()) {
                a(this.QVC.peek());
            } else {
                setVisibility(8);
            }
            b.Dt(false);
        }
        AppMethodBeat.o(159734);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        final View QVG;
        final TextView QVH;
        final Snack QVI;
        final a.c QVJ;
        final TextView tF;

        /* synthetic */ a(Snack snack, View view, a.c cVar, byte b2) {
            this(snack, view, cVar);
        }

        private a(Snack snack, View view, a.c cVar) {
            AppMethodBeat.i(159723);
            this.QVG = view;
            this.QVH = (TextView) view.findViewById(R.id.htr);
            this.tF = (TextView) view.findViewById(R.id.htt);
            this.QVI = snack;
            this.QVJ = cVar;
            AppMethodBeat.o(159723);
        }
    }

    static /* synthetic */ void a(SnackContainer snackContainer, a aVar) {
        AppMethodBeat.i(159736);
        snackContainer.a(aVar);
        AppMethodBeat.o(159736);
    }
}
