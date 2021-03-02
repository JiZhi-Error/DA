package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

/* access modifiers changed from: package-private */
public final class z extends RecyclerView.h implements RecyclerView.k {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] PRESSED_STATE_SET = {16842919};
    private int Wx = 0;
    private final int[] anA = new int[2];
    private final int[] anB = new int[2];
    final ValueAnimator anC = ValueAnimator.ofFloat(0.0f, 1.0f);
    int anD = 0;
    private final RecyclerView.l anE = new RecyclerView.l() {
        /* class android.support.v7.widget.z.AnonymousClass2 */

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            boolean z;
            z zVar = z.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = zVar.mRecyclerView.computeVerticalScrollRange();
            int i4 = zVar.anx;
            zVar.any = computeVerticalScrollRange - i4 > 0 && zVar.anx >= zVar.anh;
            int computeHorizontalScrollRange = zVar.mRecyclerView.computeHorizontalScrollRange();
            int i5 = zVar.anw;
            if (computeHorizontalScrollRange - i5 <= 0 || zVar.anw < zVar.anh) {
                z = false;
            } else {
                z = true;
            }
            zVar.anz = z;
            if (zVar.any || zVar.anz) {
                if (zVar.any) {
                    zVar.anr = (int) (((((float) computeVerticalScrollOffset) + (((float) i4) / 2.0f)) * ((float) i4)) / ((float) computeVerticalScrollRange));
                    zVar.anq = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
                }
                if (zVar.anz) {
                    zVar.anu = (int) (((((float) computeHorizontalScrollOffset) + (((float) i5) / 2.0f)) * ((float) i5)) / ((float) computeHorizontalScrollRange));
                    zVar.ant = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
                }
                if (zVar.mState == 0 || zVar.mState == 1) {
                    zVar.setState(1);
                }
            } else if (zVar.mState != 0) {
                zVar.setState(0);
            }
        }
    };
    final int anh;
    final StateListDrawable ani;
    final Drawable anj;
    private final int ank;
    private final int anl;
    private final StateListDrawable anm;
    private final Drawable ann;
    private final int ano;
    private final int anp;
    int anq;
    int anr;
    float ans;
    int ant;
    int anu;
    float anv;
    int anw = 0;
    int anx = 0;
    boolean any = false;
    boolean anz = false;
    private final Runnable mHideRunnable = new Runnable() {
        /* class android.support.v7.widget.z.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void run() {
            z zVar = z.this;
            switch (zVar.anD) {
                case 1:
                    zVar.anC.cancel();
                    break;
                case 2:
                    break;
                default:
                    return;
            }
            zVar.anD = 3;
            zVar.anC.setFloatValues(((Float) zVar.anC.getAnimatedValue()).floatValue(), 0.0f);
            zVar.anC.setDuration(500L);
            zVar.anC.start();
        }
    };
    private final int mMargin;
    RecyclerView mRecyclerView;
    int mState = 0;

    z(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        this.ani = stateListDrawable;
        this.anj = drawable;
        this.anm = stateListDrawable2;
        this.ann = drawable2;
        this.ank = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.anl = Math.max(i2, drawable.getIntrinsicWidth());
        this.ano = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.anp = Math.max(i2, drawable2.getIntrinsicWidth());
        this.anh = i3;
        this.mMargin = i4;
        this.ani.setAlpha(255);
        this.anj.setAlpha(255);
        this.anC.addListener(new a());
        this.anC.addUpdateListener(new b());
        if (this.mRecyclerView != recyclerView) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.c(this);
                this.mRecyclerView.b((RecyclerView.k) this);
                this.mRecyclerView.b(this.anE);
                jI();
            }
            this.mRecyclerView = recyclerView;
            if (this.mRecyclerView != null) {
                this.mRecyclerView.a((RecyclerView.h) this);
                this.mRecyclerView.a((RecyclerView.k) this);
                this.mRecyclerView.a(this.anE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void setState(int i2) {
        if (i2 == 2 && this.mState != 2) {
            this.ani.setState(PRESSED_STATE_SET);
            jI();
        }
        if (i2 == 0) {
            this.mRecyclerView.invalidate();
        } else {
            show();
        }
        if (this.mState == 2 && i2 != 2) {
            this.ani.setState(EMPTY_STATE_SET);
            bO(1200);
        } else if (i2 == 1) {
            bO(1500);
        }
        this.mState = i2;
    }

    private boolean jH() {
        return u.Z(this.mRecyclerView) == 1;
    }

    private void show() {
        switch (this.anD) {
            case 0:
                break;
            case 1:
            case 2:
            default:
                return;
            case 3:
                this.anC.cancel();
                break;
        }
        this.anD = 1;
        this.anC.setFloatValues(((Float) this.anC.getAnimatedValue()).floatValue(), 1.0f);
        this.anC.setDuration(500L);
        this.anC.setStartDelay(0);
        this.anC.start();
    }

    private void jI() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    private void bO(int i2) {
        jI();
        this.mRecyclerView.postDelayed(this.mHideRunnable, (long) i2);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        if (this.anw != this.mRecyclerView.getWidth() || this.anx != this.mRecyclerView.getHeight()) {
            this.anw = this.mRecyclerView.getWidth();
            this.anx = this.mRecyclerView.getHeight();
            setState(0);
        } else if (this.anD != 0) {
            if (this.any) {
                int i2 = this.anw - this.ank;
                int i3 = this.anr - (this.anq / 2);
                this.ani.setBounds(0, 0, this.ank, this.anq);
                this.anj.setBounds(0, 0, this.anl, this.anx);
                if (jH()) {
                    this.anj.draw(canvas);
                    canvas.translate((float) this.ank, (float) i3);
                    canvas.scale(-1.0f, 1.0f);
                    this.ani.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    canvas.translate((float) (-this.ank), (float) (-i3));
                } else {
                    canvas.translate((float) i2, 0.0f);
                    this.anj.draw(canvas);
                    canvas.translate(0.0f, (float) i3);
                    this.ani.draw(canvas);
                    canvas.translate((float) (-i2), (float) (-i3));
                }
            }
            if (this.anz) {
                int i4 = this.anx - this.ano;
                int i5 = this.anu - (this.ant / 2);
                this.anm.setBounds(0, 0, this.ant, this.ano);
                this.ann.setBounds(0, 0, this.anw, this.anp);
                canvas.translate(0.0f, (float) i4);
                this.ann.draw(canvas);
                canvas.translate((float) i5, 0.0f);
                this.anm.draw(canvas);
                canvas.translate((float) (-i5), (float) (-i4));
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.k
    public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.mState != 1) {
            return this.mState == 2;
        }
        boolean m = m(motionEvent.getX(), motionEvent.getY());
        boolean n = n(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0 || (!m && !n)) {
            return false;
        }
        if (n) {
            this.Wx = 1;
            this.anv = (float) ((int) motionEvent.getX());
        } else if (m) {
            this.Wx = 2;
            this.ans = (float) ((int) motionEvent.getY());
        }
        setState(2);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.k
    public final void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.mState != 0) {
            if (motionEvent.getAction() == 0) {
                boolean m = m(motionEvent.getX(), motionEvent.getY());
                boolean n = n(motionEvent.getX(), motionEvent.getY());
                if (m || n) {
                    if (n) {
                        this.Wx = 1;
                        this.anv = (float) ((int) motionEvent.getX());
                    } else if (m) {
                        this.Wx = 2;
                        this.ans = (float) ((int) motionEvent.getY());
                    }
                    setState(2);
                }
            } else if (motionEvent.getAction() == 1 && this.mState == 2) {
                this.ans = 0.0f;
                this.anv = 0.0f;
                setState(1);
                this.Wx = 0;
            } else if (motionEvent.getAction() == 2 && this.mState == 2) {
                show();
                if (this.Wx == 1) {
                    float x = motionEvent.getX();
                    this.anB[0] = this.mMargin;
                    this.anB[1] = this.anw - this.mMargin;
                    int[] iArr = this.anB;
                    float max = Math.max((float) iArr[0], Math.min((float) iArr[1], x));
                    if (Math.abs(((float) this.anu) - max) >= 2.0f) {
                        int a2 = a(this.anv, max, iArr, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.anw);
                        if (a2 != 0) {
                            this.mRecyclerView.scrollBy(a2, 0);
                        }
                        this.anv = max;
                    }
                }
                if (this.Wx == 2) {
                    float y = motionEvent.getY();
                    this.anA[0] = this.mMargin;
                    this.anA[1] = this.anx - this.mMargin;
                    int[] iArr2 = this.anA;
                    float max2 = Math.max((float) iArr2[0], Math.min((float) iArr2[1], y));
                    if (Math.abs(((float) this.anr) - max2) >= 2.0f) {
                        int a3 = a(this.ans, max2, iArr2, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.anx);
                        if (a3 != 0) {
                            this.mRecyclerView.scrollBy(0, a3);
                        }
                        this.ans = max2;
                    }
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.k
    public final void ah(boolean z) {
    }

    private static int a(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / ((float) i5)) * ((float) i6));
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private boolean m(float f2, float f3) {
        if (!jH() ? f2 >= ((float) (this.anw - this.ank)) : f2 <= ((float) (this.ank / 2))) {
            return f3 >= ((float) (this.anr - (this.anq / 2))) && f3 <= ((float) (this.anr + (this.anq / 2)));
        }
    }

    private boolean n(float f2, float f3) {
        return f3 >= ((float) (this.anx - this.ano)) && f2 >= ((float) (this.anu - (this.ant / 2))) && f2 <= ((float) (this.anu + (this.ant / 2)));
    }

    class a extends AnimatorListenerAdapter {
        private boolean mCanceled = false;

        a() {
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.mCanceled) {
                this.mCanceled = false;
            } else if (((Float) z.this.anC.getAnimatedValue()).floatValue() == 0.0f) {
                z.this.anD = 0;
                z.this.setState(0);
            } else {
                z.this.anD = 2;
                z.this.mRecyclerView.invalidate();
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            z.this.ani.setAlpha(floatValue);
            z.this.anj.setAlpha(floatValue);
            z.this.mRecyclerView.invalidate();
        }
    }
}
