package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_url extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-855310);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(90.0f, 0.0f);
                instancePath.lineTo(90.0f, 90.0f);
                instancePath.lineTo(0.0f, 90.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.70710677f, -0.70710677f, 55.691124f, 0.70710677f, 0.70710677f, 21.750002f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 153, 31);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 33.0f);
                instancePath2.lineTo(3.75f, 33.0f);
                instancePath2.lineTo(3.75f, 39.0f);
                instancePath2.cubicTo(3.75f, 41.899494f, 6.100505f, 44.25f, 9.0f, 44.25f);
                instancePath2.cubicTo(11.899495f, 44.25f, 14.25f, 41.899494f, 14.25f, 39.0f);
                instancePath2.lineTo(14.25f, 27.0f);
                instancePath2.cubicTo(14.25f, 24.100506f, 11.899495f, 21.75f, 9.0f, 21.75f);
                instancePath2.lineTo(9.0f, 18.0f);
                instancePath2.cubicTo(13.970563f, 18.0f, 18.0f, 22.029438f, 18.0f, 27.0f);
                instancePath2.lineTo(18.0f, 39.0f);
                instancePath2.cubicTo(18.0f, 43.970562f, 13.970563f, 48.0f, 9.0f, 48.0f);
                instancePath2.cubicTo(4.029437f, 48.0f, 0.0f, 43.970562f, 0.0f, 39.0f);
                instancePath2.lineTo(0.0f, 33.0f);
                instancePath2.close();
                instancePath2.moveTo(0.0f, 33.0f);
                instancePath2.lineTo(3.75f, 33.0f);
                instancePath2.lineTo(3.75f, 39.0f);
                instancePath2.cubicTo(3.75f, 41.899494f, 6.100505f, 44.25f, 9.0f, 44.25f);
                instancePath2.cubicTo(11.899495f, 44.25f, 14.25f, 41.899494f, 14.25f, 39.0f);
                instancePath2.lineTo(14.25f, 27.0f);
                instancePath2.cubicTo(14.25f, 24.100506f, 11.899495f, 21.75f, 9.0f, 21.75f);
                instancePath2.lineTo(9.0f, 18.0f);
                instancePath2.cubicTo(13.970563f, 18.0f, 18.0f, 22.029438f, 18.0f, 27.0f);
                instancePath2.lineTo(18.0f, 39.0f);
                instancePath2.cubicTo(18.0f, 43.970562f, 13.970563f, 48.0f, 9.0f, 48.0f);
                instancePath2.cubicTo(4.029437f, 48.0f, 0.0f, 43.970562f, 0.0f, 39.0f);
                instancePath2.lineTo(0.0f, 33.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(18.0f, 15.0f);
                instancePath3.lineTo(14.25f, 15.0f);
                instancePath3.lineTo(14.25f, 9.0f);
                instancePath3.cubicTo(14.25f, 6.100505f, 11.899495f, 3.75f, 9.0f, 3.75f);
                instancePath3.cubicTo(6.100505f, 3.75f, 3.75f, 6.100505f, 3.75f, 9.0f);
                instancePath3.lineTo(3.75f, 21.0f);
                instancePath3.cubicTo(3.75f, 23.899494f, 6.100505f, 26.25f, 9.0f, 26.25f);
                instancePath3.lineTo(9.0f, 30.0f);
                instancePath3.cubicTo(4.029437f, 30.0f, 0.0f, 25.970562f, 0.0f, 21.0f);
                instancePath3.lineTo(0.0f, 9.0f);
                instancePath3.cubicTo(0.0f, 4.029437f, 4.029437f, 9.130776E-16f, 9.0f, 0.0f);
                instancePath3.cubicTo(13.970563f, -9.130776E-16f, 18.0f, 4.029437f, 18.0f, 9.0f);
                instancePath3.lineTo(18.0f, 15.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
