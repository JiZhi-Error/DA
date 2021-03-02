package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_banner_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-9473160);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(33.0f, 66.0f);
                instancePath.cubicTo(51.225395f, 66.0f, 66.0f, 51.225395f, 66.0f, 33.0f);
                instancePath.cubicTo(66.0f, 14.774603f, 51.225395f, 0.0f, 33.0f, 0.0f);
                instancePath.cubicTo(14.774603f, 0.0f, 0.0f, 14.774603f, 0.0f, 33.0f);
                instancePath.cubicTo(0.0f, 51.225395f, 14.774603f, 66.0f, 33.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(33.0f, 63.0f);
                instancePath.cubicTo(49.568542f, 63.0f, 63.0f, 49.568542f, 63.0f, 33.0f);
                instancePath.cubicTo(63.0f, 16.431458f, 49.568542f, 3.0f, 33.0f, 3.0f);
                instancePath.cubicTo(16.431458f, 3.0f, 3.0f, 16.431458f, 3.0f, 33.0f);
                instancePath.cubicTo(3.0f, 49.568542f, 16.431458f, 63.0f, 33.0f, 63.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(25.401f, 47.627f);
                instancePath2.cubicTo(20.217f, 47.627f, 16.0f, 44.08f, 16.0f, 39.72f);
                instancePath2.cubicTo(16.0f, 35.36f, 20.217f, 31.814f, 25.401f, 31.814f);
                instancePath2.cubicTo(26.23f, 31.814f, 26.901f, 32.485f, 26.901f, 33.314f);
                instancePath2.cubicTo(26.901f, 34.142f, 26.23f, 34.814f, 25.401f, 34.814f);
                instancePath2.cubicTo(21.871f, 34.814f, 19.0f, 37.015f, 19.0f, 39.72f);
                instancePath2.cubicTo(19.0f, 42.426f, 21.871f, 44.627f, 25.401f, 44.627f);
                instancePath2.cubicTo(28.931f, 44.627f, 31.802f, 42.426f, 31.802f, 39.72f);
                instancePath2.lineTo(31.802f, 26.907f);
                instancePath2.cubicTo(31.802f, 22.547f, 36.02f, 19.0f, 41.204f, 19.0f);
                instancePath2.cubicTo(46.388f, 19.0f, 50.605f, 22.547f, 50.605f, 26.907f);
                instancePath2.cubicTo(50.605f, 31.267f, 46.388f, 34.814f, 41.204f, 34.814f);
                instancePath2.cubicTo(40.375f, 34.814f, 39.704f, 34.142f, 39.704f, 33.314f);
                instancePath2.cubicTo(39.704f, 32.485f, 40.375f, 31.814f, 41.204f, 31.814f);
                instancePath2.cubicTo(44.734f, 31.814f, 47.605f, 29.612f, 47.605f, 26.907f);
                instancePath2.cubicTo(47.605f, 24.201f, 44.734f, 22.0f, 41.204f, 22.0f);
                instancePath2.cubicTo(37.674f, 22.0f, 34.802f, 24.201f, 34.802f, 26.907f);
                instancePath2.lineTo(34.802f, 39.72f);
                instancePath2.cubicTo(34.802f, 44.08f, 30.585f, 47.627f, 25.401f, 47.627f);
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
