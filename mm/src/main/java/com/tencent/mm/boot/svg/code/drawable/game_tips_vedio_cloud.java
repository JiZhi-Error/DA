package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class game_tips_vedio_cloud extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -60.0f, 0.0f, 1.0f, -459.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 32.0f, 0.0f, 1.0f, 334.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 28.0f, 0.0f, 1.0f, 125.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.287003f, 6.369852f);
                instancePath.lineTo(7.7272077f, 10.9296465f);
                instancePath.lineTo(5.6058874f, 8.808326f);
                instancePath.lineTo(4.7573595f, 9.656855f);
                instancePath.lineTo(7.5857863f, 12.485281f);
                instancePath.lineTo(7.7272077f, 12.626702f);
                instancePath.lineTo(12.76821f, 7.5857f);
                instancePath.cubicTo(12.808246f, 7.584128f, 12.848477f, 7.5833335f, 12.888889f, 7.5833335f);
                instancePath.cubicTo(14.607108f, 7.5833335f, 16.0f, 9.019753f, 16.0f, 10.791667f);
                instancePath.cubicTo(16.0f, 12.5635805f, 14.607108f, 14.0f, 12.888889f, 14.0f);
                instancePath.lineTo(3.5555556f, 14.0f);
                instancePath.cubicTo(1.5918765f, 14.0f, 0.0f, 12.358377f, 0.0f, 10.333333f);
                instancePath.cubicTo(0.0f, 8.30829f, 1.5918765f, 6.6666665f, 3.5555556f, 6.6666665f);
                instancePath.cubicTo(3.5852034f, 6.6666665f, 3.6147664f, 6.667041f, 3.6442406f, 6.667785f);
                instancePath.cubicTo(4.0556173f, 4.5751743f, 5.849432f, 3.0f, 8.0f, 3.0f);
                instancePath.cubicTo(10.047238f, 3.0f, 11.771183f, 4.4274445f, 12.287003f, 6.369852f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 0.0f);
                instancePath2.lineTo(16.0f, 0.0f);
                instancePath2.lineTo(16.0f, 16.0f);
                instancePath2.lineTo(0.0f, 16.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.close();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
