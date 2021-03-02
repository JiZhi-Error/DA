package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_more extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.0f, 0.0f);
                instancePath.cubicTo(15.522847f, 0.0f, 20.0f, 4.4771523f, 20.0f, 10.0f);
                instancePath.cubicTo(20.0f, 15.522847f, 15.522847f, 20.0f, 10.0f, 20.0f);
                instancePath.cubicTo(4.4771523f, 20.0f, 0.0f, 15.522847f, 0.0f, 10.0f);
                instancePath.cubicTo(0.0f, 4.4771523f, 4.4771523f, 0.0f, 10.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(10.0f, 1.2f);
                instancePath.cubicTo(5.139894f, 1.2f, 1.2f, 5.139894f, 1.2f, 10.0f);
                instancePath.cubicTo(1.2f, 14.8601055f, 5.139894f, 18.8f, 10.0f, 18.8f);
                instancePath.cubicTo(14.8601055f, 18.8f, 18.8f, 14.8601055f, 18.8f, 10.0f);
                instancePath.cubicTo(18.8f, 5.139894f, 14.8601055f, 1.2f, 10.0f, 1.2f);
                instancePath.close();
                instancePath.moveTo(10.0f, 9.0f);
                instancePath.cubicTo(10.552284f, 9.0f, 11.0f, 9.447715f, 11.0f, 10.0f);
                instancePath.cubicTo(11.0f, 10.552284f, 10.552284f, 11.0f, 10.0f, 11.0f);
                instancePath.cubicTo(9.447715f, 11.0f, 9.0f, 10.552284f, 9.0f, 10.0f);
                instancePath.cubicTo(9.0f, 9.447715f, 9.447715f, 9.0f, 10.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(14.0f, 9.0f);
                instancePath.cubicTo(14.552284f, 9.0f, 15.0f, 9.447715f, 15.0f, 10.0f);
                instancePath.cubicTo(15.0f, 10.552284f, 14.552284f, 11.0f, 14.0f, 11.0f);
                instancePath.cubicTo(13.447716f, 11.0f, 13.0f, 10.552284f, 13.0f, 10.0f);
                instancePath.cubicTo(13.0f, 9.447715f, 13.447716f, 9.0f, 14.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(6.0f, 9.0f);
                instancePath.cubicTo(6.5522847f, 9.0f, 7.0f, 9.447715f, 7.0f, 10.0f);
                instancePath.cubicTo(7.0f, 10.552284f, 6.5522847f, 11.0f, 6.0f, 11.0f);
                instancePath.cubicTo(5.4477153f, 11.0f, 5.0f, 10.552284f, 5.0f, 10.0f);
                instancePath.cubicTo(5.0f, 9.447715f, 5.4477153f, 9.0f, 6.0f, 9.0f);
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