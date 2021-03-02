package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_min_window extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.70710677f, -0.70710677f, 11.857233f, 0.70710677f, 0.70710677f, -5.4972134f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(13.271446f, 13.528806f);
                instancePath2.lineTo(16.80698f, 17.06434f);
                instancePath2.lineTo(15.746321f, 18.125f);
                instancePath2.lineTo(13.313699f, 15.69234f);
                instancePath2.lineTo(13.31434f, 22.56434f);
                instancePath2.lineTo(11.81434f, 22.56434f);
                instancePath2.lineTo(11.813699f, 15.69234f);
                instancePath2.lineTo(9.3823595f, 18.125f);
                instancePath2.lineTo(8.321699f, 17.06434f);
                instancePath2.lineTo(11.857233f, 13.528806f);
                instancePath2.cubicTo(12.247757f, 13.138282f, 12.880922f, 13.138282f, 13.271446f, 13.528806f);
                instancePath2.close();
                instancePath2.moveTo(13.31434f, 0.5643398f);
                instancePath2.lineTo(13.313699f, 7.43434f);
                instancePath2.lineTo(15.746321f, 5.0036798f);
                instancePath2.lineTo(16.80698f, 6.0643396f);
                instancePath2.lineTo(13.271446f, 9.599874f);
                instancePath2.cubicTo(12.880922f, 9.990398f, 12.247757f, 9.990398f, 11.857233f, 9.599874f);
                instancePath2.lineTo(11.857233f, 9.599874f);
                instancePath2.lineTo(8.321699f, 6.0643396f);
                instancePath2.lineTo(9.3823595f, 5.0036798f);
                instancePath2.lineTo(11.813699f, 7.43634f);
                instancePath2.lineTo(11.81434f, 0.5643398f);
                instancePath2.lineTo(13.31434f, 0.5643398f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
