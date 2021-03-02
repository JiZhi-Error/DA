package android.support.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.graphics.c;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public final class g implements Interpolator {
    private float[] xi;
    private float[] xj;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a2 = android.support.v4.content.a.g.a(resources, theme, attributeSet, a.wV);
        if (android.support.v4.content.a.g.a(xmlPullParser, "pathData")) {
            String c2 = android.support.v4.content.a.g.c(a2, xmlPullParser, "pathData", 4);
            Path x = c.x(c2);
            if (x == null) {
                throw new InflateException("The path is null, which is created from ".concat(String.valueOf(c2)));
            }
            a(x);
        } else if (!android.support.v4.content.a.g.a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (!android.support.v4.content.a.g.a(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        } else {
            float a3 = android.support.v4.content.a.g.a(a2, xmlPullParser, "controlX1", 0, 0.0f);
            float a4 = android.support.v4.content.a.g.a(a2, xmlPullParser, "controlY1", 1, 0.0f);
            boolean a5 = android.support.v4.content.a.g.a(xmlPullParser, "controlX2");
            if (a5 != android.support.v4.content.a.g.a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!a5) {
                Path path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.quadTo(a3, a4, 1.0f, 1.0f);
                a(path);
            } else {
                float a6 = android.support.v4.content.a.g.a(a2, xmlPullParser, "controlX2", 2, 0.0f);
                float a7 = android.support.v4.content.a.g.a(a2, xmlPullParser, "controlY2", 3, 0.0f);
                Path path2 = new Path();
                path2.moveTo(0.0f, 0.0f);
                path2.cubicTo(a3, a4, a6, a7, 1.0f, 1.0f);
                a(path2);
            }
        }
        a2.recycle();
    }

    private void a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length ".concat(String.valueOf(length)));
        }
        this.xi = new float[min];
        this.xj = new float[min];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < min; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (min - 1)), fArr, null);
            this.xi[i2] = fArr[0];
            this.xj[i2] = fArr[1];
        }
        if (((double) Math.abs(this.xi[0])) > 1.0E-5d || ((double) Math.abs(this.xj[0])) > 1.0E-5d || ((double) Math.abs(this.xi[min - 1] - 1.0f)) > 1.0E-5d || ((double) Math.abs(this.xj[min - 1] - 1.0f)) > 1.0E-5d) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.xi[0] + "," + this.xj[0] + " end:" + this.xi[min - 1] + "," + this.xj[min - 1]);
        }
        float f2 = 0.0f;
        int i3 = 0;
        int i4 = 0;
        while (i4 < min) {
            int i5 = i3 + 1;
            float f3 = this.xi[i3];
            if (f3 < f2) {
                throw new IllegalArgumentException("The Path cannot loop back on itself, x :".concat(String.valueOf(f3)));
            }
            this.xi[i4] = f3;
            i4++;
            i3 = i5;
            f2 = f3;
        }
        if (pathMeasure.nextContour()) {
            throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        }
    }

    public final float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int length = this.xi.length - 1;
        int i2 = 0;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.xi[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float f3 = this.xi[length] - this.xi[i2];
        if (f3 == 0.0f) {
            return this.xj[i2];
        }
        float f4 = (f2 - this.xi[i2]) / f3;
        float f5 = this.xj[i2];
        return (f4 * (this.xj[length] - f5)) + f5;
    }
}
