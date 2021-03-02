package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_audio_wave extends c {
    private final int height = 18;
    private final int width = 18;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 18;
            case 1:
                return 18;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -5.0f, 0.0f, 1.0f, -5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.55f, 5.8333335f);
                instancePath.cubicTo(12.129899f, 5.8333335f, 12.6f, 6.3034344f, 12.6f, 6.883333f);
                instancePath.lineTo(12.6f, 21.116667f);
                instancePath.cubicTo(12.6f, 21.696566f, 12.129899f, 22.166666f, 11.55f, 22.166666f);
                instancePath.cubicTo(10.970101f, 22.166666f, 10.5f, 21.696566f, 10.5f, 21.116667f);
                instancePath.lineTo(10.5f, 6.883333f);
                instancePath.cubicTo(10.5f, 6.3034344f, 10.970101f, 5.8333335f, 11.55f, 5.8333335f);
                instancePath.close();
                instancePath.moveTo(21.583334f, 9.333333f);
                instancePath.cubicTo(22.163233f, 9.333333f, 22.633333f, 9.803434f, 22.633333f, 10.383333f);
                instancePath.lineTo(22.633333f, 17.616667f);
                instancePath.cubicTo(22.633333f, 18.196566f, 22.163233f, 18.666666f, 21.583334f, 18.666666f);
                instancePath.cubicTo(21.003435f, 18.666666f, 20.533333f, 18.196566f, 20.533333f, 17.616667f);
                instancePath.lineTo(20.533333f, 10.383333f);
                instancePath.cubicTo(20.533333f, 9.803434f, 21.003435f, 9.333333f, 21.583334f, 9.333333f);
                instancePath.close();
                instancePath.moveTo(6.5333333f, 9.333333f);
                instancePath.cubicTo(7.113232f, 9.333333f, 7.5833335f, 9.803434f, 7.5833335f, 10.383333f);
                instancePath.lineTo(7.5833335f, 17.616667f);
                instancePath.cubicTo(7.5833335f, 18.196566f, 7.113232f, 18.666666f, 6.5333333f, 18.666666f);
                instancePath.cubicTo(5.9534345f, 18.666666f, 5.483333f, 18.196566f, 5.483333f, 17.616667f);
                instancePath.lineTo(5.483333f, 10.383333f);
                instancePath.cubicTo(5.483333f, 9.803434f, 5.9534345f, 9.333333f, 6.5333333f, 9.333333f);
                instancePath.close();
                instancePath.moveTo(16.566668f, 10.733334f);
                instancePath.cubicTo(17.146566f, 10.733334f, 17.616667f, 11.203434f, 17.616667f, 11.783333f);
                instancePath.lineTo(17.616667f, 16.216667f);
                instancePath.cubicTo(17.616667f, 16.796566f, 17.146566f, 17.266666f, 16.566668f, 17.266666f);
                instancePath.cubicTo(15.986768f, 17.266666f, 15.516666f, 16.796566f, 15.516666f, 16.216667f);
                instancePath.lineTo(15.516666f, 11.783333f);
                instancePath.cubicTo(15.516666f, 11.203434f, 15.986768f, 10.733334f, 16.566668f, 10.733334f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
