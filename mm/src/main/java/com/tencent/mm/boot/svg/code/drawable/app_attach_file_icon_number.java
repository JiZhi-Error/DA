package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_number extends c {
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
                instancePaint3.setColor(-14824411);
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
                instancePaint4.setColor(-15228131);
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
                instancePaint5.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(19.75f, 62.0f);
                instancePath3.lineTo(24.25f, 62.0f);
                instancePath3.cubicTo(24.664213f, 62.0f, 25.0f, 62.335785f, 25.0f, 62.75f);
                instancePath3.lineTo(25.0f, 65.25f);
                instancePath3.cubicTo(25.0f, 65.664215f, 24.664213f, 66.0f, 24.25f, 66.0f);
                instancePath3.lineTo(19.75f, 66.0f);
                instancePath3.cubicTo(19.335787f, 66.0f, 19.0f, 65.664215f, 19.0f, 65.25f);
                instancePath3.lineTo(19.0f, 62.75f);
                instancePath3.cubicTo(19.0f, 62.335785f, 19.335787f, 62.0f, 19.75f, 62.0f);
                instancePath3.close();
                instancePath3.moveTo(27.75f, 55.0f);
                instancePath3.lineTo(32.25f, 55.0f);
                instancePath3.cubicTo(32.664215f, 55.0f, 33.0f, 55.335785f, 33.0f, 55.75f);
                instancePath3.lineTo(33.0f, 65.25f);
                instancePath3.cubicTo(33.0f, 65.664215f, 32.664215f, 66.0f, 32.25f, 66.0f);
                instancePath3.lineTo(27.75f, 66.0f);
                instancePath3.cubicTo(27.335787f, 66.0f, 27.0f, 65.664215f, 27.0f, 65.25f);
                instancePath3.lineTo(27.0f, 55.75f);
                instancePath3.cubicTo(27.0f, 55.335785f, 27.335787f, 55.0f, 27.75f, 55.0f);
                instancePath3.close();
                instancePath3.moveTo(35.75f, 44.0f);
                instancePath3.lineTo(40.25f, 44.0f);
                instancePath3.cubicTo(40.664215f, 44.0f, 41.0f, 44.335785f, 41.0f, 44.75f);
                instancePath3.lineTo(41.0f, 65.25f);
                instancePath3.cubicTo(41.0f, 65.664215f, 40.664215f, 66.0f, 40.25f, 66.0f);
                instancePath3.lineTo(35.75f, 66.0f);
                instancePath3.cubicTo(35.335785f, 66.0f, 35.0f, 65.664215f, 35.0f, 65.25f);
                instancePath3.lineTo(35.0f, 44.75f);
                instancePath3.cubicTo(35.0f, 44.335785f, 35.335785f, 44.0f, 35.75f, 44.0f);
                instancePath3.close();
                instancePath3.moveTo(19.0f, 68.0f);
                instancePath3.lineTo(49.0f, 68.0f);
                instancePath3.cubicTo(49.552284f, 68.0f, 50.0f, 68.447716f, 50.0f, 69.0f);
                instancePath3.cubicTo(50.0f, 69.552284f, 49.552284f, 70.0f, 49.0f, 70.0f);
                instancePath3.lineTo(19.0f, 70.0f);
                instancePath3.cubicTo(18.447716f, 70.0f, 18.0f, 69.552284f, 18.0f, 69.0f);
                instancePath3.cubicTo(18.0f, 68.447716f, 18.447716f, 68.0f, 19.0f, 68.0f);
                instancePath3.close();
                instancePath3.moveTo(43.75f, 50.0f);
                instancePath3.lineTo(48.25f, 50.0f);
                instancePath3.cubicTo(48.664215f, 50.0f, 49.0f, 50.335785f, 49.0f, 50.75f);
                instancePath3.lineTo(49.0f, 65.25f);
                instancePath3.cubicTo(49.0f, 65.664215f, 48.664215f, 66.0f, 48.25f, 66.0f);
                instancePath3.lineTo(43.75f, 66.0f);
                instancePath3.cubicTo(43.335785f, 66.0f, 43.0f, 65.664215f, 43.0f, 65.25f);
                instancePath3.lineTo(43.0f, 50.75f);
                instancePath3.cubicTo(43.0f, 50.335785f, 43.335785f, 50.0f, 43.75f, 50.0f);
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
