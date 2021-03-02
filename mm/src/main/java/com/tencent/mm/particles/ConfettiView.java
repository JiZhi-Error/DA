package com.tencent.mm.particles;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.particles.a.b;
import java.util.Iterator;
import java.util.List;

public class ConfettiView extends View implements View.OnLayoutChangeListener {
    List<b> jIs;
    private boolean jJc;
    private b jJd;
    boolean terminated;

    /* renamed from: do  reason: not valid java name */
    public static ConfettiView m11do(Context context) {
        AppMethodBeat.i(151362);
        ConfettiView confettiView = new ConfettiView(context, null);
        confettiView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 21) {
            confettiView.setElevation((float) context.getResources().getDimensionPixelOffset(R.dimen.y9));
        }
        AppMethodBeat.o(151362);
        return confettiView;
    }

    public ConfettiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTouchEnabled(boolean z) {
        this.jJc = z;
    }

    public final void bkK() {
        AppMethodBeat.i(151363);
        if (!this.terminated) {
            this.terminated = true;
            getParent().requestLayout();
        }
        AppMethodBeat.o(151363);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(151364);
        super.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.removeOnLayoutChangeListener(this);
        viewGroup.addOnLayoutChangeListener(this);
        if (this.jIs == null) {
            bkK();
        }
        AppMethodBeat.o(151364);
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        ViewParent parent;
        AppMethodBeat.i(151365);
        if (this.terminated && (parent = getParent()) != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.removeViewInLayout(this);
            viewGroup.removeOnLayoutChangeListener(this);
            viewGroup.invalidate();
        }
        AppMethodBeat.o(151365);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(151366);
        super.onDraw(canvas);
        if (!this.terminated) {
            canvas.save();
            for (b bVar : this.jIs) {
                if (bVar.jJz) {
                    bVar.a(canvas, bVar.jJC + bVar.jJA, bVar.jJD + bVar.jJB, bVar.jJx, bVar.jJu);
                } else if (bVar.jJy && !bVar.terminated) {
                    bVar.a(canvas, bVar.jJv, bVar.jJw, bVar.jJx, bVar.jJu);
                }
            }
            canvas.restore();
        }
        AppMethodBeat.o(151366);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(151367);
        if (this.jJc) {
            switch (motionEvent.getAction()) {
                case 0:
                    Iterator<b> it = this.jIs.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        } else {
                            b next = it.next();
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            if (next.jJv > x || x > next.jJv + ((float) next.getWidth()) || next.jJw > y || y > next.jJw + ((float) next.getHeight())) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                next.jJz = true;
                                next.jJA = x;
                                next.jJB = y;
                                next.jJC = next.jJv - x;
                                next.jJD = next.jJw - y;
                                next.ol = VelocityTracker.obtain();
                                next.ol.addMovement(motionEvent);
                                z3 = true;
                                continue;
                            } else {
                                z3 = false;
                                continue;
                            }
                            if (z3) {
                                this.jJd = next;
                                z = true;
                                break;
                            }
                        }
                    }
                    break;
                case 1:
                case 3:
                    if (this.jJd != null) {
                        b bVar = this.jJd;
                        bVar.ol.addMovement(motionEvent);
                        bVar.ol.computeCurrentVelocity(1);
                        bVar.jJj = -1;
                        bVar.jJk = motionEvent.getX() + bVar.jJC;
                        bVar.jJl = motionEvent.getY() + bVar.jJD;
                        bVar.jJm = bVar.ol.getXVelocity();
                        bVar.jJn = bVar.ol.getYVelocity();
                        bVar.jJq = bVar.jJx;
                        bVar.ol.recycle();
                        bVar.k(bVar.jIz);
                        bVar.jJz = false;
                        this.jJd = null;
                        z = true;
                        break;
                    }
                    break;
                case 2:
                    if (this.jJd != null) {
                        b bVar2 = this.jJd;
                        bVar2.jJA = motionEvent.getX();
                        bVar2.jJB = motionEvent.getY();
                        bVar2.ol.addMovement(motionEvent);
                        z = true;
                        break;
                    }
                    break;
            }
            if (!z || super.onTouchEvent(motionEvent)) {
                AppMethodBeat.o(151367);
                return true;
            }
            AppMethodBeat.o(151367);
            return false;
        }
        z = false;
        if (!z) {
        }
        AppMethodBeat.o(151367);
        return true;
    }
}
