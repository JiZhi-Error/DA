package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class connectkeyboad_banner_icon_pc extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-9473160);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 17.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(77.0f, 49.0f);
                instancePath.lineTo(46.0f, 49.0f);
                instancePath.lineTo(35.0f, 49.0f);
                instancePath.lineTo(3.0f, 49.0f);
                instancePath.lineTo(3.0f, 3.0f);
                instancePath.lineTo(77.0f, 3.0f);
                instancePath.lineTo(77.0f, 49.0f);
                instancePath.close();
                instancePath.moveTo(48.513f, 60.0f);
                instancePath.lineTo(32.487f, 60.0f);
                instancePath.lineTo(38.0f, 58.162f);
                instancePath.lineTo(38.0f, 52.0f);
                instancePath.lineTo(43.0f, 52.0f);
                instancePath.lineTo(43.0f, 58.162f);
                instancePath.lineTo(48.513f, 60.0f);
                instancePath.close();
                instancePath.moveTo(77.129f, 0.0f);
                instancePath.lineTo(2.871f, 0.0f);
                instancePath.cubicTo(1.289f, 0.0f, 0.0f, 1.285f, 0.0f, 2.87f);
                instancePath.lineTo(0.0f, 49.13f);
                instancePath.cubicTo(0.0f, 50.715f, 1.285f, 52.0f, 2.871f, 52.0f);
                instancePath.lineTo(35.0f, 52.0f);
                instancePath.lineTo(35.0f, 56.0f);
                instancePath.lineTo(23.0f, 60.0f);
                instancePath.lineTo(23.0f, 63.0f);
                instancePath.lineTo(58.0f, 63.0f);
                instancePath.lineTo(58.0f, 60.0f);
                instancePath.lineTo(46.0f, 56.0f);
                instancePath.lineTo(46.0f, 52.0f);
                instancePath.lineTo(77.129f, 52.0f);
                instancePath.cubicTo(78.711f, 52.0f, 80.0f, 50.715f, 80.0f, 49.13f);
                instancePath.lineTo(80.0f, 2.87f);
                instancePath.cubicTo(80.0f, 1.285f, 78.715f, 0.0f, 77.129f, 0.0f);
                instancePath.lineTo(77.129f, 0.0f);
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
