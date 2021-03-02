package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class search_biz_contact_btn_press extends c {
    private final int height = 78;
    private final int width = 78;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 78;
            case 1:
                return 78;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -326.0f, 0.0f, 1.0f, -362.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 98.0f, 0.0f, 1.0f, 362.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 228.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-11184811);
                instancePaint4.setStrokeWidth(3.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(28.72093f, 39.7907f);
                instancePath.cubicTo(33.18872f, 47.180103f, 26.14078f, 50.233418f, 22.39535f, 52.44186f);
                instancePath.cubicTo(10.53354f, 59.134026f, 5.0f, 61.832302f, 5.0f, 65.093025f);
                instancePath.lineTo(5.0f, 69.83721f);
                instancePath.cubicTo(5.0f, 71.6663f, 6.1515117f, 73.0f, 8.16279f, 73.0f);
                instancePath.lineTo(69.83721f, 73.0f);
                instancePath.cubicTo(71.84849f, 73.0f, 73.0f, 71.6663f, 73.0f, 69.83721f);
                instancePath.lineTo(73.0f, 65.093025f);
                instancePath.cubicTo(73.0f, 61.832302f, 67.46646f, 59.134026f, 55.604652f, 52.44186f);
                instancePath.cubicTo(51.859222f, 50.233418f, 44.81128f, 47.180103f, 49.279068f, 39.7907f);
                instancePath.cubicTo(52.82625f, 34.83821f, 55.76787f, 32.557747f, 55.604652f, 23.976744f);
                instancePath.cubicTo(55.76787f, 14.310931f, 49.19635f, 5.0f, 39.7907f, 5.0f);
                instancePath.cubicTo(28.803648f, 5.0f, 22.232128f, 14.310931f, 22.39535f, 23.976744f);
                instancePath.cubicTo(22.232128f, 32.557747f, 25.173754f, 34.83821f, 28.72093f, 39.7907f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-11184811);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(33.032784f, 62.02452f);
                instancePath2.cubicTo(32.495216f, 63.592533f, 33.032784f, 65.79082f, 34.231796f, 66.93293f);
                instancePath2.lineTo(37.862457f, 70.39129f);
                instancePath2.cubicTo(38.465904f, 70.9661f, 39.44163f, 70.9806f, 40.061115f, 70.40576f);
                instancePath2.lineTo(43.83273f, 66.90594f);
                instancePath2.cubicTo(45.048244f, 65.778015f, 45.590824f, 63.605457f, 45.03445f, 62.02452f);
                instancePath2.lineTo(38.955097f, 44.75f);
                instancePath2.lineTo(33.032784f, 62.02452f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
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
