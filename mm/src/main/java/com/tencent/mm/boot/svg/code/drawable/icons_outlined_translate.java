package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_translate extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.6f, 27.6f);
                instancePath.lineTo(3.6f, 56.4f);
                instancePath.lineTo(32.4f, 56.4f);
                instancePath.lineTo(32.4f, 27.6f);
                instancePath.lineTo(3.6f, 27.6f);
                instancePath.close();
                instancePath.moveTo(24.0f, 24.0f);
                instancePath.lineTo(24.0f, 3.0074198f);
                instancePath.cubicTo(24.0f, 1.3672829f, 25.346468f, 0.0f, 27.00742f, 0.0f);
                instancePath.lineTo(56.99258f, 0.0f);
                instancePath.cubicTo(58.632717f, 0.0f, 60.0f, 1.3464677f, 60.0f, 3.0074198f);
                instancePath.lineTo(60.0f, 32.99258f);
                instancePath.cubicTo(60.0f, 34.632717f, 58.653534f, 36.0f, 56.99258f, 36.0f);
                instancePath.lineTo(36.0f, 36.0f);
                instancePath.lineTo(36.0f, 56.99258f);
                instancePath.cubicTo(36.0f, 58.632717f, 34.653534f, 60.0f, 32.99258f, 60.0f);
                instancePath.lineTo(3.0074198f, 60.0f);
                instancePath.cubicTo(1.3672829f, 60.0f, 0.0f, 58.653534f, 0.0f, 56.99258f);
                instancePath.lineTo(0.0f, 27.00742f);
                instancePath.cubicTo(0.0f, 25.367283f, 1.3464677f, 24.0f, 3.0074198f, 24.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.close();
                instancePath.moveTo(27.6f, 24.0f);
                instancePath.lineTo(32.99258f, 24.0f);
                instancePath.cubicTo(34.632717f, 24.0f, 36.0f, 25.346468f, 36.0f, 27.00742f);
                instancePath.lineTo(36.0f, 32.4f);
                instancePath.lineTo(56.4f, 32.4f);
                instancePath.lineTo(56.4f, 3.6f);
                instancePath.lineTo(27.6f, 3.6f);
                instancePath.lineTo(27.6f, 24.0f);
                instancePath.close();
                instancePath.moveTo(20.83499f, 38.09066f);
                instancePath.lineTo(14.341711f, 38.09066f);
                instancePath.cubicTo(15.188661f, 40.08859f, 16.339643f, 41.869354f, 17.794659f, 43.41124f);
                instancePath.cubicTo(19.075941f, 41.934505f, 20.096622f, 40.175457f, 20.83499f, 38.09066f);
                instancePath.close();
                instancePath.moveTo(27.675734f, 38.09066f);
                instancePath.lineTo(24.396519f, 38.09066f);
                instancePath.cubicTo(23.375837f, 41.044125f, 21.985971f, 43.498104f, 20.205206f, 45.517754f);
                instancePath.cubicTo(22.376871f, 47.081352f, 25.004585f, 48.232334f, 28.1535f, 48.927265f);
                instancePath.cubicTo(27.436852f, 49.6222f, 26.503035f, 51.012066f, 26.025269f, 51.88073f);
                instancePath.cubicTo(22.680904f, 51.012066f, 19.966324f, 49.665634f, 17.729507f, 47.86315f);
                instancePath.cubicTo(15.362393f, 49.73078f, 12.495796f, 51.09893f, 9.064565f, 52.054462f);
                instancePath.cubicTo(8.717099f, 51.29438f, 7.761566f, 49.81765f, 7.1535f, 49.079285f);
                instancePath.cubicTo(10.476148f, 48.340916f, 13.190728f, 47.21165f, 15.38411f, 45.604618f);
                instancePath.cubicTo(13.581628f, 43.51982f, 12.191763f, 41.022408f, 11.062497f, 38.09066f);
                instancePath.lineTo(7.631266f, 38.09066f);
                instancePath.lineTo(7.631266f, 35.006893f);
                instancePath.lineTo(16.578526f, 35.006893f);
                instancePath.cubicTo(16.361359f, 34.13823f, 15.97046f, 33.030678f, 15.557843f, 32.162014f);
                instancePath.lineTo(18.94564f, 31.163048f);
                instancePath.cubicTo(19.488558f, 32.18373f, 20.096622f, 33.55188f, 20.31379f, 34.463978f);
                instancePath.lineTo(18.55474f, 35.006893f);
                instancePath.lineTo(27.675734f, 35.006893f);
                instancePath.lineTo(27.675734f, 38.09066f);
                instancePath.close();
                instancePath.moveTo(46.652344f, 25.910156f);
                instancePath.lineTo(45.36328f, 21.808594f);
                instancePath.lineTo(39.421875f, 21.808594f);
                instancePath.lineTo(38.132812f, 25.910156f);
                instancePath.lineTo(34.5f, 25.910156f);
                instancePath.lineTo(40.371094f, 9.0f);
                instancePath.lineTo(44.53125f, 9.0f);
                instancePath.lineTo(50.414062f, 25.910156f);
                instancePath.lineTo(46.652344f, 25.910156f);
                instancePath.close();
                instancePath.moveTo(42.351562f, 12.234375f);
                instancePath.lineTo(40.183594f, 19.160156f);
                instancePath.lineTo(44.601562f, 19.160156f);
                instancePath.lineTo(42.433594f, 12.234375f);
                instancePath.lineTo(42.351562f, 12.234375f);
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
