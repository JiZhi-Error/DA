package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class menu_logout_icon extends c {
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
                instancePaint3.setColor(-6710887);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 13.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(31.405348f, 0.65705854f);
                instancePath.cubicTo(37.56689f, -1.2034899f, 44.896828f, 0.94714403f, 48.581768f, 6.3487363f);
                instancePath.cubicTo(51.937164f, 11.160154f, 51.617603f, 17.371986f, 51.178207f, 22.95363f);
                instancePath.cubicTo(50.618973f, 28.435247f, 46.86413f, 32.65649f, 44.437458f, 37.357876f);
                instancePath.cubicTo(42.91954f, 40.128693f, 44.397514f, 43.42967f, 46.874115f, 45.050144f);
                instancePath.cubicTo(53.93442f, 49.75153f, 62.003345f, 52.94247f, 68.53438f, 58.454098f);
                instancePath.cubicTo(71.05093f, 60.494698f, 71.190735f, 64.01574f, 70.88116f, 66.98661f);
                instancePath.cubicTo(70.69142f, 68.817154f, 68.87392f, 70.11753f, 67.09635f, 69.97749f);
                instancePath.cubicTo(46.364815f, 70.0075f, 25.63327f, 70.0075f, 4.9017286f, 69.97749f);
                instancePath.cubicTo(3.1241686f, 70.12754f, 1.3166499f, 68.80715f, 1.1269103f, 66.99661f);
                instancePath.cubicTo(0.7973627f, 64.00573f, 0.95714337f, 60.484695f, 3.4836752f, 58.43409f);
                instancePath.cubicTo(9.82497f, 53.092514f, 17.574333f, 49.841557f, 24.55475f, 45.460266f);
                instancePath.cubicTo(26.681831f, 44.069855f, 28.67909f, 41.70916f, 28.0899f, 38.978355f);
                instancePath.cubicTo(27.071297f, 35.09721f, 24.04545f, 32.17635f, 22.477602f, 28.535276f);
                instancePath.cubicTo(20.200727f, 23.713856f, 20.370495f, 18.20223f, 20.849836f, 13.020703f);
                instancePath.cubicTo(21.468987f, 7.249002f, 25.74312f, 2.0674744f, 31.405348f, 0.65705854f);
                instancePath.lineTo(31.405348f, 0.65705854f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
