package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class card_mm_title_btn_menu extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 43.0f, 0.0f, 1.0f, 20.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.0f, 10.0f);
                instancePath.cubicTo(7.7614236f, 10.0f, 10.0f, 7.7614236f, 10.0f, 5.0f);
                instancePath.cubicTo(10.0f, 2.2385762f, 7.7614236f, 0.0f, 5.0f, 0.0f);
                instancePath.cubicTo(2.2385762f, 0.0f, 0.0f, 2.2385762f, 0.0f, 5.0f);
                instancePath.cubicTo(0.0f, 7.7614236f, 2.2385762f, 10.0f, 5.0f, 10.0f);
                instancePath.close();
                instancePath.moveTo(5.0f, 33.0f);
                instancePath.cubicTo(7.7614236f, 33.0f, 10.0f, 30.761423f, 10.0f, 28.0f);
                instancePath.cubicTo(10.0f, 25.238577f, 7.7614236f, 23.0f, 5.0f, 23.0f);
                instancePath.cubicTo(2.2385762f, 23.0f, 0.0f, 25.238577f, 0.0f, 28.0f);
                instancePath.cubicTo(0.0f, 30.761423f, 2.2385762f, 33.0f, 5.0f, 33.0f);
                instancePath.close();
                instancePath.moveTo(5.0f, 56.0f);
                instancePath.cubicTo(7.7614236f, 56.0f, 10.0f, 53.761425f, 10.0f, 51.0f);
                instancePath.cubicTo(10.0f, 48.238575f, 7.7614236f, 46.0f, 5.0f, 46.0f);
                instancePath.cubicTo(2.2385762f, 46.0f, 0.0f, 48.238575f, 0.0f, 51.0f);
                instancePath.cubicTo(0.0f, 53.761425f, 2.2385762f, 56.0f, 5.0f, 56.0f);
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
