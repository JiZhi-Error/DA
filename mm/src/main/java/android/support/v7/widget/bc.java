package android.support.v7.widget;

import android.support.v4.view.u;
import android.support.v4.view.v;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* access modifiers changed from: package-private */
public final class bc implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static bc azF;
    private static bc azG;
    private final CharSequence aeQ;
    private final Runnable azA = new Runnable() {
        /* class android.support.v7.widget.bc.AnonymousClass1 */

        public final void run() {
            bc.this.aD(false);
        }
    };
    private int azB;
    private int azC;
    private bd azD;
    private boolean azE;
    private final View azy;
    private final int azz;
    private final Runnable mHideRunnable = new Runnable() {
        /* class android.support.v7.widget.bc.AnonymousClass2 */

        public final void run() {
            bc.this.hide();
        }
    };

    public static void a(View view, CharSequence charSequence) {
        if (azF != null && azF.azy == view) {
            a(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (azG != null && azG.azy == view) {
                azG.hide();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new bc(view, charSequence);
    }

    private bc(View view, CharSequence charSequence) {
        this.azy = view;
        this.aeQ = charSequence;
        this.azz = v.b(ViewConfiguration.get(this.azy.getContext()));
        nj();
        this.azy.setOnLongClickListener(this);
        this.azy.setOnHoverListener(this);
    }

    public final boolean onLongClick(View view) {
        this.azB = view.getWidth() / 2;
        this.azC = view.getHeight() / 2;
        aD(true);
        return true;
    }

    public final boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.azD == null || !this.azE) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.azy.getContext().getSystemService("accessibility");
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
                switch (motionEvent.getAction()) {
                    case 7:
                        if (this.azy.isEnabled() && this.azD == null) {
                            int x = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            if (Math.abs(x - this.azB) > this.azz || Math.abs(y - this.azC) > this.azz) {
                                this.azB = x;
                                this.azC = y;
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                a(this);
                                break;
                            }
                        }
                        break;
                    case 10:
                        nj();
                        hide();
                        break;
                }
            }
        }
        return false;
    }

    public final void onViewAttachedToWindow(View view) {
    }

    public final void onViewDetachedFromWindow(View view) {
        hide();
    }

    /* access modifiers changed from: package-private */
    public final void aD(boolean z) {
        long longPressTimeout;
        if (u.aD(this.azy)) {
            a(null);
            if (azG != null) {
                azG.hide();
            }
            azG = this;
            this.azE = z;
            this.azD = new bd(this.azy.getContext());
            this.azD.a(this.azy, this.azB, this.azC, this.azE, this.aeQ);
            this.azy.addOnAttachStateChangeListener(this);
            if (this.azE) {
                longPressTimeout = 2500;
            } else if ((u.ao(this.azy) & 1) == 1) {
                longPressTimeout = 3000 - ((long) ViewConfiguration.getLongPressTimeout());
            } else {
                longPressTimeout = 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.azy.removeCallbacks(this.mHideRunnable);
            this.azy.postDelayed(this.mHideRunnable, longPressTimeout);
        }
    }

    /* access modifiers changed from: package-private */
    public final void hide() {
        if (azG == this) {
            azG = null;
            if (this.azD != null) {
                this.azD.hide();
                this.azD = null;
                nj();
                this.azy.removeOnAttachStateChangeListener(this);
            }
        }
        if (azF == this) {
            a(null);
        }
        this.azy.removeCallbacks(this.mHideRunnable);
    }

    private static void a(bc bcVar) {
        if (azF != null) {
            azF.ni();
        }
        azF = bcVar;
        if (bcVar != null) {
            azF.nh();
        }
    }

    private void nh() {
        this.azy.postDelayed(this.azA, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void ni() {
        this.azy.removeCallbacks(this.azA);
    }

    private void nj() {
        this.azB = Integer.MAX_VALUE;
        this.azC = Integer.MAX_VALUE;
    }
}
