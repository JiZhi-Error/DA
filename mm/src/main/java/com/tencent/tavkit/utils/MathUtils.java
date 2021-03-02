package com.tencent.tavkit.utils;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

public class MathUtils {
    public static Matrix transformBySourceRect(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(197674);
        CGRect rect = rect(cGRect, cGRect2);
        float f2 = rect.size.width / cGRect.size.width;
        float f3 = rect.size.height / cGRect.size.height;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f3);
        matrix.postTranslate(rect.origin.x - (f2 * cGRect.origin.x), rect.origin.y - (f3 * cGRect.origin.y));
        AppMethodBeat.o(197674);
        return matrix;
    }

    public static CGRect rect(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(197675);
        CGSize size = size(cGRect.size, cGRect2.size);
        CGRect cGRect3 = new CGRect(cGRect2.origin.x + ((cGRect2.size.width - size.width) / 2.0f), cGRect2.origin.y + ((cGRect2.size.height - size.height) / 2.0f), size.width, size.height);
        AppMethodBeat.o(197675);
        return cGRect3;
    }

    public static CGSize size(CGSize cGSize, CGSize cGSize2) {
        AppMethodBeat.i(197676);
        CGSize clone = cGSize2.clone();
        float f2 = cGSize2.width / cGSize.width;
        float f3 = cGSize2.height / cGSize.height;
        if (f3 > f2) {
            clone.width = cGSize.width * f3;
        } else if (f2 > f3) {
            clone.height = f2 * cGSize.height;
        }
        AppMethodBeat.o(197676);
        return clone;
    }

    public static Matrix transformBySourceRectFit(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(197677);
        CGRect rectFit = rectFit(cGRect, cGRect2);
        float f2 = rectFit.size.width / cGRect.size.width;
        float f3 = rectFit.size.height / cGRect.size.height;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f3);
        matrix.postTranslate(rectFit.origin.x - (cGRect.origin.x * f2), rectFit.origin.y - (cGRect.origin.y * f3));
        AppMethodBeat.o(197677);
        return matrix;
    }

    public static CGRect rectFit(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(197678);
        CGSize sizeFit = sizeFit(cGRect.size, cGRect2.size);
        CGRect cGRect3 = new CGRect(cGRect2.origin.x + ((cGRect2.size.width - sizeFit.width) / 2.0f), cGRect2.origin.y + ((cGRect2.size.height - sizeFit.height) / 2.0f), sizeFit.width, sizeFit.height);
        AppMethodBeat.o(197678);
        return cGRect3;
    }

    public static CGSize sizeFit(CGSize cGSize, CGSize cGSize2) {
        AppMethodBeat.i(197679);
        CGSize clone = cGSize2.clone();
        float f2 = cGSize2.width / cGSize.width;
        float f3 = cGSize2.height / cGSize.height;
        if (f3 < f2) {
            clone.width = (float) Math.round(cGSize.width * f3);
        } else if (f2 < f3) {
            clone.height = (float) Math.round(f2 * cGSize.height);
        }
        AppMethodBeat.o(197679);
        return clone;
    }

    public static Matrix transformBySourceRectFill(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(197680);
        CGRect rectFill = rectFill(cGRect, cGRect2);
        float f2 = rectFill.size.width / cGRect.size.width;
        float f3 = rectFill.size.height / cGRect.size.height;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f3);
        matrix.postTranslate(rectFill.origin.x - (f2 * cGRect.origin.x), rectFill.origin.y - (f3 * cGRect.origin.y));
        AppMethodBeat.o(197680);
        return matrix;
    }

    public static CGRect rectFill(CGRect cGRect, CGRect cGRect2) {
        AppMethodBeat.i(197681);
        CGSize sizeFill = sizeFill(cGRect.size, cGRect2.size);
        CGRect cGRect3 = new CGRect(cGRect2.origin.x + ((cGRect2.size.width - sizeFill.width) / 2.0f), cGRect2.origin.y + ((cGRect2.size.height - sizeFill.height) / 2.0f), sizeFill.width, sizeFill.height);
        AppMethodBeat.o(197681);
        return cGRect3;
    }

    public static CGSize sizeFill(CGSize cGSize, CGSize cGSize2) {
        AppMethodBeat.i(197682);
        CGSize clone = cGSize2.clone();
        float f2 = cGSize2.width / cGSize.width;
        float f3 = cGSize2.height / cGSize.height;
        if (f3 > f2) {
            clone.width = cGSize.width * f3;
        } else if (f2 > f3) {
            clone.height = f2 * cGSize.height;
        }
        AppMethodBeat.o(197682);
        return clone;
    }

    public static CGSize sizeScale(CGSize cGSize, CGSize cGSize2) {
        return cGSize2;
    }
}
