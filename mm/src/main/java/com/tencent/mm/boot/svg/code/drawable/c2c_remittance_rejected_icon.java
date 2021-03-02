package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class c2c_remittance_rejected_icon extends c {
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
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.70710677f, 0.70710677f, -7.4062233f, -0.70710677f, 0.70710677f, 16.220474f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(20.126734f, 12.80034f);
                instancePath2.lineTo(20.126734f, 14.5003395f);
                instancePath2.lineTo(13.326735f, 14.5003395f);
                instancePath2.lineTo(13.326735f, 21.30034f);
                instancePath2.lineTo(11.626735f, 21.30034f);
                instancePath2.lineTo(11.626735f, 14.217007f);
                instancePath2.cubicTo(11.626735f, 13.434603f, 12.260998f, 12.80034f, 13.043402f, 12.80034f);
                instancePath2.lineTo(20.126734f, 12.80034f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(11.333333f, 16.15f);
                instancePath3.lineTo(24.083332f, 16.15f);
                instancePath3.lineTo(24.083332f, 17.85f);
                instancePath3.lineTo(11.333333f, 17.85f);
                instancePath3.lineTo(11.333333f, 16.15f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
