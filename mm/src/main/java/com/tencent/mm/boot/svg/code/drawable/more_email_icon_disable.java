package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class more_email_icon_disable extends c {
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
                instancePaint3.setColor(-14046139);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(96.0f, 0.0f);
                instancePath.lineTo(96.0f, 96.0f);
                instancePath.lineTo(0.0f, 96.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint3, looper));
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 51, 31);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 13.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.6f, 5.1f);
                instancePath2.lineTo(3.6f, 39.9f);
                instancePath2.lineTo(56.4f, 39.9f);
                instancePath2.lineTo(56.4f, 5.1f);
                instancePath2.lineTo(3.6f, 5.1f);
                instancePath2.close();
                instancePath2.moveTo(0.0f, 4.5f);
                instancePath2.cubicTo(-2.0290612E-16f, 2.8431458f, 1.3431457f, 1.5f, 3.0f, 1.5f);
                instancePath2.lineTo(57.0f, 1.5f);
                instancePath2.cubicTo(58.656853f, 1.5f, 60.0f, 2.8431458f, 60.0f, 4.5f);
                instancePath2.lineTo(60.0f, 40.5f);
                instancePath2.cubicTo(60.0f, 42.156853f, 58.656853f, 43.5f, 57.0f, 43.5f);
                instancePath2.lineTo(3.0f, 43.5f);
                instancePath2.cubicTo(1.3431457f, 43.5f, -2.7402583E-15f, 42.156853f, 0.0f, 40.5f);
                instancePath2.lineTo(0.0f, 4.5f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(2.5124738f, 6.5230727f);
                instancePath3.lineTo(25.253035f, 23.99735f);
                instancePath3.cubicTo(28.055511f, 26.150826f, 31.955736f, 26.150826f, 34.758213f, 23.99735f);
                instancePath3.lineTo(57.498775f, 6.5230727f);
                instancePath3.lineTo(55.30527f, 3.6685066f);
                instancePath3.lineTo(32.56471f, 21.142784f);
                instancePath3.cubicTo(31.055685f, 22.30235f, 28.955564f, 22.30235f, 27.446539f, 21.142784f);
                instancePath3.lineTo(4.7059765f, 3.6685066f);
                instancePath3.lineTo(2.5124738f, 6.5230727f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
