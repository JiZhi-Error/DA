package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.a.g;
import android.support.v4.graphics.c;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {
    private final Matrix AB = new Matrix();
    private Path BC;
    private final Path BD = new Path();

    public PatternPathMotion() {
        this.BD.lineTo(1.0f, 0.0f);
        this.BC = this.BD;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.Ca);
        try {
            String c2 = g.c(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (c2 == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            Path x = c.x(c2);
            PathMeasure pathMeasure = new PathMeasure(x, false);
            float[] fArr = new float[2];
            pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
            float f2 = fArr[0];
            float f3 = fArr[1];
            pathMeasure.getPosTan(0.0f, fArr, null);
            float f4 = fArr[0];
            float f5 = fArr[1];
            if (f4 == f2 && f5 == f3) {
                throw new IllegalArgumentException("pattern must not end at the starting point");
            }
            this.AB.setTranslate(-f4, -f5);
            float f6 = f2 - f4;
            float f7 = f3 - f5;
            float h2 = 1.0f / h(f6, f7);
            this.AB.postScale(h2, h2);
            this.AB.postRotate((float) Math.toDegrees(-Math.atan2((double) f7, (double) f6)));
            x.transform(this.AB, this.BD);
            this.BC = x;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.support.transition.PathMotion
    public final Path getPath(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float h2 = h(f6, f7);
        double atan2 = Math.atan2((double) f7, (double) f6);
        this.AB.setScale(h2, h2);
        this.AB.postRotate((float) Math.toDegrees(atan2));
        this.AB.postTranslate(f2, f3);
        Path path = new Path();
        this.BD.transform(this.AB, path);
        return path;
    }

    private static float h(float f2, float f3) {
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }
}
