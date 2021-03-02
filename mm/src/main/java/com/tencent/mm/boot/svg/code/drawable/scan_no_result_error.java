package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class scan_no_result_error extends c {
    private final int height = 40;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -188.0f, 0.0f, 1.0f, -375.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 188.0f, 0.0f, 1.0f, 375.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-352965);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.0f, 40.0f);
                instancePath.cubicTo(8.954305f, 40.0f, 0.0f, 31.045694f, 0.0f, 20.0f);
                instancePath.cubicTo(0.0f, 8.954305f, 8.954305f, 0.0f, 20.0f, 0.0f);
                instancePath.cubicTo(31.045694f, 0.0f, 40.0f, 8.954305f, 40.0f, 20.0f);
                instancePath.cubicTo(40.0f, 31.045694f, 31.045694f, 40.0f, 20.0f, 40.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(19.669922f, 27.944336f);
                instancePath2.cubicTo(20.62207f, 27.944336f, 21.339844f, 28.66211f, 21.339844f, 29.614258f);
                instancePath2.cubicTo(21.339844f, 30.551758f, 20.62207f, 31.28418f, 19.669922f, 31.28418f);
                instancePath2.cubicTo(18.732422f, 31.28418f, 18.0f, 30.551758f, 18.0f, 29.614258f);
                instancePath2.cubicTo(18.0f, 28.66211f, 18.732422f, 27.944336f, 19.669922f, 27.944336f);
                instancePath2.close();
                instancePath2.moveTo(20.988281f, 10.0f);
                instancePath2.lineTo(20.8125f, 24.121094f);
                instancePath2.lineTo(18.527344f, 24.121094f);
                instancePath2.lineTo(18.351562f, 10.0f);
                instancePath2.lineTo(20.988281f, 10.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
