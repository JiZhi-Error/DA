package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class login_showpassword_icon_activa extends c {
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
                instancePaint3.setColor(-12206054);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 27.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 21.0f);
                instancePath.cubicTo(6.57101f, 9.043519f, 19.245094f, 0.23467484f, 33.0f, 0.0f);
                instancePath.cubicTo(47.52035f, -0.5352242f, 61.110394f, 8.483593f, 68.0f, 21.0f);
                instancePath.cubicTo(61.57833f, 32.60043f, 49.461784f, 41.279293f, 36.0f, 42.0f);
                instancePath.cubicTo(21.216398f, 42.959072f, 7.0190334f, 33.850266f, 0.0f, 21.0f);
                instancePath.lineTo(0.0f, 21.0f);
                instancePath.close();
                instancePath.moveTo(30.0f, 10.0f);
                instancePath.cubicTo(25.925423f, 10.998532f, 22.441738f, 15.190254f, 22.0f, 20.0f);
                instancePath.cubicTo(21.223944f, 26.657608f, 27.203108f, 33.174736f, 34.0f, 33.0f);
                instancePath.cubicTo(40.80845f, 33.204678f, 46.76765f, 26.667587f, 46.0f, 20.0f);
                instancePath.cubicTo(45.479984f, 12.565438f, 37.35471f, 7.156121f, 30.0f, 10.0f);
                instancePath.lineTo(30.0f, 10.0f);
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
