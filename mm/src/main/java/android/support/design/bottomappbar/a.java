package android.support.design.bottomappbar;

import android.support.design.f.b;
import android.support.design.f.d;

public final class a extends b {
    float ht;
    float hu;
    float hv;
    float hw;
    float hx;

    public a(float f2, float f3, float f4) {
        this.hu = f2;
        this.ht = f3;
        this.hw = f4;
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.hx = 0.0f;
    }

    @Override // android.support.design.f.b
    public final void a(float f2, float f3, d dVar) {
        if (this.hv == 0.0f) {
            dVar.j(f2);
            return;
        }
        float f4 = ((this.hu * 2.0f) + this.hv) / 2.0f;
        float f5 = f3 * this.ht;
        float f6 = (f2 / 2.0f) + this.hx;
        float f7 = (this.hw * f3) + ((1.0f - f3) * f4);
        if (f7 / f4 >= 1.0f) {
            dVar.j(f2);
            return;
        }
        float f8 = f4 + f5;
        float f9 = f7 + f5;
        float sqrt = (float) Math.sqrt((double) ((f8 * f8) - (f9 * f9)));
        float f10 = f6 - sqrt;
        float f11 = f6 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f9)));
        float f12 = 90.0f - degrees;
        dVar.j(f10 - f5);
        dVar.addArc(f10 - f5, 0.0f, f10 + f5, f5 * 2.0f, 270.0f, degrees);
        dVar.addArc(f6 - f4, (-f4) - f7, f6 + f4, f4 - f7, 180.0f - f12, (2.0f * f12) - 180.0f);
        dVar.addArc(f11 - f5, 0.0f, f11 + f5, f5 * 2.0f, 270.0f - degrees, degrees);
        dVar.j(f2);
    }
}
