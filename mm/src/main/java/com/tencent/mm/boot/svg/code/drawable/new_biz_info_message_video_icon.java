package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class new_biz_info_message_video_icon extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -166.0f, 0.0f, 1.0f, -265.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 166.0f, 0.0f, 1.0f, 265.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(838860800);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(45.0f, 0.0f);
                instancePath.cubicTo(69.85281f, 0.0f, 90.0f, 20.147184f, 90.0f, 45.0f);
                instancePath.cubicTo(90.0f, 69.85281f, 69.85281f, 90.0f, 45.0f, 90.0f);
                instancePath.cubicTo(20.147184f, 90.0f, 0.0f, 69.85281f, 0.0f, 45.0f);
                instancePath.cubicTo(0.0f, 20.147184f, 20.147184f, 0.0f, 45.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-1);
                instancePaint6.setStrokeWidth(6.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(45.0f, 3.0f);
                instancePath2.cubicTo(68.19596f, 3.0f, 87.0f, 21.804039f, 87.0f, 45.0f);
                instancePath2.cubicTo(87.0f, 68.19596f, 68.19596f, 87.0f, 45.0f, 87.0f);
                instancePath2.cubicTo(21.804039f, 87.0f, 3.0f, 68.19596f, 3.0f, 45.0f);
                instancePath2.cubicTo(3.0f, 21.804039f, 21.804039f, 3.0f, 45.0f, 3.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(57.0f, 42.0f);
                instancePath3.lineTo(63.43934f, 35.56066f);
                instancePath3.cubicTo(64.02512f, 34.974873f, 64.97488f, 34.974873f, 65.56066f, 35.56066f);
                instancePath3.cubicTo(65.841965f, 35.841965f, 66.0f, 36.223495f, 66.0f, 36.62132f);
                instancePath3.lineTo(66.0f, 53.37868f);
                instancePath3.cubicTo(66.0f, 54.207108f, 65.32843f, 54.87868f, 64.5f, 54.87868f);
                instancePath3.cubicTo(64.10217f, 54.87868f, 63.720646f, 54.720646f, 63.43934f, 54.43934f);
                instancePath3.lineTo(57.0f, 48.0f);
                instancePath3.lineTo(57.0f, 42.0f);
                instancePath3.close();
                instancePath3.moveTo(26.208f, 33.0f);
                instancePath3.lineTo(51.792f, 33.0f);
                instancePath3.cubicTo(53.011444f, 33.0f, 54.0f, 33.988556f, 54.0f, 35.208f);
                instancePath3.lineTo(54.0f, 54.792f);
                instancePath3.cubicTo(54.0f, 56.011444f, 53.011444f, 57.0f, 51.792f, 57.0f);
                instancePath3.lineTo(26.208f, 57.0f);
                instancePath3.cubicTo(24.988556f, 57.0f, 24.0f, 56.011444f, 24.0f, 54.792f);
                instancePath3.lineTo(24.0f, 35.208f);
                instancePath3.cubicTo(24.0f, 33.988556f, 24.988556f, 33.0f, 26.208f, 33.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
