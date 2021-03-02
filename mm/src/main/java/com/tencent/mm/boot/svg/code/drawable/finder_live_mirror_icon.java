package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_live_mirror_icon extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -1.0f, 0.0f, 47.058353f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(29.991686f, 4.6666665f);
                instancePath.lineTo(29.991686f, 27.333334f);
                instancePath.lineTo(18.4f, 27.333334f);
                instancePath.cubicTo(17.66362f, 27.333334f, 17.066668f, 26.73638f, 17.066668f, 26.0f);
                instancePath.cubicTo(17.066668f, 25.882484f, 17.082203f, 25.765484f, 17.112871f, 25.652039f);
                instancePath.lineTo(22.519642f, 5.6520395f);
                instancePath.cubicTo(22.676844f, 5.0705433f, 23.204401f, 4.6666665f, 23.806772f, 4.6666665f);
                instancePath.lineTo(29.991686f, 4.6666665f);
                instancePath.close();
                instancePath.moveTo(29.991064f, 6.8f);
                instancePath.lineTo(24.418352f, 6.8f);
                instancePath.lineTo(19.443686f, 25.2f);
                instancePath.lineTo(29.991064f, 25.2f);
                instancePath.lineTo(29.991064f, 6.8f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(14.666667f, 4.6666665f);
                instancePath2.lineTo(14.666667f, 27.333334f);
                instancePath2.lineTo(3.074981f, 27.333334f);
                instancePath2.cubicTo(2.3386014f, 27.333334f, 1.7416477f, 26.73638f, 1.7416477f, 26.0f);
                instancePath2.cubicTo(1.7416477f, 25.882484f, 1.7571837f, 25.765484f, 1.787852f, 25.652039f);
                instancePath2.lineTo(7.194624f, 5.6520395f);
                instancePath2.cubicTo(7.3518248f, 5.0705433f, 7.8793826f, 4.6666665f, 8.481753f, 4.6666665f);
                instancePath2.lineTo(14.666667f, 4.6666665f);
                instancePath2.lineTo(14.666667f, 4.6666665f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
