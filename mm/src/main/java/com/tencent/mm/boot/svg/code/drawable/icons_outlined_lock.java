package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_lock extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 21.0f);
                instancePath.lineTo(12.0f, 12.0f);
                instancePath.cubicTo(12.0f, 5.372583f, 17.372583f, 0.0f, 24.0f, 0.0f);
                instancePath.cubicTo(30.627417f, 0.0f, 36.0f, 5.372583f, 36.0f, 12.0f);
                instancePath.lineTo(36.0f, 21.0f);
                instancePath.lineTo(44.997383f, 21.0f);
                instancePath.cubicTo(46.65568f, 21.0f, 48.0f, 22.342468f, 48.0f, 23.995506f);
                instancePath.lineTo(48.0f, 57.004494f);
                instancePath.cubicTo(48.0f, 58.658867f, 46.666107f, 60.0f, 44.997383f, 60.0f);
                instancePath.lineTo(3.002615f, 60.0f);
                instancePath.cubicTo(1.3443165f, 60.0f, 0.0f, 58.65753f, 0.0f, 57.004494f);
                instancePath.lineTo(0.0f, 23.995506f);
                instancePath.cubicTo(0.0f, 22.341135f, 1.3338926f, 21.0f, 3.002615f, 21.0f);
                instancePath.lineTo(12.0f, 21.0f);
                instancePath.close();
                instancePath.moveTo(15.6f, 21.0f);
                instancePath.lineTo(32.399998f, 21.0f);
                instancePath.lineTo(32.399998f, 12.0f);
                instancePath.cubicTo(32.39999f, 7.360799f, 28.639183f, 3.5999908f, 23.99999f, 3.5999908f);
                instancePath.cubicTo(19.3608f, 3.5999908f, 15.599991f, 7.360799f, 15.599991f, 11.99999f);
                instancePath.lineTo(15.6f, 21.0f);
                instancePath.close();
                instancePath.moveTo(3.6f, 24.6f);
                instancePath.lineTo(3.6f, 56.4f);
                instancePath.lineTo(44.4f, 56.4f);
                instancePath.lineTo(44.4f, 24.6f);
                instancePath.lineTo(3.6f, 24.6f);
                instancePath.close();
                instancePath.moveTo(22.199999f, 41.62556f);
                instancePath.cubicTo(20.610685f, 40.93116f, 19.5f, 39.345287f, 19.5f, 37.5f);
                instancePath.cubicTo(19.5f, 35.014717f, 21.514719f, 33.0f, 24.0f, 33.0f);
                instancePath.cubicTo(26.485281f, 33.0f, 28.5f, 35.014717f, 28.5f, 37.5f);
                instancePath.cubicTo(28.5f, 39.345287f, 27.389315f, 40.93116f, 25.8f, 41.62556f);
                instancePath.lineTo(25.8f, 48.0f);
                instancePath.lineTo(22.199999f, 48.0f);
                instancePath.lineTo(22.199999f, 41.62556f);
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
