package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_sending extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.485281f, 12.0f);
                instancePath.lineTo(24.0f, 12.0f);
                instancePath.lineTo(24.0f, 18.0f);
                instancePath.lineTo(11.485281f, 18.0f);
                instancePath.lineTo(16.970562f, 23.485281f);
                instancePath.lineTo(12.727922f, 27.727922f);
                instancePath.lineTo(4.2426405f, 19.242641f);
                instancePath.lineTo(1.0606601f, 16.06066f);
                instancePath.cubicTo(0.47487372f, 15.474874f, 0.47487372f, 14.525126f, 1.0606601f, 13.93934f);
                instancePath.lineTo(12.727922f, 2.272078f);
                instancePath.lineTo(16.970562f, 6.5147185f);
                instancePath.lineTo(11.485281f, 12.0f);
                instancePath.close();
                instancePath.moveTo(27.0f, 12.0f);
                instancePath.lineTo(33.0f, 12.0f);
                instancePath.lineTo(33.0f, 18.0f);
                instancePath.lineTo(27.0f, 18.0f);
                instancePath.lineTo(27.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 12.0f);
                instancePath.lineTo(42.0f, 12.0f);
                instancePath.lineTo(42.0f, 18.0f);
                instancePath.lineTo(36.0f, 18.0f);
                instancePath.lineTo(36.0f, 12.0f);
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
