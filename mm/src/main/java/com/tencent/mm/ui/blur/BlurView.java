package com.tencent.mm.ui.blur;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a;

public class BlurView extends FrameLayout {
    private static final String TAG = BlurView.class.getSimpleName();
    public float Kx = 0.0f;
    public boolean PcA = false;
    c Pcv = gMu();
    private int Pcw;
    private final Path Pcx = new Path();
    private final RectF Pcy = new RectF();
    private float[] Pcz;

    static {
        AppMethodBeat.i(142741);
        AppMethodBeat.o(142741);
    }

    public BlurView(Context context) {
        super(context);
        AppMethodBeat.i(142721);
        init(null, 0);
        AppMethodBeat.o(142721);
    }

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142722);
        init(attributeSet, 0);
        AppMethodBeat.o(142722);
    }

    public BlurView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142723);
        init(attributeSet, i2);
        AppMethodBeat.o(142723);
    }

    private void init(AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(142724);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0244a.BlurView, i2, 0);
        this.Pcw = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        AppMethodBeat.o(142724);
    }

    public final BlurView gMr() {
        this.PcA = true;
        return this;
    }

    public final BlurView cv(float f2) {
        this.Kx = f2;
        return this;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(142725);
        if (this.Kx != 0.0f) {
            this.Pcx.reset();
            if (this.PcA) {
                this.Pcz = new float[]{this.Kx, this.Kx, this.Kx, this.Kx, this.Kx, this.Kx, this.Kx, this.Kx};
            } else {
                this.Pcz = new float[]{this.Kx, this.Kx, this.Kx, this.Kx, 0.0f, 0.0f, 0.0f, 0.0f};
            }
            this.Pcy.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            this.Pcx.addRoundRect(this.Pcy, this.Pcz, Path.Direction.CCW);
            canvas.clipPath(this.Pcx);
        }
        if (canvas.isHardwareAccelerated()) {
            this.Pcv.z(canvas);
            if (this.Pcw != 0) {
                canvas.drawColor(this.Pcw);
            }
            super.draw(canvas);
            AppMethodBeat.o(142725);
            return;
        }
        if (!isHardwareAccelerated()) {
            super.draw(canvas);
        }
        AppMethodBeat.o(142725);
    }

    public final BlurView BJ(final boolean z) {
        AppMethodBeat.i(142726);
        post(new Runnable() {
            /* class com.tencent.mm.ui.blur.BlurView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(142720);
                BlurView.this.Pcv.BH(z);
                AppMethodBeat.o(142720);
            }
        });
        AppMethodBeat.o(142726);
        return this;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142727);
        super.onSizeChanged(i2, i3, i4, i5);
        this.Pcv.gMn();
        AppMethodBeat.o(142727);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(142728);
        super.dispatchDraw(canvas);
        this.Pcv.gMm();
        AppMethodBeat.o(142728);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(142729);
        super.onDetachedFromWindow();
        this.Pcv.BI(false);
        AppMethodBeat.o(142729);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(142730);
        super.onAttachedToWindow();
        if (isHardwareAccelerated()) {
            this.Pcv.BI(true);
        }
        AppMethodBeat.o(142730);
    }

    private void setBlurController(c cVar) {
        AppMethodBeat.i(142731);
        this.Pcv.destroy();
        this.Pcv = cVar;
        AppMethodBeat.o(142731);
    }

    public final BlurView alW(int i2) {
        AppMethodBeat.i(142732);
        if (i2 != this.Pcw) {
            this.Pcw = i2;
            invalidate();
        }
        AppMethodBeat.o(142732);
        return this;
    }

    public final BlurView gMs() {
        AppMethodBeat.i(142733);
        this.Pcv.gMo();
        AppMethodBeat.o(142733);
        return this;
    }

    public final BlurView L(ViewGroup viewGroup) {
        AppMethodBeat.i(142734);
        a aVar = new a(this, viewGroup);
        setBlurController(aVar);
        if (!isHardwareAccelerated()) {
            aVar.BI(false);
        }
        AppMethodBeat.o(142734);
        return this;
    }

    public final BlurView cw(float f2) {
        AppMethodBeat.i(142735);
        this.Pcv.cu(f2);
        AppMethodBeat.o(142735);
        return this;
    }

    public final BlurView b(b bVar) {
        AppMethodBeat.i(142736);
        this.Pcv.a(bVar);
        AppMethodBeat.o(142736);
        return this;
    }

    public final BlurView F(Drawable drawable) {
        AppMethodBeat.i(142737);
        this.Pcv.E(drawable);
        AppMethodBeat.o(142737);
        return this;
    }

    public final BlurView alX(int i2) {
        AppMethodBeat.i(142738);
        this.Pcv.alV(i2);
        AppMethodBeat.o(142738);
        return this;
    }

    public final BlurView gMt() {
        AppMethodBeat.i(142739);
        this.Pcv.gMp();
        AppMethodBeat.o(142739);
        return this;
    }

    public c getBlurController() {
        return this.Pcv;
    }

    private c gMu() {
        AppMethodBeat.i(142740);
        AnonymousClass2 r0 = new c() {
            /* class com.tencent.mm.ui.blur.BlurView.AnonymousClass2 */

            @Override // com.tencent.mm.ui.blur.c
            public final void z(Canvas canvas) {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void gMn() {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void gMm() {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void cu(float f2) {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void a(b bVar) {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void E(Drawable drawable) {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void destroy() {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void BH(boolean z) {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void BI(boolean z) {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void gMo() {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void gMp() {
            }

            @Override // com.tencent.mm.ui.blur.c
            public final void alV(int i2) {
            }
        };
        AppMethodBeat.o(142740);
        return r0;
    }
}
