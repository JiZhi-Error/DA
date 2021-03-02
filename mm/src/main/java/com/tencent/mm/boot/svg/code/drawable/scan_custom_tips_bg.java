package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class scan_custom_tips_bg extends c {
    private final int height = 94;
    private final int width = 88;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 88;
            case 1:
                return 94;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 8.0f);
                instancePath.cubicTo(0.0f, 3.5817218f, 3.5817218f, 0.0f, 8.0f, 0.0f);
                instancePath.lineTo(80.0f, 0.0f);
                instancePath.cubicTo(84.41828f, 0.0f, 88.0f, 3.5817218f, 88.0f, 8.0f);
                instancePath.lineTo(88.0f, 80.0f);
                instancePath.cubicTo(88.0f, 84.41828f, 84.41828f, 88.0f, 80.0f, 88.0f);
                instancePath.lineTo(8.0f, 88.0f);
                instancePath.cubicTo(3.5817218f, 88.0f, 0.0f, 84.41828f, 0.0f, 80.0f);
                instancePath.lineTo(0.0f, 8.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.70710677f, -0.70710677f, 75.1127f, 0.70710677f, 0.70710677f, -5.338093f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(40.0f, 84.0f);
                instancePath2.lineTo(48.0f, 84.0f);
                instancePath2.lineTo(48.0f, 90.0f);
                instancePath2.cubicTo(48.0f, 91.10457f, 47.10457f, 92.0f, 46.0f, 92.0f);
                instancePath2.lineTo(40.0f, 92.0f);
                instancePath2.lineTo(40.0f, 92.0f);
                instancePath2.lineTo(40.0f, 84.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
