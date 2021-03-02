package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_add_emoji extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 2.24f, 0.0f, 1.0f, 2.24f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.76f, 23.52f);
                instancePath.cubicTo(5.2651315f, 23.52f, 0.0f, 18.25487f, 0.0f, 11.76f);
                instancePath.cubicTo(0.0f, 5.2651315f, 5.2651315f, 0.0f, 11.76f, 0.0f);
                instancePath.cubicTo(18.25487f, 0.0f, 23.52f, 5.2651315f, 23.52f, 11.76f);
                instancePath.cubicTo(23.52f, 18.25487f, 18.25487f, 23.52f, 11.76f, 23.52f);
                instancePath.close();
                instancePath.moveTo(11.76f, 18.816f);
                instancePath.cubicTo(15.133969f, 18.816f, 17.904558f, 16.232622f, 18.201632f, 12.936f);
                instancePath.lineTo(5.3183675f, 12.936f);
                instancePath.cubicTo(5.6154423f, 16.232622f, 8.386031f, 18.816f, 11.76f, 18.816f);
                instancePath.close();
                instancePath.moveTo(7.644f, 9.996f);
                instancePath.cubicTo(8.61823f, 9.996f, 9.408f, 9.20623f, 9.408f, 8.232f);
                instancePath.cubicTo(9.408f, 7.2577696f, 8.61823f, 6.468f, 7.644f, 6.468f);
                instancePath.cubicTo(6.66977f, 6.468f, 5.88f, 7.2577696f, 5.88f, 8.232f);
                instancePath.cubicTo(5.88f, 9.20623f, 6.66977f, 9.996f, 7.644f, 9.996f);
                instancePath.close();
                instancePath.moveTo(15.876f, 9.996f);
                instancePath.cubicTo(16.850231f, 9.996f, 17.64f, 9.20623f, 17.64f, 8.232f);
                instancePath.cubicTo(17.64f, 7.2577696f, 16.850231f, 6.468f, 15.876f, 6.468f);
                instancePath.cubicTo(14.90177f, 6.468f, 14.112f, 7.2577696f, 14.112f, 8.232f);
                instancePath.cubicTo(14.112f, 9.20623f, 14.90177f, 9.996f, 15.876f, 9.996f);
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
