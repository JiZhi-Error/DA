package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_star extends c {
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-8683387);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(53.089928f, 45.616577f);
                instancePath.lineTo(53.623455f, 47.1627f);
                instancePath.cubicTo(53.623455f, 47.1627f, 53.01152f, 44.28202f, 54.975307f, 42.67076f);
                instancePath.cubicTo(54.863106f, 42.752514f, 54.75811f, 42.829773f, 54.656723f, 42.90524f);
                instancePath.lineTo(73.0f, 26.94896f);
                instancePath.lineTo(48.666668f, 26.94896f);
                instancePath.cubicTo(48.666668f, 26.94896f, 45.512344f, 26.898201f, 45.06173f, 24.253796f);
                instancePath.cubicTo(45.0784f, 24.353516f, 45.093723f, 24.444702f, 45.109043f, 24.537237f);
                instancePath.lineTo(36.420692f, 0.0f);
                instancePath.lineTo(27.904024f, 24.459076f);
                instancePath.cubicTo(27.915741f, 24.39035f, 27.926556f, 24.326115f, 27.938272f, 24.253796f);
                instancePath.cubicTo(27.916191f, 24.383163f, 27.882845f, 24.5013f, 27.848598f, 24.61854f);
                instancePath.lineTo(27.758926f, 24.875479f);
                instancePath.cubicTo(26.960882f, 26.899998f, 24.333334f, 26.94896f, 24.333334f, 26.94896f);
                instancePath.lineTo(0.0f, 26.94896f);
                instancePath.lineTo(18.472155f, 43.11681f);
                instancePath.cubicTo(19.523445f, 44.34356f, 19.512178f, 45.986263f, 19.435574f, 46.74495f);
                instancePath.lineTo(11.566444f, 71.87288f);
                instancePath.lineTo(34.679054f, 56.182972f);
                instancePath.lineTo(34.246914f, 56.59578f);
                instancePath.cubicTo(34.246914f, 56.59578f, 36.448177f, 54.918938f, 38.753086f, 56.59578f);
                instancePath.cubicTo(38.745876f, 56.588593f, 38.740017f, 56.583202f, 38.732807f, 56.57557f);
                instancePath.lineTo(61.149216f, 72.0f);
                instancePath.lineTo(53.089928f, 45.616577f);
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
