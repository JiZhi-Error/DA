package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class download_image_icon extends c {
    private final int height = 480;
    private final int width = 480;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                instancePaint3.setColor(-2565928);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(480.0f, 0.0f);
                instancePath.lineTo(480.0f, 480.0f);
                instancePath.lineTo(0.0f, 480.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(377.6f, 272.91428f);
                instancePath2.lineTo(377.6f, 137.6f);
                instancePath2.lineTo(102.4f, 137.6f);
                instancePath2.lineTo(102.4f, 269.6258f);
                instancePath2.lineTo(188.8f, 188.8f);
                instancePath2.lineTo(288.0f, 278.4f);
                instancePath2.lineTo(278.4f, 252.8f);
                instancePath2.lineTo(320.0f, 220.8f);
                instancePath2.lineTo(377.6f, 272.91428f);
                instancePath2.close();
                instancePath2.moveTo(86.4f, 124.594025f);
                instancePath2.cubicTo(86.4f, 122.940475f, 87.736046f, 121.6f, 89.391014f, 121.6f);
                instancePath2.lineTo(390.60898f, 121.6f);
                instancePath2.cubicTo(392.26086f, 121.6f, 393.6f, 122.946335f, 393.6f, 124.594025f);
                instancePath2.lineTo(393.6f, 355.40598f);
                instancePath2.cubicTo(393.6f, 357.05954f, 392.26395f, 358.4f, 390.60898f, 358.4f);
                instancePath2.lineTo(89.391014f, 358.4f);
                instancePath2.cubicTo(87.73912f, 358.4f, 86.4f, 357.05365f, 86.4f, 355.40598f);
                instancePath2.lineTo(86.4f, 124.594025f);
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
