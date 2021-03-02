package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class biz_info_brand_unselect extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                instancePaint3.setColor(-2697514);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.307041f, 16.743668f);
                instancePath.cubicTo(20.848019f, 11.149101f, 23.42901f, 5.5745506f, 25.989996f, 0.0f);
                instancePath.cubicTo(28.641016f, 5.5545344f, 31.141977f, 11.189134f, 33.752983f, 16.773693f);
                instancePath.cubicTo(39.83532f, 17.174019f, 45.91766f, 17.574347f, 52.0f, 17.984682f);
                instancePath.cubicTo(47.568295f, 22.03799f, 43.07657f, 26.03125f, 38.66487f, 30.104576f);
                instancePath.cubicTo(40.075413f, 36.399715f, 41.475952f, 42.694855f, 42.87649f, 48.98999f);
                instancePath.cubicTo(37.25433f, 45.867443f, 31.64217f, 42.724876f, 26.010004f, 39.622345f);
                instancePath.cubicTo(20.377838f, 42.734886f, 14.765679f, 45.867443f, 9.143517f, 49.0f);
                instancePath.cubicTo(10.544055f, 42.694855f, 11.954597f, 36.399715f, 13.355137f, 30.104576f);
                instancePath.cubicTo(9.113505f, 26.24142f, 4.921893f, 22.338236f, 0.58022314f, 18.59518f);
                instancePath.cubicTo(0.4401693f, 18.59518f, 0.15005772f, 18.58517f, 0.0f, 18.575163f);
                instancePath.lineTo(0.0f, 18.324959f);
                instancePath.cubicTo(6.03232f, 17.22406f, 12.214698f, 17.354166f, 18.307041f, 16.743668f);
                instancePath.lineTo(18.307041f, 16.743668f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
