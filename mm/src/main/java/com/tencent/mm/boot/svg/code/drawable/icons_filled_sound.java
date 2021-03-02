package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_sound extends c {
    private final int height = 24;
    private final int width = 22;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 22;
            case 1:
                return 24;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
                Paint instancePaint = c.instancePaint(looper);
                instancePaint.setFlags(385);
                instancePaint.setStyle(Paint.Style.FILL);
                Paint instancePaint2 = c.instancePaint(looper);
                instancePaint2.setFlags(385);
                instancePaint2.setStyle(Paint.Style.STROKE);
                instancePaint.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint2.setStrokeWidth(1.0f);
                instancePaint2.setStrokeCap(Paint.Cap.BUTT);
                instancePaint2.setStrokeJoin(Paint.Join.MITER);
                instancePaint2.setStrokeMiter(4.0f);
                instancePaint2.setPathEffect(null);
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -299.0f, 0.0f, 1.0f, -821.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 820.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 272.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.966667f, 4.6666665f);
                instancePath.cubicTo(11.610999f, 4.6666665f, 12.133333f, 5.189001f, 12.133333f, 5.8333335f);
                instancePath.lineTo(12.133333f, 22.166666f);
                instancePath.cubicTo(12.133333f, 22.810999f, 11.610999f, 23.333334f, 10.966667f, 23.333334f);
                instancePath.cubicTo(10.322334f, 23.333334f, 9.8f, 22.810999f, 9.8f, 22.166666f);
                instancePath.lineTo(9.8f, 5.8333335f);
                instancePath.cubicTo(9.8f, 5.189001f, 10.322334f, 4.6666665f, 10.966667f, 4.6666665f);
                instancePath.close();
                instancePath.moveTo(23.1f, 8.166667f);
                instancePath.cubicTo(23.744331f, 8.166667f, 24.266666f, 8.689001f, 24.266666f, 9.333333f);
                instancePath.lineTo(24.266666f, 18.666666f);
                instancePath.cubicTo(24.266666f, 19.310999f, 23.744331f, 19.833334f, 23.1f, 19.833334f);
                instancePath.cubicTo(22.455667f, 19.833334f, 21.933332f, 19.310999f, 21.933332f, 18.666666f);
                instancePath.lineTo(21.933332f, 9.333333f);
                instancePath.cubicTo(21.933332f, 8.689001f, 22.455667f, 8.166667f, 23.1f, 8.166667f);
                instancePath.close();
                instancePath.moveTo(4.9f, 8.166667f);
                instancePath.cubicTo(5.544332f, 8.166667f, 6.0666666f, 8.689001f, 6.0666666f, 9.333333f);
                instancePath.lineTo(6.0666666f, 18.666666f);
                instancePath.cubicTo(6.0666666f, 19.310999f, 5.544332f, 19.833334f, 4.9f, 19.833334f);
                instancePath.cubicTo(4.2556677f, 19.833334f, 3.7333333f, 19.310999f, 3.7333333f, 18.666666f);
                instancePath.lineTo(3.7333333f, 9.333333f);
                instancePath.cubicTo(3.7333333f, 8.689001f, 4.2556677f, 8.166667f, 4.9f, 8.166667f);
                instancePath.close();
                instancePath.moveTo(17.033333f, 10.5f);
                instancePath.cubicTo(17.677666f, 10.5f, 18.2f, 11.022334f, 18.2f, 11.666667f);
                instancePath.lineTo(18.2f, 16.333334f);
                instancePath.cubicTo(18.2f, 16.977665f, 17.677666f, 17.5f, 17.033333f, 17.5f);
                instancePath.cubicTo(16.389002f, 17.5f, 15.866667f, 16.977665f, 15.866667f, 16.333334f);
                instancePath.lineTo(15.866667f, 11.666667f);
                instancePath.cubicTo(15.866667f, 11.022334f, 16.389002f, 10.5f, 17.033333f, 10.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 3.5f, 0.0f, 1.0f, 1.166667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(9.333687f, 2.3973777f);
                instancePath2.lineTo(9.3333235f, 4.7493715f);
                instancePath2.cubicTo(5.375652f, 5.315477f, 2.3333333f, 8.719119f, 2.3333333f, 12.833333f);
                instancePath2.cubicTo(2.3333333f, 17.343658f, 5.9896746f, 21.0f, 10.5f, 21.0f);
                instancePath2.cubicTo(15.010325f, 21.0f, 18.666666f, 17.343658f, 18.666666f, 12.833333f);
                instancePath2.cubicTo(18.666666f, 10.954031f, 18.031885f, 9.22299f, 16.965038f, 7.842927f);
                instancePath2.lineTo(16.796928f, 7.6326804f);
                instancePath2.lineTo(19.230915f, 6.9985886f);
                instancePath2.cubicTo(20.348316f, 8.667316f, 21.0f, 10.67422f, 21.0f, 12.833333f);
                instancePath2.cubicTo(21.0f, 18.632322f, 16.29899f, 23.333334f, 10.5f, 23.333334f);
                instancePath2.cubicTo(4.70101f, 23.333334f, -8.289665E-15f, 18.632322f, -8.289665E-15f, 12.833333f);
                instancePath2.cubicTo(-8.289665E-15f, 7.428566f, 4.083575f, 2.9775686f, 9.333687f, 2.3973777f);
                instancePath2.close();
                instancePath2.moveTo(19.246092f, 0.5963464f);
                instancePath2.lineTo(19.24902f, 0.6111901f);
                instancePath2.lineTo(19.24902f, 0.6111901f);
                instancePath2.lineTo(19.25f, 3.8848686f);
                instancePath2.cubicTo(19.25f, 3.9377704f, 19.214405f, 3.984051f, 19.163275f, 3.9976277f);
                instancePath2.lineTo(14.0f, 5.3687587f);
                instancePath2.lineTo(14.0f, 12.833333f);
                instancePath2.cubicTo(14.0f, 14.697294f, 12.542927f, 16.220938f, 10.705651f, 16.327393f);
                instancePath2.lineTo(10.5f, 16.333334f);
                instancePath2.cubicTo(8.567003f, 16.333334f, 7.0f, 14.76633f, 7.0f, 12.833333f);
                instancePath2.cubicTo(7.0f, 10.900336f, 8.567003f, 9.333333f, 10.5f, 9.333333f);
                instancePath2.cubicTo(11.13785f, 9.333333f, 11.735848f, 9.50396f, 12.250842f, 9.802058f);
                instancePath2.lineTo(12.25f, 3.2306402f);
                instancePath2.cubicTo(12.25f, 2.7016218f, 12.605953f, 2.2388158f, 13.117253f, 2.1030486f);
                instancePath2.lineTo(19.103392f, 0.5135285f);
                instancePath2.cubicTo(19.165667f, 0.49699238f, 19.229557f, 0.5340712f, 19.246092f, 0.5963464f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}