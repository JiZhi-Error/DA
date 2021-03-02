package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.u;
import android.support.v4.widget.t;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    t od;
    private final t.a or = new t.a() {
        /* class android.support.design.widget.SwipeDismissBehavior.AnonymousClass1 */
        private int om = -1;
        private int uc;

        @Override // android.support.v4.widget.t.a
        public final boolean c(View view, int i2) {
            return this.om == -1 && SwipeDismissBehavior.this.j(view);
        }

        @Override // android.support.v4.widget.t.a
        public final void l(View view, int i2) {
            this.om = i2;
            this.uc = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // android.support.v4.widget.t.a
        public final void L(int i2) {
            if (SwipeDismissBehavior.this.tU != null) {
                SwipeDismissBehavior.this.tU.I(i2);
            }
        }

        @Override // android.support.v4.widget.t.a
        public final void a(View view, float f2, float f3) {
            boolean z;
            int i2;
            boolean z2 = true;
            this.om = -1;
            int width = view.getWidth();
            if (f2 != 0.0f) {
                boolean z3 = u.Z(view) == 1;
                z = SwipeDismissBehavior.this.tY == 2 ? true : SwipeDismissBehavior.this.tY == 0 ? z3 ? f2 < 0.0f : f2 > 0.0f : SwipeDismissBehavior.this.tY == 1 ? z3 ? f2 > 0.0f : f2 < 0.0f : false;
            } else {
                z = Math.abs(view.getLeft() - this.uc) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.tZ);
            }
            if (z) {
                i2 = view.getLeft() < this.uc ? this.uc - width : this.uc + width;
            } else {
                i2 = this.uc;
                z2 = false;
            }
            if (SwipeDismissBehavior.this.od.H(i2, view.getTop())) {
                u.b(view, new b(view, z2));
            } else if (z2 && SwipeDismissBehavior.this.tU != null) {
                SwipeDismissBehavior.this.tU.onDismiss(view);
            }
        }

        @Override // android.support.v4.widget.t.a
        public final int y(View view) {
            return view.getWidth();
        }

        @Override // android.support.v4.widget.t.a
        public final int e(View view, int i2) {
            int width;
            int width2;
            boolean z = u.Z(view) == 1;
            if (SwipeDismissBehavior.this.tY == 0) {
                if (z) {
                    width = this.uc - view.getWidth();
                    width2 = this.uc;
                } else {
                    width = this.uc;
                    width2 = this.uc + view.getWidth();
                }
            } else if (SwipeDismissBehavior.this.tY != 1) {
                width = this.uc - view.getWidth();
                width2 = this.uc + view.getWidth();
            } else if (z) {
                width = this.uc;
                width2 = this.uc + view.getWidth();
            } else {
                width = this.uc - view.getWidth();
                width2 = this.uc;
            }
            return SwipeDismissBehavior.clamp(width, i2, width2);
        }

        @Override // android.support.v4.widget.t.a
        public final int d(View view, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.t.a
        public final void b(View view, int i2, int i3) {
            float width = ((float) this.uc) + (((float) view.getWidth()) * SwipeDismissBehavior.this.ua);
            float width2 = ((float) this.uc) + (((float) view.getWidth()) * SwipeDismissBehavior.this.ub);
            if (((float) i2) <= width) {
                view.setAlpha(1.0f);
            } else if (((float) i2) >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.u(1.0f - SwipeDismissBehavior.d(width, width2, (float) i2)));
            }
        }
    };
    a tU;
    private boolean tV;
    private float tW = 0.0f;
    private boolean tX;
    int tY = 2;
    float tZ = 0.5f;
    float ua = 0.0f;
    float ub = 0.5f;

    public interface a {
        void I(int i2);

        void onDismiss(View view);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        t a2;
        boolean z = this.tV;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.tV = coordinatorLayout.d(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.tV;
                break;
            case 1:
            case 3:
                this.tV = false;
                break;
        }
        if (!z) {
            return false;
        }
        if (this.od == null) {
            if (this.tX) {
                a2 = t.a(coordinatorLayout, this.tW, this.or);
            } else {
                a2 = t.a(coordinatorLayout, this.or);
            }
            this.od = a2;
        }
        return this.od.j(motionEvent);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.od == null) {
            return false;
        }
        this.od.k(motionEvent);
        return true;
    }

    public boolean j(View view) {
        return true;
    }

    class b implements Runnable {
        private final boolean ue;
        private final View view;

        b(View view2, boolean z) {
            this.view = view2;
            this.ue = z;
        }

        public final void run() {
            if (SwipeDismissBehavior.this.od != null && SwipeDismissBehavior.this.od.go()) {
                u.b(this.view, this);
            } else if (this.ue && SwipeDismissBehavior.this.tU != null) {
                SwipeDismissBehavior.this.tU.onDismiss(this.view);
            }
        }
    }

    static float u(float f2) {
        return Math.min(Math.max(0.0f, f2), 1.0f);
    }

    static int clamp(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }

    static float d(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }
}
