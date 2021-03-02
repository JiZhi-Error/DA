package com.tencent.mm.particles;

import android.graphics.Paint;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    private static final Paint jJe;
    private static Interpolator jJf;

    static {
        AppMethodBeat.i(151370);
        Paint paint = new Paint();
        jJe = paint;
        paint.setStyle(Paint.Style.FILL);
        AppMethodBeat.o(151370);
    }

    public static Interpolator bkO() {
        AppMethodBeat.i(151369);
        if (jJf == null) {
            jJf = new Interpolator() {
                /* class com.tencent.mm.particles.e.AnonymousClass1 */

                public final float getInterpolation(float f2) {
                    if (f2 >= 0.9f) {
                        return 1.0f - ((f2 - 0.9f) * 10.0f);
                    }
                    return 1.0f;
                }
            };
        }
        Interpolator interpolator = jJf;
        AppMethodBeat.o(151369);
        return interpolator;
    }
}
