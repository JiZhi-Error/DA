package com.tencent.tav.core;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

public class CGMathFunctions {
    public static Matrix transformBySourceRectFit(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(217862);
        CGRect rectFit = rectFit(cGRect, cGRect2);
        float f2 = rectFit.size.width / cGRect.size.width;
        float f3 = rectFit.size.height / cGRect.size.height;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f3);
        matrix.postTranslate(rectFit.origin.x - (cGRect.origin.x * f2), rectFit.origin.y - (cGRect.origin.y * f3));
        AppMethodBeat.o(217862);
        return matrix;
    }

    private static CGRect rectFit(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(217863);
        CGSize sizeFit = sizeFit(cGRect.size, cGRect2.size);
        CGRect cGRect3 = new CGRect(cGRect2.origin.x + ((cGRect2.size.width - sizeFit.width) / 2.0f), cGRect2.origin.y + ((cGRect2.size.height - sizeFit.height) / 2.0f), sizeFit.width, sizeFit.height);
        AppMethodBeat.o(217863);
        return cGRect3;
    }

    static CGSize sizeFit(CGSize cGSize, CGSize cGSize2) {
        AppMethodBeat.i(217864);
        CGSize clone = cGSize2.clone();
        float f2 = cGSize2.width / cGSize.width;
        float f3 = cGSize2.height / cGSize.height;
        if (f3 < f2) {
            clone.width = (float) Math.round(cGSize.width * f3);
        } else if (f2 < f3) {
            clone.height = (float) Math.round(f2 * cGSize.height);
        }
        AppMethodBeat.o(217864);
        return clone;
    }

    public static Matrix transformBySourceRectFill(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(217865);
        CGRect rectFill = rectFill(cGRect, cGRect2);
        float f2 = rectFill.size.width / cGRect.size.width;
        float f3 = rectFill.size.height / cGRect.size.height;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f3);
        matrix.postTranslate(rectFill.origin.x - (f2 * cGRect.origin.x), rectFill.origin.y - (f3 * cGRect.origin.y));
        AppMethodBeat.o(217865);
        return matrix;
    }

    private static CGRect rectFill(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(217866);
        CGSize sizeFill = sizeFill(cGRect.size, cGRect2.size);
        CGRect cGRect3 = new CGRect(cGRect2.origin.x + ((cGRect2.size.width - sizeFill.width) / 2.0f), cGRect2.origin.y + ((cGRect2.size.height - sizeFill.height) / 2.0f), sizeFill.width, sizeFill.height);
        AppMethodBeat.o(217866);
        return cGRect3;
    }

    private static CGSize sizeFill(CGSize cGSize, CGSize cGSize2) {
        AppMethodBeat.i(217867);
        CGSize clone = cGSize2.clone();
        float f2 = cGSize2.width / cGSize.width;
        float f3 = cGSize2.height / cGSize.height;
        if (f3 > f2) {
            clone.width = cGSize.width * f3;
        } else if (f2 > f3) {
            clone.height = f2 * cGSize.height;
        }
        AppMethodBeat.o(217867);
        return clone;
    }

    public static Matrix transformByScaleFitRect(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(217868);
        Matrix matrix = new Matrix();
        matrix.postScale(cGRect2.size.width / cGRect.size.width, cGRect2.size.height / cGRect.size.height);
        AppMethodBeat.o(217868);
        return matrix;
    }

    public static CGRect initGLViewportDefault(CGSize cGSize, CGSize cGSize2) {
        AppMethodBeat.i(217869);
        CGRect cGRect = new CGRect(new PointF((cGSize.width - cGSize2.width) / 2.0f, (cGSize.height - cGSize2.height) / 2.0f), cGSize2);
        AppMethodBeat.o(217869);
        return cGRect;
    }

    public static CGRect initGLViewportFill(CGSize cGSize, CGSize cGSize2) {
        float f2;
        float f3;
        float f4;
        AppMethodBeat.i(217870);
        float f5 = cGSize2.height;
        float f6 = cGSize2.width;
        float f7 = cGSize.height;
        float f8 = cGSize.width;
        if (f8 / f7 > f6 / f5) {
            f4 = (f5 * f8) / f6;
            f3 = (f7 - f4) / 2.0f;
            f2 = 0.0f;
        } else {
            float f9 = (f6 * f7) / f5;
            f2 = (f8 - f9) / 2.0f;
            f8 = f9;
            f3 = 0.0f;
            f4 = f7;
        }
        CGRect cGRect = new CGRect(new PointF(f2, f3), new CGSize(f8, f4));
        AppMethodBeat.o(217870);
        return cGRect;
    }

    public static CGRect initGLViewportFit(CGSize cGSize, CGSize cGSize2) {
        float f2;
        float f3;
        float f4;
        AppMethodBeat.i(217871);
        float f5 = cGSize2.height;
        float f6 = cGSize2.width;
        float f7 = cGSize.height;
        float f8 = cGSize.width;
        if (f8 / f7 > f6 / f5) {
            f3 = (f6 * f7) / f5;
            f2 = 0.0f;
            f4 = (f8 - f3) / 2.0f;
        } else {
            float f9 = (f5 * f8) / f6;
            f2 = (f7 - f9) / 2.0f;
            f3 = f8;
            f4 = 0.0f;
            f7 = f9;
        }
        CGRect cGRect = new CGRect(new PointF(f4, f2), new CGSize(f3, f7));
        AppMethodBeat.o(217871);
        return cGRect;
    }
}
