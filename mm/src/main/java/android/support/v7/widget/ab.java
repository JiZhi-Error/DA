package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.s;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ab implements View.OnAttachStateChangeListener, View.OnTouchListener {
    private final float anH;
    private final int anI;
    private final int anJ;
    final View anK;
    private Runnable anL;
    private Runnable anM;
    private boolean anN;
    private final int[] anO = new int[2];
    private int mActivePointerId;

    public abstract s hO();

    public ab(View view) {
        this.anK = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.anH = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.anI = ViewConfiguration.getTapTimeout();
        this.anJ = (this.anI + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ab.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.anN = false;
        this.mActivePointerId = -1;
        if (this.anL != null) {
            this.anK.removeCallbacks(this.anL);
        }
    }

    /* access modifiers changed from: protected */
    public boolean hP() {
        s hO = hO();
        if (hO == null || hO.isShowing()) {
            return true;
        }
        hO.show();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean iI() {
        s hO = hO();
        if (hO == null || !hO.isShowing()) {
            return true;
        }
        hO.dismiss();
        return true;
    }

    private void jJ() {
        if (this.anM != null) {
            this.anK.removeCallbacks(this.anM);
        }
        if (this.anL != null) {
            this.anK.removeCallbacks(this.anL);
        }
    }

    /* access modifiers changed from: package-private */
    public final void jK() {
        jJ();
        View view = this.anK;
        if (view.isEnabled() && !view.isLongClickable() && hP()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.anN = true;
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        a() {
        }

        public final void run() {
            ViewParent parent = ab.this.anK.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        b() {
        }

        public final void run() {
            ab.this.jK();
        }
    }
}
