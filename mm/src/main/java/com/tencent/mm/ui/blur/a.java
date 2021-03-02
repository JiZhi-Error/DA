package com.tencent.mm.ui.blur;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements c {
    private final float Pce = 8.0f;
    private float Pcf = 1.0f;
    private float Pcg = 1.0f;
    private b Pch;
    private Canvas Pci;
    private Bitmap Pcj;
    final View Pck;
    private final Rect Pcl = new Rect();
    private final int[] Pcm = new int[2];
    private final ViewTreeObserver.OnPreDrawListener Pcn = new ViewTreeObserver.OnPreDrawListener() {
        /* class com.tencent.mm.ui.blur.a.AnonymousClass1 */

        public final boolean onPreDraw() {
            AppMethodBeat.i(142705);
            if (!a.this.Pco) {
                a aVar = a.this;
                aVar.Pco = true;
                aVar.Pck.invalidate();
            }
            AppMethodBeat.o(142705);
            return true;
        }
    };
    boolean Pco;
    private boolean Pcp = true;
    private final Runnable Pcq = new Runnable() {
        /* class com.tencent.mm.ui.blur.a.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(142706);
            a.this.Pco = false;
            AppMethodBeat.o(142706);
        }
    };
    private Drawable Pcr;
    private boolean Pcs = true;
    private boolean Pct;
    private final ViewGroup jLy;
    private int left;
    private final Paint paint = new Paint();
    private int top;
    private float uIj = 16.0f;

    a(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(142708);
        this.jLy = viewGroup;
        this.Pck = view;
        this.Pch = new d();
        this.paint.setFilterBitmap(true);
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (lc(measuredWidth, measuredHeight)) {
            this.Pck.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.tencent.mm.ui.blur.a.AnonymousClass3 */

                public final void onGlobalLayout() {
                    AppMethodBeat.i(142707);
                    if (Build.VERSION.SDK_INT >= 16) {
                        a.this.Pck.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        a.this.Pck.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    a.this.init(a.this.Pck.getMeasuredWidth(), a.this.Pck.getMeasuredHeight());
                    AppMethodBeat.o(142707);
                }
            });
            AppMethodBeat.o(142708);
            return;
        }
        init(measuredWidth, measuredHeight);
        AppMethodBeat.o(142708);
    }

    private static int ct(float f2) {
        AppMethodBeat.i(142709);
        int ceil = (int) Math.ceil((double) (f2 / 8.0f));
        AppMethodBeat.o(142709);
        return ceil;
    }

    private static int alU(int i2) {
        return i2 % 16 == 0 ? i2 : (i2 - (i2 % 16)) + 16;
    }

    /* access modifiers changed from: package-private */
    public final void init(int i2, int i3) {
        AppMethodBeat.i(142710);
        if (lc(i2, i3)) {
            this.Pcp = false;
            this.Pck.setWillNotDraw(true);
            BI(false);
            AppMethodBeat.o(142710);
            return;
        }
        this.Pcp = true;
        this.Pck.setWillNotDraw(false);
        ld(i2, i3);
        this.Pci = new Canvas(this.Pcj);
        BI(true);
        if (this.Pct) {
            gMl();
        }
        AppMethodBeat.o(142710);
    }

    private static boolean lc(int i2, int i3) {
        AppMethodBeat.i(142711);
        if (ct((float) i3) == 0 || ct((float) i2) == 0) {
            AppMethodBeat.o(142711);
            return true;
        }
        AppMethodBeat.o(142711);
        return false;
    }

    private void ld(int i2, int i3) {
        AppMethodBeat.i(142712);
        int ct = ct((float) i2);
        int ct2 = ct((float) i3);
        int alU = alU(ct);
        int alU2 = alU(ct2);
        this.Pcg = ((float) ct2) / ((float) alU2);
        this.Pcf = ((float) ct) / ((float) alU);
        this.Pcj = Bitmap.createBitmap(alU, alU2, this.Pch.gMq());
        AppMethodBeat.o(142712);
    }

    private void gMl() {
        AppMethodBeat.i(142713);
        this.Pck.getDrawingRect(this.Pcl);
        if (this.Pcs) {
            try {
                this.jLy.offsetDescendantRectToMyCoords(this.Pck, this.Pcl);
            } catch (IllegalArgumentException e2) {
                this.Pcs = false;
            }
        } else {
            this.Pck.getLocationInWindow(this.Pcm);
            this.Pcl.offset(this.Pcm[0], this.Pcm[1]);
        }
        this.Pcl.offset(this.left, this.top);
        float f2 = this.Pcf * 8.0f;
        float f3 = this.Pcg * 8.0f;
        this.Pci.translate((((float) (-this.Pcl.left)) / f2) - (this.Pck.getTranslationX() / f2), (((float) (-this.Pcl.top)) / f3) - (this.Pck.getTranslationY() / f3));
        this.Pci.scale(1.0f / f2, 1.0f / f3);
        AppMethodBeat.o(142713);
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void z(Canvas canvas) {
        AppMethodBeat.i(142714);
        this.Pco = true;
        if (this.Pcp) {
            if (this.Pcr == null) {
                this.Pcj.eraseColor(0);
            } else {
                this.Pcr.draw(this.Pci);
            }
            if (this.Pct) {
                this.jLy.draw(this.Pci);
            } else {
                this.Pci.save();
                gMl();
                this.jLy.draw(this.Pci);
                this.Pci.restore();
            }
            this.Pcj = this.Pch.b(this.Pcj, this.uIj);
            canvas.save();
            canvas.scale(this.Pcf * 8.0f, this.Pcg * 8.0f);
            canvas.drawBitmap(this.Pcj, 0.0f, 0.0f, this.paint);
            canvas.restore();
        }
        AppMethodBeat.o(142714);
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void gMm() {
        AppMethodBeat.i(142715);
        this.Pck.post(this.Pcq);
        AppMethodBeat.o(142715);
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void gMn() {
        AppMethodBeat.i(142716);
        init(this.Pck.getMeasuredWidth(), this.Pck.getMeasuredHeight());
        AppMethodBeat.o(142716);
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void destroy() {
        AppMethodBeat.i(142717);
        BI(false);
        this.Pch.destroy();
        if (this.Pcj != null) {
            this.Pcj.recycle();
        }
        AppMethodBeat.o(142717);
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void cu(float f2) {
        this.uIj = f2;
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void a(b bVar) {
        this.Pch = bVar;
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void E(Drawable drawable) {
        this.Pcr = drawable;
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void BH(boolean z) {
        AppMethodBeat.i(142718);
        this.Pcp = z;
        BI(z);
        this.Pck.invalidate();
        AppMethodBeat.o(142718);
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void BI(boolean z) {
        AppMethodBeat.i(142719);
        this.Pck.getViewTreeObserver().removeOnPreDrawListener(this.Pcn);
        if (z) {
            this.Pck.getViewTreeObserver().addOnPreDrawListener(this.Pcn);
        }
        AppMethodBeat.o(142719);
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void gMo() {
        this.Pct = true;
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void gMp() {
        this.Pcs = false;
    }

    @Override // com.tencent.mm.ui.blur.c
    public final void alV(int i2) {
        this.top = i2;
    }
}
