package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_filled_delete_sub_video extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                instancePaint3.setColor(14211288);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(63.0f, 15.0f);
                instancePath2.cubicTo(64.65685f, 15.0f, 66.0f, 16.343145f, 66.0f, 18.0f);
                instancePath2.lineTo(66.0f, 54.0f);
                instancePath2.cubicTo(66.0f, 55.656853f, 64.65685f, 57.0f, 63.0f, 57.0f);
                instancePath2.lineTo(23.57734f, 57.0f);
                instancePath2.cubicTo(22.138334f, 57.0f, 20.786116f, 56.3118f, 19.939213f, 55.1484f);
                instancePath2.lineTo(7.285281f, 37.765602f);
                instancePath2.cubicTo(6.5191727f, 36.713192f, 6.5191727f, 35.286808f, 7.285281f, 34.234398f);
                instancePath2.lineTo(19.939213f, 16.851599f);
                instancePath2.cubicTo(20.786116f, 15.688203f, 22.138334f, 15.0f, 23.57734f, 15.0f);
                instancePath2.lineTo(63.0f, 15.0f);
                instancePath2.close();
                instancePath2.moveTo(33.78573f, 25.477728f);
                instancePath2.lineTo(30.601854f, 28.661602f);
                instancePath2.lineTo(37.933975f, 35.995728f);
                instancePath2.lineTo(30.6f, 43.329266f);
                instancePath2.lineTo(33.787582f, 46.51685f);
                instancePath2.lineTo(41.119976f, 39.18173f);
                instancePath2.lineTo(48.451538f, 46.518703f);
                instancePath2.lineTo(51.639122f, 43.331123f);
                instancePath2.lineTo(44.305977f, 35.995728f);
                instancePath2.lineTo(51.640976f, 28.663456f);
                instancePath2.lineTo(48.457104f, 25.479584f);
                instancePath2.lineTo(41.122974f, 32.81273f);
                instancePath2.lineTo(33.78573f, 25.477728f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
