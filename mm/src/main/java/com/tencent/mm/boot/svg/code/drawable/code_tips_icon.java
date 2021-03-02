package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class code_tips_icon extends c {
    private final int height = 60;
    private final int width = 50;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 50;
            case 1:
                return 60;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-12470760);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(23.0f, 0.0f);
                instancePath.lineTo(27.0f, 0.0f);
                instancePath.cubicTo(32.398567f, 0.61f, 37.560276f, 3.83f, 40.0f, 9.0f);
                instancePath.cubicTo(42.712f, 13.29f, 42.053062f, 18.67f, 42.0f, 24.0f);
                instancePath.cubicTo(45.008316f, 24.14f, 48.552624f, 25.55f, 49.0f, 29.0f);
                instancePath.cubicTo(49.13169f, 37.37f, 48.961964f, 45.75f, 49.0f, 54.0f);
                instancePath.cubicTo(49.031853f, 56.95f, 46.77548f, 59.0f, 44.0f, 60.0f);
                instancePath.lineTo(6.0f, 60.0f);
                instancePath.cubicTo(3.315282f, 59.17f, 0.97903454f, 57.02f, 1.0f, 54.0f);
                instancePath.cubicTo(1.0389383f, 45.76f, 0.8692109f, 37.39f, 1.0f, 29.0f);
                instancePath.cubicTo(1.4382969f, 25.58f, 4.982604f, 24.13f, 8.0f, 24.0f);
                instancePath.cubicTo(7.947841f, 18.69f, 7.3088675f, 13.34f, 10.0f, 9.0f);
                instancePath.cubicTo(12.370737f, 3.92f, 17.44259f, 0.73f, 23.0f, 0.0f);
                instancePath.lineTo(23.0f, 0.0f);
                instancePath.lineTo(23.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(16.0f, 9.0f);
                instancePath.cubicTo(12.136461f, 13.47097f, 13.1924925f, 19.102543f, 13.0f, 24.0f);
                instancePath.lineTo(37.0f, 24.0f);
                instancePath.cubicTo(36.783848f, 19.30367f, 37.839878f, 14.003959f, 35.0f, 10.0f);
                instancePath.cubicTo(30.587132f, 3.5754929f, 20.17625f, 3.3240833f, 16.0f, 9.0f);
                instancePath.lineTo(16.0f, 9.0f);
                instancePath.lineTo(16.0f, 9.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
