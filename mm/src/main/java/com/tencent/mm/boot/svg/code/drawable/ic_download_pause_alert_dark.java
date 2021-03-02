package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ic_download_pause_alert_dark extends c {
    private final int height = 64;
    private final int width = 64;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 64;
            case 1:
                return 64;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -148.0f, 0.0f, 1.0f, -486.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 446.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, -1.0f, -1.2246469E-16f, 212.0f, 1.2246469E-16f, -1.0f, 104.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(64.0f, 0.0f);
                instancePath.lineTo(64.0f, 64.0f);
                instancePath.lineTo(0.0f, 64.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, -1.0f, 0.0f, 56.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(436207615);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.0f, 0.0f);
                instancePath2.cubicTo(37.254833f, 0.0f, 48.0f, 10.745166f, 48.0f, 24.0f);
                instancePath2.cubicTo(48.0f, 37.254833f, 37.254833f, 48.0f, 24.0f, 48.0f);
                instancePath2.cubicTo(10.745166f, 48.0f, 0.0f, 37.254833f, 0.0f, 24.0f);
                instancePath2.cubicTo(0.0f, 10.745166f, 10.745166f, 0.0f, 24.0f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(24.0f, 4.0f);
                instancePath2.cubicTo(12.954305f, 4.0f, 4.0f, 12.954305f, 4.0f, 24.0f);
                instancePath2.cubicTo(4.0f, 35.045696f, 12.954305f, 44.0f, 24.0f, 44.0f);
                instancePath2.cubicTo(35.045696f, 44.0f, 44.0f, 35.045696f, 44.0f, 24.0f);
                instancePath2.cubicTo(44.0f, 12.954305f, 35.045696f, 4.0f, 24.0f, 4.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-2130706433);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(46.0f, 22.0f);
                instancePath3.cubicTo(47.10457f, 22.0f, 48.0f, 22.89543f, 48.0f, 24.0f);
                instancePath3.lineTo(48.0f, 24.0f);
                instancePath3.lineTo(48.0f, 24.0f);
                instancePath3.cubicTo(48.0f, 37.2217f, 37.308495f, 47.94626f, 24.099363f, 47.999798f);
                instancePath3.lineTo(24.025f, 47.999f);
                instancePath3.lineTo(24.0f, 48.0f);
                instancePath3.cubicTo(22.945639f, 48.0f, 22.081835f, 47.184124f, 22.005486f, 46.14926f);
                instancePath3.lineTo(22.0f, 46.0f);
                instancePath3.cubicTo(22.0f, 44.89543f, 22.89543f, 44.0f, 24.0f, 44.0f);
                instancePath3.lineTo(24.0f, 44.0f);
                instancePath3.cubicTo(35.045696f, 44.0f, 44.0f, 35.045696f, 44.0f, 24.0f);
                instancePath3.lineTo(44.0f, 23.999f);
                instancePath3.lineTo(44.005486f, 23.850739f);
                instancePath3.cubicTo(44.078197f, 22.865156f, 44.865158f, 22.0782f, 45.85074f, 22.005486f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-2130706433);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(28.0f, 24.0f);
                instancePath4.lineTo(28.0f, 40.0f);
                instancePath4.lineTo(24.0f, 40.0f);
                instancePath4.lineTo(24.0f, 24.0f);
                instancePath4.lineTo(28.0f, 24.0f);
                instancePath4.close();
                instancePath4.moveTo(40.0f, 24.0f);
                instancePath4.lineTo(40.0f, 40.0f);
                instancePath4.lineTo(36.0f, 40.0f);
                instancePath4.lineTo(36.0f, 24.0f);
                instancePath4.lineTo(40.0f, 24.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint6);
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
