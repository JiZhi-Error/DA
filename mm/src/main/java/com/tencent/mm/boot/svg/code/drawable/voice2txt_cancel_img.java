package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class voice2txt_cancel_img extends c {
    private final int height = 80;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 13.333333f, 0.0f, 1.0f, 10.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.952621f, 20.0f);
                instancePath.lineTo(28.047379f, 26.094757f);
                instancePath.lineTo(23.333334f, 30.808802f);
                instancePath.lineTo(11.548221f, 19.02369f);
                instancePath.cubicTo(10.246472f, 17.721941f, 10.246472f, 15.611392f, 11.548221f, 14.309644f);
                instancePath.lineTo(23.333334f, 2.5245311f);
                instancePath.lineTo(28.047379f, 7.2385764f);
                instancePath.lineTo(21.952621f, 13.333333f);
                instancePath.lineTo(36.666668f, 13.333333f);
                instancePath.cubicTo(47.71236f, 13.333333f, 56.666668f, 22.287638f, 56.666668f, 33.333332f);
                instancePath.cubicTo(56.666668f, 44.37903f, 47.71236f, 53.333332f, 36.666668f, 53.333332f);
                instancePath.lineTo(0.0f, 53.333332f);
                instancePath.lineTo(0.0f, 46.666668f);
                instancePath.lineTo(36.666668f, 46.666668f);
                instancePath.cubicTo(44.030464f, 46.666668f, 50.0f, 40.69713f, 50.0f, 33.333332f);
                instancePath.cubicTo(50.0f, 25.969536f, 44.030464f, 20.0f, 36.666668f, 20.0f);
                instancePath.lineTo(21.952621f, 20.0f);
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
