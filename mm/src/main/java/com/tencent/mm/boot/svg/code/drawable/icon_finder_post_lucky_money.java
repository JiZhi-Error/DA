package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_finder_post_lucky_money extends c {
    private final int height = 16;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
            case 1:
                return 16;
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
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.0f, 6.041652f);
                instancePath.cubicTo(4.424702f, 6.041652f, 3.9583333f, 5.5752835f, 3.9583333f, 4.9999857f);
                instancePath.cubicTo(3.9583333f, 4.424688f, 4.424702f, 3.958319f, 5.0f, 3.958319f);
                instancePath.cubicTo(5.575298f, 3.958319f, 6.0416665f, 4.424688f, 6.0416665f, 4.9999857f);
                instancePath.cubicTo(6.0416665f, 5.5752835f, 5.575298f, 6.041652f, 5.0f, 6.041652f);
                instancePath.moveTo(10.0f, 0.9679613f);
                instancePath.cubicTo(10.0f, 0.43337104f, 9.544335f, 4.0817542E-13f, 9.004602f, 3.8363648E-13f);
                instancePath.lineTo(0.99539757f, 1.949851E-14f);
                instancePath.cubicTo(0.44565466f, -5.495514E-15f, 1.04652615E-14f, 0.43866655f, 2.3092639E-14f, 0.9679613f);
                instancePath.lineTo(2.3092639E-14f, 0.9679613f);
                instancePath.cubicTo(2.3092639E-14f, 2.7304018f, 1.5278572f, 4.2160764f, 3.6154287f, 4.680278f);
                instancePath.cubicTo(3.5877142f, 4.7920485f, 3.5714285f, 4.908279f, 3.5714285f, 5.0286803f);
                instancePath.cubicTo(3.5714285f, 5.0764384f, 3.574f, 5.123621f, 3.5785713f, 5.170228f);
                instancePath.cubicTo(2.2004285f, 4.9544544f, 0.9662857f, 4.430987f, 2.3092639E-14f, 3.6964931f);
                instancePath.lineTo(4.3536257E-14f, 11.490126f);
                instancePath.cubicTo(4.4999272E-14f, 12.047864f, 0.4556644f, 12.5f, 0.99539757f, 12.5f);
                instancePath.lineTo(9.004602f, 12.5f);
                instancePath.cubicTo(9.554345f, 12.5f, 10.0f, 12.05133f, 10.0f, 11.490126f);
                instancePath.lineTo(10.0f, 3.6964931f);
                instancePath.cubicTo(9.033714f, 4.430987f, 7.7995715f, 4.9544544f, 6.4214287f, 5.170228f);
                instancePath.cubicTo(6.426f, 5.123621f, 6.428571f, 5.0764384f, 6.428571f, 5.0286803f);
                instancePath.cubicTo(6.428571f, 4.908279f, 6.412286f, 4.7920485f, 6.3845716f, 4.680278f);
                instancePath.cubicTo(8.472143f, 4.2160764f, 10.0f, 2.7304018f, 10.0f, 0.9679613f);
                instancePath.lineTo(10.0f, 0.9679613f);
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
