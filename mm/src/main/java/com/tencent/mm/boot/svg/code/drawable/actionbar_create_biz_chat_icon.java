package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_create_biz_chat_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.0f, 3.0f);
                instancePath.cubicTo(27.571133f, -2.8609138f, 43.519093f, -0.13518363f, 52.0f, 10.0f);
                instancePath.cubicTo(55.015995f, 12.687686f, 56.702606f, 16.060032f, 58.0f, 20.0f);
                instancePath.cubicTo(53.84834f, 22.386908f, 54.956116f, 27.709045f, 55.0f, 32.0f);
                instancePath.cubicTo(51.89227f, 32.106026f, 48.828426f, 31.668318f, 46.0f, 32.0f);
                instancePath.cubicTo(40.42531f, 34.334362f, 40.385387f, 43.516293f, 46.0f, 46.0f);
                instancePath.cubicTo(47.032036f, 45.804314f, 48.23961f, 46.003273f, 49.0f, 46.0f);
                instancePath.cubicTo(42.640858f, 51.18614f, 33.9583f, 53.921818f, 25.0f, 53.0f);
                instancePath.cubicTo(21.613102f, 52.42963f, 18.130098f, 50.758377f, 15.0f, 50.0f);
                instancePath.cubicTo(10.964495f, 49.7039f, 7.6112313f, 51.295567f, 4.0f, 52.0f);
                instancePath.cubicTo(4.4276276f, 48.201763f, 7.4315925f, 44.073376f, 5.0f, 41.0f);
                instancePath.cubicTo(0.8348453f, 35.28936f, -0.87172616f, 28.425297f, 3.5527137E-15f, 22.0f);
                instancePath.cubicTo(1.9625797f, 13.652635f, 8.1102295f, 6.758725f, 16.0f, 3.0f);
                instancePath.lineTo(16.0f, 3.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(59.0f, 25.0f);
                instancePath2.cubicTo(60.022385f, 23.507645f, 63.989056f, 23.527437f, 65.0f, 25.0f);
                instancePath2.cubicTo(65.397224f, 28.960669f, 65.11956f, 32.513546f, 65.0f, 36.0f);
                instancePath2.cubicTo(68.62015f, 36.086216f, 72.041405f, 35.95756f, 75.0f, 36.0f);
                instancePath2.cubicTo(78.40791f, 35.710144f, 78.48725f, 39.896404f, 77.0f, 42.0f);
                instancePath2.cubicTo(73.34049f, 42.5289f, 69.1854f, 41.727276f, 65.0f, 42.0f);
                instancePath2.cubicTo(65.16914f, 45.20098f, 65.29806f, 48.42727f, 65.0f, 52.0f);
                instancePath2.cubicTo(65.26831f, 54.563156f, 60.756218f, 54.444397f, 59.0f, 53.0f);
                instancePath2.cubicTo(58.336548f, 49.476307f, 59.0803f, 45.646328f, 59.0f, 42.0f);
                instancePath2.cubicTo(55.440876f, 41.945f, 52.01962f, 42.06376f, 49.0f, 42.0f);
                instancePath2.cubicTo(45.16719f, 42.509106f, 45.117607f, 35.621075f, 49.0f, 36.0f);
                instancePath2.cubicTo(51.970036f, 35.95756f, 55.411125f, 36.086216f, 59.0f, 36.0f);
                instancePath2.cubicTo(58.93155f, 32.513546f, 58.643967f, 28.970564f, 59.0f, 25.0f);
                instancePath2.lineTo(59.0f, 25.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
