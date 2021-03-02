package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_history_card_empty extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePaint3.setColor(-2565928);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(32.0f, 0.0f);
                instancePath.lineTo(32.0f, 32.0f);
                instancePath.lineTo(0.0f, 32.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint3, looper));
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.333333f, 0.0f, 1.0f, 2.666667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(20.0f, 0.0f);
                instancePath2.cubicTo(20.73638f, 0.0f, 21.333334f, 0.5969537f, 21.333334f, 1.3333334f);
                instancePath2.lineTo(21.333334f, 25.333334f);
                instancePath2.cubicTo(21.333334f, 26.069714f, 20.73638f, 26.666666f, 20.0f, 26.666666f);
                instancePath2.lineTo(1.3333334f, 26.666666f);
                instancePath2.cubicTo(0.5969537f, 26.666666f, 0.0f, 26.069714f, 0.0f, 25.333334f);
                instancePath2.lineTo(0.0f, 1.3333334f);
                instancePath2.cubicTo(0.0f, 0.5969537f, 0.5969537f, 0.0f, 1.3333334f, 0.0f);
                instancePath2.lineTo(20.0f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(19.333334f, 2.0f);
                instancePath2.lineTo(2.0f, 2.0f);
                instancePath2.lineTo(2.0f, 24.666666f);
                instancePath2.lineTo(19.333334f, 24.666666f);
                instancePath2.lineTo(19.333334f, 2.0f);
                instancePath2.close();
                instancePath2.moveTo(9.333333f, 14.666667f);
                instancePath2.lineTo(9.333333f, 16.666666f);
                instancePath2.lineTo(4.0f, 16.666666f);
                instancePath2.lineTo(4.0f, 14.666667f);
                instancePath2.lineTo(9.333333f, 14.666667f);
                instancePath2.close();
                instancePath2.moveTo(14.666667f, 10.0f);
                instancePath2.lineTo(14.666667f, 12.0f);
                instancePath2.lineTo(4.0f, 12.0f);
                instancePath2.lineTo(4.0f, 10.0f);
                instancePath2.lineTo(14.666667f, 10.0f);
                instancePath2.close();
                instancePath2.moveTo(14.666667f, 5.3333335f);
                instancePath2.lineTo(14.666667f, 7.3333335f);
                instancePath2.lineTo(4.0f, 7.3333335f);
                instancePath2.lineTo(4.0f, 5.3333335f);
                instancePath2.lineTo(14.666667f, 5.3333335f);
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
