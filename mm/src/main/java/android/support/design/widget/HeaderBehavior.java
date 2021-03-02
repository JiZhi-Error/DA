package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private VelocityTracker ol;
    private int om = -1;
    private Runnable rV;
    OverScroller rW;
    private boolean rX;
    private int rY;
    private int rZ = -1;

    public HeaderBehavior() {
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.rZ < 0) {
            this.rZ = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.rX) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.rX = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (bR() && coordinatorLayout.d(v, x, y)) {
                    this.rY = y;
                    this.om = motionEvent.getPointerId(0);
                    cN();
                    break;
                }
            case 1:
            case 3:
                this.rX = false;
                this.om = -1;
                if (this.ol != null) {
                    this.ol.recycle();
                    this.ol = null;
                    break;
                }
                break;
            case 2:
                int i2 = this.om;
                if (!(i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1)) {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    if (Math.abs(y2 - this.rY) > this.rZ) {
                        this.rX = true;
                        this.rY = y2;
                        break;
                    }
                }
                break;
        }
        if (this.ol != null) {
            this.ol.addMovement(motionEvent);
        }
        return this.rX;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ef  */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.support.design.widget.CoordinatorLayout r10, V r11, android.view.MotionEvent r12) {
        /*
        // Method dump skipped, instructions count: 266
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.HeaderBehavior.a(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public final int b(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return a(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public int a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        int clamp;
        int bT = bT();
        if (i3 == 0 || bT < i3 || bT > i4 || bT == (clamp = android.support.v4.b.a.clamp(i2, i3, i4))) {
            return 0;
        }
        G(clamp);
        return bT - clamp;
    }

    /* access modifiers changed from: package-private */
    public int bQ() {
        return bT();
    }

    /* access modifiers changed from: package-private */
    public final int b(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return a(coordinatorLayout, v, bQ() - i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    public void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* access modifiers changed from: package-private */
    public boolean bR() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public int g(V v) {
        return -v.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int f(V v) {
        return v.getHeight();
    }

    private void cN() {
        if (this.ol == null) {
            this.ol = VelocityTracker.obtain();
        }
    }

    class a implements Runnable {
        private final CoordinatorLayout sa;
        private final V sc;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.sa = coordinatorLayout;
            this.sc = v;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: android.support.design.widget.HeaderBehavior */
        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: android.support.design.widget.HeaderBehavior */
        /* JADX WARN: Multi-variable type inference failed */
        public final void run() {
            if (this.sc != null && HeaderBehavior.this.rW != null) {
                if (HeaderBehavior.this.rW.computeScrollOffset()) {
                    HeaderBehavior.this.b(this.sa, this.sc, HeaderBehavior.this.rW.getCurrY());
                    u.b(this.sc, this);
                    return;
                }
                HeaderBehavior.this.a(this.sa, (View) this.sc);
            }
        }
    }
}
