package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class seller_warning extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePaint3.setColor(-16896);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.7f, 0.0f);
                instancePath.lineTo(25.07f, 0.0f);
                instancePath.cubicTo(36.94f, 0.34f, 47.3f, 10.5f, 48.0f, 22.33f);
                instancePath.lineTo(48.0f, 25.39f);
                instancePath.cubicTo(47.47f, 37.15f, 37.36f, 47.34f, 25.6f, 48.0f);
                instancePath.lineTo(22.61f, 48.0f);
                instancePath.cubicTo(10.79f, 47.47f, 0.57f, 37.25f, 0.0f, 25.44f);
                instancePath.lineTo(0.0f, 22.47f);
                instancePath.cubicTo(0.61f, 10.66f, 10.88f, 0.5f, 22.7f, 0.0f);
                instancePath.lineTo(22.7f, 0.0f);
                instancePath.close();
                instancePath.moveTo(23.290903f, 13.335449f);
                instancePath.cubicTo(20.390598f, 14.737528f, 22.898153f, 19.267319f, 25.697754f, 17.65934f);
                instancePath.cubicTo(28.628271f, 16.237654f, 26.080433f, 11.747081f, 23.290903f, 13.335449f);
                instancePath.lineTo(23.290903f, 13.335449f);
                instancePath.close();
                instancePath.moveTo(20.0f, 20.0f);
                instancePath.lineTo(20.00998f, 20.98f);
                instancePath.cubicTo(20.758484f, 20.99f, 22.25549f, 21.01f, 23.003992f, 21.02f);
                instancePath.lineTo(23.003992f, 34.98f);
                instancePath.cubicTo(22.25549f, 34.99f, 20.758484f, 35.01f, 20.00998f, 35.02f);
                instancePath.lineTo(20.00998f, 36.0f);
                instancePath.lineTo(30.0f, 36.0f);
                instancePath.lineTo(29.99002f, 35.02f);
                instancePath.cubicTo(29.241516f, 35.01f, 27.74451f, 34.99f, 26.996008f, 34.98f);
                instancePath.cubicTo(26.996008f, 29.99f, 27.005987f, 24.99f, 26.996008f, 20.0f);
                instancePath.lineTo(20.0f, 20.0f);
                instancePath.lineTo(20.0f, 20.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 13.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.290903f, 0.33544943f);
                instancePath2.cubicTo(6.080433f, -1.2529188f, 8.628271f, 3.2376533f, 5.697754f, 4.659341f);
                instancePath2.cubicTo(2.8981533f, 6.2673187f, 0.39059758f, 1.7375276f, 3.290903f, 0.33544943f);
                instancePath2.lineTo(3.290903f, 0.33544943f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.0f, 7.0f);
                instancePath3.lineTo(6.996008f, 7.0f);
                instancePath3.cubicTo(7.005988f, 11.99f, 6.996008f, 16.99f, 6.996008f, 21.98f);
                instancePath3.cubicTo(7.744511f, 21.99f, 9.241517f, 22.01f, 9.99002f, 22.02f);
                instancePath3.lineTo(10.0f, 23.0f);
                instancePath3.lineTo(0.00998004f, 23.0f);
                instancePath3.lineTo(0.00998004f, 22.02f);
                instancePath3.cubicTo(0.75848305f, 22.01f, 2.255489f, 21.99f, 3.003992f, 21.98f);
                instancePath3.lineTo(3.003992f, 8.02f);
                instancePath3.cubicTo(2.255489f, 8.01f, 0.75848305f, 7.99f, 0.00998004f, 7.98f);
                instancePath3.lineTo(0.0f, 7.0f);
                instancePath3.lineTo(0.0f, 7.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
