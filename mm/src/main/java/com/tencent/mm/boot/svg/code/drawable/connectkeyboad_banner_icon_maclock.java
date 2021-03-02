package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class connectkeyboad_banner_icon_maclock extends c {
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
                instancePaint3.setColor(-9538696);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 17.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.0f, 55.0f);
                instancePath.lineTo(46.0f, 55.578f);
                instancePath.lineTo(46.215f, 56.114f);
                instancePath.lineTo(47.769f, 60.0f);
                instancePath.lineTo(33.231f, 60.0f);
                instancePath.lineTo(34.785f, 56.114f);
                instancePath.lineTo(35.0f, 55.578f);
                instancePath.lineTo(35.0f, 55.0f);
                instancePath.lineTo(46.0f, 55.0f);
                instancePath.lineTo(46.0f, 55.0f);
                instancePath.close();
                instancePath.moveTo(3.0f, 4.44f);
                instancePath.cubicTo(3.0f, 3.645f, 3.64f, 3.0f, 4.445f, 3.0f);
                instancePath.lineTo(75.555f, 3.0f);
                instancePath.cubicTo(76.353f, 3.0f, 77.0f, 3.637f, 77.0f, 4.44f);
                instancePath.lineTo(77.0f, 29.0f);
                instancePath.lineTo(80.0f, 29.0f);
                instancePath.lineTo(80.0f, 4.316f);
                instancePath.cubicTo(80.0f, 1.925f, 78.068f, 0.0f, 75.685f, 0.0f);
                instancePath.lineTo(4.315f, 0.0f);
                instancePath.cubicTo(1.938f, 0.0f, 0.0f, 1.932f, 0.0f, 4.316f);
                instancePath.lineTo(0.0f, 50.684f);
                instancePath.cubicTo(0.0f, 53.075f, 1.932f, 55.0f, 4.315f, 55.0f);
                instancePath.lineTo(32.0f, 55.0f);
                instancePath.lineTo(30.0f, 60.0f);
                instancePath.lineTo(26.0f, 62.0f);
                instancePath.lineTo(26.0f, 63.0f);
                instancePath.lineTo(55.0f, 63.0f);
                instancePath.lineTo(55.0f, 62.0f);
                instancePath.lineTo(51.0f, 60.0f);
                instancePath.lineTo(49.0f, 55.0f);
                instancePath.lineTo(59.0f, 55.0f);
                instancePath.lineTo(59.0f, 52.0f);
                instancePath.lineTo(49.0f, 52.0f);
                instancePath.lineTo(32.0f, 52.0f);
                instancePath.lineTo(4.445f, 52.0f);
                instancePath.cubicTo(3.647f, 52.0f, 3.0f, 51.363f, 3.0f, 50.56f);
                instancePath.lineTo(3.0f, 43.0f);
                instancePath.lineTo(59.0f, 43.0f);
                instancePath.lineTo(59.0f, 40.0f);
                instancePath.lineTo(3.0f, 40.0f);
                instancePath.lineTo(3.0f, 4.44f);
                instancePath.lineTo(3.0f, 4.44f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(65.0f, 60.0f);
                instancePath2.lineTo(84.0f, 60.0f);
                instancePath2.lineTo(84.0f, 46.0f);
                instancePath2.lineTo(65.0f, 46.0f);
                instancePath2.lineTo(65.0f, 60.0f);
                instancePath2.close();
                instancePath2.moveTo(69.0f, 37.0f);
                instancePath2.cubicTo(69.0f, 35.895f, 69.9f, 35.0f, 70.992f, 35.0f);
                instancePath2.lineTo(78.008f, 35.0f);
                instancePath2.cubicTo(79.108f, 35.0f, 80.0f, 35.887f, 80.0f, 37.0f);
                instancePath2.lineTo(80.0f, 43.0f);
                instancePath2.lineTo(69.0f, 43.0f);
                instancePath2.lineTo(69.0f, 37.0f);
                instancePath2.close();
                instancePath2.moveTo(84.132f, 43.0f);
                instancePath2.lineTo(83.0f, 43.0f);
                instancePath2.lineTo(83.0f, 37.754f);
                instancePath2.cubicTo(83.0f, 34.574f, 80.423f, 32.0f, 77.245f, 32.0f);
                instancePath2.lineTo(71.755f, 32.0f);
                instancePath2.cubicTo(68.582f, 32.0f, 66.0f, 34.576f, 66.0f, 37.754f);
                instancePath2.lineTo(66.0f, 43.0f);
                instancePath2.lineTo(64.868f, 43.0f);
                instancePath2.cubicTo(63.291f, 43.0f, 62.0f, 44.292f, 62.0f, 45.887f);
                instancePath2.lineTo(62.0f, 60.113f);
                instancePath2.cubicTo(62.0f, 61.718f, 63.284f, 63.0f, 64.868f, 63.0f);
                instancePath2.lineTo(84.132f, 63.0f);
                instancePath2.cubicTo(85.709f, 63.0f, 87.0f, 61.708f, 87.0f, 60.113f);
                instancePath2.lineTo(87.0f, 45.887f);
                instancePath2.cubicTo(87.0f, 44.281f, 85.716f, 43.0f, 84.132f, 43.0f);
                instancePath2.lineTo(84.132f, 43.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
