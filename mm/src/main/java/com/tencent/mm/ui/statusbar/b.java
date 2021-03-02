package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Looper;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.statusbar.c;

public class b extends FrameLayout implements c.a {
    protected static final boolean Qoi = c.Qow;
    private c Qoj;
    private int Qok = 0;
    private int Qol = 0;
    private boolean Qom = false;
    private boolean Qon = false;
    private boolean Qoo = false;
    private final int[] Qop = new int[2];
    private int Qoq = 0;
    private boolean asn = false;
    private Activity mActivity;
    private Paint mPaint;
    private volatile int mStatusBarHeight;

    @Override // com.tencent.mm.ui.statusbar.c.a
    public void yf(int i2) {
        AppMethodBeat.i(133804);
        aom(i2);
        AppMethodBeat.o(133804);
    }

    public final void CF(boolean z) {
        AppMethodBeat.i(133805);
        this.Qom = z;
        aom(this.mStatusBarHeight);
        AppMethodBeat.o(133805);
    }

    public int getDrawnStatusBarHeight() {
        AppMethodBeat.i(175983);
        int max = Math.max(0, this.mStatusBarHeight);
        AppMethodBeat.o(175983);
        return max;
    }

    static class a extends MutableContextWrapper {
        private boolean Qou = true;
        AbstractC2126a Qov;

        /* renamed from: com.tencent.mm.ui.statusbar.b$a$a  reason: collision with other inner class name */
        interface AbstractC2126a {
            void gXl();
        }

        private a(MutableContextWrapper mutableContextWrapper) {
            super(mutableContextWrapper);
        }

        public final void setBaseContext(Context context) {
            AppMethodBeat.i(133802);
            if (!this.Qou) {
                super.setBaseContext(context);
            } else if (context == getBaseContext()) {
                AppMethodBeat.o(133802);
                return;
            } else {
                ((MutableContextWrapper) getBaseContext()).setBaseContext(context);
                if (this.Qov != null) {
                    this.Qov.gXl();
                    AppMethodBeat.o(133802);
                    return;
                }
            }
            AppMethodBeat.o(133802);
        }

        public static Context kC(Context context) {
            AppMethodBeat.i(133803);
            if (context instanceof MutableContextWrapper) {
                a aVar = new a((MutableContextWrapper) context);
                AppMethodBeat.o(133803);
                return aVar;
            }
            AppMethodBeat.o(133803);
            return context;
        }
    }

    public b(Context context) {
        super(a.kC(context));
        AppMethodBeat.i(133806);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            RuntimeException runtimeException = new RuntimeException("Should be called on main-thread");
            AppMethodBeat.o(133806);
            throw runtimeException;
        }
        bSw();
        if (getContext() instanceof a) {
            ((a) getContext()).Qov = new a.AbstractC2126a() {
                /* class com.tencent.mm.ui.statusbar.b.AnonymousClass1 */

                @Override // com.tencent.mm.ui.statusbar.b.a.AbstractC2126a
                public final void gXl() {
                    AppMethodBeat.i(133800);
                    if (Looper.getMainLooper() != Looper.myLooper()) {
                        b.this.post(new Runnable() {
                            /* class com.tencent.mm.ui.statusbar.b.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(175982);
                                b.this.bSw();
                                AppMethodBeat.o(175982);
                            }
                        });
                        AppMethodBeat.o(133800);
                        return;
                    }
                    b.this.bSw();
                    AppMethodBeat.o(133800);
                }
            };
        }
        AppMethodBeat.o(133806);
    }

    /* access modifiers changed from: protected */
    public void bSw() {
        AppMethodBeat.i(133807);
        if (!Qoi) {
            this.mActivity = null;
            this.mPaint = null;
            AppMethodBeat.o(133807);
            return;
        }
        setPadding(0, 0, 0, 0);
        this.mStatusBarHeight = 0;
        if (this.Qoj != null) {
            this.Qoj.b(this);
        }
        this.mActivity = AndroidContextUtil.castActivityOrNull(getContext());
        if (this.mActivity == null) {
            this.mPaint = null;
            super.setWillNotDraw(true);
            AppMethodBeat.o(133807);
            return;
        }
        c bt = c.bt(this.mActivity);
        this.Qoj = bt;
        bt.a(this);
        this.mPaint = new Paint(0);
        this.mPaint.setStyle(Paint.Style.FILL);
        super.setWillNotDraw(false);
        AppMethodBeat.o(133807);
    }

    public final void setWillNotDraw(boolean z) {
    }

    public final boolean willNotDraw() {
        AppMethodBeat.i(175984);
        boolean willNotDraw = super.willNotDraw();
        AppMethodBeat.o(175984);
        return willNotDraw;
    }

    private void gXi() {
        AppMethodBeat.i(175985);
        if (this.Qoj == null) {
            AppMethodBeat.o(175985);
            return;
        }
        yf(this.Qoj.Qoz);
        AppMethodBeat.o(175985);
    }

    public void dispatchSystemUiVisibilityChanged(int i2) {
        AppMethodBeat.i(175986);
        super.dispatchSystemUiVisibilityChanged(i2);
        gXi();
        AppMethodBeat.o(175986);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(175987);
        super.onAttachedToWindow();
        gXi();
        AppMethodBeat.o(175987);
    }

    private void aom(int i2) {
        AppMethodBeat.i(133808);
        getLocationInWindow(this.Qop);
        this.Qoq = this.Qop[1];
        if (Log.getLogLevel() <= 1) {
            Log.d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b] mLocationInWindow[%d.%d]", Integer.valueOf(i2), Boolean.valueOf(this.asn), Integer.valueOf(this.Qop[0]), Integer.valueOf(this.Qop[1]));
        }
        this.mStatusBarHeight = Math.max(0, i2 - this.Qop[1]);
        if (this.asn) {
            this.Qon = true;
            AppMethodBeat.o(133808);
            return;
        }
        try {
            setPadding(0, this.Qom ? 0 : this.mStatusBarHeight, 0, 0);
        } catch (IllegalStateException e2) {
            Log.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight setPadding e=%s", e2.getMessage());
        }
        if (isLayoutRequested()) {
            gXj();
        }
        AppMethodBeat.o(133808);
    }

    private void gXj() {
        AppMethodBeat.i(133809);
        if (gXk()) {
            invalidate();
            AppMethodBeat.o(133809);
            return;
        }
        postInvalidate();
        AppMethodBeat.o(133809);
    }

    public void requestLayout() {
        AppMethodBeat.i(133810);
        if (this.asn) {
            this.Qoo = true;
            AppMethodBeat.o(133810);
            return;
        }
        super.requestLayout();
        AppMethodBeat.o(133810);
    }

    public void setStatusBarColor(int i2) {
        boolean f2;
        AppMethodBeat.i(133811);
        if (!Qoi) {
            AppMethodBeat.o(133811);
            return;
        }
        Activity activity = this.mActivity;
        if (activity == null) {
            f2 = false;
        } else {
            f2 = d.f(activity.getWindow());
        }
        S(i2, f2);
        AppMethodBeat.o(133811);
    }

    public void S(int i2, boolean z) {
        AppMethodBeat.i(133812);
        l(i2, z, true);
        AppMethodBeat.o(133812);
    }

    public final void l(int i2, boolean z, boolean z2) {
        b bVar;
        int argb;
        b bVar2;
        AppMethodBeat.i(133813);
        int i3 = this.Qok;
        int i4 = this.Qol;
        this.Qok = i2;
        if (!Qoi || this.mActivity == null) {
            AppMethodBeat.o(133813);
            return;
        }
        Window window = this.mActivity.getWindow();
        d.e(window);
        if (!z2 ? d.gIJ() : d.d(window, z)) {
            this.Qok = i2;
            bVar = this;
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                if (z) {
                    i2 = d.agC(i2);
                }
                this.Qok = i2;
                if (z) {
                    argb = Color.argb(51, 0, 0, 0);
                    bVar2 = this;
                    bVar2.Qol = argb;
                } else {
                    bVar = this;
                }
            }
            if (this.Qok == 0 || this.Qol != 0) {
                if (!(i3 == this.Qok && i4 == this.Qol)) {
                    super.setWillNotDraw(false);
                    gXj();
                }
                AppMethodBeat.o(133813);
            }
            super.setWillNotDraw(true);
            gXj();
            AppMethodBeat.o(133813);
            return;
        }
        argb = 0;
        bVar2 = bVar;
        bVar2.Qol = argb;
        if (this.Qok == 0) {
        }
        super.setWillNotDraw(false);
        gXj();
        AppMethodBeat.o(133813);
    }

    public void setLayoutFrozen(final boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(133815);
        if (!gXk()) {
            post(new Runnable() {
                /* class com.tencent.mm.ui.statusbar.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(133801);
                    b.this.setLayoutFrozen(z);
                    AppMethodBeat.o(133801);
                }
            });
            AppMethodBeat.o(133815);
            return;
        }
        Log.d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b]", Boolean.valueOf(z), Boolean.valueOf(this.asn), Boolean.valueOf(this.Qoo), Boolean.valueOf(this.Qon));
        if (z == this.asn) {
            z2 = false;
        }
        this.asn = z;
        if (z2 && !z && (this.Qoo || this.Qon)) {
            aom(this.mStatusBarHeight);
            this.Qoo = false;
            this.Qon = false;
        }
        AppMethodBeat.o(133815);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(196230);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.Qoj != null && !this.asn) {
            getLocationInWindow(this.Qop);
            if (this.Qoq != this.Qop[1]) {
                this.Qoj.requestApplyInsets();
            }
            this.Qoq = this.Qop[1];
        }
        AppMethodBeat.o(196230);
    }

    private static boolean gXk() {
        AppMethodBeat.i(175988);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            AppMethodBeat.o(175988);
            return true;
        }
        AppMethodBeat.o(175988);
        return false;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(133814);
        if (this.mStatusBarHeight > 0 && Qoi && !this.Qom && !willNotDraw()) {
            if (this.mPaint == null) {
                Log.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarBackground NULL paint");
            } else {
                this.mPaint.setColor(this.Qok);
                canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.mStatusBarHeight, this.mPaint);
            }
        }
        super.dispatchDraw(canvas);
        if (this.mStatusBarHeight <= 0 || !Qoi || !this.Qom || willNotDraw()) {
            AppMethodBeat.o(133814);
        } else if (this.mPaint == null) {
            Log.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarForeground NULL paint");
            AppMethodBeat.o(133814);
        } else {
            this.mPaint.setColor(this.Qol);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.mStatusBarHeight, this.mPaint);
            AppMethodBeat.o(133814);
        }
    }
}
