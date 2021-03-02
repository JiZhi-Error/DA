package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class biz_reccard_unlink_icon extends c {
    private final int height = 14;
    private final int width = 20;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 20;
            case 1:
                return 14;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-2631721);
                instancePaint4.setStrokeWidth(0.5f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.25f, 7.0f);
                instancePath.cubicTo(0.25f, 3.2720778f, 3.2720778f, 0.25f, 7.0f, 0.25f);
                instancePath.lineTo(13.0f, 0.25f);
                instancePath.cubicTo(16.727922f, 0.25f, 19.75f, 3.2720778f, 19.75f, 7.0f);
                instancePath.lineTo(19.75f, 7.0f);
                instancePath.cubicTo(19.75f, 10.727922f, 16.727922f, 13.75f, 13.0f, 13.75f);
                instancePath.lineTo(7.0f, 13.75f);
                instancePath.cubicTo(3.2720778f, 13.75f, 0.25f, 10.727922f, 0.25f, 7.0f);
                instancePath.lineTo(0.25f, 7.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-2631721);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.353554f, 4.0202203f);
                instancePath2.lineTo(13.02022f, 4.686887f);
                instancePath2.lineTo(10.686f, 7.02f);
                instancePath2.lineTo(13.02022f, 9.353554f);
                instancePath2.lineTo(12.353554f, 10.02022f);
                instancePath2.lineTo(10.02f, 7.686f);
                instancePath2.lineTo(7.686887f, 10.02022f);
                instancePath2.lineTo(7.0202203f, 9.353554f);
                instancePath2.lineTo(9.353f, 7.02f);
                instancePath2.lineTo(7.0202203f, 4.686887f);
                instancePath2.lineTo(7.686887f, 4.0202203f);
                instancePath2.lineTo(10.02f, 6.353f);
                instancePath2.lineTo(12.353554f, 4.0202203f);
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
