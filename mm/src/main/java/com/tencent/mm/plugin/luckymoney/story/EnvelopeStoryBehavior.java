package com.tencent.mm.plugin.luckymoney.story;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Vibrator;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class EnvelopeStoryBehavior extends AppBarLayout.Behavior implements View.OnTouchListener {
    private Vibrator ooM = ((Vibrator) MMApplicationContext.getContext().getSystemService("vibrator"));
    private boolean xkO = false;
    private boolean xkP = false;
    boolean yZK = false;
    AppBarLayout.b zaA;
    private boolean zaB;
    private EnvelopeAppBarLayout zar;
    private int zas = 0;
    private RecyclerView zat;
    private float zau;
    private float zav;
    private boolean zaw;
    private boolean zax;
    private int zay = a.fromDPToPix(MMApplicationContext.getContext(), 300);
    boolean zaz = false;

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(163629);
        a(coordinatorLayout, (AppBarLayout) view, view2, i2, i3, i4, i5, i6);
        AppMethodBeat.o(163629);
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) {
        AppMethodBeat.i(163628);
        a(coordinatorLayout, (AppBarLayout) view, view2, i2, i3, iArr, i4);
        AppMethodBeat.o(163628);
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i2) {
        AppMethodBeat.i(163625);
        boolean b2 = b(coordinatorLayout, (AppBarLayout) view, i2);
        AppMethodBeat.o(163625);
        return b2;
    }

    @Override // android.support.design.widget.HeaderBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        AppMethodBeat.i(163624);
        AppBarLayout appBarLayout = (AppBarLayout) view;
        if (motionEvent.getAction() == 1) {
            motionEvent.setAction(3);
        }
        switch (motionEvent.getActionMasked()) {
            case 2:
                float y = motionEvent.getY();
                float x = motionEvent.getX();
                float f2 = y - this.zav;
                if (f2 > 0.0f) {
                    float f3 = 0.5f;
                    float totalScrollRange = (float) this.zar.getTotalScrollRange();
                    if (totalScrollRange != 0.0f) {
                        if (f2 > totalScrollRange) {
                            f3 = 0.0f;
                        } else {
                            f3 = (totalScrollRange - f2) / totalScrollRange;
                        }
                    }
                    float f4 = 1.0f - f3;
                    Log.d("MicroMsg.EnvelopeStoryBehavior", "lastY: %s, Y: %s", Float.valueOf(this.zav), Float.valueOf(motionEvent.getY()));
                    Matrix matrix = new Matrix();
                    matrix.setTranslate(0.0f, ((float) (((double) ((float) (((double) f4) * 0.2d * ((double) f4)))) + 0.3d)) * (-f2));
                    motionEvent.transform(matrix);
                    break;
                } else {
                    if (((double) (Math.abs(y - this.zav) / Math.abs(x - this.zau))) < 0.57d) {
                        AppMethodBeat.o(163624);
                        return false;
                    }
                }
                break;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.zaz) {
                efN();
            } else if (this.zar != null && this.yZK) {
                this.zar.b(false, true, true);
            } else if (!efL() && !efK()) {
                efM();
            }
        }
        boolean a2 = super.a(coordinatorLayout, (View) appBarLayout, motionEvent);
        AppMethodBeat.o(163624);
        return a2;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3) {
        AppMethodBeat.i(163626);
        AppBarLayout appBarLayout = (AppBarLayout) view;
        if (efL() || efK()) {
            boolean a2 = super.a(coordinatorLayout, appBarLayout, view2, f2, f3);
            AppMethodBeat.o(163626);
            return a2;
        }
        AppMethodBeat.o(163626);
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3, boolean z) {
        AppMethodBeat.i(163627);
        boolean a2 = super.a(coordinatorLayout, (AppBarLayout) view, view2, f2, f3, z);
        AppMethodBeat.o(163627);
        return a2;
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
        AppMethodBeat.i(163630);
        boolean a2 = a(coordinatorLayout, (AppBarLayout) view, view2, view3, i2, i3);
        AppMethodBeat.o(163630);
        return a2;
    }

    public EnvelopeStoryBehavior() {
        AppMethodBeat.i(163614);
        AppMethodBeat.o(163614);
    }

    public EnvelopeStoryBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(163615);
        AppMethodBeat.o(163615);
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.AppBarLayout.Behavior
    public final boolean b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        AppMethodBeat.i(163616);
        this.zar = (EnvelopeAppBarLayout) appBarLayout;
        this.zat = (RecyclerView) coordinatorLayout.findViewById(R.id.ezi);
        this.zas = (int) (((float) coordinatorLayout.getHeight()) / 10.0f);
        if (coordinatorLayout instanceof TouchCoordinatorLayout) {
            ((TouchCoordinatorLayout) coordinatorLayout).b(this);
        }
        boolean b2 = super.b(coordinatorLayout, appBarLayout, i2);
        AppMethodBeat.o(163616);
        return b2;
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.AppBarLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
        AppMethodBeat.i(163617);
        boolean a2 = super.a(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        AppMethodBeat.o(163617);
        return a2;
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.AppBarLayout.Behavior
    public final void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
        AppMethodBeat.i(163618);
        super.a(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        AppMethodBeat.o(163618);
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.AppBarLayout.Behavior
    public final void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        AppMethodBeat.i(163619);
        if (i6 != 1 || !this.xkP) {
            int totalScrollRange = (this.zar.getTotalScrollRange() - Math.abs(bT())) + Math.abs(i5);
            Log.d("MicroMsg.EnvelopeStoryBehavior", "distance: ".concat(String.valueOf(totalScrollRange)));
            float f2 = 0.7f;
            float totalScrollRange2 = (float) this.zar.getTotalScrollRange();
            if (totalScrollRange2 != 0.0f) {
                if (((float) totalScrollRange) > totalScrollRange2) {
                    f2 = 0.0f;
                } else {
                    f2 = (totalScrollRange2 - ((float) totalScrollRange)) / totalScrollRange2;
                }
            }
            if (totalScrollRange > 0) {
                float f3 = 1.0f - f2;
                i7 = (int) (((float) (((double) ((float) (((double) f3) * 0.2d * ((double) f3)))) + 0.5d)) * ((float) i5));
            } else {
                i7 = i5;
            }
            super.a(coordinatorLayout, appBarLayout, view, i2, i3, i4, i7, i6);
            AppMethodBeat.o(163619);
            return;
        }
        if (i3 == 0) {
            Log.i("MicroMsg.EnvelopeStoryBehavior", "stop verticalRecyclerView scroll!");
            this.zat.kQ();
        }
        AppMethodBeat.o(163619);
    }

    private boolean efK() {
        AppMethodBeat.i(163620);
        if (this.zar.getTotalScrollRange() == Math.abs(bT())) {
            AppMethodBeat.o(163620);
            return true;
        }
        AppMethodBeat.o(163620);
        return false;
    }

    private boolean efL() {
        AppMethodBeat.i(163621);
        if (Math.abs(bT()) <= 0) {
            AppMethodBeat.o(163621);
            return true;
        }
        AppMethodBeat.o(163621);
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(163622);
        if (motionEvent.getAction() == 0) {
            this.zau = motionEvent.getX();
            this.zav = motionEvent.getY();
            this.zaw = false;
            this.zax = false;
            this.xkO = efL();
            this.xkP = efK();
            if (!hWe() && (this.xkP || this.xkO)) {
                z = false;
            }
            this.zaB = z;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.zaz) {
                efN();
            } else if (this.zar != null && this.yZK) {
                this.zar.b(false, true, true);
            } else if (!efL() && !efK()) {
                efM();
            }
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.zav;
            if (this.zar != null && !this.yZK && y > 0.0f && bT() != 0) {
                if (bT() + this.zar.getTotalScrollRange() < this.zas) {
                    this.zax = true;
                } else if (this.zaB && !this.zaw && bT() + this.zay >= this.zas) {
                    this.zaw = true;
                    this.ooM.vibrate(10);
                }
            }
        }
        AppMethodBeat.o(163622);
        return false;
    }

    private void efM() {
        AppMethodBeat.i(163623);
        if ((!this.xkP || bT() + this.zar.getTotalScrollRange() > this.zas) && (!this.xkO || Math.abs(bT()) < this.zas)) {
            if (!hWe()) {
                this.zar.b(true, true, true);
            }
            AppMethodBeat.o(163623);
            return;
        }
        this.zar.b(false, true, true);
        AppMethodBeat.o(163623);
    }

    private boolean hWe() {
        AppMethodBeat.i(258609);
        if (this.zar.getTotalScrollRange() - Math.abs(bT()) == this.zay) {
            AppMethodBeat.o(258609);
            return true;
        }
        AppMethodBeat.o(258609);
        return false;
    }

    private void efN() {
        AppMethodBeat.i(174342);
        int bT = bT();
        int totalScrollRange = this.zar.getTotalScrollRange();
        if (this.zaB) {
            if (totalScrollRange - Math.abs(bT) < this.zay) {
                this.zar.b(false, true, true);
                AppMethodBeat.o(174342);
            } else if (this.yZK) {
                efO();
                AppMethodBeat.o(174342);
            } else {
                efM();
                AppMethodBeat.o(174342);
            }
        } else if (this.xkP) {
            if (bT() + this.zar.getTotalScrollRange() <= this.zas) {
                this.zar.b(false, true, true);
                AppMethodBeat.o(174342);
                return;
            }
            efO();
            AppMethodBeat.o(174342);
        } else if (!this.xkO || Math.abs(bT()) < this.zas) {
            efM();
            AppMethodBeat.o(174342);
        } else if (totalScrollRange - Math.abs(bT) < this.zay) {
            this.zar.b(false, true, true);
            AppMethodBeat.o(174342);
        } else {
            efO();
            AppMethodBeat.o(174342);
        }
    }

    private void efO() {
        AppMethodBeat.i(174343);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(200L);
        valueAnimator.setIntValues(bT(), -(this.zar.getTotalScrollRange() - this.zay));
        valueAnimator.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryBehavior.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(174339);
                EnvelopeStoryBehavior.this.G(-(EnvelopeStoryBehavior.this.zar.getTotalScrollRange() - EnvelopeStoryBehavior.this.zay));
                AppMethodBeat.o(174339);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryBehavior.AnonymousClass2 */
            int zak = EnvelopeStoryBehavior.this.bT();

            {
                AppMethodBeat.i(174340);
                AppMethodBeat.o(174340);
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(174341);
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.zak = intValue;
                Log.d("MicroMsg.EnvelopeStoryBehavior", "animate middle: %s", Integer.valueOf(intValue));
                EnvelopeStoryBehavior.this.G(intValue);
                if (EnvelopeStoryBehavior.this.zaA != null) {
                    EnvelopeStoryBehavior.this.zaA.c(EnvelopeStoryBehavior.this.zar, intValue);
                }
                AppMethodBeat.o(174341);
            }
        });
        valueAnimator.start();
        AppMethodBeat.o(174343);
    }
}
