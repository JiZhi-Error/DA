package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_follow extends c {
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 15.0f);
                instancePath.cubicTo(47.59798f, 15.0f, 57.0f, 24.40202f, 57.0f, 36.0f);
                instancePath.cubicTo(57.0f, 47.59798f, 47.59798f, 57.0f, 36.0f, 57.0f);
                instancePath.cubicTo(24.40202f, 57.0f, 15.0f, 47.59798f, 15.0f, 36.0f);
                instancePath.cubicTo(15.0f, 24.40202f, 24.40202f, 15.0f, 36.0f, 15.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-372399);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(36.0f, 6.0f);
                instancePath2.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath2.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath2.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath2.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath2.close();
                instancePath2.moveTo(38.25f, 21.0f);
                instancePath2.lineTo(33.75f, 21.0f);
                instancePath2.lineTo(33.75f, 33.75f);
                instancePath2.lineTo(21.0f, 33.75f);
                instancePath2.lineTo(21.0f, 38.25f);
                instancePath2.lineTo(33.75f, 38.25f);
                instancePath2.lineTo(33.75f, 51.0f);
                instancePath2.lineTo(38.25f, 51.0f);
                instancePath2.lineTo(38.25f, 38.25f);
                instancePath2.lineTo(51.0f, 38.25f);
                instancePath2.lineTo(51.0f, 33.75f);
                instancePath2.lineTo(38.25f, 33.75f);
                instancePath2.lineTo(38.25f, 21.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
