package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class c2c_remittance_received_icon extends c {
    private final int height = 30;
    private final int width = 30;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -2.0f, 0.0f, 1.0f, -2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(17.0f, 2.8333333f);
                instancePath.cubicTo(24.824034f, 2.8333333f, 31.166666f, 9.175966f, 31.166666f, 17.0f);
                instancePath.cubicTo(31.166666f, 24.824034f, 24.824034f, 31.166666f, 17.0f, 31.166666f);
                instancePath.cubicTo(9.175966f, 31.166666f, 2.8333333f, 24.824034f, 2.8333333f, 17.0f);
                instancePath.cubicTo(2.8333333f, 9.175966f, 9.175966f, 2.8333333f, 17.0f, 2.8333333f);
                instancePath.close();
                instancePath.moveTo(17.0f, 4.5333333f);
                instancePath.cubicTo(10.11485f, 4.5333333f, 4.5333333f, 10.11485f, 4.5333333f, 17.0f);
                instancePath.cubicTo(4.5333333f, 23.885149f, 10.11485f, 29.466667f, 17.0f, 29.466667f);
                instancePath.cubicTo(23.885149f, 29.466667f, 29.466667f, 23.885149f, 29.466667f, 17.0f);
                instancePath.cubicTo(29.466667f, 10.11485f, 23.885149f, 4.5333333f, 17.0f, 4.5333333f);
                instancePath.close();
                instancePath.moveTo(23.568733f, 12.395833f);
                instancePath.lineTo(24.770815f, 13.597915f);
                instancePath.lineTo(16.342007f, 22.026724f);
                instancePath.cubicTo(15.788764f, 22.579967f, 14.89178f, 22.579967f, 14.338537f, 22.026724f);
                instancePath.lineTo(9.916667f, 17.604853f);
                instancePath.lineTo(11.118749f, 16.402771f);
                instancePath.lineTo(15.340272f, 20.624296f);
                instancePath.lineTo(23.568733f, 12.395833f);
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
