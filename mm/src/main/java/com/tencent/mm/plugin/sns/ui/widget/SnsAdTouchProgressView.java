package com.tencent.mm.plugin.sns.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.sns.ad.widget.a.b;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdTouchProgressView extends FrameLayout {
    protected a EzA;
    protected float FeE = 0.0f;
    protected float FeF = 0.0f;
    protected View FeG;
    protected b FeH;
    protected FrameLayout.LayoutParams FeI;
    protected FrameLayout.LayoutParams FeJ;
    protected FrameLayout.LayoutParams FeK;
    protected int FeL;
    protected int FeM;
    protected int FeN;
    protected boolean FeO = false;
    protected boolean FeP = false;
    protected AnimatorSet FeQ;
    protected AnimatorSet FeR;
    protected AnimatorSet FeS;
    protected int FeT = 4000;
    protected Rect FeU;
    protected Paint FeV;
    protected boolean FeW = false;
    protected Context mContext;
    protected GestureDetector mDJ;
    protected View mInnerView;
    protected boolean mIsCanceled = false;
    protected boolean nmN = false;

    public interface a {
        void onCancel();

        void onClick(View view);

        void onFinish();

        void onStart();
    }

    public SnsAdTouchProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(179405);
        init(context);
        AppMethodBeat.o(179405);
    }

    public SnsAdTouchProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(179406);
        init(context);
        AppMethodBeat.o(179406);
    }

    private void init(Context context) {
        AppMethodBeat.i(179407);
        this.mContext = context;
        this.mInnerView = new View(context);
        this.mInnerView.setBackgroundResource(R.drawable.aum);
        this.FeG = new View(context);
        this.FeG.setBackgroundResource(R.drawable.aun);
        this.FeH = new b(context);
        this.FeL = com.tencent.mm.cb.a.fromDPToPix(context, 36);
        this.FeM = com.tencent.mm.cb.a.fromDPToPix(context, 68);
        this.FeN = com.tencent.mm.cb.a.fromDPToPix(context, 6);
        this.FeI = new FrameLayout.LayoutParams(this.FeL * 2, this.FeL * 2);
        this.FeJ = new FrameLayout.LayoutParams(this.FeM * 2, this.FeM * 2);
        this.FeK = new FrameLayout.LayoutParams(this.FeM * 2, this.FeM * 2);
        addView(this.FeG, this.FeJ);
        addView(this.mInnerView, this.FeI);
        addView(this.FeH, this.FeK);
        iX(0, 0);
        this.FeG.setVisibility(4);
        this.mInnerView.setVisibility(4);
        this.FeH.setVisibility(4);
        aaq(this.FeT);
        aao(this.FeT);
        aap(this.FeT);
        this.mDJ = new GestureDetector(context, new GestureDetector.OnGestureListener() {
            /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.AnonymousClass1 */

            public final boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            public final void onShowPress(MotionEvent motionEvent) {
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(179401);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                if (SnsAdTouchProgressView.this.EzA != null) {
                    SnsAdTouchProgressView.this.EzA.onClick(SnsAdTouchProgressView.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(179401);
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(179402);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                Log.i("SnsAdTouchProgressView", e.a.NAME);
                SnsAdTouchProgressView.this.getParent().requestDisallowInterceptTouchEvent(true);
                SnsAdTouchProgressView.this.nmN = true;
                SnsAdTouchProgressView.this.FeP = true;
                if (SnsAdTouchProgressView.this.EzA != null) {
                    SnsAdTouchProgressView.this.EzA.onStart();
                }
                SnsAdTouchProgressView.this.bWT();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(179402);
            }

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return true;
            }
        });
        this.FeV = new Paint();
        this.FeV.setColor(Color.parseColor("#35FF0000"));
        AppMethodBeat.o(179407);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(203993);
        if (this.FeW && this.FeU != null) {
            canvas.drawRect(this.FeU, this.FeV);
        }
        super.dispatchDraw(canvas);
        AppMethodBeat.o(203993);
    }

    public void setDuration(int i2) {
        AppMethodBeat.i(179408);
        Log.i("SnsAdTouchProgressView", "setDuration:".concat(String.valueOf(i2)));
        if (i2 <= 0) {
            i2 = this.FeT;
        }
        aaq(i2);
        aao(i2);
        aap(i2);
        AppMethodBeat.o(179408);
    }

    public final void clear() {
        AppMethodBeat.i(179409);
        Log.i("SnsAdTouchProgressView", "clear");
        this.mIsCanceled = true;
        this.FeG.setVisibility(4);
        this.mInnerView.setVisibility(4);
        this.FeH.setVisibility(4);
        this.FeR.cancel();
        this.FeQ.cancel();
        this.FeS.cancel();
        this.FeH.clear();
        AppMethodBeat.o(179409);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(179410);
        int action = motionEvent.getAction();
        if (action != 0 || this.FeU == null || this.FeU.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            GestureDetector gestureDetector = this.mDJ;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            if (action == 0) {
                this.FeE = motionEvent.getX();
                this.FeF = motionEvent.getY();
                iX((int) this.FeE, (int) this.FeF);
                this.FeO = false;
                this.mIsCanceled = false;
            } else if (action == 1 || action == 3) {
                Log.i("SnsAdTouchProgressView", "onTouchEvent cancel， action=" + action + ", IsLongClicked=" + this.FeP + ", isSuccFinish=" + this.FeO);
                getParent().requestDisallowInterceptTouchEvent(false);
                this.nmN = false;
                if (!this.FeO && this.FeP && this.EzA != null) {
                    this.EzA.onCancel();
                }
                this.FeP = false;
                clear();
            }
            AppMethodBeat.o(179410);
            return a2;
        }
        Log.w("SnsAdTouchProgressView", "onTouchEvent, x=" + motionEvent.getX() + ", y=" + motionEvent.getY() + ", range=" + this.FeU.toShortString());
        AppMethodBeat.o(179410);
        return false;
    }

    private void aao(int i2) {
        AppMethodBeat.i(179411);
        int i3 = (int) (0.1d * ((double) i2));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.FeG, "scaleX", 0.0f, 1.0f);
        ofFloat.setDuration((long) i3);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.FeG, "scaleY", 0.0f, 1.0f);
        ofFloat2.setDuration((long) i3);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.FeG, "alpha", 0.0f, 0.4f);
        ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat3.setDuration((long) i3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.FeG, "alpha", 0.4f, 0.4f);
        ofFloat4.setDuration((long) ((int) (0.8d * ((double) i2))));
        int i4 = (int) (0.05d * ((double) i2));
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.FeG, "scaleX", 1.0f, 0.823f);
        ofFloat5.setDuration((long) i4);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.FeG, "scaleY", 1.0f, 0.823f);
        ofFloat6.setDuration((long) i4);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.FeG, "alpha", 0.4f, 0.2f);
        ofFloat7.setDuration((long) i4);
        int i5 = (int) (0.05d * ((double) i2));
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.FeG, "scaleX", 0.823f, 1.235f);
        ofFloat8.setDuration((long) i5);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.FeG, "scaleY", 0.823f, 1.235f);
        ofFloat9.setDuration((long) i5);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.FeG, "alpha", 0.2f, 0.0f);
        ofFloat10.setDuration((long) i5);
        this.FeR = new AnimatorSet();
        this.FeR.play(ofFloat).with(ofFloat2).with(ofFloat3);
        this.FeR.play(ofFloat4).after(ofFloat);
        this.FeR.play(ofFloat5).with(ofFloat6).with(ofFloat7).after(ofFloat4);
        this.FeR.play(ofFloat8).with(ofFloat9).with(ofFloat10).after(ofFloat5);
        AppMethodBeat.o(179411);
    }

    private void aap(int i2) {
        AppMethodBeat.i(203994);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.FeH, "alpha", 0.0f, 0.0f);
        ofFloat.setDuration((long) ((int) (0.1d * ((double) i2))));
        final int i3 = (int) (0.8d * ((double) i2));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.FeH, "scaleX", 1.0f, 1.0f);
        ofFloat2.setDuration((long) i3);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.FeH, "scaleY", 1.0f, 1.0f);
        ofFloat3.setDuration((long) i3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.FeH, "alpha", 1.0f, 1.0f);
        ofFloat4.setDuration((long) i3);
        int i4 = (int) (0.05d * ((double) i2));
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.FeH, "scaleX", 1.0f, 0.823f);
        ofFloat5.setDuration((long) i4);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.FeH, "scaleY", 1.0f, 0.823f);
        ofFloat6.setDuration((long) i4);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.FeH, "alpha", 1.0f, 0.4f);
        ofFloat7.setDuration((long) i4);
        int i5 = (int) (0.05d * ((double) i2));
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.FeH, "scaleX", 0.823f, 1.235f);
        ofFloat8.setDuration((long) i5);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.FeH, "scaleY", 0.823f, 1.235f);
        ofFloat9.setDuration((long) i5);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.FeH, "alpha", 0.4f, 0.0f);
        ofFloat10.setDuration((long) i5);
        this.FeS = new AnimatorSet();
        this.FeS.play(ofFloat);
        this.FeS.play(ofFloat2).with(ofFloat3).with(ofFloat4).after(ofFloat);
        this.FeS.play(ofFloat5).with(ofFloat6).with(ofFloat7).after(ofFloat4);
        this.FeS.play(ofFloat8).with(ofFloat9).with(ofFloat10).after(ofFloat7);
        ofFloat2.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(203991);
                Log.i("SnsAdTouchProgressView", "a1 onAnimationStart, startProgress, duration=" + i3);
                SnsAdTouchProgressView.this.FeH.ax(i3, SnsAdTouchProgressView.this.FeM, SnsAdTouchProgressView.this.FeN);
                AppMethodBeat.o(203991);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(179403);
                AppMethodBeat.o(179403);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        AppMethodBeat.o(203994);
    }

    private void aaq(int i2) {
        AppMethodBeat.i(179412);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mInnerView, "alpha", 0.0f, 0.0f);
        ofFloat.setDuration((long) ((int) (0.05d * ((double) i2))));
        int i3 = (int) (0.05d * ((double) i2));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mInnerView, "scaleX", 0.0f, 1.0f);
        ofFloat2.setDuration((long) i3);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mInnerView, "scaleY", 0.0f, 1.0f);
        ofFloat3.setDuration((long) i3);
        ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", 0.0f, 0.8f);
        ofFloat4.setDuration((long) i3);
        ofFloat4.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", 0.8f, 0.8f);
        ofFloat5.setDuration((long) ((int) (0.8d * ((double) i2))));
        int i4 = (int) (0.05d * ((double) i2));
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mInnerView, "scaleX", 1.0f, 0.8888f);
        ofFloat6.setDuration((long) i4);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.mInnerView, "scaleY", 1.0f, 0.8888f);
        ofFloat7.setDuration((long) i4);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", 0.8f, 0.4f);
        ofFloat8.setDuration((long) i4);
        int i5 = (int) (0.05d * ((double) i2));
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.mInnerView, "scaleX", 0.8888f, 1.625f);
        ofFloat9.setDuration((long) i5);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.mInnerView, "scaleY", 0.8888f, 1.625f);
        ofFloat10.setDuration((long) i5);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", 0.4f, 0.0f);
        ofFloat11.setDuration((long) i5);
        this.FeQ = new AnimatorSet();
        this.FeQ.play(ofFloat);
        this.FeQ.play(ofFloat2).with(ofFloat3).with(ofFloat4).after(ofFloat);
        this.FeQ.play(ofFloat5).after(ofFloat4);
        this.FeQ.play(ofFloat6).with(ofFloat7).with(ofFloat8).after(ofFloat5);
        this.FeQ.play(ofFloat9).with(ofFloat10).with(ofFloat11).after(ofFloat8);
        this.FeQ.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(203992);
                Log.i("SnsAdTouchProgressView", "onAnimationEnd, isCanceled=" + SnsAdTouchProgressView.this.mIsCanceled);
                SnsAdTouchProgressView.this.nmN = false;
                if (SnsAdTouchProgressView.this.EzA != null && !SnsAdTouchProgressView.this.mIsCanceled) {
                    SnsAdTouchProgressView.this.EzA.onFinish();
                    SnsAdTouchProgressView.this.FeO = true;
                }
                AppMethodBeat.o(203992);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        AppMethodBeat.o(179412);
    }

    private void iX(int i2, int i3) {
        AppMethodBeat.i(179415);
        int i4 = i2 - this.FeM;
        int i5 = i3 - this.FeM;
        this.FeI.leftMargin = i2 - this.FeL;
        this.FeI.topMargin = i3 - this.FeL;
        this.FeJ.leftMargin = i4;
        this.FeJ.topMargin = i5;
        this.FeK.leftMargin = i4;
        this.FeK.topMargin = i5;
        this.mInnerView.setLayoutParams(this.FeI);
        this.FeG.setLayoutParams(this.FeJ);
        this.FeH.setLayoutParams(this.FeK);
        AppMethodBeat.o(179415);
    }

    public void setTouchRange(Rect rect) {
        this.FeU = rect;
    }

    public void setActionListener(a aVar) {
        this.EzA = aVar;
    }

    public final boolean isAnimating() {
        return this.nmN;
    }

    /* access modifiers changed from: protected */
    public final void bWT() {
        AppMethodBeat.i(179414);
        Log.i("SnsAdTouchProgressView", "doOuterAnim");
        this.FeG.setVisibility(0);
        this.FeR.cancel();
        this.FeR.start();
        Log.i("SnsAdTouchProgressView", "doInnerAnim");
        this.mInnerView.setVisibility(0);
        this.FeQ.cancel();
        this.FeQ.start();
        Log.i("SnsAdTouchProgressView", "doCicleAnim");
        this.FeH.setVisibility(0);
        this.FeS.cancel();
        this.FeS.start();
        AppMethodBeat.o(179414);
    }
}
