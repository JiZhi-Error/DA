package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class friendactivity_comment_icon_golden_normal extends c {
    private final int height = 46;
    private final int width = 66;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 66;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-4547478);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 31.470589f);
                instancePath.lineTo(12.0f, 46.0f);
                instancePath.lineTo(66.0f, 46.0f);
                instancePath.lineTo(66.0f, 0.0f);
                instancePath.lineTo(12.0f, 0.0f);
                instancePath.lineTo(12.0f, 14.529412f);
                instancePath.lineTo(0.0f, 23.0f);
                instancePath.lineTo(12.0f, 31.470589f);
                instancePath.close();
                instancePath.moveTo(27.0f, 29.0f);
                instancePath.cubicTo(30.31371f, 29.0f, 33.0f, 26.31371f, 33.0f, 23.0f);
                instancePath.cubicTo(33.0f, 19.68629f, 30.31371f, 17.0f, 27.0f, 17.0f);
                instancePath.cubicTo(23.68629f, 17.0f, 21.0f, 19.68629f, 21.0f, 23.0f);
                instancePath.cubicTo(21.0f, 26.31371f, 23.68629f, 29.0f, 27.0f, 29.0f);
                instancePath.close();
                instancePath.moveTo(51.0f, 29.0f);
                instancePath.cubicTo(54.31371f, 29.0f, 57.0f, 26.31371f, 57.0f, 23.0f);
                instancePath.cubicTo(57.0f, 19.68629f, 54.31371f, 17.0f, 51.0f, 17.0f);
                instancePath.cubicTo(47.68629f, 17.0f, 45.0f, 19.68629f, 45.0f, 23.0f);
                instancePath.cubicTo(45.0f, 26.31371f, 47.68629f, 29.0f, 51.0f, 29.0f);
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
