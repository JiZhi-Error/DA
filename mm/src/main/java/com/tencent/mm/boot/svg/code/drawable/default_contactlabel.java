package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_contactlabel extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePaint3.setColor(-14187817);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                instancePath.lineTo(108.0f, 0.0f);
                instancePath.cubicTo(114.62742f, 0.0f, 120.0f, 5.3725824f, 120.0f, 12.0f);
                instancePath.lineTo(120.0f, 108.0f);
                instancePath.cubicTo(120.0f, 114.62742f, 114.62742f, 120.0f, 108.0f, 120.0f);
                instancePath.lineTo(12.0f, 120.0f);
                instancePath.cubicTo(5.3725824f, 120.0f, 0.0f, 114.62742f, 0.0f, 108.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 7.5f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(2.1213202f, 33.62132f);
                instancePath2.cubicTo(0.94974744f, 32.44975f, 0.94974744f, 30.550253f, 2.1213202f, 29.37868f);
                instancePath2.lineTo(30.62132f, 0.87867963f);
                instancePath2.cubicTo(31.18393f, 0.31607053f, 31.946991f, 3.0425315E-14f, 32.74264f, 2.88658E-14f);
                instancePath2.lineTo(52.5f, -1.7763568E-15f);
                instancePath2.cubicTo(54.156853f, -2.0807161E-15f, 55.5f, 1.3431457f, 55.5f, 3.0f);
                instancePath2.lineTo(55.5f, 22.757359f);
                instancePath2.cubicTo(55.5f, 23.553009f, 55.18393f, 24.31607f, 54.62132f, 24.87868f);
                instancePath2.lineTo(26.12132f, 53.37868f);
                instancePath2.cubicTo(24.949747f, 54.55025f, 23.050253f, 54.55025f, 21.87868f, 53.37868f);
                instancePath2.lineTo(2.1213202f, 33.62132f);
                instancePath2.close();
                instancePath2.moveTo(40.5f, 19.5f);
                instancePath2.cubicTo(42.985283f, 19.5f, 45.0f, 17.485281f, 45.0f, 15.0f);
                instancePath2.cubicTo(45.0f, 12.514719f, 42.985283f, 10.5f, 40.5f, 10.5f);
                instancePath2.cubicTo(38.014717f, 10.5f, 36.0f, 12.514719f, 36.0f, 15.0f);
                instancePath2.cubicTo(36.0f, 17.485281f, 38.014717f, 19.5f, 40.5f, 19.5f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
