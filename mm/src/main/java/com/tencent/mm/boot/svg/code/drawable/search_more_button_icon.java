package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class search_more_button_icon extends c {
    private final int height = 46;
    private final int width = 46;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                instancePaint3.setColor(-8744017);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(30.152525f, 34.384174f);
                instancePath.cubicTo(27.020466f, 36.658646f, 23.166878f, 38.0f, 19.0f, 38.0f);
                instancePath.cubicTo(8.50659f, 38.0f, 0.0f, 29.49341f, 0.0f, 19.0f);
                instancePath.cubicTo(0.0f, 8.50659f, 8.50659f, 0.0f, 19.0f, 0.0f);
                instancePath.cubicTo(29.49341f, 0.0f, 38.0f, 8.50659f, 38.0f, 19.0f);
                instancePath.cubicTo(38.0f, 23.166878f, 36.658646f, 27.020466f, 34.384174f, 30.152525f);
                instancePath.lineTo(45.66412f, 41.432472f);
                instancePath.lineTo(41.432472f, 45.66412f);
                instancePath.lineTo(30.152525f, 34.384174f);
                instancePath.close();
                instancePath.moveTo(19.0f, 33.0f);
                instancePath.cubicTo(26.731987f, 33.0f, 33.0f, 26.731987f, 33.0f, 19.0f);
                instancePath.cubicTo(33.0f, 11.268014f, 26.731987f, 5.0f, 19.0f, 5.0f);
                instancePath.cubicTo(11.268014f, 5.0f, 5.0f, 11.268014f, 5.0f, 19.0f);
                instancePath.cubicTo(5.0f, 26.731987f, 11.268014f, 33.0f, 19.0f, 33.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
