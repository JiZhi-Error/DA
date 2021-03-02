package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_unknow extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1710619);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.0f, 0.0f);
                instancePath.lineTo(68.0f, 22.0f);
                instancePath.lineTo(68.0f, 87.0f);
                instancePath.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                instancePath.lineTo(3.0f, 90.0f);
                instancePath.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                instancePath.lineTo(0.0f, 3.0f);
                instancePath.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                instancePath.lineTo(46.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-2434342);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(68.0f, 22.0f);
                instancePath2.lineTo(49.0f, 22.0f);
                instancePath2.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                instancePath2.lineTo(46.0f, 0.0f);
                instancePath2.lineTo(68.0f, 22.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-5723992);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(26.177734f, 50.26172f);
                instancePath3.cubicTo(26.371094f, 46.464844f, 28.902344f, 43.441406f, 33.841797f, 43.441406f);
                instancePath3.cubicTo(38.271484f, 43.441406f, 41.29492f, 46.183594f, 41.29492f, 49.804688f);
                instancePath3.cubicTo(41.29492f, 52.564453f, 39.871094f, 54.515625f, 37.621094f, 55.86914f);
                instancePath3.cubicTo(35.38867f, 57.1875f, 34.75586f, 58.171875f, 34.75586f, 60.01758f);
                instancePath3.lineTo(34.75586f, 61.160156f);
                instancePath3.lineTo(31.679688f, 61.160156f);
                instancePath3.lineTo(31.679688f, 59.54297f);
                instancePath3.cubicTo(31.66211f, 57.222656f, 32.78711f, 55.640625f, 35.195312f, 54.19922f);
                instancePath3.cubicTo(37.234375f, 52.95117f, 38.02539f, 51.84375f, 38.02539f, 49.96289f);
                instancePath3.cubicTo(38.02539f, 47.783203f, 36.33789f, 46.183594f, 33.71875f, 46.183594f);
                instancePath3.cubicTo(31.064453f, 46.183594f, 29.376953f, 47.748047f, 29.183594f, 50.26172f);
                instancePath3.lineTo(26.177734f, 50.26172f);
                instancePath3.close();
                instancePath3.moveTo(33.226562f, 69.17578f);
                instancePath3.cubicTo(32.101562f, 69.17578f, 31.222656f, 68.296875f, 31.222656f, 67.171875f);
                instancePath3.cubicTo(31.222656f, 66.0293f, 32.101562f, 65.16797f, 33.226562f, 65.16797f);
                instancePath3.cubicTo(34.36914f, 65.16797f, 35.23047f, 66.0293f, 35.23047f, 67.171875f);
                instancePath3.cubicTo(35.23047f, 68.296875f, 34.36914f, 69.17578f, 33.226562f, 69.17578f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
