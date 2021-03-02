package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_change extends c {
    private final int height = 20;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 20;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.736526f, 15.312118f);
                instancePath.cubicTo(18.68855f, 15.287715f, 18.641708f, 15.259116f, 18.596445f, 15.226229f);
                instancePath.lineTo(0.76661897f, 2.2721026f);
                instancePath.cubicTo(0.31868246f, 1.9466575f, 0.21645539f, 1.3237382f, 0.5433434f, 0.87381536f);
                instancePath.cubicTo(0.86796826f, 0.42700762f, 1.4962001f, 0.33003822f, 1.9398534f, 0.6523712f);
                instancePath.lineTo(19.354612f, 13.3049345f);
                instancePath.lineTo(19.457281f, 13.379528f);
                instancePath.lineTo(19.457281f, 13.379528f);
                instancePath.lineTo(19.559952f, 13.3049345f);
                instancePath.lineTo(36.97471f, 0.6523712f);
                instancePath.cubicTo(37.41836f, 0.33003822f, 38.046597f, 0.42700762f, 38.37122f, 0.87381536f);
                instancePath.cubicTo(38.69811f, 1.3237382f, 38.595882f, 1.9466575f, 38.147945f, 2.2721026f);
                instancePath.lineTo(20.623741f, 15.004182f);
                instancePath.lineTo(19.49353f, 15.865662f);
                instancePath.lineTo(18.736526f, 15.312118f);
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
