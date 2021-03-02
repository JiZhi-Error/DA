package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_quit_webview_icon extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.0f, 5.270896f);
                instancePath.cubicTo(2.4202743f, 3.8405488f, 3.8405488f, 2.4202743f, 5.270896f, 1.0f);
                instancePath.cubicTo(11.687312f, 7.3962708f, 18.083584f, 13.812688f, 24.5f, 20.21903f);
                instancePath.cubicTo(30.916416f, 13.822761f, 37.312687f, 7.3962708f, 43.729103f, 1.0f);
                instancePath.cubicTo(45.15945f, 2.4202743f, 46.579727f, 3.8405488f, 48.0f, 5.270896f);
                instancePath.cubicTo(41.60373f, 11.687312f, 35.17724f, 18.083584f, 28.78097f, 24.5f);
                instancePath.cubicTo(35.17724f, 30.916416f, 41.60373f, 37.312687f, 48.0f, 43.739178f);
                instancePath.cubicTo(46.579727f, 45.15945f, 45.15945f, 46.579727f, 43.739178f, 48.0f);
                instancePath.cubicTo(37.312687f, 41.60373f, 30.916416f, 35.17724f, 24.5f, 28.78097f);
                instancePath.cubicTo(18.083584f, 35.17724f, 11.687312f, 41.60373f, 5.270896f, 48.0f);
                instancePath.cubicTo(3.8405488f, 46.579727f, 2.4202743f, 45.15945f, 1.0f, 43.739178f);
                instancePath.cubicTo(7.3962708f, 37.312687f, 13.822761f, 30.916416f, 20.21903f, 24.5f);
                instancePath.cubicTo(13.822761f, 18.083584f, 7.3962708f, 11.687312f, 1.0f, 5.270896f);
                instancePath.lineTo(1.0f, 5.270896f);
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
