package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.k.ab;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_list_img_default extends c {
    private final int height = 414;
    private final int width = ab.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return ab.CTRL_INDEX;
            case 1:
                return 414;
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
                instancePaint3.setColor(-1315861);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 225.0f, 0.0f, 1.0f, 114.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(228.0f, 119.822876f);
                instancePath.lineTo(228.0f, 12.0f);
                instancePath.lineTo(12.0f, 12.0f);
                instancePath.lineTo(12.0f, 119.51874f);
                instancePath.lineTo(80.73831f, 55.335876f);
                instancePath.lineTo(162.56027f, 130.40851f);
                instancePath.lineTo(150.84477f, 106.321465f);
                instancePath.lineTo(184.2155f, 80.51195f);
                instancePath.lineTo(228.0f, 119.822876f);
                instancePath.lineTo(228.0f, 119.822876f);
                instancePath.close();
                instancePath.moveTo(5.9924946f, 0.0f);
                instancePath.cubicTo(2.6829312f, 0.0f, 0.0f, 2.6830428f, 0.0f, 6.004041f);
                instancePath.lineTo(0.0f, 179.99596f);
                instancePath.cubicTo(0.0f, 183.3119f, 2.6953125f, 186.0f, 5.9924946f, 186.0f);
                instancePath.lineTo(234.0075f, 186.0f);
                instancePath.cubicTo(237.31706f, 186.0f, 240.0f, 183.31696f, 240.0f, 179.99596f);
                instancePath.lineTo(240.0f, 6.004041f);
                instancePath.cubicTo(240.0f, 2.6881008f, 237.30469f, 0.0f, 234.0075f, 0.0f);
                instancePath.lineTo(5.9924946f, 0.0f);
                instancePath.lineTo(5.9924946f, 0.0f);
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
