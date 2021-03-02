package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class friendactivity_luckymoney_icon extends c {
    private final int height = 36;
    private final int width = 33;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 33;
            case 1:
                return 36;
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
                instancePath.moveTo(30.0f, 12.851442f);
                instancePath.lineTo(30.0f, 33.0f);
                instancePath.lineTo(3.0f, 33.0f);
                instancePath.lineTo(3.0f, 13.013662f);
                instancePath.cubicTo(5.0812554f, 14.928909f, 9.102742f, 16.658638f, 10.767557f, 17.279522f);
                instancePath.cubicTo(10.767557f, 16.999113f, 10.605591f, 15.996458f, 10.828888f, 14.5339985f);
                instancePath.cubicTo(6.8218164f, 12.432947f, 3.0067377f, 8.4492855f, 3.0172813f, 5.8101797f);
                instancePath.cubicTo(3.016516f, 5.641232f, 3.0105f, 5.515129f, 3.0f, 5.427509f);
                instancePath.lineTo(3.0f, 3.0f);
                instancePath.lineTo(30.0f, 3.0f);
                instancePath.lineTo(30.0f, 5.425335f);
                instancePath.cubicTo(29.998358f, 5.479269f, 29.997364f, 5.5399776f, 29.997057f, 5.6077538f);
                instancePath.cubicTo(30.007599f, 8.24686f, 26.007072f, 12.432947f, 22.0f, 14.5339985f);
                instancePath.cubicTo(22.223297f, 15.996458f, 22.06133f, 16.999113f, 22.06133f, 17.279522f);
                instancePath.cubicTo(23.773027f, 16.641155f, 27.97599f, 14.830612f, 30.0f, 12.851442f);
                instancePath.close();
                instancePath.moveTo(0.0f, 3.0074198f);
                instancePath.cubicTo(0.0f, 1.3464677f, 1.3345109f, 0.0f, 3.0013576f, 0.0f);
                instancePath.lineTo(29.998642f, 0.0f);
                instancePath.cubicTo(31.656246f, 0.0f, 33.0f, 1.3455393f, 33.0f, 3.0074198f);
                instancePath.lineTo(33.0f, 32.99258f);
                instancePath.cubicTo(33.0f, 34.653534f, 31.66549f, 36.0f, 29.998642f, 36.0f);
                instancePath.lineTo(3.0013576f, 36.0f);
                instancePath.cubicTo(1.3437536f, 36.0f, 0.0f, 34.65446f, 0.0f, 32.99258f);
                instancePath.lineTo(0.0f, 3.0074198f);
                instancePath.close();
                instancePath.moveTo(16.5f, 21.014084f);
                instancePath.cubicTo(18.985281f, 21.014084f, 21.0f, 18.996214f, 21.0f, 16.507042f);
                instancePath.cubicTo(21.0f, 14.017872f, 18.985281f, 12.0f, 16.5f, 12.0f);
                instancePath.cubicTo(14.014719f, 12.0f, 12.0f, 14.017872f, 12.0f, 16.507042f);
                instancePath.cubicTo(12.0f, 18.996214f, 14.014719f, 21.014084f, 16.5f, 21.014084f);
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
