package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_404_page_alert_icon extends c {
    private final int height = 280;
    private final int width = 280;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 280;
            case 1:
                return 280;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -10.0f, 0.0f, 1.0f, -10.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16896);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(289.5f, 151.72223f);
                instancePath.cubicTo(289.5f, 72.954666f, 227.04533f, 10.5f, 148.27777f, 10.5f);
                instancePath.cubicTo(72.954666f, 10.5f, 10.5f, 72.954666f, 10.5f, 151.72223f);
                instancePath.cubicTo(10.5f, 227.04533f, 72.954666f, 289.5f, 148.27777f, 289.5f);
                instancePath.cubicTo(227.04533f, 289.5f, 289.5f, 227.04533f, 289.5f, 151.72223f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(141.49457f, 85.5f);
                instancePath2.cubicTo(140.39299f, 85.5f, 139.53296f, 86.39243f, 139.57391f, 87.50098f);
                instancePath2.lineTo(142.96306f, 179.25606f);
                instancePath2.cubicTo(142.98346f, 179.80836f, 143.44995f, 180.2561f, 144.00685f, 180.2561f);
                instancePath2.lineTo(155.99315f, 180.2561f);
                instancePath2.cubicTo(156.54922f, 180.2561f, 157.01639f, 179.81255f, 157.03694f, 179.25606f);
                instancePath2.lineTo(160.42609f, 87.50098f);
                instancePath2.cubicTo(160.4669f, 86.39587f, 159.59766f, 85.5f, 158.50543f, 85.5f);
                instancePath2.lineTo(141.49457f, 85.5f);
                instancePath2.close();
                instancePath2.moveTo(150.0f, 214.5f);
                instancePath2.cubicTo(155.799f, 214.5f, 160.5f, 209.799f, 160.5f, 204.0f);
                instancePath2.cubicTo(160.5f, 198.201f, 155.799f, 193.5f, 150.0f, 193.5f);
                instancePath2.cubicTo(144.201f, 193.5f, 139.5f, 198.201f, 139.5f, 204.0f);
                instancePath2.cubicTo(139.5f, 209.799f, 144.201f, 214.5f, 150.0f, 214.5f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
