package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_chat_alert extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.6f, 12.6f);
                instancePath.lineTo(3.6f, 59.4f);
                instancePath.lineTo(32.4f, 59.4f);
                instancePath.lineTo(32.4f, 39.0f);
                instancePath.lineTo(36.0f, 39.0f);
                instancePath.lineTo(36.0f, 60.0f);
                instancePath.cubicTo(36.0f, 61.656853f, 34.656853f, 63.0f, 33.0f, 63.0f);
                instancePath.lineTo(3.0f, 63.0f);
                instancePath.cubicTo(1.3431457f, 63.0f, 2.0290612E-16f, 61.656853f, 0.0f, 60.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.cubicTo(-2.0290612E-16f, 10.343145f, 1.3431457f, 9.0f, 3.0f, 9.0f);
                instancePath.lineTo(9.0f, 9.0f);
                instancePath.lineTo(9.0f, 12.6f);
                instancePath.lineTo(3.6f, 12.6f);
                instancePath.close();
                instancePath.moveTo(16.11055f, 1.2103083f);
                instancePath.lineTo(19.060284f, 1.2103083f);
                instancePath.cubicTo(19.474497f, 1.2103083f, 19.810284f, 1.5460948f, 19.810284f, 1.9603083f);
                instancePath.cubicTo(19.810284f, 1.9685472f, 19.810148f, 1.9767857f, 19.809877f, 1.9850202f);
                instancePath.lineTo(19.409327f, 14.13502f);
                instancePath.cubicTo(19.395996f, 14.539394f, 19.06433f, 14.860309f, 18.659735f, 14.860309f);
                instancePath.lineTo(16.511099f, 14.860309f);
                instancePath.cubicTo(16.106504f, 14.860309f, 15.774837f, 14.539394f, 15.761506f, 14.13502f);
                instancePath.lineTo(15.360956f, 1.9850202f);
                instancePath.cubicTo(15.347308f, 1.5710315f, 15.671849f, 1.2243634f, 16.085838f, 1.2107155f);
                instancePath.cubicTo(16.094072f, 1.2104441f, 16.10231f, 1.2103083f, 16.11055f, 1.2103083f);
                instancePath.close();
                instancePath.moveTo(35.839252f, 8.160385f);
                instancePath.lineTo(37.92503f, 10.246162f);
                instancePath.cubicTo(38.217926f, 10.539056f, 38.217926f, 11.013929f, 37.92503f, 11.306823f);
                instancePath.cubicTo(37.919205f, 11.312649f, 37.913284f, 11.318378f, 37.90727f, 11.324009f);
                instancePath.lineTo(29.03269f, 19.632124f);
                instancePath.cubicTo(28.73733f, 19.908634f, 28.275883f, 19.90103f, 27.989792f, 19.614939f);
                instancePath.lineTo(26.470478f, 18.095625f);
                instancePath.cubicTo(26.184387f, 17.809532f, 26.176783f, 17.348087f, 26.45329f, 17.052727f);
                instancePath.lineTo(34.76141f, 8.178147f);
                instancePath.cubicTo(35.04449f, 7.8757625f, 35.519108f, 7.8601155f, 35.82149f, 8.143199f);
                instancePath.cubicTo(35.827507f, 8.14883f, 35.833427f, 8.154559f, 35.839252f, 8.160385f);
                instancePath.close();
                instancePath.moveTo(44.875107f, 27.025133f);
                instancePath.lineTo(44.875107f, 29.974867f);
                instancePath.cubicTo(44.875107f, 30.38908f, 44.53932f, 30.724867f, 44.125107f, 30.724867f);
                instancePath.cubicTo(44.11687f, 30.724867f, 44.10863f, 30.724731f, 44.100395f, 30.72446f);
                instancePath.lineTo(31.950396f, 30.32391f);
                instancePath.cubicTo(31.546022f, 30.31058f, 31.22511f, 29.978912f, 31.22511f, 29.574318f);
                instancePath.lineTo(31.22511f, 27.425682f);
                instancePath.cubicTo(31.22511f, 27.021088f, 31.546022f, 26.68942f, 31.950396f, 26.67609f);
                instancePath.lineTo(44.100395f, 26.27554f);
                instancePath.cubicTo(44.514385f, 26.261892f, 44.861053f, 26.586432f, 44.874702f, 27.000422f);
                instancePath.cubicTo(44.874973f, 27.008656f, 44.875107f, 27.016893f, 44.875107f, 27.025133f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
