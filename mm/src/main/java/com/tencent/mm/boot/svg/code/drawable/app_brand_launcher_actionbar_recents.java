package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_launcher_actionbar_recents extends c {
    private final int height = 58;
    private final int width = 58;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 58;
            case 1:
                return 58;
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -58.0f, 0.0f, 1.0f, -148.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 148.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(29.0f, 58.0f);
                instancePath.cubicTo(45.01626f, 58.0f, 58.0f, 45.01626f, 58.0f, 29.0f);
                instancePath.cubicTo(58.0f, 12.983743f, 45.01626f, 0.0f, 29.0f, 0.0f);
                instancePath.cubicTo(12.983743f, 0.0f, 0.0f, 12.983743f, 0.0f, 29.0f);
                instancePath.cubicTo(0.0f, 45.01626f, 12.983743f, 58.0f, 29.0f, 58.0f);
                instancePath.close();
                instancePath.moveTo(29.0f, 52.0f);
                instancePath.cubicTo(41.70255f, 52.0f, 52.0f, 41.70255f, 52.0f, 29.0f);
                instancePath.cubicTo(52.0f, 16.297451f, 41.70255f, 6.0f, 29.0f, 6.0f);
                instancePath.cubicTo(16.297451f, 6.0f, 6.0f, 16.297451f, 6.0f, 29.0f);
                instancePath.cubicTo(6.0f, 41.70255f, 16.297451f, 52.0f, 29.0f, 52.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(29.974895f, 27.246653f);
                instancePath2.lineTo(29.217737f, 14.251846f);
                instancePath2.cubicTo(29.19401f, 13.844625f, 28.835377f, 13.5f, 28.417751f, 13.5f);
                instancePath2.lineTo(27.1628f, 13.5f);
                instancePath2.cubicTo(26.745947f, 13.5f, 26.387007f, 13.836613f, 26.362814f, 14.251846f);
                instancePath2.lineTo(25.53224f, 28.506634f);
                instancePath2.cubicTo(25.501184f, 29.039612f, 25.755342f, 29.50647f, 26.163542f, 29.770678f);
                instancePath2.cubicTo(26.252584f, 30.036236f, 26.42348f, 30.280165f, 26.672367f, 30.466492f);
                instancePath2.lineTo(39.0047f, 39.69901f);
                instancePath2.cubicTo(39.340405f, 39.950333f, 39.827724f, 39.897633f, 40.089073f, 39.58617f);
                instancePath2.lineTo(40.949707f, 38.56051f);
                instancePath2.cubicTo(41.212883f, 38.24687f, 41.180317f, 37.76185f, 40.872528f, 37.47302f);
                instancePath2.lineTo(29.974895f, 27.246653f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
