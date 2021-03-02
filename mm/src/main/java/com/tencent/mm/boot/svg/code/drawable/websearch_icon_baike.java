package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class websearch_icon_baike extends c {
    private final int height = 16;
    private final int width = 12;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 12;
            case 1:
                return 16;
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
                instancePaint3.setColor(-5066062);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -138.0f, 0.0f, 1.0f, -671.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 69.0f, 0.0f, 1.0f, 68.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(6.15f, 2.4f);
                instancePath.lineTo(6.15f, 13.35697f);
                instancePath.lineTo(13.5f, 13.35697f);
                instancePath.cubicTo(13.83137f, 13.35697f, 14.1f, 13.088341f, 14.1f, 12.756969f);
                instancePath.lineTo(14.1f, 11.400009f);
                instancePath.lineTo(14.1f, 3.0f);
                instancePath.cubicTo(14.1f, 2.6686292f, 13.83137f, 2.4f, 13.5f, 2.4f);
                instancePath.lineTo(6.15f, 2.4f);
                instancePath.close();
                instancePath.moveTo(5.25f, 2.4f);
                instancePath.lineTo(3.9f, 2.4f);
                instancePath.lineTo(3.9f, 13.35697f);
                instancePath.lineTo(5.25f, 13.35697f);
                instancePath.lineTo(5.25f, 2.4f);
                instancePath.close();
                instancePath.moveTo(14.1f, 14.132156f);
                instancePath.cubicTo(13.916262f, 14.212435f, 13.713331f, 14.256969f, 13.5f, 14.256969f);
                instancePath.lineTo(3.9f, 14.256969f);
                instancePath.lineTo(3.9f, 15.6f);
                instancePath.lineTo(13.5f, 15.6f);
                instancePath.cubicTo(13.83137f, 15.6f, 14.1f, 15.33137f, 14.1f, 15.0f);
                instancePath.lineTo(14.1f, 14.132156f);
                instancePath.close();
                instancePath.moveTo(3.0f, 1.5f);
                instancePath.lineTo(13.5f, 1.5f);
                instancePath.cubicTo(14.328427f, 1.5f, 15.0f, 2.171573f, 15.0f, 3.0f);
                instancePath.lineTo(15.0f, 15.0f);
                instancePath.cubicTo(15.0f, 15.828427f, 14.328427f, 16.5f, 13.5f, 16.5f);
                instancePath.lineTo(3.0f, 16.5f);
                instancePath.lineTo(3.0f, 1.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
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
