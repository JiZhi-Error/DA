package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.support.v4.content.a.g;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
    private static final float zI = ((float) Math.tan(Math.toRadians(35.0d)));
    private float zJ = 0.0f;
    private float zK = 0.0f;
    private float zL = 70.0f;
    private float zM = 0.0f;
    private float zN = 0.0f;
    private float zO = zI;

    public ArcMotion() {
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.BZ);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        float a2 = g.a(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f);
        this.zK = a2;
        this.zN = w(a2);
        float a3 = g.a(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f);
        this.zJ = a3;
        this.zM = w(a3);
        float a4 = g.a(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f);
        this.zL = a4;
        this.zO = w(a4);
        obtainStyledAttributes.recycle();
    }

    private static float w(float f2) {
        if (f2 >= 0.0f && f2 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f2 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    @Override // android.support.transition.PathMotion
    public final Path getPath(float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        Path path = new Path();
        path.moveTo(f2, f3);
        float f11 = f4 - f2;
        float f12 = f5 - f3;
        float f13 = (f12 * f12) + (f11 * f11);
        float f14 = (f2 + f4) / 2.0f;
        float f15 = (f3 + f5) / 2.0f;
        float f16 = f13 * 0.25f;
        boolean z = f3 > f5;
        if (Math.abs(f11) < Math.abs(f12)) {
            float abs = Math.abs(f13 / (2.0f * f12));
            if (z) {
                f7 = f5 + abs;
                f6 = f4;
            } else {
                f7 = f3 + abs;
                f6 = f2;
            }
            f8 = this.zN * f16 * this.zN;
        } else {
            float f17 = f13 / (f11 * 2.0f);
            if (z) {
                f6 = f17 + f2;
                f7 = f3;
            } else {
                f6 = f4 - f17;
                f7 = f5;
            }
            f8 = this.zM * f16 * this.zM;
        }
        float f18 = f14 - f6;
        float f19 = f15 - f7;
        float f20 = (f19 * f19) + (f18 * f18);
        float f21 = this.zO * f16 * this.zO;
        if (f20 >= f8) {
            if (f20 > f21) {
                f8 = f21;
            } else {
                f8 = 0.0f;
            }
        }
        if (f8 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f8 / f20));
            f9 = ((f7 - f15) * sqrt) + f15;
            f10 = ((f6 - f14) * sqrt) + f14;
        } else {
            f9 = f7;
            f10 = f6;
        }
        path.cubicTo((f2 + f10) / 2.0f, (f3 + f9) / 2.0f, (f10 + f4) / 2.0f, (f9 + f5) / 2.0f, f4, f5);
        return path;
    }
}
