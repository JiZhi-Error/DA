package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_excel extends c {
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
                instancePaint3.setColor(-14650554);
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
                instancePaint4.setColor(-15115208);
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
                instancePath3.moveTo(22.767578f, 69.0f);
                instancePath3.lineTo(31.029297f, 56.291016f);
                instancePath3.lineTo(31.029297f, 56.16797f);
                instancePath3.lineTo(22.83789f, 43.634766f);
                instancePath3.lineTo(28.199219f, 43.634766f);
                instancePath3.lineTo(34.070312f, 53.16211f);
                instancePath3.lineTo(34.210938f, 53.16211f);
                instancePath3.lineTo(40.152344f, 43.634766f);
                instancePath3.lineTo(45.23242f, 43.634766f);
                instancePath3.lineTo(36.777344f, 56.273438f);
                instancePath3.lineTo(36.777344f, 56.396484f);
                instancePath3.lineTo(45.091797f, 69.0f);
                instancePath3.lineTo(39.871094f, 69.0f);
                instancePath3.lineTo(33.89453f, 59.683594f);
                instancePath3.lineTo(33.753906f, 59.683594f);
                instancePath3.lineTo(27.707031f, 69.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
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
