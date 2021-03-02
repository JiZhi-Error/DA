package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_bottle extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(37.99772f, 34.5f);
                instancePath.lineTo(42.19486f, 30.302864f);
                instancePath.cubicTo(42.644943f, 29.852776f, 42.8978f, 29.242327f, 42.8978f, 28.605808f);
                instancePath.lineTo(42.8978f, 18.993319f);
                instancePath.lineTo(50.95257f, 10.938545f);
                instancePath.lineTo(47.55846f, 7.544433f);
                instancePath.lineTo(39.50369f, 15.599206f);
                instancePath.lineTo(29.8912f, 15.599206f);
                instancePath.cubicTo(29.254679f, 15.599206f, 28.64423f, 15.852062f, 28.194143f, 16.302149f);
                instancePath.lineTo(9.996292f, 34.5f);
                instancePath.lineTo(22.5f, 34.5f);
                instancePath.lineTo(22.5f, 38.09999f);
                instancePath.lineTo(0.0f, 38.09999f);
                instancePath.lineTo(0.0f, 34.5f);
                instancePath.lineTo(4.9200253f, 34.5f);
                instancePath.cubicTo(4.987604f, 34.42254f, 5.0582805f, 34.346844f, 5.132054f, 34.27307f);
                instancePath.lineTo(25.648558f, 13.756565f);
                instancePath.cubicTo(26.773777f, 12.631347f, 28.2999f, 11.999206f, 29.8912f, 11.999206f);
                instancePath.lineTo(38.01252f, 11.999206f);
                instancePath.lineTo(45.43714f, 4.5745845f);
                instancePath.lineTo(43.31582f, 2.4532642f);
                instancePath.lineTo(44.37648f, 1.3926041f);
                instancePath.cubicTo(44.962265f, 0.80681765f, 45.912014f, 0.80681765f, 46.4978f, 1.3926041f);
                instancePath.lineTo(57.1044f, 11.999206f);
                instancePath.cubicTo(57.69019f, 12.584992f, 57.69019f, 13.5347395f, 57.1044f, 14.120526f);
                instancePath.lineTo(56.043743f, 15.181187f);
                instancePath.lineTo(53.92242f, 13.059866f);
                instancePath.lineTo(46.4978f, 20.484488f);
                instancePath.lineTo(46.4978f, 28.605808f);
                instancePath.cubicTo(46.4978f, 30.197107f, 45.865658f, 31.72323f, 44.74044f, 32.84845f);
                instancePath.lineTo(43.08889f, 34.5f);
                instancePath.lineTo(49.5f, 34.5f);
                instancePath.lineTo(49.5f, 38.09999f);
                instancePath.lineTo(31.5f, 38.09999f);
                instancePath.lineTo(31.5f, 34.5f);
                instancePath.lineTo(37.99772f, 34.5f);
                instancePath.close();
                instancePath.moveTo(34.5f, 49.5f);
                instancePath.lineTo(48.0f, 49.5f);
                instancePath.lineTo(48.0f, 53.09999f);
                instancePath.lineTo(34.5f, 53.09999f);
                instancePath.lineTo(34.5f, 49.5f);
                instancePath.close();
                instancePath.moveTo(25.5f, 42.0f);
                instancePath.lineTo(37.5f, 42.0f);
                instancePath.lineTo(37.5f, 45.59999f);
                instancePath.lineTo(25.5f, 45.59999f);
                instancePath.lineTo(25.5f, 42.0f);
                instancePath.close();
                instancePath.moveTo(12.0f, 42.0f);
                instancePath.lineTo(18.0f, 42.0f);
                instancePath.lineTo(18.0f, 45.59999f);
                instancePath.lineTo(12.0f, 45.59999f);
                instancePath.lineTo(12.0f, 42.0f);
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
