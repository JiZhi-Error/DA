package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class kinda_kinda_checkbox_selected extends c {
    private final int height = 26;
    private final int width = 26;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 26;
            case 1:
                return 26;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.0f, 12.148149f);
                instancePath.cubicTo(24.0f, 18.627556f, 18.627556f, 24.0f, 11.851851f, 24.0f);
                instancePath.cubicTo(5.3724446f, 24.0f, 0.0f, 18.627556f, 0.0f, 12.148149f);
                instancePath.cubicTo(0.0f, 5.3724446f, 5.3724446f, 0.0f, 11.851851f, 0.0f);
                instancePath.cubicTo(18.627556f, 0.0f, 24.0f, 5.3724446f, 24.0f, 12.148149f);
                instancePath.close();
                instancePath.moveTo(10.363961f, 15.313708f);
                instancePath.lineTo(7.0606604f, 12.010407f);
                instancePath.lineTo(6.0f, 13.071068f);
                instancePath.lineTo(9.656855f, 16.727922f);
                instancePath.cubicTo(10.047379f, 17.118446f, 10.680544f, 17.118446f, 11.071068f, 16.727922f);
                instancePath.lineTo(18.738329f, 9.06066f);
                instancePath.lineTo(17.67767f, 8.0f);
                instancePath.lineTo(10.363961f, 15.313708f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
