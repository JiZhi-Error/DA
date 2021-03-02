package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_dyeing_template_more_icon extends c {
    private final int height = 56;
    private final int width = 10;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 10;
            case 1:
                return 56;
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
                instancePaint3.setColor(-3684404);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -273.0f, 0.0f, 1.0f, -165.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(278.0f, 175.0f);
                instancePath.cubicTo(280.7614f, 175.0f, 283.0f, 172.76143f, 283.0f, 170.0f);
                instancePath.cubicTo(283.0f, 167.23857f, 280.7614f, 165.0f, 278.0f, 165.0f);
                instancePath.cubicTo(275.2386f, 165.0f, 273.0f, 167.23857f, 273.0f, 170.0f);
                instancePath.cubicTo(273.0f, 172.76143f, 275.2386f, 175.0f, 278.0f, 175.0f);
                instancePath.close();
                instancePath.moveTo(278.0f, 198.0f);
                instancePath.cubicTo(280.7614f, 198.0f, 283.0f, 195.76143f, 283.0f, 193.0f);
                instancePath.cubicTo(283.0f, 190.23857f, 280.7614f, 188.0f, 278.0f, 188.0f);
                instancePath.cubicTo(275.2386f, 188.0f, 273.0f, 190.23857f, 273.0f, 193.0f);
                instancePath.cubicTo(273.0f, 195.76143f, 275.2386f, 198.0f, 278.0f, 198.0f);
                instancePath.close();
                instancePath.moveTo(278.0f, 221.0f);
                instancePath.cubicTo(280.7614f, 221.0f, 283.0f, 218.76143f, 283.0f, 216.0f);
                instancePath.cubicTo(283.0f, 213.23857f, 280.7614f, 211.0f, 278.0f, 211.0f);
                instancePath.cubicTo(275.2386f, 211.0f, 273.0f, 213.23857f, 273.0f, 216.0f);
                instancePath.cubicTo(273.0f, 218.76143f, 275.2386f, 221.0f, 278.0f, 221.0f);
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
