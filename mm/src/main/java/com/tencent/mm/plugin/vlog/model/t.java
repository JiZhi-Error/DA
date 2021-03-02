package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006\u001a\u001a\u0010\n\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f\u001aJ\u0010\n\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006¨\u0006\u0016"}, hxF = {"scaleRect", "", FirebaseAnalytics.b.ORIGIN, "Landroid/graphics/Rect;", "target", "getScale", "", "Landroid/graphics/Matrix;", "scaleBy", "scale", "setRectToRectCenterCrop", "src", "Landroid/graphics/RectF;", "dst", "srcLeft", "srcTop", "srcRight", "srcBottom", "dstLeft", "dstTop", "dstRight", "dstBottom", "plugin-vlog_release"})
public final class t {
    public static final float e(Matrix matrix) {
        AppMethodBeat.i(190588);
        p.h(matrix, "$this$getScale");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float f2 = fArr[0];
        float f3 = fArr[3];
        float sqrt = (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
        AppMethodBeat.o(190588);
        return sqrt;
    }

    public static final void a(Matrix matrix, RectF rectF, RectF rectF2) {
        AppMethodBeat.i(190589);
        p.h(matrix, "$this$setRectToRectCenterCrop");
        p.h(rectF, "src");
        p.h(rectF2, "dst");
        matrix.reset();
        float max = Math.max(rectF2.height() / rectF.height(), rectF2.width() / rectF.width());
        matrix.postTranslate(-rectF.centerX(), -rectF.centerY());
        matrix.postScale(max, max);
        matrix.postTranslate(rectF2.centerX(), rectF2.centerY());
        AppMethodBeat.o(190589);
    }
}
