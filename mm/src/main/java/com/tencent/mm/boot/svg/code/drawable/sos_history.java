package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_history extends c {
    private final int height = 42;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-4210753);
                instancePaint5.setColor(-4210753);
                instancePaint5.setStrokeWidth(1.2f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.06508f, 39.519398f);
                instancePath.cubicTo(9.131414f, 39.519398f, 0.36045057f, 30.628284f, 0.36045057f, 19.814768f);
                instancePath.cubicTo(0.36045057f, 8.881102f, 9.251564f, 0.11013767f, 20.06508f, 0.11013767f);
                instancePath.cubicTo(30.998749f, 0.11013767f, 39.76971f, 9.001251f, 39.76971f, 19.814768f);
                instancePath.cubicTo(39.76971f, 30.628284f, 30.998749f, 39.519398f, 20.06508f, 39.519398f);
                instancePath.close();
                instancePath.moveTo(20.06508f, 1.1914893f);
                instancePath.cubicTo(9.852315f, 1.1914893f, 1.5619525f, 9.481853f, 1.5619525f, 19.694618f);
                instancePath.cubicTo(1.5619525f, 29.907385f, 9.852315f, 38.197746f, 20.06508f, 38.197746f);
                instancePath.cubicTo(30.277847f, 38.197746f, 38.56821f, 29.907385f, 38.56821f, 19.694618f);
                instancePath.cubicTo(38.56821f, 9.481853f, 30.277847f, 1.1914893f, 20.06508f, 1.1914893f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint9 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(25.83229f, 27.26408f);
                instancePath2.cubicTo(25.712141f, 27.26408f, 25.47184f, 27.14393f, 25.35169f, 27.023779f);
                instancePath2.lineTo(19.58448f, 20.055069f);
                instancePath2.cubicTo(19.46433f, 19.93492f, 19.46433f, 19.814768f, 19.46433f, 19.694618f);
                instancePath2.lineTo(19.46433f, 8.1602f);
                instancePath2.cubicTo(19.46433f, 7.79975f, 19.70463f, 7.559449f, 20.06508f, 7.559449f);
                instancePath2.cubicTo(20.425531f, 7.559449f, 20.665833f, 7.79975f, 20.665833f, 8.1602f);
                instancePath2.lineTo(20.665833f, 19.454317f);
                instancePath2.lineTo(26.312891f, 26.182728f);
                instancePath2.cubicTo(26.553192f, 26.423029f, 26.43304f, 26.78348f, 26.192741f, 27.023779f);
                instancePath2.cubicTo(26.07259f, 27.26408f, 25.95244f, 27.26408f, 25.83229f, 27.26408f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.drawPath(instancePath2, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
