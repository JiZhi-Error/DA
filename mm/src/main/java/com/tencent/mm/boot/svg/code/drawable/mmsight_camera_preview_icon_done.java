package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mmsight_camera_preview_icon_done extends c {
    private final int height = 240;
    private final int width = 240;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15028967);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 68.0f, 0.0f, 1.0f, 85.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.540069f, 40.015434f);
                instancePath.cubicTo(12.961421f, 39.417805f, 12.934421f, 38.432583f, 13.489049f, 37.804356f);
                instancePath.lineTo(15.936921f, 35.03166f);
                instancePath.cubicTo(16.48739f, 34.408142f, 17.474325f, 34.316227f, 18.125168f, 34.814026f);
                instancePath.lineTo(37.615322f, 49.72111f);
                instancePath.cubicTo(38.273388f, 50.224434f, 39.324657f, 50.21021f, 39.97293f, 49.68157f);
                instancePath.lineTo(89.95811f, 8.920589f);
                instancePath.cubicTo(90.60211f, 8.395429f, 91.602684f, 8.439274f, 92.19417f, 9.019729f);
                instancePath.lineTo(93.4955f, 10.296785f);
                instancePath.cubicTo(94.08643f, 10.876699f, 94.083435f, 11.820237f, 93.50139f, 12.391867f);
                instancePath.lineTo(39.869316f, 65.06429f);
                instancePath.cubicTo(39.28163f, 65.64146f, 38.337345f, 65.62612f, 37.75749f, 65.027245f);
                instancePath.lineTo(13.540069f, 40.015434f);
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
