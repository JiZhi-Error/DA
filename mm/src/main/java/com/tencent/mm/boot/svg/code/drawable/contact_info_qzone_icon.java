package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class contact_info_qzone_icon extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(-16384);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 7.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.179684f, 20.160744f);
                instancePath.cubicTo(25.258177f, 13.424428f, 28.385149f, 6.712214f, 31.48788f, 0.0f);
                instancePath.cubicTo(34.69969f, 6.6881127f, 37.729702f, 13.4726305f, 40.893036f, 20.196896f);
                instancePath.cubicTo(48.262024f, 20.67892f, 55.631012f, 21.160948f, 63.0f, 21.655024f);
                instancePath.cubicTo(57.63082f, 26.53554f, 52.18892f, 31.34375f, 46.84398f, 36.248367f);
                instancePath.cubicTo(48.552906f, 43.828228f, 50.24971f, 51.40809f, 51.946518f, 58.98795f);
                instancePath.cubicTo(45.13505f, 55.228146f, 38.335705f, 51.44424f, 31.51212f, 47.708538f);
                instancePath.cubicTo(24.688534f, 51.45629f, 17.889189f, 55.228146f, 11.077723f, 59.0f);
                instancePath.cubicTo(12.7745285f, 51.40809f, 14.483455f, 43.828228f, 16.180262f, 36.248367f);
                instancePath.cubicTo(11.041362f, 31.596813f, 5.963063f, 26.897058f, 0.7029627f, 22.390114f);
                instancePath.cubicTo(0.53328204f, 22.390114f, 0.1818007f, 22.378063f, 0.0f, 22.366013f);
                instancePath.lineTo(0.0f, 22.064747f);
                instancePath.cubicTo(7.3083878f, 20.739176f, 14.798576f, 20.895834f, 22.179684f, 20.160744f);
                instancePath.lineTo(22.179684f, 20.160744f);
                instancePath.lineTo(22.179684f, 20.160744f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 29.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.06f, 1.52f);
                instancePath2.cubicTo(13.81f, 1.24f, 21.54f, 0.83f, 29.28f, 0.5f);
                instancePath2.cubicTo(22.8f, 6.15f, 16.29f, 11.75f, 9.81f, 17.4f);
                instancePath2.lineTo(28.01f, 17.4f);
                instancePath2.cubicTo(28.01f, 17.72f, 28.0f, 18.38f, 28.0f, 18.71f);
                instancePath2.cubicTo(19.33f, 19.12f, 10.67f, 19.57f, 2.0f, 19.99f);
                instancePath2.cubicTo(8.51f, 14.35f, 15.02f, 8.71f, 21.53f, 3.07f);
                instancePath2.cubicTo(14.37f, 2.95f, 7.21f, 3.31f, 0.07f, 2.85f);
                instancePath2.cubicTo(1.78f, 1.46f, 4.0f, 1.65f, 6.06f, 1.52f);
                instancePath2.lineTo(6.06f, 1.52f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
