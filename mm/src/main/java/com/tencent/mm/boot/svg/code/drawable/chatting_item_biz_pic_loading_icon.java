package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_biz_pic_loading_icon extends c {
    private final int height = 42;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-5066062);
                instancePaint4.setStrokeWidth(3.1751997f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.5875999f, 2.1751997f);
                instancePath.cubicTo(1.5875999f, 1.2983925f, 2.2983925f, 0.5875999f, 3.1751997f, 0.5875999f);
                instancePath.lineTo(38.8248f, 0.5875999f);
                instancePath.cubicTo(39.701607f, 0.5875999f, 40.4124f, 1.2983925f, 40.4124f, 2.1751997f);
                instancePath.lineTo(40.4124f, 27.8248f);
                instancePath.cubicTo(40.4124f, 28.701607f, 39.701607f, 29.412401f, 38.8248f, 29.412401f);
                instancePath.lineTo(3.1751997f, 29.412401f);
                instancePath.cubicTo(2.2983925f, 29.412401f, 1.5875999f, 28.701607f, 1.5875999f, 27.8248f);
                instancePath.lineTo(1.5875999f, 2.1751997f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-5066062);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(31.32f, 14.56f);
                instancePath2.lineTo(26.1f, 19.735f);
                instancePath2.lineTo(28.188f, 23.875f);
                instancePath2.lineTo(13.572f, 10.42f);
                instancePath2.lineTo(0.0f, 22.84f);
                instancePath2.lineTo(0.0f, 29.05f);
                instancePath2.lineTo(40.716f, 29.05f);
                instancePath2.lineTo(40.716f, 22.84f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
