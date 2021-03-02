package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_servicebrand_contact extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePaint3.setColor(-14187817);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                instancePath.lineTo(108.0f, 0.0f);
                instancePath.cubicTo(114.62742f, 0.0f, 120.0f, 5.3725824f, 120.0f, 12.0f);
                instancePath.lineTo(120.0f, 108.0f);
                instancePath.cubicTo(120.0f, 114.62742f, 114.62742f, 120.0f, 108.0f, 120.0f);
                instancePath.lineTo(12.0f, 120.0f);
                instancePath.cubicTo(5.3725824f, 120.0f, 0.0f, 114.62742f, 0.0f, 108.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(7.5f, 60.0f);
                instancePath2.lineTo(7.5f, 57.94639f);
                instancePath2.cubicTo(7.5f, 55.891125f, 8.994452f, 53.495724f, 10.842293f, 52.593998f);
                instancePath2.lineTo(27.823353f, 44.30743f);
                instancePath2.cubicTo(30.28613f, 43.10562f, 30.858778f, 40.443787f, 29.080336f, 38.33592f);
                instancePath2.lineTo(27.995739f, 37.050415f);
                instancePath2.cubicTo(25.788954f, 34.434856f, 24.0f, 29.548489f, 24.0f, 26.127872f);
                instancePath2.lineTo(24.0f, 20.998741f);
                instancePath2.cubicTo(24.0f, 14.37202f, 29.386068f, 9.0f, 36.0f, 9.0f);
                instancePath2.cubicTo(42.62742f, 9.0f, 48.0f, 14.378941f, 48.0f, 21.000622f);
                instancePath2.lineTo(48.0f, 26.130558f);
                instancePath2.cubicTo(48.0f, 29.547888f, 46.202797f, 34.44858f, 44.00426f, 37.054718f);
                instancePath2.lineTo(42.919662f, 38.340397f);
                instancePath2.cubicTo(41.151096f, 40.43685f, 41.703564f, 43.105194f, 44.176647f, 44.31153f);
                instancePath2.lineTo(61.157707f, 52.594673f);
                instancePath2.cubicTo(63.003605f, 53.49508f, 64.5f, 55.87551f, 64.5f, 57.94639f);
                instancePath2.lineTo(64.5f, 60.0f);
                instancePath2.cubicTo(64.5f, 61.656853f, 63.156853f, 63.0f, 61.5f, 63.0f);
                instancePath2.lineTo(10.5f, 63.0f);
                instancePath2.cubicTo(8.843145f, 63.0f, 7.5f, 61.656853f, 7.5f, 60.0f);
                instancePath2.close();
                instancePath2.moveTo(33.0f, 54.0f);
                instancePath2.lineTo(36.0f, 57.0f);
                instancePath2.lineTo(39.0f, 54.0f);
                instancePath2.lineTo(36.0f, 45.0f);
                instancePath2.lineTo(33.0f, 54.0f);
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
