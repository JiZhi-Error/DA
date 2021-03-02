package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_music extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-10197008);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.0f, 0.0f);
                instancePath.lineTo(68.0f, 22.0f);
                instancePath.lineTo(68.0f, 87.0f);
                instancePath.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                instancePath.lineTo(3.0f, 90.0f);
                instancePath.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                instancePath.lineTo(0.0f, 3.0f);
                instancePath.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                instancePath.lineTo(46.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(68.0f, 22.0f);
                instancePath2.lineTo(49.0f, 22.0f);
                instancePath2.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                instancePath2.lineTo(46.0f, 0.0f);
                instancePath2.lineTo(68.0f, 22.0f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 51, 31);
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(46.252487f, 44.839684f);
                instancePath3.lineTo(26.667143f, 48.85265f);
                instancePath3.lineTo(26.667143f, 66.858986f);
                instancePath3.lineTo(26.667143f, 68.5715f);
                instancePath3.cubicTo(26.667143f, 70.166306f, 25.580133f, 71.72134f, 24.118086f, 72.391304f);
                instancePath3.cubicTo(23.846298f, 72.51585f, 22.129362f, 72.89289f, 21.905174f, 72.9372f);
                instancePath3.cubicTo(19.751049f, 73.36299f, 18.095936f, 71.55011f, 18.004787f, 69.71689f);
                instancePath3.cubicTo(17.913637f, 67.88367f, 19.13724f, 66.35503f, 20.556929f, 66.07441f);
                instancePath3.lineTo(22.858772f, 65.61942f);
                instancePath3.cubicTo(24.065191f, 65.38096f, 24.934671f, 64.32279f, 24.934671f, 63.09303f);
                instancePath3.lineTo(24.934671f, 46.618843f);
                instancePath3.cubicTo(24.935736f, 46.618027f, 24.936798f, 46.617214f, 24.93786f, 46.6164f);
                instancePath3.lineTo(24.93786f, 45.481544f);
                instancePath3.cubicTo(24.93786f, 44.873074f, 25.365826f, 44.34853f, 25.961914f, 44.226395f);
                instancePath3.lineTo(46.461594f, 40.026085f);
                instancePath3.cubicTo(47.154797f, 39.88405f, 47.83189f, 40.330856f, 47.973923f, 41.02406f);
                instancePath3.cubicTo(47.991264f, 41.10869f, 48.0f, 41.19485f, 48.0f, 41.28124f);
                instancePath3.lineTo(48.0f, 44.02073f);
                instancePath3.lineTo(48.0f, 62.217106f);
                instancePath3.lineTo(48.0f, 63.929623f);
                instancePath3.cubicTo(48.0f, 65.52442f, 46.903553f, 67.07946f, 45.42881f, 67.74942f);
                instancePath3.cubicTo(45.15466f, 67.87396f, 43.422817f, 68.251015f, 43.196682f, 68.29533f);
                instancePath3.cubicTo(41.023853f, 68.721115f, 39.35437f, 66.908226f, 39.26243f, 65.075005f);
                instancePath3.cubicTo(39.170486f, 63.241783f, 40.404713f, 61.713146f, 41.836727f, 61.432526f);
                instancePath3.lineTo(44.172447f, 60.97482f);
                instancePath3.cubicTo(45.380814f, 60.738026f, 46.252487f, 59.67896f, 46.252487f, 58.447613f);
                instancePath3.lineTo(46.252487f, 44.839684f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
