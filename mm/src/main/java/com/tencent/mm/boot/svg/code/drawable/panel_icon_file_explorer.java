package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_file_explorer extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-13421773);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(78.0f, 27.0f);
                instancePath.lineTo(78.0f, 57.0f);
                instancePath.cubicTo(78.0f, 58.656853f, 76.65685f, 60.0f, 75.0f, 60.0f);
                instancePath.lineTo(3.0f, 60.0f);
                instancePath.cubicTo(1.3431457f, 60.0f, 2.0290612E-16f, 58.656853f, 0.0f, 57.0f);
                instancePath.lineTo(0.0f, 27.0f);
                instancePath.lineTo(-1.3322676E-15f, 3.0f);
                instancePath.cubicTo(-1.5351737E-15f, 1.3431457f, 1.3431457f, -3.2483544E-15f, 3.0f, -3.5527137E-15f);
                instancePath.lineTo(25.947657f, 1.0214052E-14f);
                instancePath.cubicTo(26.628872f, 1.06939544E-14f, 27.289803f, 0.23184225f, 27.821741f, 0.6573936f);
                instancePath.lineTo(33.678257f, 5.3426065f);
                instancePath.cubicTo(34.210197f, 5.768158f, 34.871128f, 6.0f, 35.55234f, 6.0f);
                instancePath.lineTo(75.0f, 6.0f);
                instancePath.cubicTo(76.65685f, 6.0f, 78.0f, 7.343146f, 78.0f, 9.0f);
                instancePath.lineTo(78.0f, 27.0f);
                instancePath.close();
                instancePath.moveTo(75.0f, 18.802692f);
                instancePath.lineTo(75.0f, 15.0f);
                instancePath.cubicTo(75.0f, 13.343145f, 73.65685f, 12.0f, 72.0f, 12.0f);
                instancePath.lineTo(6.0f, 12.0f);
                instancePath.cubicTo(4.343146f, 12.0f, 3.0f, 13.343145f, 3.0f, 15.0f);
                instancePath.lineTo(3.0f, 18.802692f);
                instancePath.cubicTo(3.8825202f, 18.292183f, 4.9071383f, 18.0f, 6.0f, 18.0f);
                instancePath.lineTo(72.0f, 18.0f);
                instancePath.cubicTo(73.092865f, 18.0f, 74.11748f, 18.292183f, 75.0f, 18.802692f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
