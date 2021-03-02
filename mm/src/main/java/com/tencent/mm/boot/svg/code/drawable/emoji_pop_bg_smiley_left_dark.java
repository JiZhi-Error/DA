package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class emoji_pop_bg_smiley_left_dark extends c {
    private final int height = 405;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 405;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-13882324);
                instancePaint5.setColor(218103807);
                instancePaint5.setStrokeWidth(1.5f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -1.0f, 0.0f, 192.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(191.25f, 381.0f);
                instancePath.lineTo(191.25f, 48.0f);
                instancePath.cubicTo(191.25f, 21.904545f, 170.09546f, 0.75f, 144.0f, 0.75f);
                instancePath.lineTo(48.0f, 0.75f);
                instancePath.cubicTo(21.904545f, 0.75f, 0.75f, 21.904545f, 0.75f, 48.0f);
                instancePath.lineTo(0.75f, 180.0f);
                instancePath.cubicTo(0.75f, 194.87228f, 7.752174f, 208.87663f, 19.65f, 217.8f);
                instancePath.lineTo(53.25f, 243.0f);
                instancePath.cubicTo(65.525536f, 252.20665f, 72.75f, 266.65558f, 72.75f, 282.0f);
                instancePath.lineTo(72.75f, 381.0f);
                instancePath.cubicTo(72.75f, 393.8406f, 83.15938f, 404.25f, 96.0f, 404.25f);
                instancePath.lineTo(168.0f, 404.25f);
                instancePath.cubicTo(180.84062f, 404.25f, 191.25f, 393.8406f, 191.25f, 381.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
