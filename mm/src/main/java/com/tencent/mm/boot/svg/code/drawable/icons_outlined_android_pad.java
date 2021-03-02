package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_android_pad extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 6.123234E-17f, 1.0f, 0.0f, -1.0f, 6.123234E-17f, 72.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.0f, 6.0f);
                instancePath.cubicTo(58.656853f, 6.0f, 60.0f, 7.343146f, 60.0f, 9.0f);
                instancePath.lineTo(60.0f, 63.0f);
                instancePath.cubicTo(60.0f, 64.65685f, 58.656853f, 66.0f, 57.0f, 66.0f);
                instancePath.lineTo(15.0f, 66.0f);
                instancePath.cubicTo(13.343145f, 66.0f, 12.0f, 64.65685f, 12.0f, 63.0f);
                instancePath.lineTo(12.0f, 9.0f);
                instancePath.cubicTo(12.0f, 7.343146f, 13.343145f, 6.0f, 15.0f, 6.0f);
                instancePath.lineTo(57.0f, 6.0f);
                instancePath.close();
                instancePath.moveTo(56.4f, 9.6f);
                instancePath.lineTo(15.6f, 9.6f);
                instancePath.lineTo(15.6f, 62.4f);
                instancePath.lineTo(56.4f, 62.4f);
                instancePath.lineTo(56.4f, 9.6f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(36.0f, 18.0f);
                instancePath2.cubicTo(37.656853f, 18.0f, 39.0f, 19.343145f, 39.0f, 21.0f);
                instancePath2.cubicTo(39.0f, 22.656855f, 37.656853f, 24.0f, 36.0f, 24.0f);
                instancePath2.cubicTo(34.343147f, 24.0f, 33.0f, 22.656855f, 33.0f, 21.0f);
                instancePath2.cubicTo(33.0f, 19.343145f, 34.343147f, 18.0f, 36.0f, 18.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
