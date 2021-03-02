package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class video_preview_info extends c {
    private final int height = 16;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
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
                instancePaint3.setColor(-2130706433);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -149.0f, 0.0f, 1.0f, -698.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 654.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 73.0f, 0.0f, 1.0f, 28.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 1.0f, 0.0f, 60.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray6 = c.setMatrixFloatArray(matrixFloatArray5, 1.0f, 0.0f, 1.333333f, 0.0f, 1.0f, 1.333333f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray6);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(6.6666665f, 0.0f);
                instancePath.cubicTo(10.348565f, 0.0f, 13.333333f, 2.9847684f, 13.333333f, 6.6666665f);
                instancePath.cubicTo(13.333333f, 10.348565f, 10.348565f, 13.333333f, 6.6666665f, 13.333333f);
                instancePath.cubicTo(2.9847684f, 13.333333f, 0.0f, 10.348565f, 0.0f, 6.6666665f);
                instancePath.cubicTo(0.0f, 2.9847684f, 2.9847684f, 0.0f, 6.6666665f, 0.0f);
                instancePath.close();
                instancePath.moveTo(6.6666665f, 0.8f);
                instancePath.cubicTo(3.4265962f, 0.8f, 0.8f, 3.4265962f, 0.8f, 6.6666665f);
                instancePath.cubicTo(0.8f, 9.906737f, 3.4265962f, 12.533333f, 6.6666665f, 12.533333f);
                instancePath.cubicTo(9.906737f, 12.533333f, 12.533333f, 9.906737f, 12.533333f, 6.6666665f);
                instancePath.cubicTo(12.533333f, 3.4265962f, 9.906737f, 0.8f, 6.6666665f, 0.8f);
                instancePath.close();
                instancePath.moveTo(7.0666666f, 5.3333335f);
                instancePath.lineTo(7.0666666f, 10.0f);
                instancePath.lineTo(6.2666664f, 10.0f);
                instancePath.lineTo(6.2666664f, 5.3333335f);
                instancePath.lineTo(7.0666666f, 5.3333335f);
                instancePath.close();
                instancePath.moveTo(6.6666665f, 3.3333333f);
                instancePath.cubicTo(7.0348563f, 3.3333333f, 7.3333335f, 3.6318102f, 7.3333335f, 4.0f);
                instancePath.cubicTo(7.3333335f, 4.36819f, 7.0348563f, 4.6666665f, 6.6666665f, 4.6666665f);
                instancePath.cubicTo(6.2984767f, 4.6666665f, 6.0f, 4.36819f, 6.0f, 4.0f);
                instancePath.cubicTo(6.0f, 3.6318102f, 6.2984767f, 3.3333333f, 6.6666665f, 3.3333333f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
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
