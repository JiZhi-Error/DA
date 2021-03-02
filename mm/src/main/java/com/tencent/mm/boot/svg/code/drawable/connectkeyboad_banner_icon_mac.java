package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class connectkeyboad_banner_icon_mac extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 17.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(77.0f, 50.5601f);
                instancePath.cubicTo(77.0f, 51.3551f, 76.36f, 52.0001f, 75.555f, 52.0001f);
                instancePath.lineTo(49.0f, 52.0001f);
                instancePath.lineTo(32.0f, 52.0001f);
                instancePath.lineTo(4.445f, 52.0001f);
                instancePath.cubicTo(3.647f, 52.0001f, 3.0f, 51.3621f, 3.0f, 50.5601f);
                instancePath.lineTo(3.0f, 43.0001f);
                instancePath.lineTo(77.0f, 43.0001f);
                instancePath.lineTo(77.0f, 50.5601f);
                instancePath.close();
                instancePath.moveTo(33.232f, 60.0001f);
                instancePath.lineTo(35.0f, 55.5781f);
                instancePath.lineTo(35.0f, 55.0001f);
                instancePath.lineTo(46.0f, 55.0001f);
                instancePath.lineTo(46.0f, 55.5781f);
                instancePath.lineTo(47.769f, 60.0001f);
                instancePath.lineTo(33.232f, 60.0001f);
                instancePath.close();
                instancePath.moveTo(3.0f, 4.4401f);
                instancePath.cubicTo(3.0f, 3.6451f, 3.64f, 3.0001f, 4.445f, 3.0001f);
                instancePath.lineTo(75.555f, 3.0001f);
                instancePath.cubicTo(76.353f, 3.0001f, 77.0f, 3.6371f, 77.0f, 4.4401f);
                instancePath.lineTo(77.0f, 40.0001f);
                instancePath.lineTo(3.0f, 40.0001f);
                instancePath.lineTo(3.0f, 4.4401f);
                instancePath.close();
                instancePath.moveTo(75.685f, 1.0E-4f);
                instancePath.lineTo(4.315f, 1.0E-4f);
                instancePath.cubicTo(1.938f, 1.0E-4f, 0.0f, 1.9321f, 0.0f, 4.3161f);
                instancePath.lineTo(0.0f, 50.6841f);
                instancePath.cubicTo(0.0f, 53.0751f, 1.932f, 55.0001f, 4.315f, 55.0001f);
                instancePath.lineTo(32.0f, 55.0001f);
                instancePath.lineTo(30.0f, 60.0001f);
                instancePath.lineTo(26.0f, 62.0001f);
                instancePath.lineTo(26.0f, 63.0001f);
                instancePath.lineTo(55.0f, 63.0001f);
                instancePath.lineTo(55.0f, 62.0001f);
                instancePath.lineTo(51.0f, 60.0001f);
                instancePath.lineTo(49.0f, 55.0001f);
                instancePath.lineTo(75.685f, 55.0001f);
                instancePath.cubicTo(78.062f, 55.0001f, 80.0f, 53.0681f, 80.0f, 50.6841f);
                instancePath.lineTo(80.0f, 4.3161f);
                instancePath.cubicTo(80.0f, 1.9251f, 78.068f, 1.0E-4f, 75.685f, 1.0E-4f);
                instancePath.lineTo(75.685f, 1.0E-4f);
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
