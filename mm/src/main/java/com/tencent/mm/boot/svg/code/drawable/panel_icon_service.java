package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_service extends c {
    private final int height = 168;
    private final int width = 168;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                instancePaint3.setColor(-8617594);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 50.0f, 0.0f, 1.0f, 36.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.867924f, 54.0f);
                instancePath.lineTo(2.0f, 54.0f);
                instancePath.cubicTo(1.277121f, 54.0f, 0.50183654f, 53.545902f, -1.0658141E-14f, 53.0f);
                instancePath.cubicTo(-0.17057356f, 51.97461f, 0.02324753f, 51.06792f, 1.0f, 50.0f);
                instancePath.lineTo(43.0f, 1.0f);
                instancePath.cubicTo(43.767178f, 0.09632745f, 44.461952f, -0.13072085f, 45.0f, 7.1054274E-15f);
                instancePath.cubicTo(45.696445f, 0.28127408f, 46.048306f, 0.8571648f, 46.0f, 1.0f);
                instancePath.lineTo(42.132076f, 42.0f);
                instancePath.lineTo(67.0f, 42.0f);
                instancePath.cubicTo(67.66808f, 42.0f, 68.47741f, 42.454098f, 69.0f, 43.0f);
                instancePath.cubicTo(69.17823f, 44.026894f, 68.97627f, 44.93208f, 68.0f, 46.0f);
                instancePath.lineTo(24.0f, 95.0f);
                instancePath.cubicTo(23.331083f, 95.90367f, 22.604643f, 96.12922f, 22.0f, 96.0f);
                instancePath.cubicTo(21.31604f, 95.717224f, 20.949804f, 95.14284f, 21.0f, 95.0f);
                instancePath.lineTo(24.867924f, 54.0f);
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
