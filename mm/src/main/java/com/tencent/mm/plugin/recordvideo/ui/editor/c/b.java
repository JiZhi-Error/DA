package com.tencent.mm.plugin.recordvideo.ui.editor.c;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/MatrixInterpolator;", "", "()V", "Companion", "plugin-recordvideo_release"})
public final class b {
    public static final a CgU = new a((byte) 0);

    static {
        AppMethodBeat.i(237929);
        AppMethodBeat.o(237929);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/MatrixInterpolator$Companion;", "", "()V", "clampScale", "", "matrix", "Landroid/graphics/Matrix;", "pivotSrc", "", "minScale", "", "maxScale", "getScale", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Matrix matrix, float[] fArr, float f2, float f3) {
            AppMethodBeat.i(237928);
            p.h(matrix, "matrix");
            p.h(fArr, "pivotSrc");
            p.h(matrix, "matrix");
            float[] fArr2 = new float[9];
            matrix.getValues(fArr2);
            double d2 = (double) fArr2[0];
            double d3 = (double) fArr2[3];
            float sqrt = (float) Math.sqrt((d3 * d3) + (d2 * d2));
            if (sqrt >= f2) {
                if (sqrt > f3) {
                    f2 = f3;
                } else {
                    AppMethodBeat.o(237928);
                    return;
                }
            }
            Matrix matrix2 = new Matrix();
            matrix.invert(matrix2);
            float[] fArr3 = new float[2];
            matrix2.mapPoints(fArr3, fArr);
            float[] fArr4 = new float[9];
            matrix.getValues(fArr4);
            double d4 = (double) fArr4[0];
            double d5 = (double) fArr4[3];
            Math.sqrt((d4 * d4) + (d5 * d5));
            float round = (float) Math.round(Math.atan2(d5, (double) fArr4[4]) * 57.29577951308232d);
            matrix.setTranslate(-fArr3[0], -fArr3[1]);
            matrix.postScale(f2, f2);
            matrix.postRotate(round);
            matrix.postTranslate(fArr[0], fArr[1]);
            AppMethodBeat.o(237928);
        }
    }
}
