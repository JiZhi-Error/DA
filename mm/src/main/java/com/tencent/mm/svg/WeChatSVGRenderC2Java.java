package com.tencent.mm.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WeChatSVGRenderC2Java {
    public static Bitmap checkForImageDataURL(String str) {
        return null;
    }

    public static void invert(Matrix matrix, Matrix matrix2) {
        AppMethodBeat.i(148691);
        matrix.invert(matrix2);
        AppMethodBeat.o(148691);
    }

    public static void doNonScalingStroke(Canvas canvas, Path path, Paint paint) {
        AppMethodBeat.i(148692);
        Matrix matrix = canvas.getMatrix();
        Path path2 = new Path();
        path.transform(matrix, path2);
        canvas.setMatrix(new Matrix());
        Shader shader = paint.getShader();
        Matrix matrix2 = new Matrix();
        if (shader != null) {
            shader.getLocalMatrix(matrix2);
            Matrix matrix3 = new Matrix(matrix2);
            matrix3.postConcat(matrix);
            shader.setLocalMatrix(matrix3);
        }
        canvas.drawPath(path2, paint);
        canvas.setMatrix(matrix);
        if (shader != null) {
            shader.setLocalMatrix(matrix2);
        }
        AppMethodBeat.o(148692);
    }

    public static void setRadialGradient(Paint paint, float f2, float f3, float f4, int[] iArr, float[] fArr, Matrix matrix, int i2) {
        AppMethodBeat.i(148693);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (i2 != 0) {
            if (i2 == 2) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (i2 == 3) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        RadialGradient radialGradient = new RadialGradient(f2, f3, f4, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        AppMethodBeat.o(148693);
    }

    public static void setLinearGradient(Paint paint, float f2, float f3, float f4, float f5, int[] iArr, float[] fArr, Matrix matrix, int i2) {
        AppMethodBeat.i(148694);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (i2 != 0) {
            if (i2 == 2) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (i2 == 3) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        LinearGradient linearGradient = new LinearGradient(f2, f3, f4, f5, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        AppMethodBeat.o(148694);
    }

    public static void addPath(Path path, Matrix matrix, Path path2, boolean z) {
        AppMethodBeat.i(148695);
        if (z) {
            path.setFillType(path2.getFillType());
        }
        path.addPath(path2, matrix);
        AppMethodBeat.o(148695);
    }

    public static float getPathMeasureLength(Path path, Matrix matrix) {
        AppMethodBeat.i(148696);
        if (matrix != null) {
            path.transform(matrix);
        }
        float length = new PathMeasure(path, false).getLength();
        AppMethodBeat.o(148696);
        return length;
    }

    public static void setFillType(Path path, int i2) {
        AppMethodBeat.i(148697);
        switch (i2) {
            case 0:
            case 1:
                path.setFillType(Path.FillType.WINDING);
                AppMethodBeat.o(148697);
                return;
            case 2:
                path.setFillType(Path.FillType.EVEN_ODD);
                break;
        }
        AppMethodBeat.o(148697);
    }

    public static void addTextPath(Paint paint, Path path, String str, float f2, float f3) {
        AppMethodBeat.i(148698);
        Path path2 = new Path();
        paint.getTextPath(str, 0, str.length(), f2, f3, path2);
        path.addPath(path2);
        AppMethodBeat.o(148698);
    }

    public static float[] computePathBound(Path path, Matrix matrix) {
        AppMethodBeat.i(148699);
        if (matrix != null) {
            path.transform(matrix);
        }
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        float[] fArr = {rectF.left, rectF.top, rectF.right, rectF.bottom};
        AppMethodBeat.o(148699);
        return fArr;
    }

    public static float[] getTextBounds(Paint paint, String str) {
        AppMethodBeat.i(148700);
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        RectF rectF = new RectF(rect);
        float[] fArr = {rectF.left, rectF.top, rectF.right, rectF.bottom};
        AppMethodBeat.o(148700);
        return fArr;
    }
}
