package com.tencent.liteav.renderer;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private TextureView f1102a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f1103b;

    /* renamed from: c  reason: collision with root package name */
    private int f1104c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1105d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1106e = 640;

    /* renamed from: f  reason: collision with root package name */
    private int f1107f = 480;

    /* renamed from: g  reason: collision with root package name */
    private int f1108g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f1109h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f1110i = 1;

    /* renamed from: j  reason: collision with root package name */
    private int f1111j = 0;
    private float k = 1.0f;
    private int l = 0;

    static /* synthetic */ void a(d dVar, int i2, int i3) {
        AppMethodBeat.i(16793);
        dVar.c(i2, i3);
        AppMethodBeat.o(16793);
    }

    public d(TextureView textureView) {
        AppMethodBeat.i(16783);
        this.f1102a = textureView;
        this.f1104c = textureView.getWidth();
        this.f1105d = textureView.getHeight();
        this.f1103b = new Handler(textureView.getContext().getMainLooper());
        AppMethodBeat.o(16783);
    }

    public void a(final int i2) {
        AppMethodBeat.i(16784);
        try {
            this.f1103b.post(new Runnable() {
                /* class com.tencent.liteav.renderer.d.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(16840);
                    d.this.b(i2);
                    AppMethodBeat.o(16840);
                }
            });
            AppMethodBeat.o(16784);
        } catch (Exception e2) {
            TXCLog.e("TXCTextureViewWrapper", "set render mode failed", e2);
            AppMethodBeat.o(16784);
        }
    }

    public void b(int i2) {
        float f2 = 1.0f;
        AppMethodBeat.i(16785);
        this.f1110i = i2;
        if (this.f1102a != null) {
            if (i2 == 1) {
                if (!(this.f1111j == 0 || this.f1111j == 180 || (this.f1111j != 270 && this.f1111j != 90))) {
                    if (this.f1108g == 0 || this.f1109h == 0) {
                        AppMethodBeat.o(16785);
                        return;
                    }
                    float f3 = ((float) this.f1105d) / ((float) this.f1108g);
                    f2 = ((float) this.f1104c) / ((float) this.f1109h);
                    if (f3 <= f2) {
                        f2 = f3;
                    }
                }
            } else if (i2 == 0) {
                if (this.f1108g == 0 || this.f1109h == 0) {
                    AppMethodBeat.o(16785);
                    return;
                } else if (this.f1111j == 0 || this.f1111j == 180) {
                    float f4 = ((float) this.f1105d) / ((float) this.f1109h);
                    f2 = ((float) this.f1104c) / ((float) this.f1108g);
                    if (f4 >= f2) {
                        f2 = f4;
                    }
                } else if (this.f1111j == 270 || this.f1111j == 90) {
                    float f5 = ((float) this.f1105d) / ((float) this.f1108g);
                    f2 = ((float) this.f1104c) / ((float) this.f1109h);
                    if (f5 >= f2) {
                        f2 = f5;
                    }
                }
            }
            if (this.k < 0.0f) {
                f2 = -f2;
            }
            this.f1102a.setScaleX(f2);
            this.f1102a.setScaleY(Math.abs(f2));
            this.k = f2;
        }
        AppMethodBeat.o(16785);
    }

    public void c(final int i2) {
        AppMethodBeat.i(16786);
        try {
            this.f1103b.post(new Runnable() {
                /* class com.tencent.liteav.renderer.d.AnonymousClass2 */

                public void run() {
                    AppMethodBeat.i(16889);
                    d.this.d(i2);
                    AppMethodBeat.o(16889);
                }
            });
            AppMethodBeat.o(16786);
        } catch (Exception e2) {
            TXCLog.e("TXCTextureViewWrapper", "set render rotation failed.", e2);
            AppMethodBeat.o(16786);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(int r7) {
        /*
        // Method dump skipped, instructions count: 169
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.d.d(int):void");
    }

    private void a() {
        AppMethodBeat.i(16788);
        try {
            a(new Runnable() {
                /* class com.tencent.liteav.renderer.d.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(16756);
                    d.a(d.this, d.this.f1106e, d.this.f1107f);
                    d.this.b(d.this.f1110i);
                    d.this.d(d.this.f1111j);
                    AppMethodBeat.o(16756);
                }
            });
            AppMethodBeat.o(16788);
        } catch (Exception e2) {
            TXCLog.e("TXCTextureViewWrapper", "adjust video size failed.", e2);
            AppMethodBeat.o(16788);
        }
    }

    private void c(int i2, int i3) {
        AppMethodBeat.i(16789);
        if (this.f1102a == null || i2 == 0 || i3 == 0) {
            AppMethodBeat.o(16789);
        } else if (this.f1104c == 0 || this.f1105d == 0) {
            AppMethodBeat.o(16789);
        } else {
            double d2 = ((double) i3) / ((double) i2);
            if (this.f1105d > ((int) (((double) this.f1104c) * d2))) {
                this.f1108g = this.f1104c;
                this.f1109h = (int) (d2 * ((double) this.f1104c));
            } else {
                this.f1108g = (int) (((double) this.f1105d) / d2);
                this.f1109h = this.f1105d;
            }
            float f2 = ((float) this.f1108g) / ((float) this.f1104c);
            float f3 = ((float) this.f1109h) / ((float) this.f1105d);
            Matrix matrix = new Matrix();
            this.f1102a.getTransform(matrix);
            matrix.setScale(f2, f3);
            matrix.postTranslate(((float) (this.f1104c - this.f1108g)) / 2.0f, ((float) (this.f1105d - this.f1109h)) / 2.0f);
            this.f1102a.setTransform(matrix);
            this.f1102a.requestLayout();
            AppMethodBeat.o(16789);
        }
    }

    public void a(int i2, int i3) {
        AppMethodBeat.i(16790);
        TXCLog.w("TXCTextureViewWrapper", "vrender: set view size:" + i2 + "," + i3);
        this.f1104c = i2;
        this.f1105d = i3;
        a();
        AppMethodBeat.o(16790);
    }

    public void b(int i2, int i3) {
        AppMethodBeat.i(16791);
        TXCLog.w("TXCTextureViewWrapper", "vrender: set video size:" + i2 + "," + i3);
        this.f1106e = i2;
        this.f1107f = i3;
        a();
        AppMethodBeat.o(16791);
    }

    private void a(Runnable runnable) {
        AppMethodBeat.i(16792);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
            AppMethodBeat.o(16792);
            return;
        }
        this.f1103b.post(runnable);
        AppMethodBeat.o(16792);
    }
}
