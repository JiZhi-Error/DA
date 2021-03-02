package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_outlined_max_window extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.0f, 14.0f);
                instancePath.lineTo(18.0f, 18.0f);
                instancePath.cubicTo(18.0f, 18.552284f, 17.552284f, 19.0f, 17.0f, 19.0f);
                instancePath.lineTo(13.0f, 19.0f);
                instancePath.lineTo(13.0f, 17.8f);
                instancePath.lineTo(16.8f, 17.8f);
                instancePath.lineTo(16.8f, 14.0f);
                instancePath.lineTo(18.0f, 14.0f);
                instancePath.close();
                instancePath.moveTo(5.0f, 1.0f);
                instancePath.lineTo(5.0f, 2.2f);
                instancePath.lineTo(1.2f, 2.2f);
                instancePath.lineTo(1.2f, 6.0f);
                instancePath.lineTo(0.0f, 6.0f);
                instancePath.lineTo(0.0f, 2.0f);
                instancePath.cubicTo(0.0f, 1.4477153f, 0.44771525f, 1.0f, 1.0f, 1.0f);
                instancePath.lineTo(5.0f, 1.0f);
                instancePath.close();
                instancePath.moveTo(16.796854f, 3.0456264f);
                instancePath.lineTo(11.32492f, 8.517561f);
                instancePath.lineTo(10.476392f, 7.6690326f);
                instancePath.lineTo(15.948318f, 2.1971068f);
                instancePath.lineTo(12.996855f, 2.1971068f);
                instancePath.lineTo(12.996855f, 0.9971068f);
                instancePath.lineTo(16.996855f, 0.9971068f);
                instancePath.cubicTo(17.549139f, 0.9971068f, 17.996855f, 1.4448221f, 17.996855f, 1.9971068f);
                instancePath.lineTo(17.996855f, 5.997107f);
                instancePath.lineTo(16.796854f, 5.997107f);
                instancePath.lineTo(16.796854f, 3.0456264f);
                instancePath.close();
                instancePath.moveTo(1.2031456f, 16.954374f);
                instancePath.lineTo(6.67508f, 11.482439f);
                instancePath.lineTo(7.523608f, 12.330968f);
                instancePath.lineTo(2.0516825f, 17.802893f);
                instancePath.lineTo(5.0031457f, 17.802893f);
                instancePath.lineTo(5.0031457f, 19.002893f);
                instancePath.lineTo(1.0031456f, 19.002893f);
                instancePath.cubicTo(0.45086086f, 19.002893f, 0.0031455979f, 18.555178f, 0.0031455979f, 18.002893f);
                instancePath.lineTo(0.0031455979f, 14.002893f);
                instancePath.lineTo(1.2031456f, 14.002893f);
                instancePath.lineTo(1.2031456f, 16.954374f);
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
