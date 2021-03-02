package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_black extends c {
    private final int height = 20;
    private final int width = 20;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 20;
            case 1:
                return 20;
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
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.0f, 1.6666666f);
                instancePath.cubicTo(14.602373f, 1.6666666f, 18.333334f, 5.397627f, 18.333334f, 10.0f);
                instancePath.cubicTo(18.333334f, 14.602373f, 14.602373f, 18.333334f, 10.0f, 18.333334f);
                instancePath.cubicTo(5.397627f, 18.333334f, 1.6666666f, 14.602373f, 1.6666666f, 10.0f);
                instancePath.cubicTo(1.6666666f, 5.397627f, 5.397627f, 1.6666666f, 10.0f, 1.6666666f);
                instancePath.close();
                instancePath.moveTo(10.0f, 3.3333333f);
                instancePath.cubicTo(6.318102f, 3.3333333f, 3.3333333f, 6.318102f, 3.3333333f, 10.0f);
                instancePath.cubicTo(3.3333333f, 13.681898f, 6.318102f, 16.666666f, 10.0f, 16.666666f);
                instancePath.cubicTo(13.681898f, 16.666666f, 16.666666f, 13.681898f, 16.666666f, 10.0f);
                instancePath.cubicTo(16.666666f, 6.318102f, 13.681898f, 3.3333333f, 10.0f, 3.3333333f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -0.70710677f, 0.70710677f, 10.0f, 0.70710677f, 0.70710677f, -4.1421356f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(9.004842f, 2.207901f);
                instancePath2.lineTo(11.0f, 2.2112734f);
                instancePath2.lineTo(10.995158f, 17.792099f);
                instancePath2.lineTo(9.0f, 17.788727f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
